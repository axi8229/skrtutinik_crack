package sputnik.axmor.com.sputnik.ui.alerts;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.databinding.FragmentUpdateRequiredBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.alerts.Alert;
import com.sputnik.common.entities.alerts.AlertAppearance;
import com.sputnik.common.entities.alerts.Button;
import com.sputnik.common.extensions.ViewKt;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.core.updates.PlatformDependentFeaturesKt;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: FragmentUpdateRequired.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/alerts/FragmentUpdateRequired;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/AlertsViewState;", "alertsViewState", "", "renderAlerts", "(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/databinding/FragmentUpdateRequiredBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/common/databinding/FragmentUpdateRequiredBinding;", "binding", "Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel$delegate", "Lkotlin/Lazy;", "getAlertsViewModel", "()Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FragmentUpdateRequired extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FragmentUpdateRequired.class, "binding", "getBinding()Lcom/sputnik/common/databinding/FragmentUpdateRequiredBinding;", 0))};

    /* renamed from: alertsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy alertsViewModel;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final FragmentUpdateRequiredBinding getBinding() {
        return (FragmentUpdateRequiredBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    private final AlertsViewModel getAlertsViewModel() {
        return (AlertsViewModel) this.alertsViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AlertsViewModel alertsViewModel = getAlertsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        alertsViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewKt.addSystemWindowInsetToPadding(root, true);
    }

    /* compiled from: FragmentUpdateRequired.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AlertsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, FragmentUpdateRequired.class, "renderAlerts", "renderAlerts(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlertsViewState alertsViewState) {
            invoke2(alertsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlertsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FragmentUpdateRequired) this.receiver).renderAlerts(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAlerts(AlertsViewState alertsViewState) {
        TextWith1Param body;
        TextWith1Param body2;
        Alert alert = (Alert) CollectionsKt.firstOrNull((List) alertsViewState.getAlerts());
        if (alert == null) {
            return;
        }
        FragmentUpdateRequiredBinding binding = getBinding();
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
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton btnAccept = getBinding().btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired$initViews$1$1
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
                try {
                    Context contextRequireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    PlatformDependentFeaturesKt.openMarket(contextRequireContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1, null);
    }

    public FragmentUpdateRequired() {
        super(R.layout.fragment_update_required);
        this.binding = new ViewBindingFragmentDelegate(this, FragmentUpdateRequired$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.alertsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AlertsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired$alertsViewModel$2
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
