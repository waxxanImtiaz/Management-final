
<%@page import="beans.*"%>
<%@page import="java.util.*" %>

<%
    List<StudentSemesterResult> result = (List<StudentSemesterResult>) session.getAttribute("allResult");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Total Batches 
        <small>All Departments</small>
    </h1>
    <h5 id ="formData"></h5>
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
                                <th>Roll Number</th>
                                <th>Department</th>
                                <th>Subject</th>
                                <th>Type</th>
                                <th>Semester</th>
                                <th>Result</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (StudentSemesterResult d : result) {%>
                            <tr id = "<%=d.getId() %>">
                            
                                <td><%=d.getRollNum() %></td>
                                <td><%=d.getDepart() %></td>
                                <td><%=d.getSubject() %></td>
                                <td><%=d.getTheoryOrPractical() %></td>
                                <td><%=d.getSemester() %></td>
                                <td><%=d.getResult() %></td>

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callResultEditor('<%=d.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteResult('<%=d.getId() %>');">Delete</a></li>
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