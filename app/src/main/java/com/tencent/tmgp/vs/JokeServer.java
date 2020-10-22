package com.tencent.tmgp.vs;
import android.app.*;
import android.os.*;
import android.content.*;

public class JokeServer extends BroadcastReceiver
{
	static final String action_boot="android.intent.action.BOOT_COMPLETED";
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		if (intent.getAction().equals(action_boot)){
			Intent startIntent=new Intent(context,MainActivity.class); //接收到广播后，跳转到MainActivity
			startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(startIntent);
		}
	}
	

	
	
}
