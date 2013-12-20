/*
Adventure App - Allows you to create an Adventure Book, or Download
	books from other authors.
Copyright (C) Fall 2013 Team 5 CMPUT 301 University of Alberta

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package kainat.questions.mag.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
/**
 * 
 * @author ulvi
 *
 */
public class DbHelper extends SQLiteOpenHelper {
	
	/**
	 * Correct answer expects either a,b,c,d,e
	 * if no image,null
	 */
	static final String QuestionsTable ="create table if not exists questions "+
										  "(question_id integer primary key autoincrement,"+
										  "question_text VARCHAR not null,"+
										  "choice_a VARCHAR not null,"+
										  "choice_b VARCHAR not null,"+
										  "choice_c VARCHAR not null,"+
										  "choice_d VARCHAR not null,"+
										  "choice_e VARCHAR not null,"+
										  "correct_answer VARCHAR not null,"+
										  "question_type VARCHAR not null,"+
										  "image VARCHAR;";
	
	static final String filename="questions.xml";
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LocalStorage.db";
/**
 * 
 * @param context
 */
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
   /**
    * Creates tables
    */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QuestionsTable);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}