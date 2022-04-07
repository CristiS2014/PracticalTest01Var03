package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread{

    private Context context;
    private int firstNumber;
    private int secondNumber;
    public ProcessingThread(Context context, int firstNumber, int secondNumber) {
        this.context = context;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public void run() {

        sendMessage1();
        sleep();
        sendMessage2();
    }

    private void sleep() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage1() {
        Intent intent = new Intent();
        intent.setAction("PLUS_ACTION");
        intent.putExtra("plus", String.valueOf(firstNumber + secondNumber));
        context.sendBroadcast(intent);
    }

    private void sendMessage2() {
        Intent intent = new Intent();
        intent.setAction("MINUS_ACTION");
        intent.putExtra("minus", String.valueOf(firstNumber - secondNumber));
        context.sendBroadcast(intent);
    }

}
