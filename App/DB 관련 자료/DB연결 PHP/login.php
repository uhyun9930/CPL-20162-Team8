<?php
$con=mysqli_connect("localhost", "root", "autoset", "smartfarm");
 
$email = $_POST['email'];
$password = $_POST['password'];
 
$sql = "select * from user where email='$email' and password='$password'";
 
$res = mysqli_query($con,$sql);
 
$check = mysqli_fetch_array($res);
 
if(isset($check)){
echo 'success';
}else{
echo 'failure';
}
 
mysqli_close($con);
?>