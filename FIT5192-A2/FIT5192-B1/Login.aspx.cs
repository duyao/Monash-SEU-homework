using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void BtnSigin_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {

            string username = InputUsername.Text;
            string password = InputPassword.Text;
            //UserDao dao = new UserDao(); 
            //if (dao.login(username, password))
            //{
            //    LblResult.Text = "Login success!";
            //    FormsAuthentication.RedirectFromLoginPage(username, false);
            //}
            //else
            //{
            //    LblResult.Text = "Login failed!";
        }
    }
    protected void BtnSignOff_Click(object sender, EventArgs e)
    {
        //FormsAuthentication.SignOut();
        //Response.Redirect("~/Default.aspx");
    }
}