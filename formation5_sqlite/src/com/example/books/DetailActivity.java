package com.example.books;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	TextView book_id;
	TextView book_title;
	TextView book_author;
	Book book ;

	MySQLiteHelper db ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		MySQLiteHelper db = new MySQLiteHelper(this);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			 book = (Book) extras.get("book");
		Toast.makeText(getApplicationContext(), "book "+book.getAuthor(),1000).show();

		book_id = (TextView) findViewById(R.id.livre_id);
		book_title = (TextView) findViewById(R.id.livre_title);
		book_author = (TextView) findViewById(R.id.livre_author);
//		
		book_id.setText(String.valueOf(book.getId()));
		book_author.setText(book.getAuthor());
		book_title.setText(book.getTitle());
		
		}

	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
