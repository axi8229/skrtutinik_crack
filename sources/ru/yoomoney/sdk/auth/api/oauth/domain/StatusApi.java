package ru.yoomoney.sdk.auth.api.oauth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/oauth/domain/StatusApi;", "", "(Ljava/lang/String;I)V", "EXCHANGE", "FAILED", "SUCCESS", "WAITING", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StatusApi {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StatusApi[] $VALUES;

    @JsonProperty("Exchange")
    public static final StatusApi EXCHANGE = new StatusApi("EXCHANGE", 0);

    @JsonProperty("Failed")
    public static final StatusApi FAILED = new StatusApi("FAILED", 1);

    @JsonProperty("Success")
    public static final StatusApi SUCCESS = new StatusApi("SUCCESS", 2);

    @JsonProperty("Waiting")
    public static final StatusApi WAITING = new StatusApi("WAITING", 3);

    private static final /* synthetic */ StatusApi[] $values() {
        return new StatusApi[]{EXCHANGE, FAILED, SUCCESS, WAITING};
    }

    static {
        StatusApi[] statusApiArr$values = $values();
        $VALUES = statusApiArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(statusApiArr$values);
    }

    private StatusApi(String str, int i) {
    }

    public static EnumEntries<StatusApi> getEntries() {
        return $ENTRIES;
    }

    public static StatusApi valueOf(String str) {
        return (StatusApi) Enum.valueOf(StatusApi.class, str);
    }

    public static StatusApi[] values() {
        return (StatusApi[]) $VALUES.clone();
    }
}
