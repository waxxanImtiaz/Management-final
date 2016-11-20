<%@page import="java.util.List"%>
<%@page import="beans.*" %>

<%
    List<DepartAndBatches> departs = (List<DepartAndBatches>) session.getAttribute("allDeparts");
%>

<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Compose News
      
      </h1>
      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        
        <!-- /.col -->
        <div class="col-md-9">
          <div class="box box-primary">
            <div class="box-header with-border">
            </div>
            <!-- /.box-header -->
            <div class="box-body">
             
                <div class="form-group">
                        <label>To</label>
                        <select class="form-control" id="department" onchange="return getDepartmentSubjects();"    >
                            <option value="all" >All Students</option>
                            <% for (int i = 0; i < departs.size(); i++) {
                                    DepartAndBatches db = departs.get(i);
                            %>
                            <option value="<%=db.getDepart() %>" ><%= db.getDepart()%></option>
                            <% }%>
                        </select>
                    </div>
              
              <div class="form-group">
<textarea maxlength="500" placeholder="Write News Here" id="news"  class="form-control" style="height: 300px">

</textarea>
              </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <div class="pull-right">
                <button type="submit" class="btn btn-primary" onclick="return sendNews();" ><i class="fa fa-envelope-o"></i> Send</button>
              </div>
             </div>
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->