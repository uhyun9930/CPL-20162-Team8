<!doctype html>
<html lang="ko">
<head>
  <title>calendar</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
 <input type = "text" id="calendar" name = "calendar"/>

</body>
  <script>
  $( function() {
    $( "#calendar" ).datepicker({
     showMonthAfterYear:true,
		 minDate:'-0d',
		 yearSuffix:'년',
		 monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		 monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],	 
		 dayNamesMin:['일','월','화','수','목','금','토'],
		 xxonSelect: function(dateText, datePicker)
		{
			var mm = (datePicker.selectedMonth+1);
			var dd = datePicker.selectedDay;

			if (mm<10) mm="0"+mm;
			if (dd<10) dd="0"+dd;
			$("#currentDate").val(datePicker.selectedYear+"년"+mm+"월"+dd+"일");
		}
    });
  } );
  </script>
</html>