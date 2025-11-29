package com.sputnik.domain.entities.popups;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/popups/DomainBar;", "", "", "trackColor", "progressColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTrackColor", "getProgressColor", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainBar {
    private final String progressColor;
    private final String trackColor;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainBar)) {
            return false;
        }
        DomainBar domainBar = (DomainBar) other;
        return Intrinsics.areEqual(this.trackColor, domainBar.trackColor) && Intrinsics.areEqual(this.progressColor, domainBar.progressColor);
    }

    public int hashCode() {
        String str = this.trackColor;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.progressColor;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DomainBar(trackColor=" + this.trackColor + ", progressColor=" + this.progressColor + ")";
    }

    public DomainBar(String str, String str2) {
        this.trackColor = str;
        this.progressColor = str2;
    }

    public final String getTrackColor() {
        return this.trackColor;
    }

    public final String getProgressColor() {
        return this.progressColor;
    }
}
