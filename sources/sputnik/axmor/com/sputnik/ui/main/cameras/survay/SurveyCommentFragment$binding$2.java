package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentCommentSurveyBinding;

/* compiled from: SurveyCommentFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SurveyCommentFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentCommentSurveyBinding> {
    public static final SurveyCommentFragment$binding$2 INSTANCE = new SurveyCommentFragment$binding$2();

    SurveyCommentFragment$binding$2() {
        super(1, FragmentCommentSurveyBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentCommentSurveyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentCommentSurveyBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentCommentSurveyBinding.bind(p0);
    }
}
