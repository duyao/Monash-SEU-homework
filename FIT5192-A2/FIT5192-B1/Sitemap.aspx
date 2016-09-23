<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Sitemap.aspx.cs" Inherits="Sitemap" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="preloader" runat="Server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <div id="blue">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3><a href="Default.aspx" class="btn btn-secondary btn-lg" role="button">Home</a> / Sitemap</h3>
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
            <! -- BLOG POSTS LIST -->
	 		<div class="col-lg-7">
                 <h4>Just Get In Touch!</h4>
                 <div class="hline"></div>
                 <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                 <div id="twrap">
                     <div class="container centered">
                         <asp:TreeView ID="TreeView1" runat="server" DataSourceID="SiteMapDataSource1" Font-Bold="true" Font-Size="Medium" ForeColor="White">
                         </asp:TreeView>
                         <asp:SiteMapDataSource ID="SiteMapDataSource1" runat="server" />
                     </div>
                 </div>


             </div>
            <div class="col-lg-5">
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
                        <img src="assets/img/portfolio/portfolio_02.jpg" alt="" />
                        <div class="he-view">
                            <div class="bg a0" data-animate="fadeIn">
                                <h3 class="a1" data-animate="fadeInDown">A Web Design Item</h3>
                            </div>
                            <!-- he bg -->
                        </div>
                        <!-- he view -->
                    </div>
                    <!-- he wrap -->
                </div>
            </div>
        </div>
    </div>



</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ScriptHolder" runat="Server">
</asp:Content>

