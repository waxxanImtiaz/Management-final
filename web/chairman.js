
$(document).ready(function () {
    $(".content-wrapper").load("/final_year_project/ChairmanLoader", function (responseTxt, statusTxt, xhr) {
    });

    $("#assign_subject").click(function () {
        $(".content-wrapper").load("/final_year_project/ChairmanLoader", function (responseTxt, statusTxt, xhr) {
        });
    });
    $("#view_subject").click(function () {
        $(".content-wrapper").load("/final_year_project/TeacherAssignedSubjectLoader", function (responseTxt, statusTxt, xhr) {
        });
    });
});

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
function checkAssignSubAddForm() {
    formFields = [document.forms["add_depart_form"]["teacherName"].value,
        document.forms["add_depart_form"]["subject"].value,
        document.forms["add_depart_form"]["semester"].value,
        document.forms["add_depart_form"]["theoryOrPractical"].value,
        document.forms["add_depart_form"]["batch"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeAssignSubject();
    return false;

}

function storeAssignSubject() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertTeacherSubject?teacherName=" + formFields[0] +
                "&subject=" + formFields[1] + "&semester=" + formFields[2]
                + "&theoryOrPractical=" + formFields[3] + "&batch=" + formFields[4],
                true);
        xmlHttp.onreadystatechange = handleServerAssignSubject;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    return false;
}

function handleServerAssignSubject() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
            alert(message);
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function callSubjectsEditor(subjectId) {
    //alert("data Loaded");
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/ChairmanSubjectEditor?id=" + subjectId
                , true);
        xmlHttp.onreadystatechange = handleServerAssignSubject;
        xmlHttp.send(null);
    }
}

var sId;
function deleteSubject(subject) {

     sId = subject;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/DeleteAssignedSubjects?id=" + sId
                , true);
        xmlHttp.onreadystatechange = subjectDelete;
        xmlHttp.send(null);
    }
}
function subjectDelete() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
             if (message) {
                 $('#'+sId).hide();
                   
            }
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

 function checkSubjectUpdateForm(id){
    
     formFields = [
        document.forms["add_subject_form"]["subject"].value,
        document.forms["add_subject_form"]["semester"].value,
        document.forms["add_subject_form"]["theoryOrPractical"].value,
        document.forms["add_subject_form"]["teacherName"].value,
        document.forms["add_subject_form"]["batch"].value,
        document.forms["add_subject_form"]["id"].value
    ];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    
    updateSubjectData();
    return false;

}//end of method
function updateSubjectData() {
    
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

         xmlHttp.open("GET", "/final_year_project/UpdateSubjectData?"+
                "subjectName=" + formFields[0] + "&semester=" + formFields[1]
                + "&theoryOrPractical=" + formFields[2] + "&teacherName=" + formFields[3] + "&batch="+ formFields[4]
                + "&id="+ formFields[5],
                true);
        xmlHttp.onreadystatechange = handleServerAssignSubject;
        xmlHttp.send(null);
    } 

}