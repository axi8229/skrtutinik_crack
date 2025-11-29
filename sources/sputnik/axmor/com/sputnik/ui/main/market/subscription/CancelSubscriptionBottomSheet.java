package sputnik.axmor.com.sputnik.ui.main.market.subscription;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.github.razir.progressbutton.ProgressButtonHolderKt;
import com.github.razir.progressbutton.ProgressParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpLocale;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.market.PlansDuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.CancelSubscriptionBottomSheetBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.BottomSheetAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewState;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: CancelSubscriptionBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0003R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00101\u001a\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/CancelSubscriptionBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "", "Lcom/sputnik/common/entities/market/service/Service;", RemoteMessageConst.DATA, "renderServices", "(Ljava/util/List;)V", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lsputnik/axmor/com/databinding/CancelSubscriptionBottomSheetBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/CancelSubscriptionBottomSheetBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CancelSubscriptionBottomSheet extends BottomSheetDialogFragment {
    private ViewBinding _binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$navController$2
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

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* compiled from: CancelSubscriptionBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlansDuration.values().length];
            try {
                iArr[PlansDuration.P1M.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlansDuration.P1Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancelSubscriptionBottomSheetBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.CancelSubscriptionBottomSheetBinding");
        return (CancelSubscriptionBottomSheetBinding) viewBinding;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionViewModel getSubscriptionViewModel() {
        return (SubscriptionViewModel) this.subscriptionViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
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
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CancelSubscriptionBottomSheetBinding.inflate(getLayoutInflater(), container, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) this.getDialog();
                FrameLayout frameLayout = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet) : null;
                Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
                BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
                bottomSheetBehaviorFrom.setState(3);
                bottomSheetBehaviorFrom.setPeekHeight(0);
                final CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet = this;
                bottomSheetBehaviorFrom.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$onViewCreated$1$onGlobalLayout$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onStateChanged(View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState == 4) {
                            cancelSubscriptionBottomSheet.dismiss();
                        }
                    }
                });
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNewServices();
            }
        }, new AnonymousClass3(this));
        MarketViewModel marketViewModel2 = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        marketViewModel2.observeSubState(viewLifecycleOwner2, new Function1<MarketViewState, List<? extends Subscription>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final List<Subscription> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSubscriptions();
            }
        }, new Function1<List<? extends Subscription>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.5

            /* compiled from: CancelSubscriptionBottomSheet.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$onViewCreated$5$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PlansDuration.values().length];
                    try {
                        iArr[PlansDuration.P1M.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PlansDuration.P1Y.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subscription> list) {
                invoke2((List<Subscription>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Subscription> it) {
                UnSubscriptionPopUpLocale stopSubscriptionPopup;
                Intrinsics.checkNotNullParameter(it, "it");
                Subscription subscription = (Subscription) CollectionsKt.firstOrNull((List) it);
                CancelSubscriptionBottomSheet.this.getBinding().tvRefundValue.setText(String.valueOf(subscription != null ? subscription.getRefund() : null));
                PlansDuration duration = subscription != null ? subscription.getDuration() : null;
                int i = duration == null ? -1 : WhenMappings.$EnumSwitchMapping$0[duration.ordinal()];
                if (i == 1) {
                    LocalizationLocalModel data = CancelSubscriptionBottomSheet.this.getLocalizationScreen().getData();
                    if (data != null && (stopSubscriptionPopup = data.getStopSubscriptionPopup()) != null) {
                        stopSubscriptionPopup.getBody();
                    }
                    LinearLayout llRefund = CancelSubscriptionBottomSheet.this.getBinding().llRefund;
                    Intrinsics.checkNotNullExpressionValue(llRefund, "llRefund");
                    ViewKt.gone(llRefund);
                    return;
                }
                if (i != 2) {
                    LinearLayout llRefund2 = CancelSubscriptionBottomSheet.this.getBinding().llRefund;
                    Intrinsics.checkNotNullExpressionValue(llRefund2, "llRefund");
                    ViewKt.visible(llRefund2);
                } else {
                    LinearLayout llRefund3 = CancelSubscriptionBottomSheet.this.getBinding().llRefund;
                    Intrinsics.checkNotNullExpressionValue(llRefund3, "llRefund");
                    ViewKt.visible(llRefund3);
                }
            }
        });
        SubscriptionViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeSubState(viewLifecycleOwner3, new Function1<SubscriptionViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SubscriptionViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isCanceled();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.7
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
                    CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet = CancelSubscriptionBottomSheet.this;
                    if (contentIfNotHandled.booleanValue()) {
                        NavControllerKt.safeNavigate$default(cancelSubscriptionBottomSheet.getNavController(), R.id.bottomCancelSubscription, R.id.action_bottomCancelSubscription_to_servicesInfoFragment, BundleKt.bundleOf(TuplesKt.to("settings", Boolean.TRUE)), null, 8, null);
                        cancelSubscriptionBottomSheet.getSubscriptionsViewModel().getSubscriptions();
                        cancelSubscriptionBottomSheet.dismiss();
                    }
                }
            }
        });
        SubscriptionViewModel subscriptionViewModel2 = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        subscriptionViewModel2.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.onViewCreated.8
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
                CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet = CancelSubscriptionBottomSheet.this;
                ConstraintLayout root = cancelSubscriptionBottomSheet.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(cancelSubscriptionBottomSheet, root, it);
            }
        });
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner5, new AnonymousClass9(this));
        initView();
    }

    /* compiled from: CancelSubscriptionBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, CancelSubscriptionBottomSheet.class, "renderServices", "renderServices(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CancelSubscriptionBottomSheet) this.receiver).renderServices(p0);
        }
    }

    /* compiled from: CancelSubscriptionBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$onViewCreated$9, reason: invalid class name */
    /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass9(Object obj) {
            super(1, obj, CancelSubscriptionBottomSheet.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CancelSubscriptionBottomSheet) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionsUi(SubscriptionsViewState subscriptionsViewState) {
        int i;
        SubscriptionAppearance appearance;
        Badge badge;
        getBinding();
        BaseSubscription activeSubscription = subscriptionsViewState.getActiveSubscription();
        String color = (activeSubscription == null || (appearance = activeSubscription.getAppearance()) == null || (badge = appearance.getBadge()) == null) ? null : badge.getColor();
        if (Intrinsics.areEqual(color, "blue")) {
            i = R.color.sputnik_blue;
        } else {
            Intrinsics.areEqual(color, "green");
            i = R.color.sputnik_green;
        }
        int color2 = ContextCompat.getColor(requireContext(), i);
        RecyclerView.Adapter adapter = getBinding().rvSubscriptionServices.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.BottomSheetAdapter");
        BottomSheetAdapter bottomSheetAdapter = (BottomSheetAdapter) adapter;
        bottomSheetAdapter.setCurrentColor(color2);
        bottomSheetAdapter.notifyDataSetChanged();
        getBinding().tvRefundValue.setTextColor(color2);
        getBinding().btnApply.setBackgroundTintList(ColorStateList.valueOf(color2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderServices(List<Service> data) {
        RecyclerView.Adapter adapter = getBinding().rvSubscriptionServices.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.BottomSheetAdapter");
        BottomSheetAdapter bottomSheetAdapter = (BottomSheetAdapter) adapter;
        List<Service> list = data;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Service) it.next()).getTitle());
        }
        bottomSheetAdapter.submitList(arrayList);
    }

    public CancelSubscriptionBottomSheet() {
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$subscriptionsViewModel$2
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

    private final void initView() {
        final CancelSubscriptionBottomSheetBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvSubscriptionServices;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new BottomSheetAdapter());
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelSubscriptionBottomSheet.initView$lambda$5$lambda$4(this.f$0, view);
            }
        });
        AppCompatButton subsStopButton = binding.subsStopButton;
        Intrinsics.checkNotNullExpressionValue(subsStopButton, "subsStopButton");
        ProgressButtonHolderKt.bindProgressButton(this, subsStopButton);
        AppCompatButton subsStopButton2 = binding.subsStopButton;
        Intrinsics.checkNotNullExpressionValue(subsStopButton2, "subsStopButton");
        SafeClickListenerKt.setSafeOnClickListener$default(subsStopButton2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$initView$1$3
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
                AnalyticsService analyticsService = SputnikApp.INSTANCE.getAnalyticsService();
                Metrics.Companion companion = Metrics.INSTANCE;
                String parentScreen = companion.getServiceMetrics("").getParentScreen();
                Object serviceMetrics = companion.getServiceMetrics("");
                Metrics.ServiceMetrics serviceMetrics2 = serviceMetrics instanceof Metrics.ServiceMetrics ? (Metrics.ServiceMetrics) serviceMetrics : null;
                String unsubscribe = serviceMetrics2 != null ? serviceMetrics2.getUnsubscribe() : null;
                Intrinsics.checkNotNull(unsubscribe);
                AnalyticsService.send$default(analyticsService, parentScreen, unsubscribe, null, 4, null);
                if (this.this$0.getMarketViewModel().getCurrentState().getSubscriptions().isEmpty()) {
                    return;
                }
                String productId = ((Subscription) CollectionsKt.first((List) this.this$0.getMarketViewModel().getCurrentState().getSubscriptions())).getProductId();
                SubscriptionViewModel subscriptionViewModel = this.this$0.getSubscriptionViewModel();
                Intrinsics.checkNotNull(productId);
                subscriptionViewModel.cancelSubscription(productId);
                AppCompatButton subsStopButton3 = binding.subsStopButton;
                Intrinsics.checkNotNullExpressionValue(subsStopButton3, "subsStopButton");
                final CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet = this.this$0;
                DrawableButtonExtensionsKt.showProgress(subsStopButton3, new Function1<ProgressParams, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet$initView$1$3.1
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
                        showProgress.setProgressColor(Integer.valueOf(ContextCompat.getColor(cancelSubscriptionBottomSheet.requireContext(), R.color.track_gray)));
                    }
                });
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(CancelSubscriptionBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentKt.findNavController(this).navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this._binding = null;
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void localize() {
        /*
            r5 = this;
            sputnik.axmor.com.databinding.CancelSubscriptionBottomSheetBinding r0 = r5.getBinding()
            com.sputnik.common.viewmodels.MarketViewModel r1 = r5.getMarketViewModel()
            com.sputnik.common.base.VMState r1 = r1.getCurrentState()
            com.sputnik.common.viewmodels.MarketViewState r1 = (com.sputnik.common.viewmodels.MarketViewState) r1
            java.util.List r1 = r1.getSubscriptions()
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            com.sputnik.common.entities.market.subscription.Subscription r1 = (com.sputnik.common.entities.market.subscription.Subscription) r1
            r2 = 0
            if (r1 == 0) goto L20
            com.sputnik.domain.entities.market.PlansDuration r1 = r1.getDuration()
            goto L21
        L20:
            r1 = r2
        L21:
            if (r1 != 0) goto L25
            r1 = -1
            goto L2d
        L25:
            int[] r3 = sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
        L2d:
            r3 = 1
            if (r1 == r3) goto L5f
            r3 = 2
            if (r1 == r3) goto L4a
            com.sputnik.common.localization.LocalizationStorage r1 = r5.getLocalizationScreen()
            com.sputnik.common.entities.localization.LocalizationLocalModel r1 = r1.getData()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpLocale r1 = r1.getStopSubscriptionPopup()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpBody r1 = r1.getBody()
            goto L73
        L48:
            r1 = r2
            goto L73
        L4a:
            com.sputnik.common.localization.LocalizationStorage r1 = r5.getLocalizationScreen()
            com.sputnik.common.entities.localization.LocalizationLocalModel r1 = r1.getData()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpLocale r1 = r1.getUnsubscriptionPopup()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpBody r1 = r1.getBody()
            goto L73
        L5f:
            com.sputnik.common.localization.LocalizationStorage r1 = r5.getLocalizationScreen()
            com.sputnik.common.entities.localization.LocalizationLocalModel r1 = r1.getData()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpLocale r1 = r1.getStopSubscriptionPopup()
            if (r1 == 0) goto L48
            com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpBody r1 = r1.getBody()
        L73:
            if (r1 == 0) goto Lb0
            android.widget.TextView r3 = r0.tvCancelTitle
            java.lang.String r4 = r1.getTitle()
            r3.setText(r4)
            android.widget.TextView r3 = r0.tvSubtitle
            java.lang.String r4 = r1.getSubtitle()
            r3.setText(r4)
            android.widget.TextView r3 = r0.tvRefund
            java.lang.String r4 = r1.getRefund()
            r3.setText(r4)
            androidx.appcompat.widget.AppCompatButton r3 = r0.btnApply
            com.sputnik.common.entities.localization.entities.common.TextTitle r4 = r1.getNoButton()
            if (r4 == 0) goto L9d
            java.lang.String r4 = r4.getTitle()
            goto L9e
        L9d:
            r4 = r2
        L9e:
            r3.setText(r4)
            androidx.appcompat.widget.AppCompatButton r0 = r0.subsStopButton
            com.sputnik.common.entities.localization.entities.common.TextTitle r1 = r1.getYesButton()
            if (r1 == 0) goto Lad
            java.lang.String r2 = r1.getTitle()
        Lad:
            r0.setText(r2)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet.localize():void");
    }
}
