package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        this.plusButton = findViewById(R.id.plus_button);
        this.minusButton = findViewById(R.id.minus_button);
        this.firstField = findViewById(R.id.first_field);
        this.secondField = findViewById(R.id.second_field);
        this.result = findViewById(R.id.result);

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
                result.setText(String.valueOf(res));

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
                result.setText(String.valueOf(res));
            }
        });
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
}