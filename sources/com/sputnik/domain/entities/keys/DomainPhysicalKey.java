package com.sputnik.domain.entities.keys;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPhysicalKey.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", "", "", "uuid", "hex", "", "blocked", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "createdAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getHex", "Ljava/lang/Boolean;", "getBlocked", "()Ljava/lang/Boolean;", "getComment", "getCreatedAt", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPhysicalKey {
    private final Boolean blocked;
    private final String comment;
    private final String createdAt;
    private final String hex;
    private final String uuid;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPhysicalKey)) {
            return false;
        }
        DomainPhysicalKey domainPhysicalKey = (DomainPhysicalKey) other;
        return Intrinsics.areEqual(this.uuid, domainPhysicalKey.uuid) && Intrinsics.areEqual(this.hex, domainPhysicalKey.hex) && Intrinsics.areEqual(this.blocked, domainPhysicalKey.blocked) && Intrinsics.areEqual(this.comment, domainPhysicalKey.comment) && Intrinsics.areEqual(this.createdAt, domainPhysicalKey.createdAt);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hex;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.blocked;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.comment;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createdAt;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DomainPhysicalKey(uuid=" + this.uuid + ", hex=" + this.hex + ", blocked=" + this.blocked + ", comment=" + this.comment + ", createdAt=" + this.createdAt + ")";
    }

    public DomainPhysicalKey(String str, String str2, Boolean bool, String str3, String str4) {
        this.uuid = str;
        this.hex = str2;
        this.blocked = bool;
        this.comment = str3;
        this.createdAt = str4;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getHex() {
        return this.hex;
    }

    public final Boolean getBlocked() {
        return this.blocked;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }
}
