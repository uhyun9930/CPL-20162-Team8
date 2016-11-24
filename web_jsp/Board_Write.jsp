<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	function boardWriteCheck() {
		var form = document.BoardWriteForm;
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



	
	<table summary="글쓰기 전체 테이블">
		<form name="BoardWriteForm" method="post" action="Board_Write_action.jsp" 
														onsubmit="return boardWriteCheck();" >
		
   		<colgroup>
   			<col width="50%">
   			<col width="80%">
   		</colgroup>
   	

		<table summary="테이블 구성" >
		<caption>게시판 글쓰기</caption>	
    		<tr>
				<td>작성자</td>
				<td><input type=text name=name size=10 maxlength=8></td>
			</tr>
			<tr>
	 			<td>E-Mail</td>
	 			<td><input type=text name=email size=30></td>
    		</tr>
    		<tr>
     			<td>홈페이지</td>
     			<td><input type=text name=homepage size=30></td>
    		</tr>
    		<tr>
     			<td>제 목</td>
     			<td><input type=text name=title></td>
    		</tr>
    		<tr>
     			<td>내 용</td>
     			<td><textarea name=content rows ="10" cols="100"></textarea></td>
    		</tr>
    		<tr>
     			<td>비밀번호</td> 
     			<td><input type=password name=password size=15 maxlength=15></td>
    		</tr>
    		<tr>
     			<td colspan=2><hr size=1></td>
    		</tr>
    		<tr>
     			<td colspan="2"><div align="center">
     			<input type="submit" value="등록" >&nbsp;&nbsp;
         		<input type="button" value="뒤로" onclick="move('Board_List.jsp');"></div>
     			</td>
    		</tr> 
		</table>
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