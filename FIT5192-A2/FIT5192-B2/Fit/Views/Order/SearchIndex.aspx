<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<Fit.Models.Order>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <title>Search</title>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">


    <div id="blue">
        <div class="container">
            <div class="row">
                <h3>Search Order</h3>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /blue -->
    <div class="container mtb">
        <div class="row">
            <div class="col-lg-8">
                <table id="Customer" class="table table-hover">

                    <tr>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Userid) %>
                        </th>
                        <th>
                            <%: Html.DisplayNameFor(model => model.Item) %>
                        </th>
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
                            <%: Html.DisplayFor(modelItem => item.Userid) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Item) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Duration) %>
                        </td>
                        <td>
                            <%: Html.DisplayFor(modelItem => item.Price) %>
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

                <div class="row">
                    <h4><i class="fa  fa-search fa-3x"></i>&nbsp;&nbsp;&nbsp;&nbsp;Search</h4>
                    <% using (Html.BeginForm())
                       {   %>


                    <div class="editor-field">
                        <input type="text" id="txtSearch" placeholder="Item Name" class="form-control" />
                    </div>


                </div>
                <div class="row"></div>
                <div class="row">

                    <input type="submit" class="btn btn-lg btn-theme " value="Filter" onclick="SubmitFrm(); return false;" />

                    <script type="text/javascript">
                        function SubmitFrm() {
                            var protocol = window.location.protocol;
                            var host = window.location.host;
                            var pathname = window.location.pathname;
                            pathname = pathname.substring(0, 18);
                            var newUrl = protocol + "//" + host + pathname + "/";
                            var Searchtxt = document.getElementById("txtSearch").value;
                            window.location = newUrl + encodeURIComponent(Searchtxt);
                        }
                    </script>
                </div>


                <% }%>
            </div>
        </div>
    </div>
    <img src="../../assets/img/footer.png" />

</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="ScriptsSection" runat="server">
</asp:Content>
