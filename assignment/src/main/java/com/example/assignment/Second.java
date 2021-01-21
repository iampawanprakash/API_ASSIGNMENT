package com.example.assignment;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Second", value = "/Second")
public class Second extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String newdata= (String) request.getAttribute("data");
        Gson gs=new Gson();
        marshalobj tempobj=gs.fromJson(newdata,marshalobj.class);
        int add=tempobj.getFirst()+tempobj.getSecond();
        int sub=tempobj.getFirst()-tempobj.getSecond();
        marshalobj obj=new marshalobj(add,sub);
        String addsubjson= gs.toJson(obj);
        request.setAttribute("addsubjson",addsubjson);







    }
}
