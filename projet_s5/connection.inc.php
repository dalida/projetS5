<?php

/**
 * @Author : Romy Ardianto (romy_thedoctor46@yahoo.com)
 *
 */
 
// be sure that this file not accessed directly
if (basename($_SERVER['PHP_SELF']) == basename(__FILE__)) {
    die();
}

// be sure that magic quote is off
@ini_set('magic_quotes_gpc', false);
@ini_set('magic_quotes_runtime', false);
@ini_set('magic_quotes_sybase', false);

// project_s5 base dir
define('PROJECT_S5_BASE_DIR', realpath(dirname(__FILE__)).DIRECTORY_SEPARATOR);

// class DBConnection
class DBConnection {
	
	var $HOST = 'localhost';
	var $USER = 'user_s5';
	var $PASSWORD = 's5';
	var $DB = 's5';
	var $conn;
	var $openDB;
	var $query;
	var $objResult;
	
	// MySQL open connection
	function DBConnection(){
		$this->conn = @mysql_connect($this->HOST,$this->USER,$this->PASSWORD);
        if($this->conn) {
        	mysql_set_charset('utf8', $this->conn);
           	$this->openDB = @mysql_select_db($this->DB,$this->conn);
			if($this->openDB) {
				return $this->openDB;
            } else {
               	die("DB Error");
            }
       	} else {
        	die("Connection Error");
       	}
	}

	// MySQL query db
	function query($sql){
        $this->query = @mysql_db_query($this->DB,$sql);
        if(!$this->openDB)
			die("Query Error");
	}

	// MySQL query get data
	function getData() {
		$this->objResult = @mysql_fetch_array($this->query);
        if(!$this->objResult)
			die("Get Data Error");
    }

	// MySQL query get num rows
	function getNumRows(){
        return @mysql_num_rows($this->query);
	}	

	// MySQL close connection
	function closeConnection() { 
        @mysql_close($this->openDB);
    }
}

// create new object to open connection
$data = new DBConnection();

?>
