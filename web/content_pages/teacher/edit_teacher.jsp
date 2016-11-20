
<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%
    Teacher teacher = (Teacher) session.getAttribute("editTeacher");
    List<DepartAndBatches> departs = (List<DepartAndBatches>) session.getAttribute("allDeparts");
 %>
<section class="content-header">
    <h1>
        Update Teacher's Data

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
                        <input type="text" class="form-control" value ="<%=teacher.getName() %>" id="name" placeholder="Enter name">
                    </div>
                    
                    
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" value ="<%=teacher.getEmail() %>" id="email" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" value ="<%=teacher.getUsername() %>" id="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" value ="<%=teacher.getPassword() %>" id="password" placeholder="Enter password">
                    </div>
                    <div class="form-group">
                        <label>Department</label>
                        <select class="form-control" id="department"  >
                            <% for (int i = 0; i < departs.size(); i++) {
                                    DepartAndBatches db = departs.get(i);
                                    if(db.getDepart().equalsIgnoreCase(teacher.getDepartment())){
                            %>
                            <option value="<%=db.getDepart() %>" selected><%= db.getDepart()%></option>
                            <% }else {%>
                              <option value="<%=db.getDepart() %>" ><%= db.getDepart()%></option>
                            
                            <% } }%>
                        </select>
                    </div>

                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return editTeacherForm()" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>