<?php
 
 $email = $_POST["email"];
 $pw = $_POST["pw"];
 $name = $_POST["name"];

 
 $connect = mysql_connect("localhost","root","apmsetup");
 mysql_query("set names euckr");
 mysql_select_db("farm_db");
 
 $query = "insert into member(email,pw,name)
    values('$email','$pw', '$name')";
 mysql_query($query, $connect);
 mysql_close($connect);

?>
<script>
location.href='login_test.php';
</script>