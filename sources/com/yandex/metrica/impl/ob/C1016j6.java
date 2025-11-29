package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.google.protobuf.nano.ym.MessageNano;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.j6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1016j6 {
    private final String a;
    private final C0942g6 b;
    private final C0992i6 c;
    private final R7 d;

    public C1016j6(Context context, I3 i3) {
        i3.a();
        this.a = "session_extras";
        this.b = new C0942g6();
        this.c = new C0992i6();
        R7 r7A = C1020ja.a(context).a(i3);
        Intrinsics.checkNotNullExpressionValue(r7A, "DatabaseStorageFactory.g…Id\") !no-logs*/\n        }");
        this.d = r7A;
    }

    public final Map<String, byte[]> a() {
        try {
            byte[] bArrA = this.d.a(this.a);
            if (bArrA != null) {
                if (!(bArrA.length == 0)) {
                    C0942g6 c0942g6 = this.b;
                    this.c.getClass();
                    Gf gf = (Gf) MessageNano.mergeFrom(new Gf(), bArrA);
                    Intrinsics.checkNotNullExpressionValue(gf, "SessionExtrasProtobuf.Se…ionExtras.parseFrom(data)");
                    return c0942g6.toModel(gf);
                }
            }
        } catch (Throwable unused) {
        }
        C0942g6 c0942g62 = this.b;
        this.c.getClass();
        return c0942g62.toModel(new Gf());
    }

    public final void a(Map<String, byte[]> map) {
        R7 r7 = this.d;
        String str = this.a;
        C0992i6 c0992i6 = this.c;
        Gf gfFromModel = this.b.fromModel(map);
        c0992i6.getClass();
        r7.a(str, MessageNano.toByteArray(gfFromModel));
    }
}
