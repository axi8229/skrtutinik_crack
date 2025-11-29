package npi.spay;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.q7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1860q7 extends FunctionReferenceImpl implements Function3 {
    public static final C1860q7 a = new C1860q7();

    public C1860q7() {
        super(3, D2.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lspay/sdk/databinding/SpayRvItemCardSelectionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LayoutInflater p0 = (LayoutInflater) obj;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        Intrinsics.checkNotNullParameter(p0, "p0");
        return D2.a(p0, (ViewGroup) obj2, zBooleanValue);
    }
}
