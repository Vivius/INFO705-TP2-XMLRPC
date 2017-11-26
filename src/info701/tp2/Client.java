package info701.tp2;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String args[]) {
        XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
        try {
            clientConfig.setServerURL(new URL("http://127.0.0.1:8080"));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(clientConfig);
        try {
            List<String> params = new ArrayList<>();
            params.add("3 + 2");
            double reponse = (double)client.execute("moteurcalculsimple.calculer", params);
            System.out.println("Résultat = " + reponse);
        } catch (XmlRpcException e) {
            System.out.println(e.getMessage());
        }
    }
}
