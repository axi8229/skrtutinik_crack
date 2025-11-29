package com.sputnik.domain.entities.empty;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainEmpty.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bB[\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010#R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b$\u0010\u0019R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010 \u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b-\u0010'R\"\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010 \u0012\u0004\b/\u0010,\u001a\u0004\b.\u0010\u0019¨\u00062"}, d2 = {"Lcom/sputnik/domain/entities/empty/DomainEmpty;", "", "", CrashHianalyticsData.MESSAGE, "error", "", "httpErrorCode", "emergencyCode", "code", "limitExpiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/empty/DomainEmpty;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "setMessage", "(Ljava/lang/String;)V", "getError", "Ljava/lang/Integer;", "getHttpErrorCode", "()Ljava/lang/Integer;", "setHttpErrorCode", "(Ljava/lang/Integer;)V", "getEmergencyCode", "getEmergencyCode$annotations", "()V", "getCode", "getLimitExpiresAt", "getLimitExpiresAt$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainEmpty {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer code;
    private final String emergencyCode;
    private final String error;
    private Integer httpErrorCode;
    private final String limitExpiresAt;
    private String message;

    public DomainEmpty() {
        this((String) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainEmpty)) {
            return false;
        }
        DomainEmpty domainEmpty = (DomainEmpty) other;
        return Intrinsics.areEqual(this.message, domainEmpty.message) && Intrinsics.areEqual(this.error, domainEmpty.error) && Intrinsics.areEqual(this.httpErrorCode, domainEmpty.httpErrorCode) && Intrinsics.areEqual(this.emergencyCode, domainEmpty.emergencyCode) && Intrinsics.areEqual(this.code, domainEmpty.code) && Intrinsics.areEqual(this.limitExpiresAt, domainEmpty.limitExpiresAt);
    }

    public int hashCode() {
        String str = this.message;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.error;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.httpErrorCode;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.emergencyCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.code;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.limitExpiresAt;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DomainEmpty(message=" + this.message + ", error=" + this.error + ", httpErrorCode=" + this.httpErrorCode + ", emergencyCode=" + this.emergencyCode + ", code=" + this.code + ", limitExpiresAt=" + this.limitExpiresAt + ")";
    }

    /* compiled from: DomainEmpty.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/empty/DomainEmpty$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainEmpty> serializer() {
            return DomainEmpty$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainEmpty(int i, String str, String str2, Integer num, String str3, Integer num2, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.message = null;
        } else {
            this.message = str;
        }
        if ((i & 2) == 0) {
            this.error = null;
        } else {
            this.error = str2;
        }
        if ((i & 4) == 0) {
            this.httpErrorCode = null;
        } else {
            this.httpErrorCode = num;
        }
        if ((i & 8) == 0) {
            this.emergencyCode = null;
        } else {
            this.emergencyCode = str3;
        }
        if ((i & 16) == 0) {
            this.code = null;
        } else {
            this.code = num2;
        }
        if ((i & 32) == 0) {
            this.limitExpiresAt = null;
        } else {
            this.limitExpiresAt = str4;
        }
    }

    public DomainEmpty(String str, String str2, Integer num, String str3, Integer num2, String str4) {
        this.message = str;
        this.error = str2;
        this.httpErrorCode = num;
        this.emergencyCode = str3;
        this.code = num2;
        this.limitExpiresAt = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainEmpty self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.message != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.message);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.error != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.error);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.httpErrorCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.httpErrorCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.emergencyCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.emergencyCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.code != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.code);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.limitExpiresAt == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.limitExpiresAt);
    }

    public /* synthetic */ DomainEmpty(String str, String str2, Integer num, String str3, Integer num2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str4);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getError() {
        return this.error;
    }

    public final Integer getHttpErrorCode() {
        return this.httpErrorCode;
    }

    public final void setHttpErrorCode(Integer num) {
        this.httpErrorCode = num;
    }

    public final String getEmergencyCode() {
        return this.emergencyCode;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getLimitExpiresAt() {
        return this.limitExpiresAt;
    }
}
