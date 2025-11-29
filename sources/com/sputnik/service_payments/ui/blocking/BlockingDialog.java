package com.sputnik.service_payments.ui.blocking;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
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
import androidx.viewbinding.ViewBinding;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.DebtPopupBody;
import com.sputnik.common.entities.localization.entities.blocking.DebtPopupLocale;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.utils.WindowUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.interfaces.IPaymentsViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.service_payments.R$color;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.FragmentBlockingDebtBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PartnerInfo;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewState;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;

/* compiled from: BlockingDialog.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010M\u001a\u0010\u0012\f\u0012\n L*\u0004\u0018\u00010K0K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010O\u001a\u0010\u0012\f\u0012\n L*\u0004\u0018\u00010K0K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010S\u001a\u00020P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Lcom/sputnik/service_payments/ui/blocking/BlockingDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "initView", "localize", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "renderBlockingUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "state", "renderPayments", "(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel$delegate", "getPaymentsViewModel", "()Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "start3dsPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "startGetPaymentTokenResult", "Lcom/sputnik/service_payments/databinding/FragmentBlockingDebtBinding;", "getBinding", "()Lcom/sputnik/service_payments/databinding/FragmentBlockingDebtBinding;", "binding", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlockingDialog extends DialogFragment {
    private ViewBinding _binding;
    public Analytics analytics;
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

    /* compiled from: BlockingDialog.kt */
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
    public final FragmentBlockingDebtBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.sputnik.service_payments.databinding.FragmentBlockingDebtBinding");
        return (FragmentBlockingDebtBinding) viewBinding;
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

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$0(BlockingDialog this$0, ActivityResult result) {
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
    public static final void startGetPaymentTokenResult$lambda$2(BlockingDialog this$0, ActivityResult result) {
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
            this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickContinueButtonLimitPopupEvent());
            PaymentsViewModel paymentsViewModel = this$0.getPaymentsViewModel();
            ServiceAccountInfo accountInfo = this$0.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
            paymentsViewModel.pay(String.valueOf(accountInfo != null ? accountInfo.getAccrualUuid() : null), tokenizationResultCreateTokenizationResult.getPaymentToken());
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = FragmentBlockingDebtBinding.inflate(getLayoutInflater(), null, false);
        getAnalytics().trackLogEvent(new ServicePaymentsEvents.ViewLimitedPopupEvent());
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(getBinding().getRoot()).create();
        if (alertDialogCreate != null && alertDialogCreate.getWindow() != null) {
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowUtilsKt.requestFeatureSafe(window2, 1);
        }
        alertDialogCreate.setCanceledOnTouchOutside(false);
        localize();
        initView();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* compiled from: BlockingDialog.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingDialog$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, BlockingDialog.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingDialog) this.receiver).renderBlockingUi(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
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
        servicePaymentsViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog.onViewCreated.2
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
                BlockingDialog blockingDialog = BlockingDialog.this;
                ScrollView root = blockingDialog.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(blockingDialog, root, it);
            }
        });
        ServicePaymentsViewModel servicePaymentsViewModel3 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel3.observeState(viewLifecycleOwner3, new AnonymousClass3(this));
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        paymentsViewModel.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog.onViewCreated.4
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
                BlockingDialog blockingDialog = BlockingDialog.this;
                ScrollView root = blockingDialog.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(blockingDialog, root, it);
            }
        });
        PaymentsViewModel paymentsViewModel2 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        paymentsViewModel2.observeState(viewLifecycleOwner5, new AnonymousClass5(this));
        PaymentsViewModel paymentsViewModel3 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        paymentsViewModel3.observeSubState(viewLifecycleOwner6, new Function1<PaymentsViewState, Event<? extends Boolean>>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(PaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass7(this));
        getAnalytics().trackLogEvent(new ServicePaymentsEvents.ViewBlockedEvent());
    }

    /* compiled from: BlockingDialog.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingDialog$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, BlockingDialog.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingDialog) this.receiver).renderBlockingUi(p0);
        }
    }

    /* compiled from: BlockingDialog.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingDialog$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<PaymentsViewState, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, BlockingDialog.class, "renderPayments", "renderPayments(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentsViewState paymentsViewState) throws Resources.NotFoundException {
            invoke2(paymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingDialog) this.receiver).renderPayments(p0);
        }
    }

    /* compiled from: BlockingDialog.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BlockingDialog$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, BlockingDialog.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BlockingDialog) this.receiver).render3ds(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void initView() {
        FragmentBlockingDebtBinding binding = getBinding();
        binding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlockingDialog.initView$lambda$7$lambda$4(this.f$0, view);
            }
        });
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$initView$1$2
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
                String debt;
                Double doubleOrNull;
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickPaymentButtonLimitPopupEvent());
                PaymentsViewModel paymentsViewModel = this.this$0.getPaymentsViewModel();
                ServiceAccountInfo accountInfo = this.this$0.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
                double dDoubleValue = (accountInfo == null || (debt = accountInfo.getDebt()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(debt)) == null) ? ConfigValue.DOUBLE_DEFAULT_VALUE : doubleOrNull.doubleValue();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                String subtitle = null;
                String strValueOf = String.valueOf((data == null || (paymentBottomSheet2 = data.getPaymentBottomSheet()) == null) ? null : paymentBottomSheet2.getTitle());
                LocalizationLocalModel data2 = this.this$0.getLocalizationStorage().getData();
                if (data2 != null && (paymentBottomSheet = data2.getPaymentBottomSheet()) != null) {
                    subtitle = paymentBottomSheet.getSubtitle();
                }
                String strValueOf2 = String.valueOf(subtitle);
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                final BlockingDialog blockingDialog = this.this$0;
                IPaymentsViewModel.DefaultImpls.handlePayment$default(paymentsViewModel, dDoubleValue, strValueOf, strValueOf2, contextRequireContext, new Function1<Intent, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$initView$1$2.1
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
                        blockingDialog.startGetPaymentTokenResult.launch(it2);
                    }
                }, null, ContextCompat.getColor(this.this$0.requireContext(), R$color.sputnik_blue), 32, null);
            }
        }, 1, null);
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                BlockingDialog.initView$lambda$7$lambda$5(this.f$0, view);
            }
        });
        binding.tvAction.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                BlockingDialog.initView$lambda$7$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$4(BlockingDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickCloseBtnLimitPopupEvent());
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5(BlockingDialog this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickPromiseButtonBlockedEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.blockingDialog, R$id.action_blockingDialog_to_promiseBottomSheet, null, null, 12, null);
    }

    public BlockingDialog() {
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.paymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$paymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BlockingDialog.start3dsPaymentTokenResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BlockingDialog$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BlockingDialog.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(BlockingDialog this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickDisputeButtonEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.blockingDialog, R$id.action_blockingDialog_to_blocking_argue_debt, null, null, 12, null);
    }

    private final void localize() {
        DebtPopupLocale debtPopup;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        DebtPopupBody body = (data == null || (debtPopup = data.getDebtPopup()) == null) ? null : debtPopup.getBody();
        Intrinsics.checkNotNull(body);
        FragmentBlockingDebtBinding binding = getBinding();
        binding.tvNotice.setText(body.getTitle());
        binding.tvPaymentTitle.setText(body.getPayTitleLabel());
        binding.tvPartnerTitle.setText(body.getPartnerTitleLabel());
        binding.tvAction.setText(body.getArgueButton().getTitle());
        binding.btnApply.setText(body.getPayButton().getTitle());
        binding.btnReject.setText(body.getPromiseButton().getTitle());
        TextView textView = binding.tvPrice;
        ServiceAccountInfo accountInfo = getServicePaymentsViewModel().getCurrentState().getAccountInfo();
        textView.setText(accountInfo != null ? accountInfo.getDebtAsString() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) {
        String apartment;
        PartnerInfo partner;
        DebtPopupLocale debtPopup;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        Integer numValueOf = null;
        DebtPopupBody body = (data == null || (debtPopup = data.getDebtPopup()) == null) ? null : debtPopup.getBody();
        Intrinsics.checkNotNull(body);
        FragmentBlockingDebtBinding binding = getBinding();
        TextView textView = binding.tvPrice;
        ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
        textView.setText(accountInfo != null ? accountInfo.getDebtAsString() : null);
        TextView textView2 = binding.tvPartnerName;
        ServiceAccountInfo accountInfo2 = servicePaymentsViewState.getAccountInfo();
        textView2.setText((accountInfo2 == null || (partner = accountInfo2.getPartner()) == null) ? null : partner.getOrganisation());
        TextView textView3 = binding.tvNotice;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String title = body.getTitle();
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        if (profile != null && (apartment = profile.getApartment()) != null) {
            numValueOf = Integer.valueOf(Integer.parseInt(apartment));
        }
        String str = String.format(title, Arrays.copyOf(new Object[]{numValueOf}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView3.setText(str);
        TextView tvOffer = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer, "tvOffer");
        ServiceAccountInfo accountInfo3 = servicePaymentsViewState.getAccountInfo();
        ViewBindingUtilsKt.visibilityBasedOn(tvOffer, Boolean.valueOf((accountInfo3 != null ? Intrinsics.areEqual(accountInfo3.getOfferAccepted(), Boolean.FALSE) : false) && !(servicePaymentsViewState.getPayment() == null && servicePaymentsViewState.getDebtPayment() == null)));
        TextView tvOffer2 = binding.tvOffer;
        Intrinsics.checkNotNullExpressionValue(tvOffer2, "tvOffer");
        ViewUtilsKt.highlightText(tvOffer2, String.valueOf(body.getOffer().getText()), new HighlightedText(String.valueOf(body.getOffer().getParam1()), ContextCompat.getColor(requireContext(), R$color.sputnik_blue), "https://api-mobile-gorod.sputnik.systems/sputnik_offer.pdf", null, 0, 0, 56, null));
        AppCompatButton btnReject = binding.btnReject;
        Intrinsics.checkNotNullExpressionValue(btnReject, "btnReject");
        ServiceAccountInfo accountInfo4 = servicePaymentsViewState.getAccountInfo();
        ViewBindingUtilsKt.visibilityBasedOn(btnReject, Boolean.valueOf((accountInfo4 != null ? Intrinsics.areEqual(accountInfo4.getPromiseAvailable(), Boolean.TRUE) : false) && GlobalVariables.INSTANCE.getBlockLevel() == BlockingLevel.FULL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPayments(PaymentsViewState state) throws Resources.NotFoundException {
        AlertLocale alert;
        AlertData commonError;
        AlertLocale alert2;
        AlertData commonError2;
        DebtPopupLocale debtPopup;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        DebtPopupBody body = (data == null || (debtPopup = data.getDebtPopup()) == null) ? null : debtPopup.getBody();
        Intrinsics.checkNotNull(body);
        FragmentBlockingDebtBinding binding = getBinding();
        if (state.isPayed().peekContent().booleanValue()) {
            getAnalytics().trackLogEvent(new ServicePaymentsEvents.SuccessServPayment());
            getPaymentsViewModel().clearPaymentState();
            getServicePaymentsViewModel().clearDebt();
            getServicePaymentsViewModel().getServicePayments();
            getServicePaymentsViewModel().getServiceAccountInfo();
            IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.blockingDialog;
            int i2 = R$id.action_blockingDialog_to_fragmentSuccessPayment;
            PaymentHistory payment = getServicePaymentsViewModel().getCurrentState().getPayment();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, i2, BundleKt.bundleOf(TuplesKt.to("accrual_uuid", payment != null ? payment.getId() : null)), null, 8, null);
        } else {
            if (state.isCanceled().peekContent().booleanValue()) {
                getAnalytics().trackLogEvent(new ServicePaymentsEvents.FailServPayment());
                AppCompatButton btnApply = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply, String.valueOf(body.getPayButton().getTitle()));
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
                ButtonsExtensionsKt.hideProgress(btnApply2, String.valueOf(body.getPayButton().getTitle()));
            } else if (i3 == 2) {
                AppCompatButton btnApply3 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply3, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply3, String.valueOf(body.getPayButton().getTitle()));
            } else if (i3 == 3) {
                AppCompatButton btnApply4 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply4, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply4, String.valueOf(body.getPayButton().getTitle()));
                PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
                LocalizationLocalModel data3 = getLocalizationStorage().getData();
                if (data3 != null && (alert = data3.getAlert()) != null && (commonError = alert.getCommonError()) != null) {
                    body = commonError.getBody();
                }
                paymentsViewModel.notifyErrorMessage(body);
                getPaymentsViewModel().clearPaymentState();
            } else {
                AppCompatButton btnApply5 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply5, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply5, String.valueOf(body.getPayButton().getTitle()));
            }
        }
        AppCompatButton btnApply6 = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply6, "btnApply");
        ViewBindingUtilsKt.showProgressBasedOn$default(btnApply6, state.getServerState() == Resource.Status.LOADING, String.valueOf(body.getPayButton().getTitle()), 0, false, 12, null);
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
