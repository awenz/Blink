package com.example.blink;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Programm_Edit extends Activity{
	
	private EditText note;
	private Programm SP;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		SP = new Programm();
		setContentView(R.layout.programm_edit);
		setTitle(R.string.edit_programm);
		note = (EditText) findViewById(R.id.intervall);
		
		Button confirmButton = (Button) findViewById(R.id.confirm);
		}
	
	@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
    }
	
	private void saveState() {
        int body = Integer.valueOf(note.getText().toString());
        SP.seta(body);
    }

}
