package bz;

import android.content.Context;
import android.util.DisplayMetrics;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class A extends AbstractC0538n1 {
    public final Context c;

    public A(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.ScreenSize);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        return "" + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
}
