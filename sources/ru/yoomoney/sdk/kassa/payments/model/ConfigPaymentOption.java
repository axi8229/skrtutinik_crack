package ru.yoomoney.sdk.kassa.payments.model;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/ConfigPaymentOption;", "", "method", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "iconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getMethod", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigPaymentOption {
    public static final int $stable = 0;
    private final String iconUrl;
    private final String method;
    private final String title;

    public ConfigPaymentOption(String method, String title, String iconUrl) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.method = method;
        this.title = title;
        this.iconUrl = iconUrl;
    }

    public static /* synthetic */ ConfigPaymentOption copy$default(ConfigPaymentOption configPaymentOption, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configPaymentOption.method;
        }
        if ((i & 2) != 0) {
            str2 = configPaymentOption.title;
        }
        if ((i & 4) != 0) {
            str3 = configPaymentOption.iconUrl;
        }
        return configPaymentOption.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final ConfigPaymentOption copy(String method, String title, String iconUrl) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new ConfigPaymentOption(method, title, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigPaymentOption)) {
            return false;
        }
        ConfigPaymentOption configPaymentOption = (ConfigPaymentOption) other;
        return Intrinsics.areEqual(this.method, configPaymentOption.method) && Intrinsics.areEqual(this.title, configPaymentOption.title) && Intrinsics.areEqual(this.iconUrl, configPaymentOption.iconUrl);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.iconUrl.hashCode() + AbstractC1553e.a(this.title, this.method.hashCode() * 31, 31);
    }

    public String toString() {
        return "ConfigPaymentOption(method=" + this.method + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ")";
    }
}
