<?php
if (is_dir('./_core'))
{
	echo 'Already Installed !';
	exit;
}

$_perm = true;
$InstallTmpDir = './_installer';
$zipFile = './kimsq.zip';
$extPath = '.';
$installFoler = str_replace('/install.php','',$_SERVER['SCRIPT_NAME']);

require $InstallTmpDir.'/install.func.php';

if ($_POST['permcheck']=='Y')
{

	$FTP_CONNECT = ftp_connect($_POST['host'],$_POST['port']); 
	$FTP_CRESULT = ftp_login($FTP_CONNECT,$_POST['id'],$_POST['pw']); 
	if (!$FTP_CONNECT) getLink('./','FTP에 접속할 수 없습니다.','');
	if (!$FTP_CRESULT) getLink('./','아이디나 패스워드가 일치하지 않습니다.','');

	$ftp_pwd = explode('/',$_SERVER['DOCUMENT_ROOT']);
	$ins_pwd = '/'.$ftp_pwd[count($ftp_pwd)-1].'/';
	$ins_pwd = $ins_pwd == '//' ? '/' : $ins_pwd;
	$ins_pwd = $_POST['ftp_folder'] != '/' ? $ins_pwd.substr($_POST['ftp_folder'],1,strlen($_POST['ftp_folder'])).'/' : '';

	ftp_pasv($FTP_CONNECT, true);
	ftp_chdir($FTP_CONNECT,$ins_pwd);
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd);
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'index.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'install.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'kimsq.zip');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/ArchiveExtractor.class.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/install.css');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/install.func.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/install.js');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/pclerror.func.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/pcltar.func.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/pcltrace.func.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_installer/pclzip.class.php');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_tmp');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_tmp/session');
	ftp_chmod($FTP_CONNECT,0707,$ins_pwd.'_tmp/session/tmp.txt');
	ftp_close($FTP_CONNECT);

	getLink('./','퍼미션 변경여부를 확인 후 설치를 진행하세요.','');
}
if ($_GET['install']=='Y')
{
	unlink('./index.php');
	require $InstallTmpDir.'/ArchiveExtractor.class.php';

	$extractor = new ArchiveExtractor();
	$extractor -> extractArchive($zipFile,$extPath);
	DirChmod($extPath,0707);
	DirDelete($InstallTmpDir);
	unlink($zipFile);
	unlink('./install.php');
	getLink('./','','');
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>킴스큐Rb 인스톨</title>
<?php if ($g['mobile']):?>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,target-densitydpi=medium-dpi" />
<?php endif?>
<link type="text/css" rel="stylesheet" charset="utf-8" href="<?php echo $InstallTmpDir?>/install.css" />
<script type="text/javascript" charset="utf-8" src="<?php echo $InstallTmpDir?>/install.js"></script>
</head>
<body>

<div<?php if ($g['mobile']):?> class="_mobile"<?php endif?>>
<div id="insbox">
	<h1>무한한 가능성! 킴스큐Rb 설치를 시작합니다.</h1>
	<p>
		킴스큐Rb는 별도의 서버작업(압축해제,퍼미션 조정등) 절차없이 쉽고 빠르게 설치를 진행할 것입니다.<br />
		준비가 되셨으면 설치하기 버튼을 클릭해 주십시오.<br />
		설치가 진행되면 서버에 따라 몇초 정도 후 초기환경을 위한 셋팅페이지로 이동할 것입니다.<br />
	</p>
	<?php if(!is_writable($zipFile)||!is_writable('./index.php')||!is_writable('./install.php')||!is_writable('./_installer')||!is_writable('./_tmp')):$_perm=false;?>
	<div class="permcheck">
		
		<div class="guide">
		아래의 폴더 또는 파일들은 퍼미션이 707로 변경되어야 설치를 진행할 수 있습니다.<br />
		FTP 접속 후 퍼미션을 변경해 주시거나 퍼미션 변경방법을 모르시면 FTP접속정보를 입력해 주세요.<br />
		FTP 정보를 입력해 주시면 자동으로 변경됩니다.<br />
		</div>

		<ul>
		<?php if(!is_writable('./')):?><li><?php echo $installFoler?></li><?php endif?>
		<?php if(!is_writable('./kimsq.zip')):?><li><?php echo $installFoler?>/kimsq.zip</li><?php endif?>
		<?php if(!is_writable('./index.php')):?><li><?php echo $installFoler?>/index.php</li><?php endif?>
		<?php if(!is_writable('./install.php')):?><li><?php echo $installFoler?>/install.php</li><?php endif?>
		<?php if(!is_writable('./_installer')):?><li><?php echo $installFoler?>/_installer</li><?php endif?>
		<?php if(!is_writable('./_tmp')):?><li><?php echo $installFoler?>/_installer</li><?php endif?>
		</ul>
		
		<form action="" method="post" onsubmit="return saveCheck(this);">
		<input type="hidden" name="permcheck" value="Y" />
		<input type="hidden" name="ftp_folder" value="<?php echo $installFoler?>" />
		<table>
		<tr>
		<td class="td1">도메인(또는 IP)</td>
		<td class="td2"><input type="text" name="host" value="<?php echo $_SERVER['HTTP_HOST']?>" class="input" /></td>
		<?php if ($g['mobile']):?></tr><tr><?php endif?>
		<td class="td1">포트</td>
		<td class="td2"><input type="text" name="port" value="21" size="2" class="input" /></td>
		</tr>
		<tr>
		<td class="td1">아이디</td>
		<td class="td2"><input type="text" name="id" value="" class="input" /></td>
		<?php if ($g['mobile']):?></tr><tr><?php endif?>
		<td class="td1">패스워드</td>
		<td class="td2"><input type="password" name="pw" value="" class="input" /></td>
		</tr>
		</table>
		
		<div class="submitbox">
		<input type="submit" value="퍼미션변경" id="_submit_btn_" class="insbtn" />
		</div>
		</form>

	</div>
	<?php endif?>

	<div class="btm">
	<?php if(is_writable('./')&&$_perm):?>
	<input type="button" value="설치하기" class="insbtn" onclick="install(this);" />
	<?php else:?>
	<input type="button" value="위에 나열된 폴더 또는 파일들의 퍼미션을 707로 변경한 후 설치를 진행하세요." class="insbtn perm" onclick="permCheck();" />
	<?php endif?>
	</div>

</div>
</div>
</body>
</html>
