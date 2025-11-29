package com.group_ib.sdk;

import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.group_ib.sdk.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0619s extends L {
    public C0619s(D d, C c, AccessibilityEvent accessibilityEvent) throws JSONException {
        List<CharSequence> text;
        CharSequence charSequence;
        super(d, c);
        try {
            CharSequence className = accessibilityEvent.getClassName();
            this.c.put("t", System.currentTimeMillis()).put("class", className);
            if (accessibilityEvent.getEventType() == 32) {
                this.c.put("activity_state", W.a(T.c()).toLowerCase());
            }
            if (className == null || "android.widget.EditText".equalsIgnoreCase(className.toString()) || (text = accessibilityEvent.getText()) == null || text.size() != 1 || (charSequence = text.get(0)) == null || charSequence.length() == 0) {
                return;
            }
            this.c.put("text", charSequence.toString());
        } catch (Exception unused) {
        }
    }
}
