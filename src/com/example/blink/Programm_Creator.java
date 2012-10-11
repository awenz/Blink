package com.example.blink;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Programm_Creator extends ListActivity{
	
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
        Intent i = new Intent(this, Programm_Creator.class);
        i.putExtra("_id", id);
        startActivityForResult(i, ACTIVITY_EDIT);
    }

}
