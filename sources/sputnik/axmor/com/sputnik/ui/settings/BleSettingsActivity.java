package sputnik.axmor.com.sputnik.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.Slider;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.sputnik.common.base.BaseActivity;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.view.TextViewWithPoint;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.DebugToolsSettings;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ActivityBleBinding;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer;

/* compiled from: BleSettingsActivity.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\t038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/BleSettingsActivity;", "Lcom/sputnik/common/base/BaseActivity;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "state", "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", "", AttributionReporter.SYSTEM_PERMISSION, "requestPermission", "(Ljava/lang/String;)V", "getMessageForPermission", "(Ljava/lang/String;)Ljava/lang/String;", "", "rssiMin", "rssiMax", "recalculate", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "showInfoAboutRssi", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/ActivityBleBinding;", "_binding", "Lsputnik/axmor/com/databinding/ActivityBleBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "beaconServiceManager", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer;", "rssiDeterminer", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer;", "lastRequestedPermission", "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getBinding", "()Lsputnik/axmor/com/databinding/ActivityBleBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BleSettingsActivity extends BaseActivity {
    private ActivityBleBinding _binding;
    private BeaconServiceManager beaconServiceManager;
    public MultiViewModelFactory factory;
    private String lastRequestedPermission = "";
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda19
        @Override // androidx.view.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BleSettingsActivity.requestPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
        }
    });
    private RSSIDeterminer rssiDeterminer;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public BleSettingsActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityBleBinding getBinding() {
        ActivityBleBinding activityBleBinding = this._binding;
        Intrinsics.checkNotNull(activityBleBinding);
        return activityBleBinding;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$0(BleSettingsActivity this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reloadPreferences();
        if (z) {
            return;
        }
        this$0.getViewModel().notifySuccessMessage(this$0.getMessageForPermission(this$0.lastRequestedPermission));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        this._binding = ActivityBleBinding.inflate(getLayoutInflater());
        this.beaconServiceManager = BeaconServiceManager.INSTANCE.getInstance(this, null);
        setContentView(getBinding().getRoot());
        getViewModel().observeState(this, new AnonymousClass1(this));
        getViewModel().observeNotifications(this, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity.onCreate.2
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
                BleSettingsActivity bleSettingsActivity = BleSettingsActivity.this;
                ConstraintLayout root = bleSettingsActivity.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(bleSettingsActivity, root, it);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(null), 3, null);
        this.rssiDeterminer = new RSSIDeterminer(this, 0, new RSSIDeterminer.Listener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity.onCreate.4
            @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
            public void onAnalyzingCompleted(int optimalRssi) {
            }

            @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
            public void onTick(int i) {
                RSSIDeterminer.Listener.DefaultImpls.onTick(this, i);
            }
        }, 2, null);
        showInfoAboutRssi();
    }

    /* compiled from: BleSettingsActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$onCreate$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, BleSettingsActivity.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) {
            invoke2(settingsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BleSettingsActivity) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: BleSettingsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$onCreate$3", f = "BleSettingsActivity.kt", l = {72}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$onCreate$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BleSettingsActivity.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BleSettingsActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$onCreate$3$1", f = "BleSettingsActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$onCreate$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BleSettingsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BleSettingsActivity bleSettingsActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = bleSettingsActivity;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getViewModel().reloadPreferences();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BleSettingsActivity bleSettingsActivity = BleSettingsActivity.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(bleSettingsActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(bleSettingsActivity, state, anonymousClass1, this) == coroutine_suspended) {
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
    public final void renderUi(SettingsViewState state) {
        Boolean isBleServiceAvailable;
        ActivityBleBinding binding = getBinding();
        Button btnBluetooth = binding.btnBluetooth;
        Intrinsics.checkNotNullExpressionValue(btnBluetooth, "btnBluetooth");
        ViewBindingUtilsKt.visibilityBasedOn(btnBluetooth, Boolean.valueOf(!state.getAppState().getBluetoothEnabled()));
        TextViewWithPoint textViewWithPoint = binding.tvBluetooth;
        boolean bluetoothEnabled = state.getAppState().getBluetoothEnabled();
        int i = R.color.sputnik_red;
        textViewWithPoint.setPointColor(bluetoothEnabled ? R.color.sputnik_green : R.color.sputnik_red);
        Button btnGps = binding.btnGps;
        Intrinsics.checkNotNullExpressionValue(btnGps, "btnGps");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnGps, !state.getAppState().getGpsEnabled());
        TextViewWithPoint textViewWithPoint2 = binding.tvGps;
        if (state.getAppState().getBluetoothEnabled()) {
            i = R.color.sputnik_green;
        }
        textViewWithPoint2.setPointColor(i);
        Button btnWhiteList = binding.btnWhiteList;
        Intrinsics.checkNotNullExpressionValue(btnWhiteList, "btnWhiteList");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnWhiteList, !state.getAppState().getAppInWhiteList());
        BlePermissions blePermissions = state.getAppState().getBlePermissions();
        LinearLayout layoutBackgroundLocationPermission = binding.layoutBackgroundLocationPermission;
        Intrinsics.checkNotNullExpressionValue(layoutBackgroundLocationPermission, "layoutBackgroundLocationPermission");
        ViewBindingUtilsKt.visibilityBasedOn(layoutBackgroundLocationPermission, Boolean.valueOf(blePermissions.getBackgroundLocationPermission().getVisible()));
        LinearLayout layoutNearbyDevicesPermission = binding.layoutNearbyDevicesPermission;
        Intrinsics.checkNotNullExpressionValue(layoutNearbyDevicesPermission, "layoutNearbyDevicesPermission");
        ViewBindingUtilsKt.visibilityBasedOn(layoutNearbyDevicesPermission, Boolean.valueOf(blePermissions.getNearbyDevicesPermission().getVisible()));
        LinearLayout layoutLocationPermission = binding.layoutLocationPermission;
        Intrinsics.checkNotNullExpressionValue(layoutLocationPermission, "layoutLocationPermission");
        ViewBindingUtilsKt.visibilityBasedOn(layoutLocationPermission, Boolean.valueOf(blePermissions.getLocationPermission().getVisible()));
        LinearLayout layoutNotificationsPermission = binding.layoutNotificationsPermission;
        Intrinsics.checkNotNullExpressionValue(layoutNotificationsPermission, "layoutNotificationsPermission");
        ViewBindingUtilsKt.visibilityBasedOn(layoutNotificationsPermission, Boolean.valueOf(blePermissions.getNotificationsPermission().getVisible()));
        Button btnGpsPermission = binding.btnGpsPermission;
        Intrinsics.checkNotNullExpressionValue(btnGpsPermission, "btnGpsPermission");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnGpsPermission, !blePermissions.getLocationPermission().getGranted());
        Button btnBackgroundLocationPermission = binding.btnBackgroundLocationPermission;
        Intrinsics.checkNotNullExpressionValue(btnBackgroundLocationPermission, "btnBackgroundLocationPermission");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnBackgroundLocationPermission, !blePermissions.getBackgroundLocationPermission().getGranted());
        Button btnNearbyDevicesPermission = binding.btnNearbyDevicesPermission;
        Intrinsics.checkNotNullExpressionValue(btnNearbyDevicesPermission, "btnNearbyDevicesPermission");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnNearbyDevicesPermission, !blePermissions.getNearbyDevicesPermission().getGranted());
        Button btnNotificationsPermission = binding.btnNotificationsPermission;
        Intrinsics.checkNotNullExpressionValue(btnNotificationsPermission, "btnNotificationsPermission");
        ViewBindingUtilsKt.visibilityHideBasedOn(btnNotificationsPermission, !blePermissions.getNotificationsPermission().getGranted());
        CheckBox checkBox = binding.cbBleServiceAvailable;
        DebugToolsSettings debugToolsSettings = state.getDebugToolsSettings();
        checkBox.setChecked((debugToolsSettings == null || (isBleServiceAvailable = debugToolsSettings.getIsBleServiceAvailable()) == null) ? false : isBleServiceAvailable.booleanValue());
        binding.cbBleServiceAvailable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BleSettingsActivity.renderUi$lambda$4$lambda$3(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderUi$lambda$4$lambda$3(BleSettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PrefManager prefs = this$0.getViewModel().getPrefs();
        DebugToolsSettings debugToolsSettingsM2507getDebugToolsSettings = this$0.getViewModel().getPrefs().m2507getDebugToolsSettings();
        debugToolsSettingsM2507getDebugToolsSettings.setBleServiceAvailable(Boolean.valueOf(z));
        prefs.setDebugToolsSettings(debugToolsSettingsM2507getDebugToolsSettings);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final ActivityBleBinding binding = getBinding();
        binding.btnAnalyzeMax.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$5(this.f$0, view);
            }
        });
        binding.btnAnalyzeMin.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$6(this.f$0, view);
            }
        });
        binding.btnAnalyzeAll.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$7(this.f$0, view);
            }
        });
        binding.btnStartService.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$8(this.f$0, view);
            }
        });
        binding.btnStopService.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$9(this.f$0, view);
            }
        });
        Integer rssiOptimal = getViewModel().getAppSettings().getBleSettings().getRssiOptimal();
        float fIntValue = rssiOptimal != null ? rssiOptimal.intValue() : -120;
        binding.slider.setValue(fIntValue);
        binding.tvCurrentRssi.setText("Current RSSI: " + fIntValue);
        binding.slider.addOnChangeListener(new BaseOnChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda14
            @Override // com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                BleSettingsActivity.initViews$lambda$24$lambda$10(this.f$0, binding, slider, f, z);
            }
        });
        binding.btnBluetooth.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$12(this.f$0, view);
            }
        });
        binding.btnGps.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$13(this.f$0, view);
            }
        });
        binding.btnGpsPermission.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$14(this.f$0, view);
            }
        });
        binding.btnBackgroundLocationPermission.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$15(this.f$0, view);
            }
        });
        binding.btnNearbyDevicesPermission.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$16(this.f$0, view);
            }
        });
        binding.btnNotificationsPermission.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$17(this.f$0, view);
            }
        });
        binding.btnWhiteList.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$18(this.f$0, view);
            }
        });
        binding.btnBackgroundWork.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$19(this.f$0, view);
            }
        });
        binding.btnOpenSystemSettings.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$20(this.f$0, view);
            }
        });
        binding.btnNotifyMain.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$21(this.f$0, view);
            }
        });
        binding.btnNotifyNoPermissions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$22(this.f$0, view);
            }
        });
        binding.btnNotifyOpeningError.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BleSettingsActivity.initViews$lambda$24$lambda$23(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$5(final BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProgressBar pbAnalyzing = this$0.getBinding().pbAnalyzing;
        Intrinsics.checkNotNullExpressionValue(pbAnalyzing, "pbAnalyzing");
        ViewKt.visible(pbAnalyzing);
        this$0.getViewModel().notifySuccessMessage("Analyzing... Wait 10 seconds");
        RSSIDeterminer rSSIDeterminer = this$0.rssiDeterminer;
        if (rSSIDeterminer != null) {
            rSSIDeterminer.startAnalyzing(new RSSIDeterminer.Listener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$initViews$1$1$1
                @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
                public void onTick(int i) {
                    RSSIDeterminer.Listener.DefaultImpls.onTick(this, i);
                }

                @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
                public void onAnalyzingCompleted(int optimalRssi) {
                    this.this$0.recalculate(Integer.valueOf(optimalRssi), null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$6(final BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProgressBar pbAnalyzing = this$0.getBinding().pbAnalyzing;
        Intrinsics.checkNotNullExpressionValue(pbAnalyzing, "pbAnalyzing");
        ViewKt.visible(pbAnalyzing);
        this$0.getViewModel().notifySuccessMessage("Analyzing... Wait 10 seconds");
        RSSIDeterminer rSSIDeterminer = this$0.rssiDeterminer;
        if (rSSIDeterminer != null) {
            rSSIDeterminer.startAnalyzing(new RSSIDeterminer.Listener() { // from class: sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity$initViews$1$2$1
                @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
                public void onTick(int i) {
                    RSSIDeterminer.Listener.DefaultImpls.onTick(this, i);
                }

                @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
                public void onAnalyzingCompleted(int optimalRssi) {
                    this.this$0.recalculate(null, Integer.valueOf(optimalRssi));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$7(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsViewModel viewModel = this$0.getViewModel();
        RSSIDeterminer rSSIDeterminer = this$0.rssiDeterminer;
        viewModel.notifySuccessMessage("Optimal=" + (rSSIDeterminer != null ? Integer.valueOf(rSSIDeterminer.analyzeAll()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$8(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getViewModel().getCurrentState().getAppState().getBlePermissionsGranted()) {
            this$0.getViewModel().notifySuccessMessage("Невозможно запустить сервис без всех разрешений");
            return;
        }
        BeaconServiceManager beaconServiceManager = this$0.beaconServiceManager;
        if (beaconServiceManager != null) {
            beaconServiceManager.stopTracking();
        }
        BeaconServiceManager beaconServiceManager2 = this$0.beaconServiceManager;
        if (beaconServiceManager2 != null) {
            beaconServiceManager2.startTracking(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$9(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BeaconServiceManager beaconServiceManager = this$0.beaconServiceManager;
        if (beaconServiceManager != null) {
            beaconServiceManager.stopTracking();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$10(BleSettingsActivity this$0, ActivityBleBinding this_with, Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(slider, "slider");
        AppSettings appSettings = this$0.getViewModel().getPrefs().getAppSettings();
        BeaconServiceManager companion = BeaconServiceManager.INSTANCE.getInstance(this$0, null);
        RSSIDeterminer.Companion companion2 = RSSIDeterminer.INSTANCE;
        double d = f;
        companion.updateRssi(RSSIDeterminer.Companion.round$default(companion2, d, 0, 0, 0, 14, null));
        this$0.getViewModel().updateAppSettings(AppSettings.copy$default(appSettings, AppSettings.BleSettings.copy$default(appSettings.getBleSettings(), null, null, null, Integer.valueOf(RSSIDeterminer.Companion.round$default(companion2, d, 0, 0, 0, 14, null)), null, null, 55, null), null, 2, null));
        int i = (int) f;
        this_with.tvCurrentRssi.setText("Current RSSI: " + i);
        this$0.getViewModel().notifySuccessMessage("RSSI saved " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$12(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setAction("android.settings.BLUETOOTH_SETTINGS");
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$13(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$14(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$15(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestPermission(LocationConstant.BACKGROUND_PERMISSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$16(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestPermission("android.permission.BLUETOOTH_SCAN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$17(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestPermission("android.permission.POST_NOTIFICATIONS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$18(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IntentUtilsKt.openIgnoreBatteryOptimisationsSettings(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$19(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IntentUtilsKt.openSystemAppSettings(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$20(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IntentUtilsKt.openSystemAppSettings(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$21(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INotificationsManager.INSTANCE.getInstance(this$0).notifyPush(new PushMessage(4100, "Бесключевой доступ к домофону", "Функция “Бесключевой доступ” активна", PushMessage.Types.promo, null, null, 48, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$22(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INotificationsManager.INSTANCE.getInstance(this$0).notifyPush(new PushMessage(4102, "❗️Недостаточно разрешений", "Для работы функции “Бесключевой доступ” необходимо выдать недостающие разрешения", PushMessage.Types.promo, this$0.getString(R.string.deeplink_no_permissions), null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24$lambda$23(BleSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INotificationsManager.INSTANCE.getInstance(this$0).notifyPush(new PushMessage(4101, "🔑 Код 66666 для открытия двери 🔑", "Не смогли открыть дверь? Попробуйте воспользоваться кодом", PushMessage.Types.promo, this$0.getString(R.string.deeplink_emergency_code), null, 32, null));
    }

    private final void requestPermission(String permission) {
        this.lastRequestedPermission = permission;
        if (shouldShowRequestPermissionRationale(permission)) {
            this.requestPermissionLauncher.launch(permission);
        } else {
            this.requestPermissionLauncher.launch(permission);
        }
    }

    private final String getMessageForPermission(String permission) {
        int iHashCode = permission.hashCode();
        if (iHashCode != -1888586689) {
            if (iHashCode != 2024715147) {
                if (iHashCode == 2062356686 && permission.equals("android.permission.BLUETOOTH_SCAN")) {
                    return "Без разрешения на доступ к устройствам поблизости функция не будет работать";
                }
            } else if (permission.equals(LocationConstant.BACKGROUND_PERMISSION)) {
                return "Без полного разрешения на местоположение фукнция не будет работать";
            }
        } else if (permission.equals("android.permission.ACCESS_FINE_LOCATION")) {
            return "Без разрешения на местоположение фукнция не будет работать";
        }
        return "Не все разрешения предоставлены";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculate(Integer rssiMin, Integer rssiMax) {
        ProgressBar pbAnalyzing = getBinding().pbAnalyzing;
        Intrinsics.checkNotNullExpressionValue(pbAnalyzing, "pbAnalyzing");
        ViewKt.gone(pbAnalyzing);
        AppSettings appSettings = getViewModel().getPrefs().getAppSettings();
        getViewModel().updateAppSettings(AppSettings.copy$default(appSettings, AppSettings.BleSettings.copy$default(appSettings.getBleSettings(), null, rssiMin, null, null, null, null, 61, null), null, 2, null));
        AppSettings appSettings2 = getViewModel().getPrefs().getAppSettings();
        getViewModel().updateAppSettings(AppSettings.copy$default(appSettings2, AppSettings.BleSettings.copy$default(appSettings2.getBleSettings(), null, null, rssiMax, null, null, null, 59, null), null, 2, null));
        AppSettings.BleSettings bleSettings = getViewModel().getAppSettings().getBleSettings();
        if (bleSettings.getRssiMin() != null && bleSettings.getRssiMax() != null) {
            Integer rssiMin2 = bleSettings.getRssiMin();
            Intrinsics.checkNotNull(rssiMin2);
            int iIntValue = rssiMin2.intValue();
            Integer rssiMax2 = bleSettings.getRssiMax();
            Intrinsics.checkNotNull(rssiMax2);
            int iIntValue2 = (iIntValue + rssiMax2.intValue()) / 2;
            AppSettings appSettings3 = getViewModel().getPrefs().getAppSettings();
            getViewModel().updateAppSettings(AppSettings.copy$default(appSettings3, AppSettings.BleSettings.copy$default(appSettings3.getBleSettings(), null, null, null, Integer.valueOf(iIntValue2), null, null, 55, null), null, 2, null));
        }
        showInfoAboutRssi();
    }

    private final void showInfoAboutRssi() {
        AppSettings.BleSettings bleSettings = getViewModel().getPrefs().getAppSettings().getBleSettings();
        Integer rssiOptimal = bleSettings.getRssiOptimal();
        float fIntValue = rssiOptimal != null ? rssiOptimal.intValue() : -120;
        getBinding().tvRssi.setText("rssiMin=" + bleSettings.getRssiMin() + " | rssiMax=" + bleSettings.getRssiMax() + " | optimal=" + fIntValue);
        TextView textView = getBinding().tvCurrentRssi;
        StringBuilder sb = new StringBuilder();
        sb.append("Current RSSI: ");
        sb.append(fIntValue);
        textView.setText(sb.toString());
    }
}
