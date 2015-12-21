package com.oksbwn.osmc.rpc_methods;

import java.net.Authenticator;

import com.oksbwn.server_activity.SendData;
import com.oksbwn.server_activity.authoRize;

public class NavigationCommands {
	SendData sendDataObject=null;
	private String rpcString;
	private String serverURL;
	private String username;
	private String password;
	private boolean isCompleted;
	NavigationCommands(SendData sendDataObject,String serverURL){
		this.sendDataObject=sendDataObject;
		this.serverURL=serverURL;
	}
	public void back(){
		rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Back\"}";
		executeCommand();
	}

	public void up(){// Up button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Up\"}";
	executeCommand();
	}

	public void down(){// Down button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Down\"}";
	executeCommand();
	}

	public void left(){// Left button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Left\"}";
	executeCommand();
	}

	public void right(){// Right button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Right\"}";
	executeCommand();
	}

	public void select(){// Select button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Select\"}";
	executeCommand();
	}

	public void home(){// Home Button.
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.Home\"}";
	executeCommand();
	}
	public void contextMenu(){//Context Menu
	rpcString="{\"jsonrpc\":\"2.0\",\"method\":\"Input.ContextMenu\"}";
	executeCommand();
	}
	private void executeCommand(){
		String urlString = "http://"+serverURL+"/jsonrpc?request="+rpcString;
		Authenticator.setDefault(new authoRize(username,password));
		String response=sendDataObject.sendGet(urlString, null, null);
		if(response!=null)
			isCompleted=true;
	}
	public boolean isDone(){
		
		return isCompleted;
	}
}
