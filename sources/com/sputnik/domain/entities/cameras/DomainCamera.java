package com.sputnik.domain.entities.cameras;

import com.sputnik.domain.entities.archive.DomainFlussonic;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCamera.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001:\u0001?BÕ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u001dR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b\u0007\u0010(R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b)\u0010\u001dR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b*\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010\u001fR\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b-\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b.\u0010\u001dR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b2\u0010(R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b3\u0010\u001dR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b\u0011\u0010(R\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b\u0012\u0010(R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b8\u00109R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010:\u001a\u0004\b=\u0010<R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\b>\u0010<¨\u0006@"}, d2 = {"Lcom/sputnik/domain/entities/cameras/DomainCamera;", "", "", "uuid", "streamUrl", "previewUrl", "", "isIntercom", "intercomUuid", "intercomSerial", "", "width", "height", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "order", "widget", "address", "isLoadPhotoFailed", "isLoadVideoFailed", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "flussonicData", "Lcom/sputnik/domain/entities/cameras/DomainCamera$DomainExtraKeyReader;", "extraKeyReader", "subscriptionRequried", "mainScreen", "canOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZZLcom/sputnik/domain/entities/archive/DomainFlussonic;Lcom/sputnik/domain/entities/cameras/DomainCamera$DomainExtraKeyReader;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getStreamUrl", "getPreviewUrl", "Z", "()Z", "getIntercomUuid", "getIntercomSerial", "I", "getWidth", "getHeight", "getTitle", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "getWidget", "getAddress", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "getFlussonicData", "()Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "Lcom/sputnik/domain/entities/cameras/DomainCamera$DomainExtraKeyReader;", "getExtraKeyReader", "()Lcom/sputnik/domain/entities/cameras/DomainCamera$DomainExtraKeyReader;", "Ljava/lang/Boolean;", "getSubscriptionRequried", "()Ljava/lang/Boolean;", "getMainScreen", "getCanOpen", "DomainExtraKeyReader", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCamera {
    private final String address;
    private final Boolean canOpen;
    private final DomainExtraKeyReader extraKeyReader;
    private final DomainFlussonic flussonicData;
    private final int height;
    private final String intercomSerial;
    private final String intercomUuid;
    private final boolean isIntercom;
    private final boolean isLoadPhotoFailed;
    private final boolean isLoadVideoFailed;
    private final Boolean mainScreen;
    private final Integer order;
    private final String previewUrl;
    private final String streamUrl;
    private final Boolean subscriptionRequried;
    private final String title;
    private final String uuid;
    private final boolean widget;
    private final int width;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCamera)) {
            return false;
        }
        DomainCamera domainCamera = (DomainCamera) other;
        return Intrinsics.areEqual(this.uuid, domainCamera.uuid) && Intrinsics.areEqual(this.streamUrl, domainCamera.streamUrl) && Intrinsics.areEqual(this.previewUrl, domainCamera.previewUrl) && this.isIntercom == domainCamera.isIntercom && Intrinsics.areEqual(this.intercomUuid, domainCamera.intercomUuid) && Intrinsics.areEqual(this.intercomSerial, domainCamera.intercomSerial) && this.width == domainCamera.width && this.height == domainCamera.height && Intrinsics.areEqual(this.title, domainCamera.title) && Intrinsics.areEqual(this.order, domainCamera.order) && this.widget == domainCamera.widget && Intrinsics.areEqual(this.address, domainCamera.address) && this.isLoadPhotoFailed == domainCamera.isLoadPhotoFailed && this.isLoadVideoFailed == domainCamera.isLoadVideoFailed && Intrinsics.areEqual(this.flussonicData, domainCamera.flussonicData) && Intrinsics.areEqual(this.extraKeyReader, domainCamera.extraKeyReader) && Intrinsics.areEqual(this.subscriptionRequried, domainCamera.subscriptionRequried) && Intrinsics.areEqual(this.mainScreen, domainCamera.mainScreen) && Intrinsics.areEqual(this.canOpen, domainCamera.canOpen);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.uuid.hashCode() * 31;
        String str = this.streamUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.previewUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isIntercom;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        String str3 = this.intercomUuid;
        int iHashCode4 = (i2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.intercomSerial;
        int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31;
        String str5 = this.title;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.widget;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode7 + i3) * 31;
        String str6 = this.address;
        int iHashCode8 = (i4 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z3 = this.isLoadPhotoFailed;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (iHashCode8 + i5) * 31;
        boolean z4 = this.isLoadVideoFailed;
        int i7 = (i6 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        DomainFlussonic domainFlussonic = this.flussonicData;
        int iHashCode9 = (i7 + (domainFlussonic == null ? 0 : domainFlussonic.hashCode())) * 31;
        DomainExtraKeyReader domainExtraKeyReader = this.extraKeyReader;
        int iHashCode10 = (iHashCode9 + (domainExtraKeyReader == null ? 0 : domainExtraKeyReader.hashCode())) * 31;
        Boolean bool = this.subscriptionRequried;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.mainScreen;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canOpen;
        return iHashCode12 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "DomainCamera(uuid=" + this.uuid + ", streamUrl=" + this.streamUrl + ", previewUrl=" + this.previewUrl + ", isIntercom=" + this.isIntercom + ", intercomUuid=" + this.intercomUuid + ", intercomSerial=" + this.intercomSerial + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", order=" + this.order + ", widget=" + this.widget + ", address=" + this.address + ", isLoadPhotoFailed=" + this.isLoadPhotoFailed + ", isLoadVideoFailed=" + this.isLoadVideoFailed + ", flussonicData=" + this.flussonicData + ", extraKeyReader=" + this.extraKeyReader + ", subscriptionRequried=" + this.subscriptionRequried + ", mainScreen=" + this.mainScreen + ", canOpen=" + this.canOpen + ")";
    }

    public DomainCamera(String uuid, String str, String str2, boolean z, String str3, String str4, int i, int i2, String str5, Integer num, boolean z2, String str6, boolean z3, boolean z4, DomainFlussonic domainFlussonic, DomainExtraKeyReader domainExtraKeyReader, Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.streamUrl = str;
        this.previewUrl = str2;
        this.isIntercom = z;
        this.intercomUuid = str3;
        this.intercomSerial = str4;
        this.width = i;
        this.height = i2;
        this.title = str5;
        this.order = num;
        this.widget = z2;
        this.address = str6;
        this.isLoadPhotoFailed = z3;
        this.isLoadVideoFailed = z4;
        this.flussonicData = domainFlussonic;
        this.extraKeyReader = domainExtraKeyReader;
        this.subscriptionRequried = bool;
        this.mainScreen = bool2;
        this.canOpen = bool3;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    /* renamed from: isIntercom, reason: from getter */
    public final boolean getIsIntercom() {
        return this.isIntercom;
    }

    public final String getIntercomUuid() {
        return this.intercomUuid;
    }

    public final String getIntercomSerial() {
        return this.intercomSerial;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public /* synthetic */ DomainCamera(String str, String str2, String str3, boolean z, String str4, String str5, int i, int i2, String str6, Integer num, boolean z2, String str7, boolean z3, boolean z4, DomainFlussonic domainFlussonic, DomainExtraKeyReader domainExtraKeyReader, Boolean bool, Boolean bool2, Boolean bool3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, i, i2, (i3 & 256) != 0 ? "Door" : str6, (i3 & 512) != 0 ? 0 : num, (i3 & 1024) != 0 ? false : z2, (i3 & 2048) != 0 ? null : str7, (i3 & 4096) != 0 ? false : z3, (i3 & 8192) != 0 ? false : z4, (i3 & 16384) != 0 ? null : domainFlussonic, domainExtraKeyReader, (65536 & i3) != 0 ? Boolean.FALSE : bool, (131072 & i3) != 0 ? Boolean.FALSE : bool2, (i3 & 262144) != 0 ? Boolean.FALSE : bool3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final boolean getWidget() {
        return this.widget;
    }

    public final String getAddress() {
        return this.address;
    }

    /* renamed from: isLoadPhotoFailed, reason: from getter */
    public final boolean getIsLoadPhotoFailed() {
        return this.isLoadPhotoFailed;
    }

    /* renamed from: isLoadVideoFailed, reason: from getter */
    public final boolean getIsLoadVideoFailed() {
        return this.isLoadVideoFailed;
    }

    public final DomainFlussonic getFlussonicData() {
        return this.flussonicData;
    }

    public final DomainExtraKeyReader getExtraKeyReader() {
        return this.extraKeyReader;
    }

    public final Boolean getSubscriptionRequried() {
        return this.subscriptionRequried;
    }

    public final Boolean getMainScreen() {
        return this.mainScreen;
    }

    public final Boolean getCanOpen() {
        return this.canOpen;
    }

    /* compiled from: DomainCamera.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/cameras/DomainCamera$DomainExtraKeyReader;", "", "", "kind", "alias", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKind", "getAlias", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainExtraKeyReader {
        private final String alias;
        private final String kind;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainExtraKeyReader)) {
                return false;
            }
            DomainExtraKeyReader domainExtraKeyReader = (DomainExtraKeyReader) other;
            return Intrinsics.areEqual(this.kind, domainExtraKeyReader.kind) && Intrinsics.areEqual(this.alias, domainExtraKeyReader.alias);
        }

        public int hashCode() {
            String str = this.kind;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.alias;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DomainExtraKeyReader(kind=" + this.kind + ", alias=" + this.alias + ")";
        }

        public DomainExtraKeyReader(String str, String str2) {
            this.kind = str;
            this.alias = str2;
        }

        public final String getKind() {
            return this.kind;
        }

        public final String getAlias() {
            return this.alias;
        }
    }
}
