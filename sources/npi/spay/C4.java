package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.RedirectActivity;

/* loaded from: classes4.dex */
public final class C4 implements FlowCollector {
    public final /* synthetic */ RedirectActivity a;

    public C4(RedirectActivity redirectActivity) {
        this.a = redirectActivity;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new C2055y3(this.a));
        return Unit.INSTANCE;
    }
}
