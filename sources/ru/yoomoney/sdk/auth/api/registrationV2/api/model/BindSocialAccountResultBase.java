package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JsonSubTypes({@JsonSubTypes.Type(name = "Error", value = BindSocialAccountFailResult.class), @JsonSubTypes.Type(name = "Success", value = BindSocialAccountSuccessResult.class)})
@JsonTypeInfo(defaultImpl = BindSocialAccountResultBaseDefaultType.class, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = UpdateKey.STATUS, use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", "", "()V", "service", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "getService", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "getStatus", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "Status", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBaseDefaultType;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountSuccessResult;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BindSocialAccountResultBase {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;

        @JsonProperty("Success")
        public static final Status SUCCESS = new Status("SUCCESS", 0);

        @JsonProperty("Error")
        public static final Status ERROR = new Status("ERROR", 1);

        @JsonEnumDefaultValue
        public static final Status UNKNOWN_ENUM = new Status("UNKNOWN_ENUM", 2);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS, ERROR, UNKNOWN_ENUM};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        private Status(String str, int i) {
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    private BindSocialAccountResultBase() {
    }

    public /* synthetic */ BindSocialAccountResultBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract OauthServiceProvider getService();

    public abstract Status getStatus();
}
