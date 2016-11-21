
<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%
    Librarian lib = (Librarian) session.getAttribute("editLibrarian");
 %>
<section class="content-header">
    <h1>
        Update Librarian's Data

        <small>Control panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">





    <div class="col-md-12">

        <!-- general form elements -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Please Fill Following Fields</h3>
                <h3 class="formData"></h3>

            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form"  name="add_subject_form">



                <div class="box-body">

                    <div class="form-group">
                        <label for="name">Email</label>
                        <input type="text" class="form-control" value ="<%=lib.getEmail() %>" id="name" placeholder="Enter email">
                    </div>
                    
                    
                    <div class="form-group">
                        <label for="email">Mobile Number</label>
                        <input type="email" class="form-control" value ="<%=lib.getMobileNumber() %>" id="mobileNumber" placeholder="Enter mobile number">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" value ="<%=lib.getUsername() %>" id="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" value ="<%=lib.getPassword() %>" id="password" placeholder="Enter password">
                    </div>
                   

                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return editLibrarianForm()" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>