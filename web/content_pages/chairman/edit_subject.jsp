

<%@page import="java.util.*" %>
<%@page import="beans.*" %>

<%
 
    List<Subjects> subjects = (List<Subjects>) session.getAttribute("allSubjects");
    TeacherSubjects assingedSubject = (TeacherSubjects)session.getAttribute("assignedSubject");
    
    List<Teacher> teachers = (List<Teacher>) session.getAttribute("departTeachers");
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Update Subject Of Teacher

    </h1>
   
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
                        <label for="teacherName">Select Teacher Name</label>
                        <select class="form-control" id="teacherName"    >
                            <% for (int i = 0; i < teachers.size(); i++) {
                                    Teacher db = teachers.get(i);
                              if(db.getName().equalsIgnoreCase(assingedSubject.getTeacherName())){
                            %>
                            <option value="<%=db.getName() %>" selected><%= db.getName() %></option>
                            <% }else %>
                             <option value="<%=db.getName() %>" ><%= db.getName() %></option>
                            <% }%>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Subject</label>
                        <select class="form-control" id = "subject" >
                            <% for (Subjects s : subjects) {
                             if(s.getSubjectName().equalsIgnoreCase(assingedSubject.getSubject())) {
                            %>
                            <option value="<%=s.getSubjectName() %>" selected><%=s.getSubjectName() %></option>
                            <% } else %>
                             <option value=<%=s.getSubjectName() %> ><%=s.getSubjectName() %></option>
                            <% }%>
                        </select>
                    </div>
                    <% String[] type = {"Theory","Practical"}; %>
                    <div class="form-group">
                        <label>Type</label>
                        <select class="form-control"  id = "theoryOrPractical" >
                            <% for(int i = 0; i< type.length; i++){
                            if(type[ i ].equalsIgnoreCase(assingedSubject.getType() )){    
                            %>
                            <option selected><%=assingedSubject.getType() %></option>
                            <% }else %>
                            <option ><%=type[ i ]%></option>
                            <% }
                            %>
                        </select>
                    </div>
                    <% String[] semesters = {"1st","2nd","3rd","4th","5th","6th","7th","8th"};  %>        
                    <div class="form-group">
                        <label>Semester</label>
                        <select class="form-control" id = "semester" >

                           <% for( int i = 0; i< semesters.length; i++ ) { 
                               if(semesters[ i ].equalsIgnoreCase(assingedSubject.getSemester())){ %>
                                <option selected><%=assingedSubject.getSemester()  %></option>
                                <% } else %>
                                 <option><%=semesters[ i ] %></option>
                                 <% } %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="batch">Batch</label>
                        <input type="text" class="form-control" value="<%=assingedSubject.getBatch() %>" id="batch" placeholder="Enter batch">
                    </div>

                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary" onclick="return checkSubjectUpdateForm('<%=assingedSubject.getId()+"" %>')" >Submit</button>
                </div>
            </form>
        </div>
    </div>
</section>