package com.sputnik.domain.entities.prefs;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.profile.AddressStatus;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LoginState.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b)\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0003BACB_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010Be\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019HÇ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJh\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b.\u0010!R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u00106R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState;", "", "", "phone", "", "limitExpiresAt", "limitExpiresAtMessage", "", "needNavigateToCode", "smsCodeExpiresAt", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "sessions", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Lcom/sputnik/domain/entities/auth/RegistrationWay;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Lcom/sputnik/domain/entities/auth/RegistrationWay;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/LoginState;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Lcom/sputnik/domain/entities/auth/RegistrationWay;Ljava/util/List;)Lcom/sputnik/domain/entities/prefs/LoginState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPhone", "setPhone", "(Ljava/lang/String;)V", "Ljava/lang/Long;", "getLimitExpiresAt", "()Ljava/lang/Long;", "getLimitExpiresAtMessage", "Z", "getNeedNavigateToCode", "()Z", "setNeedNavigateToCode", "(Z)V", "getSmsCodeExpiresAt", "setSmsCodeExpiresAt", "(Ljava/lang/Long;)V", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "setWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "Ljava/util/List;", "getSessions", "()Ljava/util/List;", "setSessions", "(Ljava/util/List;)V", "Companion", "$serializer", "Session", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class LoginState {
    private final Long limitExpiresAt;
    private final String limitExpiresAtMessage;
    private boolean needNavigateToCode;
    private String phone;
    private List<Session> sessions;
    private Long smsCodeExpiresAt;
    private RegistrationWay way;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new EnumSerializer("com.sputnik.domain.entities.auth.RegistrationWay", RegistrationWay.values()), new ArrayListSerializer(LoginState$Session$$serializer.INSTANCE)};

    public LoginState() {
        this((String) null, (Long) null, (String) null, false, (Long) null, (RegistrationWay) null, (List) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LoginState copy$default(LoginState loginState, String str, Long l, String str2, boolean z, Long l2, RegistrationWay registrationWay, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginState.phone;
        }
        if ((i & 2) != 0) {
            l = loginState.limitExpiresAt;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            str2 = loginState.limitExpiresAtMessage;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = loginState.needNavigateToCode;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            l2 = loginState.smsCodeExpiresAt;
        }
        Long l4 = l2;
        if ((i & 32) != 0) {
            registrationWay = loginState.way;
        }
        RegistrationWay registrationWay2 = registrationWay;
        if ((i & 64) != 0) {
            list = loginState.sessions;
        }
        return loginState.copy(str, l3, str3, z2, l4, registrationWay2, list);
    }

    public final LoginState copy(String phone, Long limitExpiresAt, String limitExpiresAtMessage, boolean needNavigateToCode, Long smsCodeExpiresAt, RegistrationWay way, List<Session> sessions) {
        return new LoginState(phone, limitExpiresAt, limitExpiresAtMessage, needNavigateToCode, smsCodeExpiresAt, way, sessions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginState)) {
            return false;
        }
        LoginState loginState = (LoginState) other;
        return Intrinsics.areEqual(this.phone, loginState.phone) && Intrinsics.areEqual(this.limitExpiresAt, loginState.limitExpiresAt) && Intrinsics.areEqual(this.limitExpiresAtMessage, loginState.limitExpiresAtMessage) && this.needNavigateToCode == loginState.needNavigateToCode && Intrinsics.areEqual(this.smsCodeExpiresAt, loginState.smsCodeExpiresAt) && this.way == loginState.way && Intrinsics.areEqual(this.sessions, loginState.sessions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.phone;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.limitExpiresAt;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.limitExpiresAtMessage;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.needNavigateToCode;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        Long l2 = this.smsCodeExpiresAt;
        int iHashCode4 = (i2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        RegistrationWay registrationWay = this.way;
        int iHashCode5 = (iHashCode4 + (registrationWay == null ? 0 : registrationWay.hashCode())) * 31;
        List<Session> list = this.sessions;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "LoginState(phone=" + this.phone + ", limitExpiresAt=" + this.limitExpiresAt + ", limitExpiresAtMessage=" + this.limitExpiresAtMessage + ", needNavigateToCode=" + this.needNavigateToCode + ", smsCodeExpiresAt=" + this.smsCodeExpiresAt + ", way=" + this.way + ", sessions=" + this.sessions + ")";
    }

    /* compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/prefs/LoginState;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LoginState> serializer() {
            return LoginState$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ LoginState(int i, String str, Long l, String str2, boolean z, Long l2, RegistrationWay registrationWay, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.phone = null;
        } else {
            this.phone = str;
        }
        if ((i & 2) == 0) {
            this.limitExpiresAt = null;
        } else {
            this.limitExpiresAt = l;
        }
        if ((i & 4) == 0) {
            this.limitExpiresAtMessage = null;
        } else {
            this.limitExpiresAtMessage = str2;
        }
        if ((i & 8) == 0) {
            this.needNavigateToCode = false;
        } else {
            this.needNavigateToCode = z;
        }
        if ((i & 16) == 0) {
            this.smsCodeExpiresAt = null;
        } else {
            this.smsCodeExpiresAt = l2;
        }
        if ((i & 32) == 0) {
            this.way = null;
        } else {
            this.way = registrationWay;
        }
        if ((i & 64) == 0) {
            this.sessions = null;
        } else {
            this.sessions = list;
        }
    }

    public LoginState(String str, Long l, String str2, boolean z, Long l2, RegistrationWay registrationWay, List<Session> list) {
        this.phone = str;
        this.limitExpiresAt = l;
        this.limitExpiresAtMessage = str2;
        this.needNavigateToCode = z;
        this.smsCodeExpiresAt = l2;
        this.way = registrationWay;
        this.sessions = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(LoginState self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.limitExpiresAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.limitExpiresAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.limitExpiresAtMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.limitExpiresAtMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.needNavigateToCode) {
            output.encodeBooleanElement(serialDesc, 3, self.needNavigateToCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.smsCodeExpiresAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.smsCodeExpiresAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.way != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.way);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.sessions == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.sessions);
    }

    public /* synthetic */ LoginState(String str, Long l, String str2, boolean z, Long l2, RegistrationWay registrationWay, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : registrationWay, (i & 64) != 0 ? null : list);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final Long getLimitExpiresAt() {
        return this.limitExpiresAt;
    }

    public final String getLimitExpiresAtMessage() {
        return this.limitExpiresAtMessage;
    }

    public final boolean getNeedNavigateToCode() {
        return this.needNavigateToCode;
    }

    public final Long getSmsCodeExpiresAt() {
        return this.smsCodeExpiresAt;
    }

    public final void setSmsCodeExpiresAt(Long l) {
        this.smsCodeExpiresAt = l;
    }

    public final RegistrationWay getWay() {
        return this.way;
    }

    /* compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b@\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0003efdBÇ\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001cBÕ\u0001\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010!J(\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%HÇ\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0002¢\u0006\u0004\b,\u0010+J\u0010\u0010-\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010+\"\u0004\b4\u00105R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00102\u001a\u0004\b6\u0010+\"\u0004\b7\u00105R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00102\u001a\u0004\b8\u0010+\"\u0004\b9\u00105R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00102\u001a\u0004\b:\u0010+\"\u0004\b;\u00105R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010<\u001a\u0004\b\b\u0010=\"\u0004\b>\u0010?R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00102\u001a\u0004\b@\u0010+\"\u0004\bA\u00105R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010<\u001a\u0004\b\f\u0010=\"\u0004\bG\u0010?R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00102\u001a\u0004\bH\u0010+\"\u0004\bI\u00105R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00102\u001a\u0004\bT\u0010+\"\u0004\bU\u00105R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00102\u001a\u0004\bV\u0010+\"\u0004\bW\u00105R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00102\u001a\u0004\bX\u0010+\"\u0004\bY\u00105R$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010<\u001a\u0004\b\u0015\u0010=\"\u0004\bZ\u0010?R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010<\u001a\u0004\b[\u0010=\"\u0004\b\\\u0010?R$\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010<\u001a\u0004\b]\u0010=\"\u0004\b^\u0010?R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006g"}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "countryCode", "phone", "jwt", "", "isVisible", "image", "Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "profileSettings", "isAvatarLoaded", "avatarUrl", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "", "codeExpiresAt", "requestId", "userSmsCode", "userSmsPhone", "isIntercomOpened", "haveSubscription", "haveLoadingVideo", "", "Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "addresses", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/prefs/ProfileSettings;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/RegistrationWay;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/prefs/ProfileSettings;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/auth/RegistrationWay;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/LoginState$Session;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hash", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getCountryCode", "setCountryCode", "getPhone", "setPhone", "getJwt", "setJwt", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setVisible", "(Ljava/lang/Boolean;)V", "getImage", "setImage", "Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "getProfileSettings", "()Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "setProfileSettings", "(Lcom/sputnik/domain/entities/prefs/ProfileSettings;)V", "setAvatarLoaded", "getAvatarUrl", "setAvatarUrl", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "setWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "Ljava/lang/Long;", "getCodeExpiresAt", "()Ljava/lang/Long;", "setCodeExpiresAt", "(Ljava/lang/Long;)V", "getRequestId", "setRequestId", "getUserSmsCode", "setUserSmsCode", "getUserSmsPhone", "setUserSmsPhone", "setIntercomOpened", "getHaveSubscription", "setHaveSubscription", "getHaveLoadingVideo", "setHaveLoadingVideo", "Ljava/util/List;", "getAddresses", "()Ljava/util/List;", "setAddresses", "(Ljava/util/List;)V", "Companion", "$serializer", "Address", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Session {
        private List<Address> addresses;
        private String avatarUrl;
        private Long codeExpiresAt;
        private String countryCode;
        private Boolean haveLoadingVideo;
        private Boolean haveSubscription;
        private String image;
        private Boolean isAvatarLoaded;
        private Boolean isIntercomOpened;
        private Boolean isVisible;
        private String jwt;
        private String name;
        private String phone;
        private ProfileSettings profileSettings;
        private String requestId;
        private String userSmsCode;
        private String userSmsPhone;
        private RegistrationWay way;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, new EnumSerializer("com.sputnik.domain.entities.auth.RegistrationWay", RegistrationWay.values()), null, null, null, null, null, null, null, new ArrayListSerializer(LoginState$Session$Address$$serializer.INSTANCE)};

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Session)) {
                return false;
            }
            Session session = (Session) other;
            return Intrinsics.areEqual(this.name, session.name) && Intrinsics.areEqual(this.countryCode, session.countryCode) && Intrinsics.areEqual(this.phone, session.phone) && Intrinsics.areEqual(this.jwt, session.jwt) && Intrinsics.areEqual(this.isVisible, session.isVisible) && Intrinsics.areEqual(this.image, session.image) && Intrinsics.areEqual(this.profileSettings, session.profileSettings) && Intrinsics.areEqual(this.isAvatarLoaded, session.isAvatarLoaded) && Intrinsics.areEqual(this.avatarUrl, session.avatarUrl) && this.way == session.way && Intrinsics.areEqual(this.codeExpiresAt, session.codeExpiresAt) && Intrinsics.areEqual(this.requestId, session.requestId) && Intrinsics.areEqual(this.userSmsCode, session.userSmsCode) && Intrinsics.areEqual(this.userSmsPhone, session.userSmsPhone) && Intrinsics.areEqual(this.isIntercomOpened, session.isIntercomOpened) && Intrinsics.areEqual(this.haveSubscription, session.haveSubscription) && Intrinsics.areEqual(this.haveLoadingVideo, session.haveLoadingVideo) && Intrinsics.areEqual(this.addresses, session.addresses);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.countryCode.hashCode()) * 31) + this.phone.hashCode()) * 31;
            String str2 = this.jwt;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.isVisible;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.image;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            ProfileSettings profileSettings = this.profileSettings;
            int iHashCode5 = (iHashCode4 + (profileSettings == null ? 0 : profileSettings.hashCode())) * 31;
            Boolean bool2 = this.isAvatarLoaded;
            int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str4 = this.avatarUrl;
            int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            RegistrationWay registrationWay = this.way;
            int iHashCode8 = (iHashCode7 + (registrationWay == null ? 0 : registrationWay.hashCode())) * 31;
            Long l = this.codeExpiresAt;
            int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
            String str5 = this.requestId;
            int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.userSmsCode;
            int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.userSmsPhone;
            int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Boolean bool3 = this.isIntercomOpened;
            int iHashCode13 = (iHashCode12 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.haveSubscription;
            int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.haveLoadingVideo;
            return ((iHashCode14 + (bool5 != null ? bool5.hashCode() : 0)) * 31) + this.addresses.hashCode();
        }

        /* compiled from: LoginState.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState$Session$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Session> serializer() {
                return LoginState$Session$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Session(int i, String str, String str2, String str3, String str4, Boolean bool, String str5, ProfileSettings profileSettings, Boolean bool2, String str6, RegistrationWay registrationWay, Long l, String str7, String str8, String str9, Boolean bool3, Boolean bool4, Boolean bool5, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, LoginState$Session$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
            this.countryCode = str2;
            this.phone = str3;
            this.jwt = str4;
            this.isVisible = bool;
            this.image = str5;
            this.profileSettings = profileSettings;
            this.isAvatarLoaded = bool2;
            this.avatarUrl = str6;
            this.way = registrationWay;
            this.codeExpiresAt = l;
            this.requestId = str7;
            if ((i & 4096) == 0) {
                this.userSmsCode = null;
            } else {
                this.userSmsCode = str8;
            }
            if ((i & 8192) == 0) {
                this.userSmsPhone = null;
            } else {
                this.userSmsPhone = str9;
            }
            if ((i & 16384) == 0) {
                this.isIntercomOpened = null;
            } else {
                this.isIntercomOpened = bool3;
            }
            if ((32768 & i) == 0) {
                this.haveSubscription = null;
            } else {
                this.haveSubscription = bool4;
            }
            if ((65536 & i) == 0) {
                this.haveLoadingVideo = null;
            } else {
                this.haveLoadingVideo = bool5;
            }
            this.addresses = (i & 131072) == 0 ? CollectionsKt.emptyList() : list;
        }

        public Session(String str, String countryCode, String phone, String str2, Boolean bool, String str3, ProfileSettings profileSettings, Boolean bool2, String str4, RegistrationWay registrationWay, Long l, String str5, String str6, String str7, Boolean bool3, Boolean bool4, Boolean bool5, List<Address> addresses) {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(addresses, "addresses");
            this.name = str;
            this.countryCode = countryCode;
            this.phone = phone;
            this.jwt = str2;
            this.isVisible = bool;
            this.image = str3;
            this.profileSettings = profileSettings;
            this.isAvatarLoaded = bool2;
            this.avatarUrl = str4;
            this.way = registrationWay;
            this.codeExpiresAt = l;
            this.requestId = str5;
            this.userSmsCode = str6;
            this.userSmsPhone = str7;
            this.isIntercomOpened = bool3;
            this.haveSubscription = bool4;
            this.haveLoadingVideo = bool5;
            this.addresses = addresses;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(Session self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.name);
            output.encodeStringElement(serialDesc, 1, self.countryCode);
            output.encodeStringElement(serialDesc, 2, self.phone);
            output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.jwt);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 4, booleanSerializer, self.isVisible);
            output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.image);
            output.encodeNullableSerializableElement(serialDesc, 6, ProfileSettings$$serializer.INSTANCE, self.profileSettings);
            output.encodeNullableSerializableElement(serialDesc, 7, booleanSerializer, self.isAvatarLoaded);
            output.encodeNullableSerializableElement(serialDesc, 8, stringSerializer, self.avatarUrl);
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.way);
            output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.codeExpiresAt);
            output.encodeNullableSerializableElement(serialDesc, 11, stringSerializer, self.requestId);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.userSmsCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, stringSerializer, self.userSmsCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.userSmsPhone != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, stringSerializer, self.userSmsPhone);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.isIntercomOpened != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, booleanSerializer, self.isIntercomOpened);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.haveSubscription != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, booleanSerializer, self.haveSubscription);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.haveLoadingVideo != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, booleanSerializer, self.haveLoadingVideo);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 17) && Intrinsics.areEqual(self.addresses, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 17, kSerializerArr[17], self.addresses);
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final void setCountryCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.countryCode = str;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final void setPhone(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.phone = str;
        }

        public final String getJwt() {
            return this.jwt;
        }

        public final void setJwt(String str) {
            this.jwt = str;
        }

        /* renamed from: isVisible, reason: from getter */
        public final Boolean getIsVisible() {
            return this.isVisible;
        }

        public final void setVisible(Boolean bool) {
            this.isVisible = bool;
        }

        public final String getImage() {
            return this.image;
        }

        public final void setImage(String str) {
            this.image = str;
        }

        public final ProfileSettings getProfileSettings() {
            return this.profileSettings;
        }

        public final void setProfileSettings(ProfileSettings profileSettings) {
            this.profileSettings = profileSettings;
        }

        public final RegistrationWay getWay() {
            return this.way;
        }

        public final void setWay(RegistrationWay registrationWay) {
            this.way = registrationWay;
        }

        public final Long getCodeExpiresAt() {
            return this.codeExpiresAt;
        }

        public final void setCodeExpiresAt(Long l) {
            this.codeExpiresAt = l;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final void setRequestId(String str) {
            this.requestId = str;
        }

        public final String getUserSmsCode() {
            return this.userSmsCode;
        }

        public final void setUserSmsCode(String str) {
            this.userSmsCode = str;
        }

        public final String getUserSmsPhone() {
            return this.userSmsPhone;
        }

        public final void setUserSmsPhone(String str) {
            this.userSmsPhone = str;
        }

        /* renamed from: isIntercomOpened, reason: from getter */
        public final Boolean getIsIntercomOpened() {
            return this.isIntercomOpened;
        }

        public final void setIntercomOpened(Boolean bool) {
            this.isIntercomOpened = bool;
        }

        public final Boolean getHaveSubscription() {
            return this.haveSubscription;
        }

        public final void setHaveSubscription(Boolean bool) {
            this.haveSubscription = bool;
        }

        public final Boolean getHaveLoadingVideo() {
            return this.haveLoadingVideo;
        }

        public final void setHaveLoadingVideo(Boolean bool) {
            this.haveLoadingVideo = bool;
        }

        /* compiled from: LoginState.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;Bo\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010Bs\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018HÇ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJx\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b+\u0010 R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b/\u0010(R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b0\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b1\u0010 R\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00102\u001a\u0004\b\f\u00103\"\u0004\b4\u00105R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "", "", "id", "", "fullAddress", "fullAddressWithApartment", "", "addressVerificationRequired", "apartment", "flatUUID", "entryUUID", "isSelected", "Lcom/sputnik/domain/entities/profile/AddressStatus;", UpdateKey.STATUS, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/profile/AddressStatus;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/profile/AddressStatus;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/profile/AddressStatus;)Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullAddress", "getFullAddressWithApartment", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "getApartment", "getFlatUUID", "getEntryUUID", "Z", "()Z", "setSelected", "(Z)V", "Lcom/sputnik/domain/entities/profile/AddressStatus;", "getStatus", "()Lcom/sputnik/domain/entities/profile/AddressStatus;", "setStatus", "(Lcom/sputnik/domain/entities/profile/AddressStatus;)V", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Address {
            private final Boolean addressVerificationRequired;
            private final Integer apartment;
            private final String entryUUID;
            private final String flatUUID;
            private final String fullAddress;
            private final String fullAddressWithApartment;
            private final Integer id;
            private boolean isSelected;
            private AddressStatus status;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, new EnumSerializer("com.sputnik.domain.entities.profile.AddressStatus", AddressStatus.values())};

            public Address() {
                this((Integer) null, (String) null, (String) null, (Boolean) null, (Integer) null, (String) null, (String) null, false, (AddressStatus) null, 511, (DefaultConstructorMarker) null);
            }

            public final Address copy(Integer id, String fullAddress, String fullAddressWithApartment, Boolean addressVerificationRequired, Integer apartment, String flatUUID, String entryUUID, boolean isSelected, AddressStatus status) {
                Intrinsics.checkNotNullParameter(status, "status");
                return new Address(id, fullAddress, fullAddressWithApartment, addressVerificationRequired, apartment, flatUUID, entryUUID, isSelected, status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Address)) {
                    return false;
                }
                Address address = (Address) other;
                return Intrinsics.areEqual(this.id, address.id) && Intrinsics.areEqual(this.fullAddress, address.fullAddress) && Intrinsics.areEqual(this.fullAddressWithApartment, address.fullAddressWithApartment) && Intrinsics.areEqual(this.addressVerificationRequired, address.addressVerificationRequired) && Intrinsics.areEqual(this.apartment, address.apartment) && Intrinsics.areEqual(this.flatUUID, address.flatUUID) && Intrinsics.areEqual(this.entryUUID, address.entryUUID) && this.isSelected == address.isSelected && this.status == address.status;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Integer num = this.id;
                int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
                String str = this.fullAddress;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.fullAddressWithApartment;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Boolean bool = this.addressVerificationRequired;
                int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
                Integer num2 = this.apartment;
                int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str3 = this.flatUUID;
                int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.entryUUID;
                int iHashCode7 = (iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
                boolean z = this.isSelected;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return ((iHashCode7 + i) * 31) + this.status.hashCode();
            }

            public String toString() {
                return "Address(id=" + this.id + ", fullAddress=" + this.fullAddress + ", fullAddressWithApartment=" + this.fullAddressWithApartment + ", addressVerificationRequired=" + this.addressVerificationRequired + ", apartment=" + this.apartment + ", flatUUID=" + this.flatUUID + ", entryUUID=" + this.entryUUID + ", isSelected=" + this.isSelected + ", status=" + this.status + ")";
            }

            /* compiled from: LoginState.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Address> serializer() {
                    return LoginState$Session$Address$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Address(int i, Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, boolean z, AddressStatus addressStatus, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.id = null;
                } else {
                    this.id = num;
                }
                if ((i & 2) == 0) {
                    this.fullAddress = null;
                } else {
                    this.fullAddress = str;
                }
                if ((i & 4) == 0) {
                    this.fullAddressWithApartment = null;
                } else {
                    this.fullAddressWithApartment = str2;
                }
                if ((i & 8) == 0) {
                    this.addressVerificationRequired = null;
                } else {
                    this.addressVerificationRequired = bool;
                }
                if ((i & 16) == 0) {
                    this.apartment = null;
                } else {
                    this.apartment = num2;
                }
                if ((i & 32) == 0) {
                    this.flatUUID = null;
                } else {
                    this.flatUUID = str3;
                }
                if ((i & 64) == 0) {
                    this.entryUUID = null;
                } else {
                    this.entryUUID = str4;
                }
                if ((i & 128) == 0) {
                    this.isSelected = false;
                } else {
                    this.isSelected = z;
                }
                if ((i & 256) == 0) {
                    this.status = AddressStatus.unknown;
                } else {
                    this.status = addressStatus;
                }
            }

            public Address(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, boolean z, AddressStatus status) {
                Intrinsics.checkNotNullParameter(status, "status");
                this.id = num;
                this.fullAddress = str;
                this.fullAddressWithApartment = str2;
                this.addressVerificationRequired = bool;
                this.apartment = num2;
                this.flatUUID = str3;
                this.entryUUID = str4;
                this.isSelected = z;
                this.status = status;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(Address self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fullAddress != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.fullAddress);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fullAddressWithApartment != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.fullAddressWithApartment);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.addressVerificationRequired != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.addressVerificationRequired);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.apartment != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.apartment);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.flatUUID != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.flatUUID);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.entryUUID != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.entryUUID);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isSelected) {
                    output.encodeBooleanElement(serialDesc, 7, self.isSelected);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.status == AddressStatus.unknown) {
                    return;
                }
                output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.status);
            }

            public final Integer getId() {
                return this.id;
            }

            public final String getFullAddress() {
                return this.fullAddress;
            }

            public final String getFullAddressWithApartment() {
                return this.fullAddressWithApartment;
            }

            public final Boolean getAddressVerificationRequired() {
                return this.addressVerificationRequired;
            }

            public final Integer getApartment() {
                return this.apartment;
            }

            public final String getFlatUUID() {
                return this.flatUUID;
            }

            public final String getEntryUUID() {
                return this.entryUUID;
            }

            /* renamed from: isSelected, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            public final void setSelected(boolean z) {
                this.isSelected = z;
            }

            public /* synthetic */ Address(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, boolean z, AddressStatus addressStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? str4 : null, (i & 128) != 0 ? false : z, (i & 256) != 0 ? AddressStatus.unknown : addressStatus);
            }

            public final AddressStatus getStatus() {
                return this.status;
            }
        }

        public /* synthetic */ Session(String str, String str2, String str3, String str4, Boolean bool, String str5, ProfileSettings profileSettings, Boolean bool2, String str6, RegistrationWay registrationWay, Long l, String str7, String str8, String str9, Boolean bool3, Boolean bool4, Boolean bool5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, bool, str5, profileSettings, bool2, str6, registrationWay, l, str7, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : bool3, (32768 & i) != 0 ? null : bool4, (65536 & i) != 0 ? null : bool5, (i & 131072) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Address> getAddresses() {
            return this.addresses;
        }

        public final void setAddresses(List<Address> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.addresses = list;
        }

        public String toString() {
            return CollectionsKt.joinToString$default(this.addresses, "\n GGGG:", null, null, 0, null, null, 62, null);
        }

        public final String hash() {
            return LoginStateKt.toPhoneHash(this.countryCode + this.phone);
        }
    }

    public final List<Session> getSessions() {
        return this.sessions;
    }

    public final void setSessions(List<Session> list) {
        this.sessions = list;
    }
}
