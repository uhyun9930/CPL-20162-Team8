<?php
 $user_id = $_POST["user_id"];
 $pw = $_POST["pw"];
 $name = $_POST["name"];
 $email = $_POST["email"];
 $memo = $_POST["memo"];
 
 $connect = mysql_connect("localhost","root","apmsetup");
 mysql_select_db("hompi");
 
 $query = "insert into member(user_id,pw,name,email,memo)
    values('$user_id','$pw','$name','$email','$memo')";
 mysql_query($query, $connect);
 mysql_close($connect);
 echo $_POST["user_id"];

?>
<script>

</script>
 