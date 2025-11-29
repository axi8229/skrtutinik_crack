package com.sputnik.domain.entities.alers;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainAlertAppearance.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/sputnik/domain/entities/alers/DomainAlertAppearance;", "", "Lcom/sputnik/domain/entities/alers/TextWith1Param;", "body", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Lcom/sputnik/domain/entities/alers/TextWith1Param;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/alers/TextWith1Param;", "getBody", "()Lcom/sputnik/domain/entities/alers/TextWith1Param;", "Ljava/lang/String;", "getTitle", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainAlertAppearance {
    private final TextWith1Param body;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainAlertAppearance)) {
            return false;
        }
        DomainAlertAppearance domainAlertAppearance = (DomainAlertAppearance) other;
        return Intrinsics.areEqual(this.body, domainAlertAppearance.body) && Intrinsics.areEqual(this.title, domainAlertAppearance.title);
    }

    public int hashCode() {
        TextWith1Param textWith1Param = this.body;
        int iHashCode = (textWith1Param == null ? 0 : textWith1Param.hashCode()) * 31;
        String str = this.title;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DomainAlertAppearance(body=" + this.body + ", title=" + this.title + ")";
    }

    public DomainAlertAppearance(TextWith1Param textWith1Param, String str) {
        this.body = textWith1Param;
        this.title = str;
    }

    public final TextWith1Param getBody() {
        return this.body;
    }

    public final String getTitle() {
        return this.title;
    }
}
