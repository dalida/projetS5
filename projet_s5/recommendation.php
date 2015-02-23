<?php

/**
 * @Author : Romy Ardianto (romy_thedoctor46@yahoo.com)
 *
 */

require_once 'connection.inc.php';

$path_brew = "../brew_local";

$path_csv_file = PROJECT_S5_BASE_DIR."csv/book_tmp.csv";

$terminated_string = ";";
$enclosed_string = '"';
$escaped_string = '"';
$lines_terminated_string = "\r\n";

$submit = (isset($_POST["submit"]) && !empty($_POST["submit"])) ? $_POST["submit"] : "";
$year = (isset($_POST["year"]) && !empty($_POST["year"])) ? $_POST["year"] : "";
$number_of_pages = (isset($_POST["number_of_pages"]) && !empty($_POST["number_of_pages"])) ? $_POST["number_of_pages"] : "";

if($submit != "" && $year != "" && $number_of_pages != "") {

  $sql="select * from book_tmp";

  $data->query($sql);

  $data_2 = new DBConnection();

  for ($i=0;$i<$data->GetNumRows();$i++) {
    $data->getData();
    $idBook = $data->objResult["IdBook"];

    $sql_update = "update book_tmp set category='".$_POST["".$idBook.""]."' WHERE idBook='".$idBook."'";
    
    $data_2->query($sql_update);
  }

  $sql="(SELECT 'title','year','pageNumber','genreNumeric','category')
      UNION 
      (SELECT title,year,pageNumber,genreNumeric,category
      FROM book_tmp
      INTO OUTFILE '".$path_csv_file."'
      CHARACTER SET utf8
      FIELDS ENCLOSED BY '".$enclosed_string."' TERMINATED BY '".$terminated_string."' ESCAPED BY '".$escaped_string."'
      LINES TERMINATED BY '".$lines_terminated_string."')";

  $data->query($sql);

  header("Location: $path_brew/utadis_book_recommendation.rhtml?year=$year&number_of_pages=$number_of_pages");
  exit;

} else {
  header("Location: book_recommendation.php");
  exit;
}

?>
