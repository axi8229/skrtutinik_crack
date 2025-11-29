package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.threeten.bp.LocalDateTime;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/Session;", "", "()V", "nextAvailableFrom", "Lorg/threeten/bp/LocalDateTime;", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "getType", "()Lru/yoomoney/sdk/two_fa/domain/SessionType;", "validUntil", "getValidUntil", "Lru/yoomoney/sdk/two_fa/domain/SessionDefaultType;", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "Lru/yoomoney/sdk/two_fa/domain/SessionPhoneCall;", "Lru/yoomoney/sdk/two_fa/domain/SessionPushApp;", "Lru/yoomoney/sdk/two_fa/domain/SessionPushCode;", "Lru/yoomoney/sdk/two_fa/domain/SessionSms;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Session {
    public static final int $stable = 0;

    public /* synthetic */ Session(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LocalDateTime getNextAvailableFrom();

    public abstract SessionType getType();

    public abstract LocalDateTime getValidUntil();

    private Session() {
    }
}
