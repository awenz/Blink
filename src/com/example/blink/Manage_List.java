package com.example.blink;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Manage_List extends ListActivity {
	
	private static final int ACTIVITY_CREATE=0;
	private static final int ACTIVITY_EDIT=1;
	private DatabaseAdapter DBA;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBA = new DatabaseAdapter(this);
        DBA.open();
        populateList();
        setContentView(R.layout.programm_list);
        registerForContextMenu(getListView());
    }
	
	private void populateList() {
		Cursor listCursor  = DBA.fetchList();
		String [] from = new String[]{DatabaseAdapter.KEY_TEXT};
    	int[] to = new int[]{R.id.notes_row};
    	SimpleCursorAdapter list = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,listCursor,from,to);
    	setListAdapter(list);
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, Programm_Creator.class);
        i.putExtra("_id", id);
        startActivityForResult(i, ACTIVITY_EDIT);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manage_programms, menu);
        return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_programm:     addProgramm();
                                break;
        }
        return true;
    }
	
	public void addProgramm() {
    	Intent i = new Intent(this, Programm_Creator.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }

}
