package com.sputnik.domain.entities.call;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainCall.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002'&B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tBC\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b%\u0010\u0018¨\u0006("}, d2 = {"Lcom/sputnik/domain/entities/call/DomainCall;", "", "", "flatUuid", "acceptedBy", "Lcom/sputnik/domain/entities/call/CallState;", "state", "sipAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/call/DomainCall;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFlatUuid", "getAcceptedBy", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "getSipAddress", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainCall {
    private final String acceptedBy;
    private final String flatUuid;
    private final String sipAddress;
    private final CallState state;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new EnumSerializer("com.sputnik.domain.entities.call.CallState", CallState.values()), null};

    public DomainCall() {
        this((String) null, (String) null, (CallState) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCall)) {
            return false;
        }
        DomainCall domainCall = (DomainCall) other;
        return Intrinsics.areEqual(this.flatUuid, domainCall.flatUuid) && Intrinsics.areEqual(this.acceptedBy, domainCall.acceptedBy) && this.state == domainCall.state && Intrinsics.areEqual(this.sipAddress, domainCall.sipAddress);
    }

    public int hashCode() {
        String str = this.flatUuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.acceptedBy;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        CallState callState = this.state;
        int iHashCode3 = (iHashCode2 + (callState == null ? 0 : callState.hashCode())) * 31;
        String str3 = this.sipAddress;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DomainCall(flatUuid=" + this.flatUuid + ", acceptedBy=" + this.acceptedBy + ", state=" + this.state + ", sipAddress=" + this.sipAddress + ")";
    }

    /* compiled from: DomainCall.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/call/DomainCall$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/call/DomainCall;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainCall> serializer() {
            return DomainCall$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainCall(int i, String str, String str2, CallState callState, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.flatUuid = null;
        } else {
            this.flatUuid = str;
        }
        if ((i & 2) == 0) {
            this.acceptedBy = null;
        } else {
            this.acceptedBy = str2;
        }
        if ((i & 4) == 0) {
            this.state = null;
        } else {
            this.state = callState;
        }
        if ((i & 8) == 0) {
            this.sipAddress = null;
        } else {
            this.sipAddress = str3;
        }
    }

    public DomainCall(String str, String str2, CallState callState, String str3) {
        this.flatUuid = str;
        this.acceptedBy = str2;
        this.state = callState;
        this.sipAddress = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainCall self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.flatUuid != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.flatUuid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.acceptedBy != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.acceptedBy);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.state != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.state);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.sipAddress == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.sipAddress);
    }

    public /* synthetic */ DomainCall(String str, String str2, CallState callState, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : callState, (i & 8) != 0 ? null : str3);
    }

    public final String getFlatUuid() {
        return this.flatUuid;
    }

    public final String getAcceptedBy() {
        return this.acceptedBy;
    }

    public final CallState getState() {
        return this.state;
    }

    public final String getSipAddress() {
        return this.sipAddress;
    }
}
