
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Add Master Key
        
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
              <h5 id="formData"></h5>
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form"  name="add_depart_form">
              <div class="box-body">
                  <div class="form-group">
                  <label for="department">Username</label>
                  <input type="text" class="form-control" id="department" placeholder="Enter username">
              </div>
                  <div class="form-group">
                  <label for="password">Master Key</label>
                  <input type="password" class="form-control" id="password" placeholder="Enter master key">
              </div>
                  
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                  <button type="submit" class="btn btn-primary" onclick="return checkMasterAddForm()" >Submit</button>
              </div>
            </form>
          </div>
        </div>
      </section>