package com.example.blink;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Programm_Creator extends ListActivity{
	
	private static final int ACTIVITY_CREATE=0;
	private static final int ACTIVITY_EDIT=1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programm_list);
        registerForContextMenu(getListView());
        populateList();
    }
	
	private void populateList() {
		String[] values = new String[] { "1","2","3" };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, Programm_Edit.class);
        i.putExtra("_id", id);
        startActivityForResult(i, ACTIVITY_EDIT);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.programm_creator, menu);
        return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_intervall:     addIntervall();
                                break;
        }
        return true;
    }
	
	public void addIntervall() {
    	Intent i = new Intent(this, Programm_Edit.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }

}
