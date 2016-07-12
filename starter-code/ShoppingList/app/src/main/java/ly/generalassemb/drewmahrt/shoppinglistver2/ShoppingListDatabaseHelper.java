package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by owlslubic on 7/12/16.
 */
public class ShoppingListDatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION=7;
    public static final String DATABASE_NAME="SHOPPING_DB";
    public static final String SHOPPING_TABLE_NAME="SHOPPING_LIST";

// public static final String COL_ID="_id";
 public static final String COL_NAME="ITEM_NAME";
// public static final String COL_DESCRIPTION="DESCRIPTION";
// public static final String COL_PRICE="PRICE";
// public static final String COL_TYPE="TYPE";


    private static ShoppingListDatabaseHelper sInstance;



    private ShoppingListDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    public static ShoppingListDatabaseHelper getInstance(Context context){
        if(sInstance==null){
            sInstance = new ShoppingListDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_TABLE_NAME);
        onCreate(db);
    }


//  public void addItem(String name, String description, double price, String type){
//      SQLiteDatabase db = getWritableDatabase();
//      ContentValues values = new ContentValues();
//      values.put(COL_NAME,name);
//      values.put(COL_DESCRIPTION,description);
//      values.put(COL_PRICE,price);
//      values.put(COL_TYPE,type);

//      db.insert(SHOPPING_TABLE_NAME,null,values);
//      db.close();
//  }

    public Cursor getAllItems(){
        SQLiteDatabase db = getReadableDatabase();

        return db.query(SHOPPING_TABLE_NAME,null,null,null,null,null,null);

    } //THEN JUST call cursor.get(COL whatever names ) in the main

//



}
