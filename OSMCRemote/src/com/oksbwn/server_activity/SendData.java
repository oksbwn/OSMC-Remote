package com.oksbwn.server_activity;
/**
 * Created by OKSBWN on 21/Dec/2015.
 * Used to send data to server.
 * Methods :
 *  sendPost(String address,String [] tags,String[] data);
 *  sendGet(String address,String [] tags,String[] data);
 * 
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendData {
	private final String USER_AGENT = "Mozilla/5.0";
	public String sendPost(String address,String [] tags,String[] data){
		String url = address;
		try{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			//add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 
			String urlParameters = "";
			for(int i=0;i<tags.length;i++){
				if(i==0)
					urlParameters=tags[i]+"="+data[i];
				else
					urlParameters=urlParameters+"&"+tags[i]+"="+data[i];
			}
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			return response.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
 
	}
	public String sendGet(String address,String [] tags,String[] data) {
		 
		String url = address;
		URL obj;
		try {
			obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add request header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
 
	}
}