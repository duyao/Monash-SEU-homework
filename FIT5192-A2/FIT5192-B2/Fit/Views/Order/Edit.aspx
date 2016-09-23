<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Order>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Edit</title>

    <link href="../../assets/css/jquery.datepicker.css" rel="stylesheet">
    <script src="../../assets/js/jquery.datepicker.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#datepicker").datePicker();
        });
    </script>

</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Order Edit</h3>

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
                        <%: Html.LabelFor(model => model.Userid, "Customer") %>
                    </div>
                    <div class="editor-field">
                        <%: Html.DropDownList("Userid", String.Empty) %>
                        <%: Html.ValidationMessageFor(model => model.Userid) %>
                        <script>
                            $("select").addClass("form-control")
                        </script>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Item) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextBoxFor(model => model.Item,new {@class="form-control"}) %>
                        <%: Html.ValidationMessageFor(model => model.Item) %>
                    </div>
                </div>

                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Start) %>
                    </div>
                    <div class="editor-field">
                        <div class="input-group">
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-info" disabled="disabled"><i class="fa fa-calendar"></i></button>
                            </span>

                            <%: Html.TextBoxFor(model => model.Start,new {@class="form-control",@id="datepicker"}) %>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Duration) %>
                    </div>
                    <div class="editor-field">
                        <div class="input-group">
                            <%: Html.TextBoxFor(model => model.Duration,new {@class="form-control"}) %>
                            <span class="input-group-addon">Year(s)</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Price) %>
                    </div>
                    <div class="editor-field">
                        <div class="input-group">
                            <span class="input-group-addon">$</span>
                            <%: Html.TextBoxFor(model => model.Price,new {@class="form-control"}) %>
                            <span class="input-group-addon">.00</span>
                        </div>
                        <%: Html.ValidationMessageFor(model => model.Price) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="editor-label">
                        <%: Html.LabelFor(model => model.Content) %>
                    </div>
                    <div class="editor-field">
                        <%: Html.TextAreaFor(model => model.Content,new {@class="form-control", @rows = 5}) %>
                        <%: Html.ValidationMessageFor(model => model.Content) %>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group">
                        <p>
                            <input type="submit" value="Save" class="btn btn-theme btn-lg" />
                        </p>
                    </div>
                    <% } %>
                </div>

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
