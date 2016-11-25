

<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%
    List<Subjects> subjects = (List<Subjects>) session.getAttribute("allSubjects");
    List<Teacher> teachers = (List<Teacher>) session.getAttribute("departTeachers");
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Assign Subject To Teacher

        
    </h1>

</section>

<!-- Main content -->
<section class="content">





    <div class="col-md-12">

        <!-- general form elements -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Please Fill Following Fields</h3>
                <h5 id="formData"></h5>

            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form"  name="add_depart_form">
                <div class="box-body">
                    <div class="form-group">
                        <label for="teacherName">Select Teacher Name</label>
                        <select class="form-control" id="teacherName"    >
                            <% for (int i = 0; i < teachers.size(); i++) {
                                    Teacher db = teachers.get(i);
                            %>
                            <option><%= db.getName() %></option>
                            <% }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Semester</label>
                        <select class="form-control" id = "semester" >
                            <option>1st</option>
                            <option>2nd</option>
                            <option>3rd</option>
                            <option>4th</option>
                            <option>5th</option>
                            <option>6th</option>
                            <option>7th</option>
                            <option>8th</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Subject</label>
                        <select class="form-control" id = "subject" >
                            <% for (Subjects s : subjects) {%>
                            <option ><%= s.getSubjectName()%></option>
                            <% }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Type</label>
                        <select class="form-control" id = "theoryOrPractical" >
                            <option>Thoery</option>
                            <option>Practical</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="batch">Batch</label>
                        <input type="text" class="form-control" id="batch" placeholder="Enter batch">
                    </div>
                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return checkAssignSubAddForm()" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>