package sputnik.axmor.com.sputnik.ui.main.market;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.AlisaEvents;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GorservEvents;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.databinding.LayoutCompleteRegistrationBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.demo.DemoModeLocale;
import com.sputnik.common.entities.localization.IntercomLocale;
import com.sputnik.common.entities.localization.ItemSubscription;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.MarketBody;
import com.sputnik.common.entities.localization.MarketLocale;
import com.sputnik.common.entities.localization.ServicePopupBody;
import com.sputnik.common.entities.localization.ServicePopupLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionBody;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionInfoView;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionLocale;
import com.sputnik.common.entities.market.MarketItems;
import com.sputnik.common.entities.market.items.ItemsIds;
import com.sputnik.common.entities.market.items.MarketItem;
import com.sputnik.common.entities.services.OuterService;
import com.sputnik.common.entities.services.OuterServiceAppearance;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import com.sputnik.subscriptions.databinding.FragmentNewMarketBinding;
import com.sputnik.subscriptions.ui.adapters.SubscriptionsAdapter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.company.Company;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.adapter.MarketItemsAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.adapter.ServicesAdapter;

/* compiled from: NewMarketFragment.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\u00020\u0001:\u0001gB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0003R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u00105\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00105\u001a\u0004\bJ\u0010KR\u001d\u0010Q\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00105\u001a\u0004\bO\u0010PR\"\u0010S\u001a\u00020R8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006h"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/NewMarketFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/entities/services/OuterService;", "marketResponse", "", "showIntercomMessage", "(Lcom/sputnik/common/entities/services/OuterService;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "openSubscriptionsTab", "openServicesTab", "openKeysTab", "deactivateAllTabs", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "selectTab", "initViews", "localize", "onPause", "Lcom/sputnik/subscriptions/databinding/FragmentNewMarketBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/subscriptions/databinding/FragmentNewMarketBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel$delegate", "getHelpViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMarketFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NewMarketFragment.class, "binding", "getBinding()Lcom/sputnik/subscriptions/databinding/FragmentNewMarketBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static MarketItems destination = MarketItems.SUBS;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: helpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy helpViewModel;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;
    public ISupportManager supportManager;

    /* compiled from: NewMarketFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarketItems.values().length];
            try {
                iArr[MarketItems.SERVICES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarketItems.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarketItems.ITEMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderSubscriptionsUi$lambda$23$lambda$15(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderSubscriptionsUi$lambda$23$lambda$18(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentNewMarketBinding getBinding() {
        return (FragmentNewMarketBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    /* compiled from: NewMarketFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/NewMarketFragment$Companion;", "", "<init>", "()V", "Lcom/sputnik/common/entities/market/MarketItems;", "destination", "Lcom/sputnik/common/entities/market/MarketItems;", "getDestination", "()Lcom/sputnik/common/entities/market/MarketItems;", "setDestination", "(Lcom/sputnik/common/entities/market/MarketItems;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setDestination(MarketItems marketItems) {
            Intrinsics.checkNotNullParameter(marketItems, "<set-?>");
            NewMarketFragment.destination = marketItems;
        }
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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

    private final SubscriptionsViewModel getSubscriptionViewModel() {
        return (SubscriptionsViewModel) this.subscriptionViewModel.getValue();
    }

    private final HelpViewModel getHelpViewModel() {
        return (HelpViewModel) this.helpViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
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

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
        return null;
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
        getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarket());
        SubscriptionsViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        SubscriptionsViewModel subscriptionViewModel2 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment.onViewCreated.2
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
                NewMarketFragment newMarketFragment = NewMarketFragment.this;
                LinearLayout root = newMarketFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(newMarketFragment, root, it);
            }
        });
        SubscriptionsViewModel subscriptionViewModel3 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionViewModel3.observeSubState(viewLifecycleOwner3, new Function1<SubscriptionsViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getMarketState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment.onViewCreated.4
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
                if (it == Resource.Status.SUCCESS) {
                    NewMarketFragment.this.getBinding().layoutSwipeRefresh.setRefreshing(false);
                }
            }
        });
        NavigationViewModel navigationViewModel = getNavigationViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        navigationViewModel.observeState(viewLifecycleOwner4, new Function1<NavigationViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationViewState navigationViewState) {
                invoke2(navigationViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavigationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NewMarketFragment.this.selectTab();
            }
        });
    }

    /* compiled from: NewMarketFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, NewMarketFragment.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((NewMarketFragment) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    public final void selectTab() {
        int i = WhenMappings.$EnumSwitchMapping$0[destination.ordinal()];
        if (i == 1) {
            openServicesTab();
        } else if (i == 2) {
            openSubscriptionsTab();
        } else {
            if (i != 3) {
                return;
            }
            openKeysTab();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        ServicePopupLocale servicePopup;
        ServicePopupBody body;
        final FragmentNewMarketBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvServices;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String partner = (data == null || (servicePopup = data.getServicePopup()) == null || (body = servicePopup.getBody()) == null) ? null : body.getPartner();
        Company company = (Company) CollectionsKt.firstOrNull((List) getHelpViewModel().getCurrentState().getCompaniesList());
        String img = company != null ? company.getImg() : null;
        FragmentManager childFragmentManager = getChildFragmentManager();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Analytics analytics = getAnalytics();
        Function2<OuterService, Integer, Unit> function2 = new Function2<OuterService, Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$initViews$1$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(OuterService outerService, Integer num) throws Resources.NotFoundException {
                invoke(outerService, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(OuterService marketResponse, int i) throws Resources.NotFoundException {
                String link;
                Intrinsics.checkNotNullParameter(marketResponse, "marketResponse");
                if (i == 2) {
                    OuterServiceAppearance appearance = marketResponse.getAppearance();
                    String title = appearance != null ? appearance.getTitle() : null;
                    OuterServiceAppearance appearance2 = marketResponse.getAppearance();
                    link = appearance2 != null ? appearance2.getLink() : null;
                    if (link != null) {
                        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("url", link), TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, title));
                        NavController navController = this.this$0.getNavController();
                        if (navController != null) {
                            NavControllerKt.safeNavigate$default(navController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_webViewFragment, bundleBundleOf, null, 8, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    if (i != 111) {
                        return;
                    }
                    this.this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickServicesScreen());
                    NavController navController2 = this.this$0.getNavController();
                    if (navController2 != null) {
                        NavControllerKt.safeNavigate$default(navController2, R.id.action_mainHostFragment_to_gorserv, null, null, 6, null);
                        return;
                    }
                    return;
                }
                OuterServiceAppearance appearance3 = marketResponse.getAppearance();
                String title2 = appearance3 != null ? appearance3.getTitle() : null;
                OuterServiceAppearance appearance4 = marketResponse.getAppearance();
                link = appearance4 != null ? appearance4.getLink() : null;
                if (link == null) {
                    this.this$0.showIntercomMessage(marketResponse);
                    return;
                }
                Bundle bundleBundleOf2 = BundleKt.bundleOf(TuplesKt.to("url", link), TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, title2));
                NavController navController3 = this.this$0.getNavController();
                if (navController3 != null) {
                    NavControllerKt.safeNavigate$default(navController3, R.id.mainHostFragment, R.id.action_mainHostFragment_to_partner_dialog, bundleBundleOf2, null, 8, null);
                }
                this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketServPartnerOfferCustom());
            }
        };
        Intrinsics.checkNotNull(childFragmentManager);
        Intrinsics.checkNotNull(viewLifecycleOwner);
        recyclerView.setAdapter(new ServicesAdapter(null, partner, function2, img, childFragmentManager, viewLifecycleOwner, analytics, 1, null));
        RecyclerView recyclerView2 = binding.rvKeys;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setAdapter(new MarketItemsAdapter(new Function1<MarketItem, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$initViews$1$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MarketItem marketItem) throws Resources.NotFoundException {
                invoke2(marketItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MarketItem it) throws Resources.NotFoundException {
                MarketItem.MarketItemAppearance.TextTitle finale;
                Intrinsics.checkNotNullParameter(it, "it");
                String identifier = it.getIdentifier();
                if (Intrinsics.areEqual(identifier, ItemsIds.licensed_keys.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickKeyMarket());
                    NavController navController = this.this$0.getNavController();
                    if (navController != null) {
                        NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_marketItemDetailsFragment, BundleKt.bundleOf(TuplesKt.to("id", it.getIdentifier())), null, 4, null);
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(identifier, ItemsIds.yandex_catalog.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new AlisaEvents.ClickAlisaMarket());
                    MarketItem.MarketItemAppearance appearance = it.getAppearance();
                    Pair pair = TuplesKt.to("url", (appearance == null || (finale = appearance.getFinale()) == null) ? null : finale.getLink());
                    MarketItem.MarketItemAppearance appearance2 = it.getAppearance();
                    Bundle bundleBundleOf = BundleKt.bundleOf(pair, TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, appearance2 != null ? appearance2.getTitle() : null));
                    NavController navController2 = this.this$0.getNavController();
                    if (navController2 != null) {
                        NavControllerKt.safeNavigate$default(navController2, R.id.mainHostFragment, R.id.action_mainHostFragment_to_webViewFragment, bundleBundleOf, null, 8, null);
                    }
                }
            }
        }));
        binding.layoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                NewMarketFragment.initViews$lambda$8$lambda$2(this.f$0);
            }
        });
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNull(toolbar);
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        selectTab();
        binding.btnServices.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMarketFragment.initViews$lambda$8$lambda$4(binding, this, view);
            }
        });
        binding.btnKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMarketFragment.initViews$lambda$8$lambda$5(binding, this, view);
            }
        });
        binding.btnSubscriptions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMarketFragment.initViews$lambda$8$lambda$6(this.f$0, view);
            }
        });
        LinearLayout root = binding.layoutCompleteRegistration.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewBindingUtilsKt.visibilityBasedOn(root, Boolean.valueOf(getPrefManager().getIsNoDomofon()));
        binding.layoutCompleteRegistration.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMarketFragment.initViews$lambda$8$lambda$7(this.f$0, view);
            }
        });
    }

    public NewMarketFragment() {
        super(R.layout.fragment_new_market);
        this.binding = new ViewBindingFragmentDelegate(this, NewMarketFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.helpViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HelpViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$helpViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    return ActivityKt.findNavController(activity, R.id.root_nav_host_fragment);
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$2(NewMarketFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSubscriptionViewModel().getSubscriptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$4(FragmentNewMarketBinding this_with, NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView ivServicesOnboarding = this_with.ivServicesOnboarding;
        Intrinsics.checkNotNullExpressionValue(ivServicesOnboarding, "ivServicesOnboarding");
        ViewKt.gone(ivServicesOnboarding);
        this$0.openServicesTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$5(FragmentNewMarketBinding this_with, NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView ivKeysOnboarding = this_with.ivKeysOnboarding;
        Intrinsics.checkNotNullExpressionValue(ivKeysOnboarding, "ivKeysOnboarding");
        ViewKt.gone(ivKeysOnboarding);
        this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickKeyMarket());
        this$0.openKeysTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$6(NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openSubscriptionsTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$7(NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInvitesViewModel().clearInvites();
        this$0.getProfileViewModel().cleanEvents();
        NavController navController = this$0.getNavController();
        if (navController != null) {
            NavControllerKt.safeNavigate$default(navController, R.id.action_mainNoIntercomFragment_to_connectIntercomFragment, null, null, 6, null);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        DemoModeLocale demo;
        TextTitle endRegistrationButton;
        DemoModeLocale demo2;
        MarketBody body;
        List<String> sectionNewTitles;
        MarketBody body2;
        List<String> sectionNewTitles2;
        MarketBody body3;
        List<String> sectionNewTitles3;
        TextTitle navigation;
        FragmentNewMarketBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        MarketLocale market = data != null ? data.getMarket() : null;
        binding.toolbarTitle.setText((market == null || (navigation = market.getNavigation()) == null) ? null : navigation.getTitle());
        Button button = binding.btnSubscriptions;
        String str = (market == null || (body3 = market.getBody()) == null || (sectionNewTitles3 = body3.getSectionNewTitles()) == null) ? null : (String) CollectionsKt.getOrNull(sectionNewTitles3, 0);
        if (str == null) {
            str = "";
        }
        button.setText(str);
        Button button2 = binding.btnServices;
        String str2 = (market == null || (body2 = market.getBody()) == null || (sectionNewTitles2 = body2.getSectionNewTitles()) == null) ? null : (String) CollectionsKt.getOrNull(sectionNewTitles2, 1);
        if (str2 == null) {
            str2 = "";
        }
        button2.setText(str2);
        Button button3 = binding.btnKeys;
        String str3 = (market == null || (body = market.getBody()) == null || (sectionNewTitles = body.getSectionNewTitles()) == null) ? null : (String) CollectionsKt.getOrNull(sectionNewTitles, 2);
        button3.setText(str3 != null ? str3 : "");
        LayoutCompleteRegistrationBinding layoutCompleteRegistrationBinding = binding.layoutCompleteRegistration;
        TextView textView = layoutCompleteRegistrationBinding.tvTitle;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText((data2 == null || (demo2 = data2.getDemo()) == null) ? null : demo2.getNotice());
        AppCompatButton appCompatButton = layoutCompleteRegistrationBinding.btnApply;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 != null && (demo = data3.getDemo()) != null && (endRegistrationButton = demo.getEndRegistrationButton()) != null) {
            title = endRegistrationButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showIntercomMessage(OuterService marketResponse) {
        IntercomLocale intercom;
        String noServiceTitle;
        String identifier = marketResponse.getIdentifier();
        if (Intrinsics.areEqual(marketResponse.getIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getINSTALL_SPUTNIK_IDENTIFIER())) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            NavControllerKt.safeNavigate$default(ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment), R.id.action_fragmentNewMarket_to_fragment_send_install_sputnik_request, null, null, 6, null);
            return;
        }
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (intercom = data.getIntercom()) == null || (noServiceTitle = intercom.getNoServiceTitle()) == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(identifier);
        String str = String.format(noServiceTitle, Arrays.copyOf(new Object[]{identifier, "6.24.3"}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        getSupportManager().displayMessenger(str + "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionsUi(SubscriptionsViewState subscriptionsViewState) {
        MarketLocale market;
        MarketBody body;
        ItemSubscription itemSubscription;
        SettingsSubscriptionLocale subscriptionSettings;
        SettingsSubscriptionBody body2;
        SettingsSubscriptionInfoView subscriptionInfoView;
        List<String> subtitles;
        List listPlus;
        final FragmentNewMarketBinding binding = getBinding();
        if (subscriptionsViewState.getMarketState() == Resource.Status.NONE) {
            getSubscriptionViewModel().getSubscriptions();
        }
        if (subscriptionsViewState.getMarketState() == Resource.Status.LOADING) {
            LinearLayout serviceLoader = binding.serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
        } else {
            if (subscriptionsViewState.getSubscriptions() == null && subscriptionsViewState.getServices() == null && subscriptionsViewState.getActiveSubscription() == null && subscriptionsViewState.getNeedToLockAllViews()) {
                deactivateAllTabs();
            }
            LinearLayout serviceLoader2 = binding.serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
            ViewKt.gone(serviceLoader2);
        }
        String btnSubscribe = null;
        if (subscriptionsViewState.getSubscriptions() == null) {
            binding.btnSubscriptions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMarketFragment.renderSubscriptionsUi$lambda$23$lambda$15(view);
                }
            });
            binding.btnSubscriptions.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.background_button_tab_locked));
            binding.btnSubscriptions.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_door_closed_outline, 0, 0, 0);
            if (subscriptionsViewState.getServices() != null) {
                openServicesTab();
            }
        } else {
            Button button = binding.btnSubscriptions;
            button.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.background_button_tab));
            button.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMarketFragment.renderSubscriptionsUi$lambda$23$lambda$17$lambda$16(this.f$0, view);
                }
            });
            button.setCompoundDrawables(null, null, null, null);
        }
        if (subscriptionsViewState.getServices() == null) {
            if (destination == MarketItems.SERVICES && subscriptionsViewState.getSubscriptions() != null) {
                openSubscriptionsTab();
            }
            binding.btnServices.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMarketFragment.renderSubscriptionsUi$lambda$23$lambda$18(view);
                }
            });
            binding.btnServices.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.background_button_tab_locked));
            binding.btnServices.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_door_closed_outline, 0, 0, 0);
        } else {
            if (subscriptionsViewState.getNeedToShowRedPointOnServices() && destination == MarketItems.SUBS) {
                ImageView ivServicesOnboarding = binding.ivServicesOnboarding;
                Intrinsics.checkNotNullExpressionValue(ivServicesOnboarding, "ivServicesOnboarding");
                ViewKt.visible(ivServicesOnboarding);
            }
            Button button2 = binding.btnServices;
            button2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.background_button_tab));
            button2.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMarketFragment.renderSubscriptionsUi$lambda$23$lambda$20$lambda$19(binding, this, view);
                }
            });
            button2.setCompoundDrawables(null, null, null, null);
        }
        RecyclerView recyclerView = binding.rvSubscriptions;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        List<BaseSubscription> subscriptions = subscriptionsViewState.getSubscriptions();
        List listFilterNotNull = (subscriptions == null || (listPlus = CollectionsKt.plus((Collection<? extends BaseSubscription>) subscriptions, subscriptionsViewState.getActiveSubscription())) == null) ? null : CollectionsKt.filterNotNull(listPlus);
        if (listFilterNotNull == null) {
            listFilterNotNull = CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(listFilterNotNull, new Comparator() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$renderSubscriptionsUi$lambda$23$lambda$22$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((BaseSubscription) t).getOrder(), ((BaseSubscription) t2).getOrder());
            }
        }));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String strValueOf = String.valueOf((data == null || (subscriptionSettings = data.getSubscriptionSettings()) == null || (body2 = subscriptionSettings.getBody()) == null || (subscriptionInfoView = body2.getSubscriptionInfoView()) == null || (subtitles = subscriptionInfoView.getSubtitles()) == null) ? null : (String) CollectionsKt.firstOrNull((List) subtitles));
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (market = data2.getMarket()) != null && (body = market.getBody()) != null && (itemSubscription = body.getItemSubscription()) != null) {
            btnSubscribe = itemSubscription.getBtnSubscribe();
        }
        recyclerView.setAdapter(new SubscriptionsAdapter(mutableList, new Function1<BaseSubscription, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$renderSubscriptionsUi$1$5$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) throws Resources.NotFoundException {
                invoke2(baseSubscription);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseSubscription it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardPayment());
                SubscriptionDetails subscriptionDetails = it.getSubscriptionDetails();
                String productId = subscriptionDetails != null ? subscriptionDetails.getProductId() : null;
                if (Intrinsics.areEqual(productId, Subscriptions.standard.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardDet());
                } else if (Intrinsics.areEqual(productId, Subscriptions.premium.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsPremiumDet());
                }
                NavController navController = this.this$0.getNavController();
                if (navController != null) {
                    SubscriptionDetails subscriptionDetails2 = it.getSubscriptionDetails();
                    NavControllerKt.safeNavigate$default(navController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_subscriptions_navigation, BundleKt.bundleOf(TuplesKt.to("product_id", subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null)), null, 8, null);
                }
            }
        }, new Function1<BaseSubscription, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment$renderSubscriptionsUi$1$5$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) throws Resources.NotFoundException {
                invoke2(baseSubscription);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseSubscription it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardPayment());
                SubscriptionDetails subscriptionDetails = it.getSubscriptionDetails();
                String productId = subscriptionDetails != null ? subscriptionDetails.getProductId() : null;
                if (Intrinsics.areEqual(productId, Subscriptions.standard.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardPayment());
                } else if (Intrinsics.areEqual(productId, Subscriptions.premium.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsPremiumPayment());
                }
                NavController navController = this.this$0.getNavController();
                if (navController != null) {
                    SubscriptionDetails subscriptionDetails2 = it.getSubscriptionDetails();
                    NavControllerKt.safeNavigate$default(navController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_subscriptions_navigation, BundleKt.bundleOf(TuplesKt.to("product_id", subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null)), null, 8, null);
                }
            }
        }, strValueOf, String.valueOf(btnSubscribe)));
        if (subscriptionsViewState.getServices() != null && (!r0.isEmpty())) {
            RecyclerView.Adapter adapter = getBinding().rvServices.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.adapter.ServicesAdapter");
            ServicesAdapter servicesAdapter = (ServicesAdapter) adapter;
            List<OuterService> services = subscriptionsViewState.getServices();
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            servicesAdapter.submitList(services);
        }
        if (subscriptionsViewState.getItems() != null && (!r0.isEmpty())) {
            Button btnKeys = getBinding().btnKeys;
            Intrinsics.checkNotNullExpressionValue(btnKeys, "btnKeys");
            ViewKt.visible(btnKeys);
            RecyclerView.Adapter adapter2 = getBinding().rvKeys.getAdapter();
            Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.adapter.MarketItemsAdapter");
            MarketItemsAdapter marketItemsAdapter = (MarketItemsAdapter) adapter2;
            List<MarketItem> items = subscriptionsViewState.getItems();
            if (items == null) {
                items = CollectionsKt.emptyList();
            }
            marketItemsAdapter.submitList(items);
        }
        Intrinsics.checkNotNull(recyclerView);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderSubscriptionsUi$lambda$23$lambda$17$lambda$16(NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openSubscriptionsTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderSubscriptionsUi$lambda$23$lambda$20$lambda$19(FragmentNewMarketBinding this_with, NewMarketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView ivServicesOnboarding = this_with.ivServicesOnboarding;
        Intrinsics.checkNotNullExpressionValue(ivServicesOnboarding, "ivServicesOnboarding");
        ViewKt.gone(ivServicesOnboarding);
        this$0.openServicesTab();
    }

    private final void openSubscriptionsTab() {
        FragmentNewMarketBinding binding = getBinding();
        getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubs());
        destination = MarketItems.SUBS;
        Button btnSubscriptions = binding.btnSubscriptions;
        Intrinsics.checkNotNullExpressionValue(btnSubscriptions, "btnSubscriptions");
        ViewKt.activate(btnSubscriptions);
        Button btnServices = binding.btnServices;
        Intrinsics.checkNotNullExpressionValue(btnServices, "btnServices");
        ViewKt.disactivate(btnServices);
        RecyclerView rvSubscriptions = binding.rvSubscriptions;
        Intrinsics.checkNotNullExpressionValue(rvSubscriptions, "rvSubscriptions");
        ViewKt.visible(rvSubscriptions);
        RecyclerView rvServices = binding.rvServices;
        Intrinsics.checkNotNullExpressionValue(rvServices, "rvServices");
        ViewKt.gone(rvServices);
        Button btnKeys = binding.btnKeys;
        Intrinsics.checkNotNullExpressionValue(btnKeys, "btnKeys");
        ViewKt.disactivate(btnKeys);
        RecyclerView rvKeys = binding.rvKeys;
        Intrinsics.checkNotNullExpressionValue(rvKeys, "rvKeys");
        ViewKt.gone(rvKeys);
    }

    private final void openServicesTab() {
        FragmentNewMarketBinding binding = getBinding();
        getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketServ());
        destination = MarketItems.SERVICES;
        Button btnSubscriptions = binding.btnSubscriptions;
        Intrinsics.checkNotNullExpressionValue(btnSubscriptions, "btnSubscriptions");
        ViewKt.disactivate(btnSubscriptions);
        Button btnServices = binding.btnServices;
        Intrinsics.checkNotNullExpressionValue(btnServices, "btnServices");
        ViewKt.activate(btnServices);
        RecyclerView rvSubscriptions = binding.rvSubscriptions;
        Intrinsics.checkNotNullExpressionValue(rvSubscriptions, "rvSubscriptions");
        ViewKt.gone(rvSubscriptions);
        RecyclerView rvServices = binding.rvServices;
        Intrinsics.checkNotNullExpressionValue(rvServices, "rvServices");
        ViewKt.visible(rvServices);
        Button btnKeys = binding.btnKeys;
        Intrinsics.checkNotNullExpressionValue(btnKeys, "btnKeys");
        ViewKt.disactivate(btnKeys);
        RecyclerView rvKeys = binding.rvKeys;
        Intrinsics.checkNotNullExpressionValue(rvKeys, "rvKeys");
        ViewKt.gone(rvKeys);
    }

    private final void openKeysTab() {
        FragmentNewMarketBinding binding = getBinding();
        destination = MarketItems.ITEMS;
        Button btnSubscriptions = binding.btnSubscriptions;
        Intrinsics.checkNotNullExpressionValue(btnSubscriptions, "btnSubscriptions");
        ViewKt.disactivate(btnSubscriptions);
        Button btnServices = binding.btnServices;
        Intrinsics.checkNotNullExpressionValue(btnServices, "btnServices");
        ViewKt.disactivate(btnServices);
        Button btnKeys = binding.btnKeys;
        Intrinsics.checkNotNullExpressionValue(btnKeys, "btnKeys");
        ViewKt.activate(btnKeys);
        RecyclerView rvSubscriptions = binding.rvSubscriptions;
        Intrinsics.checkNotNullExpressionValue(rvSubscriptions, "rvSubscriptions");
        ViewKt.gone(rvSubscriptions);
        RecyclerView rvServices = binding.rvServices;
        Intrinsics.checkNotNullExpressionValue(rvServices, "rvServices");
        ViewKt.gone(rvServices);
        RecyclerView rvKeys = binding.rvKeys;
        Intrinsics.checkNotNullExpressionValue(rvKeys, "rvKeys");
        ViewKt.visible(rvKeys);
    }

    private final void deactivateAllTabs() {
        FragmentNewMarketBinding binding = getBinding();
        destination = MarketItems.SUBS;
        Button btnSubscriptions = binding.btnSubscriptions;
        Intrinsics.checkNotNullExpressionValue(btnSubscriptions, "btnSubscriptions");
        ViewKt.disactivate(btnSubscriptions);
        Button btnServices = binding.btnServices;
        Intrinsics.checkNotNullExpressionValue(btnServices, "btnServices");
        ViewKt.disactivate(btnServices);
        Button btnKeys = binding.btnKeys;
        Intrinsics.checkNotNullExpressionValue(btnKeys, "btnKeys");
        ViewKt.disactivate(btnKeys);
        RecyclerView rvSubscriptions = binding.rvSubscriptions;
        Intrinsics.checkNotNullExpressionValue(rvSubscriptions, "rvSubscriptions");
        ViewKt.gone(rvSubscriptions);
        RecyclerView rvServices = binding.rvServices;
        Intrinsics.checkNotNullExpressionValue(rvServices, "rvServices");
        ViewKt.gone(rvServices);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().layoutSwipeRefresh.setRefreshing(false);
    }
}
