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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AppSettings.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0003*+)B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/sputnik/domain/entities/prefs/AppSettings;", "", "Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "bleSettings", "", "permissionsRequested", "<init>", "(Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/AppSettings;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;Ljava/lang/Boolean;)Lcom/sputnik/domain/entities/prefs/AppSettings;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "getBleSettings", "()Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "setBleSettings", "(Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;)V", "Ljava/lang/Boolean;", "getPermissionsRequested", "()Ljava/lang/Boolean;", "setPermissionsRequested", "(Ljava/lang/Boolean;)V", "Companion", "$serializer", "BleSettings", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class AppSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BleSettings bleSettings;
    private Boolean permissionsRequested;

    public AppSettings() {
        this((BleSettings) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ AppSettings copy$default(AppSettings appSettings, BleSettings bleSettings, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bleSettings = appSettings.bleSettings;
        }
        if ((i & 2) != 0) {
            bool = appSettings.permissionsRequested;
        }
        return appSettings.copy(bleSettings, bool);
    }

    public final AppSettings copy(BleSettings bleSettings, Boolean permissionsRequested) {
        Intrinsics.checkNotNullParameter(bleSettings, "bleSettings");
        return new AppSettings(bleSettings, permissionsRequested);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSettings)) {
            return false;
        }
        AppSettings appSettings = (AppSettings) other;
        return Intrinsics.areEqual(this.bleSettings, appSettings.bleSettings) && Intrinsics.areEqual(this.permissionsRequested, appSettings.permissionsRequested);
    }

    public int hashCode() {
        int iHashCode = this.bleSettings.hashCode() * 31;
        Boolean bool = this.permissionsRequested;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "AppSettings(bleSettings=" + this.bleSettings + ", permissionsRequested=" + this.permissionsRequested + ")";
    }

    @Deprecated
    public /* synthetic */ AppSettings(int i, BleSettings bleSettings, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        this.bleSettings = (i & 1) == 0 ? BleSettings.INSTANCE.m2541default() : bleSettings;
        if ((i & 2) == 0) {
            this.permissionsRequested = null;
        } else {
            this.permissionsRequested = bool;
        }
    }

    public AppSettings(BleSettings bleSettings, Boolean bool) {
        Intrinsics.checkNotNullParameter(bleSettings, "bleSettings");
        this.bleSettings = bleSettings;
        this.permissionsRequested = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(AppSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.bleSettings, BleSettings.INSTANCE.m2541default())) {
            output.encodeSerializableElement(serialDesc, 0, AppSettings$BleSettings$$serializer.INSTANCE, self.bleSettings);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.permissionsRequested == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.permissionsRequested);
    }

    public /* synthetic */ AppSettings(BleSettings bleSettings, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BleSettings.INSTANCE.m2541default() : bleSettings, (i & 2) != 0 ? null : bool);
    }

    public final BleSettings getBleSettings() {
        return this.bleSettings;
    }

    public final void setBleSettings(BleSettings bleSettings) {
        Intrinsics.checkNotNullParameter(bleSettings, "<set-?>");
        this.bleSettings = bleSettings;
    }

    public final Boolean getPermissionsRequested() {
        return this.permissionsRequested;
    }

    /* compiled from: AppSettings.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000243BG\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bBW\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017JX\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b0\u0010$R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&¨\u00065"}, d2 = {"Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "", "", "enabled", "", "rssiMin", "rssiMax", "rssiOptimal", "blePromoEnabled", "bleServiceAvailable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "getRssiMin", "()Ljava/lang/Integer;", "setRssiMin", "(Ljava/lang/Integer;)V", "getRssiMax", "setRssiMax", "getRssiOptimal", "setRssiOptimal", "getBlePromoEnabled", "getBleServiceAvailable", "setBleServiceAvailable", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class BleSettings {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean blePromoEnabled;
        private Boolean bleServiceAvailable;
        private Boolean enabled;
        private Integer rssiMax;
        private Integer rssiMin;
        private Integer rssiOptimal;

        public static /* synthetic */ BleSettings copy$default(BleSettings bleSettings, Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = bleSettings.enabled;
            }
            if ((i & 2) != 0) {
                num = bleSettings.rssiMin;
            }
            Integer num4 = num;
            if ((i & 4) != 0) {
                num2 = bleSettings.rssiMax;
            }
            Integer num5 = num2;
            if ((i & 8) != 0) {
                num3 = bleSettings.rssiOptimal;
            }
            Integer num6 = num3;
            if ((i & 16) != 0) {
                bool2 = bleSettings.blePromoEnabled;
            }
            Boolean bool4 = bool2;
            if ((i & 32) != 0) {
                bool3 = bleSettings.bleServiceAvailable;
            }
            return bleSettings.copy(bool, num4, num5, num6, bool4, bool3);
        }

        public final BleSettings copy(Boolean enabled, Integer rssiMin, Integer rssiMax, Integer rssiOptimal, Boolean blePromoEnabled, Boolean bleServiceAvailable) {
            return new BleSettings(enabled, rssiMin, rssiMax, rssiOptimal, blePromoEnabled, bleServiceAvailable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BleSettings)) {
                return false;
            }
            BleSettings bleSettings = (BleSettings) other;
            return Intrinsics.areEqual(this.enabled, bleSettings.enabled) && Intrinsics.areEqual(this.rssiMin, bleSettings.rssiMin) && Intrinsics.areEqual(this.rssiMax, bleSettings.rssiMax) && Intrinsics.areEqual(this.rssiOptimal, bleSettings.rssiOptimal) && Intrinsics.areEqual(this.blePromoEnabled, bleSettings.blePromoEnabled) && Intrinsics.areEqual(this.bleServiceAvailable, bleSettings.bleServiceAvailable);
        }

        public int hashCode() {
            Boolean bool = this.enabled;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Integer num = this.rssiMin;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.rssiMax;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.rssiOptimal;
            int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Boolean bool2 = this.blePromoEnabled;
            int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.bleServiceAvailable;
            return iHashCode5 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "BleSettings(enabled=" + this.enabled + ", rssiMin=" + this.rssiMin + ", rssiMax=" + this.rssiMax + ", rssiOptimal=" + this.rssiOptimal + ", blePromoEnabled=" + this.blePromoEnabled + ", bleServiceAvailable=" + this.bleServiceAvailable + ")";
        }

        @Deprecated
        public /* synthetic */ BleSettings(int i, Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Boolean bool3, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, AppSettings$BleSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.enabled = bool;
            this.rssiMin = num;
            this.rssiMax = num2;
            this.rssiOptimal = num3;
            if ((i & 16) == 0) {
                this.blePromoEnabled = null;
            } else {
                this.blePromoEnabled = bool2;
            }
            if ((i & 32) == 0) {
                this.bleServiceAvailable = null;
            } else {
                this.bleServiceAvailable = bool3;
            }
        }

        public BleSettings(Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Boolean bool3) {
            this.enabled = bool;
            this.rssiMin = num;
            this.rssiMax = num2;
            this.rssiOptimal = num3;
            this.blePromoEnabled = bool2;
            this.bleServiceAvailable = bool3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(BleSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, booleanSerializer, self.enabled);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 1, intSerializer, self.rssiMin);
            output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.rssiMax);
            output.encodeNullableSerializableElement(serialDesc, 3, intSerializer, self.rssiOptimal);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.blePromoEnabled != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, booleanSerializer, self.blePromoEnabled);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.bleServiceAvailable == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, booleanSerializer, self.bleServiceAvailable);
        }

        public /* synthetic */ BleSettings(Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, num, num2, num3, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : bool3);
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public final Integer getRssiMin() {
            return this.rssiMin;
        }

        public final Integer getRssiMax() {
            return this.rssiMax;
        }

        public final Integer getRssiOptimal() {
            return this.rssiOptimal;
        }

        public final void setRssiOptimal(Integer num) {
            this.rssiOptimal = num;
        }

        public final Boolean getBlePromoEnabled() {
            return this.blePromoEnabled;
        }

        public final void setBleServiceAvailable(Boolean bool) {
            this.bleServiceAvailable = bool;
        }

        /* compiled from: AppSettings.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings$Companion;", "", "()V", "MAX_RSSI", "", "MIN_RSSI", "default", "Lcom/sputnik/domain/entities/prefs/AppSettings$BleSettings;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<BleSettings> serializer() {
                return AppSettings$BleSettings$$serializer.INSTANCE;
            }

            /* renamed from: default, reason: not valid java name */
            public final BleSettings m2541default() {
                return new BleSettings(Boolean.FALSE, (Integer) (-60), (Integer) (-150), (Integer) (-120), Boolean.TRUE, (Boolean) null, 32, (DefaultConstructorMarker) null);
            }
        }
    }

    /* compiled from: AppSettings.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/entities/prefs/AppSettings$Companion;", "", "()V", "default", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AppSettings> serializer() {
            return AppSettings$$serializer.INSTANCE;
        }

        /* renamed from: default, reason: not valid java name */
        public final AppSettings m2542default() {
            return new AppSettings(BleSettings.INSTANCE.m2541default(), Boolean.FALSE);
        }
    }
}
