package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import health.fitness.pro.R;


public class Cholestrol_Result extends Activity {

    String TAG = getClass().getSimpleName();

    double cholestrol;
    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    LinearLayout rl_main;
    SharedPreferenceManager sharedPreferenceManager;
    TextView tv_ans_bmr;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_bmr);

        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.globalFunction = new GlobalFunction(this);

        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.rl_main = (LinearLayout) findViewById(R.id.rl_main);

        this.extras = getIntent().getExtras();
        this.cholestrol = this.extras.getDouble("cholestrol");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        this.tv_ans_bmr.setTypeface(this.typefaceManager.getLight());
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.cholestrol);
        Log.d("cholestrol->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.your_cholestrol));
        sb2.append(" : ");
        sb2.append(String.format("%.0f", new Object[]{Double.valueOf(this.cholestrol)}));
        textView.setText(String.valueOf(sb2.toString()));
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Cholestrol_Result.this.onBackPressed();
            }
        });
    }

}
