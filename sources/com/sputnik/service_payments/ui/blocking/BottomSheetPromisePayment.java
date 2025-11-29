package com.sputnik.service_payments.ui.blocking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
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
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.PromisePopupBody;
import com.sputnik.common.entities.localization.entities.blocking.PromisePopupLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
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
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.domain.usecases.service_payments.PromisePaymentStates;
import com.sputnik.service_payments.R$color;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.databinding.BottomSheetPromisePaymentsBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.PromisePayment;
import com.sputnik.service_payments.entities.payments.PromisedPayment;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;

/* compiled from: BottomSheetPromisePayment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010(\u001a\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u0010\u0012\f\u0012\n F*\u0004\u0018\u00010E0E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010I\u001a\u0010\u0012\f\u0012\n F*\u0004\u0018\u00010E0E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010H¨\u0006J"}, d2 = {"Lcom/sputnik/service_payments/ui/blocking/BottomSheetPromisePayment;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/service_payments/databinding/BottomSheetPromisePaymentsBinding;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "", "renderBlockingUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "state", "renderPayments", "(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel$delegate", "getPaymentsViewModel", "()Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "start3dsPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "startGetPaymentTokenResult", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetPromisePayment extends BaseBottomSheetDialogFragment<BottomSheetPromisePaymentsBinding> {
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

    /* compiled from: BottomSheetPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PromisePaymentStates.values().length];
            try {
                iArr[PromisePaymentStates.activated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IntercomPaymentState.values().length];
            try {
                iArr2[IntercomPaymentState.pending.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[IntercomPaymentState.succeeded.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[IntercomPaymentState.canceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: BottomSheetPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetPromisePaymentsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetPromisePaymentsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/service_payments/databinding/BottomSheetPromisePaymentsBinding;", 0);
        }

        public final BottomSheetPromisePaymentsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetPromisePaymentsBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetPromisePaymentsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ BottomSheetPromisePaymentsBinding access$getBinding(BottomSheetPromisePayment bottomSheetPromisePayment) {
        return bottomSheetPromisePayment.getBinding();
    }

    public BottomSheetPromisePayment() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.paymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$paymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetPromisePayment.start3dsPaymentTokenResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetPromisePayment.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
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

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
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
    public static final void start3dsPaymentTokenResult$lambda$0(BottomSheetPromisePayment this$0, ActivityResult result) {
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
    public static final void startGetPaymentTokenResult$lambda$2(BottomSheetPromisePayment this$0, ActivityResult result) {
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    /* compiled from: BottomSheetPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07761 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        C07761(Object obj) {
            super(1, obj, BottomSheetPromisePayment.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) throws Resources.NotFoundException {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetPromisePayment) this.receiver).renderBlockingUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner, new C07761(this));
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        paymentsViewModel.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment.onViewCreated.2
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
                BottomSheetPromisePayment bottomSheetPromisePayment = BottomSheetPromisePayment.this;
                ScrollView root = BottomSheetPromisePayment.access$getBinding(bottomSheetPromisePayment).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(bottomSheetPromisePayment, root, it);
            }
        });
        ServicePaymentsViewModel servicePaymentsViewModel2 = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment.onViewCreated.3
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
                BottomSheetPromisePayment bottomSheetPromisePayment = BottomSheetPromisePayment.this;
                ScrollView root = BottomSheetPromisePayment.access$getBinding(bottomSheetPromisePayment).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(bottomSheetPromisePayment, root, it);
            }
        });
        PaymentsViewModel paymentsViewModel2 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        paymentsViewModel2.observeState(viewLifecycleOwner4, new AnonymousClass4(this));
        PaymentsViewModel paymentsViewModel3 = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        paymentsViewModel3.observeSubState(viewLifecycleOwner5, new Function1<PaymentsViewState, Event<? extends Boolean>>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(PaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass6(this));
    }

    /* compiled from: BottomSheetPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<PaymentsViewState, Unit> {
        AnonymousClass4(Object obj) {
            super(1, obj, BottomSheetPromisePayment.class, "renderPayments", "renderPayments(Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentsViewState paymentsViewState) throws Resources.NotFoundException {
            invoke2(paymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentsViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetPromisePayment) this.receiver).renderPayments(p0);
        }
    }

    /* compiled from: BottomSheetPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, BottomSheetPromisePayment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetPromisePayment) this.receiver).render3ds(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetPromisePaymentsBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPromisePayment.initViews$lambda$5$lambda$3(this.f$0, view);
            }
        });
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPromisePayment.initViews$lambda$5$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$3(BottomSheetPromisePayment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getServicePaymentsViewModel().promisePayment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$4(final BottomSheetPromisePayment this$0, View view) {
        PaymentBottomSheet paymentBottomSheet;
        PaymentBottomSheet paymentBottomSheet2;
        String debt;
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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
        IPaymentsViewModel.DefaultImpls.handlePayment$default(paymentsViewModel, dDoubleValue, strValueOf, strValueOf2, contextRequireContext, new Function1<Intent, Unit>() { // from class: com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment$initViews$1$2$1
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

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle payButton;
        TextTitle useButton;
        TextWithParam body;
        TextWithParam body2;
        PromisePopupLocale promisePopup;
        BottomSheetPromisePaymentsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        PromisePopupBody body3 = (data == null || (promisePopup = data.getPromisePopup()) == null) ? null : promisePopup.getBody();
        binding.tvCancelTitle.setText(body3 != null ? body3.getTitle() : null);
        TextView textView = binding.tvDescription;
        String strValueOf = String.valueOf((body3 == null || (body2 = body3.getBody()) == null) ? null : body2.getText());
        String strValueOf2 = String.valueOf((body3 == null || (body = body3.getBody()) == null) ? null : body.getParam());
        Context context = getContext();
        if (context == null) {
            context = requireContext();
        }
        int color = ContextCompat.getColor(context, R$color.sputnik_header_black);
        Context context2 = getContext();
        if (context2 == null) {
            context2 = requireContext();
        }
        Context context3 = context2;
        Intrinsics.checkNotNull(context3);
        textView.setText(ViewUtilsKt.highlightText$default(strValueOf, strValueOf2, color, context3, 0, 16, null));
        binding.btnApply.setText((body3 == null || (useButton = body3.getUseButton()) == null) ? null : useButton.getTitle());
        AppCompatButton appCompatButton = binding.btnReject;
        if (body3 != null && (payButton = body3.getPayButton()) != null) {
            title = payButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) throws Resources.NotFoundException {
        PromisedPayment promisedPayment;
        getBinding();
        PromisePayment promisedPaymentInfo = servicePaymentsViewState.getPromisedPaymentInfo();
        PromisePaymentStates state = (promisedPaymentInfo == null || (promisedPayment = promisedPaymentInfo.getPromisedPayment()) == null) ? null : promisedPayment.getState();
        if ((state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) == 1) {
            getAnalytics().trackLogEvent(new ServicePaymentsEvents.SuccessPromiseBtnBlocked());
            dismiss();
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.promiseBottomSheet, R$id.action_promiseBottomSheet_to_promiseSuccessDialog, null, null, 12, null);
            return;
        }
        getAnalytics().trackLogEvent(new ServicePaymentsEvents.FailPromiseBtnBlocked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPayments(PaymentsViewState state) throws Resources.NotFoundException {
        AlertLocale alert;
        AlertData commonError;
        AlertLocale alert2;
        AlertData commonError2;
        PromisePopupLocale promisePopup;
        PromisePopupBody body;
        TextTitle useButton;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String strValueOf = String.valueOf((data == null || (promisePopup = data.getPromisePopup()) == null || (body = promisePopup.getBody()) == null || (useButton = body.getUseButton()) == null) ? null : useButton.getTitle());
        BottomSheetPromisePaymentsBinding binding = getBinding();
        if (state.isPayed().peekContent().booleanValue()) {
            getAnalytics().trackLogEvent(new ServicePaymentsEvents.SuccessServPayment());
            getPaymentsViewModel().clearPaymentState();
            getServicePaymentsViewModel().clearDebt();
            getServicePaymentsViewModel().getServicePayments();
            getServicePaymentsViewModel().getServiceAccountInfo();
            IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.promiseBottomSheet;
            int i2 = R$id.action_promiseBottomSheet_to_fragmentSuccessPayment;
            Pair pair = TuplesKt.to(RemoteMessageConst.FROM, 1000);
            PaymentHistory payment = getServicePaymentsViewModel().getCurrentState().getPayment();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, i2, BundleKt.bundleOf(pair, TuplesKt.to("accrual_uuid", payment != null ? payment.getId() : null)), null, 8, null);
        } else {
            if (state.isCanceled().peekContent().booleanValue()) {
                getAnalytics().trackLogEvent(new ServicePaymentsEvents.FailServPayment());
                AppCompatButton btnApply = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply, strValueOf);
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
            int i3 = state3ds == null ? -1 : WhenMappings.$EnumSwitchMapping$1[state3ds.ordinal()];
            if (i3 == 1) {
                AppCompatButton btnApply2 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply2, strValueOf);
            } else if (i3 == 2) {
                AppCompatButton btnApply3 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply3, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply3, strValueOf);
            } else if (i3 == 3) {
                AppCompatButton btnApply4 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply4, "btnApply");
                ButtonsExtensionsKt.hideProgress(btnApply4, strValueOf);
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
                ButtonsExtensionsKt.hideProgress(btnApply5, strValueOf);
            }
        }
        AppCompatButton btnApply6 = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply6, "btnApply");
        ViewBindingUtilsKt.showProgressBasedOn$default(btnApply6, state.getServerState() == Resource.Status.LOADING, strValueOf, 0, false, 12, null);
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
