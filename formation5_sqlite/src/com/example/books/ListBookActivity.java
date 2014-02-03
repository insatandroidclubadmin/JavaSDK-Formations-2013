package com.example.books;

import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListBookActivity extends ListActivity {

	MySQLiteHelper db = new MySQLiteHelper(this);
	Dialog dialog;
	LinearLayout l_layout;
	Book b;
	List<Book> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		
		// get all books
		list = db.getAllBooks();
		
		//
		final String[] books_title = new String[list.size()];
          int i =0;
		for (Book lis : list) {
			
			books_title[i] = lis.getTitle();
			i++;
		}
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_books,
				books_title));

		ListView listView = getListView();

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {

				 b = db.getBook(arg2 + 1);
				 
				 dialog = new Dialog(ListBookActivity.this);
					dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					l_layout = (LinearLayout) View.inflate(getApplicationContext(), R.layout.dialog_layout, null);
					dialog.setContentView(R.layout.dialog_layout);
					
					//detail
					Button b = (Button)dialog.findViewById(R.id.detail);
                    b.setOnClickListener(new OnClickListener() {
                    	
						@Override
						public void onClick(View v) {
							dialog.dismiss();
                               detail(v);
						}
					})	;	
                    
                    
                    //delete
                    Button b2 = (Button)dialog.findViewById(R.id.delete);
                    b2.setOnClickListener(new OnClickListener() {
                    	
						@Override
						public void onClick(View v) {
							dialog.dismiss();
                               supprimer(v);
                               
						}
					})	;	
                    
                    
					dialog.show();       
			}
		});

	}
	
	
	public void supprimer(View v){
		 db.deleteBook(b);
		this.recreate();
		 
	}
	
	public void update(View v){
		
	}
	
	public void detail(View v){
		Intent i = new Intent(getApplicationContext(),
				DetailActivity.class);
		i.putExtra("book", b);
		startActivity(i);
		
	}


	
}
