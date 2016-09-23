<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<Fit.Models.Order>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Order Index</title>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Order Index</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /blue -->


    <div class="container mtb">
        <div class="row">
            <div class="col-lg-8">

                <table id="Order" class="table table-hover">
                    <tr>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Item) %>
                        </th>
                        <th>Customer Name</th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Duration) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Price) %>
                        </th>


                    </tr>

                    <% foreach (var item in Model)
                       { %>
                    <tr>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Item) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Customer.Name) %>
                        </td>

                        <td>
                            <%: Html.DisplayFor(modelItem => item.Duration) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Price) %>
                        </td>

                        <td>
                            <div class="col-lg-3">
                                <%: Html.ActionLink("Edit", "Edit", new { id=item.Id },new { @class = "btn btn-success"}) %>
                            </div>
                            <div class="col-lg-3">
                                <%: Html.ActionLink("Details", "Details", new { id=item.Id },new { @class = "btn btn-warning"}) %>
                            </div>
                            <div class="col-lg-3">
                                <%: Html.ActionLink("Delete", "Delete", new { id=item.Id },new { @class = "btn btn-danger"}) %>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>

            <div class="col-lg-3 col-lg-offset-1">

                <h4><i class="fa   fa-shield fa-3x"></i>&nbsp;&nbsp;&nbsp;&nbsp;More Functions</h4>
                <div class="hline"></div>
                <br />
                <div class="col-lg-offset-1 col-lg-8">
                    <%: Html.ActionLink("Create New", "Create",null,new { @class = "btn btn-info btn-lg form-control"}) %>
                    <br />
                    <br />
                    <%: Html.ActionLink("Search", "SearchIndex",null,new { @class = "btn btn-info btn-lg form-control"}) %>
                </div>
            </div>
        </div>
    </div>
    <img src="../../assets/img/footer.png" />
</asp:Content>



<asp:Content ID="Content4" ContentPlaceHolderID="ScriptsSection" runat="server">
</asp:Content>
