package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.ArchiveMainButtonTitles;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainSubscriptionView;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.IntercomLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.PaymentWaitingBody;
import com.sputnik.common.entities.localization.PaymentWaitingLocale;
import com.sputnik.common.entities.localization.TextListTitles;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.market.services.ServiceState;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;
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
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentServicesArchiveActiveBinding;
import sputnik.axmor.com.databinding.LayoutInfoServiceBinding;
import sputnik.axmor.com.databinding.WaintingSubscriptionScreenBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: ArchiveServiceFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0003R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010+\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/ArchiveServiceFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "", "renderService", "(Ljava/util/List;)V", "service", "initCompanyService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "initSubscriptionService", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentServicesArchiveActiveBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentServicesArchiveActiveBinding;", "binding", "Ldagger/Lazy;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Ldagger/Lazy;", "getFactory", "()Ldagger/Lazy;", "setFactory", "(Ldagger/Lazy;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "serviceId$delegate", "getServiceId", "()Ljava/lang/String;", "serviceId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArchiveServiceFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ArchiveServiceFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentServicesArchiveActiveBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public Lazy<MultiViewModelFactory> factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy marketViewModel;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy serviceId;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy subscriptionViewModel;
    public ISupportManager supportManager;

    /* compiled from: ArchiveServiceFragment.kt */
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
    public final FragmentServicesArchiveActiveBinding getBinding() {
        return (FragmentServicesArchiveActiveBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Lazy<MultiViewModelFactory> getFactory() {
        Lazy<MultiViewModelFactory> lazy = this.factory;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionViewModel() {
        return (SubscriptionsViewModel) this.subscriptionViewModel.getValue();
    }

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
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

    private final String getServiceId() {
        return (String) this.serviceId.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    /* compiled from: ArchiveServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, ArchiveServiceFragment.class, "renderService", "renderService(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ArchiveServiceFragment) this.receiver).renderService(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServices();
            }
        }, new AnonymousClass2(this));
        SubscriptionsViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeSubState(viewLifecycleOwner2, new Function1<SubscriptionsViewState, BaseSubscription>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final BaseSubscription invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getActiveSubscription();
            }
        }, new AnonymousClass4());
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
    }

    /* compiled from: ArchiveServiceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "sub", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$onViewCreated$4, reason: invalid class name */
    static final class AnonymousClass4 extends Lambda implements Function1<BaseSubscription, Unit> {
        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) {
            invoke2(baseSubscription);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final BaseSubscription baseSubscription) {
            AppCompatButton buttonHelp = ArchiveServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            Intrinsics.checkNotNullExpressionValue(buttonHelp, "buttonHelp");
            ViewBindingUtilsKt.visibilityBasedOn(buttonHelp, Boolean.valueOf(baseSubscription != null));
            AppCompatButton appCompatButton = ArchiveServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            final ArchiveServiceFragment archiveServiceFragment = ArchiveServiceFragment.this;
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$onViewCreated$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArchiveServiceFragment.AnonymousClass4.invoke$lambda$1(archiveServiceFragment, baseSubscription, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(ArchiveServiceFragment this$0, BaseSubscription baseSubscription, View view) {
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
    public final void renderService(List<Service> services) {
        Object next;
        Iterator<T> it = services.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), getServiceId())) {
                    break;
                }
            }
        }
        Service service = (Service) next;
        if (service == null) {
            return;
        }
        getBinding().toolbar.setTitle(service.getTitle());
        if (service.getState() == ServiceState.activated) {
            FragmentServicesArchiveActiveBinding binding = getBinding();
            binding.tvMainInfoService.setText(service.getDescription());
            TextView textView = binding.infoLayout.tvDateService;
            Origin origin = service.getOrigin();
            textView.setText(origin != null ? origin.getExpires() : null);
            LinearLayout dateLayout = binding.infoLayout.dateLayout;
            Intrinsics.checkNotNullExpressionValue(dateLayout, "dateLayout");
            Origin origin2 = service.getOrigin();
            ViewBindingUtilsKt.visibilityBasedOn(dateLayout, Boolean.valueOf((origin2 != null ? origin2.getExpires() : null) != null));
            Origin origin3 = service.getOrigin();
            if ((origin3 != null ? origin3.getType() : null) == OriginType.company) {
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

    private final void initCompanyService(Service service) {
        ArchiveMainLocale archiveMain;
        ArchiveMainView body;
        ArchiveMainLocale archiveMain2;
        ArchiveMainView body2;
        TextListTitles partnerView;
        List<String> values;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        Origin origin = service.getOrigin();
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String infoLabel = null;
        textView.setText((data == null || (archiveMain2 = data.getArchiveMain()) == null || (body2 = archiveMain2.getBody()) == null || (partnerView = body2.getPartnerView()) == null || (values = partnerView.getValues()) == null) ? null : (String) CollectionsKt.last((List) values));
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
        if (data2 != null && (archiveMain = data2.getArchiveMain()) != null && (body = archiveMain.getBody()) != null) {
            infoLabel = body.getInfoLabel();
        }
        appCompatButton.setText(infoLabel);
    }

    private final void initSubscriptionService(Service service) {
        ArchiveMainLocale archiveMain;
        ArchiveMainView body;
        ArchiveMainSubscriptionView subscriptionView;
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
        if (data != null && (archiveMain = data.getArchiveMain()) != null && (body = archiveMain.getBody()) != null && (subscriptionView = body.getSubscriptionView()) != null && (settingsButton = subscriptionView.getSettingsButton()) != null) {
            title = settingsButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        AppCompatButton appCompatButton = getBinding().btnServiceUpdate;
        appCompatButton.setEnabled(true);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ArchiveServiceFragment.initViews$lambda$8$lambda$7(this.f$0, view);
            }
        });
        getBinding().subsSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ArchiveServiceFragment.initViews$lambda$9(this.f$0, view);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.archiveServiceFragment, R.id.action_archiveServiceFragment_to_blockingNavigation, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$7(ArchiveServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            AnalyticsService analyticsService = SputnikApp.INSTANCE.getAnalyticsService();
            Metrics.Companion companion = Metrics.INSTANCE;
            String parentScreen = companion.getServiceMetrics(this$0.getServiceId()).getParentScreen();
            Object serviceMetrics = companion.getServiceMetrics(this$0.getServiceId());
            Metrics.ArchiveMetrics archiveMetrics = serviceMetrics instanceof Metrics.ArchiveMetrics ? (Metrics.ArchiveMetrics) serviceMetrics : null;
            String getAccess = archiveMetrics != null ? archiveMetrics.getGetAccess() : null;
            Intrinsics.checkNotNull(getAccess);
            AnalyticsService.send$default(analyticsService, parentScreen, getAccess, null, 4, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.archiveServiceFragment, R.id.action_archiveServiceFragment_to_bottomArchiveFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9(ArchiveServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.archiveServiceFragment, R.id.archiveServicesFragment_to_infoServices, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        ArchiveMainLocale archiveMain;
        ArchiveMainView body;
        TextListTitles partnerView;
        List<String> titles;
        ArchiveMainLocale archiveMain2;
        ArchiveMainView body2;
        ArchiveMainButtonTitles actionView;
        List<String> buttonTitles;
        PaymentWaitingLocale paymentWaiting;
        PaymentWaitingBody body3;
        TextTitle helpButton;
        PaymentWaitingLocale paymentWaiting2;
        PaymentWaitingBody body4;
        PaymentWaitingLocale paymentWaiting3;
        PaymentWaitingBody body5;
        WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding = getBinding().serviceWaiting;
        TextView textView = waintingSubscriptionScreenBinding.waitingHeader;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str = null;
        textView.setText((data == null || (paymentWaiting3 = data.getPaymentWaiting()) == null || (body5 = paymentWaiting3.getBody()) == null) ? null : body5.getTitle());
        TextView textView2 = waintingSubscriptionScreenBinding.waitingDescription;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView2.setText((data2 == null || (paymentWaiting2 = data2.getPaymentWaiting()) == null || (body4 = paymentWaiting2.getBody()) == null) ? null : body4.getSubtitle());
        AppCompatButton appCompatButton = waintingSubscriptionScreenBinding.buttonHelp;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        appCompatButton.setText((data3 == null || (paymentWaiting = data3.getPaymentWaiting()) == null || (body3 = paymentWaiting.getBody()) == null || (helpButton = body3.getHelpButton()) == null) ? null : helpButton.getTitle());
        AppCompatButton appCompatButton2 = getBinding().btnServiceUpdate;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (archiveMain2 = data4.getArchiveMain()) != null && (body2 = archiveMain2.getBody()) != null && (actionView = body2.getActionView()) != null && (buttonTitles = actionView.getButtonTitles()) != null) {
            str = (String) CollectionsKt.first((List) buttonTitles);
        }
        appCompatButton2.setText(str);
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        if (data5 == null || (archiveMain = data5.getArchiveMain()) == null || (body = archiveMain.getBody()) == null || (partnerView = body.getPartnerView()) == null || (titles = partnerView.getTitles()) == null) {
            return;
        }
        layoutInfoServiceBinding.tvHeaderServiceInfo.setText((CharSequence) CollectionsKt.first((List) titles));
        layoutInfoServiceBinding.dateService.setText(titles.get(1));
        layoutInfoServiceBinding.typeSub.setText(titles.get(2));
        layoutInfoServiceBinding.companyName.setText(titles.get(3));
        layoutInfoServiceBinding.companyPhone.setText(titles.get(4));
        layoutInfoServiceBinding.companySite.setText(titles.get(5));
    }

    public ArchiveServiceFragment() {
        super(R.layout.fragment_services_archive_active);
        this.binding = new ViewBindingFragmentDelegate(this, ArchiveServiceFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment$serviceId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("curService") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return (String) obj;
            }
        });
    }
}
