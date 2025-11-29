package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class WebvttParserUtil {
    private static final Pattern COMMENT = Pattern.compile("^NOTE([ \t].*)?$");

    public static void validateWebvttHeaderLine(ParsableByteArray input) throws ParserException {
        int position = input.getPosition();
        if (isWebvttHeaderLine(input)) {
            return;
        }
        input.setPosition(position);
        throw new ParserException("Expected WEBVTT. Got " + input.readLine());
    }

    public static boolean isWebvttHeaderLine(ParsableByteArray input) {
        String line = input.readLine();
        return line != null && line.startsWith("WEBVTT");
    }

    public static long parseTimestampUs(String timestamp) throws NumberFormatException {
        String[] strArrSplitAtFirst = Util.splitAtFirst(timestamp, "\\.");
        long j = 0;
        for (String str : Util.split(strArrSplitAtFirst[0], ":")) {
            j = (j * 60) + Long.parseLong(str);
        }
        long j2 = j * 1000;
        if (strArrSplitAtFirst.length == 2) {
            j2 += Long.parseLong(strArrSplitAtFirst[1]);
        }
        return j2 * 1000;
    }

    public static float parsePercentage(String s) throws NumberFormatException {
        if (!s.endsWith("%")) {
            throw new NumberFormatException("Percentages must end with %");
        }
        return Float.parseFloat(s.substring(0, s.length() - 1)) / 100.0f;
    }
}
