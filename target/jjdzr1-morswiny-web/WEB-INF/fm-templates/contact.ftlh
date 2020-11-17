<!doctype html>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <title>Contact us</title>
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
<div>
    <ol class="breadcrumb primary-color bold-text">
        <li class="breadcrumb-item white-text"><a href="/main-page">Home</a></li>
        <li class="breadcrumb-item breadcrumb-active white-text">Contact</li>
    </ol>
</div>
<div class="d-flex p-2 justify-content-center">
    <h4>Feel free to contact us: </h4>
</div>
<br>
<div class="d-flex p-2 justify-content-center">
    <form name="emailForm" method="post" action="contact" accept-charset="UTF-8">
        <div class="form-group">
            <label for="mailAddress">E-mail address:</label><br>
            <input type="email" class="form-control" name ="mailAddress" placeholder="Enter email" required>
        </div>
        <div class="form-group">
            <label for="subject">Subject:</label><br>
            <input type="text" class="form-control" name="subject" placeholder="Enter subject">
        </div>
        <div class="form-group">
            <label for="message">Message:</label><br>
            <textarea class="form-control" name="message" placeholder="Enter message here" rows="6" cols="50"></textarea>
        </div>
        <div class="d-flex p-2 justify-content-center">
            <input type="submit" value="Submit" class="btn btn-primary">
        </div>
    </form>
</div>
<br>
<img src="../Images/morswinOFF2.gif" class="contact-center">
</body>
</html>