<?php
	// WINDOWS XP ・ LINUX の設定ファイル
	// $wl = 1 WINDOWS
	// $wl = 0 LINUX
	$wl = 0;
	define("OS_SET",$wl);
	
	// GLOBAL
	ini_set("session.name","SID");
	ini_set("display_errors",0);
	// session_cache_limiter("private");
	session_cache_limiter("nocache");
	define("TITLE","Galaxy Admin");
	$title = "Galaxy Admin";
	// WINDOWS or LINUX
	
	if($wl == 1){
		define("DB_HOST","localhost:3306");
		define("DB_USER","");
		define("DB_PASS","");
		define("DB_NAME","galaxy");
		
		$filedir1 = "D://tmp/security/";
		$filedir2 = "D://tmp/ocr/";
		$filedir3 = "D://tmp/kensa/";
	}else{
		ini_set("session.use_cookies",1);
		// ini_set("mbstring.internal_encoding","EUC-JP");
		define("DB_HOST","localhost:3306");
		define("DB_USER","");
		define("DB_PASS","");
		define("DB_NAME","galaxy");
		define("RETURN_PATH","-fsupport@aaaa.jp\r\n");
	}
	
	// ## ファイルアップロードディレクトリ ##########################
	if($wl == 1){
		$up_dir = "D://tmp/kensa/abc/";
	}else{
		$up_dir="../../upload/abc/";
	}
	
	
	// ## メール送信先定義 ##########################################
	
	define("MAIL_TO","support@aaaa.jp");
	
	// DB_CONNECTION SET
	
	function fin_exit(){
		print "<a href=\"index.html\">トップに戻る</a><br>\n";
		exit;
	}
	
	function db_connection(){
		if(! mysql_connect(DB_HOST,DB_USER,DB_PASS)){ error("データベース接続エラー(ホスト)");}
		if(! mysql_select_db(DB_NAME)){ error("データベース接続エラー(データベース)");}
		// mysql_set_charset('eucjp'); //utf8
		// mysql_set_charset('utf8');
		mysql_query('SET NAMES utf8');
	}
	
	function dber($msg){
		error($msg."\n<!--\n".mysql_error()."\n-->\n");
	}
	
	function error($msg,$opt=""){
		$text = '
		<table width="760" border="0" cellspacing="0" cellpadding="20" bgcolor="#FFFFFF">
		<tr valign="top"><td align="center">
		<u><font color=red>エラー</font></u><p>
		<table><tr><td>
		'.$msg.'
		</td></tr></table>';
		print($text);
	}
	
	function calc_age($kensaday,$barth)
	{
		list($ty, $tm, $td) = explode('-', $kensaday);
		list($by, $bm, $bd) = explode('-', $barth);
		$age = $ty - $by;
		if($tm * 100 + $td < $bm * 100 + $bd) $age--;
		return $age;
	}
	
	function sendmail_st($address,$subject,$message,$header){
		$command = RETURN_PATH;
		if(OS_SET == 1){
			$flag = sendmail_st_win($address,$subject,$message,$header,$command);
			return $flag;
		}else{
			$flag = sendmail_st_lin($address,$subject,$message,$header,$command);
			return $flag;
		}
	}

?>