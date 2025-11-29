package com.sputnik.service_payments.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentBody;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentSuccessLocale;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.WebViewUtils;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.BottomNavigationAction;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;
import com.sputnik.service_payments.R$string;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.FragmentSuccessPaymentBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.interfaces.IServicePaymentsViewModel;
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

/* compiled from: SuccessPaymentFragment.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0003R#\u0010%\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010/\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010/\u001a\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010/\u001a\u0004\bY\u0010ZR\u001d\u0010`\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010/\u001a\u0004\b^\u0010_R\u001d\u0010e\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010/\u001a\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/sputnik/service_payments/ui/SuccessPaymentFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "servicePaymentsViewState", "", "handleLoading", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "state", "renderServiceUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "", "Lcom/sputnik/common/entities/market/market/Market;", RemoteMessageConst.DATA, "renderSubscriptionUi", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "onStop", "Lcom/sputnik/service_payments/databinding/FragmentSuccessPaymentBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/service_payments/databinding/FragmentSuccessPaymentBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "", "from$delegate", "getFrom", "()Ljava/lang/Integer;", RemoteMessageConst.FROM, "", "accrualUuid$delegate", "getAccrualUuid", "()Ljava/lang/String;", "accrualUuid", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SuccessPaymentFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SuccessPaymentFragment.class, "binding", "getBinding()Lcom/sputnik/service_payments/databinding/FragmentSuccessPaymentBinding;", 0))};

    /* renamed from: accrualUuid$delegate, reason: from kotlin metadata */
    private final Lazy accrualUuid;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: from$delegate, reason: from kotlin metadata */
    private final Lazy from;
    public LocalizationStorage localizationStorage;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderSubscriptionUi(List<Market> data) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSuccessPaymentBinding getBinding() {
        return (FragmentSuccessPaymentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
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
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final Integer getFrom() {
        return (Integer) this.from.getValue();
    }

    private final String getAccrualUuid() {
        return (String) this.accrualUuid.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner, new Function1<MarketViewState, List<? extends Market>>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final List<Market> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getMarket();
            }
        }, new AnonymousClass2(this));
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner2, new AnonymousClass3(this));
        ServicePaymentsViewModel servicePaymentsViewModel2 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment.onViewCreated.4
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
                SuccessPaymentFragment successPaymentFragment = SuccessPaymentFragment.this;
                View root = successPaymentFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(successPaymentFragment, root, it);
            }
        });
        getServicePaymentsViewModel().getCurrentState();
        IServicePaymentsViewModel.DefaultImpls.updateLastShowingDebtDate$default(getServicePaymentsViewModel(), null, 1, null);
    }

    /* compiled from: SuccessPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.SuccessPaymentFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends Market>, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, SuccessPaymentFragment.class, "renderSubscriptionUi", "renderSubscriptionUi(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Market> list) {
            invoke2((List<Market>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Market> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SuccessPaymentFragment) this.receiver).renderSubscriptionUi(p0);
        }
    }

    /* compiled from: SuccessPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.SuccessPaymentFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, SuccessPaymentFragment.class, "renderServiceUi", "renderServiceUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SuccessPaymentFragment) this.receiver).renderServiceUi(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentSuccessPaymentBinding binding = getBinding();
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$initViews$1$1
                {
                    super(true);
                }

                @Override // androidx.view.OnBackPressedCallback
                public void handleOnBackPressed() {
                    IProfileViewModel.DefaultImpls.loadProfile$default(this.this$0.getProfileViewModel(), false, 1, null);
                    this.this$0.getCamerasViewModel().loadMainCameras();
                    FragmentKt.findNavController(this.this$0).navigateUp();
                }
            });
        }
        binding.btnShareOrSave.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuccessPaymentFragment.initViews$lambda$5$lambda$1(this.f$0, view);
            }
        });
        binding.btnAddSub.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SuccessPaymentFragment.initViews$lambda$5$lambda$2(this.f$0, view);
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuccessPaymentFragment.initViews$lambda$5$lambda$3(this.f$0, view);
            }
        });
        binding.btnGoToProfile.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SuccessPaymentFragment.initViews$lambda$5$lambda$4(this.f$0, view);
            }
        });
        ImageView ivSuccessPayment = binding.ivSuccessPayment;
        Intrinsics.checkNotNullExpressionValue(ivSuccessPayment, "ivSuccessPayment");
        ViewKt.addSystemWindowInsetToPadding$default(ivSuccessPayment, true, true, true, false, 8, null);
        AppCompatButton btnCancel = binding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        ViewKt.addSystemWindowInsetToMargin$default(btnCancel, false, false, false, true, 7, null);
        AppCompatButton btnGoToProfile = binding.btnGoToProfile;
        Intrinsics.checkNotNullExpressionValue(btnGoToProfile, "btnGoToProfile");
        ViewKt.addSystemWindowInsetToMargin$default(btnGoToProfile, false, false, false, true, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$1(SuccessPaymentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getServicePaymentsViewModel().getReceipt(String.valueOf(this$0.getAccrualUuid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$2(SuccessPaymentFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickSputnik1ButtonEvent());
        NavController navControllerFindNavController = FragmentKt.findNavController(this$0);
        Uri uri = Uri.parse(this$0.getString(R$string.deeplink_subscription));
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        navControllerFindNavController.navigate(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$3(SuccessPaymentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).popBackStack(R$id.service_payments_navigation, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$4(SuccessPaymentFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickBackToProfileEvent());
        Integer from = this$0.getFrom();
        if (from != null && from.intValue() == 2000) {
            FragmentKt.findNavController(this$0).popBackStack(R$id.service_payments_navigation, true);
            return;
        }
        if (from != null && from.intValue() == 1000) {
            FragmentKt.findNavController(this$0).popBackStack(R$id.navigation_promise, true);
            NavController bottomController = GlobalVariables.INSTANCE.getBottomController();
            if (bottomController != null) {
                Uri uri = Uri.parse(this$0.getString(R$string.deeplink_profile));
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                bottomController.navigate(uri);
                return;
            }
            return;
        }
        this$0.getNavigationViewModel().addAction(new NavigationScenario(new BottomNavigationAction(this$0.getString(R$string.deeplink_profile), null, 2, null), new LinkedList(CollectionsKt.emptyList()), true));
    }

    private final void handleLoading(ServicePaymentsViewState.ReceiptState servicePaymentsViewState) {
        ProgressBar pbLoader = getBinding().pbLoader;
        Intrinsics.checkNotNullExpressionValue(pbLoader, "pbLoader");
        ViewBindingUtilsKt.visibilityBasedOn(pbLoader, Boolean.valueOf((servicePaymentsViewState != null ? servicePaymentsViewState.getState() : null) == Resource.Status.LOADING));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderServiceUi(ServicePaymentsViewState state) {
        ServicePaymentsViewState.ReceiptState receiptState = state.getReceiptState();
        FragmentSuccessPaymentBinding binding = getBinding();
        handleLoading(receiptState);
        final String receiptUrl = receiptState != null ? receiptState.getReceiptUrl() : null;
        if (receiptUrl != null) {
            WebViewUtils.INSTANCE.openWebPage(getActivity(), receiptUrl);
            binding.btnShareOrSave.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuccessPaymentFragment.renderServiceUi$lambda$8$lambda$7(this.f$0, receiptUrl, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderServiceUi$lambda$8$lambda$7(SuccessPaymentFragment this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebViewUtils.INSTANCE.openWebPage(this$0.getActivity(), str);
    }

    public SuccessPaymentFragment() {
        super(R$layout.fragment_success_payment);
        this.binding = new ViewBindingFragmentDelegate(this, SuccessPaymentFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$10
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$13
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.from = LazyKt.lazy(new Function0<Integer>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$from$2
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
        this.accrualUuid = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.service_payments.ui.SuccessPaymentFragment$accrualUuid$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("accrual_uuid");
                }
                return null;
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle profileButton;
        TextTitle profileButton2;
        TextTitle subscriptionButton;
        TextTitle saveButton;
        ServicePaymentSuccessLocale servicePaymentSuccess;
        FragmentSuccessPaymentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        ServicePaymentBody body = (data == null || (servicePaymentSuccess = data.getServicePaymentSuccess()) == null) ? null : servicePaymentSuccess.getBody();
        binding.tvSuccessPayment.setText(body != null ? body.getTitle() : null);
        binding.btnShareOrSave.setText((body == null || (saveButton = body.getSaveButton()) == null) ? null : saveButton.getTitle());
        binding.btnAddSub.setText((body == null || (subscriptionButton = body.getSubscriptionButton()) == null) ? null : subscriptionButton.getTitle());
        binding.btnCancel.setText((body == null || (profileButton2 = body.getProfileButton()) == null) ? null : profileButton2.getTitle());
        AppCompatButton appCompatButton = binding.btnGoToProfile;
        if (body != null && (profileButton = body.getProfileButton()) != null) {
            title = profileButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getServicePaymentsViewModel().clearReceipt();
    }
}
