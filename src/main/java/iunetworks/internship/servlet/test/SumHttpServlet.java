package iunetworks.internship.servlet.test;


import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SumHttpServlet extends HttpServlet {

    private PrintWriter pw;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        response.

        String[] query = request.getQueryString().split("&");

        String[] vars = new String[query.length];
        String[] values = new String[query.length];

        for(int i = 0; i < query.length; i++) {
            vars[i] = query[i].split("=")[0];
            values[i] = query[i].split("=")[1];
        }

        int sum = 0;

        for(String temp : vars) {
            System.out.println(temp);
        }

        for(String temp : values) {
            sum += Integer.parseInt(temp.toString());
            System.out.println(Integer.parseInt(temp.toString()));
        }

        StringBuffer var = new StringBuffer();

        for(String temp : vars) {
            var.append(temp + " ");
        }



        pw.println(String.format("The sum of %sis <h1>%d</h1>", var, sum));
    }

}
