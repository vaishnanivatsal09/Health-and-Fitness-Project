package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import health.fitness.pro.R;

public class BodySurfaceArea_Result extends Activity {

    String TAG = getClass().getSimpleName();

    double bsa;
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

        this.extras = getIntent().getExtras();
        this.bsa = this.extras.getDouble("bsa");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        this.tv_ans_bmr.setTypeface(this.typefaceManager.getLight());
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        iv_close = findViewById(R.id.iv_close);

        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BodySurfaceArea_Result.this.onBackPressed();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.bsa);
        Log.d("bmr_val->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.your_body_surface_Area));
        sb3.append(" :\n");
        sb3.append(String.format("%.02f", new Object[]{Double.valueOf(this.bsa)}));
        sb2.append(String.valueOf(sb3.toString()));
        sb2.append(" m<sup>2</sup>");
        textView.setText(Html.fromHtml(sb2.toString()));
    }

}
