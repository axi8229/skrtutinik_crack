package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSurveyCloseBinding;

/* compiled from: SurveyFinishFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SurveyFinishFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSurveyCloseBinding> {
    public static final SurveyFinishFragment$binding$2 INSTANCE = new SurveyFinishFragment$binding$2();

    SurveyFinishFragment$binding$2() {
        super(1, FragmentSurveyCloseBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSurveyCloseBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSurveyCloseBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSurveyCloseBinding.bind(p0);
    }
}
