package com.ticket.sminger.myticket.fragment;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.ticket.sminger.myticket.TicketApplication;
import com.ticket.sminger.myticket.dataRequest.TicketInfoResult;
import com.ticket.sminger.myticket.dataRequest.WebSiteResult;
import com.ticket.sminger.myticket.netBeanLoader.BeanLoaderImpl;
import com.ticket.sminger.myticket.netBeanLoader.IBeanLoader;
import com.ticket.sminger.myticket.sourceBean.TicketBean;

import android.os.Handler;

/**
 * Created by sminger on 15-8-6.
 */
public class FragmentMgr {
    private static TicketInfoResult mTickeInfoResult;
    private static WebSiteResult mWebSiteResult;

    public class build {

    }

    public static void getTicketData(final Handler handler, final int SiteID) {
        TicketBean ticketBean = new TicketBean();
        BeanLoaderImpl beanLoader = new BeanLoaderImpl(TicketApplication.context);
        beanLoader.setCallback(new IBeanLoader.ILoadCallback<TicketInfoResult>() {
            @Override
            public void onCacheComplete(int tag, TicketInfoResult result) {

            }

            @Override
            public void onHttpComplete(int resultCode, int tag, TicketInfoResult result) {

                if (resultCode == IBeanLoader.LOAD_SUCCESS) {
                    mTickeInfoResult = result;
                    Message msg = Message.obtain();
                    msg.what = SiteID;
                    msg.arg1 = resultCode;
                    msg.obj = mTickeInfoResult;
                    handler.sendMessage(msg);
                }

            }

            @Override
            public void onContentChange(int tag) {

            }
        });
        beanLoader.loadHttp(ticketBean, 1);
    }



}
