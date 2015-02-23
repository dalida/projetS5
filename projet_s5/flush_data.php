<?php

/**
 * @Author : Romy Ardianto (romy_thedoctor46@yahoo.com)
 *
 */

require_once 'connection.inc.php';

// Empty book temporary table from database

$sql_empty_table = "truncate table book_tmp";
$data->query($sql_empty_table);

// Delete book temporary file (csv) from directory

$file = "csv/book_tmp.csv";

    if (file_exists($file)){
        unlink($file);
    }

?>