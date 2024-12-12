<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Metal Band</title>
</head>
<body>
<c:if test="${! empty metalBand}">
	 Name: ${metalBand.nameofband  }
	 Popular Song ${metalBand.popularsong }	 
</c:if> 
</body>
</html>