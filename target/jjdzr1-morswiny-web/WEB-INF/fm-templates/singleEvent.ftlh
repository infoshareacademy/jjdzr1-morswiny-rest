<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${event.getName()}</title>
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
        <li class="breadcrumb-item white-text"><a href="/search-events?search=">All events</a></li>
        <li class="breadcrumb-item breadcrumb-active white-text">${event.getName()}</li>
    </ol>
</div>
<div class="container">
    <div class="row event-info">
        <div class="col-4 thumbnail picture-singleevent">
            <picture>
                <#if picture??>
                    <source srcset="${picture}">
                </#if>
                <img src="Images/morswin.png" alt="Morświn events" class="rounded picture-singleevent" />
            </picture>
        </div>
            <div class="col-8">
                <h3 class="bold-text">${event.getName()}</h3>
                <h4>Place: ${event.getPlace().getName()}</h4>
                <#if event.getPlace().getSubname()??>
                    <h4>${event.getPlace().getSubname()}</h4>
                </#if>
                <h4>Start: ${event.getStartDate()}</h4>
                <h4>End: ${event.getEndDate()}</h4>
                <h6>Organised by: ${event.getOrganizer().getDesignation()}</h6>
            </div>
        </div>
    <div class="row">
        <div class="col">
            <p class="p-singleevent">${event.getDescLong()}</p>
        </div>
    </div>
        <div class="row d-flex justify-content-center buttons-for-event">
            <#if tickets??>
                <a href="${tickets}" class="button-singleevent" role="button">Tickets and more information</a>
            <#else>
                <button class="button-singleevent" type="button" disabled>Tickets and more information</button>
            </#if>
            <a href="/single-event?id=#{event.getEventId()}&addEvent=#{event.getEventId()}" class="button-singleevent" role="button">Add event to favourites</a>
            <a href="/edit-event?id=${event.getEventId()}" class="button-singleevent" role="button"> Edit event </a>
            <a href="/delete-event?id=${event.getEventId()}" class="button-singleevent" role="button"> Delete event </a>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>