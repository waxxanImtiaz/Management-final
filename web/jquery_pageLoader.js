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
    
     $("#add_result").click(function () {
        $(".content-wrapper").load("/final_year_project/SubjectsAndDepartLoader", function (responseTxt, statusTxt, xhr) {
        });   
    });
     $("#add_batch").click(function () {
        $(".content-wrapper").load("content_pages/batch_and_depart_pages/add_depart_batch.jsp", function (responseTxt, statusTxt, xhr) {
        });   
    });
     $("#view_batch").click(function () {
        $(".content-wrapper").load("/final_year_project/AllBatchLoader", function (responseTxt, statusTxt, xhr) {
        });   
    });
     $("#view_result").click(function () {
        $(".content-wrapper").load("/final_year_project/AllResultLoader", function (responseTxt, statusTxt, xhr) {
        });   
    });
});



