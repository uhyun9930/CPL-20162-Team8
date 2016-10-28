import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.MediaTypeRegistry;

public class CoAPClient {

	/*
	 * Application entry point.
	 * 
	 */
	private static final String uriString = "localhost:9999/smartfarm";

	public static void main(String args[]) {

		URI uri = null; // URI parameter of the request

		// input URI from command line arguments
		try {
			uri = new URI(uriString);
		} catch (URISyntaxException e) {
			System.err.println("Invalid URI: " + e.getMessage());
			System.exit(-1);
		}

		CoapClient client = new CoapClient(uri);

		CoapResponse response = client.post("Hello world".getBytes(), MediaTypeRegistry.TEXT_PLAIN);
		printResponse(response);

		response = client.put("Hello world".getBytes(), MediaTypeRegistry.TEXT_PLAIN);
		printResponse(response);

		response = client.get();
		printResponse(response);

		response = client.delete();
		printResponse(response);

	}

	public static void printResponse(CoapResponse response) {
		if (response != null) {

//			System.out.println(response.getCode());
//			System.out.println(response.getOptions());
//			System.out.println(response.getResponseText());

			// access advanced API with access to more details through
			// .advanced()
			System.out.println(Utils.prettyPrint(response));

		}
		else {
			System.out.println("No response received.");
		}
	}

}