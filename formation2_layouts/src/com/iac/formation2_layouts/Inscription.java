package com.iac.formation2_layouts;

import com.iac.formation2.model.Friend;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Inscription extends Activity {
 TextView salutation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inscription_layout);
		
		salutation = (TextView) findViewById(R.id.salutation);
		
		
		Friend friend = (Friend) getIntent().getSerializableExtra("friend");
		salutation.setText("Bonjour "+friend.getNom()+" "+friend.getPrenom()+"\n La bienvenue dans l'atelier "+friend.getAtelier());
		
		
		
		
}
	
}
