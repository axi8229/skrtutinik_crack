package com.sputnik.service_payments.ui.payment_info_list;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.ActiveCell;
import com.sputnik.common.entities.localization.entities.blocking.NormalCell;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentBody;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentLocale;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import com.sputnik.common.entities.localization.entities.common.TextWithoutParam;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.interfaces.IPaymentsViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.service_payments.R$color;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.FragmentIntercomPaymentBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewState;
import com.yandex.varioqub.config.model.ConfigValue;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;

/* compiled from: IntercomPaymentFragment.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u0010@R\"\u0010E\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010C0C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010J\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010C0C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010FR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00104\u001a\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcom/sputnik/service_payments/ui/payment_info_list/IntercomPaymentFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "handleLoading", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "state", "renderPayments", "(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", "Lcom/sputnik/domain/common/Event;", "", "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/service_payments/databinding/FragmentIntercomPaymentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/service_payments/databinding/FragmentIntercomPaymentBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel$delegate", "getPaymentsViewModel", "()Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "start3dsPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "accrualToPay", "Ljava/lang/String;", "startGetPaymentTokenResult", "Lcom/sputnik/service_payments/ui/payment_info_list/PaymentsHistoryAdapter;", "recyclerViewAdapter$delegate", "getRecyclerViewAdapter", "()Lcom/sputnik/service_payments/ui/payment_info_list/PaymentsHistoryAdapter;", "recyclerViewAdapter", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntercomPaymentFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IntercomPaymentFragment.class, "binding", "getBinding()Lcom/sputnik/service_payments/databinding/FragmentIntercomPaymentBinding;", 0))};
    private String accrualToPay;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: paymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paymentsViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: recyclerViewAdapter$delegate, reason: from kotlin metadata */
    private final Lazy recyclerViewAdapter;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;

    /* compiled from: IntercomPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntercomPaymentState.values().length];
            try {
                iArr[IntercomPaymentState.pending.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntercomPaymentState.succeeded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IntercomPaymentState.canceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentIntercomPaymentBinding getBinding() {
        return (FragmentIntercomPaymentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final PaymentsViewModel getPaymentsViewModel() {
        return (PaymentsViewModel) this.paymentsViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$0(IntercomPaymentFragment this$0, ActivityResult result) {
        AlertLocale alert;
        AlertData commonError;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.getPaymentsViewModel().getCurrentState(String.valueOf(this$0.getPaymentsViewModel().getCurrentState().getPaymentUuid()));
            return;
        }
        this$0.getPaymentsViewModel().clearPaymentState();
        PaymentsViewModel paymentsViewModel = this$0.getPaymentsViewModel();
        LocalizationLocalModel data = this$0.getLocalizationStorage().getData();
        paymentsViewModel.notifyErrorMessage((data == null || (alert = data.getAlert()) == null || (commonError = alert.getCommonError()) == null) ? null : commonError.getBody());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGetPaymentTokenResult$lambda$2(IntercomPaymentFragment this$0, ActivityResult result) {
        AlertLocale alert;
        AlertData commonError;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        String body = null;
        body = null;
        body = null;
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
            LogUtilsKt.writeLog("payment token", tokenizationResultCreateTokenizationResult.getPaymentToken());
            this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickPaymentContinueEvent());
            ProgressBar pbLoader = this$0.getBinding().pbLoader;
            Intrinsics.checkNotNullExpressionValue(pbLoader, "pbLoader");
            ViewKt.visible(pbLoader);
            this$0.getPaymentsViewModel().pay(String.valueOf(this$0.accrualToPay), tokenizationResultCreateTokenizationResult.getPaymentToken());
            return;
        }
        ServicePaymentsViewModel servicePaymentsViewModel = this$0.getServicePaymentsViewModel();
        LocalizationLocalModel data2 = this$0.getLocalizationStorage().getData();
        if (data2 != null && (alert = data2.getAlert()) != null && (commonError = alert.getCommonError()) != null) {
            body = commonError.getBody();
        }
        servicePaymentsViewModel.notifyErrorMessage(body);
        this$0.getPaymentsViewModel().clearPaymentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentsHistoryAdapter getRecyclerViewAdapter() {
        return (PaymentsHistoryAdapter) this.recyclerViewAdapter.getValue();
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
        super.onAttach(context);
    }

    /* compiled from: IntercomPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, IntercomPaymentFragment.class, "renderUi", "renderUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) throws ParseException {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) throws ParseException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((IntercomPaymentFragment) this.receiver).renderUi(p0);
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
        servicePaymentsViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment.onViewCreated.2
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
                IntercomPaymentFragment intercomPaymentFragment = IntercomPaymentFragment.this;
                ConstraintLayout root = intercomPaymentFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(intercomPaymentFragment, root, it);
            }
        });
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        paymentsViewModel.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment.onViewCreated.3
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
                IntercomPaymentFragment intercomPaymentFragment = IntercomPaymentFragment.this;
                ConstraintLayout root = intercomPaymentFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(intercomPaymentFragment, root, it);
            }
        });
        PaymentsViewModel paymentsViewModel2 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        paymentsViewModel2.observeState(viewLifecycleOwner4, new AnonymousClass4(this));
        PaymentsViewModel paymentsViewModel3 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        paymentsViewModel3.observeSubState(viewLifecycleOwner5, new Function1<PaymentsViewState, Event<? extends Boolean>>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(PaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass6(this));
        getServicePaymentsViewModel().getServicePayments();
    }

    /* compiled from: IntercomPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<PaymentsViewState, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, IntercomPaymentFragment.class, "renderPayments", "renderPayments(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentsViewState paymentsViewState) throws Resources.NotFoundException {
            invoke2(paymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((IntercomPaymentFragment) this.receiver).renderPayments(p0);
        }
    }

    /* compiled from: IntercomPaymentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, IntercomPaymentFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((IntercomPaymentFragment) this.receiver).render3ds(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentIntercomPaymentBinding binding = getBinding();
        TextView tvAction = binding.tvAction;
        Intrinsics.checkNotNullExpressionValue(tvAction, "tvAction");
        SafeClickListenerKt.setSafeOnClickListener$default(tvAction, 0L, new Function1<View, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$initViews$1$1
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
                PaymentBottomSheet paymentBottomSheet;
                PaymentBottomSheet paymentBottomSheet2;
                String str;
                Double doubleOrNull;
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickPaymentButtonEvent());
                IntercomPaymentFragment intercomPaymentFragment = this.this$0;
                PaymentHistory payment = intercomPaymentFragment.getServicePaymentsViewModel().getCurrentState().getPayment();
                String subtitle = null;
                intercomPaymentFragment.accrualToPay = payment != null ? payment.getId() : null;
                PaymentsViewModel paymentsViewModel = this.this$0.getPaymentsViewModel();
                PaymentHistory payment2 = this.this$0.getServicePaymentsViewModel().getCurrentState().getPayment();
                double dDoubleValue = (payment2 == null || (str = payment2.get_amount()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(str)) == null) ? ConfigValue.DOUBLE_DEFAULT_VALUE : doubleOrNull.doubleValue();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                String strValueOf = String.valueOf((data == null || (paymentBottomSheet2 = data.getPaymentBottomSheet()) == null) ? null : paymentBottomSheet2.getTitle());
                LocalizationLocalModel data2 = this.this$0.getLocalizationStorage().getData();
                if (data2 != null && (paymentBottomSheet = data2.getPaymentBottomSheet()) != null) {
                    subtitle = paymentBottomSheet.getSubtitle();
                }
                String strValueOf2 = String.valueOf(subtitle);
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                final IntercomPaymentFragment intercomPaymentFragment2 = this.this$0;
                IPaymentsViewModel.DefaultImpls.handlePayment$default(paymentsViewModel, dDoubleValue, strValueOf, strValueOf2, contextRequireContext, new Function1<Intent, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$initViews$1$1.1
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
                        intercomPaymentFragment2.startGetPaymentTokenResult.launch(it2);
                    }
                }, null, ContextCompat.getColor(this.this$0.requireContext(), R$color.sputnik_blue), 32, null);
            }
        }, 1, null);
        TextView tvDebtAction = binding.tvDebtAction;
        Intrinsics.checkNotNullExpressionValue(tvDebtAction, "tvDebtAction");
        SafeClickListenerKt.setSafeOnClickListener$default(tvDebtAction, 0L, new Function1<View, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$initViews$1$2
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
                PaymentBottomSheet paymentBottomSheet;
                PaymentBottomSheet paymentBottomSheet2;
                String str;
                Double doubleOrNull;
                Intrinsics.checkNotNullParameter(it, "it");
                IntercomPaymentFragment intercomPaymentFragment = this.this$0;
                PaymentHistory debtPayment = intercomPaymentFragment.getServicePaymentsViewModel().getCurrentState().getDebtPayment();
                String subtitle = null;
                intercomPaymentFragment.accrualToPay = debtPayment != null ? debtPayment.getId() : null;
                PaymentsViewModel paymentsViewModel = this.this$0.getPaymentsViewModel();
                PaymentHistory debtPayment2 = this.this$0.getServicePaymentsViewModel().getCurrentState().getDebtPayment();
                double dDoubleValue = (debtPayment2 == null || (str = debtPayment2.get_amount()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(str)) == null) ? ConfigValue.DOUBLE_DEFAULT_VALUE : doubleOrNull.doubleValue();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                String strValueOf = String.valueOf((data == null || (paymentBottomSheet2 = data.getPaymentBottomSheet()) == null) ? null : paymentBottomSheet2.getTitle());
                LocalizationLocalModel data2 = this.this$0.getLocalizationStorage().getData();
                if (data2 != null && (paymentBottomSheet = data2.getPaymentBottomSheet()) != null) {
                    subtitle = paymentBottomSheet.getSubtitle();
                }
                String strValueOf2 = String.valueOf(subtitle);
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                final IntercomPaymentFragment intercomPaymentFragment2 = this.this$0;
                IPaymentsViewModel.DefaultImpls.handlePayment$default(paymentsViewModel, dDoubleValue, strValueOf, strValueOf2, contextRequireContext, new Function1<Intent, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$initViews$1$2.1
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
                        intercomPaymentFragment2.startGetPaymentTokenResult.launch(it2);
                    }
                }, null, ContextCompat.getColor(this.this$0.requireContext(), R$color.sputnik_blue), 32, null);
            }
        }, 1, null);
        binding.btnAboutPayments.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                IntercomPaymentFragment.initViews$lambda$8$lambda$3(this.f$0, view);
            }
        });
        RecyclerView recyclerView = binding.rvPaymentsHistory;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(getRecyclerViewAdapter());
        postponeEnterTransition();
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return IntercomPaymentFragment.initViews$lambda$8$lambda$5$lambda$4(this.f$0);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntercomPaymentFragment.initViews$lambda$8$lambda$6(this.f$0, view);
            }
        });
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNull(toolbar);
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ConstraintLayout viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
        handleLoading(getServicePaymentsViewModel().getCurrentState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$3(IntercomPaymentFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.fragmentPayments, R$id.action_fragmentPayments_to_bottomSheetPaymentInfo, BundleKt.bundleOf(), null, 8, null);
    }

    public IntercomPaymentFragment() {
        super(R$layout.fragment_intercom_payment);
        this.binding = new ViewBindingFragmentDelegate(this, IntercomPaymentFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.paymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$paymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IntercomPaymentFragment.start3dsPaymentTokenResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IntercomPaymentFragment.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
        this.recyclerViewAdapter = LazyKt.lazy(new Function0<PaymentsHistoryAdapter>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$recyclerViewAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaymentsHistoryAdapter invoke() {
                ServicePaymentLocale servicePaymentLocale;
                ServicePaymentBody body;
                NormalCell normalCell;
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                String bottom = (data == null || (servicePaymentLocale = data.getServicePaymentLocale()) == null || (body = servicePaymentLocale.getBody()) == null || (normalCell = body.getNormalCell()) == null) ? null : normalCell.getBottom();
                final IntercomPaymentFragment intercomPaymentFragment = this.this$0;
                return new PaymentsHistoryAdapter(bottom, new Function2<View, PaymentHistory, Unit>() { // from class: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment$recyclerViewAdapter$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, PaymentHistory paymentHistory) throws Resources.NotFoundException {
                        invoke2(view, paymentHistory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, PaymentHistory call) throws Resources.NotFoundException {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(call, "call");
                        intercomPaymentFragment.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickHistoryDetailsEvent());
                        NavController navControllerFindNavController = FragmentKt.findNavController(intercomPaymentFragment);
                        int i = R$id.fragmentPayments;
                        int i2 = R$id.action_fragmentPayments_to_fragmentDetailsPayment;
                        Pair pair = TuplesKt.to("timestamp", call.getPaymentDate());
                        Pair pair2 = TuplesKt.to("price", call.getAmount());
                        ServiceAccountInfo accountInfo = intercomPaymentFragment.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
                        Pair pair3 = TuplesKt.to("account_number", accountInfo != null ? accountInfo.getNumber() : null);
                        ServiceAccountInfo accountInfo2 = intercomPaymentFragment.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
                        NavControllerKt.safeNavigate$default(navControllerFindNavController, i, i2, BundleKt.bundleOf(pair, pair2, pair3, TuplesKt.to("address", accountInfo2 != null ? accountInfo2.getFullAddress() : null), TuplesKt.to("accrual_uuid", call.getId())), null, 8, null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$8$lambda$5$lambda$4(IntercomPaymentFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPostponedEnterTransition();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8$lambda$6(IntercomPaymentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextWithoutParam debtBadge;
        List<String> sectionTitles;
        ActiveCell activeCell;
        ActiveCell activeCell2;
        ServicePaymentLocale servicePaymentLocale;
        FragmentIntercomPaymentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String text = null;
        ServicePaymentBody body = (data == null || (servicePaymentLocale = data.getServicePaymentLocale()) == null) ? null : servicePaymentLocale.getBody();
        binding.tvAction.setText((body == null || (activeCell2 = body.getActiveCell()) == null) ? null : activeCell2.getBottom());
        binding.tvDebtAction.setText((body == null || (activeCell = body.getActiveCell()) == null) ? null : activeCell.getBottom());
        binding.tvPaymentsHistory.setText((body == null || (sectionTitles = body.getSectionTitles()) == null) ? null : (String) CollectionsKt.firstOrNull((List) sectionTitles));
        TextView textView = binding.tvDebtPaymentTitle;
        if (body != null && (debtBadge = body.getDebtBadge()) != null) {
            text = debtBadge.getText();
        }
        textView.setText(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(ServicePaymentsViewState data) throws ParseException {
        String dMMYFormat;
        TextWith1Param offer;
        TextWith1Param offer2;
        String payUntil;
        String phoneLocale;
        TextWithoutParam badge;
        ServicePaymentLocale servicePaymentLocale;
        FragmentIntercomPaymentBinding binding = getBinding();
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        ServicePaymentBody body = (data2 == null || (servicePaymentLocale = data2.getServicePaymentLocale()) == null) ? null : servicePaymentLocale.getBody();
        handleLoading(data);
        CardView cvPayment = binding.cvPayment;
        Intrinsics.checkNotNullExpressionValue(cvPayment, "cvPayment");
        boolean z = false;
        ViewBindingUtilsKt.visibilityBasedOn(cvPayment, Boolean.valueOf(data.getPayment() != null));
        CardView cvDebtPayment = binding.cvDebtPayment;
        Intrinsics.checkNotNullExpressionValue(cvDebtPayment, "cvDebtPayment");
        ViewBindingUtilsKt.visibilityBasedOn(cvDebtPayment, Boolean.valueOf(data.getDebtPayment() != null));
        ConstraintLayout layoutPayment = binding.layoutPayment;
        Intrinsics.checkNotNullExpressionValue(layoutPayment, "layoutPayment");
        ViewBindingUtilsKt.visibilityBasedOn(layoutPayment, Boolean.valueOf((data.getPayment() == null && data.getDebtPayment() == null) ? false : true));
        TextView textView = binding.tvPrice;
        PaymentHistory payment = data.getPayment();
        textView.setText(payment != null ? payment.getAmount() : null);
        TextView textView2 = binding.tvDebtPrice;
        PaymentHistory debtPayment = data.getDebtPayment();
        textView2.setText(debtPayment != null ? debtPayment.getAmount() : null);
        binding.tvTopTitle.setText(body != null ? body.getSubtitle() : null);
        TextView textView3 = binding.tvPaymentTitle;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strValueOf = String.valueOf((body == null || (badge = body.getBadge()) == null) ? null : badge.getText());
        PaymentHistory payment2 = data.getPayment();
        if (payment2 == null || (payUntil = payment2.getPayUntil()) == null) {
            dMMYFormat = null;
        } else {
            LocalizationLocalModel data3 = getLocalizationStorage().getData();
            if (data3 == null || (phoneLocale = data3.getTag()) == null) {
                phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
            }
            dMMYFormat = DateUtilsKt.toDMMYFormat(payUntil, phoneLocale);
        }
        String str = String.format(strValueOf, Arrays.copyOf(new Object[]{dMMYFormat}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView3.setText(str);
        TextView tvOffer = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer, "tvOffer");
        ServiceAccountInfo accountInfo = data.getAccountInfo();
        if ((accountInfo != null ? Intrinsics.areEqual(accountInfo.getOfferAccepted(), Boolean.FALSE) : false) && (data.getPayment() != null || data.getDebtPayment() != null)) {
            z = true;
        }
        ViewBindingUtilsKt.visibilityBasedOn(tvOffer, Boolean.valueOf(z));
        TextView tvOffer2 = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer2, "tvOffer");
        ViewUtilsKt.highlightText(tvOffer2, String.valueOf((body == null || (offer2 = body.getOffer()) == null) ? null : offer2.getText()), new HighlightedText(String.valueOf((body == null || (offer = body.getOffer()) == null) ? null : offer.getParam1()), ContextCompat.getColor(requireContext(), R$color.sputnik_blue), "https://api-mobile-gorod.sputnik.systems/sputnik_offer.pdf", null, 0, 0, 56, null));
        TextView textView4 = binding.tvToolbarTitle;
        String accountNumber = body != null ? body.getAccountNumber() : null;
        ServiceAccountInfo accountInfo2 = data.getAccountInfo();
        textView4.setText(accountNumber + " " + (accountInfo2 != null ? accountInfo2.getNumber() : null));
        Toolbar toolbar = binding.toolbar;
        ServiceAccountInfo accountInfo3 = data.getAccountInfo();
        toolbar.setTitle(accountInfo3 != null ? accountInfo3.getNumber() : null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new IntercomPaymentFragment$renderUi$1$1(this, data, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void handleLoading(com.sputnik.service_payments.ui.ServicePaymentsViewState r5) {
        /*
            r4 = this;
            com.sputnik.domain.common.Resource$Status r0 = r5.getServerStatePayments()
            com.sputnik.domain.common.Resource$Status r1 = com.sputnik.domain.common.Resource.Status.NONE
            r2 = 1
            if (r0 == r1) goto L20
            com.sputnik.domain.common.Resource$Status r0 = r5.getServerStateAccountInfo()
            if (r0 == r1) goto L20
            com.sputnik.domain.common.Resource$Status r0 = r5.getServerStatePayments()
            com.sputnik.domain.common.Resource$Status r1 = com.sputnik.domain.common.Resource.Status.LOADING
            if (r0 == r1) goto L20
            com.sputnik.domain.common.Resource$Status r5 = r5.getServerStateAccountInfo()
            if (r5 != r1) goto L1e
            goto L20
        L1e:
            r5 = 0
            goto L21
        L20:
            r5 = r2
        L21:
            com.sputnik.service_payments.databinding.FragmentIntercomPaymentBinding r0 = r4.getBinding()
            android.widget.ProgressBar r1 = r0.pbLoader
            java.lang.String r3 = "pbLoader"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(r1, r3)
            androidx.core.widget.NestedScrollView r0 = r0.layoutScroll
            java.lang.String r1 = "layoutScroll"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r5 ^ r2
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment.handleLoading(com.sputnik.service_payments.ui.ServicePaymentsViewState):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPayments(PaymentsViewState state) throws Resources.NotFoundException {
        AlertLocale alert;
        AlertData commonError;
        AlertLocale alert2;
        AlertData commonError2;
        FragmentIntercomPaymentBinding binding = getBinding();
        if (state.isPayed().peekContent().booleanValue()) {
            getAnalytics().trackLogEvent(new ServicePaymentsEvents.SuccessServPayment());
            getPaymentsViewModel().clearPaymentState();
            getServicePaymentsViewModel().clearDebt();
            getServicePaymentsViewModel().getServicePayments();
            getServicePaymentsViewModel().getServiceAccountInfo();
            IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.fragmentPayments;
            int i2 = R$id.action_fragmentPayments_to_fragmentSuccessPayment;
            Pair pair = TuplesKt.to(RemoteMessageConst.FROM, 2000);
            PaymentHistory payment = getServicePaymentsViewModel().getCurrentState().getPayment();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, i2, BundleKt.bundleOf(pair, TuplesKt.to("accrual_uuid", payment != null ? payment.getId() : null)), null, 8, null);
        } else {
            if (state.isCanceled().peekContent().booleanValue()) {
                getAnalytics().trackLogEvent(new ServicePaymentsEvents.FailServPayment());
                ProgressBar pbLoader = binding.pbLoader;
                Intrinsics.checkNotNullExpressionValue(pbLoader, "pbLoader");
                ViewKt.gone(pbLoader);
                ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
                LocalizationLocalModel data = getLocalizationStorage().getData();
                if (data != null && (alert2 = data.getAlert()) != null && (commonError2 = alert2.getCommonError()) != null) {
                    body = commonError2.getBody();
                }
                servicePaymentsViewModel.notifyErrorMessage(body);
                getPaymentsViewModel().clearPaymentState();
                return;
            }
            IntercomPaymentState state3ds = state.getState3ds();
            int i3 = state3ds == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state3ds.ordinal()];
            if (i3 == 1) {
                ProgressBar pbLoader2 = binding.pbLoader;
                Intrinsics.checkNotNullExpressionValue(pbLoader2, "pbLoader");
                ViewKt.visible(pbLoader2);
            } else if (i3 == 2) {
                ProgressBar pbLoader3 = binding.pbLoader;
                Intrinsics.checkNotNullExpressionValue(pbLoader3, "pbLoader");
                ViewKt.gone(pbLoader3);
            } else if (i3 == 3) {
                ProgressBar pbLoader4 = binding.pbLoader;
                Intrinsics.checkNotNullExpressionValue(pbLoader4, "pbLoader");
                ViewKt.gone(pbLoader4);
                PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
                LocalizationLocalModel data2 = getLocalizationStorage().getData();
                if (data2 != null && (alert = data2.getAlert()) != null && (commonError = alert.getCommonError()) != null) {
                    body = commonError.getBody();
                }
                paymentsViewModel.notifyErrorMessage(body);
                getPaymentsViewModel().clearPaymentState();
            } else {
                ProgressBar pbLoader5 = binding.pbLoader;
                Intrinsics.checkNotNullExpressionValue(pbLoader5, "pbLoader");
                ViewKt.gone(pbLoader5);
            }
        }
        ProgressBar pbLoader6 = binding.pbLoader;
        Intrinsics.checkNotNullExpressionValue(pbLoader6, "pbLoader");
        ViewBindingUtilsKt.visibilityBasedOn(pbLoader6, Boolean.valueOf(state.getServerState() == Resource.Status.LOADING));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render3ds(Event<Boolean> data) {
        String url3ds;
        if (data.getContentIfNotHandled() == null || (url3ds = getPaymentsViewModel().getCurrentState().getUrl3ds()) == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.start3dsPaymentTokenResult;
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        activityResultLauncher.launch(paymentsViewModel.getConfirmationIntent(url3ds, contextRequireContext));
    }
}
