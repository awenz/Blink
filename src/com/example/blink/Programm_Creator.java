package com.example.blink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Programm_Creator extends Activity{
	
	private static final int ACTIVITY_CREATE=0;
	//private static final int ACTIVITY_EDIT=1;
	private DatabaseAdapter DBA;
	private Programm SP;
	private EditText programm_name;
	private EditText intervall1;
	private EditText intervall2;
	private EditText intervall3;
	private EditText intervall4;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programm_create);
        DBA = new DatabaseAdapter(this);
        DBA.open();
    }
	
	public void OnClick(View view) {
		SP = new Programm();
        programm_name = (EditText) findViewById(R.id.programm_name);
        intervall1 = (EditText) findViewById(R.id.intervall1);
        intervall2 = (EditText) findViewById(R.id.intervall2);
        intervall3 = (EditText) findViewById(R.id.intervall3);
        intervall4 = (EditText) findViewById(R.id.intervall4);
	    switch (view.getId()) {
	    case R.id.accept_programm:
	      SP.setname(programm_name.getText().toString());	
	      SP.seta(Integer.valueOf(intervall1.getText().toString()));
	      SP.setb(Integer.valueOf(intervall2.getText().toString()));
	      SP.setc(Integer.valueOf(intervall3.getText().toString()));
	      SP.setd(Integer.valueOf(intervall4.getText().toString()));
	      break;
	    }
	    try{
	    	DBA.createProgramm(SP);
	    } catch (Exception e) {
	    	 Toast.makeText(getApplicationContext(), "An Error Occured", Toast.LENGTH_LONG).show();
	    	e.printStackTrace();
	    }
	    finish();
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
