package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Service;", "", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "logoUrl", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;Ljava/lang/String;Ljava/lang/String;)V", "getLogoUrl", "()Ljava/lang/String;", "getTitle", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Service {
    private final String logoUrl;
    private final String title;
    private final ApiOrigin type;

    public Service(@JsonProperty("type") ApiOrigin type, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title, @JsonProperty("logoUrl") String logoUrl) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        this.type = type;
        this.title = title;
        this.logoUrl = logoUrl;
    }

    public static /* synthetic */ Service copy$default(Service service, ApiOrigin apiOrigin, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            apiOrigin = service.type;
        }
        if ((i & 2) != 0) {
            str = service.title;
        }
        if ((i & 4) != 0) {
            str2 = service.logoUrl;
        }
        return service.copy(apiOrigin, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final ApiOrigin getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Service copy(@JsonProperty("type") ApiOrigin type, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title, @JsonProperty("logoUrl") String logoUrl) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        return new Service(type, title, logoUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Service)) {
            return false;
        }
        Service service = (Service) other;
        return this.type == service.type && Intrinsics.areEqual(this.title, service.title) && Intrinsics.areEqual(this.logoUrl, service.logoUrl);
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ApiOrigin getType() {
        return this.type;
    }

    public int hashCode() {
        return this.logoUrl.hashCode() + a.a(this.title, this.type.hashCode() * 31, 31);
    }

    public String toString() {
        return "Service(type=" + this.type + ", title=" + this.title + ", logoUrl=" + this.logoUrl + ")";
    }
}
