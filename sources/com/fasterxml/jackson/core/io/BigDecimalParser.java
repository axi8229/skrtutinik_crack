package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BigDecimalParser {
    private static final int MAX_CHARS_TO_REPORT = 1000;
    private final char[] chars;

    BigDecimalParser(char[] cArr) {
        this.chars = cArr;
    }

    public static BigDecimal parse(String str) {
        return parse(str.toCharArray());
    }

    public static BigDecimal parse(char[] cArr, int i, int i2) {
        if (i > 0 || i2 != cArr.length) {
            cArr = Arrays.copyOfRange(cArr, i, i2 + i);
        }
        return parse(cArr);
    }

    public static BigDecimal parse(char[] cArr) {
        String str;
        int length = cArr.length;
        try {
            if (length < 500) {
                return new BigDecimal(cArr);
            }
            return new BigDecimalParser(cArr).parseBigDecimal(length / 10);
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Not a valid number representation";
            }
            if (cArr.length <= 1000) {
                str = new String(cArr);
            } else {
                str = new String(Arrays.copyOfRange(cArr, 0, 1000)) + "(truncated, full length is " + cArr.length + " chars)";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigDecimal`, reason: " + message);
        }
    }

    private BigDecimal parseBigDecimal(int i) throws NumberFormatException {
        int i2;
        int i3;
        BigDecimal bigDecimalRec;
        int length = this.chars.length;
        int i4 = -1;
        int i5 = -1;
        int iAdjustScale = 0;
        boolean z = false;
        boolean z2 = false;
        int i6 = 0;
        boolean z3 = false;
        for (int i7 = 0; i7 < length; i7++) {
            char c = this.chars[i7];
            if (c != '+') {
                if (c == 'E' || c == 'e') {
                    if (i4 >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    i4 = i7;
                } else if (c != '-') {
                    if (c == '.') {
                        if (i5 >= 0) {
                            throw new NumberFormatException("Multiple decimal points");
                        }
                        i5 = i7;
                    } else if (i5 >= 0 && i4 == -1) {
                        iAdjustScale++;
                    }
                } else if (i4 >= 0) {
                    if (z2) {
                        throw new NumberFormatException("Multiple signs in exponent");
                    }
                    z2 = true;
                } else {
                    if (z) {
                        throw new NumberFormatException("Multiple signs in number");
                    }
                    i6 = i7 + 1;
                    z = true;
                    z3 = true;
                }
            } else if (i4 >= 0) {
                if (z2) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
                z2 = true;
            } else {
                if (z) {
                    throw new NumberFormatException("Multiple signs in number");
                }
                i6 = i7 + 1;
                z = true;
            }
        }
        if (i4 >= 0) {
            i2 = 1;
            i3 = Integer.parseInt(new String(this.chars, i4 + 1, (length - i4) - 1));
            iAdjustScale = adjustScale(iAdjustScale, i3);
            length = i4;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (i5 >= 0) {
            int i8 = (length - i5) - i2;
            bigDecimalRec = toBigDecimalRec(i6, i5 - i6, i3, i).add(toBigDecimalRec(i5 + i2, i8, i3 - i8, i));
        } else {
            bigDecimalRec = toBigDecimalRec(i6, length - i6, i3, i);
        }
        if (iAdjustScale != 0) {
            bigDecimalRec = bigDecimalRec.setScale(iAdjustScale);
        }
        return z3 ? bigDecimalRec.negate() : bigDecimalRec;
    }

    private int adjustScale(int i, long j) {
        long j2 = i - j;
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new NumberFormatException("Scale out of range: " + j2 + " while adjusting scale " + i + " to exponent " + j);
    }

    private BigDecimal toBigDecimalRec(int i, int i2, int i3, int i4) {
        if (i2 <= i4) {
            return i2 == 0 ? BigDecimal.ZERO : new BigDecimal(this.chars, i, i2).movePointRight(i3);
        }
        int i5 = i2 / 2;
        return toBigDecimalRec(i, i5, (i3 + i2) - i5, i4).add(toBigDecimalRec(i + i5, i2 - i5, i3, i4));
    }
}
