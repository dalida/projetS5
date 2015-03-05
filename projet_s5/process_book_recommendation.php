<?php

/**
 * @Author : 
 Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 *
 */

require_once 'connection.inc.php';

$genre_1 = (isset($_POST["genre_1"]) && !empty($_POST["genre_1"])) ? $_POST["genre_1"] : "";
$genre_2 = (isset($_POST["genre_2"]) && !empty($_POST["genre_2"])) ? $_POST["genre_2"] : "";
$genre_3 = (isset($_POST["genre_3"]) && !empty($_POST["genre_3"])) ? $_POST["genre_3"] : "";

if($genre_1 != "" && $genre_2 != "" && $genre_3 != "" ) {

?>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="src/jquery.mobile-1.4.5.min.css">
<script src="src/jquery-1.11.2.min.js"></script>
<script src="src/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>

<div data-role="page" id="pageone">
  <div data-role="header">
    <h1>Preference Selection</h1>
  </div>
  
	<div data-role="main" class="ui-content">

  	<form id="bookFormProcess" method="post" action="recommendation.php">
    <fieldset class="ui-field-contain">

  	<p><strong>Please rate preferences of at least one book per category - Good, Medium, Bad (must have a minimum of two different preference categories)</strong></p>

  	<?php

    $sql="(select a.*,b.genre as genre_name from book a inner join genres b on a.genre=b.IdGenre where a.genre='".$genre_1."' order by rand() limit 4)
          union
          (select a.*,b.genre as genre_name from book a inner join genres b on a.genre=b.IdGenre where a.genre='".$genre_2."' order by rand() limit 4)
          union
          (select a.*,b.genre as genre_name from book a inner join genres b on a.genre=b.IdGenre where a.genre='".$genre_3."' order by rand() limit 4)";

      $data->query($sql);
      
  	  $data_2 = new DBConnection();
      
      echo "
      <table data-role=\"table\" class=\"ui-responsive table-stroke\" id=\"myTable\">
        	<thead>
          <tr>
            	<th>No.</th>
            	<th>Book Title</th>
		<th>Author</th>
            	<th>Genre</th>
            	<th>Year</th>
                <th>No. Pgs</th>
            	<th>Preference Category</th>
          </tr>
      	</thead>
      	<tbody>";

    	for ($i=0;$i<$data->GetNumRows();$i++) {
      	$data->getData();
      	$idBook = $data->objResult["IdBook"];
      	$title = $data->objResult["title"];
      	$language = $data->objResult["language"];
      	$year = $data->objResult["year"];
      	$editor = $data->objResult["title"];
      	$pageNumber = $data->objResult["pageNumber"];
      	$author = $data->objResult["author"];
      	$genre = $data->objResult["genre"];
        $genreName = $data->objResult["genre_name"];
        	
    		$genre_1_checked = "";
    		$genre_2_checked = "";
    		$genre_3_checked = "";

      	if($genre_1 == $genre) {
      		$genreNumeric = 1;
      		$genre_1_checked = "checked=\"checked\"";
      	}
      	if($genre_2 == $genre) {
      		$genreNumeric = 2;
      		$genre_2_checked = "checked=\"checked\"";
      	}
      	if($genre_3 == $genre) {
      		$genreNumeric = 3;
      		$genre_3_checked = "checked=\"checked\"";
      	}

      	$sql_insert = "insert into book_tmp (idBook, title, language, year, editor, 
      					pageNumber, author, genre, genreNumeric)
						    values ('".mysql_real_escape_string($idBook)."', '".mysql_real_escape_string($title)."', '".mysql_real_escape_string($language)."', 
                '".mysql_real_escape_string($year)."', '".mysql_real_escape_string($editor)."', '".mysql_real_escape_string($pageNumber)."', 
                '".mysql_real_escape_string($author)."', '".mysql_real_escape_string($genre)."', '".mysql_real_escape_string($genreNumeric)."')";
		
		    $data_2->query($sql_insert);

      ?>

      <tr>
        <td><?php echo ($i+1); ?></td>
        <td class="bookListCol1"><?php echo $title; ?></td>
        <td class="bookListCol2"><?php echo $author; ?></td>
        <td class="bookListCol2"><?php echo $genre." - ".$genreName; ?></td>
        <td><?php echo $year; ?></td>
        <td><?php echo $pageNumber; ?></td>
        <td>
          <fieldset data-role="controlgroup" data-mini="true" data-type="horizontal">
            <label for="good_<?php echo $idBook; ?>">Good</label>
            <input type="radio" name="<?php echo $idBook; ?>" id="good_<?php echo $idBook; ?>" value="good" <?php echo $genre_1_checked; ?>>
            <label for="medium_<?php echo $idBook; ?>">Medium</label>
            <input type="radio" name="<?php echo $idBook; ?>" id="medium_<?php echo $idBook; ?>" value="medium" <?php echo $genre_2_checked; ?>>
            <label for="bad_<?php echo $idBook; ?>">Bad</label>
            <input type="radio" name="<?php echo $idBook; ?>" id="bad_<?php echo $idBook; ?>" value="bad" <?php echo $genre_3_checked; ?>>
          </fieldset>
        </td>
      </tr>

      <?php

    	}

      $data->closeConnection();

      echo "
      	</tbody>
      </table>";

  	  ?>

      <br><br>

      <p><strong>Please select criteria preferences</strong></p>

      <fieldset data-role="controlgroup" data-mini="true" data-type="horizontal">
          <legend>Year:</legend>
          <label for="year_min">Older</label>
          <input type="radio" name="year" id="year_min" value="min" checked="checked">
          <label for="year_max">Newer</label>
          <input type="radio" name="year" id="year_max" value="max"> 
      </fieldset>
      <br>
      <fieldset data-role="controlgroup" data-mini="true" data-type="horizontal">
          <legend>Number of pages:</legend>
          <label for="number_of_pages_min">Less</label>
          <input type="radio" name="number_of_pages" id="number_of_pages_min" value="min" checked="checked">
          <label for="number_of_pages_max">More</label>
          <input type="radio" name="number_of_pages" id="number_of_pages_max" value="max"> 
      </fieldset>

    </fieldset>
    <br><br>
    <a href="book_recommendation.php" class="ui-btn ui-btn-inline ui-shadow ui-corner-all" rel="external">Go Back</a>
    <input type="submit" name = "submit" data-inline="true" value="Submit" data-icon="check">
    </form>

	</div>
</div>

</body>
</html>

<?php

} else {
	header("Location: book_recommendation.php");
  exit;
}

?>
