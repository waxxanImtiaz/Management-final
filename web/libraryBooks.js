
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
function checkBookAddForm() {
    formFields = [document.forms["add_depart_form"]["bookName"].value,
        document.forms["add_depart_form"]["bookAuthor"].value];

    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }
    storeBookData();
    return false;

}

function storeBookData() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/InsertBookData?bookName=" + formFields[0] +
                "&bookAuthor=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerOfBookInsert;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }
    return false;
}

function handleServerOfBookInsert() {
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


function callBookEditor(bookId) {
    //alert("data Loaded");
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/BookEditor?bookId=" + bookId
                , true);
        xmlHttp.onreadystatechange = bookEdit;
        xmlHttp.send(null);
    }
}

function bookEdit() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            if (message) {
                $(".content-wrapper").load("content_pages/librarybooks/edit_librarybooks.jsp", function (responseTxt, statusTxt, xhr) {
                });
            }

        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

function validateEditBookForm(){
     formFields = [document.forms["add_batch_form"]["bookName"].value,
        document.forms["add_batch_form"]["bookAuthor"].value];

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

          xmlHttp.open("GET", "/final_year_project/UpdateBookData?bookName=" + formFields[0] +
                "&bookAuthor=" + formFields[1], true);
        xmlHttp.onreadystatechange = handleServerResponseUpdateBook;
        xmlHttp.send(null);
    } else {
        // setTimeout('storeStudentData()', 1000);

    }

}

function handleServerResponseUpdateBook() {
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
function deleteBook(book){

     dd = book;
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {

        xmlHttp.open("GET", "/final_year_project/BookDelete?id=" +dd
                , true);
        xmlHttp.onreadystatechange = bookDelete;
        xmlHttp.send(null);
    }
}

function bookDelete(){
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
