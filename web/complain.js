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

function readComplain(id) {

    xmlHttp.open("GET", "/final_year_project/ReadComplainLoader?id=" + id
            , true);
    xmlHttp.onreadystatechange = handleServerGetComplain;
    xmlHttp.send(null);
    return false;
}


function handleServerGetComplain() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            if (message) {
                $(".content-wrapper").load("content_pages/complains/complains.jsp", function (responseTxt, statusTxt, xhr) {
                });
            } else {
                alert("Complain is deleted");
            }

        } catch (e) {
            // alert("exception=" + e.toString());
        }
    }
}

var complainId;
function deleteComplain(id) {
    complainId = id;

    xmlHttp.open("GET", "/final_year_project/DeleteComplain?id=" + id
            , true);
    xmlHttp.onreadystatechange = handleServerDeleteComplain;
    xmlHttp.send(null);
    return false;
}

jQuery("complainContent").ready(
        function () {
            refreshPage();
        }
);
function refreshPage() {
//    setInterval(function ()
//    {
        $(".content-wrapper").load("/final_year_project/ComplainLoader", function (responseTxt, statusTxt, xhr) {
        });
//    }, 3000);

}

function deleteButton(id) {
    complainId = id;

    xmlHttp.open("GET", "/final_year_project/DeleteComplain?id=" + id
            , true);
    xmlHttp.onreadystatechange = handleServerDeleteComplain;
    xmlHttp.send(null);
    return false;
}
function handleServerDeleteComplain() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0) {

        try {
            xmlResponse = xmlHttp.responseText;
            var message = xmlResponse.toString();

            if (message) {
                alert("Complain deleted succesfully");
                $(".content-wrapper").load("/final_year_project/ComplainLoader", function (responseTxt, statusTxt, xhr) {
                });
            }


        } catch (e) {
            alert("exception=" + e.toString());
        }
    }
}

