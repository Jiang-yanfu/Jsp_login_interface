function checkPassword(e)
{
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value;
	if (password1 != password2)
	{
		document.getElementById("error").innerHTML = "Please make sure your passwords are the same";
		e.preventDefault();
	}
	else
	{
		document.form[0].submit();
	}
}
window.onload = function(){
	document.getElementById("form").onsubmit = checkPassword;
};