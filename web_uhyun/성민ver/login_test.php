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
 <?echo $_COOKIE['hwi']?>���� �α����ϼ̽��ϴ�!

<p><h3> ���Ĺ����� Ȯ���ϱ⢸</h3></p>

<table width="850" border="1" cellspacing="0" cellpadding="5">
<tr bgcolor="#cccccc">
<th>����</th>
<th>�̸�</th>
<th>�µ�</th>
<th>����</th>
<th>������</th>
<th>����</th>
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
 
  �α������� �ʾҽ��ϴ�<br>
  <a href='member.php'>ȸ�������ϱ�</a>
  <a href='login.php'>�α����ϱ�</a>
 <?}
  
?>