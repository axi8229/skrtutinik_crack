package com.sputnik.domain.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: Errors.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00060\u0001j\u0002`\u0002:\u0007\b\u0007\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/sputnik/domain/common/Errors;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "<init>", "(I)V", "Factory", "AuthException", "Forbidden", "NotFound", "ServerDied", "TooManyRequests", "UserInputError", "Lcom/sputnik/domain/common/Errors$AuthException;", "Lcom/sputnik/domain/common/Errors$DoorError$DeviceOffline;", "Lcom/sputnik/domain/common/Errors$Forbidden;", "Lcom/sputnik/domain/common/Errors$NotFound;", "Lcom/sputnik/domain/common/Errors$ServerDied;", "Lcom/sputnik/domain/common/Errors$TooManyRequests;", "Lcom/sputnik/domain/common/Errors$UserInputError;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Errors extends Exception {

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ Errors(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$AuthException;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AuthException extends Errors {
        public AuthException() {
            super(pjsip_status_code.PJSIP_SC_UNAUTHORIZED, null);
        }
    }

    private Errors(int i) {
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$ServerDied;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ServerDied extends Errors {
        public ServerDied() {
            super(503, null);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$Forbidden;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Forbidden extends Errors {
        public Forbidden() {
            super(pjsip_status_code.PJSIP_SC_FORBIDDEN, null);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$NotFound;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotFound extends Errors {
        public NotFound() {
            super(pjsip_status_code.PJSIP_SC_NOT_FOUND, null);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$TooManyRequests;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TooManyRequests extends Errors {
        public TooManyRequests() {
            super(pjsip_status_code.PJSIP_SC_PROVIDE_REFERRER_HEADER, null);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/common/Errors$UserInputError;", "Lcom/sputnik/domain/common/Errors;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UserInputError extends Errors {
        public UserInputError() {
            super(pjsip_status_code.PJSIP_SC_SESSION_TIMER_TOO_SMALL, null);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/common/Errors$Factory;", "", "()V", "invoke", "Lcom/sputnik/domain/common/Errors;", "code", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.domain.common.Errors$Factory, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Errors invoke(int code) {
            if (code == 401) {
                return new AuthException();
            }
            if (500 <= code && code < 504) {
                return new ServerDied();
            }
            if (code == 403) {
                return new Forbidden();
            }
            if (code == 404) {
                return new NotFound();
            }
            if (code == 422) {
                return new UserInputError();
            }
            if (code == 429) {
                return new TooManyRequests();
            }
            if (code == 434) {
                return new Errors$DoorError$DeviceOffline();
            }
            return null;
        }
    }
}
