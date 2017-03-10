<%@ page import="org.apache.commons.lang.RandomStringUtils" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: chenghuanhuan
  Date: 16/1/29
  Time: 下午6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>修改密码</title>
    <meta name="keywords" content="BootstrapÄ£°æ,BootstrapÄ£°æÏÂÔØ,Bootstrap½Ì³Ì,BootstrapÖÐÎÄ" />
    <meta name="description" content="JS´úÂëÍøÌá¹©BootstrapÄ£°æ,Bootstrap½Ì³Ì,BootstrapÖÐÎÄ·­ÒëµÈÏà¹ØBootstrap²å¼þÏÂÔØ" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->



    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">Ace</span>
                            <span class="white">Application</span>
                        </h1>
                        <h4 class="blue">&copy; Company Name</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        Please Enter Your Password
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="resetForm">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" id="password1" name="password1"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" id="password2" name="password2"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <%--<label class="inline">
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl"> Remember Me</span>
                                                </label>--%>

                                                <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="reset_submit">
                                                    <i class="icon-key"></i>
                                                    Submit
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                   <%-- <div class="social-or-login center">
                                        <span class="bigger-110">Or Login Using</span>
                                    </div>--%>

                                   <%-- <div class="social-login center">
                                        <a class="btn btn-primary">
                                            <i class="icon-facebook"></i>
                                        </a>

                                        <a class="btn btn-info">
                                            <i class="icon-twitter"></i>
                                        </a>

                                        <a class="btn btn-danger">
                                            <i class="icon-google-plus"></i>
                                        </a>
                                    </div>--%>
                                </div><!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <%--<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            I forgot my password
                                        </a>--%>
                                    </div>

                                    <div>
                                       <%-- <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                                            I want to register
                                            <i class="icon-arrow-right"></i>
                                        </a>--%>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->

                        <%--<div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        Retrieve Password
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        Enter your email and to receive instructions
                                    </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="icon-lightbulb"></i>
                                                    Send Me!
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        Back to login
                                        <i class="icon-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div>--%><!-- /forgot-box -->

                        <%--<div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="icon-group blue"></i>
                                        New User Registration
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> Enter your details to begin: </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Repeat password" />
															<i class="icon-retweet"></i>
														</span>
                                            </label>

                                            <label class="block">
                                                <input type="checkbox" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
                                </label>

                                <div class="space-24"></div>

                                <div class="clearfix">
                                    <button type="reset" class="width-30 pull-left btn btn-sm">
                                        <i class="icon-refresh"></i>
                                        Reset
                                    </button>

                                    <button type="button" class="width-65 pull-right btn btn-sm btn-success">
                                        Register
                                        <i class="icon-arrow-right icon-on-right"></i>
                                    </button>
                                </div>
                                </fieldset>
                                </form>
                            </div>

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        <i class="icon-arrow-left"></i>
                                        Back to login
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div>--%><!-- /signup-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="/assets/js/jquery.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
</script>
<%
    RandomStringUtils rs = new RandomStringUtils();
    String ping = rs.randomAlphanumeric(10);
%>
<input type="hidden" id="ping" value="<%=ping%>">
<input type="hidden" id="user_name" value="${username}">
<script src="/assets/js/jquery.validate.min.js"></script>
<script src="/assets/js/security.js"></script>
<script>

    $(document).ready(function(){
        var reset_100000     = "<spring:message code="reset_100000"/>";
        var reset_100001     = "<spring:message code="reset_100001"/>";
        var required_100000  = "<spring:message code="required_100000"/>";
        var equalTo_100002   = "<spring:message code="equalTo_100002"/>";
        var minlength_100003 = "<spring:message code="minlength_100003"/>";

        var password1   = $("#password1");
        var reset_submit= $("#reset_submit");
        var user_name   = $("#user_name").val();
        $("#resetForm").validate({
            rules : {
                password1:{
                    minlength : 6,
                    required : true,
                },
                password2:{
                    equalTo : '#password1',
                    required : true,
                },
            },
            messages:{
                password1:{
                    minlength : minlength_100003,
                    required : required_100000,
                },
                password2:{
                    equalTo : equalTo_100002,
                    required : required_100000,
                },
            },
        });
        reset_submit.click(function(){
            if($("#resetForm").valid()){
                var ping=$("#ping").val();
                var key = new RSAKeyPair(
                        "22c29d5bda305e5daa0920b86cd410844a7aead043cfc3f78af2166e86e26eb", "",
                        "102e05ea9849d82b2630523751c1cd1984e92d3b45bf8d1ba0d67b55b0119eb9"
                );
                var newpwd = encryptedString(key, password1.val() + ping);
                var json=JSON.stringify({password:newpwd,loginName:user_name});
                $.ajax({
                    type: "POST",
                    url: "/resetPassword/reset",
                    data: json,
                    contentType: "application/json",
                    dataType: "json",
                    success: function (data) {
                        if (data.result == "ok") {
                            alert(reset_100000);
                            window.location.href="login";
                        } else {
                            alert(reset_100001);
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>
