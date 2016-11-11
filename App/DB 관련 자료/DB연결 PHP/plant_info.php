<?
$connect=mysqli_connect("localhost", "root", "autoset", "farm_db");

if (mysqli_connect_errno($connect))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}  

mysqli_set_charset($connect,"utf8"); 

$res=mysqli_query($connect,"select * from plant_info");

$result = array(); 

while($row=mysqli_fetch_array($res)){
	array_push($result, array('pid'=>$row[0],'date_info'=>$row[1],'time_info'=>$row[2] ,'temperature'=>$row[3] ,'illumination'=>$row[4], 'humid'=>$row[5], 'soil_humid'=>$row[6]));  
}
echo json_encode(array("result"=>$result));
mysqli_close($connect);
?>
