package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.account.model.a;
import ru.yoomoney.sdk.auth.api.account.model.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006)"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessConfirmEmail;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "validUntil", "nextResendFrom", "secretLength", "", "attemptsLeft", Scopes.EMAIL, "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLorg/threeten/bp/OffsetDateTime;Lorg/threeten/bp/OffsetDateTime;IILjava/lang/String;)V", "getAddToBackStack", "()Z", "getAttemptsLeft", "()I", "getEmail", "()Ljava/lang/String;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "getNextResendFrom", "getSecretLength", "getValidUntil", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationProcessConfirmEmail extends MigrationProcess {

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("attemptsLeft")
    private final int attemptsLeft;

    @SerializedName(Scopes.EMAIL)
    private final String email;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("nextResendFrom")
    private final OffsetDateTime nextResendFrom;

    @SerializedName("secretLength")
    private final int secretLength;

    @SerializedName("validUntil")
    private final OffsetDateTime validUntil;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationProcessConfirmEmail(String id, OffsetDateTime expireAt, boolean z, OffsetDateTime validUntil, OffsetDateTime nextResendFrom, int i, int i2, String email) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        Intrinsics.checkNotNullParameter(email, "email");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.validUntil = validUntil;
        this.nextResendFrom = nextResendFrom;
        this.secretLength = i;
        this.attemptsLeft = i2;
        this.email = email;
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
    public final String getEmail() {
        return this.email;
    }

    public final MigrationProcessConfirmEmail copy(String id, OffsetDateTime expireAt, boolean addToBackStack, OffsetDateTime validUntil, OffsetDateTime nextResendFrom, int secretLength, int attemptsLeft, String email) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        Intrinsics.checkNotNullParameter(email, "email");
        return new MigrationProcessConfirmEmail(id, expireAt, addToBackStack, validUntil, nextResendFrom, secretLength, attemptsLeft, email);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationProcessConfirmEmail)) {
            return false;
        }
        MigrationProcessConfirmEmail migrationProcessConfirmEmail = (MigrationProcessConfirmEmail) other;
        return Intrinsics.areEqual(this.id, migrationProcessConfirmEmail.id) && Intrinsics.areEqual(this.expireAt, migrationProcessConfirmEmail.expireAt) && this.addToBackStack == migrationProcessConfirmEmail.addToBackStack && Intrinsics.areEqual(this.validUntil, migrationProcessConfirmEmail.validUntil) && Intrinsics.areEqual(this.nextResendFrom, migrationProcessConfirmEmail.nextResendFrom) && this.secretLength == migrationProcessConfirmEmail.secretLength && this.attemptsLeft == migrationProcessConfirmEmail.attemptsLeft && Intrinsics.areEqual(this.email, migrationProcessConfirmEmail.email);
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final String getEmail() {
        return this.email;
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

    public final int getSecretLength() {
        return this.secretLength;
    }

    public final OffsetDateTime getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        return this.email.hashCode() + a.a(this.attemptsLeft, a.a(this.secretLength, b.a(this.nextResendFrom, b.a(this.validUntil, ru.yoomoney.sdk.auth.b.a(this.addToBackStack, b.a(this.expireAt, this.id.hashCode() * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "MigrationProcessConfirmEmail(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", validUntil=" + this.validUntil + ", nextResendFrom=" + this.nextResendFrom + ", secretLength=" + this.secretLength + ", attemptsLeft=" + this.attemptsLeft + ", email=" + this.email + ")";
    }
}
