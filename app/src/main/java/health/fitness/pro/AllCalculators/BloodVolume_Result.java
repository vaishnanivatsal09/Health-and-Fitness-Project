package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import health.fitness.pro.R;


public class BloodVolume_Result extends Activity {

    String TAG = getClass().getSimpleName();

    double blood_volume;
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
        this.blood_volume = this.extras.getDouble("blood_volume");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        this.tv_ans_bmr.setTypeface(this.typefaceManager.getLight());

        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.blood_volume);
        Log.d("bmr_val->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.Your_bloodvolume_is));
        sb3.append(" :\n");
        sb3.append(String.format("%.02f", new Object[]{Double.valueOf(this.blood_volume)}));
        sb2.append(String.valueOf(sb3.toString()));
        sb2.append(" ");
        sb2.append(getString(R.string.liter));
        textView.setText(sb2.toString());
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BloodVolume_Result.this.onBackPressed();
            }
        });
    }
}
