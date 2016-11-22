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
function checkMasterAddForm() {
    formFields = [document.forms["add_depart_form"]["department"].value,
        document.forms["add_depart_form"]["password"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeMasterData();
    return false;

}

function storeMasterData() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertMasterData?department=" + formFields[0] +
                "&password=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerOfMasterInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    return false;
}

function handleServerOfMasterInsert() {
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


function callMasterEditor(depart) {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/MasterEditor?department=" + depart
                , true);
        xmlHttp.onreadystatechange = masterEdit;
        xmlHttp.send(null);
    }
}

function masterEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            if (message) {
                $(".content-wrapper").load("content_pages/master/edit_master.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }

        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function validateEditMasterForm(){
     formFields = [document.forms["add_batch_form"]["department"].value,
        document.forms["add_batch_form"]["password"].value];

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

          xmlHttp.open("GET", "/final_year_project/UpdateMasterData?department=" + formFields[0] +
                "&password=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerResponseUpdateMaster;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }

}

function handleServerResponseUpdateMaster() {
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
function deleteMaster(id){

     dd = id;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/MasterDelete?department=" +dd
                , true);
        xmlHttp.onreadystatechange = masterDelete;
        xmlHttp.send(null);
    }
}

function masterDelete(){
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
