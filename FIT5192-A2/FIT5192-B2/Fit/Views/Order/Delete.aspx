<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Order>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">

    <title>Delete</title>
    <script>
        $(document).ready(function () {
            $('#red').css('color', 'red');

        });
    </script>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Order Details</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>

    <div class="container mtb">
        <div class="row">
            <div class="col-lg-5 col-lg-offset-1">
                <h3 id="red">Are you sure you want to delete this?</h3>
                <div class="col-lg-8">
                    <div class="form-group">
                        <strong><%: Html.DisplayNameFor(model => model.Customer.Name) %></strong>
                        <span class=" alert alert-danger form-control">
                            <%: Html.DisplayFor(model => model.Customer.Name) %></span>
                    </div>
                    <div class="form-group">
                        <strong>
                            <%: Html.DisplayNameFor(model => model.Item) %>
                        </strong>
                        <span class=" alert alert-danger form-control">
                            <%: Html.DisplayFor(model => model.Item) %>
                        </span>
                    </div>

                    <div class="form-group">
                        <strong>
                            <%: Html.DisplayNameFor(model => model.Start) %>
                        </strong>
                        <span class=" alert alert-danger form-control">
                            <%: Html.DisplayFor(model => model.Start) %>
                        </span>
                    </div>

                    <div class="form-group">
                        <strong>
                            <%: Html.DisplayNameFor(model => model.Duration) %>
                        </strong>
                        <span class=" alert alert-danger form-control">
                            <%: Html.DisplayFor(model => model.Duration) %>
                        </span>
                    </div>

                    <div class="form-group">
                        <strong>
                            <%: Html.DisplayNameFor(model => model.Price) %>
                        </strong>
                        <span class=" alert alert-danger form-control">
                            <%: Html.DisplayFor(model => model.Price) %>
                        </span>
                    </div>

                    <div class="form-group">
                        <strong>
                            <%: Html.DisplayNameFor(model => model.Content) %>
                        </strong>
                        <span class=" alert alert-danger form-control" style="overflow: auto; height: auto">
                            <%: Html.DisplayFor(model => model.Content) %>
                        </span>
                    </div>

                    <% using (Html.BeginForm())
                       { %>
                    <%: Html.AntiForgeryToken() %>
                    <p>
                        <input type="submit" value="Delete" class="btn btn-danger btn-lg" />
                    </p>
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
</asp:Content>
