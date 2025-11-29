package sputnik.axmor.com.sputnik.ui.subscriptions;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.NavigationUI;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyErrors;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.SubscriptionLicense;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.Features;
import com.sputnik.common.entities.subscriptions.Header;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.NoticeBody;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.Service;
import com.sputnik.common.entities.subscriptions.ServiceAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.FeatureCardView;
import com.sputnik.common.ui.view.TextViewWithImage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.subscriptions.Services;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.subscriptions.analytics.NewSubscriptionsEvents;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import com.sputnik.subscriptions.databinding.FragmentSubscriptionDetailsBinding;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.Util;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewState;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;
import sputnik.axmor.com.sputnik.viewmodels.ISubscriptionViewModel;

/* compiled from: SubscriptionDetailsFragment.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u001d\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J!\u0010(\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u00109\u001a\u0004\bN\u0010OR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001d\u0010]\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u00109\u001a\u0004\b[\u0010\\R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u00109\u001a\u0004\b_\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u001b\u0010e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u00109\u001a\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010aR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010gR\"\u0010t\u001a\u0010\u0012\f\u0012\n s*\u0004\u0018\u00010r0r0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\"\u0010v\u001a\u0010\u0012\f\u0012\n s*\u0004\u0018\u00010r0r0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010u¨\u0006w"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/subscriptions/SubscriptionDetailsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "serviceId", "", "handleNavigation", "(Ljava/lang/String;)V", "handlePaymentPromo", "", "getSubscriptionPrice", "()Ljava/lang/Integer;", "startBuySubscription", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Landroid/view/View;", "view", "insetTop", "changeAppBarHeight", "(Landroid/view/View;I)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "localize", "initViews", "Lcom/sputnik/common/viewmodels/NavigationAction;", "action", "onNeedCustomNavigate", "(Lcom/sputnik/common/viewmodels/NavigationAction;)V", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/subscriptions/databinding/FragmentSubscriptionDetailsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/subscriptions/databinding/FragmentSubscriptionDetailsBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "primaryColor", "Ljava/lang/Integer;", "productId$delegate", "getProductId", "()Ljava/lang/String;", "productId", "serviceId$delegate", "getServiceId", "_serviceId", "Ljava/lang/String;", "needShowPayment$delegate", "getNeedShowPayment", "()Z", "needShowPayment", "_needShowPayment", "Z", "subId", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "isAlreadyNavigatedToService", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "start3dsPaymentTokenResult", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionDetailsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SubscriptionDetailsFragment.class, "binding", "getBinding()Lcom/sputnik/subscriptions/databinding/FragmentSubscriptionDetailsBinding;", 0))};
    private boolean _needShowPayment;
    private String _serviceId;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    private boolean isAlreadyNavigatedToService;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: needShowPayment$delegate, reason: from kotlin metadata */
    private final Lazy needShowPayment;
    private Integer primaryColor;

    /* renamed from: productId$delegate, reason: from kotlin metadata */
    private final Lazy productId;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final Lazy serviceId;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;
    private String subId;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* compiled from: SubscriptionDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceAppearance.ServiceBadges.values().length];
            try {
                iArr[ServiceAppearance.ServiceBadges.f24new.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServiceAppearance.ServiceBadges.beta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSubscriptionDetailsBinding getBinding() {
        return (FragmentSubscriptionDetailsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final SubscriptionViewModel getSubscriptionViewModel() {
        return (SubscriptionViewModel) this.subscriptionViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProductId() {
        return (String) this.productId.getValue();
    }

    private final String getServiceId() {
        return (String) this.serviceId.getValue();
    }

    private final boolean getNeedShowPayment() {
        return ((Boolean) this.needShowPayment.getValue()).booleanValue();
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
    public static final void startGetPaymentTokenResult$lambda$4(SubscriptionDetailsFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        BaseSubscription baseSubscription;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardPayment());
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            List<BaseSubscription> subscriptions = this$0.getSubscriptionsViewModel().getCurrentState().getSubscriptions();
            if (subscriptions != null) {
                Iterator<T> it = subscriptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    SubscriptionDetails subscriptionDetails2 = ((BaseSubscription) next).getSubscriptionDetails();
                    if (Intrinsics.areEqual(subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null, this$0.getProductId())) {
                        break;
                    }
                }
                baseSubscription = (BaseSubscription) next;
            } else {
                baseSubscription = null;
            }
            String productId = this$0.getProductId();
            if (Intrinsics.areEqual(productId, Subscriptions.standard.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsStandardDetPayment());
            } else if (Intrinsics.areEqual(productId, Subscriptions.premium.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketSubsPremiumDetPayment());
            }
            Plan plan = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
            if (baseSubscription != null) {
                SubscriptionViewModel subscriptionViewModel = this$0.getSubscriptionViewModel();
                String strValueOf = String.valueOf(this$0.getProductId());
                String identifier = plan != null ? plan.getIdentifier() : null;
                Intrinsics.checkNotNull(identifier);
                Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
                subscriptionViewModel.subscribe(strValueOf, identifier, tokenizationResultCreateTokenizationResult.getPaymentToken(), tokenizationResultCreateTokenizationResult.getPaymentMethodType());
            }
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            return;
        }
        LinearLayout serviceLoader2 = this$0.getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
        ViewKt.gone(serviceLoader2);
        LocalizationLocalModel data2 = this$0.getLocalizationScreen().getData();
        if (data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getSubscriptionViewModel().notifyErrorMessage(operationFailure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$6(SubscriptionDetailsFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            this$0.getSubscriptionViewModel().getCurrentState(String.valueOf(this$0.getProductId()));
            return;
        }
        LinearLayout serviceLoader2 = this$0.getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
        ViewKt.gone(serviceLoader2);
        LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
        if (data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getSubscriptionViewModel().notifyErrorMessage(operationFailure);
    }

    public SubscriptionDetailsFragment() {
        super(R.layout.fragment_subscription_details);
        this.binding = new ViewBindingFragmentDelegate(this, SubscriptionDetailsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$viewModels$default$4
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
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.productId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$productId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("product_id") : null);
            }
        });
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$serviceId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("curService") : null);
            }
        });
        this.needShowPayment = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$needShowPayment$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                Boolean bool = (Boolean) (arguments != null ? arguments.get("need_show_payment") : null);
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        this.subId = "";
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SubscriptionDetailsFragment.startGetPaymentTokenResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SubscriptionDetailsFragment.start3dsPaymentTokenResult$lambda$6(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle viewPaymentInProgress;
        TextView textView = getBinding().tvPaymentInProgress;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText(String.valueOf((data == null || (viewPaymentInProgress = data.getViewPaymentInProgress()) == null) ? null : viewPaymentInProgress.getTitle()));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentSubscriptionDetailsBinding binding = getBinding();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        NavigationUI.setupWithNavController$default(toolbar, ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment), null, 4, null);
        binding.appBar.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return SubscriptionDetailsFragment.initViews$lambda$9$lambda$8(this.f$0, view, windowInsets);
            }
        });
        ConstraintLayout viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        AppCompatButton btnSubscribe = binding.btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSubscribe, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$initViews$1$2
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
                if (Intrinsics.areEqual(this.this$0.getProductId(), Subscriptions.standard.toString())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickBuyMarketStandardDetails());
                }
                this.this$0.startBuySubscription();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets initViews$lambda$9$lambda$8(SubscriptionDetailsFragment this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        view.setPadding(view.getPaddingLeft(), insets.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
        this$0.changeAppBarHeight(view, insets.getSystemWindowInsetTop());
        return insets;
    }

    private final void handleNavigation(String serviceId) throws Resources.NotFoundException {
        BaseSubscription baseSubscription;
        Service service;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Plan plan;
        ServiceAppearance appearance;
        ServiceAppearance appearance2;
        ServiceAppearance appearance3;
        ServiceAppearance appearance4;
        ServiceAppearance appearance5;
        SubscriptionAppearance appearance6;
        Badge badge;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        SubscriptionDetails subscriptionDetails2;
        List<Plan> plans2;
        Plan plan2;
        Plan.Promo promo;
        SubscriptionAppearance appearance7;
        DetailedLayout detailedLayout;
        IncludedServices includedServices;
        List<Service> services;
        Object next;
        Object next2;
        if (serviceId == null || this.isAlreadyNavigatedToService) {
            return;
        }
        this.isAlreadyNavigatedToService = true;
        List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
        ServiceAppearance.ServiceBadges badge2 = null;
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                } else {
                    next2 = it.next();
                    if (Intrinsics.areEqual(((BaseSubscription) next2).getIdentifier(), getProductId())) {
                        break;
                    }
                }
            }
            baseSubscription = (BaseSubscription) next2;
        } else {
            baseSubscription = null;
        }
        if (baseSubscription == null || (appearance7 = baseSubscription.getAppearance()) == null || (detailedLayout = appearance7.getDetailedLayout()) == null || (includedServices = detailedLayout.getIncludedServices()) == null || (services = includedServices.getServices()) == null) {
            service = null;
        } else {
            Iterator<T> it2 = services.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), serviceId)) {
                        break;
                    }
                }
            }
            service = (Service) next;
        }
        if ((baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.first((List) plans2)) == null || (promo = plan2.getPromo()) == null || promo.getDiscountPrice() == null) && baseSubscription != null && (subscriptionDetails = baseSubscription.getSubscriptionDetails()) != null && (plans = subscriptionDetails.getPlans()) != null && (plan = (Plan) CollectionsKt.first((List) plans)) != null) {
            plan.getPrice();
        }
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String strValueOf = String.valueOf((data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
        LogUtilsKt.writeLog("GGGG: serviceId=" + serviceId + " | subId=" + getProductId() + " | serviceFound=" + (service != null) + " | subFound=" + (baseSubscription != null));
        Context contextRequireContext = requireContext();
        String color = (baseSubscription == null || (appearance6 = baseSubscription.getAppearance()) == null || (badge = appearance6.getBadge()) == null) ? null : badge.getColor();
        boolean zAreEqual = Intrinsics.areEqual(color, "blue");
        int i = R.color.sputnik_blue;
        if (!zAreEqual && Intrinsics.areEqual(color, "green")) {
            i = R.color.sputnik_green;
        }
        int color2 = ContextCompat.getColor(contextRequireContext, i);
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        Pair pair = TuplesKt.to("header", (service == null || (appearance5 = service.getAppearance()) == null) ? null : appearance5.getTitle());
        Pair pair2 = TuplesKt.to("title_1", (service == null || (appearance4 = service.getAppearance()) == null) ? null : appearance4.getIntroduction());
        Pair pair3 = TuplesKt.to("title_2", (service == null || (appearance3 = service.getAppearance()) == null) ? null : appearance3.getFullDescription());
        Pair pair4 = TuplesKt.to("title_3", (service == null || (appearance2 = service.getAppearance()) == null) ? null : appearance2.getResume());
        Pair pair5 = TuplesKt.to("button_text", strValueOf);
        Pair pair6 = TuplesKt.to(RemoteMessageConst.Notification.COLOR, Integer.valueOf(color2));
        Pair pair7 = TuplesKt.to("curService", serviceId);
        Pair pair8 = TuplesKt.to("sub_id", getProductId());
        if (service != null && (appearance = service.getAppearance()) != null) {
            badge2 = appearance.getBadge();
        }
        NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.fragmentSubscriptionDetails, R.id.action_fragmentSubscriptionDetails_to_bottomSheetAboutService, BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, TuplesKt.to("service_type", String.valueOf(badge2))), null, 8, null);
    }

    @Override // com.sputnik.common.base.BaseFragment
    public void onNeedCustomNavigate(NavigationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle bundle = action.getBundle();
        String string = bundle != null ? bundle.getString("curService") : null;
        if (string != null) {
            this._serviceId = string;
        }
        handlePaymentPromo();
        getNavigationViewModel().removeAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePaymentPromo() {
        if (this._needShowPayment) {
            this._needShowPayment = false;
            Profile profile = getProfileViewModel().getCurrentState().getProfile();
            if ((profile != null ? profile.getPaymentMethod() : null) == null) {
                startBuySubscription();
            }
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._needShowPayment = getNeedShowPayment();
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.1
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
        if (getSubscriptionsViewModel().getCurrentState().getMarketState() == Resource.Status.NONE) {
            getSubscriptionsViewModel().getSubscriptions();
        }
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.3
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
                SubscriptionDetailsFragment subscriptionDetailsFragment = SubscriptionDetailsFragment.this;
                ConstraintLayout root = subscriptionDetailsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(subscriptionDetailsFragment, root, it);
            }
        });
        SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeState(viewLifecycleOwner4, new Function1<SubscriptionViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionViewState subscriptionViewState) {
                invoke2(subscriptionViewState);
                return Unit.INSTANCE;
            }
        });
        SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionViewModel2.observeSubState(viewLifecycleOwner5, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass6(this));
        SubscriptionsViewModel subscriptionsViewModel3 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        subscriptionsViewModel3.observeSubState(viewLifecycleOwner6, new Function1<SubscriptionsViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedToBuySubscription());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.8
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
                    SubscriptionDetailsFragment.this.startBuySubscription();
                    SubscriptionDetailsFragment.this.getSubscriptionsViewModel().clearNeedToBuySubscription();
                }
            }
        });
        SubscriptionViewModel subscriptionViewModel3 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        subscriptionViewModel3.observeSubState(viewLifecycleOwner7, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isPayed();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.10
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
                SubscriptionDetailsFragment subscriptionDetailsFragment = SubscriptionDetailsFragment.this;
                if (it.peekContent().booleanValue()) {
                    String str = subscriptionDetailsFragment.subId;
                    if (Intrinsics.areEqual(str, Subscriptions.standard.toString())) {
                        subscriptionDetailsFragment.getAnalytics().trackLogEvent(new SubscriptionsEvents.SuccessStandardPurchase());
                        Integer subscriptionPrice = subscriptionDetailsFragment.getSubscriptionPrice();
                        if (subscriptionPrice != null) {
                            subscriptionDetailsFragment.getAnalytics().trackNewEvent(new NewSubscriptionsEvents.StateSuccessSubscriptionPurchase("yookassa", "standard", String.valueOf(subscriptionPrice.intValue())));
                        }
                    } else if (Intrinsics.areEqual(str, Subscriptions.premium.toString())) {
                        subscriptionDetailsFragment.getAnalytics().trackLogEvent(new SubscriptionsEvents.SuccessPremiumPurchase());
                    }
                    LinearLayout serviceLoader = subscriptionDetailsFragment.getBinding().serviceLoader;
                    Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
                    ViewKt.gone(serviceLoader);
                    it.getContentIfNotHandled();
                    try {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SubscriptionDetailsFragment$onViewCreated$10$1$2$1$1(subscriptionDetailsFragment, null), 3, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    NavController navControllerFindNavController = FragmentKt.findNavController(subscriptionDetailsFragment);
                    IntentProcessingUtilsKt.handleDeeplink(subscriptionDetailsFragment.getString(R.string.deeplink_profile), BundleKt.bundleOf(), subscriptionDetailsFragment.requireActivity(), subscriptionDetailsFragment.getNavigationViewModel(), subscriptionDetailsFragment.getProfileViewModel(), (64 & 32) != 0 ? null : subscriptionDetailsFragment.getAnalytics(), (64 & 64) != 0 ? null : null);
                    NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_bottomSheetSuccessPayment, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.Notification.COLOR, subscriptionDetailsFragment.primaryColor), new Pair("is_migration_from_other_subscription", Boolean.valueOf(subscriptionDetailsFragment.getSubscriptionsViewModel().getCurrentState().getActiveSubscription() != null))), null, 8, null);
                    subscriptionDetailsFragment.getSubscriptionsViewModel().getSubscriptions();
                    IProfileViewModel.DefaultImpls.loadProfile$default(subscriptionDetailsFragment.getProfileViewModel(), false, 1, null);
                    return;
                }
                LinearLayout serviceLoader2 = subscriptionDetailsFragment.getBinding().serviceLoader;
                Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
                ViewKt.gone(serviceLoader2);
            }
        });
        SubscriptionViewModel subscriptionViewModel4 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        subscriptionViewModel4.observeNotifications(viewLifecycleOwner8, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment.onViewCreated.11
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
                SubscriptionDetailsFragment subscriptionDetailsFragment = SubscriptionDetailsFragment.this;
                ConstraintLayout root = subscriptionDetailsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(subscriptionDetailsFragment, root, it);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass12(null), 3, null);
    }

    /* compiled from: SubscriptionDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, SubscriptionDetailsFragment.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) throws Resources.NotFoundException {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SubscriptionDetailsFragment) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    /* compiled from: SubscriptionDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, SubscriptionDetailsFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SubscriptionDetailsFragment) this.receiver).render3ds(p0);
        }
    }

    /* compiled from: SubscriptionDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$12", f = "SubscriptionDetailsFragment.kt", l = {351}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$12, reason: invalid class name */
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass12(Continuation<? super AnonymousClass12> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionDetailsFragment.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SubscriptionDetailsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$12$1", f = "SubscriptionDetailsFragment.kt", l = {352}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$onViewCreated$12$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SubscriptionDetailsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SubscriptionDetailsFragment subscriptionDetailsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionDetailsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.handlePaymentPromo();
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SubscriptionDetailsFragment subscriptionDetailsFragment = SubscriptionDetailsFragment.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(subscriptionDetailsFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(subscriptionDetailsFragment, state, anonymousClass1, this) == coroutine_suspended) {
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
    public final Integer getSubscriptionPrice() {
        BaseSubscription baseSubscription;
        Plan.Promo promo;
        Integer discountPrice;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Object next;
        List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubscriptionDetails subscriptionDetails2 = ((BaseSubscription) next).getSubscriptionDetails();
                if (Intrinsics.areEqual(subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null, getProductId())) {
                    break;
                }
            }
            baseSubscription = (BaseSubscription) next;
        } else {
            baseSubscription = null;
        }
        Plan plan = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
        if (plan != null && (promo = plan.getPromo()) != null && (discountPrice = promo.getDiscountPrice()) != null) {
            return discountPrice;
        }
        if (plan != null) {
            return plan.getPrice();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBuySubscription() {
        BaseSubscription baseSubscription;
        int iIntValue;
        SubscriptionAppearance appearance;
        Plan.Promo promo;
        Integer discountPrice;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Object next;
        List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubscriptionDetails subscriptionDetails2 = ((BaseSubscription) next).getSubscriptionDetails();
                if (Intrinsics.areEqual(subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null, getProductId())) {
                    break;
                }
            }
            baseSubscription = (BaseSubscription) next;
        } else {
            baseSubscription = null;
        }
        Plan plan = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        if ((profile != null ? profile.getPaymentMethod() : null) == null) {
            Log.e("sub|plan", baseSubscription + "\n|" + plan);
            try {
                SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
                if (plan == null || (promo = plan.getPromo()) == null || (discountPrice = promo.getDiscountPrice()) == null) {
                    Integer price = plan != null ? plan.getPrice() : null;
                    Intrinsics.checkNotNull(price);
                    iIntValue = price.intValue();
                } else {
                    iIntValue = discountPrice.intValue();
                }
                if (baseSubscription != null && (appearance = baseSubscription.getAppearance()) != null) {
                    title = appearance.getTitle();
                }
                subscriptionViewModel.handleSubscribe(iIntValue, String.valueOf(title), new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$startBuySubscription$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                        invoke2(intent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Intent it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        this.this$0.startGetPaymentTokenResult.launch(it2);
                    }
                });
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Log.e("sub2|plan2", baseSubscription + "\n|" + plan);
        if (baseSubscription != null) {
            SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
            SubscriptionDetails subscriptionDetails3 = baseSubscription.getSubscriptionDetails();
            ISubscriptionViewModel.DefaultImpls.subscribe$default(subscriptionViewModel2, String.valueOf(subscriptionDetails3 != null ? subscriptionDetails3.getProductId() : null), String.valueOf(plan != null ? plan.getIdentifier() : null), null, null, 12, null);
        }
        LinearLayout serviceLoader = getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
        ViewKt.visible(serviceLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render3ds(Event<Boolean> data) {
        Boolean contentIfNotHandled = data.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        String url3ds = getSubscriptionViewModel().getCurrentState().getUrl3ds();
        Intrinsics.checkNotNull(url3ds);
        ActivityResultLauncher<Intent> activityResultLauncher = this.start3dsPaymentTokenResult;
        SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        activityResultLauncher.launch(subscriptionViewModel.getConfirmationIntent(contextRequireContext, url3ds));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionsUi(SubscriptionsViewState subscriptionsViewState) throws Resources.NotFoundException {
        List listPlus;
        Object next;
        DetailedLayout detailedLayout;
        Integer price;
        List<Plan> plans;
        Plan plan;
        String str;
        int i;
        int i2;
        String str2;
        Context context;
        int i3;
        int i4;
        int i5;
        boolean z;
        List<Plan> plans2;
        Plan plan2;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        NoticeBody notice;
        NoticeBody notice2;
        SubscriptionBuyLocale subscriptionBuy2;
        SubscriptionBuyBody body2;
        SubscriptionLicense license;
        SubscriptionBuyLocale subscriptionBuy3;
        SubscriptionBuyBody body3;
        SubscriptionLicense license2;
        SubscriptionBuyLocale subscriptionBuy4;
        SubscriptionBuyBody body4;
        TextTitle buyButton2;
        List<Plan> plans3;
        Plan plan3;
        List<Plan> plans4;
        Plan plan4;
        Plan.Promo promo;
        List<String> list;
        List<String> title;
        List<String> title2;
        List<Service> services;
        SubscriptionBuyLocale subscriptionBuy5;
        SubscriptionBuyBody body5;
        TextTitle buyButton3;
        List<Plan> plans5;
        Plan plan5;
        Plan.Promo promo2;
        List<String> title3;
        List<String> title4;
        Badge badge;
        SubscriptionBuyLocale subscriptionBuy6;
        TextTitle navigation;
        Badge badge2;
        SubscriptionDetails subscriptionDetails;
        SubscriptionDetails subscriptionDetails2;
        int i6 = 1;
        FragmentSubscriptionDetailsBinding binding = getBinding();
        if (subscriptionsViewState.getMarketState() == Resource.Status.SUCCESS) {
            String str3 = this._serviceId;
            if (str3 == null) {
                String serviceId = getServiceId();
                if (serviceId != null) {
                    handleNavigation(serviceId);
                    Unit unit = Unit.INSTANCE;
                }
            } else if (str3 != null) {
                handleNavigation(str3);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        LinearLayout mainLoader = getBinding().mainLoader;
        Intrinsics.checkNotNullExpressionValue(mainLoader, "mainLoader");
        int i7 = 0;
        ViewBindingUtilsKt.visibilityBasedOn(mainLoader, Boolean.valueOf(subscriptionsViewState.getMarketState() == Resource.Status.LOADING));
        List<BaseSubscription> subscriptions = subscriptionsViewState.getSubscriptions();
        if (subscriptions == null || (listPlus = CollectionsKt.plus((Collection<? extends BaseSubscription>) subscriptions, subscriptionsViewState.getActiveSubscription())) == null) {
            return;
        }
        Iterator it = listPlus.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BaseSubscription baseSubscription = (BaseSubscription) next;
            if (Intrinsics.areEqual((baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null) ? null : subscriptionDetails2.getProductId(), getProductId())) {
                break;
            }
            if (Intrinsics.areEqual((baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null) ? null : subscriptionDetails.getProductId(), getProductId())) {
                break;
            }
        }
        final BaseSubscription baseSubscription2 = (BaseSubscription) next;
        if (baseSubscription2 != null) {
            SubscriptionDetails subscriptionDetails3 = baseSubscription2.getSubscriptionDetails();
            this.subId = String.valueOf(subscriptionDetails3 != null ? subscriptionDetails3.getProductId() : null);
            SubscriptionAppearance appearance = baseSubscription2.getAppearance();
            if (appearance == null || (detailedLayout = appearance.getDetailedLayout()) == null) {
                return;
            }
            Context contextRequireContext = requireContext();
            String str4 = "requireContext(...)";
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            SubscriptionAppearance appearance2 = baseSubscription2.getAppearance();
            String color = (appearance2 == null || (badge2 = appearance2.getBadge()) == null) ? null : badge2.getColor();
            boolean zAreEqual = Intrinsics.areEqual(color, "blue");
            int i8 = R.color.sputnik_blue;
            if (!zAreEqual && Intrinsics.areEqual(color, "green")) {
                i8 = R.color.sputnik_green;
            }
            int color2 = ContextCompat.getColor(contextRequireContext, i8);
            this.primaryColor = Integer.valueOf(color2);
            TextView textView = binding.toolbarTitle;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            String strValueOf = String.valueOf((data == null || (subscriptionBuy6 = data.getSubscriptionBuy()) == null || (navigation = subscriptionBuy6.getNavigation()) == null) ? null : navigation.getTitle());
            SubscriptionAppearance appearance3 = baseSubscription2.getAppearance();
            textView.setText(Util.format(strValueOf, String.valueOf((appearance3 == null || (badge = appearance3.getBadge()) == null) ? null : badge.getTitle())));
            binding.appBar.setBackgroundColor(color2);
            TextView tvTitle1 = binding.layout.tvTitle1;
            Intrinsics.checkNotNullExpressionValue(tvTitle1, "tvTitle1");
            Header header = detailedLayout.getHeader();
            String strValueOf2 = String.valueOf((header == null || (title4 = header.getTitle()) == null) ? null : CollectionsKt.joinToString$default(title4, "\n", null, null, 0, null, null, 62, null));
            Header header2 = detailedLayout.getHeader();
            ViewUtilsKt.highlightText(tvTitle1, strValueOf2, new HighlightedText(String.valueOf((header2 == null || (title3 = header2.getTitle()) == null) ? null : (String) CollectionsKt.firstOrNull((List) title3)), color2, null, null, 0, 0, 60, null));
            SubscriptionDetails subscriptionDetails4 = baseSubscription2.getSubscriptionDetails();
            if (subscriptionDetails4 == null || (plans5 = subscriptionDetails4.getPlans()) == null || (plan5 = (Plan) CollectionsKt.first((List) plans5)) == null || (promo2 = plan5.getPromo()) == null || (price = promo2.getDiscountPrice()) == null) {
                SubscriptionDetails subscriptionDetails5 = baseSubscription2.getSubscriptionDetails();
                price = (subscriptionDetails5 == null || (plans = subscriptionDetails5.getPlans()) == null || (plan = (Plan) CollectionsKt.first((List) plans)) == null) ? null : plan.getPrice();
            }
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            String strValueOf3 = String.valueOf((data2 == null || (subscriptionBuy5 = data2.getSubscriptionBuy()) == null || (body5 = subscriptionBuy5.getBody()) == null || (buyButton3 = body5.getBuyButton()) == null) ? null : buyButton3.getTitle());
            SubscriptionAppearance appearance4 = baseSubscription2.getAppearance();
            String priceText = appearance4 != null ? appearance4.getPriceText() : null;
            StringBuilder sb = new StringBuilder();
            sb.append(price);
            String str5 = " ";
            sb.append(" ");
            sb.append(priceText);
            final String str6 = Util.format(strValueOf3, sb.toString());
            int iApplyDimension = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
            binding.layout.layoutFeatures.removeAllViews();
            IncludedServices includedServices = detailedLayout.getIncludedServices();
            int i9 = -2;
            int i10 = -1;
            if (includedServices == null || (services = includedServices.getServices()) == null) {
                str = " ";
                i = iApplyDimension;
                i2 = color2;
                str2 = "requireContext(...)";
                context = contextRequireContext;
                i3 = -1;
                i4 = -2;
            } else {
                int i11 = 0;
                for (Object obj : services) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final Service service = (Service) obj;
                    LinearLayout linearLayout = binding.layout.layoutFeatures;
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, str4);
                    final FeatureCardView featureCardView = new FeatureCardView(contextRequireContext2, null, 0, 6, null);
                    if (i11 != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i9);
                        layoutParams.setMargins(i7, iApplyDimension, i7, i7);
                        featureCardView.setLayoutParams(layoutParams);
                    }
                    ServiceAppearance appearance5 = service.getAppearance();
                    featureCardView.setTitle(String.valueOf(appearance5 != null ? appearance5.getTitle() : null));
                    ServiceAppearance appearance6 = service.getAppearance();
                    featureCardView.setSubtitle(String.valueOf(appearance6 != null ? appearance6.getDescription() : null));
                    ServiceAppearance appearance7 = service.getAppearance();
                    ServiceAppearance.ServiceBadges badge3 = appearance7 != null ? appearance7.getBadge() : null;
                    int i13 = badge3 == null ? i10 : WhenMappings.$EnumSwitchMapping$0[badge3.ordinal()];
                    if (i13 == i6) {
                        featureCardView.setSpecialIcon(R.drawable.ic_new_market);
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        if (i13 == 2) {
                            featureCardView.setSpecialIcon(R.drawable.ic_beta_market);
                        }
                        Unit unit4 = Unit.INSTANCE;
                    }
                    featureCardView.setColor(color2);
                    final int i14 = color2;
                    SafeClickListenerKt.setSafeOnClickListener$default(featureCardView, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$renderSubscriptionsUi$1$4$1$1$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(View it2) throws Resources.NotFoundException {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            NavController navControllerFindNavController = androidx.navigation.ViewKt.findNavController(featureCardView);
                            ServiceAppearance appearance8 = service.getAppearance();
                            Pair pair = TuplesKt.to("header", appearance8 != null ? appearance8.getTitle() : null);
                            ServiceAppearance appearance9 = service.getAppearance();
                            Pair pair2 = TuplesKt.to("title_1", appearance9 != null ? appearance9.getIntroduction() : null);
                            ServiceAppearance appearance10 = service.getAppearance();
                            Pair pair3 = TuplesKt.to("title_2", appearance10 != null ? appearance10.getFullDescription() : null);
                            ServiceAppearance appearance11 = service.getAppearance();
                            Pair pair4 = TuplesKt.to("title_3", appearance11 != null ? appearance11.getResume() : null);
                            Pair pair5 = TuplesKt.to("button_text", str6);
                            Pair pair6 = TuplesKt.to(RemoteMessageConst.Notification.COLOR, Integer.valueOf(i14));
                            Pair pair7 = TuplesKt.to("curService", service.getServiceConfigIdentifier());
                            SubscriptionDetails subscriptionDetails6 = baseSubscription2.getSubscriptionDetails();
                            Pair pair8 = TuplesKt.to("sub_id", subscriptionDetails6 != null ? subscriptionDetails6.getProductId() : null);
                            ServiceAppearance appearance12 = service.getAppearance();
                            NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.fragmentSubscriptionDetails, R.id.action_fragmentSubscriptionDetails_to_bottomSheetAboutService, BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, TuplesKt.to("service_type", String.valueOf(appearance12 != null ? appearance12.getBadge() : null))), null, 8, null);
                        }
                    }, 1, null);
                    featureCardView.setButtonInfoListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) throws Resources.NotFoundException {
                            SubscriptionDetailsFragment.renderSubscriptionsUi$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27$lambda$22$lambda$21$lambda$20(this.f$0, service, featureCardView, str6, i14, baseSubscription2, view);
                        }
                    });
                    linearLayout.addView(featureCardView);
                    str4 = str4;
                    str5 = str5;
                    i9 = i9;
                    color2 = i14;
                    i11 = i12;
                    iApplyDimension = iApplyDimension;
                    contextRequireContext = contextRequireContext;
                    i6 = 1;
                    i7 = 0;
                    i10 = i10;
                }
                str = str5;
                i = iApplyDimension;
                i2 = color2;
                str2 = str4;
                context = contextRequireContext;
                i3 = i10;
                i4 = i9;
                Unit unit5 = Unit.INSTANCE;
            }
            TextView tvTitleSub = binding.layout.tvTitleSub;
            Intrinsics.checkNotNullExpressionValue(tvTitleSub, "tvTitleSub");
            Features features = detailedLayout.getFeatures();
            String strValueOf4 = String.valueOf((features == null || (title2 = features.getTitle()) == null) ? null : CollectionsKt.joinToString$default(title2, " ", null, null, 0, null, null, 62, null));
            Features features2 = detailedLayout.getFeatures();
            ViewUtilsKt.highlightText(tvTitleSub, strValueOf4, new HighlightedText(String.valueOf((features2 == null || (title = features2.getTitle()) == null) ? null : (String) CollectionsKt.firstOrNull((List) title)), i2, null, null, 0, 0, 60, null));
            binding.layout.layoutFeaturesSecond.removeAllViews();
            Features features3 = detailedLayout.getFeatures();
            if (features3 == null || (list = features3.getList()) == null) {
                i5 = i2;
                z = false;
            } else {
                for (String str7 : list) {
                    LinearLayout linearLayout2 = binding.layout.layoutFeaturesSecond;
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, str2);
                    TextViewWithImage textViewWithImage = new TextViewWithImage(contextRequireContext3, null, 0, 6, null);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i4);
                    layoutParams2.setMargins(0, i, 0, 0);
                    textViewWithImage.setLayoutParams(layoutParams2);
                    textViewWithImage.setTitle(str7);
                    textViewWithImage.setImageColor(i2);
                    linearLayout2.addView(textViewWithImage);
                }
                i5 = i2;
                z = false;
                Unit unit6 = Unit.INSTANCE;
            }
            AppCompatButton appCompatButton = binding.btnSubscribe;
            SubscriptionDetails subscriptionDetails6 = baseSubscription2.getSubscriptionDetails();
            Integer discountPrice = (subscriptionDetails6 == null || (plans4 = subscriptionDetails6.getPlans()) == null || (plan4 = (Plan) CollectionsKt.firstOrNull((List) plans4)) == null || (promo = plan4.getPromo()) == null) ? null : promo.getDiscountPrice();
            SubscriptionDetails subscriptionDetails7 = baseSubscription2.getSubscriptionDetails();
            Integer price2 = (subscriptionDetails7 == null || (plans3 = subscriptionDetails7.getPlans()) == null || (plan3 = (Plan) CollectionsKt.firstOrNull((List) plans3)) == null) ? null : plan3.getPrice();
            if (discountPrice != null) {
                LocalizationLocalModel data3 = getLocalizationScreen().getData();
                String strValueOf5 = String.valueOf((data3 == null || (subscriptionBuy4 = data3.getSubscriptionBuy()) == null || (body4 = subscriptionBuy4.getBody()) == null || (buyButton2 = body4.getBuyButton()) == null) ? null : buyButton2.getTitle());
                String strOrEmpty = price2 != null ? StringUtilsKt.orEmpty(price2) : null;
                String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
                SubscriptionAppearance appearance8 = baseSubscription2.getAppearance();
                String safe = StringUtilsKt.formatSafe(strValueOf5, strOrEmpty + str + strOrEmpty2 + str + (appearance8 != null ? appearance8.getPriceText() : null));
                Intrinsics.checkNotNull(appCompatButton);
                ViewUtilsKt.strikeThrouth(appCompatButton, safe, String.valueOf(price2), Integer.valueOf(ContextCompat.getColor(context, R.color.track_gray)));
            } else {
                LocalizationLocalModel data4 = getLocalizationScreen().getData();
                String strValueOf6 = String.valueOf((data4 == null || (subscriptionBuy = data4.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
                SubscriptionDetails subscriptionDetails8 = baseSubscription2.getSubscriptionDetails();
                String strOrEmpty3 = StringUtilsKt.orEmpty((subscriptionDetails8 == null || (plans2 = subscriptionDetails8.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null) ? null : plan2.getPrice());
                SubscriptionAppearance appearance9 = baseSubscription2.getAppearance();
                appCompatButton.setText(StringUtilsKt.formatSafe(strValueOf6, strOrEmpty3 + str + (appearance9 != null ? appearance9.getPriceText() : null)));
            }
            Unit unit7 = Unit.INSTANCE;
            TextView tvAgreement = binding.layout.tvAgreement;
            Intrinsics.checkNotNullExpressionValue(tvAgreement, "tvAgreement");
            LocalizationLocalModel data5 = getLocalizationScreen().getData();
            String strValueOf7 = String.valueOf((data5 == null || (subscriptionBuy3 = data5.getSubscriptionBuy()) == null || (body3 = subscriptionBuy3.getBody()) == null || (license2 = body3.getLicense()) == null) ? null : license2.getTitle());
            LocalizationLocalModel data6 = getLocalizationScreen().getData();
            ViewUtilsKt.highlightText(tvAgreement, strValueOf7, new HighlightedText(String.valueOf((data6 == null || (subscriptionBuy2 = data6.getSubscriptionBuy()) == null || (body2 = subscriptionBuy2.getBody()) == null || (license = body2.getLicense()) == null) ? null : license.getParam1()), i5, "https://sso.sputnik.systems/mobile_licence.pdf", null, 0, 0, 56, null));
            binding.layout.imageView.setImageTintList(ColorStateList.valueOf(i5));
            ConstraintLayout layoutAttention = binding.layout.layoutAttention;
            Intrinsics.checkNotNullExpressionValue(layoutAttention, "layoutAttention");
            DetailedLayout detailedLayout2 = appearance.getDetailedLayout();
            ViewBindingUtilsKt.visibilityBasedOn(layoutAttention, Boolean.valueOf(((detailedLayout2 == null || (notice2 = detailedLayout2.getNotice()) == null) ? null : notice2.getBody()) != null ? true : z));
            TextView textView2 = binding.layout.tvAttention;
            DetailedLayout detailedLayout3 = appearance.getDetailedLayout();
            textView2.setText(String.valueOf((detailedLayout3 == null || (notice = detailedLayout3.getNotice()) == null) ? null : notice.getBody()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderSubscriptionsUi$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27$lambda$22$lambda$21$lambda$20(SubscriptionDetailsFragment this$0, Service domainIncludedService, FeatureCardView this_apply, String buttonText, int i, BaseSubscription subscription, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(domainIncludedService, "$domainIncludedService");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(buttonText, "$buttonText");
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        String productId = this$0.getProductId();
        if (Intrinsics.areEqual(productId, Subscriptions.premium.toString())) {
            String serviceConfigIdentifier = domainIncludedService.getServiceConfigIdentifier();
            if (Intrinsics.areEqual(serviceConfigIdentifier, Services.archive_7.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetArch7());
            } else if (Intrinsics.areEqual(serviceConfigIdentifier, Services.face_rec.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetFacerec());
            } else if (Intrinsics.areEqual(serviceConfigIdentifier, Services.history.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetCallLog());
            } else if (Intrinsics.areEqual(serviceConfigIdentifier, Services.digital_keys.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetCodes());
            }
        } else if (Intrinsics.areEqual(productId, Subscriptions.standard.toString())) {
            String serviceConfigIdentifier2 = domainIncludedService.getServiceConfigIdentifier();
            if (Intrinsics.areEqual(serviceConfigIdentifier2, Services.digital_keys.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetCodes());
            } else if (Intrinsics.areEqual(serviceConfigIdentifier2, Services.archive_3.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetArch3());
            } else if (Intrinsics.areEqual(serviceConfigIdentifier2, Services.history.toString())) {
                this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetCallLog());
            }
        }
        NavController navControllerFindNavController = androidx.navigation.ViewKt.findNavController(this_apply);
        ServiceAppearance appearance = domainIncludedService.getAppearance();
        Pair pair = TuplesKt.to("header", appearance != null ? appearance.getTitle() : null);
        ServiceAppearance appearance2 = domainIncludedService.getAppearance();
        Pair pair2 = TuplesKt.to("title_1", appearance2 != null ? appearance2.getIntroduction() : null);
        ServiceAppearance appearance3 = domainIncludedService.getAppearance();
        Pair pair3 = TuplesKt.to("title_2", appearance3 != null ? appearance3.getFullDescription() : null);
        ServiceAppearance appearance4 = domainIncludedService.getAppearance();
        Pair pair4 = TuplesKt.to("title_3", appearance4 != null ? appearance4.getResume() : null);
        Pair pair5 = TuplesKt.to("button_text", buttonText);
        Pair pair6 = TuplesKt.to(RemoteMessageConst.Notification.COLOR, Integer.valueOf(i));
        Pair pair7 = TuplesKt.to("curService", domainIncludedService.getServiceConfigIdentifier());
        SubscriptionDetails subscriptionDetails = subscription.getSubscriptionDetails();
        Pair pair8 = TuplesKt.to("sub_id", subscriptionDetails != null ? subscriptionDetails.getProductId() : null);
        ServiceAppearance appearance5 = domainIncludedService.getAppearance();
        NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.fragmentSubscriptionDetails, R.id.action_fragmentSubscriptionDetails_to_bottomSheetAboutService, BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, TuplesKt.to("service_type", String.valueOf(appearance5 != null ? appearance5.getBadge() : null))), null, 8, null);
    }

    private final void changeAppBarHeight(View view, int insetTop) {
        TypedValue typedValue = new TypedValue();
        if (requireActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            view.getLayoutParams().height = insetTop + TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        } else {
            view.getLayoutParams().height = insetTop + 140;
        }
    }
}
