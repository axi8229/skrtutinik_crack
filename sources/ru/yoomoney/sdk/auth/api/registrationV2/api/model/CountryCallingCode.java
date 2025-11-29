package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;", "", "phonePrefix", "", "countryCode", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getPhonePrefix", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CountryCallingCode {
    private final String countryCode;
    private final String phonePrefix;
    private final String title;

    public CountryCallingCode(@JsonProperty("phonePrefix") String phonePrefix, @JsonProperty("countryCode") String countryCode, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title) {
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(title, "title");
        this.phonePrefix = phonePrefix;
        this.countryCode = countryCode;
        this.title = title;
    }

    public static /* synthetic */ CountryCallingCode copy$default(CountryCallingCode countryCallingCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryCallingCode.phonePrefix;
        }
        if ((i & 2) != 0) {
            str2 = countryCallingCode.countryCode;
        }
        if ((i & 4) != 0) {
            str3 = countryCallingCode.title;
        }
        return countryCallingCode.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final CountryCallingCode copy(@JsonProperty("phonePrefix") String phonePrefix, @JsonProperty("countryCode") String countryCode, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title) {
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(title, "title");
        return new CountryCallingCode(phonePrefix, countryCode, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryCallingCode)) {
            return false;
        }
        CountryCallingCode countryCallingCode = (CountryCallingCode) other;
        return Intrinsics.areEqual(this.phonePrefix, countryCallingCode.phonePrefix) && Intrinsics.areEqual(this.countryCode, countryCallingCode.countryCode) && Intrinsics.areEqual(this.title, countryCallingCode.title);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode() + a.a(this.countryCode, this.phonePrefix.hashCode() * 31, 31);
    }

    public String toString() {
        return "CountryCallingCode(phonePrefix=" + this.phonePrefix + ", countryCode=" + this.countryCode + ", title=" + this.title + ")";
    }
}
