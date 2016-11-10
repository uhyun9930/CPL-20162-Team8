<?php
function getLink($url,$alert,$history)
{
	echo '<meta http-equiv="content-type" content="text/html; charset=utf-8" />';
	echo '<script type="text/javascript">';
	if ( $alert ) echo "alert('".$alert."          ');";
	if ( $url   ) echo "location.href='".$url."';";
	if ($history == -1) echo 'history.go('.$history.');';
	if ($history == "close") echo 'top.close();';
	echo '</script>'; 
	exit;
}
function DirChmod($t_dir,$mode)
{
	$dirh = opendir($t_dir); 
	while(false !== ($filename = readdir($dirh))) 
	{ 
		if($filename != '.' && $filename != '..') 
		{
			if(!is_file($t_dir.'/'.$filename)) 
			{
				@chmod($t_dir.'/'.$filename,$mode); 
				DirChmod($t_dir.'/'.$filename,$mode);
			}
			else { 
				@chmod($t_dir.'/'.$filename,$mode); 
			}
		}
	} 
	closedir($dirh);
	@chmod($t_dir,$mode);
}
function DirDelete($t_dir)
{
	$dirh = opendir($t_dir); 
	while(false !== ($filename = readdir($dirh))) 
	{ 
		if($filename != '.' && $filename != '..') 
		{
			if(!is_file($t_dir.'/'.$filename)) 
			{
				DirDelete($t_dir.'/'.$filename);
			}
			else { 
				@unlink($t_dir.'/'.$filename); 
			}
		}
	} 
	closedir($dirh);
	@rmdir($t_dir);
}
function isMobileConnect($agent)
{
	if($_SESSION['pcmode']=='E') return 'RB-Emulator';
	$xagent = strtolower($agent);
	foreach($GLOBALS['d']['magent'] as $val)
	{
		$valexp = explode('=',trim($val));
		if(strpos($xagent,$valexp[0])) return $valexp[1];
	}
	return '';
}
$d['magent']= array(
	'android=안드로이드',
	'ipod=아이팟',
	'ipad=아이패드',
	'iphone=아이폰',
	'blackberry=블랙베리',
	'windows ce=윈도우즈모바일',
	'windows phone os 7=윈도우7폰',
	'mobile=모바일'
);
$g['mobile'] = isMobileConnect($_SERVER['HTTP_USER_AGENT']);
?>