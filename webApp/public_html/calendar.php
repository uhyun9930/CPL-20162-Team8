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
		 yearSuffix:'��',
		 monthNames:['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'],
		 monthNamesShort:['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'],	 
		 dayNamesMin:['��','��','ȭ','��','��','��','��'],
		 xxonSelect: function(dateText, datePicker)
		{
			var mm = (datePicker.selectedMonth+1);
			var dd = datePicker.selectedDay;

			if (mm<10) mm="0"+mm;
			if (dd<10) dd="0"+dd;
			$("#currentDate").val(datePicker.selectedYear+"��"+mm+"��"+dd+"��");
		}
    });
  } );
  </script>
</html>