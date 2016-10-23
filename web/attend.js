
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

//===========================DROP DOWN 

/* When the user clicks on the button,
 toggle between hiding and showing the dropdown content */
function subjects() {
    document.getElementById("subjects").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

function process(value) {
    alert("value=" + value);
}
function subjects(department) {
    
    var e = document.getElementById("subjects");
    var subject = e.options[e.selectedIndex].value;

    if(subject != "" && department != ""){
        alert(department+" system");
    
     if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        document.location = "../TeacherSubjectsAndStudentLoader?subjectName=" + subject+
                +"&department="+department+" system";
    } else {
        //alert("Teachers");
    }
    }
}
