package ru.yoomoney.sdk.auth.phone.enter;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.b;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter;", "", "()V", "Action", "AnalyticsLogger", "BusinessLogic", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneEnter {
    public static final PhoneEnter INSTANCE = new PhoneEnter();

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0013\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "", "()V", "CheckExpiration", "ClickToPhoneDisabled", "CloseDialog", "ConfirmPhone", "Expired", "LoadData", "OpenIdentificationInfo", "PhoneConfirmSuccess", "PhoneSetSuccess", "PhoneValidated", "RegistrationPhoneSetSuccess", "RestartProcess", "SelectCountry", "SendAnalyticsFromTwoFa", "SetPhone", "ShowContent", "ShowContentWithPreloadedData", "ShowCountries", "ShowFailure", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ClickToPhoneDisabled;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CloseDialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ConfirmPhone;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$OpenIdentificationInfo;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneConfirmSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneSetSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneValidated;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$RegistrationPhoneSetSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SelectCountry;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SendAnalyticsFromTwoFa;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowContent;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowContentWithPreloadedData;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowCountries;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowFailure;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "phone", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Ljava/lang/String;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getPhone", "()Ljava/lang/String;", "getProcessId", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CheckExpiration extends Action {
            private final OffsetDateTime expireAt;
            private final String phone;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CheckExpiration(ProcessType processType, String processId, OffsetDateTime offsetDateTime, String phone) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(phone, "phone");
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
                this.phone = phone;
            }

            public static /* synthetic */ CheckExpiration copy$default(CheckExpiration checkExpiration, ProcessType processType, String str, OffsetDateTime offsetDateTime, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = checkExpiration.processType;
                }
                if ((i & 2) != 0) {
                    str = checkExpiration.processId;
                }
                if ((i & 4) != 0) {
                    offsetDateTime = checkExpiration.expireAt;
                }
                if ((i & 8) != 0) {
                    str2 = checkExpiration.phone;
                }
                return checkExpiration.copy(processType, str, offsetDateTime, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            /* renamed from: component4, reason: from getter */
            public final String getPhone() {
                return this.phone;
            }

            public final CheckExpiration copy(ProcessType processType, String processId, OffsetDateTime expireAt, String phone) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(phone, "phone");
                return new CheckExpiration(processType, processId, expireAt, phone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckExpiration)) {
                    return false;
                }
                CheckExpiration checkExpiration = (CheckExpiration) other;
                return this.processType == checkExpiration.processType && Intrinsics.areEqual(this.processId, checkExpiration.processId) && Intrinsics.areEqual(this.expireAt, checkExpiration.expireAt) && Intrinsics.areEqual(this.phone, checkExpiration.phone);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getPhone() {
                return this.phone;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iA = a.a(this.processId, this.processType.hashCode() * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return this.phone.hashCode() + ((iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode())) * 31);
            }

            public String toString() {
                return "CheckExpiration(processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ", phone=" + this.phone + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ClickToPhoneDisabled;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ClickToPhoneDisabled extends Action {
            public static final ClickToPhoneDisabled INSTANCE = new ClickToPhoneDisabled();

            private ClickToPhoneDisabled() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ClickToPhoneDisabled);
            }

            public int hashCode() {
                return 1893057511;
            }

            public String toString() {
                return "ClickToPhoneDisabled";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CloseDialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CloseDialog extends Action {
            public static final CloseDialog INSTANCE = new CloseDialog();

            private CloseDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof CloseDialog);
            }

            public int hashCode() {
                return 1700692512;
            }

            public String toString() {
                return "CloseDialog";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ConfirmPhone;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmPhone extends Action {
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmPhone(String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processId = processId;
            }

            public static /* synthetic */ ConfirmPhone copy$default(ConfirmPhone confirmPhone, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirmPhone.processId;
                }
                return confirmPhone.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final ConfirmPhone copy(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new ConfirmPhone(processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmPhone) && Intrinsics.areEqual(this.processId, ((ConfirmPhone) other).processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.processId.hashCode();
            }

            public String toString() {
                return "ConfirmPhone(processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Expired extends Action {
            public static final Expired INSTANCE = new Expired();

            private Expired() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Expired);
            }

            public int hashCode() {
                return -1828119579;
            }

            public String toString() {
                return "Expired";
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "predefinedPhone", "", "resultDataPhone", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Ljava/lang/String;)V", "getPredefinedPhone", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getResultDataPhone", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadData extends Action {
            private final String predefinedPhone;
            private final ProcessType processType;
            private final String resultDataPhone;
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadData(CountryCallingCode selectedCountry, ProcessType processType, String str, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.selectedCountry = selectedCountry;
                this.processType = processType;
                this.predefinedPhone = str;
                this.resultDataPhone = str2;
            }

            public static /* synthetic */ LoadData copy$default(LoadData loadData, CountryCallingCode countryCallingCode, ProcessType processType, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = loadData.selectedCountry;
                }
                if ((i & 2) != 0) {
                    processType = loadData.processType;
                }
                if ((i & 4) != 0) {
                    str = loadData.predefinedPhone;
                }
                if ((i & 8) != 0) {
                    str2 = loadData.resultDataPhone;
                }
                return loadData.copy(countryCallingCode, processType, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component3, reason: from getter */
            public final String getPredefinedPhone() {
                return this.predefinedPhone;
            }

            /* renamed from: component4, reason: from getter */
            public final String getResultDataPhone() {
                return this.resultDataPhone;
            }

            public final LoadData copy(CountryCallingCode selectedCountry, ProcessType processType, String predefinedPhone, String resultDataPhone) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new LoadData(selectedCountry, processType, predefinedPhone, resultDataPhone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadData)) {
                    return false;
                }
                LoadData loadData = (LoadData) other;
                return Intrinsics.areEqual(this.selectedCountry, loadData.selectedCountry) && this.processType == loadData.processType && Intrinsics.areEqual(this.predefinedPhone, loadData.predefinedPhone) && Intrinsics.areEqual(this.resultDataPhone, loadData.resultDataPhone);
            }

            public final String getPredefinedPhone() {
                return this.predefinedPhone;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final String getResultDataPhone() {
                return this.resultDataPhone;
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                int iHashCode = (this.processType.hashCode() + (this.selectedCountry.hashCode() * 31)) * 31;
                String str = this.predefinedPhone;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.resultDataPhone;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "LoadData(selectedCountry=" + this.selectedCountry + ", processType=" + this.processType + ", predefinedPhone=" + this.predefinedPhone + ", resultDataPhone=" + this.resultDataPhone + ")";
            }

            public /* synthetic */ LoadData(CountryCallingCode countryCallingCode, ProcessType processType, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(countryCallingCode, processType, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$OpenIdentificationInfo;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class OpenIdentificationInfo extends Action {
            public static final OpenIdentificationInfo INSTANCE = new OpenIdentificationInfo();

            private OpenIdentificationInfo() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof OpenIdentificationInfo);
            }

            public int hashCode() {
                return 529877862;
            }

            public String toString() {
                return "OpenIdentificationInfo";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneConfirmSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PhoneConfirmSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhoneConfirmSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ PhoneConfirmSuccess copy$default(PhoneConfirmSuccess phoneConfirmSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = phoneConfirmSuccess.process;
                }
                return phoneConfirmSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final PhoneConfirmSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new PhoneConfirmSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhoneConfirmSuccess) && Intrinsics.areEqual(this.process, ((PhoneConfirmSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "PhoneConfirmSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneSetSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PhoneSetSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhoneSetSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ PhoneSetSuccess copy$default(PhoneSetSuccess phoneSetSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = phoneSetSuccess.process;
                }
                return phoneSetSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final PhoneSetSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new PhoneSetSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhoneSetSuccess) && Intrinsics.areEqual(this.process, ((PhoneSetSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "PhoneSetSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$PhoneValidated;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "isValid", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PhoneValidated extends Action {
            private final boolean isValid;

            public PhoneValidated(boolean z) {
                super(null);
                this.isValid = z;
            }

            public static /* synthetic */ PhoneValidated copy$default(PhoneValidated phoneValidated, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = phoneValidated.isValid;
                }
                return phoneValidated.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsValid() {
                return this.isValid;
            }

            public final PhoneValidated copy(boolean isValid) {
                return new PhoneValidated(isValid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhoneValidated) && this.isValid == ((PhoneValidated) other).isValid;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValid);
            }

            public final boolean isValid() {
                return this.isValid;
            }

            public String toString() {
                return "PhoneValidated(isValid=" + this.isValid + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$RegistrationPhoneSetSuccess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationPhoneSetSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationPhoneSetSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ RegistrationPhoneSetSuccess copy$default(RegistrationPhoneSetSuccess registrationPhoneSetSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationPhoneSetSuccess.process;
                }
                return registrationPhoneSetSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final RegistrationPhoneSetSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new RegistrationPhoneSetSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationPhoneSetSuccess) && Intrinsics.areEqual(this.process, ((RegistrationPhoneSetSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "RegistrationPhoneSetSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof RestartProcess);
            }

            public int hashCode() {
                return -1411142496;
            }

            public String toString() {
                return "RestartProcess";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SelectCountry;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SelectCountry extends Action {
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectCountry(CountryCallingCode selectedCountry) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                this.selectedCountry = selectedCountry;
            }

            public static /* synthetic */ SelectCountry copy$default(SelectCountry selectCountry, CountryCallingCode countryCallingCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = selectCountry.selectedCountry;
                }
                return selectCountry.copy(countryCallingCode);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public final SelectCountry copy(CountryCallingCode selectedCountry) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                return new SelectCountry(selectedCountry);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectCountry) && Intrinsics.areEqual(this.selectedCountry, ((SelectCountry) other).selectedCountry);
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return this.selectedCountry.hashCode();
            }

            public String toString() {
                return "SelectCountry(selectedCountry=" + this.selectedCountry + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SendAnalyticsFromTwoFa;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "event", "Lru/yoomoney/sdk/auth/analytics/AnalyticsEvent;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Lru/yoomoney/sdk/auth/analytics/AnalyticsEvent;)V", "getEvent", "()Lru/yoomoney/sdk/auth/analytics/AnalyticsEvent;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendAnalyticsFromTwoFa extends Action {
            private final AnalyticsEvent event;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendAnalyticsFromTwoFa(ProcessType processType, AnalyticsEvent event) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(event, "event");
                this.processType = processType;
                this.event = event;
            }

            public static /* synthetic */ SendAnalyticsFromTwoFa copy$default(SendAnalyticsFromTwoFa sendAnalyticsFromTwoFa, ProcessType processType, AnalyticsEvent analyticsEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = sendAnalyticsFromTwoFa.processType;
                }
                if ((i & 2) != 0) {
                    analyticsEvent = sendAnalyticsFromTwoFa.event;
                }
                return sendAnalyticsFromTwoFa.copy(processType, analyticsEvent);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final AnalyticsEvent getEvent() {
                return this.event;
            }

            public final SendAnalyticsFromTwoFa copy(ProcessType processType, AnalyticsEvent event) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(event, "event");
                return new SendAnalyticsFromTwoFa(processType, event);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SendAnalyticsFromTwoFa)) {
                    return false;
                }
                SendAnalyticsFromTwoFa sendAnalyticsFromTwoFa = (SendAnalyticsFromTwoFa) other;
                return this.processType == sendAnalyticsFromTwoFa.processType && Intrinsics.areEqual(this.event, sendAnalyticsFromTwoFa.event);
            }

            public final AnalyticsEvent getEvent() {
                return this.event;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.event.hashCode() + (this.processType.hashCode() * 31);
            }

            public String toString() {
                return "SendAnalyticsFromTwoFa(processType=" + this.processType + ", event=" + this.event + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "phone", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "getProcessId", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetPhone extends Action {
            private final String phone;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetPhone(ProcessType processType, String processId, String phone) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(phone, "phone");
                this.processType = processType;
                this.processId = processId;
                this.phone = phone;
            }

            public static /* synthetic */ SetPhone copy$default(SetPhone setPhone, ProcessType processType, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = setPhone.processType;
                }
                if ((i & 2) != 0) {
                    str = setPhone.processId;
                }
                if ((i & 4) != 0) {
                    str2 = setPhone.phone;
                }
                return setPhone.copy(processType, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getPhone() {
                return this.phone;
            }

            public final SetPhone copy(ProcessType processType, String processId, String phone) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(phone, "phone");
                return new SetPhone(processType, processId, phone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetPhone)) {
                    return false;
                }
                SetPhone setPhone = (SetPhone) other;
                return this.processType == setPhone.processType && Intrinsics.areEqual(this.processId, setPhone.processId) && Intrinsics.areEqual(this.phone, setPhone.phone);
            }

            public final String getPhone() {
                return this.phone;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.phone.hashCode() + a.a(this.processId, this.processType.hashCode() * 31, 31);
            }

            public String toString() {
                return "SetPhone(processType=" + this.processType + ", processId=" + this.processId + ", phone=" + this.phone + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowContent;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContent extends Action {
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContent(CountryCallingCode selectedCountry) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                this.selectedCountry = selectedCountry;
            }

            public static /* synthetic */ ShowContent copy$default(ShowContent showContent, CountryCallingCode countryCallingCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = showContent.selectedCountry;
                }
                return showContent.copy(countryCallingCode);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public final ShowContent copy(CountryCallingCode selectedCountry) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                return new ShowContent(selectedCountry);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowContent) && Intrinsics.areEqual(this.selectedCountry, ((ShowContent) other).selectedCountry);
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return this.selectedCountry.hashCode();
            }

            public String toString() {
                return "ShowContent(selectedCountry=" + this.selectedCountry + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowContentWithPreloadedData;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "predefinedPhone", "", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Ljava/lang/String;)V", "getPredefinedPhone", "()Ljava/lang/String;", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContentWithPreloadedData extends Action {
            private final String predefinedPhone;
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContentWithPreloadedData(CountryCallingCode selectedCountry, String predefinedPhone) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                Intrinsics.checkNotNullParameter(predefinedPhone, "predefinedPhone");
                this.selectedCountry = selectedCountry;
                this.predefinedPhone = predefinedPhone;
            }

            public static /* synthetic */ ShowContentWithPreloadedData copy$default(ShowContentWithPreloadedData showContentWithPreloadedData, CountryCallingCode countryCallingCode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = showContentWithPreloadedData.selectedCountry;
                }
                if ((i & 2) != 0) {
                    str = showContentWithPreloadedData.predefinedPhone;
                }
                return showContentWithPreloadedData.copy(countryCallingCode, str);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            /* renamed from: component2, reason: from getter */
            public final String getPredefinedPhone() {
                return this.predefinedPhone;
            }

            public final ShowContentWithPreloadedData copy(CountryCallingCode selectedCountry, String predefinedPhone) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                Intrinsics.checkNotNullParameter(predefinedPhone, "predefinedPhone");
                return new ShowContentWithPreloadedData(selectedCountry, predefinedPhone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowContentWithPreloadedData)) {
                    return false;
                }
                ShowContentWithPreloadedData showContentWithPreloadedData = (ShowContentWithPreloadedData) other;
                return Intrinsics.areEqual(this.selectedCountry, showContentWithPreloadedData.selectedCountry) && Intrinsics.areEqual(this.predefinedPhone, showContentWithPreloadedData.predefinedPhone);
            }

            public final String getPredefinedPhone() {
                return this.predefinedPhone;
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return this.predefinedPhone.hashCode() + (this.selectedCountry.hashCode() * 31);
            }

            public String toString() {
                return "ShowContentWithPreloadedData(selectedCountry=" + this.selectedCountry + ", predefinedPhone=" + this.predefinedPhone + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowCountries;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowCountries extends Action {
            public static final ShowCountries INSTANCE = new ShowCountries();

            private ShowCountries() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowCountries);
            }

            public int hashCode() {
                return 1971179767;
            }

            public String toString() {
                return "ShowCountries";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$ShowFailure;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                return showFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowFailure) && Intrinsics.areEqual(this.failure, ((ShowFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u000024\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0001J9\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H¦\u0002¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$BusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "invoke", "state", "action", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BusinessLogic extends Function2<State, Action, Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect>> {
        @Override // kotlin.jvm.functions.Function2
        /* synthetic */ Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect> invoke(State state, Action action);

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        Triple<State, Command<?, Action>, Effect> invoke2(State state, Action action);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "", "()V", "FillEditText", "ResetProcess", "ShowCountries", "ShowError", "ShowExpireDialog", "ShowIdentificationInfo", "ShowNextRegistrationStep", "ShowNextStep", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$FillEditText;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowCountries;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowError;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowIdentificationInfo;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$FillEditText;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", RemoteMessageConst.DATA, "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FillEditText extends Effect {
            private final String data;

            public FillEditText(String str) {
                super(null);
                this.data = str;
            }

            public static /* synthetic */ FillEditText copy$default(FillEditText fillEditText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fillEditText.data;
                }
                return fillEditText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getData() {
                return this.data;
            }

            public final FillEditText copy(String data) {
                return new FillEditText(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FillEditText) && Intrinsics.areEqual(this.data, ((FillEditText) other).data);
            }

            public final String getData() {
                return this.data;
            }

            public int hashCode() {
                String str = this.data;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "FillEditText(data=" + this.data + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ResetProcess);
            }

            public int hashCode() {
                return -1479432731;
            }

            public String toString() {
                return "ResetProcess";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowCountries;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowCountries extends Effect {
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowCountries(CountryCallingCode selectedCountry) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                this.selectedCountry = selectedCountry;
            }

            public static /* synthetic */ ShowCountries copy$default(ShowCountries showCountries, CountryCallingCode countryCallingCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = showCountries.selectedCountry;
                }
                return showCountries.copy(countryCallingCode);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public final ShowCountries copy(CountryCallingCode selectedCountry) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                return new ShowCountries(selectedCountry);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowCountries) && Intrinsics.areEqual(this.selectedCountry, ((ShowCountries) other).selectedCountry);
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return this.selectedCountry.hashCode();
            }

            public String toString() {
                return "ShowCountries(selectedCountry=" + this.selectedCountry + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowError;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowError extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowError copy$default(ShowError showError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showError.failure;
                }
                return showError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowError) && Intrinsics.areEqual(this.failure, ((ShowError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowError(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowExpireDialog);
            }

            public int hashCode() {
                return -477800407;
            }

            public String toString() {
                return "ShowExpireDialog";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowIdentificationInfo;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowIdentificationInfo extends Effect {
            public static final ShowIdentificationInfo INSTANCE = new ShowIdentificationInfo();

            private ShowIdentificationInfo() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowIdentificationInfo);
            }

            public int hashCode() {
                return 534284190;
            }

            public String toString() {
                return "ShowIdentificationInfo";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextRegistrationStep extends Effect {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextRegistrationStep(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextRegistrationStep copy$default(ShowNextRegistrationStep showNextRegistrationStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showNextRegistrationStep.process;
                }
                return showNextRegistrationStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ShowNextRegistrationStep copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextRegistrationStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextRegistrationStep) && Intrinsics.areEqual(this.process, ((ShowNextRegistrationStep) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextRegistrationStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = showNextStep.process;
                }
                return showNextStep.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextStep(process=" + this.process + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "", "()V", "Content", "Dialog", "Loading", "PreLoad", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Dialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Loading;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$PreLoad;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "phoneIsValid", "", "offersIsChecked", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;ZZ)V", "getOffersIsChecked", "()Z", "getPhoneIsValid", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final boolean offersIsChecked;
            private final boolean phoneIsValid;
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(CountryCallingCode selectedCountry, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                this.selectedCountry = selectedCountry;
                this.phoneIsValid = z;
                this.offersIsChecked = z2;
            }

            public static /* synthetic */ Content copy$default(Content content, CountryCallingCode countryCallingCode, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = content.selectedCountry;
                }
                if ((i & 2) != 0) {
                    z = content.phoneIsValid;
                }
                if ((i & 4) != 0) {
                    z2 = content.offersIsChecked;
                }
                return content.copy(countryCallingCode, z, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getPhoneIsValid() {
                return this.phoneIsValid;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final Content copy(CountryCallingCode selectedCountry, boolean phoneIsValid, boolean offersIsChecked) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                return new Content(selectedCountry, phoneIsValid, offersIsChecked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.selectedCountry, content.selectedCountry) && this.phoneIsValid == content.phoneIsValid && this.offersIsChecked == content.offersIsChecked;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final boolean getPhoneIsValid() {
                return this.phoneIsValid;
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return Boolean.hashCode(this.offersIsChecked) + b.a(this.phoneIsValid, this.selectedCountry.hashCode() * 31, 31);
            }

            public String toString() {
                return "Content(selectedCountry=" + this.selectedCountry + ", phoneIsValid=" + this.phoneIsValid + ", offersIsChecked=" + this.offersIsChecked + ")";
            }

            public /* synthetic */ Content(CountryCallingCode countryCallingCode, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(countryCallingCode, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Dialog;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "content", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;)V", "getContent", "()Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Dialog extends State {
            private final Content content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Dialog(Content content) {
                super(null);
                Intrinsics.checkNotNullParameter(content, "content");
                this.content = content;
            }

            public static /* synthetic */ Dialog copy$default(Dialog dialog, Content content, int i, Object obj) {
                if ((i & 1) != 0) {
                    content = dialog.content;
                }
                return dialog.copy(content);
            }

            /* renamed from: component1, reason: from getter */
            public final Content getContent() {
                return this.content;
            }

            public final Dialog copy(Content content) {
                Intrinsics.checkNotNullParameter(content, "content");
                return new Dialog(content);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Dialog) && Intrinsics.areEqual(this.content, ((Dialog) other).content);
            }

            public final Content getContent() {
                return this.content;
            }

            public int hashCode() {
                return this.content.hashCode();
            }

            public String toString() {
                return "Dialog(content=" + this.content + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Loading;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "offersIsChecked", "", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Z)V", "getOffersIsChecked", "()Z", "getSelectedCountry", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            private final boolean offersIsChecked;
            private final CountryCallingCode selectedCountry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(CountryCallingCode selectedCountry, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                this.selectedCountry = selectedCountry;
                this.offersIsChecked = z;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, CountryCallingCode countryCallingCode, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = loading.selectedCountry;
                }
                if ((i & 2) != 0) {
                    z = loading.offersIsChecked;
                }
                return loading.copy(countryCallingCode, z);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final Loading copy(CountryCallingCode selectedCountry, boolean offersIsChecked) {
                Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
                return new Loading(selectedCountry, offersIsChecked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) other;
                return Intrinsics.areEqual(this.selectedCountry, loading.selectedCountry) && this.offersIsChecked == loading.offersIsChecked;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final CountryCallingCode getSelectedCountry() {
                return this.selectedCountry;
            }

            public int hashCode() {
                return Boolean.hashCode(this.offersIsChecked) + (this.selectedCountry.hashCode() * 31);
            }

            public String toString() {
                return "Loading(selectedCountry=" + this.selectedCountry + ", offersIsChecked=" + this.offersIsChecked + ")";
            }

            public /* synthetic */ Loading(CountryCallingCode countryCallingCode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(countryCallingCode, (i & 2) != 0 ? false : z);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$PreLoad;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PreLoad extends State {
            public static final PreLoad INSTANCE = new PreLoad();

            private PreLoad() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof PreLoad);
            }

            public int hashCode() {
                return -1458547180;
            }

            public String toString() {
                return "PreLoad";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private PhoneEnter() {
    }
}
