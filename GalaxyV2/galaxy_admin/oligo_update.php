<?php
	include "inc/common.php";
	include "inc/access.php";
	
	db_connection();
	
	$oligo_id = $_REQUEST[oligo_id];
	if($oligo_id!= ""){
		$q = "update oligo_table set oligo_code='$_REQUEST[oligo_code]', oligo_structure='$_REQUEST[oligo_structure]', oligo_ods= '$_REQUEST[oligo_ods]',"
		." oligo_amide = '$_REQUEST[oligo_amide]', oligo_mw = '$_REQUEST[oligo_mw]', oligo_pref = '$_REQUEST[oligo_pref]', oligo_source = '$_REQUEST[oligo_source]',"
		." oligo_info = '$_REQUEST[oligo_info]', enz1 = '$_REQUEST[enz1]', enz2 = '$_REQUEST[enz2]', enz3 = '$_REQUEST[enz3]', enz4 = '$_REQUEST[enz4]',"
		." enz5 = '$_REQUEST[enz5]', enz6 = '$_REQUEST[enz6]', glycan = '$_REQUEST[glycan]', stat = '$_REQUEST[stat]'"
		." where oligo_id = $oligo_id;";
		// echo $q . ":" .$_SESSION[return_q]; exit;
		if(!$result = mysql_query($q)){dber('アップデートに失敗しました。(oligo_table)'); exit;}
		header("Location: oligo_master.htm?$_SESSION[return_q]"); exit;
	}else{
		header("Location: oligo_master.htm?$_SESSION[return_q]"); exit;
	}
?>
