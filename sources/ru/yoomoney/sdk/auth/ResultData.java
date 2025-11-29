package ru.yoomoney.sdk.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.OauthResult;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J~\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010;J\t\u0010<\u001a\u00020=HÖ\u0001J\u0013\u0010>\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020=HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020=HÖ\u0001R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001b¨\u0006H"}, d2 = {"Lru/yoomoney/sdk/auth/ResultData;", "Landroid/os/Parcelable;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "marketingNewsLetterByEmailAccepted", "", "marketingNewsLetterByPhoneAccepted", "phone", "userHasEmail", "userAccountWasUpdated", "sberIdResultData", "Landroid/net/Uri;", "oauthLinkStatus", "Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;", YooMoneyAuth.KEY_IDENTIFICATION_ACCESSIBLE, "forceLogin", "(Ljava/lang/String;ZZLjava/lang/String;ZZLandroid/net/Uri;Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getForceLogin", "()Ljava/lang/Boolean;", "setForceLogin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIdentificationAccessible", "setIdentificationAccessible", "getMarketingNewsLetterByEmailAccepted", "()Z", "setMarketingNewsLetterByEmailAccepted", "(Z)V", "getMarketingNewsLetterByPhoneAccepted", "setMarketingNewsLetterByPhoneAccepted", "getOauthLinkStatus", "()Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;", "setOauthLinkStatus", "(Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;)V", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "getSberIdResultData", "()Landroid/net/Uri;", "setSberIdResultData", "(Landroid/net/Uri;)V", "getTmxSessionId", "setTmxSessionId", "getUserAccountWasUpdated", "setUserAccountWasUpdated", "getUserHasEmail", "setUserHasEmail", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZZLjava/lang/String;ZZLandroid/net/Uri;Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lru/yoomoney/sdk/auth/ResultData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ResultData implements Parcelable {
    public static final Parcelable.Creator<ResultData> CREATOR = new Creator();
    private Boolean forceLogin;
    private Boolean identificationAccessible;
    private boolean marketingNewsLetterByEmailAccepted;
    private boolean marketingNewsLetterByPhoneAccepted;
    private OauthResult.OauthLinkStatus oauthLinkStatus;
    private String phone;
    private Uri sberIdResultData;
    private String tmxSessionId;
    private boolean userAccountWasUpdated;
    private boolean userHasEmail;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ResultData> {
        @Override // android.os.Parcelable.Creator
        public final ResultData createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            String string2 = parcel.readString();
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            Uri uri = (Uri) parcel.readParcelable(ResultData.class.getClassLoader());
            Boolean boolValueOf2 = null;
            OauthResult.OauthLinkStatus oauthLinkStatusValueOf = parcel.readInt() == 0 ? null : OauthResult.OauthLinkStatus.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ResultData(string, z, z2, string2, z3, z4, uri, oauthLinkStatusValueOf, boolValueOf, boolValueOf2);
        }

        @Override // android.os.Parcelable.Creator
        public final ResultData[] newArray(int i) {
            return new ResultData[i];
        }
    }

    public ResultData() {
        this(null, false, false, null, false, false, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getForceLogin() {
        return this.forceLogin;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getMarketingNewsLetterByEmailAccepted() {
        return this.marketingNewsLetterByEmailAccepted;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMarketingNewsLetterByPhoneAccepted() {
        return this.marketingNewsLetterByPhoneAccepted;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getUserHasEmail() {
        return this.userHasEmail;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUserAccountWasUpdated() {
        return this.userAccountWasUpdated;
    }

    /* renamed from: component7, reason: from getter */
    public final Uri getSberIdResultData() {
        return this.sberIdResultData;
    }

    /* renamed from: component8, reason: from getter */
    public final OauthResult.OauthLinkStatus getOauthLinkStatus() {
        return this.oauthLinkStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getIdentificationAccessible() {
        return this.identificationAccessible;
    }

    public final ResultData copy(String tmxSessionId, boolean marketingNewsLetterByEmailAccepted, boolean marketingNewsLetterByPhoneAccepted, String phone, boolean userHasEmail, boolean userAccountWasUpdated, Uri sberIdResultData, OauthResult.OauthLinkStatus oauthLinkStatus, Boolean identificationAccessible, Boolean forceLogin) {
        return new ResultData(tmxSessionId, marketingNewsLetterByEmailAccepted, marketingNewsLetterByPhoneAccepted, phone, userHasEmail, userAccountWasUpdated, sberIdResultData, oauthLinkStatus, identificationAccessible, forceLogin);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultData)) {
            return false;
        }
        ResultData resultData = (ResultData) other;
        return Intrinsics.areEqual(this.tmxSessionId, resultData.tmxSessionId) && this.marketingNewsLetterByEmailAccepted == resultData.marketingNewsLetterByEmailAccepted && this.marketingNewsLetterByPhoneAccepted == resultData.marketingNewsLetterByPhoneAccepted && Intrinsics.areEqual(this.phone, resultData.phone) && this.userHasEmail == resultData.userHasEmail && this.userAccountWasUpdated == resultData.userAccountWasUpdated && Intrinsics.areEqual(this.sberIdResultData, resultData.sberIdResultData) && this.oauthLinkStatus == resultData.oauthLinkStatus && Intrinsics.areEqual(this.identificationAccessible, resultData.identificationAccessible) && Intrinsics.areEqual(this.forceLogin, resultData.forceLogin);
    }

    public final Boolean getForceLogin() {
        return this.forceLogin;
    }

    public final Boolean getIdentificationAccessible() {
        return this.identificationAccessible;
    }

    public final boolean getMarketingNewsLetterByEmailAccepted() {
        return this.marketingNewsLetterByEmailAccepted;
    }

    public final boolean getMarketingNewsLetterByPhoneAccepted() {
        return this.marketingNewsLetterByPhoneAccepted;
    }

    public final OauthResult.OauthLinkStatus getOauthLinkStatus() {
        return this.oauthLinkStatus;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final Uri getSberIdResultData() {
        return this.sberIdResultData;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public final boolean getUserAccountWasUpdated() {
        return this.userAccountWasUpdated;
    }

    public final boolean getUserHasEmail() {
        return this.userHasEmail;
    }

    public int hashCode() {
        String str = this.tmxSessionId;
        int iA = b.a(this.marketingNewsLetterByPhoneAccepted, b.a(this.marketingNewsLetterByEmailAccepted, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
        String str2 = this.phone;
        int iA2 = b.a(this.userAccountWasUpdated, b.a(this.userHasEmail, (iA + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31);
        Uri uri = this.sberIdResultData;
        int iHashCode = (iA2 + (uri == null ? 0 : uri.hashCode())) * 31;
        OauthResult.OauthLinkStatus oauthLinkStatus = this.oauthLinkStatus;
        int iHashCode2 = (iHashCode + (oauthLinkStatus == null ? 0 : oauthLinkStatus.hashCode())) * 31;
        Boolean bool = this.identificationAccessible;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.forceLogin;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setForceLogin(Boolean bool) {
        this.forceLogin = bool;
    }

    public final void setIdentificationAccessible(Boolean bool) {
        this.identificationAccessible = bool;
    }

    public final void setMarketingNewsLetterByEmailAccepted(boolean z) {
        this.marketingNewsLetterByEmailAccepted = z;
    }

    public final void setMarketingNewsLetterByPhoneAccepted(boolean z) {
        this.marketingNewsLetterByPhoneAccepted = z;
    }

    public final void setOauthLinkStatus(OauthResult.OauthLinkStatus oauthLinkStatus) {
        this.oauthLinkStatus = oauthLinkStatus;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setSberIdResultData(Uri uri) {
        this.sberIdResultData = uri;
    }

    public final void setTmxSessionId(String str) {
        this.tmxSessionId = str;
    }

    public final void setUserAccountWasUpdated(boolean z) {
        this.userAccountWasUpdated = z;
    }

    public final void setUserHasEmail(boolean z) {
        this.userHasEmail = z;
    }

    public String toString() {
        return "ResultData(tmxSessionId=" + this.tmxSessionId + ", marketingNewsLetterByEmailAccepted=" + this.marketingNewsLetterByEmailAccepted + ", marketingNewsLetterByPhoneAccepted=" + this.marketingNewsLetterByPhoneAccepted + ", phone=" + this.phone + ", userHasEmail=" + this.userHasEmail + ", userAccountWasUpdated=" + this.userAccountWasUpdated + ", sberIdResultData=" + this.sberIdResultData + ", oauthLinkStatus=" + this.oauthLinkStatus + ", identificationAccessible=" + this.identificationAccessible + ", forceLogin=" + this.forceLogin + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.tmxSessionId);
        parcel.writeInt(this.marketingNewsLetterByEmailAccepted ? 1 : 0);
        parcel.writeInt(this.marketingNewsLetterByPhoneAccepted ? 1 : 0);
        parcel.writeString(this.phone);
        parcel.writeInt(this.userHasEmail ? 1 : 0);
        parcel.writeInt(this.userAccountWasUpdated ? 1 : 0);
        parcel.writeParcelable(this.sberIdResultData, flags);
        OauthResult.OauthLinkStatus oauthLinkStatus = this.oauthLinkStatus;
        if (oauthLinkStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(oauthLinkStatus.name());
        }
        Boolean bool = this.identificationAccessible;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.forceLogin;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    public ResultData(String str, boolean z, boolean z2, String str2, boolean z3, boolean z4, Uri uri, OauthResult.OauthLinkStatus oauthLinkStatus, Boolean bool, Boolean bool2) {
        this.tmxSessionId = str;
        this.marketingNewsLetterByEmailAccepted = z;
        this.marketingNewsLetterByPhoneAccepted = z2;
        this.phone = str2;
        this.userHasEmail = z3;
        this.userAccountWasUpdated = z4;
        this.sberIdResultData = uri;
        this.oauthLinkStatus = oauthLinkStatus;
        this.identificationAccessible = bool;
        this.forceLogin = bool2;
    }

    public /* synthetic */ ResultData(String str, boolean z, boolean z2, String str2, boolean z3, boolean z4, Uri uri, OauthResult.OauthLinkStatus oauthLinkStatus, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? true : z3, (i & 32) == 0 ? z4 : false, (i & 64) != 0 ? null : uri, (i & 128) != 0 ? null : oauthLinkStatus, (i & 256) != 0 ? null : bool, (i & 512) == 0 ? bool2 : null);
    }
}
