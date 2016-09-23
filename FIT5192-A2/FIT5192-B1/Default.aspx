<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
    <title>SOLID</title>
    <!--from other page-->
    <!-- Normalize -->
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <!-- Owl -->
    <link rel="stylesheet" type="text/css" href="css/owl.css" />
    <!-- Animate.css -->
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.1.0/css/font-awesome.min.css" />
    <!-- Elegant Icons -->
    <link rel="stylesheet" type="text/css" href="fonts/eleganticons/et-icons.css" />
    <!-- Main style -->
    <link rel="stylesheet" type="text/css" href="css/cardio.css" />
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="preloader" runat="Server">
    <div class="preloader">
        <img src="img/loader.gif" alt="Preloader image" />
    </div>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <!-- *****************************************************************************************************************
	 HEADERWRAP
	 ***************************************************************************************************************** -->

    <header id="intro">
        <div class="container">
            <div class="table">
                <div class="header-text">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h3 class="light white">Take care of your body.</h3>
                            <h1 class="white typed">It's the only place you have to live.</h1>
                            <span class="typed-cursor">|</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <section>
        <div class="cut cut-top"></div>
        <div class="container">
            <div class="row intro-tables">
                <div class="col-md-4">
                    <div class="intro-table intro-table-first">
                        <h5 class="white heading">Today's Schedule</h5>
                        <div class="owl-carousel owl-schedule bottom">
                            <div class="item">
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Early Exercise</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Muscle Building</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Cardio</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Early Exercise</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Muscle Building</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Cardio</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Early Exercise</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Muscle Building</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                                <div class="schedule-row row">
                                    <div class="col-xs-6">
                                        <h5 class="regular white">Cardio</h5>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <h5 class="white">8:30 - 10:00</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="intro-table intro-table-hover">
                        <h5 class="white heading hide-hover">Premium Membership</h5>
                        <div class="bottom">
                            <h4 class="white heading small-heading no-margin regular">Join now!</h4>
                            <h4 class="white heading small-pt">Come And See</h4>
                            <a href="Login.aspx" class="btn btn-white-fill expand">Login</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="intro-table intro-table-third">
                        <h5 class="white heading">Happy Clients</h5>
                        <div class="owl-testimonials bottom">
                            <div class="item">
                                <h4 class="white heading content">I couldn't be more happy with the results!</h4>
                                <h2 class="white heading light author">
                                    <a href="Register.aspx" class="btn btn-white-fill expand">Register</a>
                                    <a href="Login.aspx" class="btn btn-white-fill expand">Login</a>
                                </h2>
                                
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="services" class="section section-padded">
        <div class="container">
            <div class="row text-center title">
                <h2>Services</h2>
                <h4 class="light muted">Achieve the best results with our wide variety of training options!</h4>
            </div>
            <div class="row services">
                <div class="col-md-4">
                    <div class="service">
                        <div class="icon-holder">
                            <img src="img/icons/heart-blue.png" alt="" class="icon" />
                        </div>
                        <h4 class="heading">Cardio Training</h4>
                        <p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="service">
                        <div class="icon-holder">
                            <img src="img/icons/guru-blue.png" alt="" class="icon">
                        </div>
                        <h4 class="heading">Yoga Pilates</h4>
                        <p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="service">
                        <div class="icon-holder">
                            <img src="img/icons/weight-blue.png" alt="" class="icon">
                        </div>
                        <h4 class="heading">Power Training</h4>
                        <p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="cut cut-bottom"></div>
    </section>
    <section class="section section-padded blue-bg">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="owl-twitter owl-carousel">
                        <div class="item text-center">
                            <i class="icon fa fa-twitter"></i>
                            <h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>
                            <h4 class="light-white light">#health #training #exercise</h4>
                        </div>
                        <div class="item text-center">
                            <i class="icon fa fa-twitter"></i>
                            <h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>
                            <h4 class="light-white light">#health #training #exercise</h4>
                        </div>
                        <div class="item text-center">
                            <i class="icon fa fa-twitter"></i>
                            <h4 class="white light">To enjoy the glow of good health, you must exercise.</h4>
                            <h4 class="light-white light">#health #training #exercise</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>





</asp:Content>

<asp:Content ID="Content4" ContentPlaceHolderID="ScriptHolder" runat="server">
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/typewriter.js"></script>
    <script src="js/jquery.onepagenav.js"></script>
    <script src="js/main.js"></script>

</asp:Content>

