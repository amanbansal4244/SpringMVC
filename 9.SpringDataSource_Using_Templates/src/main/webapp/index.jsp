<html>
<body>
<form action="getCircleNameSimpleMapping">
	Enter the  Circle ID:       <input type="text" name="t1"><br>
	Press Submit To Get Result: <input type="submit">
</form>

<form action="getCircleCountMapping">
	Get Total Circle Count: <input type="submit">
</form>

<form action="getCircleNameClassMapping">
	Enter the  Circle ID:       <input type="text" name="t2"><br>
	Get Circle Name using RowMapper: <input type="submit">
</form>

<form action="getCircleListClassMapping">
	Get Total No of Circle Count from List using RoWMapper: <input type="submit">
</form>


<form action="insertNewCircleRecordAction">
	Enter the New Circle ID:       <input type="text" name="t3"><br>
	Enter the New Circle Name:     <input type="text" name="t4"><br>
	Press Submit to insert new circle record: <input type="submit">
</form>

<form action="createNewTableInDbAction">
	Create New Table: <input type="submit">
</form>

<form action="insertNewCircleRecordUsingNamedParameterJdbcTemplateAction">
	Enter the New Circle ID:       <input type="text" name="t5"><br>
	Enter the New Circle Name:     <input type="text" name="t6"><br>
	Press Submit to insert new circle record using NamedParameterJdbcTemplate: <input type="submit">
</form>

<form action="insertNewCircleRecordUsingSimpleJdbcTemplateAction">
	Enter the New Circle ID:       <input type="text" name="t7"><br>
	Enter the New Circle Name:     <input type="text" name="t8"><br>
	Press Submit to insert new circle record using SimpleJdbcTemplate: <input type="submit">
</form>

<form action="getCircleListClassMappingUsingSimpleJdbcTemplateAction">
	Get Total No of Circle Count from List using SimpleJdbcTemplate : <input type="submit">
</form>


</body>
</html>
