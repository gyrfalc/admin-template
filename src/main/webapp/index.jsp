<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	
	<script type="text/javascript">
		function fakeit() {
			window.location = 'home';
		}
	
	</script>
	
</head>
<body>
	<div class="login-container">
		<div class="login">
		
			<h3>Please log in.</h3>
		
			<ul>
				<li><label>User Id</label><input type="text"/>
				<li><label>Password</label><input type="password"/>
			</ul>
			
			<h3 style="text-align:right; width: 300px; margin: 0 auto;"><input type="submit" onclick="fakeit()" value="Login"/></h3>
		
		</div>
	</div>
</body>
</html>