
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
  
  
  <!-- BEGIN: load jquery -->
  <script language="javascript" type="text/javascript" src="../jquery-1.3.2.min.js"></script>
  <script type="text/javascript" src="../../jqplot/jquery-1.3.2.min.js"></script>
 <link href="../../jqplot/jquery.jqplot.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="../jquery.jqplot.js"></script>
 <script type="text/javascript" src="../excanvas.min.js"></script>

  <!-- END: load jquery -->
  
  <!-- BEGIN: load jqplot -->
 <script language="javascript" type="text/javascript" src="../jquery.jqplot.js"></script>
  <script language="javascript" type="text/javascript" src="../plugins/jqplot.dateAxisRenderer.js"></script>
   <script language="javascript" type="text/javascript" src="../plugins/jqplot.cursor.js"></script>
  <script language="javascript" type="text/javascript" src="../plugins/jqplot.highlighter.js"></script>

<script src="https://daks2k3a4ib2z.cloudfront.net/0globals/modernizr-2.7.1.js" type="text/javascript">
</script>
<link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>

<body class="back">
<div class="navbar w-nav" data-animation="default" data-collapse="medium" data-duration="400">
<div class="w-container"><a class="w-nav-brand" href="#"><h1 class="smart">SMART FARM</h1></a>

<nav class="w-nav-menu" role="navigation">
<a class="link w-nav-link" href='gg.php'>HOME</a>
<a class="link w-nav-link" href="http://155.230.158.166:8080/html/">CAMERA</a>
<a class="link2 w-nav-link" href="#">WEATHER</a>
<a class="l w-nav-link" href='gg_graph0.php'>GRAPH</a>
<a class="l2 w-nav-link" href='gg_manage.php'>MANAGE</a>
</nav>

<div class="w-nav-button">
<div class="w-icon-nav-menu">

</div>
</div>
</div></div><div></div>

<div class="tab">
<div class="w-tabs" data-duration-in="300" data-duration-out="100">
<div class="w-tab-menu">
<a class="w-inline-block w-tab-link" data-w-tab="Tab 1" href='gg_graph0.php'><div>온도</div></a>
<a class="tab2 w--current w-inline-block w-tab-link" data-w-tab="Tab 2" href='gg_graph1.php'><div>조도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 3" href='gg_graph2.php'><div>습도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 4" href='gg_graph3.php'><div>토양습도</div></a>
</div>


<div class="w--tab-active w-tab-pane" data-w-tab="Tab 2">

 
<div id="test" class="plot" style="width:500px;height:300px;"></div>
<script language="javascript" type="text/javascript"><!--
   s1 = [['23-May-08',1],['24-May-08',4],['25-May-08',2],['26-May-08',6]];


   plot1 = $.jqplot('test',[s1],{
       title: 'Smart Farm 조도',
       axes: {
           xaxis: {
               renderer: $.jqplot.DateAxisRenderer,
               tickOptions: {
                   formatString: '%b %#d, %Y'
               },
               numberTicks: 4
           },
           yaxis: {
               tickOptions: {
                   formatString: '$%.2f'
               }
           }
       },
       highlighter: {
           sizeAdjust: 10,
           tooltipLocation: 'n',
           tooltipAxes: 'y',
           tooltipFormatString: '<b><i><span style="color:red;">hello</span></i></b> %.2f',
           useAxesFormatters: false
       },
       cursor: {
           show: true,
           useAxesFormatStrings: false,
           tooltipFormatString: ''
       }
   });
--></script>


</div>

</div></div></div>

<div class="w-tabs" data-duration-in="300" data-duration-out="100"></div>

<div class="w-clearfix">
<a class="b1 w-button" href="#">식물 추가하기</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body></html>