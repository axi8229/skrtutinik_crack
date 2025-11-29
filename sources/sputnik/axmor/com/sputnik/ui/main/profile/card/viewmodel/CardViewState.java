package sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.PaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* compiled from: CardViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010Jl\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b\u0006\u0010 R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b\u0007\u0010 R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b!\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010\u0014R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lcom/sputnik/domain/common/Event;", "", "isDeleted", "isUpdated", "need3ds", "", "url3ds", "Lcom/sputnik/domain/entities/card/PaymentState;", "state3ds", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "paymentMethod", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/card/PaymentState;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/card/PaymentState;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "getNeed3ds", "Ljava/lang/String;", "getUrl3ds", "Lcom/sputnik/domain/entities/card/PaymentState;", "getState3ds", "()Lcom/sputnik/domain/entities/card/PaymentState;", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "getPaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CardViewState implements VMState {
    private final Event<Boolean> isDeleted;
    private final Event<Boolean> isUpdated;
    private final Event<Boolean> need3ds;
    private final PaymentMethodType paymentMethod;
    private final Resource.Status serverState;
    private final PaymentState state3ds;
    private final String url3ds;

    public CardViewState() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CardViewState copy$default(CardViewState cardViewState, Resource.Status status, Event event, Event event2, Event event3, String str, PaymentState paymentState, PaymentMethodType paymentMethodType, int i, Object obj) {
        if ((i & 1) != 0) {
            status = cardViewState.serverState;
        }
        if ((i & 2) != 0) {
            event = cardViewState.isDeleted;
        }
        Event event4 = event;
        if ((i & 4) != 0) {
            event2 = cardViewState.isUpdated;
        }
        Event event5 = event2;
        if ((i & 8) != 0) {
            event3 = cardViewState.need3ds;
        }
        Event event6 = event3;
        if ((i & 16) != 0) {
            str = cardViewState.url3ds;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            paymentState = cardViewState.state3ds;
        }
        PaymentState paymentState2 = paymentState;
        if ((i & 64) != 0) {
            paymentMethodType = cardViewState.paymentMethod;
        }
        return cardViewState.copy(status, event4, event5, event6, str2, paymentState2, paymentMethodType);
    }

    public final CardViewState copy(Resource.Status serverState, Event<Boolean> isDeleted, Event<Boolean> isUpdated, Event<Boolean> need3ds, String url3ds, PaymentState state3ds, PaymentMethodType paymentMethod) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        Intrinsics.checkNotNullParameter(isUpdated, "isUpdated");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        Intrinsics.checkNotNullParameter(state3ds, "state3ds");
        return new CardViewState(serverState, isDeleted, isUpdated, need3ds, url3ds, state3ds, paymentMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardViewState)) {
            return false;
        }
        CardViewState cardViewState = (CardViewState) other;
        return this.serverState == cardViewState.serverState && Intrinsics.areEqual(this.isDeleted, cardViewState.isDeleted) && Intrinsics.areEqual(this.isUpdated, cardViewState.isUpdated) && Intrinsics.areEqual(this.need3ds, cardViewState.need3ds) && Intrinsics.areEqual(this.url3ds, cardViewState.url3ds) && this.state3ds == cardViewState.state3ds && this.paymentMethod == cardViewState.paymentMethod;
    }

    public int hashCode() {
        int iHashCode = ((((((this.serverState.hashCode() * 31) + this.isDeleted.hashCode()) * 31) + this.isUpdated.hashCode()) * 31) + this.need3ds.hashCode()) * 31;
        String str = this.url3ds;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.state3ds.hashCode()) * 31;
        PaymentMethodType paymentMethodType = this.paymentMethod;
        return iHashCode2 + (paymentMethodType != null ? paymentMethodType.hashCode() : 0);
    }

    public String toString() {
        return "CardViewState(serverState=" + this.serverState + ", isDeleted=" + this.isDeleted + ", isUpdated=" + this.isUpdated + ", need3ds=" + this.need3ds + ", url3ds=" + this.url3ds + ", state3ds=" + this.state3ds + ", paymentMethod=" + this.paymentMethod + ")";
    }

    public CardViewState(Resource.Status serverState, Event<Boolean> isDeleted, Event<Boolean> isUpdated, Event<Boolean> need3ds, String str, PaymentState state3ds, PaymentMethodType paymentMethodType) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        Intrinsics.checkNotNullParameter(isUpdated, "isUpdated");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        Intrinsics.checkNotNullParameter(state3ds, "state3ds");
        this.serverState = serverState;
        this.isDeleted = isDeleted;
        this.isUpdated = isUpdated;
        this.need3ds = need3ds;
        this.url3ds = str;
        this.state3ds = state3ds;
        this.paymentMethod = paymentMethodType;
    }

    public /* synthetic */ CardViewState(Resource.Status status, Event event, Event event2, Event event3, String str, PaymentState paymentState, PaymentMethodType paymentMethodType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? new Event(Boolean.FALSE) : event, (i & 4) != 0 ? new Event(Boolean.FALSE) : event2, (i & 8) != 0 ? new Event(Boolean.FALSE) : event3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? PaymentState.f26new : paymentState, (i & 64) != 0 ? null : paymentMethodType);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Event<Boolean> isDeleted() {
        return this.isDeleted;
    }

    public final Event<Boolean> isUpdated() {
        return this.isUpdated;
    }

    public final Event<Boolean> getNeed3ds() {
        return this.need3ds;
    }

    public final String getUrl3ds() {
        return this.url3ds;
    }

    public final PaymentState getState3ds() {
        return this.state3ds;
    }

    public final PaymentMethodType getPaymentMethod() {
        return this.paymentMethod;
    }
}
