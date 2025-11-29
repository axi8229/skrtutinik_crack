package sputnik.axmor.com.sputnik.ui.alerts;

import android.view.View;
import com.sputnik.common.databinding.FragmentUpdateRequiredBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentUpdateRequired.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class FragmentUpdateRequired$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentUpdateRequiredBinding> {
    public static final FragmentUpdateRequired$binding$2 INSTANCE = new FragmentUpdateRequired$binding$2();

    FragmentUpdateRequired$binding$2() {
        super(1, FragmentUpdateRequiredBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/common/databinding/FragmentUpdateRequiredBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentUpdateRequiredBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentUpdateRequiredBinding.bind(p0);
    }
}
