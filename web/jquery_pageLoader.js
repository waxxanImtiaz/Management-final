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
        $(".content-wrapper").load("/final_year_project/AllSubjectsLoader", function (responseTxt, statusTxt, xhr) {
        });
    });
    $("#matric").click(function () {
        $(".content-wrapper").load("content_pages/add_subject.jsp", function (responseTxt, statusTxt, xhr) {
        });
    });
});



