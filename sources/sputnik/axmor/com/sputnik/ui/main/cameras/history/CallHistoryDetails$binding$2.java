package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentVisitDetailsBinding;

/* compiled from: CallHistoryDetails.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CallHistoryDetails$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentVisitDetailsBinding> {
    public static final CallHistoryDetails$binding$2 INSTANCE = new CallHistoryDetails$binding$2();

    CallHistoryDetails$binding$2() {
        super(1, FragmentVisitDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentVisitDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentVisitDetailsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentVisitDetailsBinding.bind(p0);
    }
}
