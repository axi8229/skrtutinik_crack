package spay.sdk.domain.model.response.listOfCards;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;
import npi.spay.U0;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001:\u000656789:BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020(HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020(HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006;"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody;", "Landroid/os/Parcelable;", "userInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$UserInfo;", "orderInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo;", "paymentToolInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo;", "merchantInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$MerchantInfo;", "buttonBnpl", "Lspay/sdk/domain/model/response/bnpl/ButtonBnpl;", "promoInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo;", "formInfo", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$FormInfo;", "(Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$UserInfo;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$MerchantInfo;Lspay/sdk/domain/model/response/bnpl/ButtonBnpl;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$FormInfo;)V", "getButtonBnpl", "()Lspay/sdk/domain/model/response/bnpl/ButtonBnpl;", "getFormInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$FormInfo;", "getMerchantInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$MerchantInfo;", "getOrderInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo;", "getPaymentToolInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo;", "getPromoInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo;", "getUserInfo", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$UserInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "FormInfo", "MerchantInfo", "OrderInfo", "PaymentToolInfo", "PromoInfo", "UserInfo", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListOfCardsResponseBody implements Parcelable {
    public static final Parcelable.Creator<ListOfCardsResponseBody> CREATOR = new Creator();
    private final ButtonBnpl buttonBnpl;
    private final FormInfo formInfo;
    private final MerchantInfo merchantInfo;
    private final OrderInfo orderInfo;
    private final PaymentToolInfo paymentToolInfo;
    private final PromoInfo promoInfo;
    private final UserInfo userInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ListOfCardsResponseBody> {
        @Override // android.os.Parcelable.Creator
        public final ListOfCardsResponseBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ListOfCardsResponseBody(UserInfo.CREATOR.createFromParcel(parcel), OrderInfo.CREATOR.createFromParcel(parcel), PaymentToolInfo.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MerchantInfo.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ButtonBnpl.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PromoInfo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? FormInfo.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final ListOfCardsResponseBody[] newArray(int i) {
            return new ListOfCardsResponseBody[i];
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$FormInfo;", "Landroid/os/Parcelable;", "notEnoughBalanceText", "", "onlyPartPayText", "(Ljava/lang/String;Ljava/lang/String;)V", "getNotEnoughBalanceText", "()Ljava/lang/String;", "getOnlyPartPayText", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FormInfo implements Parcelable {
        public static final Parcelable.Creator<FormInfo> CREATOR = new Creator();
        private final String notEnoughBalanceText;
        private final String onlyPartPayText;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FormInfo> {
            @Override // android.os.Parcelable.Creator
            public final FormInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FormInfo(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final FormInfo[] newArray(int i) {
                return new FormInfo[i];
            }
        }

        public FormInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FormInfo copy$default(FormInfo formInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formInfo.notEnoughBalanceText;
            }
            if ((i & 2) != 0) {
                str2 = formInfo.onlyPartPayText;
            }
            return formInfo.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getNotEnoughBalanceText() {
            return this.notEnoughBalanceText;
        }

        /* renamed from: component2, reason: from getter */
        public final String getOnlyPartPayText() {
            return this.onlyPartPayText;
        }

        public final FormInfo copy(String notEnoughBalanceText, String onlyPartPayText) {
            return new FormInfo(notEnoughBalanceText, onlyPartPayText);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormInfo)) {
                return false;
            }
            FormInfo formInfo = (FormInfo) other;
            return Intrinsics.areEqual(this.notEnoughBalanceText, formInfo.notEnoughBalanceText) && Intrinsics.areEqual(this.onlyPartPayText, formInfo.onlyPartPayText);
        }

        public final String getNotEnoughBalanceText() {
            return this.notEnoughBalanceText;
        }

        public final String getOnlyPartPayText() {
            return this.onlyPartPayText;
        }

        public int hashCode() {
            String str = this.notEnoughBalanceText;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.onlyPartPayText;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FormInfo(notEnoughBalanceText=");
            sb.append(this.notEnoughBalanceText);
            sb.append(", onlyPartPayText=");
            return Q1.a(sb, this.onlyPartPayText, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.notEnoughBalanceText);
            parcel.writeString(this.onlyPartPayText);
        }

        public FormInfo(String str, String str2) {
            this.notEnoughBalanceText = str;
            this.onlyPartPayText = str2;
        }

        public /* synthetic */ FormInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\""}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$MerchantInfo;", "Landroid/os/Parcelable;", "merchantName", "", "merchantLogoUrl", "bindingIsNeeded", "", "bindingSafeText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getBindingIsNeeded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBindingSafeText", "()Ljava/lang/String;", "getMerchantLogoUrl", "getMerchantName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$MerchantInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MerchantInfo implements Parcelable {
        public static final Parcelable.Creator<MerchantInfo> CREATOR = new Creator();
        private final Boolean bindingIsNeeded;
        private final String bindingSafeText;
        private final String merchantLogoUrl;
        private final String merchantName;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MerchantInfo> {
            @Override // android.os.Parcelable.Creator
            public final MerchantInfo createFromParcel(Parcel parcel) {
                Boolean boolValueOf;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    boolValueOf = null;
                } else {
                    boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new MerchantInfo(string, string2, boolValueOf, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final MerchantInfo[] newArray(int i) {
                return new MerchantInfo[i];
            }
        }

        public MerchantInfo() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, String str, String str2, Boolean bool, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = merchantInfo.merchantName;
            }
            if ((i & 2) != 0) {
                str2 = merchantInfo.merchantLogoUrl;
            }
            if ((i & 4) != 0) {
                bool = merchantInfo.bindingIsNeeded;
            }
            if ((i & 8) != 0) {
                str3 = merchantInfo.bindingSafeText;
            }
            return merchantInfo.copy(str, str2, bool, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMerchantName() {
            return this.merchantName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMerchantLogoUrl() {
            return this.merchantLogoUrl;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getBindingIsNeeded() {
            return this.bindingIsNeeded;
        }

        /* renamed from: component4, reason: from getter */
        public final String getBindingSafeText() {
            return this.bindingSafeText;
        }

        public final MerchantInfo copy(String merchantName, String merchantLogoUrl, Boolean bindingIsNeeded, String bindingSafeText) {
            return new MerchantInfo(merchantName, merchantLogoUrl, bindingIsNeeded, bindingSafeText);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MerchantInfo)) {
                return false;
            }
            MerchantInfo merchantInfo = (MerchantInfo) other;
            return Intrinsics.areEqual(this.merchantName, merchantInfo.merchantName) && Intrinsics.areEqual(this.merchantLogoUrl, merchantInfo.merchantLogoUrl) && Intrinsics.areEqual(this.bindingIsNeeded, merchantInfo.bindingIsNeeded) && Intrinsics.areEqual(this.bindingSafeText, merchantInfo.bindingSafeText);
        }

        public final Boolean getBindingIsNeeded() {
            return this.bindingIsNeeded;
        }

        public final String getBindingSafeText() {
            return this.bindingSafeText;
        }

        public final String getMerchantLogoUrl() {
            return this.merchantLogoUrl;
        }

        public final String getMerchantName() {
            return this.merchantName;
        }

        public int hashCode() {
            String str = this.merchantName;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.merchantLogoUrl;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.bindingIsNeeded;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.bindingSafeText;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MerchantInfo(merchantName=");
            sb.append(this.merchantName);
            sb.append(", merchantLogoUrl=");
            sb.append(this.merchantLogoUrl);
            sb.append(", bindingIsNeeded=");
            sb.append(this.bindingIsNeeded);
            sb.append(", bindingSafeText=");
            return Q1.a(sb, this.bindingSafeText, ')');
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int iBooleanValue;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.merchantName);
            parcel.writeString(this.merchantLogoUrl);
            Boolean bool = this.bindingIsNeeded;
            if (bool == null) {
                iBooleanValue = 0;
            } else {
                parcel.writeInt(1);
                iBooleanValue = bool.booleanValue();
            }
            parcel.writeInt(iBooleanValue);
            parcel.writeString(this.bindingSafeText);
        }

        public MerchantInfo(String str, String str2, Boolean bool, String str3) {
            this.merchantName = str;
            this.merchantLogoUrl = str2;
            this.bindingIsNeeded = bool;
            this.bindingSafeText = str3;
        }

        public /* synthetic */ MerchantInfo(String str, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str3);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo;", "Landroid/os/Parcelable;", "orderAmount", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo$OrderAmount;", "(Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo$OrderAmount;)V", "getOrderAmount", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo$OrderAmount;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "OrderAmount", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class OrderInfo implements Parcelable {
        public static final Parcelable.Creator<OrderInfo> CREATOR = new Creator();
        private final OrderAmount orderAmount;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<OrderInfo> {
            @Override // android.os.Parcelable.Creator
            public final OrderInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OrderInfo(parcel.readInt() == 0 ? null : OrderAmount.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final OrderInfo[] newArray(int i) {
                return new OrderInfo[i];
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$OrderInfo$OrderAmount;", "Landroid/os/Parcelable;", "amount", "", "currency", "", "(ILjava/lang/String;)V", "getAmount", "()I", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class OrderAmount implements Parcelable {
            public static final Parcelable.Creator<OrderAmount> CREATOR = new Creator();
            private final int amount;
            private final String currency;

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<OrderAmount> {
                @Override // android.os.Parcelable.Creator
                public final OrderAmount createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new OrderAmount(parcel.readInt(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final OrderAmount[] newArray(int i) {
                    return new OrderAmount[i];
                }
            }

            public OrderAmount(int i, String currency) {
                Intrinsics.checkNotNullParameter(currency, "currency");
                this.amount = i;
                this.currency = currency;
            }

            public static /* synthetic */ OrderAmount copy$default(OrderAmount orderAmount, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = orderAmount.amount;
                }
                if ((i2 & 2) != 0) {
                    str = orderAmount.currency;
                }
                return orderAmount.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getAmount() {
                return this.amount;
            }

            /* renamed from: component2, reason: from getter */
            public final String getCurrency() {
                return this.currency;
            }

            public final OrderAmount copy(int amount, String currency) {
                Intrinsics.checkNotNullParameter(currency, "currency");
                return new OrderAmount(amount, currency);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OrderAmount)) {
                    return false;
                }
                OrderAmount orderAmount = (OrderAmount) other;
                return this.amount == orderAmount.amount && Intrinsics.areEqual(this.currency, orderAmount.currency);
            }

            public final int getAmount() {
                return this.amount;
            }

            public final String getCurrency() {
                return this.currency;
            }

            public int hashCode() {
                return this.currency.hashCode() + (Integer.hashCode(this.amount) * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("OrderAmount(amount=");
                sb.append(this.amount);
                sb.append(", currency=");
                return Q1.a(sb, this.currency, ')');
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.amount);
                parcel.writeString(this.currency);
            }
        }

        public OrderInfo() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ OrderInfo copy$default(OrderInfo orderInfo, OrderAmount orderAmount, int i, Object obj) {
            if ((i & 1) != 0) {
                orderAmount = orderInfo.orderAmount;
            }
            return orderInfo.copy(orderAmount);
        }

        /* renamed from: component1, reason: from getter */
        public final OrderAmount getOrderAmount() {
            return this.orderAmount;
        }

        public final OrderInfo copy(OrderAmount orderAmount) {
            return new OrderInfo(orderAmount);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OrderInfo) && Intrinsics.areEqual(this.orderAmount, ((OrderInfo) other).orderAmount);
        }

        public final OrderAmount getOrderAmount() {
            return this.orderAmount;
        }

        public int hashCode() {
            OrderAmount orderAmount = this.orderAmount;
            if (orderAmount == null) {
                return 0;
            }
            return orderAmount.hashCode();
        }

        public String toString() {
            return "OrderInfo(orderAmount=" + this.orderAmount + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            OrderAmount orderAmount = this.orderAmount;
            if (orderAmount == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                orderAmount.writeToParcel(parcel, flags);
            }
        }

        public OrderInfo(OrderAmount orderAmount) {
            this.orderAmount = orderAmount;
        }

        public /* synthetic */ OrderInfo(OrderAmount orderAmount, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : orderAmount);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001 B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo;", "Landroid/os/Parcelable;", "toolList", "", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool;", "additionalCards", "", "isSpPaymentToolsNeedUpdate", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAdditionalCards", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getToolList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Tool", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PaymentToolInfo implements Parcelable {
        public static final Parcelable.Creator<PaymentToolInfo> CREATOR = new Creator();
        private final Boolean additionalCards;
        private final Boolean isSpPaymentToolsNeedUpdate;
        private final List<Tool> toolList;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PaymentToolInfo> {
            @Override // android.os.Parcelable.Creator
            public final PaymentToolInfo createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i = parcel.readInt();
                    arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(Tool.CREATOR.createFromParcel(parcel));
                    }
                }
                return new PaymentToolInfo(arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final PaymentToolInfo[] newArray(int i) {
                return new PaymentToolInfo[i];
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001AB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ¢\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\u0005HÖ\u0001J\u0013\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000e\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000f\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006B"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool;", "Landroid/os/Parcelable;", "productName", "", "paymentId", "", "priorityCard", "", "paymentSourceType", "financialProductId", BankCardViewKt.EXTRA_CARD_NUMBER, "paymentSystemType", "cardLogoUrl", "countAdditionalCards", "isSpPaymentTools", "isSpPaymentToolsPriority", "precalculateBonuses", "amountData", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData;", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData;)V", "getAmountData", "()Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData;", "getCardLogoUrl", "()Ljava/lang/String;", "getCardNumber", "getCountAdditionalCards", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFinancialProductId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPaymentId", "()I", "getPaymentSourceType", "getPaymentSystemType", "getPrecalculateBonuses", "getPriorityCard", "()Z", "getProductName", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData;)Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "AmountData", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Tool implements Parcelable {
            public static final Parcelable.Creator<Tool> CREATOR = new Creator();
            private final AmountData amountData;
            private final String cardLogoUrl;
            private final String cardNumber;
            private final Integer countAdditionalCards;
            private final String financialProductId;
            private final Boolean isSpPaymentTools;
            private final Boolean isSpPaymentToolsPriority;
            private final int paymentId;
            private final String paymentSourceType;
            private final String paymentSystemType;
            private final String precalculateBonuses;
            private final boolean priorityCard;
            private final String productName;

            @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData;", "Landroid/os/Parcelable;", "amount", "", "currency", "", "(JLjava/lang/String;)V", "getAmount", "()J", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class AmountData implements Parcelable {
                public static final Parcelable.Creator<AmountData> CREATOR = new Creator();
                private final long amount;
                private final String currency;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<AmountData> {
                    @Override // android.os.Parcelable.Creator
                    public final AmountData createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new AmountData(parcel.readLong(), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    public final AmountData[] newArray(int i) {
                        return new AmountData[i];
                    }
                }

                public AmountData(long j, String currency) {
                    Intrinsics.checkNotNullParameter(currency, "currency");
                    this.amount = j;
                    this.currency = currency;
                }

                public static /* synthetic */ AmountData copy$default(AmountData amountData, long j, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = amountData.amount;
                    }
                    if ((i & 2) != 0) {
                        str = amountData.currency;
                    }
                    return amountData.copy(j, str);
                }

                /* renamed from: component1, reason: from getter */
                public final long getAmount() {
                    return this.amount;
                }

                /* renamed from: component2, reason: from getter */
                public final String getCurrency() {
                    return this.currency;
                }

                public final AmountData copy(long amount, String currency) {
                    Intrinsics.checkNotNullParameter(currency, "currency");
                    return new AmountData(amount, currency);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AmountData)) {
                        return false;
                    }
                    AmountData amountData = (AmountData) other;
                    return this.amount == amountData.amount && Intrinsics.areEqual(this.currency, amountData.currency);
                }

                public final long getAmount() {
                    return this.amount;
                }

                public final String getCurrency() {
                    return this.currency;
                }

                public int hashCode() {
                    return this.currency.hashCode() + (Long.hashCode(this.amount) * 31);
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("AmountData(amount=");
                    sb.append(this.amount);
                    sb.append(", currency=");
                    return Q1.a(sb, this.currency, ')');
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel parcel, int flags) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    parcel.writeLong(this.amount);
                    parcel.writeString(this.currency);
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Tool> {
                @Override // android.os.Parcelable.Creator
                public final Tool createFromParcel(Parcel parcel) {
                    Boolean boolValueOf;
                    Boolean boolValueOf2;
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String string = parcel.readString();
                    int i = parcel.readInt();
                    boolean z = parcel.readInt() != 0;
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    String string6 = parcel.readString();
                    Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                    if (parcel.readInt() == 0) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    if (parcel.readInt() == 0) {
                        boolValueOf2 = null;
                    } else {
                        boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    return new Tool(string, i, z, string2, string3, string4, string5, string6, numValueOf, boolValueOf, boolValueOf2, parcel.readString(), parcel.readInt() != 0 ? AmountData.CREATOR.createFromParcel(parcel) : null);
                }

                @Override // android.os.Parcelable.Creator
                public final Tool[] newArray(int i) {
                    return new Tool[i];
                }
            }

            public Tool(String productName, int i, boolean z, String paymentSourceType, String str, String str2, String str3, String str4, Integer num, Boolean bool, Boolean bool2, String str5, AmountData amountData) {
                Intrinsics.checkNotNullParameter(productName, "productName");
                Intrinsics.checkNotNullParameter(paymentSourceType, "paymentSourceType");
                this.productName = productName;
                this.paymentId = i;
                this.priorityCard = z;
                this.paymentSourceType = paymentSourceType;
                this.financialProductId = str;
                this.cardNumber = str2;
                this.paymentSystemType = str3;
                this.cardLogoUrl = str4;
                this.countAdditionalCards = num;
                this.isSpPaymentTools = bool;
                this.isSpPaymentToolsPriority = bool2;
                this.precalculateBonuses = str5;
                this.amountData = amountData;
            }

            /* renamed from: component1, reason: from getter */
            public final String getProductName() {
                return this.productName;
            }

            /* renamed from: component10, reason: from getter */
            public final Boolean getIsSpPaymentTools() {
                return this.isSpPaymentTools;
            }

            /* renamed from: component11, reason: from getter */
            public final Boolean getIsSpPaymentToolsPriority() {
                return this.isSpPaymentToolsPriority;
            }

            /* renamed from: component12, reason: from getter */
            public final String getPrecalculateBonuses() {
                return this.precalculateBonuses;
            }

            /* renamed from: component13, reason: from getter */
            public final AmountData getAmountData() {
                return this.amountData;
            }

            /* renamed from: component2, reason: from getter */
            public final int getPaymentId() {
                return this.paymentId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getPriorityCard() {
                return this.priorityCard;
            }

            /* renamed from: component4, reason: from getter */
            public final String getPaymentSourceType() {
                return this.paymentSourceType;
            }

            /* renamed from: component5, reason: from getter */
            public final String getFinancialProductId() {
                return this.financialProductId;
            }

            /* renamed from: component6, reason: from getter */
            public final String getCardNumber() {
                return this.cardNumber;
            }

            /* renamed from: component7, reason: from getter */
            public final String getPaymentSystemType() {
                return this.paymentSystemType;
            }

            /* renamed from: component8, reason: from getter */
            public final String getCardLogoUrl() {
                return this.cardLogoUrl;
            }

            /* renamed from: component9, reason: from getter */
            public final Integer getCountAdditionalCards() {
                return this.countAdditionalCards;
            }

            public final Tool copy(String productName, int paymentId, boolean priorityCard, String paymentSourceType, String financialProductId, String cardNumber, String paymentSystemType, String cardLogoUrl, Integer countAdditionalCards, Boolean isSpPaymentTools, Boolean isSpPaymentToolsPriority, String precalculateBonuses, AmountData amountData) {
                Intrinsics.checkNotNullParameter(productName, "productName");
                Intrinsics.checkNotNullParameter(paymentSourceType, "paymentSourceType");
                return new Tool(productName, paymentId, priorityCard, paymentSourceType, financialProductId, cardNumber, paymentSystemType, cardLogoUrl, countAdditionalCards, isSpPaymentTools, isSpPaymentToolsPriority, precalculateBonuses, amountData);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Tool)) {
                    return false;
                }
                Tool tool = (Tool) other;
                return Intrinsics.areEqual(this.productName, tool.productName) && this.paymentId == tool.paymentId && this.priorityCard == tool.priorityCard && Intrinsics.areEqual(this.paymentSourceType, tool.paymentSourceType) && Intrinsics.areEqual(this.financialProductId, tool.financialProductId) && Intrinsics.areEqual(this.cardNumber, tool.cardNumber) && Intrinsics.areEqual(this.paymentSystemType, tool.paymentSystemType) && Intrinsics.areEqual(this.cardLogoUrl, tool.cardLogoUrl) && Intrinsics.areEqual(this.countAdditionalCards, tool.countAdditionalCards) && Intrinsics.areEqual(this.isSpPaymentTools, tool.isSpPaymentTools) && Intrinsics.areEqual(this.isSpPaymentToolsPriority, tool.isSpPaymentToolsPriority) && Intrinsics.areEqual(this.precalculateBonuses, tool.precalculateBonuses) && Intrinsics.areEqual(this.amountData, tool.amountData);
            }

            public final AmountData getAmountData() {
                return this.amountData;
            }

            public final String getCardLogoUrl() {
                return this.cardLogoUrl;
            }

            public final String getCardNumber() {
                return this.cardNumber;
            }

            public final Integer getCountAdditionalCards() {
                return this.countAdditionalCards;
            }

            public final String getFinancialProductId() {
                return this.financialProductId;
            }

            public final int getPaymentId() {
                return this.paymentId;
            }

            public final String getPaymentSourceType() {
                return this.paymentSourceType;
            }

            public final String getPaymentSystemType() {
                return this.paymentSystemType;
            }

            public final String getPrecalculateBonuses() {
                return this.precalculateBonuses;
            }

            public final boolean getPriorityCard() {
                return this.priorityCard;
            }

            public final String getProductName() {
                return this.productName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iHashCode = (Integer.hashCode(this.paymentId) + (this.productName.hashCode() * 31)) * 31;
                boolean z = this.priorityCard;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                int iA = AbstractC1553e.a(this.paymentSourceType, (iHashCode + i) * 31, 31);
                String str = this.financialProductId;
                int iHashCode2 = (iA + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.cardNumber;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.paymentSystemType;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.cardLogoUrl;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Integer num = this.countAdditionalCards;
                int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
                Boolean bool = this.isSpPaymentTools;
                int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.isSpPaymentToolsPriority;
                int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                String str5 = this.precalculateBonuses;
                int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
                AmountData amountData = this.amountData;
                return iHashCode9 + (amountData != null ? amountData.hashCode() : 0);
            }

            public final Boolean isSpPaymentTools() {
                return this.isSpPaymentTools;
            }

            public final Boolean isSpPaymentToolsPriority() {
                return this.isSpPaymentToolsPriority;
            }

            public String toString() {
                return "Tool(productName=" + this.productName + ", paymentId=" + this.paymentId + ", priorityCard=" + this.priorityCard + ", paymentSourceType=" + this.paymentSourceType + ", financialProductId=" + this.financialProductId + ", cardNumber=" + this.cardNumber + ", paymentSystemType=" + this.paymentSystemType + ", cardLogoUrl=" + this.cardLogoUrl + ", countAdditionalCards=" + this.countAdditionalCards + ", isSpPaymentTools=" + this.isSpPaymentTools + ", isSpPaymentToolsPriority=" + this.isSpPaymentToolsPriority + ", precalculateBonuses=" + this.precalculateBonuses + ", amountData=" + this.amountData + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.productName);
                parcel.writeInt(this.paymentId);
                parcel.writeInt(this.priorityCard ? 1 : 0);
                parcel.writeString(this.paymentSourceType);
                parcel.writeString(this.financialProductId);
                parcel.writeString(this.cardNumber);
                parcel.writeString(this.paymentSystemType);
                parcel.writeString(this.cardLogoUrl);
                Integer num = this.countAdditionalCards;
                if (num == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                }
                Boolean bool = this.isSpPaymentTools;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                Boolean bool2 = this.isSpPaymentToolsPriority;
                if (bool2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool2.booleanValue() ? 1 : 0);
                }
                parcel.writeString(this.precalculateBonuses);
                AmountData amountData = this.amountData;
                if (amountData == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    amountData.writeToParcel(parcel, flags);
                }
            }

            public /* synthetic */ Tool(String str, int i, boolean z, String str2, String str3, String str4, String str5, String str6, Integer num, Boolean bool, Boolean bool2, String str7, AmountData amountData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i, z, str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? null : bool, (i2 & 1024) != 0 ? null : bool2, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : amountData);
            }
        }

        public PaymentToolInfo() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PaymentToolInfo copy$default(PaymentToolInfo paymentToolInfo, List list, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = paymentToolInfo.toolList;
            }
            if ((i & 2) != 0) {
                bool = paymentToolInfo.additionalCards;
            }
            if ((i & 4) != 0) {
                bool2 = paymentToolInfo.isSpPaymentToolsNeedUpdate;
            }
            return paymentToolInfo.copy(list, bool, bool2);
        }

        public final List<Tool> component1() {
            return this.toolList;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getAdditionalCards() {
            return this.additionalCards;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getIsSpPaymentToolsNeedUpdate() {
            return this.isSpPaymentToolsNeedUpdate;
        }

        public final PaymentToolInfo copy(List<Tool> toolList, Boolean additionalCards, Boolean isSpPaymentToolsNeedUpdate) {
            return new PaymentToolInfo(toolList, additionalCards, isSpPaymentToolsNeedUpdate);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentToolInfo)) {
                return false;
            }
            PaymentToolInfo paymentToolInfo = (PaymentToolInfo) other;
            return Intrinsics.areEqual(this.toolList, paymentToolInfo.toolList) && Intrinsics.areEqual(this.additionalCards, paymentToolInfo.additionalCards) && Intrinsics.areEqual(this.isSpPaymentToolsNeedUpdate, paymentToolInfo.isSpPaymentToolsNeedUpdate);
        }

        public final Boolean getAdditionalCards() {
            return this.additionalCards;
        }

        public final List<Tool> getToolList() {
            return this.toolList;
        }

        public int hashCode() {
            List<Tool> list = this.toolList;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            Boolean bool = this.additionalCards;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isSpPaymentToolsNeedUpdate;
            return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public final Boolean isSpPaymentToolsNeedUpdate() {
            return this.isSpPaymentToolsNeedUpdate;
        }

        public String toString() {
            return "PaymentToolInfo(toolList=" + this.toolList + ", additionalCards=" + this.additionalCards + ", isSpPaymentToolsNeedUpdate=" + this.isSpPaymentToolsNeedUpdate + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<Tool> list = this.toolList;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(list.size());
                Iterator<Tool> it = list.iterator();
                while (it.hasNext()) {
                    it.next().writeToParcel(parcel, flags);
                }
            }
            Boolean bool = this.additionalCards;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Boolean bool2 = this.isSpPaymentToolsNeedUpdate;
            if (bool2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool2.booleanValue() ? 1 : 0);
            }
        }

        public PaymentToolInfo(List<Tool> list, Boolean bool, Boolean bool2) {
            this.toolList = list;
            this.additionalCards = bool;
            this.isSpPaymentToolsNeedUpdate = bool2;
        }

        public /* synthetic */ PaymentToolInfo(List list, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u001cB#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo;", "Landroid/os/Parcelable;", "hint", "", "bannerList", "", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo$BannerData;", "(Ljava/lang/String;Ljava/util/List;)V", "getBannerList", "()Ljava/util/List;", "getHint", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BannerData", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PromoInfo implements Parcelable {
        public static final Parcelable.Creator<PromoInfo> CREATOR = new Creator();
        private final List<BannerData> bannerList;
        private final String hint;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JU\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006)"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo$BannerData;", "Landroid/os/Parcelable;", "type", "", "hint", "header", "text", "iconUrl", "buttons", "", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo$BannerData$Buttons;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getButtons", "()Ljava/util/List;", "getHeader", "()Ljava/lang/String;", "getHint", "getIconUrl", "getText", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Buttons", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class BannerData implements Parcelable {
            public static final Parcelable.Creator<BannerData> CREATOR = new Creator();
            private final List<Buttons> buttons;
            private final String header;
            private final String hint;
            private final String iconUrl;
            private final String text;
            private final String type;

            @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo$BannerData$Buttons;", "Landroid/os/Parcelable;", "type", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getTitle", "getType", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class Buttons implements Parcelable {
                public static final Parcelable.Creator<Buttons> CREATOR = new Creator();
                private final String deeplink;
                private final String title;
                private final String type;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Buttons> {
                    @Override // android.os.Parcelable.Creator
                    public final Buttons createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new Buttons(parcel.readString(), parcel.readString(), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    public final Buttons[] newArray(int i) {
                        return new Buttons[i];
                    }
                }

                public Buttons(String type, String str, String str2) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    this.type = type;
                    this.title = str;
                    this.deeplink = str2;
                }

                public static /* synthetic */ Buttons copy$default(Buttons buttons, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = buttons.type;
                    }
                    if ((i & 2) != 0) {
                        str2 = buttons.title;
                    }
                    if ((i & 4) != 0) {
                        str3 = buttons.deeplink;
                    }
                    return buttons.copy(str, str2, str3);
                }

                /* renamed from: component1, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                /* renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                /* renamed from: component3, reason: from getter */
                public final String getDeeplink() {
                    return this.deeplink;
                }

                public final Buttons copy(String type, String title, String deeplink) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    return new Buttons(type, title, deeplink);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Buttons)) {
                        return false;
                    }
                    Buttons buttons = (Buttons) other;
                    return Intrinsics.areEqual(this.type, buttons.type) && Intrinsics.areEqual(this.title, buttons.title) && Intrinsics.areEqual(this.deeplink, buttons.deeplink);
                }

                public final String getDeeplink() {
                    return this.deeplink;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    int iHashCode = this.type.hashCode() * 31;
                    String str = this.title;
                    int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                    String str2 = this.deeplink;
                    return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("Buttons(type=");
                    sb.append(this.type);
                    sb.append(", title=");
                    sb.append(this.title);
                    sb.append(", deeplink=");
                    return Q1.a(sb, this.deeplink, ')');
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel parcel, int flags) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    parcel.writeString(this.type);
                    parcel.writeString(this.title);
                    parcel.writeString(this.deeplink);
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<BannerData> {
                @Override // android.os.Parcelable.Creator
                public final BannerData createFromParcel(Parcel parcel) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    if (parcel.readInt() == 0) {
                        arrayList = null;
                    } else {
                        int i = parcel.readInt();
                        ArrayList arrayList2 = new ArrayList(i);
                        for (int i2 = 0; i2 != i; i2++) {
                            arrayList2.add(Buttons.CREATOR.createFromParcel(parcel));
                        }
                        arrayList = arrayList2;
                    }
                    return new BannerData(string, string2, string3, string4, string5, arrayList);
                }

                @Override // android.os.Parcelable.Creator
                public final BannerData[] newArray(int i) {
                    return new BannerData[i];
                }
            }

            public BannerData(String type, String str, String str2, String str3, String str4, List<Buttons> list) {
                Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
                this.hint = str;
                this.header = str2;
                this.text = str3;
                this.iconUrl = str4;
                this.buttons = list;
            }

            public static /* synthetic */ BannerData copy$default(BannerData bannerData, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = bannerData.type;
                }
                if ((i & 2) != 0) {
                    str2 = bannerData.hint;
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    str3 = bannerData.header;
                }
                String str7 = str3;
                if ((i & 8) != 0) {
                    str4 = bannerData.text;
                }
                String str8 = str4;
                if ((i & 16) != 0) {
                    str5 = bannerData.iconUrl;
                }
                String str9 = str5;
                if ((i & 32) != 0) {
                    list = bannerData.buttons;
                }
                return bannerData.copy(str, str6, str7, str8, str9, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* renamed from: component2, reason: from getter */
            public final String getHint() {
                return this.hint;
            }

            /* renamed from: component3, reason: from getter */
            public final String getHeader() {
                return this.header;
            }

            /* renamed from: component4, reason: from getter */
            public final String getText() {
                return this.text;
            }

            /* renamed from: component5, reason: from getter */
            public final String getIconUrl() {
                return this.iconUrl;
            }

            public final List<Buttons> component6() {
                return this.buttons;
            }

            public final BannerData copy(String type, String hint, String header, String text, String iconUrl, List<Buttons> buttons) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new BannerData(type, hint, header, text, iconUrl, buttons);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BannerData)) {
                    return false;
                }
                BannerData bannerData = (BannerData) other;
                return Intrinsics.areEqual(this.type, bannerData.type) && Intrinsics.areEqual(this.hint, bannerData.hint) && Intrinsics.areEqual(this.header, bannerData.header) && Intrinsics.areEqual(this.text, bannerData.text) && Intrinsics.areEqual(this.iconUrl, bannerData.iconUrl) && Intrinsics.areEqual(this.buttons, bannerData.buttons);
            }

            public final List<Buttons> getButtons() {
                return this.buttons;
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getHint() {
                return this.hint;
            }

            public final String getIconUrl() {
                return this.iconUrl;
            }

            public final String getText() {
                return this.text;
            }

            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                int iHashCode = this.type.hashCode() * 31;
                String str = this.hint;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.header;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.text;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.iconUrl;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                List<Buttons> list = this.buttons;
                return iHashCode5 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("BannerData(type=");
                sb.append(this.type);
                sb.append(", hint=");
                sb.append(this.hint);
                sb.append(", header=");
                sb.append(this.header);
                sb.append(", text=");
                sb.append(this.text);
                sb.append(", iconUrl=");
                sb.append(this.iconUrl);
                sb.append(", buttons=");
                return U0.a(sb, this.buttons, ')');
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.type);
                parcel.writeString(this.hint);
                parcel.writeString(this.header);
                parcel.writeString(this.text);
                parcel.writeString(this.iconUrl);
                List<Buttons> list = this.buttons;
                if (list == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeInt(list.size());
                Iterator<Buttons> it = list.iterator();
                while (it.hasNext()) {
                    it.next().writeToParcel(parcel, flags);
                }
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PromoInfo> {
            @Override // android.os.Parcelable.Creator
            public final PromoInfo createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String string = parcel.readString();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList2.add(BannerData.CREATOR.createFromParcel(parcel));
                    }
                    arrayList = arrayList2;
                }
                return new PromoInfo(string, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final PromoInfo[] newArray(int i) {
                return new PromoInfo[i];
            }
        }

        public PromoInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PromoInfo copy$default(PromoInfo promoInfo, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = promoInfo.hint;
            }
            if ((i & 2) != 0) {
                list = promoInfo.bannerList;
            }
            return promoInfo.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getHint() {
            return this.hint;
        }

        public final List<BannerData> component2() {
            return this.bannerList;
        }

        public final PromoInfo copy(String hint, List<BannerData> bannerList) {
            return new PromoInfo(hint, bannerList);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromoInfo)) {
                return false;
            }
            PromoInfo promoInfo = (PromoInfo) other;
            return Intrinsics.areEqual(this.hint, promoInfo.hint) && Intrinsics.areEqual(this.bannerList, promoInfo.bannerList);
        }

        public final List<BannerData> getBannerList() {
            return this.bannerList;
        }

        public final String getHint() {
            return this.hint;
        }

        public int hashCode() {
            String str = this.hint;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<BannerData> list = this.bannerList;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PromoInfo(hint=");
            sb.append(this.hint);
            sb.append(", bannerList=");
            return U0.a(sb, this.bannerList, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.hint);
            List<BannerData> list = this.bannerList;
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<BannerData> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }

        public PromoInfo(String str, List<BannerData> list) {
            this.hint = str;
            this.bannerList = list;
        }

        public /* synthetic */ PromoInfo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JF\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006%"}, d2 = {"Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$UserInfo;", "Landroid/os/Parcelable;", "lastName", "", "firstName", "gender", "", "sub", "ucpId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "getGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastName", "getSub", "getUcpId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$UserInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UserInfo implements Parcelable {
        public static final Parcelable.Creator<UserInfo> CREATOR = new Creator();
        private final String firstName;
        private final Integer gender;
        private final String lastName;
        private final String sub;
        private final String ucpId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<UserInfo> {
            @Override // android.os.Parcelable.Creator
            public final UserInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UserInfo(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final UserInfo[] newArray(int i) {
                return new UserInfo[i];
            }
        }

        public UserInfo(String lastName, String firstName, Integer num, String str, String str2) {
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = num;
            this.sub = str;
            this.ucpId = str2;
        }

        public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, Integer num, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userInfo.lastName;
            }
            if ((i & 2) != 0) {
                str2 = userInfo.firstName;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                num = userInfo.gender;
            }
            Integer num2 = num;
            if ((i & 8) != 0) {
                str3 = userInfo.sub;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = userInfo.ucpId;
            }
            return userInfo.copy(str, str5, num2, str6, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLastName() {
            return this.lastName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getGender() {
            return this.gender;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSub() {
            return this.sub;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUcpId() {
            return this.ucpId;
        }

        public final UserInfo copy(String lastName, String firstName, Integer gender, String sub, String ucpId) {
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            return new UserInfo(lastName, firstName, gender, sub, ucpId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserInfo)) {
                return false;
            }
            UserInfo userInfo = (UserInfo) other;
            return Intrinsics.areEqual(this.lastName, userInfo.lastName) && Intrinsics.areEqual(this.firstName, userInfo.firstName) && Intrinsics.areEqual(this.gender, userInfo.gender) && Intrinsics.areEqual(this.sub, userInfo.sub) && Intrinsics.areEqual(this.ucpId, userInfo.ucpId);
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final Integer getGender() {
            return this.gender;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getSub() {
            return this.sub;
        }

        public final String getUcpId() {
            return this.ucpId;
        }

        public int hashCode() {
            int iA = AbstractC1553e.a(this.firstName, this.lastName.hashCode() * 31, 31);
            Integer num = this.gender;
            int iHashCode = (iA + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.sub;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.ucpId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UserInfo(lastName=");
            sb.append(this.lastName);
            sb.append(", firstName=");
            sb.append(this.firstName);
            sb.append(", gender=");
            sb.append(this.gender);
            sb.append(", sub=");
            sb.append(this.sub);
            sb.append(", ucpId=");
            return Q1.a(sb, this.ucpId, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int iIntValue;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.lastName);
            parcel.writeString(this.firstName);
            Integer num = this.gender;
            if (num == null) {
                iIntValue = 0;
            } else {
                parcel.writeInt(1);
                iIntValue = num.intValue();
            }
            parcel.writeInt(iIntValue);
            parcel.writeString(this.sub);
            parcel.writeString(this.ucpId);
        }

        public /* synthetic */ UserInfo(String str, String str2, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }
    }

    public ListOfCardsResponseBody(UserInfo userInfo, OrderInfo orderInfo, PaymentToolInfo paymentToolInfo, MerchantInfo merchantInfo, ButtonBnpl buttonBnpl, PromoInfo promoInfo, FormInfo formInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(orderInfo, "orderInfo");
        Intrinsics.checkNotNullParameter(paymentToolInfo, "paymentToolInfo");
        this.userInfo = userInfo;
        this.orderInfo = orderInfo;
        this.paymentToolInfo = paymentToolInfo;
        this.merchantInfo = merchantInfo;
        this.buttonBnpl = buttonBnpl;
        this.promoInfo = promoInfo;
        this.formInfo = formInfo;
    }

    public static /* synthetic */ ListOfCardsResponseBody copy$default(ListOfCardsResponseBody listOfCardsResponseBody, UserInfo userInfo, OrderInfo orderInfo, PaymentToolInfo paymentToolInfo, MerchantInfo merchantInfo, ButtonBnpl buttonBnpl, PromoInfo promoInfo, FormInfo formInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            userInfo = listOfCardsResponseBody.userInfo;
        }
        if ((i & 2) != 0) {
            orderInfo = listOfCardsResponseBody.orderInfo;
        }
        OrderInfo orderInfo2 = orderInfo;
        if ((i & 4) != 0) {
            paymentToolInfo = listOfCardsResponseBody.paymentToolInfo;
        }
        PaymentToolInfo paymentToolInfo2 = paymentToolInfo;
        if ((i & 8) != 0) {
            merchantInfo = listOfCardsResponseBody.merchantInfo;
        }
        MerchantInfo merchantInfo2 = merchantInfo;
        if ((i & 16) != 0) {
            buttonBnpl = listOfCardsResponseBody.buttonBnpl;
        }
        ButtonBnpl buttonBnpl2 = buttonBnpl;
        if ((i & 32) != 0) {
            promoInfo = listOfCardsResponseBody.promoInfo;
        }
        PromoInfo promoInfo2 = promoInfo;
        if ((i & 64) != 0) {
            formInfo = listOfCardsResponseBody.formInfo;
        }
        return listOfCardsResponseBody.copy(userInfo, orderInfo2, paymentToolInfo2, merchantInfo2, buttonBnpl2, promoInfo2, formInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final PaymentToolInfo getPaymentToolInfo() {
        return this.paymentToolInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final ButtonBnpl getButtonBnpl() {
        return this.buttonBnpl;
    }

    /* renamed from: component6, reason: from getter */
    public final PromoInfo getPromoInfo() {
        return this.promoInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final FormInfo getFormInfo() {
        return this.formInfo;
    }

    public final ListOfCardsResponseBody copy(UserInfo userInfo, OrderInfo orderInfo, PaymentToolInfo paymentToolInfo, MerchantInfo merchantInfo, ButtonBnpl buttonBnpl, PromoInfo promoInfo, FormInfo formInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(orderInfo, "orderInfo");
        Intrinsics.checkNotNullParameter(paymentToolInfo, "paymentToolInfo");
        return new ListOfCardsResponseBody(userInfo, orderInfo, paymentToolInfo, merchantInfo, buttonBnpl, promoInfo, formInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListOfCardsResponseBody)) {
            return false;
        }
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) other;
        return Intrinsics.areEqual(this.userInfo, listOfCardsResponseBody.userInfo) && Intrinsics.areEqual(this.orderInfo, listOfCardsResponseBody.orderInfo) && Intrinsics.areEqual(this.paymentToolInfo, listOfCardsResponseBody.paymentToolInfo) && Intrinsics.areEqual(this.merchantInfo, listOfCardsResponseBody.merchantInfo) && Intrinsics.areEqual(this.buttonBnpl, listOfCardsResponseBody.buttonBnpl) && Intrinsics.areEqual(this.promoInfo, listOfCardsResponseBody.promoInfo) && Intrinsics.areEqual(this.formInfo, listOfCardsResponseBody.formInfo);
    }

    public final ButtonBnpl getButtonBnpl() {
        return this.buttonBnpl;
    }

    public final FormInfo getFormInfo() {
        return this.formInfo;
    }

    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public final OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public final PaymentToolInfo getPaymentToolInfo() {
        return this.paymentToolInfo;
    }

    public final PromoInfo getPromoInfo() {
        return this.promoInfo;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        int iHashCode = (this.paymentToolInfo.hashCode() + ((this.orderInfo.hashCode() + (this.userInfo.hashCode() * 31)) * 31)) * 31;
        MerchantInfo merchantInfo = this.merchantInfo;
        int iHashCode2 = (iHashCode + (merchantInfo == null ? 0 : merchantInfo.hashCode())) * 31;
        ButtonBnpl buttonBnpl = this.buttonBnpl;
        int iHashCode3 = (iHashCode2 + (buttonBnpl == null ? 0 : buttonBnpl.hashCode())) * 31;
        PromoInfo promoInfo = this.promoInfo;
        int iHashCode4 = (iHashCode3 + (promoInfo == null ? 0 : promoInfo.hashCode())) * 31;
        FormInfo formInfo = this.formInfo;
        return iHashCode4 + (formInfo != null ? formInfo.hashCode() : 0);
    }

    public String toString() {
        return "ListOfCardsResponseBody(userInfo=" + this.userInfo + ", orderInfo=" + this.orderInfo + ", paymentToolInfo=" + this.paymentToolInfo + ", merchantInfo=" + this.merchantInfo + ", buttonBnpl=" + this.buttonBnpl + ", promoInfo=" + this.promoInfo + ", formInfo=" + this.formInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.userInfo.writeToParcel(parcel, flags);
        this.orderInfo.writeToParcel(parcel, flags);
        this.paymentToolInfo.writeToParcel(parcel, flags);
        MerchantInfo merchantInfo = this.merchantInfo;
        if (merchantInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            merchantInfo.writeToParcel(parcel, flags);
        }
        ButtonBnpl buttonBnpl = this.buttonBnpl;
        if (buttonBnpl == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            buttonBnpl.writeToParcel(parcel, flags);
        }
        PromoInfo promoInfo = this.promoInfo;
        if (promoInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            promoInfo.writeToParcel(parcel, flags);
        }
        FormInfo formInfo = this.formInfo;
        if (formInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            formInfo.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ ListOfCardsResponseBody(UserInfo userInfo, OrderInfo orderInfo, PaymentToolInfo paymentToolInfo, MerchantInfo merchantInfo, ButtonBnpl buttonBnpl, PromoInfo promoInfo, FormInfo formInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userInfo, orderInfo, paymentToolInfo, (i & 8) != 0 ? null : merchantInfo, (i & 16) != 0 ? null : buttonBnpl, (i & 32) != 0 ? null : promoInfo, (i & 64) != 0 ? null : formInfo);
    }
}
