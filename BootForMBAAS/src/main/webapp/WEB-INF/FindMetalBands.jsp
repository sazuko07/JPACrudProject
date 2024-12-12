<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Metal Bands</title>
</head>
<body>
<c:forEach items="${metalBands }" var="metalBands">
${metalBands.nameOfBand }
${metalBands.popularSong }
</c:forEach>
</body>
</html>
