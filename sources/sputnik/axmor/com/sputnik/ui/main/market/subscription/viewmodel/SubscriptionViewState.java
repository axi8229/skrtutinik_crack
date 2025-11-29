package sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.card.PaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* compiled from: SubscriptionViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010Jl\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u0004\u0010\u001cR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u0005\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001f\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0014R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Event;", "", "isPayed", "isCanceled", "", "tariffIndex", "need3ds", "", "url3ds", "Lcom/sputnik/domain/entities/card/PaymentState;", "state3ds", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "paymentMethod", "<init>", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;ILcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/card/PaymentState;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)V", "copy", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;ILcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/card/PaymentState;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "I", "getTariffIndex", "getNeed3ds", "Ljava/lang/String;", "getUrl3ds", "Lcom/sputnik/domain/entities/card/PaymentState;", "getState3ds", "()Lcom/sputnik/domain/entities/card/PaymentState;", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "getPaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubscriptionViewState implements VMState {
    private final Event<Boolean> isCanceled;
    private final Event<Boolean> isPayed;
    private final Event<Boolean> need3ds;
    private final PaymentMethodType paymentMethod;
    private final PaymentState state3ds;
    private final int tariffIndex;
    private final String url3ds;

    public SubscriptionViewState() {
        this(null, null, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SubscriptionViewState copy$default(SubscriptionViewState subscriptionViewState, Event event, Event event2, int i, Event event3, String str, PaymentState paymentState, PaymentMethodType paymentMethodType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            event = subscriptionViewState.isPayed;
        }
        if ((i2 & 2) != 0) {
            event2 = subscriptionViewState.isCanceled;
        }
        Event event4 = event2;
        if ((i2 & 4) != 0) {
            i = subscriptionViewState.tariffIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            event3 = subscriptionViewState.need3ds;
        }
        Event event5 = event3;
        if ((i2 & 16) != 0) {
            str = subscriptionViewState.url3ds;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            paymentState = subscriptionViewState.state3ds;
        }
        PaymentState paymentState2 = paymentState;
        if ((i2 & 64) != 0) {
            paymentMethodType = subscriptionViewState.paymentMethod;
        }
        return subscriptionViewState.copy(event, event4, i3, event5, str2, paymentState2, paymentMethodType);
    }

    public final SubscriptionViewState copy(Event<Boolean> isPayed, Event<Boolean> isCanceled, int tariffIndex, Event<Boolean> need3ds, String url3ds, PaymentState state3ds, PaymentMethodType paymentMethod) {
        Intrinsics.checkNotNullParameter(isPayed, "isPayed");
        Intrinsics.checkNotNullParameter(isCanceled, "isCanceled");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        Intrinsics.checkNotNullParameter(state3ds, "state3ds");
        return new SubscriptionViewState(isPayed, isCanceled, tariffIndex, need3ds, url3ds, state3ds, paymentMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionViewState)) {
            return false;
        }
        SubscriptionViewState subscriptionViewState = (SubscriptionViewState) other;
        return Intrinsics.areEqual(this.isPayed, subscriptionViewState.isPayed) && Intrinsics.areEqual(this.isCanceled, subscriptionViewState.isCanceled) && this.tariffIndex == subscriptionViewState.tariffIndex && Intrinsics.areEqual(this.need3ds, subscriptionViewState.need3ds) && Intrinsics.areEqual(this.url3ds, subscriptionViewState.url3ds) && this.state3ds == subscriptionViewState.state3ds && this.paymentMethod == subscriptionViewState.paymentMethod;
    }

    public int hashCode() {
        int iHashCode = ((((((this.isPayed.hashCode() * 31) + this.isCanceled.hashCode()) * 31) + Integer.hashCode(this.tariffIndex)) * 31) + this.need3ds.hashCode()) * 31;
        String str = this.url3ds;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.state3ds.hashCode()) * 31;
        PaymentMethodType paymentMethodType = this.paymentMethod;
        return iHashCode2 + (paymentMethodType != null ? paymentMethodType.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionViewState(isPayed=" + this.isPayed + ", isCanceled=" + this.isCanceled + ", tariffIndex=" + this.tariffIndex + ", need3ds=" + this.need3ds + ", url3ds=" + this.url3ds + ", state3ds=" + this.state3ds + ", paymentMethod=" + this.paymentMethod + ")";
    }

    public SubscriptionViewState(Event<Boolean> isPayed, Event<Boolean> isCanceled, int i, Event<Boolean> need3ds, String str, PaymentState state3ds, PaymentMethodType paymentMethodType) {
        Intrinsics.checkNotNullParameter(isPayed, "isPayed");
        Intrinsics.checkNotNullParameter(isCanceled, "isCanceled");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        Intrinsics.checkNotNullParameter(state3ds, "state3ds");
        this.isPayed = isPayed;
        this.isCanceled = isCanceled;
        this.tariffIndex = i;
        this.need3ds = need3ds;
        this.url3ds = str;
        this.state3ds = state3ds;
        this.paymentMethod = paymentMethodType;
    }

    public /* synthetic */ SubscriptionViewState(Event event, Event event2, int i, Event event3, String str, PaymentState paymentState, PaymentMethodType paymentMethodType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Event(Boolean.FALSE) : event, (i2 & 2) != 0 ? new Event(Boolean.FALSE) : event2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new Event(Boolean.FALSE) : event3, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? PaymentState.f26new : paymentState, (i2 & 64) == 0 ? paymentMethodType : null);
    }

    public final Event<Boolean> isPayed() {
        return this.isPayed;
    }

    public final Event<Boolean> isCanceled() {
        return this.isCanceled;
    }

    public final int getTariffIndex() {
        return this.tariffIndex;
    }

    public final Event<Boolean> getNeed3ds() {
        return this.need3ds;
    }

    public final String getUrl3ds() {
        return this.url3ds;
    }

    public final PaymentMethodType getPaymentMethod() {
        return this.paymentMethod;
    }
}
