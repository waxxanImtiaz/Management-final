
<%@page import="java.util.*" %>
<%@page import="beans.*" %>

<%
    List<Students> students = (List<Students>) session.getAttribute("allStudents");

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
                    <h3 class="box-title"><!-- Hover Data Table --></h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" >




                    <table id="example2" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Father Name</th>
                                <th>Roll Number</th>
                                <th>Caste</th>
                                <th>Department</th>
                                <th>Permanent Address</th>
                                <th>Batch</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Students st : students) {%>
                            <tr>
                                <td><%=st.getName()%></td>
                                <td><%=st.getFatherName()%>
                                </td>
                                <td><%=st.getRollNum()%></td>
                                <td> <%=st.getCaste()%></td>
                                <td><%=st.getDepartment()%>
                                </td>


                                <td><%=st.getPermAdd()%>
                                </td>

                                <td><%=st.getBatch()%>
                                </td>


                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <!--<li><a href="${pageContext.request.contextPath}/StudentEditor?rollNumber=<%=st.getRollNum()%>">Edit</a></li>-->
                                            <li><a href="#" onclick="callEditor('<%=st.getRollNum()%>');">Edit</a></li>
                                            <li><a href="#">Delete</a></li>
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