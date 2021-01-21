package com.example.assignment;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
public class Info {
    public  void paraInfo( HttpServletRequest req,HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        out.write("****************Parameter info****************");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            out.write(paramName);
            out.write("\n");
            String[] values = req.getParameterValues(paramName);
            for (int i = 0; i < values.length; i++) {
                String paramValue = values[i];
                out.write("\t" + paramValue);
                out.write("\n");
            }

        }
    }
    public  void headerInfo(HttpServletRequest req,HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.write("****************Header info****************");
        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {

            String headerName = (String)headerNames.nextElement();
            out.println("header name:" + headerName);
            out.println(" header:" + req.getHeader(headerName));
        }

    }

}


