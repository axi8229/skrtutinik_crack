package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Kg extends IllegalStateException {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kg(String field) {
        super("Required field is null at the response ".concat(field));
        Intrinsics.checkNotNullParameter(field, "field");
        this.a = field;
    }
}
