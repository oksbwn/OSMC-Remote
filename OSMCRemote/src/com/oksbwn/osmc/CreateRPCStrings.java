package com.oksbwn.osmc;

public class CreateRPCStrings {
	private String rpcString=null;
	private int volumeLevel=0;
	
	public CreateRPCStrings(int parameter){
		
		switch(parameter){
		
			// Navigation COntrols
			
			// Volume Controls
			case 8:// Decrease volume
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetVolume\",\"params\":{\"volume\":\"decrement\"}}";
				break;

			case 9:// Mute/Unmute
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetMute\",\"params\":{\"mute\":\"toggle\"}}";
				break;

			case 10:// Increase volume.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetVolume\",\"params\":{\"volume\":\"increment\"}}";
				break;

			case 11:// Set volume to a specified level.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Application.SetVolume\",\"params\":{\"volume\":"+volumeLevel+"}}";
				break;

				
			//Player
			case 12:// Previous track.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
				break;

			case 13:// Previous track.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
				break;

			case 14:// Previous track.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
				break;

			case 15:// Previous track.
				rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
				break;
				
			default://Default
				break;
		}
	}
	public String getJSON(){
		return this.rpcString;
		
	}
}
