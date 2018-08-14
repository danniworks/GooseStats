package server.controller;

import org.apache.http.client.utils.URLEncodedUtils;
import server.api.ApiHelper;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet("/AjaxDealer")
public class AjaxDealer extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String error = "";

        String req = URLEncoder.encode(request.getParameter("search")).replace("+", "%20");



        ApiHelper data = new ApiHelper(req, "profile");
        data.doReq();

        String ret;
        ret = data.getRet();

        if (!(ret.equals("error"))) {
            request.setAttribute("profile_data", ret);
            request.setAttribute("searchBar", "true");
            ret = data.getRet();
            request.setAttribute("ranked-container", ret);
            this.getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
        }
        else {
            error = data.getErrorMessage();
            request.setAttribute("error", error);
            this.getServletContext().getRequestDispatcher("/not_found.jsp").forward(request, response);
        }
    }
}
