<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.security.MessageDigest, java.util.*" %>
<%
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");
    String recipeId = request.getParameter("recipeId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1, user-scalable=no" />
<meta name="robots" content="noindex, nofollow" />
<meta name="title" content="[A.I Based food life platform FoodLab]" />
<meta name="author" content="원더풀플랫폼">
<meta name="description" content="인공지능 푸디가 여러분의 건강과 취향을 고려햐여 음식을 만들고 추천해 드려요! 식재료,음식 공유 & 기부 플랫폼을 통해 새로운 가치를 만들고, 잃어버린 '같이'를 찾아요!" />
<meta property="og:title" content="[A.I Based food life platform FoodLab]">
<meta property="og:author" content="원더풀플랫폼">
<meta property="og:image" content="https://lh3.googleusercontent.com/Jx7zYz89Yp-riZCcQzHNOUS6IJ7MV-f2McIV8ssX5wv5od5mK5Iph5zaZ3feUhWmnA=w300-rw">
<meta property="og:description" content="인공지능 푸디가 여러분의 건강과 취향을 고려햐여 음식을 만들고 추천해 드려요! 식재료,음식 공유 & 기부 플랫폼을 통해 새로운 가치를 만들고, 잃어버린 '같이'를 찾아요!">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var userAgent=navigator.userAgent,visitedAt=(new Date).getTime();if(userAgent.match(/Android/)){var appStore="https://play.google.com/store/apps/details?id=com.onethefull.recipe&hl=ko";userAgent.match(/Chrome/)?setTimeout(function(){location.href="intent://recipe_detail?recipeid="+<%= recipeId %>+"#Intent;scheme=foodlab;action=android.intent.action.VIEW;category=android.intent.category.BROWSABLE;package=com.onethefull.recipe;end;"},1e3):location.href="intent://recipe_detail?recipeid="+<%= recipeId %>+"#Intent;scheme=foodlab;action=android.intent.action.VIEW;category=android.intent.category.BROWSABLE;package=com.onethefull.recipe;end;"}else if(userAgent.match(/iPhone|iPad|iPod/)){var appStore="https://play.google.com/store/apps/details?id=com.onethefull.recipe&hl=ko";setTimeout(function(){(new Date).getTime()-visitedAt<2e3&&(location.href=appStore)},1500)}else location.href="https://play.google.com/store/apps/details?id=com.onethefull.recipe&hl=ko";
});
</script>
</head>
<body>

</body>
</html>