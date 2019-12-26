<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
span.star-prototype, span.star-prototype > * {
    height: 16px; 
    background: url(http://i.imgur.com/YsyS5y8.png) 0 -16px repeat-x;
    width: 80px;
    display: inline-block;
}
 
span.star-prototype > * {
    background-position: 0 0;
    max-width:80px; 
}
</style>
 <script >
  
 $.fn.generateStars = function() {
	    return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
	};

	// 숫자 평점을 별로 변환하도록 호출하는 함수
	$('.star-prototype').generateStars();

  
 </script>
</head>
<body>
 <span class="star-prototype">4.5</span>
</body>


</html>



