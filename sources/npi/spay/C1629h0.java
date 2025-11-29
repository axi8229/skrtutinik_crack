package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.h0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1629h0 implements FlowCollector {
    public final /* synthetic */ RedirectActivity a;

    public C1629h0(RedirectActivity redirectActivity) {
        this.a = redirectActivity;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new C1851pn(this.a));
        return Unit.INSTANCE;
    }
}
