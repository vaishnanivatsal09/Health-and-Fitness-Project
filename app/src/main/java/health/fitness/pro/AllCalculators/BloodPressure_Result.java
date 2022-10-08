package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import health.fitness.pro.R;


public class BloodPressure_Result extends Activity {

    String TAG = getClass().getSimpleName();

    String diastolic_result;
    Float diastolic_val;
    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    SharedPreferenceManager sharedPreferenceManager;
    String syastolic_result;
    Float systolic_val;
    TextView tv_diastolic_ans;
    TextView tv_systolic_ans;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_bloodpressure);
        this.globalFunction = new GlobalFunction(this);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.tv_systolic_ans = (TextView) findViewById(R.id.tv_systolic_ans);
        this.tv_diastolic_ans = (TextView) findViewById(R.id.tv_diastolic_ans);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);


        this.extras = getIntent().getExtras();
        this.systolic_val = Float.valueOf(this.extras.getFloat("systolic_val"));
        this.diastolic_val = Float.valueOf(this.extras.getFloat("diastolic_val"));
        this.tv_systolic_ans.setTypeface(this.typefaceManager.getLight());
        this.tv_diastolic_ans.setTypeface(this.typefaceManager.getLight());
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BloodPressure_Result.this.onBackPressed();
            }
        });
        if (this.systolic_val.floatValue() < 120.0f) {
            this.syastolic_result = getString(R.string.Normal_Blood_Pressure);
        } else if (this.systolic_val.floatValue() >= 120.0f && this.systolic_val.floatValue() <= 139.0f) {
            this.syastolic_result = getString(R.string.Prehypertension);
        } else if (this.systolic_val.floatValue() >= 140.0f && this.systolic_val.floatValue() <= 159.0f) {
            this.syastolic_result = getString(R.string.High_Blood_Pressure_Stage_1);
        } else if (this.systolic_val.floatValue() >= 160.0f && this.systolic_val.floatValue() <= 180.0f) {
            this.syastolic_result = getString(R.string.High_Blood_Pressure_Stage_2);
        } else if (this.systolic_val.floatValue() > 180.0f) {
            this.syastolic_result = getString(R.string.Hypertensive_Crisis_Emergency_care_needed);
        }
        if (this.diastolic_val.floatValue() < 80.0f) {
            this.diastolic_result = getString(R.string.Normal_Blood_Pressure);
        } else if (this.diastolic_val.floatValue() >= 80.0f && this.diastolic_val.floatValue() <= 89.0f) {
            this.diastolic_result = getString(R.string.Prehypertension);
        } else if (this.diastolic_val.floatValue() >= 90.0f && this.diastolic_val.floatValue() <= 99.0f) {
            this.diastolic_result = getString(R.string.High_Blood_Pressure_Stage_1);
        } else if (this.diastolic_val.floatValue() >= 100.0f && this.diastolic_val.floatValue() <= 110.0f) {
            this.diastolic_result = getString(R.string.High_Blood_Pressure_Stage_2);
        } else if (this.diastolic_val.floatValue() > 110.0f) {
            this.diastolic_result = getString(R.string.Hypertensive_Crisis_Emergency_care_needed);
        }
        TextView textView = this.tv_systolic_ans;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.upper_result));
        sb.append("\n");
        sb.append(this.syastolic_result);
        textView.setText(sb.toString());
        TextView textView2 = this.tv_diastolic_ans;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.lower_result));
        sb2.append("\n");
        sb2.append(this.diastolic_result);
        textView2.setText(sb2.toString());

    }
}
