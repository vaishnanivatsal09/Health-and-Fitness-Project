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

import androidx.annotation.Nullable;

import health.fitness.pro.R;


public class BodyFrame_Result extends Activity {

    String TAG = getClass().getSimpleName();
    String body_frame;
    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    SharedPreferenceManager sharedPreferenceManager;
    TextView tv_ans_bmr;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_body_frame);

        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.globalFunction = new GlobalFunction(this);

        this.extras = getIntent().getExtras();
        this.body_frame = this.extras.getString("body_frame");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_ans_bmr.setTypeface(this.typefaceManager.getLight());

        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.body_frame);
        Log.d("body_frame->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.Body_frame_text));
        sb2.append(" : ");
        sb2.append(this.body_frame);
        textView.setText(sb2.toString());

        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BodyFrame_Result.this.onBackPressed();
            }
        });
    }

}
