package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

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
import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FaceRecognitionMainActionView;
import com.sputnik.common.entities.localization.FaceRecognitionMainBody;
import com.sputnik.common.entities.localization.FaceRecognitionMainLocale;
import com.sputnik.common.entities.localization.FaceRecognitionMainSubscriptionView;
import com.sputnik.common.entities.localization.IntercomLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
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
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.market.services.ServiceState;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
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
import sputnik.axmor.com.databinding.FragmentServicesFrBinding;
import sputnik.axmor.com.databinding.LayoutInfoServiceBinding;
import sputnik.axmor.com.databinding.WaintingSubscriptionScreenBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: FrServiceFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrServiceFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", RemoteMessageConst.DATA, "", "renderProfileUi", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "renderService", "(Ljava/util/List;)V", "service", "initCompanyService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "initSubscriptionService", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentServicesFrBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentServicesFrBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "serviceId", "Ljava/lang/String;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrServiceFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FrServiceFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentServicesFrBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final String serviceId;

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;
    public ISupportManager supportManager;

    /* compiled from: FrServiceFragment.kt */
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
    public final FragmentServicesFrBinding getBinding() {
        return (FragmentServicesFrBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionViewModel() {
        return (SubscriptionsViewModel) this.subscriptionViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Scopes.PROFILE, "show", null, 4, null);
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Service>>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Service> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServices();
            }
        }, new AnonymousClass2(this));
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new AnonymousClass3(this));
        SubscriptionsViewModel subscriptionViewModel = getSubscriptionViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionViewModel.observeSubState(viewLifecycleOwner3, new Function1<SubscriptionsViewState, BaseSubscription>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final BaseSubscription invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getActiveSubscription();
            }
        }, new AnonymousClass5());
    }

    /* compiled from: FrServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends Service>, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, FrServiceFragment.class, "renderService", "renderService(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Service> list) {
            invoke2((List<Service>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Service> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FrServiceFragment) this.receiver).renderService(p0);
        }
    }

    /* compiled from: FrServiceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, FrServiceFragment.class, "renderProfileUi", "renderProfileUi(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FrServiceFragment) this.receiver).renderProfileUi(p0);
        }
    }

    /* compiled from: FrServiceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "sub", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$onViewCreated$5, reason: invalid class name */
    static final class AnonymousClass5 extends Lambda implements Function1<BaseSubscription, Unit> {
        AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSubscription baseSubscription) {
            invoke2(baseSubscription);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final BaseSubscription baseSubscription) {
            AppCompatButton buttonHelp = FrServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            Intrinsics.checkNotNullExpressionValue(buttonHelp, "buttonHelp");
            ViewBindingUtilsKt.visibilityBasedOn(buttonHelp, Boolean.valueOf(baseSubscription != null));
            AppCompatButton appCompatButton = FrServiceFragment.this.getBinding().serviceWaiting.buttonHelp;
            final FrServiceFragment frServiceFragment = FrServiceFragment.this;
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$onViewCreated$5$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FrServiceFragment.AnonymousClass5.invoke$lambda$1(frServiceFragment, baseSubscription, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(FrServiceFragment this$0, BaseSubscription baseSubscription, View view) {
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
    public final void renderProfileUi(ProfileViewState data) {
        FaceRecognitionMainLocale faceRecognitionMain;
        FaceRecognitionMainBody body;
        FaceRecognitionMainActionView actionView;
        List<String> buttonTitles;
        FaceRecognitionMainLocale faceRecognitionMain2;
        FaceRecognitionMainBody body2;
        FaceRecognitionMainActionView actionView2;
        List<String> buttonTitles2;
        Profile profile = data.getProfile();
        AppCompatButton btnServiceDelete = getBinding().btnServiceDelete;
        Intrinsics.checkNotNullExpressionValue(btnServiceDelete, "btnServiceDelete");
        ViewBindingUtilsKt.visibilityBasedOn(btnServiceDelete, Boolean.valueOf(profile != null ? Intrinsics.areEqual(profile.getFaceRecognitionDataUploaded(), Boolean.TRUE) : false));
        boolean zAreEqual = profile != null ? Intrinsics.areEqual(profile.getFaceRecognitionDataUploaded(), Boolean.TRUE) : false;
        String str = null;
        if (zAreEqual) {
            AppCompatButton appCompatButton = getBinding().btnServiceUpdate;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 != null && (faceRecognitionMain2 = data2.getFaceRecognitionMain()) != null && (body2 = faceRecognitionMain2.getBody()) != null && (actionView2 = body2.getActionView()) != null && (buttonTitles2 = actionView2.getButtonTitles()) != null) {
                str = buttonTitles2.get(1);
            }
            appCompatButton.setText(str);
            return;
        }
        AppCompatButton appCompatButton2 = getBinding().btnServiceUpdate;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 != null && (faceRecognitionMain = data3.getFaceRecognitionMain()) != null && (body = faceRecognitionMain.getBody()) != null && (actionView = body.getActionView()) != null && (buttonTitles = actionView.getButtonTitles()) != null) {
            str = (String) CollectionsKt.first((List) buttonTitles);
        }
        appCompatButton2.setText(str);
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
                if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), this.serviceId)) {
                    break;
                }
            }
        }
        Service service = (Service) next;
        if (service != null) {
            Toolbar toolbar = getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
            getBinding().toolbar.setTitle(service.getTitle());
            if (service.getState() == ServiceState.activated) {
                FragmentServicesFrBinding binding = getBinding();
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
    }

    private final void initCompanyService(Service service) {
        FaceRecognitionMainLocale faceRecognitionMain;
        FaceRecognitionMainBody body;
        FaceRecognitionMainLocale faceRecognitionMain2;
        FaceRecognitionMainBody body2;
        TextListTitles partnerView;
        List<String> values;
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        Origin origin = service.getOrigin();
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String infoLabel = null;
        textView.setText((data == null || (faceRecognitionMain2 = data.getFaceRecognitionMain()) == null || (body2 = faceRecognitionMain2.getBody()) == null || (partnerView = body2.getPartnerView()) == null || (values = partnerView.getValues()) == null) ? null : (String) CollectionsKt.last((List) values));
        LinearLayout companyNameLayout = layoutInfoServiceBinding.companyNameLayout;
        Intrinsics.checkNotNullExpressionValue(companyNameLayout, "companyNameLayout");
        ViewBindingUtilsKt.visibilityBasedOn(companyNameLayout, Boolean.valueOf((origin != null ? origin.getTitle() : null) != null));
        layoutInfoServiceBinding.tvCompanyName.setText(origin != null ? origin.getTitle() : null);
        LinearLayout companyPhoneLayout = layoutInfoServiceBinding.companyPhoneLayout;
        Intrinsics.checkNotNullExpressionValue(companyPhoneLayout, "companyPhoneLayout");
        ViewBindingUtilsKt.visibilityBasedOn(companyPhoneLayout, Boolean.valueOf((origin != null ? origin.getPhone() : null) != null));
        layoutInfoServiceBinding.tvCompanyPhone.setText(origin != null ? origin.getPhone() : null);
        LinearLayout companySiteLayout = layoutInfoServiceBinding.companySiteLayout;
        Intrinsics.checkNotNullExpressionValue(companySiteLayout, "companySiteLayout");
        ViewBindingUtilsKt.visibilityBasedOn(companySiteLayout, Boolean.valueOf((origin != null ? origin.getWebsite() : null) != null));
        layoutInfoServiceBinding.tvCompanySite.setText(origin != null ? origin.getWebsite() : null);
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.visible(lCompanyTitles);
        AppCompatButton appCompatButton = getBinding().subsSettingsButton;
        appCompatButton.setEnabled(false);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (faceRecognitionMain = data2.getFaceRecognitionMain()) != null && (body = faceRecognitionMain.getBody()) != null) {
            infoLabel = body.getInfoLabel();
        }
        appCompatButton.setText(infoLabel);
    }

    private final void initSubscriptionService(Service service) {
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        TextView textView = layoutInfoServiceBinding.tvTypeSub;
        Origin origin = service.getOrigin();
        textView.setText(origin != null ? origin.getTitle() : null);
        LinearLayout lCompanyTitles = layoutInfoServiceBinding.lCompanyTitles;
        Intrinsics.checkNotNullExpressionValue(lCompanyTitles, "lCompanyTitles");
        ViewKt.gone(lCompanyTitles);
        getBinding().subsSettingsButton.setEnabled(true);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        getBinding().subsSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                FrServiceFragment.initViews$lambda$7(this.f$0, view);
            }
        });
        getBinding().btnServiceUpdate.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                FrServiceFragment.initViews$lambda$8(this.f$0, view);
            }
        });
        getBinding().btnServiceDelete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                FrServiceFragment.initViews$lambda$9(this.f$0, view);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.frServiceFragment, R.id.action_frServiceFragment_to_blockingNavigation, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(FrServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.frServiceFragment, R.id.frServicesFragment_to_infoServices, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(FrServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.FaceRecognizerMainEventName.INSTANCE.getParentScreen(), "data_update", null, 4, null);
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.frServiceFragment, R.id.action_frServiceFragment_to_FrStartScan, null, null, 12, null);
    }

    public FrServiceFragment() {
        super(R.layout.fragment_services_fr);
        this.binding = new ViewBindingFragmentDelegate(this, FrServiceFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.serviceId = AndroidConstants.ServicesNames.INSTANCE.getFR_SUBS_IDENTIFIER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9(FrServiceFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.FaceRecognizerMainEventName.INSTANCE.getParentScreen(), "data_delete", null, 4, null);
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.frServiceFragment, R.id.action_frServiceFragment_to_deleteFr_dialog, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FaceRecognitionMainLocale faceRecognitionMain;
        FaceRecognitionMainBody body;
        FaceRecognitionMainSubscriptionView subscriptionView;
        TextTitle settingsButton;
        FaceRecognitionMainLocale faceRecognitionMain2;
        FaceRecognitionMainBody body2;
        FaceRecognitionMainActionView actionView;
        List<String> buttonTitles;
        FaceRecognitionMainLocale faceRecognitionMain3;
        FaceRecognitionMainBody body3;
        TextListTitles partnerView;
        List<String> titles;
        PaymentWaitingLocale paymentWaiting;
        PaymentWaitingBody body4;
        WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding = getBinding().serviceWaiting;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        if (data != null && (paymentWaiting = data.getPaymentWaiting()) != null && (body4 = paymentWaiting.getBody()) != null) {
            waintingSubscriptionScreenBinding.waitingHeader.setText(body4.getTitle());
            waintingSubscriptionScreenBinding.waitingDescription.setText(body4.getSubtitle());
            AppCompatButton appCompatButton = waintingSubscriptionScreenBinding.buttonHelp;
            TextTitle helpButton = body4.getHelpButton();
            appCompatButton.setText(helpButton != null ? helpButton.getTitle() : null);
        }
        LayoutInfoServiceBinding layoutInfoServiceBinding = getBinding().infoLayout;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (faceRecognitionMain3 = data2.getFaceRecognitionMain()) != null && (body3 = faceRecognitionMain3.getBody()) != null && (partnerView = body3.getPartnerView()) != null && (titles = partnerView.getTitles()) != null) {
            layoutInfoServiceBinding.tvHeaderServiceInfo.setText((CharSequence) CollectionsKt.first((List) titles));
            layoutInfoServiceBinding.dateService.setText(titles.get(1));
            layoutInfoServiceBinding.typeSub.setText(titles.get(2));
            layoutInfoServiceBinding.companyName.setText(titles.get(3));
            layoutInfoServiceBinding.companyPhone.setText(titles.get(4));
            layoutInfoServiceBinding.companySite.setText(titles.get(5));
        }
        FragmentServicesFrBinding binding = getBinding();
        AppCompatButton appCompatButton2 = binding.btnServiceDelete;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        appCompatButton2.setText((data3 == null || (faceRecognitionMain2 = data3.getFaceRecognitionMain()) == null || (body2 = faceRecognitionMain2.getBody()) == null || (actionView = body2.getActionView()) == null || (buttonTitles = actionView.getButtonTitles()) == null) ? null : (String) CollectionsKt.last((List) buttonTitles));
        AppCompatButton appCompatButton3 = binding.subsSettingsButton;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (faceRecognitionMain = data4.getFaceRecognitionMain()) != null && (body = faceRecognitionMain.getBody()) != null && (subscriptionView = body.getSubscriptionView()) != null && (settingsButton = subscriptionView.getSettingsButton()) != null) {
            title = settingsButton.getTitle();
        }
        appCompatButton3.setText(title);
    }
}
