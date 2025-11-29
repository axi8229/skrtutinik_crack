package sputnik.axmor.com.sputnik.ui.call;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.video.VideoListener;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CallBody;
import com.sputnik.common.entities.localization.CallLoader;
import com.sputnik.common.entities.localization.CallLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.webrtc.MediaStreamTrack;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentReceivingCallBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.manager.PlayersManager;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewState;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.views.ZoomOnDoubleTapListener;

/* compiled from: ReceivingCallFragment.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002il\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0003R\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010=\u001a\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010=\u001a\u0004\bq\u0010rR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010tR$\u0010v\u001a\u0004\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0085\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/entities/camera/Camera;", "camera", "", "renderCameraImage", "(Lcom/sputnik/common/entities/camera/Camera;)V", "initSound", "setVibrationMode", "Landroid/media/AudioManager;", "audioManager", "setNormalMode", "(Landroid/media/AudioManager;)V", "navigateToAnswerScreen", "navigateToRootActivity", "initView", "releaseVibration", "releaseMediaPlayer", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Lsputnik/axmor/com/databinding/FragmentReceivingCallBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentReceivingCallBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "callViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "getCallViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "setCallViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel$delegate", "Lkotlin/Lazy;", "getCameraViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "callViewModel$delegate", "getCallViewModel", "()Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "callViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "playersManager", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "Lkotlinx/coroutines/Job;", "openDoorJob", "Lkotlinx/coroutines/Job;", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "sputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment$exoPlayerListener$1", "exoPlayerListener", "Lsputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment$exoPlayerListener$1;", "sputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment$videoListener$1", "videoListener", "Lsputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment$videoListener$1;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Landroid/media/AudioManager;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "afChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getAfChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "setAfChangeListener", "(Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "Landroid/os/Vibrator;", "mvibrator", "Landroid/os/Vibrator;", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceivingCallFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ReceivingCallFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentReceivingCallBinding;", 0))};
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
    public Analytics analytics;
    private AudioManager audioManager;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: callViewModel$delegate, reason: from kotlin metadata */
    private final Lazy callViewModel;
    public CallViewModel.Factory.AssistFactory callViewModelFactory;

    /* renamed from: cameraViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cameraViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;
    private final ReceivingCallFragment$exoPlayerListener$1 exoPlayerListener;
    public MultiViewModelFactory factory;
    private Handler handler;
    public LocalizationStorage localizationScreen;
    private MediaPlayer mediaPlayer;
    private Vibrator mvibrator;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    private Job openDoorJob;
    private SimpleExoPlayer player;
    private PlayersManager playersManager;
    public PrefManager prefManager;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;
    private final ReceivingCallFragment$videoListener$1 videoListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentReceivingCallBinding getBinding() {
        return (FragmentReceivingCallBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactory");
        return null;
    }

    public final CallViewModel.Factory.AssistFactory getCallViewModelFactory() {
        CallViewModel.Factory.AssistFactory assistFactory = this.callViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callViewModelFactory");
        return null;
    }

    private final AllCamerasViewModel getCameraViewModel() {
        return (AllCamerasViewModel) this.cameraViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallViewModel getCallViewModel() {
        return (CallViewModel) this.callViewModel.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$videoListener$1] */
    public ReceivingCallFragment() {
        super(R.layout.fragment_receiving_call);
        this.binding = new ViewBindingFragmentDelegate(this, ReceivingCallFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.cameraViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$cameraViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory camerasFactory = this.this$0.getCamerasFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return camerasFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.callViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$callViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                CallViewModel.Factory.AssistFactory callViewModelFactory = this.this$0.getCallViewModelFactory();
                Intent intent = this.this$0.requireActivity().getIntent();
                String string = null;
                String string2 = (intent == null || (extras3 = intent.getExtras()) == null) ? null : extras3.getString("sputnik.axmor.com.sputnik.global.call_id");
                Intent intent2 = this.this$0.requireActivity().getIntent();
                String string3 = (intent2 == null || (extras2 = intent2.getExtras()) == null) ? null : extras2.getString("sputnik.axmor.com.sputnik.global.uuid");
                Intent intent3 = this.this$0.requireActivity().getIntent();
                if (intent3 != null && (extras = intent3.getExtras()) != null) {
                    string = extras.getString("call.flat_uuid");
                }
                return CallViewModel.Factory.AssistFactory.DefaultImpls.create$default(callViewModelFactory, string2, string3, string, false, 8, null);
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
        this.playersManager = new PlayersManager();
        this.exoPlayerListener = new ReceivingCallFragment$exoPlayerListener$1(this);
        this.videoListener = new VideoListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$videoListener$1
            @Override // com.google.android.exoplayer2.video.VideoListener
            public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                if (this.this$0.getView() != null) {
                    try {
                        Unit unit = Unit.INSTANCE;
                    } catch (Exception e) {
                        Log.e("error", e.toString());
                    }
                }
            }
        };
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.call_nav_host_fragment);
            }
        });
    }

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        if (CallActivity.INSTANCE.getCallNeedBeAccepted()) {
            navigateToAnswerScreen();
        }
        initView();
        AllCamerasViewModel cameraViewModel = getCameraViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        cameraViewModel.observeState(viewLifecycleOwner, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AllCamerasViewState allCamerasViewState) {
                invoke2(allCamerasViewState);
                return Unit.INSTANCE;
            }
        });
        CallViewModel callViewModel = getCallViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        callViewModel.observeSubState(viewLifecycleOwner2, new Function1<CallViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCallIsAccepted();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    ReceivingCallFragment receivingCallFragment = ReceivingCallFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        receivingCallFragment.navigateToAnswerScreen();
                    }
                }
            }
        });
        CallViewModel callViewModel2 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        callViewModel2.observeSubState(viewLifecycleOwner3, new Function1<CallViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCallIsDeclined();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    ReceivingCallFragment receivingCallFragment = ReceivingCallFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        receivingCallFragment.navigateToRootActivity();
                    }
                }
            }
        });
        CallViewModel callViewModel3 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        callViewModel3.observeState(viewLifecycleOwner4, new Function1<CallViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CallViewState callViewState) {
                invoke2(callViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CallViewState it) {
                Camera currentCamera;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getLoadCameraState() != Resource.Status.SUCCESS || (currentCamera = it.getCurrentCamera()) == null) {
                    return;
                }
                ReceivingCallFragment.this.renderCameraImage(currentCamera);
            }
        });
        CallViewModel callViewModel4 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        callViewModel4.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.onViewCreated.7
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
                ReceivingCallFragment receivingCallFragment = ReceivingCallFragment.this;
                ConstraintLayout root = receivingCallFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(receivingCallFragment, root, it);
                ReceivingCallFragment.this.navigateToRootActivity();
            }
        });
        getCallViewModel().checkCallState();
        CallViewModel callViewModel5 = getCallViewModel();
        String callUuid = getCallViewModel().getCurrentState().getCallUuid();
        if (callUuid == null) {
            callUuid = "";
        }
        String flatUuid = getCallViewModel().getCurrentState().getFlatUuid();
        callViewModel5.loadCameraByIntercomUUID(callUuid, flatUuid != null ? flatUuid : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCameraImage(Camera camera) {
        try {
            PlayersManager playersManager = this.playersManager;
            String strValueOf = String.valueOf(camera.getStreamUrl());
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            PlayerView playerView = getBinding().playerExo;
            SurfaceViewRenderer playerWebrtc = getBinding().playerWebrtc;
            Intrinsics.checkNotNullExpressionValue(playerWebrtc, "playerWebrtc");
            LinearLayout videoLoader = getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            PlayersCallback playersCallback = new PlayersCallback() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$renderCameraImage$1$1
                @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback
                public void onStateChanged(PlayerStates state, PlayersCallback.Players player) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(player, "player");
                    ReceivingCallFragment receivingCallFragment = this.this$0;
                    try {
                        ZoomLayout zoomLayout = receivingCallFragment.getBinding().layoutZoom2;
                        boolean z = true;
                        if (zoomLayout != null) {
                            Intrinsics.checkNotNull(zoomLayout);
                            ViewBindingUtilsKt.visibilityBasedOn(zoomLayout, Boolean.valueOf(player == PlayersCallback.Players.EXO || player == PlayersCallback.Players.VLC));
                        }
                        ZoomLayout zoomLayout2 = receivingCallFragment.getBinding().layoutZoom;
                        if (zoomLayout2 != null) {
                            Intrinsics.checkNotNull(zoomLayout2);
                            if (player != PlayersCallback.Players.WEBRTC) {
                                z = false;
                            }
                            ViewBindingUtilsKt.visibilityBasedOn(zoomLayout2, Boolean.valueOf(z));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Analytics analytics = getAnalytics();
            Boolean webrtcEnabled = getPrefManager().getExperimentalSettings().getWebrtcEnabled();
            playersManager.play(strValueOf, lifecycle, fragmentActivityRequireActivity, playerView, playerWebrtc, videoLoader, playersCallback, analytics, webrtcEnabled != null ? webrtcEnabled.booleanValue() : true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initSound() {
        try {
            AudioManager audioManager = (AudioManager) requireContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.audioManager = audioManager;
            if (audioManager != null) {
                Intrinsics.checkNotNull(audioManager);
                int ringerMode = audioManager.getRingerMode();
                if (ringerMode == 1) {
                    setVibrationMode();
                } else if (ringerMode == 2) {
                    AudioManager audioManager2 = this.audioManager;
                    Intrinsics.checkNotNull(audioManager2);
                    setNormalMode(audioManager2);
                    setVibrationMode();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setVibrationMode() {
        Object systemService = requireContext().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        Object systemService2 = requireContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        this.mvibrator = (Vibrator) systemService2;
    }

    private final void setNormalMode(AudioManager audioManager) {
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$$ExternalSyntheticLambda3
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) throws IllegalStateException {
                ReceivingCallFragment.setNormalMode$lambda$3(this.f$0, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNormalMode$lambda$3(ReceivingCallFragment this$0, int i) throws IllegalStateException {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == -1 && (mediaPlayer = this$0.mediaPlayer) != null && mediaPlayer != null && mediaPlayer.isPlaying() && (mediaPlayer2 = this$0.mediaPlayer) != null) {
            mediaPlayer2.pause();
        }
        Log.e("AUDIO FOCUS", String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToAnswerScreen() throws Resources.NotFoundException {
        NavControllerKt.safeNavigate$default(getNavController(), R.id.fragmentReceivingCall, R.id.action_fragmentReceivingCall_to_fragmentAnswerCall, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToRootActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initView() {
        getBinding().layoutZoom.setMaxScale(12.0f);
        getBinding().layoutZoom2.setMaxScale(12.0f);
        getBinding().layoutZoom.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom2.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.initView.1
            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoom(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomBegin(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomEnd(ZoomLayout view, float scale) {
            }
        });
        getBinding().layoutZoom2.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment.initView.2
            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoom(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomBegin(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomEnd(ZoomLayout view, float scale) {
            }
        });
        getBinding();
        IPushProcessor.Companion companion = IPushProcessor.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final IPushProcessor instance$default = IPushProcessor.Companion.getInstance$default(companion, contextRequireContext, null, 2, null);
        FragmentReceivingCallBinding binding = getBinding();
        binding.acceptCallBtn.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ReceivingCallFragment.initView$lambda$8$lambda$7$lambda$4(instance$default, this, view);
            }
        });
        binding.secondaryOpenDoorBtn.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReceivingCallFragment.initView$lambda$8$lambda$7$lambda$5(instance$default, this, view);
            }
        });
        binding.declineCallBtn.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReceivingCallFragment.initView$lambda$8$lambda$7$lambda$6(instance$default, this, view);
            }
        });
        ImageView acceptCallBtn = binding.acceptCallBtn;
        Intrinsics.checkNotNullExpressionValue(acceptCallBtn, "acceptCallBtn");
        ViewKt.addSystemWindowInsetToMargin$default(acceptCallBtn, true, false, false, true, 6, null);
        ImageView declineCallBtn = binding.declineCallBtn;
        Intrinsics.checkNotNullExpressionValue(declineCallBtn, "declineCallBtn");
        ViewKt.addSystemWindowInsetToMargin$default(declineCallBtn, false, false, true, true, 3, null);
        initSound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7$lambda$4(IPushProcessor pushProcessor, ReceivingCallFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(pushProcessor, "$pushProcessor");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pushProcessor.cancel();
        this$0.navigateToAnswerScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7$lambda$5(IPushProcessor pushProcessor, ReceivingCallFragment this$0, View view) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(pushProcessor, "$pushProcessor");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "call", "incoming_call_door_open", null, 4, null);
        pushProcessor.cancel();
        AllCamerasViewModel cameraViewModel = this$0.getCameraViewModel();
        String callUuid = this$0.getCallViewModel().getCurrentState().getCallUuid();
        Intent intent = this$0.requireActivity().getIntent();
        cameraViewModel.openDoor(callUuid, (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("call.flat_uuid"));
        this$0.openDoorJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new ReceivingCallFragment$initView$3$1$2$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7$lambda$6(IPushProcessor pushProcessor, ReceivingCallFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(pushProcessor, "$pushProcessor");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pushProcessor.cancel();
        this$0.getCallViewModel().declineCall();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() throws IllegalStateException {
        getCallViewModel().cancelJobs();
        Job job = this.openDoorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        IPushProcessor.Companion companion = IPushProcessor.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        IPushProcessor.Companion.getInstance$default(companion, contextRequireContext, null, 2, null).cancel();
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.afChangeListener);
        }
        this.audioManager = null;
        this.handler = null;
        releaseMediaPlayer();
        releaseVibration();
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.release();
        }
        super.onDestroy();
    }

    private final void releaseVibration() {
        try {
            Vibrator vibrator = this.mvibrator;
            if (vibrator != null) {
                Intrinsics.checkNotNull(vibrator);
                if (vibrator.hasVibrator()) {
                    Vibrator vibrator2 = this.mvibrator;
                    Intrinsics.checkNotNull(vibrator2);
                    vibrator2.cancel();
                }
                this.mvibrator = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void releaseMediaPlayer() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                }
                this.mediaPlayer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void localize() {
        CallLocale call;
        FragmentReceivingCallBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (call = data.getCall()) == null) {
            return;
        }
        TextView textView = binding.tvTitleCall;
        CallBody body = call.getBody();
        textView.setText(body != null ? body.getTitle() : null);
        TextView textView2 = binding.tvLoader;
        CallLoader stream = call.getStream();
        textView2.setText(stream != null ? stream.getTitle() : null);
    }
}
