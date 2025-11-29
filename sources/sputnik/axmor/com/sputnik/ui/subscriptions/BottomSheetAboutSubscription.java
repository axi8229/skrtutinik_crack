package sputnik.axmor.com.sputnik.ui.subscriptions;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.BottomSheetStandardPromo;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyErrors;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.ServiceAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.TextViewWithPoint;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import com.sputnik.subscriptions.databinding.BottomSheetAboutSubscriptionBinding;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewState;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;
import sputnik.axmor.com.sputnik.viewmodels.ISubscriptionViewModel;

/* compiled from: BottomSheetAboutSubscription.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010.\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010.\u001a\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bM\u0010 \u001a\u0004\bN\u0010\"\"\u0004\bO\u0010$R\u001d\u0010T\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010.\u001a\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010]\u001a\u0010\u0012\f\u0012\n \\*\u0004\u0018\u00010[0[0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010_\u001a\u0010\u0012\f\u0012\n \\*\u0004\u0018\u00010[0[0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010^¨\u0006`"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/subscriptions/BottomSheetAboutSubscription;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/subscriptions/databinding/BottomSheetAboutSubscriptionBinding;", "<init>", "()V", "", "startBuySubscription", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "state", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "localizationScreen", "getLocalizationScreen", "setLocalizationScreen", "", "from$delegate", "getFrom", "()Ljava/lang/Integer;", RemoteMessageConst.FROM, "primaryColor", "Ljava/lang/Integer;", "", "productId", "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "start3dsPaymentTokenResult", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetAboutSubscription extends BaseBottomSheetDialogFragment<BottomSheetAboutSubscriptionBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: from$delegate, reason: from kotlin metadata */
    private final Lazy from;
    public LocalizationStorage localizationScreen;
    public LocalizationStorage localizationStorage;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private Integer primaryColor;
    private final String productId;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* compiled from: BottomSheetAboutSubscription.kt */
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

    public static final /* synthetic */ BottomSheetAboutSubscriptionBinding access$getBinding(BottomSheetAboutSubscription bottomSheetAboutSubscription) {
        return bottomSheetAboutSubscription.getBinding();
    }

    /* compiled from: BottomSheetAboutSubscription.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetAboutSubscriptionBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetAboutSubscriptionBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/subscriptions/databinding/BottomSheetAboutSubscriptionBinding;", 0);
        }

        public final BottomSheetAboutSubscriptionBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetAboutSubscriptionBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetAboutSubscriptionBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BottomSheetAboutSubscription() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$viewModels$default$4
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
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.from = LazyKt.lazy(new Function0<Integer>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$from$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (Integer) (arguments != null ? arguments.get(RemoteMessageConst.FROM) : null);
            }
        });
        this.productId = Subscriptions.standard.toString();
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetAboutSubscription.startGetPaymentTokenResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetAboutSubscription.start3dsPaymentTokenResult$lambda$6(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    private final SubscriptionViewModel getSubscriptionViewModel() {
        return (SubscriptionViewModel) this.subscriptionViewModel.getValue();
    }

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getFrom() {
        return (Integer) this.from.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGetPaymentTokenResult$lambda$4(BottomSheetAboutSubscription this$0, ActivityResult result) {
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
                    if (Intrinsics.areEqual(subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null, this$0.productId)) {
                        break;
                    }
                }
                baseSubscription = (BaseSubscription) next;
            } else {
                baseSubscription = null;
            }
            Plan plan = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
            if (baseSubscription != null) {
                SubscriptionViewModel subscriptionViewModel = this$0.getSubscriptionViewModel();
                String string = this$0.productId.toString();
                String identifier = plan != null ? plan.getIdentifier() : null;
                Intrinsics.checkNotNull(identifier);
                Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
                subscriptionViewModel.subscribe(string, identifier, tokenizationResultCreateTokenizationResult.getPaymentToken(), tokenizationResultCreateTokenizationResult.getPaymentMethodType());
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
    public static final void start3dsPaymentTokenResult$lambda$6(BottomSheetAboutSubscription this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            this$0.getSubscriptionViewModel().getCurrentState(this$0.productId);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheet);
    }

    /* compiled from: BottomSheetAboutSubscription.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C27041 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        C27041(Object obj) {
            super(1, obj, BottomSheetAboutSubscription.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetAboutSubscription) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner, new C27041(this));
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.2
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
                View decorView;
                Window window;
                Intrinsics.checkNotNullParameter(it, "it");
                BottomSheetAboutSubscription bottomSheetAboutSubscription = BottomSheetAboutSubscription.this;
                Dialog dialog = bottomSheetAboutSubscription.getDialog();
                if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
                    decorView = BottomSheetAboutSubscription.access$getBinding(BottomSheetAboutSubscription.this).layoutSnackbar;
                }
                Intrinsics.checkNotNull(decorView);
                ViewKt.renderNotifications(bottomSheetAboutSubscription, decorView, it);
            }
        });
        SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeState(viewLifecycleOwner3, new Function1<SubscriptionViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.3
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
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        subscriptionViewModel2.observeSubState(viewLifecycleOwner4, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass5(this));
        SubscriptionViewModel subscriptionViewModel3 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionViewModel3.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.6
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
                View decorView;
                Window window;
                Intrinsics.checkNotNullParameter(it, "it");
                BottomSheetAboutSubscription bottomSheetAboutSubscription = BottomSheetAboutSubscription.this;
                Dialog dialog = bottomSheetAboutSubscription.getDialog();
                if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
                    decorView = BottomSheetAboutSubscription.access$getBinding(BottomSheetAboutSubscription.this).layoutSnackbar;
                }
                Intrinsics.checkNotNull(decorView);
                ViewKt.renderNotifications(bottomSheetAboutSubscription, decorView, it);
            }
        });
        SubscriptionsViewModel subscriptionsViewModel3 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        subscriptionsViewModel3.observeSubState(viewLifecycleOwner6, new Function1<SubscriptionsViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedToBuySubscription());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.8
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
                    BottomSheetAboutSubscription.this.startBuySubscription();
                    BottomSheetAboutSubscription.this.getSubscriptionsViewModel().clearNeedToBuySubscription();
                }
            }
        });
        SubscriptionViewModel subscriptionViewModel4 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        subscriptionViewModel4.observeSubState(viewLifecycleOwner7, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isPayed();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.onViewCreated.10
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
                BottomSheetAboutSubscription bottomSheetAboutSubscription = BottomSheetAboutSubscription.this;
                if (it.peekContent().booleanValue()) {
                    bottomSheetAboutSubscription.getAnalytics().trackLogEvent(new SubscriptionsEvents.SuccessStandardPurchase());
                    LinearLayout serviceLoader = BottomSheetAboutSubscription.access$getBinding(bottomSheetAboutSubscription).serviceLoader;
                    Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
                    ViewKt.gone(serviceLoader);
                    NavController navControllerFindNavController = FragmentKt.findNavController(bottomSheetAboutSubscription);
                    IntentProcessingUtilsKt.handleDeeplink(bottomSheetAboutSubscription.getString(R.string.deeplink_profile), BundleKt.bundleOf(), bottomSheetAboutSubscription.requireActivity(), bottomSheetAboutSubscription.getNavigationViewModel(), bottomSheetAboutSubscription.getProfileViewModel(), (64 & 32) != 0 ? null : bottomSheetAboutSubscription.getAnalytics(), (64 & 64) != 0 ? null : null);
                    NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_bottomSheetSuccessPayment, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.Notification.COLOR, bottomSheetAboutSubscription.primaryColor), new Pair("is_migration_from_other_subscription", Boolean.valueOf(bottomSheetAboutSubscription.getSubscriptionsViewModel().getCurrentState().getActiveSubscription() != null))), null, 8, null);
                    bottomSheetAboutSubscription.getSubscriptionsViewModel().getSubscriptions();
                    IProfileViewModel.DefaultImpls.loadProfile$default(bottomSheetAboutSubscription.getProfileViewModel(), false, 1, null);
                    return;
                }
                LinearLayout serviceLoader2 = BottomSheetAboutSubscription.access$getBinding(bottomSheetAboutSubscription).serviceLoader;
                Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
                ViewKt.gone(serviceLoader2);
            }
        });
        getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewWantPromoStandardDesc());
    }

    /* compiled from: BottomSheetAboutSubscription.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, BottomSheetAboutSubscription.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetAboutSubscription) this.receiver).render3ds(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetAboutSubscriptionBinding binding = getBinding();
        Button button = binding.btnSubscribe;
        Intrinsics.checkNotNull(button);
        SafeClickListenerKt.setSafeOnClickListener$default(button, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$initViews$1$1$1
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
                this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickWantPromoStandardPayment());
                this.this$0.startBuySubscription();
            }
        }, 1, null);
        TextView textView = binding.btnOtherSubscriptions;
        Intrinsics.checkNotNull(textView);
        SafeClickListenerKt.setSafeOnClickListener$default(textView, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription$initViews$1$2$1
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
                NavController bottomController;
                Intrinsics.checkNotNullParameter(it, "it");
                FragmentKt.findNavController(this.this$0).popBackStack();
                Integer from = this.this$0.getFrom();
                if (from != null && from.intValue() == 2002) {
                    NavController bottomController2 = GlobalVariables.INSTANCE.getBottomController();
                    if (bottomController2 != null) {
                        Uri uri = Uri.parse(this.this$0.getString(R.string.deeplink_market));
                        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                        bottomController2.navigate(uri);
                        return;
                    }
                    return;
                }
                if (from != null && from.intValue() == 2001) {
                    FragmentKt.findNavController(this.this$0).popBackStack();
                    GlobalVariables.INSTANCE.setNeedNavigateToMarket(true);
                } else {
                    if (from == null || from.intValue() != 2003 || (bottomController = GlobalVariables.INSTANCE.getBottomController()) == null) {
                        return;
                    }
                    Uri uri2 = Uri.parse(this.this$0.getString(R.string.deeplink_market));
                    Intrinsics.checkNotNullExpressionValue(uri2, "parse(...)");
                    bottomController.navigate(uri2);
                }
            }
        }, 1, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        BaseSubscription baseSubscription;
        SubscriptionAppearance appearance;
        SubscriptionDetails subscriptionDetails;
        List<Plan> plans;
        Plan plan;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        SubscriptionAppearance appearance2;
        List<SubscriptionAppearance.FeaturePoint> featuresPoints;
        Enum enumValueOf;
        SubscriptionAppearance appearance3;
        SubscriptionAppearance appearance4;
        SubscriptionBuyLocale subscriptionBuy2;
        SubscriptionBuyBody body2;
        TextTitle buyButton2;
        SubscriptionDetails subscriptionDetails2;
        List<Plan> plans2;
        Plan plan2;
        SubscriptionDetails subscriptionDetails3;
        List<Plan> plans3;
        Plan plan3;
        Plan.Promo promo;
        Object next;
        BottomSheetAboutSubscriptionBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        BottomSheetStandardPromo bottomSheetStandardPromo = data != null ? data.getBottomSheetStandardPromo() : null;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        TextTitle viewPaymentInProgress = data2 != null ? data2.getViewPaymentInProgress() : null;
        List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.areEqual(((BaseSubscription) next).getIdentifier(), this.productId)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            baseSubscription = (BaseSubscription) next;
        } else {
            baseSubscription = null;
        }
        Integer discountPrice = (baseSubscription == null || (subscriptionDetails3 = baseSubscription.getSubscriptionDetails()) == null || (plans3 = subscriptionDetails3.getPlans()) == null || (plan3 = (Plan) CollectionsKt.firstOrNull((List) plans3)) == null || (promo = plan3.getPromo()) == null) ? null : promo.getDiscountPrice();
        Integer price = (baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null) ? null : plan2.getPrice();
        if (discountPrice != null) {
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            String strValueOf = String.valueOf((data3 == null || (subscriptionBuy2 = data3.getSubscriptionBuy()) == null || (body2 = subscriptionBuy2.getBody()) == null || (buyButton2 = body2.getBuyButton()) == null) ? null : buyButton2.getTitle());
            String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
            String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
            SubscriptionAppearance appearance5 = baseSubscription.getAppearance();
            String safe = StringUtilsKt.formatSafe(strValueOf, strOrEmpty + " " + strOrEmpty2 + " " + (appearance5 != null ? appearance5.getPriceText() : null));
            Button btnSubscribe = binding.btnSubscribe;
            Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
            ViewUtilsKt.strikeThrouth(btnSubscribe, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(requireContext(), R.color.track_gray)));
        } else {
            Button button = binding.btnSubscribe;
            LocalizationLocalModel data4 = getLocalizationScreen().getData();
            String strValueOf2 = String.valueOf((data4 == null || (subscriptionBuy = data4.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
            String strOrEmpty3 = StringUtilsKt.orEmpty((baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans)) == null) ? null : plan.getPrice());
            button.setText(StringUtilsKt.formatSafe(strValueOf2, strOrEmpty3 + " " + StringUtilsKt.orEmpty((baseSubscription == null || (appearance = baseSubscription.getAppearance()) == null) ? null : appearance.getPriceText())));
        }
        TextView tvTitle = binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
        ViewBindingUtilsKt.visibilityBasedOn(tvTitle, Boolean.valueOf((bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getTitle() : null) != null));
        binding.tvTitle.setText(bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getTitle() : null);
        TextView tvSubtitle = binding.tvSubtitle;
        Intrinsics.checkNotNullExpressionValue(tvSubtitle, "tvSubtitle");
        ViewBindingUtilsKt.visibilityBasedOn(tvSubtitle, Boolean.valueOf((bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getSubtitle() : null) != null));
        binding.tvSubtitle.setText(bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getSubtitle() : null);
        binding.tvSubscriptionTitle.setText((baseSubscription == null || (appearance4 = baseSubscription.getAppearance()) == null) ? null : appearance4.getTitle());
        binding.tvHeader.setText((baseSubscription == null || (appearance3 = baseSubscription.getAppearance()) == null) ? null : appearance3.getDescription());
        binding.btnOtherSubscriptions.setText(String.valueOf(bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getBtnOtherTariffs() : null));
        binding.tvPaymentInProgress.setText(String.valueOf(viewPaymentInProgress != null ? viewPaymentInProgress.getTitle() : null));
        LinearLayout linearLayout = binding.layoutService;
        if (baseSubscription != null && (appearance2 = baseSubscription.getAppearance()) != null && (featuresPoints = appearance2.getFeaturesPoints()) != null) {
            for (SubscriptionAppearance.FeaturePoint featurePoint : featuresPoints) {
                String title = featurePoint.getTitle();
                if (title != null) {
                    Context context = linearLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    TextViewWithPoint textViewWithPoint = new TextViewWithPoint(context, null, 0, 6, null);
                    textViewWithPoint.setTitle(title);
                    textViewWithPoint.setPointEnabled(true);
                    Resources resources = textViewWithPoint.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    textViewWithPoint.setPadding(DpUtilsKt.convertPxToDb(20.0f, resources), 0, 0, 0);
                    String badge = featurePoint.getBadge();
                    if (badge != null) {
                        try {
                            enumValueOf = Enum.valueOf(ServiceAppearance.ServiceBadges.class, badge);
                        } catch (IllegalArgumentException unused) {
                            enumValueOf = null;
                        }
                        ServiceAppearance.ServiceBadges serviceBadges = (ServiceAppearance.ServiceBadges) enumValueOf;
                        int i = serviceBadges == null ? -1 : WhenMappings.$EnumSwitchMapping$0[serviceBadges.ordinal()];
                        if (i == 1) {
                            textViewWithPoint.setSpecialIcon(R.drawable.ic_new_market);
                        } else if (i == 2) {
                            textViewWithPoint.setSpecialIcon(R.drawable.ic_beta_market);
                        }
                    }
                    linearLayout.addView(textViewWithPoint);
                }
            }
        }
        binding.tvAttention.setText(String.valueOf(bottomSheetStandardPromo != null ? bottomSheetStandardPromo.getCaution() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBuySubscription() {
        BaseSubscription baseSubscription;
        int iIntValue;
        SubscriptionAppearance appearance;
        Plan.Promo promo;
        Integer discountPrice;
        AlertLocale alert;
        AlertData commonError;
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
                if (Intrinsics.areEqual(subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null, this.productId)) {
                    break;
                }
            }
            baseSubscription = (BaseSubscription) next;
        } else {
            baseSubscription = null;
        }
        Plan plan = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
        if ((plan != null ? plan.getPrice() : null) == null) {
            SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
            LocalizationLocalModel data = getLocalizationStorage().getData();
            if (data != null && (alert = data.getAlert()) != null && (commonError = alert.getCommonError()) != null) {
                title = commonError.getBody();
            }
            subscriptionViewModel.notifyErrorMessage(title);
            return;
        }
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        if ((profile != null ? profile.getPaymentMethod() : null) == null) {
            Log.e("sub|plan", baseSubscription + "\n|" + plan);
            SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
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
            subscriptionViewModel2.handleSubscribe(iIntValue, String.valueOf(title), new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.startBuySubscription.1
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
                    BottomSheetAboutSubscription.this.startGetPaymentTokenResult.launch(it2);
                }
            });
            return;
        }
        Log.e("sub2|plan2", baseSubscription + "\n|" + plan);
        if (baseSubscription != null) {
            SubscriptionViewModel subscriptionViewModel3 = getSubscriptionViewModel();
            SubscriptionDetails subscriptionDetails3 = baseSubscription.getSubscriptionDetails();
            ISubscriptionViewModel.DefaultImpls.subscribe$default(subscriptionViewModel3, String.valueOf(subscriptionDetails3 != null ? subscriptionDetails3.getProductId() : null), String.valueOf(plan != null ? plan.getIdentifier() : null), null, null, 12, null);
        }
        LinearLayout serviceLoader = getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
        ViewKt.visible(serviceLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef A[EDGE_INSN: B:75:0x00ef->B:54:0x00ef BREAK  A[LOOP:1: B:33:0x00b4->B:78:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[LOOP:1: B:33:0x00b4->B:78:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderSubscriptionsUi(com.sputnik.common.viewmodels.SubscriptionsViewState r11) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription.renderSubscriptionsUi(com.sputnik.common.viewmodels.SubscriptionsViewState):void");
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
}
