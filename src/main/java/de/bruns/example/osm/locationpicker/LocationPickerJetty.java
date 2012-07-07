package de.bruns.example.osm.locationpicker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class LocationPickerJetty {

	public LocationPickerJetty() throws Exception {
        int port = 8080;
        try {
            port = Integer.valueOf(System.getenv("PORT"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        WebAppContext context = new WebAppContext();
        Server server = new Server(port);
		context.setServer(server);

        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

		server.setHandler(context);

		server.start();
		server.join();
	}

	public static void main(final String[] args) throws Exception {
		new LocationPickerJetty();
	}
}
