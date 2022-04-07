package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class PracticalTest01Var03Service extends Service {
    public PracticalTest01Var03Service() {
    }

    ProcessingThread processingThread;

    public int onStartCommand(Intent intent, int flags, int startId) {

        int firstNumber = intent.getIntExtra("firstValue", 0);
        int secondNumber = intent.getIntExtra("secondValue", 0);
        processingThread = new ProcessingThread(this, firstNumber, secondNumber);
        processingThread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}