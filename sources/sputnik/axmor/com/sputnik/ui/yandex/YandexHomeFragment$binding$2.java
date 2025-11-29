package sputnik.axmor.com.sputnik.ui.yandex;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentYandexHomeBinding;

/* compiled from: YandexHomeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class YandexHomeFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentYandexHomeBinding> {
    public static final YandexHomeFragment$binding$2 INSTANCE = new YandexHomeFragment$binding$2();

    YandexHomeFragment$binding$2() {
        super(1, FragmentYandexHomeBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentYandexHomeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentYandexHomeBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentYandexHomeBinding.bind(p0);
    }
}
