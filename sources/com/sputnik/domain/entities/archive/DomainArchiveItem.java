package com.sputnik.domain.entities.archive;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainArchiveItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\f¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/archive/DomainArchiveItem;", "", "", "cameraUUID", "deviceUUID", "playerUrl", "domain", "sdkUrl", "archiveToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCameraUUID", "getDeviceUUID", "getPlayerUrl", "getDomain", "getSdkUrl", "getArchiveToken"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainArchiveItem {
    private final String archiveToken;
    private final String cameraUUID;
    private final String deviceUUID;
    private final String domain;
    private final String playerUrl;
    private final String sdkUrl;

    public DomainArchiveItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainArchiveItem)) {
            return false;
        }
        DomainArchiveItem domainArchiveItem = (DomainArchiveItem) other;
        return Intrinsics.areEqual(this.cameraUUID, domainArchiveItem.cameraUUID) && Intrinsics.areEqual(this.deviceUUID, domainArchiveItem.deviceUUID) && Intrinsics.areEqual(this.playerUrl, domainArchiveItem.playerUrl) && Intrinsics.areEqual(this.domain, domainArchiveItem.domain) && Intrinsics.areEqual(this.sdkUrl, domainArchiveItem.sdkUrl) && Intrinsics.areEqual(this.archiveToken, domainArchiveItem.archiveToken);
    }

    public int hashCode() {
        String str = this.cameraUUID;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceUUID;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playerUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.domain;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sdkUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.archiveToken;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DomainArchiveItem(cameraUUID=" + this.cameraUUID + ", deviceUUID=" + this.deviceUUID + ", playerUrl=" + this.playerUrl + ", domain=" + this.domain + ", sdkUrl=" + this.sdkUrl + ", archiveToken=" + this.archiveToken + ")";
    }

    public DomainArchiveItem(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cameraUUID = str;
        this.deviceUUID = str2;
        this.playerUrl = str3;
        this.domain = str4;
        this.sdkUrl = str5;
        this.archiveToken = str6;
    }

    public /* synthetic */ DomainArchiveItem(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getCameraUUID() {
        return this.cameraUUID;
    }

    public final String getDeviceUUID() {
        return this.deviceUUID;
    }

    public final String getPlayerUrl() {
        return this.playerUrl;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getArchiveToken() {
        return this.archiveToken;
    }
}
