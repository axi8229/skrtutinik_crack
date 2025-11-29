package com.sputnik.service_payments.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.payments.YoomoneyPaymentsModule;
import com.sputnik.common.viewmodels.interfaces.IPaymentsViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.service_payments.DomainIntercomPaymentInfo;
import com.sputnik.domain.entities.service_payments.DomainPaymentItem;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavePaymentMethod;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* compiled from: PaymentsViewModel.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJS\u0010(\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0019¢\u0006\u0004\b,\u0010-J\u001d\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b/\u00100R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00101R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u00104R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00105R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00106¨\u00067"}, d2 = {"Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "Lcom/sputnik/common/viewmodels/interfaces/IPaymentsViewModel;", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefs", "Lcom/sputnik/domain/usecases/service_payments/PayIntercomUseCase;", "payIntercomUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetPaymentStatusUseCase;", "getPaymentStatusUseCase", "<init>", "(Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/service_payments/PayIntercomUseCase;Lcom/sputnik/domain/usecases/service_payments/GetPaymentStatusUseCase;)V", "", "uuid", "paymentToken", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/service_payments/DomainIntercomPaymentInfo;", "payIntercomOnServer", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentItem;", "getPaymentStatusFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "pay", "(Ljava/lang/String;Ljava/lang/String;)V", "", "amount", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Landroid/content/Intent;", "callback", "currencyString", "", "formColor", "handlePayment", "(DLjava/lang/String;Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Ljava/lang/String;I)V", "getCurrentState", "(Ljava/lang/String;)V", "clearPaymentState", "()V", "url", "getConfirmationIntent", "(Ljava/lang/String;Landroid/content/Context;)Landroid/content/Intent;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "getPrefs", "()Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/service_payments/PayIntercomUseCase;", "Lcom/sputnik/domain/usecases/service_payments/GetPaymentStatusUseCase;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PaymentsViewModel extends BaseViewModel<PaymentsViewState> implements IPaymentsViewModel {
    private final IConfig config;
    private final GetPaymentStatusUseCase getPaymentStatusUseCase;
    private final PayIntercomUseCase payIntercomUseCase;
    private final PrefManager prefs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentsViewModel(IConfig config, PrefManager prefs, PayIntercomUseCase payIntercomUseCase, GetPaymentStatusUseCase getPaymentStatusUseCase) {
        super(new PaymentsViewState(null, null, null, null, null, null, null, 127, null), Reflection.getOrCreateKotlinClass(PaymentsViewModel.class).toString());
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(payIntercomUseCase, "payIntercomUseCase");
        Intrinsics.checkNotNullParameter(getPaymentStatusUseCase, "getPaymentStatusUseCase");
        this.config = config;
        this.prefs = prefs;
        this.payIntercomUseCase = payIntercomUseCase;
        this.getPaymentStatusUseCase = getPaymentStatusUseCase;
    }

    private final LiveData<Resource<DomainIntercomPaymentInfo>> payIntercomOnServer(String uuid, String paymentToken) {
        return FlowLiveDataConversions.asLiveData$default(this.payIntercomUseCase.invoke(uuid, paymentToken), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPaymentItem>> getPaymentStatusFromServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.getPaymentStatusUseCase.invoke(uuid), null, 0L, 3, null);
    }

    public void pay(String uuid, String paymentToken) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        clearPaymentState();
        PaymentsViewState paymentsViewStateCopy$default = PaymentsViewState.copy$default(getCurrentState(), Resource.Status.LOADING, new Event(Boolean.FALSE), null, null, null, IntercomPaymentState.pending, null, 92, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PaymentsViewModel$pay$$inlined$updateState$1(paymentsViewStateCopy$default, this, null), 3, null);
        getState().setValue(paymentsViewStateCopy$default);
        subscribeOnDataSource(payIntercomOnServer(uuid, paymentToken), new Function2<Resource<? extends DomainIntercomPaymentInfo>, PaymentsViewState, PaymentsViewState>() { // from class: com.sputnik.service_payments.viewmodel.PaymentsViewModel.pay.2

            /* compiled from: PaymentsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.service_payments.viewmodel.PaymentsViewModel$pay$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PaymentsViewState invoke(Resource<? extends DomainIntercomPaymentInfo> resource, PaymentsViewState paymentsViewState) {
                return invoke2((Resource<DomainIntercomPaymentInfo>) resource, paymentsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final PaymentsViewState invoke2(Resource<DomainIntercomPaymentInfo> serverData, PaymentsViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return PaymentsViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, IntercomPaymentState.pending, null, 94, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        PaymentsViewModel.this.notifyErrorMessage(message);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        PaymentsViewModel paymentsViewModel = PaymentsViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        paymentsViewModel.notifySimpleError(error);
                    }
                    return PaymentsViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, null, 126, null);
                }
                if (i == 4) {
                    DomainIntercomPaymentInfo data = serverData.getData();
                    Intrinsics.checkNotNull(data);
                    if (data.getState() == IntercomPaymentState.canceled) {
                        return PaymentsViewState.copy$default(state, null, new Event(Boolean.FALSE), new Event(Boolean.TRUE), null, null, null, null, 121, null);
                    }
                    DomainIntercomPaymentInfo data2 = serverData.getData();
                    Intrinsics.checkNotNull(data2);
                    if (data2.getConfirmation() == null) {
                        DomainIntercomPaymentInfo data3 = serverData.getData();
                        Intrinsics.checkNotNull(data3);
                        return PaymentsViewState.copy$default(state, null, new Event(Boolean.TRUE), null, null, null, null, data3.getUuid(), 61, null);
                    }
                    DomainIntercomPaymentInfo data4 = serverData.getData();
                    Intrinsics.checkNotNull(data4);
                    String uuid2 = data4.getUuid();
                    Event event = new Event(Boolean.TRUE);
                    DomainIntercomPaymentInfo data5 = serverData.getData();
                    Intrinsics.checkNotNull(data5);
                    String confirmation = data5.getConfirmation();
                    DomainIntercomPaymentInfo data6 = serverData.getData();
                    Intrinsics.checkNotNull(data6);
                    return PaymentsViewState.copy$default(state, null, null, null, event, confirmation, data6.getState(), uuid2, 7, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public final void clearPaymentState() {
        PaymentsViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        Boolean bool = Boolean.FALSE;
        PaymentsViewState paymentsViewStateCopy = currentState.copy(status, new Event<>(bool), new Event<>(bool), new Event<>(bool), null, IntercomPaymentState.none, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PaymentsViewModel$clearPaymentState$$inlined$updateState$1(paymentsViewStateCopy, this, null), 3, null);
        getState().setValue(paymentsViewStateCopy);
    }

    @Override // com.sputnik.common.viewmodels.interfaces.IPaymentsViewModel
    public void handlePayment(double amount, String title, String subtitle, Context context, Function1<? super Intent, Unit> callback, String currencyString, int formColor) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(currencyString, "currencyString");
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(amount));
        Currency currency = Currency.getInstance(currencyString);
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        callback.invoke(Checkout.createTokenizeIntent(context, new PaymentParameters(new Amount(bigDecimal, currency), title, subtitle, "live_NjM1NTgwZEOnFT_k1s3U0puSjPvaYOIlYvL15lxO2nA", "635580", SavePaymentMethod.ON, SetsKt.setOf((Object[]) new PaymentMethodType[]{PaymentMethodType.BANK_CARD, PaymentMethodType.SBERBANK}), null, null, null, null, null, null, 8064, null), new TestParameters(true, false, null, null, null, 28, null), new UiParameters(false, new ColorScheme(formColor))));
    }

    public void getCurrentState(final String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        subscribeOnDataSource(getPaymentStatusFromServer(uuid), new Function2<Resource<? extends DomainPaymentItem>, PaymentsViewState, PaymentsViewState>() { // from class: com.sputnik.service_payments.viewmodel.PaymentsViewModel.getCurrentState.1

            /* compiled from: PaymentsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.service_payments.viewmodel.PaymentsViewModel$getCurrentState$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
                    int[] iArr2 = new int[Resource.Status.values().length];
                    try {
                        iArr2[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr2[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr2[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused7) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PaymentsViewState invoke(Resource<? extends DomainPaymentItem> resource, PaymentsViewState paymentsViewState) {
                return invoke2((Resource<DomainPaymentItem>) resource, paymentsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final PaymentsViewState invoke2(Resource<DomainPaymentItem> serverData, PaymentsViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$1[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return PaymentsViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, null, 126, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        PaymentsViewModel.this.notifyErrorMessage(message);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        PaymentsViewModel paymentsViewModel = PaymentsViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        paymentsViewModel.notifySimpleError(error);
                    }
                    return null;
                }
                if (i == 4) {
                    DomainPaymentItem data = serverData.getData();
                    Intrinsics.checkNotNull(data);
                    IntercomPaymentState state2 = data.getState();
                    int i2 = state2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
                    if (i2 == 1) {
                        final PaymentsViewModel paymentsViewModel2 = PaymentsViewModel.this;
                        final String str = uuid;
                        BaseViewModel.delayRequestWithBlocking$default(paymentsViewModel2, YooProfilerImpl.TIMER_LIMIT, null, 0L, new Function0<Unit>() { // from class: com.sputnik.service_payments.viewmodel.PaymentsViewModel.getCurrentState.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                paymentsViewModel2.getCurrentState(str);
                            }
                        }, 6, null);
                        DomainPaymentItem data2 = serverData.getData();
                        Intrinsics.checkNotNull(data2);
                        return PaymentsViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, data2.getState(), null, 94, null);
                    }
                    if (i2 == 2) {
                        DomainPaymentItem data3 = serverData.getData();
                        Intrinsics.checkNotNull(data3);
                        return PaymentsViewState.copy$default(state, null, new Event(Boolean.TRUE), null, null, null, data3.getState(), null, 93, null);
                    }
                    if (i2 == 3) {
                        DomainPaymentItem data4 = serverData.getData();
                        Intrinsics.checkNotNull(data4);
                        return PaymentsViewState.copy$default(state, null, new Event(Boolean.FALSE), null, null, null, data4.getState(), null, 93, null);
                    }
                    final PaymentsViewModel paymentsViewModel3 = PaymentsViewModel.this;
                    final String str2 = uuid;
                    BaseViewModel.delayRequestWithBlocking$default(paymentsViewModel3, 0L, null, 0L, new Function0<Unit>() { // from class: com.sputnik.service_payments.viewmodel.PaymentsViewModel.getCurrentState.1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            paymentsViewModel3.getCurrentState(str2);
                        }
                    }, 7, null);
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public final Intent getConfirmationIntent(String url, Context context) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        PaymentMethodType paymentMethodType = PaymentMethodType.BANK_CARD;
        YoomoneyPaymentsModule.Companion companion = YoomoneyPaymentsModule.INSTANCE;
        return Checkout.createConfirmationIntent$default(context, url, paymentMethodType, companion.getInstance().getClientApplicationKey(this.prefs, false), companion.getInstance().getShopId(this.prefs, false), null, null, 96, null);
    }
}
