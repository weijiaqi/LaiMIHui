package com.coldraincn.laimihui.widget.addressselector;

import java.util.List;

/**
 */

public interface DataProvider {
    void provideData(int currentDeep, int preId, DataReceiver receiver);


    interface DataReceiver {
        void send(List<ISelectAble> data);
    }
}
