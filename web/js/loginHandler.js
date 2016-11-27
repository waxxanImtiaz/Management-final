var xmlHttp = createXmlHttpRequestObject();

function createXmlHttpRequestObject() {
    var xmlHttp;
    try {
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        xmlHttp = false;
    }
    if (!xmlHttp)
    {
        alert("Cant create object! Browser not support ");
    } else
        return xmlHttp;

}
var formFields;
function checkLoginForm() {
    formFields = [document.forms["loginform"]["username"].value,
        document.forms["loginform"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    sendToServer();
    return false;

}


function sendToServer(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/Checker?username=" + formFields[0] +
                "&password="+formFields[1],
                true);
        xmlHttp.onreadystatechange = handlerLoginResponse;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}

function handlerLoginResponse() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

//              if(message)  
//                alert("Invalid Username or Password! Please Try Again");           
                alert(message);           
           
                  
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}
