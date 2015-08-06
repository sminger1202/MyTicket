package com.ticket.sminger.myticket.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ticket.sminger.myticket.MainActivity;
import com.ticket.sminger.myticket.R;
import com.ticket.sminger.myticket.TicketApplication;
import com.ticket.sminger.myticket.adapter.ticketAdapter;
import com.ticket.sminger.myticket.dataRequest.TicketInfoResult;

import android.os.Handler;

/**
 * Created by sminger on 15-8-6.
 */
public class TicketFragment extends BaseFragment{

    private static final String ARG_SITE_NUMBER = "ticketSite_number";
    private static int mCurrentSiteID;
    private TextView mTextView;
    private ListView mListView;
    private ticketAdapter mListAdapter;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                default:

                    mListAdapter.configData((TicketInfoResult)msg.obj);

            }
        }
    };

    public TicketFragment() {
        super();
    }

    public static TicketFragment newInstance(int siteNumber) {
        TicketFragment fragment = new TicketFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SITE_NUMBER, siteNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView( rootView );
        initData();
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCurrentSiteID = getArguments().getInt(ARG_SITE_NUMBER);
        ((MainActivity) activity).onSectionAttached(mCurrentSiteID);
    }

    public void initView(View rootView) {
        mTextView = (TextView)rootView.findViewById(R.id.site_label);
        mListView = (ListView)rootView.findViewById(R.id.ticketList);
        mListAdapter = new ticketAdapter(getActivity(), this);
        mListView.setAdapter(mListAdapter);
    }

    public void initData() {
        mCurrentSiteID = getArguments().getInt(ARG_SITE_NUMBER);
        FragmentMgr.getTicketData(mHandler, mCurrentSiteID);

    }

}
