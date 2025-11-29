package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import timber.log.Timber;

/* renamed from: npi.spay.z4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2081z4 extends Lk implements InterfaceC1738la {
    public final InterfaceC1495bg d;
    public final Ei e;
    public final Hk f;
    public final C2014wc g;
    public final C1898rl h;
    public CountDownTimerC1537d8 i;
    public final MutableStateFlow j;
    public final long k;
    public final MutableStateFlow l;
    public final StateFlow m;
    public final C2006w4 n;
    public final C1981v4 o;
    public final String p;
    public final StateFlow q;
    public final MutableStateFlow r;
    public final StateFlow s;
    public final MutableStateFlow t;
    public final StateFlow u;
    public final MutableStateFlow v;
    public final StateFlow w;
    public final StateFlow x;
    public final StateFlow y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2081z4(npi.spay.C1955u3 r24, npi.spay.Ih r25, npi.spay.InterfaceC1495bg r26, npi.spay.Ei r27, npi.spay.Hk r28, npi.spay.C2014wc r29, npi.spay.C1898rl r30) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2081z4.<init>(npi.spay.u3, npi.spay.Ih, npi.spay.bg, npi.spay.Ei, npi.spay.Hk, npi.spay.wc, npi.spay.rl):void");
    }

    @Override // npi.spay.AbstractC1819og
    public final void a(AbstractC1794ng viewState) {
        CountDownTimerC1537d8 countDownTimerC1537d8;
        Intrinsics.checkNotNullParameter(viewState, "event");
        super.a(viewState);
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        if (!Intrinsics.areEqual(viewState, C1744lg.a)) {
            if (!Intrinsics.areEqual(viewState, C1669ig.a) || (countDownTimerC1537d8 = this.i) == null) {
                return;
            }
            countDownTimerC1537d8.cancel();
            return;
        }
        long j = this.k;
        this.j.setValue(Long.valueOf(((Number) this.j.getValue()).longValue()));
        CountDownTimerC1537d8 countDownTimerC1537d82 = new CountDownTimerC1537d8(((Number) this.j.getValue()).longValue(), j, new B8(this), new C2086z9(this));
        this.i = countDownTimerC1537d82;
        countDownTimerC1537d82.start();
        CountDownTimerC1537d8 countDownTimerC1537d83 = this.i;
        if (countDownTimerC1537d83 != null) {
            countDownTimerC1537d83.start();
        }
    }

    public final void c() {
        Timber.INSTANCE.i("ConfirmCode accepted", new Object[0]);
        ((Jh) this.d).a(new C2050xn(C1825om.a, false));
    }

    public final MutableStateFlow d() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(npi.spay.AbstractC1801nn r18) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2081z4.a(npi.spay.nn):void");
    }
}
