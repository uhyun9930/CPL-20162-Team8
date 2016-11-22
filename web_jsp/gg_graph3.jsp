<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
    Connection conn;
    Statement stmt;
    try
    {
        Class.forName( "com.mysql.jdbc.Driver" );
        conn = DriverManager.getConnection( "jdbc:mysql://localhost/smart", "user", "user" );
        stmt = conn.createStatement();
        
  stmt.close();
  conn.close();
    }
    catch( Exception ex )
    {
        out.println( ex.getMessage() );
    }
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Fri Nov 18 2016 02:35:31 GMT+0000 (UTC) -->
<html data-wf-domain="SMART FARM" data-wf-page="582e6147e6a815951372abed" data-wf-site="582dbc23c34982e54bfd9491" data-wf-status="1">

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
  
  
<script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<%  
  Date now=new Date();
%>
<script>
$(function () {
    Highcharts.chart('container', {
        title: {
            text: '토양습도 그래프',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
        	 categories: ['12:00', '13:00', '14:00', '15:00', '16:00', '17:00',
        	                '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
        },
        yAxis: {
            title: {
                text: 'soil humidity (%)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '%'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{name:' ',data: []}, {name:' ',data: []},  {name:' ',data: []},
            {
                name: '토양습도',
                data: [29, 28, 23,32, 29, 29, 30, 39, 44, 45, 42,43]
            }]
    });
});
</script>

<script src="https://daks2k3a4ib2z.cloudfront.net/0globals/modernizr-2.7.1.js" type="text/javascript">
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
<a class="w-inline-block w-tab-link" data-w-tab="Tab 1" href='gg_graph0.jsp'><div>온도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 2" href='gg_graph1.jsp'><div>조도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 3" href='gg_graph2.jsp'><div>습도</div></a>
<a class="tab2 w--current w-inline-block w-tab-link" data-w-tab="Tab 4" href='gg_graph3.jsp'><div>토양습도</div></a>
</div>


<div class="w--tab-active w-tab-pane" data-w-tab="Tab 4">


<h4>현재 시각은,  <%=now %> 입니다 ^^!</h4>
 <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

</div>

</div></div></div>

</body></html>