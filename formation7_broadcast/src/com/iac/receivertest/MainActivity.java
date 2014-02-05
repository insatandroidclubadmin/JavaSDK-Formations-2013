package com.iac.receivertest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Bundle extra = getIntent().getExtras();
		if(extra!=null){
			int show = extra.getInt("showDiag");
			if(show==1){
				String numeroBloque = extra.getString("number");
				
				 new AlertDialog.Builder(MainActivity.this)
				.setTitle("Attention !")
				.setMessage("Vous n'etes pas autorisé à appeler "+numeroBloque+" !" )
				.setNeutralButton("OK", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}
				}).show();
				
			}
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
