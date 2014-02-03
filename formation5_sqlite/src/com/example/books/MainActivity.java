package com.example.books;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	List<Book> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MySQLiteHelper db = new MySQLiteHelper(this);

		/**
		 * CRUD Operations
		 * */
		list = db.getAllBooks();
		
		if(list.size() == 0){
		
		// add Books
		db.addBook(new Book("Android",
				"XX"));
		db.addBook(new Book("JAVA",
				"XY"));
		db.addBook(new Book("PHP", "XZ"));
		//
		// get all books
		 List<Book> list = db.getAllBooks();
		

		}
		
		Intent i = new Intent(this, ListBookActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
