package health.fitness.pro.AllCalculators;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import health.fitness.pro.R;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.MyRestaurant_ViewHolder> implements Filterable {

    ArrayList<All_Home> FilteredList = new ArrayList<>();
    Activity activity;
    public ArrayList<All_Home> allVideo;
    ArrayList<All_Home> all_videohistoryArrayList;
    Context context;
    boolean isFilter = false;
    TypefaceManager typefaceManager;

    public class MyRestaurant_ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_home;
        RelativeLayout rl_home;
        TextView tv_title_home;

        public MyRestaurant_ViewHolder(View view) {
            super(view);
            this.tv_title_home = (TextView) view.findViewById(R.id.tv_title_home);
            this.image_home = (ImageView) view.findViewById(R.id.image_home);
            this.rl_home = (RelativeLayout) view.findViewById(R.id.rl_home);
            this.tv_title_home.setTypeface(Home_Adapter.this.typefaceManager.getLight());
        }
    }

    public Home_Adapter(Activity activity2, ArrayList<All_Home> arrayList, Context context2) {
        this.activity = activity2;
        this.context = context2;
        this.all_videohistoryArrayList = arrayList;
        this.allVideo = arrayList;
        this.typefaceManager = new TypefaceManager(context2.getAssets(), context2);
    }

    public MyRestaurant_ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyRestaurant_ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_home, viewGroup, false));
    }

    public void onBindViewHolder(final MyRestaurant_ViewHolder myRestaurant_ViewHolder, int i) {
        try {
            myRestaurant_ViewHolder.tv_title_home.setText(((All_Home) this.all_videohistoryArrayList.get(i)).title);
//            GradientDrawable gradientDrawable = (GradientDrawable) myRestaurant_ViewHolder.rl_home.getBackground();
//            StringBuilder sb = new StringBuilder();
//            sb.append("#");
//            sb.append(((All_Home) this.all_videohistoryArrayList.get(i)).color);
//            gradientDrawable.setColor(Color.parseColor(sb.toString()));
            try {
                Resources resources = this.context.getResources();
                myRestaurant_ViewHolder.image_home.setImageDrawable(resources.getDrawable(resources.getIdentifier(((All_Home) this.all_videohistoryArrayList.get(i)).image, "drawable", this.context.getPackageName())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            myRestaurant_ViewHolder.rl_home.setTag(Integer.valueOf(i));
            myRestaurant_ViewHolder.rl_home.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int i = ((All_Home) Home_Adapter.this.all_videohistoryArrayList.get(((Integer) view.getTag()).intValue())).f2614id;
                    if (i == 0) {
                        Intent intent = new Intent(Home_Adapter.this.activity, bmr_calculator.class);
                        intent.putExtra("from", "bmr");
                        Pair create = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create).toBundle());
                    }

                    else if (i == 1) {
                        Intent intent4 = new Intent(Home_Adapter.this.activity, BloodPressure_Calculator.class);
                        Pair create4 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent4, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create4).toBundle());
                    }
                    else if (i == 2) {
                        Intent intent5 = new Intent(Home_Adapter.this.activity, Sugar_calculator.class);
                        Pair create5 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent5, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create5).toBundle());
                    }
                    else if (i == 3) {
                        Intent intent6 = new Intent(Home_Adapter.this.activity, Blood_Volume_Calculator.class);
                        Pair create6 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent6, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create6).toBundle());
                    }

                    else if (i == 4) {
                        Intent intent9 = new Intent(Home_Adapter.this.activity, Body_Frame_Size_Calculator.class);
                        Pair create9 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent9, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create9).toBundle());
                    }
                    else if (i == 5) {
                        Intent intent10 = new Intent(Home_Adapter.this.activity, BMI_Calculator.class);
                        Pair create10 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent10, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create10).toBundle());
                    }
                    else if (i == 6) {
                        Intent intent11 = new Intent(Home_Adapter.this.activity, Body_Surface_Area_Calculator.class);
                        Pair create11 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent11, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create11).toBundle());
                    }
                    else if (i == 7) {
                        Intent intent12 = new Intent(Home_Adapter.this.activity, Trademill_Calculator.class);
                        Pair create12 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent12, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create12).toBundle());
                    }
                    else if (i == 8) {
                        Intent intent13 = new Intent(Home_Adapter.this.activity, Calories_burn_Calculator.class);
                        Pair create13 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent13, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create13).toBundle());
                    }

                    else if (i == 9) {
                        Intent intent16 = new Intent(Home_Adapter.this.activity, Cholestrol_Calculator.class);
                        Pair create16 = Pair.create(myRestaurant_ViewHolder.rl_home, Home_Adapter.this.activity.getString(R.string.transition1));
                        ActivityCompat.startActivity(Home_Adapter.this.activity, intent16, ActivityOptionsCompat.makeSceneTransitionAnimation(Home_Adapter.this.activity, create16).toBundle());
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getItemCount() {
        return this.all_videohistoryArrayList.size();
    }

    public Filter getFilter() {
        return new Filter() {

            public void publishResults(CharSequence charSequence, FilterResults filterResults) {
                Home_Adapter.this.all_videohistoryArrayList = (ArrayList) filterResults.values;
                Home_Adapter.this.notifyDataSetChanged();
            }

            public FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.values = Home_Adapter.this.allVideo;
                    filterResults.count = Home_Adapter.this.allVideo.size();
                    Home_Adapter.this.isFilter = false;
                } else {
                    Home_Adapter.this.FilteredList.clear();
                    Home_Adapter.this.isFilter = true;
                    for (int i = 0; i < Home_Adapter.this.allVideo.size(); i++) {
                        All_Home all_Home = (All_Home) Home_Adapter.this.allVideo.get(i);
                        if (all_Home.title.toString().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("pos->");
                            sb.append(String.valueOf(i));
                            Log.d("pos->", sb.toString());
                            Home_Adapter.this.FilteredList.add(all_Home);
                        }
                    }
                    filterResults.values = Home_Adapter.this.FilteredList;
                    filterResults.count = Home_Adapter.this.FilteredList.size();
                }
                return filterResults;
            }
        };
    }
}
