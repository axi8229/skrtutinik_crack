package spay.sdk.data.dto.response.bnpl;

import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import npi.spay.Q1;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.bnpl.BnplPayment;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001c"}, d2 = {"Lspay/sdk/data/dto/response/bnpl/BnplPaymentDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/bnpl/BnplPayment;", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "", "amount", "", "currencyCode", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrencyCode", "()Ljava/lang/String;", "getDate", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lspay/sdk/data/dto/response/bnpl/BnplPaymentDto;", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BnplPaymentDto implements DataDtoInterface<BnplPayment> {

    @SerializedName("amount")
    private final Long amount;

    @SerializedName("currencyCode")
    private final String currencyCode;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)
    private final String date;

    public BnplPaymentDto(String str, Long l, String str2) {
        this.date = str;
        this.amount = l;
        this.currencyCode = str2;
    }

    public static /* synthetic */ BnplPaymentDto copy$default(BnplPaymentDto bnplPaymentDto, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bnplPaymentDto.date;
        }
        if ((i & 2) != 0) {
            l = bnplPaymentDto.amount;
        }
        if ((i & 4) != 0) {
            str2 = bnplPaymentDto.currencyCode;
        }
        return bnplPaymentDto.copy(str, l, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final BnplPaymentDto copy(String date, Long amount, String currencyCode) {
        return new BnplPaymentDto(date, amount, currencyCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BnplPaymentDto)) {
            return false;
        }
        BnplPaymentDto bnplPaymentDto = (BnplPaymentDto) other;
        return Intrinsics.areEqual(this.date, bnplPaymentDto.date) && Intrinsics.areEqual(this.amount, bnplPaymentDto.amount) && Intrinsics.areEqual(this.currencyCode, bnplPaymentDto.currencyCode);
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getDate() {
        return this.date;
    }

    public int hashCode() {
        String str = this.date;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.amount;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.currencyCode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BnplPaymentDto(date=");
        sb.append(this.date);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", currencyCode=");
        return Q1.a(sb, this.currencyCode, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public BnplPayment toModel() {
        String str = this.date;
        if (str == null) {
            throw new Kg(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE);
        }
        Long l = this.amount;
        if (l == null) {
            throw new Kg("amount");
        }
        long jLongValue = l.longValue();
        String str2 = this.currencyCode;
        if (str2 != null) {
            return new BnplPayment(str, jLongValue, str2);
        }
        throw new Kg("currencyCode");
    }
}
