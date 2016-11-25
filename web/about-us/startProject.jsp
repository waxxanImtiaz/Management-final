<%-- 
    Document   : startProject
    Created on : Jun 19, 2016, 4:02:19 PM
    Author     : waxxan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>MIS DUET</title>
  <link rel="stylesheet" href="../css/style2.css">
<!--  <script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>-->
</head>
<body>
    <div class="wrapper">
	<div class="container">
    <img src="../img/duet_logo.png" height="80" width="110">
		<h2>MANAGEMENT INFORMATION SYSTEM DUET</h2>
		<!--${pageContext.request.contextPath}/Checker -->
                <form role="form"   class="form" name="loginform" action="${pageContext.request.contextPath}/Checker" method="post">
			<input type="text" placeholder="username" id="username" name="username" />
                        <input type="password" placeholder="password" id="password" name="password" />
                        <button type="submit"  o >Login</button>
            <button type="submit">Forget Password</button>
		</form>
	</div>
                <!--nclick="return checkLoginForm();"-->
	
    <ul class="bg-bubbles">
		<li> <img src="../img/duet_logo.png" height="60" width="60" > </li>
		<li> <img src="../img/download (1).jpg"  height="60" width="60" ></li>
		<li><img src="../img/download (3).jpg"  height="60" width="60" ></li>
		<li><img src="../img/download (7).jpg"  height="60" width="60" ></li>
		<li><img src="/img/download (6).jpg"  height="60" width="60" ></li>
		<li><img src="../img/download (5).jpg"  height="60" width="60" ></li>
		<li><img src="../img/download.jpg"  height="60" width="60" ></li>
		<li><img src="../img/download.png"  height="60" width="60" ></li>
		<li><img src="../img/download12.jpg"  height="60" width="60" ></li>
		<li><img src="../img/fees.jpg"  height="60" width="60" ></li>
        <li><img src="../img/images (2).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (3).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (3).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (4).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (5).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (6).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (7).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (8).jpg"  height="60" width="60" ></li>
		<li><img src="../img/images (10).jpg" height="60" width="60"></li>
        
	</ul>
     </div>
   
 <%
    request.getSession().invalidate();
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

        <script src="js/index.js"></script>
         <script src="../js/loginHandler.js"></script>
    
    
    
  </body>
</html>

<!--student_name= document.forms["add_student_form"]["student_name"].value,
        rollNumber=document.forms["add_student_form"]["rollNumber"].value,
        department = document.forms["add_student_form"]["department"].value,
      fatherName=  document.forms["add_student_form"]["fatherName"].value,
        batch = document.forms["add_student_form"]["batch"].value,
      dob =  document.forms["add_student_form"]["dob"].value,
      caste =  document.forms["add_student_form"]["caste"].value,
      address =  document.forms["add_student_form"]["address"].value,
      pern_address =  document.forms["add_student_form"]["perm_address"].value,
      nic =   document.forms["add_student_form"]["nic"].value,
      gender =  document.forms["add_student_form"]["gender"].value,
      father_contact =   document.forms["add_student_form"]["father_contact"].value,
       student_contact_num =  document.forms["add_student_form"]["student_contact_num"].value,
       email =  document.forms["add_student_form"]["email"].value,
      password =  document.forms["add_student_form"]["password"].value;-->