package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.huawei.hms.push.AttributionReporter;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.PermissionsEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.permissions.PermissionsLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.CheckBoxPreferenceView;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.Lazy;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentPermissionsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewState;

/* compiled from: PermissionsFragment.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0003R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R(\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010Q\u001a\u0010\u0012\f\u0012\n P*\u0004\u0018\u00010\n0\n0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010TR\u0016\u0010V\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010TR\u0016\u0010X\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010TR\u0016\u0010Z\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010TR\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010T¨\u0006\\"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/PermissionsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "state", "", "renderSettingsUi", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", "trackAnalytics", "", AttributionReporter.SYSTEM_PERMISSION, "", "needRequestPermission", "navigateToPermissionExplaining", "(Ljava/lang/String;Z)V", "Lkotlin/Function1;", "onNeedExplain", "requestPermission", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentPermissionsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentPermissionsBinding;", "binding", "Ldagger/Lazy;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Ldagger/Lazy;", "getFactory", "()Ldagger/Lazy;", "setFactory", "(Ldagger/Lazy;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel$delegate", "getInstructionsViewModel", "()Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "lastRequestedPermission", "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "isBluetoothRequested", "Z", "isGpsRequested", "isNotificationPermissionRequested", "isLocationPermissionRequested", "isBackgroundLocationPermissionRequested", "isNearbyDevicesPermissionRequested", "isAppInWhiteListRequested", "isDisplayOverOtherAppsRequested", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PermissionsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentPermissionsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public Lazy<MultiViewModelFactory> factory;

    /* renamed from: instructionsViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy instructionsViewModel;
    private boolean isAppInWhiteListRequested;
    private boolean isBackgroundLocationPermissionRequested;
    private boolean isBluetoothRequested;
    private boolean isDisplayOverOtherAppsRequested;
    private boolean isGpsRequested;
    private boolean isLocationPermissionRequested;
    private boolean isNearbyDevicesPermissionRequested;
    private boolean isNotificationPermissionRequested;
    private String lastRequestedPermission;
    public LocalizationStorage localizationScreen;
    private final ActivityResultLauncher<String> requestPermissionLauncher;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy settingsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentPermissionsBinding getBinding() {
        return (FragmentPermissionsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Lazy<MultiViewModelFactory> getFactory() {
        Lazy<MultiViewModelFactory> lazy = this.factory;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    private final InstructionsViewModel getInstructionsViewModel() {
        return (InstructionsViewModel) this.instructionsViewModel.getValue();
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
    public static final void requestPermissionLauncher$lambda$0(PermissionsFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            return;
        }
        this$0.getSettingsViewModel().reloadPreferences();
        navigateToPermissionExplaining$default(this$0, this$0.lastRequestedPermission, false, 2, null);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        InstructionsViewModel instructionsViewModel = getInstructionsViewModel();
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        instructionsViewModel.changeManufacturerAndSDKInt(MANUFACTURER, Build.VERSION.SDK_INT);
        SettingsViewModel settingsViewModel = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        settingsViewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                PermissionsFragment permissionsFragment = PermissionsFragment.this;
                LinearLayout root = permissionsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(permissionsFragment, root, it);
            }
        });
        getSettingsViewModel().reloadPreferences();
        SettingsViewModel settingsViewModel2 = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        settingsViewModel2.observeState(viewLifecycleOwner2, new Function1<SettingsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment.onViewCreated.2
            {
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
                PermissionsFragment.this.getBinding().prefWhitelistPermission.setChecked(it.getAppState().getAppInWhiteList());
                if (it.getAppState().getAppInWhiteList() && PermissionsFragment.this.isAppInWhiteListRequested) {
                    PermissionsFragment.this.isAppInWhiteListRequested = false;
                    PermissionsFragment.this.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionWhitelistOn());
                    LogUtilsKt.writeLog("PermissionRequest: WHITELIST REQUESTED AND GRANTED");
                }
                if (it.getAppState().getDisplayOverOtherAppsAllowed() && PermissionsFragment.this.isDisplayOverOtherAppsRequested) {
                    PermissionsFragment.this.isDisplayOverOtherAppsRequested = false;
                    PermissionsFragment.this.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionOverOn());
                    LogUtilsKt.writeLog("PermissionRequest: DISPLAY OVER APPS REQUESTED AND GRANTED");
                }
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(null), 3, null);
    }

    /* compiled from: PermissionsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$onViewCreated$3", f = "PermissionsFragment.kt", l = {111}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$onViewCreated$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PermissionsFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PermissionsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$onViewCreated$3$1", f = "PermissionsFragment.kt", l = {113}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$onViewCreated$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PermissionsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PermissionsFragment permissionsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = permissionsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getSettingsViewModel().reloadPreferences();
                    MutableStateFlow<SettingsViewState> uiState = this.this$0.getSettingsViewModel().getUiState();
                    final PermissionsFragment permissionsFragment = this.this$0;
                    FlowCollector<? super SettingsViewState> flowCollector = new FlowCollector() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment.onViewCreated.3.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((SettingsViewState) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(SettingsViewState settingsViewState, Continuation<? super Unit> continuation) throws InterruptedException, Resources.NotFoundException {
                            permissionsFragment.renderSettingsUi(settingsViewState);
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (uiState.collect(flowCollector, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PermissionsFragment permissionsFragment = PermissionsFragment.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(permissionsFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(permissionsFragment, state, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSettingsUi(final SettingsViewState state) throws InterruptedException, Resources.NotFoundException {
        PermissionsLocale permissions;
        PermissionsLocale.Permission backgroundWork;
        PermissionsLocale permissions2;
        PermissionsLocale.Permission backgroundWork2;
        PermissionsLocale permissions3;
        PermissionsLocale.Permission whitelist;
        PermissionsLocale permissions4;
        PermissionsLocale.Permission whitelist2;
        PermissionsLocale permissions5;
        PermissionsLocale.Permission aboveOtherApps;
        PermissionsLocale permissions6;
        PermissionsLocale.Permission aboveOtherApps2;
        PermissionsLocale permissions7;
        PermissionsLocale.Permission nearbyDevices;
        PermissionsLocale permissions8;
        PermissionsLocale.Permission nearbyDevices2;
        PermissionsLocale permissions9;
        PermissionsLocale.Permission location;
        PermissionsLocale permissions10;
        PermissionsLocale.Permission location2;
        PermissionsLocale permissions11;
        PermissionsLocale.Permission location3;
        PermissionsLocale permissions12;
        PermissionsLocale.Permission location4;
        PermissionsLocale permissions13;
        PermissionsLocale.Permission notifications;
        PermissionsLocale permissions14;
        PermissionsLocale.Permission notifications2;
        PermissionsLocale permissions15;
        PermissionsLocale.Permission bluetoothService;
        PermissionsLocale permissions16;
        PermissionsLocale.Permission locationService;
        PermissionsLocale permissions17;
        PermissionsLocale.Permission bluetoothService2;
        PermissionsLocale permissions18;
        PermissionsLocale.Permission bluetoothService3;
        trackAnalytics(state);
        FragmentPermissionsBinding binding = getBinding();
        CheckBoxPreferenceView prefBluetoothService = binding.prefBluetoothService;
        Intrinsics.checkNotNullExpressionValue(prefBluetoothService, "prefBluetoothService");
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String explain = null;
        String name = (data == null || (permissions18 = data.getPermissions()) == null || (bluetoothService3 = permissions18.getBluetoothService()) == null) ? null : bluetoothService3.getName();
        if (name == null) {
            name = "";
        }
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        String explain2 = (data2 == null || (permissions17 = data2.getPermissions()) == null || (bluetoothService2 = permissions17.getBluetoothService()) == null) ? null : bluetoothService2.getExplain();
        if (explain2 == null) {
            explain2 = "";
        }
        CheckBoxPreferenceView.initialize$default(prefBluetoothService, name, explain2, state.getAppState().getBluetoothEnabled(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getBluetoothEnabled()) {
                        this.isBluetoothRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionBluetoothOn());
                    Intent intent = new Intent();
                    intent.setAction("android.settings.BLUETOOTH_SETTINGS");
                    this.startActivity(intent);
                }
            }
        }, null, false, 48, null);
        CheckBoxPreferenceView prefGpsService = binding.prefGpsService;
        Intrinsics.checkNotNullExpressionValue(prefGpsService, "prefGpsService");
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        String name2 = (data3 == null || (permissions16 = data3.getPermissions()) == null || (locationService = permissions16.getLocationService()) == null) ? null : locationService.getName();
        String str = name2 == null ? "" : name2;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        String explain3 = (data4 == null || (permissions15 = data4.getPermissions()) == null || (bluetoothService = permissions15.getBluetoothService()) == null) ? null : bluetoothService.getExplain();
        CheckBoxPreferenceView.initialize$default(prefGpsService, str, explain3 == null ? "" : explain3, state.getAppState().getGpsEnabled(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getGpsEnabled()) {
                        this.isGpsRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionGPSOn());
                    this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }
        }, null, false, 48, null);
        CheckBoxPreferenceView prefNotificationsPermission = binding.prefNotificationsPermission;
        Intrinsics.checkNotNullExpressionValue(prefNotificationsPermission, "prefNotificationsPermission");
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        String name3 = (data5 == null || (permissions14 = data5.getPermissions()) == null || (notifications2 = permissions14.getNotifications()) == null) ? null : notifications2.getName();
        String str2 = name3 == null ? "" : name3;
        LocalizationLocalModel data6 = getLocalizationScreen().getData();
        String explain4 = (data6 == null || (permissions13 = data6.getPermissions()) == null || (notifications = permissions13.getNotifications()) == null) ? null : notifications.getExplain();
        CheckBoxPreferenceView.initialize$default(prefNotificationsPermission, str2, explain4 == null ? "" : explain4, state.getAppState().getBlePermissions().getNotificationsPermission().getGranted(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getBlePermissions().getNotificationsPermission().getGranted()) {
                        this.isNotificationPermissionRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionNotificationsOn());
                    if (state.getAppState().getBlePermissions().getNotificationsPermission().getGranted()) {
                        return;
                    }
                    PermissionsFragment permissionsFragment = this;
                    String id = state.getAppState().getBlePermissions().getNotificationsPermission().getId();
                    final PermissionsFragment permissionsFragment2 = this;
                    final SettingsViewState settingsViewState = state;
                    permissionsFragment.requestPermission(id, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            permissionsFragment2.navigateToPermissionExplaining(settingsViewState.getAppState().getBlePermissions().getNotificationsPermission().getId(), z2);
                        }
                    });
                }
            }
        }, null, state.getAppState().getBlePermissions().getNotificationsPermission().getVisible(), 16, null);
        CheckBoxPreferenceView prefLocationPermission = binding.prefLocationPermission;
        Intrinsics.checkNotNullExpressionValue(prefLocationPermission, "prefLocationPermission");
        LocalizationLocalModel data7 = getLocalizationScreen().getData();
        String name4 = (data7 == null || (permissions12 = data7.getPermissions()) == null || (location4 = permissions12.getLocation()) == null) ? null : location4.getName();
        String str3 = name4 == null ? "" : name4;
        LocalizationLocalModel data8 = getLocalizationScreen().getData();
        String explain5 = (data8 == null || (permissions11 = data8.getPermissions()) == null || (location3 = permissions11.getLocation()) == null) ? null : location3.getExplain();
        CheckBoxPreferenceView.initialize$default(prefLocationPermission, str3, explain5 == null ? "" : explain5, state.getAppState().getBlePermissions().getLocationPermission().getGranted(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getBlePermissions().getLocationPermission().getGranted()) {
                        this.isLocationPermissionRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionLocationOn());
                    if (state.getAppState().getBlePermissions().getLocationPermission().getGranted()) {
                        return;
                    }
                    PermissionsFragment permissionsFragment = this;
                    String id = state.getAppState().getBlePermissions().getLocationPermission().getId();
                    final PermissionsFragment permissionsFragment2 = this;
                    final SettingsViewState settingsViewState = state;
                    permissionsFragment.requestPermission(id, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            permissionsFragment2.navigateToPermissionExplaining(settingsViewState.getAppState().getBlePermissions().getLocationPermission().getId(), z2);
                        }
                    });
                }
            }
        }, null, state.getAppState().getBlePermissions().getLocationPermission().getVisible(), 16, null);
        CheckBoxPreferenceView prefBackgroundLocationPermission = binding.prefBackgroundLocationPermission;
        Intrinsics.checkNotNullExpressionValue(prefBackgroundLocationPermission, "prefBackgroundLocationPermission");
        LocalizationLocalModel data9 = getLocalizationScreen().getData();
        String name5 = (data9 == null || (permissions10 = data9.getPermissions()) == null || (location2 = permissions10.getLocation()) == null) ? null : location2.getName();
        String str4 = name5 == null ? "" : name5;
        LocalizationLocalModel data10 = getLocalizationScreen().getData();
        String explain6 = (data10 == null || (permissions9 = data10.getPermissions()) == null || (location = permissions9.getLocation()) == null) ? null : location.getExplain();
        CheckBoxPreferenceView.initialize$default(prefBackgroundLocationPermission, str4, explain6 == null ? "" : explain6, state.getAppState().getBlePermissions().getBackgroundLocationPermission().getGranted(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getBlePermissions().getBackgroundLocationPermission().getGranted()) {
                        this.isBackgroundLocationPermissionRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionLocationOn());
                    if (state.getAppState().getBlePermissions().getBackgroundLocationPermission().getGranted()) {
                        return;
                    }
                    PermissionsFragment permissionsFragment = this;
                    String id = state.getAppState().getBlePermissions().getBackgroundLocationPermission().getId();
                    final PermissionsFragment permissionsFragment2 = this;
                    final SettingsViewState settingsViewState = state;
                    permissionsFragment.requestPermission(id, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            permissionsFragment2.navigateToPermissionExplaining(settingsViewState.getAppState().getBlePermissions().getBackgroundLocationPermission().getId(), z2);
                        }
                    });
                }
            }
        }, null, state.getAppState().getBlePermissions().getBackgroundLocationPermission().getVisible(), 16, null);
        CheckBoxPreferenceView prefNearbyDevicesPermission = binding.prefNearbyDevicesPermission;
        Intrinsics.checkNotNullExpressionValue(prefNearbyDevicesPermission, "prefNearbyDevicesPermission");
        LocalizationLocalModel data11 = getLocalizationScreen().getData();
        String name6 = (data11 == null || (permissions8 = data11.getPermissions()) == null || (nearbyDevices2 = permissions8.getNearbyDevices()) == null) ? null : nearbyDevices2.getName();
        String str5 = name6 == null ? "" : name6;
        LocalizationLocalModel data12 = getLocalizationScreen().getData();
        String explain7 = (data12 == null || (permissions7 = data12.getPermissions()) == null || (nearbyDevices = permissions7.getNearbyDevices()) == null) ? null : nearbyDevices.getExplain();
        CheckBoxPreferenceView.initialize$default(prefNearbyDevicesPermission, str5, explain7 == null ? "" : explain7, state.getAppState().getBlePermissions().getNearbyDevicesPermission().getGranted(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!state.getAppState().getBlePermissions().getNearbyDevicesPermission().getGranted()) {
                        this.isNearbyDevicesPermissionRequested = true;
                    }
                    this.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionDeviceSearchOn());
                    if (state.getAppState().getBlePermissions().getNearbyDevicesPermission().getGranted()) {
                        return;
                    }
                    PermissionsFragment permissionsFragment = this;
                    String id = state.getAppState().getBlePermissions().getNearbyDevicesPermission().getId();
                    final PermissionsFragment permissionsFragment2 = this;
                    final SettingsViewState settingsViewState = state;
                    permissionsFragment.requestPermission(id, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$6.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            permissionsFragment2.navigateToPermissionExplaining(settingsViewState.getAppState().getBlePermissions().getNearbyDevicesPermission().getId(), z2);
                        }
                    });
                }
            }
        }, null, state.getAppState().getBlePermissions().getNearbyDevicesPermission().getVisible(), 16, null);
        CheckBoxPreferenceView prefDisplayOverAppsPermission = binding.prefDisplayOverAppsPermission;
        Intrinsics.checkNotNullExpressionValue(prefDisplayOverAppsPermission, "prefDisplayOverAppsPermission");
        LocalizationLocalModel data13 = getLocalizationScreen().getData();
        String name7 = (data13 == null || (permissions6 = data13.getPermissions()) == null || (aboveOtherApps2 = permissions6.getAboveOtherApps()) == null) ? null : aboveOtherApps2.getName();
        String str6 = name7 == null ? "" : name7;
        LocalizationLocalModel data14 = getLocalizationScreen().getData();
        String explain8 = (data14 == null || (permissions5 = data14.getPermissions()) == null || (aboveOtherApps = permissions5.getAboveOtherApps()) == null) ? null : aboveOtherApps.getExplain();
        CheckBoxPreferenceView.initialize$default(prefDisplayOverAppsPermission, str6, explain8 == null ? "" : explain8, getSettingsViewModel().getCurrentState().getAppState().getDisplayOverOtherAppsAllowed(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!this.this$0.getSettingsViewModel().getCurrentState().getAppState().getDisplayOverOtherAppsAllowed()) {
                        this.this$0.isDisplayOverOtherAppsRequested = true;
                    }
                    this.this$0.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionDisplayOverOn());
                    if (this.this$0.getSettingsViewModel().getCurrentState().getAppState().getDisplayOverOtherAppsAllowed()) {
                        return;
                    }
                    Context context = this.this$0.getContext();
                    this.this$0.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + (context != null ? context.getPackageName() : null))));
                }
            }
        }, null, false, 48, null);
        CheckBoxPreferenceView prefWhitelistPermission = binding.prefWhitelistPermission;
        Intrinsics.checkNotNullExpressionValue(prefWhitelistPermission, "prefWhitelistPermission");
        LocalizationLocalModel data15 = getLocalizationScreen().getData();
        String name8 = (data15 == null || (permissions4 = data15.getPermissions()) == null || (whitelist2 = permissions4.getWhitelist()) == null) ? null : whitelist2.getName();
        String str7 = name8 == null ? "" : name8;
        LocalizationLocalModel data16 = getLocalizationScreen().getData();
        String explain9 = (data16 == null || (permissions3 = data16.getPermissions()) == null || (whitelist = permissions3.getWhitelist()) == null) ? null : whitelist.getExplain();
        CheckBoxPreferenceView.initialize$default(prefWhitelistPermission, str7, explain9 == null ? "" : explain9, getSettingsViewModel().getCurrentState().getAppState().getAppInWhiteList(), new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$renderSettingsUi$1$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (!this.this$0.getSettingsViewModel().getCurrentState().getAppState().getAppInWhiteList()) {
                        this.this$0.isAppInWhiteListRequested = true;
                    }
                    this.this$0.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionWhitelistOn());
                }
                if (!z || this.this$0.getSettingsViewModel().getCurrentState().getAppState().getAppInWhiteList()) {
                    return;
                }
                PermissionsFragment.navigateToPermissionExplaining$default(this.this$0, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", false, 2, null);
            }
        }, null, false, 48, null);
        TextView textView = binding.tvBackgroundWorkTitle;
        LocalizationLocalModel data17 = getLocalizationScreen().getData();
        String name9 = (data17 == null || (permissions2 = data17.getPermissions()) == null || (backgroundWork2 = permissions2.getBackgroundWork()) == null) ? null : backgroundWork2.getName();
        if (name9 == null) {
            name9 = "";
        }
        textView.setText(name9);
        TextView textView2 = binding.tvBackgroundWorkSubtitle;
        LocalizationLocalModel data18 = getLocalizationScreen().getData();
        if (data18 != null && (permissions = data18.getPermissions()) != null && (backgroundWork = permissions.getBackgroundWork()) != null) {
            explain = backgroundWork.getExplain();
        }
        textView2.setText(explain != null ? explain : "");
    }

    public PermissionsFragment() {
        super(R.layout.fragment_permissions);
        this.binding = new ViewBindingFragmentDelegate(this, PermissionsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$settingsViewModel$2
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
        this.instructionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InstructionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$instructionsViewModel$2
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
        this.lastRequestedPermission = "";
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PermissionsFragment.requestPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* compiled from: PermissionsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$trackAnalytics$1", f = "PermissionsFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$trackAnalytics$1, reason: invalid class name and case insensitive filesystem */
    static final class C26791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SettingsViewState $state;
        int label;
        final /* synthetic */ PermissionsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26791(SettingsViewState settingsViewState, PermissionsFragment permissionsFragment, Continuation<? super C26791> continuation) {
            super(2, continuation);
            this.$state = settingsViewState;
            this.this$0 = permissionsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26791(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SettingsViewState settingsViewState = this.$state;
            PermissionsFragment permissionsFragment = this.this$0;
            if (settingsViewState.getAppState().getBluetoothEnabled() && permissionsFragment.isBluetoothRequested) {
                permissionsFragment.isBluetoothRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionBluetoothOn());
                LogUtilsKt.writeLog("PermissionRequest: BLE REQUESTED AND GRANTED");
            }
            if (settingsViewState.getAppState().getGpsEnabled() && permissionsFragment.isGpsRequested) {
                permissionsFragment.isGpsRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionGPSOn());
                LogUtilsKt.writeLog("PermissionRequest: GPS REQUESTED AND GRANTED");
            }
            if (settingsViewState.getAppState().getBlePermissions().getNotificationsPermission().getGranted() && permissionsFragment.isNotificationPermissionRequested) {
                permissionsFragment.isNotificationPermissionRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionNotificationsOn());
                LogUtilsKt.writeLog("PermissionRequest: NOTIFICATION REQUESTED AND GRANTED");
            }
            if (settingsViewState.getAppState().getBlePermissions().getLocationPermission().getGranted() && permissionsFragment.isLocationPermissionRequested) {
                permissionsFragment.isLocationPermissionRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionLocationOn());
                LogUtilsKt.writeLog("PermissionRequest: LOCATION REQUESTED AND GRANTED");
            }
            if (settingsViewState.getAppState().getBlePermissions().getBackgroundLocationPermission().getGranted() && permissionsFragment.isBackgroundLocationPermissionRequested) {
                permissionsFragment.isBackgroundLocationPermissionRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionLocationOn());
                LogUtilsKt.writeLog("PermissionRequest: BACKGROUND LOCATION REQUESTED AND GRANTED");
            }
            if (settingsViewState.getAppState().getBlePermissions().getNearbyDevicesPermission().getGranted() && permissionsFragment.isNearbyDevicesPermissionRequested) {
                permissionsFragment.isNearbyDevicesPermissionRequested = false;
                permissionsFragment.getAnalytics().trackLogEvent(new PermissionsEvents.StatePermissionDeviceSearchOn());
                LogUtilsKt.writeLog("PermissionRequest: NEARBY REQUESTED AND GRANTED");
            }
            return Unit.INSTANCE;
        }
    }

    private final void trackAnalytics(SettingsViewState state) throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C26791(state, this, null), 1, null);
    }

    static /* synthetic */ void navigateToPermissionExplaining$default(PermissionsFragment permissionsFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        permissionsFragment.navigateToPermissionExplaining(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToPermissionExplaining(String permission, boolean needRequestPermission) {
        getSettingsViewModel().reloadPreferences();
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.action_permissionsFragment_to_bottomSheetPermissionExplaining, BundleKt.bundleOf(TuplesKt.to("item", permission), TuplesKt.to("need_request_permission", Boolean.valueOf(needRequestPermission))), null, 4, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        getBinding().btnOpenSystemSettings.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionsFragment.initViews$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3$lambda$2(PermissionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new PermissionsEvents.ClickSetupWorkInBackground());
        if (this$0.getInstructionsViewModel().getCurrentState().getInstructions().isEmpty()) {
            navigateToPermissionExplaining$default(this$0, "permission_background_work", false, 2, null);
        } else {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_permissionsFragment_to_fragmentBackgroundWork, null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPermission(String permission, Function1<? super Boolean, Unit> onNeedExplain) {
        this.lastRequestedPermission = permission;
        if (shouldShowRequestPermissionRationale(permission)) {
            getSettingsViewModel().reloadPreferences();
            onNeedExplain.invoke(Boolean.TRUE);
        } else {
            this.requestPermissionLauncher.launch(permission);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        PermissionsLocale permissions;
        TextTitle setupBackgroundWorkBtn;
        PermissionsLocale permissions2;
        TextTitle navigation;
        FragmentPermissionsBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        String title2 = (data == null || (permissions2 = data.getPermissions()) == null || (navigation = permissions2.getNavigation()) == null) ? null : navigation.getTitle();
        if (title2 == null) {
            title2 = "";
        }
        toolbar.setTitle(title2);
        AppCompatButton appCompatButton = binding.btnOpenSystemSettings;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (permissions = data2.getPermissions()) != null && (setupBackgroundWorkBtn = permissions.getSetupBackgroundWorkBtn()) != null) {
            title = setupBackgroundWorkBtn.getTitle();
        }
        appCompatButton.setText(title != null ? title : "");
    }
}
