package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    private TextView result;
    private Button correct;
    private Button incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        this.result = findViewById(R.id.result);
        this.correct = findViewById(R.id.correct_button);
        this.incorrect = findViewById(R.id.incorrect_button);

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) { //intent.getExtras().containsKey(key)
            if (intent.getExtras().containsKey("result")) {
                this.result.setText(intent.getStringExtra("result"));
            }
        }
    }
}