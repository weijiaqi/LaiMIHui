package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.AddressList;
import com.coldraincn.laimihui.entity.ProductDetail;

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

public interface AddressView extends BaseView{
    void onSuccess(AddressList data);
    void onError(String result);
}
