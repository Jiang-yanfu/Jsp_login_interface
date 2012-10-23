function createRequest()
{
	var ajax;
	if(window.XMLHttpRequest)
	{
		ajax = new XMLHttpRequest();
	}
	else
	{
		ajax = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return ajax;
}
function sendRequest(e)
{
	e.preventDefault();
 	var evt = e ? e:event;
 	var elem = "";
 	if (evt.srcElement)  elem = evt.srcElement.toString();
 	else if (evt.target) elem = evt.target.toString();
 	var id_index = elem.indexOf("?");
 	var id = elem.substring(id_index + 1);
	var request = createRequest();
	request.open("GET", "Delete?id=" + id, true);
	request.send(null);
	request.onreadystatechange = function() {//Call a function when the state changes.
	if(request.readyState == 4 && request.status == 200) {
		if(request.responseText == "success")
		{
			 window.location = location.href;
		}
	}
}
}
window.onload=function()
{
	var a_link = document.getElementsByTagName("a");
	for(var i = 0; i < a_link.length - 1; i++)
	{
		console.dir(a_link[i]);
		a_link[i].onclick = sendRequest;
	}
}