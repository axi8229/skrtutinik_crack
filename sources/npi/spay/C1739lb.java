package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.lb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1739lb implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public C1739lb(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        ViewBinding viewBinding = c1888rb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Ed) viewBinding).h.setChecked(zBooleanValue);
        return Unit.INSTANCE;
    }
}
