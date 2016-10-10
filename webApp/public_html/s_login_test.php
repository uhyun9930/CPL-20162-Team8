<script>
 session_start();
</script>
<?

 if($_COOKIE['hwi']){?>
 <?=$email?>
<?
$email=$_COOKIE['hwi'];
$connect=mysql_connect("localhost", "root", "apmsetup");
mysql_select_db("farm_db", $connect);
$query  = "select * from farm where email='$email'";
$result=mysql_query($query, $connect) or die(mysql_error());
?>
</table>
 <?echo $_COOKIE['hwi']?>님이 로그인하셨습니다!

<p><h3> ▶식물정보 확인하기◀</h3></p>

<table width="850" border="1" cellspacing="0" cellpadding="5">
<tr bgcolor="#cccccc">
<th>구분</th>
<th>이름</th>
<th>온도</th>
<th>습도</th>
<th>토양습도</th>
<th>조도</th>
</tr>
<?
$count=1;
while($data=mysql_fetch_array($result)){
echo"<tr>
<td>$count</td>
<td>$data[pname]</td>
<td>$data[temperature]</td>
<td>$data[humidity]</td>
<td>$data[soil]</td>
<td>$data[illumination]</td>
</tr>";
$count++;
}
mysql_close($connect);
?>

 <?}else{?>
 
  로그인하지 않았습니다<br>
  <a href='member.php'>회원가입하기</a>
  <a href='login.php'>로그인하기</a>
 <?}
  
?>