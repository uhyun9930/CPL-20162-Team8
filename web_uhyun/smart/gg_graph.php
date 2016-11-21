
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
 <link rel="stylesheet" type="text/css" href="../jquery.jqplot.css" />
  <link rel="stylesheet" type="text/css" href="../examples/examples.css" />
<script type="text/javascript">WebFont.load({
  google: {
    families: ["Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Ubuntu:300,300italic,400,400italic,500,500italic,700,700italic"]
  }
});

</script>
  
  
  <!-- BEGIN: load jquery -->
  <script language="javascript" type="text/javascript" src="../jquery-1.3.2.min.js"></script>
  <!-- END: load jquery -->
  
  <!-- BEGIN: load jqplot -->
<script language="javascript" type="text/javascript" src="../jquery.jqplot.js"></script>
  <script language="javascript" type="text/javascript" src="../plugins/jqplot.dateAxisRenderer.js"></script>

<script src="https://daks2k3a4ib2z.cloudfront.net/0globals/modernizr-2.7.1.js" type="text/javascript">
</script>
<link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
  <script type="text/javascript" language="javascript">
  
  $(document).ready(function(){
    
    // Set up simulated data from a live price feed for the past minute where data is coming in at every second.
    var t = 1000; // 1000 ms equals 1 second
    var d = new Date().getTime(); // create a new date at the current time.
    var p = Math.random() * 100;  // create a random price for right now.
    var l = [[d,p]];  // create an array to hold our data, mighty as well put in the current time, price while we're at it.
    
    // loop 59 times to create random data for the past 59 seconds.
    for (var i=1; i<61; i++) {
      l.unshift([d - i*t, Math.random()*100]);
    }
    
    // create a custom ticks array for the 
    var ticks = [];
    for (var i=0; i<7; i++) {
      ticks.unshift(d - i*10*t);
    }
    

    plot = $.jqplot('chart', [l], {  
      axes: { 
        xaxis: { padMin:1.0, padMax: 1.1, tickInterval: "10 seconds", renderer: $.jqplot.DateAxisRenderer, tickOptions:{formatString:"%H:%M:%S"} }, 
        yaxis: { tickOptions:{formatString:"$%.2f"}, min:0, max:100 }
      },
      series:[
        {showMarker:false}
      ]
    });
    
    // window.setInterval(updateData, 1000);
    
  });
    
    function updateData () {
      // remove the first element and add a new one on end
      var d = new Date().getTime();
      var p = Math.random()*100;
      var data = plot.series[0].data;
      data.splice(0,1);
      data.push([d, p]);
      // var min = data[0][0];
      // var max = data[data.length-1][0];
      // var ticks = [];
      // for (var t in plot.axes.xaxis._ticks) {
      //   ticks.push(plot.axes.xaxis._ticks[t].value);
      // };
      // plot.axes.xaxis.min = min;
      // plot.axes.xaxis.max = max;
      // plot.axes.xaxis.tickInterval = null;
      // // for date axes...
      // plot.axes.xaxis.daTickInterval = null;
      // plot.axes.xaxis._ticks = null;
      plot.replot({resetAxes:['xaxis']});
    }
  
  </script>

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
<a class="tab2 w--current w-inline-block w-tab-link" data-w-tab="Tab 1"><div>온도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 2"><div>조도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 3"><div>습도</div></a>
<a class="w-inline-block w-tab-link" data-w-tab="Tab 4"><div>토양습도</div></a>
</div>


<div class="w--tab-active w-tab-pane" data-w-tab="Tab 1">

 <?php include "../examples/nav.inc"; ?>
    <div id="chart" style="margin-top:20px; margin-left:20px; width:600px; height:300px;"></div>
    <button onclick="timer = window.setInterval(updateData, 10000);">Start</button>
    <button onclick="timer = window.clearInterval(timer);">Stop</button>
</div>

<div class="w-tab-pane" data-w-tab="Tab 2">
</div>
<div class="w-tab-pane" data-w-tab="Tab 3">

</div>
</div></div></div>

<div class="w-tabs" data-duration-in="300" data-duration-out="100"></div>

<div class="w-clearfix">
<a class="b1 w-button" href="#">식물 추가하기</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body></html>