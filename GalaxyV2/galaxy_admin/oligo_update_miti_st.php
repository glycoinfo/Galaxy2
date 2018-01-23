<?php
	include "inc/common.php";
	include "inc/access.php";
	
	db_connection();
	
	$oligo_id = $_REQUEST[oligo_id];
	$stat = $_REQUEST[stat];
	if($stat == 0){
		$stat = 1;
	}else if($stat == 1){
		$stat = 0;
	}else{
		$stat = 0;
	}
	if($oligo_id!= ""){
		$q = "update oligo_table_miti set stat = '$stat' where oligo_id = $oligo_id;";
		// echo $q . ":" .$_SESSION[return_q]; exit;
		if(!$result = mysql_query($q)){dber('アップデートに失敗しました。(oligo_table_miti)'); exit;}
		header("Location: oligo_master_miti.htm?$_SESSION[return_q]"); exit;
	}else{
		header("Location: oligo_master_miti.htm?$_SESSION[return_q]"); exit;
	}
?>