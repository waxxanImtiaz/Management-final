
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Add Batch
        
        <small>Control panel</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
     
       
        
   
       
      <div class="col-md-12">
          
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Please Fill Following Fields</h3>
              <h5 id="formData"></h5>
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form"  name="add_depart_form">
              <div class="box-body">
                  <div class="form-group">
                  <label for="subjectName">Batch Name</label>
                  <input type="text" class="form-control" id="batch" placeholder="Enter batch">
              </div>
                  <div class="form-group">
                  <label for="subjectName">Department</label>
                  <input type="text" class="form-control" id="department" placeholder="Enter department">
              </div>
                  
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                  <button type="submit" class="btn btn-primary" onclick="return checkBatchDepartAddForm()" >Submit</button>
              </div>
            </form>
          </div>
        </div>
      </section>