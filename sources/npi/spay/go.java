package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class go implements FlowCollector {
    public final /* synthetic */ mo a;

    public go(mo moVar) {
        this.a = moVar;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        int iIntValue = ((Number) obj).intValue();
        mo moVar = this.a;
        int i = mo.$r8$clinit;
        ViewBinding viewBinding = moVar.e;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatImageView appCompatImageView = ((Dd) viewBinding).b;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.sbssAcivBackground");
        AbstractC1923sl.a(appCompatImageView, iIntValue);
        return Unit.INSTANCE;
    }
}
