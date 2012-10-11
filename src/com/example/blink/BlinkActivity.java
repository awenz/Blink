package com.example.blink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BlinkActivity extends Activity {

	private TextView text;
	private boolean running = false;
	private Handler handler;
	private static final int ACTIVITY_CREATE=0;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.Count);
        handler = new Handler();
        final Stopwatch s = new Stopwatch();
           
        
        final Button button = (Button) findViewById(R.id.trigger);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  	
            	if(running){
            		s.stop();
            		button.setText("Start");
            		running = false;
            		}
            	else{
            		s.start();
            		button.setText("Stop");
            		running = true;
            	}           	
                updateTime(s);            	
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manage_programms:     manageProgramms();
                                break;
        }
        return true;
    }
    
    public void updateTime(final Stopwatch s){
    	Runnable run = new Runnable() {
    		@Override
    		public void run(){
    			while(running){
    				final String textf;
                	textf = String.valueOf(s.getElapsedTime());
                	handler.post(new Runnable() {
                		@Override
                        public void run() {
                          text.setText(textf);
                        }
                	});
                }
    		}
    	};
    	new Thread(run).start();
    }
    
    public void manageProgramms() {
    	Intent i = new Intent(this, Manage_List.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }
}
