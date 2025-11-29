package npi.spay;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.MatchResult;

/* renamed from: npi.spay.sj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1921sj extends Lambda implements Function1 {
    public final /* synthetic */ Ref$ObjectRef a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1921sj(Ref$ObjectRef ref$ObjectRef) {
        super(1);
        this.a = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, npi.spay.B4] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MatchResult it = (MatchResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Ref$ObjectRef ref$ObjectRef = this.a;
        B4 b4 = (B4) ref$ObjectRef.element;
        List mutableList = CollectionsKt.toMutableList((Collection) b4.b);
        mutableList.add(it.getValue());
        Unit unit = Unit.INSTANCE;
        ref$ObjectRef.element = B4.a(b4, null, mutableList, null, 5);
        return "";
    }
}
