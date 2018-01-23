<?php
	include "inc/common.php";
	// include "inc/access.php";
	session_start();
	
	$pass = $_POST[pass];
	$userid = $_POST[userid];
	if($userid != "" && $pass != ""){
		if($userid == "sakaguchi" && $pass == "gfhjkd"){
			$_SESSION[adminid] = $userid;
			$_SESSION[adgroup] = "Administrator";
			$_SESSION[uid] = $userid;
			$_SESSION[group] = "Administrator";
			
			header("Location: main.htm"); exit;
		}
		if($userid == "ginga" && $pass == "ginga"){
			$_SESSION[adminid] = $userid;
			$_SESSION[adgroup] = "gingakobo";
			$_SESSION[uid] = $userid;
			$_SESSION[group] = "Administrator";
			
			header("Location: main.htm"); exit;
		}
		if($userid == "galaxy" && $pass == "system"){
			$_SESSION[adminid] = $userid;
			$_SESSION[adgroup] = "Administrator";
			$_SESSION[uid] = $userid;
			$_SESSION[group] = "Administrator";
			
			header("Location: main.htm"); exit;
		}
		header("Location: index.htm?login=field"); exit;
	}else{
		header("Location: index.htm?login=field"); exit;
	}
?>