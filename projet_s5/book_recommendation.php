<?php

/**
 * @Author : 
 Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 *
 */

require_once 'connection.inc.php';
require_once 'flush_data.php';

?>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="src/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="src/filter.css">
<script src="src/jquery-1.11.2.min.js"></script>
<script src="src/jquery.mobile-1.4.5.min.js"></script>
<script src="src/filter.js"></script>
<script type="text/javascript">
function validateForm() {
    var genre_1 = document.forms["bookForm"]["genre_1"].value;
    var genre_2 = document.forms["bookForm"]["genre_2"].value;
    var genre_3 = document.forms["bookForm"]["genre_3"].value;

    if (genre_1 == genre_2 || genre_1 == genre_3 || genre_2 == genre_3) {
        alert("[Error] The value of each genre must be different.");
        return false;
    }
}
</script>
</head>
<body>

<div data-role="page">
  <div data-role="header">
  <h1>Book Recommender System</h1>
  </div>

  <div data-role="main" class="ui-content">

    <p><strong>Please select preferred genres (Genre 1 = most prefered)</strong></p>

    <form id="bookForm" method="post" action="process_book_recommendation.php" onsubmit="return validateForm()">
      <fieldset class="ui-field-contain">

      <label for="day">Genre 1</label>
      
      <select name="genre_1" id="genre_1" data-native-menu="false">
      
      <?php
    
      $sql="select b.IdGenre as genreId,b.genre as genre from book as a 
            inner join genres as b 
            where a.genre=b.IdGenre
            group by a.genre
            order by b.IdGenre";
            
      $data->query($sql);
      
      $data_2 = new DBConnection();

      for ($i=0;$i<$data->GetNumRows();$i++) {
          $data->getData();
          $genreId = $data->objResult["genreId"];
          $genre = $data->objResult["genre"];

          $sql_number_of_book="select count(*) as numRows from book where genre='".$genreId."'";
          $data_2->query($sql_number_of_book);
          $data_2->getData();

          echo "<option value=\"$genreId\">".$genreId." - ".$genre." -- ".$data_2->objResult["numRows"]." item(s)</option>";
      }

      ?>
      
      </select>

      <br><br><br>

      <label for="day">Genre 2</label>

      <select name="genre_2" id="genre_2" data-native-menu="false">
      
      <?php
    
      $sql="SELECT b.IdGenre as genreId,b.genre as genre FROM `book` as a 
          INNER JOIN genres as b 
          where a.genre=b.IdGenre
          group by a.genre
          order by b.IdGenre";
      $data->query($sql);

      for ($i=0;$i<$data->GetNumRows();$i++) {
          $data->getData();
          $genreId = $data->objResult["genreId"];
          $genre = $data->objResult["genre"];
          
          $sql_number_of_book="select count(*) as numRows from book where genre='".$genreId."'";
          $data_2->query($sql_number_of_book);
          $data_2->getData();

          echo "<option value=\"$genreId\">".$genreId." - ".$genre." -- ".$data_2->objResult["numRows"]." item(s)</option>";
      }

      ?>
      
      </select>

      <br><br><br>
      
      <label for="day">Genre 3</label>

      <select name="genre_3" id="genre_3" data-native-menu="false">
      
      <?php
    
      $sql="SELECT b.IdGenre as genreId,b.genre as genre FROM `book` as a 
          INNER JOIN genres as b 
          where a.genre=b.IdGenre
          group by a.genre
          order by b.IdGenre";
      $data->query($sql);

      for ($i=0;$i<$data->GetNumRows();$i++) {
          $data->getData();
          $genreId = $data->objResult["genreId"];
          $genre = $data->objResult["genre"];
          
          $sql_number_of_book="select count(*) as numRows from book where genre='".$genreId."'";
          $data_2->query($sql_number_of_book);
          $data_2->getData();

          echo "<option value=\"$genreId\">".$genreId." - ".$genre." -- ".$data_2->objResult["numRows"]." item(s)</option>";
      }

      $data->closeConnection();
      $data_2->closeConnection();
      ?>
      
      </select>
    
      </fieldset>
      <br><br>
      <input type="submit" data-inline="true" value="Submit" data-icon="check">
    </form>
  </div>
  
</div>

</body>
</html>
