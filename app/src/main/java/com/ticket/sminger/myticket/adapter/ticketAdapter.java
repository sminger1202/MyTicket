package com.ticket.sminger.myticket.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ticket.sminger.myticket.R;
import com.ticket.sminger.myticket.dataRequest.TicketInfoResult;
import com.ticket.sminger.myticket.dataRequest.TicketInfoResult.TicketInfo;
import com.ticket.sminger.myticket.fragment.TicketFragment;

import java.util.ArrayList;

/**
 * Created by shi.ming on 2015/7/31.
 */
public class ticketAdapter extends BaseAdapter {

    private TicketFragment mFragment;
    private Context mContext;
    private LayoutInflater mInflater;


    ArrayList<TicketInfo> mTicketList = new ArrayList<>();

    public ticketAdapter(Context context, TicketFragment fragment){
        mContext = context;
        mFragment = fragment;
        mInflater = LayoutInflater.from(mContext);
    }

    public void configData(TicketInfoResult ticketInfoResult) {
        mTicketList.addAll(ticketInfoResult.data);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mTicketList.size();
    }

    @Override
    public Object getItem(int i) {

        return mTicketList.get(i);

    }

    @Override
    public long getItemId(int i) {

        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ticketHolder holder;
        if (view == null) {
            view = mInflater.inflate(R.layout.ticket_item, viewGroup, false);
            holder = new ticketHolder();
            initViewHolder(holder, view);
            view.setTag(holder);

        } else {
            holder = (ticketHolder)view.getTag();
        }
        initViewData(holder, i);
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    public class ticketHolder {
        ImageView mImageView;
        TextView mTitle;
        TextView mTime;
    }

    public void initViewHolder(ticketHolder holder, View view) {
        holder.mImageView = (ImageView) view.findViewById(R.id.ticket_img);
        holder.mTitle = (TextView)view.findViewById(R.id.ticket_title);
        holder.mTime = (TextView) view.findViewById(R.id.ticket_time);
    }

    public void initViewData(ticketHolder holder, int position) {
        mFragment.mImageLoader.displayImage(mTicketList.get(position).headPic, holder.mImageView);
        holder.mTitle.setText(mTicketList.get(position).title);
        holder.mTime.setText(mTicketList.get(position).time);
    }
}
