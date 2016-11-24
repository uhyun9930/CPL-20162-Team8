<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Last Published: Fri Nov 18 2016 02:35:31 GMT+0000 (UTC) -->
<html data-wf-domain="kimwoohyuns-dynamite-site.webflow.io" data-wf-page="582e6147e6a815951372abed" data-wf-site="582dbc23c34982e54bfd9491" data-wf-status="1">

<head>
<meta charset="utf-8">
<title>manage</title>
<meta content="manage" property="og:title">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta content="Webflow" name="generator">
<link href="https://daks2k3a4ib2z.cloudfront.net/582dbc23c34982e54bfd9491/css/kimwoohyuns-dynamite-site.webflow.29d5ec84f.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js">
</script>

<script type="text/javascript">WebFont.load({
  google: {
    families: ["Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Ubuntu:300,300italic,400,400italic,500,500italic,700,700italic"]
  }
});

</script>

<script src="https://daks2k3a4ib2z.cloudfront.net/0globals/modernizr-2.7.1.js" type="text/javascript">
</script>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>

<script type="text/javascript">
	function move(url) {
		location.href=url;
	}
	function boardDeleteCheck() {
		var form = document.BoardDeleteForm;
		return true;
	}
</script>
<link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>

<body class="back">
<div class="navbar w-nav" data-animation="default" data-collapse="medium" data-duration="400">
<div class="w-container"><a class="w-nav-brand" href="#"><h1 class="smart">SMART FARM</h1></a>

<nav class="w-nav-menu" role="navigation">
<a class="link w-nav-link" href='gg.jsp'>HOME</a>
<a class="link w-nav-link" href="http://155.230.158.166:8080/html/">CAMERA</a>
<a class="link2 w-nav-link" href="#">WEATHER</a>
<a class="l w-nav-link" href='gg_graph.jsp'>GRAPH</a>
<a class="l2 w-nav-link" href='Board_List.jsp'>MANAGE</a>
</nav>

<div class="w-nav-button">
<div class="w-icon-nav-menu">

</div>
</div>
</div></div><div></div>

<div class="tab">
<div class="w-tabs" data-duration-in="300" data-duration-out="100">
<div class="w-tab-menu">
<a class="tab2 w--current w-inline-block w-tab-link" data-w-tab="Tab 1"><div>식물 관리</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 2"><div>내 정보 관리</div></a>

</div><div class="w-tab-content"><div class="w--tab-active w-tab-pane" data-w-tab="Tab 1">

	<center>
	<br><br>
	<table width=50% cellspacing=0 cellpadding=3>
 		<tr>
			<td bgcolor=#dcdcdc height=21 align=center>
			작성자의 비밀번호를 입력해 주세요.</td>
		</tr>
	</table>
	
	<table width=70% cellspacing=0 cellpadding=2>
		<form name="BoardDeleteForm" method="post" action="Board_Delete_action.jsp" 
														onsubmit="return boardDeleteCheck();" >
 	<tr>
		<td align=center>
		<table align=center border=0 width=91%>
    <tr> 
     	<td align=center>  
	  	<input type=password name="password" size=17 maxlength=15>
	 	</td> 
    </tr>
    <tr>
		<td><hr size=1 color=#eeeeee></td>
	</tr>
    <tr>
		<td align=center>
		<input type="submit" value="삭제완료" >
		<input type=button value="뒤로" onClick="history.go(-1)">
		</td>
	</tr> 
	</table>
	</td>
	</tr>
	</form> 
	</table>
	</center>

</div>

<div class="w-tab-pane" data-w-tab="Tab 2">
</div>

</div></div></div>

<div class="w-tabs" data-duration-in="300" data-duration-out="100"></div>

<div class="w-clearfix">
<a class="b1 w-button" href="#">식물 추가하기</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body></html>