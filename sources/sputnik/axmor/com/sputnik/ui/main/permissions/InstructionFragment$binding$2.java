package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentInstructionBinding;

/* compiled from: InstructionFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class InstructionFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentInstructionBinding> {
    public static final InstructionFragment$binding$2 INSTANCE = new InstructionFragment$binding$2();

    InstructionFragment$binding$2() {
        super(1, FragmentInstructionBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentInstructionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentInstructionBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentInstructionBinding.bind(p0);
    }
}
