<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Event</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker-standalone.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
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
        <li class="breadcrumb-item white-text"><a class="white-text" href="/single-event?id=${event.getId()}">Single
                Event</a></li>
        <li class="breadcrumb-item breadcrumb-active">Edit Event</li>
    </ol>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img"
                     src="/Images/morswin.png" height="130" width="130"
                     alt="">
                <form class="form-create" action="/edit-event" method="POST">
                    <div class="form-group">
                        <center><h2>Edit Event</h2></center>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventName">Name</label>
                        <input id="eventName" name = "eventName" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getName()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventPlace">Place</label>
                        <input id="eventPlace" name ="eventPlace" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getPlace().getName()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="organizer">Organizer</label>
                        <input id="organizer" name = "organizer" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getOrganizer().getDesignation()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="eventURL">URL</label>
                        <input id="eventURL" name="eventURL" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getUrls().getWww()}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="startDate">Start Date</label>
                        <div class='input-group date' id='startDate'>
                            <input type='text' name= "startDate" class="form-control" contenteditable="true"
                                   value=${event.getStartDate()} required/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#startDate').datetimepicker({
                                        format: 'DD MMMM YYYY H:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="endDate">End Date</label>
                        <div class='input-group date' id='endDate'>
                            <input type='text' name= "endDate" class="form-control" contenteditable="true"
                                   value=${event.getEndDate()} required/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#endDate').datetimepicker({
                                        format: 'DD MMMM YYYY H:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="description">Description</label>
                        <textarea id="description" name="description" cols="20" rows="10"
                                  class="form-control">${event.getDescLong()}</textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="ticket">Ticket</label>
                        <input name="ticket" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getTickets().getType()}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="categoryId">Category Id</label>
                        <input name="categoryId" type="text" maxlength="100" class="form-control" contenteditable="true"
                               value="${event.getCategoryId()}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="active">Active</label><br>
                        <input type="radio" name="active" id="active" value="1" checked="checked">
                        Yes
                        <input type="radio" name="active" id="active" value="0">
                        No
                    </div>
                    <div class="form-group">
                        <label class="form-group" for="attachment">Attach event image</label>
                        <label for="attachment"></label>
                        <input type="file" name = "attachment" class="form-control-file" id="attachment">
                    </div>
                    <form action="/search-events?search=">
                        <div>
                            <input class="btn btn-lg btn-primary btn-block" type="submit"
                                    value="Apply"/>
                        </div>
                    </form>
                    <br>
                    <p class="form-group">By creating an event, you agree to our <a href="#">Terms of Use</a> and our
                        <a href="#">Privacy Policy</a>.</p>

                </form>
            </div>
        </div>
    </div>
</div>
<#--<#include "footer.ftlh">-->
</body>
</html>