package com.sputnik.service_payments.ui.blocking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.BlockBody;
import com.sputnik.common.entities.localization.BlockMain;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.DebtPopupBody;
import com.sputnik.common.entities.localization.entities.blocking.DebtPopupLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.interfaces.IPaymentsViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.service_payments.R$color;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.FragmentPromiseBlockBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PartnerInfo;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewState;
import com.yandex.varioqub.config.model.ConfigValue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;

/* compiled from: BlockingPromiseBlockFragment.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0003R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010M\u001a\u0010\u0012\f\u0012\n L*\u0004\u0018\u00010K0K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010O\u001a\u0010\u0012\f\u0012\n L*\u0004\u0018\u00010K0K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010N¨\u0006P"}, d2 = {"Lcom/sputnik/service_payments/ui/blocking/BlockingPromiseBlockFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "", "renderBlockingUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", RemoteMessageConst.DATA, "handleLoading", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "state", "renderPayments", "(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", "Lcom/sputnik/domain/common/Event;", "", "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/service_payments/databinding/FragmentPromiseBlockBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/service_payments/databinding/FragmentPromiseBlockBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel$delegate", "getPaymentsViewModel", "()Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "start3dsPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "startGetPaymentTokenResult", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlockingPromiseBlockFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BlockingPromiseBlockFragment.class, "binding", "getBinding()Lcom/sputnik/service_payments/databinding/FragmentPromiseBlockBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: paymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paymentsViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;

    /* compiled from: BlockingPromiseBlockFragment.kt */
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
    public final FragmentPromiseBlockBinding getBinding() {
        return (FragmentPromiseBlockBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    private final PaymentsViewModel getPaymentsViewModel() {
        return (PaymentsViewModel) this.paymentsViewModel.getValue();
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
    public static final void start3dsPaymentTokenResult$lambda$0(BlockingPromiseBlockFragment this$0, ActivityResult result) {
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
    public static final void startGetPaymentTokenResult$lambda$2(BlockingPromiseBlockFragment this$0, ActivityResult result) {
        AlertLocale alert;
        AlertData commonError;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
            LogUtilsKt.writeLog("payment token", tokenizationResultCreateTokenizationResult.getPaymentToken());
            AppCompatButton btnApply = this$0.getBinding().btnApply;
            Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
            ButtonsExtensionsKt.showProgress$default(btnApply, 0, 1, null);
            PaymentsViewModel paymentsViewModel = this$0.getPaymentsViewModel();
            ServiceAccountInfo accountInfo = this$0.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
            paymentsViewModel.pay(String.valueOf(accountInfo != null ? accountInfo.getAccrualUuid() : null), tokenizationResultCreateTokenizationResult.getPaymentToken());
            return;
        }
        PaymentsViewModel paymentsViewModel2 = this$0.getPaymentsViewModel();
        LocalizationLocalModel data2 = this$0.getLocalizationStorage().getData();
        if (data2 != null && (alert = data2.getAlert()) != null && (commonError = alert.getCommonError()) != null) {
            body = commonError.getBody();
        }
        paymentsViewModel2.notifyErrorMessage(body);
        this$0.getPaymentsViewModel().clearPaymentState();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    /* compiled from: BlockingPromiseBlockFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, BlockingPromiseBlockFragment.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingPromiseBlockFragment) this.receiver).renderBlockingUi(p0);
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
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        paymentsViewModel.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment.onViewCreated.2
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
                BlockingPromiseBlockFragment blockingPromiseBlockFragment = BlockingPromiseBlockFragment.this;
                ScrollView root = blockingPromiseBlockFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(blockingPromiseBlockFragment, root, it);
            }
        });
        ServicePaymentsViewModel servicePaymentsViewModel2 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment.onViewCreated.3
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
                BlockingPromiseBlockFragment blockingPromiseBlockFragment = BlockingPromiseBlockFragment.this;
                ScrollView root = blockingPromiseBlockFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(blockingPromiseBlockFragment, root, it);
            }
        });
        PaymentsViewModel paymentsViewModel2 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        paymentsViewModel2.observeState(viewLifecycleOwner4, new AnonymousClass4(this));
        PaymentsViewModel paymentsViewModel3 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        paymentsViewModel3.observeSubState(viewLifecycleOwner5, new Function1<PaymentsViewState, Event<? extends Boolean>>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(PaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass6(this));
    }

    /* compiled from: BlockingPromiseBlockFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<PaymentsViewState, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, BlockingPromiseBlockFragment.class, "renderPayments", "renderPayments(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentsViewState paymentsViewState) throws Resources.NotFoundException {
            invoke2(paymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingPromiseBlockFragment) this.receiver).renderPayments(p0);
        }
    }

    /* compiled from: BlockingPromiseBlockFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, BlockingPromiseBlockFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingPromiseBlockFragment) this.receiver).render3ds(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentPromiseBlockBinding binding = getBinding();
        binding.tvAction.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                BlockingPromiseBlockFragment.initViews$lambda$6$lambda$3(this.f$0, view);
            }
        });
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlockingPromiseBlockFragment.initViews$lambda$6$lambda$4(this.f$0, view);
            }
        });
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                BlockingPromiseBlockFragment.initViews$lambda$6$lambda$5(this.f$0, view);
            }
        });
        ScrollView viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$3(BlockingPromiseBlockFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.promiseBlockFragment, R$id.action_promiseBlockFragment_to_blocking_argue_debt, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$4(final BlockingPromiseBlockFragment this$0, View view) {
        PaymentBottomSheet paymentBottomSheet;
        PaymentBottomSheet paymentBottomSheet2;
        String debt;
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickPaymentButtonBlockedEvent());
        PaymentsViewModel paymentsViewModel = this$0.getPaymentsViewModel();
        ServiceAccountInfo accountInfo = this$0.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
        double dDoubleValue = (accountInfo == null || (debt = accountInfo.getDebt()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(debt)) == null) ? ConfigValue.DOUBLE_DEFAULT_VALUE : doubleOrNull.doubleValue();
        LocalizationLocalModel data = this$0.getLocalizationStorage().getData();
        String subtitle = null;
        String strValueOf = String.valueOf((data == null || (paymentBottomSheet2 = data.getPaymentBottomSheet()) == null) ? null : paymentBottomSheet2.getTitle());
        LocalizationLocalModel data2 = this$0.getLocalizationStorage().getData();
        if (data2 != null && (paymentBottomSheet = data2.getPaymentBottomSheet()) != null) {
            subtitle = paymentBottomSheet.getSubtitle();
        }
        String strValueOf2 = String.valueOf(subtitle);
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        IPaymentsViewModel.DefaultImpls.handlePayment$default(paymentsViewModel, dDoubleValue, strValueOf, strValueOf2, contextRequireContext, new Function1<Intent, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$initViews$1$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.startGetPaymentTokenResult.launch(it);
            }
        }, null, ContextCompat.getColor(this$0.requireContext(), R$color.sputnik_blue), 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$5(BlockingPromiseBlockFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickUsePromiseButtonBlocked());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.promiseBlockFragment, R$id.action_promiseBlockFragment_to_promiseBottomSheet, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle promiseButton;
        TextTitle payButton;
        TextTitle argueButton;
        BlockMain blockMain;
        FragmentPromiseBlockBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        BlockBody body = (data == null || (blockMain = data.getBlockMain()) == null) ? null : blockMain.getBody();
        binding.tvDescription.setText(body != null ? body.getTitle() : null);
        binding.tvPartnerTitle.setText(body != null ? body.getPartnerTitleLabel() : null);
        binding.tvAction.setText((body == null || (argueButton = body.getArgueButton()) == null) ? null : argueButton.getTitle());
        binding.btnApply.setText((body == null || (payButton = body.getPayButton()) == null) ? null : payButton.getTitle());
        AppCompatButton appCompatButton = binding.btnReject;
        if (body != null && (promiseButton = body.getPromiseButton()) != null) {
            title = promiseButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) {
        TextWith1Param offer;
        TextWith1Param offer2;
        PartnerInfo partner;
        DebtPopupLocale debtPopup;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String param1 = null;
        DebtPopupBody body = (data == null || (debtPopup = data.getDebtPopup()) == null) ? null : debtPopup.getBody();
        FragmentPromiseBlockBinding binding = getBinding();
        handleLoading(servicePaymentsViewState);
        TextView textView = binding.tvPartnerName;
        ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
        textView.setText((accountInfo == null || (partner = accountInfo.getPartner()) == null) ? null : partner.getOrganisation());
        TextView textView2 = binding.tvPrice;
        ServiceAccountInfo accountInfo2 = servicePaymentsViewState.getAccountInfo();
        textView2.setText(accountInfo2 != null ? accountInfo2.getDebtAsString() : null);
        AppCompatButton btnReject = binding.btnReject;
        Intrinsics.checkNotNullExpressionValue(btnReject, "btnReject");
        ServiceAccountInfo accountInfo3 = servicePaymentsViewState.getAccountInfo();
        boolean z = false;
        ViewBindingUtilsKt.visibilityBasedOn(btnReject, Boolean.valueOf((accountInfo3 != null ? Intrinsics.areEqual(accountInfo3.getPromiseAvailable(), Boolean.TRUE) : false) && GlobalVariables.INSTANCE.getBlockLevel() == BlockingLevel.FULL));
        TextView tvOffer = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer, "tvOffer");
        ServiceAccountInfo accountInfo4 = servicePaymentsViewState.getAccountInfo();
        if ((accountInfo4 != null ? Intrinsics.areEqual(accountInfo4.getOfferAccepted(), Boolean.FALSE) : false) && (servicePaymentsViewState.getPayment() != null || servicePaymentsViewState.getDebtPayment() != null)) {
            z = true;
        }
        ViewBindingUtilsKt.visibilityBasedOn(tvOffer, Boolean.valueOf(z));
        TextView tvOffer2 = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer2, "tvOffer");
        String strValueOf = String.valueOf((body == null || (offer2 = body.getOffer()) == null) ? null : offer2.getText());
        if (body != null && (offer = body.getOffer()) != null) {
            param1 = offer.getParam1();
        }
        ViewUtilsKt.highlightText(tvOffer2, strValueOf, new HighlightedText(String.valueOf(param1), ContextCompat.getColor(requireContext(), R$color.sputnik_blue), "https://api-mobile-gorod.sputnik.systems/sputnik_offer.pdf", null, 0, 0, 56, null));
    }

    public BlockingPromiseBlockFragment() {
        super(R$layout.fragment_promise_block);
        this.binding = new ViewBindingFragmentDelegate(this, BlockingPromiseBlockFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.paymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$paymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BlockingPromiseBlockFragment.start3dsPaymentTokenResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BlockingPromiseBlockFragment.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    private final void handleLoading(ServicePaymentsViewState data) {
        FragmentPromiseBlockBinding binding = getBinding();
        boolean z = data.getServerStateAccountInfo() == Resource.Status.NONE || data.getServerStateAccountInfo() == Resource.Status.LOADING;
        LinearLayout layoutLoader = binding.layoutLoader;
        Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
        ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPayments(PaymentsViewState state) throws Resources.NotFoundException {
        TextTitle payButton;
        TextTitle payButton2;
        AlertLocale alert;
        AlertData commonError;
        TextTitle payButton3;
        TextTitle payButton4;
        AlertLocale alert2;
        AlertData commonError2;
        TextTitle payButton5;
        TextTitle payButton6;
        DebtPopupLocale debtPopup;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String body = null;
        DebtPopupBody body2 = (data == null || (debtPopup = data.getDebtPopup()) == null) ? null : debtPopup.getBody();
        FragmentPromiseBlockBinding binding = getBinding();
        if (state.isPayed().peekContent().booleanValue()) {
            getAnalytics().trackLogEvent(new ServicePaymentsEvents.SuccessServPayment());
            getServicePaymentsViewModel().clearDebt();
            getServicePaymentsViewModel().getServicePayments();
            getServicePaymentsViewModel().getServiceAccountInfo();
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.promiseBlockFragment;
            int i2 = R$id.action_promiseBlockFragment_to_fragmentSuccessPayment;
            Pair pair = TuplesKt.to(RemoteMessageConst.FROM, 1000);
            PaymentHistory payment = getServicePaymentsViewModel().getCurrentState().getPayment();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, i2, BundleKt.bundleOf(pair, TuplesKt.to("accrual_uuid", payment != null ? payment.getId() : null)), null, 8, null);
        } else {
            if (state.isCanceled().peekContent().booleanValue()) {
                getAnalytics().trackLogEvent(new ServicePaymentsEvents.FailServPayment());
                AppCompatButton btnApply = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply, String.valueOf((body2 == null || (payButton5 = body2.getPayButton()) == null) ? null : payButton5.getTitle()));
                ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
                LocalizationLocalModel data2 = getLocalizationStorage().getData();
                if (data2 != null && (alert2 = data2.getAlert()) != null && (commonError2 = alert2.getCommonError()) != null) {
                    body = commonError2.getBody();
                }
                servicePaymentsViewModel.notifyErrorMessage(body);
                getPaymentsViewModel().clearPaymentState();
                return;
            }
            IntercomPaymentState state3ds = state.getState3ds();
            int i3 = state3ds == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state3ds.ordinal()];
            if (i3 == 1) {
                AppCompatButton btnApply2 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply2, String.valueOf((body2 == null || (payButton = body2.getPayButton()) == null) ? null : payButton.getTitle()));
            } else if (i3 == 2) {
                AppCompatButton btnApply3 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply3, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply3, String.valueOf((body2 == null || (payButton2 = body2.getPayButton()) == null) ? null : payButton2.getTitle()));
            } else if (i3 == 3) {
                AppCompatButton btnApply4 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply4, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply4, String.valueOf((body2 == null || (payButton3 = body2.getPayButton()) == null) ? null : payButton3.getTitle()));
                PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
                LocalizationLocalModel data3 = getLocalizationStorage().getData();
                paymentsViewModel.notifyErrorMessage((data3 == null || (alert = data3.getAlert()) == null || (commonError = alert.getCommonError()) == null) ? null : commonError.getBody());
                getPaymentsViewModel().clearPaymentState();
            } else {
                AppCompatButton btnApply5 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply5, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply5, String.valueOf((body2 == null || (payButton4 = body2.getPayButton()) == null) ? null : payButton4.getTitle()));
            }
        }
        AppCompatButton btnApply6 = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply6, "btnApply");
        boolean z = state.getServerState() == Resource.Status.LOADING;
        if (body2 != null && (payButton6 = body2.getPayButton()) != null) {
            body = payButton6.getTitle();
        }
        ViewBindingUtilsKt.showProgressBasedOn$default(btnApply6, z, String.valueOf(body), 0, false, 12, null);
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
