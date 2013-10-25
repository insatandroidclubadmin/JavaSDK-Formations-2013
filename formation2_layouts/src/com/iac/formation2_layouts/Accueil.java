package com.iac.formation2_layouts;

import com.iac.formation2.model.Friend;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Accueil extends Activity {

	EditText nom;
	EditText prenom;
	Spinner atelier;
	CheckBox staff_boolean;
	Button valider;

	String val_nom;
	String val_prenom;
	String val_atelier;
	Boolean val_staff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accueil_layout);

		nom = (EditText) findViewById(R.id.nom);
		prenom = (EditText) findViewById(R.id.prenom);
		atelier = (Spinner) findViewById(R.id.ateliers);
		staff_boolean = (CheckBox) findViewById(R.id.staff);
		valider = (Button) findViewById(R.id.button_valider);

		// appliquer un listener à notre bouton valider

		valider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				val_nom = nom.getText().toString();
				val_prenom = prenom.getText().toString();
				val_atelier = atelier.getSelectedItem().toString();
				val_staff = staff_boolean.isSelected();

				if (val_nom == null || val_prenom == null) {
					nom.setError(getResources().getString(R.string.error));
					prenom.setError(getResources().getString(R.string.error));
				} else {
					// construction d'une boite de dialog
					AlertDialog.Builder validerDialog = new AlertDialog.Builder(
							Accueil.this);
					validerDialog.setTitle(getResources().getString(
							R.string.dialog_title));
					// click sur le bouton annuler
					validerDialog.setNegativeButton(
							getResources().getString(R.string.annuler),
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Toast.makeText(
											getApplicationContext(),
											getResources().getString(
													R.string.annuler),
											Toast.LENGTH_SHORT).show();
								}
							});

					// click sur le bouton confirmer

					validerDialog.setPositiveButton(
							getResources().getString(R.string.confirmer),
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// Envoi de données à l'activité
									Friend friend = new Friend(val_nom,
											val_prenom, val_atelier, val_staff);
									Intent intent = new Intent(
											getApplicationContext(),
											Inscription.class);
									intent.putExtra("friend", friend);
									startActivity(intent);

								}
							}).show();

				}

			}
		}); // fin de listener

	}

}
