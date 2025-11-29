package com.group_ib.sdk;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0606k0 extends L implements I {
    public final V d;
    public final C0600h0[] e;
    public final JSONArray f;
    public boolean g;
    public HashSet h;
    public long i;

    public C0606k0(V v, U u) {
        super(D.swipe, u);
        this.e = new C0600h0[10];
        this.f = new JSONArray();
        this.g = false;
        this.h = null;
        this.i = 0L;
        this.d = v;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.group_ib.sdk.B a(com.group_ib.sdk.l1 r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L3f
            android.hardware.Sensor r1 = r4.b
            int r1 = r1.getType()
            r2 = 4
            if (r1 == r2) goto L1d
            r2 = 9
            if (r1 == r2) goto L15
            r2 = 10
            if (r1 == r2) goto L1d
            goto L2a
        L15:
            com.group_ib.sdk.v r0 = new com.group_ib.sdk.v
            long r1 = r3.i
            r0.<init>(r1)
            goto L2a
        L1d:
            com.group_ib.sdk.r r0 = new com.group_ib.sdk.r
            android.hardware.Sensor r4 = r4.b
            int r4 = r4.getType()
            long r1 = r3.i
            r0.<init>(r4, r1)
        L2a:
            if (r0 == 0) goto L3f
            java.util.HashSet r4 = r3.h
            if (r4 != 0) goto L37
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r3.h = r4
        L37:
            r4 = 1
            r0.a = r4
            java.util.HashSet r4 = r3.h
            r4.add(r0)
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0606k0.a(com.group_ib.sdk.l1):com.group_ib.sdk.B");
    }

    public final void a(MotionEvent motionEvent) {
        C0600h0 c0600h0;
        C0600h0 c0600h02;
        try {
            int actionMasked = motionEvent.getActionMasked();
            int i = 0;
            if (actionMasked == 0) {
                Arrays.fill(this.e, (Object) null);
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                C0600h0[] c0600h0Arr = this.e;
                if (pointerId < c0600h0Arr.length) {
                    c0600h0Arr[pointerId] = new C0600h0(actionIndex, motionEvent);
                }
                this.i = SystemClock.elapsedRealtimeNanos() - ((SystemClock.uptimeMillis() - (motionEvent.getEventTime() - 50)) * 1000000);
                MobileSdkService mobileSdkService = ((HandlerC0598g0) this.d).a;
                synchronized (mobileSdkService.i) {
                    try {
                        d1 d1Var = (d1) mobileSdkService.i.get("MotionCollectionCapability");
                        if (d1Var != null && ((K) d1Var).a(this)) {
                            i = 1;
                        }
                    } finally {
                    }
                }
                if (i == 0) {
                    this.i = 0L;
                    return;
                }
                return;
            }
            if (actionMasked == 1) {
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                C0600h0[] c0600h0Arr2 = this.e;
                if (pointerId2 < c0600h0Arr2.length) {
                    C0600h0 c0600h03 = c0600h0Arr2[pointerId2];
                    if (c0600h03 != null) {
                        c0600h03.a(actionIndex2, motionEvent);
                        this.f.put(c0600h03.a);
                    }
                    this.g = true;
                }
                if (this.i == 0 || !((HandlerC0598g0) this.d).a((I) this)) {
                    ((HandlerC0598g0) this.d).a((L) this);
                    return;
                }
                return;
            }
            if (actionMasked == 5) {
                int actionIndex3 = motionEvent.getActionIndex();
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                C0600h0[] c0600h0Arr3 = this.e;
                if (pointerId3 < c0600h0Arr3.length) {
                    c0600h0Arr3[pointerId3] = new C0600h0(actionIndex3, motionEvent);
                    return;
                }
                return;
            }
            if (actionMasked == 6) {
                int actionIndex4 = motionEvent.getActionIndex();
                int pointerId4 = motionEvent.getPointerId(actionIndex4);
                C0600h0[] c0600h0Arr4 = this.e;
                if (pointerId4 >= c0600h0Arr4.length || (c0600h02 = c0600h0Arr4[pointerId4]) == null) {
                    return;
                }
                c0600h02.a(actionIndex4, motionEvent);
                this.f.put(c0600h02.a);
                this.e[pointerId4] = null;
                return;
            }
            if (actionMasked == 2) {
                int pointerCount = motionEvent.getPointerCount();
                while (i < pointerCount) {
                    int pointerId5 = motionEvent.getPointerId(i);
                    C0600h0[] c0600h0Arr5 = this.e;
                    if (pointerId5 < c0600h0Arr5.length && (c0600h0 = c0600h0Arr5[pointerId5]) != null) {
                        c0600h0.a(i, motionEvent);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            c1.a("ActivitySwipe", "failed to add motion event", e);
        }
    }

    @Override // com.group_ib.sdk.L
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("type", this.a.name()).put(RemoteMessageConst.DATA, this.f);
        if (jSONObjectPut != null && this.h != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                B b = (B) ((k1) it.next());
                b.getClass();
                JSONArray jSONArray2 = new JSONArray();
                for (A a : b.g) {
                    jSONArray2.put(a.a());
                }
                jSONArray.put(new JSONObject().put("type", b.f).put("num", b.b).put("mean_delay", b.e).put(RemoteMessageConst.DATA, jSONArray2));
            }
            jSONObjectPut.put("sensors", jSONArray);
        }
        return jSONObjectPut;
    }
}
