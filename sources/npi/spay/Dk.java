package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Dk {
    public final Function3 a;

    public Dk(Function3 viewBindingInflater) {
        Intrinsics.checkNotNullParameter(viewBindingInflater, "viewBindingInflater");
        this.a = viewBindingInflater;
    }

    public abstract Integer a(Object obj);

    public abstract void a(ViewBinding viewBinding, Object obj);

    public abstract boolean b(Object obj);
}
