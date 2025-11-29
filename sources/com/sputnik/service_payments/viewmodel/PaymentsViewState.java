package com.sputnik.service_payments.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentsViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJn\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u0006\u0010\u001fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u0007\u0010\u001fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\u0013R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b&\u0010\u0013¨\u0006'"}, d2 = {"Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lcom/sputnik/domain/common/Event;", "", "isPayed", "isCanceled", "need3ds", "", "url3ds", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "state3ds", "paymentUuid", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;Ljava/lang/String;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;Ljava/lang/String;)Lcom/sputnik/service_payments/viewmodel/PaymentsViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "getNeed3ds", "Ljava/lang/String;", "getUrl3ds", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getState3ds", "()Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getPaymentUuid", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PaymentsViewState implements VMState {
    private final Event<Boolean> isCanceled;
    private final Event<Boolean> isPayed;
    private final Event<Boolean> need3ds;
    private final String paymentUuid;
    private final Resource.Status serverState;
    private final IntercomPaymentState state3ds;
    private final String url3ds;

    public PaymentsViewState() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PaymentsViewState copy$default(PaymentsViewState paymentsViewState, Resource.Status status, Event event, Event event2, Event event3, String str, IntercomPaymentState intercomPaymentState, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            status = paymentsViewState.serverState;
        }
        if ((i & 2) != 0) {
            event = paymentsViewState.isPayed;
        }
        Event event4 = event;
        if ((i & 4) != 0) {
            event2 = paymentsViewState.isCanceled;
        }
        Event event5 = event2;
        if ((i & 8) != 0) {
            event3 = paymentsViewState.need3ds;
        }
        Event event6 = event3;
        if ((i & 16) != 0) {
            str = paymentsViewState.url3ds;
        }
        String str3 = str;
        if ((i & 32) != 0) {
            intercomPaymentState = paymentsViewState.state3ds;
        }
        IntercomPaymentState intercomPaymentState2 = intercomPaymentState;
        if ((i & 64) != 0) {
            str2 = paymentsViewState.paymentUuid;
        }
        return paymentsViewState.copy(status, event4, event5, event6, str3, intercomPaymentState2, str2);
    }

    public final PaymentsViewState copy(Resource.Status serverState, Event<Boolean> isPayed, Event<Boolean> isCanceled, Event<Boolean> need3ds, String url3ds, IntercomPaymentState state3ds, String paymentUuid) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isPayed, "isPayed");
        Intrinsics.checkNotNullParameter(isCanceled, "isCanceled");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        return new PaymentsViewState(serverState, isPayed, isCanceled, need3ds, url3ds, state3ds, paymentUuid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentsViewState)) {
            return false;
        }
        PaymentsViewState paymentsViewState = (PaymentsViewState) other;
        return this.serverState == paymentsViewState.serverState && Intrinsics.areEqual(this.isPayed, paymentsViewState.isPayed) && Intrinsics.areEqual(this.isCanceled, paymentsViewState.isCanceled) && Intrinsics.areEqual(this.need3ds, paymentsViewState.need3ds) && Intrinsics.areEqual(this.url3ds, paymentsViewState.url3ds) && this.state3ds == paymentsViewState.state3ds && Intrinsics.areEqual(this.paymentUuid, paymentsViewState.paymentUuid);
    }

    public int hashCode() {
        int iHashCode = ((((((this.serverState.hashCode() * 31) + this.isPayed.hashCode()) * 31) + this.isCanceled.hashCode()) * 31) + this.need3ds.hashCode()) * 31;
        String str = this.url3ds;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        IntercomPaymentState intercomPaymentState = this.state3ds;
        int iHashCode3 = (iHashCode2 + (intercomPaymentState == null ? 0 : intercomPaymentState.hashCode())) * 31;
        String str2 = this.paymentUuid;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PaymentsViewState(serverState=" + this.serverState + ", isPayed=" + this.isPayed + ", isCanceled=" + this.isCanceled + ", need3ds=" + this.need3ds + ", url3ds=" + this.url3ds + ", state3ds=" + this.state3ds + ", paymentUuid=" + this.paymentUuid + ")";
    }

    public PaymentsViewState(Resource.Status serverState, Event<Boolean> isPayed, Event<Boolean> isCanceled, Event<Boolean> need3ds, String str, IntercomPaymentState intercomPaymentState, String str2) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isPayed, "isPayed");
        Intrinsics.checkNotNullParameter(isCanceled, "isCanceled");
        Intrinsics.checkNotNullParameter(need3ds, "need3ds");
        this.serverState = serverState;
        this.isPayed = isPayed;
        this.isCanceled = isCanceled;
        this.need3ds = need3ds;
        this.url3ds = str;
        this.state3ds = intercomPaymentState;
        this.paymentUuid = str2;
    }

    public /* synthetic */ PaymentsViewState(Resource.Status status, Event event, Event event2, Event event3, String str, IntercomPaymentState intercomPaymentState, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? new Event(Boolean.FALSE) : event, (i & 4) != 0 ? new Event(Boolean.FALSE) : event2, (i & 8) != 0 ? new Event(Boolean.FALSE) : event3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? IntercomPaymentState.none : intercomPaymentState, (i & 64) != 0 ? null : str2);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Event<Boolean> isPayed() {
        return this.isPayed;
    }

    public final Event<Boolean> isCanceled() {
        return this.isCanceled;
    }

    public final Event<Boolean> getNeed3ds() {
        return this.need3ds;
    }

    public final String getUrl3ds() {
        return this.url3ds;
    }

    public final IntercomPaymentState getState3ds() {
        return this.state3ds;
    }

    public final String getPaymentUuid() {
        return this.paymentUuid;
    }
}
