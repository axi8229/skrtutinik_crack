package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.target.Target;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CamerasBody;
import com.sputnik.common.entities.localization.CamerasLocale;
import com.sputnik.common.entities.localization.CamerasStream;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.ToggleStateButton;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.data.entities.cameras.CameraPreferences;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.EventsSettings;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.domain.usecases.issues.IssueTypes;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.GlobalCameraFragmentBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.manager.PlayersManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel;
import sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewState;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.views.ZoomOnDoubleTapListener;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: GlobalCameraFragment.kt */
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001h\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010F\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010F\u001a\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010F\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010F\u001a\u0004\be\u0010fR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010F\u001a\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006w"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "showErrorLoadCamera", "observeZoom", "loadImage", "reloadStreamWithDelay", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onDetach", "Lsputnik/axmor/com/databinding/GlobalCameraFragmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/GlobalCameraFragmentBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel$delegate", "Lkotlin/Lazy;", "getCameraViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewModel;", "eventViewModel$delegate", "getEventViewModel", "()Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewModel;", "eventViewModel", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "sputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment$exoPlayerListener$1", "exoPlayerListener", "Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment$exoPlayerListener$1;", "Lcom/sputnik/common/entities/camera/Camera;", "camera$delegate", "getCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "camera", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "playersManager", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "playersCallback", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalCameraFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GlobalCameraFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/GlobalCameraFragmentBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SimpleExoPlayer player;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camera$delegate, reason: from kotlin metadata */
    private final Lazy camera;

    /* renamed from: cameraViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cameraViewModel;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: eventViewModel$delegate, reason: from kotlin metadata */
    private final Lazy eventViewModel;
    private final GlobalCameraFragment$exoPlayerListener$1 exoPlayerListener;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private final PlayersCallback playersCallback;
    private PlayersManager playersManager;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final GlobalCameraFragmentBinding getBinding() {
        return (GlobalCameraFragmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
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
    public final AllCamerasViewModel getCameraViewModel() {
        return (AllCamerasViewModel) this.cameraViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventViewModel getEventViewModel() {
        return (EventViewModel) this.eventViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorLoadCamera() {
        SputnikApp.INSTANCE.getAnalyticsService().send("myCameras", "play_video", "failed");
        getCameraViewModel().handleLoading(false);
        try {
            getEventViewModel().reportNoCamera(getCamera().getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getView() != null) {
            GlobalCameraFragmentBinding binding = getBinding();
            LinearLayout previewError = binding.previewError;
            Intrinsics.checkNotNullExpressionValue(previewError, "previewError");
            ViewKt.visible(previewError);
            LinearLayout videoLoader = binding.videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            ViewKt.gone(videoLoader);
            binding.tvError.setText("Видео недоступно :(");
            TextView textView = binding.tvErrorSubtitle;
            if (textView == null) {
                return;
            }
            textView.setText("Проверьте настройки или сообщите нам о проблеме для скорейшего устранения");
        }
    }

    public GlobalCameraFragment() {
        super(R.layout.global_camera_fragment);
        this.binding = new ViewBindingFragmentDelegate(this, GlobalCameraFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.cameraViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$cameraViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$navController$2
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
        this.eventViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EventViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$eventViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.exoPlayerListener = new GlobalCameraFragment$exoPlayerListener$1(this);
        this.camera = LazyKt.lazy(new Function0<Camera>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$camera$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Camera invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("ui.main.cameras.camera") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.sputnik.common.entities.camera.Camera");
                return (Camera) obj;
            }
        });
        this.playersManager = new PlayersManager();
        this.playersCallback = new GlobalCameraFragment$playersCallback$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Camera getCamera() {
        return (Camera) this.camera.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Intrinsics.areEqual(getCamera().getSubscriptionRequried(), Boolean.TRUE)) {
            LinearLayout videoLoader = getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            ViewKt.gone(videoLoader);
            loadImage();
        }
        getBinding().layoutZoom.setMaxScale(12.0f);
        ZoomLayout zoomLayout = getBinding().layoutZoom2;
        if (zoomLayout != null) {
            zoomLayout.setMaxScale(12.0f);
        }
        getBinding().layoutZoom.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        ZoomLayout zoomLayout2 = getBinding().layoutZoom2;
        if (zoomLayout2 != null) {
            zoomLayout2.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        }
        getBinding().layoutZoom.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.onViewCreated.1
            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoom(ZoomLayout view2, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomBegin(ZoomLayout view2, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomEnd(ZoomLayout view2, float scale) {
                GlobalCameraFragment.this.getSettingsViewModel().saveCameraPreference(new CameraPreferences(GlobalCameraFragment.this.getCamera().getUuid(), scale, view2 != null ? view2.getPosX() : 0.0f, view2 != null ? view2.getPosY() : 0.0f));
            }
        });
        ZoomLayout zoomLayout3 = getBinding().layoutZoom2;
        if (zoomLayout3 != null) {
            zoomLayout3.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.onViewCreated.2
                @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
                public void onZoom(ZoomLayout view2, float scale) {
                }

                @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
                public void onZoomBegin(ZoomLayout view2, float scale) {
                }

                @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
                public void onZoomEnd(ZoomLayout view2, float scale) {
                    GlobalCameraFragment.this.getSettingsViewModel().saveCameraPreference(new CameraPreferences(GlobalCameraFragment.this.getCamera().getUuid(), scale, view2 != null ? view2.getPosX() : 0.0f, view2 != null ? view2.getPosY() : 0.0f));
                }
            });
        }
        try {
            getBinding().layoutZoom.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GlobalCameraFragment.onViewCreated$lambda$9$lambda$5(view, this);
                }
            });
            ZoomLayout zoomLayout4 = getBinding().layoutZoom2;
            if (zoomLayout4 != null) {
                zoomLayout4.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GlobalCameraFragment.onViewCreated$lambda$9$lambda$8(view, this);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        observeZoom();
        EventViewModel eventViewModel = getEventViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        eventViewModel.observeState(viewLifecycleOwner, new Function1<EventViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventViewState eventViewState) {
                invoke2(eventViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                EventsSettings eventsSettings = state.getEventsSettings();
                if (eventsSettings != null) {
                    GlobalCameraFragment globalCameraFragment = GlobalCameraFragment.this;
                    if (System.currentTimeMillis() - eventsSettings.getLastClick(globalCameraFragment.getPrefManager().getPhone(), IssueTypes.video.toString(), globalCameraFragment.getCamera().getUuid()) < 86400000) {
                        TextView textView = globalCameraFragment.getBinding().tvCompanyContactsInfo;
                        if (textView != null) {
                            Intrinsics.checkNotNull(textView);
                            ViewKt.visible(textView);
                        }
                        ToggleStateButton toggleStateButton = globalCameraFragment.getBinding().btnReport;
                        if (toggleStateButton != null) {
                            toggleStateButton.lockState(false);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$5(View view, GlobalCameraFragment this$0) {
        CameraPreferences cameraPreferencesByCameraUuid;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAdded() || this$0.getParentFragmentManager().isDestroyed() || (cameraPreferencesByCameraUuid = this$0.getSettingsViewModel().getCameraPreferencesByCameraUuid(this$0.getCamera().getUuid())) == null) {
            return;
        }
        this$0.getBinding().layoutZoom.setScale(cameraPreferencesByCameraUuid.getScale(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$8(View view, GlobalCameraFragment this$0) {
        CameraPreferences cameraPreferencesByCameraUuid;
        ZoomLayout zoomLayout;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAdded() || this$0.getParentFragmentManager().isDestroyed() || (cameraPreferencesByCameraUuid = this$0.getSettingsViewModel().getCameraPreferencesByCameraUuid(this$0.getCamera().getUuid())) == null || (zoomLayout = this$0.getBinding().layoutZoom2) == null) {
            return;
        }
        zoomLayout.setScale(cameraPreferencesByCameraUuid.getScale(), false);
    }

    private final void observeZoom() {
        getCameraViewModel().handleZoomMode(false);
        AllCamerasViewModel cameraViewModel = getCameraViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        cameraViewModel.observeSubState(viewLifecycleOwner, new Function1<AllCamerasViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.observeZoom.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getZoomMode());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.observeZoom.2
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String locked;
        LocalizationLocalModel data;
        CamerasLocale cameraList;
        CamerasBody body;
        CamerasLocale cameraList2;
        CamerasStream stream;
        TextTitle loader;
        String title;
        GlobalCameraFragmentBinding binding = getBinding();
        TextView textView = binding.tvCompanyContactsInfo;
        if (textView != null) {
            textView.setText("Срок решения проблемы обычно составляет один рабочий день ");
        }
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (cameraList2 = data2.getCameraList()) != null && (stream = cameraList2.getStream()) != null && (loader = stream.getLoader()) != null && (title = loader.getTitle()) != null) {
            binding.tvLoader.setText(title);
        }
        TextView textView2 = binding.tvSubscriptionRequired;
        if (textView2 == null) {
            return;
        }
        LocalizationStorage localizationScreen = getLocalizationScreen();
        if (localizationScreen == null || (data = localizationScreen.getData()) == null || (cameraList = data.getCameraList()) == null || (body = cameraList.getBody()) == null || (locked = body.getLocked()) == null) {
            locked = "";
        }
        textView2.setText(locked);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final GlobalCameraFragmentBinding binding = getBinding();
        ToggleStateButton toggleStateButton = binding.btnCameraSettings;
        if (toggleStateButton != null) {
            toggleStateButton.setFirstState("Проверить настройки", R.drawable.ic_settings_outline, R.drawable.background_button_white_12, R.color.large_text, R.color.sputnik_header_black);
        }
        ToggleStateButton toggleStateButton2 = binding.btnCameraSettings;
        if (toggleStateButton2 != null) {
            toggleStateButton2.setSecondState("Проверить настройки", R.drawable.ic_settings_outline, R.drawable.background_button_white_12, R.color.large_text, R.color.sputnik_header_black);
        }
        ToggleStateButton toggleStateButton3 = binding.btnReport;
        if (toggleStateButton3 != null) {
            toggleStateButton3.setFirstState("Сообщить о проблеме", R.drawable.ic_alert_outline, R.drawable.background_button_pink_12, R.color.white, R.color.white);
        }
        ToggleStateButton toggleStateButton4 = binding.btnReport;
        if (toggleStateButton4 != null) {
            toggleStateButton4.setSecondState("Мы получили ваше обращение", R.drawable.ic_checkmark_outline_green, R.drawable.background_button_transparent_12, R.color.white, R.color.sputnik_green);
        }
        ToggleStateButton toggleStateButton5 = binding.btnReport;
        if (toggleStateButton5 != null) {
            toggleStateButton5.setOnToggleListener(new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$initViews$1$1
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
                        this.this$0.getEventViewModel().reportNoVideoIssue(this.this$0.getCamera().getUuid());
                        ToggleStateButton toggleStateButton6 = binding.btnReport;
                        if (toggleStateButton6 != null) {
                            toggleStateButton6.lockState(false);
                        }
                    }
                }
            });
        }
        ToggleStateButton toggleStateButton6 = binding.btnCameraSettings;
        if (toggleStateButton6 != null) {
            Intrinsics.checkNotNull(toggleStateButton6);
            SafeClickListenerKt.setSafeOnClickListener$default(toggleStateButton6, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$initViews$1$2
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
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_mainHostFragment_to_intercomSettingsFragment, null, null, 6, null);
                }
            }, 1, null);
        }
        LinearLayout linearLayout = binding.layoutCameraLocked;
        if (linearLayout != null) {
            Intrinsics.checkNotNull(linearLayout);
            ViewBindingUtilsKt.visibilityBasedOn(linearLayout, Boolean.valueOf(Intrinsics.areEqual(getCamera().getSubscriptionRequried(), Boolean.TRUE)));
        }
        View view = binding.viewDimSubscriptionRequired;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            ViewBindingUtilsKt.visibilityBasedOn(view, Boolean.valueOf(Intrinsics.areEqual(getCamera().getSubscriptionRequried(), Boolean.TRUE)));
        }
        AppCompatButton appCompatButton = binding.btnSubscribe;
        if (appCompatButton != null) {
            Intrinsics.checkNotNull(appCompatButton);
            SafeClickListenerKt.setSafeOnClickListener$default(appCompatButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$initViews$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    IntentProcessingUtilsKt.handleDeeplink(this.this$0.getString(R.string.deeplink_market_feature_extra_cameras), BundleKt.bundleOf(), this.this$0.getActivity(), this.this$0.getNavigationViewModel(), this.this$0.getProfileViewModel(), (64 & 32) != 0 ? null : null, (64 & 64) != 0 ? null : null);
                }
            }, 1, null);
        }
    }

    private final void loadImage() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageRequest imageRequestBuild = new ImageRequest.Builder(contextRequireContext).data(getCamera().getPreviewUrl()).target(new Target(this) { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$loadImage$$inlined$target$default$1
            @Override // coil.target.Target
            public void onStart(Drawable placeholder) {
            }

            @Override // coil.target.Target
            public void onError(Drawable error) {
                SimpleExoPlayer simpleExoPlayer;
                Log.e("camera error", String.valueOf(error));
                String uuid = this.this$0.getCamera().getUuid();
                Camera currentCamera = this.this$0.getCameraViewModel().getCurrentState().getCurrentCamera();
                if (Intrinsics.areEqual(uuid, currentCamera != null ? currentCamera.getUuid() : null) && ((simpleExoPlayer = GlobalCameraFragment.player) == null || !simpleExoPlayer.isPlaying())) {
                    this.this$0.getCameraViewModel().handleLoading(true);
                }
                this.this$0.getCamera().setLoadPhotoFailed(true);
                if (this.this$0.getCamera().getIsLoadVideoFailed()) {
                    this.this$0.showErrorLoadCamera();
                }
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable result) {
                if (this.this$0.getView() != null) {
                    this.this$0.getBinding().preview.setImageDrawable(result);
                    this.this$0.getCameraViewModel().handleLoading(false);
                    this.this$0.getCamera().setLoadPhotoFailed(false);
                    LinearLayout videoLoader = this.this$0.getBinding().videoLoader;
                    Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
                    ViewKt.gone(videoLoader);
                    HorizontalScrollView horizontalScrollView = this.this$0.getBinding().hsPreview;
                    final GlobalCameraFragment globalCameraFragment = this.this$0;
                    horizontalScrollView.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$loadImage$request$2$1$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (globalCameraFragment.getView() != null) {
                                GlobalCameraFragment globalCameraFragment2 = globalCameraFragment;
                                globalCameraFragment2.getBinding().hsPreview.scrollTo(globalCameraFragment2.getBinding().preview.getWidth() / 3, 0);
                            }
                        }
                    });
                }
            }
        }).build();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        new ImageLoader.Builder(contextRequireContext2).build().enqueue(imageRequestBuild);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* compiled from: GlobalCameraFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$reloadStreamWithDelay$1", f = "GlobalCameraFragment.kt", l = {506}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$reloadStreamWithDelay$1, reason: invalid class name and case insensitive filesystem */
    static final class C26581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C26581(Continuation<? super C26581> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlobalCameraFragment.this.new C26581(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(DeviceOrientationRequest.OUTPUT_PERIOD_FAST, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LinearLayout previewError = GlobalCameraFragment.this.getBinding().previewError;
            Intrinsics.checkNotNullExpressionValue(previewError, "previewError");
            ViewKt.gone(previewError);
            LinearLayout videoLoader = GlobalCameraFragment.this.getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            ViewKt.visible(videoLoader);
            PlayersManager playersManager = GlobalCameraFragment.this.playersManager;
            String strValueOf = String.valueOf(GlobalCameraFragment.this.getCamera().getStreamUrl());
            Lifecycle lifecycle = GlobalCameraFragment.this.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            FragmentActivity fragmentActivityRequireActivity = GlobalCameraFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            PlayerView playerView = GlobalCameraFragment.this.getBinding().playerExo;
            SurfaceViewRenderer playerWebrtc = GlobalCameraFragment.this.getBinding().playerWebrtc;
            Intrinsics.checkNotNullExpressionValue(playerWebrtc, "playerWebrtc");
            LinearLayout videoLoader2 = GlobalCameraFragment.this.getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader2, "videoLoader");
            PlayersCallback playersCallback = GlobalCameraFragment.this.playersCallback;
            Analytics analytics = GlobalCameraFragment.this.getAnalytics();
            Boolean webrtcEnabled = GlobalCameraFragment.this.getPrefManager().getExperimentalSettings().getWebrtcEnabled();
            playersManager.play(strValueOf, lifecycle, fragmentActivityRequireActivity, playerView, playerWebrtc, videoLoader2, playersCallback, analytics, webrtcEnabled != null ? webrtcEnabled.booleanValue() : true);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadStreamWithDelay() {
        BuildersKt__Builders_commonKt.launch$default(getMainCoroutineScope(), null, null, new C26581(null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        BaseSubscription baseSubscription;
        SubscriptionAppearance appearance;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        SubscriptionAppearance appearance2;
        SubscriptionBuyLocale subscriptionBuy2;
        SubscriptionBuyBody body2;
        TextTitle buyButton2;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Plan plan;
        SubscriptionDetails subscriptionDetails2;
        List<Plan> plans2;
        Plan plan2;
        Plan.Promo promo;
        Object next;
        super.onResume();
        if (Intrinsics.areEqual(getCamera().getSubscriptionRequried(), Boolean.FALSE) || getCamera().getSubscriptionRequried() == null) {
            PlayersManager playersManager = this.playersManager;
            String strValueOf = String.valueOf(getCamera().getStreamUrl());
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            PlayerView playerView = getBinding().playerExo;
            SurfaceViewRenderer playerWebrtc = getBinding().playerWebrtc;
            Intrinsics.checkNotNullExpressionValue(playerWebrtc, "playerWebrtc");
            LinearLayout videoLoader = getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            PlayersCallback playersCallback = this.playersCallback;
            Analytics analytics = getAnalytics();
            Boolean webrtcEnabled = getPrefManager().getExperimentalSettings().getWebrtcEnabled();
            playersManager.play(strValueOf, lifecycle, fragmentActivityRequireActivity, playerView, playerWebrtc, videoLoader, playersCallback, analytics, webrtcEnabled != null ? webrtcEnabled.booleanValue() : true);
            return;
        }
        if (getSubscriptionsViewModel().getCurrentState().getMarketState() == Resource.Status.SUCCESS) {
            List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
            String priceText = null;
            if (subscriptions != null) {
                Iterator<T> it = subscriptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((BaseSubscription) next).getIdentifier(), Subscriptions.standard.toString())) {
                            break;
                        }
                    }
                }
                baseSubscription = (BaseSubscription) next;
            } else {
                baseSubscription = null;
            }
            Integer discountPrice = (baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null || (promo = plan2.getPromo()) == null) ? null : promo.getDiscountPrice();
            Integer price = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans)) == null) ? null : plan.getPrice();
            if (discountPrice != null) {
                LocalizationLocalModel data = getLocalizationScreen().getData();
                String strValueOf2 = String.valueOf((data == null || (subscriptionBuy2 = data.getSubscriptionBuy()) == null || (body2 = subscriptionBuy2.getBody()) == null || (buyButton2 = body2.getBuyButton()) == null) ? null : buyButton2.getTitle());
                String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
                String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
                if (baseSubscription != null && (appearance2 = baseSubscription.getAppearance()) != null) {
                    priceText = appearance2.getPriceText();
                }
                String safe = StringUtilsKt.formatSafe(strValueOf2, strOrEmpty + " " + strOrEmpty2 + " " + priceText);
                AppCompatButton appCompatButton = getBinding().btnSubscribe;
                if (appCompatButton != null) {
                    ViewUtilsKt.strikeThrouth(appCompatButton, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(requireContext(), R.color.track_gray)));
                    return;
                }
                return;
            }
            AppCompatButton appCompatButton2 = getBinding().btnSubscribe;
            if (appCompatButton2 != null) {
                LocalizationLocalModel data2 = getLocalizationScreen().getData();
                String strValueOf3 = String.valueOf((data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
                String strOrEmpty3 = price != null ? StringUtilsKt.orEmpty(price) : null;
                if (baseSubscription != null && (appearance = baseSubscription.getAppearance()) != null) {
                    priceText = appearance.getPriceText();
                }
                appCompatButton2.setText(StringUtilsKt.formatSafe(strValueOf3, strOrEmpty3 + " " + priceText));
                return;
            }
            return;
        }
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner, new Function1<SubscriptionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment.onResume.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
                invoke2(subscriptionsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubscriptionsViewState it2) {
                BaseSubscription baseSubscription2;
                SubscriptionAppearance appearance3;
                SubscriptionBuyLocale subscriptionBuy3;
                SubscriptionBuyBody body3;
                TextTitle buyButton3;
                SubscriptionAppearance appearance4;
                SubscriptionBuyLocale subscriptionBuy4;
                SubscriptionBuyBody body4;
                TextTitle buyButton4;
                SubscriptionDetails subscriptionDetails3;
                List<Plan> plans3;
                Plan plan3;
                SubscriptionDetails subscriptionDetails4;
                List<Plan> plans4;
                Plan plan4;
                Plan.Promo promo2;
                Object next2;
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2.getMarketState() == Resource.Status.SUCCESS) {
                    List<BaseSubscription> subscriptions2 = it2.getSubscriptions();
                    String priceText2 = null;
                    if (subscriptions2 != null) {
                        Iterator<T> it3 = subscriptions2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next2 = null;
                                break;
                            } else {
                                next2 = it3.next();
                                if (Intrinsics.areEqual(((BaseSubscription) next2).getIdentifier(), Subscriptions.standard.toString())) {
                                    break;
                                }
                            }
                        }
                        baseSubscription2 = (BaseSubscription) next2;
                    } else {
                        baseSubscription2 = null;
                    }
                    Integer discountPrice2 = (baseSubscription2 == null || (subscriptionDetails4 = baseSubscription2.getSubscriptionDetails()) == null || (plans4 = subscriptionDetails4.getPlans()) == null || (plan4 = (Plan) CollectionsKt.firstOrNull((List) plans4)) == null || (promo2 = plan4.getPromo()) == null) ? null : promo2.getDiscountPrice();
                    Integer price2 = (baseSubscription2 == null || (subscriptionDetails3 = baseSubscription2.getSubscriptionDetails()) == null || (plans3 = subscriptionDetails3.getPlans()) == null || (plan3 = (Plan) CollectionsKt.firstOrNull((List) plans3)) == null) ? null : plan3.getPrice();
                    if (discountPrice2 == null) {
                        AppCompatButton appCompatButton3 = GlobalCameraFragment.this.getBinding().btnSubscribe;
                        if (appCompatButton3 != null) {
                            LocalizationLocalModel data3 = GlobalCameraFragment.this.getLocalizationScreen().getData();
                            String strValueOf4 = String.valueOf((data3 == null || (subscriptionBuy3 = data3.getSubscriptionBuy()) == null || (body3 = subscriptionBuy3.getBody()) == null || (buyButton3 = body3.getBuyButton()) == null) ? null : buyButton3.getTitle());
                            String strOrEmpty4 = price2 != null ? StringUtilsKt.orEmpty(price2) : null;
                            if (baseSubscription2 != null && (appearance3 = baseSubscription2.getAppearance()) != null) {
                                priceText2 = appearance3.getPriceText();
                            }
                            appCompatButton3.setText(StringUtilsKt.formatSafe(strValueOf4, strOrEmpty4 + " " + priceText2));
                            return;
                        }
                        return;
                    }
                    LocalizationLocalModel data4 = GlobalCameraFragment.this.getLocalizationScreen().getData();
                    String strValueOf5 = String.valueOf((data4 == null || (subscriptionBuy4 = data4.getSubscriptionBuy()) == null || (body4 = subscriptionBuy4.getBody()) == null || (buyButton4 = body4.getBuyButton()) == null) ? null : buyButton4.getTitle());
                    String strOrEmpty5 = price2 != null ? StringUtilsKt.orEmpty(price2) : null;
                    String strOrEmpty6 = StringUtilsKt.orEmpty(discountPrice2);
                    if (baseSubscription2 != null && (appearance4 = baseSubscription2.getAppearance()) != null) {
                        priceText2 = appearance4.getPriceText();
                    }
                    String safe2 = StringUtilsKt.formatSafe(strValueOf5, strOrEmpty5 + " " + strOrEmpty6 + " " + priceText2);
                    AppCompatButton appCompatButton4 = GlobalCameraFragment.this.getBinding().btnSubscribe;
                    if (appCompatButton4 != null) {
                        ViewUtilsKt.strikeThrouth(appCompatButton4, safe2, String.valueOf(price2), Integer.valueOf(ContextCompat.getColor(GlobalCameraFragment.this.requireContext(), R.color.track_gray)));
                    }
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleExoPlayer simpleExoPlayer = player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener(this.exoPlayerListener);
        }
        SimpleExoPlayer simpleExoPlayer2 = player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.pause();
        }
        Log.e("CAMERAS", "paused");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        SimpleExoPlayer simpleExoPlayer = player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        Log.e("CAMERAS", "stopped");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SimpleExoPlayer simpleExoPlayer = player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener(this.exoPlayerListener);
        }
        Log.e("CAMERAS", "destoryed");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Log.e("CAMERAS", "detach");
    }

    /* compiled from: GlobalCameraFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment$Companion;", "", "()V", "CAMERA_KEY", "", "SWIPE_MIN_DISTANCE", "", "SWIPE_THRESHOLD_VELOCITY", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "newInstance", "Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment;", "camera", "Lcom/sputnik/common/entities/camera/Camera;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCameraFragment newInstance(Camera camera) {
            Intrinsics.checkNotNullParameter(camera, "camera");
            GlobalCameraFragment globalCameraFragment = new GlobalCameraFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ui.main.cameras.camera", camera);
            globalCameraFragment.setArguments(bundle);
            return globalCameraFragment;
        }

        public final SimpleExoPlayer getPlayer() {
            return GlobalCameraFragment.player;
        }

        public final void setPlayer(SimpleExoPlayer simpleExoPlayer) {
            GlobalCameraFragment.player = simpleExoPlayer;
        }
    }
}
