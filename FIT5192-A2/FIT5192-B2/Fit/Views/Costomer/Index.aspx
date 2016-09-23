<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<Fit.Models.Customer>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Customer Index</title>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Customer Index</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /blue -->


    <!-- *****************************************************************************************************************
	 AGENCY ABOUT
	 ***************************************************************************************************************** -->

    <div class="container mtb">
        <div class="row">
            <div class="col-lg-8">

                <table id="Customer" class="table table-hover">
                    <tr>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Name) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Age) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Gender) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Email) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Phone) %>
                        </th>

                        <th></th>
                    </tr>

                    <% foreach (var item in Model)
                       { %>
                    <tr>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Name) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Age) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Gender) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Email) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Phone) %>
                        </td>

                        <td>

                            <div class="col-lg-3">
                                <%: Html.ActionLink("Details", "Details", new { id=item.Id },new { @class = "btn btn-success"}) %>
                            </div>
                            <div class="col-lg-3">

                                <%: Html.ActionLink("Edit", "Edit", new { id=item.Id }, new { @class = "btn btn-warning"}) %>
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
