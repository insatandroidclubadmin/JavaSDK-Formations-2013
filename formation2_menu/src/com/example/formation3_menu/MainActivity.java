package com.example.formation3_menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
 Button click ;
 Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		click = (Button) findViewById(R.id.button1);
		
		
		//une fois on clique sur le bouton , on va afficher une  boite de dialogue
		click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                
				dialog = new Dialog(MainActivity.this);
//				dialog.setTitle("confirmation");
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog);
				dialog.show();
				
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.authentification:
			Toast.makeText(getApplicationContext(),
					getResources().getString(R.string.authentification),
					Toast.LENGTH_SHORT).show();
			break;

		case R.id.inscription:
			Toast.makeText(getApplicationContext(),
					getResources().getString(R.string.inscription),
					Toast.LENGTH_SHORT).show();
			break;

		default:
			Toast.makeText(getApplicationContext(),
					getResources().getString(R.string.action_settings),
					Toast.LENGTH_SHORT).show();
			break;

		}

		return super.onOptionsItemSelected(item);
	}

}

