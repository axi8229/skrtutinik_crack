package ru.yoomoney.sdk.auth.api.account.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneConfirmPhone;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "validUntil", "nextResendFrom", "secretLength", "", "attemptsLeft", "phone", "isCurrentUserAccountPhone", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLorg/threeten/bp/OffsetDateTime;Lorg/threeten/bp/OffsetDateTime;IILjava/lang/String;Z)V", "getAddToBackStack", "()Z", "getAttemptsLeft", "()I", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getNextResendFrom", "getPhone", "getSecretLength", "getValidUntil", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ChangePhoneConfirmPhone extends ChangePhoneProcess {

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("attemptsLeft")
    private final int attemptsLeft;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("isCurrentUserAccountPhone")
    private final boolean isCurrentUserAccountPhone;

    @SerializedName("nextResendFrom")
    private final OffsetDateTime nextResendFrom;

    @SerializedName("phone")
    private final String phone;

    @SerializedName("secretLength")
    private final int secretLength;

    @SerializedName("validUntil")
    private final OffsetDateTime validUntil;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangePhoneConfirmPhone(String id, OffsetDateTime expireAt, boolean z, OffsetDateTime validUntil, OffsetDateTime nextResendFrom, int i, int i2, String phone, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.validUntil = validUntil;
        this.nextResendFrom = nextResendFrom;
        this.secretLength = i;
        this.attemptsLeft = i2;
        this.phone = phone;
        this.isCurrentUserAccountPhone = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    /* renamed from: component4, reason: from getter */
    public final OffsetDateTime getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component5, reason: from getter */
    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSecretLength() {
        return this.secretLength;
    }

    /* renamed from: component7, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsCurrentUserAccountPhone() {
        return this.isCurrentUserAccountPhone;
    }

    public final ChangePhoneConfirmPhone copy(String id, OffsetDateTime expireAt, boolean addToBackStack, OffsetDateTime validUntil, OffsetDateTime nextResendFrom, int secretLength, int attemptsLeft, String phone, boolean isCurrentUserAccountPhone) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new ChangePhoneConfirmPhone(id, expireAt, addToBackStack, validUntil, nextResendFrom, secretLength, attemptsLeft, phone, isCurrentUserAccountPhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangePhoneConfirmPhone)) {
            return false;
        }
        ChangePhoneConfirmPhone changePhoneConfirmPhone = (ChangePhoneConfirmPhone) other;
        return Intrinsics.areEqual(this.id, changePhoneConfirmPhone.id) && Intrinsics.areEqual(this.expireAt, changePhoneConfirmPhone.expireAt) && this.addToBackStack == changePhoneConfirmPhone.addToBackStack && Intrinsics.areEqual(this.validUntil, changePhoneConfirmPhone.validUntil) && Intrinsics.areEqual(this.nextResendFrom, changePhoneConfirmPhone.nextResendFrom) && this.secretLength == changePhoneConfirmPhone.secretLength && this.attemptsLeft == changePhoneConfirmPhone.attemptsLeft && Intrinsics.areEqual(this.phone, changePhoneConfirmPhone.phone) && this.isCurrentUserAccountPhone == changePhoneConfirmPhone.isCurrentUserAccountPhone;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getSecretLength() {
        return this.secretLength;
    }

    public final OffsetDateTime getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isCurrentUserAccountPhone) + ru.yoomoney.sdk.auth.a.a(this.phone, a.a(this.attemptsLeft, a.a(this.secretLength, b.a(this.nextResendFrom, b.a(this.validUntil, ru.yoomoney.sdk.auth.b.a(this.addToBackStack, b.a(this.expireAt, this.id.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    public final boolean isCurrentUserAccountPhone() {
        return this.isCurrentUserAccountPhone;
    }

    public String toString() {
        return "ChangePhoneConfirmPhone(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", validUntil=" + this.validUntil + ", nextResendFrom=" + this.nextResendFrom + ", secretLength=" + this.secretLength + ", attemptsLeft=" + this.attemptsLeft + ", phone=" + this.phone + ", isCurrentUserAccountPhone=" + this.isCurrentUserAccountPhone + ")";
    }
}
