package com.ticket.sminger.myticket;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.ticket.sminger.myticket.Utils.DeviceInfo;
import com.ticket.sminger.myticket.Utils.ImageLoaderManager;
import com.ticket.sminger.myticket.Utils.Profile;

/**
 * Created by shi.ming on 2015/7/31.
 */
public class TicketApplication extends MultiDexApplication {

    public static Context context = null;

    public static String versionName;

    public static String appName;

    private static SharedPreferences mSharedPreferences;

    public static String COOKIE = null;// 服务器返回的 Cookie 串



    @Override
    public void onCreate() {
        context = this;
        ImageLoaderManager.initImageLoaderConfiguration(this);

        DeviceInfo.init();

        initVersionInfo() ;

        initPreferences();

        super.onCreate();
    }

    private void initVersionInfo() {
        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(),
                    PackageManager.GET_META_DATA).versionName;
            appName = getPackageManager().getPackageInfo(getPackageName(),
                    PackageManager.GET_META_DATA).applicationInfo.name;
            Profile.VER = versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = "5.0";
            Profile.VER = versionName;
            Log.e("", e.toString());
        }
    }

    private void initPreferences() {
//        mDownloadSharedPreferences = context.getSharedPreferences(context.getPackageName() + "_cache",
//                UIUtils.hasGingerbread() ? MODE_MULTI_PROCESS : MODE_PRIVATE);

        mSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
    }
}
