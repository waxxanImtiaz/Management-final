
<%@page import="beans.Teacher"%>
<%@page import="beans.DepartAndBatches"%>
<%@page import="java.util.*" %>

<%
    List<Teacher> teachers = (List<Teacher>) session.getAttribute("allTechers");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        All Teachers  
    </h1>
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
                                <th>Name</th>
                                <th>Department</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Password</th>
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Teacher t : teachers) {%>
                            <tr id = "<%=t.getId() %>">
                            
                                <td><%=t.getName() %></td>
                                <td><%=t.getDepartment() %></td>
                                <td><%=t.getEmail() %></td>
                                <td><%=t.getUsername() %></td>
                                <td><%=t.getPassword() %></td>

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callTeacherEditor('<%=t.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteTeacher('<%=t.getId() %>');">Delete</a></li>
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