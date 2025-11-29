package sputnik.axmor.com.sputnik.ui.nointercom;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentNewAdressBinding;

/* compiled from: SettingsAddress.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SettingsAddress$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNewAdressBinding> {
    public static final SettingsAddress$binding$2 INSTANCE = new SettingsAddress$binding$2();

    SettingsAddress$binding$2() {
        super(1, FragmentNewAdressBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentNewAdressBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNewAdressBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNewAdressBinding.bind(p0);
    }
}
