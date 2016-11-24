
<?php


error_reporting(0); 

include("dbconnect.php");
 
 // session의 시작
 session_start();

 $email = $_POST[Email];
 $pass = $_POST[Password];
 
 $query  = "select *from member where email='$email' and pass='$pass'";
 $result = mysqli_query($conn,$query);
 
 
 $count=mysqli_num_rows($result); //몇개의 데이터가 반환되었는지 확인, 1이라면 유저존재
	 
 if($count==1)
 {
  echo "
	.<script>document.location.href='gg.php'</script>


     //<a href='gg.php'>go</a>
  ";
  exit;
 }
 else 
 {
	 echo "
	  <script>
	   window.alert('아이디 혹은 비밀번호를 확인하세요.');
	   history.back(1);
	  </script>
	  ";
	  exit;
 }
 
 	 
 // 연결 확인
 
 setcookie("hwi","$email",0,"/");
 $hwi = $_COOKIE[hwi];
 
 mysqli_close($conn); 
 


?>
