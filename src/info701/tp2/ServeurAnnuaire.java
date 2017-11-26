package info701.tp2;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class ServeurAnnuaire {
    private WebServer webServer;
    private XmlRpcServer xmlRpcServer;
    private PropertyHandlerMapping handler;

    public ServeurAnnuaire(int port) {
        webServer = new WebServer(port);
        xmlRpcServer = webServer.getXmlRpcServer();
        handler = new PropertyHandlerMapping();

        try {
            handler.addHandler("annuaire", Annuaire.class);
        } catch (XmlRpcException e) {
            System.out.println(e.getMessage());
        }
        xmlRpcServer.setHandlerMapping(handler);
        try {
            webServer.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        new ServeurAnnuaire(8080);
    }
}
