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
	function boardReplyCheck() {
		var form = document.BoardReplyForm;
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


<body>
	<table summary="전체 테이블 구성">
 	<tr>
  		<td bgcolor=#dcdcdc height=25 align=center>답변달기</td>
 	</tr>
	</table><br>

	<table summary= "답변 테이블 구성">
	<form name="BoardReplyForm" method="post" action="Board_Reply_action.jsp" 
														onsubmit="return boardReplyCheck();" >
 	<tr>
		<td>
		<table border=0 width=100% align=center>
	    <tr>
			<td align="center">작성자</td>
			<td ><input type=text name=name size=10 maxlength=8></td>
    	</tr>
    	<tr>
	 		<td align="center">E-Mail</td>
	 		<td><input type=text name=email size=30 maxlength=30></td>
    	</tr>
    	<tr>
			<td align="center">홈페이지</td>
			<td><input type=text name=homepage size=40 maxlength=30></td>
	    </tr>
		<tr>
			<td width=10% align="center">제 목</td>
			<td width=50%><input type=text name=title size=50 maxlength=30 value="RE : 게시판 글입니다."></td>
		</tr>
		<tr>
			<td width=10% align="center">내 용</td>
			<td><textarea name=content rows=10 cols=70> 가나다라마바사

----------------------------------------------

|댓글|

		</textarea></td>
		</tr>
		<tr>
			<td width=10% align="center">비밀 번호</td> 
			<td width=70% ><input type=password name="password" size=15 maxlength=15></td>
		    </tr>
		<tr>
			<td colspan=2><hr size=2></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<input type="submit" value="답변 등록" class="btn" >&nbsp;
			<input type="button" value="뒤로가기" onclick="javascript:history.back()">
			</td>
		</tr> 
		</table>
		</td>
		</tr>
		</form> 
	</table>
</body>

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