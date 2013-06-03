package com.example.blink;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseInterface extends SQLiteOpenHelper{
	
	public static final String DB_Name = "blink_db";
	public static final int DB_Version = 1;
	public static final String KEY_ROWID = "_id";
    public static final String KEY_TEXT = "name";
	
	private static final String List_DB_Create = "create table plist (" + KEY_ROWID + " integer primary key autoincrement, " + KEY_TEXT + " text not null)";
	private static final String Programm_DB_Create = "create table programm (_id integer primary key autoincrement, time integer not null, lid integer not null, foreign key (lid) references plist (_id));";
	private static final String test_list = "insert into plist VALUES (null,'test')";
	
	public DatabaseInterface(Context context){
		super(context,DB_Name,null,DB_Version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database){
		database.execSQL(List_DB_Create);
		database.execSQL(Programm_DB_Create);
		database.execSQL(test_list);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, int db_old, int db_new){
		Log.w(DatabaseInterface.class.getName(),"Upgrading from "+ db_old + "to " + db_new);
		database.execSQL("DROP TALE IF EXISTS plist");
		database.execSQL("DROP TALE IF EXISTS programm");
		onCreate(database);
	}
}

