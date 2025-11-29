package bz;

import android.content.Context;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okio.Utf8;

/* loaded from: classes.dex */
public final class X0 implements U0 {
    public static final String d = AbstractC0569y0.a(new byte[]{-128, -76, -74, -81, -121, -101, -40, -64, 22, -27, 5, -114, 80, 65, -68, -5});
    public static final Map e;
    public final HashMap a = new HashMap(4);
    public final Context b;
    public final InterfaceC0502c c;

    static {
        HashMap map = new HashMap(4);
        map.put(0, AbstractC0569y0.a(new byte[]{40, 75, -54, 93, 80, -46, -51, -36, 41, -42, 98, -83, 39, 44, -19, -67}));
        map.put(1, AbstractC0569y0.a(new byte[]{57, 10, 116, -128, -64, -5, -51, 84, 85, 97, 80, 82, 107, -94, -4, 30}));
        map.put(2, AbstractC0569y0.a(new byte[]{-111, 123, -81, 102, -119, 48, 28, 37, -90, -38, 124, 92, 14, -24, 6, -25}));
        map.put(3, AbstractC0569y0.a(new byte[]{-95, -104, 89, 89, -53, -88, -28, 119, 14, 75, -91, 93, 57, -117, -64, 68}));
        e = Collections.unmodifiableMap(map);
    }

    public X0(Context context, C0556u c0556u) {
        this.b = context;
        this.c = c0556u;
    }

    public final Set a(int i) throws IOException {
        Set hashSet = (Set) this.a.get(Integer.valueOf(i));
        if (hashSet == null) {
            InterfaceC0502c interfaceC0502c = this.c;
            Context context = this.b;
            String str = (String) e.get(Integer.valueOf(i));
            if (str == null) {
                throw new zone.bi.mobile.fingerprint.api.a(AbstractC0569y0.a(new byte[]{53, 118, 41, -114, -119, -103, 107, 8, -1, 89, 124, 50, -84, Utf8.REPLACEMENT_BYTE, 114, -88, 68, 74, -39, -61, 96, 125, 66, -110, -12, -63, -64, 86, 72, 118, 3, -127}) + i);
            }
            String strA = ((C0556u) interfaceC0502c).a(context, str);
            hashSet = strA != null ? new HashSet(Arrays.asList(strA.split(d))) : Collections.emptySet();
            this.a.put(Integer.valueOf(i), hashSet);
        }
        return hashSet;
    }
}
