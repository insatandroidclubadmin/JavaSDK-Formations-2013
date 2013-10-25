package org.iac.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
 
	Button button ;
	EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  (Button) findViewById(R.id.button1);
        editText1 =  (EditText) findViewById(R.id.editText1);
        button.setOnClickListener(new OnClickListener() {
			 public void onClick(View v) {
      				Toast.makeText(getApplicationContext(),editText1.getText().toString(),Toast.LENGTH_LONG).show();
      				
			}
		});
        
    }


    
}
