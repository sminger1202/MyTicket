package com.ticket.sminger.myticket.Utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.ticket.sminger.myticket.TicketApplication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by shi.ming on 2015/7/31.
 */
public class Util {

    /**
     * TODO 判断网络状态是否可用
     *
     * @return true: 网络可用 ; false: 网络不可用
     */
    public static boolean hasInternet() {
        ConnectivityManager m = (ConnectivityManager) TicketApplication.context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (m == null) {
            Log.d("NetWorkState", "Unavailabel");
            return false;
        } else {
            try {
                NetworkInfo[] info = m.getAllNetworkInfo();
                if (info != null) {
                    for (int i = 0; i < info.length; i++) {
                        if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                            Log.d("NetWorkState", "Availabel");
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        return false;
    }

    /**
     * Get the memory class of this device (approx. per-app memory limit)
     *
     * @param context
     * @return
     */
    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
    }

    /** 获得MD5串 */
    public static String md5(final String s) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    /**
     * 对url进行utf-8转义
     *
     * @param s
     *            字符串
     * @return
     */
    public static String URLEncoder(String s) {
        if (TextUtils.isEmpty(s))
            return "";
        try {
            s = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (NullPointerException e) {
            return "";
        }
        return s;
    }

    /**
     * 初次运行，获得GUID
     *
     * @return
     */
    public static final String getGUID() {
        return md5(DeviceInfo.MAC + "&" + DeviceInfo.IMEI + "&" + "&");
    }

    public static String getNetworkType() {
        ConnectivityManager m = (ConnectivityManager) TicketApplication.context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n = m.getActiveNetworkInfo();
        if (n == null) {
            return "";
        }
        int type = n.getType();
        if (type == ConnectivityManager.TYPE_WIFI) {// is WIFI
            return "WIFI";
        } else if (type == ConnectivityManager.TYPE_MOBILE) {// is MOBILE
            TelephonyManager tm = (TelephonyManager) TicketApplication.context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            return String.valueOf(tm.getNetworkType());
        } else {
            return "OTHER";
        }
    }

}
