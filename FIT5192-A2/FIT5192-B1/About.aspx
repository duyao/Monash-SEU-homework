<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="About.aspx.cs" Inherits="About" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="preloader" runat="Server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <div id="blue">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3><a href="Default.aspx" class="btn btn-secondary btn-lg" role="button">Home</a> / Login</h3>
                </div>
                <div class="col-md-3 col-md-offset-5">
                    <asp:LoginView ID="LoginView1" runat="server">
                        <AnonymousTemplate>
                            <ul class="nav navbar-nav">
                                <li><a href="Login.aspx">
                                    <h4>Login</h4>
                                </a></li>
                                <li><a href="Register.aspx">
                                    <h4>Register</h4>
                                </a></li>
                            </ul>
                        </AnonymousTemplate>
                        <LoggedInTemplate>
                            <div class="col-md-3 col-md-offset-5">
                                <p>
                                    Welcome <b>
                                        <asp:LoginName ID="LoginUser" runat="server" />
                                    </b>
                                    <asp:Button ID="BtnSignOff" runat="server" Text="Sign out" CssClass="btn btn-default btn-sm" OnClick="BtnSignOff_Click" />
                                </p>
                            </div>
                        </LoggedInTemplate>
                    </asp:LoginView>
                </div>
            </div>
        </div>
        <!-- /container -->

    </div>
    <!-- /blue -->

    <div class="container mtb">
        <div class="row">
            <div class="col-lg-6">
                <img class="img-responsive" src="assets/img/agency.jpg" alt="">
            </div>

            <div class="col-lg-6">
                <h4>More About Our Agency.</h4>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>
                <p>It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                <p>Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.</p>
                <p>
                    <br />
                    <a href="contact.html" class="btn btn-theme">Contact Us</a>
                </p>
            </div>
        </div>
    </div>

    <!-- *****************************************************************************************************************
	 TEEAM MEMBERS
	 ***************************************************************************************************************** -->

    <div class="container mtb">
        <div class="row centered">
            <h3 class="mb">MEET OUR TEAM</h3>
            <div class="hline"></div>

            <div class="col-lg-4 col-lg-offset-2">
                <div class="he-wrap tpl6">
                    <img src="assets/img/team/team02.jpg" alt="">
                    <div class="he-view">
                        <div class="bg a0" data-animate="fadeIn">
                            <h3 class="a1" data-animate="fadeInDown">Contact Me:</h3>
                            <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-envelope"></i></a>
                            <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-twitter"></i></a>
                        </div>
                        <!-- he bg -->
                    </div>
                    <!-- he view -->
                </div>
                <!-- he wrap -->
                <h4>Paul Jameson</h4>
                <h5 class="ctitle">LEAD DESIGNER</h5>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                <div class="hline"></div>
            </div>

            <div class="col-lg-4">
                <div class="he-wrap tpl6">
                    <img src="assets/img/team/team03.jpg" alt="">
                    <div class="he-view">
                        <div class="bg a0" data-animate="fadeIn">
                            <h3 class="a1" data-animate="fadeInDown">Contact Me:</h3>
                            <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-envelope"></i></a>
                            <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-twitter"></i></a>
                        </div>
                        <!-- he bg -->
                    </div>
                    <!-- he view -->
                </div>
                <!-- he wrap -->
                <h4>Laura Sommers</h4>
                <h5 class="ctitle">LEAD DEVELOPER</h5>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                <div class="hline"></div>
            </div>

            

        </div>
    </div>

</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ScriptHolder" runat="Server">
</asp:Content>

