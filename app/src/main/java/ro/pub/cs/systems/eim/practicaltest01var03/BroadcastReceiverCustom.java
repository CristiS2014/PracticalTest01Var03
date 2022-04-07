package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverCustom extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras().containsKey("plus")) {
            Log.d("RECV", intent.getStringExtra("plus"));
        }

        if (intent.getExtras().containsKey("minus")) {
            Log.d("RECV", intent.getStringExtra("minus"));
        }

    }
}
