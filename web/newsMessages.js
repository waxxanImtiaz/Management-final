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
var department;
var news;
function sendNews() {
    department = document.getElementById("department").value;
    news = document.getElementById("news").value;
    

    if(news == "Write news Here" || news == ""){
        alert("Please write news first");
        return false;
    }
    
    storeNews();
    return false;

}

function storeNews(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/SendNews?department=" + department +
                "&news=" + news ,true);
        xmlHttp.onreadystatechange = handleServerOfNewsSend;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}

function handleServerOfNewsSend() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

                
//            document.getElementById("formData").innerHTML = '<span style="color: green">'
//                    + message + '</span>';
              alert(message);           
           
                  
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

var message;
var to;
function sendMess(){
    
     message = document.forms["message_form"]["message"].value;
     to = document.forms["message_form"]["to"].value;
    
    if(message == "Write Message Here" || message == ""){
        alert("Please write message first");
        return false;
    }
    storeMessage();
    return false;
}

function storeMessage(){
     if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/SendMessage?to=" + to +
                "&message=" + message ,true);
        xmlHttp.onreadystatechange = handleServerOfNewsSend;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}