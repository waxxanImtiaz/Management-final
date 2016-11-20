
<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%
    List<Subjects> subjects = (List<Subjects>) session.getAttribute("allSubjects");
    List<DepartAndBatches> departs = (List<DepartAndBatches>) session.getAttribute("departments");
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Add Semester Result Of Student

        <small>Control panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">





    <div class="col-md-12">

        <!-- general form elements -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Please Fill Following Fields</h3>
                <h3 class="formData"></h3>

            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form"  name="add_subject_form">



                <div class="box-body">

                    <div class="form-group">
                        <label>Department</label>
                        <select class="form-control" id="department" onchange="return getDepartmentSubjects();"    >
                            <% for (int i = 0; i < departs.size(); i++) {
                                    DepartAndBatches db = departs.get(i);
                            %>
                            <option value="<%=db.getDepart() %>" ><%= db.getDepart()%></option>
                            <% }%>
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
                        <label>Type</label>
                        <select class="form-control" id = "theoryOrPractical" >
                            <option>Thoery</option>
                            <option>Practical</option>
                        </select>
                    </div>


                    <div class="form-group">
                        <label for="rollNumber">Student Roll Number</label>
                        <input type="text" class="form-control" id="rollNumber" placeholder="Enter roll number">
                    </div>
                    <div class="form-group">
                        <label for="result">Result</label>
                        <input type="text" class="form-control" id="result" placeholder="Enter student result">
                    </div>
                    <div class="form-group">
                        <label for="batch">Batch</label>
                        <input type="text" class="form-control" id="batch" placeholder="Enter batch">
                    </div>
                    

                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return checkResultAddForm()" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>