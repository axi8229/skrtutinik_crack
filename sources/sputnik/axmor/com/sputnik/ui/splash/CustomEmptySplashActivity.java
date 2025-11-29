package sputnik.axmor.com.sputnik.ui.splash;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.OnBackPressedCallback;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.sputnik.common.StaticVariables;
import com.sputnik.common.analytics.ABExperimentsEvents;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SplashBody;
import com.sputnik.common.entities.localization.SplashLocale;
import com.sputnik.common.entities.promotion.ScreenVariants;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.prefs.VersionModel;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.yandex.varioqub.config.Varioqub;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSplashCustomScreenBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;
import sputnik.axmor.com.sputnik.ui.splash.viewmodel.SplashViewModel;
import sputnik.axmor.com.sputnik.ui.splash.viewmodel.SplashViewState;

/* compiled from: CustomEmptySplashActivity.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0003R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010N\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/CustomEmptySplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "initializePromotion", "initViews", "Lcom/sputnik/common/entities/promotion/ScreenVariants;", "variant", "launchPromotion", "(Lcom/sputnik/common/entities/promotion/ScreenVariants;)V", "initVideoView", "setupText", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "outState", "onSaveInstanceState", "onPause", "onBackPressed", "onDestroy", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", "binding", "Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", "Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewModel;", "splashViewModel$delegate", "Lkotlin/Lazy;", "getSplashViewModel", "()Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewModel;", "splashViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "Lkotlinx/coroutines/Job;", "timerJob", "Lkotlinx/coroutines/Job;", "", "lastCountDownMilliseconds", "Ljava/lang/Integer;", "", "", "getLoadingTexts", "()Ljava/util/List;", "loadingTexts", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomEmptySplashActivity extends AppCompatActivity {
    public Analytics analytics;
    private FragmentSplashCustomScreenBinding binding;
    public MultiViewModelFactory factory;
    private Integer lastCountDownMilliseconds;
    public LocalizationStorage localizationScreen;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private SimpleExoPlayer player;
    public PrefManager prefManager;

    /* renamed from: splashViewModel$delegate, reason: from kotlin metadata */
    private final Lazy splashViewModel;
    private Job timerJob;

    /* compiled from: CustomEmptySplashActivity.kt */
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

    public CustomEmptySplashActivity() {
        final Function0 function0 = null;
        this.splashViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SplashViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$splashViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$special$$inlined$viewModels$default$3
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
        this.navigationViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$special$$inlined$viewModels$default$6
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

    private final SplashViewModel getSplashViewModel() {
        return (SplashViewModel) this.splashViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBindingInflate = FragmentSplashCustomScreenBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(fragmentSplashCustomScreenBindingInflate, "inflate(...)");
        this.binding = fragmentSplashCustomScreenBindingInflate;
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = null;
        if (fragmentSplashCustomScreenBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBindingInflate = null;
        }
        ConstraintLayout layoutActions = fragmentSplashCustomScreenBindingInflate.layoutActions;
        Intrinsics.checkNotNullExpressionValue(layoutActions, "layoutActions");
        ViewKt.addSystemWindowInsetToMargin$default(layoutActions, false, true, false, true, 5, null);
        this.lastCountDownMilliseconds = savedInstanceState != null ? Integer.valueOf(savedInstanceState.getInt("last_count_down_millis", 3500)) : null;
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding2 = this.binding;
        if (fragmentSplashCustomScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSplashCustomScreenBinding = fragmentSplashCustomScreenBinding2;
        }
        ConstraintLayout root = fragmentSplashCustomScreenBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        setContentView(root);
        setupText();
        initViews();
        AppCompatDelegate.setDefaultNightMode(1);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.onCreate.1
            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
        getSplashViewModel().observeState(this, new Function1<SplashViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.onCreate.2
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
                FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding3 = CustomEmptySplashActivity.this.binding;
                if (fragmentSplashCustomScreenBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSplashCustomScreenBinding3 = null;
                }
                TextSwitcher textSwitcher = fragmentSplashCustomScreenBinding3.tvSplash;
                List loadingTexts = CustomEmptySplashActivity.this.getLoadingTexts();
                if (loadingTexts != null) {
                    CustomEmptySplashActivity customEmptySplashActivity = CustomEmptySplashActivity.this;
                    if (curLoaderIndex < 0 || curLoaderIndex > CollectionsKt.getLastIndex(loadingTexts)) {
                        List loadingTexts2 = customEmptySplashActivity.getLoadingTexts();
                        obj = loadingTexts2 != null ? (String) CollectionsKt.firstOrNull(loadingTexts2) : null;
                    } else {
                        obj = loadingTexts.get(curLoaderIndex);
                    }
                    str = (String) obj;
                }
                textSwitcher.setText(str);
            }
        });
        initVideoView();
        initializePromotion();
    }

    private final void initializePromotion() {
        ScreenVariants screenVariants = ScreenVariants.text;
        String string = Varioqub.getString("splash_screen_close_button", screenVariants.toString());
        LogUtilsKt.writeLog("Varioqub", "Get id: " + Varioqub.getId());
        LogUtilsKt.writeLog("Varioqub", "Got flag: " + string);
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = null;
        if (Intrinsics.areEqual(string, screenVariants.toString())) {
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding2 = this.binding;
            if (fragmentSplashCustomScreenBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSplashCustomScreenBinding = fragmentSplashCustomScreenBinding2;
            }
            TextView btnPromote1 = fragmentSplashCustomScreenBinding.btnPromote1;
            Intrinsics.checkNotNullExpressionValue(btnPromote1, "btnPromote1");
            ViewKt.visible(btnPromote1);
            return;
        }
        if (Intrinsics.areEqual(string, ScreenVariants.accelerating_icon.toString())) {
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding3 = this.binding;
            if (fragmentSplashCustomScreenBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSplashCustomScreenBinding3 = null;
            }
            ImageView ivBackground = fragmentSplashCustomScreenBinding3.ivBackground;
            Intrinsics.checkNotNullExpressionValue(ivBackground, "ivBackground");
            ViewKt.gone(ivBackground);
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding4 = this.binding;
            if (fragmentSplashCustomScreenBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSplashCustomScreenBinding4 = null;
            }
            ImageView ivPromotionBackground = fragmentSplashCustomScreenBinding4.ivPromotionBackground;
            Intrinsics.checkNotNullExpressionValue(ivPromotionBackground, "ivPromotionBackground");
            ViewKt.gone(ivPromotionBackground);
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding5 = this.binding;
            if (fragmentSplashCustomScreenBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSplashCustomScreenBinding5 = null;
            }
            ImageView btnPromote2 = fragmentSplashCustomScreenBinding5.btnPromote2;
            Intrinsics.checkNotNullExpressionValue(btnPromote2, "btnPromote2");
            ViewKt.visible(btnPromote2);
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding6 = this.binding;
            if (fragmentSplashCustomScreenBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSplashCustomScreenBinding = fragmentSplashCustomScreenBinding6;
            }
            ImageView ivPromote2Background = fragmentSplashCustomScreenBinding.ivPromote2Background;
            Intrinsics.checkNotNullExpressionValue(ivPromote2Background, "ivPromote2Background");
            ViewKt.visible(ivPromote2Background);
            return;
        }
        if (Intrinsics.areEqual(string, ScreenVariants.close_icon.toString())) {
            FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding7 = this.binding;
            if (fragmentSplashCustomScreenBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSplashCustomScreenBinding = fragmentSplashCustomScreenBinding7;
            }
            ImageView btnPromote3 = fragmentSplashCustomScreenBinding.btnPromote3;
            Intrinsics.checkNotNullExpressionValue(btnPromote3, "btnPromote3");
            ViewKt.visible(btnPromote3);
        }
    }

    private final void initViews() {
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = this.binding;
        if (fragmentSplashCustomScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding = null;
        }
        fragmentSplashCustomScreenBinding.btnPromote1.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomEmptySplashActivity.initViews$lambda$4$lambda$1(this.f$0, view);
            }
        });
        fragmentSplashCustomScreenBinding.btnPromote2.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomEmptySplashActivity.initViews$lambda$4$lambda$2(this.f$0, view);
            }
        });
        fragmentSplashCustomScreenBinding.btnPromote3.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomEmptySplashActivity.initViews$lambda$4$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$1(CustomEmptySplashActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$2(CustomEmptySplashActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.accelerating_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$3(CustomEmptySplashActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchPromotion(ScreenVariants.close_icon);
    }

    private final void launchPromotion(ScreenVariants variant) {
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = this.binding;
        if (fragmentSplashCustomScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding = null;
        }
        TextView tvTimer = fragmentSplashCustomScreenBinding.tvTimer;
        Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
        ViewKt.visible(tvTimer);
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding2 = this.binding;
        if (fragmentSplashCustomScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding2 = null;
        }
        ImageView ivTimerBackground = fragmentSplashCustomScreenBinding2.ivTimerBackground;
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
        NavigationViewModel navigationViewModel = getNavigationViewModel();
        Subscriptions subscriptions = Subscriptions.standard;
        String string = subscriptions.toString();
        NavigationTypes navigationTypes = NavigationTypes.custom;
        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf((Object[]) new NavigationAction[]{new NavigationAction(R.id.action_to_subscriptions_navigation, string, null, navigationTypes), new NavigationAction(R.id.action_fragmentSubscriptionDetails_to_bottomSheetAboutService, subscriptions.toString(), null, navigationTypes)})), false, 4, null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        TimeInterpolator accelerateInterpolator;
        super.onStart();
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = this.binding;
        if (fragmentSplashCustomScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding = null;
        }
        fragmentSplashCustomScreenBinding.progress.setMax(1000);
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
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding2 = this.binding;
        if (fragmentSplashCustomScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding2 = null;
        }
        ProgressBar progressBar = fragmentSplashCustomScreenBinding2.progress;
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
        objectAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$onStart$lambda$7$$inlined$doOnEnd$1
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
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C27022(null), 3, null);
    }

    /* compiled from: CustomEmptySplashActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$onStart$2", f = "CustomEmptySplashActivity.kt", l = {234, 236}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$onStart$2, reason: invalid class name and case insensitive filesystem */
    static final class C27022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int label;

        C27022(Continuation<? super C27022> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomEmptySplashActivity.this.new C27022(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008b -> B:38:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0090 -> B:38:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0095 -> B:38:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a3 -> B:37:0x00a6). Please report as a decompilation issue!!! */
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
                goto La6
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1f:
                int r1 = r9.I$1
                int r4 = r9.I$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lab
            L28:
                kotlin.ResultKt.throwOnFailure(r10)
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.this
                java.lang.Integer r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.access$getLastCountDownMilliseconds$p(r10)
                if (r10 == 0) goto L3d
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.this
                java.lang.Integer r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.access$getLastCountDownMilliseconds$p(r10)
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
                if (r1 > r10) goto Lb0
                r4 = r10
            L51:
                r10 = 1000(0x3e8, float:1.401E-42)
                if (r4 < r10) goto L72
                int r10 = r4 % 1000
                if (r10 != 0) goto L72
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.this
                sputnik.axmor.com.databinding.FragmentSplashCustomScreenBinding r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.access$getBinding$p(r10)
                if (r10 != 0) goto L67
                java.lang.String r10 = "binding"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
                r10 = 0
            L67:
                android.widget.TextView r10 = r10.tvTimer
                int r5 = r4 / 1000
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r10.setText(r5)
            L72:
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.this
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.access$setLastCountDownMilliseconds$p(r10, r5)
                int r10 = r4 % 1000
                r5 = 1000(0x3e8, double:4.94E-321)
                if (r10 != 0) goto L8e
                r9.I$0 = r4
                r9.I$1 = r1
                r9.label = r3
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
                if (r10 != r0) goto Lab
                return r0
            L8e:
                int r10 = r4 % 500
                if (r10 != 0) goto Lab
                long r7 = (long) r4
                int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r10 >= 0) goto Lab
                r9.I$0 = r4
                r9.I$1 = r1
                r9.label = r2
                r5 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
                if (r10 != r0) goto La6
                return r0
            La6:
                sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity r10 = sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.this
                r10.finish()
            Lab:
                if (r4 == r1) goto Lb0
                int r4 = r4 + (-500)
                goto L51
            Lb0:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity.C27022.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Number number = this.lastCountDownMilliseconds;
        if (number == null) {
            number = 3500L;
        }
        outState.putInt("last_count_down_millis", number.intValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        SputnikRootActivity.INSTANCE.setNeedGoToSplash(false);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SputnikRootActivity.INSTANCE.setNeedGoToSplash(false);
    }

    private final void initVideoView() {
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = this.binding;
        if (fragmentSplashCustomScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding = null;
        }
        SimpleExoPlayerView viewVideo = fragmentSplashCustomScreenBinding.viewVideo;
        Intrinsics.checkNotNullExpressionValue(viewVideo, "viewVideo");
        ViewKt.visible(viewVideo);
        TextSwitcher tvSplash = fragmentSplashCustomScreenBinding.tvSplash;
        Intrinsics.checkNotNullExpressionValue(tvSplash, "tvSplash");
        ViewKt.visible(tvSplash);
        ImageView ivOurHome = fragmentSplashCustomScreenBinding.ivOurHome;
        Intrinsics.checkNotNullExpressionValue(ivOurHome, "ivOurHome");
        ViewKt.gone(ivOurHome);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_out);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomEmptySplashActivity$initVideoView$1$1(null), 3, null);
        SimpleExoPlayer simpleExoPlayerBuild = new SimpleExoPlayer.Builder(this).build();
        Player.AudioComponent audioComponent = simpleExoPlayerBuild.getAudioComponent();
        if (audioComponent != null) {
            audioComponent.setVolume(0.0f);
        }
        simpleExoPlayerBuild.addListener(new Player.EventListener() { // from class: sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity$initVideoView$1$2$1
            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackStateChanged(int state) {
                super.onPlaybackStateChanged(state);
                if (state == 4) {
                    SputnikRootActivity.INSTANCE.setNeedGoToSplash(false);
                }
            }
        });
        this.player = simpleExoPlayerBuild;
        Intrinsics.checkNotNullExpressionValue(RawResourceDataSource.buildRawResourceUri(R.raw.start_screen).toString(), "toString(...)");
        Uri uriBuildRawResourceUri = RawResourceDataSource.buildRawResourceUri(R.raw.start_screen);
        Intrinsics.checkNotNullExpressionValue(uriBuildRawResourceUri, "buildRawResourceUri(...)");
        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(uriBuildRawResourceUri, new DefaultDataSourceFactory(this, "MyExoplayer"), new DefaultExtractorsFactory(), null, null);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.prepare(extractorMediaSource);
        }
        fragmentSplashCustomScreenBinding.viewVideo.setPlayer(this.player);
        fragmentSplashCustomScreenBinding.viewVideo.setResizeMode(4);
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == null) {
            return;
        }
        simpleExoPlayer2.setPlayWhenReady(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
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

    private final void setupText() {
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding = this.binding;
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding2 = null;
        if (fragmentSplashCustomScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSplashCustomScreenBinding = null;
        }
        fragmentSplashCustomScreenBinding.tvSplash.setInAnimation(this, R.anim.slide_in_up);
        FragmentSplashCustomScreenBinding fragmentSplashCustomScreenBinding3 = this.binding;
        if (fragmentSplashCustomScreenBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSplashCustomScreenBinding2 = fragmentSplashCustomScreenBinding3;
        }
        fragmentSplashCustomScreenBinding2.tvSplash.setOutAnimation(this, R.anim.slide_out_down);
    }
}
