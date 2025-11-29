package bz;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;

/* loaded from: classes.dex */
public final class F1 extends AbstractC0538n1 {
    public static final String d = AbstractC0569y0.a(new byte[]{6, -26, -8, -1, -93, 21, -32, 40, -95, 84, -4, -68, -120, -99, -83, -24});
    public static final String e = AbstractC0569y0.a(new byte[]{78, 114, 123, 125, 80, -73, -73, -3, 32, 73, -15, 66, -87, -102, 11, -9});
    public static final String f = AbstractC0569y0.a(new byte[]{-77, 86, -116, 124, 95, -28, -38, 31, 38, -28, -70, 38, 83, 89, -40, 83});
    public static final String g = AbstractC0569y0.a(new byte[]{-125, -98, -31, 124, 102, 55, -128, -35, 49, ByteSourceJsonBootstrapper.UTF8_BOM_3, ByteSourceJsonBootstrapper.UTF8_BOM_2, 102, 34, 100, 67, 99});
    public final Context c;

    public F1(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.RdpConnection);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final String h() throws e2 {
        DisplayManager displayManager = (DisplayManager) this.c.getSystemService("display");
        if (displayManager == null) {
            throw new e2(AbstractC0569y0.a(new byte[]{19, 17, -80, 43, -40, 119, 107, -54, 67, 80, -64, -34, 119, -76, -35, 114}));
        }
        for (Display display : displayManager.getDisplays()) {
            int flags = display.getFlags();
            String strValueOf = String.valueOf(display);
            boolean zContains = strValueOf.contains(d);
            boolean zContains2 = strValueOf.contains(e);
            if (flags == 8 || zContains || zContains2) {
                return f;
            }
        }
        return g;
    }
}
