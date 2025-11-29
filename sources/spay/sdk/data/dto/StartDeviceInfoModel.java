package spay.sdk.data.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1901s;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, d2 = {"Lspay/sdk/data/dto/StartDeviceInfoModel;", "", "compromised", "", "emulator", "rdpConnection", "accessibilityServices", "Lspay/sdk/data/dto/StartDeviceInfoModel$AccessibilityServices;", "rdpConnectionDuration", "debugger", "(IIILspay/sdk/data/dto/StartDeviceInfoModel$AccessibilityServices;II)V", "getAccessibilityServices", "()Lspay/sdk/data/dto/StartDeviceInfoModel$AccessibilityServices;", "getCompromised", "()I", "getDebugger", "getEmulator", "getRdpConnection", "getRdpConnectionDuration", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "AccessibilityServices", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartDeviceInfoModel {

    @SerializedName("AccessibilityServices")
    private final AccessibilityServices accessibilityServices;

    @SerializedName("Compromised")
    private final int compromised;

    @SerializedName("Debugger")
    private final int debugger;

    @SerializedName("Emulator")
    private final int emulator;

    @SerializedName("RdpConnection")
    private final int rdpConnection;

    @SerializedName("RdpConnectionDuration")
    private final int rdpConnectionDuration;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lspay/sdk/data/dto/StartDeviceInfoModel$AccessibilityServices;", "", "enabled", "", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AccessibilityServices {

        @SerializedName("enabled")
        private final boolean enabled;

        public AccessibilityServices(boolean z) {
            this.enabled = z;
        }

        public static /* synthetic */ AccessibilityServices copy$default(AccessibilityServices accessibilityServices, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = accessibilityServices.enabled;
            }
            return accessibilityServices.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        public final AccessibilityServices copy(boolean enabled) {
            return new AccessibilityServices(enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccessibilityServices) && this.enabled == ((AccessibilityServices) other).enabled;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return AbstractC1901s.a(new StringBuilder("AccessibilityServices(enabled="), this.enabled, ')');
        }
    }

    public StartDeviceInfoModel(int i, int i2, int i3, AccessibilityServices accessibilityServices, int i4, int i5) {
        Intrinsics.checkNotNullParameter(accessibilityServices, "accessibilityServices");
        this.compromised = i;
        this.emulator = i2;
        this.rdpConnection = i3;
        this.accessibilityServices = accessibilityServices;
        this.rdpConnectionDuration = i4;
        this.debugger = i5;
    }

    public static /* synthetic */ StartDeviceInfoModel copy$default(StartDeviceInfoModel startDeviceInfoModel, int i, int i2, int i3, AccessibilityServices accessibilityServices, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = startDeviceInfoModel.compromised;
        }
        if ((i6 & 2) != 0) {
            i2 = startDeviceInfoModel.emulator;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = startDeviceInfoModel.rdpConnection;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            accessibilityServices = startDeviceInfoModel.accessibilityServices;
        }
        AccessibilityServices accessibilityServices2 = accessibilityServices;
        if ((i6 & 16) != 0) {
            i4 = startDeviceInfoModel.rdpConnectionDuration;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = startDeviceInfoModel.debugger;
        }
        return startDeviceInfoModel.copy(i, i7, i8, accessibilityServices2, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCompromised() {
        return this.compromised;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEmulator() {
        return this.emulator;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRdpConnection() {
        return this.rdpConnection;
    }

    /* renamed from: component4, reason: from getter */
    public final AccessibilityServices getAccessibilityServices() {
        return this.accessibilityServices;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRdpConnectionDuration() {
        return this.rdpConnectionDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDebugger() {
        return this.debugger;
    }

    public final StartDeviceInfoModel copy(int compromised, int emulator, int rdpConnection, AccessibilityServices accessibilityServices, int rdpConnectionDuration, int debugger) {
        Intrinsics.checkNotNullParameter(accessibilityServices, "accessibilityServices");
        return new StartDeviceInfoModel(compromised, emulator, rdpConnection, accessibilityServices, rdpConnectionDuration, debugger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartDeviceInfoModel)) {
            return false;
        }
        StartDeviceInfoModel startDeviceInfoModel = (StartDeviceInfoModel) other;
        return this.compromised == startDeviceInfoModel.compromised && this.emulator == startDeviceInfoModel.emulator && this.rdpConnection == startDeviceInfoModel.rdpConnection && Intrinsics.areEqual(this.accessibilityServices, startDeviceInfoModel.accessibilityServices) && this.rdpConnectionDuration == startDeviceInfoModel.rdpConnectionDuration && this.debugger == startDeviceInfoModel.debugger;
    }

    public final AccessibilityServices getAccessibilityServices() {
        return this.accessibilityServices;
    }

    public final int getCompromised() {
        return this.compromised;
    }

    public final int getDebugger() {
        return this.debugger;
    }

    public final int getEmulator() {
        return this.emulator;
    }

    public final int getRdpConnection() {
        return this.rdpConnection;
    }

    public final int getRdpConnectionDuration() {
        return this.rdpConnectionDuration;
    }

    public int hashCode() {
        return Integer.hashCode(this.debugger) + ((Integer.hashCode(this.rdpConnectionDuration) + ((this.accessibilityServices.hashCode() + ((Integer.hashCode(this.rdpConnection) + ((Integer.hashCode(this.emulator) + (Integer.hashCode(this.compromised) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "StartDeviceInfoModel(compromised=" + this.compromised + ", emulator=" + this.emulator + ", rdpConnection=" + this.rdpConnection + ", accessibilityServices=" + this.accessibilityServices + ", rdpConnectionDuration=" + this.rdpConnectionDuration + ", debugger=" + this.debugger + ')';
    }
}
