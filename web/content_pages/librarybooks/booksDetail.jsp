
<%@page import="beans.LibraryDetails"%>
<%@page import="java.util.*" %>

<%
    List<LibraryDetails> lib = (List<LibraryDetails>) session.getAttribute("libraryDetails");
%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Library Information 
        <small>Management Information System</small>
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
                                <th>Roll Number</th>
                                <th>Department</th>
                                <th>Book Name</th>
                                <th>Book Issue Date</th>
                                <th>Book Return Date</th>
                              
                                
                             
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (LibraryDetails l : lib) {%>
                            <tr id = "<%="sub"+l.getId()%>">
                            
                                <td><%=l.getName() %></td>
                                <td><%=l.getRollNum() %></td>
                                <td><%=l.getDepartment() %></td>
                                <td><%=l.getBookName() %></td>
                                <td><%=l.getIssueDate() %></td>
                                <td><%=l.getReturnDate() %></td>
                                
                              
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