<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Add New Student
        
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
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" action="${pageContext.request.contextPath}/InsertStudentServlet">
              <div class="box-body">
                  <div class="form-group">
                  <label for="id">Roll Number</label>
                  <input type="text" class="form-control" id="id" placeholder="Enter roll number">
              </div>
                  <div class="form-group">
                  <label for="student_name">Name</label>
                  <input type="text" class="form-control" id="student_name" placeholder="Enter name">
                </div>
                  <div class="form-group">
                  <label for="fatherName">Father Name</label>
                  <input type="text" class="form-control" id="fatherName" placeholder="Enter father name">
                </div>
                  <div class="form-group">
                  <label for="batch">Batch</label>
                  <input type="text" class="form-control" id="batch" placeholder="Enter batch">
                </div>
                  <div class="form-group">
                  <label for="dob">Date of birth</label>
                  <input type="text" class="form-control" id="dob" placeholder="Enter date of birth">
                </div>
                  
                  <div class="form-group">
                  <label for="department">Department</label>
                  <input type="text" class="form-control" id="department" placeholder="Enter department">
                </div>
                  
                  
                  <div class="form-group">
                  <label for="caste">Caste</label>
                  <input type="text" class="form-control" id="caste" placeholder="Enter caste">
                </div>
                  <div class="form-group">
                  <label for="address">Address</label>
                  <input type="text" class="form-control" id="address" placeholder="Enter address">
                </div>
                  
                  <div class="form-group">
                  <label for="perm_address">Permanent Address</label>
                  <input type="text" class="form-control" id="perm_address" placeholder="Enter permanent address">
                </div>
                  <div class="form-group">
                  <label for="nic">NIC #</label>
                  <input type="text" class="form-control" id="nic" placeholder="Enter nic #">
                </div>
                  <div class="form-group">
                  <label for="gender">Gender</label>
                  <input type="text" class="form-control" id="gender" placeholder="Enter gender">
                </div>
                  <div class="form-group">
                  <label for="father_contact">Father Contact #</label>
                  <input type="text" class="form-control" id="father_contact" placeholder="Enter father contact #">
                </div>
                  <div class="form-group">
                  <label for="student_contact_num">Student Contact #</label>
                  <input type="text" class="form-control" id="student_contact_num" placeholder="Enter student contact #">
                </div>
                  
                <div class="form-group">
                  <label for="email">Email address</label>
                  <input type="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password" placeholder="Password">
                </div>
             
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
        </div>
      </section>