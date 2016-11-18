<?php


error_reporting(0); 
 $db_host = "localhost"; 
 $db_user = "user"; 
 $db_passwd = "user";
 $db_name = "test"; //smart farm 회원 정보 db
 $conn = mysqli_connect($db_host,$db_user,$db_passwd,$db_name);

 // 연결
 
 
  if (mysqli_connect_errno($conn)) {
  echo "데이터베이스 연결 실패: " . mysqli_connect_error();
 } else {
  echo "연결 성공";
 }
 
 // 연결 확인
 $email = $_POST[Email];
 $name = $_POST[Name];
 $pass = $_POST[password];
 
 mysqli_query($conn, "INSERT INTO member VALUES ('$email', '$name', '$pass')");



echo "<table border='1'>
<tr>
<th>No</th>
<th>name</th>
</tr>";

$result = mysqli_query($conn,"SELECT * FROM member");
$no = 1;  // 리스트 번호를 나타냄
while($row = mysqli_fetch_array($result)){
 echo "<tr>";
 echo "<td>" . $no . "</td>";
 echo "<td>" . $row[name] . "</td>";
 echo "</tr>";
 $no++;  // 리스트 번호를 1씩 증가시킴
}
echo "</table>";


 mysqli_close($conn); 
 

?>


<script>
 location.href='N_login.php';
</script>