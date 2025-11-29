package com.sputnik.domain.entities.notifications;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.buttons.ColorsButton;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainNotification.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)Bg\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b!\u0010\u0013R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b%\u0010\u0013R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/sputnik/domain/entities/notifications/DomainNotification;", "", "", "id", "", "identifier", "identifierHuman", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", CrashHianalyticsData.MESSAGE, "", "viewed", "createdAt", "", "Lcom/sputnik/domain/entities/notifications/DomainNotification$DomainButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getIdentifier", "getIdentifierHuman", "getTitle", "getDeeplink", "getMessage", "Ljava/lang/Boolean;", "getViewed", "()Ljava/lang/Boolean;", "getCreatedAt", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "DomainButton", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainNotification {
    private final List<DomainButton> buttons;
    private final String createdAt;
    private final String deeplink;
    private final Integer id;
    private final String identifier;
    private final String identifierHuman;
    private final String message;
    private final String title;
    private final Boolean viewed;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainNotification)) {
            return false;
        }
        DomainNotification domainNotification = (DomainNotification) other;
        return Intrinsics.areEqual(this.id, domainNotification.id) && Intrinsics.areEqual(this.identifier, domainNotification.identifier) && Intrinsics.areEqual(this.identifierHuman, domainNotification.identifierHuman) && Intrinsics.areEqual(this.title, domainNotification.title) && Intrinsics.areEqual(this.deeplink, domainNotification.deeplink) && Intrinsics.areEqual(this.message, domainNotification.message) && Intrinsics.areEqual(this.viewed, domainNotification.viewed) && Intrinsics.areEqual(this.createdAt, domainNotification.createdAt) && Intrinsics.areEqual(this.buttons, domainNotification.buttons);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.identifierHuman;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.message;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.viewed;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.createdAt;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<DomainButton> list = this.buttons;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DomainNotification(id=" + this.id + ", identifier=" + this.identifier + ", identifierHuman=" + this.identifierHuman + ", title=" + this.title + ", deeplink=" + this.deeplink + ", message=" + this.message + ", viewed=" + this.viewed + ", createdAt=" + this.createdAt + ", buttons=" + this.buttons + ")";
    }

    public DomainNotification(Integer num, String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, List<DomainButton> list) {
        this.id = num;
        this.identifier = str;
        this.identifierHuman = str2;
        this.title = str3;
        this.deeplink = str4;
        this.message = str5;
        this.viewed = bool;
        this.createdAt = str6;
        this.buttons = list;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getIdentifierHuman() {
        return this.identifierHuman;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Boolean getViewed() {
        return this.viewed;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final List<DomainButton> getButtons() {
        return this.buttons;
    }

    /* compiled from: DomainNotification.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/sputnik/domain/entities/notifications/DomainNotification$DomainButton;", "", "", "type", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", RemoteMessageConst.Notification.COLOR, "deeplink", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/buttons/ColorsButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", "getColor", "()Lcom/sputnik/domain/entities/buttons/ColorsButton;", "getDeeplink", "getTitle", "getLink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainButton {
        private final ColorsButton color;
        private final String deeplink;
        private final String link;
        private final String title;
        private final String type;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainButton)) {
                return false;
            }
            DomainButton domainButton = (DomainButton) other;
            return Intrinsics.areEqual(this.type, domainButton.type) && this.color == domainButton.color && Intrinsics.areEqual(this.deeplink, domainButton.deeplink) && Intrinsics.areEqual(this.title, domainButton.title) && Intrinsics.areEqual(this.link, domainButton.link);
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            ColorsButton colorsButton = this.color;
            int iHashCode2 = (iHashCode + (colorsButton == null ? 0 : colorsButton.hashCode())) * 31;
            String str2 = this.deeplink;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.title;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.link;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "DomainButton(type=" + this.type + ", color=" + this.color + ", deeplink=" + this.deeplink + ", title=" + this.title + ", link=" + this.link + ")";
        }

        public DomainButton(String str, ColorsButton colorsButton, String str2, String str3, String str4) {
            this.type = str;
            this.color = colorsButton;
            this.deeplink = str2;
            this.title = str3;
            this.link = str4;
        }

        public final String getType() {
            return this.type;
        }

        public final ColorsButton getColor() {
            return this.color;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getLink() {
            return this.link;
        }
    }
}
