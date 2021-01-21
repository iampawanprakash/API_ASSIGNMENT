package com.example.assignment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutputStream os=response.getOutputStream();
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"Salary.csv\"");
        File f=new File("C:\\Users\\Pawan Prakash\\IdeaProjects\\assignment\\src\\main\\resources\\salary.csv");
        BufferedReader br=new BufferedReader(new FileReader(f));
        String data="";
        int r;
        try{
            while((r=br.read())!=-1)
            {
                data=data+(char)r;
            }
            os=response.getOutputStream();
            os.write(data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            os.flush();
            os.close();
        }


        }


}
