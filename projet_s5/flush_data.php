<?php

/**
 * @Author : 
 Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
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