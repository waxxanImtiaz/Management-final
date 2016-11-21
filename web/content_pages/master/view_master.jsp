
<%@page import="beans.Master"%>
<%@page import="beans.DepartAndBatches"%>
<%@page import="java.util.*" %>

<%
    List<Master> master = (List<Master>) session.getAttribute("allMasters");
%>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Total Master Keys 
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
                                <th>Username</th>
                                <th>Master Key</th>
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Master d : master) {%>
                            <tr id = "<%=d.getDepart() %>">
                            
                                <td><%=d.getDepart() %></td>
                                <td><%=d.getMasterKey() %></td>

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callMasterEditor('<%=d.getDepart() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteMaster('<%=d.getDepart() %>');">Delete</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
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