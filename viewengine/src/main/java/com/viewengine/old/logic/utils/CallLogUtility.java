package com.viewengine.old.logic.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

public class CallLogUtility {

	public void AddNumToCallLog(ContentResolver resolver, String strNum,
			int type, long timeInMiliSecond) {
		while (strNum.contains("-")) {
			strNum = strNum.substring(0, strNum.indexOf('-'))
					+ strNum.substring(strNum.indexOf('-') + 1, strNum.length());
		}
		ContentValues values = new ContentValues();
		values.put(CallLog.Calls.NUMBER, strNum);
		values.put(CallLog.Calls.DATE, timeInMiliSecond);
		values.put(CallLog.Calls.DURATION, 0);
		values.put(CallLog.Calls.TYPE, type);
		values.put(CallLog.Calls.NEW, 1);
		values.put(CallLog.Calls.CACHED_NAME, "");
		values.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0);
		values.put(CallLog.Calls.CACHED_NUMBER_LABEL, "");
		Log.d("AddToCallLog", "Inserting call log placeholder for " + strNum);

		if (null != resolver) {
			resolver.insert(CallLog.Calls.CONTENT_URI, values);
		}
		// getContentResolver().delete(url, where, selectionArgs)
	}

	public void deleteNumFromCallLog(ContentResolver resolver, String strNum) {
		try {
			String strUriCalls = "content://call_log/calls";
			Uri UriCalls = Uri.parse(strUriCalls);
			// Cursor c = res.query(UriCalls, null, null, null, null);
			if (null != resolver) {
				resolver.delete(UriCalls, CallLog.Calls.NUMBER + "=?",
						new String[] { strNum });
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void deleteLastCallLog(Context context, String phoneNumber) {

		try {
			// Thread.sleep(4000);
			String strNumberOne[] = { phoneNumber };
			Cursor cursor = context.getContentResolver().query(
					CallLog.Calls.CONTENT_URI, null,
					CallLog.Calls.NUMBER + " = ? ", strNumberOne,
					CallLog.Calls.DATE + " DESC");

			if (cursor.moveToFirst()) {
				int idOfRowToDelete = cursor.getInt(cursor
						.getColumnIndex(CallLog.Calls._ID));
				int foo = context.getContentResolver().delete(
						CallLog.Calls.CONTENT_URI, CallLog.Calls._ID + " = ? ",
						new String[] { String.valueOf(idOfRowToDelete) });

			}
		} catch (Exception ex) {
			Log.v("deleteNumber",
					"Exception, unable to remove # from call log: "
							+ ex.toString());
		}
	}
	
	public void deleteCallLogByNumber(ContentResolver resolver, String number) {
		String queryString = "NUMBER=" + number;
		resolver.delete(CallLog.Calls.CONTENT_URI, queryString, null);
	}
}