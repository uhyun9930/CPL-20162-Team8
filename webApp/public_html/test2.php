<?header("content-type;text/html; charset=UTF-8");

$connect = mysql_connect("localhost", "uhyun9930", "774kuhqwe*"); //mysql연결
mysql_select_db("member", $connect);//db선택

if(!$connect){
	echo "sfdsdfds".mysql_error();
}

?>