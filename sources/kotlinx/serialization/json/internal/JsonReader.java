package kotlinx.serialization.json.internal;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b%\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u000fH&¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\u000fH&¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H\u0004¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u001f¢\u0006\u0004\b.\u0010\u0003J\u0015\u0010(\u001a\u00020'2\u0006\u0010/\u001a\u00020'¢\u0006\u0004\b(\u00100J\u0017\u0010(\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020*H\u0016¢\u0006\u0004\b(\u00101J\u0017\u00102\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020*H\u0004¢\u0006\u0004\b2\u00101J!\u00108\u001a\u0002052\u0006\u00103\u001a\u00020'2\b\b\u0002\u00104\u001a\u00020\u000fH\u0000¢\u0006\u0004\b6\u00107J\r\u00109\u001a\u00020'¢\u0006\u0004\b9\u0010)J\u0017\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u000f¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J!\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u000fH&¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u0004\u0018\u00010\n2\u0006\u0010@\u001a\u00020\u000f¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001f¢\u0006\u0004\bE\u0010\u0003J\u001f\u0010G\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\fJ\u000f\u0010H\u001a\u00020\nH&¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\n¢\u0006\u0004\bI\u0010\u000eJ'\u0010I\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0005¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\n¢\u0006\u0004\bK\u0010\u000eJ\r\u0010L\u001a\u00020\n¢\u0006\u0004\bL\u0010\u000eJ\u001f\u0010O\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0014¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u000f¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\nH\u0016¢\u0006\u0004\bT\u0010\u000eJ\u0015\u0010V\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ)\u00108\u001a\u0002052\u0006\u0010X\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010Y\u001a\u00020\n¢\u0006\u0004\b8\u0010ZJ\r\u0010\\\u001a\u00020[¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020\u000f¢\u0006\u0004\b^\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\t\u0010_R\u0014\u0010a\u001a\u00020`8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR&\u0010g\u001a\u00060ej\u0002`f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010\u0016\u001a\u00020\u00158$X¤\u0004¢\u0006\u0006\u001a\u0004\bm\u0010n¨\u0006o"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", "", "lastPosition", "current", "appendEscape", "(II)I", "currentPosition", "", "decodedString", "(II)Ljava/lang/String;", "takePeeked", "()Ljava/lang/String;", "", "wasUnquotedString", "()Z", "startPosition", "appendEsc", "(I)I", "", "source", "startPos", "appendHex", "(Ljava/lang/CharSequence;I)I", "fromHexChar", "start", "consumeBoolean", "(I)Z", "literalSuffix", "", "consumeBooleanLiteral", "(Ljava/lang/String;I)V", "ensureHaveChars", "position", "prefetchOrEof", "tryConsumeComma", "canConsumeValue", "", "consumeNextToken", "()B", "", "c", "isValidValueStart", "(C)Z", "expectEof", "expected", "(B)B", "(C)V", "unexpectedToken", "expectedToken", "wasConsumed", "", "fail$kotlinx_serialization_json", "(BZ)Ljava/lang/Void;", "fail", "peekNextToken", "doConsume", "tryConsumeNull", "(Z)Z", "skipWhitespaces", "()I", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "peekString", "(Z)Ljava/lang/String;", "discardPeeked", "endPos", "substring", "consumeKeyString", "consumeString", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "consumeStringLenientNotNull", "consumeStringLenient", "fromIndex", "toIndex", "appendRange", "(II)V", "allowLenientStrings", "skipElement", "(Z)V", "toString", "key", "failOnUnknownKey", "(Ljava/lang/String;)V", CrashHianalyticsData.MESSAGE, "hint", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", "", "consumeNumericLiteral", "()J", "consumeBooleanLenient", "I", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "escapedString", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "getSource", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: kotlinx.serialization.json.internal.AbstractJsonLexer, reason: from toString */
/* loaded from: classes4.dex */
public abstract class JsonReader {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public abstract void consumeNextToken(char expected);

    public void ensureHaveChars() {
    }

    protected abstract CharSequence getSource();

    protected final boolean isValidValueStart(char c) {
        return !(c == '}' || c == ']' || c == ':' || c == ',');
    }

    public abstract String peekLeadingMatchingValue(String keyToMatch, boolean isLenient);

    public abstract int prefetchOrEof(int position);

    public abstract int skipWhitespaces();

    public abstract boolean tryConsumeComma();

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final byte consumeNextToken(byte expected) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == expected) {
            return bConsumeNextToken;
        }
        fail$kotlinx_serialization_json$default(this, expected, false, 2, null);
        throw new KotlinNothingValueException();
    }

    protected final void unexpectedToken(char expected) {
        int i = this.currentPosition;
        if (i > 0 && expected == '\"') {
            try {
                this.currentPosition = i - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.currentPosition = i;
                if (Intrinsics.areEqual(strConsumeStringLenient, "null")) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i;
                throw th;
            }
        }
        fail$kotlinx_serialization_json$default(this, AbstractJsonLexerKt.charToTokenClass(expected), false, 2, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$kotlinx_serialization_json$default(JsonReader jsonReader, byte b, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return jsonReader.fail$kotlinx_serialization_json(b, z);
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken, boolean wasConsumed) {
        String str = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int i = wasConsumed ? this.currentPosition - 1 : this.currentPosition;
        fail$default(this, "Expected " + str + ", but had '" + ((this.currentPosition == getSource().length() || i < 0) ? "EOF" : String.valueOf(getSource().charAt(i))) + "' instead", i, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof != -1) {
                char cCharAt = source.charAt(iPrefetchOrEof);
                if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                    this.currentPosition = iPrefetchOrEof;
                    return AbstractJsonLexerKt.charToTokenClass(cCharAt);
                }
                i = iPrefetchOrEof + 1;
            } else {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
        }
    }

    public static /* synthetic */ boolean tryConsumeNull$default(JsonReader jsonReader, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return jsonReader.tryConsumeNull(z);
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - iPrefetchOrEof;
        if (length < 4 || iPrefetchOrEof == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if ("null".charAt(i) != getSource().charAt(iPrefetchOrEof + i)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iPrefetchOrEof + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = iPrefetchOrEof + 4;
        return true;
    }

    public final String peekString(boolean isLenient) {
        String strConsumeString;
        byte bPeekNextToken = peekNextToken();
        if (isLenient) {
            if (bPeekNextToken != 1 && bPeekNextToken != 0) {
                return null;
            }
            strConsumeString = consumeStringLenient();
        } else {
            if (bPeekNextToken != 1) {
                return null;
            }
            strConsumeString = consumeString();
        }
        this.peekedString = strConsumeString;
        return strConsumeString;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    protected final String consumeString(CharSequence source, int startPosition, int current) {
        String strDecodedString;
        int iPrefetchOrEof;
        Intrinsics.checkNotNullParameter(source, "source");
        char cCharAt = source.charAt(current);
        boolean z = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iPrefetchOrEof = prefetchOrEof(appendEscape(startPosition, current));
                if (iPrefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                current++;
                if (current >= source.length()) {
                    appendRange(startPosition, current);
                    iPrefetchOrEof = prefetchOrEof(current);
                    if (iPrefetchOrEof == -1) {
                        fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    cCharAt = source.charAt(current);
                }
            }
            z = true;
            startPosition = iPrefetchOrEof;
            current = startPosition;
            cCharAt = source.charAt(current);
        }
        if (!z) {
            strDecodedString = substring(startPosition, current);
        } else {
            strDecodedString = decodedString(startPosition, current);
        }
        this.currentPosition = current + 1;
        return strDecodedString;
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String string = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.escapedString.setLength(0);
        return string;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String strConsumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual(strConsumeStringLenient, "null") || !wasUnquotedString()) {
            return strConsumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String strDecodedString;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= getSource().length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte bCharToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(iSkipWhitespaces), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.currentPosition = iSkipWhitespaces;
                    return decodedString(0, 0);
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        if (!z) {
            strDecodedString = substring(this.currentPosition, iSkipWhitespaces);
        } else {
            strDecodedString = decodedString(this.currentPosition, iSkipWhitespaces);
        }
        this.currentPosition = iSkipWhitespaces;
        return strDecodedString;
    }

    protected void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    private final int appendEsc(int startPosition) {
        int iPrefetchOrEof = prefetchOrEof(startPosition);
        if (iPrefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = iPrefetchOrEof + 1;
        char cCharAt = getSource().charAt(iPrefetchOrEof);
        if (cCharAt == 'u') {
            return appendHex(getSource(), i);
        }
        char cEscapeToChar = AbstractJsonLexerKt.escapeToChar(cCharAt);
        if (cEscapeToChar == 0) {
            fail$default(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append(cEscapeToChar);
        return i;
    }

    private final int appendHex(CharSequence source, int startPos) {
        int i = startPos + 4;
        if (i >= source.length()) {
            this.currentPosition = startPos;
            ensureHaveChars();
            if (this.currentPosition + 4 >= source.length()) {
                fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            return appendHex(source, this.currentPosition);
        }
        this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
        return i;
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char cCharAt = source.charAt(currentPosition);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void skipElement(boolean allowLenientStrings) {
        ArrayList arrayList = new ArrayList();
        byte bPeekNextToken = peekNextToken();
        if (bPeekNextToken != 8 && bPeekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte bPeekNextToken2 = peekNextToken();
            if (bPeekNextToken2 != 1) {
                if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                    arrayList.add(Byte.valueOf(bPeekNextToken2));
                } else if (bPeekNextToken2 == 9) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (bPeekNextToken2 == 7) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (bPeekNextToken2 == 10) {
                    fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (allowLenientStrings) {
                consumeStringLenient();
            } else {
                consumeKeyString();
            }
        }
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        fail("Encountered an unknown key '" + key + '\'', StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), key, 0, false, 6, (Object) null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$default(JsonReader jsonReader, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = jsonReader.currentPosition;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return jsonReader.fail(str, i, str2);
    }

    public final Void fail(String message, int position, String hint) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw JsonExceptionsKt.JsonDecodingException(position, message + " at path: " + this.path.getPath() + str, getSource());
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f6, code lost:
    
        fail$default(r17, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0206, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011d, code lost:
    
        fail$default(r17, "Unexpected symbol '" + r3 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0141, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0142, code lost:
    
        if (r5 == r0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0144, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
    
        if (r0 == r5) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0149, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014d, code lost:
    
        if (r0 == (r5 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014f, code lost:
    
        if (r1 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0151, code lost:
    
        if (r3 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015d, code lost:
    
        if (getSource().charAt(r5) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015f, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0162, code lost:
    
        fail$default(r17, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0172, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0173, code lost:
    
        fail$default(r17, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0183, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0184, code lost:
    
        r17.currentPosition = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0186, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0188, code lost:
    
        r0 = r11 * consumeNumericLiteral$calculateExponent(r13, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0192, code lost:
    
        if (r0 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0198, code lost:
    
        if (r0 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a0, code lost:
    
        if (java.lang.Math.floor(r0) != r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a2, code lost:
    
        r11 = (long) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a4, code lost:
    
        fail$default(r17, "Can't convert " + r0 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c8, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c9, code lost:
    
        fail$default(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d9, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01da, code lost:
    
        if (r10 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:
    
        if (r11 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e4, code lost:
    
        return -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e5, code lost:
    
        fail$default(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f5, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long consumeNumericLiteral() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonReader.consumeNumericLiteral():long");
    }

    private static final double consumeNumericLiteral$calculateExponent(long j, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -j);
        }
        if (z) {
            return Math.pow(10.0d, j);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        boolean zConsumeBoolean = consumeBoolean(iSkipWhitespaces);
        if (z) {
            if (this.currentPosition == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (getSource().charAt(this.currentPosition) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.currentPosition++;
        }
        return zConsumeBoolean;
    }

    private final boolean consumeBoolean(int start) {
        int iPrefetchOrEof = prefetchOrEof(start);
        if (iPrefetchOrEof >= getSource().length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = iPrefetchOrEof + 1;
        int iCharAt = getSource().charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            consumeBooleanLiteral("alse", i);
            return false;
        }
        if (iCharAt == 116) {
            consumeBooleanLiteral("rue", i);
            return true;
        }
        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i = 0; i < length; i++) {
            if (literalSuffix.charAt(i) != (getSource().charAt(current + i) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = current + literalSuffix.length();
    }
}
