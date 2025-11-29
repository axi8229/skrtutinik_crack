package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActiveSessionApi.kt */
@JsonSubTypes({@JsonSubTypes.Type(name = "PushApp", value = ActiveSessionApiPushApp.class), @JsonSubTypes.Type(name = "PushCode", value = ActiveSessionApiPushCode.class)})
@JsonTypeInfo(defaultImpl = ActiveSessionApiDefaultType.class, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApi;", "", "()V", "authProcessId", "", "getAuthProcessId", "()Ljava/lang/String;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiDefaultType;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiPushApp;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiPushCode;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ActiveSessionApi {
    public static final int $stable = 0;

    public /* synthetic */ ActiveSessionApi(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getAuthProcessId();

    public abstract ActiveSessionApiType getType();

    private ActiveSessionApi() {
    }
}
