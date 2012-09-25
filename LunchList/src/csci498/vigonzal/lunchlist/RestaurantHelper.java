package csci498.vigonzal.lunchlist;

import android.content.Context;
import android.database.Cursor;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.database.SQLException;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

class RestaurantHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME="lunchlist.db";
	private static final int SCHEMA_VERSION=1;

	
	public RestaurantHelper(Context context) {
	
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
	
			db.execSQL("CREATE TABLE restaurants (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"name TEXT, address TEXT, type TEXT, notes, TEXT)");
			
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//only have one schema so it wont be needed until we have two.
	}
	
	public void insert(String name, String address, String type, String notes){
		
		ContentValues cv = new ContentValues();
		
		cv.put("name", name);
		cv.put("address", address);
		cv.put("type", type);
		cv.put("notes", notes);
		
		getWritableDatabase().insert("restaurants", "name", cv);
		
	}
	
	public Cursor getAll(){

		return (getReadableDatabase().rawQuery("SELECT _id name, address, type, notes " +
				"FROM restaurants ORDER BY name", null));
	}
	
	public Cursor getById(String id) {
		
		String[] args = {id};
		
		return(getReadableDatabase().rawQuery("SELECT _id, name, address, type, notes " +
				"FROM restaurants WHERE _ID=?", args));
		
	}
	public void update(String id, String name, String address, String type, String notes) {
		
		ContentValues cv = new ContentValues();
		String[] args = {id};
		
		cv.put("name", name);
		cv.put("address", address);
		cv.put("type", type);
		cv.put("notes", notes);
		
		getWritableDatabase().update("restaurants", cv, "_ID=?", args);
		
	}

	public String getName(Cursor c){

		return(c.getString(1));

	}

	public String getAddress(Cursor c){

		return(c.getString(2));

	}

	public String getType(Cursor c){

		return(c.getString(3));

	}

	public String getNotes(Cursor c){

		return(c.getString(4));

	}

}