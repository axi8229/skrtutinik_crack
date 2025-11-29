package com.yandex.metrica.impl.ob;

import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1135o0 {
    private boolean a;
    private DeferredDeeplinkListener b;
    private DeferredDeeplinkParametersListener c;
    private C1110n0 d;

    /* renamed from: com.yandex.metrica.impl.ob.o0$a */
    enum a {
        NOT_A_FIRST_LAUNCH,
        PARSE_ERROR,
        NO_REFERRER
    }

    public C1135o0(boolean z) {
        this.a = z;
    }

    public void a(C1110n0 c1110n0) {
        this.d = c1110n0;
        a();
    }

    private void a(a aVar) {
        DeferredDeeplinkListener.Error error;
        C1110n0 c1110n0 = this.d;
        String str = c1110n0 == null ? null : c1110n0.c;
        DeferredDeeplinkListener deferredDeeplinkListener = this.b;
        if (deferredDeeplinkListener != null) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                error = DeferredDeeplinkListener.Error.NOT_A_FIRST_LAUNCH;
            } else if (iOrdinal == 1) {
                error = DeferredDeeplinkListener.Error.PARSE_ERROR;
            } else if (iOrdinal != 2) {
                error = DeferredDeeplinkListener.Error.UNKNOWN;
            } else {
                error = DeferredDeeplinkListener.Error.NO_REFERRER;
            }
            deferredDeeplinkListener.onError(error, str == null ? "" : str);
            this.b = null;
        }
        a(aVar, str);
    }

    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.c = deferredDeeplinkParametersListener;
        if (this.a) {
            a(a.NOT_A_FIRST_LAUNCH);
        } else {
            a();
        }
    }

    public void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = deferredDeeplinkListener;
        if (this.a) {
            a(a.NOT_A_FIRST_LAUNCH);
        } else {
            a();
        }
    }

    private void a() {
        C1110n0 c1110n0 = this.d;
        if (c1110n0 != null) {
            String str = c1110n0.b;
            if (str != null) {
                DeferredDeeplinkListener deferredDeeplinkListener = this.b;
                if (deferredDeeplinkListener != null) {
                    deferredDeeplinkListener.onDeeplinkLoaded(str);
                    this.b = null;
                }
                if (!A2.b(this.d.a)) {
                    Map<String, String> map = this.d.a;
                    DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.c;
                    if (deferredDeeplinkParametersListener != null) {
                        deferredDeeplinkParametersListener.onParametersLoaded(map);
                        this.c = null;
                        return;
                    }
                    return;
                }
                a(a.PARSE_ERROR, this.d.c);
                return;
            }
            if (c1110n0.c != null) {
                a(a.PARSE_ERROR);
            } else {
                a(a.NO_REFERRER);
            }
        }
    }

    private void a(a aVar, String str) {
        DeferredDeeplinkParametersListener.Error error;
        DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.c;
        if (deferredDeeplinkParametersListener != null) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                error = DeferredDeeplinkParametersListener.Error.NOT_A_FIRST_LAUNCH;
            } else if (iOrdinal == 1) {
                error = DeferredDeeplinkParametersListener.Error.PARSE_ERROR;
            } else if (iOrdinal != 2) {
                error = DeferredDeeplinkParametersListener.Error.UNKNOWN;
            } else {
                error = DeferredDeeplinkParametersListener.Error.NO_REFERRER;
            }
            if (str == null) {
                str = "";
            }
            deferredDeeplinkParametersListener.onError(error, str);
            this.c = null;
        }
    }
}
