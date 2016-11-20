
<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%

    List<DepartAndBatches> departs = (List<DepartAndBatches>) session.getAttribute("allDeparts");
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Add New Teacher

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
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" placeholder="Enter name">
                    </div>
                    
                    
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password">
                    </div>
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

                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return checkTeacherAddForm()" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>