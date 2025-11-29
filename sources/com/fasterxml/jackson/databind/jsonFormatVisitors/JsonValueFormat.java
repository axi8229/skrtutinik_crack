package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.android.gms.common.Scopes;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;

/* loaded from: classes2.dex */
public enum JsonValueFormat {
    COLOR(RemoteMessageConst.Notification.COLOR),
    DATE(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE),
    DATE_TIME("date-time"),
    EMAIL(Scopes.EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE("style"),
    TIME(CrashHianalyticsData.TIME),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");

    private final String _desc;

    JsonValueFormat(String str) {
        this._desc = str;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
