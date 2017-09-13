package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.GetAddress;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 13:33
 */

public interface AddressModifyView extends BaseView{
    void onError(String result);
    void onSuccess(GetAddress getAddress);
    void onUpdateSuccess();
    void onDeleteSuccess();
}
