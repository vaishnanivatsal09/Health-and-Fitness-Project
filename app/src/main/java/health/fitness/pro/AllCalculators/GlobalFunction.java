package health.fitness.pro.AllCalculators;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import health.fitness.pro.R;

public class GlobalFunction {
    Activity activity;
    SharedPreferenceManager sharedPreferenceManager;

    public GlobalFunction(Activity activity2) {
        this.activity = activity2;
        this.sharedPreferenceManager = new SharedPreferenceManager(activity2);
    }

    @SuppressLint("WrongConstant")
    public void showToast(String str) {
        Toast.makeText(this.activity, str, 0).show();
    }

    @SuppressLint("WrongConstant")
    public void hideKeyboard(View view) {
        if (view != null) {
            ((InputMethodManager) this.activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void shareIntent() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        String string = this.activity.getString(R.string.invite_friends_share_other_message);
        for (ResolveInfo resolveInfo : this.activity.getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.SUBJECT", "Share");
            if (TextUtils.equals(str, "com.facebook.katana")) {
                intent2.putExtra("android.intent.extra.TEXT", string);
            } else {
                intent2.putExtra("android.intent.extra.TEXT", string);
            }
            intent2.setPackage(str);
            arrayList.add(intent2);
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), "Share Via");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        this.activity.startActivity(createChooser);
    }

    public void set_locale_language() {
        String[] strArr = {"en", "  ja", "ko", "it", "zh-Hans", "zh-Hant", "de", "fr", "es", "it", "pt", "ru", "ar", "zh"};
        String language = Locale.getDefault().getLanguage();
        String locale = Locale.getDefault().toString();
        String str = this.sharedPreferenceManager.get_Language();
        String str2 = this.sharedPreferenceManager.get_Prev_Phone_Language();
        if (str.equals("")) {
            if (language.equals(str2)) {
                setLocale(str2, locale);
            } else if (Arrays.asList(strArr).contains(language)) {
                this.sharedPreferenceManager.set_Prev_Phone_Language(language);
                setLocale(language, locale);
            } else {
                setLocale("en", locale);
            }
        } else if (language.equals(str)) {
            setLocale(str, locale);
        } else if (language.equals(str2)) {
            if (Arrays.asList(strArr).contains(language)) {
                setLocale(str, locale);
            } else {
                setLocale("en", locale);
            }
        } else if (language.equals(str2)) {
        } else {
            if (Arrays.asList(strArr).contains(language)) {
                this.sharedPreferenceManager.set_Prev_Phone_Language(language);
                setLocale(language, locale);
                return;
            }
            setLocale("en", locale);
        }
    }

    public void setLocale(String str, String str2) {
        String[] strArr = {"en", "ja", "ko", "it", "zh-Hans", "zh-Hant", "de", "fr", "es", "it", "pt", "ru", "ar", "zh"};
        if (str2.trim().equalsIgnoreCase("zh_CN")) {
            this.sharedPreferenceManager.set_Language("zh-Hans");
        } else if (str2.trim().equalsIgnoreCase("zh_TW")) {
            this.sharedPreferenceManager.set_Language("zh-Hant");
        } else if (Arrays.asList(strArr).contains(str)) {
            this.sharedPreferenceManager.set_Language(str);
        } else {
            this.sharedPreferenceManager.set_Language("en");
        }
        Resources resources = this.activity.getResources();
        Configuration configuration = resources.getConfiguration();
        if (str.equals("zh")) {
            if (str2.trim().equalsIgnoreCase("zh_CN")) {
                configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            } else if (str2.trim().equalsIgnoreCase("zh_TW")) {
                configuration.setLocale(Locale.TRADITIONAL_CHINESE);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            } else {
                configuration.setLocale(new Locale(str.toLowerCase()));
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        } else if (VERSION.SDK_INT < 17) {
        } else {
            if (str.equals("zh-Hans")) {
                configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            } else if (str.equals("zh-Hant")) {
                configuration.setLocale(Locale.TRADITIONAL_CHINESE);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            } else {
                configuration.setLocale(new Locale(str.toLowerCase()));
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
    }

    public boolean isConnectingToInternet() {
        @SuppressLint("WrongConstant") ConnectivityManager connectivityManager = (ConnectivityManager) this.activity.getSystemService("connectivity");
        if (connectivityManager != null) {
            @SuppressLint("MissingPermission") NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
