<%@page import="beans.Complain"%>
<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Read Complain
      </h1>
      <ol class="breadcrumb">
        <li class="active">Complain</li>
      </ol>
    </section>

<%
    Complain complain = (Complain)session.getAttribute("complainRead");
%>


    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- /.col -->
        <div class="col-md-9">
          <div class="box box-primary">
            
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>From: <%=complain.getName() %></h3>
                <h5>Roll Number: <%=complain.getRollNumber() %>
                  <span class="mailbox-read-time pull-right"><%=complain.getDateTime() %></span></h5>
              </div>
              <!-- /.mailbox-read-info -->
              
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
                  <h4>Complain</h4>
                <p >
                    <%=complain.getComplain() %>
                </p>

                
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
            
            </div>
            <!-- /.box-footer -->
            <div class="box-footer">
             
                <button type="button" onclick="return deleteComplain('<%=complain.getId() %>')" class="btn btn-default"><i class="fa fa-trash-o"></i> Delete</button>
              <button type="button" onclick="return print();" class="btn btn-default"><i class="fa fa-print"></i> Print</button>
            </div>
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>