
<%@page import="java.util.*" %>
<%@page import="beans.*" %>

<%
    Students student = (Students)session.getAttribute("student");
    Intermediate inter = (Intermediate)session.getAttribute("inter");
    MatricInformation matric = (MatricInformation)session.getAttribute("matric");

%>

<!-- Content Header (Page header) -->
    <section class="content-header" onload="checkStudentDataEditPage()" >
      <h1>
        Update Student Data
       
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
                  <input type="text" class="form-control" value="<%=student.getRollNum() %>" id="rollNumber" placeholder="Enter roll number" disabled>
              </div>
                  <div class="form-group">
                  <label for="student_name">Name</label>
                  <input type="text" class="form-control" value="<%=student.getName() %>" id="student_name" placeholder="Enter name">
                </div>
                  <div class="form-group">
                  <label for="fatherName">Father Name</label>
                  <input type="text" class="form-control" value="<%=student.getFatherName() %>" id="fatherName" placeholder="Enter father name">
                </div>
                  <div class="form-group">
                  <label for="batch">Batch</label>
                  <input type="text" class="form-control" value="<%=student.getBatch() %>" id="batch" placeholder="Enter batch">
                </div>
                  <!-- Date -->
              <div class="form-group">
                <label>Date of Birth</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                    <input type="text" value="<%=student.getDob() %>"  class="form-control pull-right" id="dob">
                </div>
                <!-- /.input group -->
              </div>
                  
                  
                  
                    <div class="form-group">
                        <label>Department</label>
                         <select class="form-control" id = "department" value="<%=student.getDepartment() %>">
                            <option>Computer System</option>
                            <option>Chemical Engineering</option>
                            <option>Electronic Engineering</option>
                            <option>Industrial Engineering</option>
                            <option>Energy & Environement Engineering</option>
                        </select>
                    </div>
                  
                  <div class="form-group">
                  <label for="caste">Caste</label>
                  <input type="text" class="form-control" id="caste" value="<%= student.getCaste() %>" placeholder="Enter caste">
                    </div>
                  <div class="form-group">
                  <label for="address">Address</label>
                  <input type="text" class="form-control" id="address" value="<%=student.getTempAdd() %>"  placeholder="Enter address">
                </div>
                  
                  <div class="form-group">
                  <label for="perm_address">Permanent Address</label>
                  <input type="text" class="form-control" id="perm_address" value="<%=student.getPermAdd() %>" placeholder="Enter permanent address">
                </div>
                  <div class="form-group">
                  <label for="nic">NIC #</label>
                  <input type="text" class="form-control" id="nic" value="<%=student.getCnic() %>" placeholder="Enter nic #">
                </div>
                  <div class="form-group">
                  <label for="gender">Gender</label>
                  <input type="text" class="form-control" id="gender" value="<%=student.getGender() %>" placeholder="Enter gender">
                </div>
                  <div class="form-group">
                  <label for="father_contact">Father Contact #</label>
                  <input type="text" class="form-control" id="father_contact" value="<%=student.getFtContactNum() %>" placeholder="Enter father contact #">
                </div>
                  <div class="form-group">
                  <label for="student_contact_num">Student Contact #</label>
                  <input type="text" class="form-control" id="student_contact_num" value="<%=student.getStContactNum() %>" placeholder="Enter student contact #">
                </div>
                  
                <div class="form-group">
                  <label for="email">Email address</label>
                  <input type="email" class="form-control" value="<%=student.getStEmail() %>" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password" value="<%=student.getPassword() %>" placeholder="Password">
                </div>
             
                
                 <!-- Matric info -->
                    <h3 class="box-title">Matriculation Education</h3><br />
                    <div class="form-group">
                        <label for="collageName">School/Collage Name</label>
                        <input type="text" class="form-control" value="<%=matric.getSchoolName() %>"  id="matricCollageName" placeholder="Enter school/collage name">
                    </div>
                    <div class="form-group">
                        <label for="grade">Grade</label>
                        <input type="text" class="form-control"  value ="<%=matric.getGrade() %>"   id="matricGrade" placeholder="Enter grade">
                    </div>

                    <div class="form-group">
                        <label for="board">Board</label>
                        <input type="text" class="form-control" value ="<%=matric.getBoard() %>"  id="matricBoard" placeholder="Enter board">
                    </div>


                    <div class="form-group">
                        <label for="totalMarks">Total Marks</label>
                        <input type="text" class="form-control" value ="<%=matric.getTotalMarks() %>"  id="matricTotalMarks" placeholder="Enter total marks">
                    </div>
                    <div class="form-group">
                        <label for="passingYear">Passing Year</label>
                        <input type="text" class="form-control" value ="<%=matric.getPassingYear() %>"  id="matricPassingYear" placeholder="Enter passing year">
                    </div>

                    <div class="form-group">
                        <label for="district">District</label>
                        <input type="text" class="form-control" value ="<%=matric.getDistrict() %>"  id="matricDistrict" placeholder="Enter district">
                    </div>
                    <div class="form-group">
                        <label for="obtainedMarks">Obtained Marks</label>
                        <input type="text" class="form-control" value ="<%=matric.getObtainedMarks() %>"  id="matricObtainedMarks" placeholder="Enter obtained marks">
                    </div>



                    <!-- Intermeidate info -->
                    <h3 class="box-title">Intermediate Education</h3><br />
                    <div class="form-group">
                        <label for="collageName">Collage Name</label>
                        <input type="text" class="form-control" value ="<%=inter.getCollageName() %>"  id="interCollageName" placeholder="Enter collage name">
                    </div>
                    <div class="form-group">
                        <label for="grade">Grade</label>
                        <input type="text" class="form-control" value ="<%=inter.getGrade() %>" id="interGrade" placeholder="Enter grade">
                    </div>

                    <div class="form-group">
                        <label for="board">Board</label>
                        <input type="text" class="form-control" value ="<%=inter.getBoard() %>" id="interBoard" placeholder="Enter board">
                    </div>


                    <div class="form-group">
                        <label for="totalMarks">Total Marks</label>
                        <input type="text" class="form-control" value ="<%=inter.getTotalMarks() %>"id="interTotalMarks" placeholder="Enter total marks">
                    </div>
                    <div class="form-group">
                        <label for="passingYear">Passing Year</label>
                        <input type="text" class="form-control" value ="<%=inter.getPassingYear() %>" id="interPassingYear" placeholder="Enter passing year">
                    </div>

                    <div class="form-group">
                        <label for="district">District</label>
                        <input type="text" class="form-control" value ="<%=inter.getDistrict() %>" id="interDistrict" placeholder="Enter district">
                    </div>
                    <div class="form-group">
                        <label for="obtainedMarks">Obtained Marks</label>
                        <input type="number" class="form-control" value ="<%=inter.getObtainedMarks() %>" id="interObtainedMarks" placeholder="Enter obtained marks">
                    </div>


                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" onclick="return validateEditStudentForm()" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
        </div>
      </section>