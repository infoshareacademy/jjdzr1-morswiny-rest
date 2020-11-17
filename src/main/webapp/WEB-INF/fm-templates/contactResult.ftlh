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
    <#if Success??>
        <h4>Your e-mail was sent successfully!</h4>
    <#else>
        <h4>Your e-mail could not be sent!</h4>
    </#if>
</div>
<div class="d-flex p-2 justify-content-center">
    <a href="/main-page">Go back to main page</a>
</div>
<img src="../Images/morswinOFF2.gif" class="contact-center">
<br>
</body>
</html>