package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.threeten.bp.LocalDateTime;

/* compiled from: SessionApi.kt */
@JsonSubTypes({@JsonSubTypes.Type(name = "Email", value = SessionEmailApi.class), @JsonSubTypes.Type(name = "PhoneCall", value = SessionPhoneCallApi.class), @JsonSubTypes.Type(name = "PushApp", value = SessionPushAppApi.class), @JsonSubTypes.Type(name = "PushCode", value = SessionPushCodeApi.class), @JsonSubTypes.Type(name = "Sms", value = SessionSmsApi.class)})
@JsonTypeInfo(defaultImpl = SessionApiDefaultType.class, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "", "()V", "nextAvailableFrom", "Lorg/threeten/bp/LocalDateTime;", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "validUntil", "getValidUntil", "Lru/yoomoney/sdk/two_fa/api/model/SessionApiDefaultType;", "Lru/yoomoney/sdk/two_fa/api/model/SessionEmailApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPhoneCallApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPushAppApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPushCodeApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionSmsApi;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SessionApi {
    public static final int $stable = 0;

    public /* synthetic */ SessionApi(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LocalDateTime getNextAvailableFrom();

    public abstract ApiSessionType getType();

    public abstract LocalDateTime getValidUntil();

    private SessionApi() {
    }
}
