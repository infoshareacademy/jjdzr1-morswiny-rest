<!--<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="media">
        <a href="main-page"><img src="/Images/morswin.png" height="80" width="80" class="mr-3" alt="..."></a>
    </div>
    <a class="navbar-brand" href="#"><b>Morświny Events</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="search-events?search=">Events</a>
            </li>
            <#if logged??>
                <li class="nav-item active">
                    <a class="nav-link" href="/add-event">Add Event</a>
                </li>
            <#else>
                <li class="nav-item active">
                    <a class="nav-link" href="/login">Add Event</a>
                </li>
            </#if>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Filter
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="my-profile.html">Filter by Date</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Place</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Ticket Price</a>
                </div>
            </li>
            <li class="nav-item active">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/contact">Contact</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/HTML/abous-us.html">About Us</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search-events?">
            <input class="form-control mr-sm-2" type="search" placeholder="Type here..." name = "search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div>
            <a href="/HTML/log-in.html">
                <button type="button" style="position:relative; right:-5px;" class="btn btn-outline-primary">Log in
                </button>
            </a>
        </div>

    </div>
</nav>
/-->

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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="zoom media">
        <a href="/main-page"><img src="../Images/morswin.png"
                                 style="margin-left: 2px; margin-top: 2px; margin-bottom: 2px" height="80" width="80"
                                 class="mr-3" alt="..."></a>
    </div>
    <a class="navbar-brand" href="#"><b>Morświny Events</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active zoom">
                <a class="nav-link" href="search-events?search=">Events</a>
            </li>
            <#if admin??>
                <li class="nav-item active zoom">
                    <a class="nav-link" href="/loadEvents">Add new Data</a>
                </li>
            </#if>
            <#if logged??>
                <li class="nav-item active zoom">
                    <a class="nav-link" href="/add-event">Add Event</a>
                </li>
            <#else>
                <li class="nav-item active zoom">
                    <a class="nav-link" href="/login">Add Event</a>
                </li>
            </#if>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle zoom" href="#" id="navbarDropdownMenuLink" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Filter
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="my-profile.html">Filter by Date</a>
                        <a class="dropdown-item" href="my-profile.html">Filter by Place</a>
                        <a class="dropdown-item" href="my-profile.html">Filter by Ticket Price</a>
                    </div>
                </li>
                <#if admin??>
                <li class="nav-item active">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
                </#if>
                <li class="nav-item active zoom">
                    <a class="nav-link" href="/contact">Contact</a>
                </li>
                <li class="nav-item active zoom">
                    <a class="nav-link" href="/about-us">About Us</a>
                </li>
            </div>
            <li>
                <label class="switch" style="margin-top: 5px"><input type="checkbox" id="togBtn">
                    <div onclick="myFunction()" class="slider round"><!--ADDED HTML --><span class="on"><svg width="2em"
                                                                                                             height="2em"
                                                                                                             viewBox="0 0 16 16"
                                                                                                             class="bi bi-moon"
                                                                                                             fill="currentColor"
                                                                                                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M14.53 10.53a7 7 0 0 1-9.058-9.058A7.003 7.003 0 0 0 8 15a7.002 7.002 0 0 0 6.53-4.47z"/>
                        </svg></span><span class="off"><svg width="2em" height="2em" viewBox="0 0 16 16"
                                                            class="bi bi-sun" fill="currentColor"
                                                            xmlns="http://www.w3.org/2000/svg">
                            <path d="M3.5 8a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0z"/>
                        <path fill-rule="evenodd"
                              d="M8.202.28a.25.25 0 0 0-.404 0l-.91 1.255a.25.25 0 0 1-.334.067L5.232.79a.25.25 0 0 0-.374.155l-.36 1.508a.25.25 0 0 1-.282.19l-1.532-.245a.25.25 0 0 0-.286.286l.244 1.532a.25.25 0 0 1-.189.282l-1.509.36a.25.25 0 0 0-.154.374l.812 1.322a.25.25 0 0 1-.067.333l-1.256.91a.25.25 0 0 0 0 .405l1.256.91a.25.25 0 0 1 .067.334L.79 10.768a.25.25 0 0 0 .154.374l1.51.36a.25.25 0 0 1 .188.282l-.244 1.532a.25.25 0 0 0 .286.286l1.532-.244a.25.25 0 0 1 .282.189l.36 1.508a.25.25 0 0 0 .374.155l1.322-.812a.25.25 0 0 1 .333.067l.91 1.256a.25.25 0 0 0 .405 0l.91-1.256a.25.25 0 0 1 .334-.067l1.322.812a.25.25 0 0 0 .374-.155l.36-1.508a.25.25 0 0 1 .282-.19l1.532.245a.25.25 0 0 0 .286-.286l-.244-1.532a.25.25 0 0 1 .189-.282l1.508-.36a.25.25 0 0 0 .155-.374l-.812-1.322a.25.25 0 0 1 .067-.333l1.256-.91a.25.25 0 0 0 0-.405l-1.256-.91a.25.25 0 0 1-.067-.334l.812-1.322a.25.25 0 0 0-.155-.374l-1.508-.36a.25.25 0 0 1-.19-.282l.245-1.532a.25.25 0 0 0-.286-.286l-1.532.244a.25.25 0 0 1-.282-.189l-.36-1.508a.25.25 0 0 0-.374-.155l-1.322.812a.25.25 0 0 1-.333-.067L8.203.28zM8 2.5a5.5 5.5 0 1 0 0 11 5.5 5.5 0 0 0 0-11z"/>
                        </svg></span></div>
                </label>
            </li>
        </ul>

        <form class="form-inline my-2 my-lg-0" action="/search-events?">
            <input class="form-control mr-sm-2" type="search" placeholder="Type here..." name="search"
                   aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <#if logged??>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${logged}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/profile">My Profile</a>
                    <a class="dropdown-item" href="/favourites-list">My favourites</a>
                    <a class="dropdown-item" href="/logout">Log out</a>
                </div>
            </li>
        <#else>
            <div>
                <a href="/login">
                    <button type="button" style="position:relative; right:-5px;" class="btn btn-outline-primary">Log in
                    </button>
                </a>
            </div>
        </#if>

    </div>
</nav>

<script>
    function myFunction() {
        var element = document.body;
        element.classList.toggle("dark-mode");

        let navbar = document.getElementsByClassName('navbar')[0].classList;
    }
</script>