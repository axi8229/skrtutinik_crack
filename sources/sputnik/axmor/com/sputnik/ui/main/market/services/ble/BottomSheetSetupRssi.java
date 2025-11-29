package sputnik.axmor.com.sputnik.ui.main.market.services.ble;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.huawei.hms.push.AttributionReporter;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.BleEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetSetupRssiBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;

/* compiled from: BottomSheetSetupRssi.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010/\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BottomSheetSetupRssi;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetSetupRssiBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "permission$delegate", "getPermission", "()Ljava/lang/String;", AttributionReporter.SYSTEM_PERMISSION, "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer;", "rssiDeterminer", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer;", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetSetupRssi extends BaseBottomSheetDialogFragment<BottomSheetSetupRssiBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: permission$delegate, reason: from kotlin metadata */
    private final Lazy permission;
    private RSSIDeterminer rssiDeterminer;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    public static final /* synthetic */ BottomSheetSetupRssiBinding access$getBinding(BottomSheetSetupRssi bottomSheetSetupRssi) {
        return bottomSheetSetupRssi.getBinding();
    }

    /* compiled from: BottomSheetSetupRssi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetSetupRssiBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetSetupRssiBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetSetupRssiBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetSetupRssiBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetSetupRssiBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetSetupRssiBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetSetupRssi() {
        super(AnonymousClass1.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$navController$2
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
        this.permission = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$permission$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("item");
                }
                return null;
            }
        });
        final Function0 function0 = null;
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$settingsViewModel$2
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

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
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
        setStyle(0, R.style.BottomSheet);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.rssiDeterminer = new RSSIDeterminer(contextRequireContext, 0, new C26711(), 2, null);
    }

    /* compiled from: BottomSheetSetupRssi.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"sputnik/axmor/com/sputnik/ui/main/market/services/ble/BottomSheetSetupRssi$onViewCreated$1", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$Listener;", "", "optimalRssi", "", "onAnalyzingCompleted", "(I)V", "left", "onTick", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    public static final class C26711 implements RSSIDeterminer.Listener {
        C26711() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0090 A[PHI: r9
  0x0090: PHI (r9v7 int) = (r9v1 int), (r9v2 int) binds: [B:18:0x008e, B:21:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0158  */
        @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAnalyzingCompleted(int r19) {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi.C26711.onAnalyzingCompleted(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnalyzingCompleted$lambda$1$lambda$0(BottomSheetSetupRssi this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
        }

        @Override // sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Listener
        public void onTick(int left) {
            LocalizationLocalModel data;
            BleLocale ble;
            BleLocale.SetupRssiBottomSheet setupRssiBottomSheet;
            BottomSheetSetupRssiBinding bottomSheetSetupRssiBindingAccess$getBinding = BottomSheetSetupRssi.access$getBinding(BottomSheetSetupRssi.this);
            BottomSheetSetupRssi bottomSheetSetupRssi = BottomSheetSetupRssi.this;
            if (left > 0) {
                ConstraintLayout layoutDetermining = bottomSheetSetupRssiBindingAccess$getBinding.layoutDetermining;
                Intrinsics.checkNotNullExpressionValue(layoutDetermining, "layoutDetermining");
                ViewKt.visible(layoutDetermining);
                AppCompatButton btnApply = BottomSheetSetupRssi.access$getBinding(bottomSheetSetupRssi).btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                ViewKt.disable(btnApply);
                TextView textView = BottomSheetSetupRssi.access$getBinding(bottomSheetSetupRssi).tvDeterminingTitle;
                LocalizationStorage localizationStorage = bottomSheetSetupRssi.getLocalizationStorage();
                String inProgress = (localizationStorage == null || (data = localizationStorage.getData()) == null || (ble = data.getBle()) == null || (setupRssiBottomSheet = ble.getSetupRssiBottomSheet()) == null) ? null : setupRssiBottomSheet.getInProgress();
                if (inProgress == null) {
                    inProgress = "";
                }
                textView.setText(inProgress);
                BottomSheetSetupRssi.access$getBinding(bottomSheetSetupRssi).tvSeconds.setText(String.valueOf(left));
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(BottomSheetSetupRssi.access$getBinding(bottomSheetSetupRssi).progress, "progress", 100 - (left * 10));
                objectAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
                objectAnimatorOfInt.start();
                return;
            }
            AppCompatButton btnApply2 = BottomSheetSetupRssi.access$getBinding(bottomSheetSetupRssi).btnApply;
            Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
            ViewKt.enable(btnApply2);
            ConstraintLayout layoutDetermining2 = bottomSheetSetupRssiBindingAccess$getBinding.layoutDetermining;
            Intrinsics.checkNotNullExpressionValue(layoutDetermining2, "layoutDetermining");
            ViewKt.gone(layoutDetermining2);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final BottomSheetSetupRssiBinding binding = getBinding();
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$initViews$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleSignalLevel2());
                ConstraintLayout layoutStatus = binding.layoutStatus;
                Intrinsics.checkNotNullExpressionValue(layoutStatus, "layoutStatus");
                ViewKt.gone(layoutStatus);
                RSSIDeterminer rSSIDeterminer = this.this$0.rssiDeterminer;
                if (rSSIDeterminer != null) {
                    rSSIDeterminer.startAnalyzing();
                }
            }
        }, 1, null);
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetSetupRssi.initViews$lambda$1$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1$lambda$0(BottomSheetSetupRssi this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new BleEvents.ClickBleExcellent());
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        RSSIDeterminer rSSIDeterminer = this.rssiDeterminer;
        if (rSSIDeterminer != null) {
            rSSIDeterminer.stopAnalyzing();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        LocalizationLocalModel data;
        BleLocale ble;
        BleLocale.SetupRssiBottomSheet setupRssiBottomSheet;
        BottomSheetSetupRssiBinding binding = getBinding();
        LocalizationStorage localizationStorage = getLocalizationStorage();
        if (localizationStorage == null || (data = localizationStorage.getData()) == null || (ble = data.getBle()) == null || (setupRssiBottomSheet = ble.getSetupRssiBottomSheet()) == null) {
            return;
        }
        TextView textView = binding.tvTitle;
        String title = setupRssiBottomSheet.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        TextView textView2 = binding.tvSubtitle;
        String subtitle = setupRssiBottomSheet.getSubtitle();
        if (subtitle == null) {
            subtitle = "";
        }
        textView2.setText(subtitle);
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle okButton = setupRssiBottomSheet.getOkButton();
        String title2 = okButton != null ? okButton.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        appCompatButton.setText(title2);
        AppCompatButton appCompatButton2 = binding.btnCancel;
        TextTitle cancelButton = setupRssiBottomSheet.getCancelButton();
        String title3 = cancelButton != null ? cancelButton.getTitle() : null;
        appCompatButton2.setText(title3 != null ? title3 : "");
    }
}
