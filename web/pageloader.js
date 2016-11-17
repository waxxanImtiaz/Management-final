
$(document).ready(function () {
    $(".content-wrapper").load("content_pages/add_student.jsp", function (responseTxt, statusTxt, xhr) {
    });
    $("#add_student").click(function () {
        $(".content-wrapper").load("content_pages/add_student.jsp", function (responseTxt, statusTxt, xhr) {
        });
    });
    $("#view_students").click(function () {
        $(".content-wrapper").load("/final_year_project/AllStudentLoader", function (responseTxt, statusTxt, xhr) {
        });
    });

///student_list.jsp
    $("#m").click(function () {
        $(".content-wrapper").load("content_pages/messages.jsp", function (responseTxt, statusTxt, xhr) {
        });
    });
    $("#inter").click(function () {
        $(".content-wrapper").load("content_pages/intermediate.jsp", function (responseTxt, statusTxt, xhr) {
        });
    });
    $("#matric").click(function () {
        $(".content-wrapper").load("content_pages/matric.jsp", function (responseTxt, statusTxt, xhr) {
        });
    });
});




var formFields;
//librarian form validator
function validateAddStudentForm() {
    //alert("Roll Number must be filled out");
    var formFields = [document.forms["add_student_form"]["student_name"].value,
        document.forms["add_student_form"]["rollNumber"].value,
        document.forms["add_student_form"]["department"].value,
        document.forms["add_student_form"]["fatherName"].value,
        document.forms["add_student_form"]["batch"].value,
        document.forms["add_student_form"]["dob"].value,
        document.forms["add_student_form"]["caste"].value,
        document.forms["add_student_form"]["address"].value,
        document.forms["add_student_form"]["perm_address"].value,
        document.forms["add_student_form"]["nic"].value,
        document.forms["add_student_form"]["gender"].value,
        document.forms["add_student_form"]["father_contact"].value,
        document.forms["add_student_form"]["student_contact_num"].value,
        document.forms["add_student_form"]["email"].value,
        document.forms["add_student_form"]["password"].value
    ];


    for (var i = 0; i < formFields.length; i++) {
        if (formFields[i] == null || formFields[i] == "") {
            alert("Please Fill All Fields");
            return false;
        }
    }

    mob = document.forms["add_student_form"]["student_contact_num"].value;
    if (!isMobileNumber(mob)) {
        alert("Invalid mobile number");
        return false;
    }

    
    mob = document.forms["add_student_form"]["father_contact"].value;
    if (!isMobileNumber(mob)) {
        alert("Invalid mobile number");
        return false;
    }
    nic = document.forms["add_student_form"]["nic"].value;
    if (!validateNic(nic)) {
        alert("Please Insert 14 Digits NIC Number");
        return false;
    }

    var email = document.forms["add_student_form"]["email"].value

    if (!validateEmail(email)) {
        alert("Please Insert a valid email address");
        return false;
    }

    var dob = document.forms["add_student_form"]["dob"].value;
    if (!validateDob(dob)) {
        alert("Please insert correct date formate mm/dd/yyyy");
        return false;
    }


    storeStudentData();
    //return true;

}//end of method

function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
function validateDob(dob) {
    var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
    if ((date_regex.test(dob)))
    {
        return false;
    } else
        return true;
}

function isMobileNumber(txtMob) {
    var mob = /^[0-9]{1}[0-9]{10}$/;
    if (!mob.test(txtMob)) {
        return false;
    }
    return true;
}

function validateNic(nic) {
    var n = /^[1-9]{3}[0-9]{10}$/;
    if (!n.test(nic)) {
        return false;
    }
    return true;
}



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

function storeStudentData(){
     var formFields = [document.forms["add_student_form"]["student_name"].value,
        document.forms["add_student_form"]["rollNumber"].value,
        document.forms["add_student_form"]["department"].value,
        document.forms["add_student_form"]["fatherName"].value,
        document.forms["add_student_form"]["batch"].value,
        document.forms["add_student_form"]["dob"].value,
        document.forms["add_student_form"]["caste"].value,
        document.forms["add_student_form"]["address"].value,
        document.forms["add_student_form"]["perm_address"].value,
        document.forms["add_student_form"]["nic"].value,
        document.forms["add_student_form"]["gender"].value,
        document.forms["add_student_form"]["father_contact"].value,
        document.forms["add_student_form"]["student_contact_num"].value,
        document.forms["add_student_form"]["email"].value,
        document.forms["add_student_form"]["password"].value];
    
//     for (var i = 0; i < formFields.length; i++) {
//        //if (formFields[i] == null || formFields[i] == "") {
//            alert(formFields[i]);
//           // return false;
//        //}
//    }
    
     if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
        
        xmlHttp.open("GET", "/final_year_project/InsertStudentServlet?student_name="+formFields[0]+
                "&rollNumber="+formFields[1]+"&department="+formFields[2]
        +"&fatherName="+formFields[3]+"&batch="+formFields[4]+"&dob="+formFields[5]
        +"&caste="+formFields[6]+"&address="+formFields[7]+"&perm_address="+formFields[8]
        +"&nic="+formFields[9]+"&gender="+formFields[10]+"&father_contact="+formFields[11]
        +"&student_contact_num="+formFields[12]+"&email="+formFields[13]+"&password="+formFields[14]
        , true);
        xmlHttp.onreadystatechange = handleServerResponseOfIssuanceForm;
        xmlHttp.send(null);
    } else{
       // setTimeout('storeStudentData()', 1000);
        
    }
    
}

function handleServerResponseOfIssuanceForm() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0 ) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            document.getElementById("formData").innerHTML = '<span style="color: green">'
                    + message + '</span>';

                 //alert(message);
              
        } catch (e) {
            alert("exception="+e.toString());
        }
    }
}


function checkStudentData() {
   // alert("inside checkStudentData()");
  
    if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
         //alert(document.forms["add_student_form"]["student_name"].value);
         
    var formFields = [document.forms["add_student_form"]["student_name"].value,
        document.forms["add_student_form"]["rollNumber"].value,
        document.forms["add_student_form"]["department"].value,
        document.forms["add_student_form"]["fatherName"].value,
        document.forms["add_student_form"]["batch"].value,
        document.forms["add_student_form"]["dob"].value,
        document.forms["add_student_form"]["caste"].value,
        document.forms["add_student_form"]["address"].value,
        document.forms["add_student_form"]["perm_address"].value,
        document.forms["add_student_form"]["nic"].value,
        document.forms["add_student_form"]["gender"].value,
         document.forms["add_student_form"]["father_contact"].value,
        document.forms["add_student_form"]["student_contact_num"].value,
        document.forms["add_student_form"]["email"].value,
        document.forms["add_student_form"]["password"].value];
    
        
        xmlHttp.open("GET", "/final_year_project/InsertStudentServlet?student_name="+formFields[0]+
                "&rollNumber="+formFields[1]+"&department="+formFields[2]
        +"&fatherName="+formFields[3]+"&batch="+formFields[4]+"&dob="+formFields[5]
        +"&caste="+formFields[6]+"&address="+formFields[7]+"&perm_address="+formFields[8]
        +"&nic="+formFields[9]+"&gender="+formFields[10]+"&father_contact="+formFields[11]
        +"&student_contact_num="+formFields[12]+"&email="+formFields[13]+"&password="+formFields[14]
        , true);
         xmlHttp.onreadystatechange = handleServerResponseOfIssuanceForm;
        xmlHttp.send(null);
        
    } else {
        setTimeout('checkStudentData()', 1000);
    }
}