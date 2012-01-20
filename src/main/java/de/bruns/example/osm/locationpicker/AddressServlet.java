package de.bruns.example.osm.locationpicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddressServlet extends HttpServlet {

   private static final long serialVersionUID = 4581952804038449353L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String lon = request.getParameter("lon");
      String lat = request.getParameter("lat");

      String urlAsString = "http://maps.google.com/maps/api/geocode/json?address=" + lat + "," + lon + "&sensor=false";
      String contentAsString = contentOfUrl(urlAsString);
      String address = addressOfContent(contentAsString);

      System.out.println(lon+ "," + lat + " => " + address);

      response.setContentType("text/plain");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(address);
   }

   private String addressOfContent(String content) {
      String startIndexString = "formatted_address\" : \"";
      int startIndex = content.indexOf(startIndexString) + startIndexString.length();
      int endIndex = content.indexOf("\"geometry");
      return content.substring(startIndex, endIndex).trim().replace("\",", "");
   }

   private String contentOfUrl(String urlString) throws IOException {
      StringBuffer contentBuffer = new StringBuffer();
      BufferedReader in = new BufferedReader(new InputStreamReader(new URL(urlString).openStream(), "UTF-8"));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
         contentBuffer.append(inputLine);
      }
      in.close();
      return contentBuffer.toString();
   }
}
