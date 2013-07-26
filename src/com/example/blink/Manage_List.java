package com.example.blink;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Manage_List extends ListActivity {
	
	private static final int ACTIVITY_CREATE=0;
	private static final int ACTIVITY_EDIT=1;
    private static final int ACTIVITY_RUN=1;
	private DatabaseAdapter DBA;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programm_list);
        DBA = new DatabaseAdapter(this);
        DBA.open();
        populateList();
        //registerForContextMenu(getListView());
    }
	
	private void populateList() {
		List<ListItem> values = DBA.fetchList();
		ArrayAdapter<ListItem> adapter = new ArrayAdapter<ListItem>(this,
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
	
	@Override
	  protected void onResume() {
	    DBA.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    DBA.close();
	    super.onPause();
	  }

}
