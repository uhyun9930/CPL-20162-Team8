<?

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

?>