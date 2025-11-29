package sputnik.axmor.com.sputnik.ui.main.market.subscription;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.github.razir.progressbutton.ProgressButtonHolderKt;
import com.github.razir.progressbutton.ProgressParams;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyErrors;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.SubscriptionLicense;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.market.SmallServices;
import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.MarketTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SubscriptionActivityBinding;
import sputnik.axmor.com.databinding.SubscriptionScrollingLayoutBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.FeaturesAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.ServicesAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.TariffsAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewState;
import sputnik.axmor.com.sputnik.viewmodels.ISubscriptionViewModel;

/* compiled from: SubscriptionFragment.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0003R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010L\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010J0J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010N\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010J0J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010M¨\u0006O"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/SubscriptionFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/market/market/Market;", RemoteMessageConst.DATA, "", "renderUi", "(Ljava/util/List;)V", "Lcom/sputnik/domain/common/Event;", "", "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/view/View;", "view", "", "insetTop", "changeAppBarHeight", "(Landroid/view/View;I)V", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "plan", "initButton", "(Lcom/sputnik/common/entities/market/market/SubsPlans;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/SubscriptionActivityBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/SubscriptionActivityBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "lastText", "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "start3dsPaymentTokenResult", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SubscriptionFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/SubscriptionActivityBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    private String lastText;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionActivityBinding getBinding() {
        return (SubscriptionActivityBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionViewModel getSubscriptionViewModel() {
        return (SubscriptionViewModel) this.subscriptionViewModel.getValue();
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
    public static final void startGetPaymentTokenResult$lambda$4(SubscriptionFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Object next;
        List<SubsPlans> plans;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            Iterator<T> it = this$0.getMarketViewModel().getCurrentState().getMarket().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Market) next).getType() == MarketTypes.subscription) {
                        break;
                    }
                }
            }
            Market market = (Market) next;
            SubsPlans subsPlans = (market == null || (plans = market.getPlans()) == null) ? null : plans.get(this$0.getSubscriptionViewModel().getCurrentState().getTariffIndex());
            if (subsPlans != null) {
                SubscriptionViewModel subscriptionViewModel = this$0.getSubscriptionViewModel();
                String subscriptionProductId = market != null ? market.getSubscriptionProductId() : null;
                Intrinsics.checkNotNull(subscriptionProductId);
                String identifier = subsPlans.getIdentifier();
                Intrinsics.checkNotNull(identifier);
                Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
                ISubscriptionViewModel.DefaultImpls.subscribe$default(subscriptionViewModel, subscriptionProductId, identifier, tokenizationResultCreateTokenizationResult.getPaymentToken(), null, 8, null);
                return;
            }
            return;
        }
        LocalizationLocalModel data2 = this$0.getLocalizationScreen().getData();
        if (data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getSubscriptionViewModel().notifyErrorMessage(operationFailure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$7(SubscriptionFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            Iterator<T> it = this$0.getMarketViewModel().getCurrentState().getMarket().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Market) next).getType() == MarketTypes.subscription) {
                        break;
                    }
                }
            }
            Market market = (Market) next;
            SubscriptionViewModel subscriptionViewModel = this$0.getSubscriptionViewModel();
            String subscriptionProductId = market != null ? market.getSubscriptionProductId() : null;
            Intrinsics.checkNotNull(subscriptionProductId);
            subscriptionViewModel.getCurrentState(subscriptionProductId);
            return;
        }
        LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
        if (data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getSubscriptionViewModel().notifyErrorMessage(operationFailure);
    }

    public SubscriptionFragment() {
        super(R.layout.subscription_activity);
        this.binding = new ViewBindingFragmentDelegate(this, SubscriptionFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$special$$inlined$viewModels$default$4
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
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SubscriptionFragment.startGetPaymentTokenResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SubscriptionFragment.start3dsPaymentTokenResult$lambda$7(this.f$0, (ActivityResult) obj);
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

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.1
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
        SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeState(viewLifecycleOwner2, new Function1<SubscriptionViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.2
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
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner3, new Function1<MarketViewState, List<? extends Market>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final List<Market> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getMarket();
            }
        }, new AnonymousClass4(this));
        SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        subscriptionViewModel2.observeSubState(viewLifecycleOwner4, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass6(this));
        SubscriptionViewModel subscriptionViewModel3 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionViewModel3.observeSubState(viewLifecycleOwner5, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isPayed();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.8
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
                    final SubscriptionFragment subscriptionFragment = SubscriptionFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        subscriptionFragment.getMarketViewModel().loadSubscriptions();
                        MarketViewModel marketViewModel2 = subscriptionFragment.getMarketViewModel();
                        LifecycleOwner viewLifecycleOwner6 = subscriptionFragment.getViewLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
                        marketViewModel2.observeSubState(viewLifecycleOwner6, new Function1<MarketViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$onViewCreated$8$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Resource.Status invoke(MarketViewState it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return it2.getSubscriptionState();
                            }
                        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$onViewCreated$8$1$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) throws Resources.NotFoundException {
                                invoke2(status);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Resource.Status it2) throws Resources.NotFoundException {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                if (it2 == Resource.Status.SUCCESS) {
                                    LinearLayout serviceLoader = subscriptionFragment.getBinding().serviceLoader;
                                    Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
                                    ViewKt.gone(serviceLoader);
                                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(subscriptionFragment), R.id.subscriptionFragment, R.id.action_subscriptionFragment_to_mainHostFragment, BundleKt.bundleOf(TuplesKt.to("newSubscription", Boolean.TRUE)), null, 8, null);
                                }
                            }
                        });
                    }
                }
            }
        });
        SubscriptionViewModel subscriptionViewModel4 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        subscriptionViewModel4.observeNotifications(viewLifecycleOwner6, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.onViewCreated.9
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
                SubscriptionFragment subscriptionFragment = SubscriptionFragment.this;
                FrameLayout root = subscriptionFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(subscriptionFragment, root, it);
                AppCompatButton btnSubscribe = SubscriptionFragment.this.getBinding().btnSubscribe;
                Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
                DrawableButtonExtensionsKt.hideProgress(btnSubscribe, SubscriptionFragment.this.lastText);
            }
        });
    }

    /* compiled from: SubscriptionFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<List<? extends Market>, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, SubscriptionFragment.class, "renderUi", "renderUi(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Market> list) {
            invoke2((List<Market>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Market> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SubscriptionFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: SubscriptionFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, SubscriptionFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SubscriptionFragment) this.receiver).render3ds(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderUi(List<Market> data) {
        Object next;
        ArrayList arrayList;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        String title;
        SubsPlans subsPlans;
        Iterator<T> it = data.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((Market) next).getType() == MarketTypes.subscription) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        Market market = (Market) next;
        if (market != null) {
            Toolbar toolbar = getBinding().toolbar;
            Badge badge = market.getBadge();
            toolbar.setTitle(badge != null ? badge.getTitle() : null);
            SubscriptionScrollingLayoutBinding subscriptionScrollingLayoutBinding = getBinding().layout;
            TextView textView = subscriptionScrollingLayoutBinding.tvHeader;
            List<String> titleHeader = market.getTitleHeader();
            textView.setText(titleHeader != null ? CollectionsKt.joinToString$default(titleHeader, "\n", null, null, 0, null, null, 62, null) : null);
            subscriptionScrollingLayoutBinding.tvIncluded.setText(market.getIncludedServiceTitle());
            subscriptionScrollingLayoutBinding.tvTariffs.setText(market.getPlansTitle());
            RecyclerView.Adapter adapter = subscriptionScrollingLayoutBinding.rvFeatures.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.FeaturesAdapter");
            ((FeaturesAdapter) adapter).submitList(market.getFeaturesList());
            RecyclerView.Adapter adapter2 = subscriptionScrollingLayoutBinding.rvServices.getAdapter();
            Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.ServicesAdapter");
            ServicesAdapter servicesAdapter = (ServicesAdapter) adapter2;
            List<SmallServices> includedServices = market.getIncludedServices();
            if (includedServices != null) {
                List<SmallServices> list = includedServices;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (SmallServices smallServices : list) {
                    arrayList.add(new Pair(smallServices.getTitle(), smallServices.getDescription()));
                }
            } else {
                arrayList = null;
            }
            servicesAdapter.submitList(arrayList);
            int tariffIndex = getSubscriptionViewModel().getCurrentState().getTariffIndex();
            RecyclerView.Adapter adapter3 = subscriptionScrollingLayoutBinding.rvTariffs.getAdapter();
            Intrinsics.checkNotNull(adapter3, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.TariffsAdapter");
            TariffsAdapter tariffsAdapter = (TariffsAdapter) adapter3;
            tariffsAdapter.submitList(market.getPlans());
            tariffsAdapter.setCheckedPosition(tariffIndex);
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 != null && (subscriptionBuy = data2.getSubscriptionBuy()) != null && (body = subscriptionBuy.getBody()) != null && (buyButton = body.getBuyButton()) != null && (title = buyButton.getTitle()) != null) {
                AppCompatButton appCompatButton = getBinding().btnSubscribe;
                List<SubsPlans> plans = market.getPlans();
                String priceVerbose = (plans == null || (subsPlans = plans.get(tariffIndex)) == null) ? null : subsPlans.getPriceVerbose();
                Intrinsics.checkNotNull(priceVerbose);
                appCompatButton.setText(Util.format(title, priceVerbose));
            }
            List<SubsPlans> plans2 = market.getPlans();
            final SubsPlans subsPlans2 = plans2 != null ? plans2.get(getSubscriptionViewModel().getCurrentState().getTariffIndex()) : null;
            AppCompatButton btnSubscribe = getBinding().btnSubscribe;
            Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
            SafeClickListenerKt.setSafeOnClickListener$default(btnSubscribe, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$renderUi$1$1$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    SubsPlans subsPlans3 = subsPlans2;
                    if (subsPlans3 != null) {
                        this.initButton(subsPlans3);
                    }
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render3ds(Event<Boolean> data) {
        data.getContentIfNotHandled();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton btnSubscribe = getBinding().btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
        ViewKt.addSystemWindowInsetToMargin$default(btnSubscribe, true, false, true, true, 2, null);
        getBinding().appBar.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return SubscriptionFragment.initViews$lambda$15(this.f$0, view, windowInsets);
            }
        });
        SubscriptionScrollingLayoutBinding subscriptionScrollingLayoutBinding = getBinding().layout;
        RecyclerView recyclerView = subscriptionScrollingLayoutBinding.rvFeatures;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new FeaturesAdapter());
        RecyclerView recyclerView2 = subscriptionScrollingLayoutBinding.rvServices;
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView2.setAdapter(new ServicesAdapter());
        final RecyclerView recyclerView3 = subscriptionScrollingLayoutBinding.rvTariffs;
        recyclerView3.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView3.setAdapter(new TariffsAdapter(new Function1<SubsPlans, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$initViews$2$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubsPlans subsPlans) {
                invoke2(subsPlans);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SubsPlans plan) {
                SubscriptionBuyLocale subscriptionBuy;
                SubscriptionBuyBody body;
                TextTitle buyButton;
                String title;
                Intrinsics.checkNotNullParameter(plan, "plan");
                SubscriptionViewModel subscriptionViewModel = this.this$0.getSubscriptionViewModel();
                RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.TariffsAdapter");
                subscriptionViewModel.handleTariffIndex(((TariffsAdapter) adapter).getCheckedPosition());
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                if (data != null && (subscriptionBuy = data.getSubscriptionBuy()) != null && (body = subscriptionBuy.getBody()) != null && (buyButton = body.getBuyButton()) != null && (title = buyButton.getTitle()) != null) {
                    AppCompatButton appCompatButton = this.this$0.getBinding().btnSubscribe;
                    String priceVerbose = plan.getPriceVerbose();
                    Intrinsics.checkNotNull(priceVerbose);
                    appCompatButton.setText(Util.format(title, priceVerbose));
                }
                AppCompatButton btnSubscribe2 = this.this$0.getBinding().btnSubscribe;
                Intrinsics.checkNotNullExpressionValue(btnSubscribe2, "btnSubscribe");
                final SubscriptionFragment subscriptionFragment = this.this$0;
                SafeClickListenerKt.setSafeOnClickListener$default(btnSubscribe2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment$initViews$2$3$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        subscriptionFragment.initButton(plan);
                    }
                }, 1, null);
            }
        }));
        AppCompatButton btnSubscribe2 = getBinding().btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(btnSubscribe2, "btnSubscribe");
        ProgressButtonHolderKt.bindProgressButton(this, btnSubscribe2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets initViews$lambda$15(SubscriptionFragment this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        view.setPadding(view.getPaddingLeft(), insets.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
        this$0.changeAppBarHeight(view, insets.getSystemWindowInsetTop());
        return insets;
    }

    private final void changeAppBarHeight(View view, int insetTop) {
        TypedValue typedValue = new TypedValue();
        if (requireActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            view.getLayoutParams().height = insetTop + TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        } else {
            view.getLayoutParams().height = insetTop + 140;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initButton(SubsPlans plan) {
        SubsPlans subsPlans;
        Object next;
        List<SubsPlans> plans;
        List<SubsPlans> plans2;
        this.lastText = getBinding().btnSubscribe.getText().toString();
        AppCompatButton btnSubscribe = getBinding().btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
        DrawableButtonExtensionsKt.showProgress(btnSubscribe, new Function1<ProgressParams, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.initButton.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProgressParams progressParams) {
                invoke2(progressParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProgressParams showProgress) {
                Intrinsics.checkNotNullParameter(showProgress, "$this$showProgress");
                showProgress.setProgressColor(Integer.valueOf(ContextCompat.getColor(SubscriptionFragment.this.requireContext(), R.color.sputnik_blue)));
            }
        });
        Iterator<T> it = getMarketViewModel().getCurrentState().getMarket().iterator();
        while (true) {
            subsPlans = null;
            subsPlans = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Market) next).getType() == MarketTypes.subscription) {
                    break;
                }
            }
        }
        Market market = (Market) next;
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        if ((profile != null ? profile.getCardInfo() : null) == null) {
            SubsPlans subsPlans2 = (market == null || (plans2 = market.getPlans()) == null) ? null : plans2.get(getSubscriptionViewModel().getCurrentState().getTariffIndex());
            Log.e("sub|plan", subsPlans2 + "\n|" + plan);
            SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
            Integer price = plan.getPrice();
            Intrinsics.checkNotNull(price);
            int iIntValue = price.intValue();
            String title = subsPlans2 != null ? subsPlans2.getTitle() : null;
            Intrinsics.checkNotNull(title);
            subscriptionViewModel.handleSubscribe(iIntValue, title, new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment.initButton.2
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
                    SubscriptionFragment.this.startGetPaymentTokenResult.launch(it2);
                }
            });
            return;
        }
        if (market != null && (plans = market.getPlans()) != null) {
            subsPlans = plans.get(getSubscriptionViewModel().getCurrentState().getTariffIndex());
        }
        Log.e("sub2|plan2", subsPlans + "\n|" + plan);
        if (subsPlans != null) {
            SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
            String subscriptionProductId = market.getSubscriptionProductId();
            Intrinsics.checkNotNull(subscriptionProductId);
            String identifier = subsPlans.getIdentifier();
            Intrinsics.checkNotNull(identifier);
            ISubscriptionViewModel.DefaultImpls.subscribe$default(subscriptionViewModel2, subscriptionProductId, identifier, null, null, 12, null);
        }
        LinearLayout serviceLoader = getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
        ViewKt.visible(serviceLoader);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        SubscriptionLicense license;
        TextView textView = getBinding().layout.tvAgreement;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (license = body.getLicense()) == null) {
            return;
        }
        String title = license.getTitle();
        Intrinsics.checkNotNull(title);
        String param1 = license.getParam1();
        Intrinsics.checkNotNull(param1);
        SpannableString spannableString = new SpannableString(Util.format(title, param1));
        String param12 = license.getParam1();
        Intrinsics.checkNotNull(param12);
        SpansKt.addLink$default(spannableString, param12, "https://storage.yandexcloud.net/sputnik-systems-citizen-app/mobile_privacy.html", null, 4, null);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
