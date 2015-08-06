package com.ticket.sminger.myticket.sourceBean;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.ticket.sminger.myticket.dataRequest.TicketInfoResult;
import com.ticket.sminger.myticket.netBeanLoader.baseNetBean.BaseNetBean;

/**
 * Created by sminger on 15-8-6.
 */
public class TicketBean extends BaseNetBean {

    @Override
    public String getUrl() {

        String url = HOST + getSuffix() + getBaseUrl() ;

        return url;
    }

    @Override
    public String getHttpMethod() {
        return HTTPGET;
    }

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public boolean parseJson(String json, boolean bLoadMore) {
        if(TextUtils.isEmpty(json)){
            return  false;
        }
        result = JSON.parseObject(json, TicketInfoResult.class) ;
        return true;
    }

    @Override
    public String getCachePath() {
        return null;
    }

    @Override
    public String getSuffix() {
        return "/allInfo.json";
    }

}
