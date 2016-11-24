<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>

<!DOCTYPE html><!-- This site was created in Webflow. http://www.webflow.com-->
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
<script type="text/javascript">
	function move(url) {
		location.href=url;
	}
	function boardViewCheck() {
		var form = document.BoardViewForm;
		return true;
	}
</script>

<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>
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

<form name="BoardViewForm" method="post">
	<table summary="전체 테이블 구성">
	<tr>
		<td ><div align="center"><h3><b>글 읽기</b></h3></div></td>
	</tr>
	<tr>
		<td colspan=2>
		<table border="1" summary="목록 테이블 구성"> 
    <tr> 
		<td align=center bgcolor=#dddddd width=20%> 작성자</td>
		<td bgcolor=#ffffe8 width=40%>지후니</td>
		<td align=center bgcolor=#dddddd width=50%> 작성일</td>
		<td bgcolor=#ffffe8 width=40%>2015/11/23</td>
	</tr>
    <tr>
		<td align=center bgcolor=#dddddd> E-mail </td>
		<td bgcolor=#ffffe8 >hunit@hunit</td> 
		<td align=center bgcolor=#dddddd> 홈페이지 </td>
		<td bgcolor=#ffffe8><a href="http://hunit.tistory.com" target="_new">http://hunit.tistory.com</a></td> 
	</tr>
	<tr> 
		<td align=center bgcolor=#dddddd> 제 목</td>
		<td bgcolor=#ffffe8 colspan=3> 게시판 글입니다</td>
   </tr>
   <tr> 
		<td colspan=4><br>가나다라마바사<br></td>
   </tr>
   <tr>
		<td colspan=4 align=right> 조회수  : </td>
   </tr>
	</table>
	</td>
 	</tr>
	<tr>
		<td align=center colspan=2> 
		<hr size=1>
		<div align="center">
		[ <input type="button" value="목록" onclick="move('Board_List.jsp');"> | 
		<input type="button" value="수정" onclick="move('Board_Update.jsp');"> |
		<input type="button" value="답변" onclick="move('Board_Reply.jsp');"> |
		<input type="button" value="삭제" onclick="move('Board_Delete.jsp');">]<br>
		</div>
		</td>
	</tr>
	</table>
</form>


</div>

<div class="w-tab-pane" data-w-tab="Tab 2">
</div>

</div></div></div>

<div class="w-tabs" data-duration-in="300" data-duration-out="100"></div>

<div class="w-clearfix">
<a class="b1 w-button" href="#">��臾� 異�媛���湲�</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body></html>