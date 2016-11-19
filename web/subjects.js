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
function checkSubjectAddForm() {
    formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["subjectName"].value,
        document.forms["add_subject_form"]["semester"].value,
        document.forms["add_subject_form"]["theoryOrPractical"].value,
        document.forms["add_subject_form"]["creditHours"].value,
        document.forms["add_subject_form"]["totalLectures"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeSubjectData();
    return false;

}

function storeSubjectData(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertSubjectData?department=" + formFields[0] +
                "&subjectName=" + formFields[1] + "&semester=" + formFields[2]
                + "&theoryOrPractical=" + formFields[3] + "&creditHours=" + formFields[4] + "&totalLectures="+ formFields[5],
                true);
        xmlHttp.onreadystatechange = handleServerResponseOfIssuanceForm;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}



function handleServerResponseOfIssuanceForm() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';

           // alert("Data Stored Successfully");
                  
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}


function callSubjectEditor(subjectId) {
    //alert("data Loaded");
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/SubjectEditor?subjectId=" + subjectId
                , true);
        xmlHttp.onreadystatechange = subjectEdit;
        xmlHttp.send(null);
    }
}

function subjectEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

//            document.getElementById("formData").innerHTML = '<span style="color: green">'
//                    + message + '</span>';

            
            if (message) {
                $(".content-wrapper").load("content_pages/edit_subject.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}


var sId;
function deleteSubject(subject) {

     sId = subject;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/SubjectDelete?subjectId=" + sId
                , true);
        xmlHttp.onreadystatechange = subjectDelete;
        xmlHttp.send(null);
    }
}

function subjectDelete(){
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';

            if (message) {
                 $('#sub'+id).hide();
                   
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
    
}



//librarian form validator
function validateEditSubjectForm() {
    
    
     formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["subjectName"].value,
        document.forms["add_subject_form"]["semester"].value,
        document.forms["add_subject_form"]["theoryOrPractical"].value,
        document.forms["add_subject_form"]["creditHours"].value,
        document.forms["add_subject_form"]["totalLectures"].value];

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

         xmlHttp.open("GET", "/final_year_project/UpdateSubjectData?department=" + formFields[0] +
                "&subjectName=" + formFields[1] + "&semester=" + formFields[2]
                + "&theoryOrPractical=" + formFields[3] + "&creditHours=" + formFields[4] + "&totalLectures="+ formFields[5],
                true);
        xmlHttp.onreadystatechange = handleServerResponseOfIssuanceForm;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }

}
