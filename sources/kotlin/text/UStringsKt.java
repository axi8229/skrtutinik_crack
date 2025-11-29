package kotlin.text;

import com.fasterxml.jackson.module.kotlin.ULongSerializer$$ExternalSyntheticBackport2;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UStrings.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\r\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u0004\u0018\u00010\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001d\u0010\u0018\u001a\u0004\u0018\u00010\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"", "Lkotlin/UByte;", "toUByte", "(Ljava/lang/String;)B", "Lkotlin/UShort;", "toUShort", "(Ljava/lang/String;)S", "Lkotlin/UInt;", "toUInt", "(Ljava/lang/String;)I", "Lkotlin/ULong;", "toULong", "(Ljava/lang/String;)J", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "", "radix", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UStringsKt {
    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compare(data ^ Integer.MIN_VALUE, UInt.m2660constructorimpl(KotlinVersion.MAX_COMPONENT_VALUE) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UByte.m2637boximpl(UByte.m2638constructorimpl((byte) data));
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compare(data ^ Integer.MIN_VALUE, UInt.m2660constructorimpl(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UShort.m2704boximpl(UShort.m2705constructorimpl((short) data));
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iM2660constructorimpl = UInt.m2660constructorimpl(i);
        int iM = 119304647;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (Integer.compare(i3 ^ Integer.MIN_VALUE, iM ^ Integer.MIN_VALUE) > 0) {
                if (iM == 119304647) {
                    iM = UStringsKt$$ExternalSyntheticBackport1.m(-1, iM2660constructorimpl);
                    if (Integer.compare(i3 ^ Integer.MIN_VALUE, iM ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iM2660constructorimpl2 = UInt.m2660constructorimpl(i3 * iM2660constructorimpl);
            int iM2660constructorimpl3 = UInt.m2660constructorimpl(UInt.m2660constructorimpl(iDigitOf) + iM2660constructorimpl2);
            if (Integer.compare(iM2660constructorimpl3 ^ Integer.MIN_VALUE, iM2660constructorimpl2 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            i3 = iM2660constructorimpl3;
        }
        return UInt.m2659boximpl(i3);
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM2682constructorimpl = ULong.m2682constructorimpl(i);
        long j = 0;
        long jM = 512409557603043100L;
        while (i2 < length) {
            if (CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                return null;
            }
            if (Long.compare(j ^ Long.MIN_VALUE, jM ^ Long.MIN_VALUE) > 0) {
                if (jM == 512409557603043100L) {
                    jM = ULongSerializer$$ExternalSyntheticBackport2.m(-1L, jM2682constructorimpl);
                    if (Long.compare(j ^ Long.MIN_VALUE, jM ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jM2682constructorimpl2 = ULong.m2682constructorimpl(j * jM2682constructorimpl);
            long jM2682constructorimpl3 = ULong.m2682constructorimpl(ULong.m2682constructorimpl(UInt.m2660constructorimpl(r13) & 4294967295L) + jM2682constructorimpl2);
            if (Long.compare(jM2682constructorimpl3 ^ Long.MIN_VALUE, jM2682constructorimpl2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            j = jM2682constructorimpl3;
        }
        return ULong.m2681boximpl(j);
    }
}
