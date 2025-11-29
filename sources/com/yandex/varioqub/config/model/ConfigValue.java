package com.yandex.varioqub.config.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000  2\u00020\u0001:\u0001 B%\b\u0000\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/yandex/varioqub/config/model/ConfigValue;", "", "", "asString", "", "asDouble", "", "asBoolean", "", "asLong", "other", "equals", "", "hashCode", "toString", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "b", "I", "getSourceType", "()I", "sourceType", "c", "J", "getTestId", "()J", "testId", "<init>", "(Ljava/lang/String;IJ)V", "Companion", "config_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class ConfigValue {
    public static final boolean BOOLEAN_DEFAULT_VALUE = false;
    public static final double DOUBLE_DEFAULT_VALUE = 0.0d;
    public static final long LONG_DEFAULT_VALUE = 0;
    public static final int SOURCE_DEFAULT = 0;
    public static final int SOURCE_INAPP_DEFAULT = 1;
    public static final int SOURCE_SERVER = 2;
    public static final String STRING_DEFAULT_VALUE = "";

    /* renamed from: a, reason: from kotlin metadata */
    private final String value;

    /* renamed from: b, reason: from kotlin metadata */
    private final int sourceType;

    /* renamed from: c, reason: from kotlin metadata */
    private final long testId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern d = Pattern.compile("^(true|false)$", 2);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/yandex/varioqub/config/model/ConfigValue$Companion;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lcom/yandex/varioqub/config/model/ConfigValue;", "createInappDefault$config_release", "(Ljava/lang/String;)Lcom/yandex/varioqub/config/model/ConfigValue;", "createInappDefault", "createDefault$config_release", "()Lcom/yandex/varioqub/config/model/ConfigValue;", "createDefault", "", "BOOLEAN_DEFAULT_VALUE", "Z", "Ljava/util/regex/Pattern;", "BOOLEAN_REGEXP", "Ljava/util/regex/Pattern;", "", "DOUBLE_DEFAULT_VALUE", "D", "", "LONG_DEFAULT_VALUE", "J", "", "SOURCE_DEFAULT", "I", "SOURCE_INAPP_DEFAULT", "SOURCE_SERVER", "STRING_DEFAULT_VALUE", "Ljava/lang/String;", "config_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConfigValue createDefault$config_release() {
            return new ConfigValue("", 0, 0L, 4, null);
        }

        public final ConfigValue createInappDefault$config_release(String value) {
            return new ConfigValue(value, 1, 0L, 4, null);
        }
    }

    public ConfigValue(String str, int i, long j) {
        this.value = str;
        this.sourceType = i;
        this.testId = j;
    }

    public final boolean asBoolean() {
        if (this.sourceType == 0) {
            return false;
        }
        Pattern pattern = d;
        String str = this.value;
        if (str == null) {
            str = "";
        }
        if (pattern.matcher(str).matches()) {
            return Boolean.parseBoolean(this.value);
        }
        if (this.sourceType == 1) {
            return false;
        }
        throw new IllegalArgumentException("Value " + this.value + " cannot be converted to type Boolean");
    }

    public final double asDouble() {
        if (this.sourceType == 0) {
            return DOUBLE_DEFAULT_VALUE;
        }
        try {
            String str = this.value;
            return str != null ? Double.parseDouble(str) : DOUBLE_DEFAULT_VALUE;
        } catch (NumberFormatException unused) {
            if (this.sourceType == 1) {
                return DOUBLE_DEFAULT_VALUE;
            }
            throw new IllegalArgumentException("Value " + this.value + " cannot be converted to type Double");
        }
    }

    public final long asLong() {
        if (this.sourceType == 0) {
            return 0L;
        }
        try {
            String str = this.value;
            if (str != null) {
                return Long.parseLong(str);
            }
            return 0L;
        } catch (NumberFormatException unused) {
            if (this.sourceType == 1) {
                return 0L;
            }
            throw new IllegalArgumentException("Value " + this.value + " cannot be converted to type Long");
        }
    }

    public final String asString() {
        String str;
        return (this.sourceType == 0 || (str = this.value) == null) ? "" : str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ConfigValue.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yandex.varioqub.config.model.ConfigValue");
        }
        ConfigValue configValue = (ConfigValue) other;
        return Intrinsics.areEqual(this.value, configValue.value) && this.sourceType == configValue.sourceType && this.testId == configValue.testId;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final long getTestId() {
        return this.testId;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.value;
        return Long.hashCode(this.testId) + ((((str != null ? str.hashCode() : 0) * 31) + this.sourceType) * 31);
    }

    public String toString() {
        return "ConfigValue(value='" + this.value + "', sourceType=" + this.sourceType + ", testId=" + this.testId + ')';
    }

    public /* synthetic */ ConfigValue(String str, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? -1L : j);
    }
}
