package sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.payments.YoomoneyPaymentsModule;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainPaymentState;
import com.sputnik.domain.entities.card.PaymentState;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionStart;
import com.sputnik.domain.usecases.subscription.GetLastCardPaymentUseCase;
import com.sputnik.domain.usecases.subscription.StartSubscriptionUseCase;
import com.sputnik.domain.usecases.subscription.StopSubscriptionUseCase;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavePaymentMethod;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.viewmodels.ISubscriptionViewModel;

/* compiled from: SubscriptionViewModel.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001fH\u0016J8\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u001b0\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u00122\b\u0010)\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b0\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u00122\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewState;", "Lsputnik/axmor/com/sputnik/viewmodels/ISubscriptionViewModel;", "prefs", "Lcom/sputnik/data/local/PrefManager;", "startSubscriptionUseCase", "Lcom/sputnik/domain/usecases/subscription/StartSubscriptionUseCase;", "getLastCardPaymentUseCase", "Lcom/sputnik/domain/usecases/subscription/GetLastCardPaymentUseCase;", "stopSubscriptionUseCase", "Lcom/sputnik/domain/usecases/subscription/StopSubscriptionUseCase;", "localization", "Lcom/sputnik/common/localization/LocalizationStorage;", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/subscription/StartSubscriptionUseCase;Lcom/sputnik/domain/usecases/subscription/GetLastCardPaymentUseCase;Lcom/sputnik/domain/usecases/subscription/StopSubscriptionUseCase;Lcom/sputnik/common/localization/LocalizationStorage;)V", "cancelSubscription", "", "id", "", "getConfirmationIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "url", "getCurrentState", "getLastCardPaymentFromServer", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "handleSubscribe", "price", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "callback", "Lkotlin/Function1;", "handleTariffIndex", "index", "startSubscriptionToServer", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionStart;", "plan", "paymentToken", "paymentMethod", "stopSubscriptionFromServer", "subscribe", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionViewModel extends BaseViewModel<SubscriptionViewState> implements ISubscriptionViewModel {
    private final GetLastCardPaymentUseCase getLastCardPaymentUseCase;
    private final LocalizationStorage localization;
    private final PrefManager prefs;
    private final StartSubscriptionUseCase startSubscriptionUseCase;
    private final StopSubscriptionUseCase stopSubscriptionUseCase;

    /* compiled from: SubscriptionViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethodType.values().length];
            try {
                iArr[PaymentMethodType.SBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentMethodType.BANK_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentMethodType.SBERBANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SubscriptionViewModel(PrefManager prefs, StartSubscriptionUseCase startSubscriptionUseCase, GetLastCardPaymentUseCase getLastCardPaymentUseCase, StopSubscriptionUseCase stopSubscriptionUseCase, LocalizationStorage localization) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(startSubscriptionUseCase, "startSubscriptionUseCase");
        Intrinsics.checkNotNullParameter(getLastCardPaymentUseCase, "getLastCardPaymentUseCase");
        Intrinsics.checkNotNullParameter(stopSubscriptionUseCase, "stopSubscriptionUseCase");
        Intrinsics.checkNotNullParameter(localization, "localization");
        SubscriptionViewState subscriptionViewState = new SubscriptionViewState(null, null, 0, null, null, null, null, 127, null);
        String name = SubscriptionViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(subscriptionViewState, name);
        this.prefs = prefs;
        this.startSubscriptionUseCase = startSubscriptionUseCase;
        this.getLastCardPaymentUseCase = getLastCardPaymentUseCase;
        this.stopSubscriptionUseCase = stopSubscriptionUseCase;
        this.localization = localization;
    }

    private final LiveData<Resource<DomainSubscriptionStart>> startSubscriptionToServer(String id, String plan, String paymentToken, String paymentMethod) {
        return FlowLiveDataConversions.asLiveData$default(this.startSubscriptionUseCase.invoke(id, plan, paymentToken, paymentMethod), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPaymentState>> getLastCardPaymentFromServer(String id) {
        return FlowLiveDataConversions.asLiveData$default(this.getLastCardPaymentUseCase.invoke(id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> stopSubscriptionFromServer(String id) {
        return FlowLiveDataConversions.asLiveData$default(this.stopSubscriptionUseCase.invoke(id), null, 0L, 3, null);
    }

    public void handleSubscribe(int price, String name, Function1<? super Intent, Unit> callback) {
        PaymentBottomSheet paymentBottomSheet;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SputnikApp sputnikAppApplicationContext = SputnikApp.INSTANCE.applicationContext();
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(price);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        Currency currency = Currency.getInstance("RUB");
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        Amount amount = new Amount(bigDecimalValueOf, currency);
        LocalizationLocalModel data = this.localization.getData();
        callback.invoke(Checkout.createTokenizeIntent$default(sputnikAppApplicationContext, new PaymentParameters(amount, String.valueOf((data == null || (paymentBottomSheet = data.getPaymentBottomSheet()) == null) ? null : paymentBottomSheet.getTitle()), name, "live_NjM1NTgwZEOnFT_k1s3U0puSjPvaYOIlYvL15lxO2nA", "635580", SavePaymentMethod.ON, SetsKt.setOf((Object[]) new PaymentMethodType[]{PaymentMethodType.BANK_CARD, PaymentMethodType.SBERBANK, PaymentMethodType.SBP}), null, null, "+" + this.prefs.getPhone(), null, null, null, 7552, null), null, null, 12, null));
    }

    public void handleTariffIndex(int index) {
        SubscriptionViewState subscriptionViewStateCopy$default = SubscriptionViewState.copy$default(getCurrentState(), null, null, index, null, null, null, null, 123, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SubscriptionViewModel$handleTariffIndex$$inlined$updateState$1(subscriptionViewStateCopy$default, this, null), 3, null);
        getState().setValue(subscriptionViewStateCopy$default);
    }

    @Override // sputnik.axmor.com.sputnik.viewmodels.ISubscriptionViewModel
    public void subscribe(String id, String plan, String paymentToken, PaymentMethodType paymentMethodType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(plan, "plan");
        String str = null;
        SubscriptionViewState subscriptionViewStateCopy$default = SubscriptionViewState.copy$default(getCurrentState(), new Event(Boolean.FALSE), null, 0, null, null, null, paymentMethodType, 62, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SubscriptionViewModel$subscribe$$inlined$updateState$1(subscriptionViewStateCopy$default, this, null), 3, null);
        getState().setValue(subscriptionViewStateCopy$default);
        int i = paymentMethodType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[paymentMethodType.ordinal()];
        if (i == 1) {
            str = "sbp";
        } else if (i == 2) {
            str = "bank_card";
        } else if (i == 3) {
            str = "sberbank";
        }
        subscribeOnDataSource(startSubscriptionToServer(id, plan, paymentToken, str), new Function2<Resource<? extends DomainSubscriptionStart>, SubscriptionViewState, SubscriptionViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel.subscribe.2

            /* compiled from: SubscriptionViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel$subscribe$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ SubscriptionViewState invoke(Resource<? extends DomainSubscriptionStart> resource, SubscriptionViewState subscriptionViewState) {
                return invoke2((Resource<DomainSubscriptionStart>) resource, subscriptionViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SubscriptionViewState invoke2(Resource<DomainSubscriptionStart> serverData, SubscriptionViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                Unit unit = null;
                if (i2 == 1 || i2 == 2) {
                    return null;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainSubscriptionStart data = serverData.getData();
                    Intrinsics.checkNotNull(data);
                    if (data.getConfirmationUrl() == null) {
                        return SubscriptionViewState.copy$default(state, new Event(Boolean.TRUE), null, 0, null, null, null, null, 126, null);
                    }
                    Event event = new Event(Boolean.TRUE);
                    DomainSubscriptionStart data2 = serverData.getData();
                    Intrinsics.checkNotNull(data2);
                    return SubscriptionViewState.copy$default(state, null, null, 0, event, data2.getConfirmationUrl(), null, null, 103, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    SubscriptionViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    SubscriptionViewModel subscriptionViewModel = SubscriptionViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    subscriptionViewModel.notifySimpleError(error);
                }
                return SubscriptionViewState.copy$default(state, new Event(Boolean.FALSE), null, 0, null, null, null, null, 126, null);
            }
        });
    }

    public void getCurrentState(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        subscribeOnDataSource(getLastCardPaymentFromServer(id), new Function2<Resource<? extends DomainPaymentState>, SubscriptionViewState, SubscriptionViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel.getCurrentState.1

            /* compiled from: SubscriptionViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel$getCurrentState$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[PaymentState.values().length];
                    try {
                        iArr[PaymentState.f26new.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PaymentState.pending.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PaymentState.waiting.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PaymentState.success.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[PaymentState.canceled.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[Resource.Status.values().length];
                    try {
                        iArr2[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr2[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr2[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr2[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused9) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ SubscriptionViewState invoke(Resource<? extends DomainPaymentState> resource, SubscriptionViewState subscriptionViewState) {
                return invoke2((Resource<DomainPaymentState>) resource, subscriptionViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SubscriptionViewState invoke2(Resource<DomainPaymentState> serverData, SubscriptionViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$1[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            DomainPaymentState data = serverData.getData();
                            Intrinsics.checkNotNull(data);
                            int i2 = WhenMappings.$EnumSwitchMapping$0[data.getState().ordinal()];
                            if (i2 == 1 || i2 == 2 || i2 == 3) {
                                final SubscriptionViewModel subscriptionViewModel = SubscriptionViewModel.this;
                                final String str = id;
                                BaseViewModel.delayRequest$default(subscriptionViewModel, 0L, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel.getCurrentState.1.2
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
                                        subscriptionViewModel.getCurrentState(str);
                                    }
                                }, 1, null);
                                DomainPaymentState data2 = serverData.getData();
                                Intrinsics.checkNotNull(data2);
                                return SubscriptionViewState.copy$default(state, null, null, 0, null, null, data2.getState(), null, 95, null);
                            }
                            if (i2 == 4) {
                                DomainPaymentState data3 = serverData.getData();
                                Intrinsics.checkNotNull(data3);
                                return SubscriptionViewState.copy$default(state, new Event(Boolean.TRUE), null, 0, null, null, data3.getState(), null, 94, null);
                            }
                            if (i2 != 5) {
                                return null;
                            }
                            DomainPaymentState data4 = serverData.getData();
                            Intrinsics.checkNotNull(data4);
                            return SubscriptionViewState.copy$default(state, null, null, 0, null, null, data4.getState(), null, 95, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        SubscriptionViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        SubscriptionViewModel subscriptionViewModel2 = SubscriptionViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        subscriptionViewModel2.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void cancelSubscription(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        subscribeOnDataSource(stopSubscriptionFromServer(id), new Function2<Resource<? extends Unit>, SubscriptionViewState, SubscriptionViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel.cancelSubscription.1

            /* compiled from: SubscriptionViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel$cancelSubscription$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ SubscriptionViewState invoke(Resource<? extends Unit> resource, SubscriptionViewState subscriptionViewState) {
                return invoke2((Resource<Unit>) resource, subscriptionViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SubscriptionViewState invoke2(Resource<Unit> serverData, SubscriptionViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return SubscriptionViewState.copy$default(state, null, new Event(Boolean.TRUE), 0, null, null, null, null, 125, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        SubscriptionViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        SubscriptionViewModel subscriptionViewModel = SubscriptionViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        subscriptionViewModel.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public final Intent getConfirmationIntent(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        PaymentMethodType paymentMethod = getCurrentState().getPaymentMethod();
        if (paymentMethod == null) {
            paymentMethod = PaymentMethodType.BANK_CARD;
        }
        PaymentMethodType paymentMethodType = paymentMethod;
        YoomoneyPaymentsModule.Companion companion = YoomoneyPaymentsModule.INSTANCE;
        return Checkout.createConfirmationIntent$default(context, url, paymentMethodType, companion.getInstance().getClientApplicationKey(this.prefs, false), companion.getInstance().getShopId(this.prefs, false), null, null, 96, null);
    }
}
