<? 
 $email = $_POST["email"];
 $pw = $_POST["pw"];
 $name = $_POST["name"];
 $connect = mysql_connect("localhost","root","apmsetup");
 mysql_query("set names euckr");
 mysql_select_db("farm_db");
 $query  = "select *from member where email='$email'";
 $result = mysql_query($query,$connect);
 $data =  mysql_fetch_array($result);
 $name = $data[name];

 if($data[email]!= $email){
  echo "
  <script>
   window.alert('엇; 아이디가 디비에 엄써여');
   history.back(1);
  </script>
  ";
  exit;
 }

 if($data[pw]!= $pw){
  echo "
  <script>
   window.alert('비밀번호를 잘못썼어여ㅋㅋ');
   history.back(1);
  </script>
  ";
  exit;
 }
 
 setcookie("hwi",$email,0,"/");
 $hwi = $_COOKIE['hwi'];
 
 
 mysql_close($connect);
?>
<script>
 location.href='green.php';
</script>