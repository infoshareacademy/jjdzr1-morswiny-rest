<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
    <link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
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
    <ol class="breadcrumb primary-color">
        <li class="breadcrumb-item"><a class="white-text" href="/main-page">Home</a></li>
        <li class="breadcrumb-item breadcrumb-active">About Us</li>
    </ol>
</div>

<div>
    <div>
        <p style="text-align: center">Developers Team Project:</p>
        <img src="../Images/morswinOFF2.gif" class="center">
    </div>
</div>
<br>

<p style="text-align: center">Technologies we used:</p>
<div id="carouselExampleIndicators" class="carousel slide carouselstyle" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../Images/technolopgies.png" class="d-block w-100 center" alt="...">
        </div>
        <div class="carousel-item">
            <img src="../Images/sprint3.png" class="d-block w-100 center" alt="...">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br>

<div>
    <div>
        <p style="text-align: center">in cooperation with:</p>
        <img src="../Images/infoshare.png" class="center">
    </div>
</div>

<!--Grid row-->
<div class="row" style="text-align: center">

    <!--Grid column-->
    <div class="col-md-6 mb-4 center">

        <!--Card-->
        <div class="card card-cascade narrower">

            <!--Card image-->
            <div class="view view-cascade gradient-card-header blue-gradient">
                <h5 class="mb-0" style="margin-top: 20px">Infoshare Academy Location</h5>
            </div>
            <!--/Card image-->

            <!--Card content-->
            <div class="card-body card-body-cascade text-center">

                <!--Google map-->
                <div id="map-container-google-8" class="z-depth-1-half map-container-5" style="height: 300px">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d4644.656935682813!2d18.570166022719658!3d54.40417545568694!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x29ab463b3b839ab7!2sinfoShare%20Academy%20sp.%20z%20o.o.!5e0!3m2!1spl!2spl!4v1598782631271!5m2!1spl!2spl"
                            width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""
                            aria-hidden="false" tabindex="0"></iframe>
                </div>

            </div>
            <!--/.Card content-->

        </div>
        <!--/.Card-->

    </div>
    <!--Grid column-->

</div>

<div><p style="text-align: center">Developers Team Members:</p><br>

    <div class="content">
        <img src="../Images/profile-pictures/mateuszstopyra.png">
        <div class="text">
            <h3><strong>Mateusz Stopyra</strong></h3>
            <p>__________________________</p>
            <p>Junior Java Developer</p>
            <p>infoShare Academy</p>
        </div>
    </div><br><br><br><br><br>
    <div class="content">
        <div class="text">
            <h3><strong>Tomek Miecielica</strong></h3>
            <p>__________________________</p>
            <p>Junior Java Developer</p>
            <p>infoShare Academy</p>
        </div>
        <img src="../Images/profile-pictures/TM.png">
    </div><br><br><br><br><br>
    <div class="content">
        <img src="../Images/profile-pictures/as.png">
        <div class="text">
            <h3><strong>   Agata Sudoł</strong></h3>
            <p>___________________</p>
            <p>Junior Java Developer</p>
            <p>infoShare Academy</p>
        </div>
    </div><br><br><br><br><br>
    <div class="content">
        <div class="text">
            <h3><strong>Jakub Bieńkowski</strong></h3>
            <p>____________________________</p>
            <p>Junior Java Developer</p>
            <p>infoShare Academy</p>
        </div>
        <img src="../Images/profile-pictures/KB.png">
    </div><br><br><br><br><br>
    <div class="content">
        <img src="../Images/profile-pictures/PZ.png">
        <div class="text">
            <h3><strong>Przemysław Zieliński</strong></h3>
            <p>________________________________</p>
            <p>Junior Java Developer</p>
            <p>infoShare Academy</p>
        </div>
    </div><br><br><br><br><br>

</div>

</body>
</html>