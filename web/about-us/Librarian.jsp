<!DOCTYPE html>
<html>

    <head>

        <link rel="stylesheet" type="text/css" media="all" href="../wp-content/themes/duet/style.css" />


        <!-- MIS DUET-->
        <title>MIS DUET</title>

        <script src="../wp-content/themes/duet/menu/jquery-1.10.2.min.js">
            
            $("#prospects_form").submit(function(e) {
    e.preventDefault();
        });
        </script>
        <script type="text/javascript" src="../handler.js" ></script>
    </head>

    <link rel="stylesheet" href="../wp-content/themes/duet/menu/demo.css">
    <link rel="stylesheet" href="../wp-content/themes/duet/menu/daisynav.css">


    <body class="page page-id-22 page-parent page-template-default" onload="checkBookData()">
        <!-- page -->
        <script src="../wp-content/themes/duet/backstretch/jquery.backstretch.min.js"></script>
        <script>
            $.backstretch([
                "../wp-content/uploads/2014/09/about_bg1.png",
            ], {
                fade: 750,
                duration: 4000,
                transition: 'fade',
                transition_speed: 500,
                navigation: 1,
                fit_portrait: 0,
                fit_landscape0: 0,
                slide_captions: 1,
                slide_counter: 1
            });

            //    	$.backstretch("");
        </script>

  <div id ="formData" ></div>
        <div id="wrapper" class="hfeed">
            <div class="inner_wrap">
                <div id="header">
                    <!--inner_wrap-->

                    <!--.inner_head-->	
                    <div class="inner_header">

                        <div class="logo">
                            <a href="../index.html" title="MIS DUET">
                                <img src="../wp-content/themes/duet/images/logo1.jpg" height=277  width=244>
                            </a>
                        </div>
                        <div id="nav-trigger">
                            <div>- <span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></div>
                        </div>
                        <nav id="nav-mobile">
                            <div >
                            </div>                </nav>
                        <div class="top_menu">
                            <div class="menu-header"><ul id="menu-top-menu-1" class="menu">
                                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-7286"><a href="#">Log Out</a></li>
                                </ul></div>                

                            <div class="search">
                                <div class="mw_button">

                                </div>

                            </div>
                        </div>
                    </div>
                    <!--.inner_head-->

                    <div class="vav_wrap">
                        <div  class="menu-toggle-button" data-menu-id="demo-menu">MENU <i>---</i>?</div>
                        <div class="res_menu"><ul class="menu-list" id="demo-menu"><li id="item-id">Menu: </li>

                        </div>            
                        <div class="inner_wraper">
                            <div id="access" role="navigation">
                                <div class="menu-header"><ul id="menu-main-menu-1" class="menu">

                                        <ul class="sub-menu">
                                            <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-7840"> </li>
                                        </ul>
                                        </li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-50"><a href="#"> Books </a>
                                            <ul class="sub-menu">
                                                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-975"><a href="${pageContext.request.contextPath}/LibraryBooksLoader?jspPage=lib">Available Books</a>

                                                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-975"><a href="${pageContext.request.contextPath}/LibraryIssuedBooksList">Issued Books</a>

                                            </ul>
                                        </li>
                                        <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-7307"><a href="#"> Complaints/Help </a></li>
                                    </ul>

                                </div>     
                            </div>

                            <!-- #access -->
                            <nav id="nav-mobile">
                            </nav>
                        </div>   
                    </div>
                </div><!-- #header -->
                <div id="main">



                    <div id="container">
                        <div id="content" role="main">



                            <div id="post-136" class="post-136 page type-page status-publish has-post-thumbnail hentry">
                                <h1 class="entry-title">Book Issuance Form</h1>

                                <div class="entry-content">
                                    <div class="accordion"> 
                                        <div class="panel-content activeClass">
                                            <div id ="serverResponse" ></div>
                                            <div>
                                                

                                                <form name="librarianForm">
                                                    Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text1" id="name" name="Name" value="" size="35" ><br>
                                                    Department:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text2" id="department" name="department" value="" size="35" ><br>
                                                    <!--Batch:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text2" name="batch" value="" size="35" ><br>-->
                                                    Roll Number:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text2" id="rollNumber" name="Roll no" value="" size="35" ><br>
                                                    Book Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text2" id="bookName" name="book name" value="" size="35" ><br>
                                                    <!--Book Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
                                                    <!--<input type="text2" name="book code" value="" size="35" ><br>-->
                                                    Book Author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="text2" id="bookAuthor" name="Roll No" value="" size="35" ><br>
                                                    Date of Issuance:&nbsp;&nbsp;
                                                    <input type="text2" id="bookIssueDate" name="issue date" value="" size="35" ><br>
                                                    Date of Returning:
                                                    <input type="text2" id="bookReturnDate" name="Retuern date" value="" size="35" ><br>
                                                    <input type="submit" value="submit" onclick="validateLibrarianForm()">
                                                </form>
                                            </div>
                                        </div> </div>
                                </div><!-- .entry-content -->
                            </div><!-- #post-## -->



                        </div><!-- #content -->

                        <div id="primary" class="widget-area" role="complementary">

                            <h3 class="widget-title side">Librarian</h3>
                            <ul class="tb_side">
                                <li class="page_item page-item-51 page_item_has_children"><a><a href="Librarian.jsp">Book Issuance form </a>
                                        <ul class='children'>

                                        </ul>
                                </li>
                                <li class="page_item page-item-53 page_item_has_children"><a href="${pageContext.request.contextPath}/LibraryIssuedBooksList">Issued Books</a>
                                    <ul class='children'>

                                    </ul>
                                </li>
                                <li class="page_item page-item-53 page_item_has_children"><a href="${pageContext.request.contextPath}/LibraryBooksLoader?jspPage=lib">Available Books</a>
                                    <ul class='children'>

                                    </ul>
                                </li>

                                <li class="page_item page-item-7830"><!--<a href="complaint.html">Complaints/Help</a> --></li>
                            </ul>			
                        </div><!-- #primary .widget-area -->


                    </div><!-- #container -->


                </div>
                <!-- #main -->
            </div>
            <!--.inner_wrap-->
            <div id="footer" role="contentinfo">
                <div class="inner_footer">
                    <div class="main_footer">
                        <div class="footer_col">
                            <li id="nav_menu-2" class="widget-container widget_nav_menu"><h3 class="widget-title">PERSONEL</h3><div class="menu-about-us-container"><ul id="menu-about-us" class="menu"><li id="menu-item-65" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-65"><a href="#">Personel Information</a></li>
                                    </ul></div></li>
                            <li id="nav_menu-3" class="widget-container widget_nav_menu"><h3 class="widget-title"> </h3></a> <div class="menu-footer-house-of-habib-container"><ul id="menu-footer-house-of-habib" class="menu">
                                        <li id="menu-item-6363" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6363"><a href="#">Complaints/Help</a></li>

                                    </ul></div></li>      </div>
                        <div class="footer_col">
                            <li id="nav_menu-4" class="widget-container widget_nav_menu"><h3 class="widget-title">DEPARTMENTS</h3><div class="menu-footer-prospective-container"><ul id="menu-footer-prospective" class="menu"><li id="menu-item-241" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-241"><a href="#">Computer System Engineering</a></li>
                                        <li id="menu-item-242" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-242"><a href="#">Chemical Engineering</a></li>
                                        <li id="menu-item-240" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-240"><a href="#">Telecommunication Engineering</a></li>
                                        <li id="menu-item-6373" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6373"><a href="#">Petrolium and Gas Engineering</a></li>
                                        <li id="menu-item-243" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-243"><a href="#">Electronics Engineering</a></li>
                                        <li id="menu-item-6373" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6373"><a href="#">Metaulargy and Materials Engineering</a></li>
                                        <li id="menu-item-6374" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6374"><a href="#">Industrial Engineering and Management</a></li>
                                        <li id="menu-item-6375" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6375"><a href="#">Energy and Enviroment Engineering </a></li>
                                        <li id="menu-item-6729" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6729"><a href="#">Architecture</a></li>

                                    </ul></div></li>      </div>
                        <div class="footer_col">
                            <li id="nav_menu-5" class="widget-container widget_nav_menu"><h3 class="widget-title">DUET</h3><div class="menu-footer-life-habib-container">
                                    <ul id="menu-footer-life-habib" class="menu">
                                        <li id="menu-item-6248" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6248"><a href="#">Duet Website</a></li>
                                        <li id="menu-item-6249" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6249"><a href="#">Duet QEC</a></li>
                                        <li id="menu-item-6250" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6250"><a href="#">Duet Mail</a></li>
                                    </ul></div></li>
                            </ul></div></li>      </div>
                    <div class="footer_col">
                        <li id="nav_menu-6" class="widget-container widget_nav_menu"><h3 class="widget-title">Contact Us</h3><div class="menu-footer-current-student-container"><ul id="menu-footer-current-student" class="menu"><li id="menu-item-9091" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-9091"><a href="#">Duet M.A Jinnah Road, Karachi-74800</a></li>
                                    <li id="menu-item-9093" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-9093"><a href="#">Telephone: 
                                            +92 21 9923 1195/96/97/98 Ext: 267 </a></li>
                                    <li id="menu-item-9094" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-9094"><a href="#">Vice Chancellor
                                            Dr. Faiz ullah Abbasi 
                                            PS to VC: +92 021 9923 1195/98 Ext: 267 </a></li>
                                    <li id="menu-item-288" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-288"><a href="#">Registrar 
                                            Engr. Capt(R) Syed Waqar Hussain
                                            Ph: +92 21 9923 2645 Ext: 262
                                            registrar@duet.edu.pk </a></li>
                                </ul></div></li>
                        </ul></div></li>      </div>
                <div class="footer_col">
                    <li id="nav_menu-7" class="widget-container widget_nav_menu"><h3 class="widget-title">About Us</h3><div class="menu-footer-library-container"><ul id="menu-footer-library" class="menu"><li id="menu-item-8039" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-8039"><a href="#">Imtiaz Ali Wassan</a></li>
                                <li id="menu-item-6459" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-6459"><a target="_blank" href="#">Abdul Qayyum Laghari</a></li>
                                <li id="menu-item-9379" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-9379"><a href="#">Asghar Ali Lashari</a></li>
                                <li id="menu-item-9380" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-9380"><a href="#">Munesh Kumar Rathore</a></li>
                            </ul></div></li>
                    </ul></div></li>      </div>
        </div>
    </div>

    <div id="site-info">
        <div class="inner_wraper">
            <div class="footer_social"> 
            </div>
            <div class="footer_right">
                Rights Reserved - Dawood unniversity Of Engineering and Technology karachi | Laghari - Wassan - Lashari - Kumar <a href="#" target="_blank" style="color:#fff !important;"></a></p>
            </div>
        </div>
        <!-- #site-info --> 

    </div>
</div>
<!-- #footer -->
</div>
<!-- #wrapper -->
<link rel='stylesheet' id='elite-accordion-plugin-style-css'  href='../wp-content/plugins/elite-accordion/css/elite_style8686.css?ver=4.5.1' type='text/css' media='all' />
<script type='text/javascript' src='../wp-content/plugins/elite-accordion/js/main68b3.js?ver=1'></script>
<script type='text/javascript' src='../wp-content/plugins/elite-accordion/js/modernizr68b3.js?ver=1'></script>
<script type='text/javascript'>
        /* <![CDATA[ */
        var JQLBSettings = {"fitToScreen": "0", "resizeSpeed": "400", "displayDownloadLink": "0", "navbarOnTop": "0", "loopImages": "", "resizeCenter": "", "marginSize": "", "linkTarget": "", "help": "", "prevLinkTitle": "previous image", "nextLinkTitle": "next image", "prevLinkText": "\u00ab Previous", "nextLinkText": "Next \u00bb", "closeTitle": "close image gallery", "image": "Image ", "of": " of ", "download": "Download", "jqlb_overlay_opacity": "80", "jqlb_overlay_color": "#000000", "jqlb_overlay_close": "1", "jqlb_border_width": "10", "jqlb_border_color": "#ffffff", "jqlb_border_radius": "0", "jqlb_image_info_background_transparency": "100", "jqlb_image_info_bg_color": "#ffffff", "jqlb_image_info_text_color": "#000000", "jqlb_image_info_text_fontsize": "10", "jqlb_show_text_for_image": "1", "jqlb_next_image_title": "next image", "jqlb_previous_image_title": "previous image", "jqlb_next_button_image": "http:\/\/habib.edu.pk\/wp-content\/plugins\/wp-lightbox-2\/styles\/images\/next.gif", "jqlb_previous_button_image": "http:\/\/habib.edu.pk\/wp-content\/plugins\/wp-lightbox-2\/styles\/images\/prev.gif", "jqlb_maximum_width": "", "jqlb_maximum_height": "", "jqlb_show_close_button": "1", "jqlb_close_image_title": "close image gallery", "jqlb_close_image_max_heght": "22", "jqlb_image_for_close_lightbox": "http:\/\/habib.edu.pk\/wp-content\/plugins\/wp-lightbox-2\/styles\/images\/closelabel.gif", "jqlb_keyboard_navigation": "1", "jqlb_popup_size_fix": "0"};
        /* ]]> */
</script>
<script type='text/javascript' src='../wp-content/plugins/wp-lightbox-2/wp-lightbox-2.min1894.js?ver=1.3.4.1'></script>
<script type='text/javascript' src='../wp-content/plugins/social-sharing-toolkit/script_2.1.28686.js?ver=4.5.1'></script>
<script type='text/javascript' src='../../connect.facebook.net/en_US/all8686.js?ver=4.5.1#xfbml=1&#038;appId=188707654478'></script>
<script type='text/javascript' src='../wp-content/plugins/social-sharing-toolkit/includes/buttons/button.googleplus8686.js?ver=4.5.1'></script>
<script type='text/javascript' src='../../platform.twitter.com/widgets8686.js?ver=4.5.1'></script>
<script type='text/javascript' src='../wp-includes/js/wp-embed.min8686.js?ver=4.5.1'></script>
<script type="text/javascript" src="../wp-content/themes/duet/js/script.js"></script>
</body>
<!-- Mirrored from habib.edu.pk/about-us/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 02 May 2016 10:03:10 GMT -->
</html>

<script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery("h3.activeClass a").attr("aria-expanded", "true").addClass("active");
            jQuery("div.activeClass").attr("aria-hidden", "false").show();

            jQuery(".mwUpcomingEvents a.pressRelease[href=#]").siblings('a.watchVideo').css('width', '100%');
            jQuery(".mwUpcomingEvents a.watchVideo[href=#]").siblings('a.pressRelease').css('width', '100%');
            jQuery(".singleEvent a.btn[href=#], a.watchVideo[href=#], a.pressRelease[href=#]").hide();
        });
</script>
