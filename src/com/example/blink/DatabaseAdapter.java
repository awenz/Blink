package com.example.blink;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {
	
	private final Context mCtx;
	private DatabaseInterface DBI;
    private SQLiteDatabase DB;
    public static final String KEY_ROWID = "_id";
    public static final String KEY_TEXT = "name";
    public static final String DATABASE_TABLE = "plist";
    
	public DatabaseAdapter(Context context){
		this.mCtx=context;
	}
	
	public DatabaseAdapter open() {
		DBI = new DatabaseInterface(mCtx);
		DB = DBI.getWritableDatabase();
		return this;
	}
	
	public void close(){
		DBI.close();
	}
	
	public long createProgramm(Programm programm){
		ContentValues data = new ContentValues();
		data.put("name", programm.getname());
		DB.insert("plist", null, data);
		if(0 != programm.geta())
			data.put("time",programm.geta());
		else
			data.put("time",5);
		return DB.insert("programm", null, data);
	}
	
	public boolean deleteNote(long ID){
		return DB.delete("note", "id" + "=" + ID, null) > 0;
	}
	
	public Cursor fetchNotes(){
		//return DB.rawQuery( "select rowid _id,* from notes", null);
		return DB.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TEXT}, null, null, null, null, null);
	}
	
	public Cursor fetchList(){
		return DB.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TEXT}, null, null, null, null, null);
	}
	
	public Cursor fetchProgramm(long rowId) throws SQLException {

        Cursor mCursor =

        		DB.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                        KEY_TEXT}, KEY_ROWID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }
	
	public boolean updateNote(long rowId, String text) {
        ContentValues args = new ContentValues();
        args.put(KEY_TEXT, text);

        return DB.update("notes", args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
