
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import services.User;
import services.AccountService;
/**
 *
 * @author Hayley
 */

public class LoginServlet extends HttpServlet {
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set up the session
        HttpSession session = request.getSession();
        // Retrieve the parameter from the login form
        String usersesh =(String) request.getAttribute("username_form");
        session.setAttribute("username_display", usersesh);
       
       String logout = request.getParameter("logout");
        //check if logout exists
        if(logout != null){ 
            //stop sesion
            session.invalidate();
            //display message
            request.setAttribute("logout_success","You have been Logged out");
            //redirect back to login
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }else{
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             return;
        }  
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username_form");
        String password = request.getParameter("password_form");
        
        AccountService ac = new AccountService();
        User user = ac.login(username, password);
        
        HttpSession session = request.getSession();
        //first check if username and pass are empty
        if(username.isEmpty() || password.isEmpty() || username == null || password == null){
         // display error message and keep what user typed in
         request.setAttribute("invalidLogin_display", "Invalid entry! Please fill out all feilds");
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }else{
            //pass user and pass params to login method of account service
            //if login returns a non-null then store username in var and redirect user to home url 
            if(user != null){
               session.setAttribute("username_display", username);
               response.sendRedirect("home"); 
            }else{
               request.setAttribute("invalidLogin_display", "Invalid username or password");
            }
            
        }   
        
    }

}
