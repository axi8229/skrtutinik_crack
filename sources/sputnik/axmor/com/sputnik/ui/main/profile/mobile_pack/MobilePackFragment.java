package sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.TextListTitles;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.market.services.OriginType;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentMobilePackBinding;
import sputnik.axmor.com.databinding.LayoutInfoServiceBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: MobilePackFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010=\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/mobile_pack/MobilePackFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "", "renderService", "(Ljava/util/List;)V", "service", "initCompanyService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentMobilePackBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentMobilePackBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "serviceId$delegate", "getServiceId", "()Ljava/lang/String;", "serviceId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePackFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MobilePackFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentMobilePackBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: serviceId$delegate, reason: from kotlin metadata */
    private final Lazy serviceId;

    private final FragmentMobilePackBinding getBinding() {
        return (FragmentMobilePackBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
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

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        Toolbar toolbar3 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar3, true, true, true, false, 8, null);
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServices();
            }
        }, new AnonymousClass2(this));
    }

    /* compiled from: MobilePackFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, MobilePackFragment.class, "renderService", "renderService(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MobilePackFragment) this.receiver).renderService(p0);
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
        FragmentMobilePackBinding binding = getBinding();
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
        }
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

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        getBinding();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FragmentMobilePackBinding binding = getBinding();
        binding.tvTitle.setText("С подключенным пакетом вам доступны:");
        binding.tvBody.setText("   • Коды доступа\n   • Видеоархив 3 дня\n   • История посещений\n   • Ускоренная загрузка приложения");
    }

    public MobilePackFragment() {
        super(R.layout.fragment_mobile_pack);
        this.binding = new ViewBindingFragmentDelegate(this, MobilePackFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$navController$2
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
        this.serviceId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment$serviceId$2
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
