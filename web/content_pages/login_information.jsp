
<%@page import="beans.LoginInformation"%>
<%@page import="java.util.*" %>

<%
    List<LoginInformation> login = (List<LoginInformation>) session.getAttribute("loginInfo");
    

%>


<script type="text/javascript" src="pageloader.js">
</script>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Login Information 
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
                                <th>Username</th>
                                <th>Password</th>
                                <th>Date And Time</th>
                                <th>Host</th>
                                <th>Connection</th>
                                <th>UserAgent</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (LoginInformation s : login) {%>
                            <tr id = "<%="sub"+s.getId()%>">
                            
                                <td><%=s.getUsername() %></td>
                                <td><%=s.getPassword() %></td>
                                <td><%=s.getDate() %></td>
                                <td><%=s.getConnection() %>
                                </td>
                                <td><%=s.getUserAgent() %></td>
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