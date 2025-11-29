package kotlin.time;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b$\b\u0087@\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001^B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0013\u0010\r\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\bJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\bJ\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J?\u00105\u001a\u000202*\u00060,j\u0002`-2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020(2\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J\r\u00107\u001a\u00020(¢\u0006\u0004\b6\u0010*J\u0010\u0010:\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010>\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010;HÖ\u0003¢\u0006\u0004\b<\u0010=R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010?R\u0014\u0010A\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u0014\u0010D\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bE\u0010\u0005R\u001a\u0010J\u001a\u00020\u001f8@X\u0081\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001a\u0004\bG\u00109R\u001a\u0010M\u001a\u00020\u001f8@X\u0081\u0004¢\u0006\f\u0012\u0004\bL\u0010I\u001a\u0004\bK\u00109R\u001a\u0010P\u001a\u00020\u001f8@X\u0081\u0004¢\u0006\f\u0012\u0004\bO\u0010I\u001a\u0004\bN\u00109R\u001a\u0010S\u001a\u00020\u001f8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010I\u001a\u0004\bQ\u00109R\u0011\u0010U\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bT\u0010\u0005R\u0011\u0010W\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bV\u0010\u0005R\u0011\u0010Y\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u0005R\u0011\u0010[\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0005R\u0011\u0010]\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0004\n\u0002\b!¨\u0006_"}, d2 = {"Lkotlin/time/Duration;", "", "", "rawValue", "constructor-impl", "(J)J", "", "isInNanos-impl", "(J)Z", "isInNanos", "isInMillis-impl", "isInMillis", "unaryMinus-UwyO8pc", "unaryMinus", "other", "plus-LRDsOJo", "(JJ)J", "plus", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "addValuesMixedRanges", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "", "compareTo-LRDsOJo", "(JJ)I", "compareTo", "Lkotlin/time/DurationUnit;", "unit", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "appendFractional", "toIsoString-impl", "toIsoString", "hashCode-impl", "(J)I", "hashCode", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getValue-impl", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes4.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m2752constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m2750boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2753equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    private static final long m2765getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2766hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m2768isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m2769isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m2771isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m2772isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m2753equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m2766hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m2778compareToLRDsOJo(duration.getRawValue());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m2764getStorageUnitimpl(long j) {
        return m2769isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2752constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m2769isInNanosimpl(j)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).contains(m2765getValueimpl(j))) {
                    throw new AssertionError(m2765getValueimpl(j) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new LongRange(-4611686018427387903L, 4611686018427387903L).contains(m2765getValueimpl(j))) {
                    throw new AssertionError(m2765getValueimpl(j) + " ms is out of milliseconds range");
                }
                if (new LongRange(-4611686018426L, 4611686018426L).contains(m2765getValueimpl(j))) {
                    throw new AssertionError(m2765getValueimpl(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u00068\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00068\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u0004\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/time/Duration;", "parseIsoString-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "ZERO", "J", "getZERO-UwyO8pc", "()J", "INFINITE", "getINFINITE-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m2781getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m2780getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m2782parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m2777unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m2765getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m2773plusLRDsOJo(long j, long j2) {
        if (m2770isInfiniteimpl(j)) {
            if (m2767isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m2770isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long jM2765getValueimpl = m2765getValueimpl(j) + m2765getValueimpl(j2);
            return m2769isInNanosimpl(j) ? DurationKt.durationOfNanosNormalized(jM2765getValueimpl) : DurationKt.durationOfMillisNormalized(jM2765getValueimpl);
        }
        if (m2768isInMillisimpl(j)) {
            return m2748addValuesMixedRangesUwyO8pc(j, m2765getValueimpl(j), m2765getValueimpl(j2));
        }
        return m2748addValuesMixedRangesUwyO8pc(j, m2765getValueimpl(j2), m2765getValueimpl(j));
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m2748addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j4)) {
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(j4) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m2770isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m2767isFiniteimpl(long j) {
        return !m2770isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m2754getAbsoluteValueUwyO8pc(long j) {
        return m2771isNegativeimpl(j) ? m2777unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m2778compareToLRDsOJo(long j) {
        return m2751compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m2751compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m2771isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m2755getHoursComponentimpl(long j) {
        if (m2770isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2757getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m2761getMinutesComponentimpl(long j) {
        if (m2770isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2759getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m2763getSecondsComponentimpl(long j) {
        if (m2770isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2760getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m2762getNanosecondsComponentimpl(long j) {
        long jM2765getValueimpl;
        if (m2770isInfiniteimpl(j)) {
            return 0;
        }
        if (m2768isInMillisimpl(j)) {
            jM2765getValueimpl = DurationKt.millisToNanos(m2765getValueimpl(j) % 1000);
        } else {
            jM2765getValueimpl = m2765getValueimpl(j) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        }
        return (int) jM2765getValueimpl;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m2775toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2765getValueimpl(j), m2764getStorageUnitimpl(j), unit);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m2756getInWholeDaysimpl(long j) {
        return m2775toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m2757getInWholeHoursimpl(long j) {
        return m2775toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m2759getInWholeMinutesimpl(long j) {
        return m2775toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m2760getInWholeSecondsimpl(long j) {
        return m2775toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m2758getInWholeMillisecondsimpl(long j) {
        return (m2768isInMillisimpl(j) && m2767isFiniteimpl(j)) ? m2765getValueimpl(j) : m2775toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    public String toString() {
        return m2776toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2776toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM2771isNegativeimpl = m2771isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM2771isNegativeimpl) {
            sb.append('-');
        }
        long jM2754getAbsoluteValueUwyO8pc = m2754getAbsoluteValueUwyO8pc(j);
        long jM2756getInWholeDaysimpl = m2756getInWholeDaysimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2755getHoursComponentimpl = m2755getHoursComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2761getMinutesComponentimpl = m2761getMinutesComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2763getSecondsComponentimpl = m2763getSecondsComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2762getNanosecondsComponentimpl = m2762getNanosecondsComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM2756getInWholeDaysimpl != 0;
        boolean z2 = iM2755getHoursComponentimpl != 0;
        boolean z3 = iM2761getMinutesComponentimpl != 0;
        boolean z4 = (iM2763getSecondsComponentimpl == 0 && iM2762getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM2756getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM2755getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM2761getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM2763getSecondsComponentimpl != 0 || z || z2 || z3) {
                m2749appendFractionalimpl(j, sb, iM2763getSecondsComponentimpl, iM2762getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM2762getNanosecondsComponentimpl >= 1000000) {
                m2749appendFractionalimpl(j, sb, iM2762getNanosecondsComponentimpl / 1000000, iM2762getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM2762getNanosecondsComponentimpl >= 1000) {
                m2749appendFractionalimpl(j, sb, iM2762getNanosecondsComponentimpl / 1000, iM2762getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM2762getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM2771isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m2749appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) strPadStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m2774toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m2771isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM2754getAbsoluteValueUwyO8pc = m2754getAbsoluteValueUwyO8pc(j);
        long jM2757getInWholeHoursimpl = m2757getInWholeHoursimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2761getMinutesComponentimpl = m2761getMinutesComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2763getSecondsComponentimpl = m2763getSecondsComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        int iM2762getNanosecondsComponentimpl = m2762getNanosecondsComponentimpl(jM2754getAbsoluteValueUwyO8pc);
        if (m2770isInfiniteimpl(j)) {
            jM2757getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = jM2757getInWholeHoursimpl != 0;
        boolean z3 = (iM2763getSecondsComponentimpl == 0 && iM2762getNanosecondsComponentimpl == 0) ? false : true;
        if (iM2761getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM2757getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM2761getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m2749appendFractionalimpl(j, sb, iM2763getSecondsComponentimpl, iM2762getNanosecondsComponentimpl, 9, "S", true);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
