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

function readComplain(id){
   
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