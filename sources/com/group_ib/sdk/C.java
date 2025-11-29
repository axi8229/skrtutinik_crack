package com.group_ib.sdk;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class C {
    public int a;
    public final String b;
    public final LinkedList c = new LinkedList();

    public C(Activity activity) {
        String localClassName = activity.getLocalClassName();
        this.b = localClassName;
        this.a = localClassName.hashCode();
    }

    public final JSONArray a() throws JSONException {
        if (this.c.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 3;
            int i2 = 3;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                InterfaceC0629x interfaceC0629x = (InterfaceC0629x) this.c.get(size);
                if (i <= 0 || !(interfaceC0629x instanceof C0631y)) {
                    jSONArray.put(size, interfaceC0629x.a(0));
                } else {
                    jSONArray.put(size, interfaceC0629x.a(i2));
                    i--;
                    if ((i2 & 2) != 0) {
                        i2 = 1;
                    }
                }
            }
        } catch (Exception unused) {
            c1.a(1, 1, "ActivityElement", "Failed to get view hierarchy");
        }
        return jSONArray;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        C c = (C) obj;
        if (c.c.size() != this.c.size() || !c.b.equals(this.b)) {
            return false;
        }
        Iterator itDescendingIterator = this.c.descendingIterator();
        Iterator itDescendingIterator2 = c.c.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            if (!((InterfaceC0629x) itDescendingIterator.next()).equals(itDescendingIterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final void a(Activity activity, MotionEvent motionEvent, HashMap map) {
        InterfaceC0629x interfaceC0629x;
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                a((ViewGroup) decorView, motionEvent.getX(), motionEvent.getY(), linkedList, linkedList2);
                if (linkedList.size() == 0) {
                    linkedList = linkedList2;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C0631y c0631y = (C0631y) it.next();
                    if (map != null && (interfaceC0629x = (InterfaceC0629x) map.get(c0631y.a)) != null) {
                        interfaceC0629x.a();
                        this.c.add(interfaceC0629x);
                        this.a = interfaceC0629x.b() + this.a;
                    }
                    c0631y.a();
                    this.c.add(c0631y);
                    this.a = c0631y.b() + this.a;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.view.ViewGroup r8, float r9, float r10, java.util.LinkedList r11, java.util.LinkedList r12) {
        /*
            int r0 = r8.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
        L8:
            if (r0 < 0) goto L76
            android.view.View r4 = r8.getChildAt(r0)
            r5 = 2
            int[] r5 = new int[r5]
            r4.getLocationOnScreen(r5)
            boolean r6 = r4.isShown()
            if (r6 == 0) goto L73
            r6 = r5[r2]
            float r7 = (float) r6
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 > 0) goto L73
            int r7 = r4.getWidth()
            int r7 = r7 + r6
            float r6 = (float) r7
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 >= 0) goto L73
            r6 = r5[r1]
            float r7 = (float) r6
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 > 0) goto L73
            int r7 = r4.getHeight()
            int r7 = r7 + r6
            float r6 = (float) r7
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 >= 0) goto L73
            boolean r6 = r4 instanceof android.view.ViewGroup
            if (r6 == 0) goto L59
            r6 = r4
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            boolean r6 = a(r6, r9, r10, r11, r12)
            if (r6 != 0) goto L4f
            boolean r6 = r4.isClickable()
            if (r6 == 0) goto L65
        L4f:
            com.group_ib.sdk.y r3 = new com.group_ib.sdk.y
            r3.<init>(r4, r5, r0)
        L54:
            r11.addFirst(r3)
            r3 = r1
            goto L65
        L59:
            boolean r6 = r4.isClickable()
            if (r6 == 0) goto L65
            com.group_ib.sdk.y r3 = new com.group_ib.sdk.y
            r3.<init>(r4, r5, r0)
            goto L54
        L65:
            if (r12 == 0) goto L70
            com.group_ib.sdk.y r6 = new com.group_ib.sdk.y
            r6.<init>(r4, r5, r0)
            r12.addFirst(r6)
            r12 = 0
        L70:
            if (r3 == 0) goto L73
            return r1
        L73:
            int r0 = r0 + (-1)
            goto L8
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C.a(android.view.ViewGroup, float, float, java.util.LinkedList, java.util.LinkedList):boolean");
    }

    public final void a(O o) {
        o.a();
        this.c.addFirst(o);
        this.a = o.b() + this.a;
    }
}
