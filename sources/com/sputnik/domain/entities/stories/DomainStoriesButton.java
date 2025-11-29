package com.sputnik.domain.entities.stories;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainStoriesButton.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/stories/DomainStoriesButton;", "", "Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "type", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, RemoteMessageConst.Notification.COLOR, "Lcom/sputnik/domain/entities/stories/DeepLinks;", "deeplink", "<init>", "(Lcom/sputnik/domain/entities/stories/ButtonStoryType;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/stories/DeepLinks;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "getType", "()Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "Ljava/lang/String;", "getTitle", "getColor", "Lcom/sputnik/domain/entities/stories/DeepLinks;", "getDeeplink", "()Lcom/sputnik/domain/entities/stories/DeepLinks;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainStoriesButton {
    private final String color;
    private final DeepLinks deeplink;
    private final String title;
    private final ButtonStoryType type;

    public DomainStoriesButton() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainStoriesButton)) {
            return false;
        }
        DomainStoriesButton domainStoriesButton = (DomainStoriesButton) other;
        return this.type == domainStoriesButton.type && Intrinsics.areEqual(this.title, domainStoriesButton.title) && Intrinsics.areEqual(this.color, domainStoriesButton.color) && this.deeplink == domainStoriesButton.deeplink;
    }

    public int hashCode() {
        ButtonStoryType buttonStoryType = this.type;
        int iHashCode = (buttonStoryType == null ? 0 : buttonStoryType.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.color;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeepLinks deepLinks = this.deeplink;
        return iHashCode3 + (deepLinks != null ? deepLinks.hashCode() : 0);
    }

    public String toString() {
        return "DomainStoriesButton(type=" + this.type + ", title=" + this.title + ", color=" + this.color + ", deeplink=" + this.deeplink + ")";
    }

    public DomainStoriesButton(ButtonStoryType buttonStoryType, String str, String str2, DeepLinks deepLinks) {
        this.type = buttonStoryType;
        this.title = str;
        this.color = str2;
        this.deeplink = deepLinks;
    }

    public /* synthetic */ DomainStoriesButton(ButtonStoryType buttonStoryType, String str, String str2, DeepLinks deepLinks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : buttonStoryType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : deepLinks);
    }

    public final ButtonStoryType getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getColor() {
        return this.color;
    }

    public final DeepLinks getDeeplink() {
        return this.deeplink;
    }
}
