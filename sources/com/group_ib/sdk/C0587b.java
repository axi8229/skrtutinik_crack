package com.group_ib.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.group_ib.sdk.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0587b extends View.AccessibilityDelegate {
    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        V v;
        D d;
        Activity activity;
        C0588b0 c0588b0 = T.v;
        if (c0588b0 != null && (v = c0588b0.c) != null) {
            int eventType = accessibilityEvent.getEventType();
            C0619s c0619s = null;
            if (eventType == 1) {
                d = D.accessibility_click;
            } else if (eventType == 2) {
                d = D.accessibility_long_click;
            } else if (eventType != 16) {
                if (eventType == 32) {
                    d = D.accessibility_window_state_changed;
                }
                ((HandlerC0598g0) v).a(c0619s);
            } else {
                d = D.accessibility_text_change;
            }
            Context context = view.getContext();
            char[] cArr = AbstractC0604j0.a;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity != null) {
                c0619s = new C0619s(d, new C(activity), accessibilityEvent);
            }
            ((HandlerC0598g0) v).a(c0619s);
        }
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
