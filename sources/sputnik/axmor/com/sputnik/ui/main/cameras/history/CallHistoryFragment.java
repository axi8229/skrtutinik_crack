package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
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
import androidx.navigation.fragment.FragmentNavigatorExtrasKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.entities.localization.PromoView;
import com.sputnik.common.entities.localization.VisitsArcAvailable;
import com.sputnik.common.entities.localization.VisitsArcUnavailable;
import com.sputnik.common.entities.localization.VisitsBody;
import com.sputnik.common.entities.localization.VisitsBottomTitle;
import com.sputnik.common.entities.localization.VisitsBottomView;
import com.sputnik.common.entities.localization.VisitsEmptyView;
import com.sputnik.common.entities.localization.VisitsLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveItem;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import com.sputnik.domain.entities.market.MarketTypes;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentVisitsBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$swiper$2;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryAdapter;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryStateAdapter;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.SwipeToDeleteCallback;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.VisitsSwipeHelper;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewState;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewState;
import sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.MyButton;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: CallHistoryFragment.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003J\u0019\u0010\"\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0003R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010E\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010@\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010@\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010@\u001a\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010@\u001a\u0004\b\\\u0010]R\u001b\u0010c\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010@\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010@\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010@\u001a\u0004\bk\u0010lR\u001b\u0010r\u001a\u00020n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010@\u001a\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010@\u001a\u0004\bu\u0010vR\"\u0010y\u001a\u00020x8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0083\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;)V", "Lcom/sputnik/common/viewmodels/MarketViewState;", "renderMarketUi", "(Lcom/sputnik/common/viewmodels/MarketViewState;)V", "Lcom/sputnik/common/entities/market/service/Service;", "service", "initArchive", "(Lcom/sputnik/common/entities/market/service/Service;)V", "initNewArchive", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "onViewStateRestored", "(Landroid/os/Bundle;)V", "onDestroy", "localize", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory$AssistFactory;", "callHistoryFactory", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory$AssistFactory;", "getCallHistoryFactory", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory$AssistFactory;", "setCallHistoryFactory", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel;", "callHistoryViewModel$delegate", "Lkotlin/Lazy;", "getCallHistoryViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel;", "callHistoryViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel$delegate", "getArchiveViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryAdapter;", "recyclerViewAdapter$delegate", "getRecyclerViewAdapter", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryAdapter;", "recyclerViewAdapter", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/VisitsSwipeHelper;", "swiper$delegate", "getSwiper", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/VisitsSwipeHelper;", "swiper", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/databinding/FragmentVisitsBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentVisitsBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryFragment extends BaseFragment {
    private ViewBinding _binding;
    public Analytics analytics;

    /* renamed from: archiveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archiveViewModel;
    public CallHistoryViewModel.Factory.AssistFactory callHistoryFactory;

    /* renamed from: callHistoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy callHistoryViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: recyclerViewAdapter$delegate, reason: from kotlin metadata */
    private final Lazy recyclerViewAdapter;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: swiper$delegate, reason: from kotlin metadata */
    private final Lazy swiper;

    /* compiled from: CallHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockingLevel.values().length];
            try {
                iArr[BlockingLevel.PARTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentVisitsBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.FragmentVisitsBinding");
        return (FragmentVisitsBinding) viewBinding;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final CallHistoryViewModel.Factory.AssistFactory getCallHistoryFactory() {
        CallHistoryViewModel.Factory.AssistFactory assistFactory = this.callHistoryFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callHistoryFactory");
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
    public final CallHistoryViewModel getCallHistoryViewModel() {
        return (CallHistoryViewModel) this.callHistoryViewModel.getValue();
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveViewModel getArchiveViewModel() {
        return (ArchiveViewModel) this.archiveViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallHistoryAdapter getRecyclerViewAdapter() {
        return (CallHistoryAdapter) this.recyclerViewAdapter.getValue();
    }

    public CallHistoryFragment() {
        super(R.layout.fragment_visits);
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$callHistoryViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ProfileSettingsLocale profileSettings;
                List<String> messages;
                CallHistoryViewModel.Factory.AssistFactory callHistoryFactory = this.this$0.getCallHistoryFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return callHistoryFactory.create((data == null || (profileSettings = data.getProfileSettings()) == null || (messages = profileSettings.getMessages()) == null) ? null : (String) CollectionsKt.last((List) messages));
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$viewModels$default$2
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
        this.callHistoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallHistoryViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$viewModels$default$4
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
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$camerasViewModel$2
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
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.archiveViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ArchiveViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$archiveViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$special$$inlined$activityViewModels$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$navController$2
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
        this.recyclerViewAdapter = LazyKt.lazy(new Function0<CallHistoryAdapter>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$recyclerViewAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CallHistoryAdapter invoke() {
                VisitsLocale visits;
                VisitsBody body;
                VisitsBottomTitle table;
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                Object obj = null;
                String bottomTitle = (data == null || (visits = data.getVisits()) == null || (body = visits.getBody()) == null || (table = body.getTable()) == null) ? null : table.getBottomTitle();
                for (Object obj2 : this.this$0.getMarketViewModel().getCurrentState().getServices()) {
                    Service service = (Service) obj2;
                    String serviceConfigIdentifier = service.getServiceConfigIdentifier();
                    AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
                    if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_7d_IDENTIFIER()) || Intrinsics.areEqual(service.getServiceConfigIdentifier(), servicesNames.getVIDEO_ARCHIVE_5d_IDENTIFIER()) || Intrinsics.areEqual(service.getServiceConfigIdentifier(), servicesNames.getVIDEO_ARCHIVE_3d_IDENTIFIER())) {
                        obj = obj2;
                        break;
                    }
                }
                final CallHistoryFragment callHistoryFragment = this.this$0;
                Function2<View, CallHistoryUi, Unit> function2 = new Function2<View, CallHistoryUi, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$recyclerViewAdapter$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, CallHistoryUi callHistoryUi) throws Resources.NotFoundException {
                        invoke2(view, callHistoryUi);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, CallHistoryUi call) throws Resources.NotFoundException {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(call, "call");
                        if (call instanceof CallHistoryUi.Promo) {
                            callHistoryFragment.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickSeeAllHistoryBtn());
                            callHistoryFragment.getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_subscriptions_navigation, Subscriptions.standard.toString(), null, null, 12, null))), false, 4, null));
                            return;
                        }
                        CallHistory item = ((CallHistoryUi.CallHistoryItem) call).getItem();
                        Pair pair = TuplesKt.to("image", item.getImageUrl());
                        Pair pair2 = TuplesKt.to("video_url", item.getVideoUrl());
                        Pair pair3 = TuplesKt.to("call_declined", Boolean.valueOf(item.isCallDeclined()));
                        Pair pair4 = TuplesKt.to(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, item.getDate());
                        Pair pair5 = TuplesKt.to(CrashHianalyticsData.TIME, item.getTime());
                        String rawDateTime = item.getRawDateTime();
                        NavControllerKt.safeNavigate(callHistoryFragment.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_callHistoryDetails, BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("start_position", Long.valueOf(rawDateTime != null ? DateUtilsKt.toNanoFormat(rawDateTime) / 1000 : 0L))), FragmentNavigatorExtrasKt.FragmentNavigatorExtras(new Pair[0]));
                    }
                };
                final CallHistoryFragment callHistoryFragment2 = this.this$0;
                return new CallHistoryAdapter(bottomTitle, (Service) obj, function2, new Function2<View, CallHistoryUi, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$recyclerViewAdapter$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, CallHistoryUi callHistoryUi) throws Resources.NotFoundException {
                        invoke2(view, callHistoryUi);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, CallHistoryUi call) throws Resources.NotFoundException {
                        DomainArchiveItem domainArchiveItem;
                        List<DomainArchiveItem> data2;
                        Object next;
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(call, "call");
                        callHistoryFragment2.getAnalytics().trackLogEvent(new GeneralEvents.ClickArchiveFromHistory());
                        CallHistory item = ((CallHistoryUi.CallHistoryItem) call).getItem();
                        if (item.getHasArchive()) {
                            DomainArchiveUrls archive = callHistoryFragment2.getArchiveViewModel().getCurrentState().getArchive();
                            if (archive == null || (data2 = archive.getData()) == null) {
                                domainArchiveItem = null;
                            } else {
                                Iterator<T> it = data2.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next = null;
                                        break;
                                    } else {
                                        next = it.next();
                                        if (Intrinsics.areEqual(((DomainArchiveItem) next).getDeviceUUID(), item.getDeviceUuid())) {
                                            break;
                                        }
                                    }
                                }
                                domainArchiveItem = (DomainArchiveItem) next;
                            }
                            NavControllerKt.safeNavigate$default(callHistoryFragment2.getNavController(), R.id.action_global_to_archiveWebViewFragment, BundleKt.bundleOf(TuplesKt.to("url", domainArchiveItem != null ? domainArchiveItem.getPlayerUrl() : null), TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, "archive")), null, 4, null);
                            return;
                        }
                        String imageUrl = item.getImageUrl();
                        Intrinsics.checkNotNull(imageUrl);
                        NavControllerKt.safeNavigate(callHistoryFragment2.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetNoArchive, BundleKt.bundleOf(), FragmentNavigatorExtrasKt.FragmentNavigatorExtras(TuplesKt.to(view, imageUrl)));
                    }
                });
            }
        });
        this.swiper = LazyKt.lazy(new Function0<CallHistoryFragment$swiper$2.AnonymousClass1>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$swiper$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$swiper$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new VisitsSwipeHelper(this.this$0.requireContext(), this.this$0.getBinding().rvVisits) { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$swiper$2.1
                    {
                        Intrinsics.checkNotNull(recyclerView);
                    }

                    @Override // sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.VisitsSwipeHelper
                    public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer, final CallHistoryUi item) {
                        Intrinsics.checkNotNullParameter(buffer, "buffer");
                        Intrinsics.checkNotNullParameter(item, "item");
                        if (item instanceof CallHistoryUi.CallHistoryItem) {
                            Context contextRequireContext = this.this$0.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                            int color = Color.parseColor("#FF3D71");
                            final CallHistoryFragment callHistoryFragment = this.this$0;
                            buffer.add(new MyButton("delete", contextRequireContext, R.drawable.ic_delete, color, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$swiper$2$1$instantiateMyButton$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) throws Resources.NotFoundException {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i) throws Resources.NotFoundException {
                                    Profile profile = callHistoryFragment.getProfileViewModel().getCurrentState().getProfile();
                                    if (profile != null ? Intrinsics.areEqual(profile.getHistoryAvailable(), Boolean.FALSE) : false) {
                                        NavControllerKt.safeNavigate$default(callHistoryFragment.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2001)), null, 8, null);
                                        return;
                                    }
                                    String callId = ((CallHistoryUi.CallHistoryItem) item).getItem().getCallId();
                                    if (callId != null) {
                                        callHistoryFragment.getCallHistoryViewModel().deleteCall(callId);
                                    }
                                }
                            }));
                        }
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VisitsSwipeHelper getSwiper() {
        return (VisitsSwipeHelper) this.swiper.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentVisitsBinding.inflate(getLayoutInflater(), null, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, getNavController(), null, 2, null);
        getAnalytics().trackLogEvent(new GeneralEvents.ViewCallLog());
        CallHistoryViewModel callHistoryViewModel = getCallHistoryViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        callHistoryViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        marketViewModel.observeState(viewLifecycleOwner3, new C26623(this));
        ArchiveViewModel archiveViewModel = getArchiveViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        archiveViewModel.observeState(viewLifecycleOwner4, new Function1<ArchiveViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArchiveViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArchiveViewState archiveViewState) {
                invoke2(archiveViewState);
                return Unit.INSTANCE;
            }
        });
        getArchiveViewModel().loadArchiveLinksIfNeeded();
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeSubState(viewLifecycleOwner5, new Function1<SubscriptionsViewState, BaseSubscription>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final BaseSubscription invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getActiveSubscription();
            }
        }, new Function1<BaseSubscription, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) {
                invoke2(baseSubscription);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseSubscription baseSubscription) {
                if (baseSubscription != null) {
                    CallHistoryFragment.this.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickCallLog());
                }
            }
        });
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeSubState(viewLifecycleOwner6, new Function1<SubscriptionsViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedShowButtonPromo());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.onViewCreated.8
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_blockingNavigation, null, null, 12, null);
        }
    }

    /* compiled from: CallHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<CallHistoryViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, CallHistoryFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallHistoryViewState callHistoryViewState) {
            invoke2(callHistoryViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallHistoryViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CallHistoryFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: CallHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$onViewCreated$3, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26623 extends FunctionReferenceImpl implements Function1<MarketViewState, Unit> {
        C26623(Object obj) {
            super(1, obj, CallHistoryFragment.class, "renderMarketUi", "renderMarketUi(Lcom/sputnik/common/viewmodels/MarketViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
            invoke2(marketViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MarketViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CallHistoryFragment) this.receiver).renderMarketUi(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final Context contextRequireContext = requireContext();
        new SwipeToDeleteCallback(contextRequireContext) { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$initViews$swipeHandler$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(contextRequireContext);
                Intrinsics.checkNotNull(contextRequireContext);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) throws Resources.NotFoundException {
                String callId;
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                CallHistoryUi currentItem = this.this$0.getRecyclerViewAdapter().getCurrentItem(viewHolder.getBindingAdapterPosition());
                Profile profile = this.this$0.getProfileViewModel().getCurrentState().getProfile();
                if (profile != null ? Intrinsics.areEqual(profile.getHistoryAvailable(), Boolean.FALSE) : false) {
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2001)), null, 8, null);
                    this.this$0.getRecyclerViewAdapter().notifyDataSetChanged();
                } else {
                    if (!(currentItem instanceof CallHistoryUi.CallHistoryItem) || (callId = ((CallHistoryUi.CallHistoryItem) currentItem).getItem().getCallId()) == null) {
                        return;
                    }
                    this.this$0.getCallHistoryViewModel().deleteCall(callId);
                }
            }
        };
        RecyclerView recyclerView = getBinding().rvVisits;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(getRecyclerViewAdapter().withLoadStateHeaderAndFooter(new CallHistoryStateAdapter(new CallHistoryFragment$initViews$1$1(getRecyclerViewAdapter())), new CallHistoryStateAdapter(new CallHistoryFragment$initViews$1$2(getRecyclerViewAdapter()))));
        new ItemTouchHelper(getSwiper()).attachToRecyclerView(recyclerView);
        postponeEnterTransition();
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return CallHistoryFragment.initViews$lambda$1$lambda$0(this.f$0);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        RecyclerView rvVisits = getBinding().rvVisits;
        Intrinsics.checkNotNullExpressionValue(rvVisits, "rvVisits");
        ViewKt.addSystemWindowInsetToPadding$default(rvVisits, true, false, true, true, 2, null);
        ConstraintLayout relativeLayout = getBinding().relativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "relativeLayout");
        ViewKt.addSystemWindowInsetToPadding$default(relativeLayout, true, false, true, true, 2, null);
        LinearLayout lInfoArchives = getBinding().lInfoArchives;
        Intrinsics.checkNotNullExpressionValue(lInfoArchives, "lInfoArchives");
        ViewKt.addSystemWindowInsetToPadding$default(lInfoArchives, true, false, true, true, 2, null);
        getRecyclerViewAdapter().addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.initViews.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) throws Resources.NotFoundException {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:40:0x00db  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(androidx.paging.CombinedLoadStates r9) throws android.content.res.Resources.NotFoundException {
                /*
                    Method dump skipped, instructions count: 388
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.AnonymousClass2.invoke2(androidx.paging.CombinedLoadStates):void");
            }
        });
        CallHistoryViewModel callHistoryViewModel = getCallHistoryViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        callHistoryViewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.initViews.3
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
                CallHistoryFragment callHistoryFragment = CallHistoryFragment.this;
                ConstraintLayout root = callHistoryFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(callHistoryFragment, root, it);
            }
        });
        TextView btnWantMore = getBinding().btnWantMore;
        Intrinsics.checkNotNullExpressionValue(btnWantMore, "btnWantMore");
        SafeClickListenerKt.setSafeOnClickListener$default(btnWantMore, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.initViews.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                CallHistoryFragment.this.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickWantPromoInCallLog());
                NavControllerKt.safeNavigate$default(CallHistoryFragment.this.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2001)), null, 8, null);
            }
        }, 1, null);
        TextView btnWantMore2 = getBinding().btnWantMore2;
        Intrinsics.checkNotNullExpressionValue(btnWantMore2, "btnWantMore2");
        SafeClickListenerKt.setSafeOnClickListener$default(btnWantMore2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.initViews.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                CallHistoryFragment.this.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickWantPromoInCallLog());
                NavControllerKt.safeNavigate$default(CallHistoryFragment.this.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2001)), null, 8, null);
            }
        }, 1, null);
        getBinding().btnPromo.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                CallHistoryFragment.initViews$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$1$lambda$0(CallHistoryFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPostponedEnterTransition();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(CallHistoryFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2001)), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(CallHistoryViewState data) {
        if (data.getCallHistoryList() != null) {
            Log.e("CALLHISTORY", String.valueOf(data.getCallHistoryList()));
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C26651(data, this, null), 3, null);
        }
    }

    /* compiled from: CallHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$renderUi$1", f = "CallHistoryFragment.kt", l = {459}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$renderUi$1, reason: invalid class name and case insensitive filesystem */
    static final class C26651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CallHistoryViewState $data;
        int label;
        final /* synthetic */ CallHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26651(CallHistoryViewState callHistoryViewState, CallHistoryFragment callHistoryFragment, Continuation<? super C26651> continuation) {
            super(2, continuation);
            this.$data = callHistoryViewState;
            this.this$0 = callHistoryFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26651(this.$data, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                Flow<PagingData<CallHistoryUi>> callHistoryList = this.$data.getCallHistoryList();
                C03641 c03641 = new C03641(this.this$0, this.$data, ref$BooleanRef, null);
                this.label = 1;
                if (FlowKt.collectLatest(callHistoryList, c03641, this) == coroutine_suspended) {
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

        /* compiled from: CallHistoryFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$renderUi$1$1", f = "CallHistoryFragment.kt", l = {506}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$renderUi$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03641 extends SuspendLambda implements Function2<PagingData<CallHistoryUi>, Continuation<? super Unit>, Object> {
            final /* synthetic */ CallHistoryViewState $data;
            final /* synthetic */ Ref$BooleanRef $needToShowPromo;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CallHistoryFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03641(CallHistoryFragment callHistoryFragment, CallHistoryViewState callHistoryViewState, Ref$BooleanRef ref$BooleanRef, Continuation<? super C03641> continuation) {
                super(2, continuation);
                this.this$0 = callHistoryFragment;
                this.$data = callHistoryViewState;
                this.$needToShowPromo = ref$BooleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C03641 c03641 = new C03641(this.this$0, this.$data, this.$needToShowPromo, continuation);
                c03641.L$0 = obj;
                return c03641;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PagingData<CallHistoryUi> pagingData, Continuation<? super Unit> continuation) {
                return ((C03641) create(pagingData, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x013c  */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.ArrayList] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    Method dump skipped, instructions count: 341
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment.C26651.C03641.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderMarketUi(MarketViewState data) {
        Object next;
        Object next2;
        if (data.getServicesState() == Resource.Status.SUCCESS) {
            Object obj = null;
            if (getRecyclerViewAdapter().getArchiveService() == null) {
                CallHistoryAdapter recyclerViewAdapter = getRecyclerViewAdapter();
                Iterator<T> it = data.getServices().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    Service service = (Service) next2;
                    String serviceConfigIdentifier = service.getServiceConfigIdentifier();
                    AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
                    if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_7d_IDENTIFIER()) || Intrinsics.areEqual(service.getServiceConfigIdentifier(), servicesNames.getVIDEO_ARCHIVE_5d_IDENTIFIER()) || Intrinsics.areEqual(service.getServiceConfigIdentifier(), servicesNames.getVIDEO_ARCHIVE_3d_IDENTIFIER())) {
                        break;
                    }
                }
                recyclerViewAdapter.setArchiveService((Service) next2);
                getRecyclerViewAdapter().notifyDataSetChanged();
            }
            Iterator<T> it2 = data.getServices().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                String serviceConfigIdentifier2 = ((Service) next).getServiceConfigIdentifier();
                if (serviceConfigIdentifier2 != null && StringsKt.startsWith$default(serviceConfigIdentifier2, "archive", false, 2, (Object) null)) {
                    break;
                }
            }
            Service service2 = (Service) next;
            if (service2 != null) {
                initArchive(service2);
                return;
            }
            Iterator<T> it3 = data.getMarket().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next3 = it3.next();
                if (((Market) next3).getType() == MarketTypes.subscription) {
                    obj = next3;
                    break;
                }
            }
            if (((Market) obj) != null) {
                initNewArchive();
                return;
            }
            LinearLayout lInfoArchives = getBinding().lInfoArchives;
            Intrinsics.checkNotNullExpressionValue(lInfoArchives, "lInfoArchives");
            ViewKt.gone(lInfoArchives);
        }
    }

    private final void initArchive(final Service service) {
        VisitsLocale visits;
        VisitsBody body;
        VisitsBottomView bottomView;
        VisitsArcAvailable archiveAvailable;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (visits = data.getVisits()) == null || (body = visits.getBody()) == null || (bottomView = body.getBottomView()) == null || (archiveAvailable = bottomView.getArchiveAvailable()) == null) {
            return;
        }
        getBinding().tvArchiveInfo.setText(archiveAvailable.getTitle());
        AppCompatButton appCompatButton = getBinding().btnSubsGetAccess;
        TextTitle forwardButton = archiveAvailable.getForwardButton();
        appCompatButton.setText(forwardButton != null ? forwardButton.getTitle() : null);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                CallHistoryFragment.initArchive$lambda$8$lambda$7$lambda$6(service, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initArchive$lambda$8$lambda$7$lambda$6(Service service, CallHistoryFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.VisitsEventName.INSTANCE.getParentScreen(), "archive_request", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_archiveService, BundleKt.bundleOf(TuplesKt.to("curService", service.getServiceConfigIdentifier())), null, 8, null);
    }

    private final void initNewArchive() {
        VisitsLocale visits;
        VisitsBody body;
        VisitsBottomView bottomView;
        VisitsArcUnavailable archiveUnavailable;
        FragmentVisitsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (visits = data.getVisits()) == null || (body = visits.getBody()) == null || (bottomView = body.getBottomView()) == null || (archiveUnavailable = bottomView.getArchiveUnavailable()) == null) {
            return;
        }
        binding.tvArchiveInfo.setText(archiveUnavailable.getTitle());
        AppCompatButton appCompatButton = binding.btnSubsGetAccess;
        TextTitle activateButton = archiveUnavailable.getActivateButton();
        appCompatButton.setText(activateButton != null ? activateButton.getTitle() : null);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                CallHistoryFragment.initNewArchive$lambda$12$lambda$11$lambda$10$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNewArchive$lambda$12$lambda$11$lambda$10$lambda$9(CallHistoryFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.VisitsEventName.INSTANCE.getParentScreen(), "archive_subscribe", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.callHistoryFragment, R.id.action_callHistoryFragment_to_subscriptionFragment, null, null, 12, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        getProfileViewModel().loadProfileIfNeeded();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        VisitsLocale visits;
        TextTitle allHistory;
        PromoView promoView;
        TitleWithParam title;
        PromoView promoView2;
        TitleWithParam title2;
        PromoView promoView3;
        PromoView promoView4;
        TitleWithParam title3;
        PromoView promoView5;
        TitleWithParam title4;
        PromoView promoView6;
        VisitsEmptyView emptyView;
        VisitsEmptyView emptyView2;
        FragmentVisitsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (visits = data.getVisits()) == null) {
            return;
        }
        Toolbar toolbar = binding.toolbar;
        TextTitle navigation = visits.getNavigation();
        String title5 = null;
        toolbar.setTitle(navigation != null ? navigation.getTitle() : null);
        TextView textView = binding.tvNoCalls;
        VisitsBody body = visits.getBody();
        textView.setText((body == null || (emptyView2 = body.getEmptyView()) == null) ? null : emptyView2.getTitle());
        TextView textView2 = binding.tvHistoryCalls;
        VisitsBody body2 = visits.getBody();
        textView2.setText((body2 == null || (emptyView = body2.getEmptyView()) == null) ? null : emptyView.getTotallyEmpty());
        TextView textView3 = binding.btnWantMore;
        VisitsBody body3 = visits.getBody();
        textView3.setText((body3 == null || (promoView6 = body3.getPromoView()) == null) ? null : promoView6.getBtnPromoWantMore());
        TextView textView4 = binding.tvInfo;
        VisitsBody body4 = visits.getBody();
        String strValueOf = String.valueOf((body4 == null || (promoView5 = body4.getPromoView()) == null || (title4 = promoView5.getTitle()) == null) ? null : title4.getTitle());
        VisitsBody body5 = visits.getBody();
        String strValueOf2 = String.valueOf((body5 == null || (promoView4 = body5.getPromoView()) == null || (title3 = promoView4.getTitle()) == null) ? null : title3.getParam1());
        int color = ContextCompat.getColor(requireContext(), R.color.sputnik_header_black);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textView4.setText(ViewUtilsKt.highlightText$default(strValueOf, strValueOf2, color, contextRequireContext, 0, 16, null));
        TextView textView5 = binding.btnWantMore2;
        VisitsBody body6 = visits.getBody();
        textView5.setText((body6 == null || (promoView3 = body6.getPromoView()) == null) ? null : promoView3.getBtnPromoWantMore());
        TextView textView6 = binding.tvInfo2;
        VisitsBody body7 = visits.getBody();
        String strValueOf3 = String.valueOf((body7 == null || (promoView2 = body7.getPromoView()) == null || (title2 = promoView2.getTitle()) == null) ? null : title2.getTitle());
        VisitsBody body8 = visits.getBody();
        String strValueOf4 = String.valueOf((body8 == null || (promoView = body8.getPromoView()) == null || (title = promoView.getTitle()) == null) ? null : title.getParam1());
        int color2 = ContextCompat.getColor(requireContext(), R.color.sputnik_header_black);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        textView6.setText(ViewUtilsKt.highlightText$default(strValueOf3, strValueOf4, color2, contextRequireContext2, 0, 16, null));
        AppCompatButton appCompatButton = binding.btnPromo;
        VisitsBody body9 = visits.getBody();
        if (body9 != null && (allHistory = body9.getAllHistory()) != null) {
            title5 = allHistory.getTitle();
        }
        appCompatButton.setText(title5);
    }
}
