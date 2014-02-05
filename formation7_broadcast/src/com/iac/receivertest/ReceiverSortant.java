package com.iac.receivertest;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ReceiverSortant extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		ArrayList<String> numerosInterdis = new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.list_num_sortant_interdits)));
		
		Bundle extra = intent.getExtras();
		
		if(extra!=null){
			String numeroSortant = extra.getString(Intent.EXTRA_PHONE_NUMBER);
			
			if(numerosInterdis.contains(numeroSortant.replace(" " , "").replace("-", "").replace("(", "").replace(")", ""))){
				setResultData(null);
				
				Intent i = new Intent(context, MainActivity.class);
				i.putExtra("showDiag", 1);
				i.putExtra("number", numeroSortant);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(i);
				
			}
		}
		
	}

}
