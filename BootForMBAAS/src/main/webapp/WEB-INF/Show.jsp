<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Metal Band</title>
</head>
<body>
<form>
<c:forEach items="${metalBands }" var="metalBands">
${metalBands.id } 
${metalBands.nameOfBand }
${metalBands.popularSong }
</c:forEach>
</form>
</body>
</html>