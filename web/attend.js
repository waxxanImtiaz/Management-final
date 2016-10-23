
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

function teacherAttendance(clicked_id) {

    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        xmlHttp.open("GET", "../TeacherAttendanceHandler?rollNumber=" + clicked_id, true);
        xmlHttp.onreadystatechange = handleAttendanceResponse;
        xmlHttp.send(null);
    } else {
        //alert("Teachers");
     }
}

function handleAttendanceResponse() {


    if (xmlHttp.readyState == 4) {

        try {
            
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
            alert(message);
            setTimeout('process()', 1000);

        } catch (e) {
            alert(e.toString());
        }
    } else {
        setTimeout('process()', 1000);
    }
}