package com.sputnik.domain.entities.digital_keys;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainDigitalKey.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "", "", "uuid", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "expTime", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getValue", "Ljava/lang/Long;", "getExpTime", "()Ljava/lang/Long;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "getType", "()Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainDigitalKey {
    private final Long expTime;
    private final TypeDigitalKey type;
    private final String uuid;
    private final String value;

    public DomainDigitalKey() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainDigitalKey)) {
            return false;
        }
        DomainDigitalKey domainDigitalKey = (DomainDigitalKey) other;
        return Intrinsics.areEqual(this.uuid, domainDigitalKey.uuid) && Intrinsics.areEqual(this.value, domainDigitalKey.value) && Intrinsics.areEqual(this.expTime, domainDigitalKey.expTime) && this.type == domainDigitalKey.type;
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.expTime;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        TypeDigitalKey typeDigitalKey = this.type;
        return iHashCode3 + (typeDigitalKey != null ? typeDigitalKey.hashCode() : 0);
    }

    public String toString() {
        return "DomainDigitalKey(uuid=" + this.uuid + ", value=" + this.value + ", expTime=" + this.expTime + ", type=" + this.type + ")";
    }

    public DomainDigitalKey(String str, String str2, Long l, TypeDigitalKey typeDigitalKey) {
        this.uuid = str;
        this.value = str2;
        this.expTime = l;
        this.type = typeDigitalKey;
    }

    public /* synthetic */ DomainDigitalKey(String str, String str2, Long l, TypeDigitalKey typeDigitalKey, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : typeDigitalKey);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getValue() {
        return this.value;
    }

    public final Long getExpTime() {
        return this.expTime;
    }

    public final TypeDigitalKey getType() {
        return this.type;
    }
}
