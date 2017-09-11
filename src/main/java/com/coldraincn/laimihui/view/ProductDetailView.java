package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.ProductDetail;

/**
 * Created by hd on 2017/9/10.
 */

public interface ProductDetailView extends BaseView {
    void onSuccess(ProductDetail data);
    void onError(String result);
}
