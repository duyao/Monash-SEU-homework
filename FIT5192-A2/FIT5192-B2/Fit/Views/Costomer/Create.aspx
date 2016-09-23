<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Customer>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Create</title>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Customer Create</h3>

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
                        <%: Html.RadioButtonFor(model => model.Gender,"Female") %>Female

                    </div>
                </div>
                <div class="form-group ">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Email) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Email,new {@class="form-control"}) %>
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Email,null,new {@class="label-danger"}) %>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Phone) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Phone,new {@class="form-control"}) %>
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Phone) %>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Address) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Address,new {@class="form-control"}) %>
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Address) %>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Height) %>
                    </div>
                    <div class="input-group">
                        <%: Html.TextBoxFor(model => model.Height,new {@class="form-control"}) %>
                        <span class="input-group-addon">cm</span>
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Height) %>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Weight) %>
                    </div>
                    <div class="input-group">
                        <%: Html.TextBoxFor(model => model.Weight,new {@class="form-control"}) %>
                        <span class="input-group-addon">kg</span>
                    </div>
                    <%: Html.ValidationMessageFor(model => model.Weight) %>
                </div>
                <div class="form-group">
                    <p>
                        <input type="submit" value="Create" class="btn btn-theme btn-lg" />
                    </p>
                </div>


                <% } %>
            </div>
            <div class="col-lg-3">

                <h4>Functions</h4>
                <div class="hline"></div>
                <p>
                    <%: Html.ActionLink("Back to List", "Index",null,new { @class = "btn btn-info btn-lg"}) %>
                </p>

            </div>

        </div>
    </div>
    <img src="../../assets/img/footer.png" />
</asp:Content>


<asp:Content ID="Content4" ContentPlaceHolderID="ScriptsSection" runat="server">
    <%: Scripts.Render("~/bundles/jqueryval") %>
</asp:Content>
