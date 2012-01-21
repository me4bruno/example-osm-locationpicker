package de.bruns.example.osm.locationpicker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoiServlet extends HttpServlet {

   private static final long serialVersionUID = 4581952804038449353L;

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String name = request.getParameter("poiName");
      String address = request.getParameter("poiAddress");
      String lat = request.getParameter("poiLatitude");
      String lon = request.getParameter("poiLongitude");
      String poiAddress = name + " (" + lon + "," + lat + ") => " + address;
      
      System.out.println("Sehenswürdigkeit erstellt: " + poiAddress);
      response.getWriter().write("Danke - viel Spaß bei: " + poiAddress);
   }
}
