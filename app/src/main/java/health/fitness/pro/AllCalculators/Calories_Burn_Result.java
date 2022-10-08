package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import health.fitness.pro.R;


public class Calories_Burn_Result extends Activity {

    String TAG = getClass().getSimpleName();

    float caloriesburn;
    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    SharedPreferenceManager sharedPreferenceManager;
    String tips;
    TextView tv_ans_calburn;
    TextView tv_calburn;
    TextView tv_recomended;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_calories_burn);

        this.globalFunction = new GlobalFunction(this);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.typefaceManager = new TypefaceManager(getAssets(), this);

        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_ans_calburn = (TextView) findViewById(R.id.tv_ans_calburn);
        this.tv_calburn = (TextView) findViewById(R.id.tv_calburn);
        this.tv_recomended = (TextView) findViewById(R.id.tv_recomended);
        this.tv_ans_calburn.setTypeface(this.typefaceManager.getLight());
        this.tv_calburn.setTypeface(this.typefaceManager.getLight());
        this.tv_recomended.setTypeface(this.typefaceManager.getLight());
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        this.extras = getIntent().getExtras();
        this.caloriesburn = this.extras.getFloat("caloriesburn");
        this.tips = this.extras.getString("tips");
        StringBuilder sb = new StringBuilder();
        sb.append("tips");
        sb.append(this.tips);
        Log.d("tips", sb.toString());
        try {
            TextView textView = this.tv_ans_calburn;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(R.string.Calories_burned));
            sb2.append(" : ");
            sb2.append(String.format("%.02f", new Object[]{Float.valueOf(this.caloriesburn)}));
            textView.setText(String.valueOf(sb2.toString()));
            this.tv_recomended.setText(String.valueOf(this.tips));
            this.tv_calburn.setText("");
        } catch (Exception unused) {
        }

        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Calories_Burn_Result.this.onBackPressed();
            }
        });
    }
}
