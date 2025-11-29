package sputnik.axmor.com.sputnik.services.ble_service;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScanParameters.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/ScanParameters;", "", "Ljava/util/UUID;", "uuid", "", "major", "minor", "<init>", "(Ljava/util/UUID;II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "I", "getMajor", "getMinor", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ScanParameters {
    private final int major;
    private final int minor;
    private final UUID uuid;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanParameters)) {
            return false;
        }
        ScanParameters scanParameters = (ScanParameters) other;
        return Intrinsics.areEqual(this.uuid, scanParameters.uuid) && this.major == scanParameters.major && this.minor == scanParameters.minor;
    }

    public int hashCode() {
        return (((this.uuid.hashCode() * 31) + Integer.hashCode(this.major)) * 31) + Integer.hashCode(this.minor);
    }

    public String toString() {
        return "ScanParameters(uuid=" + this.uuid + ", major=" + this.major + ", minor=" + this.minor + ")";
    }

    public ScanParameters(UUID uuid, int i, int i2) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.major = i;
        this.minor = i2;
    }
}
