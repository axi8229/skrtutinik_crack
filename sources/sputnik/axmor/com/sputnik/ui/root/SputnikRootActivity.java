package sputnik.axmor.com.sputnik.ui.root;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.common.StaticVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.entities.localization.InternetErrorLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.TextSubtitle;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.Service;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.extensions.ActivityExtensionsKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.StateViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SputnikActivityRootBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;
import sputnik.axmor.com.sputnik.core.push.IPushManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.call.CallActivity;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: SputnikRootActivity.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u0003R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010<\u001a\u0004\bP\u0010>R\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020W8\u0002X\u0082D¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082D¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020Z8\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010\\R\u0014\u0010^\u001a\u00020Z8\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010\\R\u001d\u0010c\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010<\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/root/SputnikRootActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "handlePromotionNavigation", "listenForInternetConnectivity", "setNoInternetState", "setNormalState", "localize", "listenNavController", "showDebugTools", "hideDebugTools", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "onStop", "outState", "onSaveInstanceState", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onNewIntent", "(Landroid/content/Intent;)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDestroy", "changeOrientation", "Lsputnik/axmor/com/databinding/SputnikActivityRootBinding;", "binding", "Lsputnik/axmor/com/databinding/SputnikActivityRootBinding;", "isInternetConnected", "Z", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/StateViewModel;", "stateViewModel$delegate", "getStateViewModel", "()Lcom/sputnik/common/viewmodels/StateViewModel;", "stateViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "settingsViewModel$delegate", "getSettingsViewModel", "settingsViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "", "notificationId", "I", "", "notificationChannelId", "Ljava/lang/String;", "notificationChannelName", "notificationChannelDescription", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "", "collapseAppTimestamp", "J", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SputnikRootActivity extends AppCompatActivity {
    private static boolean isChangingOrientation;
    private static boolean isControllerInitialized;
    private static boolean needGoToSplash;
    public Analytics analytics;
    private SputnikActivityRootBinding binding;
    private long collapseAppTimestamp;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    /* renamed from: stateViewModel$delegate, reason: from kotlin metadata */
    private final Lazy stateViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isSplashInAppEnabled = true;
    private boolean isInternetConnected = true;
    private final int notificationId = 666;
    private final String notificationChannelId = "tools";
    private final String notificationChannelName = "Debug tools";
    private final String notificationChannelDescription = "Need description for it?";

    /* renamed from: connectivityManager$delegate, reason: from kotlin metadata */
    private final Lazy connectivityManager = LazyKt.lazy(new Function0<ConnectivityManager>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$connectivityManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityManager invoke() {
            try {
                Object systemService = this.this$0.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                return (ConnectivityManager) systemService;
            } catch (Exception unused) {
                return null;
            }
        }
    });
    private final ConnectivityManager.NetworkCallback networkCallback = new SputnikRootActivity$networkCallback$1(this);

    private final void hideDebugTools() {
    }

    private final void showDebugTools() {
    }

    public SputnikRootActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$3
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
        this.stateViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(StateViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$stateViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$6
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
        this.navigationViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$9
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
        this.profileViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$11
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$12
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
        this.settingsViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$14
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$15
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
        this.subscriptionsViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$17
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$special$$inlined$viewModels$default$18
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

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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
    public final StateViewModel getStateViewModel() {
        return (StateViewModel) this.stateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeMain);
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        SputnikActivityRootBinding sputnikActivityRootBindingInflate = SputnikActivityRootBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(sputnikActivityRootBindingInflate, "inflate(...)");
        this.binding = sputnikActivityRootBindingInflate;
        if (sputnikActivityRootBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sputnikActivityRootBindingInflate = null;
        }
        FrameLayout root = sputnikActivityRootBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        setContentView(root);
        AppCompatDelegate.setDefaultNightMode(1);
        boolean z = savedInstanceState != null ? savedInstanceState.getBoolean("state") : true;
        this.isInternetConnected = z;
        if (!z) {
            setNoInternetState();
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        localize();
        listenForInternetConnectivity();
        listenNavController();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
        getNavigationViewModel().observeSubState(this, new Function1<NavigationViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity.onCreate.2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(NavigationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedClearActivityIntent());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity.onCreate.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    ActivityExtensionsKt.clearIntentExtras(SputnikRootActivity.this);
                }
            }
        });
        getProfileViewModel().observeState(this, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity.onCreate.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getIsAppLoaded()) {
                    Intent intent = SputnikRootActivity.this.getIntent();
                    SputnikRootActivity sputnikRootActivity = SputnikRootActivity.this;
                    IntentProcessingUtilsKt.handleIntent$default(intent, sputnikRootActivity, sputnikRootActivity.getNavigationViewModel(), null, SputnikRootActivity.this.getAnalytics(), SputnikRootActivity.this.getProfileViewModel(), 8, null);
                    ActivityExtensionsKt.clearIntentExtras(SputnikRootActivity.this);
                }
            }
        });
    }

    /* compiled from: SputnikRootActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$onCreate$1", f = "SputnikRootActivity.kt", l = {159}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$onCreate$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SputnikRootActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SputnikRootActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$onCreate$1$1", f = "SputnikRootActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SputnikRootActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03711(SputnikRootActivity sputnikRootActivity, Continuation<? super C03711> continuation) {
                super(2, continuation);
                this.this$0 = sputnikRootActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03711(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.handlePromotionNavigation();
                    if (this.this$0.getProfileViewModel().getIsLoggedIn() && !this.this$0.getProfileViewModel().getIsInDemoMode()) {
                        this.this$0.getSettingsViewModel().reloadPreferences();
                        this.this$0.handlePromotionNavigation();
                    }
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
                SputnikRootActivity sputnikRootActivity = SputnikRootActivity.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                C03711 c03711 = new C03711(sputnikRootActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(sputnikRootActivity, state, c03711, this) == coroutine_suspended) {
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
    public final void handlePromotionNavigation() {
        List<BaseSubscription> subscriptions;
        BaseSubscription baseSubscription;
        Service service;
        NavDestination currentDestination;
        DetailedLayout detailedLayout;
        IncludedServices includedServices;
        List<Service> services;
        Object next;
        if (getSubscriptionsViewModel().getCurrentState().getNeedShowButtonPromo() && StaticVariables.INSTANCE.getNavigationClickMethod() != null && (subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions()) != null && (baseSubscription = (BaseSubscription) CollectionsKt.firstOrNull((List) subscriptions)) != null) {
            SubscriptionAppearance appearance = baseSubscription.getAppearance();
            if (appearance == null || (detailedLayout = appearance.getDetailedLayout()) == null || (includedServices = detailedLayout.getIncludedServices()) == null || (services = includedServices.getServices()) == null) {
                service = null;
            } else {
                Iterator<T> it = services.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), "accelerated_loading")) {
                            break;
                        }
                    }
                }
                service = (Service) next;
            }
            if (service != null) {
                NavController navControllerFindNavController = ActivityKt.findNavController(this, R.id.root_nav_host_fragment);
                Integer numValueOf = (navControllerFindNavController == null || (currentDestination = navControllerFindNavController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination.getId());
                ArrayList arrayList = new ArrayList();
                if ((numValueOf == null || numValueOf.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf == null || numValueOf.intValue() != R.id.bottomSheetAboutService)) {
                    arrayList.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", "accelerated_loading")), null, 8, null));
                }
                if (numValueOf != null && numValueOf.intValue() == R.id.fragmentSubscriptionDetails) {
                    arrayList.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", "accelerated_loading")), NavigationTypes.custom));
                }
                StaticVariables.INSTANCE.setNavigationClickMethod(null);
                getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList)), false, 4, null));
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        showDebugTools();
        SputnikApp.Companion companion = SputnikApp.INSTANCE;
        if (companion.getCallState().getInCallStateNow()) {
            Intent intent = new Intent(this, (Class<?>) CallActivity.class);
            intent.putExtra("sputnik.axmor.com.sputnik.global.call_id", companion.getCallState().getCallId());
            intent.putExtra("sputnik.axmor.com.sputnik.global.uuid", companion.getCallState().getCallUuid());
            intent.putExtra("call.flat_uuid", companion.getCallState().getFlatUuid());
            startActivity(intent);
            return;
        }
        if (needGoToSplash && !isChangingOrientation && isSplashInAppEnabled && !StaticVariables.INSTANCE.getCustomScenarioEnabled() && System.currentTimeMillis() - this.collapseAppTimestamp > DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
            startActivity(new Intent(this, (Class<?>) CustomEmptySplashActivity.class));
        }
        isChangingOrientation = false;
        StaticVariables.INSTANCE.setCustomScenarioEnabled(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.collapseAppTimestamp = System.currentTimeMillis();
        if (getProfileViewModel().haveSubscription() || !getProfileViewModel().getIsLoggedIn()) {
            return;
        }
        needGoToSplash = true;
    }

    private final void listenForInternetConnectivity() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager != null) {
            connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean("state", this.isInternetConnected);
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNoInternetState() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SputnikRootActivity.setNoInternetState$lambda$4(this.f$0);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNoInternetState$lambda$4(SputnikRootActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SputnikActivityRootBinding sputnikActivityRootBinding = this$0.binding;
        if (sputnikActivityRootBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sputnikActivityRootBinding = null;
        }
        FrameLayout noInternet = sputnikActivityRootBinding.noInternet;
        Intrinsics.checkNotNullExpressionValue(noInternet, "noInternet");
        ViewKt.visible(noInternet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNormalState() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SputnikRootActivity.setNormalState$lambda$5(this.f$0);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNormalState$lambda$5(SputnikRootActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SputnikActivityRootBinding sputnikActivityRootBinding = this$0.binding;
        if (sputnikActivityRootBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sputnikActivityRootBinding = null;
        }
        FrameLayout noInternet = sputnikActivityRootBinding.noInternet;
        Intrinsics.checkNotNullExpressionValue(noInternet, "noInternet");
        ViewKt.gone(noInternet);
    }

    private final void localize() {
        InternetErrorLocale internetError;
        TextSubtitle body;
        SputnikActivityRootBinding sputnikActivityRootBinding = this.binding;
        if (sputnikActivityRootBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sputnikActivityRootBinding = null;
        }
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (internetError = data.getInternetError()) == null || (body = internetError.getBody()) == null) {
            return;
        }
        sputnikActivityRootBinding.tvTitle.setText(body.getTitle());
        String subtitle = body.getSubtitle();
        if (subtitle != null) {
            sputnikActivityRootBinding.tvSubtitle.setText(subtitle);
        }
    }

    private final void listenNavController() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.root_nav_host_fragment);
        if (isControllerInitialized) {
            return;
        }
        isControllerInitialized = true;
        Intrinsics.checkNotNull(navHostFragment);
        navHostFragment.getNavController().addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$$ExternalSyntheticLambda0
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                SputnikRootActivity.listenNavController$lambda$10(this.f$0, navController, navDestination, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenNavController$lambda$10(SputnikRootActivity this$0, NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        SputnikActivityRootBinding sputnikActivityRootBinding = null;
        Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
        if ((numValueOf != null && numValueOf.intValue() == R.id.new_registration_navigation) || ((numValueOf != null && numValueOf.intValue() == R.id.onboarding_navigation) || (numValueOf != null && numValueOf.intValue() == R.id.first_sign_navigation))) {
            SputnikActivityRootBinding sputnikActivityRootBinding2 = this$0.binding;
            if (sputnikActivityRootBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                sputnikActivityRootBinding = sputnikActivityRootBinding2;
            }
            sputnikActivityRootBinding.getRoot().setBackgroundResource(R.drawable.background_splash_screen);
            return;
        }
        SputnikActivityRootBinding sputnikActivityRootBinding3 = this$0.binding;
        if (sputnikActivityRootBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            sputnikActivityRootBinding = sputnikActivityRootBinding3;
        }
        sputnikActivityRootBinding.getRoot().setBackgroundColor(ContextCompat.getColor(this$0, android.R.color.transparent));
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        IntentProcessingUtilsKt.handleIntent$default(intent, this, getNavigationViewModel(), null, getAnalytics(), getProfileViewModel(), 8, null);
        ActivityExtensionsKt.clearIntentExtras(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        View currentFocus;
        Intrinsics.checkNotNullParameter(event, "event");
        View currentFocus2 = getCurrentFocus();
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(event);
        if ((currentFocus2 instanceof EditText) && (currentFocus = getCurrentFocus()) != null) {
            currentFocus.getLocationOnScreen(new int[2]);
            float rawX = (event.getRawX() + currentFocus.getLeft()) - r2[0];
            float rawY = (event.getRawY() + currentFocus.getTop()) - r2[1];
            if (event.getAction() == 1 && (rawX < currentFocus.getLeft() || rawX >= currentFocus.getRight() || rawY < currentFocus.getTop() || rawY > currentFocus.getBottom())) {
                Object systemService = getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                View currentFocus3 = getWindow().getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus3);
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus3.getWindowToken(), 0);
            }
        }
        return zDispatchTouchEvent;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        hideDebugTools();
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager != null) {
            connectivityManager.unregisterNetworkCallback(this.networkCallback);
        }
        IPushManager.INSTANCE.clearInstance();
        INotificationsManager.INSTANCE.clearInstance();
        super.onDestroy();
    }

    public final void changeOrientation() {
        isChangingOrientation = true;
        if (GlobalCamerasFragment.INSTANCE.isPortrait()) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* compiled from: SputnikRootActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/root/SputnikRootActivity$Companion;", "", "<init>", "()V", "", "needGoToSplash", "Z", "getNeedGoToSplash", "()Z", "setNeedGoToSplash", "(Z)V", "isSplashInAppEnabled", "setSplashInAppEnabled", "isChangingOrientation", "setChangingOrientation", "isControllerInitialized", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setNeedGoToSplash(boolean z) {
            SputnikRootActivity.needGoToSplash = z;
        }

        public final void setSplashInAppEnabled(boolean z) {
            SputnikRootActivity.isSplashInAppEnabled = z;
        }

        public final void setChangingOrientation(boolean z) {
            SputnikRootActivity.isChangingOrientation = z;
        }
    }
}
