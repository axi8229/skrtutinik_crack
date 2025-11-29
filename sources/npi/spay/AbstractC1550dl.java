package npi.spay;

import android.content.Context;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.dl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1550dl {
    public static final String a(Bk bk, Context context) {
        String string;
        Intrinsics.checkNotNullParameter(bk, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (bk instanceof Ak) {
            return ((Ak) bk).a.toString();
        }
        if (!(bk instanceof C2097zk)) {
            throw new NoWhenBranchMatchedException();
        }
        C2097zk c2097zk = (C2097zk) bk;
        if (c2097zk.b.isEmpty()) {
            string = context.getString(c2097zk.a);
        } else {
            int size = c2097zk.b.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                Object objA = c2097zk.b.get(i);
                if (objA instanceof Bk) {
                    objA = a((Bk) objA, context);
                }
                objArr[i] = objA;
            }
            string = context.getString(c2097zk.a, Arrays.copyOf(objArr, size));
        }
        Intrinsics.checkNotNullExpressionValue(string, "{\n        if (args.isEmp…d, *args)\n        }\n    }");
        return string;
    }

    public static final C2097zk a(int i, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return new C2097zk(i, ArraysKt.toList(args));
    }
}
