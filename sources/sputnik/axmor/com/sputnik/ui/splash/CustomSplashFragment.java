package sputnik.axmor.com.sputnik.ui.splash;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.StaticVariables;
import com.sputnik.common.analytics.ABExperimentsEvents;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.SimpleDialog;
import com.sputnik.common.databinding.DialogErrorSplashBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SplashBody;
import com.sputnik.common.entities.localization.SplashErrorsLocale;
import com.sputnik.common.entities.localization.SplashLocale;
import com.sputnik.common.entities.localization.TextSubtitle;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.promotion.ScreenVariants;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.StoriesDataState;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Errors;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.entities.prefs.SplashScreen;
import com.sputnik.domain.entities.prefs.VersionModel;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.yandex.varioqub.config.Varioqub;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSplashCustomScreenBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment;
import sputnik.axmor.com.sputnik.ui.splash.viewmodel.SplashViewModel;
import sputnik.axmor.com.sputnik.ui.splash.viewmodel.SplashViewState;

/* compiled from: CustomSplashFragment.kt */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00042\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0003J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020&H\u0016¢\u0006\u0004\b0\u0010)J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u0010\u0003R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010g\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010g\u001a\u0004\br\u0010sR\u001b\u0010y\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010g\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010g\u001a\u0004\b|\u0010}R\u001f\u0010\u0083\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0080\u0001\u0010g\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0088\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010g\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0097\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0094\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u0098\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/CustomSplashFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "initVideoView", "initializePromotion", "Lcom/sputnik/common/entities/promotion/ScreenVariants;", "variant", "launchPromotion", "(Lcom/sputnik/common/entities/promotion/ScreenVariants;)V", "loadLocalPrefs", "setupText", "Lcom/sputnik/common/viewmodels/ProfileViewState;", RemoteMessageConst.DATA, "renderState", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "renderUi", "navigateWithProfileState", "", "navigate", "doUnblocked", "(Z)V", "navigateToStart", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "doWithError", "(Ljava/lang/Exception;)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, RemoteMessageConst.MessageBody.MSG, "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "outState", "onSaveInstanceState", "onResume", "initViews", "localize", "onDestroy", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/IConfig;", "getConfig", "()Lcom/sputnik/data/IConfig;", "setConfig", "(Lcom/sputnik/data/IConfig;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", "binding", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "Lkotlin/Lazy;", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewModel;", "splashViewModel$delegate", "getSplashViewModel", "()Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewModel;", "splashViewModel", "Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel$delegate", "getStoriesViewModel", "()Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lkotlinx/coroutines/Job;", "timerJob", "Lkotlinx/coroutines/Job;", "", "lastCountDownMilliseconds", "Ljava/lang/Integer;", "needNavigate", "Z", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "", "getLoadingTexts", "()Ljava/util/List;", "loadingTexts", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomSplashFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CustomSplashFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public IConfig config;
    public MultiViewModelFactory factory;
    private Integer lastCountDownMilliseconds;
    public LocalizationStorage localizationScreen;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private boolean needNavigate;
    private SimpleExoPlayer player;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: splashViewModel$delegate, reason: from kotlin metadata */
    private final Lazy splashViewModel;

    /* renamed from: storiesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storiesViewModel;
    private Job timerJob;

    /* compiled from: CustomSplashFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenVariants.values().length];
            try {
                iArr[ScreenVariants.close_icon.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScreenVariants.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScreenVariants.accelerating_icon.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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
    public final FragmentSplashCustomScreenBinding getBinding() {
        return (FragmentSplashCustomScreenBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    private final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final SplashViewModel getSplashViewModel() {
        return (SplashViewModel) this.splashViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoriesViewModel getStoriesViewModel() {
        return (StoriesViewModel) this.storiesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getLoadingTexts() {
        Object next;
        SplashLocale splash;
        SplashBody body;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        List<String> loadingText = (data == null || (splash = data.getSplash()) == null || (body = splash.getBody()) == null) ? null : body.getLoadingText();
        if (loadingText != null && !loadingText.isEmpty()) {
            return loadingText;
        }
        Iterator<T> it = getPrefManager().getLocalesVersions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((VersionModel) next).getLocale(), getPrefManager().getCurLocale())) {
                break;
            }
        }
        VersionModel versionModel = (VersionModel) next;
        if (versionModel != null) {
            return versionModel.getLoadedText();
        }
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.lastCountDownMilliseconds = savedInstanceState != null ? Integer.valueOf(savedInstanceState.getInt("last_count_down_millis", 3500)) : null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout layoutActions = getBinding().layoutActions;
        Intrinsics.checkNotNullExpressionValue(layoutActions, "layoutActions");
        ViewKt.addSystemWindowInsetToMargin$default(layoutActions, false, true, false, true, 5, null);
        if (getProfileViewModel().haveSubscription()) {
            FragmentSplashCustomScreenBinding binding = getBinding();
            ConstraintLayout layoutVideo = binding.layoutVideo;
            Intrinsics.checkNotNullExpressionValue(layoutVideo, "layoutVideo");
            ViewKt.gone(layoutVideo);
            TextSwitcher tvSplash = binding.tvSplash;
            Intrinsics.checkNotNullExpressionValue(tvSplash, "tvSplash");
            ViewKt.gone(tvSplash);
            SimpleExoPlayerView viewVideo = binding.viewVideo;
            Intrinsics.checkNotNullExpressionValue(viewVideo, "viewVideo");
            ViewKt.gone(viewVideo);
            ImageView ivOurHome = binding.ivOurHome;
            Intrinsics.checkNotNullExpressionValue(ivOurHome, "ivOurHome");
            ViewKt.visible(ivOurHome);
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        CustomSplashFragment.onViewCreated$lambda$2(this.f$0);
                    }
                });
            }
        }
        loadLocalPrefs();
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "launch", "launch", null, 4, null);
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new AnonymousClass3(this));
        setupText();
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner2, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.4
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
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        profileViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.5
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
                CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                ConstraintLayout root = customSplashFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(customSplashFragment, root, it);
            }
        });
        SplashViewModel splashViewModel = getSplashViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        splashViewModel.observeState(viewLifecycleOwner4, new Function1<SplashViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SplashViewState splashViewState) {
                invoke2(splashViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SplashViewState it) {
                Object obj;
                Intrinsics.checkNotNullParameter(it, "it");
                int curLoaderIndex = it.getCurLoaderIndex();
                TextSwitcher textSwitcher = CustomSplashFragment.this.getBinding().tvSplash;
                List loadingTexts = CustomSplashFragment.this.getLoadingTexts();
                if (loadingTexts != null) {
                    CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                    if (curLoaderIndex < 0 || curLoaderIndex > CollectionsKt.getLastIndex(loadingTexts)) {
                        List loadingTexts2 = customSplashFragment.getLoadingTexts();
                        obj = loadingTexts2 != null ? (String) CollectionsKt.firstOrNull(loadingTexts2) : null;
                    } else {
                        obj = loadingTexts.get(curLoaderIndex);
                    }
                    str = (String) obj;
                }
                textSwitcher.setText(str);
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner5, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getLocalizationNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.8
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
                    CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        if (customSplashFragment.getProfileViewModel().getCurrentState().getUserLocale() != null) {
                            PrefManager prefManager = customSplashFragment.getPrefManager();
                            String userLocale = customSplashFragment.getProfileViewModel().getCurrentState().getUserLocale();
                            Intrinsics.checkNotNull(userLocale);
                            prefManager.updateUserLocale(userLocale);
                        } else {
                            customSplashFragment.getPrefManager().updateUserLocale(AndroidConstants.INSTANCE.getPhoneLocale());
                        }
                        customSplashFragment.getLocalizationViewModel().loadLocalization(customSplashFragment.getPrefManager().getCurLocale());
                    }
                }
            }
        });
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        localizationViewModel.observeSubState(viewLifecycleOwner6, new Function1<LocalizationViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.10
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
                    CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        if (customSplashFragment.getPrefManager().getIsNeedShowStartOnBoarding() && !StringsKt.isBlank(customSplashFragment.getPrefManager().getJwtToken())) {
                            customSplashFragment.getStoriesViewModel().loadOnboardingStories();
                        } else if (!StringsKt.isBlank(customSplashFragment.getPrefManager().getJwtToken())) {
                            customSplashFragment.getStoriesViewModel().loadStories();
                        } else {
                            CustomSplashFragment.navigateToStart$default(customSplashFragment, false, 1, null);
                        }
                    }
                }
            }
        });
        StoriesViewModel storiesViewModel = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        storiesViewModel.observeSubState(viewLifecycleOwner7, new Function1<StoriesDataState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.11
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(StoriesDataState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.12
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
                    CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        List<Story> stories = customSplashFragment.getStoriesViewModel().getCurrentState().getStories();
                        if (stories == null || stories.isEmpty()) {
                            IProfileViewModel.DefaultImpls.loadProfile$default(customSplashFragment.getProfileViewModel(), false, 1, null);
                        } else {
                            NavControllerKt.safeNavigate(customSplashFragment.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToOnBoarding());
                        }
                    }
                }
            }
        });
        StoriesViewModel storiesViewModel2 = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        storiesViewModel2.observeSubState(viewLifecycleOwner8, new Function1<StoriesDataState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.13
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(StoriesDataState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getOnBoardingIsLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.14
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
                    CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        List<Story> stories = customSplashFragment.getStoriesViewModel().getCurrentState().getStories();
                        if (stories == null || stories.isEmpty()) {
                            IProfileViewModel.DefaultImpls.loadProfile$default(customSplashFragment.getProfileViewModel(), false, 1, null);
                            customSplashFragment.getPrefManager().updateShowStartOnBoarding(false);
                        } else {
                            NavControllerKt.safeNavigate(customSplashFragment.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToOnBoarding());
                        }
                    }
                }
            }
        });
        LocalizationViewModel localizationViewModel2 = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        localizationViewModel2.observeNotifications(viewLifecycleOwner9, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.onViewCreated.15
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
                CustomSplashFragment customSplashFragment = CustomSplashFragment.this;
                ConstraintLayout root = customSplashFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(customSplashFragment, root, it);
            }
        });
        getProfileViewModel().loadLocalization();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(CustomSplashFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initVideoView();
        this$0.initializePromotion();
    }

    /* compiled from: CustomSplashFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, CustomSplashFragment.class, "renderState", "renderState(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CustomSplashFragment) this.receiver).renderState(p0);
        }
    }

    public CustomSplashFragment() {
        super(R.layout.fragment_splash_custom_screen);
        this.binding = new ViewBindingFragmentDelegate(this, CustomSplashFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$camerasViewModel$2
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
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$splashViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.splashViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SplashViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$viewModels$default$4
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
        this.storiesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(StoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$storiesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getBaseFactory();
            }
        });
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$navController$2
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        TimeInterpolator accelerateInterpolator;
        super.onStart();
        getBinding().progress.setMax(1000);
        int iNextInt = Random.INSTANCE.nextInt(1, 4);
        if (iNextInt == 1) {
            accelerateInterpolator = new AccelerateInterpolator();
        } else if (iNextInt == 2) {
            accelerateInterpolator = new AccelerateDecelerateInterpolator();
        } else if (iNextInt != 3 && iNextInt == 4) {
            accelerateInterpolator = new LinearInterpolator();
        } else {
            accelerateInterpolator = new DecelerateInterpolator();
        }
        List listMutableListOf = CollectionsKt.mutableListOf(0);
        int iNextInt2 = 0;
        for (int i = 0; i < 9; i++) {
            iNextInt2 += Random.INSTANCE.nextInt(50, 100);
            listMutableListOf.add(Integer.valueOf(iNextInt2));
        }
        listMutableListOf.add(1000);
        ProgressBar progressBar = getBinding().progress;
        int[] intArray = CollectionsKt.toIntArray(listMutableListOf);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(progressBar, "progress", Arrays.copyOf(intArray, intArray.length));
        try {
            objectAnimatorOfInt.getClass().getMethod("setDurationScale", Float.TYPE).invoke(null, Float.valueOf(1.0f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        objectAnimatorOfInt.setDuration(3500L);
        objectAnimatorOfInt.setInterpolator(accelerateInterpolator);
        Intrinsics.checkNotNull(objectAnimatorOfInt);
        objectAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$onStart$lambda$5$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfInt.start();
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    /* compiled from: CustomSplashFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$onStart$2", f = "CustomSplashFragment.kt", l = {296, 298}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$onStart$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomSplashFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0083 -> B:35:0x00ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0088 -> B:35:0x00ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008d -> B:35:0x00ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009b -> B:34:0x009e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                int r1 = r9.I$1
                int r4 = r9.I$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L9e
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1f:
                int r1 = r9.I$1
                int r4 = r9.I$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lad
            L28:
                kotlin.ResultKt.throwOnFailure(r10)
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.this
                java.lang.Integer r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$getLastCountDownMilliseconds$p(r10)
                if (r10 == 0) goto L3d
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.this
                java.lang.Integer r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$getLastCountDownMilliseconds$p(r10)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
                goto L43
            L3d:
                r4 = 3500(0xdac, double:1.729E-320)
                java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            L43:
                int r10 = r10.intValue()
                r1 = 0
                r4 = -500(0xfffffffffffffe0c, float:NaN)
                int r1 = kotlin.internal.ProgressionUtilKt.getProgressionLastElement(r10, r1, r4)
                if (r1 > r10) goto Lb2
                r4 = r10
            L51:
                r10 = 1000(0x3e8, float:1.401E-42)
                if (r4 < r10) goto L6a
                int r10 = r4 % 1000
                if (r10 != 0) goto L6a
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.this
                sputnik.axmor.com.databinding.FragmentSplashCustomScreenBinding r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$getBinding(r10)
                android.widget.TextView r10 = r10.tvTimer
                int r5 = r4 / 1000
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r10.setText(r5)
            L6a:
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.this
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$setLastCountDownMilliseconds$p(r10, r5)
                int r10 = r4 % 1000
                r5 = 1000(0x3e8, double:4.94E-321)
                if (r10 != 0) goto L86
                r9.I$0 = r4
                r9.I$1 = r1
                r9.label = r3
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
                if (r10 != r0) goto Lad
                return r0
            L86:
                int r10 = r4 % 500
                if (r10 != 0) goto Lad
                long r7 = (long) r4
                int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r10 >= 0) goto Lad
                r9.I$0 = r4
                r9.I$1 = r1
                r9.label = r2
                r5 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
                if (r10 != r0) goto L9e
                return r0
            L9e:
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment r10 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.this
                com.sputnik.common.viewmodels.ProfileViewModel r5 = sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$getProfileViewModel(r10)
                com.sputnik.common.base.VMState r5 = r5.getCurrentState()
                com.sputnik.common.viewmodels.ProfileViewState r5 = (com.sputnik.common.viewmodels.ProfileViewState) r5
                sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.access$navigateWithProfileState(r10, r5)
            Lad:
                if (r4 == r1) goto Lb2
                int r4 = r4 + (-500)
                goto L51
            Lb2:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Number number = this.lastCountDownMilliseconds;
        if (number == null) {
            number = 3500L;
        }
        outState.putInt("last_count_down_millis", number.intValue());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needNavigate) {
            doUnblocked(true);
        }
    }

    private final void initVideoView() {
        FragmentSplashCustomScreenBinding binding = getBinding();
        ConstraintLayout layoutVideo = binding.layoutVideo;
        Intrinsics.checkNotNullExpressionValue(layoutVideo, "layoutVideo");
        ViewKt.visible(layoutVideo);
        SimpleExoPlayerView viewVideo = binding.viewVideo;
        Intrinsics.checkNotNullExpressionValue(viewVideo, "viewVideo");
        ViewKt.visible(viewVideo);
        TextSwitcher tvSplash = binding.tvSplash;
        Intrinsics.checkNotNullExpressionValue(tvSplash, "tvSplash");
        ViewKt.visible(tvSplash);
        ImageView ivOurHome = binding.ivOurHome;
        Intrinsics.checkNotNullExpressionValue(ivOurHome, "ivOurHome");
        ViewKt.gone(ivOurHome);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomSplashFragment$initVideoView$1$1(this, null), 3, null);
        SimpleExoPlayer simpleExoPlayerBuild = new SimpleExoPlayer.Builder(requireContext()).build();
        Player.AudioComponent audioComponent = simpleExoPlayerBuild.getAudioComponent();
        if (audioComponent != null) {
            audioComponent.setVolume(0.0f);
        }
        simpleExoPlayerBuild.addListener(new Player.EventListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$initVideoView$1$2$1
            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackStateChanged(int state) {
                super.onPlaybackStateChanged(state);
            }
        });
        this.player = simpleExoPlayerBuild;
        Intrinsics.checkNotNullExpressionValue(RawResourceDataSource.buildRawResourceUri(R.raw.start_screen).toString(), "toString(...)");
        Uri uriBuildRawResourceUri = RawResourceDataSource.buildRawResourceUri(R.raw.start_screen);
        Intrinsics.checkNotNullExpressionValue(uriBuildRawResourceUri, "buildRawResourceUri(...)");
        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(uriBuildRawResourceUri, new DefaultDataSourceFactory(requireContext(), "MyExoplayer"), new DefaultExtractorsFactory(), null, null);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.prepare(extractorMediaSource);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setRepeatMode(2);
        }
        binding.viewVideo.setPlayer(this.player);
        binding.viewVideo.setResizeMode(4);
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.setPlayWhenReady(true);
        }
        binding.btnPromote1.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomSplashFragment.initVideoView$lambda$10$lambda$7(this.f$0, view);
            }
        });
        binding.btnPromote2.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomSplashFragment.initVideoView$lambda$10$lambda$8(this.f$0, view);
            }
        });
        binding.btnPromote3.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomSplashFragment.initVideoView$lambda$10$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVideoView$lambda$10$lambda$7(CustomSplashFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVideoView$lambda$10$lambda$8(CustomSplashFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.accelerating_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVideoView$lambda$10$lambda$9(CustomSplashFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.close_icon);
    }

    private final void initializePromotion() {
        ScreenVariants screenVariants = ScreenVariants.text;
        String string = Varioqub.getString("splash_screen_close_button", screenVariants.toString());
        LogUtilsKt.writeLog("Varioqub", "Get id: " + Varioqub.getId());
        LogUtilsKt.writeLog("Varioqub", "Got flag: " + string);
        if (Intrinsics.areEqual(string, screenVariants.toString())) {
            TextView btnPromote1 = getBinding().btnPromote1;
            Intrinsics.checkNotNullExpressionValue(btnPromote1, "btnPromote1");
            ViewKt.visible(btnPromote1);
            return;
        }
        if (Intrinsics.areEqual(string, ScreenVariants.accelerating_icon.toString())) {
            ImageView ivBackground = getBinding().ivBackground;
            Intrinsics.checkNotNullExpressionValue(ivBackground, "ivBackground");
            ViewKt.gone(ivBackground);
            ImageView ivPromotionBackground = getBinding().ivPromotionBackground;
            Intrinsics.checkNotNullExpressionValue(ivPromotionBackground, "ivPromotionBackground");
            ViewKt.gone(ivPromotionBackground);
            ImageView btnPromote2 = getBinding().btnPromote2;
            Intrinsics.checkNotNullExpressionValue(btnPromote2, "btnPromote2");
            ViewKt.visible(btnPromote2);
            ImageView ivPromote2Background = getBinding().ivPromote2Background;
            Intrinsics.checkNotNullExpressionValue(ivPromote2Background, "ivPromote2Background");
            ViewKt.visible(ivPromote2Background);
            return;
        }
        if (Intrinsics.areEqual(string, ScreenVariants.close_icon.toString())) {
            ImageView btnPromote3 = getBinding().btnPromote3;
            Intrinsics.checkNotNullExpressionValue(btnPromote3, "btnPromote3");
            ViewKt.visible(btnPromote3);
        }
    }

    private final void launchPromotion(ScreenVariants variant) {
        TextView tvTimer = getBinding().tvTimer;
        Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
        ViewKt.visible(tvTimer);
        ImageView ivTimerBackground = getBinding().ivTimerBackground;
        Intrinsics.checkNotNullExpressionValue(ivTimerBackground, "ivTimerBackground");
        ViewKt.visible(ivTimerBackground);
        int i = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
        if (i == 1) {
            getAnalytics().trackLogEvent(new ABExperimentsEvents.ShowDetFastLoadingCloseIcon());
        } else if (i == 2) {
            getAnalytics().trackLogEvent(new ABExperimentsEvents.ShowDetFastLoadingText());
        } else if (i == 3) {
            getAnalytics().trackLogEvent(new ABExperimentsEvents.ShowDetFastLoadingAcceleratingIcon());
        }
        StaticVariables.INSTANCE.setNavigationClickMethod(variant);
        getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(0, null, BundleKt.bundleOf(), NavigationTypes.custom))), false, 4, null));
    }

    private final void loadLocalPrefs() {
        SplashBody body;
        String fullAddress;
        SplashScreen splashScreen;
        String title;
        SplashScreen splashScreen2;
        byte[] bArrDecode;
        SplashScreen splashScreen3;
        ProfileSettings localProfileSettings = getProfileViewModel().getLocalProfileSettings();
        if (((localProfileSettings == null || (splashScreen3 = localProfileSettings.getSplashScreen()) == null) ? null : splashScreen3.getBackgroundBase64()) != null) {
            try {
                SplashScreen splashScreen4 = localProfileSettings.getSplashScreen();
                bArrDecode = Base64.decode(splashScreen4 != null ? splashScreen4.getBackgroundBase64() : null, 0);
            } catch (Exception unused) {
                bArrDecode = null;
            }
            if (bArrDecode != null) {
                BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            }
        }
        FragmentSplashCustomScreenBinding binding = getBinding();
        if (((localProfileSettings == null || (splashScreen2 = localProfileSettings.getSplashScreen()) == null) ? null : splashScreen2.getTitle()) != null && (splashScreen = localProfileSettings.getSplashScreen()) != null && (title = splashScreen.getTitle()) != null && (!StringsKt.isBlank(title))) {
            TextView textView = binding.tvTitle;
            SplashScreen splashScreen5 = localProfileSettings.getSplashScreen();
            textView.setText(splashScreen5 != null ? splashScreen5.getTitle() : null);
        } else {
            LocalizationLocalModel data = getLocalizationScreen().getData();
            SplashLocale splash = data != null ? data.getSplash() : null;
            if (splash != null && (body = splash.getBody()) != null) {
                TextView textView2 = getBinding().tvTitle;
                TitleWithParam title2 = body.getTitle();
                String strValueOf = String.valueOf(title2 != null ? title2.getTitle() : null);
                TitleWithParam title3 = body.getTitle();
                textView2.setText(ViewUtilsKt.highlightText(strValueOf, String.valueOf(title3 != null ? title3.getParam1() : null), ContextCompat.getColor(requireContext(), R.color.sputnik_red)));
            }
        }
        if (localProfileSettings == null || (fullAddress = localProfileSettings.getFullAddress()) == null) {
            return;
        }
        binding.tvSubtitle.setText(fullAddress);
    }

    private final void setupText() {
        getBinding().tvSplash.setInAnimation(getContext(), R.anim.slide_in_up);
        getBinding().tvSplash.setOutAnimation(getContext(), R.anim.slide_out_down);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderState(ProfileViewState data) {
        TextSwitcher tvSplash = getBinding().tvSplash;
        Intrinsics.checkNotNullExpressionValue(tvSplash, "tvSplash");
        Resource.Status profileServerState = data.getProfileServerState();
        Resource.Status status = Resource.Status.ERROR;
        ViewBindingUtilsKt.visibilityHideBasedOn(tvSplash, (profileServerState == status || getProfileViewModel().haveSubscription() || !getProfileViewModel().getIsLoggedIn()) ? false : true);
        if (data.getServerState() == status) {
            Exception exception = data.getException();
            Intrinsics.checkNotNull(exception);
            doWithError(exception);
            return;
        }
        renderUi(data);
    }

    private final void renderUi(ProfileViewState data) {
        if (data.getProfileServerState() == Resource.Status.SUCCESS) {
            ProfileNavigationState profileNavigationStatePeekContent = data.getProfileState().peekContent();
            if (profileNavigationStatePeekContent instanceof ProfileNavigationState.ToActivatedState) {
                doUnblocked(this.needNavigate);
                return;
            }
            if (profileNavigationStatePeekContent instanceof ProfileNavigationState.ToLoginState ? true : profileNavigationStatePeekContent instanceof ProfileNavigationState.Default) {
                return;
            }
            navigateToStart(this.needNavigate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateWithProfileState(ProfileViewState data) {
        ProfileNavigationState profileNavigationStatePeekContent = data.getProfileState().peekContent();
        if (profileNavigationStatePeekContent instanceof ProfileNavigationState.ToActivatedState) {
            doUnblocked(true);
            return;
        }
        if (profileNavigationStatePeekContent instanceof ProfileNavigationState.ToLoginState ? true : profileNavigationStatePeekContent instanceof ProfileNavigationState.Default) {
            return;
        }
        navigateToStart(true);
    }

    private final void doUnblocked(boolean navigate) {
        String phoneLocale;
        FragmentActivity activity;
        if (!getProfileViewModel().haveSubscription() && getProfileViewModel().getIsLoggedIn()) {
            if (!navigate || (activity = getActivity()) == null) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    CustomSplashFragment.doUnblocked$lambda$20(this.f$0);
                }
            });
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    CustomSplashFragment.doUnblocked$lambda$18(this.f$0);
                }
            });
        }
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        PrefManager prefManager = getPrefManager();
        if (profile == null || (phoneLocale = profile.getLocalization()) == null) {
            phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
        }
        prefManager.updateUserLocale(phoneLocale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doUnblocked$lambda$18(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToMainHostFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doUnblocked$lambda$20(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToMainHostFragment());
    }

    static /* synthetic */ void navigateToStart$default(CustomSplashFragment customSplashFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        customSplashFragment.navigateToStart(z);
    }

    private final void navigateToStart(boolean navigate) {
        if (getProfileViewModel().haveSubscription() || !getProfileViewModel().getIsLoggedIn()) {
            if (getPrefManager().getIsNeedShowStartOnBoarding()) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            CustomSplashFragment.navigateToStart$lambda$21(this.f$0);
                        }
                    });
                    return;
                }
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        CustomSplashFragment.navigateToStart$lambda$22(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        if (navigate) {
            if (getPrefManager().getIsNeedShowStartOnBoarding()) {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            CustomSplashFragment.navigateToStart$lambda$23(this.f$0);
                        }
                    });
                    return;
                }
                return;
            }
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                activity4.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        CustomSplashFragment.navigateToStart$lambda$24(this.f$0);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToStart$lambda$21(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToFirstSignNavigation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToStart$lambda$22(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashToAuth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToStart$lambda$23(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashFragmentToFirstSignNavigation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToStart$lambda$24(CustomSplashFragment this$0) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate(this$0.getNavController(), CustomSplashFragmentDirections.INSTANCE.actionSplashToAuth());
    }

    private final void doWithError(Exception e) {
        TextSubtitle unknown;
        TextSubtitle timeout;
        TextSubtitle timeout2;
        TextSubtitle unknown2;
        TextSubtitle unknown3;
        TextSubtitle serverDied;
        TextSubtitle serverDied2;
        SplashLocale splash;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        SplashErrorsLocale errors = (data == null || (splash = data.getSplash()) == null) ? null : splash.getErrors();
        Log.e("error", e.toString());
        if (e instanceof Errors.AuthException) {
            getProfileViewModel().cleanState();
            navigateToStart$default(this, false, 1, null);
            return;
        }
        if (e instanceof Errors.ServerDied) {
            String title2 = (errors == null || (serverDied2 = errors.getServerDied()) == null) ? null : serverDied2.getTitle();
            if (errors != null && (serverDied = errors.getServerDied()) != null) {
                title = serverDied.getSubtitle();
            }
            showErrorDialog(title2, title);
            return;
        }
        if (e instanceof UnknownHostException) {
            String title3 = (errors == null || (unknown3 = errors.getUnknown()) == null) ? null : unknown3.getTitle();
            if (errors != null && (unknown2 = errors.getUnknown()) != null) {
                title = unknown2.getSubtitle();
            }
            showErrorDialog(title3, title);
            return;
        }
        if (e instanceof SocketTimeoutException) {
            String title4 = (errors == null || (timeout2 = errors.getTimeout()) == null) ? null : timeout2.getTitle();
            if (errors != null && (timeout = errors.getTimeout()) != null) {
                title = timeout.getSubtitle();
            }
            showErrorDialog(title4, title);
            return;
        }
        ProfileViewModel profileViewModel = getProfileViewModel();
        String message = e.getMessage();
        if (message == null) {
            if (errors != null && (unknown = errors.getUnknown()) != null) {
                title = unknown.getTitle();
            }
            message = title == null ? "Error" : title;
        }
        profileViewModel.notifyErrorMessage(message);
    }

    /* compiled from: CustomSplashFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/AlertDialog;", "view", "Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$showErrorDialog$2, reason: invalid class name and case insensitive filesystem */
    static final class C27032 extends Lambda implements Function2<AlertDialog, DialogErrorSplashBinding, Unit> {
        final /* synthetic */ String $msg;
        final /* synthetic */ String $title;
        final /* synthetic */ CustomSplashFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27032(String str, String str2, CustomSplashFragment customSplashFragment) {
            super(2);
            this.$title = str;
            this.$msg = str2;
            this.this$0 = customSplashFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, DialogErrorSplashBinding dialogErrorSplashBinding) {
            invoke2(alertDialog, dialogErrorSplashBinding);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final AlertDialog dialog, DialogErrorSplashBinding view) {
            String title;
            SplashLocale splash;
            TextTitle errorButton;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(view, "view");
            String str = this.$title;
            String str2 = this.$msg;
            final CustomSplashFragment customSplashFragment = this.this$0;
            TextView textView = view.errorName;
            if (str == null) {
                str = "Something went wrong";
            }
            textView.setText(str);
            TextView textView2 = view.errorAdvice;
            if (str2 == null) {
                str2 = ":(";
            }
            textView2.setText(str2);
            AppCompatButton appCompatButton = view.btnRepeat;
            LocalizationLocalModel data = customSplashFragment.getLocalizationScreen().getData();
            if (data == null || (splash = data.getSplash()) == null || (errorButton = splash.getErrorButton()) == null || (title = errorButton.getTitle()) == null) {
                title = "Repeat";
            }
            appCompatButton.setText(title);
            view.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$showErrorDialog$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CustomSplashFragment.C27032.invoke$lambda$1$lambda$0(customSplashFragment, dialog, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1$lambda$0(CustomSplashFragment this$0, AlertDialog dialog, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            IProfileViewModel.DefaultImpls.loadProfile$default(this$0.getProfileViewModel(), false, 1, null);
            dialog.dismiss();
        }
    }

    /* compiled from: CustomSplashFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment$showErrorDialog$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogErrorSplashBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, DialogErrorSplashBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", 0);
        }

        public final DialogErrorSplashBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogErrorSplashBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogErrorSplashBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    private final void showErrorDialog(String title, String msg) {
        SimpleDialog.Companion companion = SimpleDialog.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.newInstance(contextRequireContext, AnonymousClass1.INSTANCE, new C27032(title, msg, this));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.release();
        }
        this.player = null;
    }
}
