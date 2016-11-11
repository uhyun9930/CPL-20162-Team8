<?php
$con=mysqli_connect("localhost", "root", "autoset", "smartfarm");
 
$email = $_POST['email'];

$sql = "select * from user where email='$email'";
 
$res = mysqli_query($con,$sql);
 
$check = mysqli_fetch_array($res);
 
if(isset($check)){
echo 'success';
}else{
echo 'failure';
}
 
mysqli_close($con);
?>