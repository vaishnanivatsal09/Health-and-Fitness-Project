package health.fitness.pro.AllCalculators;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import health.fitness.pro.R;

public class CalculatorHomePageActivity extends AppCompatActivity {

    private static final String TAG = "Home_page";
    ArrayList<All_Home> all_home = new ArrayList<>();
    String[] arr_image;
    String[] arr_title;

    Home_Adapter home_adapter;
    GridLayoutManager manager;
    RecyclerView recyclerview_homepage;
    SharedPreferenceManager sharedPreferenceManager;
    TypefaceManager typefaceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_home_page);


        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.typefaceManager = new TypefaceManager(this.getAssets(), this);
        this.recyclerview_homepage = (RecyclerView) findViewById(R.id.recyclerview_homepage);

        this.manager = new GridLayoutManager(this, 2);
        this.typefaceManager = new TypefaceManager(this.getAssets(), this);

        this.recyclerview_homepage.setLayoutManager(this.manager);
        this.home_adapter = new Home_Adapter(this, this.all_home, this);

        this.recyclerview_homepage.setAdapter(this.home_adapter);

        this.arr_title = getResources().getStringArray(R.array.arr_home_title);
        this.arr_image = getResources().getStringArray(R.array.arr_home_image1);

        for (int i = 0; i < this.arr_title.length; i++) {
            this.all_home.add(new All_Home(i, this.arr_title[i],  this.arr_image[i]));
        }

    }
}