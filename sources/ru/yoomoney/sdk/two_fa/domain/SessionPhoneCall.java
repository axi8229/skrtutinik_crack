package ru.yoomoney.sdk.two_fa.domain;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\tHÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/SessionPhoneCall;", "Lru/yoomoney/sdk/two_fa/domain/Session;", "Landroid/os/Parcelable;", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "nextAvailableFrom", "phone", "", "codeLength", "", "attemptsLeft", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Ljava/lang/String;II)V", "getAttemptsLeft", "()I", "getCodeLength", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getPhone", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/two_fa/domain/SessionType;", "getValidUntil", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionPhoneCall extends Session implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SessionPhoneCall> CREATOR = new Creator();
    private final int attemptsLeft;
    private final int codeLength;
    private final LocalDateTime nextAvailableFrom;
    private final String phone;
    private final SessionType type;
    private final LocalDateTime validUntil;

    /* compiled from: Domain.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SessionPhoneCall> {
        @Override // android.os.Parcelable.Creator
        public final SessionPhoneCall createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SessionPhoneCall(SessionType.CREATOR.createFromParcel(parcel), (LocalDateTime) parcel.readSerializable(), (LocalDateTime) parcel.readSerializable(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SessionPhoneCall[] newArray(int i) {
            return new SessionPhoneCall[i];
        }
    }

    public static /* synthetic */ SessionPhoneCall copy$default(SessionPhoneCall sessionPhoneCall, SessionType sessionType, LocalDateTime localDateTime, LocalDateTime localDateTime2, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            sessionType = sessionPhoneCall.type;
        }
        if ((i3 & 2) != 0) {
            localDateTime = sessionPhoneCall.validUntil;
        }
        LocalDateTime localDateTime3 = localDateTime;
        if ((i3 & 4) != 0) {
            localDateTime2 = sessionPhoneCall.nextAvailableFrom;
        }
        LocalDateTime localDateTime4 = localDateTime2;
        if ((i3 & 8) != 0) {
            str = sessionPhoneCall.phone;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            i = sessionPhoneCall.codeLength;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = sessionPhoneCall.attemptsLeft;
        }
        return sessionPhoneCall.copy(sessionType, localDateTime3, localDateTime4, str2, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final SessionType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getNextAvailableFrom() {
        return this.nextAvailableFrom;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCodeLength() {
        return this.codeLength;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final SessionPhoneCall copy(SessionType type, LocalDateTime validUntil, LocalDateTime nextAvailableFrom, String phone, int codeLength, int attemptsLeft) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new SessionPhoneCall(type, validUntil, nextAvailableFrom, phone, codeLength, attemptsLeft);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionPhoneCall)) {
            return false;
        }
        SessionPhoneCall sessionPhoneCall = (SessionPhoneCall) other;
        return this.type == sessionPhoneCall.type && Intrinsics.areEqual(this.validUntil, sessionPhoneCall.validUntil) && Intrinsics.areEqual(this.nextAvailableFrom, sessionPhoneCall.nextAvailableFrom) && Intrinsics.areEqual(this.phone, sessionPhoneCall.phone) && this.codeLength == sessionPhoneCall.codeLength && this.attemptsLeft == sessionPhoneCall.attemptsLeft;
    }

    public int hashCode() {
        return (((((((((this.type.hashCode() * 31) + this.validUntil.hashCode()) * 31) + this.nextAvailableFrom.hashCode()) * 31) + this.phone.hashCode()) * 31) + Integer.hashCode(this.codeLength)) * 31) + Integer.hashCode(this.attemptsLeft);
    }

    public String toString() {
        return "SessionPhoneCall(type=" + this.type + ", validUntil=" + this.validUntil + ", nextAvailableFrom=" + this.nextAvailableFrom + ", phone=" + this.phone + ", codeLength=" + this.codeLength + ", attemptsLeft=" + this.attemptsLeft + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.type.writeToParcel(parcel, flags);
        parcel.writeSerializable(this.validUntil);
        parcel.writeSerializable(this.nextAvailableFrom);
        parcel.writeString(this.phone);
        parcel.writeInt(this.codeLength);
        parcel.writeInt(this.attemptsLeft);
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public SessionType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public LocalDateTime getNextAvailableFrom() {
        return this.nextAvailableFrom;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPhoneCall(SessionType type, LocalDateTime validUntil, LocalDateTime nextAvailableFrom, String phone, int i, int i2) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.type = type;
        this.validUntil = validUntil;
        this.nextAvailableFrom = nextAvailableFrom;
        this.phone = phone;
        this.codeLength = i;
        this.attemptsLeft = i2;
    }
}
