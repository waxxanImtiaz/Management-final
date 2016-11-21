
<%@page import="beans.LibraryBooks"%>
<%@page import="java.util.*" %>

<%
    List<LibraryBooks> books = (List<LibraryBooks>) session.getAttribute("allBooks");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Total Library Books 
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
                                <th>Book Name</th>
                                <th>Book Author</th>
                                
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (LibraryBooks d : books) {%>
                            <tr id = "<%=d.getId() %>">
                            
                                <td><%=d.getBookName() %></td>


                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callBookEditor('<%=d.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteBook('<%=d.getId() %>');">Delete</a></li>
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