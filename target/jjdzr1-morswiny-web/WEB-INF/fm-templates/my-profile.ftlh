<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My profile</title>
    <link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>



</head>
<body>

<#include "header.ftlh">
<div>
    <ol class="breadcrumb primary-color">
        <li class="breadcrumb-item"><a class="white-text" href="/main-page">Home</a></li>
        <li class="breadcrumb-item white-text">Profile</li>
    </ol>
</div>


<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>Hello ${User.getName()}</h1></div>
    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center" style="padding-top: 30px">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                     alt="avatar">
                <p>Upload a different photo</p>
                <input type="file" class="form-control-file" id="exampleFormControlFile1">
            </div>
            </hr><br>


            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Events created:</strong></span>
                    0
                </li>
                <li class="list-group-item text-right"><span
                            class="pull-left"><strong>Favourites:</strong></span> ${User.getFavourites()?size}
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>TBA</strong></span> 0
                </li>
            </ul>
            <br>
            <!--
            <ul class="list-group">
                <li class="list-group-item text-muted">Admin Panel <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Events deleted:</strong></span>

                </li>
                <li class="list-group-item text-right"><span
                            class="pull-left"><strong>Accounts deleted:</strong></span> 13
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Reports:</strong></span>
                    37
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Active Tickets:</strong></span>
                    78
                </li>
            </ul>
            -->

        </div><!--/col-3-->
        <div class="col-sm-9" style="padding-top: 40px">
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <input type="radio" name="options" id="option1" checked> Settings
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="options" id="option2"> Favourites
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="options" id="option3"> Events added
                </label>
            </div>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <#if dataChangeSuccess??>
                        <p style="color: green">Data changed successfully</p>
                    </#if>
                    <form class="form" action="profile" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name"><h4>First name</h4></label>
                                <input type="text" class="form-control" name="name" id="first_name"
                                       placeholder=${User.getName()} >
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="surname"><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="surname" id="last_name"
                                       placeholder=${User.getSurname()}>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Address Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email"
                                       placeholder=${User.getEmail()} disabled>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="***" >
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h6>Upcoming Events email notifications</h6></label><br>
                                <label class="switch">
                                    <input type="checkbox">
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h6>Special promotions email notifications</h6></label><br>
                                <label class="switch">
                                    <input type="checkbox">
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12" >
                                <br>
                                <button type="submit" class="btn btn-success">Edit and save</button>
                            </div>
                        </div>
                    </form>
                    <form method="post" action="DeleteAccount">
                        <button style="text-align: end" type="submit" class="btn btn-danger" style="margin-left: 10px">Delete my account</button>
                    </form>
                    <hr>

                </div><!--/tab-pane-->
                <div class="tab-pane" id="messages">

                    <h2></h2>

                    <hr>
                    <form class="form" action="##" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name"><h4>First name</h4></label>
                                <input type="text" class="form-control" name="first_name" id="first_name"
                                       placeholder="first name" title="enter your first name if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name"><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="last_name" id="last_name"
                                       placeholder="last name" title="enter your last name if any.">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control" name="phone" id="phone"
                                       placeholder="enter phone" title="enter your phone number if any.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile"><h4>Mobile</h4></label>
                                <input type="text" class="form-control" name="mobile" id="mobile"
                                       placeholder="enter mobile number" title="enter your mobile number if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email"
                                       placeholder="you@email.com" title="enter your email.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Location</h4></label>
                                <input type="email" class="form-control" id="location" placeholder="somewhere"
                                       title="enter a location">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="password" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="password2"
                                       placeholder="password2" title="enter your password2.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                </button>
                                <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset
                                </button>
                            </div>
                        </div>
                    </form>

                </div><!--/tab-pane-->
                <div class="tab-pane" id="settings">


                    <hr>
                    <form class="form" action="##" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name"><h4>First name</h4></label>
                                <input type="text" class="form-control" name="first_name" id="first_name"
                                       placeholder="first name" title="enter your first name if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name"><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="last_name" id="last_name"
                                       placeholder="last name" title="enter your last name if any.">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control" name="phone" id="phone"
                                       placeholder="enter phone" title="enter your phone number if any.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile"><h4>Mobile</h4></label>
                                <input type="text" class="form-control" name="mobile" id="mobile"
                                       placeholder="enter mobile number" title="enter your mobile number if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email"
                                       placeholder="you@email.com" title="enter your email.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Location</h4></label>
                                <input type="email" class="form-control" id="location" placeholder="somewhere"
                                       title="enter a location">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="password" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="password2"
                                       placeholder="password2" title="enter your password2.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-12" style="align-content: end">
                                <br>
                                <button type="submit" class="btn btn-success">Save</button>
                                <button type="reset" class="btn btn-light">Reset</button>

                            </div>
                        </div>
                    </form>
                </div>

            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->
</body>
</html>