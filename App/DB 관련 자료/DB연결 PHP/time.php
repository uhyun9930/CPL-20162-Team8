<?
$connect=mysqli_connect("localhost", "root", "autoset", "farm_db");

if (mysqli_connect_errno($connect))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}  

mysqli_set_charset($connect,"utf8"); 

$res=mysqli_query($connect,"select * from time");

$result = array(); 

while($row=mysqli_fetch_array($res)){
	array_push($result, array('date_info'=>$row[0],'time_info'=>$row[1]));  
}
echo json_encode(array("result"=>$result));
mysqli_close($connect);
?>
