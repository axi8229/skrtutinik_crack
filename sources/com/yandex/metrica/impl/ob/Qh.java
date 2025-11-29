package com.yandex.metrica.impl.ob;

import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IParamsCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class Qh implements Yh {
    private static final IIdentifierCallback b = new a();
    private final AtomicReference<IIdentifierCallback> a;

    class a implements IIdentifierCallback {
        a() {
        }

        @Override // com.yandex.metrica.IIdentifierCallback
        public void onReceive(Map<String, String> map) {
        }

        @Override // com.yandex.metrica.IIdentifierCallback
        public void onRequestError(IIdentifierCallback.Reason reason) {
        }
    }

    public Qh(IIdentifierCallback iIdentifierCallback) {
        this.a = new AtomicReference<>(iIdentifierCallback);
    }

    @Override // com.yandex.metrica.impl.ob.Yh
    public void a(IParamsCallback.Reason reason, Map<String, W0> map) {
        IIdentifierCallback andSet = this.a.getAndSet(b);
        int iOrdinal = reason.ordinal();
        andSet.onRequestError(iOrdinal != 1 ? iOrdinal != 2 ? IIdentifierCallback.Reason.UNKNOWN : IIdentifierCallback.Reason.INVALID_RESPONSE : IIdentifierCallback.Reason.NETWORK);
    }

    @Override // com.yandex.metrica.impl.ob.Yh
    public void onReceive(Map<String, W0> map) {
        IIdentifierCallback andSet = this.a.getAndSet(b);
        HashMap map2 = new HashMap();
        for (Map.Entry<String, W0> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue().a);
        }
        andSet.onReceive(map2);
    }
}
