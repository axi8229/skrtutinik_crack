package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.CommonDates;
import com.sputnik.common.entities.localization.CommonLocale;
import com.sputnik.common.entities.localization.DigitalKeysMainActionView;
import com.sputnik.common.entities.localization.DigitalKeysMainBody;
import com.sputnik.common.entities.localization.DigitalKeysMainKeyView;
import com.sputnik.common.entities.localization.DigitalKeysMainLocale;
import com.sputnik.common.entities.localization.DigitalKeysMainSubscriptionView;
import com.sputnik.common.entities.localization.IntercomLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.NamingSet;
import com.sputnik.common.entities.localization.PaymentWaitingBody;
import com.sputnik.common.entities.localization.PaymentWaitingLocale;
import com.sputnik.common.entities.localization.TextListTitles;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.market.services.ServiceState;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import java.util.Calendar;
import java.util.Iterator;
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
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentDigitalKeysActiveBinding;
import sputnik.axmor.com.databinding.LayoutInfoServiceBinding;
import sputnik.axmor.com.databinding.WaintingSubscriptionScreenBinding;
import sputnik.axmor.com.sputnik.entities.digital_keys.DigitalKey;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewState;

/* compiled from: DigitalKeysServiceFragment.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0003R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001d\u0010T\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010Q\u001a\u0004\b\\\u0010]R\u001b\u0010c\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010Q\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010Q\u001a\u0004\bf\u0010gR\u001d\u0010l\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010Q\u001a\u0004\bj\u0010k¨\u0006m"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/DigitalKeysServiceFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;", RemoteMessageConst.DATA, "", "renderKeys", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;)V", "Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;", "code", "initPermCode", "(Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;)V", "initTempCode", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "renderService", "(Ljava/util/List;)V", "service", "initCompanyService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "initSubscriptionService", "", "shareCode", "(Ljava/lang/String;)V", "copyCode", "", "extTime", "Landroid/widget/TextView;", "view", "setTime", "(JLandroid/widget/TextView;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "onDestroy", "Lsputnik/axmor/com/databinding/FragmentDigitalKeysActiveBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentDigitalKeysActiveBinding;", "binding", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/entities/localization/CommonLocale;", "dates$delegate", "Lkotlin/Lazy;", "getDates", "()Lcom/sputnik/common/entities/localization/CommonLocale;", "dates", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewModel;", "digitalKeysViewModel$delegate", "getDigitalKeysViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewModel;", "digitalKeysViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel", "serviceId$delegate", "getServiceId", "()Ljava/lang/String;", "serviceId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DigitalKeysServiceFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DigitalKeysServiceFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentDigitalKeysActiveBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: dates$delegate, reason: from kotlin metadata */
    private final Lazy dates;

    /* renamed from: digitalKeysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy digitalKeysViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final Lazy serviceId;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;
    public ISupportManager supportManager;

    /* compiled from: DigitalKeysServiceFragment.kt */
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
    public final FragmentDigitalKeysActiveBinding getBinding() {
        return (FragmentDigitalKeysActiveBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
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

    private final CommonLocale getDates() {
        return (CommonLocale) this.dates.getValue();
    }

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DigitalKeysViewModel getDigitalKeysViewModel() {
        return (DigitalKeysViewModel) this.digitalKeysViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionViewModel() {
        return (SubscriptionsViewModel) this.subscriptionViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    /* compiled from: DigitalKeysServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, DigitalKeysServiceFragment.class, "renderService", "renderService(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DigitalKeysServiceFragment) this.receiver).renderService(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServices();
            }
        }, new AnonymousClass2(this));
        DigitalKeysViewModel digitalKeysViewModel = getDigitalKeysViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        digitalKeysViewModel.observeState(viewLifecycleOwner2, new AnonymousClass3(this));
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner3, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment.onViewCreated.4
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
        DigitalKeysViewModel digitalKeysViewModel2 = getDigitalKeysViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        digitalKeysViewModel2.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment.onViewCreated.5
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
                DigitalKeysServiceFragment digitalKeysServiceFragment = DigitalKeysServiceFragment.this;
                LinearLayout root = digitalKeysServiceFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(digitalKeysServiceFragment, root, it);
            }
        });
        SubscriptionsViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeSubState(viewLifecycleOwner5, new Function1<SubscriptionsViewState, BaseSubscription>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final BaseSubscription invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getActiveSubscription();
            }
        }, new AnonymousClass7());
        getDigitalKeysViewModel().loadDigitalKeys();
    }

    /* compiled from: DigitalKeysServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<DigitalKeysViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, DigitalKeysServiceFragment.class, "renderKeys", "renderKeys(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DigitalKeysViewState digitalKeysViewState) {
            invoke2(digitalKeysViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DigitalKeysViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DigitalKeysServiceFragment) this.receiver).renderKeys(p0);
        }
    }

    /* compiled from: DigitalKeysServiceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "sub", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$onViewCreated$7, reason: invalid class name */
    static final class AnonymousClass7 extends Lambda implements Function1<BaseSubscription, Unit> {
        AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) {
            invoke2(baseSubscription);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final BaseSubscription baseSubscription) {
            AppCompatButton buttonHelp = DigitalKeysServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            Intrinsics.checkNotNullExpressionValue(buttonHelp, "buttonHelp");
            ViewBindingUtilsKt.visibilityBasedOn(buttonHelp, Boolean.valueOf(baseSubscription != null));
            AppCompatButton appCompatButton = DigitalKeysServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            final DigitalKeysServiceFragment digitalKeysServiceFragment = DigitalKeysServiceFragment.this;
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$onViewCreated$7$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DigitalKeysServiceFragment.AnonymousClass7.invoke$lambda$1(digitalKeysServiceFragment, baseSubscription, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(DigitalKeysServiceFragment this$0, BaseSubscription baseSubscription, View view) {
            IntercomLocale intercom;
            String activationSubscriptionProblemTitle;
            SubscriptionAppearance appearance;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
            if (data == null || (intercom = data.getIntercom()) == null || (activationSubscriptionProblemTitle = intercom.getActivationSubscriptionProblemTitle()) == null) {
                return;
            }
            ISupportManager supportManager = this$0.getSupportManager();
            supportManager.displayMessenger(StringUtilsKt.formatSafe(activationSubscriptionProblemTitle, String.valueOf((baseSubscription == null || (appearance = baseSubscription.getAppearance()) == null) ? null : appearance.getTitle())) + "\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderKeys(DigitalKeysViewState data) {
        LinearLayout serviceLoader = getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
        ViewBindingUtilsKt.visibilityBasedOn(serviceLoader, Boolean.valueOf(data.getServerState() == Resource.Status.LOADING));
        initPermCode(data.getPermCode());
        initTempCode(data.getTempCode());
    }

    private final void initPermCode(DigitalKey code) {
        FragmentDigitalKeysActiveBinding binding = getBinding();
        if (code != null) {
            binding.tvPerm.setText(code.getValue());
            Long expTime = code.getExpTime();
            Intrinsics.checkNotNull(expTime);
            long jLongValue = expTime.longValue();
            TextView tvExpireTimePerm = binding.tvExpireTimePerm;
            Intrinsics.checkNotNullExpressionValue(tvExpireTimePerm, "tvExpireTimePerm");
            setTime(jLongValue, tvExpireTimePerm);
        }
        CardView permCardLayout = binding.permCardLayout;
        Intrinsics.checkNotNullExpressionValue(permCardLayout, "permCardLayout");
        ViewBindingUtilsKt.visibilityBasedOn(permCardLayout, Boolean.valueOf(code != null));
        TextView addPermCodeButton = binding.addPermCodeButton;
        Intrinsics.checkNotNullExpressionValue(addPermCodeButton, "addPermCodeButton");
        ViewBindingUtilsKt.visibilityBasedOn(addPermCodeButton, Boolean.valueOf(code == null));
    }

    private final void initTempCode(final DigitalKey code) {
        FragmentDigitalKeysActiveBinding binding = getBinding();
        if (code != null) {
            binding.tvTemp.setText(code.getValue());
            Long expTime = code.getExpTime();
            Intrinsics.checkNotNull(expTime);
            long jLongValue = expTime.longValue();
            TextView tvExpireTimeTemp = binding.tvExpireTimeTemp;
            Intrinsics.checkNotNullExpressionValue(tvExpireTimeTemp, "tvExpireTimeTemp");
            setTime(jLongValue, tvExpireTimeTemp);
            binding.shareButtonTemp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DigitalKeysServiceFragment.initTempCode$lambda$5$lambda$4$lambda$2(this.f$0, code, view);
                }
            });
            binding.tvTemp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DigitalKeysServiceFragment.initTempCode$lambda$5$lambda$4$lambda$3(this.f$0, code, view);
                }
            });
        }
        CardView tempCardLayout = binding.tempCardLayout;
        Intrinsics.checkNotNullExpressionValue(tempCardLayout, "tempCardLayout");
        ViewBindingUtilsKt.visibilityBasedOn(tempCardLayout, Boolean.valueOf(code != null));
        TextView addCodeButton = binding.addCodeButton;
        Intrinsics.checkNotNullExpressionValue(addCodeButton, "addCodeButton");
        ViewBindingUtilsKt.visibilityBasedOn(addCodeButton, Boolean.valueOf(code == null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTempCode$lambda$5$lambda$4$lambda$2(DigitalKeysServiceFragment this$0, DigitalKey digitalKey, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String value = digitalKey.getValue();
        Intrinsics.checkNotNull(value);
        this$0.shareCode(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTempCode$lambda$5$lambda$4$lambda$3(DigitalKeysServiceFragment this$0, DigitalKey digitalKey, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String value = digitalKey.getValue();
        Intrinsics.checkNotNull(value);
        this$0.copyCode(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderService(List<Service> services) {
        Object next;
        OriginType type;
        LogUtilsKt.writeLog("RENDERING " + services);
        Iterator<T> it = services.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getDIGITAL_KEY_IDENTIFIER())) {
                    break;
                }
            }
        }
        Service service = (Service) next;
        LogUtilsKt.writeLog("RENDERING " + service);
        if (service != null) {
            Toolbar toolbar = getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
            getBinding().toolbar.setTitle(service.getTitle());
            if (service.getState() == ServiceState.activated) {
                FragmentDigitalKeysActiveBinding binding = getBinding();
                TextView textView = binding.infoLayout.tvDateService;
                Origin origin = service.getOrigin();
                textView.setText(origin != null ? origin.getExpires() : null);
                LinearLayout dateLayout = binding.infoLayout.dateLayout;
                Intrinsics.checkNotNullExpressionValue(dateLayout, "dateLayout");
                Origin origin2 = service.getOrigin();
                ViewBindingUtilsKt.visibilityBasedOn(dateLayout, Boolean.valueOf((origin2 != null ? origin2.getExpires() : null) != null));
                Origin origin3 = service.getOrigin();
                LogUtilsKt.writeLog(String.valueOf((origin3 == null || (type = origin3.getType()) == null) ? null : type.toString()));
                Origin origin4 = service.getOrigin();
                if ((origin4 != null ? origin4.getType() : null) == OriginType.company) {
                    initCompanyService(service);
                } else {
                    initSubscriptionService(service);
                }
                ScrollView root = getBinding().serviceWaiting.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.gone(root);
                return;
            }
            ScrollView root2 = getBinding().serviceWaiting.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            ViewKt.visible(root2);
        }
    }

    private final void initCompanyService(Service service) {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        ArchiveMainLocale archiveMain;
        ArchiveMainView body2;
        TextListTitles partnerView;
        List<String> values;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        Origin origin = service.getOrigin();
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String infoLabel = null;
        textView.setText((data == null || (archiveMain = data.getArchiveMain()) == null || (body2 = archiveMain.getBody()) == null || (partnerView = body2.getPartnerView()) == null || (values = partnerView.getValues()) == null) ? null : (String) CollectionsKt.last((List) values));
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.visible(lCompanyTitles);
        LinearLayout companyNameLayout = layoutInfoServiceBinding.companyNameLayout;
        Intrinsics.checkNotNullExpressionValue(companyNameLayout, "companyNameLayout");
        String title = origin != null ? origin.getTitle() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companyNameLayout, Boolean.valueOf(!(title == null || title.length() == 0)));
        layoutInfoServiceBinding.tvCompanyName.setText(origin != null ? origin.getTitle() : null);
        LinearLayout companyPhoneLayout = layoutInfoServiceBinding.companyPhoneLayout;
        Intrinsics.checkNotNullExpressionValue(companyPhoneLayout, "companyPhoneLayout");
        String phone = origin != null ? origin.getPhone() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companyPhoneLayout, Boolean.valueOf(!(phone == null || phone.length() == 0)));
        layoutInfoServiceBinding.tvCompanyPhone.setText(origin != null ? origin.getPhone() : null);
        LinearLayout companySiteLayout = layoutInfoServiceBinding.companySiteLayout;
        Intrinsics.checkNotNullExpressionValue(companySiteLayout, "companySiteLayout");
        String website = origin != null ? origin.getWebsite() : null;
        ViewBindingUtilsKt.visibilityBasedOn(companySiteLayout, Boolean.valueOf(!(website == null || website.length() == 0)));
        layoutInfoServiceBinding.tvCompanySite.setText(origin != null ? origin.getWebsite() : null);
        AppCompatButton appCompatButton = getBinding().subsSettingsButton;
        appCompatButton.setEnabled(false);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (digitalKeysMain = data2.getDigitalKeysMain()) != null && (body = digitalKeysMain.getBody()) != null) {
            infoLabel = body.getInfoLabel();
        }
        appCompatButton.setText(infoLabel);
    }

    public DigitalKeysServiceFragment() {
        super(R.layout.fragment_digital_keys_active);
        this.binding = new ViewBindingFragmentDelegate(this, DigitalKeysServiceFragment$binding$2.INSTANCE);
        this.dates = LazyKt.lazy(new Function0<CommonLocale>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$dates$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CommonLocale invoke() {
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                if (data != null) {
                    return data.getCommon();
                }
                return null;
            }
        });
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.digitalKeysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DigitalKeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$digitalKeysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$serviceId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("curService") : null);
            }
        });
    }

    private final void initSubscriptionService(Service service) {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        DigitalKeysMainSubscriptionView subscriptionView;
        TextTitle settingsButton;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        Origin origin = service.getOrigin();
        String title = null;
        textView.setText(origin != null ? origin.getTitle() : null);
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.gone(lCompanyTitles);
        AppCompatButton appCompatButton = getBinding().subsSettingsButton;
        appCompatButton.setEnabled(true);
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data != null && (digitalKeysMain = data.getDigitalKeysMain()) != null && (body = digitalKeysMain.getBody()) != null && (subscriptionView = body.getSubscriptionView()) != null && (settingsButton = subscriptionView.getSettingsButton()) != null) {
            title = settingsButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        getBinding().subsSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                DigitalKeysServiceFragment.initViews$lambda$14(this.f$0, view);
            }
        });
        FragmentDigitalKeysActiveBinding binding = getBinding();
        binding.refreshButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                DigitalKeysServiceFragment.initViews$lambda$18$lambda$15(this.f$0, view);
            }
        });
        TextView addPermCodeButton = binding.addPermCodeButton;
        Intrinsics.checkNotNullExpressionValue(addPermCodeButton, "addPermCodeButton");
        SafeClickListenerKt.setSafeOnClickListener$default(addPermCodeButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$initViews$2$2
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
                this.this$0.getDigitalKeysViewModel().updateDigitalPermKey();
            }
        }, 1, null);
        binding.refreshButtonTemp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                DigitalKeysServiceFragment.initViews$lambda$18$lambda$16(this.f$0, view);
            }
        });
        TextView addCodeButton = binding.addCodeButton;
        Intrinsics.checkNotNullExpressionValue(addCodeButton, "addCodeButton");
        SafeClickListenerKt.setSafeOnClickListener$default(addCodeButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$initViews$2$4
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
                this.this$0.getDigitalKeysViewModel().createDigitalTempKey();
            }
        }, 1, null);
        binding.deleteButtonTemp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                DigitalKeysServiceFragment.initViews$lambda$18$lambda$17(this.f$0, view);
            }
        });
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.digitalKeyServiceFragment, R.id.action_digitalKeyServiceFragment_to_blockingNavigation, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14(DigitalKeysServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.digitalKeyServiceFragment, R.id.digitalKeyServicesFragment_to_infoServices, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$18$lambda$15(DigitalKeysServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.digitalKeyServiceFragment, R.id.action_digitalKeyServiceFragment_to_updatePermCodeDialog, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$18$lambda$16(DigitalKeysServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.digitalKeyServiceFragment, R.id.action_digitalKeyServiceFragment_to_updateTempCodeDialog, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$18$lambda$17(DigitalKeysServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.digitalKeyServiceFragment, R.id.action_digitalKeyServiceFragment_to_deleteTempCodeDialog, null, null, 12, null);
    }

    private final void shareCode(String code) {
        DigitalKeysMainLocale digitalKeysMain;
        TextTitle navigation;
        DigitalKeysMainLocale digitalKeysMain2;
        TextTitle sharePopUp;
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        Context context = getContext();
        if (context != null) {
            getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickShareTempCode());
            LocalizationLocalModel data = getLocalizationScreen().getData();
            String title = null;
            String title2 = (data == null || (digitalKeysMain2 = data.getDigitalKeysMain()) == null || (sharePopUp = digitalKeysMain2.getSharePopUp()) == null) ? null : sharePopUp.getTitle();
            Intrinsics.checkNotNull(title2);
            String address = profile != null ? profile.getAddress() : null;
            Intrinsics.checkNotNull(address);
            String str = Util.format(title2, address, code);
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 != null && (digitalKeysMain = data2.getDigitalKeysMain()) != null && (navigation = digitalKeysMain.getNavigation()) != null) {
                title = navigation.getTitle();
            }
            IntentUtilsKt.shareText(context, str, String.valueOf(title));
        }
    }

    private final void copyCode(String code) {
        DigitalKeysMainLocale digitalKeysMain;
        TextTitle copyPopUp;
        String title;
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("clipboard") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData clipDataNewPlainText = ClipData.newPlainText("Digital Key", code);
        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
        getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickShareTempCode());
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (digitalKeysMain = data.getDigitalKeysMain()) == null || (copyPopUp = digitalKeysMain.getCopyPopUp()) == null || (title = copyPopUp.getTitle()) == null) {
            return;
        }
        getDigitalKeysViewModel().notifySuccessMessage(title);
    }

    private final void setTime(long extTime, TextView view) {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        DigitalKeysMainKeyView keyView;
        String timeLabel;
        CommonLocale dates;
        String str;
        long j = 60;
        long time = ((extTime - Calendar.getInstance().getTime().getTime()) / 1000) / j;
        long j2 = time / j;
        long j3 = 24;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        long j6 = time % j;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (digitalKeysMain = data.getDigitalKeysMain()) == null || (body = digitalKeysMain.getBody()) == null || (keyView = body.getKeyView()) == null || (timeLabel = keyView.getTimeLabel()) == null || (dates = getDates()) == null) {
            return;
        }
        String time$lambda$21$getDayInString = setTime$lambda$21$getDayInString(j4, dates);
        String time$lambda$21$getHourInString = setTime$lambda$21$getHourInString(j5, dates);
        String time$lambda$21$getMinutesInString = setTime$lambda$21$getMinutesInString(j6, dates);
        if (j4 == 0) {
            str = "";
        } else {
            str = j4 + " " + time$lambda$21$getDayInString + " ";
        }
        view.setText(Util.format(timeLabel, str + j5 + " " + time$lambda$21$getHourInString + " " + j6 + " " + time$lambda$21$getMinutesInString));
    }

    private static final String setTime$lambda$21$getDayInString(long j, CommonLocale commonLocale) {
        NamingSet days;
        NamingSet days2;
        NamingSet days3;
        NamingSet days4;
        String few = null;
        if ((j % 100) / 10 == 1) {
            CommonDates dates = commonLocale.getDates();
            if (dates != null && (days4 = dates.getDays()) != null) {
                few = days4.getMany();
            }
            return String.valueOf(few);
        }
        if (j == 1) {
            CommonDates dates2 = commonLocale.getDates();
            if (dates2 != null && (days3 = dates2.getDays()) != null) {
                few = days3.getSingle();
            }
            return String.valueOf(few);
        }
        if (j == 2 || j == 3 || j == 4) {
            CommonDates dates3 = commonLocale.getDates();
            if (dates3 != null && (days = dates3.getDays()) != null) {
                few = days.getFew();
            }
            return String.valueOf(few);
        }
        CommonDates dates4 = commonLocale.getDates();
        if (dates4 != null && (days2 = dates4.getDays()) != null) {
            few = days2.getMany();
        }
        return String.valueOf(few);
    }

    private static final String setTime$lambda$21$getHourInString(long j, CommonLocale commonLocale) {
        NamingSet hours;
        NamingSet hours2;
        NamingSet hours3;
        CommonDates dates = commonLocale.getDates();
        String many = null;
        String single = (dates == null || (hours3 = dates.getHours()) == null) ? null : hours3.getSingle();
        CommonDates dates2 = commonLocale.getDates();
        String few = (dates2 == null || (hours2 = dates2.getHours()) == null) ? null : hours2.getFew();
        CommonDates dates3 = commonLocale.getDates();
        if (dates3 != null && (hours = dates3.getHours()) != null) {
            many = hours.getMany();
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{single, few, many});
        int iIntValue = 2;
        List listListOf2 = CollectionsKt.listOf((Object[]) new Integer[]{2, 0, 1, 1, 1, 2});
        long j2 = j % 100;
        if (5 > j2 || j2 >= 20) {
            iIntValue = ((Number) listListOf2.get((int) (((int) j) % 10 < 5 ? j % 10 : 5L))).intValue();
        }
        return String.valueOf(listListOf.get(Math.abs(iIntValue)));
    }

    private static final String setTime$lambda$21$getMinutesInString(long j, CommonLocale commonLocale) {
        NamingSet minutes;
        NamingSet minutes2;
        NamingSet minutes3;
        NamingSet minutes4;
        long jAbs = Math.abs(j) % 100;
        long j2 = jAbs % 10;
        String many = null;
        if (11 <= jAbs && jAbs < 20) {
            CommonDates dates = commonLocale.getDates();
            if (dates != null && (minutes4 = dates.getMinutes()) != null) {
                many = minutes4.getMany();
            }
            return String.valueOf(many);
        }
        if (2 <= j2 && j2 < 5) {
            CommonDates dates2 = commonLocale.getDates();
            if (dates2 != null && (minutes3 = dates2.getMinutes()) != null) {
                many = minutes3.getFew();
            }
            return String.valueOf(many);
        }
        if (j2 == 1) {
            CommonDates dates3 = commonLocale.getDates();
            if (dates3 != null && (minutes2 = dates3.getMinutes()) != null) {
                many = minutes2.getSingle();
            }
            return String.valueOf(many);
        }
        CommonDates dates4 = commonLocale.getDates();
        if (dates4 != null && (minutes = dates4.getMinutes()) != null) {
            many = minutes.getMany();
        }
        return String.valueOf(many);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        DigitalKeysMainLocale digitalKeysMain;
        DigitalKeysMainBody body;
        TextListTitles partnerView;
        List<String> titles;
        DigitalKeysMainLocale digitalKeysMain2;
        DigitalKeysMainBody body2;
        DigitalKeysMainActionView actionView;
        List<String> buttonTitles;
        DigitalKeysMainLocale digitalKeysMain3;
        DigitalKeysMainBody body3;
        DigitalKeysMainKeyView keyView;
        List<String> titles2;
        DigitalKeysMainLocale digitalKeysMain4;
        DigitalKeysMainBody body4;
        TextTitle attentionView;
        PaymentWaitingLocale paymentWaiting;
        PaymentWaitingBody body5;
        TextTitle helpButton;
        PaymentWaitingLocale paymentWaiting2;
        PaymentWaitingBody body6;
        PaymentWaitingLocale paymentWaiting3;
        PaymentWaitingBody body7;
        WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding = getBinding().serviceWaiting;
        TextView textView = waintingSubscriptionScreenBinding.waitingHeader;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str = null;
        textView.setText((data == null || (paymentWaiting3 = data.getPaymentWaiting()) == null || (body7 = paymentWaiting3.getBody()) == null) ? null : body7.getTitle());
        TextView textView2 = waintingSubscriptionScreenBinding.waitingDescription;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView2.setText((data2 == null || (paymentWaiting2 = data2.getPaymentWaiting()) == null || (body6 = paymentWaiting2.getBody()) == null) ? null : body6.getSubtitle());
        AppCompatButton appCompatButton = waintingSubscriptionScreenBinding.buttonHelp;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        appCompatButton.setText((data3 == null || (paymentWaiting = data3.getPaymentWaiting()) == null || (body5 = paymentWaiting.getBody()) == null || (helpButton = body5.getHelpButton()) == null) ? null : helpButton.getTitle());
        FragmentDigitalKeysActiveBinding binding = getBinding();
        TextView textView3 = binding.tvAttention;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        textView3.setText((data4 == null || (digitalKeysMain4 = data4.getDigitalKeysMain()) == null || (body4 = digitalKeysMain4.getBody()) == null || (attentionView = body4.getAttentionView()) == null) ? null : attentionView.getTitle());
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        if (data5 != null && (digitalKeysMain3 = data5.getDigitalKeysMain()) != null && (body3 = digitalKeysMain3.getBody()) != null && (keyView = body3.getKeyView()) != null && (titles2 = keyView.getTitles()) != null) {
            binding.textView2.setText((CharSequence) CollectionsKt.first((List) titles2));
            binding.textViewTemp.setText((CharSequence) CollectionsKt.last((List) titles2));
        }
        TextView textView4 = binding.addCodeButton;
        LocalizationLocalModel data6 = getLocalizationScreen().getData();
        if (data6 != null && (digitalKeysMain2 = data6.getDigitalKeysMain()) != null && (body2 = digitalKeysMain2.getBody()) != null && (actionView = body2.getActionView()) != null && (buttonTitles = actionView.getButtonTitles()) != null) {
            str = (String) CollectionsKt.first((List) buttonTitles);
        }
        textView4.setText(str);
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        LocalizationLocalModel data7 = getLocalizationScreen().getData();
        if (data7 == null || (digitalKeysMain = data7.getDigitalKeysMain()) == null || (body = digitalKeysMain.getBody()) == null || (partnerView = body.getPartnerView()) == null || (titles = partnerView.getTitles()) == null) {
            return;
        }
        layoutInfoServiceBinding.tvHeaderServiceInfo.setText((CharSequence) CollectionsKt.first((List) titles));
        layoutInfoServiceBinding.dateService.setText(titles.get(1));
        layoutInfoServiceBinding.typeSub.setText(titles.get(2));
        layoutInfoServiceBinding.companyName.setText(titles.get(3));
        layoutInfoServiceBinding.companyPhone.setText(titles.get(4));
        layoutInfoServiceBinding.companySite.setText(titles.get(5));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getDigitalKeysViewModel().clearState();
    }
}
