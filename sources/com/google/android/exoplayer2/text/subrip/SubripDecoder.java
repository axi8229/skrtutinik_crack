package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    private final ArrayList<String> tags;
    private final StringBuilder textBuilder;
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");

    public SubripDecoder() {
        super("SubripDecoder");
        this.textBuilder = new StringBuilder();
        this.tags = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bytes, int length, boolean reset) throws NumberFormatException {
        String str;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bytes, length);
        while (true) {
            String line = parsableByteArray.readLine();
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                try {
                    Integer.parseInt(line);
                    String line2 = parsableByteArray.readLine();
                    if (line2 == null) {
                        Log.w("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(line2);
                    if (!matcher.matches()) {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + line2);
                    } else {
                        longArray.add(parseTimecode(matcher, 1));
                        longArray.add(parseTimecode(matcher, 6));
                        int i = 0;
                        this.textBuilder.setLength(0);
                        this.tags.clear();
                        for (String line3 = parsableByteArray.readLine(); !TextUtils.isEmpty(line3); line3 = parsableByteArray.readLine()) {
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(processLine(line3, this.tags));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.textBuilder.toString());
                        while (true) {
                            if (i >= this.tags.size()) {
                                str = null;
                                break;
                            }
                            str = this.tags.get(i);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i++;
                        }
                        arrayList.add(buildCue(spannedFromHtml, str));
                        arrayList.add(Cue.EMPTY);
                    }
                } catch (NumberFormatException unused) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + line);
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SubripSubtitle(cueArr, longArray.toArray());
    }

    private String processLine(String line, ArrayList<String> tags) {
        String strTrim = line.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            tags.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.exoplayer2.text.Cue buildCue(android.text.Spanned r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.buildCue(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.Cue");
    }

    private static long parseTimecode(Matcher matcher, int groupOffset) {
        String strGroup = matcher.group(groupOffset + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(groupOffset + 2))) * 60000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(groupOffset + 3))) * 1000);
        String strGroup2 = matcher.group(groupOffset + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    static float getFractionalPositionForAnchorType(int anchorType) {
        if (anchorType == 0) {
            return 0.08f;
        }
        if (anchorType == 1) {
            return 0.5f;
        }
        if (anchorType == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
}
