package sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.payments.YoomoneyPaymentsModule;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainConfirmation;
import com.sputnik.domain.entities.card.DomainPaymentState;
import com.sputnik.domain.entities.card.PaymentState;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.card.AddNewCardUseCase;
import com.sputnik.domain.usecases.card.GetLastCardPaymentUseCase;
import com.sputnik.domain.usecases.card.RemoveCardUseCase;
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
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.viewmodels.ICardViewModel;

/* compiled from: CardViewModel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150\u0014H\u0002J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0014H\u0002J\u001c\u0010!\u001a\u00020\u000e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0#H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewState;", "Lsputnik/axmor/com/sputnik/viewmodels/ICardViewModel;", "prefs", "Lcom/sputnik/data/local/PrefManager;", "addNewCardUseCase", "Lcom/sputnik/domain/usecases/card/AddNewCardUseCase;", "removeCardUseCase", "Lcom/sputnik/domain/usecases/card/RemoveCardUseCase;", "getLastCardPaymentUSeCase", "Lcom/sputnik/domain/usecases/card/GetLastCardPaymentUseCase;", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/card/AddNewCardUseCase;Lcom/sputnik/domain/usecases/card/RemoveCardUseCase;Lcom/sputnik/domain/usecases/card/GetLastCardPaymentUseCase;)V", "addCard", "", "paymentToken", "", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "addNewCardToServer", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainConfirmation;", "deleteCard", "getConfirmationIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "url", "getCurrentState", "getLastCardPaymentFromServer", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "removeCardFromServer", "saveCard", "callback", "Lkotlin/Function1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardViewModel extends BaseViewModel<CardViewState> implements ICardViewModel {
    private final AddNewCardUseCase addNewCardUseCase;
    private final GetLastCardPaymentUseCase getLastCardPaymentUSeCase;
    private final PrefManager prefs;
    private final RemoveCardUseCase removeCardUseCase;

    /* compiled from: CardViewModel.kt */
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

    public CardViewModel(PrefManager prefs, AddNewCardUseCase addNewCardUseCase, RemoveCardUseCase removeCardUseCase, GetLastCardPaymentUseCase getLastCardPaymentUSeCase) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(addNewCardUseCase, "addNewCardUseCase");
        Intrinsics.checkNotNullParameter(removeCardUseCase, "removeCardUseCase");
        Intrinsics.checkNotNullParameter(getLastCardPaymentUSeCase, "getLastCardPaymentUSeCase");
        CardViewState cardViewState = new CardViewState(null, null, null, null, null, null, null, 127, null);
        String name = CardViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(cardViewState, name);
        this.prefs = prefs;
        this.addNewCardUseCase = addNewCardUseCase;
        this.removeCardUseCase = removeCardUseCase;
        this.getLastCardPaymentUSeCase = getLastCardPaymentUSeCase;
    }

    private final LiveData<Resource<DomainConfirmation>> addNewCardToServer(String paymentToken, String paymentMethodType) {
        return FlowLiveDataConversions.asLiveData$default(this.addNewCardUseCase.invoke(paymentToken, paymentMethodType), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> removeCardFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.removeCardUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPaymentState>> getLastCardPaymentFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getLastCardPaymentUSeCase.invoke(), null, 0L, 3, null);
    }

    @Override // sputnik.axmor.com.sputnik.viewmodels.ICardViewModel
    public void addCard(String paymentToken, PaymentMethodType paymentMethodType) {
        String str;
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        int i = paymentMethodType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[paymentMethodType.ordinal()];
        if (i != 1) {
            str = "bank_card";
            if (i != 2 && i == 3) {
                str = "sberbank";
            }
        } else {
            str = "sbp";
        }
        CardViewState cardViewStateCopy$default = CardViewState.copy$default(getCurrentState(), null, null, new Event(Boolean.FALSE), null, null, null, paymentMethodType, 59, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CardViewModel$addCard$$inlined$updateState$1(cardViewStateCopy$default, this, null), 3, null);
        getState().setValue(cardViewStateCopy$default);
        subscribeOnDataSource(addNewCardToServer(paymentToken, str), new Function2<Resource<? extends DomainConfirmation>, CardViewState, CardViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel.addCard.2

            /* compiled from: CardViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel$addCard$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ CardViewState invoke(Resource<? extends DomainConfirmation> resource, CardViewState cardViewState) {
                return invoke2((Resource<DomainConfirmation>) resource, cardViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CardViewState invoke2(Resource<DomainConfirmation> serverData, CardViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i2 = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                Unit unit = null;
                unit = null;
                if (i2 == 1 || i2 == 2) {
                    return null;
                }
                if (i2 == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        CardViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        CardViewModel cardViewModel = CardViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        cardViewModel.notifySimpleError(error);
                    }
                    return CardViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, null, 126, null);
                }
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainConfirmation data = serverData.getData();
                Intrinsics.checkNotNull(data);
                if (data.getConfirmationUrl() == null) {
                    CardViewModel cardViewModel2 = CardViewModel.this;
                    String string = SputnikApp.INSTANCE.applicationContext().getString(R.string.bank_card_save);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    cardViewModel2.notifySuccessMessage(string);
                    return CardViewState.copy$default(state, null, null, new Event(Boolean.TRUE), null, null, null, null, 123, null);
                }
                Event event = new Event(Boolean.TRUE);
                DomainConfirmation data2 = serverData.getData();
                return CardViewState.copy$default(state, Resource.Status.SUCCESS, null, null, event, data2 != null ? data2.getConfirmationUrl() : null, null, null, 102, null);
            }
        });
    }

    public void saveCard(Function1<? super Intent, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SputnikApp sputnikAppApplicationContext = SputnikApp.INSTANCE.applicationContext();
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(1L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        Currency currency = Currency.getInstance("RUB");
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        Amount amount = new Amount(bigDecimalValueOf, currency);
        String string = sputnikAppApplicationContext.getString(R.string.domofon_subscribe_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = sputnikAppApplicationContext.getString(R.string.bank_card_change_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        callback.invoke(Checkout.createTokenizeIntent$default(sputnikAppApplicationContext, new PaymentParameters(amount, string, string2, "live_NjM1NTgwZEOnFT_k1s3U0puSjPvaYOIlYvL15lxO2nA", "635580", SavePaymentMethod.ON, SetsKt.setOf((Object[]) new PaymentMethodType[]{PaymentMethodType.BANK_CARD, PaymentMethodType.SBERBANK, PaymentMethodType.SBP}), null, null, "+" + this.prefs.getPhone(), null, null, null, 7552, null), null, null, 12, null));
    }

    public void deleteCard() {
        CardViewState cardViewStateCopy$default = CardViewState.copy$default(getCurrentState(), null, new Event(Boolean.FALSE), null, null, null, null, null, 125, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CardViewModel$deleteCard$$inlined$updateState$1(cardViewStateCopy$default, this, null), 3, null);
        getState().setValue(cardViewStateCopy$default);
        subscribeOnDataSource(removeCardFromServer(), new Function2<Resource<? extends Unit>, CardViewState, CardViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel.deleteCard.2

            /* compiled from: CardViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel$deleteCard$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ CardViewState invoke(Resource<? extends Unit> resource, CardViewState cardViewState) {
                return invoke2((Resource<Unit>) resource, cardViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CardViewState invoke2(Resource<Unit> serverData, CardViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        CardViewModel cardViewModel = CardViewModel.this;
                        String string = SputnikApp.INSTANCE.applicationContext().getString(R.string.bank_card_deleted);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        cardViewModel.notifySuccessMessage(string);
                        return CardViewState.copy$default(state, null, new Event(Boolean.TRUE), null, null, null, null, null, 125, null);
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        CardViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        CardViewModel cardViewModel2 = CardViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        cardViewModel2.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void getCurrentState() {
        subscribeOnDataSource(getLastCardPaymentFromServer(), new Function2<Resource<? extends DomainPaymentState>, CardViewState, CardViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel.getCurrentState.1

            /* compiled from: CardViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel$getCurrentState$1$WhenMappings */
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
                        iArr[PaymentState.refunded.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[PaymentState.canceled.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[Resource.Status.values().length];
                    try {
                        iArr2[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr2[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr2[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr2[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused10) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CardViewState invoke(Resource<? extends DomainPaymentState> resource, CardViewState cardViewState) {
                return invoke2((Resource<DomainPaymentState>) resource, cardViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CardViewState invoke2(Resource<DomainPaymentState> serverData, CardViewState state) {
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
                            switch (WhenMappings.$EnumSwitchMapping$0[data.getState().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                    final CardViewModel cardViewModel = CardViewModel.this;
                                    BaseViewModel.delayRequest$default(cardViewModel, 0L, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel.getCurrentState.1.2
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
                                            cardViewModel.getCurrentState();
                                        }
                                    }, 1, null);
                                    DomainPaymentState data2 = serverData.getData();
                                    Intrinsics.checkNotNull(data2);
                                    return CardViewState.copy$default(state, null, null, null, null, null, data2.getState(), null, 95, null);
                                case 4:
                                case 5:
                                    DomainPaymentState data3 = serverData.getData();
                                    Intrinsics.checkNotNull(data3);
                                    return CardViewState.copy$default(state, null, null, new Event(Boolean.TRUE), null, null, data3.getState(), null, 91, null);
                                case 6:
                                    DomainPaymentState data4 = serverData.getData();
                                    Intrinsics.checkNotNull(data4);
                                    return CardViewState.copy$default(state, null, null, null, null, null, data4.getState(), null, 95, null);
                                default:
                                    return null;
                            }
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        CardViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        CardViewModel cardViewModel2 = CardViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        cardViewModel2.notifySimpleError(error);
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
