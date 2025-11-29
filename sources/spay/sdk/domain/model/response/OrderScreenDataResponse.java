package spay.sdk.domain.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1901s;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lspay/sdk/domain/model/response/OrderScreenDataResponse;", "Landroid/os/Parcelable;", "listOfCardsResponseBody", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody;", "paymentPlanBnplResponseBody", "Lspay/sdk/domain/model/response/PaymentPlanBnplResponseBody;", "moreThanOneCard", "", "(Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody;Lspay/sdk/domain/model/response/PaymentPlanBnplResponseBody;Z)V", "getListOfCardsResponseBody", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody;", "getMoreThanOneCard", "()Z", "getPaymentPlanBnplResponseBody", "()Lspay/sdk/domain/model/response/PaymentPlanBnplResponseBody;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OrderScreenDataResponse implements Parcelable {
    public static final Parcelable.Creator<OrderScreenDataResponse> CREATOR = new Creator();
    private final ListOfCardsResponseBody listOfCardsResponseBody;
    private final boolean moreThanOneCard;
    private final PaymentPlanBnplResponseBody paymentPlanBnplResponseBody;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderScreenDataResponse> {
        @Override // android.os.Parcelable.Creator
        public final OrderScreenDataResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderScreenDataResponse(ListOfCardsResponseBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PaymentPlanBnplResponseBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final OrderScreenDataResponse[] newArray(int i) {
            return new OrderScreenDataResponse[i];
        }
    }

    public OrderScreenDataResponse(ListOfCardsResponseBody listOfCardsResponseBody, PaymentPlanBnplResponseBody paymentPlanBnplResponseBody, boolean z) {
        Intrinsics.checkNotNullParameter(listOfCardsResponseBody, "listOfCardsResponseBody");
        this.listOfCardsResponseBody = listOfCardsResponseBody;
        this.paymentPlanBnplResponseBody = paymentPlanBnplResponseBody;
        this.moreThanOneCard = z;
    }

    public static /* synthetic */ OrderScreenDataResponse copy$default(OrderScreenDataResponse orderScreenDataResponse, ListOfCardsResponseBody listOfCardsResponseBody, PaymentPlanBnplResponseBody paymentPlanBnplResponseBody, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            listOfCardsResponseBody = orderScreenDataResponse.listOfCardsResponseBody;
        }
        if ((i & 2) != 0) {
            paymentPlanBnplResponseBody = orderScreenDataResponse.paymentPlanBnplResponseBody;
        }
        if ((i & 4) != 0) {
            z = orderScreenDataResponse.moreThanOneCard;
        }
        return orderScreenDataResponse.copy(listOfCardsResponseBody, paymentPlanBnplResponseBody, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ListOfCardsResponseBody getListOfCardsResponseBody() {
        return this.listOfCardsResponseBody;
    }

    /* renamed from: component2, reason: from getter */
    public final PaymentPlanBnplResponseBody getPaymentPlanBnplResponseBody() {
        return this.paymentPlanBnplResponseBody;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMoreThanOneCard() {
        return this.moreThanOneCard;
    }

    public final OrderScreenDataResponse copy(ListOfCardsResponseBody listOfCardsResponseBody, PaymentPlanBnplResponseBody paymentPlanBnplResponseBody, boolean moreThanOneCard) {
        Intrinsics.checkNotNullParameter(listOfCardsResponseBody, "listOfCardsResponseBody");
        return new OrderScreenDataResponse(listOfCardsResponseBody, paymentPlanBnplResponseBody, moreThanOneCard);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderScreenDataResponse)) {
            return false;
        }
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) other;
        return Intrinsics.areEqual(this.listOfCardsResponseBody, orderScreenDataResponse.listOfCardsResponseBody) && Intrinsics.areEqual(this.paymentPlanBnplResponseBody, orderScreenDataResponse.paymentPlanBnplResponseBody) && this.moreThanOneCard == orderScreenDataResponse.moreThanOneCard;
    }

    public final ListOfCardsResponseBody getListOfCardsResponseBody() {
        return this.listOfCardsResponseBody;
    }

    public final boolean getMoreThanOneCard() {
        return this.moreThanOneCard;
    }

    public final PaymentPlanBnplResponseBody getPaymentPlanBnplResponseBody() {
        return this.paymentPlanBnplResponseBody;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.listOfCardsResponseBody.hashCode() * 31;
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = this.paymentPlanBnplResponseBody;
        int iHashCode2 = (iHashCode + (paymentPlanBnplResponseBody == null ? 0 : paymentPlanBnplResponseBody.hashCode())) * 31;
        boolean z = this.moreThanOneCard;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OrderScreenDataResponse(listOfCardsResponseBody=");
        sb.append(this.listOfCardsResponseBody);
        sb.append(", paymentPlanBnplResponseBody=");
        sb.append(this.paymentPlanBnplResponseBody);
        sb.append(", moreThanOneCard=");
        return AbstractC1901s.a(sb, this.moreThanOneCard, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.listOfCardsResponseBody.writeToParcel(parcel, flags);
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = this.paymentPlanBnplResponseBody;
        if (paymentPlanBnplResponseBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentPlanBnplResponseBody.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.moreThanOneCard ? 1 : 0);
    }

    public /* synthetic */ OrderScreenDataResponse(ListOfCardsResponseBody listOfCardsResponseBody, PaymentPlanBnplResponseBody paymentPlanBnplResponseBody, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(listOfCardsResponseBody, paymentPlanBnplResponseBody, (i & 4) != 0 ? false : z);
    }
}
