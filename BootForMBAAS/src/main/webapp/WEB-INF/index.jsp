<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPACrudProject</title>
</head>
<body>

	<form action="findBandById.do">
		<input type="text" name="id" placeholder="input band id here">
		<input type="submit"  value="Find Band by ID">
		
	</form>
	<form action="addMetalBand.do" method="post">
		<input type="text" name="year founded" placeholder="input the year the band was founded">
		<input type="text" name="name of band" placeholder="input name of band here">
		<input type="text" name="popular song" placeholder="input popular song here">
		<input type="submit" name="add new band" value="add new band">
	</form><br>
	<form>
	<p>You can also change the info of an existing metal band in the database:</p><br>
	<form action="changeBandInfo.do" method="post">
		<input type="text" name="edit year founded" placeholder="edit existing year founded entry for a band">
		<input type="text" name="edit name of band" placeholder="edit name of existing band">
		<input type="text" name="edit popular song" placeholder="edit the existing popular song of a current band in the database">
		<input type="submit" name="confirm" value="confirm">
	</form><br>
	<form>
	<p>You can also delete a band from the current database:</p><br>
	<form action="deleteBand.do">
	<input type="text" name="delete band from database" placeholder="delete a selected band from the database">
	<input type="submit" name="confirm delete" value="confirm">
	</form>
	<form>
	<form action=""
	
	</form>
	
</body>
</html>