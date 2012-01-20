package de.bruns.example.osm.locationpicker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoiServlet extends HttpServlet {

   private static final long serialVersionUID = 4581952804038449353L;

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("poiName");
      String address = request.getParameter("poiAddress");
      String lat = request.getParameter("poiLatitude");
      String lon = request.getParameter("poiLongitude");

      System.out.println("Sehensw�rdigkeit erstellt: " + name + " (" + lon + "," + lat + ") => " + address);

      response.getWriter().write("Danke");
   }
}