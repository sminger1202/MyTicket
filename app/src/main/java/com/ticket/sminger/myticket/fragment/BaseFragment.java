package com.ticket.sminger.myticket.fragment;

import android.support.v4.app.Fragment;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.ticket.sminger.myticket.TicketApplication;
import com.ticket.sminger.myticket.Utils.ImageLoaderManager;

/**
 * Created by sminger on 15-8-6.
 */
public class BaseFragment extends Fragment {
    public ImageLoader mImageLoader;
    public BaseFragment() {
        mImageLoader = ImageLoaderManager.getInstance();
    }
}
