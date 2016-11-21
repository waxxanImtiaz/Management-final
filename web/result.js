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


function getDepartmentSubjects() {

//alert("id=" + id);
    var selectBox = document.getElementById("department");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;


    xmlHttp.open("GET", "/final_year_project/SubjectLoader?department=" + selectedValue
            , true);
    xmlHttp.onreadystatechange = handleServerGetDepartment;
    xmlHttp.send(null);
    return false;
}

function handleServerGetDepartment() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

//            document.getElementById("formData").innerHTML = '<span style="color: green">'
//                    + message + '</span>';
            var select = document.getElementById("subject");
            //if(message){
            if (message) {

                // Optional: Clear all existing options first:
                select.innerHTML = "";
                var json = JSON.parse(message);


                // var count = Object.keys(json).length;

                var flag = true;
                for (var key in json) {
                    if (json[key] != null) {
                        flag = false;
                        select.innerHTML += "<option value=\"" + json[key] + "\">" + json[key] + "</option>";
                    }
                }
                if (flag) {
                    select.innerHTML += "<option value=\"" + 0 + "\">No subject found</option>";

                }

            } else {
                alert("Subjects not found");
            }




            // }
            //  }else{
            //  select.innerHTML += "<option value=\"" + opt + "\">Not found</option>";
            //}

        } catch (e) {
            // alert("exception=" + e.toString());
        }
    }
}

var formFields;
function checkResultAddForm() {
    
    formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["subject"].value,
        document.forms["add_subject_form"]["semester"].value,
        document.forms["add_subject_form"]["theoryOrPractical"].value,
        document.forms["add_subject_form"]["rollNumber"].value,
        document.forms["add_subject_form"]["batch"].value,
        document.forms["add_subject_form"]["result"].value];
    
    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    //alert("inside storeResultData");
    storeData();
    return false;

}

function storeData() {
    
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertResultData?department=" + formFields[0] +
                "&subjectName=" + formFields[1] + "&semester=" + formFields[2]
                + "&theoryOrPractical=" + formFields[3] + "&rollNumber=" + formFields[4]
                + "&batch=" + formFields[5] + "&result=" + formFields[6],
                true);
        xmlHttp.onreadystatechange = handleServerOfIns;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    
    return false;
}

function handleServerOfIns() {
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
var rowId;
function callResultEditor(rId){
    
   rowId = rId;
  //alert("data Loaded");
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/ResultEditor?id=" + rId, true);
        xmlHttp.onreadystatechange = resultEdit;
        xmlHttp.send(null);
    }
}

function resultEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();
                
            if (message) {
              
                $(".content-wrapper").load("content_pages/result_pages/edit_result.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }

        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function deleteResult(id){
  
    rowId = id;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/ResultDelete?id=" +id
                , true);
        xmlHttp.onreadystatechange = resultDelete;
        xmlHttp.send(null);
    }
}

function resultDelete(){
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';


            if (message) {
                 $('#'+rowId).hide();
                   
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}
var id;
function checkResultUpdateForm(rId){

    id = rId;
    
 formFields = [document.forms["add_subject_form"]["department"].value,
        document.forms["add_subject_form"]["subject"].value,
        document.forms["add_subject_form"]["semester"].value,
        document.forms["add_subject_form"]["theoryOrPractical"].value,
        document.forms["add_subject_form"]["rollNumber"].value,
        document.forms["add_subject_form"]["batch"].value,
        document.forms["add_subject_form"]["result"].value
        
    ];
    
    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeResultData();
    return false;

}

function storeResultData() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/UpdateResultData?department=" + formFields[0] +
                "&subjectName=" + formFields[1] + "&semester=" + formFields[2]
                + "&theoryOrPractical=" + formFields[3] + "&rollNumber=" + formFields[4]
                + "&batch=" + formFields[5] + "&result=" + formFields[6]+"&id=" + id,
                true);
        xmlHttp.onreadystatechange = handleServerOfIns;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    return false;
}
