
//if student is in first semester
function isFirstSemester(){
//    var semesterValue = document.getElementById("semesterOne").textContent;
//    alert(semesterValue);
    //alert("is first semester is called");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText;
            alert(data);
        }
    }
    xhr.open('POST', '/SemesterChecker', true);
    xhr.send("firstSemester");
    
}