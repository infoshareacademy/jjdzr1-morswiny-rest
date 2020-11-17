<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/./Images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/./Images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/./Images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/./Images/favicon/site.webmanifest">
    <link rel="mask-icon" href="/./Images/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body>
<#include "header.ftlh">
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img"
                     src="../Images/morswin.png" height="130" width="130"
                     alt="">
                <form class="form-signin" name="userRegistrationForm" method="post" action="createAccount" accept-charset="UTF-8">
                    <div class="form-group">
                        <center><h2>Create an account</h2></center>
                    </div>
                    <#if success??>
                        <h3 style="text-align: center">Account was created successfully. Click <a href="/login">here</a> to log in.</h3>
                    <#elseif accountExist??>
                        <h5 style="color:red ">There is account associated with this email. Try to log in</h5>
                    <#elseif error??>
                        <h5 style="color:red">There was an error during registration process!</h5>
                    </#if>
                <div class="form-group">
                    <label class="control-label" for="signupName">First Name</label>
                    <input id="signupName" name="name" type="text" maxlength="50" class="form-control" required>
                </div>
                <div class="form-group">
                    <label class="control-label" for="signupName">Last Name</label>
                    <input id="signupSurname" name="surname" type="text" maxlength="50" class="form-control" required>
                </div>
                <div class="form-group">
                    <label class="control-label" for="signupEmail">Address E-mail</label>
                    <input id="signupEmail" name="email" type="email" maxlength="50" class="form-control" required>
                </div>
                <div></div>
                <div class="form-group">
                    <label class="control-label" for="signupPassword">Password</label>
                    <input id="signupPassword" name="password" type="password" maxlength="25" class="form-control"
                           placeholder="at least 6 characters" length="40" required>
                </div>
                <div class="form-group">
                    <label class="control-label" for="signupPasswordagain">Password verify</label>
                    <input id="signupPasswordagain" type="password" maxlength="25" class="form-control"
                           placeholder="at least 6 characters" length="40" required>
                </div>
                <div>
                    <input type="submit" value="Submit" class="btn btn-lg btn-primary btn-block">
                </div>
                <br>
                <p class="form-group">By creating an account, you agree to our <a href="#">Terms of Use</a> and our
                    <a href="#">Privacy Policy</a>.</p>
                <hr>
                <p>Already have an account? <a href="/login">Sign in</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>