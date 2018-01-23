<?php
	include "inc/common.php";
	include "inc/access.php";
	
	db_connection();
	
	$user_number = $_REQUEST[user_number];
	if($user_number!= ""){
		$q = "update regist_table set galaxy_id='$_REQUEST[galaxy_id]', insert_date='$_REQUEST[insert_date]', user_first= '$_REQUEST[user_first]',"
		." user_last = '$_REQUEST[user_last]', user_country = '$_REQUEST[user_country]', user_zip = '$_REQUEST[user_zip]', user_group = '$_REQUEST[user_group]',"
		." user_sex = '$_REQUEST[user_sex]', user_mail = '$_REQUEST[user_mail]', user_mode = '$_REQUEST[user_mode]', user_pass = '$_REQUEST[user_pass]',"
		." galaxy_admin = '$_REQUEST[galaxy_admin]', user_graph = '$_REQUEST[user_graph]', user_mark1_c = '$_REQUEST[user_mark1_c]', user_mark1 = '$_REQUEST[user_mark1]',"
		." user_mark2_c = '$_REQUEST[user_mark2_c]', user_mark2 = '$_REQUEST[user_mark2]', user_mark3_c = '$_REQUEST[user_mark3_c]', user_mark3 = '$_REQUEST[user_mark3]',"
		." user_bg_c = '$_REQUEST[user_bg_c]', mark1 = '$_REQUEST[mark1]', mark2 = '$_REQUEST[mark2]', mark3 = '$_REQUEST[mark3]',stat = '$_REQUEST[stat]'"
		." where user_number = $user_number;";
		// echo $q . ":" .$_SESSION[return_q]; exit;
		if(!$result = mysql_query($q)){dber('アップデートに失敗しました。(regist_table)'); exit;}
		header("Location: usermaster.htm?$_SESSION[return_q]"); exit;
	}else{
		header("Location: usermaster.htm?$_SESSION[return_q]"); exit;
	}
?>