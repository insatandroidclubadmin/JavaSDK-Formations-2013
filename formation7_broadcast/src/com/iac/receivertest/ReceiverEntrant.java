package com.iac.receivertest;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class ReceiverEntrant extends BroadcastReceiver {

	static int modeActuel=-25;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		AudioManager audMan = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	
		if(modeActuel==-25){
			modeActuel=audMan.getRingerMode();
		}
		
		ArrayList<String> numerosInterdis = new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.list_num_entrant_interdits)));
		
		Bundle extra = intent.getExtras();
		
		if (extra!=null){
			String etatTelAppelEntrant = extra.getString(TelephonyManager.EXTRA_STATE);
			
			if(etatTelAppelEntrant.equals(TelephonyManager.EXTRA_STATE_RINGING)){
				String numeroEntrant= extra.getString(TelephonyManager.EXTRA_INCOMING_NUMBER) ;

				if(numerosInterdis.contains(numeroEntrant.replace(" " , "").replace("-", "").replace("(", "").replace(")", ""))){
					audMan.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				}
			}else{
				audMan.setRingerMode(modeActuel);
			}
		}
		
	}

}
