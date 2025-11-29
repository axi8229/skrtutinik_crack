package sputnik.axmor.com.sputnik.ui.call;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Keep;
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
import com.axmor.ash.toolset.service.Composite;
import com.axmor.ash.toolset.service.bus.DeliveryListener;
import com.axmor.axvoip.mojo.core.sip.AccountSession;
import com.axmor.axvoip.mojo.core.sip.CallSession;
import com.axmor.axvoip.mojo.core.sip.SipSession;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.mocklets.pluto.PlutoLog;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CallLoader;
import com.sputnik.common.entities.localization.CallLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.pjsip.pjsua2.AccountConfig;
import org.webrtc.MediaStreamTrack;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentAnswerCallBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.manager.PlayersManager;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;
import sputnik.axmor.com.sputnik.entities.call.SipAccount;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewState;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.views.OpenDoorButtonView;
import sputnik.axmor.com.sputnik.ui.views.ZoomOnDoubleTapListener;
import sputnik.axmor.com.sputnik.utils.SipConfigUtils;

/* compiled from: AnswerCallFragment.kt */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0004\u0082\u0001\u008b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0003J!\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010*\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u0010*\u001a\u000200H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b8\u0010\u0003R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010V\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010V\u001a\u0004\by\u0010zR\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006\u0093\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/AnswerCallFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "checkCallSession", "Lcom/sputnik/domain/common/Event;", "", "callLoaded", "renderCall", "(Lcom/sputnik/domain/common/Event;)V", "sipIsLoaded", "renderSipCall", "Lcom/sputnik/common/entities/camera/Camera;", "camera", "renderCameraImage", "(Lcom/sputnik/common/entities/camera/Camera;)V", "Lcom/axmor/ash/toolset/service/Composite;", "composite", "initSip", "(Lcom/axmor/ash/toolset/service/Composite;)V", "initView", "navigateToRootActivity", "localize", "isSpeakerMode", "setSpeakerMode", "(Z)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/axmor/axvoip/mojo/core/sip/AccountSession$CallCreatedEvent;", "event", "onCallCreated", "(Lcom/axmor/axvoip/mojo/core/sip/AccountSession$CallCreatedEvent;)V", "Lcom/axmor/axvoip/mojo/core/sip/AccountSession$CallCompletedEvent;", "onCallComplete", "(Lcom/axmor/axvoip/mojo/core/sip/AccountSession$CallCompletedEvent;)V", "Lcom/axmor/axvoip/mojo/core/sip/CallSession$CallStateUpdatedEvent;", "onCallStateUpdate", "(Lcom/axmor/axvoip/mojo/core/sip/CallSession$CallStateUpdatedEvent;)V", "Lcom/axmor/axvoip/mojo/core/sip/SipSession$SipStateUpdate;", "state", "onSipStateChanged", "(Lcom/axmor/axvoip/mojo/core/sip/SipSession$SipStateUpdate;)V", "onDestroyView", "onDestroy", "Lsputnik/axmor/com/databinding/FragmentAnswerCallBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentAnswerCallBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "callViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "getCallViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "setCallViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel$delegate", "Lkotlin/Lazy;", "getCameraViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "playersManager", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "callViewModel$delegate", "getCallViewModel", "()Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "callViewModel", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "sputnik/axmor/com/sputnik/ui/call/AnswerCallFragment$exoPlayerListener$1", "exoPlayerListener", "Lsputnik/axmor/com/sputnik/ui/call/AnswerCallFragment$exoPlayerListener$1;", "Lcom/axmor/axvoip/mojo/core/sip/SipSession;", "sipSession", "Lcom/axmor/axvoip/mojo/core/sip/SipSession;", "Lcom/axmor/axvoip/mojo/core/sip/CallSession;", "callSession", "Lcom/axmor/axvoip/mojo/core/sip/CallSession;", "sputnik/axmor/com/sputnik/ui/call/AnswerCallFragment$appServiceListener$1", "appServiceListener", "Lsputnik/axmor/com/sputnik/ui/call/AnswerCallFragment$appServiceListener$1;", "Lkotlinx/coroutines/Job;", "checkingJob", "Lkotlinx/coroutines/Job;", "isAlreadyLoading", "Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnswerCallFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AnswerCallFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentAnswerCallBinding;", 0))};
    public Analytics analytics;
    private final AnswerCallFragment$appServiceListener$1 appServiceListener;
    private AudioManager audioManager;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    private CallSession callSession;

    /* renamed from: callViewModel$delegate, reason: from kotlin metadata */
    private final Lazy callViewModel;
    public CallViewModel.Factory.AssistFactory callViewModelFactory;

    /* renamed from: cameraViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cameraViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;
    private Job checkingJob;
    private final AnswerCallFragment$exoPlayerListener$1 exoPlayerListener;
    public MultiViewModelFactory factory;
    private boolean isAlreadyLoading;
    public LocalizationStorage localizationScreen;
    private SimpleExoPlayer player;
    private PlayersManager playersManager;
    public PrefManager prefManager;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;
    private SipSession sipSession;

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onCallStateUpdate(CallSession.CallStateUpdatedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentAnswerCallBinding getBinding() {
        return (FragmentAnswerCallBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCameraViewModel() {
        return (AllCamerasViewModel) this.cameraViewModel.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final CallViewModel getCallViewModel() {
        return (CallViewModel) this.callViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    /* compiled from: AnswerCallFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$checkCallSession$1", f = "AnswerCallFragment.kt", l = {168}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$checkCallSession$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnswerCallFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AnswerCallFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$checkCallSession$1$1", f = "AnswerCallFragment.kt", l = {169}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$checkCallSession$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AnswerCallFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03621(AnswerCallFragment answerCallFragment, Continuation<? super C03621> continuation) {
                super(2, continuation);
                this.this$0 = answerCallFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03621(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CallSession callSession = this.this$0.callSession;
                if (callSession == null || callSession.isAlive()) {
                    this.this$0.checkCallSession();
                } else {
                    this.this$0.getCallViewModel().declineCall();
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C03621 c03621 = new C03621(AnswerCallFragment.this, null);
                this.label = 1;
                if (BuildersKt.withContext(main, c03621, this) == coroutine_suspended) {
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
    public final void checkCallSession() {
        this.checkingJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$appServiceListener$1] */
    public AnswerCallFragment() {
        super(R.layout.fragment_answer_call);
        this.binding = new ViewBindingFragmentDelegate(this, AnswerCallFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.cameraViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$cameraViewModel$2
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
        this.playersManager = new PlayersManager();
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$viewModels$default$4
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
        this.callViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$callViewModel$2
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
        this.exoPlayerListener = new AnswerCallFragment$exoPlayerListener$1(this);
        this.appServiceListener = new DeliveryListener() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$appServiceListener$1
            {
                super(true);
            }

            @Override // com.axmor.ash.toolset.service.bus.DeliveryListener
            protected void onConnected(Composite composite) throws Exception {
                if (composite != null) {
                    this.this$0.initSip(composite);
                }
                if (composite != null) {
                    return;
                }
                try {
                    throw new Exception("COMPOSITE IS NULL");
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Job job = this.checkingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        checkCallSession();
        CallSession callSession = this.callSession;
        if (callSession == null || callSession.isAlive()) {
            return;
        }
        getCallViewModel().declineCall();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.audioManager = (AudioManager) requireContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        localize();
        initView();
        CallViewModel callViewModel = getCallViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        callViewModel.observeSubState(viewLifecycleOwner, new Function1<CallViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSipIsLoaded();
            }
        }, new C26422(this));
        CallViewModel callViewModel2 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        callViewModel2.observeSubState(viewLifecycleOwner2, new Function1<CallViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCallIsDeclined();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.4
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
                    AnswerCallFragment answerCallFragment = AnswerCallFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        answerCallFragment.navigateToRootActivity();
                    }
                }
            }
        });
        CallViewModel callViewModel3 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        callViewModel3.observeSubState(viewLifecycleOwner3, new Function1<CallViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCallLoaded();
            }
        }, new AnonymousClass6(this));
        getCallViewModel().checkCallState();
        CallViewModel callViewModel4 = getCallViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        callViewModel4.observeState(viewLifecycleOwner4, new Function1<CallViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.7
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
                AnswerCallFragment.this.renderCameraImage(currentCamera);
            }
        });
        if (getCallViewModel().getCurrentState().getCurrentCamera() == null) {
            CallViewModel callViewModel5 = getCallViewModel();
            String callUuid = getCallViewModel().getCurrentState().getCallUuid();
            if (callUuid == null) {
                callUuid = "";
            }
            String flatUuid = getCallViewModel().getCurrentState().getFlatUuid();
            callViewModel5.loadCameraByIntercomUUID(callUuid, flatUuid != null ? flatUuid : "");
        }
        AllCamerasViewModel cameraViewModel = getCameraViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        cameraViewModel.observeState(viewLifecycleOwner5, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.onViewCreated.8
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
    }

    /* compiled from: AnswerCallFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26422 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        C26422(Object obj) {
            super(1, obj, AnswerCallFragment.class, "renderSipCall", "renderSipCall(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AnswerCallFragment) this.receiver).renderSipCall(p0);
        }
    }

    /* compiled from: AnswerCallFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, AnswerCallFragment.class, "renderCall", "renderCall(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AnswerCallFragment) this.receiver).renderCall(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCall(Event<Boolean> callLoaded) {
        PjmCallHandle pjmCallHandle;
        AccountSession accountSession;
        AccountSession accountSession2;
        List<PjmCallHandle> activeCalls;
        Boolean contentIfNotHandled = callLoaded.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        SipSession sipSession = this.sipSession;
        CallSession callSession = null;
        if (sipSession == null || (accountSession2 = sipSession.getAccountSession()) == null || (activeCalls = accountSession2.getActiveCalls()) == null) {
            pjmCallHandle = null;
        } else {
            Intrinsics.checkNotNull(activeCalls);
            pjmCallHandle = (PjmCallHandle) CollectionsKt.getOrNull(activeCalls, 0);
        }
        SipSession sipSession2 = this.sipSession;
        if (sipSession2 != null && (accountSession = sipSession2.getAccountSession()) != null) {
            callSession = accountSession.getCallSession(pjmCallHandle);
        }
        this.callSession = callSession;
        if (callSession != null) {
            if (callSession != null) {
                callSession.accept();
            }
            setSpeakerMode(true);
            ProgressBar progressBar = getBinding().loaderSip;
            if (progressBar != null) {
                Intrinsics.checkNotNull(progressBar);
                ViewKt.gone(progressBar);
            }
            SputnikApp.INSTANCE.getAnalyticsService().send("call", "call_accept", "sip_success");
            return;
        }
        getCallViewModel().declineCall();
        setSpeakerMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSipCall(Event<Boolean> sipIsLoaded) {
        Boolean contentIfNotHandled = sipIsLoaded.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        SipAccount sipAccount = getCallViewModel().getCurrentState().getSipAccount();
        Intrinsics.checkNotNull(sipAccount);
        String sipServer = sipAccount.getSipServer();
        String sipPort = sipAccount.getSipPort();
        long j = sipPort != null ? Long.parseLong(sipPort) : 5440L;
        PjmEndpointConfig pjmEndpointConfig = new PjmEndpointConfig();
        pjmEndpointConfig.configureTransport(j);
        AccountConfig accountConfigGenerateSipAccountConfig = SipConfigUtils.generateSipAccountConfig(sipAccount.getLogin(), sipAccount.getPassword(), sipServer, (int) j);
        accountConfigGenerateSipAccountConfig.getSipConfig().getProxies().add("sip:" + sipServer + ":" + j + ";transport=tcp");
        PlutoLog.i$default(PlutoLog.INSTANCE, "sip host", "sip:" + sipServer + ":" + j + ";transport=tcp", null, 4, null);
        SipSession sipSession = this.sipSession;
        if (sipSession != null) {
            sipSession.activate(pjmEndpointConfig, accountConfigGenerateSipAccountConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCameraImage(Camera camera) {
        if (this.isAlreadyLoading) {
            return;
        }
        LogUtilsKt.writeLog("GGGG: RENDER CAMERA IMAGE=" + camera);
        this.isAlreadyLoading = true;
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
            PlayersCallback playersCallback = new PlayersCallback() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$renderCameraImage$1$1
                @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback
                public void onStateChanged(PlayerStates state, PlayersCallback.Players player) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(player, "player");
                    LogUtilsKt.writeLog("GGGG: PLAYER STATE=" + state + "| " + player);
                    AnswerCallFragment answerCallFragment = this.this$0;
                    try {
                        PlayerView playerView2 = answerCallFragment.getBinding().playerExo;
                        if (playerView2 != null) {
                            Intrinsics.checkNotNull(playerView2);
                            ViewBindingUtilsKt.visibilityBasedOn(playerView2, Boolean.valueOf(player == PlayersCallback.Players.EXO));
                        }
                        ZoomLayout zoomLayout = answerCallFragment.getBinding().layoutZoom2;
                        if (zoomLayout != null) {
                            Intrinsics.checkNotNull(zoomLayout);
                            ViewBindingUtilsKt.visibilityBasedOn(zoomLayout, Boolean.valueOf(player == PlayersCallback.Players.EXO || player == PlayersCallback.Players.VLC));
                        }
                        ZoomLayout zoomLayout2 = answerCallFragment.getBinding().layoutZoom;
                        if (zoomLayout2 != null) {
                            Intrinsics.checkNotNull(zoomLayout2);
                            ViewBindingUtilsKt.visibilityBasedOn(zoomLayout2, Boolean.valueOf(player == PlayersCallback.Players.WEBRTC));
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onCallCreated(AccountSession.CallCreatedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AnswerCallFragment.onCallCreated$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCallCreated$lambda$4(AnswerCallFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e("CALLVIEWMODEL", "callCreated");
        this$0.getCallViewModel().handleCall();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onCallComplete(AccountSession.CallCompletedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnswerCallFragment.onCallComplete$lambda$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCallComplete$lambda$5(AnswerCallFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SputnikApp.INSTANCE.getAnalyticsService().send("call", "call_end", "by_server");
        this$0.getCallViewModel().declineCall();
        this$0.setSpeakerMode(false);
        Log.e("CALLVIEWMODEL", "completed");
    }

    @Subscribe
    @Keep
    public final void onSipStateChanged(SipSession.SipStateUpdate state) {
        Intrinsics.checkNotNullParameter(state, "state");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnswerCallFragment.onSipStateChanged$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSipStateChanged$lambda$6(AnswerCallFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCallViewModel().updateSipState(this$0.sipSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initSip(Composite composite) {
        if (this.sipSession == null) {
            SipSession sipSession = (SipSession) composite.getService(SipSession.class);
            this.sipSession = sipSession;
            PlutoLog plutoLog = PlutoLog.INSTANCE;
            SipSession.SipState state = sipSession != null ? sipSession.getState() : null;
            SipSession sipSession2 = this.sipSession;
            PlutoLog.i$default(plutoLog, "initSip", "SIP session state:" + state + "; SIP Account:" + (sipSession2 != null ? sipSession2.getAccountSession() : null), null, 4, null);
            getCallViewModel().updateSipState(this.sipSession);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() throws AssertionError {
        super.onDestroyView();
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener(this.exoPlayerListener);
        }
        CallSession callSession = this.callSession;
        if (callSession != null) {
            callSession.decline();
        }
        this.callSession = null;
        this.sipSession = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getCallViewModel().cancelJobs();
        Job job = this.checkingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
        }
        super.onDestroy();
    }

    private final void initView() {
        getBinding().layoutZoom.setMaxScale(12.0f);
        getBinding().layoutZoom2.setMaxScale(12.0f);
        getBinding().layoutZoom.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom2.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.initView.1
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
        getBinding().layoutZoom2.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment.initView.2
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
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.call.CallActivity");
        ((CallActivity) fragmentActivityRequireActivity).getCompositeServiceConnection().addDeliveryNode(this.appServiceListener);
        FragmentAnswerCallBinding binding = getBinding();
        ImageView declineCallBtn = binding.declineCallBtn;
        Intrinsics.checkNotNullExpressionValue(declineCallBtn, "declineCallBtn");
        SafeClickListenerKt.setSafeOnClickListener$default(declineCallBtn, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$initView$3$1
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
                this.this$0.getCallViewModel().declineCall();
            }
        }, 1, null);
        OpenDoorButtonView secondaryOpenDoorBtn = binding.secondaryOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(secondaryOpenDoorBtn, "secondaryOpenDoorBtn");
        SafeClickListenerKt.setSafeOnClickListener$default(secondaryOpenDoorBtn, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$initView$3$2
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
                Bundle extras;
                Intrinsics.checkNotNullParameter(it, "it");
                AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "call", "door_open", null, 4, null);
                LogUtilsKt.writeLog("CALL", "opening door");
                AllCamerasViewModel cameraViewModel = this.this$0.getCameraViewModel();
                String callUuid = this.this$0.getCallViewModel().getCurrentState().getCallUuid();
                Intent intent = this.this$0.requireActivity().getIntent();
                cameraViewModel.openDoor(callUuid, (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("call.flat_uuid"));
            }
        }, 1, null);
        OpenDoorButtonView secondaryOpenDoorBtn2 = binding.secondaryOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(secondaryOpenDoorBtn2, "secondaryOpenDoorBtn");
        ViewKt.addSystemWindowInsetToMargin$default(secondaryOpenDoorBtn2, false, false, false, true, 7, null);
        ImageView declineCallBtn2 = binding.declineCallBtn;
        Intrinsics.checkNotNullExpressionValue(declineCallBtn2, "declineCallBtn");
        ViewKt.addSystemWindowInsetToMargin$default(declineCallBtn2, false, false, true, true, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToRootActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void localize() {
        CallLocale call;
        CallLoader stream;
        TextView textView = getBinding().tvLoading;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (call = data.getCall()) == null || (stream = call.getStream()) == null) ? null : stream.getConnecting());
    }

    private final void setSpeakerMode(final boolean isSpeakerMode) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AnswerCallFragment.setSpeakerMode$lambda$8(this.f$0, isSpeakerMode);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpeakerMode$lambda$8(AnswerCallFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudioManager audioManager = this$0.audioManager;
        if (audioManager != null) {
            audioManager.setMode(z ? 3 : 0);
        }
        AudioManager audioManager2 = this$0.audioManager;
        if (audioManager2 == null) {
            return;
        }
        audioManager2.setSpeakerphoneOn(z);
    }
}
