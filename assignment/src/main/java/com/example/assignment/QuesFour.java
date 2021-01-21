package com.example.assignment;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuesFour", value = "/QuesFour")
public class QuesFour extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        int i=Integer.parseInt(request.getParameter("one"));
        int j=Integer.parseInt(request.getParameter("two"));
        marshalobj obj= new marshalobj(i,j);
        Gson gs=new Gson();
        String data=gs.toJson(obj);
        request.setAttribute("data",data);
        RequestDispatcher rd=request.getRequestDispatcher("Second");
        rd.include(request,response);
        String addsub =(String) request.getAttribute("addsubjson");
        marshalobj tempobj=gs.fromJson(addsub,marshalobj.class);
        int multiply1=tempobj.getFirst()*tempobj.getSecond();
        int multiply2=tempobj.getFirst()*tempobj.getFirst();
        int multiply3=tempobj.getSecond()*tempobj.getSecond();
        Result r=new Result(multiply1,multiply2,multiply3);
        String output= gs.toJson(r);
        out.write(output);

    }

}
