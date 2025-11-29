package sputnik.axmor.com.sputnik.ui.main.market.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithSubtitle;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionBody;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionInfoView;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionStopBody;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.ActivePlan;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.SurveysState;
import com.sputnik.common.viewmodels.SurveysViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.services.ServiceState;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SettingsSubscriptionFragmentBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.adapter.ServicesInfoAdapter;

/* compiled from: ServicesInfoFragment.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00109\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010 \u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/ServicesInfoFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/market/service/Service;", RemoteMessageConst.DATA, "", "renderServices", "(Ljava/util/List;)V", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "renderSubscriptionInfo", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/SettingsSubscriptionFragmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/SettingsSubscriptionFragmentBinding;", "binding", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel$delegate", "getSurveysViewModel", "()Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "isSubscriptionCancel$delegate", "isSubscriptionCancel", "()Z", "Lsputnik/axmor/com/sputnik/ui/main/market/services/adapter/ServicesInfoAdapter;", "servicesAdapter", "Lsputnik/axmor/com/sputnik/ui/main/market/services/adapter/ServicesInfoAdapter;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesInfoFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ServicesInfoFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/SettingsSubscriptionFragmentBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: isSubscriptionCancel$delegate, reason: from kotlin metadata */
    private final Lazy isSubscriptionCancel;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;
    private final ServicesInfoAdapter servicesAdapter;

    /* renamed from: surveysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveysViewModel;

    /* compiled from: ServicesInfoFragment.kt */
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

    private final SettingsSubscriptionFragmentBinding getBinding() {
        return (SettingsSubscriptionFragmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final SurveysViewModel getSurveysViewModel() {
        return (SurveysViewModel) this.surveysViewModel.getValue();
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

    private final boolean isSubscriptionCancel() {
        return ((Boolean) this.isSubscriptionCancel.getValue()).booleanValue();
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
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNewServices();
            }
        }, new C26692(this));
        MarketViewModel marketViewModel2 = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        marketViewModel2.observeSubState(viewLifecycleOwner2, new Function1<MarketViewState, List<? extends Subscription>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final List<Subscription> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSubscriptions();
            }
        }, new AnonymousClass4(this));
        getSurveysViewModel().observeState(this, new Function1<SurveysState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurveysState surveysState) {
                invoke2(surveysState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurveysState it) {
                Event<Survey> requestedSurvey;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getRequestedSurvey() == null || (requestedSurvey = it.getRequestedSurvey()) == null || requestedSurvey.getContentIfNotHandled() == null) {
                    return;
                }
                ServicesInfoFragment.this.addNavigationAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.to_navigation_poll, "", null, null, 12, null))), false, 4, null));
            }
        });
    }

    /* compiled from: ServicesInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26692 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        C26692(Object obj) {
            super(1, obj, ServicesInfoFragment.class, "renderServices", "renderServices(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ServicesInfoFragment) this.receiver).renderServices(p0);
        }
    }

    /* compiled from: ServicesInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<List<? extends Subscription>, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, ServicesInfoFragment.class, "renderSubscriptionInfo", "renderSubscriptionInfo(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subscription> list) {
            invoke2((List<Subscription>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Subscription> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ServicesInfoFragment) this.receiver).renderSubscriptionInfo(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderServices(List<Service> data) {
        RecyclerView.Adapter adapter = getBinding().rvSubServices.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.services.adapter.ServicesInfoAdapter");
        ((ServicesInfoAdapter) adapter).submitList(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderSubscriptionInfo(List<Subscription> data) {
        Unit unit;
        Object next;
        int i;
        SettingsSubscriptionLocale subscriptionSettings;
        SettingsSubscriptionBody body;
        SettingsSubscriptionInfoView subscriptionInfoView;
        Iterator<T> it = data.iterator();
        while (true) {
            unit = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Subscription subscription = (Subscription) next;
            if (subscription.getState() != ServiceState.deactivated || Intrinsics.areEqual(subscription.getPrimeSubscription(), Boolean.TRUE)) {
                break;
            }
        }
        Subscription subscription2 = (Subscription) next;
        if (subscription2 != null) {
            SettingsSubscriptionFragmentBinding binding = getBinding();
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            List<String> subtitles = (data2 == null || (subscriptionSettings = data2.getSubscriptionSettings()) == null || (body = subscriptionSettings.getBody()) == null || (subscriptionInfoView = body.getSubscriptionInfoView()) == null) ? null : subscriptionInfoView.getSubtitles();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int color = ContextCompat.getColor(contextRequireContext, R.color.sputnik_header_black);
            TextView textView = binding.tvSubscriptionPayedUntil;
            String str = subtitles != null ? (String) CollectionsKt.first((List) subtitles) : null;
            SpannableString spannableString = new SpannableString(str + ": " + subscription2.getExpiresDate());
            SpansKt.addColorSpan(spannableString, String.valueOf(subtitles != null ? (String) CollectionsKt.first((List) subtitles) : null), color);
            textView.setText(spannableString);
            TextView textView2 = binding.tvInfoCompany;
            String str2 = subtitles != null ? subtitles.get(1) : null;
            ActivePlan activePlan = subscription2.getActivePlan();
            SpannableString spannableString2 = new SpannableString(str2 + ": " + (activePlan != null ? activePlan.getPlanTitle() : null));
            ActivePlan activePlan2 = subscription2.getActivePlan();
            SpansKt.addBoldSpan(spannableString2, activePlan2 != null ? activePlan2.getPlanTitle() : null);
            textView2.setText(spannableString2);
            TextView textView3 = binding.tvSubscriptionPrice;
            String str3 = subtitles != null ? (String) CollectionsKt.last((List) subtitles) : null;
            ActivePlan activePlan3 = subscription2.getActivePlan();
            SpannableString spannableString3 = new SpannableString(str3 + ": " + (activePlan3 != null ? activePlan3.getPriceVerbose() : null));
            SpansKt.addColorSpan(spannableString3, String.valueOf(subtitles != null ? (String) CollectionsKt.last((List) subtitles) : null), color);
            textView3.setText(spannableString3);
            Badge badge = subscription2.getBadge();
            String color2 = badge != null ? badge.getColor() : null;
            if (Intrinsics.areEqual(color2, "blue")) {
                i = R.color.sputnik_blue;
            } else {
                Intrinsics.areEqual(color2, "green");
                i = R.color.sputnik_green;
            }
            this.servicesAdapter.applyColor(ContextCompat.getColor(contextRequireContext, i));
            ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, i);
            TextView textView4 = binding.tvSubscriptionTitle;
            Badge badge2 = subscription2.getBadge();
            textView4.setText(badge2 != null ? badge2.getTitle() : null);
            textView4.setBackgroundTintList(colorStateList);
            AppCompatButton subsStopButton = binding.subsStopButton;
            Intrinsics.checkNotNullExpressionValue(subsStopButton, "subsStopButton");
            Boolean canManage = subscription2.getCanManage();
            Boolean bool = Boolean.TRUE;
            ViewBindingUtilsKt.visibilityBasedOn(subsStopButton, Boolean.valueOf(Intrinsics.areEqual(canManage, bool) && subscription2.getState() != ServiceState.deactivated && Intrinsics.areEqual(subscription2.getAutoRenewStatus(), bool)));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LinearLayout lInfoPrice = getBinding().lInfoPrice;
            Intrinsics.checkNotNullExpressionValue(lInfoPrice, "lInfoPrice");
            ViewKt.invisible(lInfoPrice);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        SettingsSubscriptionFragmentBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_widget_divider);
        binding.subsStopButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ServicesInfoFragment.initViews$lambda$10$lambda$7(this.f$0, view);
            }
        });
        binding.cancelScreen.buttonHelp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServicesInfoFragment.initViews$lambda$10$lambda$8(this.f$0, view);
            }
        });
        RecyclerView recyclerView = binding.rvSubServices;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.servicesAdapter);
        Toolbar toolbar2 = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        NestedScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
        ScrollView root = binding.cancelScreen.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewKt.addSystemWindowInsetToPadding$default(root, true, false, true, true, 2, null);
        ScrollView root2 = binding.cancelScreen.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        ViewBindingUtilsKt.visibilityBasedOn(root2, Boolean.valueOf(isSubscriptionCancel()));
        if (isSubscriptionCancel()) {
            getMarketViewModel().loadMarket();
            getMarketViewModel().loadSubscriptions();
            getMarketViewModel().delayRequest(3000L, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$initViews$1$4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getMarketViewModel().handleNeedUpdate(true);
                }
            });
            getSurveysViewModel().loadSurvey("unsubscribe");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$7(ServicesInfoFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.servicesInfoFragment, R.id.action_servicesInfoFragment_to_bottomCancelSubscription, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$8(ServicesInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).popBackStack(R.id.profileSettingsFragment, true);
    }

    public ServicesInfoFragment() {
        super(R.layout.settings_subscription_fragment);
        this.binding = new ViewBindingFragmentDelegate(this, ServicesInfoFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.surveysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment$surveysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.isSubscriptionCancel = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment.isSubscriptionCancel.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = ServicesInfoFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("settings") : false);
            }
        });
        this.servicesAdapter = new ServicesInfoAdapter();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String strValueOf;
        SettingsSubscriptionLocale subscriptionSettings;
        SettingsSubscriptionBody body;
        TextTitle stopButton;
        TitleWithSubtitle titleWithSubtitle;
        SubscriptionStopBody subscriptionStopBody;
        SubscriptionStopBody subscriptionStopBody2;
        SubscriptionStopBody subscriptionStopBody3;
        SettingsSubscriptionLocale subscriptionSettings2;
        SettingsSubscriptionInfoView subscriptionInfoView;
        SettingsSubscriptionLocale subscriptionSettings3;
        SettingsSubscriptionBody body2;
        TextTitle cancelButton;
        SettingsSubscriptionLocale subscriptionSettings4;
        SettingsSubscriptionBody body3;
        TextTitle stopButton2;
        SettingsSubscriptionFragmentBinding binding = getBinding();
        Subscription subscription = (Subscription) CollectionsKt.firstOrNull((List) getMarketViewModel().getCurrentState().getSubscriptions());
        String backToProfile = null;
        PlansDuration duration = subscription != null ? subscription.getDuration() : null;
        int i = duration == null ? -1 : WhenMappings.$EnumSwitchMapping$0[duration.ordinal()];
        if (i == 1) {
            LocalizationLocalModel data = getLocalizationScreen().getData();
            strValueOf = String.valueOf((data == null || (subscriptionSettings = data.getSubscriptionSettings()) == null || (body = subscriptionSettings.getBody()) == null || (stopButton = body.getStopButton()) == null) ? null : stopButton.getTitle());
        } else if (i == 2) {
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            strValueOf = String.valueOf((data2 == null || (subscriptionSettings3 = data2.getSubscriptionSettings()) == null || (body2 = subscriptionSettings3.getBody()) == null || (cancelButton = body2.getCancelButton()) == null) ? null : cancelButton.getTitle());
        } else {
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            strValueOf = String.valueOf((data3 == null || (subscriptionSettings4 = data3.getSubscriptionSettings()) == null || (body3 = subscriptionSettings4.getBody()) == null || (stopButton2 = body3.getStopButton()) == null) ? null : stopButton2.getTitle());
        }
        PlansDuration duration2 = subscription != null ? subscription.getDuration() : null;
        if ((duration2 != null ? WhenMappings.$EnumSwitchMapping$0[duration2.ordinal()] : -1) == 2) {
            LocalizationLocalModel data4 = getLocalizationScreen().getData();
            titleWithSubtitle = data4 != null ? data4.getSubscriptionCancel() : null;
        } else {
            LocalizationLocalModel data5 = getLocalizationScreen().getData();
            String title = (data5 == null || (subscriptionStopBody2 = data5.getSubscriptionStopBody()) == null) ? null : subscriptionStopBody2.getTitle();
            LocalizationLocalModel data6 = getLocalizationScreen().getData();
            titleWithSubtitle = new TitleWithSubtitle(title, (data6 == null || (subscriptionStopBody = data6.getSubscriptionStopBody()) == null) ? null : subscriptionStopBody.getSubtitle());
        }
        binding.cancelScreen.waitingHeader.setText(String.valueOf(titleWithSubtitle != null ? titleWithSubtitle.getTitle() : null));
        binding.cancelScreen.waitingDescription.setText(String.valueOf(titleWithSubtitle != null ? titleWithSubtitle.getSubtitle() : null));
        LocalizationLocalModel data7 = getLocalizationScreen().getData();
        if (data7 != null && (subscriptionSettings2 = data7.getSubscriptionSettings()) != null) {
            Toolbar toolbar = binding.toolbar;
            TextTitle navigation = subscriptionSettings2.getNavigation();
            toolbar.setTitle(navigation != null ? navigation.getTitle() : null);
            TextView textView = binding.tvTitleItemPaid;
            SettingsSubscriptionBody body4 = subscriptionSettings2.getBody();
            textView.setText(body4 != null ? body4.getTitle() : null);
            TextView textView2 = binding.tvInfoSubTitle;
            SettingsSubscriptionBody body5 = subscriptionSettings2.getBody();
            textView2.setText((body5 == null || (subscriptionInfoView = body5.getSubscriptionInfoView()) == null) ? null : subscriptionInfoView.getTitle());
            binding.subsStopButton.setText(strValueOf);
        }
        AppCompatButton appCompatButton = binding.cancelScreen.buttonHelp;
        LocalizationLocalModel data8 = getLocalizationScreen().getData();
        if (data8 != null && (subscriptionStopBody3 = data8.getSubscriptionStopBody()) != null) {
            backToProfile = subscriptionStopBody3.getBackToProfile();
        }
        appCompatButton.setText(backToProfile);
    }
}
