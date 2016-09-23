<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Register.aspx.cs" Inherits="Register" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
    <title>Register</title>
    <link rel="stylesheet" href="assets/css/jquery.datepicker.css"/>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="preloader" runat="Server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <div id="blue">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3><a href="Default.aspx" class="btn btn-secondary btn-lg" role="button">Home</a> / Register</h3>
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
                <div role="form">
                    <div class="form-group">
                        <label for="TxbUsername">Your Name</label>
                        <asp:TextBox ID="TxbUsername" runat="server" CssClass="form-control"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredName" runat="server" ErrorMessage="Your Name should not be empty!" ControlToValidate="TxbUsername" ForeColor="#CC3333" EnableClientScript="false"></asp:RequiredFieldValidator>
                    </div>


                    <div class="form-group">
                        <label for="TxbUsername">Age</label>
                        <asp:TextBox ID="TxbAge" runat="server" CssClass="form-control"></asp:TextBox>
                        <asp:CustomValidator ID="CustomValidator1" runat="server" ErrorMessage="You should input a number" ControlToValidate="TxbAge" OnServerValidate="CustomValidator1_ServerValidate" EnableClientScript="false"></asp:CustomValidator>

                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="The age should not be empty!" ControlToValidate="TxbAge" ForeColor="#CC3333" EnableClientScript="false"></asp:RequiredFieldValidator>
                        <asp:RangeValidator ID="VldAge" runat="server" ErrorMessage="This age is not between 0 and 120." ForeColor="#CC3333"
                            Type="Integer" MaximumValue="120" MinimumValue="0" ControlToValidate="TxbAge"></asp:RangeValidator>
                    </div>


                    <div class="form-group">
                        <label for="TxbPassword">Password</label>
                        <asp:TextBox ID="TxbPassword" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="The password should not be empty!" EnableClientScript="false"
                            ControlToValidate="TxbPassword" ForeColor="#CC3333"></asp:RequiredFieldValidator>
                        <asp:RegularExpressionValidator ID="VldPwd" ControlToValidate="TxbPassword" runat="server" ForeColor="#CC3333"
                            ErrorMessage="Only sequence of one or more word characters with 4 to 15 characters" ValidationExpression="\w{4,15}"></asp:RegularExpressionValidator>
                    </div>
                    <div class="form-group">
                        <label for="TxbPassword">Password Again</label>
                        <asp:TextBox ID="TxbPassword2" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
                        <asp:CompareValidator ID="VldPwdCmp" runat="server" ErrorMessage="Your password does not match!"
                            ControlToValidate="TxbPassword2" ControlToCompare="TxbPassword" ForeColor="#CC3333" EnableClientScript="false"></asp:CompareValidator>
                        <asp:RequiredFieldValidator ID="vldPwd2" runat="server" ErrorMessage="You must confirm your password!" EnableClientScript="false"
                            ControlToValidate="TxbPassword2" ForeColor="#CC3333"></asp:RequiredFieldValidator>
                    </div>

                    <div class="form-group">
                        <label for="TxbMail">Email</label>
                        <asp:TextBox ID="TxbMail" runat="server" CssClass="form-control" TextMode="Email"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="  The e-mail should not be empty!" EnableClientScript="false"
                            ControlToValidate="TxbMail" ForeColor="#CC3333"></asp:RequiredFieldValidator>
                        <asp:RegularExpressionValidator ID="RegularExpressionValidator1" ControlToValidate="TxbMail" runat="server" ForeColor="#CC3333"
                            ErrorMessage="Illeagle Email Address!" ValidationExpression="\S+@\S+\.\S+"></asp:RegularExpressionValidator>
                    </div>

                    <div class="form-group">
                        <label for="TxbAttendDate" class="control-label">Attendance Date</label>
                        <div class="input-group">
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-info" data-toggle="datepicker"><i class="fa fa-calendar"></i></button>
                            </span>

                            <asp:TextBox name="date" ID="date" data-select="datepicker" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>

                    </div>

                    <div class="form-group row">
                        <label for="OptSexList" class="col-lg-2">Gender</label>

                        <div class="col-lg-3">
                            <div class="radio-inline">
                                <asp:RadioButton ID="OptSexM" GroupName="OptSex" runat="server" Text="Male" Checked="true" />
                            </div>
                            <div class="radio-inline">
                                <asp:RadioButton ID="OptSexF" GroupName="OptSex" runat="server" Text="Female" />
                            </div>
                        </div>

                    </div>


                    <div class="form-group row">

                        <label for="ChkList" class="col-lg-2">Body Exercise</label>
                        <div class="col-lg-10">
                            <asp:CheckBoxList ID="ChkList" runat="server" RepeatDirection="Horizontal" RepeatColumns="5" RepeatLayout="Flow">
                                <asp:ListItem>&nbsp;Arm&nbsp;&nbsp;&nbsp;&nbsp;</asp:ListItem>
                                <asp:ListItem>&nbsp;Chest&nbsp;&nbsp;&nbsp;&nbsp;</asp:ListItem>
                                <asp:ListItem>&nbsp;Back&nbsp;&nbsp;&nbsp;&nbsp;</asp:ListItem>
                                <asp:ListItem>&nbsp;Leg&nbsp;&nbsp;&nbsp;&nbsp;</asp:ListItem>
                                <asp:ListItem>&nbsp;Shoulder&nbsp;&nbsp;&nbsp;&nbsp;</asp:ListItem>
                            </asp:CheckBoxList>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="LsbSubscribe" class="col-lg-2">Nutrition Subscription </label>
                        <div class="col-lg-10">
                            <asp:ListBox ID="LsbSubscibe" runat="server" SelectionMode="Multiple" CssClass="form-control">
                                <asp:ListItem>Healthy Recipes</asp:ListItem>
                                <asp:ListItem>Meal Plans</asp:ListItem>
                                <asp:ListItem>Lose Fat</asp:ListItem>
                                <asp:ListItem>Gain Mass</asp:ListItem>
                                <asp:ListItem>Supplements</asp:ListItem>

                            </asp:ListBox>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="DroplistGrade" class="col-lg-2">Training Opintion</label>
                        <div class="col-lg-10">
                            <asp:DropDownList ID="DroplistGrade" runat="server" CssClass="form-control">
                                <asp:ListItem>Cardio Training</asp:ListItem>
                                <asp:ListItem>Yoga Pilates</asp:ListItem>
                                <asp:ListItem>Power Training</asp:ListItem>
                            </asp:DropDownList>
                        </div>
                    </div>

                    <div class="form-group">

                        <asp:Button ID="BtnRegister" CssClass="btn btn-theme" runat="server" Text="Register" OnClick="BtnRegister_Click" />
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <h4>More Functions</h4>
                <div class="hline"></div>
                <ul class="popular-posts">
                    <li>
                        <a href="#">
                            <img src="assets/img/thumb01.jpg" alt="Popular Post" /></a>
                        <p><a href="#">Click here to display the code used for this page</a></p>
                        <em>Add Records</em>
                    </li>
                    <li>
                        <a href="#">
                            <img src="assets/img/thumb02.jpg" alt="Popular Post" /></a>
                        <p><a href="#">Click here to show all records</a></p>
                        <em>Display Records</em>
                    </li>
                    <li>
                        <a href="#">
                            <img src="assets/img/thumb03.jpg" alt="Popular Post" /></a>
                        <p><a href="#">Click here to Search records</a></p>
                        <em>Search Records</em>
                    </li>

                </ul>

                <div class="spacing"></div>
            </div>
        </div>
    </div>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ScriptHolder" runat="Server">
    <script src="assets/js/jquery.datepicker.js"></script>
</asp:Content>

