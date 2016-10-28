import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoAPServer extends CoapServer {

//    private static final int COAP_PORT = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);
	private static final int COAP_PORT = 9999;
    /*
     * Application entry point.
     */
    public static void main(String[] args) {
        
        try {

        	
            // create server
        	CoAPServer server = new CoAPServer();
            // add endpoints on all IP addresses
            server.addEndpoints();
            server.start();
           
        } catch (SocketException e) {
            System.err.println("Failed to initialize server: " + e.getMessage());
        }
    }

    /**
     * Add individual endpoints listening on default CoAP port on all IPv4 addresses of all network interfaces.
     */
    private void addEndpoints() {
    	for (InetAddress addr : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
    		// only binds to IPv4 addresses and localhost
            if (addr instanceof Inet4Address || addr.isLoopbackAddress()) {
                InetSocketAddress bindToAddress = new InetSocketAddress(addr, COAP_PORT);
                addEndpoint(new CoapEndpoint(bindToAddress));
            }
        }
    }


    /*
     * Constructor for a new Hello-World server. Here, the resources
     * of the server are initialized.
     */
    public CoAPServer() throws SocketException {
        
        // provide an instance of a Hello-World resource
        add(new HelloWorldResource("smartfarm"));
    }

    /*
     * Definition of the Hello-World Resource
     */
    class HelloWorldResource extends CoapResource {
        
        public HelloWorldResource() {
            
            // set resource identifier
            super("smartfarm");
            
            // set display name
            getAttributes().setTitle("Sensor Resource");
        }
        
        public HelloWorldResource(String id) {
            
            // set resource identifier
            super(id);
            
            // set display name
            getAttributes().setTitle("Sensor Resource");
        }
        
        @Override
        public void handleGET(CoapExchange exchange) {
            
            // 리소스 쿼리시 사용
        	System.out.println(exchange.getRequestText());
            exchange.respond("Response Message");
        }
        
        @Override
        public void handlePOST(CoapExchange exchange) {
            // 리소스 생성 시 사용
        	System.out.println(exchange.getRequestText());
        	exchange.respond(CoAP.ResponseCode.CREATED);
        }
        
        @Override
        public void handlePUT(CoapExchange exchange) {
        	// 리소스 수정 시 사용
        	System.out.println(exchange.getRequestText());
            exchange.respond(CoAP.ResponseCode.CHANGED);
        }
        
        @Override
        public void handleDELETE(CoapExchange exchange) {
        	//리소스 삭제 시 사용
        	delete();
            exchange.respond(CoAP.ResponseCode.DELETED);
        }
    }
    
    class ConnectionDB
    {
    	ConnectionDB()
    	{
    		Connection connection;
			Statement stmt;
		
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e)
			{
				System.err.print("ClassNotFoundException:");
			}
			
			
			try{
				String jdbcUrl="jdbc:mysql://localhost:3306/smartfarm";
				String userId = "root";
				String userPass = "autoset";
				
				connection = DriverManager.getConnection(jdbcUrl, userId, userPass);
				
				stmt = connection.createStatement();
				
				System.out.println("DB연결");
				
				stmt.close();
				connection.close();
			}
			catch(SQLException e)
			{
				System.out.println("SQLException: "+e.getMessage());
			}
		}
    }
}