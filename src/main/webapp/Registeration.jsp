<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset-UTF-8">
<title>Registeration page</title>
<script type="text/javascript">
function validateUserName() {
	var name=document.getElementById('name').value;
	if(name.length<2){
		alert("name should have atleast one char")
		return false;
	}else{
		return true;
	}
}

</script>
</head>
<body bgcolor="gray" font-color="red">
	<form action="register" modelattribute="register" method="post">
		<h1>${message }</h1>
		<h1>${error_message }</h1>
		<div align="center"></div>
		<table>
			<tr>
				<td align='center'>Name:</td>
				<td><input type='text' name="name"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Sur_Name:</td>
				<td><input type='text' name="surName"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Date Of Birth:</td>
				<td><input type='text' name="dateOfBirth"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Address:</td>
				<td><input type='text' name="address"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Phone:</td>
				<td><input type='text' name="phoneNo"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Email:</td>
				<td><input type='text' name="email"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align='center'>Zip:</td>
				<td><input type='text' name="zip"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<table border='0' cellpadding='0' cellspacing='0' width='480px'
				align='center'>
				<tr>
					<td align='center'><input type='submit' name='REGISTER'
						value="register"></td>
				</tr>
			</table>
			</form>
</body>
</html>