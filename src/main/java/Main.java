import org.eclipse.jetty.server.Server;

public class Main {
    public static void main(String[] args) throws Exception {
        int serverPort = 7777;
        Server jettyServer = new Server(serverPort);
        jettyServer.setHandler(new JettyHandlers());
        jettyServer.start();
        jettyServer.join();
    }
}
