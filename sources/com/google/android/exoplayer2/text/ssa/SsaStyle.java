package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class SsaStyle {
    public final int alignment;
    public final String name;

    private static boolean isValidAlignment(int alignment) {
        switch (alignment) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private SsaStyle(String name, int alignment) {
        this.name = name;
        this.alignment = alignment;
    }

    public static SsaStyle fromStyleLine(String styleLine, Format format) {
        Assertions.checkArgument(styleLine.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(styleLine.substring(6), ",");
        int length = strArrSplit.length;
        int i = format.length;
        if (length != i) {
            Log.w("SsaStyle", Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i), Integer.valueOf(strArrSplit.length), styleLine));
            return null;
        }
        try {
            return new SsaStyle(strArrSplit[format.nameIndex].trim(), parseAlignment(strArrSplit[format.alignmentIndex]));
        } catch (RuntimeException e) {
            Log.w("SsaStyle", "Skipping malformed 'Style:' line: '" + styleLine + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseAlignment(String alignmentStr) throws NumberFormatException {
        try {
            int i = Integer.parseInt(alignmentStr.trim());
            if (isValidAlignment(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        Log.w("SsaStyle", "Ignoring unknown alignment: " + alignmentStr);
        return -1;
    }

    static final class Format {
        public final int alignmentIndex;
        public final int length;
        public final int nameIndex;

        private Format(int nameIndex, int alignmentIndex, int length) {
            this.nameIndex = nameIndex;
            this.alignmentIndex = alignmentIndex;
            this.length = length;
        }

        public static Format fromFormatLine(String styleFormatLine) {
            String[] strArrSplit = TextUtils.split(styleFormatLine.substring(7), ",");
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                String lowerInvariant = Util.toLowerInvariant(strArrSplit[i3].trim());
                lowerInvariant.hashCode();
                if (lowerInvariant.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                    i = i3;
                } else if (lowerInvariant.equals("alignment")) {
                    i2 = i3;
                }
            }
            if (i != -1) {
                return new Format(i, i2, strArrSplit.length);
            }
            return null;
        }
    }

    static final class Overrides {
        public final int alignment;
        public final PointF position;
        private static final Pattern BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern POSITION_PATTERN = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern MOVE_PATTERN = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");

        private Overrides(int alignment, PointF position) {
            this.alignment = alignment;
            this.position = position;
        }

        public static Overrides parseFromDialogue(String text) {
            Matcher matcher = BRACES_PATTERN.matcher(text);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str = (String) Assertions.checkNotNull(matcher.group(1));
                try {
                    PointF position = parsePosition(str);
                    if (position != null) {
                        pointF = position;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int alignmentOverride = parseAlignmentOverride(str);
                    if (alignmentOverride != -1) {
                        i = alignmentOverride;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new Overrides(i, pointF);
        }

        public static String stripStyleOverrides(String dialogueLine) {
            return BRACES_PATTERN.matcher(dialogueLine).replaceAll("");
        }

        private static PointF parsePosition(String styleOverride) {
            String strGroup;
            String strGroup2;
            Matcher matcher = POSITION_PATTERN.matcher(styleOverride);
            Matcher matcher2 = MOVE_PATTERN.matcher(styleOverride);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    Log.i("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + styleOverride + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.checkNotNull(strGroup)).trim()), Float.parseFloat(((String) Assertions.checkNotNull(strGroup2)).trim()));
        }

        private static int parseAlignmentOverride(String braceContents) {
            Matcher matcher = ALIGNMENT_OVERRIDE_PATTERN.matcher(braceContents);
            if (matcher.find()) {
                return SsaStyle.parseAlignment((String) Assertions.checkNotNull(matcher.group(1)));
            }
            return -1;
        }
    }
}
