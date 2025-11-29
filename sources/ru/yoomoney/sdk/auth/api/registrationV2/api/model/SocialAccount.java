package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/SocialAccount;", "", "service", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;Ljava/lang/String;)V", "getService", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccount {
    private final OauthServiceProvider service;
    private final String title;

    public SocialAccount(@JsonProperty("service") OauthServiceProvider service, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String str) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        this.title = str;
    }

    public static /* synthetic */ SocialAccount copy$default(SocialAccount socialAccount, OauthServiceProvider oauthServiceProvider, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            oauthServiceProvider = socialAccount.service;
        }
        if ((i & 2) != 0) {
            str = socialAccount.title;
        }
        return socialAccount.copy(oauthServiceProvider, str);
    }

    /* renamed from: component1, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final SocialAccount copy(@JsonProperty("service") OauthServiceProvider service, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title) {
        Intrinsics.checkNotNullParameter(service, "service");
        return new SocialAccount(service, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccount)) {
            return false;
        }
        SocialAccount socialAccount = (SocialAccount) other;
        return this.service == socialAccount.service && Intrinsics.areEqual(this.title, socialAccount.title);
    }

    public final OauthServiceProvider getService() {
        return this.service;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = this.service.hashCode() * 31;
        String str = this.title;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SocialAccount(service=" + this.service + ", title=" + this.title + ")";
    }

    public /* synthetic */ SocialAccount(OauthServiceProvider oauthServiceProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(oauthServiceProvider, (i & 2) != 0 ? null : str);
    }
}
