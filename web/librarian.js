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
function checkLibrarianAddForm() {
    formFields = [document.forms["add_subject_form"]["mobileNumber"].value,
        document.forms["add_subject_form"]["email"].value,
        document.forms["add_subject_form"]["username"].value,
        document.forms["add_subject_form"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeLibrarianData();
    return false;

}

function storeLibrarianData(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertLibrarianData?mobileNumber=" + formFields[0] +
                 "&email=" + formFields[1]
                + "&username=" + formFields[2] + "&password="+formFields[ 3 ],true);
        xmlHttp.onreadystatechange = handleServerOfLibrarianInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}

function handleServerOfLibrarianInsert() {
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
function callLibrarianEditor(id){
    tId = id;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/EditLibrarian?id=" + id
                , true);
        xmlHttp.onreadystatechange = librarianEdit;
        xmlHttp.send(null);
    }
}

function librarianEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
            
            if (message) {
                $(".content-wrapper").load("content_pages/librarian/edit_librarian.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function editLibrarianForm(){
    formFields = [
        document.forms["add_subject_form"]["mobileNumber"].value,
        document.forms["add_subject_form"]["email"].value,
        document.forms["add_subject_form"]["username"].value,
        document.forms["add_subject_form"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeLibrarianUpdatedData();
    return false;
}

function storeLibrarianUpdatedData(){
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

       xmlHttp.open("GET", "/final_year_project/UpdateLibrarianData?mobileNumber=" + formFields[0] +
                 "&email=" + formFields[1]
                + "&username=" + formFields[2] + "&password="+formFields[ 3 ],true);
        xmlHttp.onreadystatechange = handleServerOfLibrarianInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
      return false;  
}
var teacherId
function deleteLibrarian(tId){
 teacherId = tId;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/DeleteLibrarian?id=" + tId
                , true);
        xmlHttp.onreadystatechange = librarianDelete;
        xmlHttp.send(null);
    }
}

function librarianDelete(){
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();



            if (message) {
                
            document.getElementById("formData").innerHTML = '<span style="color: green">Librarian\'s data deleted successfully</span>';
                 $('#sub'+teacherId).hide();
            }else{
                 document.getElementById("formData").innerHTML = '<span style="color: green">Librarian\'s data not deleted</span>';
           
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
    
}

