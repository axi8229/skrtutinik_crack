package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.ConfirmationType;
import com.sputnik.domain.entities.prefs.LoginState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 Jö\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00102\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u0010$R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b1\u0010$R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b2\u0010$R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b6\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b7\u0010$R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00108\u001a\u0004\b9\u0010:R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010;\u001a\u0004\b>\u0010=R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010;\u001a\u0004\b\u0013\u0010=R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b?\u0010$R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0019\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0019\u0010F\u001a\u0004\bG\u0010HR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010;\u001a\u0004\b\u001a\u0010=R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010I\u001a\u0004\bJ\u0010KR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/sputnik/common/viewmodels/LoginViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "phone", "prettyPhone", "countryCode", "", "Lcom/sputnik/common/entities/country_code/CountryCode;", "countryCodeList", "rawPhone", "code", "Lcom/sputnik/domain/entities/auth/ConfirmationType;", "confirmationType", "Lcom/sputnik/domain/common/Event;", "", "toRequestCode", "toLimitExceeded", "isLimitExceeded", "limitExceededMessage", "", "remainTimeInSeconds", "Lcom/sputnik/domain/entities/prefs/LoginState;", "loginState", "smsCodeExpired", "isLoaded", "Lcom/sputnik/common/viewmodels/SessionsState;", "sessionsState", "Lcom/sputnik/common/entities/auth/ApplyRegistration;", "applyRegistration", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/ConfirmationType;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Ljava/lang/Long;Lcom/sputnik/domain/entities/prefs/LoginState;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/common/viewmodels/SessionsState;Lcom/sputnik/common/entities/auth/ApplyRegistration;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/ConfirmationType;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Ljava/lang/Long;Lcom/sputnik/domain/entities/prefs/LoginState;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/common/viewmodels/SessionsState;Lcom/sputnik/common/entities/auth/ApplyRegistration;)Lcom/sputnik/common/viewmodels/LoginViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/lang/String;", "getPhone", "getPrettyPhone", "getCountryCode", "Ljava/util/List;", "getCountryCodeList", "()Ljava/util/List;", "getRawPhone", "getCode", "Lcom/sputnik/domain/entities/auth/ConfirmationType;", "getConfirmationType", "()Lcom/sputnik/domain/entities/auth/ConfirmationType;", "Lcom/sputnik/domain/common/Event;", "getToRequestCode", "()Lcom/sputnik/domain/common/Event;", "getToLimitExceeded", "getLimitExceededMessage", "Ljava/lang/Long;", "getRemainTimeInSeconds", "()Ljava/lang/Long;", "Lcom/sputnik/domain/entities/prefs/LoginState;", "getLoginState", "()Lcom/sputnik/domain/entities/prefs/LoginState;", "Z", "getSmsCodeExpired", "()Z", "Lcom/sputnik/common/viewmodels/SessionsState;", "getSessionsState", "()Lcom/sputnik/common/viewmodels/SessionsState;", "Lcom/sputnik/common/entities/auth/ApplyRegistration;", "getApplyRegistration", "()Lcom/sputnik/common/entities/auth/ApplyRegistration;", "setApplyRegistration", "(Lcom/sputnik/common/entities/auth/ApplyRegistration;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LoginViewState implements VMState {
    private ApplyRegistration applyRegistration;
    private final String code;
    private final ConfirmationType confirmationType;
    private final String countryCode;
    private final List<CountryCode> countryCodeList;
    private final Event<Boolean> isLimitExceeded;
    private final Event<Boolean> isLoaded;
    private final String limitExceededMessage;
    private final LoginState loginState;
    private final String phone;
    private final String prettyPhone;
    private final String rawPhone;
    private final Long remainTimeInSeconds;
    private final Resource.Status serverState;
    private final SessionsState sessionsState;
    private final boolean smsCodeExpired;
    private final Event<Boolean> toLimitExceeded;
    private final Event<Boolean> toRequestCode;

    public LoginViewState() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 262143, null);
    }

    public final LoginViewState copy(Resource.Status serverState, String phone, String prettyPhone, String countryCode, List<CountryCode> countryCodeList, String rawPhone, String code, ConfirmationType confirmationType, Event<Boolean> toRequestCode, Event<Boolean> toLimitExceeded, Event<Boolean> isLimitExceeded, String limitExceededMessage, Long remainTimeInSeconds, LoginState loginState, boolean smsCodeExpired, Event<Boolean> isLoaded, SessionsState sessionsState, ApplyRegistration applyRegistration) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(confirmationType, "confirmationType");
        Intrinsics.checkNotNullParameter(toRequestCode, "toRequestCode");
        Intrinsics.checkNotNullParameter(toLimitExceeded, "toLimitExceeded");
        Intrinsics.checkNotNullParameter(isLimitExceeded, "isLimitExceeded");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(sessionsState, "sessionsState");
        return new LoginViewState(serverState, phone, prettyPhone, countryCode, countryCodeList, rawPhone, code, confirmationType, toRequestCode, toLimitExceeded, isLimitExceeded, limitExceededMessage, remainTimeInSeconds, loginState, smsCodeExpired, isLoaded, sessionsState, applyRegistration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginViewState)) {
            return false;
        }
        LoginViewState loginViewState = (LoginViewState) other;
        return this.serverState == loginViewState.serverState && Intrinsics.areEqual(this.phone, loginViewState.phone) && Intrinsics.areEqual(this.prettyPhone, loginViewState.prettyPhone) && Intrinsics.areEqual(this.countryCode, loginViewState.countryCode) && Intrinsics.areEqual(this.countryCodeList, loginViewState.countryCodeList) && Intrinsics.areEqual(this.rawPhone, loginViewState.rawPhone) && Intrinsics.areEqual(this.code, loginViewState.code) && this.confirmationType == loginViewState.confirmationType && Intrinsics.areEqual(this.toRequestCode, loginViewState.toRequestCode) && Intrinsics.areEqual(this.toLimitExceeded, loginViewState.toLimitExceeded) && Intrinsics.areEqual(this.isLimitExceeded, loginViewState.isLimitExceeded) && Intrinsics.areEqual(this.limitExceededMessage, loginViewState.limitExceededMessage) && Intrinsics.areEqual(this.remainTimeInSeconds, loginViewState.remainTimeInSeconds) && Intrinsics.areEqual(this.loginState, loginViewState.loginState) && this.smsCodeExpired == loginViewState.smsCodeExpired && Intrinsics.areEqual(this.isLoaded, loginViewState.isLoaded) && Intrinsics.areEqual(this.sessionsState, loginViewState.sessionsState) && Intrinsics.areEqual(this.applyRegistration, loginViewState.applyRegistration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        String str = this.phone;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.prettyPhone;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<CountryCode> list = this.countryCodeList;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.rawPhone;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.code;
        int iHashCode7 = (((((((((iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.confirmationType.hashCode()) * 31) + this.toRequestCode.hashCode()) * 31) + this.toLimitExceeded.hashCode()) * 31) + this.isLimitExceeded.hashCode()) * 31;
        String str6 = this.limitExceededMessage;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.remainTimeInSeconds;
        int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        LoginState loginState = this.loginState;
        int iHashCode10 = (iHashCode9 + (loginState == null ? 0 : loginState.hashCode())) * 31;
        boolean z = this.smsCodeExpired;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iHashCode11 = (((((iHashCode10 + i) * 31) + this.isLoaded.hashCode()) * 31) + this.sessionsState.hashCode()) * 31;
        ApplyRegistration applyRegistration = this.applyRegistration;
        return iHashCode11 + (applyRegistration != null ? applyRegistration.hashCode() : 0);
    }

    public String toString() {
        return "LoginViewState(serverState=" + this.serverState + ", phone=" + this.phone + ", prettyPhone=" + this.prettyPhone + ", countryCode=" + this.countryCode + ", countryCodeList=" + this.countryCodeList + ", rawPhone=" + this.rawPhone + ", code=" + this.code + ", confirmationType=" + this.confirmationType + ", toRequestCode=" + this.toRequestCode + ", toLimitExceeded=" + this.toLimitExceeded + ", isLimitExceeded=" + this.isLimitExceeded + ", limitExceededMessage=" + this.limitExceededMessage + ", remainTimeInSeconds=" + this.remainTimeInSeconds + ", loginState=" + this.loginState + ", smsCodeExpired=" + this.smsCodeExpired + ", isLoaded=" + this.isLoaded + ", sessionsState=" + this.sessionsState + ", applyRegistration=" + this.applyRegistration + ")";
    }

    public LoginViewState(Resource.Status serverState, String str, String str2, String str3, List<CountryCode> list, String str4, String str5, ConfirmationType confirmationType, Event<Boolean> toRequestCode, Event<Boolean> toLimitExceeded, Event<Boolean> isLimitExceeded, String str6, Long l, LoginState loginState, boolean z, Event<Boolean> isLoaded, SessionsState sessionsState, ApplyRegistration applyRegistration) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(confirmationType, "confirmationType");
        Intrinsics.checkNotNullParameter(toRequestCode, "toRequestCode");
        Intrinsics.checkNotNullParameter(toLimitExceeded, "toLimitExceeded");
        Intrinsics.checkNotNullParameter(isLimitExceeded, "isLimitExceeded");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(sessionsState, "sessionsState");
        this.serverState = serverState;
        this.phone = str;
        this.prettyPhone = str2;
        this.countryCode = str3;
        this.countryCodeList = list;
        this.rawPhone = str4;
        this.code = str5;
        this.confirmationType = confirmationType;
        this.toRequestCode = toRequestCode;
        this.toLimitExceeded = toLimitExceeded;
        this.isLimitExceeded = isLimitExceeded;
        this.limitExceededMessage = str6;
        this.remainTimeInSeconds = l;
        this.loginState = loginState;
        this.smsCodeExpired = z;
        this.isLoaded = isLoaded;
        this.sessionsState = sessionsState;
        this.applyRegistration = applyRegistration;
    }

    public /* synthetic */ LoginViewState(Resource.Status status, String str, String str2, String str3, List list, String str4, String str5, ConfirmationType confirmationType, Event event, Event event2, Event event3, String str6, Long l, LoginState loginState, boolean z, Event event4, SessionsState sessionsState, ApplyRegistration applyRegistration, int i, DefaultConstructorMarker defaultConstructorMarker) {
        LoginState loginState2;
        Event event5;
        Event event6;
        String str7;
        Long l2;
        ApplyRegistration applyRegistration2;
        SessionsState sessionsState2;
        Resource.Status status2 = (i & 1) != 0 ? Resource.Status.NONE : status;
        String str8 = (i & 2) != 0 ? null : str;
        String str9 = (i & 4) != 0 ? null : str2;
        String str10 = (i & 8) != 0 ? null : str3;
        List list2 = (i & 16) != 0 ? null : list;
        String str11 = (i & 32) != 0 ? null : str4;
        String str12 = (i & 64) != 0 ? null : str5;
        ConfirmationType confirmationType2 = (i & 128) != 0 ? ConfirmationType.sms4 : confirmationType;
        Event event7 = (i & 256) != 0 ? new Event(Boolean.FALSE) : event;
        Event event8 = (i & 512) != 0 ? new Event(Boolean.FALSE) : event2;
        Event event9 = (i & 1024) != 0 ? new Event(Boolean.FALSE) : event3;
        String str13 = (i & 2048) != 0 ? null : str6;
        Long l3 = (i & 4096) != 0 ? null : l;
        LoginState loginState3 = (i & 8192) != 0 ? null : loginState;
        boolean z2 = (i & 16384) != 0 ? true : z;
        if ((i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0) {
            loginState2 = loginState3;
            event5 = new Event(Boolean.FALSE);
        } else {
            loginState2 = loginState3;
            event5 = event4;
        }
        if ((65536 & i) != 0) {
            event6 = event5;
            l2 = l3;
            str7 = str13;
            applyRegistration2 = null;
            sessionsState2 = new SessionsState(false, null, 3, null);
        } else {
            event6 = event5;
            str7 = str13;
            l2 = l3;
            applyRegistration2 = null;
            sessionsState2 = sessionsState;
        }
        this(status2, str8, str9, str10, list2, str11, str12, confirmationType2, event7, event8, event9, str7, l2, loginState2, z2, event6, sessionsState2, (i & 131072) == 0 ? applyRegistration : applyRegistration2);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPrettyPhone() {
        return this.prettyPhone;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final List<CountryCode> getCountryCodeList() {
        return this.countryCodeList;
    }

    public final String getRawPhone() {
        return this.rawPhone;
    }

    public final Event<Boolean> getToRequestCode() {
        return this.toRequestCode;
    }

    public final Event<Boolean> isLimitExceeded() {
        return this.isLimitExceeded;
    }

    public final String getLimitExceededMessage() {
        return this.limitExceededMessage;
    }

    public final Long getRemainTimeInSeconds() {
        return this.remainTimeInSeconds;
    }

    public final Event<Boolean> isLoaded() {
        return this.isLoaded;
    }

    public final SessionsState getSessionsState() {
        return this.sessionsState;
    }

    public final ApplyRegistration getApplyRegistration() {
        return this.applyRegistration;
    }
}
