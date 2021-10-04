package com.healthz.myhealthz.interfaces;

import com.healthz.myhealthz.responsepojo.DropDownListResponse;

import java.util.List;

public interface SpecTypeChckedListener {

    void onItemSpecCheck(int position, String specValue, List<DropDownListResponse.DataBean.SpecialzationBean> spectypedataBeanList);

    void onItemSpecUnCheck(int position, String specValue);

}