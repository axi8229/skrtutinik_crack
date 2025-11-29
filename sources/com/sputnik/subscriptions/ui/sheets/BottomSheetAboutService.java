package com.sputnik.subscriptions.ui.sheets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$style;
import com.sputnik.common.analytics.AlisaEvents;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.CamerasEvents;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.ServiceAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.entities.subscriptions.Services;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.subscriptions.R$color;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import com.sputnik.subscriptions.databinding.BottomSheetAboutServiceBinding;
import com.sputnik.subscriptions.di.SubscriptionsComponentKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: BottomSheetAboutService.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u001d\u00104\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u00100R\u001d\u00107\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u00100R\u001d\u0010:\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010)\u001a\u0004\b9\u00100R\u001d\u0010=\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b<\u00100R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010)\u001a\u0004\b@\u0010AR\u001d\u0010E\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010)\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010)\u001a\u0004\bG\u00100R\u001d\u0010K\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010)\u001a\u0004\bJ\u00100R\"\u0010M\u001a\u00020L8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcom/sputnik/subscriptions/ui/sheets/BottomSheetAboutService;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/subscriptions/databinding/BottomSheetAboutServiceBinding;", "<init>", "()V", "", "trackAnalytics", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "state", "renderBlockingUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "", "header$delegate", "getHeader", "()Ljava/lang/String;", "header", "title1$delegate", "getTitle1", "title1", "title2$delegate", "getTitle2", "title2", "title3$delegate", "getTitle3", "title3", "buttonText$delegate", "getButtonText", "buttonText", "", "buttonColor$delegate", "getButtonColor", "()Ljava/lang/Integer;", "buttonColor", "serviceId$delegate", "getServiceId", "serviceId", "subId$delegate", "getSubId", "subId", "serviceType$delegate", "getServiceType", "serviceType", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetAboutService extends BaseBottomSheetDialogFragment<BottomSheetAboutServiceBinding> {
    public Analytics analytics;

    /* renamed from: buttonColor$delegate, reason: from kotlin metadata */
    private final Lazy buttonColor;

    /* renamed from: buttonText$delegate, reason: from kotlin metadata */
    private final Lazy buttonText;
    public MultiViewModelFactory factory;

    /* renamed from: header$delegate, reason: from kotlin metadata */
    private final Lazy header;
    public LocalizationStorage localizationStorage;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final Lazy serviceId;

    /* renamed from: serviceType$delegate, reason: from kotlin metadata */
    private final Lazy serviceType;

    /* renamed from: subId$delegate, reason: from kotlin metadata */
    private final Lazy subId;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: title1$delegate, reason: from kotlin metadata */
    private final Lazy title1;

    /* renamed from: title2$delegate, reason: from kotlin metadata */
    private final Lazy title2;

    /* renamed from: title3$delegate, reason: from kotlin metadata */
    private final Lazy title3;

    /* compiled from: BottomSheetAboutService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetAboutServiceBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetAboutServiceBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/subscriptions/databinding/BottomSheetAboutServiceBinding;", 0);
        }

        public final BottomSheetAboutServiceBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetAboutServiceBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetAboutServiceBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
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

    private final String getHeader() {
        return (String) this.header.getValue();
    }

    private final String getTitle1() {
        return (String) this.title1.getValue();
    }

    private final String getTitle2() {
        return (String) this.title2.getValue();
    }

    private final String getTitle3() {
        return (String) this.title3.getValue();
    }

    private final String getButtonText() {
        return (String) this.buttonText.getValue();
    }

    private final Integer getButtonColor() {
        return (Integer) this.buttonColor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getServiceId() {
        return (String) this.serviceId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSubId() {
        return (String) this.subId.getValue();
    }

    private final String getServiceType() {
        return (String) this.serviceType.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SubscriptionsComponentKt.subscriptionsComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomSheet);
    }

    /* compiled from: BottomSheetAboutService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07771 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        C07771(Object obj) {
            super(1, obj, BottomSheetAboutService.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetAboutService) this.receiver).renderBlockingUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner, new C07771(this));
        trackAnalytics();
    }

    private final void trackAnalytics() {
        String strValueOf = String.valueOf(getSubId());
        if (Intrinsics.areEqual(strValueOf, Subscriptions.standard.toString())) {
            String strValueOf2 = String.valueOf(getServiceId());
            if (Intrinsics.areEqual(strValueOf2, Services.digital_keys.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketStandardDetCodesDesc());
                return;
            }
            if (Intrinsics.areEqual(strValueOf2, Services.archive_3.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketStandardDetArch3Desc());
                return;
            }
            if (Intrinsics.areEqual(strValueOf2, Services.history.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketStandardDetCallLogDesc());
                return;
            }
            if (Intrinsics.areEqual(strValueOf2, Services.ble.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketStandardDetBle());
                return;
            }
            if (Intrinsics.areEqual(strValueOf2, Services.accelerated_loading.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ShowDetFastLoading());
                return;
            }
            if (Intrinsics.areEqual(strValueOf2, Services.extra_cameras.toString())) {
                getAnalytics().trackLogEvent(new CamerasEvents.ShowDetAllCamerasAccess());
                return;
            } else if (Intrinsics.areEqual(strValueOf2, Services.alice.toString())) {
                getAnalytics().trackLogEvent(new AlisaEvents.ShowDetAlisa());
                return;
            } else {
                if (Intrinsics.areEqual(strValueOf2, Services.multiaddress.toString())) {
                    getAnalytics().trackLogEvent(new MultiAddressEvents.ShowAddressInfoSheet());
                    return;
                }
                return;
            }
        }
        if (Intrinsics.areEqual(strValueOf, Subscriptions.premium.toString())) {
            String strValueOf3 = String.valueOf(getServiceId());
            if (Intrinsics.areEqual(strValueOf3, Services.archive_7.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketPremiumDetArch7Desc());
                return;
            }
            if (Intrinsics.areEqual(strValueOf3, Services.face_rec.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketPremiumDetFacerecDesc());
            } else if (Intrinsics.areEqual(strValueOf3, Services.history.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketPremiumDetCallLogDesc());
            } else if (Intrinsics.areEqual(strValueOf3, Services.digital_keys.toString())) {
                getAnalytics().trackLogEvent(new SubscriptionsEvents.ViewMarketPremiumDetCodesDesc());
            }
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Enum enumValueOf;
        Object next;
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyBody body;
        TextTitle buyButton;
        List<Plan> plans;
        Plan plan;
        List<Plan> plans2;
        Plan plan2;
        Plan.Promo promo;
        BottomSheetAboutServiceBinding binding = getBinding();
        String serviceType = getServiceType();
        if (serviceType == null) {
            enumValueOf = null;
        } else {
            try {
                enumValueOf = Enum.valueOf(ServiceAppearance.ServiceBadges.class, serviceType);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (enumValueOf == ServiceAppearance.ServiceBadges.beta) {
            ConstraintLayout layoutBeta = binding.layoutBeta;
            Intrinsics.checkNotNullExpressionValue(layoutBeta, "layoutBeta");
            ViewKt.visible(layoutBeta);
            binding.tvBeta.setText("Обратите внимание, функция находится на этапе Бета тестирования и может работать нестабильно");
        }
        binding.tvHeader.setText(String.valueOf(getHeader()));
        binding.tvTitle1.setText(String.valueOf(getTitle1()));
        binding.tvTitle2.setText(String.valueOf(getTitle2()));
        binding.tvTitle3.setText(String.valueOf(getTitle3()));
        TextView tvTitle3 = binding.tvTitle3;
        Intrinsics.checkNotNullExpressionValue(tvTitle3, "tvTitle3");
        ViewBindingUtilsKt.visibilityBasedOn(tvTitle3, Boolean.valueOf((getTitle3() == null || StringsKt.isBlank(String.valueOf(getTitle3()))) ? false : true));
        AppCompatButton appCompatButton = binding.btnSubscribe;
        List<BaseSubscription> subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions();
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubscriptionDetails subscriptionDetails = ((BaseSubscription) next).getSubscriptionDetails();
                if (Intrinsics.areEqual(subscriptionDetails != null ? subscriptionDetails.getProductId() : null, getSubId())) {
                    break;
                }
            }
            BaseSubscription baseSubscription = (BaseSubscription) next;
            if (baseSubscription != null) {
                SubscriptionDetails subscriptionDetails2 = baseSubscription.getSubscriptionDetails();
                Integer discountPrice = (subscriptionDetails2 == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null || (promo = plan2.getPromo()) == null) ? null : promo.getDiscountPrice();
                SubscriptionDetails subscriptionDetails3 = baseSubscription.getSubscriptionDetails();
                Integer price = (subscriptionDetails3 == null || (plans = subscriptionDetails3.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans)) == null) ? null : plan.getPrice();
                if (discountPrice != null) {
                    LocalizationLocalModel data = getLocalizationStorage().getData();
                    String strValueOf = String.valueOf((data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
                    String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
                    String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
                    SubscriptionAppearance appearance = baseSubscription.getAppearance();
                    String safe = StringUtilsKt.formatSafe(strValueOf, strOrEmpty + " " + strOrEmpty2 + " " + (appearance != null ? appearance.getPriceText() : null));
                    Intrinsics.checkNotNull(appCompatButton);
                    ViewUtilsKt.strikeThrouth(appCompatButton, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(appCompatButton.getContext(), R$color.track_gray)));
                } else {
                    String strOrEmpty3 = StringUtilsKt.orEmpty(getButtonText());
                    String strOrEmpty4 = StringUtilsKt.orEmpty(price);
                    SubscriptionAppearance appearance2 = baseSubscription.getAppearance();
                    appCompatButton.setText(StringUtilsKt.formatSafe(strOrEmpty3, strOrEmpty4 + " " + (appearance2 != null ? appearance2.getPriceText() : null)));
                }
            }
        }
        getButtonColor();
        Intrinsics.checkNotNull(appCompatButton);
        SafeClickListenerKt.setSafeOnClickListener$default(appCompatButton, 0L, new Function1<View, Unit>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$initViews$1$1$4
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
                String strValueOf2 = String.valueOf(this.this$0.getSubId());
                if (Intrinsics.areEqual(strValueOf2, Subscriptions.standard.toString())) {
                    String strValueOf3 = String.valueOf(this.this$0.getServiceId());
                    if (Intrinsics.areEqual(strValueOf3, Services.digital_keys.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetCodesDescPayment());
                    } else if (Intrinsics.areEqual(strValueOf3, Services.archive_3.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetArch3DescPayment());
                    } else if (Intrinsics.areEqual(strValueOf3, Services.history.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetCallLogDescPayment());
                    } else if (Intrinsics.areEqual(strValueOf3, Services.accelerated_loading.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetFastLoadingDescPayment());
                    } else if (Intrinsics.areEqual(strValueOf3, Services.ble.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketStandardDetBleDescPayment());
                    }
                } else if (Intrinsics.areEqual(strValueOf2, Subscriptions.premium.toString())) {
                    String strValueOf4 = String.valueOf(this.this$0.getServiceId());
                    if (Intrinsics.areEqual(strValueOf4, Services.archive_7.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetArch7DescPayment());
                    } else if (Intrinsics.areEqual(strValueOf4, Services.face_rec.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetFacerecDescPayment());
                    } else if (Intrinsics.areEqual(strValueOf4, Services.history.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetCallLogDescPayment());
                    } else if (Intrinsics.areEqual(strValueOf4, Services.digital_keys.toString())) {
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickMarketPremiumDetCodesDescPayment());
                    }
                }
                this.this$0.getSubscriptionsViewModel().setNeedToBuySubscription();
                FragmentKt.findNavController(this.this$0).navigateUp();
            }
        }, 1, null);
    }

    public BottomSheetAboutService() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.header = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$header$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("header") : null);
            }
        });
        this.title1 = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$title1$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("title_1") : null);
            }
        });
        this.title2 = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$title2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("title_2") : null);
            }
        });
        this.title3 = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$title3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("title_3") : null);
            }
        });
        this.buttonText = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$buttonText$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("button_text") : null);
            }
        });
        this.buttonColor = LazyKt.lazy(new Function0<Integer>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$buttonColor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (Integer) (arguments != null ? arguments.get(RemoteMessageConst.Notification.COLOR) : null);
            }
        });
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$serviceId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("curService") : null);
            }
        });
        this.subId = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$subId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("sub_id") : null);
            }
        });
        this.serviceType = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService$serviceType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("service_type") : null);
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(SubscriptionsViewState state) {
        getBinding();
    }
}
