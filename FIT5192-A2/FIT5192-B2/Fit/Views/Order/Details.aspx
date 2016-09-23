<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Order>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Details</title>

</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div class="container mtb">
        <div class="row">

            <div class="jumbotron col-lg-8">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="row">
                            <img src="../../assets/img/flower.png" />
                        </div>
                        <div class="spacing"></div>
                        <div class="row col-lg-offset-1">
                            <h4>PROFILE</h4>
                        </div>
                    </div>

                    <div class="col-lg-8">
                        <div class=" row">

                            <h1 style="display: inline-block">
                                <%: Html.DisplayFor(model => model.Item) %>
                            </h1>
                            <h3 style="display: inline-block">: $ <%: Html.DisplayFor(model => model.Price) %>

                            </h3>

                        </div>
                        <div class="row">
                            <p>
                                <em>Item Description</em> : <%: Html.DisplayFor(model => model.Content) %>
                            </p>

                        </div>
                        <div class="row">
                            <div class="col-lg-2">

                                <%: Html.ActionLink("Edit", "Edit", new { id=Model.Id }, new { @class = "btn btn-warning btn-lg"}) %>
                            </div>
                            <div class="col-lg-4">
                                <%: Html.ActionLink("Back to List", "Index", null,new { @class = "btn btn-info btn-lg"}) %>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <table id="Order" class="table table-hover">
            <tr>
                <th>
                    <%: Html.DisplayNameFor(model => model.Customer.Name) %>
                </th>
                <th>Item Name</th>
                <th>Start Time</th>

                <th>
                    <%: Html.DisplayNameFor(model => model.Duration) %>
                </th>
                <th>
                    <%: Html.DisplayNameFor(model => model.Price) %>
                </th>

            </tr>
            <tr>

                <td>
                    <%: Html.DisplayFor(model => model.Customer.Name) %>
                </td>
                <td>
                    <%: Html.DisplayFor(model => model.Item) %>
                </td>
                <td>
                    <%: Html.DisplayFor(model => model.Start) %>
                </td>
                <td>
                    <%: Html.DisplayFor(model => model.Duration) %>
                </td>
                <td>
                    <%: Html.DisplayFor(model => model.Price) %>
                </td>

            </tr>
        </table>
    </div>

    <img src="../../assets/img/footer.png" />
</asp:Content>


<asp:Content ID="Content4" ContentPlaceHolderID="ScriptsSection" runat="server">
</asp:Content>
