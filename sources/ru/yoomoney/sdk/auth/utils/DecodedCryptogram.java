package ru.yoomoney.sdk.auth.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/utils/DecodedCryptogram;", "", "sessionTicket", "", "initialVector", "", "encryptedJson", "(Ljava/lang/String;[B[B)V", "getEncryptedJson", "()[B", "getInitialVector", "getSessionTicket", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DecodedCryptogram {
    private final byte[] encryptedJson;
    private final byte[] initialVector;
    private final String sessionTicket;

    public DecodedCryptogram(String sessionTicket, byte[] initialVector, byte[] encryptedJson) {
        Intrinsics.checkNotNullParameter(sessionTicket, "sessionTicket");
        Intrinsics.checkNotNullParameter(initialVector, "initialVector");
        Intrinsics.checkNotNullParameter(encryptedJson, "encryptedJson");
        this.sessionTicket = sessionTicket;
        this.initialVector = initialVector;
        this.encryptedJson = encryptedJson;
    }

    public static /* synthetic */ DecodedCryptogram copy$default(DecodedCryptogram decodedCryptogram, String str, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = decodedCryptogram.sessionTicket;
        }
        if ((i & 2) != 0) {
            bArr = decodedCryptogram.initialVector;
        }
        if ((i & 4) != 0) {
            bArr2 = decodedCryptogram.encryptedJson;
        }
        return decodedCryptogram.copy(str, bArr, bArr2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionTicket() {
        return this.sessionTicket;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getInitialVector() {
        return this.initialVector;
    }

    /* renamed from: component3, reason: from getter */
    public final byte[] getEncryptedJson() {
        return this.encryptedJson;
    }

    public final DecodedCryptogram copy(String sessionTicket, byte[] initialVector, byte[] encryptedJson) {
        Intrinsics.checkNotNullParameter(sessionTicket, "sessionTicket");
        Intrinsics.checkNotNullParameter(initialVector, "initialVector");
        Intrinsics.checkNotNullParameter(encryptedJson, "encryptedJson");
        return new DecodedCryptogram(sessionTicket, initialVector, encryptedJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(DecodedCryptogram.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.utils.DecodedCryptogram");
        DecodedCryptogram decodedCryptogram = (DecodedCryptogram) other;
        return Intrinsics.areEqual(this.sessionTicket, decodedCryptogram.sessionTicket) && Arrays.equals(this.initialVector, decodedCryptogram.initialVector) && Arrays.equals(this.encryptedJson, decodedCryptogram.encryptedJson);
    }

    public final byte[] getEncryptedJson() {
        return this.encryptedJson;
    }

    public final byte[] getInitialVector() {
        return this.initialVector;
    }

    public final String getSessionTicket() {
        return this.sessionTicket;
    }

    public int hashCode() {
        return Arrays.hashCode(this.encryptedJson) + ((Arrays.hashCode(this.initialVector) + (this.sessionTicket.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "DecodedCryptogram(sessionTicket=" + this.sessionTicket + ", initialVector=" + Arrays.toString(this.initialVector) + ", encryptedJson=" + Arrays.toString(this.encryptedJson) + ")";
    }
}
