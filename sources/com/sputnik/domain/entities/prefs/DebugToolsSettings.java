package com.sputnik.domain.entities.prefs;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: DebugToolsSettings.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002$#B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fHÇ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u0003\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u0004\u0010\u001f\"\u0004\b\"\u0010!¨\u0006%"}, d2 = {"Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "", "", "isAccountLimitsEnabled", "isBleServiceAvailable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAccountLimitsEnabled", "(Ljava/lang/Boolean;)V", "setBleServiceAvailable", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DebugToolsSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Boolean isAccountLimitsEnabled;
    private Boolean isBleServiceAvailable;

    public final DebugToolsSettings copy(Boolean isAccountLimitsEnabled, Boolean isBleServiceAvailable) {
        return new DebugToolsSettings(isAccountLimitsEnabled, isBleServiceAvailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebugToolsSettings)) {
            return false;
        }
        DebugToolsSettings debugToolsSettings = (DebugToolsSettings) other;
        return Intrinsics.areEqual(this.isAccountLimitsEnabled, debugToolsSettings.isAccountLimitsEnabled) && Intrinsics.areEqual(this.isBleServiceAvailable, debugToolsSettings.isBleServiceAvailable);
    }

    public int hashCode() {
        Boolean bool = this.isAccountLimitsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isBleServiceAvailable;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "DebugToolsSettings(isAccountLimitsEnabled=" + this.isAccountLimitsEnabled + ", isBleServiceAvailable=" + this.isBleServiceAvailable + ")";
    }

    @Deprecated
    public /* synthetic */ DebugToolsSettings(int i, Boolean bool, Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, DebugToolsSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.isAccountLimitsEnabled = bool;
        if ((i & 2) == 0) {
            this.isBleServiceAvailable = null;
        } else {
            this.isBleServiceAvailable = bool2;
        }
    }

    public DebugToolsSettings(Boolean bool, Boolean bool2) {
        this.isAccountLimitsEnabled = bool;
        this.isBleServiceAvailable = bool2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DebugToolsSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, booleanSerializer, self.isAccountLimitsEnabled);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.isBleServiceAvailable == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, booleanSerializer, self.isBleServiceAvailable);
    }

    public /* synthetic */ DebugToolsSettings(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, (i & 2) != 0 ? null : bool2);
    }

    /* renamed from: isAccountLimitsEnabled, reason: from getter */
    public final Boolean getIsAccountLimitsEnabled() {
        return this.isAccountLimitsEnabled;
    }

    /* renamed from: isBleServiceAvailable, reason: from getter */
    public final Boolean getIsBleServiceAvailable() {
        return this.isBleServiceAvailable;
    }

    public final void setBleServiceAvailable(Boolean bool) {
        this.isBleServiceAvailable = bool;
    }

    /* compiled from: DebugToolsSettings.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/entities/prefs/DebugToolsSettings$Companion;", "", "()V", "default", "Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebugToolsSettings> serializer() {
            return DebugToolsSettings$$serializer.INSTANCE;
        }

        /* renamed from: default, reason: not valid java name */
        public final DebugToolsSettings m2543default() {
            return new DebugToolsSettings(Boolean.TRUE, Boolean.FALSE);
        }
    }
}
