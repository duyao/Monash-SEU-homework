<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Customer>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Edit</title>

</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Customer Edit</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>


    <div class="container mtb">
        <div class="row">
            <div class="col-lg-5 col-lg-offset-1">

                <% using (Html.BeginForm())
                   { %>
                <%: Html.AntiForgeryToken() %>
                <%: Html.ValidationSummary(true) %>



                <%: Html.HiddenFor(model => model.Id) %>

                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Name) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Name,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Name) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Age) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Age,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Age) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Gender) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.RadioButtonFor(model => model.Gender,"Male",new { @checked = true }) %>Male 
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <%: Html.RadioButtonFor(model => model.Gender,"Female",new { @checked = true }) %>Female
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Gender) %>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Email) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Email,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Email) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Phone) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Phone,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Phone) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Address) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Address,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Address) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Height) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Height,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Height) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Weight) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Weight,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Weight) %>
                    </div>
                </div>
                <div class="form-group">
                    <p>
                        <input type="submit" value="Save" class="btn btn-theme btn-lg" />
                    </p>
                </div>

                <% } %>
            </div>
            <div class="col-lg-3 col-lg-offset-1">
                <div class="row">
                    <h4><i class="fa   fa-shield fa-3x"></i>&nbsp;&nbsp;&nbsp;&nbsp;More Functions</h4>
                    <div class="hline"></div>
                    <br />
                    <div class="col-lg-offset-1 col-lg-8">
                        <%: Html.ActionLink("Back to List", "Index",null,new { @class = "btn btn-info btn-lg"}) %>
                    </div>

                </div>
                <div class="spacing"></div>
                <div class="row col-lg-offset-1 col-lg-11">
                    <h4 class="centered">Tips</h4>
                    <div class="hline"></div>
                    <div class="col-lg-offset-1">
                        <img src="../../assets/img/side.png" style="margin-top: 15px" />
                    </div>
                </div>

            </div>
        </div>
    </div>
    <img src="../../assets/img/footer.png" />
</asp:Content>



<asp:Content ID="Content4" ContentPlaceHolderID="ScriptsSection" runat="server">
    <%: Scripts.Render("~/bundles/jqueryval") %>
</asp:Content>
