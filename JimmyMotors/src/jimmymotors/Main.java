package jimmymotors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.json.JSONObject;
import org.omg.CORBA.portable.InputStream;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.print("test lol");
       // AsyncHttpClient client = new AsyncHttpClient();
//        try{
//        URL yahoo = new URL("https://api.edmunds.com/api/vehicle/v2/vins/2G1FC3D33C9165616?fmt=json&api_key=hjew2hpbk4uhckx9pxyknseb");
//        URLConnection yc = yahoo.openConnection();
//        BufferedReader in = new BufferedReader(
//                                new InputStreamReader(
//                                yc.getInputStream()));
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) 
//            System.out.println(inputLine);
//        in.close();
//        }catch(Exception e){
//        	
//        }
        
        Future<HttpResponse<JsonNode>> future = Unirest.post("https://api.edmunds.com/api/vehicle/v2/vins/2G1FC3D33C9165616?fmt=json&api_key=hjew2hpbk4uhckx9pxyknseb")
				  .header("accept", "application/json")
				  .asJsonAsync(new Callback<JsonNode>() {
				    public void failed(UnirestException e) {
				        System.out.println("The request has failed");
				    }

				    public void completed(HttpResponse<JsonNode> response) {
				        System.out.println("The request has compeleted");

				         int code = response.getStatus();
				         Map<String, List<String>> headers = response.getHeaders();
				         JsonNode body = response.getBody();
				         JSONObject json = body.getObject();
				         String a = json.getJSONObject("model").getString("name");
				         System.out.print(" first: " + a);
				         InputStream rawBody = (InputStream) response.getRawBody();
				         
				    }

				    public void cancelled() {
				        System.out.println("The request has been cancelled");
				    }

				});
        System.out.print("aaa");
        
	}

}
