<?
	session_start();
	$uid = $_SESSION[uid];
	$u_name = $_SESSION[group];
	$login_id = $_SESSION[login_id];
	
	$phpsid = session_id();
	if($uid == ""){
		header("Location: index.htm?login=logout"); exit;
	}
?>