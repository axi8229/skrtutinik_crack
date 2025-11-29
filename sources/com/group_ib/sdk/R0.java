package com.group_ib.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class R0 implements Handler.Callback {
    public volatile Handler a = null;
    public final HashMap b = new HashMap();
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();
    public int e = 0;

    public final R0 a(Looper looper) {
        if (looper != null) {
            this.b.clear();
            this.c.clear();
            this.d.clear();
            this.a = new Handler(looper, this);
        } else {
            this.a = null;
        }
        return this;
    }

    public final void b(int i, S0 s0) {
        Handler handler = this.a;
        if (handler == null) {
            c1.a("Dispatcher", "Empty Dispatcher accessed", new Exception());
            return;
        }
        if (Thread.currentThread() != handler.getLooper().getThread()) {
            handler.sendMessage(handler.obtainMessage(2, i, 0, s0));
            return;
        }
        if (this.e == i) {
            this.d.add(s0);
            this.c.remove(s0);
        } else {
            LinkedHashSet linkedHashSet = (LinkedHashSet) this.b.get(Integer.valueOf(i));
            if (linkedHashSet != null) {
                linkedHashSet.remove(s0);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            Object obj = message.obj;
            if (obj instanceof S0) {
                a(message.arg1, (S0) obj);
            }
        } else if (i == 2) {
            Object obj2 = message.obj;
            if (obj2 instanceof S0) {
                b(message.arg1, (S0) obj2);
            }
        } else if (i == 3) {
            a(message.arg1, message.obj);
        }
        return true;
    }

    public final void a(int i, S0 s0) {
        if (s0 == null) {
            return;
        }
        Handler handler = this.a;
        if (handler == null) {
            c1.a("Dispatcher", "Empty Dispatcher accessed", new Exception());
            return;
        }
        if (Thread.currentThread() != handler.getLooper().getThread()) {
            handler.sendMessage(handler.obtainMessage(1, i, 0, s0));
            return;
        }
        if (this.e == i) {
            this.c.add(s0);
            this.d.remove(s0);
            return;
        }
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.b.get(Integer.valueOf(i));
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            this.b.put(Integer.valueOf(i), linkedHashSet);
        }
        linkedHashSet.add(s0);
    }

    public final void a(int i, Object obj) {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        if (Thread.currentThread() != handler.getLooper().getThread()) {
            handler.sendMessage(handler.obtainMessage(3, i, 0, obj));
            return;
        }
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.b.get(Integer.valueOf(i));
        if (linkedHashSet == null) {
            return;
        }
        this.e = i;
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            try {
                ((S0) it.next()).a(i, obj);
            } catch (Exception e) {
                c1.a("Dispatcher", "Exception in " + handler.getLooper().getThread() + " thread", e);
            }
        }
        if (!this.c.isEmpty()) {
            linkedHashSet.addAll(this.c);
            this.c.clear();
        }
        if (!this.d.isEmpty()) {
            linkedHashSet.removeAll(this.d);
            this.d.clear();
        }
        this.e = 0;
    }
}
