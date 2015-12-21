package com.oksbwn.osmc;

import java.net.Authenticator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.oksbwn.server_activity.SendData;
import com.oksbwn.server_activity.authoRize;

public class ClickManager {
	//192.168.0.100/jsonrpc?request=
	SendData sd= new SendData();
    String runningPlayerId = "0";
	public static void main(String[] args){
		ClickManager cm = new ClickManager();
		cm.clickedOn(17);
    	System.out.println(cm.checkCurrent());
	}
	public void clickedOn(int i) {
		// TODO Auto-generated method stub
            String urlString = "http://192.168.0.100/jsonrpc?request=";
			switch(i){
	        	case 0:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
	        		break;
	        	case 1:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Up\"}";
	        		break;
	        	case 2:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Down\"}";
	        		break;
	        	case 3:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Left\"}";
	        		break;
	        	case 4:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Right\"}";
	        		break;
	        	case 5:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Select\"}";
	        		break;
	        	case 6:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Player.GoTo\",\"params\":{\"playerid\":"+runningPlayerId+",\"to\":\"previous\"}}";
	        		break;
	        	case 7:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.PlayPause\",\"params\":{\"playerid\":"+runningPlayerId+",\"play\":true}}";
	        		break;
	        	case 8:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Player.GoTo\",\"params\":{\"playerid\":"+runningPlayerId+",\"to\":\"next\"}}";
	        		break;
	        	case 9:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.SetSpeed\",\"params\":{\"playerid\":"+runningPlayerId+",\"speed\":-4}}";
	        		break;
	        	case 10:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.PlayPause\",\"params\":{\"playerid\":"+runningPlayerId+",\"play\":false}}";
	        		break;
	        	case 11:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.SetSpeed\",\"params\":{\"playerid\":"+runningPlayerId+",\"speed\":4}}";
	        		break;
	        	case 12:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Input.Home\"}";
	        		break;
	        	case 13:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetVolume\",\"params\":{\"volume\":\"decrement\"}}";
	        		break;
	        	case 14:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetMute\",\"params\":{\"mute\":\"toggle\"}}";
	        		break;
	        	case 15:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetVolume\",\"params\":{\"volume\":\"increment\"}}";
	        		break;
	        	case 16:
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"JSONRPC.Version\"}";
	        		break;
	        	case 17:	
	        		urlString=urlString+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.GetActivePlayers\"}";
	        		break;
            }
            Authenticator.setDefault(new authoRize("om", "om"));
    		//System.out.println(urlString);
            String response=sd.sendGet(urlString, null, null);
    		//System.out.println(sd.sendGet(urlString));
            if(i==17){
            	//System.out.println(response);
            	JSONParser parser= new JSONParser();
            	try {
					JSONObject obj=(JSONObject) parser.parse(response);
					JSONArray arr=(JSONArray) obj.get("result");
					obj=(JSONObject) arr.get(0);
					runningPlayerId=obj.get("playerid").toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
	}
public String checkCurrent() {
		// TODO Auto-generated method stub
		String urlString = "http://192.168.0.100/jsonrpc?request="+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"Player.GetItem\",\"params\":{\"playerid\":"+runningPlayerId+"}}";
		Authenticator.setDefault(new authoRize("om", "om"));
		String songName = "" ;
		String response=sd.sendGet(urlString, null, null);
		//System.out.println(response);
		JSONParser parser= new JSONParser();
		try {
			JSONObject obj=(JSONObject) parser.parse(response);
			JSONObject arr=(JSONObject) obj.get("result");
			obj=(JSONObject) arr.get("item");
			songName= obj.get("label").toString();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return songName;
	}
public void shutDown() {
	String urlString = "http://192.168.0.100/jsonrpc?request="+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"System.Shutdown\"}";
	Authenticator.setDefault(new authoRize("om", "om"));
	sd.sendGet(urlString, null, null);
}
public void reboot() {
	String urlString = "http://192.168.0.100/jsonrpc?request="+"{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"System.Reboot\"}";
	Authenticator.setDefault(new authoRize("om", "om"));
	sd.sendGet(urlString, null, null);
}
}
