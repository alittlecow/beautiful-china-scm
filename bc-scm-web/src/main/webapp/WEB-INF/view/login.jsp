<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.RandomStringUtils" %>

<%
    response.setHeader("Expires", "0");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragrma", "no-cache");
    RandomStringUtils rs = new RandomStringUtils();
    String ping = rs.randomAlphanumeric(10);
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>login</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->



		<!-- ace styles -->

		<link rel="stylesheet" href="/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="/assets/js/html5shiv.js"></script>
		<script src="/assets/js/respond.min.js"></script>
		<![endif]-->
        <style type="text/css">
            .error{
                color: brown;
            }
        </style>
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
									<span class="red">Beautiful</span>
									<span class="white">China</span>
								</h1>
								<h4 class="blue"></h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>

											<form id="loginForm" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
                                                            <label id="login_error" class="error" style="display:none"></label>
															<input type="text" id="username" name="username" class="form-control" placeholder="Username" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
                                                            <%--<label for="password"></label>--%>
															<input type="password" id="password" name="password" class="form-control" placeholder="Password" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>

														<button type="submit" id="loginBtn" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															Login
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<%--<div class="social-or-login center">
												<span class="bigger-110">Or Login Using</span>
											</div>

											<div class="social-login center">
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
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>
													I forgot my password
												</a>
											</div>

											<div>
												<%--<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													I want to register
													<i class="icon-arrow-right"></i>
												</a>--%>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
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
															<input type="email" class="form-control" placeholder="Email" id="forget_email" />
															<label id="forget-info" class="error"></label>
															<i class="icon-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger" id="send_email">
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
								</div><!-- /forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
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
								</div><!-- /signup-box -->
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
        <script type="text/javascript">
             window.jQuery || document.write("<script src='/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
        </script>
        <![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
        <script src="/assets/js/jquery.validate.min.js"></script>
        <script src="/assets/js/security.js"></script>
		<!-- inline scripts related to this page -->
		<script>
			$(document).ready(function(){
				var forget_100002   = "<spring:message code="forget_100002"/>";
				var required_100000 = "<spring:message code="required_100000"/>";
				var email_100001    = "<spring:message code="email_100001"/>";
				var forget_100000   = "<spring:message code="forget_100000"/>";
				var forget_100001   = "<spring:message code="forget_100001"/>";

				var forget_email=$("#forget_email");
				var forgetInfo  =$("#forget-info");
				var send_submit =$("#send_email");
				var reg         =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				forget_email.on("keyup blur",function(){
					if(forget_email.val()==""){
						infoshow(forgetInfo,required_100000,send_submit);
					}else if(!forget_email.val().match(reg)){
						infoshow(forgetInfo,email_100001,send_submit);
					}else if(forget_email.val().match(reg)){
						var jsonEmail=JSON.stringify({email:forget_email.val()});//email.val()转成json格式
						$.ajax({
							type: "POST",
							url: "/resetPassword/uniqueEmail",
							data: jsonEmail,
							contentType: "application/json",
							dataType: "json",
							success: function (data) {
								if (data.result == "fail") {
									infoshow(forgetInfo,forget_100002,send_submit);
								}else{
									infohide(forgetInfo,send_submit);
								}
							}
						});
					}
				});
				send_submit.click(function(){
					if(forget_email.val()==""){
						infoshow(forgetInfo,required_100000,send_submit);
						return;
					}else if(!forget_email.val().match(reg)){
						infoshow(forgetInfo,email_100001,send_submit);
						return;
					}else{
						var jsonEmail=JSON.stringify({email:forget_email.val()});//email.val()转成json格式
						$.ajax({
							type: "POST",
							url: "/resetPassword/uniqueEmail",
							data: jsonEmail,
							contentType: "application/json",
							dataType: "json",
							success: function (data) {
								if (data.result == "fail") {
									infoshow(forgetInfo,forget_100002,send_submit);
									return;
								}else{
									infohide(forgetInfo,send_submit);
									//验证通过
									var json=JSON.stringify({email:forget_email.val()});
									$.ajax({
										type: "POST",
										url: "/resetPassword/sendEmail",
										data: json,
										contentType: "application/json",
										dataType: "json",
										success: function (data) {
											if(data.result=="ok"){
												alert(forget_100000);
											}else{
												alert(forget_100001);
											}
										}
									});
								}
							}
						});
					}
				});
			});
			/**
			 * 信息显示：info-信息框,msg-信息内容,btn-按钮
			 * @param info
			 * @param msg
			 * @param btn
			 */
			function infoshow(info,msg,btn){
				info.show();
				info.text(msg);
				btn.attr("disabled","disabled");
			}
			/**
			 * 信息隐藏：info-信息框,btn-按钮
			 * @param info
			 * @param btn
			 */
			function infohide(info,btn){
				info.hide();
				btn.removeAttr("disabled");
			}
		</script>
		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}


            $().ready(function(){

                validate();

				// 登录
               /* $("#loginBtn").click(function(){
                    validate();
                   /!* *!/
                });*/
			});


            function validate(){
                // 验证
                $("#loginForm").validate({
                    rules: {
                        username: {
                            required: true,
                            maxlength: 20
                        },
                        password: {
                            required: true,
                            maxlength: 20
                        }
                    },
                    messages: {
                        username: {
                            required: "Please enter a username",
                            maxlength: "Your password must be at most 20 characters long"
                        },
                        password: {
                            required: "Please provide a password",
                            maxlength: "Your password must be at most 20 characters long"
                        }
                    },
                    submitHandler:function(form){
						var password = $("#password").val();
                        var key = new RSAKeyPair(
                                "22c29d5bda305e5daa0920b86cd410844a7aead043cfc3f78af2166e86e26eb", "",
                                "102e05ea9849d82b2630523751c1cd1984e92d3b45bf8d1ba0d67b55b0119eb9"
                        );
                        var newpwd = encryptedString(key, password + '<%=ping%>');
                        console.log(newpwd);
                        //$("#password").val(newpwd);
                        //var postData = $("#loginForm").serializeArray();
						var username = $("#username").val();
						var postData = [{name:"username",value:username},{name:"password",value:newpwd}];
                        $.ajax({
                            url: "/login/platformLogin",
                            type:"POST",
                            data:postData,
                            dataType : "json",
                            success: function(data){
                                if(data.result=="ok"){
                                    window.localStorage.setItem('user',JSON.stringify(data.data));
                                    window.location.href = "/app/index.html"
                                }else {
                                    $("#login_error").html(data.msg);
                                    $("#login_error").show();
                                    $("#password").val('');
                                }
                            }
                        });
                    },
                    onfocusout: function(element) {
                        //$(element).valid();
                        $("#login_error").html('');
                        $("#login_error").hide();
                    }
                });
            }

		</script>
	</body>
</html>
