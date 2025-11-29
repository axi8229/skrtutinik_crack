package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.google.common.util.concurrent.ListenableFuture;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FaceRecognitionMainLocale;
import com.sputnik.common.entities.localization.FaceRecognitionStartBody;
import com.sputnik.common.entities.localization.FaceRecognitionStartLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.roadar.facerecog.Constants;
import ru.roadar.facerecog.FaceAnalyzer;
import ru.roadar.facerecog.FaceProcessNative;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentFrCameraBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel.FrServiceViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel.FrServiceViewState;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: ShotFragment.kt */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005*\u0001g\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010ER)\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010H0G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00107\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/ShotFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "repeatFR", "showFRError", "", "isCorrect", "Lru/roadar/facerecog/FaceProcessNative$ProcessState;", "state", "onFrameProcessed", "(ZLru/roadar/facerecog/FaceProcessNative$ProcessState;)V", "", "curProgress", "raiseProgress", "(Lru/roadar/facerecog/FaceProcessNative$ProcessState;I)V", "isFacesState", "(Lru/roadar/facerecog/FaceProcessNative$ProcessState;)Z", "downProgress", "bindCameraUseCases", "width", "height", "aspectRatio", "(II)I", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "localize", "initViews", "Lsputnik/axmor/com/databinding/FragmentFrCameraBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentFrCameraBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewModel;", "frServiceViewModel$delegate", "Lkotlin/Lazy;", "getFrServiceViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewModel;", "frServiceViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroid/hardware/display/DisplayManager;", "displayManager$delegate", "getDisplayManager", "()Landroid/hardware/display/DisplayManager;", "displayManager", "", "", "facesStatesName$delegate", "getFacesStatesName", "()Ljava/util/Map;", "facesStatesName", "displayId", "I", "lensFacing", "Landroidx/camera/core/Preview;", "preview", "Landroidx/camera/core/Preview;", "Landroidx/camera/core/ImageAnalysis;", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "Landroidx/camera/core/Camera;", "camera", "Landroidx/camera/core/Camera;", "Ljava/util/concurrent/ExecutorService;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "Lru/roadar/facerecog/FaceAnalyzer;", "faceAnalyzer", "Lru/roadar/facerecog/FaceAnalyzer;", "Lru/roadar/facerecog/FaceProcessNative;", "faceProcess", "Lru/roadar/facerecog/FaceProcessNative;", "isAlive", "Z", "isDone", "lastState", "Lru/roadar/facerecog/FaceProcessNative$ProcessState;", "sputnik/axmor/com/sputnik/ui/main/market/services/fr_service/ShotFragment$displayListener$1", "displayListener", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/ShotFragment$displayListener$1;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShotFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ShotFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentFrCameraBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    private Camera camera;
    private ExecutorService cameraExecutor;
    private int displayId;
    private final ShotFragment$displayListener$1 displayListener;

    /* renamed from: displayManager$delegate, reason: from kotlin metadata */
    private final Lazy displayManager;
    private FaceAnalyzer faceAnalyzer;
    private FaceProcessNative faceProcess;

    /* renamed from: facesStatesName$delegate, reason: from kotlin metadata */
    private final Lazy facesStatesName;
    public MultiViewModelFactory factory;

    /* renamed from: frServiceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy frServiceViewModel;
    private ImageAnalysis imageAnalyzer;
    private boolean isAlive;
    private boolean isDone;
    private FaceProcessNative.ProcessState lastState;
    private int lensFacing;
    public LocalizationStorage localizationScreen;
    private Preview preview;

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentFrCameraBinding getBinding() {
        return (FragmentFrCameraBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final FrServiceViewModel getFrServiceViewModel() {
        return (FrServiceViewModel) this.frServiceViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    private final DisplayManager getDisplayManager() {
        return (DisplayManager) this.displayManager.getValue();
    }

    private final Map<FaceProcessNative.ProcessState, String> getFacesStatesName() {
        return (Map) this.facesStatesName.getValue();
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
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.FaceRecognizerSettingsEventName.INSTANCE.getParentScreen(), "start", null, 4, null);
        FrServiceViewModel frServiceViewModel = getFrServiceViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        frServiceViewModel.observeSubState(viewLifecycleOwner, new Function1<FrServiceViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(FrServiceViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerStatus();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.2

            /* compiled from: ShotFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$onViewCreated$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) {
                invoke2(status);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource.Status it) {
                Intrinsics.checkNotNullParameter(it, "it");
                int i = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                if (i == 1) {
                    ProgressBar progressBar = ShotFragment.this.getBinding().progressFrStatus;
                    progressBar.setProgressDrawable(ContextCompat.getDrawable(progressBar.getContext(), R.drawable.bg_progress_fr));
                    progressBar.setIndeterminate(true);
                } else if (i == 2) {
                    ProgressBar progressBar2 = ShotFragment.this.getBinding().progressFrStatus;
                    progressBar2.setProgress(0);
                    progressBar2.setIndeterminate(false);
                } else {
                    if (i != 3) {
                        return;
                    }
                    ProgressBar progressBar3 = ShotFragment.this.getBinding().progressFrStatus;
                    progressBar3.setProgress(0);
                    progressBar3.setIndeterminate(false);
                }
            }
        });
        FrServiceViewModel frServiceViewModel2 = getFrServiceViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        frServiceViewModel2.observeSubState(viewLifecycleOwner2, new Function1<FrServiceViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(FrServiceViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDataIsUpdated();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.4
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
                    ShotFragment shotFragment = ShotFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(shotFragment), R.id.shotFragment, R.id.action_shotFragment_to_successFrFragment, null, null, 12, null);
                    }
                }
            }
        });
        FrServiceViewModel frServiceViewModel3 = getFrServiceViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        frServiceViewModel3.observeSubState(viewLifecycleOwner3, new Function1<FrServiceViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(FrServiceViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDataIsError();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment.onViewCreated.6
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
                    ShotFragment shotFragment = ShotFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(shotFragment), R.id.shotFragment, R.id.action_shotFragment_to_errorFrFragment, null, null, 12, null);
                    }
                }
            }
        });
        Toolbar title = getBinding().title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        ExecutorService executorService = null;
        ToolbarKt.setupWithNavController$default(title, FragmentKt.findNavController(this), null, 2, null);
        getDisplayManager().registerDisplayListener(this.displayListener, null);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.cameraExecutor = executorServiceNewSingleThreadExecutor;
        getDisplayManager().registerDisplayListener(this.displayListener, null);
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor2, "newSingleThreadExecutor(...)");
        this.cameraExecutor = executorServiceNewSingleThreadExecutor2;
        if (executorServiceNewSingleThreadExecutor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
        } else {
            executorService = executorServiceNewSingleThreadExecutor2;
        }
        executorService.execute(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ShotFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        Toolbar title2 = getBinding().title;
        Intrinsics.checkNotNullExpressionValue(title2, "title");
        ViewKt.addSystemWindowInsetToMargin$default(title2, true, true, true, false, 8, null);
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
        getBinding().tvScanning.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShotFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$displayListener$1] */
    public ShotFragment() {
        super(R.layout.fragment_fr_camera);
        this.binding = new ViewBindingFragmentDelegate(this, ShotFragment$binding$2.INSTANCE);
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$frServiceViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.frServiceViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FrServiceViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
        this.displayManager = LazyKt.lazy(new Function0<DisplayManager>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$displayManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DisplayManager invoke() {
                Object systemService = this.this$0.requireContext().getSystemService("display");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
                return (DisplayManager) systemService;
            }
        });
        this.facesStatesName = LazyKt.lazy(new Function0<Map<FaceProcessNative.ProcessState, ? extends String>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$facesStatesName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<FaceProcessNative.ProcessState, ? extends String> invoke() {
                FaceRecognitionStartLocale faceRecognitionStart;
                FaceRecognitionStartBody body;
                List<String> subtitles;
                FaceRecognitionStartLocale faceRecognitionStart2;
                FaceRecognitionStartBody body2;
                List<String> subtitles2;
                FaceRecognitionStartLocale faceRecognitionStart3;
                FaceRecognitionStartBody body3;
                List<String> subtitles3;
                FaceProcessNative.ProcessState processState = FaceProcessNative.ProcessState.Portrait;
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                String str = null;
                Pair pair = TuplesKt.to(processState, (data == null || (faceRecognitionStart3 = data.getFaceRecognitionStart()) == null || (body3 = faceRecognitionStart3.getBody()) == null || (subtitles3 = body3.getSubtitles()) == null) ? null : (String) CollectionsKt.first((List) subtitles3));
                FaceProcessNative.ProcessState processState2 = FaceProcessNative.ProcessState.Left;
                LocalizationLocalModel data2 = this.this$0.getLocalizationScreen().getData();
                Pair pair2 = TuplesKt.to(processState2, (data2 == null || (faceRecognitionStart2 = data2.getFaceRecognitionStart()) == null || (body2 = faceRecognitionStart2.getBody()) == null || (subtitles2 = body2.getSubtitles()) == null) ? null : subtitles2.get(1));
                FaceProcessNative.ProcessState processState3 = FaceProcessNative.ProcessState.Right;
                LocalizationLocalModel data3 = this.this$0.getLocalizationScreen().getData();
                if (data3 != null && (faceRecognitionStart = data3.getFaceRecognitionStart()) != null && (body = faceRecognitionStart.getBody()) != null && (subtitles = body.getSubtitles()) != null) {
                    str = (String) CollectionsKt.last((List) subtitles);
                }
                return MapsKt.mapOf(pair, pair2, TuplesKt.to(processState3, str));
            }
        });
        this.displayId = -1;
        this.lastState = FaceProcessNative.ProcessState.None;
        this.displayListener = new DisplayManager.DisplayListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$displayListener$1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                ImageAnalysis imageAnalysis;
                View view = this.this$0.getView();
                if (view != null) {
                    ShotFragment shotFragment = this.this$0;
                    if (displayId == shotFragment.displayId && (imageAnalysis = shotFragment.imageAnalyzer) != null) {
                        imageAnalysis.setTargetRotation(view.getDisplay().getRotation());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final ShotFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.faceProcess = new FaceProcessNative(this$0.requireContext());
        this$0.getBinding().viewFinder.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ShotFragment.onViewCreated$lambda$1$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(ShotFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = new Handler(Looper.getMainLooper());
        FaceProcessNative faceProcessNative = this$0.faceProcess;
        Intrinsics.checkNotNull(faceProcessNative);
        this$0.faceAnalyzer = new FaceAnalyzer(faceProcessNative, new ShotFragment$onViewCreated$7$1$1(this$0), handler);
        this$0.displayId = this$0.getBinding().viewFinder.getDisplay().getDisplayId();
        this$0.bindCameraUseCases();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ShotFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showFRError();
    }

    private final void repeatFR() {
        FaceRecognitionStartLocale faceRecognitionStart;
        FaceRecognitionStartBody body;
        List<String> subtitles;
        FaceRecognitionStartLocale faceRecognitionStart2;
        FaceRecognitionStartBody body2;
        FragmentFrCameraBinding binding = getBinding();
        binding.btnRepeat.setVisibility(8);
        TextView textView = binding.tvScanning;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str = null;
        textView.setText((data == null || (faceRecognitionStart2 = data.getFaceRecognitionStart()) == null || (body2 = faceRecognitionStart2.getBody()) == null) ? null : body2.getTitle());
        TextView textView2 = binding.tvScanState;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (faceRecognitionStart = data2.getFaceRecognitionStart()) != null && (body = faceRecognitionStart.getBody()) != null && (subtitles = body.getSubtitles()) != null) {
            str = (String) CollectionsKt.first((List) subtitles);
        }
        textView2.setText(str);
        this.isAlive = true;
        FaceProcessNative faceProcessNative = this.faceProcess;
        if (faceProcessNative != null) {
            faceProcessNative.reset();
        }
    }

    private final void showFRError() {
        FaceRecognitionStartLocale faceRecognitionStart;
        FaceRecognitionStartBody body;
        List<String> error;
        FaceRecognitionStartLocale faceRecognitionStart2;
        FaceRecognitionStartBody body2;
        List<String> error2;
        FragmentFrCameraBinding binding = getBinding();
        binding.btnRepeat.setVisibility(0);
        binding.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShotFragment.showFRError$lambda$5$lambda$4(this.f$0, view);
            }
        });
        TextView textView = binding.tvScanning;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str = null;
        textView.setText((data == null || (faceRecognitionStart2 = data.getFaceRecognitionStart()) == null || (body2 = faceRecognitionStart2.getBody()) == null || (error2 = body2.getError()) == null) ? null : (String) CollectionsKt.first((List) error2));
        TextView textView2 = binding.tvScanState;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (faceRecognitionStart = data2.getFaceRecognitionStart()) != null && (body = faceRecognitionStart.getBody()) != null && (error = body.getError()) != null) {
            str = (String) CollectionsKt.last((List) error);
        }
        textView2.setText(str);
        binding.progressFrStatus.setProgress(0);
        this.lastState = FaceProcessNative.ProcessState.None;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFRError$lambda$5$lambda$4(ShotFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.repeatFR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFrameProcessed(boolean isCorrect, FaceProcessNative.ProcessState state) {
        if (!this.isAlive || this.isDone) {
            return;
        }
        int progress = getBinding().progressFrStatus.getProgress();
        if (state == FaceProcessNative.ProcessState.Error) {
            showFRError();
            return;
        }
        if (isCorrect) {
            raiseProgress(state, progress);
        } else {
            downProgress(state, progress);
        }
        if (state == FaceProcessNative.ProcessState.Done) {
            FaceProcessNative faceProcessNative = this.faceProcess;
            Intrinsics.checkNotNull(faceProcessNative);
            faceProcessNative.getEmbeddings();
            FrServiceViewModel frServiceViewModel = getFrServiceViewModel();
            Intrinsics.checkNotNull(null);
            frServiceViewModel.loadFrData(null);
            FaceAnalyzer faceAnalyzer = this.faceAnalyzer;
            if (faceAnalyzer != null) {
                faceAnalyzer.stop();
            }
        }
    }

    private final void raiseProgress(FaceProcessNative.ProcessState state, int curProgress) {
        FaceProcessNative.ProcessState processState = this.lastState;
        if (processState == FaceProcessNative.ProcessState.Error && processState == FaceProcessNative.ProcessState.Done) {
            return;
        }
        ProgressBar progressBar = getBinding().progressFrStatus;
        int progress = progressBar.getProgress();
        Constants constants = Constants.INSTANCE;
        Integer num = constants.getStatesBorders().get(this.lastState);
        Intrinsics.checkNotNull(num);
        progressBar.setProgress(progress + (curProgress >= num.intValue() ? 0 : 4));
        if (this.lastState != state) {
            if (isFacesState(state)) {
                Integer num2 = constants.getStatesBorders().get(this.lastState);
                Intrinsics.checkNotNull(num2);
                if (curProgress < num2.intValue()) {
                    ProgressBar progressBar2 = getBinding().progressFrStatus;
                    Integer num3 = constants.getStatesBorders().get(this.lastState);
                    Intrinsics.checkNotNull(num3);
                    progressBar2.setProgress(num3.intValue());
                }
                ImageView imageView = getBinding().faceState;
                Integer num4 = constants.getFacesStates().get(state);
                Intrinsics.checkNotNull(num4);
                imageView.setImageResource(num4.intValue());
                TextView textView = getBinding().tvScanState;
                String str = getFacesStatesName().get(state);
                Intrinsics.checkNotNull(str);
                textView.setText(str);
            }
            this.lastState = state;
        }
    }

    private final boolean isFacesState(FaceProcessNative.ProcessState state) {
        return (state == FaceProcessNative.ProcessState.None || state == FaceProcessNative.ProcessState.Done) ? false : true;
    }

    private final void downProgress(FaceProcessNative.ProcessState state, int curProgress) {
        ProgressBar progressBar = getBinding().progressFrStatus;
        int progress = progressBar.getProgress();
        Integer num = Constants.INSTANCE.getStatesBorders().get(this.lastState);
        Intrinsics.checkNotNull(num);
        progressBar.setProgress(progress + (curProgress <= num.intValue() + (-33) ? 0 : -2));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isAlive = true;
        FaceProcessNative faceProcessNative = this.faceProcess;
        if (faceProcessNative != null) {
            faceProcessNative.reset();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isAlive = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isAlive = false;
        ExecutorService executorService = null;
        this.faceAnalyzer = null;
        ExecutorService executorService2 = this.cameraExecutor;
        if (executorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
        } else {
            executorService = executorService2;
        }
        executorService.shutdown();
        getDisplayManager().unregisterDisplayListener(this.displayListener);
    }

    private final void bindCameraUseCases() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBinding().viewFinder.getDisplay().getRealMetrics(displayMetrics);
        final int iAspectRatio = aspectRatio(displayMetrics.widthPixels, displayMetrics.heightPixels);
        final int rotation = getBinding().viewFinder.getDisplay().getRotation();
        final CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(...)");
        processCameraProvider.addListener(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, InterruptedException {
                ShotFragment.bindCameraUseCases$lambda$8(processCameraProvider, this, iAspectRatio, rotation, cameraSelectorBuild);
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void bindCameraUseCases$lambda$8(ListenableFuture cameraProviderFuture, ShotFragment this$0, int i, int i2, CameraSelector cameraSelector) throws ExecutionException, InterruptedException {
        Intrinsics.checkNotNullParameter(cameraProviderFuture, "$cameraProviderFuture");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraSelector, "$cameraSelector");
        V v = cameraProviderFuture.get();
        Intrinsics.checkNotNullExpressionValue(v, "get(...)");
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) v;
        this$0.preview = new Preview.Builder().build();
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setTargetAspectRatio(i).setTargetRotation(i2).setBackpressureStrategy(0).build();
        ExecutorService executorService = this$0.cameraExecutor;
        if (executorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
            executorService = null;
        }
        FaceAnalyzer faceAnalyzer = this$0.faceAnalyzer;
        Intrinsics.checkNotNull(faceAnalyzer);
        imageAnalysisBuild.setAnalyzer(executorService, faceAnalyzer);
        this$0.imageAnalyzer = imageAnalysisBuild;
        processCameraProvider.unbindAll();
        try {
            this$0.camera = processCameraProvider.bindToLifecycle(this$0.getViewLifecycleOwner(), cameraSelector, this$0.preview, this$0.imageAnalyzer);
            Preview preview = this$0.preview;
            if (preview != null) {
                preview.setSurfaceProvider(this$0.getBinding().viewFinder.getSurfaceProvider());
            }
        } catch (Exception unused) {
        }
    }

    private final int aspectRatio(int width, int height) {
        double dMax = Math.max(width, height) / Math.min(width, height);
        return Math.abs(dMax - 1.3333333333333333d) <= Math.abs(dMax - 1.7777777777777777d) ? 0 : 1;
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FaceRecognitionStartLocale faceRecognitionStart;
        FaceRecognitionStartBody body;
        FaceRecognitionStartLocale faceRecognitionStart2;
        FaceRecognitionStartBody body2;
        FaceRecognitionStartLocale faceRecognitionStart3;
        FaceRecognitionStartBody body3;
        List<String> subtitles;
        FaceRecognitionMainLocale faceRecognitionMain;
        TextTitle navigation;
        FragmentFrCameraBinding binding = getBinding();
        Toolbar toolbar = binding.title;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String errorLabel = null;
        toolbar.setTitle((data == null || (faceRecognitionMain = data.getFaceRecognitionMain()) == null || (navigation = faceRecognitionMain.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView = binding.tvScanState;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText((data2 == null || (faceRecognitionStart3 = data2.getFaceRecognitionStart()) == null || (body3 = faceRecognitionStart3.getBody()) == null || (subtitles = body3.getSubtitles()) == null) ? null : (String) CollectionsKt.first((List) subtitles));
        TextView textView2 = binding.tvScanning;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView2.setText((data3 == null || (faceRecognitionStart2 = data3.getFaceRecognitionStart()) == null || (body2 = faceRecognitionStart2.getBody()) == null) ? null : body2.getTitle());
        TextView textView3 = binding.tvScanAttention;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (faceRecognitionStart = data4.getFaceRecognitionStart()) != null && (body = faceRecognitionStart.getBody()) != null) {
            errorLabel = body.getErrorLabel();
        }
        textView3.setText(String.valueOf(errorLabel));
    }
}
