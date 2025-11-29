package com.sputnik.common.entities.tiles;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tile.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/entities/tiles/Tile;", "", "", "id", "", "identifier", "imgLink", "deeplink", "", "pinned", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getIdentifier", "getImgLink", "getDeeplink", "Ljava/lang/Boolean;", "getPinned", "()Ljava/lang/Boolean;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Tile {
    private final String deeplink;
    private final Integer id;
    private final String identifier;
    private final String imgLink;
    private final Boolean pinned;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return Intrinsics.areEqual(this.id, tile.id) && Intrinsics.areEqual(this.identifier, tile.identifier) && Intrinsics.areEqual(this.imgLink, tile.imgLink) && Intrinsics.areEqual(this.deeplink, tile.deeplink) && Intrinsics.areEqual(this.pinned, tile.pinned);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imgLink;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deeplink;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.pinned;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "Tile(id=" + this.id + ", identifier=" + this.identifier + ", imgLink=" + this.imgLink + ", deeplink=" + this.deeplink + ", pinned=" + this.pinned + ")";
    }

    public Tile(Integer num, String str, String str2, String str3, Boolean bool) {
        this.id = num;
        this.identifier = str;
        this.imgLink = str2;
        this.deeplink = str3;
        this.pinned = bool;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getImgLink() {
        return this.imgLink;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }
}
