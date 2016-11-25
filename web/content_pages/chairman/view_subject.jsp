
<%@page import="beans.TeacherSubjects"%>
<%@page import="java.util.*" %>

<%
   List<TeacherSubjects> subjects = (List<TeacherSubjects>) session.getAttribute("allAssignedSubjects");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Total Subjects Assigned to Teachers 
       
    </h1>
    <!--      <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Tables</a></li>
            <li class="active">Data tables</li>
          </ol>-->
</section>

<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title" id="formData" ><!-- Hover Data Table --></h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" >




                    <table id="example2" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Teacher Name</th>
                                <th>Semester</th>
                                <th>Subject</th>
                                <th>Department</th>
                                <th>Batch</th>
                                <th>Type</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (TeacherSubjects d : subjects) {%>
                            <tr id = "<%=d.getId() %>">
                            
                                <td><%=d.getTeacherName() %></td>
                                <td><%=d.getSemester() %></td>
                                <td><%=d.getSubject() %></td>
                                <td><%=d.getDepartment() %></td>
                                <td><%=d.getBatch() %></td>
                                <td><%=d.getType() %></td>
                                

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callSubjectsEditor('<%=d.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteSubject('<%=d.getId() %>');">Delete</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            <% }%>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>

            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->