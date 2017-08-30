package com.viewengine.old.logic.global.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class OutgoingCallInterceptor extends BroadcastReceiver {

	// @Override
	// public void onReceive(Context context, Intent intent) {
	//
	// TelephonyManager telephonyManager = (TelephonyManager)
	// context.getSystemService(Context.TELEPHONY_SERVICE);
	// telephonyManager.listen(new CustomPhoneStateListener(context),
	// PhoneStateListener.LISTEN_CALL_STATE);
	//
	// }

	@Override
	public void onReceive(Context context, Intent intent) {
		final String oldNumber = intent
				.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
		boolean delete = false;
		if (oldNumber.equals("205")) {
			// this.setResultData("+972503086186");
			// final String newNumber = this.getResultData();
			// String msg = "Intercepted outgoing call. Old number " + oldNumber
			// + ", new number " + newNumber;
			// Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
//			setResultData(null);
//			Intent i = new Intent(context, ActivityMain.class);
//			i.putExtra("p", "+972503086186");
//			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			//i.putExtra("p", "+972546222427");
//			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			context.startActivity(i);
		} else {
			//new CallLogUtility().deleteNumFromCallLog(context.getContentResolver(), oldNumber);
		}
	}
}