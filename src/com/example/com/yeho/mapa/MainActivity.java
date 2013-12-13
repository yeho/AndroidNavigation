package com.example.com.yeho.mapa;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		boolean isAvailable = isIntentavailable(this, "com.google.android.maps.MapsActivity");
	//	if (isAvailable)
//		{
			final Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?" + "saddr=21.145632,-101.697614&daddr=21.115259,-101.662697"));
		    intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
		    startActivity(intent);
//		}
	}

	
	public static boolean isIntentavailable(Context context, String action){
		final PackageManager packagemanager =  context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list = packagemanager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		
		
		return list.size() > 0;
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
