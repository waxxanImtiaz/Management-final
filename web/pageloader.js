  
    $(document).ready(function(){
       $(".content-wrapper").load("content_pages/add_student.jsp", function(responseTxt, statusTxt, xhr){
        });
    $("#add_student").click(function(){
        $(".content-wrapper").load("content_pages/add_student.jsp", function(responseTxt, statusTxt, xhr){
        });
    });
    $("#view_students").click(function(){
        $(".content-wrapper").load("content_pages/student_list.jsp", function(responseTxt, statusTxt, xhr){
        });
    });
   
    $("#m").click(function(){
        $(".content-wrapper").load("content_pages/messages.jsp", function(responseTxt, statusTxt, xhr){
        });
    });
    $("#inter").click(function(){
        $(".content-wrapper").load("content_pages/intermediate.jsp", function(responseTxt, statusTxt, xhr){
        });
    });
    $("#matric").click(function(){
        $(".content-wrapper").load("content_pages/matric.jsp", function(responseTxt, statusTxt, xhr){
        });
    });
    });

