package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class CssParser {
    private static final Pattern VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final ParsableByteArray styleInput = new ParsableByteArray();
    private final StringBuilder stringBuilder = new StringBuilder();

    public List<WebvttCssStyle> parseBlock(ParsableByteArray input) {
        this.stringBuilder.setLength(0);
        int position = input.getPosition();
        skipStyleBlock(input);
        this.styleInput.reset(input.data, input.getPosition());
        this.styleInput.setPosition(position);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String selector = parseSelector(this.styleInput, this.stringBuilder);
            if (selector == null || !"{".equals(parseNextToken(this.styleInput, this.stringBuilder))) {
                return arrayList;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            applySelectorToStyle(webvttCssStyle, selector);
            String str = null;
            boolean z = false;
            while (!z) {
                int position2 = this.styleInput.getPosition();
                String nextToken = parseNextToken(this.styleInput, this.stringBuilder);
                boolean z2 = nextToken == null || "}".equals(nextToken);
                if (!z2) {
                    this.styleInput.setPosition(position2);
                    parseStyleDeclaration(this.styleInput, webvttCssStyle, this.stringBuilder);
                }
                str = nextToken;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }

    private static String parseSelector(ParsableByteArray input, StringBuilder stringBuilder) {
        skipWhitespaceAndComments(input);
        if (input.bytesLeft() < 5 || !"::cue".equals(input.readString(5))) {
            return null;
        }
        int position = input.getPosition();
        String nextToken = parseNextToken(input, stringBuilder);
        if (nextToken == null) {
            return null;
        }
        if ("{".equals(nextToken)) {
            input.setPosition(position);
            return "";
        }
        String cueTarget = "(".equals(nextToken) ? readCueTarget(input) : null;
        if (")".equals(parseNextToken(input, stringBuilder))) {
            return cueTarget;
        }
        return null;
    }

    private static String readCueTarget(ParsableByteArray input) {
        int position = input.getPosition();
        int iLimit = input.limit();
        boolean z = false;
        while (position < iLimit && !z) {
            int i = position + 1;
            z = ((char) input.data[position]) == ')';
            position = i;
        }
        return input.readString((position - 1) - input.getPosition()).trim();
    }

    private static void parseStyleDeclaration(ParsableByteArray input, WebvttCssStyle style, StringBuilder stringBuilder) {
        skipWhitespaceAndComments(input);
        String identifier = parseIdentifier(input, stringBuilder);
        if (!"".equals(identifier) && ":".equals(parseNextToken(input, stringBuilder))) {
            skipWhitespaceAndComments(input);
            String propertyValue = parsePropertyValue(input, stringBuilder);
            if (propertyValue == null || "".equals(propertyValue)) {
                return;
            }
            int position = input.getPosition();
            String nextToken = parseNextToken(input, stringBuilder);
            if (!";".equals(nextToken)) {
                if (!"}".equals(nextToken)) {
                    return;
                } else {
                    input.setPosition(position);
                }
            }
            if (RemoteMessageConst.Notification.COLOR.equals(identifier)) {
                style.setFontColor(ColorParser.parseCssColor(propertyValue));
                return;
            }
            if ("background-color".equals(identifier)) {
                style.setBackgroundColor(ColorParser.parseCssColor(propertyValue));
                return;
            }
            boolean z = true;
            if ("text-combine-upright".equals(identifier)) {
                if (!"all".equals(propertyValue) && !propertyValue.startsWith("digits")) {
                    z = false;
                }
                style.setCombineUpright(z);
                return;
            }
            if ("text-decoration".equals(identifier)) {
                if ("underline".equals(propertyValue)) {
                    style.setUnderline(true);
                }
            } else {
                if ("font-family".equals(identifier)) {
                    style.setFontFamily(propertyValue);
                    return;
                }
                if ("font-weight".equals(identifier)) {
                    if ("bold".equals(propertyValue)) {
                        style.setBold(true);
                    }
                } else if ("font-style".equals(identifier) && "italic".equals(propertyValue)) {
                    style.setItalic(true);
                }
            }
        }
    }

    static void skipWhitespaceAndComments(ParsableByteArray input) {
        while (true) {
            for (boolean z = true; input.bytesLeft() > 0 && z; z = false) {
                if (maybeSkipWhitespace(input) || maybeSkipComment(input)) {
                    break;
                }
            }
            return;
        }
    }

    static String parseNextToken(ParsableByteArray input, StringBuilder stringBuilder) {
        skipWhitespaceAndComments(input);
        if (input.bytesLeft() == 0) {
            return null;
        }
        String identifier = parseIdentifier(input, stringBuilder);
        if (!"".equals(identifier)) {
            return identifier;
        }
        return "" + ((char) input.readUnsignedByte());
    }

    private static boolean maybeSkipWhitespace(ParsableByteArray input) {
        char cPeekCharAtPosition = peekCharAtPosition(input, input.getPosition());
        if (cPeekCharAtPosition != '\t' && cPeekCharAtPosition != '\n' && cPeekCharAtPosition != '\f' && cPeekCharAtPosition != '\r' && cPeekCharAtPosition != ' ') {
            return false;
        }
        input.skipBytes(1);
        return true;
    }

    static void skipStyleBlock(ParsableByteArray input) {
        while (!TextUtils.isEmpty(input.readLine())) {
        }
    }

    private static char peekCharAtPosition(ParsableByteArray input, int position) {
        return (char) input.data[position];
    }

    private static String parsePropertyValue(ParsableByteArray input, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!z) {
            int position = input.getPosition();
            String nextToken = parseNextToken(input, stringBuilder);
            if (nextToken == null) {
                return null;
            }
            if ("}".equals(nextToken) || ";".equals(nextToken)) {
                input.setPosition(position);
                z = true;
            } else {
                sb.append(nextToken);
            }
        }
        return sb.toString();
    }

    private static boolean maybeSkipComment(ParsableByteArray input) {
        int position = input.getPosition();
        int iLimit = input.limit();
        byte[] bArr = input.data;
        if (position + 2 > iLimit) {
            return false;
        }
        int i = position + 1;
        if (bArr[position] != 47) {
            return false;
        }
        int i2 = position + 2;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 < iLimit) {
                if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                    i2 += 2;
                    iLimit = i2;
                } else {
                    i2 = i3;
                }
            } else {
                input.skipBytes(iLimit - input.getPosition());
                return true;
            }
        }
    }

    private static String parseIdentifier(ParsableByteArray input, StringBuilder stringBuilder) {
        boolean z = false;
        stringBuilder.setLength(0);
        int position = input.getPosition();
        int iLimit = input.limit();
        while (position < iLimit && !z) {
            char c = (char) input.data[position];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                position++;
                stringBuilder.append(c);
            }
        }
        input.skipBytes(position - input.getPosition());
        return stringBuilder.toString();
    }

    private void applySelectorToStyle(WebvttCssStyle style, String selector) {
        if ("".equals(selector)) {
            return;
        }
        int iIndexOf = selector.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = VOICE_NAME_PATTERN.matcher(selector.substring(iIndexOf));
            if (matcher.matches()) {
                style.setTargetVoice((String) Assertions.checkNotNull(matcher.group(1)));
            }
            selector = selector.substring(0, iIndexOf);
        }
        String[] strArrSplit = Util.split(selector, "\\.");
        String str = strArrSplit[0];
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            style.setTargetTagName(str.substring(0, iIndexOf2));
            style.setTargetId(str.substring(iIndexOf2 + 1));
        } else {
            style.setTargetTagName(str);
        }
        if (strArrSplit.length > 1) {
            style.setTargetClasses((String[]) Util.nullSafeArrayCopyOfRange(strArrSplit, 1, strArrSplit.length));
        }
    }
}
