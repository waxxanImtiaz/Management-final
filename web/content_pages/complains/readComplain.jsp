<%-- 
    Document   : readComplain
    Created on : Nov 21, 2016, 1:28:16 AM
    Author     : waxxan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="beans.*" %>
<%
    List<Complain> complains = (List<Complain>) session.getAttribute("allComplains");
 %>

        <!--<h1>Hello World!</h1>-->
    
 <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Complains
      </h1>
    </section>
 <section class="content">
      <div class="row">
     
        <!-- /.col -->
        <div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Inbox</h3>

             
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-controls">
                <!-- Check all button -->
                
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                </div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                <div class="pull-right">
                  Total <%=complains.size() %> Complains
                 
                  <!-- /.btn-group -->
                </div>
                <!-- /.pull-right -->
              </div>
              <div class="table-responsive mailbox-messages">
                <table class="table table-hover table-striped">
                  <tbody>
                      <% for(Complain c : complains) { %>
                  <tr id="<%=c.getId() %>">
                    <td id="<%="cb"+c.getId() %>"><input type="checkbox"></td>
                    <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                    <td class="mailbox-name"><a href="#" onclick="readComplain.jsp?id=<%=c.getId() %>"><%=c.getName() %></a></td>
                    <td class="mailbox-subject"><b><%=c.getComplain() %></b>
                    </td>
                    <td class="mailbox-attachment"></td>
                    <td class="mailbox-date"><%=c.getDateTime() %></td>
                  </tr>
                  <% } %>
                  </tbody>
                </table>
                <!-- /.table -->
              </div>
              <!-- /.mail-box-messages -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer no-padding">
              <div class="mailbox-controls">
                <!-- Check all button -->
                
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                </div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                <div class="pull-right">
                  1-50/200

                </div>
                <!-- /.pull-right -->
              </div>
            </div>
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  

  
