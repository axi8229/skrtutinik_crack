package org.jose4j.json.internal.json_simple.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes4.dex */
class Yylex {
    private int yychar;
    private int yycolumn;
    private int yyline;
    private boolean zzAtEOF;
    private int zzCurrentPos;
    private int zzEndRead;
    private int zzMarkedPos;
    private Reader zzReader;
    private int zzStartRead;
    private int zzState;
    private static final int[] ZZ_LEXSTATE = {0, 0, 1, 1};
    private static final char[] ZZ_CMAP = zzUnpackCMap("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000");
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final int[] ZZ_TRANS = {2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String[] ZZ_ERROR_MSG = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private int zzLexicalState = 0;
    private char[] zzBuffer = new char[16384];
    private boolean zzAtBOL = true;
    private StringBuilder sb = new StringBuilder();

    private static int[] zzUnpackAction() {
        int[] iArr = new int[45];
        zzUnpackAction("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", 0, iArr);
        return iArr;
    }

    private static int zzUnpackAction(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2);
            i2 += 2;
            char cCharAt = str.charAt(i3);
            do {
                iArr[i] = cCharAt;
                iCharAt--;
                i++;
            } while (iCharAt > 0);
        }
        return i;
    }

    private static int[] zzUnpackRowMap() {
        int[] iArr = new int[45];
        zzUnpackRowMap("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006", 0, iArr);
        return iArr;
    }

    private static int zzUnpackRowMap(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2) << 16;
            i2 += 2;
            iArr[i] = str.charAt(i3) | iCharAt;
            i++;
        }
        return i;
    }

    private static int[] zzUnpackAttribute() {
        int[] iArr = new int[45];
        zzUnpackAttribute("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", 0, iArr);
        return iArr;
    }

    private static int zzUnpackAttribute(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int iCharAt = str.charAt(i2);
            i2 += 2;
            char cCharAt = str.charAt(i3);
            do {
                iArr[i] = cCharAt;
                iCharAt--;
                i++;
            } while (iCharAt > 0);
        }
        return i;
    }

    int getPosition() {
        return this.yychar;
    }

    Yylex(Reader reader) {
        this.zzReader = reader;
    }

    private static char[] zzUnpackCMap(String str) {
        char[] cArr = new char[pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1];
        int i = 0;
        int i2 = 0;
        while (i < 90) {
            int i3 = i + 1;
            int iCharAt = str.charAt(i);
            i += 2;
            char cCharAt = str.charAt(i3);
            do {
                cArr[i2] = cCharAt;
                iCharAt--;
                i2++;
            } while (iCharAt > 0);
        }
        return cArr;
    }

    private boolean zzRefill() throws IOException {
        int i;
        int i2 = this.zzStartRead;
        if (i2 > 0) {
            char[] cArr = this.zzBuffer;
            System.arraycopy(cArr, i2, cArr, 0, this.zzEndRead - i2);
            int i3 = this.zzEndRead;
            int i4 = this.zzStartRead;
            this.zzEndRead = i3 - i4;
            this.zzCurrentPos -= i4;
            this.zzMarkedPos -= i4;
            this.zzStartRead = 0;
        }
        int i5 = this.zzCurrentPos;
        char[] cArr2 = this.zzBuffer;
        if (i5 >= cArr2.length) {
            char[] cArr3 = new char[i5 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.zzBuffer = cArr3;
        }
        Reader reader = this.zzReader;
        char[] cArr4 = this.zzBuffer;
        int i6 = this.zzEndRead;
        int i7 = reader.read(cArr4, i6, cArr4.length - i6);
        if (i7 > 0) {
            this.zzEndRead += i7;
            return false;
        }
        if (i7 != 0 || (i = this.zzReader.read()) == -1) {
            return true;
        }
        char[] cArr5 = this.zzBuffer;
        int i8 = this.zzEndRead;
        this.zzEndRead = i8 + 1;
        cArr5[i8] = (char) i;
        return false;
    }

    public final void yyreset(Reader reader) {
        this.zzReader = reader;
        this.zzAtBOL = true;
        this.zzAtEOF = false;
        this.zzStartRead = 0;
        this.zzEndRead = 0;
        this.zzMarkedPos = 0;
        this.zzCurrentPos = 0;
        this.yycolumn = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.zzLexicalState = 0;
    }

    public final void yybegin(int i) {
        this.zzLexicalState = i;
    }

    public final String yytext() {
        char[] cArr = this.zzBuffer;
        int i = this.zzStartRead;
        return new String(cArr, i, this.zzMarkedPos - i);
    }

    public final char yycharat(int i) {
        return this.zzBuffer[this.zzStartRead + i];
    }

    private void zzScanError(int i) {
        String str;
        try {
            str = ZZ_ERROR_MSG[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = ZZ_ERROR_MSG[0];
        }
        throw new Error(str);
    }

    public Yytoken yylex() throws ParseException, NumberFormatException, IOException {
        char c;
        int i;
        char c2;
        int i2 = this.zzEndRead;
        char[] cArr = this.zzBuffer;
        char[] cArr2 = ZZ_CMAP;
        int[] iArr = ZZ_TRANS;
        int[] iArr2 = ZZ_ROWMAP;
        int[] iArr3 = ZZ_ATTRIBUTE;
        while (true) {
            int i3 = this.zzMarkedPos;
            this.yychar += i3 - this.zzStartRead;
            this.zzStartRead = i3;
            this.zzCurrentPos = i3;
            this.zzState = ZZ_LEXSTATE[this.zzLexicalState];
            char c3 = 65535;
            int i4 = i3;
            int i5 = -1;
            while (true) {
                if (i3 < i2) {
                    i = i3 + 1;
                    c = cArr[i3];
                } else if (this.zzAtEOF) {
                    c = c3;
                } else {
                    this.zzCurrentPos = i3;
                    this.zzMarkedPos = i4;
                    boolean zZzRefill = zzRefill();
                    int i6 = this.zzCurrentPos;
                    i4 = this.zzMarkedPos;
                    char[] cArr3 = this.zzBuffer;
                    int i7 = this.zzEndRead;
                    if (zZzRefill) {
                        cArr = cArr3;
                        c = c3;
                        i2 = i7;
                    } else {
                        i = i6 + 1;
                        i2 = i7;
                        c = cArr3[i6];
                        cArr = cArr3;
                    }
                }
                int i8 = iArr[iArr2[this.zzState] + cArr2[c]];
                if (i8 != c3) {
                    this.zzState = i8;
                    int i9 = iArr3[i8];
                    if ((i9 & 1) != 1) {
                        c2 = 65535;
                    } else if ((i9 & 8) == 8) {
                        i4 = i;
                        i5 = i8;
                    } else {
                        c2 = 65535;
                        i4 = i;
                        i5 = i8;
                    }
                    i3 = i;
                    c3 = c2;
                }
            }
            this.zzMarkedPos = i4;
            if (i5 >= 0) {
                i5 = ZZ_ACTION[i5];
            }
            switch (i5) {
                case 1:
                    throw new ParseException(this.yychar, 0, new Character(yycharat(0)));
                case 2:
                    String strYytext = yytext();
                    try {
                        return new Yytoken(0, Long.valueOf(strYytext));
                    } catch (NumberFormatException unused) {
                        return new Yytoken(0, new BigInteger(strYytext));
                    }
                case 3:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    break;
                case 4:
                    this.sb = null;
                    this.sb = new StringBuilder();
                    yybegin(2);
                    break;
                case 5:
                    return new Yytoken(1, null);
                case 6:
                    return new Yytoken(2, null);
                case 7:
                    return new Yytoken(3, null);
                case 8:
                    return new Yytoken(4, null);
                case 9:
                    return new Yytoken(5, null);
                case 10:
                    return new Yytoken(6, null);
                case 11:
                    this.sb.append(yytext());
                    break;
                case 12:
                    this.sb.append('\\');
                    break;
                case 13:
                    yybegin(0);
                    return new Yytoken(0, this.sb.toString());
                case 14:
                    this.sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    break;
                case 15:
                    this.sb.append(JsonPointer.SEPARATOR);
                    break;
                case 16:
                    this.sb.append('\b');
                    break;
                case 17:
                    this.sb.append('\f');
                    break;
                case 18:
                    this.sb.append('\n');
                    break;
                case 19:
                    this.sb.append('\r');
                    break;
                case 20:
                    this.sb.append('\t');
                    break;
                case 21:
                    return new Yytoken(0, Double.valueOf(yytext()));
                case 22:
                    return new Yytoken(0, null);
                case 23:
                    return new Yytoken(0, Boolean.valueOf(yytext()));
                case 24:
                    try {
                        this.sb.append((char) Integer.parseInt(yytext().substring(2), 16));
                        break;
                    } catch (Exception e) {
                        throw new ParseException(this.yychar, 2, e);
                    }
                default:
                    if (c == 65535 && this.zzStartRead == this.zzCurrentPos) {
                        this.zzAtEOF = true;
                        return null;
                    }
                    zzScanError(1);
                    break;
                    break;
            }
        }
    }
}
