package kotlinx.serialization.json.internal;

import kotlin.Metadata;

/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "token", "", "tokenDescription", "(B)Ljava/lang/String;", "", "c", "charToTokenClass", "(C)B", "", "escapeToChar", "(I)C", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AbstractJsonLexerKt {
    public static final String tokenDescription(byte b) {
        if (b == 1) {
            return "quotation mark '\"'";
        }
        if (b == 2) {
            return "string escape sequence '\\'";
        }
        if (b == 4) {
            return "comma ','";
        }
        if (b == 5) {
            return "colon ':'";
        }
        if (b == 6) {
            return "start of the object '{'";
        }
        if (b == 7) {
            return "end of the object '}'";
        }
        if (b == 8) {
            return "start of the array '['";
        }
        if (b == 9) {
            return "end of the array ']'";
        }
        if (b == 10) {
            return "end of the input";
        }
        if (b == 127) {
            return "invalid token";
        }
        return "valid token";
    }

    public static final byte charToTokenClass(char c) {
        if (c < '~') {
            return CharMappings.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    public static final char escapeToChar(int i) {
        if (i < 117) {
            return CharMappings.ESCAPE_2_CHAR[i];
        }
        return (char) 0;
    }
}
