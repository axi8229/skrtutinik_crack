package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.r2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1879r2 implements FlowCollector {
    public final /* synthetic */ RedirectActivity a;

    public C1879r2(RedirectActivity redirectActivity) {
        this.a = redirectActivity;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new L0(this.a));
        return Unit.INSTANCE;
    }
}
