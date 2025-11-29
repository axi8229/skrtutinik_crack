package ru.yoomoney.sdk.auth.api.cryptogramAuth.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;", "", "hash", "", "salt", "authCryptogram", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthCryptogram", "()Ljava/lang/String;", "getHash", "getSalt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CryptogramAuthValidateRequest {

    @SerializedName("authCryptogram")
    private final String authCryptogram;

    @SerializedName("hash")
    private final String hash;

    @SerializedName("salt")
    private final String salt;

    public CryptogramAuthValidateRequest(String hash, String salt, String authCryptogram) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(authCryptogram, "authCryptogram");
        this.hash = hash;
        this.salt = salt;
        this.authCryptogram = authCryptogram;
    }

    public static /* synthetic */ CryptogramAuthValidateRequest copy$default(CryptogramAuthValidateRequest cryptogramAuthValidateRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cryptogramAuthValidateRequest.hash;
        }
        if ((i & 2) != 0) {
            str2 = cryptogramAuthValidateRequest.salt;
        }
        if ((i & 4) != 0) {
            str3 = cryptogramAuthValidateRequest.authCryptogram;
        }
        return cryptogramAuthValidateRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSalt() {
        return this.salt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthCryptogram() {
        return this.authCryptogram;
    }

    public final CryptogramAuthValidateRequest copy(String hash, String salt, String authCryptogram) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(authCryptogram, "authCryptogram");
        return new CryptogramAuthValidateRequest(hash, salt, authCryptogram);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CryptogramAuthValidateRequest)) {
            return false;
        }
        CryptogramAuthValidateRequest cryptogramAuthValidateRequest = (CryptogramAuthValidateRequest) other;
        return Intrinsics.areEqual(this.hash, cryptogramAuthValidateRequest.hash) && Intrinsics.areEqual(this.salt, cryptogramAuthValidateRequest.salt) && Intrinsics.areEqual(this.authCryptogram, cryptogramAuthValidateRequest.authCryptogram);
    }

    public final String getAuthCryptogram() {
        return this.authCryptogram;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getSalt() {
        return this.salt;
    }

    public int hashCode() {
        return this.authCryptogram.hashCode() + a.a(this.salt, this.hash.hashCode() * 31, 31);
    }

    public String toString() {
        return "CryptogramAuthValidateRequest(hash=" + this.hash + ", salt=" + this.salt + ", authCryptogram=" + this.authCryptogram + ")";
    }
}
