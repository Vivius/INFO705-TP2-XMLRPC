package info701.tp2;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Serveur {

    public static void main (String[] args){
        WebServer webServer = new WebServer(8080);
        XmlRpcServer xmlServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping handler = new PropertyHandlerMapping();
        try {
            handler.addHandler("moteurcalculsimple", MoteurCalculSimple.class);
        } catch (XmlRpcException e) {
            System.out.println(e.getMessage());
        }

        xmlServer.setHandlerMapping(handler);
        try {
            webServer.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
