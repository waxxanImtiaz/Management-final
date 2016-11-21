
<%@page import="beans.Librarian"%>
<%@page import="java.util.*" %>

<%
    List<Librarian> lib = (List<Librarian>) session.getAttribute("allLibrarian");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        All Librarians  
    </h1>
    <h5 id="formData"></h5>
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
                                <th>Email</th>
                                <th>Mobile Number</th>
                                <th>Username</th>
                                <th>Password</th>
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Librarian l : lib) {%>
                            <tr id = "<%="sub"+l.getId() %>">
                            
                                <td><%=l.getEmail() %></td>
                                <td><%=l.getMobileNumber() %></td>
                                <td><%=l.getUsername() %></td>
                                <td><%=l.getPassword() %></td>

                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" onclick="callLibrarianEditor('<%=l.getId() %>');">Edit</a></li>
                                            <li><a href="#" onclick="deleteLibrarian('<%=l.getId() %>');">Delete</a></li>
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