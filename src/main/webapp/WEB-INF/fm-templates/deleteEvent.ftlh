<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Event </title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/log-in.css">
    <link rel="apple-touch-icon" sizes="180x180" href="/./Images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/./Images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/./Images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/./Images/favicon/site.webmanifest">
    <link rel="mask-icon" href="/./Images/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
</head>
<body>
<#setting number_format="00000">
<#--<#include "header.ftlh">-->
<div>
    <ol class="breadcrumb primary-color">
        <li class="breadcrumb-item"><a class="white-text" href="/main-page">Home</a></li>
        <li class="breadcrumb-item breadcrumb-active">Delete Event</li>
    </ol>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall" style="text-align:center">
                <img class="profile-img"
                     src="/Images/morswin.png"  height="130" width="130"
                     alt="">
                        <h3> Event has been deleted </h3>
                    <br>
                    <div>
                        <p>Go back to <a href="/search-events?=search="> all events.</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#--<#include "footer.ftlh">-->
</body>
</html>