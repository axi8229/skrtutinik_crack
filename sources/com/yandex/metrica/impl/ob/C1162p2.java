package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Ui;
import com.yandex.metrica.networktasks.api.NetworkResponseHandler;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import java.util.List;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.p2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1162p2 implements NetworkResponseHandler {
    private final Ti a;
    private final C1312v9 b;

    public C1162p2() {
        this(new Ti(), new C1312v9());
    }

    @Override // com.yandex.metrica.networktasks.api.NetworkResponseHandler
    public Object handle(ResponseDataHolder responseDataHolder) {
        if (200 != responseDataHolder.getResponseCode()) {
            return null;
        }
        byte[] responseData = responseDataHolder.getResponseData();
        Map responseHeaders = responseDataHolder.getResponseHeaders();
        List list = responseHeaders != null ? (List) responseHeaders.get("Content-Encoding") : null;
        if (!A2.b(list) && "encrypted".equals(list.get(0))) {
            responseData = this.b.a(responseDataHolder.getResponseData(), "hBnBQbZrmjPXEWVJ");
        }
        if (responseData == null) {
            return null;
        }
        Ui uiA = this.a.a(responseData);
        if (Ui.a.OK == uiA.A()) {
            return uiA;
        }
        return null;
    }

    C1162p2(Ti ti, C1312v9 c1312v9) {
        this.a = ti;
        this.b = c1312v9;
    }
}
