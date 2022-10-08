package health.fitness.pro.AllReminders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import health.fitness.pro.R;

public class ReminderMainActivity extends AppCompatActivity {

    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_main);

        ReminderMainActivity.this.openFragment(Fragment_Reminder.newInstance(str, str));
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}