package sputnik.axmor.com.sputnik.ui.alerts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.databinding.BottomSheetUpdateRequiredBinding;
import com.sputnik.common.entities.alerts.Alert;
import com.sputnik.common.entities.alerts.AlertAppearance;
import com.sputnik.common.entities.alerts.Button;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AlertsViewModel;
import com.sputnik.common.viewmodels.AlertsViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.entities.alers.TextWith1Param;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.core.updates.PlatformDependentFeaturesKt;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetUpdateRequired.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/alerts/BottomSheetUpdateRequired;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/common/databinding/BottomSheetUpdateRequiredBinding;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/AlertsViewState;", "alertsViewState", "", "renderUi", "(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel$delegate", "Lkotlin/Lazy;", "getAlertsViewModel", "()Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetUpdateRequired extends BaseBottomSheetDialogFragment<BottomSheetUpdateRequiredBinding> {

    /* renamed from: alertsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy alertsViewModel;
    public Analytics analytics;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    /* compiled from: BottomSheetUpdateRequired.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetUpdateRequiredBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetUpdateRequiredBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/common/databinding/BottomSheetUpdateRequiredBinding;", 0);
        }

        public final BottomSheetUpdateRequiredBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetUpdateRequiredBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetUpdateRequiredBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final AlertsViewModel getAlertsViewModel() {
        return (AlertsViewModel) this.alertsViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    /* compiled from: BottomSheetUpdateRequired.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26391 extends FunctionReferenceImpl implements Function1<AlertsViewState, Unit> {
        C26391(Object obj) {
            super(1, obj, BottomSheetUpdateRequired.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlertsViewState alertsViewState) {
            invoke2(alertsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlertsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetUpdateRequired) this.receiver).renderUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AlertsViewModel alertsViewModel = getAlertsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        alertsViewModel.observeState(viewLifecycleOwner, new C26391(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(AlertsViewState alertsViewState) {
        TextWith1Param body;
        TextWith1Param body2;
        Alert alert = (Alert) CollectionsKt.firstOrNull((List) alertsViewState.getAlerts());
        if (alert == null) {
            return;
        }
        BottomSheetUpdateRequiredBinding binding = getBinding();
        TextView textView = binding.tvHeader;
        AlertAppearance appearance = alert.getAppearance();
        textView.setText(appearance != null ? appearance.getTitle() : null);
        TextView textView2 = binding.tvSubtitle;
        AlertAppearance appearance2 = alert.getAppearance();
        String strValueOf = String.valueOf((appearance2 == null || (body2 = appearance2.getBody()) == null) ? null : body2.getText());
        AlertAppearance appearance3 = alert.getAppearance();
        String strValueOf2 = String.valueOf((appearance3 == null || (body = appearance3.getBody()) == null) ? null : body.getParam1());
        int color = ContextCompat.getColor(requireContext(), R.color.sputnik_header_black);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textView2.setText(ViewUtilsKt.highlightText$default(strValueOf, strValueOf2, color, contextRequireContext, 0, 16, null));
        AppCompatButton appCompatButton = binding.btnAccept;
        Button button = (Button) CollectionsKt.firstOrNull((List) alert.getButtons());
        appCompatButton.setText(button != null ? button.getTitle() : null);
        AppCompatButton appCompatButton2 = binding.btnCancel;
        Button button2 = (Button) CollectionsKt.getOrNull(alert.getButtons(), 1);
        appCompatButton2.setText(button2 != null ? button2.getTitle() : null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetUpdateRequiredBinding binding = getBinding();
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$initViews$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BottomSheetUpdateRequired bottomSheetUpdateRequired = this.this$0;
                try {
                    bottomSheetUpdateRequired.dismiss();
                    Context contextRequireContext = bottomSheetUpdateRequired.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    PlatformDependentFeaturesKt.openMarket(contextRequireContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1, null);
        AppCompatButton btnCancel = binding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        SafeClickListenerKt.setSafeOnClickListener$default(btnCancel, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$initViews$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.dismiss();
            }
        }, 1, null);
    }

    public BottomSheetUpdateRequired() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.alertsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AlertsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired$alertsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
