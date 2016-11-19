
<%@page import="java.util.*" %>
<%@page import="beans.Subjects" %>

<%
    List<Subjects> subjects = (List<Subjects>) session.getAttribute("allSubjects");
    

%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Total Students 
        <small>All Departments</small>
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
                                <th>Subject Id</th>
                                <th>Subject Name</th>
                                <th>Department</th>
                                <th>Semester</th>
                                <th>Type</th>
                                <th>Credit Hours</th>
                                <th>Total Subjects</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Subjects s : subjects) {%>
                            <tr id = "<%="sub"+s.getId()%>">
                            
                                <td><%=s.getId() %></td>
                                <td><%=s.getSubjectName() %></td>
                                <td><%=s.getDepartment() %></td>
                                <td><%=s.getSemester() %>
                                </td>
                                <td><%=s.getTheoryOrPractical() %></td>
                                <td> <%=s.getCreditHours() %></td>
                                <td> <%=s.getTotalLectures() %></td>
                                

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callSubjectEditor('<%=s.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteSubject('<%=s.getId()+"" %>');">Delete</a></li>
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