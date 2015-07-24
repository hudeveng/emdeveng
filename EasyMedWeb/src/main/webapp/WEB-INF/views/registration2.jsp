<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Form</title>

	<style>
		.error {
			color: #ff0000;
		}
	</style>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('#storeForm').submit(
			function(event) {
				var ownername = $('#ownername').val();
				var storename = $('#storename').val();
				var city = $('#city').val();
				var json = {"ownername" : ownername, "storename" : storename, "city" : city};
				$.ajax({
					url : '/medzhealthweb/saveDetails',
					type: 'POST',
			        data: JSON.stringify(json),
			        cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
					success : function(response) {
						alert( response );
					},
					error : function(xhr, status, error) {
						alert(xhr.responseText);
					}
				});
				return false;
			});
		});
	
	</script>
</head>

<body>

	<h2>Medicine Store Registration</h2>
	<br>
	<br>
 	<h3>Hello : ${name}</h3>
 	<form:form id="storeForm" method="POST" commandName="store">
		<table>
			<tr>
				<td><label for="ownername">Owner Name: </label> </td>
				<td><form:input path="ownername" id="ownername"/></td>
				<td><form:errors path="ownername" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="storename">Store Name: </label> </td>
				<td><form:input path="storename" id="storename"/></td>
				<td><form:errors path="storename" cssClass="error"/></td>
		    </tr>
			
			<tr>
				<td><label for="city">City: </label> </td>
				<td><form:select path="city">
				   		<form:option value="0" label="--- Select ---"/>
				   		<form:options items="${cityList}" itemValue="id" itemLabel="cityname"/>
					</form:select>
				</td>
				<td><form:errors path="city" cssClass="error"/></td>
		    </tr>
			
			<tr>
				<td colspan="3"><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
</body>
</html>