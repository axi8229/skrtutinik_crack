package com.sputnik.domain.entities.popups;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/sputnik/domain/entities/popups/DomainButton;", "", "", "text", "deeplink", "textColor", "backgroundColor", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getDeeplink", "getTextColor", "getBackgroundColor", "getAction", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainButton {
    private final String action;
    private final String backgroundColor;
    private final String deeplink;
    private final String text;
    private final String textColor;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainButton)) {
            return false;
        }
        DomainButton domainButton = (DomainButton) other;
        return Intrinsics.areEqual(this.text, domainButton.text) && Intrinsics.areEqual(this.deeplink, domainButton.deeplink) && Intrinsics.areEqual(this.textColor, domainButton.textColor) && Intrinsics.areEqual(this.backgroundColor, domainButton.backgroundColor) && Intrinsics.areEqual(this.action, domainButton.action);
    }

    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.deeplink.hashCode()) * 31;
        String str = this.textColor;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.action;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DomainButton(text=" + this.text + ", deeplink=" + this.deeplink + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", action=" + this.action + ")";
    }

    public DomainButton(String text, String deeplink, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        this.text = text;
        this.deeplink = deeplink;
        this.textColor = str;
        this.backgroundColor = str2;
        this.action = str3;
    }

    public final String getText() {
        return this.text;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getAction() {
        return this.action;
    }
}
