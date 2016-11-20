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
function checkTeacherAddForm() {
    formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["name"].value,
        document.forms["add_subject_form"]["email"].value,
        document.forms["add_subject_form"]["username"].value,
        document.forms["add_subject_form"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeTeacherData();
    return false;

}

function storeTeacherData(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertTeacherData?department=" + formFields[0] +
                "&name=" + formFields[1] + "&email=" + formFields[2]
                + "&username=" + formFields[3] + "&password="+formFields[ 4 ],true);
        xmlHttp.onreadystatechange = handleServerOfTeacherInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}

function handleServerOfTeacherInsert() {
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
var tId;
function callTeacherEditor(id){
    tId = id;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/EditTeacher?id=" + id
                , true);
        xmlHttp.onreadystatechange = teacherEdit;
        xmlHttp.send(null);
    }
}

function teacherEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
            
            if (message) {
                $(".content-wrapper").load("content_pages/teacher/edit_teacher.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function editTeacherForm(){
    formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["name"].value,
        document.forms["add_subject_form"]["email"].value,
        document.forms["add_subject_form"]["username"].value,
        document.forms["add_subject_form"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeTeacherUpdatedData();
    return false;
}

function storeTeacherUpdatedData(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/UpdateTeacherData?department=" + formFields[0] +
                "&name=" + formFields[1] + "&email=" + formFields[2]
                + "&username=" + formFields[3] + "&password="+formFields[ 4 ],true);
        xmlHttp.onreadystatechange = handleServerOfTeacherInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}