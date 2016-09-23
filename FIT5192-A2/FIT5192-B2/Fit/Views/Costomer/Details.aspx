<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.master" Inherits="System.Web.Mvc.ViewPage<Fit.Models.Customer>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Details</title>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Customer Details</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>


    <div class="container mtb">
        <div class="row">

            <div class="jumbotron col-lg-8">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="row">
                            <img src="../../assets/img/profle.png" />
                        </div>
                        <div class="spacing"></div>
                        <div class="row col-lg-offset-1">
                            <h4>PROFILE</h4>
                        </div>

                    </div>
                    <div class="col-lg-8">
                        <div class=" row">
                            <em style="display: inline"><%: Html.DisplayNameFor(model => model.Name) %></em>
                            &nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
                            <h1 style="display: inline"><%: Html.DisplayFor(model => model.Name) %></h1>

                        </div>
                        <div class="row">
                            <p>
                                <em><%: Html.DisplayNameFor(model => model.Age) %></em> : <%: Html.DisplayFor(model => model.Age) %> , 
                    <em><%: Html.DisplayFor(model => model.Gender) %></em> ：<%: Html.DisplayNameFor(model => model.Gender) %>
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

                    <th><%: Html.DisplayNameFor(model => model.Address) %></th>
                    <th><%: Html.DisplayNameFor(model => model.Height) %></th>
                    <th><%: Html.DisplayNameFor(model => model.Weight) %></th>
                </tr>
                <tr>
                    <td>
                        <%: Html.DisplayFor(model => model.Name) %>
                    </td>
                    <td>
                        <%: Html.DisplayFor(model => model.Age) %>
                    </td>
                    <td>
                        <%: Html.DisplayFor(model => model.Gender) %>
                    </td>
                    <td>
                        <%: Html.DisplayFor(model => model.Email) %>
                    </td>
                    <td>
                        <%: Html.DisplayFor(model => model.Phone) %>
                    </td>
                    <td><%: Html.DisplayFor(model => model.Address) %>
                    <td><%: Html.DisplayFor(model => model.Height) %></td>
                    <td><%: Html.DisplayFor(model => model.Weight) %></td>
                </tr>
            </table>
        </div>

    </div>
    <img src="../../assets/img/footer.png" />

</asp:Content>



<asp:Content ID="Content4" ContentPlaceHolderID="ScriptsSection" runat="server">
</asp:Content>
