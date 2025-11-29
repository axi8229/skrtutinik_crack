package com.sputnik.common.entities.help;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Announce.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/entities/help/Announce;", "", "Lcom/sputnik/common/entities/help/Announce$AnnounceType;", "type", "", CrashHianalyticsData.MESSAGE, "<init>", "(Lcom/sputnik/common/entities/help/Announce$AnnounceType;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/help/Announce$AnnounceType;", "getType", "()Lcom/sputnik/common/entities/help/Announce$AnnounceType;", "Ljava/lang/String;", "getMessage", "Companion", "AnnounceType", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Announce {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String message;
    private final AnnounceType type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Announce)) {
            return false;
        }
        Announce announce = (Announce) other;
        return this.type == announce.type && Intrinsics.areEqual(this.message, announce.message);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "Announce(type=" + this.type + ", message=" + this.message + ")";
    }

    public Announce(AnnounceType type, String message) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.type = type;
        this.message = message;
    }

    public final AnnounceType getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Announce.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/entities/help/Announce$AnnounceType;", "", "(Ljava/lang/String;I)V", "INFO", "WARNING", "CRITICAL", "UNKNOWN", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnnounceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnnounceType[] $VALUES;
        public static final AnnounceType INFO = new AnnounceType("INFO", 0);
        public static final AnnounceType WARNING = new AnnounceType("WARNING", 1);
        public static final AnnounceType CRITICAL = new AnnounceType("CRITICAL", 2);
        public static final AnnounceType UNKNOWN = new AnnounceType("UNKNOWN", 3);

        private static final /* synthetic */ AnnounceType[] $values() {
            return new AnnounceType[]{INFO, WARNING, CRITICAL, UNKNOWN};
        }

        public static AnnounceType valueOf(String str) {
            return (AnnounceType) Enum.valueOf(AnnounceType.class, str);
        }

        public static AnnounceType[] values() {
            return (AnnounceType[]) $VALUES.clone();
        }

        private AnnounceType(String str, int i) {
        }

        static {
            AnnounceType[] announceTypeArr$values = $values();
            $VALUES = announceTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(announceTypeArr$values);
        }
    }

    /* compiled from: Announce.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/entities/help/Announce$Companion;", "", "()V", "parseType", "Lcom/sputnik/common/entities/help/Announce$AnnounceType;", "type", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnnounceType parseType(String type) {
            if (type == null) {
                AnnounceType announceType = AnnounceType.INFO;
            }
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 3237038) {
                    if (iHashCode != 1124446108) {
                        if (iHashCode == 1952151455 && type.equals("critical")) {
                            return AnnounceType.CRITICAL;
                        }
                    } else if (type.equals("warning")) {
                        return AnnounceType.WARNING;
                    }
                } else if (type.equals("info")) {
                    return AnnounceType.INFO;
                }
            }
            return AnnounceType.UNKNOWN;
        }
    }
}
