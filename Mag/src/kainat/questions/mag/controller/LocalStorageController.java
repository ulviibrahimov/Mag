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
package kainat.questions.mag.controller;


import kainat.questions.mag.helper.DbHelper;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * @author ulvi
 *
 */
public class LocalStorageController {
	
	private Context context;
	public static DbHelper DBHelper;
	public SQLiteDatabase db;
	/**
	 * 
	 * @param ctx
	 */
	public LocalStorageController(Context ctx){
    	this.context=ctx;
    	DBHelper=new DbHelper(context);
    }

	/**
	 * open writable database
	 * @return current object
	 * @throws SQLException
	 */

	public LocalStorageController openForWrite() throws SQLException{
    	db=DBHelper.getWritableDatabase();
    	return this;
    }
	
	/**

	 * open database for read	
	 * @return current object
	 * @throws SQLException
	 */
	public LocalStorageController openForRead() throws SQLException{	
    	db=DBHelper.getReadableDatabase();
    	return this;
    }
	
	/**
	 * close database
	 */
	public void close(){
    	DBHelper.close();
	}

	


}// class close

