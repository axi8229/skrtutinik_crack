package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.webrtc.MediaStreamTrack;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentFlussonicBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.download_service.DownloadService;
import timber.log.Timber;

/* compiled from: FlussonicActivity.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0007J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0007J/\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b'\u0010$J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\u0007J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\u0007J\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J-\u00100\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b2\u0010\u0007R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R#\u0010@\u001a\n ;*\u0004\u0018\u00010:0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010F\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010K\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\"\u0010M\u001a\u00020L8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\"\u0010d\u001a\u00020c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010C\u001a\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/FlussonicActivity;", "Lcom/sputnik/common/base/BaseFragment;", "Lflussonic/watcher/sdk/presentation/core/listeners/FlussonicCollapseExpandTimelineListener;", "Lflussonic/watcher/sdk/presentation/core/listeners/FlussonicBufferingListener;", "Lflussonic/watcher/sdk/presentation/core/listeners/FlussonicUpdateProgressEventListener;", "Lflussonic/watcher/sdk/presentation/watcher/FlussonicWatcherView$FlussonicExoPlayerErrorListener;", "<init>", "()V", "", "url", "", "setupWatcher", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "initViews", "localize", "onLowMemory", "", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "p0", "collapseToolbar", "(I)V", "expandToolbar", "showToolbar", "hideToolbar", "onBufferingStart", "onBufferingStop", "Lflussonic/watcher/sdk/domain/pojo/UpdateProgressEvent;", "event", "onUpdateProgress", "(Lflussonic/watcher/sdk/domain/pojo/UpdateProgressEvent;)V", "code", CrashHianalyticsData.MESSAGE, "onExoPlayerError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/databinding/FragmentFlussonicBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentFlussonicBinding;", "binding", "Lcom/sputnik/common/entities/camera/Camera;", "camera$delegate", "Lkotlin/Lazy;", "getCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "camera", "", "startPosition$delegate", "getStartPosition", "()Ljava/lang/Long;", "startPosition", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Factory;", "downloadServiceFactory", "Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Factory;", "getDownloadServiceFactory", "()Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Factory;", "setDownloadServiceFactory", "(Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Factory;)V", "Lsputnik/axmor/com/sputnik/services/download_service/DownloadService;", "downloadService", "Lsputnik/axmor/com/sputnik/services/download_service/DownloadService;", "Lflussonic/watcher/sdk/presentation/core/listeners/FlussonicDownloadRequestListener;", "downloadFragment", "Lflussonic/watcher/sdk/presentation/core/listeners/FlussonicDownloadRequestListener;", "filePrefix", "Ljava/lang/String;", "fileName", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlussonicActivity extends BaseFragment implements FlussonicCollapseExpandTimelineListener, FlussonicBufferingListener, FlussonicUpdateProgressEventListener, FlussonicWatcherView.FlussonicExoPlayerErrorListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FlussonicActivity.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentFlussonicBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camera$delegate, reason: from kotlin metadata */
    private final Lazy camera;
    private final FlussonicDownloadRequestListener downloadFragment;
    private DownloadService downloadService;
    public DownloadService.Factory downloadServiceFactory;
    public MultiViewModelFactory factory;
    private String fileName;
    private final String filePrefix;
    public LocalizationStorage localizationScreen;

    /* renamed from: startPosition$delegate, reason: from kotlin metadata */
    private final Lazy startPosition;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    private final FragmentFlussonicBinding getBinding() {
        return (FragmentFlussonicBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    private final Camera getCamera() {
        return (Camera) this.camera.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long getStartPosition() {
        return (Long) this.startPosition.getValue();
    }

    public final DownloadService.Factory getDownloadServiceFactory() {
        DownloadService.Factory factory = this.downloadServiceFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadServiceFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFragment$lambda$0(FlussonicActivity this$0, long j, long j2) {
        SubscriptionsViewState currentState;
        Flussonic flussonicData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!DownloadService.INSTANCE.isDownloading()) {
            long j3 = j2 - j;
            String str = new SimpleDateFormat("MMdd_HH_mm").format(new Date(1000 * j));
            String strValueOf = String.valueOf(j3 / 60);
            this$0.fileName = this$0.filePrefix + "_" + str + "_" + strValueOf + ".ts";
            DownloadService downloadService = this$0.downloadService;
            BaseSubscription activeSubscription = null;
            if (downloadService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadService");
                downloadService = null;
            }
            Camera camera = this$0.getCamera();
            downloadService.tryDownload((camera == null || (flussonicData = camera.getFlussonicData()) == null) ? null : flussonicData.getDownloadUrl(j, j3), this$0.fileName);
            SubscriptionsViewModel subscriptionsViewModel = this$0.getSubscriptionsViewModel();
            if (subscriptionsViewModel != null && (currentState = subscriptionsViewModel.getCurrentState()) != null) {
                activeSubscription = currentState.getActiveSubscription();
            }
            if (activeSubscription != null) {
                this$0.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickArchiveDownload());
                return;
            }
            return;
        }
        Toast.makeText(this$0.getContext(), this$0.getString(R.string.already_download), 0).show();
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Flussonic flussonicData;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DownloadService.Factory downloadServiceFactory = getDownloadServiceFactory();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        this.downloadService = downloadServiceFactory.create((AppCompatActivity) activity);
        Camera camera = getCamera();
        String str = "https://" + ((camera == null || (flussonicData = camera.getFlussonicData()) == null) ? null : flussonicData.getSdkUrl());
        getSubscriptionsViewModel().observeState(this, new Function1<SubscriptionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
                invoke2(subscriptionsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getActiveSubscription() != null) {
                    if (FlussonicActivity.this.getStartPosition() != null) {
                        FlussonicActivity.this.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickCallLogEventArchive());
                    }
                    FlussonicActivity.this.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickArchiveView());
                }
            }
        });
        try {
            setupWatcher(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentFlussonicBinding binding = getBinding();
        Toolbar title = getBinding().title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        ToolbarKt.setupWithNavController$default(title, FragmentKt.findNavController(this), null, 2, null);
        Toolbar toolbar = binding.title;
        Camera camera = getCamera();
        toolbar.setTitle(camera != null ? camera.getTitle() : null);
        getBinding().title.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlussonicActivity.initViews$lambda$4$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$3(FlussonicActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FlussonicWatcherView flussonicWatcherView = this$0.getBinding().watcherView;
        Long startPosition = this$0.getStartPosition();
        flussonicWatcherView.seek(startPosition != null ? startPosition.longValue() : System.currentTimeMillis());
    }

    private final void setupWatcher(String url) throws Resources.NotFoundException {
        FlussonicWatcherView flussonicWatcherView = getBinding().watcherView;
        flussonicWatcherView.disableAudio(true);
        flussonicWatcherView.setCollapseExpandTimelineListener(this);
        flussonicWatcherView.setBufferingListener(this);
        flussonicWatcherView.setDownloadRequestListener(this.downloadFragment);
        flussonicWatcherView.setUpdateProgressEventListener(this);
        flussonicWatcherView.setExoPlayerErrorListener(this);
        flussonicWatcherView.initialize(this);
        flussonicWatcherView.setUrl(url);
        flussonicWatcherView.enableTimelineMarkersV2(true);
        Long startPosition = getStartPosition();
        if (startPosition != null) {
            getBinding().watcherView.setStartPosition(startPosition.longValue());
        }
        LinearLayout container = getBinding().container;
        Intrinsics.checkNotNullExpressionValue(container, "container");
        ViewKt.addSystemWindowInsetToPadding(container, true, true, true, true);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            getBinding().watcherView.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FlussonicActivity() {
        super(R.layout.fragment_flussonic);
        this.binding = new ViewBindingFragmentDelegate(this, FlussonicActivity$binding$2.INSTANCE);
        this.camera = LazyKt.lazy(new Function0<Camera>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$camera$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Camera invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return (Camera) arguments.getParcelable("camera");
                }
                return null;
            }
        });
        this.startPosition = LazyKt.lazy(new Function0<Long>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$startPosition$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Bundle arguments = this.this$0.getArguments();
                return StringsKt.toLongOrNull(String.valueOf(arguments != null ? arguments.get("start_position") : null));
            }
        });
        this.downloadFragment = new FlussonicDownloadRequestListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$$ExternalSyntheticLambda0
            @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener
            public final void onDownloadRequest(long j, long j2) {
                FlussonicActivity.downloadFragment$lambda$0(this.f$0, j, j2);
            }
        };
        this.filePrefix = MediaStreamTrack.VIDEO_TRACK_KIND;
        this.fileName = "";
        final Function0 function0 = null;
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity$subscriptionsViewModel$2
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

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        String lastDownloadUrl;
        Flussonic flussonicData;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == DownloadService.INSTANCE.getSTORAGE_PERMISSIONS_CODE()) {
            if (!(grantResults.length == 0) && grantResults[0] == 0) {
                DownloadService downloadService = this.downloadService;
                if (downloadService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadService");
                    downloadService = null;
                }
                Camera camera = getCamera();
                if (camera == null || (flussonicData = camera.getFlussonicData()) == null || (lastDownloadUrl = flussonicData.getLastDownloadUrl()) == null) {
                    lastDownloadUrl = "";
                }
                downloadService.beginDownload(lastDownloadUrl, this.fileName);
                return;
            }
            Toast.makeText(getContext(), getString(R.string.access_denied), 0).show();
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener
    public void collapseToolbar(int p0) {
        Timber.INSTANCE.d("collapseToolbar", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener
    public void expandToolbar(int p0) {
        Timber.INSTANCE.d("expandToolbar", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener
    public void showToolbar(int p0) {
        Timber.INSTANCE.d("showToolbar", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener
    public void hideToolbar(int p0) {
        Timber.INSTANCE.d("hideToolbar", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener
    public void onBufferingStart() {
        Timber.INSTANCE.d("onBufferingStart", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener
    public void onBufferingStop() {
        Timber.INSTANCE.d("onBufferingStop", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener
    public void onUpdateProgress(UpdateProgressEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List<Track> availableTracks = getBinding().watcherView.getAvailableTracks();
        Intrinsics.checkNotNullExpressionValue(availableTracks, "getAvailableTracks(...)");
        StringBuilder sb = new StringBuilder();
        int size = availableTracks.size();
        for (int i = 0; i < size; i++) {
            sb.append(availableTracks.get(i).trackId());
            if (i < availableTracks.size() - 1) {
                sb.append(", ");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Track currentTrack = getBinding().watcherView.getCurrentTrack();
        Timber.Companion companion = Timber.INSTANCE;
        String strValueOf = String.valueOf(event.currentUtcInSeconds());
        String string2 = event.playbackStatus().toString();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(event.speed())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (string.length() == 0) {
            string = "NO";
        }
        companion.d("update progress: %s %s %s %s %s", strValueOf, string2, str, string, currentTrack != null ? currentTrack.trackId() : "NO");
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView.FlussonicExoPlayerErrorListener
    public void onExoPlayerError(String code, String message, String url) {
        Timber.INSTANCE.e("onExoPlayerError code: %s, message: %s, player_url: %s", code, message, url);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            getBinding().watcherView.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
