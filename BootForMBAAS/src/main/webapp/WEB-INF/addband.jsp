<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Metal Band</title>
</head>
<body>
<p>You have successfully added a new band to the database!</p>
${metalBand.id }<br> 
${metalBand.nameOfBand }<br>
&{metalBand.yearFounded }<br>
${metalBand.popularSong }

</body>
</html>