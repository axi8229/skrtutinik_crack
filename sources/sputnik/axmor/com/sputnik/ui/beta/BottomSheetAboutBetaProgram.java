package sputnik.axmor.com.sputnik.ui.beta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetAboutBetaProgramBinding;
import sputnik.axmor.com.sputnik.core.updates.PlatformDependentFeaturesKt;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetAboutBetaProgram.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/beta/BottomSheetAboutBetaProgram;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetAboutBetaProgramBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetAboutBetaProgram extends BaseBottomSheetDialogFragment<BottomSheetAboutBetaProgramBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* compiled from: BottomSheetAboutBetaProgram.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetAboutBetaProgramBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetAboutBetaProgramBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetAboutBetaProgramBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetAboutBetaProgramBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetAboutBetaProgramBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetAboutBetaProgramBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetAboutBetaProgram() {
        super(AnonymousClass1.INSTANCE);
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.DialogStyle);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetAboutBetaProgramBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetAboutBetaProgram.initViews$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetAboutBetaProgram.initViews$lambda$2$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$0(BottomSheetAboutBetaProgram this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GeneralEvents.ClickBetaPromoBecomeATester());
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PlatformDependentFeaturesKt.openMarket(contextRequireContext);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(BottomSheetAboutBetaProgram this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        BottomSheetAboutBetaProgramBinding binding = getBinding();
        binding.btnApply.setText("Стать бета-тестировщиком");
        binding.btnCancel.setText("Не сейчас");
        binding.tvTitle.setText("Как стать участником?");
        binding.tvAttention.setText("Обратите внимание,\nколичество мест в программе\nбета-тестирования ограничено");
        TextView textView = binding.tvTellUs;
        int color = ContextCompat.getColor(requireContext(), R.color.sputnik_header_black);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textView.setText(ViewUtilsKt.highlightText$default("Необходимо перейти на страницу приложения\n«Наш дом» в магазине приложений и нажать\nПрисоединиться в разделе «Примите участие\nв бета-тестировании»", "Присоединиться", color, contextRequireContext, 0, 16, null));
    }
}
