
<%@page import="java.util.*" %>
<%@page import="beans.*" %>

<%
    DepartAndBatches batch = (DepartAndBatches)session.getAttribute("batch");

%>

<!-- Content Header (Page header) -->
    <section class="content-header" >
      <h1>
        Update Batch Data
       
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
              <h3 class="box-title">Please Fill Following Fields</h3><br />
              <h3 class="box-title" id = "formData"></h3>
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
           <form role="form"  name="add_batch_form">
              <div class="box-body">
                  <div class="form-group">
                  <label for="subjectName">Batch Name</label>
                  <input type="text" class="form-control" id="batch" value="<%=batch.getBatch() %>" placeholder="Enter batch name" disabled="true">
              </div>
                  <div class="form-group">
                  <label for="subjectName">Department</label>
                  <input type="text" class="form-control" id="department" value="<%=batch.getDepart() %>" placeholder="Enter department name" >
              </div>
                  
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                  <button type="submit" class="btn btn-primary" onclick="return  validateEditBatchForm()" >Submit</buttcheckSubjectAddFormon>
              </div>
            </form>
          </div>
        </div>
      </section>