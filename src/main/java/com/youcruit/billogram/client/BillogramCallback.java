package com.youcruit.billogram.client;

import java.io.IOException;

public interface BillogramCallback<V> {
    void onSuccess(V response);
    void onError(IOException cause);
}
