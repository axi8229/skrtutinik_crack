package com.sputnik.domain.entities.call_history;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.entities.call.CallState;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCallHistory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u000fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u000fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "", "", "createdAt", "imageUrl", "videoUrl", "flatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "state", "address", FailedBinderCallBack.CALLER_ID, "deviceUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCreatedAt", "getImageUrl", "getVideoUrl", "getFlatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "getAddress", "getCallId", "getDeviceUuid", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCallHistory {
    private final String address;
    private final String callId;
    private final String createdAt;
    private final String deviceUuid;
    private final String flatUUID;
    private final String imageUrl;
    private final CallState state;
    private final String videoUrl;

    public DomainCallHistory() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCallHistory)) {
            return false;
        }
        DomainCallHistory domainCallHistory = (DomainCallHistory) other;
        return Intrinsics.areEqual(this.createdAt, domainCallHistory.createdAt) && Intrinsics.areEqual(this.imageUrl, domainCallHistory.imageUrl) && Intrinsics.areEqual(this.videoUrl, domainCallHistory.videoUrl) && Intrinsics.areEqual(this.flatUUID, domainCallHistory.flatUUID) && this.state == domainCallHistory.state && Intrinsics.areEqual(this.address, domainCallHistory.address) && Intrinsics.areEqual(this.callId, domainCallHistory.callId) && Intrinsics.areEqual(this.deviceUuid, domainCallHistory.deviceUuid);
    }

    public int hashCode() {
        String str = this.createdAt;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.flatUUID;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CallState callState = this.state;
        int iHashCode5 = (iHashCode4 + (callState == null ? 0 : callState.hashCode())) * 31;
        String str5 = this.address;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.callId;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.deviceUuid;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "DomainCallHistory(createdAt=" + this.createdAt + ", imageUrl=" + this.imageUrl + ", videoUrl=" + this.videoUrl + ", flatUUID=" + this.flatUUID + ", state=" + this.state + ", address=" + this.address + ", callId=" + this.callId + ", deviceUuid=" + this.deviceUuid + ")";
    }

    public DomainCallHistory(String str, String str2, String str3, String str4, CallState callState, String str5, String str6, String str7) {
        this.createdAt = str;
        this.imageUrl = str2;
        this.videoUrl = str3;
        this.flatUUID = str4;
        this.state = callState;
        this.address = str5;
        this.callId = str6;
        this.deviceUuid = str7;
    }

    public /* synthetic */ DomainCallHistory(String str, String str2, String str3, String str4, CallState callState, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : callState, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getFlatUUID() {
        return this.flatUUID;
    }

    public final CallState getState() {
        return this.state;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getDeviceUuid() {
        return this.deviceUuid;
    }
}
