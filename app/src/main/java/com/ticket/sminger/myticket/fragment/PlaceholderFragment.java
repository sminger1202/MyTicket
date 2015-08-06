package com.ticket.sminger.myticket.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ticket.sminger.myticket.MainActivity;
import com.ticket.sminger.myticket.R;
import com.ticket.sminger.myticket.adapter.ticketAdapter;

/**
     * A placeholder fragment containing a simple view.
     */
public class PlaceholderFragment extends BaseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static ListView mListView;
    private static int mCurrentCateID = 0;
    private static ListAdapter mListAdapter;



    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
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
        mCurrentCateID = getArguments().getInt(ARG_SECTION_NUMBER);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    public void initView(View rootView) {
        mListView = (ListView)rootView.findViewById(R.id.ticketList);
//        mListAdapter = new ticketAdapter(getActivity(), this);
        mListView.setAdapter(mListAdapter);
    }

    public void initData() {
        mCurrentCateID = getArguments().getInt(ARG_SECTION_NUMBER);

    }
}

