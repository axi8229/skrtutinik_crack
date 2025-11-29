package sputnik.axmor.com.sputnik.ui.call;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentReceivingCallBinding;

/* compiled from: ReceivingCallFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ReceivingCallFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentReceivingCallBinding> {
    public static final ReceivingCallFragment$binding$2 INSTANCE = new ReceivingCallFragment$binding$2();

    ReceivingCallFragment$binding$2() {
        super(1, FragmentReceivingCallBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentReceivingCallBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentReceivingCallBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentReceivingCallBinding.bind(p0);
    }
}
