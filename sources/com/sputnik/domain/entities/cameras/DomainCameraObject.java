package com.sputnik.domain.entities.cameras;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCameraObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJX\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "", "", "uuid", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "mainScreenOrder", "widgetOrder", "", "mainScreen", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getTitle", "Ljava/lang/Integer;", "getMainScreenOrder", "()Ljava/lang/Integer;", "getWidgetOrder", "Ljava/lang/Boolean;", "getMainScreen", "()Ljava/lang/Boolean;", "getWidget", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCameraObject {
    private final Boolean mainScreen;
    private final Integer mainScreenOrder;
    private final String title;
    private final String uuid;
    private final Boolean widget;
    private final Integer widgetOrder;

    public DomainCameraObject() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DomainCameraObject copy$default(DomainCameraObject domainCameraObject, String str, String str2, Integer num, Integer num2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = domainCameraObject.uuid;
        }
        if ((i & 2) != 0) {
            str2 = domainCameraObject.title;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            num = domainCameraObject.mainScreenOrder;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = domainCameraObject.widgetOrder;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            bool = domainCameraObject.mainScreen;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            bool2 = domainCameraObject.widget;
        }
        return domainCameraObject.copy(str, str3, num3, num4, bool3, bool2);
    }

    public final DomainCameraObject copy(String uuid, String title, Integer mainScreenOrder, Integer widgetOrder, Boolean mainScreen, Boolean widget) {
        return new DomainCameraObject(uuid, title, mainScreenOrder, widgetOrder, mainScreen, widget);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCameraObject)) {
            return false;
        }
        DomainCameraObject domainCameraObject = (DomainCameraObject) other;
        return Intrinsics.areEqual(this.uuid, domainCameraObject.uuid) && Intrinsics.areEqual(this.title, domainCameraObject.title) && Intrinsics.areEqual(this.mainScreenOrder, domainCameraObject.mainScreenOrder) && Intrinsics.areEqual(this.widgetOrder, domainCameraObject.widgetOrder) && Intrinsics.areEqual(this.mainScreen, domainCameraObject.mainScreen) && Intrinsics.areEqual(this.widget, domainCameraObject.widget);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.mainScreenOrder;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.widgetOrder;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.mainScreen;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.widget;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "DomainCameraObject(uuid=" + this.uuid + ", title=" + this.title + ", mainScreenOrder=" + this.mainScreenOrder + ", widgetOrder=" + this.widgetOrder + ", mainScreen=" + this.mainScreen + ", widget=" + this.widget + ")";
    }

    public DomainCameraObject(String str, String str2, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        this.uuid = str;
        this.title = str2;
        this.mainScreenOrder = num;
        this.widgetOrder = num2;
        this.mainScreen = bool;
        this.widget = bool2;
    }

    public /* synthetic */ DomainCameraObject(String str, String str2, Integer num, Integer num2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getMainScreenOrder() {
        return this.mainScreenOrder;
    }

    public final Integer getWidgetOrder() {
        return this.widgetOrder;
    }

    public final Boolean getMainScreen() {
        return this.mainScreen;
    }

    public final Boolean getWidget() {
        return this.widget;
    }
}
