package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.ConfirmationType;
import com.sputnik.domain.entities.auth.StateType;
import com.sputnik.domain.entities.empty.DomainEmpty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallCodeViewModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b%\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001GB¯\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJº\u0001\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b,\u0010 R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b\t\u0010.R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b2\u0010 R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b6\u0010 R\u001f\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010:\u001a\u0004\b;\u0010<R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010=\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010@R\u0017\u0010\u0017\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010\u0018\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010A\u001a\u0004\bD\u0010CR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\bE\u0010 R\u0017\u0010\u001a\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010A\u001a\u0004\bF\u0010C¨\u0006H"}, d2 = {"Lcom/sputnik/common/viewmodels/CallCodeViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "handleCodeServerState", "", "phone", "code", "Lcom/sputnik/domain/common/Event;", "", "isLoaded", "Lcom/sputnik/domain/entities/auth/ConfirmationType;", "confirmationType", "jwt", "Lcom/sputnik/domain/entities/auth/StateType;", "state", "app", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "parsedError", "", "count", "needSendSms", "smsSent", "smsTimer", "smsSendRestricted", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/auth/ConfirmationType;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/String;Ljava/lang/Exception;Lcom/sputnik/domain/entities/empty/DomainEmpty;IZZLjava/lang/String;Z)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/auth/ConfirmationType;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/String;Ljava/lang/Exception;Lcom/sputnik/domain/entities/empty/DomainEmpty;IZZLjava/lang/String;Z)Lcom/sputnik/common/viewmodels/CallCodeViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getHandleCodeServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/lang/String;", "getPhone", "getCode", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/domain/entities/auth/ConfirmationType;", "getConfirmationType", "()Lcom/sputnik/domain/entities/auth/ConfirmationType;", "getJwt", "Lcom/sputnik/domain/entities/auth/StateType;", "getState", "()Lcom/sputnik/domain/entities/auth/StateType;", "getApp", "Ljava/lang/Exception;", "getError", "()Ljava/lang/Exception;", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "getParsedError", "()Lcom/sputnik/domain/entities/empty/DomainEmpty;", "I", "getCount", "setCount", "(I)V", "Z", "getNeedSendSms", "()Z", "getSmsSent", "getSmsTimer", "getSmsSendRestricted", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CallCodeViewState implements VMState {
    private final String app;
    private final String code;
    private final ConfirmationType confirmationType;
    private int count;
    private final Exception error;
    private final Resource.Status handleCodeServerState;
    private final Event<Boolean> isLoaded;
    private final String jwt;
    private final boolean needSendSms;
    private final DomainEmpty parsedError;
    private final String phone;
    private final boolean smsSendRestricted;
    private final boolean smsSent;
    private final String smsTimer;
    private final StateType state;

    public final CallCodeViewState copy(Resource.Status handleCodeServerState, String phone, String code, Event<Boolean> isLoaded, ConfirmationType confirmationType, String jwt, StateType state, String app, Exception error, DomainEmpty parsedError, int count, boolean needSendSms, boolean smsSent, String smsTimer, boolean smsSendRestricted) {
        Intrinsics.checkNotNullParameter(handleCodeServerState, "handleCodeServerState");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(confirmationType, "confirmationType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(smsTimer, "smsTimer");
        return new CallCodeViewState(handleCodeServerState, phone, code, isLoaded, confirmationType, jwt, state, app, error, parsedError, count, needSendSms, smsSent, smsTimer, smsSendRestricted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallCodeViewState)) {
            return false;
        }
        CallCodeViewState callCodeViewState = (CallCodeViewState) other;
        return this.handleCodeServerState == callCodeViewState.handleCodeServerState && Intrinsics.areEqual(this.phone, callCodeViewState.phone) && Intrinsics.areEqual(this.code, callCodeViewState.code) && Intrinsics.areEqual(this.isLoaded, callCodeViewState.isLoaded) && this.confirmationType == callCodeViewState.confirmationType && Intrinsics.areEqual(this.jwt, callCodeViewState.jwt) && this.state == callCodeViewState.state && Intrinsics.areEqual(this.app, callCodeViewState.app) && Intrinsics.areEqual(this.error, callCodeViewState.error) && Intrinsics.areEqual(this.parsedError, callCodeViewState.parsedError) && this.count == callCodeViewState.count && this.needSendSms == callCodeViewState.needSendSms && this.smsSent == callCodeViewState.smsSent && Intrinsics.areEqual(this.smsTimer, callCodeViewState.smsTimer) && this.smsSendRestricted == callCodeViewState.smsSendRestricted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.handleCodeServerState.hashCode() * 31) + this.phone.hashCode()) * 31;
        String str = this.code;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.isLoaded.hashCode()) * 31) + this.confirmationType.hashCode()) * 31;
        String str2 = this.jwt;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.state.hashCode()) * 31) + this.app.hashCode()) * 31;
        Exception exc = this.error;
        int iHashCode4 = (iHashCode3 + (exc == null ? 0 : exc.hashCode())) * 31;
        DomainEmpty domainEmpty = this.parsedError;
        int iHashCode5 = (((iHashCode4 + (domainEmpty != null ? domainEmpty.hashCode() : 0)) * 31) + Integer.hashCode(this.count)) * 31;
        boolean z = this.needSendSms;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        boolean z2 = this.smsSent;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int iHashCode6 = (((i2 + i3) * 31) + this.smsTimer.hashCode()) * 31;
        boolean z3 = this.smsSendRestricted;
        return iHashCode6 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "CallCodeViewState(handleCodeServerState=" + this.handleCodeServerState + ", phone=" + this.phone + ", code=" + this.code + ", isLoaded=" + this.isLoaded + ", confirmationType=" + this.confirmationType + ", jwt=" + this.jwt + ", state=" + this.state + ", app=" + this.app + ", error=" + this.error + ", parsedError=" + this.parsedError + ", count=" + this.count + ", needSendSms=" + this.needSendSms + ", smsSent=" + this.smsSent + ", smsTimer=" + this.smsTimer + ", smsSendRestricted=" + this.smsSendRestricted + ")";
    }

    public CallCodeViewState(Resource.Status handleCodeServerState, String phone, String str, Event<Boolean> isLoaded, ConfirmationType confirmationType, String str2, StateType state, String app, Exception exc, DomainEmpty domainEmpty, int i, boolean z, boolean z2, String smsTimer, boolean z3) {
        Intrinsics.checkNotNullParameter(handleCodeServerState, "handleCodeServerState");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(confirmationType, "confirmationType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(smsTimer, "smsTimer");
        this.handleCodeServerState = handleCodeServerState;
        this.phone = phone;
        this.code = str;
        this.isLoaded = isLoaded;
        this.confirmationType = confirmationType;
        this.jwt = str2;
        this.state = state;
        this.app = app;
        this.error = exc;
        this.parsedError = domainEmpty;
        this.count = i;
        this.needSendSms = z;
        this.smsSent = z2;
        this.smsTimer = smsTimer;
        this.smsSendRestricted = z3;
    }

    public /* synthetic */ CallCodeViewState(Resource.Status status, String str, String str2, Event event, ConfirmationType confirmationType, String str3, StateType stateType, String str4, Exception exc, DomainEmpty domainEmpty, int i, boolean z, boolean z2, String str5, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Resource.Status.NONE : status, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? new Event(Boolean.FALSE) : event, (i2 & 16) != 0 ? ConfirmationType.sms4 : confirmationType, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? StateType.empty : stateType, (i2 & 128) != 0 ? "default" : str4, (i2 & 256) != 0 ? null : exc, (i2 & 512) != 0 ? null : domainEmpty, (i2 & 1024) != 0 ? 0 : i, (i2 & 2048) != 0 ? false : z, (i2 & 4096) != 0 ? true : z2, (i2 & 8192) != 0 ? "" : str5, (i2 & 16384) != 0 ? false : z3);
    }

    public final Resource.Status getHandleCodeServerState() {
        return this.handleCodeServerState;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final Event<Boolean> isLoaded() {
        return this.isLoaded;
    }

    public final String getApp() {
        return this.app;
    }

    public final Exception getError() {
        return this.error;
    }

    public final DomainEmpty getParsedError() {
        return this.parsedError;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getNeedSendSms() {
        return this.needSendSms;
    }

    public final String getSmsTimer() {
        return this.smsTimer;
    }

    public final boolean getSmsSendRestricted() {
        return this.smsSendRestricted;
    }
}
