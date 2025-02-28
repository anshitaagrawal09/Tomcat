package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"}, // URL Pattern for the servlet
        initParams = {
                @WebInitParam(name = "user", value = "Narayan"),
                @WebInitParam(name = "password", value = "BridgeLabz")
        }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nameRegex="^[A-Z]{1}[a-z]{3,}$";
        String passRegex="(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%]).{8,20}";
        String user=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        String userId=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");
        if(userId.equals(user) && password.equals(pwd)&&Pattern.matches(nameRegex,userId)&& Pattern.matches(passRegex,password)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }
        else{
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request,response);
        }
    }

    // Servlet methods (e.g., doGet, doPost) should be implemented here
}



//package com.demo;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServlet;
//public class LoginServlet {
////    @WebServlet(
////        description="Login Servlet Testing",
////        urlPatterns={"/LoginServlet"},
////
////    )
//    @WebServlet(
//            description="Login Servlet Testing",
//            urlPatterns = {"/LoginServlet"},// URL Pattern for the servlet
//            initParams = {
//                    @WebInitParam(name = "user", value = "admin"),
//                    @WebInitParam(name = "password", value ="password")
//   }
//   )
//}




//package com.demo;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.regex.Pattern;
//
//@WebServlet(
//        description = "Login Servlet Testing",
//        urlPatterns = {"/LoginServlet"},
//        initParams = {
//                @WebInitParam(name = "user", value = "Na"),
//                @WebInitParam(name = "password", value = "BridgeLabz")
//        }
//)
//public class LoginServlet extends HttpServlet {
//    private static final String NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$"; // Name validation pattern
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String user = request.getParameter("user");
//        String pwd = request.getParameter("pwd");
//
//        String userId = getServletConfig().getInitParameter("user");
//        String password = getServletConfig().getInitParameter("password");
//
//        // Validate Name Format
//        if (!Pattern.matches(NAME_PATTERN, user)) {
//            out.println("<font color=red>Invalid Name! Name must start with a capital letter and have at least 3 characters.</font>");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            rd.include(request, response);
//            return;
//        }
//
//        // Validate User Credentials
//        if (userId.equals(user) && password.equals(pwd)) {
//            request.setAttribute("user", user);
//            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
//        } else {
//            out.println("<font color=red>Either username or password is wrong.</font>");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            rd.include(request, response);
//        }
//    }
//}
