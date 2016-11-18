<!-- Content Header (Page header) -->
<section class="content-header" onload="checkStudentData()" >
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
                <h3 class="box-title">Please Fill Following Fields</h3><br />
                <h3 class="box-title" id = "formData"></h3>

            </div>
              <!--action="${pageContext.request.contextPath}/InsertStudentServlet"-->
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" name="add_student_form" >
                <div class="box-body">
                    <div class="form-group">
                        <label for="rollNumber">Roll Number</label>
                        <input type="text" class="form-control" id="rollNumber" placeholder="Enter roll number">
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
                    <!-- Date -->
                    <div class="form-group">
                        <label>Date of Birth</label>

                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text"  class="form-control pull-right" id="dob">
                        </div>
                        <!-- /.input group -->
                    </div>



                    <div class="form-group">
                        <label>Department</label>
                        <select class="form-control" id = "department">
                            <option>Computer System</option>
                            <option>Chemical Engineering</option>
                            <option>Electronic Engineering</option>
                            <option>Industrial Engineering</option>
                            <option>Energy & Environement Engineering</option>
                        </select>
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
                    <!-- Matric info -->
                    <h3 class="box-title">Matriculation Education</h3><br />
                    <div class="form-group">
                        <label for="collageName">School/Collage Name</label>
                        <input type="text" class="form-control" id="matricCollageName" placeholder="Enter school/collage name">
                    </div>
                    <div class="form-group">
                        <label for="grade">Grade</label>
                        <input type="text" class="form-control" id="matricGrade" placeholder="Enter grade">
                    </div>

                    <div class="form-group">
                        <label for="board">Board</label>
                        <input type="text" class="form-control" id="matricBoard" placeholder="Enter board">
                    </div>


                    <div class="form-group">
                        <label for="totalMarks">Total Marks</label>
                        <input type="text" class="form-control" id="matricTotalMarks" placeholder="Enter total marks">
                    </div>
                    <div class="form-group">
                        <label for="passingYear">Passing Year</label>
                        <input type="text" class="form-control" id="matricPassingYear" placeholder="Enter passing year">
                    </div>

                    <div class="form-group">
                        <label for="district">District</label>
                        <input type="text" class="form-control" id="matricDistrict" placeholder="Enter district">
                    </div>
                    <div class="form-group">
                        <label for="obtainedMarks">Obtained Marks</label>
                        <input type="text" class="form-control" id="matricObtainedMarks" placeholder="Enter obtained marks">
                    </div>



                    <!-- Intermeidate info -->
                    <h3 class="box-title">Intermediate Education</h3><br />
                    <div class="form-group">
                        <label for="collageName">Collage Name</label>
                        <input type="text" class="form-control" id="interCollageName" placeholder="Enter collage name">
                    </div>
                    <div class="form-group">
                        <label for="grade">Grade</label>
                        <input type="text" class="form-control" id="interGrade" placeholder="Enter grade">
                    </div>

                    <div class="form-group">
                        <label for="board">Board</label>
                        <input type="text" class="form-control" id="interBoard" placeholder="Enter board">
                    </div>


                    <div class="form-group">
                        <label for="totalMarks">Total Marks</label>
                        <input type="text" class="form-control" id="interTotalMarks" placeholder="Enter total marks">
                    </div>
                    <div class="form-group">
                        <label for="passingYear">Passing Year</label>
                        <input type="text" class="form-control" id="interPassingYear" placeholder="Enter passing year">
                    </div>

                    <div class="form-group">
                        <label for="district">District</label>
                        <input type="text" class="form-control" id="interDistrict" placeholder="Enter district">
                    </div>
                    <div class="form-group">
                        <label for="obtainedMarks">Obtained Marks</label>
                        <input type="number" class="form-control" id="interObtainedMarks" placeholder="Enter obtained marks">
                    </div>



                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" onclick="return validateAddStudentForm()" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>