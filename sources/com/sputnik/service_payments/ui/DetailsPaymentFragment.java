package com.sputnik.service_payments.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentDetailBody;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentDetailLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.SettingsMenuView;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.utils.WebViewUtils;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.FragmentDetailsPaymentBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PartnerInfo;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
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

/* compiled from: DetailsPaymentFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\u001d\u0010A\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010=R\u001d\u0010D\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00101\u001a\u0004\bC\u0010=R\u001d\u0010G\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bF\u0010=R\u001d\u0010J\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00101\u001a\u0004\bI\u0010=R\u001d\u0010M\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00101\u001a\u0004\bL\u0010=R\u001d\u0010R\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u00101\u001a\u0004\bP\u0010QR\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006Z"}, d2 = {"Lcom/sputnik/service_payments/ui/DetailsPaymentFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "servicePaymentsViewState", "", "handleLoading", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "state", "renderServiceUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "renderBlockingUi", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "onStop", "Lcom/sputnik/service_payments/databinding/FragmentDetailsPaymentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/service_payments/databinding/FragmentDetailsPaymentBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "timestamp$delegate", "getTimestamp", "()Ljava/lang/Object;", "timestamp", "price$delegate", "getPrice", "price", "accountNumber$delegate", "getAccountNumber", "accountNumber", "address$delegate", "getAddress", "address", "paymentMethod$delegate", "getPaymentMethod", "paymentMethod", "commission$delegate", "getCommission", "commission", "", "accrualUuid$delegate", "getAccrualUuid", "()Ljava/lang/String;", "accrualUuid", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DetailsPaymentFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DetailsPaymentFragment.class, "binding", "getBinding()Lcom/sputnik/service_payments/databinding/FragmentDetailsPaymentBinding;", 0))};

    /* renamed from: accountNumber$delegate, reason: from kotlin metadata */
    private final Lazy accountNumber;

    /* renamed from: accrualUuid$delegate, reason: from kotlin metadata */
    private final Lazy accrualUuid;

    /* renamed from: address$delegate, reason: from kotlin metadata */
    private final Lazy address;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: commission$delegate, reason: from kotlin metadata */
    private final Lazy commission;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: paymentMethod$delegate, reason: from kotlin metadata */
    private final Lazy paymentMethod;

    /* renamed from: price$delegate, reason: from kotlin metadata */
    private final Lazy price;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* renamed from: timestamp$delegate, reason: from kotlin metadata */
    private final Lazy timestamp;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDetailsPaymentBinding getBinding() {
        return (FragmentDetailsPaymentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    private final Object getTimestamp() {
        return this.timestamp.getValue();
    }

    private final Object getPrice() {
        return this.price.getValue();
    }

    private final Object getAccountNumber() {
        return this.accountNumber.getValue();
    }

    private final Object getAddress() {
        return this.address.getValue();
    }

    private final Object getPaymentMethod() {
        return this.paymentMethod.getValue();
    }

    private final Object getCommission() {
        return this.commission.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAccrualUuid() {
        return (String) this.accrualUuid.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        getServicePaymentsViewModel().clearReceipt();
        super.onAttach(context);
    }

    /* compiled from: DetailsPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.DetailsPaymentFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, DetailsPaymentFragment.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DetailsPaymentFragment) this.receiver).renderBlockingUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        ServicePaymentsViewModel servicePaymentsViewModel2 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel2.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        ServicePaymentsViewModel servicePaymentsViewModel3 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel3.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment.onViewCreated.3
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
                DetailsPaymentFragment detailsPaymentFragment = DetailsPaymentFragment.this;
                ConstraintLayout root = detailsPaymentFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(detailsPaymentFragment, root, it);
            }
        });
    }

    /* compiled from: DetailsPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.DetailsPaymentFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, DetailsPaymentFragment.class, "renderServiceUi", "renderServiceUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DetailsPaymentFragment) this.receiver).renderServiceUi(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentDetailsPaymentBinding binding = getBinding();
        SettingsMenuView btnShareOrSave = binding.btnShareOrSave;
        Intrinsics.checkNotNullExpressionValue(btnShareOrSave, "btnShareOrSave");
        SafeClickListenerKt.setSafeOnClickListener$default(btnShareOrSave, 0L, new Function1<View, Unit>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$initViews$1$1
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
                this.this$0.getServicePaymentsViewModel().getReceipt(String.valueOf(this.this$0.getAccrualUuid()));
            }
        }, 1, null);
        EditText etCompany = binding.etCompany;
        Intrinsics.checkNotNullExpressionValue(etCompany, "etCompany");
        ViewUtilsKt.setDrawableListener$default(etCompany, 0, new Function0<Unit>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$initViews$1$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws Resources.NotFoundException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws Resources.NotFoundException {
                this.this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickHistoryPartnerInfoEvent());
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R$id.fragmentDetailsPayment, R$id.action_fragmentDetailsPayment_to_bottomSheetAboutCompany, null, null, 12, null);
            }
        }, 1, null);
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNull(toolbar);
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ServicePaymentDetailBody body;
        TextTitle saveButton;
        ServicePaymentDetailBody body2;
        List<String> titles;
        String str6;
        ServicePaymentDetailBody body3;
        List<String> titles2;
        ServicePaymentDetailBody body4;
        List<String> titles3;
        ServicePaymentDetailBody body5;
        List<String> titles4;
        ServicePaymentDetailBody body6;
        List<String> titles5;
        ServicePaymentDetailBody body7;
        List<String> titles6;
        ServicePaymentDetailBody body8;
        List<String> titles7;
        TextTitle navigation;
        FragmentDetailsPaymentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        ServicePaymentDetailLocale servicePaymentDetail = data != null ? data.getServicePaymentDetail() : null;
        binding.toolbar.setTitle((servicePaymentDetail == null || (navigation = servicePaymentDetail.getNavigation()) == null) ? null : navigation.getTitle());
        binding.tvPaymentDate.setText((servicePaymentDetail == null || (body8 = servicePaymentDetail.getBody()) == null || (titles7 = body8.getTitles()) == null) ? null : (String) CollectionsKt.firstOrNull((List) titles7));
        TextView textView = binding.tvCompany;
        String str7 = "";
        if (servicePaymentDetail == null || (body7 = servicePaymentDetail.getBody()) == null || (titles6 = body7.getTitles()) == null || (str = titles6.get(1)) == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = binding.tvAccountNumber;
        if (servicePaymentDetail == null || (body6 = servicePaymentDetail.getBody()) == null || (titles5 = body6.getTitles()) == null || (str2 = titles5.get(2)) == null) {
            str2 = "";
        }
        textView2.setText(str2);
        TextView textView3 = binding.tvAddress;
        if (servicePaymentDetail == null || (body5 = servicePaymentDetail.getBody()) == null || (titles4 = body5.getTitles()) == null || (str3 = titles4.get(3)) == null) {
            str3 = "";
        }
        textView3.setText(str3);
        TextView textView4 = binding.tvAmount;
        if (servicePaymentDetail == null || (body4 = servicePaymentDetail.getBody()) == null || (titles3 = body4.getTitles()) == null || (str4 = titles3.get(4)) == null) {
            str4 = "";
        }
        textView4.setText(str4);
        TextView textView5 = binding.tvPaymentMethod;
        if (servicePaymentDetail == null || (body3 = servicePaymentDetail.getBody()) == null || (titles2 = body3.getTitles()) == null || (str5 = titles2.get(5)) == null) {
            str5 = "";
        }
        textView5.setText(str5);
        TextView textView6 = binding.tvComission;
        if (servicePaymentDetail != null && (body2 = servicePaymentDetail.getBody()) != null && (titles = body2.getTitles()) != null && (str6 = titles.get(6)) != null) {
            str7 = str6;
        }
        textView6.setText(str7);
        SettingsMenuView settingsMenuView = binding.btnShareOrSave;
        if (servicePaymentDetail != null && (body = servicePaymentDetail.getBody()) != null && (saveButton = body.getSaveButton()) != null) {
            title = saveButton.getTitle();
        }
        settingsMenuView.setTitle(title);
    }

    private final void handleLoading(ServicePaymentsViewState.ReceiptState servicePaymentsViewState) {
        ProgressBar pbLoader = getBinding().pbLoader;
        Intrinsics.checkNotNullExpressionValue(pbLoader, "pbLoader");
        ViewBindingUtilsKt.visibilityBasedOn(pbLoader, Boolean.valueOf((servicePaymentsViewState != null ? servicePaymentsViewState.getState() : null) == Resource.Status.LOADING));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderServiceUi(ServicePaymentsViewState state) {
        ServicePaymentsViewState.ReceiptState receiptState = state.getReceiptState();
        FragmentDetailsPaymentBinding binding = getBinding();
        handleLoading(receiptState);
        final String receiptUrl = receiptState != null ? receiptState.getReceiptUrl() : null;
        if (receiptUrl != null) {
            WebViewUtils.INSTANCE.openWebPage(getActivity(), receiptUrl);
            SettingsMenuView btnShareOrSave = binding.btnShareOrSave;
            Intrinsics.checkNotNullExpressionValue(btnShareOrSave, "btnShareOrSave");
            SafeClickListenerKt.setSafeOnClickListener$default(btnShareOrSave, 0L, new Function1<View, Unit>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$renderServiceUi$1$1
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
                    WebViewUtils.INSTANCE.openWebPage(this.this$0.getActivity(), receiptUrl);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) {
        FragmentDetailsPaymentBinding binding = getBinding();
        ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
        PartnerInfo partner = accountInfo != null ? accountInfo.getPartner() : null;
        binding.etCompany.setText(partner != null ? partner.getOrganisation() : null);
        binding.etPaymentDate.setText(String.valueOf(getTimestamp()));
        binding.etSum.setText(String.valueOf(getPrice()));
        binding.etAccountBill.setText(String.valueOf(getAccountNumber()));
        binding.etAddress.setText(String.valueOf(getAddress()));
        LinearLayout lAddress = binding.lAddress;
        Intrinsics.checkNotNullExpressionValue(lAddress, "lAddress");
        ViewBindingUtilsKt.visibilityBasedOn(lAddress, Boolean.valueOf(getAddress() != null));
        LinearLayout lAccountBill = binding.lAccountBill;
        Intrinsics.checkNotNullExpressionValue(lAccountBill, "lAccountBill");
        ViewBindingUtilsKt.visibilityBasedOn(lAccountBill, Boolean.valueOf(getAccountNumber() != null));
        LinearLayout lDatePayment = binding.lDatePayment;
        Intrinsics.checkNotNullExpressionValue(lDatePayment, "lDatePayment");
        ViewBindingUtilsKt.visibilityBasedOn(lDatePayment, Boolean.valueOf(getTimestamp() != null));
        LinearLayout lPaymentMethod = binding.lPaymentMethod;
        Intrinsics.checkNotNullExpressionValue(lPaymentMethod, "lPaymentMethod");
        ViewBindingUtilsKt.visibilityBasedOn(lPaymentMethod, Boolean.valueOf(getPaymentMethod() != null));
        LinearLayout lCommission = binding.lCommission;
        Intrinsics.checkNotNullExpressionValue(lCommission, "lCommission");
        ViewBindingUtilsKt.visibilityBasedOn(lCommission, Boolean.valueOf(getCommission() != null));
        LinearLayout lSum = binding.lSum;
        Intrinsics.checkNotNullExpressionValue(lSum, "lSum");
        ViewBindingUtilsKt.visibilityBasedOn(lSum, Boolean.valueOf(getPrice() != null));
    }

    public DetailsPaymentFragment() {
        super(R$layout.fragment_details_payment);
        this.binding = new ViewBindingFragmentDelegate(this, DetailsPaymentFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                return FragmentKt.findNavController(this.this$0);
            }
        });
        this.timestamp = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$timestamp$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("timestamp");
                }
                return null;
            }
        });
        this.price = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$price$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("price");
                }
                return null;
            }
        });
        this.accountNumber = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$accountNumber$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("account_number");
                }
                return null;
            }
        });
        this.address = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$address$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("address");
                }
                return null;
            }
        });
        this.paymentMethod = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$paymentMethod$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("payment_method");
                }
                return null;
            }
        });
        this.commission = LazyKt.lazy(new Function0<Object>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$commission$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.get("commission");
                }
                return null;
            }
        });
        this.accrualUuid = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.service_payments.ui.DetailsPaymentFragment$accrualUuid$2
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getServicePaymentsViewModel().clearReceipt();
    }
}
