package com.sputnik.domain.entities.archive;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFlussonic.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "", "", "domain", "sdkUrl", "cameraUUID", "archiveToken", "deviceUUID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDomain", "getSdkUrl", "getCameraUUID", "getArchiveToken", "getDeviceUUID"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainFlussonic {
    private final String archiveToken;
    private final String cameraUUID;
    private final String deviceUUID;
    private final String domain;
    private final String sdkUrl;

    public DomainFlussonic() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainFlussonic)) {
            return false;
        }
        DomainFlussonic domainFlussonic = (DomainFlussonic) other;
        return Intrinsics.areEqual(this.domain, domainFlussonic.domain) && Intrinsics.areEqual(this.sdkUrl, domainFlussonic.sdkUrl) && Intrinsics.areEqual(this.cameraUUID, domainFlussonic.cameraUUID) && Intrinsics.areEqual(this.archiveToken, domainFlussonic.archiveToken) && Intrinsics.areEqual(this.deviceUUID, domainFlussonic.deviceUUID);
    }

    public int hashCode() {
        String str = this.domain;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sdkUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cameraUUID;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.archiveToken;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.deviceUUID;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DomainFlussonic(domain=" + this.domain + ", sdkUrl=" + this.sdkUrl + ", cameraUUID=" + this.cameraUUID + ", archiveToken=" + this.archiveToken + ", deviceUUID=" + this.deviceUUID + ")";
    }

    public DomainFlussonic(String str, String str2, String str3, String str4, String str5) {
        this.domain = str;
        this.sdkUrl = str2;
        this.cameraUUID = str3;
        this.archiveToken = str4;
        this.deviceUUID = str5;
    }

    public /* synthetic */ DomainFlussonic(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getCameraUUID() {
        return this.cameraUUID;
    }

    public final String getArchiveToken() {
        return this.archiveToken;
    }

    public final String getDeviceUUID() {
        return this.deviceUUID;
    }
}
