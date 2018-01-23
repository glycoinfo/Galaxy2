<?php
	include "inc/common.php";
	include "inc/access.php";
	
	db_connection();
	
	$user_number = $_REQUEST[user_number];
	$stat = $_REQUEST[stat];
	if($stat == 0){
		$stat = 1;
	}else if($stat == 1){
		$stat = 0;
	}
	if($user_number!= ""){
		$q = "update regist_table set stat = '$stat' where user_number = $user_number;";
		// echo $q . ":" .$_SESSION[return_q]; exit;
		if(!$result = mysql_query($q)){dber('アップデートに失敗しました。(regist_table)'); exit;}
		header("Location: usermaster.htm?$_SESSION[return_q]"); exit;
	}else{
		header("Location: usermaster.htm?$_SESSION[return_q]"); exit;
	}
?>
