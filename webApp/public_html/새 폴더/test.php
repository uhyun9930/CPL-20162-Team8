
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
body	{padding:0; margin:0; font-size:12px; font-family:dotum; color:#666;}
a {color:#666; text-decoration:none;}
a:hover	{color:#333; text-decoration:none;}
p,ul,li,ol,h2,dl,dt,dd	{margin:0; padding:0; list-style:none;}
#GNB {height:46px; width:647px; background:url(gnb.png) no-repeat left top; margin:50px;}
#GNB li	{width:136px; height:40px; display:block; float:left;}
#GNB a.menu1,
#GNB a.menu2,
#GNB a.menu3{width:136px; height:45px; display:block; float:left; overflow:hidden; text-indent:-999px; background:url(gnb.png) no-repeat;}
#GNB a.menu1{background-position:left top;}
#GNB a.menu2 {background-position:-136px top;}
#GNB a.menu3 {background-position:-272px top;}
#GNB a.menu1:hover {background-position:left -46px;}
#GNB a.menu2:hover {background-position:-136px -46px;}
#GNB a.menu3:hover {background-position:-272px -46px;}
#GNB dl	{border:1px solid #ccc; margin-top:5px; display:none; border-top:0; margin:0 5px; background:#fff; overflow:hidden;}
#GNB dl	dt	{display:none;}
#GNB dl	dd a {display:block;padding:5px 5px 4px 5px;}
#GNB dl	dd a:hover	{background:#eee;}
</style>
<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script>	
$(function() {	
	$('#GNB li').hover(function() {
		$('dl', this).slideDown(200);
	}, function() {
		$('dl', this).slideUp(300);
	});
});
/* 아래 함수와 모두 똑같다....
$(function() {	
	$('#GNB li').mouseenter(function() {
		$('dl', this).slideDown(200);
	});
	$('#GNB li').mouseleave(function() {
		$('dl', this).slideUp(200);
	});
});
$(function() {	
	$('#GNB li').mouseover(function() {
		$('dl', this).slideDown(200);
	});
	$('#GNB li').mouseout(function() {
		$('dl', this).slideUp(200);
	});
});
*/
</script>
</head>
<body>
<!-- GNB -->			
<div id="GNB">					
	<ul>
		<li><a href="#" class="menu1">웹하메뉴1</a>
			<dl>
				<dt>웹하메뉴1</dt>
				<dd><a href="#">메뉴1_1</a></dd>
				<dd><a href="#">메뉴1_2</a></dd>
				<dd><a href="#">메뉴1_3</a></dd>
				<dd><a href="#">메뉴1_4</a></dd>
			</dl>
		</li>
		<li><a href="#" class="menu2">웹하메뉴2</a>
			<dl>
				<dt>웹하메뉴2</dt>
				<dd><a href="#">메뉴2_1</a></dd>
				<dd><a href="#">메뉴2_2</a></dd>
				<dd><a href="#">메뉴2_3</a></dd>
				<dd><a href="#">메뉴2_4</a></dd>
			</dl>
		</li>
		<li><a href="#" class="menu3">웹하메뉴3</a>
			<dl>
				<dt>웹하메뉴3</dt>
				<dd><a href="#">메뉴3_1</a></dd>
				<dd><a href="#">메뉴3_2</a></dd>
				<dd><a href="#">메뉴3_3</a></dd>
				<dd><a href="#">메뉴3_4</a></dd>
			</dl>
		</li>
	</ul>
</div>
<!--// GNB -->


</body>
</html>