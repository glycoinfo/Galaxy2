<?php
	include "inc/common.php";
	include "inc/access.php";
	
	session_unset();
	session_destroy();
	sleep(1);
	header("Location: index.htm?login=logout"); exit;
?>

<HTML>
<HEAD>
<TITLE>Logout ...</TITLE>
</HEAD>
<BODY>
	Logout !!
</BODY>
</HTML>