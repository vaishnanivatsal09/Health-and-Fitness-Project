package health.fitness.pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import health.fitness.pro.AllCalculators.CalculatorHomePageActivity;
import health.fitness.pro.AllReminders.ReminderMainActivity;
import health.fitness.pro.StepCounter.StepCounter;

public class AllFeaturesActivity extends AppCompatActivity {

    ImageView btn_health_calculator, btn_exercise_steps, btn_reminder, btn_step_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_features);

        btn_health_calculator = findViewById(R.id.btn_health_calculator);
        btn_exercise_steps = findViewById(R.id.btn_exercise_steps);
        btn_reminder = findViewById(R.id.btn_reminder);
        btn_step_counter = findViewById(R.id.btn_step_counter);


        btn_health_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllFeaturesActivity.this, CalculatorHomePageActivity.class));
            }
        });


        btn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllFeaturesActivity.this, ReminderMainActivity.class));
            }
        });

        btn_exercise_steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllFeaturesActivity.this, AllFeaturesActivity.class));
            }
        });


        btn_step_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllFeaturesActivity.this, StepCounter.class));
            }
        });


    }
}