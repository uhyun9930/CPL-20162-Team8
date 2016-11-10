<?php
if ($_POST['_live_dbhost'])
{
	header("Content-type:text/html;charset=utf-8");
	session_save_path('./_tmp/session');
	session_start();

	$_SESSION['_live_dbhost'] = $_POST['_live_dbhost'];
	$_SESSION['_live_dbname'] = $_POST['_live_dbname'];
	$_SESSION['_live_dbuser'] = $_POST['_live_dbuser'];
	$_SESSION['_live_dbpass'] = $_POST['_live_dbpass'];
	$_SESSION['_live_dbport'] = $_POST['_live_dbport'];
	$_SESSION['_live_dbhead'] = $_POST['_live_dbhead'];
	$_SESSION['_live_name'] = $_POST['_live_name'];
	$_SESSION['_live_id'] = $_POST['_live_id'];
	$_SESSION['_live_pw'] = $_POST['_live_pw'];
	$_SESSION['_live_email'] = $_POST['_live_email'];
	$_SESSION['_live_sitename'] = $_POST['_live_sitename'];
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html id="kimsQStart" lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>kimsQ-Rb Installer</title>
<script type="text/javascript">
//<![CDATA[
location.href = './install.php';
//]]>
</script>

</head>
<body>
</body>
</html>

