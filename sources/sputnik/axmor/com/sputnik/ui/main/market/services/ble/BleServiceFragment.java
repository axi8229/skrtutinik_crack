package sputnik.axmor.com.sputnik.ui.main.market.services.ble;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.Slider;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.BleEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.DigitalKeysMainBody;
import com.sputnik.common.entities.localization.DigitalKeysMainLocale;
import com.sputnik.common.entities.localization.DigitalKeysMainSubscriptionView;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.TextListTitles;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.SetCheckedSafeKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.market.services.ServiceState;
import com.sputnik.domain.entities.prefs.AppSettings;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentBleServiceBinding;
import sputnik.axmor.com.databinding.LayoutInfoServiceBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewState;

/* compiled from: BleServiceFragment.kt */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001<\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0003R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010+\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010+\u001a\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006Z"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BleServiceFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "", "renderService", "(Ljava/util/List;)V", "service", "initCompanyService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "initSubscriptionService", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentBleServiceBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentBleServiceBinding;", "binding", "Ldagger/Lazy;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Ldagger/Lazy;", "getFactory", "()Ldagger/Lazy;", "setFactory", "(Ldagger/Lazy;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "beaconServiceManager", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "sputnik/axmor/com/sputnik/ui/main/market/services/ble/BleServiceFragment$beaconScanningListener$1", "beaconScanningListener", "Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BleServiceFragment$beaconScanningListener$1;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "", "serviceId$delegate", "getServiceId", "()Ljava/lang/String;", "serviceId", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "isRssiManuallyChanged", "Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BleServiceFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BleServiceFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentBleServiceBinding;", 0))};
    public Analytics analytics;
    private final BleServiceFragment$beaconScanningListener$1 beaconScanningListener;
    private BeaconServiceManager beaconServiceManager;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public Lazy<MultiViewModelFactory> factory;
    private boolean isRssiManuallyChanged;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy navController;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy onboardingViewModel;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy serviceId;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy settingsViewModel;

    /* compiled from: BleServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockingLevel.values().length];
            try {
                iArr[BlockingLevel.PARTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentBleServiceBinding getBinding() {
        return (FragmentBleServiceBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Lazy<MultiViewModelFactory> getFactory() {
        Lazy<MultiViewModelFactory> lazy = this.factory;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
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
        BeaconServiceManager.Companion companion = BeaconServiceManager.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.beaconServiceManager = companion.getInstance(contextRequireContext, this.beaconScanningListener);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
        SettingsViewModel settingsViewModel = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        settingsViewModel.observeState(viewLifecycleOwner, new AnonymousClass2());
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner2, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServices();
            }
        }, new AnonymousClass4(this));
    }

    /* compiled from: BleServiceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$1", f = "BleServiceFragment.kt", l = {102}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BleServiceFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BleServiceFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$1$1", f = "BleServiceFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BleServiceFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03661(BleServiceFragment bleServiceFragment, Continuation<? super C03661> continuation) {
                super(2, continuation);
                this.this$0 = bleServiceFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03661(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                Integer rssiOptimal = this.this$0.getSettingsViewModel().getAppSettings().getBleSettings().getRssiOptimal();
                float fIntValue = rssiOptimal != null ? rssiOptimal.intValue() : -120;
                ref$FloatRef.element = fIntValue;
                if (fIntValue > -60.0f) {
                    ref$FloatRef.element = -60.0f;
                    AppSettings appSettings = this.this$0.getSettingsViewModel().getAppSettings();
                    SettingsViewModel settingsViewModel = this.this$0.getSettingsViewModel();
                    AppSettings.BleSettings bleSettings = appSettings.getBleSettings();
                    bleSettings.setRssiOptimal(Boxing.boxInt((int) ref$FloatRef.element));
                    appSettings.setBleSettings(bleSettings);
                    settingsViewModel.updateAppSettings(appSettings);
                }
                if (ref$FloatRef.element < -150.0f) {
                    ref$FloatRef.element = -150.0f;
                    AppSettings appSettings2 = this.this$0.getSettingsViewModel().getAppSettings();
                    SettingsViewModel settingsViewModel2 = this.this$0.getSettingsViewModel();
                    AppSettings.BleSettings bleSettings2 = appSettings2.getBleSettings();
                    bleSettings2.setRssiOptimal(Boxing.boxInt((int) ref$FloatRef.element));
                    appSettings2.setBleSettings(bleSettings2);
                    settingsViewModel2.updateAppSettings(appSettings2);
                }
                this.this$0.getBinding().slider.setValue((float) Math.abs(ref$FloatRef.element));
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BleServiceFragment bleServiceFragment = BleServiceFragment.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                C03661 c03661 = new C03661(bleServiceFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(bleServiceFragment, state, c03661, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BleServiceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$2, reason: invalid class name */
    static final class AnonymousClass2 extends Lambda implements Function1<SettingsViewState, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) throws Resources.NotFoundException {
            invoke2(settingsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewState it) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(it, "it");
            final FragmentBleServiceBinding binding = BleServiceFragment.this.getBinding();
            final BleServiceFragment bleServiceFragment = BleServiceFragment.this;
            ConstraintLayout layoutPermissions = binding.layoutPermissions;
            Intrinsics.checkNotNullExpressionValue(layoutPermissions, "layoutPermissions");
            ViewBindingUtilsKt.visibilityBasedOn(layoutPermissions, Boolean.valueOf((it.getAppState().getBlePermissionsGranted() && it.getAppState().getBluetoothEnabled() && it.getAppState().getGpsEnabled()) ? false : true));
            bleServiceFragment.getBinding().slider.setValue((float) Math.abs(it.getAppSettings().getBleSettings().getRssiOptimal() != null ? r3.intValue() : Double.MIN_VALUE));
            binding.slider.clearOnChangeListeners();
            binding.slider.addOnChangeListener(new BaseOnChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$2$$ExternalSyntheticLambda0
                @Override // com.google.android.material.slider.BaseOnChangeListener
                public final void onValueChange(Slider slider, float f, boolean z) {
                    BleServiceFragment.AnonymousClass2.invoke$lambda$3$lambda$0(bleServiceFragment, slider, f, z);
                }
            });
            SwitchCompat switchBle = binding.switchBle;
            Intrinsics.checkNotNullExpressionValue(switchBle, "switchBle");
            Boolean enabled = it.getAppSettings().getBleSettings().getEnabled();
            SetCheckedSafeKt.setCheckedSafe(switchBle, enabled != null ? enabled.booleanValue() : false);
            SwitchCompat switchBlePromo = binding.switchBlePromo;
            Intrinsics.checkNotNullExpressionValue(switchBlePromo, "switchBlePromo");
            Boolean blePromoEnabled = it.getAppSettings().getBleSettings().getBlePromoEnabled();
            SetCheckedSafeKt.setCheckedSafe(switchBlePromo, blePromoEnabled != null ? blePromoEnabled.booleanValue() : false);
            binding.switchBle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$2$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws Resources.NotFoundException {
                    BleServiceFragment.AnonymousClass2.invoke$lambda$3$lambda$1(bleServiceFragment, binding, compoundButton, z);
                }
            });
            binding.switchBlePromo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$2$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BleServiceFragment.AnonymousClass2.invoke$lambda$3$lambda$2(bleServiceFragment, compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$0(BleServiceFragment this$0, Slider slider, float f, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(slider, "slider");
            if (!this$0.isRssiManuallyChanged) {
                this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleOpeningDistance());
                this$0.isRssiManuallyChanged = true;
            }
            AppSettings appSettings = this$0.getSettingsViewModel().getPrefs().getAppSettings();
            int iRound$default = RSSIDeterminer.Companion.round$default(RSSIDeterminer.INSTANCE, -f, 0, 0, 0, 14, null);
            BeaconServiceManager.Companion companion = BeaconServiceManager.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            companion.getInstance(contextRequireContext, null).updateRssi(iRound$default);
            this$0.getSettingsViewModel().updateAppSettings(AppSettings.copy$default(appSettings, AppSettings.BleSettings.copy$default(appSettings.getBleSettings(), null, null, null, Integer.valueOf(iRound$default), null, null, 55, null), null, 2, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$1(BleServiceFragment this$0, FragmentBleServiceBinding fragmentBleServiceBinding, CompoundButton compoundButton, boolean z) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z) {
                if (this$0.getSettingsViewModel().getCurrentState().getAppState().getBlePermissionsGranted() && this$0.getSettingsViewModel().getCurrentState().getAppState().getBluetoothEnabled() && this$0.getSettingsViewModel().getCurrentState().getAppState().getGpsEnabled()) {
                    this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleOn());
                    BeaconServiceManager beaconServiceManager = this$0.beaconServiceManager;
                    if (beaconServiceManager != null) {
                        beaconServiceManager.startTracking(this$0.beaconScanningListener);
                    }
                    this$0.getOnboardingViewModel().delayBleFeedback();
                } else {
                    this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleOff());
                    BeaconServiceManager beaconServiceManager2 = this$0.beaconServiceManager;
                    if (beaconServiceManager2 != null) {
                        beaconServiceManager2.stopTracking();
                    }
                    z = false;
                    fragmentBleServiceBinding.switchBle.setChecked(false);
                    NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_bottomSheetNoBlePermissions, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, "ble_switcher")), null, 4, null);
                }
            } else {
                this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleOff2());
                BeaconServiceManager beaconServiceManager3 = this$0.beaconServiceManager;
                if (beaconServiceManager3 != null) {
                    beaconServiceManager3.stopTracking();
                }
            }
            this$0.getSettingsViewModel().updateAppSettings(new AppSettings(new AppSettings.BleSettings(Boolean.valueOf(z), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, 32, (DefaultConstructorMarker) null), (Boolean) null, 2, (DefaultConstructorMarker) null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$2(BleServiceFragment this$0, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z) {
                this$0.getAnalytics().trackLogEvent(new BleEvents.StateBlePromoOff());
            }
            this$0.getSettingsViewModel().updateAppSettings(new AppSettings(new AppSettings.BleSettings((Boolean) null, (Integer) null, (Integer) null, (Integer) null, Boolean.valueOf(z), (Boolean) null, 32, (DefaultConstructorMarker) null), (Boolean) null, 2, (DefaultConstructorMarker) null));
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$beaconScanningListener$1] */
    public BleServiceFragment() {
        super(R.layout.fragment_ble_service);
        this.binding = new ViewBindingFragmentDelegate(this, BleServiceFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.beaconScanningListener = new BeaconServiceManager.BeaconServiceConnectionListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$beaconScanningListener$1
            @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager.BeaconServiceConnectionListener
            public void onBeaconServiceConnected(boolean isTracking) {
            }
        };
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$serviceId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("curService") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return (String) obj;
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment);
            }
        });
    }

    /* compiled from: BleServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, BleServiceFragment.class, "renderService", "renderService(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BleServiceFragment) this.receiver).renderService(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderService(List<Service> services) {
        Object next;
        OriginType type;
        Iterator<T> it = services.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getBLE_IDENTIFIER())) {
                    break;
                }
            }
        }
        Service service = (Service) next;
        if (service != null) {
            Toolbar toolbar = getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
            getBinding().toolbar.setTitle(service.getTitle());
            if (service.getState() == ServiceState.activated) {
                FragmentBleServiceBinding binding = getBinding();
                TextView textView = binding.layoutInfo.tvDateService;
                Origin origin = service.getOrigin();
                textView.setText(origin != null ? origin.getExpires() : null);
                LinearLayout dateLayout = binding.layoutInfo.dateLayout;
                Intrinsics.checkNotNullExpressionValue(dateLayout, "dateLayout");
                Origin origin2 = service.getOrigin();
                ViewBindingUtilsKt.visibilityBasedOn(dateLayout, Boolean.valueOf((origin2 != null ? origin2.getExpires() : null) != null));
                Origin origin3 = service.getOrigin();
                LogUtilsKt.writeLog(String.valueOf((origin3 == null || (type = origin3.getType()) == null) ? null : type.toString()));
                Origin origin4 = service.getOrigin();
                if ((origin4 != null ? origin4.getType() : null) == OriginType.company) {
                    initCompanyService(service);
                } else {
                    initSubscriptionService(service);
                }
                ScrollView root = getBinding().serviceWaiting.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.gone(root);
                return;
            }
            ScrollView root2 = getBinding().serviceWaiting.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            ViewKt.visible(root2);
        }
    }

    private final void initCompanyService(Service service) {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        ArchiveMainLocale archiveMain;
        ArchiveMainView body2;
        TextListTitles partnerView;
        List<String> values;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().layoutInfo;
        Origin origin = service.getOrigin();
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String infoLabel = null;
        textView.setText((data == null || (archiveMain = data.getArchiveMain()) == null || (body2 = archiveMain.getBody()) == null || (partnerView = body2.getPartnerView()) == null || (values = partnerView.getValues()) == null) ? null : (String) CollectionsKt.last((List) values));
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.visible(lCompanyTitles);
        LinearLayout companyNameLayout = layoutInfoServiceBinding.companyNameLayout;
        Intrinsics.checkNotNullExpressionValue(companyNameLayout, "companyNameLayout");
        String title = origin != null ? origin.getTitle() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companyNameLayout, Boolean.valueOf(!(title == null || title.length() == 0)));
        layoutInfoServiceBinding.tvCompanyName.setText(origin != null ? origin.getTitle() : null);
        LinearLayout companyPhoneLayout = layoutInfoServiceBinding.companyPhoneLayout;
        Intrinsics.checkNotNullExpressionValue(companyPhoneLayout, "companyPhoneLayout");
        String phone = origin != null ? origin.getPhone() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companyPhoneLayout, Boolean.valueOf(!(phone == null || phone.length() == 0)));
        layoutInfoServiceBinding.tvCompanyPhone.setText(origin != null ? origin.getPhone() : null);
        LinearLayout companySiteLayout = layoutInfoServiceBinding.companySiteLayout;
        Intrinsics.checkNotNullExpressionValue(companySiteLayout, "companySiteLayout");
        String website = origin != null ? origin.getWebsite() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companySiteLayout, Boolean.valueOf(!(website == null || website.length() == 0)));
        layoutInfoServiceBinding.tvCompanySite.setText(origin != null ? origin.getWebsite() : null);
        AppCompatButton appCompatButton = getBinding().subsSettingsButton;
        appCompatButton.setEnabled(false);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (digitalKeysMain = data2.getDigitalKeysMain()) != null && (body = digitalKeysMain.getBody()) != null) {
            infoLabel = body.getInfoLabel();
        }
        appCompatButton.setText(infoLabel);
    }

    private final void initSubscriptionService(Service service) {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        DigitalKeysMainSubscriptionView subscriptionView;
        TextTitle settingsButton;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().layoutInfo;
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        Origin origin = service.getOrigin();
        String title = null;
        textView.setText(origin != null ? origin.getTitle() : null);
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.gone(lCompanyTitles);
        AppCompatButton appCompatButton = getBinding().subsSettingsButton;
        appCompatButton.setEnabled(true);
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data != null && (digitalKeysMain = data.getDigitalKeysMain()) != null && (body = digitalKeysMain.getBody()) != null && (subscriptionView = body.getSubscriptionView()) != null && (settingsButton = subscriptionView.getSettingsButton()) != null) {
            title = settingsButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        ScrollView viewMain = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        ScrollView viewMain2 = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain2, "viewMain");
        ViewKt.addSystemWindowInsetToMargin$default(viewMain2, true, false, true, true, 2, null);
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.archiveServiceFragment, R.id.action_archiveServiceFragment_to_blockingNavigation, null, null, 12, null);
        }
        FragmentBleServiceBinding binding = getBinding();
        binding.btnSetupRssi.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleServiceFragment.initViews$lambda$11$lambda$8(this.f$0, view);
            }
        });
        binding.btnSetupPermissions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleServiceFragment.initViews$lambda$11$lambda$9(this.f$0, view);
            }
        });
        binding.subsSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleServiceFragment.initViews$lambda$11$lambda$10(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11$lambda$8(BleServiceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleSignalLevel());
        if (this$0.getSettingsViewModel().getCurrentState().getAppState().getBlePermissionsGranted() && this$0.getSettingsViewModel().getCurrentState().getAppState().getBluetoothEnabled() && this$0.getSettingsViewModel().getCurrentState().getAppState().getGpsEnabled()) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_bleServiceFragment_to_bottomSheetSetupRssi, null, null, 6, null);
        } else {
            NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_bottomSheetNoBlePermissions, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, "setup_rssi")), null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11$lambda$9(BleServiceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBlePermission());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_permissionsFragment, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11$lambda$10(BleServiceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleSubscriptionSettings());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.bleServiceFragment_to_infoServices, null, null, 6, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        BleLocale ble;
        BleLocale.BleService bleService;
        BleLocale.Body body;
        BleLocale ble2;
        BleLocale.BleService bleService2;
        TextTitle navigation;
        FragmentBleServiceBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = (data == null || (ble2 = data.getBle()) == null || (bleService2 = ble2.getBleService()) == null || (navigation = bleService2.getNavigation()) == null) ? null : navigation.getTitle();
        if (title == null) {
            title = "";
        }
        toolbar.setTitle(title);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 == null || (ble = data2.getBle()) == null || (bleService = ble.getBleService()) == null || (body = bleService.getBody()) == null) {
            return;
        }
        TextView textView = binding.tvBleEnabledTitle;
        String useBleSwitch = body.getUseBleSwitch();
        if (useBleSwitch == null) {
            useBleSwitch = "";
        }
        textView.setText(useBleSwitch);
        TextView textView2 = binding.tvAttention;
        String permissionsNotGrantedAttention = body.getPermissionsNotGrantedAttention();
        if (permissionsNotGrantedAttention == null) {
            permissionsNotGrantedAttention = "";
        }
        textView2.setText(permissionsNotGrantedAttention);
        AppCompatButton appCompatButton = binding.btnSetupPermissions;
        BleLocale.Body.SetupPermissionsButton setupPermissionsButton = body.getSetupPermissionsButton();
        String title2 = setupPermissionsButton != null ? setupPermissionsButton.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        appCompatButton.setText(title2);
        TextView textView3 = binding.tvRssiTitle;
        String rssiLevel = body.getRssiLevel();
        if (rssiLevel == null) {
            rssiLevel = "";
        }
        textView3.setText(rssiLevel);
        TextView textView4 = binding.tvRssiDescription;
        String rssiLevelDescription = body.getRssiLevelDescription();
        if (rssiLevelDescription == null) {
            rssiLevelDescription = "";
        }
        textView4.setText(rssiLevelDescription);
        AppCompatButton appCompatButton2 = binding.btnSetupRssi;
        BleLocale.Body.SetupRssiButton setupRssiButton = body.getSetupRssiButton();
        String title3 = setupRssiButton != null ? setupRssiButton.getTitle() : null;
        if (title3 == null) {
            title3 = "";
        }
        appCompatButton2.setText(title3);
        TextView textView5 = binding.tvDistanceTitle;
        String openDistance = body.getOpenDistance();
        if (openDistance == null) {
            openDistance = "";
        }
        textView5.setText(openDistance);
        TextView textView6 = binding.tvDistanceDescription;
        String openDistanceDescription = body.getOpenDistanceDescription();
        if (openDistanceDescription == null) {
            openDistanceDescription = "";
        }
        textView6.setText(openDistanceDescription);
        TextView textView7 = binding.tvDistanceNear;
        String distanceNear = body.getDistanceNear();
        if (distanceNear == null) {
            distanceNear = "";
        }
        textView7.setText(distanceNear);
        TextView textView8 = binding.tvDistanceLong;
        String distanceLong = body.getDistanceLong();
        if (distanceLong == null) {
            distanceLong = "";
        }
        textView8.setText(distanceLong);
        TextView textView9 = binding.tvTitle;
        String mainTitle = body.getMainTitle();
        if (mainTitle == null) {
            mainTitle = "";
        }
        textView9.setText(mainTitle);
        TextView textView10 = binding.tvBlePromoTitle;
        String promo = body.getPromo();
        if (promo == null) {
            promo = "";
        }
        textView10.setText(promo);
        TextView textView11 = binding.tvBeta;
        String beta = body.getBeta();
        textView11.setText(beta != null ? beta : "");
    }
}
