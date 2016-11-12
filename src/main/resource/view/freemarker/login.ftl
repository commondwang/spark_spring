<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Edit configuration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="../flat-ui/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="../flat-ui/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="../flat-ui/img/favicon.ico">
    <link rel="stylesheet" href="../css/all.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="../flat-ui/js/vendor/html5shiv.js"></script>
    <script src="../flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<#--<#if user>-->
    <#--<pre>${user.userName}</pre>-->
<#--</#if>-->
<#--<#include "nav.ftl"/>-->
<div class="container login-main">
    <h3 class="text-center">Sign In</h3>
    <div class="main-login main-center">
        <form class="form-horizontal" method="post" action="/login">
            <div class="form-group">
                <label for="username" class="cols-sm-2 control-label">Username</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="cols-sm-2 control-label">Password</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
                        <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Login</button>
            </div>
        </form>
    </div>
</div>
<!-- /.container -->


<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="../flat-ui/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../flat-ui/js/vendor/video.js"></script>
<script src="../flat-ui/js/flat-ui.min.js"></script>
<script>

</script>
</body>
</html>
