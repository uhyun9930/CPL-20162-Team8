<?
$connect=mysqli_connect("localhost", "root", "zotnl39a", "smartfarm");

if (mysqli_connect_errno($connect))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}  

mysqli_set_charset($connect,"utf8"); 

$res=mysqli_query($connect,"select * from farm");

$result = array(); 

while($row=mysqli_fetch_array($res)){
	array_push($result, array('email'=>$row[0],'pid'=>$row[1]));  
}
echo json_encode(array("result"=>$result));
mysqli_close($connect);
?>
