package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class E5 implements FlowCollector {
    public final /* synthetic */ I5 a;

    public E5(I5 i5) {
        this.a = i5;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        String str = (String) obj;
        I5 i5 = this.a;
        int i = I5.$r8$clinit;
        ViewBinding viewBinding = i5.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Km) viewBinding).d.setText(str);
        return Unit.INSTANCE;
    }
}
