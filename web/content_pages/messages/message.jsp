
<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Write Message
      
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
                        <label for="to">To</label>
                        <input type="text" class="form-control" id="to" placeholder="Enter Roll Number Of Student">
                    </div>
              
              <div class="form-group">
<textarea maxlength="500" placeholder="Write Message Here" id="message"  class="form-control" style="height: 300px">

</textarea>
              </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <div class="pull-right">
                <button type="submit" class="btn btn-primary" onclick="return sendMessage();" ><i class="fa fa-envelope-o"></i> Send</button>
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