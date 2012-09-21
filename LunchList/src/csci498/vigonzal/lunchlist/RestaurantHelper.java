package csci498.vigonzal.lunchlist;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
}