<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Morświny Events Home Page</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/./Images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/./Images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/./Images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/./Images/favicon/site.webmanifest">
    <link rel="mask-icon" href="/./Images/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <link rel="canonical" href="/web/tweet-button">
    <link rel="me" href="https://twitter.com/twitterdev">
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

    <style>
        .dark-mode {
            background-color: #222831;
            color: gray;
        }
        .zoom {
            transition: transform .2s;
        !important;
            margin: 0 auto;
        !important;
        }

        .zoom:hover {
            transform: scale(1.1);
        !important;
        }

        .switch {
            position: relative;
            display: inline-block;
            width: 60px;
            height: 20px;
        }

        .switch input {
            display: none;
        }

        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #adadad;
            -webkit-transition: .4s;
            transition: .4s;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 13px;
            width: 13px;
            left: 4px;
            bottom: 4px;
            background-color: white;
            -webkit-transition: .4s;
            transition: .4s;
        }

        input:checked + .slider {
            background-color: #222831;
        }

        input:focus + .slider {
            box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .slider:before {
            -webkit-transform: translateX(37px);
            -ms-transform: translateX(37px);
            transform: translateX(37px);
        }

        /*------ ADDED CSS ---------*/
        .on {
            display: none;
        }

        .on, .off {
            color: white;
            position: absolute;
            transform: translate(-50%, -50%);
            top: 50%;
            left: 50%;
            font-size: 8px;
            font-family: Verdana, sans-serif;
        }

        input:checked + .slider .on {
            display: block;
        }

        input:checked + .slider .off {
            display: none;
        }

        /*--------- END --------*/

        /* Rounded sliders */
        .slider.round {
            border-radius: 15px;
        }

        .slider.round:before {
            border-radius: 50%;
        }
    </style>

</head>
<body>

<#include "header.ftlh">

<div>
    <ol class="breadcrumb primary-color">
        <li class="breadcrumb-item white-text">Home Page</li>
    </ol>
</div>


<div class="card text-center">
    <div class="card-header">
        Featured News
    </div>
    <div class="card-body">
        <h4 class="card-title"> Welcome! </h4>
        <p class="card-text">
            We believe that culture is vital for every nation and person. <br>
            You can find here many pieces of information concerning latest cultural events in Gdansk. <br>
            Search for, add to favourites, register your own events! <br>
            Have fun! :-) <br>
        </p>
    </div>
</div>

<div class="container">
    <br/>
    <div class="row justify-content-center">
        <div class="col-12 col-md-10 col-lg-8">
            <form class="card card-sm" action="/search-events">
                <div class="card-body row no-gutters align-items-center">
                    <div class="col-auto">
                        <i class="fas fa-search h4 text-body"></i>
                    </div>
                    <!--end of col-->
                    <div class="col">
                        <input class="form-control form-control-lg form-control-borderless" type="search"
                               placeholder="Search events by topics or keywords" name="search">
                    </div>
                    <!--end of col-->
                    <div class="col-auto">
                        <button class="btn btn-lg btn-success fa fa-search" type="submit">Search</button>
                    </div>

                    <!--end of col-->
                </div>
            </form>
        </div>
        <!--end of col-->
    </div>
</div>
<br/>

<h5><p style="margin-left: 15px">Latest events coming: </p></h5>


<div class="card-deck">
    <#list listOfMainEvents as event>
        <div class="card">
            <#if event.getAttachments()?size = 0>
                <img src="/Images/morswin.png" class="card-img-top" style="height: auto; max-width: 620px;" alt="...">
            <#else>
                <img src="${event.attachments[0].getFileName()}" style="height: 590px; width: 620px;">
            </#if>
            <div class="card-body">
                <h5>${event.name}</h5>
            </div>
            <div style="margin-left: 20px">
                <div>
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar-date" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z"/>
                        <path fill-rule="evenodd"
                              d="M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1zm1-3a2 2 0 0 0-2 2v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2H2z"/>
                        <path fill-rule="evenodd"
                              d="M3.5 0a.5.5 0 0 1 .5.5V1a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 .5-.5zm9 0a.5.5 0 0 1 .5.5V1a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 .5-.5z"/>
                    </svg>
                    ${event.startDate} - ${event.endDate}
                </div>
                <div>
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-geo-alt" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                    </svg>
                    ${event.getPlace().getName()}
                    <#if event.getPlace().getSubname()??>
                        - ${event.getPlace().getSubname()}
                    </#if>
                </div>
                <br>
                <div>
                    <a class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/"
                       data-layout="button" data-size="large" target="_blank"
                       href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp" src="sdkpreparse"
                       class="fb-xfbml-parse-ignore">Share</a></br>
<#--                    dlaczego tutaj nie ma oddzielenia ?!-->
                    </br><a class="twitter-share-button" data-layout="button" data-size="large"
                       href="https://twitter.com/intent/tweet">
                        Tweet</a>
                </div>
                <div style="text-align: end; margin-right: 20px; margin-bottom: 20px">
                    <#if event.getUrls().www ?has_content>
                        <a href= ${event.getUrls().www}>
                            <button type="button" class="btn btn-primary">Buy tickets</button>
                        </a>
                    </#if>
                    <a href="main-page?addEvent=#{event.getEventId()}" role="button">
                        <button type="submit" class="btn btn-secondary">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                            </svg>
                        </button>
                    </a>
                    <a href="/single-event?id=#{event.getEventId()}">
                        <button type="button" class="btn btn-info">Info</button>
                    </a>
                </div>
            </div>
        </div>
    </#list>
</div>


<script>
    function myFunction() {
        var element = document.body;
        element.classList.toggle("dark-mode");
    }
</script>

<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_EN/sdk.js#xfbml=1&version=v8.0"
        nonce="26lxUPcI"></script>

<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

</body>
</html>