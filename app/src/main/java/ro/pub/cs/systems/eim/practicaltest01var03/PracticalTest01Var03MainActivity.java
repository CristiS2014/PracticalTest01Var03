package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button plusButton;
    private Button minusButton;
    private EditText firstField;
    private EditText secondField;
    private TextView result;
    private Button nextActivity;
    private BroadcastReceiverCustom broadcastReceiverCustom = new BroadcastReceiverCustom();
    private IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        this.plusButton = findViewById(R.id.plus_button);
        this.minusButton = findViewById(R.id.minus_button);
        this.firstField = findViewById(R.id.first_field);
        this.secondField = findViewById(R.id.second_field);
        this.result = findViewById(R.id.result);
        this.nextActivity = findViewById(R.id.next_activity);

        this.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNumber;
                int secondNumber;

                try {
                    firstNumber = Integer.parseInt(firstField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplication(), "NaN", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    secondNumber = Integer.parseInt(secondField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplication(), "NaN", Toast.LENGTH_LONG).show();
                    return;
                }

                int res = firstNumber + secondNumber;
                result.setText(String.valueOf(firstNumber) + " + " + String.valueOf(secondNumber)  + " = " + String.valueOf(res));
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03Service.class);
                intent.putExtra("firstValue", firstNumber);
                intent.putExtra("secondValue", secondNumber);
                getApplicationContext().startService(intent);

            }
        });

        this.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNumber;
                int secondNumber;

                try {
                    firstNumber = Integer.parseInt(firstField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplication(), "NaN", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    secondNumber = Integer.parseInt(secondField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplication(), "NaN", Toast.LENGTH_LONG).show();
                    return;
                }

                int res = firstNumber - secondNumber;
                result.setText(String.valueOf(firstNumber) + " - " + String.valueOf(secondNumber)  + " = " + String.valueOf(res));
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03Service.class);
                intent.putExtra("firstValue", firstNumber);
                intent.putExtra("secondValue", secondNumber);
                getApplicationContext().startService(intent);
            }
        });

        this.nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                intent.putExtra("result", result.getText().toString());
                startActivityForResult(intent, 10);
            }
        });
        intentFilter.addAction("PLUS_ACTION");
        intentFilter.addAction("MINUS_ACTION");
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var03Service.class);
        stopService(intent);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiverCustom);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiverCustom, intentFilter);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstField", firstField.getText().toString());
        savedInstanceState.putString("secondField", secondField.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("firstField")) {
            firstField.setText(savedInstanceState.getString("firstField"));
            Toast.makeText(getApplication(), savedInstanceState.getString("firstField"), Toast.LENGTH_LONG).show();
        }
        if (savedInstanceState.containsKey("secondField")) {
            secondField.setText(savedInstanceState.getString("secondField"));
            Toast.makeText(getApplication(), savedInstanceState.getString("secondField"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 10) {

            if (resultCode == -1) {
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
            }

            if (resultCode == 0) {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show();
            }
        }
    }
}