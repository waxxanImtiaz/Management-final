
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
function checkBatchDepartAddForm() {
    formFields = [document.forms["add_depart_form"]["department"].value,
        document.forms["add_depart_form"]["batch"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeBatchData();
    return false;

}

function storeBatchData() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertBatchData?department=" + formFields[0] +
                "&batchName=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerOfBatchInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    return false;
}

function handleServerOfBatchInsert() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();


            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';
//              alert(message);           


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}


function callBatchEditor(batch) {
    //alert("data Loaded");
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/BatchEditor?batch=" + batch
                , true);
        xmlHttp.onreadystatechange = batchEdit;
        xmlHttp.send(null);
    }
}

function batchEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            if (message) {
                $(".content-wrapper").load("content_pages/batch_and_depart_pages/edit_depart_batch.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }

        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function validateEditBatchForm(){
     formFields = [document.forms["add_batch_form"]["department"].value,
        document.forms["add_batch_form"]["batch"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    updateBatchData();
    return false;
}
function updateBatchData(){
   if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

          xmlHttp.open("GET", "/final_year_project/UpdateBatchData?department=" + formFields[0] +
                "&batchName=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerResponseUpdateBatch;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }

}

function handleServerResponseUpdateBatch() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

               
             // if(message)
                alert(message);           
           
                  
        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
} 

var dd;
function deleteBatch(batch){

     dd = batch;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/BatchDelete?batch=" +dd
                , true);
        xmlHttp.onreadystatechange = batchDelete;
        xmlHttp.send(null);
    }
}

function batchDelete(){
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';


            if (message) {
                 $('#'+dd).hide();
                   
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}
