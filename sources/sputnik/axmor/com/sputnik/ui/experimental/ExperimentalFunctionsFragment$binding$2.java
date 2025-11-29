package sputnik.axmor.com.sputnik.ui.experimental;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentExperimentalBinding;

/* compiled from: ExperimentalFunctionsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ExperimentalFunctionsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentExperimentalBinding> {
    public static final ExperimentalFunctionsFragment$binding$2 INSTANCE = new ExperimentalFunctionsFragment$binding$2();

    ExperimentalFunctionsFragment$binding$2() {
        super(1, FragmentExperimentalBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentExperimentalBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentExperimentalBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentExperimentalBinding.bind(p0);
    }
}
