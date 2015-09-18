<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/dist/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div class="registration">
        <div id="wrapper">
            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Registration</h1>
                            <div class="registration-container">
                            	<form:form id="storeForm" method="POST" commandName="store" action="${pageContext.request.contextPath}/saveDetails">
                                    <p><span>*</span> indicate required information</p>
                                    <fieldset>
                                        <legend>Please fill in the details</legend>
                                        <div class="col-md-6 left-container">
                                            <div class="clearfix">
                                            <label class="col-sm-3">First Name*</label>
                                            <form:input class="col-sm-9" path="firstname" id="firstname" name="firstname" placeholder="Enter First Name" required="true"/>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Middle Name</label>
                                            <form:input class="col-sm-9" path="middlename" id="middlename" name="middlename" placeholder="Enter Middle Name" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Last Name*</label>
                                            <form:input class="col-sm-9" path="lastname" id="lastname" name="lastname" placeholder="Enter Last Name" required="true"/>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Owner Name*</label>
                                            <form:input class="col-sm-9" path="ownername" id="ownername" name="ownername" placeholder="Enter Owner Name" required="true"/>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Shop Name*</label>
                                            <form:input class="col-sm-9" path="storename" id="storename" name="storename" placeholder="Enter Shop Name" required="true"/>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Shop License Number*</label>
                                            <form:input class="col-sm-9" path="licennceno" id="licennceno" name="licennceno" placeholder="Enter Shop License Number" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Address*</label>
                                            <form:textarea class="col-sm-9" path="address" id="address" name="address" placeholder="Enter Address" required="true"></form:textarea>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Phone Number*</label>
                                            <form:input class="col-sm-9" path="primarycontactno" id="phonenumber" name="phonenumber" placeholder="Enter phone Number" required="true"/>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Pincode*</label>
                                            <form:input class="col-sm-9" path="pin" id="pinCode" name="pinCode" placeholder="Enter Pincode" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">City*</label>
                                            <form:select class="col-sm-6" path="city" name="city" id="city" required="true">
										   		<form:option value="0" label="--- Select ---"/>
										   		<form:options items="${cityList}" itemValue="id" itemLabel="cityname"/>
											</form:select>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">State*</label>
                                            <form:select class="col-sm-6" path="state" name="state" id="state" required="true">
										   		<form:option value="0" label="--- Select ---"/>
										   		<form:options items="${stateList}" itemValue="id" itemLabel="statename"/>
											</form:select>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Country*</label>
                                            <form:select class="col-sm-6" path="country" name="country" id="country" required="true">
										   		<form:option value="0" label="--- Select ---"/>
										   		<form:options items="${countryList}" itemValue="id" itemLabel="countryname"/>
											</form:select>
                                        </div>    
                                        </div>
                                        <div class="col-md-6 right-container">
                                            <div class="clearfix">
                                            <label class="col-sm-3">Email*</label>
                                            <form:input class="col-sm-9" path="emailid" type="email" id="emailid" name="emailid" placeholder="Enter Email" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">User Name*</label>
                                            <form:input class="col-sm-9" path="username" id="username" name="username" placeholder="Enter User Name" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Password*</label>
                                            <form:input class="col-sm-9" path="password" type="password" id="password" name="password" placeholder="Enter Password" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Confirm Password*</label>
                                            <form:input class="col-sm-9" path="password" type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" required="true" />
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">Gender*</label>
                                            <form:select class="col-sm-3" path="gender" name="gender" id="gender" required="true">
                                                <form:option value="0" label="--- Select ---"/>
                                                <form:option value="1" label="Male"/>
                                                <form:option value="2" label="Female"/>
                                                <form:option value="3" label="Other"/>
                                            </form:select>
                                        </div>
                                        <div class="clearfix">
                                            <label class="col-sm-3">How do u know about us?</label>
                                            <form:textarea class="col-sm-9" path="extrainfo" rows="5" id="howdoyouknowaboutus" name="howdoyouknowaboutus" placeholder="Let us know"></form:textarea>
                                        </div>    
                                        </div>
                                        
                                        <div class="row clearfix">
                                            <div class="col-lg-12">
                                                <div class="col-md-6">
                                                    <div class="clearfix">
                                                        <input type="checkbox" class="checkbox" id="agree" name="agree" required="true" />I agree to the Privacy Policy and Terms &amp; Conditions
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="registration-submit">
                                                        <input class="btn btn-primary" type="submit" id="submit" name="submit" value="Submit" />
                                                        <input class="btn" type="reset" value="Reset"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>      
                                    </fieldset>
                                </form:form>
                            </div>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->
    </div>
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/dist/js/sb-admin-2.js"></script>

    <!-- Validate Javascript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/dist/js/register-validation.js"></script>
</body>

</html>
