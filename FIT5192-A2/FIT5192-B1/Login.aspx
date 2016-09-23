<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

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
            <div class="col-lg-8">
                <h4>Just Get In Touch!</h4>
                <div class="hline"></div>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                <div class="container">
                    <div class="row col-lg-8">
                        <div role="form">
                            <div class="form-group">
                                <label for="TxbUsername">Your Name</label>
                                <asp:TextBox ID="InputUsername" runat="server" CssClass="form-control"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="RequiredName" runat="server" ErrorMessage="Your Name should not be empty!" ControlToValidate="InputUsername" ForeColor="#CC3333" EnableClientScript="false"></asp:RequiredFieldValidator>
                            </div>


                            <div class="form-group">
                                <label for="TxbPassword">Password</label>
                                <asp:TextBox ID="InputPassword" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Password should not be empty!" ControlToValidate="InputPassword" ForeColor="#CC3333" EnableClientScript="false"></asp:RequiredFieldValidator>
                            </div>

                            <div class="form-group">
                                <asp:Button ID="BtnSigin" runat="server" Text="Sign in" CssClass="btn btn-success" OnClick="BtnSigin_Click" />
                                <a href="Register.aspx">
                                    <input id="Button1" type="button" value="Register" class="btn btn-info" /></a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <asp:Label ID="LblResult" runat="server" Text=""></asp:Label>
                    </div>

                </div>

            </div>
            <div class="col-lg-4">

                <h4>Popular Tags</h4>
                <div class="hline"></div>
                <p>
                    <a class="btn btn-theme" href="#" role="button">Login Code</a>
                </p>
                <div class="spacing"></div>

                <h4>Categories</h4>
                <div class="hline"></div>
                <div class="portfolio-item web-design">
                    <div class="he-wrap tpl6">
                        <img src="assets/img/portfolio/portfolio_02.jpg" alt=""/>
                        <div class="he-view">
                            <div class="bg a0" data-animate="fadeIn">
                                <h3 class="a1" data-animate="fadeInDown">A Web Design Item</h3>
                                <a data-rel="prettyPhoto" href="assets/img/portfolio/portfolio_02.jpg" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-search"></i></a>
                                <a href="single-project.html" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-link"></i></a>
                            </div>
                            <!-- he bg -->
                        </div>
                        <!-- he view -->
                    </div>
                    <!-- he wrap -->
                </div>
                <!-- end col-12 -->





            </div>
        </div>
    </div>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ScriptHolder" runat="Server">
</asp:Content>

