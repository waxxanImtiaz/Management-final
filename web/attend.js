function teacherAttendance(clicked_id){
  if (xmlHttp.readyState == 0 || xmlHttp.readyState == 4) {
      
        xmlHttp.open("GET", "../ComplaintHandler?name=" + name + "&rollNumber=" + rollNumber
                + "&complain=" + complain, true);
        xmlHttp.onreadystatechange = handleServerResponse;
        xmlHttp.send(null);
    } else {
        // setTimeout('process()', 1000);
    }  
}

