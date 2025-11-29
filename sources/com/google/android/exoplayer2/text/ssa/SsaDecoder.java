package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final SsaDialogueFormat dialogueFormatFromInitializationData;
    private final boolean haveInitializationData;
    private float screenHeight;
    private float screenWidth;
    private Map<String, SsaStyle> styles;

    private static float computeDefaultLineOrPosition(int anchor) {
        if (anchor == 0) {
            return 0.05f;
        }
        if (anchor != 1) {
            return anchor != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public SsaDecoder(List<byte[]> initializationData) {
        super("SsaDecoder");
        this.screenWidth = -3.4028235E38f;
        this.screenHeight = -3.4028235E38f;
        if (initializationData != null && !initializationData.isEmpty()) {
            this.haveInitializationData = true;
            String strFromUtf8Bytes = Util.fromUtf8Bytes(initializationData.get(0));
            Assertions.checkArgument(strFromUtf8Bytes.startsWith("Format:"));
            this.dialogueFormatFromInitializationData = (SsaDialogueFormat) Assertions.checkNotNull(SsaDialogueFormat.fromFormatLine(strFromUtf8Bytes));
            parseHeader(new ParsableByteArray(initializationData.get(1)));
            return;
        }
        this.haveInitializationData = false;
        this.dialogueFormatFromInitializationData = null;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bytes, int length, boolean reset) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bytes, length);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, arrayList2);
        return new SsaSubtitle(arrayList, arrayList2);
    }

    private void parseHeader(ParsableByteArray data) {
        while (true) {
            String line = data.readLine();
            if (line == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(line)) {
                parseScriptInfo(data);
            } else if ("[V4+ Styles]".equalsIgnoreCase(line)) {
                this.styles = parseStyles(data);
            } else if ("[V4 Styles]".equalsIgnoreCase(line)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(line)) {
                return;
            }
        }
    }

    private void parseScriptInfo(ParsableByteArray data) {
        while (true) {
            String line = data.readLine();
            if (line == null) {
                return;
            }
            if (data.bytesLeft() != 0 && data.peekUnsignedByte() == 91) {
                return;
            }
            String[] strArrSplit = line.split(":");
            if (strArrSplit.length == 2) {
                String lowerInvariant = Util.toLowerInvariant(strArrSplit[0].trim());
                lowerInvariant.hashCode();
                if (lowerInvariant.equals("playresx")) {
                    this.screenWidth = Float.parseFloat(strArrSplit[1].trim());
                } else if (lowerInvariant.equals("playresy")) {
                    try {
                        this.screenHeight = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map<String, SsaStyle> parseStyles(ParsableByteArray data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format formatFromFormatLine = null;
        while (true) {
            String line = data.readLine();
            if (line == null || (data.bytesLeft() != 0 && data.peekUnsignedByte() == 91)) {
                break;
            }
            if (line.startsWith("Format:")) {
                formatFromFormatLine = SsaStyle.Format.fromFormatLine(line);
            } else if (line.startsWith("Style:")) {
                if (formatFromFormatLine == null) {
                    Log.w("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + line);
                } else {
                    SsaStyle ssaStyleFromStyleLine = SsaStyle.fromStyleLine(line, formatFromFormatLine);
                    if (ssaStyleFromStyleLine != null) {
                        linkedHashMap.put(ssaStyleFromStyleLine.name, ssaStyleFromStyleLine);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private void parseEventBody(ParsableByteArray data, List<List<Cue>> cues, List<Long> cueTimesUs) {
        SsaDialogueFormat ssaDialogueFormatFromFormatLine = this.haveInitializationData ? this.dialogueFormatFromInitializationData : null;
        while (true) {
            String line = data.readLine();
            if (line == null) {
                return;
            }
            if (line.startsWith("Format:")) {
                ssaDialogueFormatFromFormatLine = SsaDialogueFormat.fromFormatLine(line);
            } else if (line.startsWith("Dialogue:")) {
                if (ssaDialogueFormatFromFormatLine == null) {
                    Log.w("SsaDecoder", "Skipping dialogue line before complete format: " + line);
                } else {
                    parseDialogueLine(line, ssaDialogueFormatFromFormatLine, cues, cueTimesUs);
                }
            }
        }
    }

    private void parseDialogueLine(String dialogueLine, SsaDialogueFormat format, List<List<Cue>> cues, List<Long> cueTimesUs) {
        int i;
        Assertions.checkArgument(dialogueLine.startsWith("Dialogue:"));
        String[] strArrSplit = dialogueLine.substring(9).split(",", format.length);
        if (strArrSplit.length != format.length) {
            Log.w("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + dialogueLine);
            return;
        }
        long timecodeUs = parseTimecodeUs(strArrSplit[format.startTimeIndex]);
        if (timecodeUs == -9223372036854775807L) {
            Log.w("SsaDecoder", "Skipping invalid timing: " + dialogueLine);
            return;
        }
        long timecodeUs2 = parseTimecodeUs(strArrSplit[format.endTimeIndex]);
        if (timecodeUs2 == -9223372036854775807L) {
            Log.w("SsaDecoder", "Skipping invalid timing: " + dialogueLine);
            return;
        }
        Map<String, SsaStyle> map = this.styles;
        SsaStyle ssaStyle = (map == null || (i = format.styleIndex) == -1) ? null : map.get(strArrSplit[i].trim());
        String str = strArrSplit[format.textIndex];
        Cue cueCreateCue = createCue(SsaStyle.Overrides.stripStyleOverrides(str).replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n"), ssaStyle, SsaStyle.Overrides.parseFromDialogue(str), this.screenWidth, this.screenHeight);
        int iAddCuePlacerholderByTime = addCuePlacerholderByTime(timecodeUs2, cueTimesUs, cues);
        for (int iAddCuePlacerholderByTime2 = addCuePlacerholderByTime(timecodeUs, cueTimesUs, cues); iAddCuePlacerholderByTime2 < iAddCuePlacerholderByTime; iAddCuePlacerholderByTime2++) {
            cues.get(iAddCuePlacerholderByTime2).add(cueCreateCue);
        }
    }

    private static long parseTimecodeUs(String timeString) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(timeString.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) Util.castNonNull(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) Util.castNonNull(matcher.group(2))) * 60000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(4))) * DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
        }
        return -9223372036854775807L;
    }

    private static Cue createCue(String text, SsaStyle style, SsaStyle.Overrides styleOverrides, float screenWidth, float screenHeight) {
        float fComputeDefaultLineOrPosition;
        float fComputeDefaultLineOrPosition2;
        int i = styleOverrides.alignment;
        if (i == -1) {
            i = style != null ? style.alignment : -1;
        }
        int positionAnchor = toPositionAnchor(i);
        int lineAnchor = toLineAnchor(i);
        PointF pointF = styleOverrides.position;
        if (pointF != null && screenHeight != -3.4028235E38f && screenWidth != -3.4028235E38f) {
            float f = pointF.x / screenWidth;
            fComputeDefaultLineOrPosition2 = pointF.y / screenHeight;
            fComputeDefaultLineOrPosition = f;
        } else {
            fComputeDefaultLineOrPosition = computeDefaultLineOrPosition(positionAnchor);
            fComputeDefaultLineOrPosition2 = computeDefaultLineOrPosition(lineAnchor);
        }
        return new Cue(text, toTextAlignment(i), fComputeDefaultLineOrPosition2, 0, lineAnchor, fComputeDefaultLineOrPosition, positionAnchor, -3.4028235E38f);
    }

    private static Layout.Alignment toTextAlignment(int alignment) {
        switch (alignment) {
            case -1:
                return null;
            case 0:
            default:
                Log.w("SsaDecoder", "Unknown alignment: " + alignment);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private static int toLineAnchor(int alignment) {
        switch (alignment) {
            case -1:
                break;
            case 0:
            default:
                Log.w("SsaDecoder", "Unknown alignment: " + alignment);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int toPositionAnchor(int alignment) {
        switch (alignment) {
            case -1:
                break;
            case 0:
            default:
                Log.w("SsaDecoder", "Unknown alignment: " + alignment);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int addCuePlacerholderByTime(long timeUs, List<Long> sortedCueTimesUs, List<List<Cue>> cues) {
        int i;
        ArrayList arrayList;
        int size = sortedCueTimesUs.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (sortedCueTimesUs.get(size).longValue() == timeUs) {
                return size;
            }
            if (sortedCueTimesUs.get(size).longValue() < timeUs) {
                i = size + 1;
                break;
            }
            size--;
        }
        sortedCueTimesUs.add(i, Long.valueOf(timeUs));
        if (i == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(cues.get(i - 1));
        }
        cues.add(i, arrayList);
        return i;
    }
}
