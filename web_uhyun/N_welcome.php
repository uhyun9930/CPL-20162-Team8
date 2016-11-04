<!DOCTYPE html><!-- This site was created in Webflow. http://www.webflow.com--><!-- Last Published: Sun Oct 02 2016 09:30:59 GMT+0000 (UTC) --><html data-wf-domain="kimwoohyun-s-cool-site.webflow.io" data-wf-page="57f0c61d5acc0a513c8c4da1" data-wf-site="57f0c61c5acc0a513c8c4d9e" data-wf-status="1"><head><meta charset="utf-8"><title>Kimwoohyun&#39;s Cool Site</title><meta content="width=device-width, initial-scale=1" name="viewport"><meta content="Webflow" name="generator"><link href="https://daks2k3a4ib2z.cloudfront.net/57f0c61c5acc0a513c8c4d9e/css/kimwoohyun-s-cool-site.webflow.1df0c40f0.css" rel="stylesheet" type="text/css"><script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script><script type="text/javascript">WebFont.load({
  google: {
    families: ["Open Sans:300,300italic,400,400italic,600,600italic,700,700italic,800,800italic","Montserrat:400,700","Roboto:300,regular,500"]
  }
});</script>
<script src="https://daks2k3a4ib2z.cloudfront.net/0globals/modernizr-2.7.1.js" type="text/javascript">
session_start();

<link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon"></script><link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon"></head><body><div class="navigation-bar w-nav" data-animation="default" data-collapse="medium" data-contain="1" data-duration="400"><div class="w-container"><a class="brand-link w-nav-brand" href="/"><h1 class="brand-text">smart farm</h1></a><nav class="navigation-menu w-nav-menu" role="navigation"><?echo $_COOKIE['hwi']?><a class="navigation-link w-nav-link" href="/"><span>Home</span></a><a class="navigation-link w-nav-link" href="#">info</a></nav><div class="hamburger-button w-nav-button"><div class="w-icon-nav-menu"></div></div></div></div><div class="centered hero-section"><div class="w-container" data-ix="new-interaction"><h1 class="hero-heading" data-ix="fade-in-bottom-page-loads">smart farm</h1></div></div><div class="section"><div class="container w-container"><div class="section-title-group"></div><div class="tabs-wrapper w-tabs" data-duration-in="300" data-duration-out="100"><div class="tab-menu w-tab-menu"><a class="button tab w-inline-block w-tab-link" data-w-tab="camera"><div>camera</div></a><a class="button tab w--current w-inline-block w-tab-link" data-w-tab="Tab 2"><div>weather</div></a><a class="button tab w-inline-block w-tab-link" data-w-tab="Tab 3"><div>graph</div></a><a class="button tab w-inline-block w-tab-link" data-w-tab="Tab 5"><div>qr cord</div></a></div><div class="w-tab-content"><div class="w-tab-pane" data-w-tab="camera"><div><img class="fullwidth-image" sizes="(max-width: 767px) 96vw, (max-width: 991px) 728px, 940px" src="http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4dec_photo-1422222948315-28aadb7a2cb8.jpg" srcset="http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4dec_photo-1422222948315-28aadb7a2cb8-p-500x334.jpeg 500w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4dec_photo-1422222948315-28aadb7a2cb8-p-800x534.jpeg 800w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4dec_photo-1422222948315-28aadb7a2cb8-p-1080x721.jpeg 1080w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4dec_photo-1422222948315-28aadb7a2cb8.jpg 1300w"><h2>camera</h2><p>실시간 농장 상황입니다.</p></div></div><div class="w--tab-active w-tab-pane" data-w-tab="Tab 2"><a href="#">http://www.kma.go.kr/index.jsp</a></div><div class="w-tab-pane" data-w-tab="Tab 3"><div>
<h2>Graph</h2></div>
<html>
<head>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Day');
      data.addColumn('number', 'Guardians of the Galaxy');
      data.addColumn('number', 'The Avengers');
      data.addColumn('number', 'Transformers: Age of Extinction');

      data.addRows([
        [1,  37.8, 80.8, 41.8],
        [2,  30.9, 69.5, 32.4],
        [3,  25.4,   57, 25.7],
        [4,  11.7, 18.8, 10.5],
        [5,  11.9, 17.6, 10.4],
        [6,   8.8, 13.6,  7.7],
        [7,   7.6, 12.3,  9.6],
        [8,  12.3, 29.2, 10.6],
        [9,  16.9, 42.9, 14.8],
        [10, 12.8, 30.9, 11.6],
        [11,  5.3,  7.9,  4.7],
        [12,  6.6,  8.4,  5.2],
        [13,  4.8,  6.3,  3.6],
        [14,  4.2,  6.2,  3.4]
      ]);

      var options = {
        chart: {
          title: 'Box Office Earnings in First Two Weeks of Opening',
          subtitle: 'in millions of dollars (USD)'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));
      chart.draw(data, options);
    }
  </script>
</head>
<body>
  <div id="line_top_x"></div>
</body>
</html>

</div><div class="w-tab-pane" data-w-tab="Tab 5"><div><img class="fullwidth-image" sizes="(max-width: 767px) 96vw, (max-width: 991px) 728px, 940px" src="http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4df0_5cf8b62b.jpg" srcset="http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4df0_5cf8b62b-p-500x333.jpeg 500w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4df0_5cf8b62b-p-800x532.jpeg 800w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4df0_5cf8b62b-p-1080x718.jpeg 1080w, http://uploads.webflow.com/57f0c61c5acc0a513c8c4d9e/57f0c61d5acc0a513c8c4df0_5cf8b62b.jpg 1300w"><h2>Heading</h2></div><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. <br>Duis cursus, mi quis viverra ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat. <br>Aenean faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut sem vitae risus tristique posuere.</p></div></div></div></div></div><div class="center footer"><div class="w-container"><div class="footer-text">경북대학교 컴퓨터학부 smartfarmpang</div></div></div><script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<script src="https://daks2k3a4ib2z.cloudfront.net/57f0c61c5acc0a513c8c4d9e/js/webflow.bd0517ecd.js" type="text/javascript"></script>
<!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body></html>