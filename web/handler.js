//complaint form validator
function validateForm() {
    var rollNumber = document.forms["complainForm"]["rollNumber"].value;
    var name = document.forms["complainForm"]["name"].value;
    var complaintField = document.forms["complainForm"]["complaint"].value;
    if (rollNumber == null || rollNumber == "") {
        alert("Roll Number must be filled out");
        return false;
    } else if (name == null || name == "")
    {
        alert("Name must be filled out");
        return false;
    } else if (complaintField == null || complaintField == "") {
        alert("Please fill Complaint/Help field first");
        return false;
    }

    process();
}//end of method


//handling complaint form

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

function process() {
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        name = encodeURIComponent(document.getElementById("name").value);
        rollNumber = encodeURIComponent(document.getElementById("rollNumber").value);
        complain = encodeURIComponent(document.getElementById("complaint").value);

        xmlHttp.open("GET", "../ComplaintHandler?name=" + name + "&rollNumber=" + rollNumber
                + "&complain=" + complain, true);
        xmlHttp.onreadystatechange = handleServerResponse;
        xmlHttp.send(null);
    } else {
        // setTimeout('process()', 1000);
    }
}

function handleServerResponse() {

    if (xmlHttp.readyState == 4) {

        try {
            //if (xmlHttp.status == 200) {
            xmlResponse = xmlHttp.responseText;
            //xmlDocumentElement = xmlResponse.documentElement;
            var message = xmlResponse.toString();

//                document.getElementById("serverOutput").innerHTML = '<span style="color: green">'
//                        + message + '</span>';

            if (message == "true") {
                alert("Complain sent successfully!");
            }
//                }
            setTimeout('process()', 1000);
            //}
        } catch (e) {
            alert(e.toString());
        }
//        }
    } else {
        //alert("Ooops!! Something went wrong!"+xmlHttp.readyState);
        setTimeout('process()', 1000);
    }
}


function checkBookData() {
    
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        rollNumber = encodeURIComponent(document.getElementById("rollNumber").value);
        bookAuthor = encodeURIComponent(document.getElementById("bookAuthor").value);
        bookName = encodeURIComponent(document.getElementById("bookName").value);
        bookIssueDate = encodeURIComponent(document.getElementById("bookIssueDate").value);
        bookReturnDate = encodeURIComponent(document.getElementById("bookReturnDate").value);
        name = encodeURIComponent(document.getElementById("name").value);
        department = encodeURIComponent(document.getElementById("department").value);

        xmlHttp.open("GET", "../BookChecker?rollNumber=" + rollNumber
                + "&bookAuthor=" + bookAuthor + "&bookName=" + bookName
                + "&department=" + department + "&name=" + name
                + "&bookIssueDate=" + bookIssueDate + "&bookReturnDate=" + bookReturnDate
        , true);
        xmlHttp.onreadystatechange = handleTestServletResponse;
        xmlHttp.send(null);
    } else {
        setTimeout('checkBookData()', 1000);
    }
}

function handleTestServletResponse() {
    if (xmlHttp.readyState == 4) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("serverResponse").innerHTML = '<span style="color: green">'
                    + message + '</span>';

            setTimeout('checkBookData()', 1000);
            //}
        } catch (e) {
            alert(e.toString());
        }
    }
}

//librarian form validator
function validateLibrarianForm() {
    var rollNumber = document.forms["librarianForm"]["rollNumber"].value;
    var name = document.forms["librarianForm"]["name"].value;
    var department = document.forms["librarianForm"]["department"].value;
    var bookIssueDate = document.forms["librarianForm"]["bookIssueDate"].value;
    var bookReturnDate = document.forms["librarianForm"]["bookReturnDate"].value;
    var bookAuthor = document.forms["librarianForm"]["bookAuthor"].value;
    var bookName = document.forms["librarianForm"]["bookName"].value;
    
    
    if (rollNumber == null || rollNumber == "") {
        alert("Roll Number must be filled out");
        return false;
    } else if (name == null || name == "")
    {
        alert("Name must be filled out");
        return false;
    } else if (bookAuthor == null || bookAuthor == "") {
        alert("Please insert Book Author!");
        return false;
    } else if (department == null || department == "") {
        alert("Please insert Department");
        return false;
    } else if (bookName == null || bookName == "") {
        alert("Please fill bookName field!");
        return false;
    } else if (bookIssueDate == null || bookIssueDate == "") {
        alert("Please Insert Date of Issuance!");
        return false;
    } else if (bookReturnDate == null || bookReturnDate == "") {
        alert("Please insert Date of Returning!");
        return false;
    }
    
    
   storeLibraryIssuanceFormData();
}//end of method


//======================BOOK ISSUE FORM DATA===================
function storeLibraryIssuanceFormData(){

    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        rollNumber = encodeURIComponent(document.getElementById("rollNumber").value);
        bookAuthor = encodeURIComponent(document.getElementById("bookAuthor").value);
        bookName = encodeURIComponent(document.getElementById("bookName").value);
        bookIssueDate = encodeURIComponent(document.getElementById("bookIssueDate").value);
        bookReturnDate = encodeURIComponent(document.getElementById("bookReturnDate").value);
        name = encodeURIComponent(document.getElementById("name").value);
        department = encodeURIComponent(document.getElementById("department").value);

        xmlHttp.open("GET", "../StoreBookIssueFormData?rollNumber=" + rollNumber
                + "&bookAuthor=" + bookAuthor + "&bookName=" + bookName
                + "&department=" + department + "&name=" + name
                + "&bookIssueDate=" + bookIssueDate + "&bookReturnDate=" + bookReturnDate
        , true);
        xmlHttp.onreadystatechange = handleServerResponseOfIssuanceForm;
        xmlHttp.send(null);
    } else{
        //setTimeout('storeLibraryIssuanceFormData()', 1000);
    }
}


function handleServerResponseOfIssuanceForm() {
    if (xmlHttp.readyState == 4) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';
             //if(message == 'true'){
                 alert('Book Issued Successfully!');
             //}       
          //  setTimeout('storeLibraryIssuanceFormData()', 1000);
            //}
        } catch (e) {
            alert(e.toString());
        }
    }
}