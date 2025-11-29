package com.group_ib.sdk;

import android.hardware.display.DisplayManager;
import android.view.Display;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class I0 implements DisplayManager.DisplayListener {
    public final /* synthetic */ L0 a;

    public I0(L0 l0) {
        this.a = l0;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) throws JSONException {
        this.a.a(true, J0.a(this.a.c.getDisplay(i)));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) throws JSONException {
        Display display = this.a.c.getDisplay(i);
        if (display == null || display.getState() != 1) {
            return;
        }
        L0 l0 = this.a;
        l0.a(false, (J0) l0.d.get(Integer.valueOf(i)));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) throws JSONException {
        L0 l0 = this.a;
        l0.a(false, (J0) l0.d.get(Integer.valueOf(i)));
    }
}
