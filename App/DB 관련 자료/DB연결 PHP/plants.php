<?
function unistr_to_xnstr($str){ 
    return preg_replace('/\\\u([a-z0-9]{4})/i', "&#x\\1;", $str); 
} 

$connect=mysqli_connect("localhost", "root", "zotnl39a", "smartfarm");

if (mysqli_connect_errno($connect))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}  

mysqli_set_charset($connect,"utf8"); 

$res=mysqli_query($connect,"select * from plants");

$result = array(); 

while($row=mysqli_fetch_array($res)){
	array_push($result, array('pid'=>$row[0],'pname'=>$row[1]));  
}
$json = json_encode(array("result"=>$result));  
echo unistr_to_xnstr($json);
mysqli_close($connect);
?>
