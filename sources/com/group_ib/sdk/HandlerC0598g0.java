package com.group_ib.sdk;

import android.app.Activity;
import android.os.Message;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.group_ib.sdk.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class HandlerC0598g0 extends W0 implements V, S0 {
    public N b;
    public boolean c;
    public volatile boolean d;

    public HandlerC0598g0(MobileSdkService mobileSdkService) {
        super(mobileSdkService);
        this.b = new N();
        this.c = true;
        this.d = false;
    }

    @Override // com.group_ib.sdk.S0
    public final void a(int i, Object obj) {
        if (i == 3) {
            c1.a(4, 4, "ActivityProvider", "App WebView has notified to send data from SDK");
            N n = this.b;
            if (n.b != 0) {
                this.a.a(n);
                this.b = new N();
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 2048) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof L) {
            a((L) obj);
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        if (Thread.currentThread() == this.a.getMainLooper().getThread()) {
            C0588b0 c0588b0 = T.v;
            if (c0588b0 != null) {
                c0588b0.c = this;
                for (Map.Entry entry : c0588b0.a.entrySet()) {
                    Activity activity = (Activity) entry.getKey();
                    if (entry.getValue() == null) {
                        Window window = activity.getWindow();
                        Window.Callback callback = window.getCallback();
                        if (!(callback instanceof WindowCallbackC0627w)) {
                            WindowCallbackC0627w windowCallbackC0627w = new WindowCallbackC0627w(this, activity, callback);
                            window.setCallback(windowCallbackC0627w);
                            callback = windowCallbackC0627w;
                        }
                        entry.setValue((WindowCallbackC0627w) callback);
                        N0 n0 = c0588b0.b;
                        n0.getClass();
                        if (activity instanceof FragmentActivity) {
                            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(n0, true);
                        }
                    }
                }
                this.d = true;
                c1.a(4, 4, "ActivityProvider", "Activity monitoring started");
            }
            U0.b.a(3, (S0) this);
        }
    }

    public final void a(L l) {
        int i;
        if (l == null) {
            return;
        }
        if (Thread.currentThread() != this.a.getMainLooper().getThread()) {
            sendMessage(obtainMessage(2048, l));
            return;
        }
        N n = this.b;
        n.getClass();
        C c = l.b;
        LinkedHashMap linkedHashMap = (LinkedHashMap) n.a.get(c);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            n.a.put(c, linkedHashMap);
        }
        LinkedList linkedList = (LinkedList) linkedHashMap.get(l.a);
        if (linkedList == null) {
            linkedList = new LinkedList();
            linkedHashMap.put(l.a, linkedList);
        }
        linkedList.add(l);
        n.b++;
        boolean z = this.d;
        if (!this.c && ((i = AbstractC0590c0.a[l.a.ordinal()]) == 1 || i == 2 || i == 3 || i == 4)) {
            this.c = true;
        } else if (z && this.b.b < 10) {
            return;
        }
        N n2 = this.b;
        if (n2.b != 0) {
            this.a.a(n2);
            this.b = new N();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.group_ib.sdk.I r5) {
        /*
            r4 = this;
            com.group_ib.sdk.MobileSdkService r0 = r4.a
            java.util.LinkedHashMap r1 = r0.i
            monitor-enter(r1)
            java.util.LinkedHashMap r0 = r0.i     // Catch: java.lang.Throwable -> L25
            java.lang.String r2 = "MotionCollectionCapability"
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L25
            com.group_ib.sdk.d1 r0 = (com.group_ib.sdk.d1) r0     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L27
            com.group_ib.sdk.K r0 = (com.group_ib.sdk.K) r0     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto L27
            r2 = 2048(0x800, float:2.87E-42)
            android.os.Message r5 = r0.obtainMessage(r2, r5)     // Catch: java.lang.Throwable -> L25
            r2 = 50
            boolean r5 = r0.sendMessageDelayed(r5, r2)     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto L27
            r5 = 1
            goto L28
        L25:
            r5 = move-exception
            goto L2a
        L27:
            r5 = 0
        L28:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            return r5
        L2a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.HandlerC0598g0.a(com.group_ib.sdk.I):boolean");
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        if (Thread.currentThread() == this.a.getMainLooper().getThread()) {
            U0.b.b(3, this);
            C0588b0 c0588b0 = T.v;
            if (c0588b0 != null) {
                this.d = false;
                c0588b0.c = null;
                for (Map.Entry entry : c0588b0.a.entrySet()) {
                    Activity activity = (Activity) entry.getKey();
                    WindowCallbackC0627w windowCallbackC0627w = (WindowCallbackC0627w) c0588b0.a.get(activity);
                    if (windowCallbackC0627w != null) {
                        activity.getWindow().setCallback(windowCallbackC0627w.b);
                        N0 n0 = c0588b0.b;
                        n0.getClass();
                        if (activity instanceof FragmentActivity) {
                            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(n0);
                        }
                    }
                    entry.setValue(null);
                }
                N n = this.b;
                if (n.b != 0) {
                    this.a.a(n);
                    this.b = new N();
                }
                c1.a(4, 4, "ActivityProvider", "Activity monitoring stopped");
            }
        }
    }
}
