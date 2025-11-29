package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);

    public TtmlDecoder() throws XmlPullParserException {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bytes, int length, boolean reset) throws XmlPullParserException, SubtitleDecoderException, NumberFormatException, IOException {
        TtmlSubtitle ttmlSubtitle;
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes, 0, length), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRates = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            int i = 0;
            TtmlSubtitle ttmlSubtitle2 = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRates = parseFrameAndTickRates(xmlPullParserNewPullParser);
                            cellResolution = parseCellResolution(xmlPullParserNewPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(xmlPullParserNewPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate2 = frameAndTickRates;
                        CellResolution cellResolution2 = cellResolution;
                        if (isSupportedTag(name)) {
                            if ("head".equals(name)) {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate = frameAndTickRate2;
                                parseHeader(xmlPullParserNewPullParser, map, cellResolution2, ttsExtent2, map2, map3);
                            } else {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate = frameAndTickRate2;
                                try {
                                    TtmlNode node = parseNode(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(node);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(node);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w("TtmlDecoder", "Suppressing parser error", e);
                                    i++;
                                }
                            }
                            frameAndTickRates = frameAndTickRate;
                            ttsExtent = ttsExtent2;
                            cellResolution = cellResolution2;
                        } else {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i++;
                            frameAndTickRates = frameAndTickRate2;
                            ttsExtent = ttsExtent2;
                            cellResolution = cellResolution2;
                        }
                    } else {
                        ttmlSubtitle = ttmlSubtitle2;
                        if (eventType == 4) {
                            ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(xmlPullParserNewPullParser.getText()));
                        } else if (eventType == 3) {
                            ttmlSubtitle2 = xmlPullParserNewPullParser.getName().equals("tt") ? new TtmlSubtitle((TtmlNode) Assertions.checkNotNull(arrayDeque.peek()), map, map2, map3) : ttmlSubtitle;
                            arrayDeque.pop();
                        }
                    }
                    xmlPullParserNewPullParser.next();
                } else {
                    ttmlSubtitle = ttmlSubtitle2;
                    if (eventType == 2) {
                        i++;
                    } else if (eventType == 3) {
                        i--;
                    }
                }
                ttmlSubtitle2 = ttmlSubtitle;
                xmlPullParserNewPullParser.next();
            }
            TtmlSubtitle ttmlSubtitle3 = ttmlSubtitle2;
            if (ttmlSubtitle3 != null) {
                return ttmlSubtitle3;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlParser) throws SubtitleDecoderException, NumberFormatException {
        float f;
        String attributeValue = xmlParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (Util.split(attributeValue2, " ").length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i2 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i * f, i2, i3);
    }

    private CellResolution parseCellResolution(XmlPullParser xmlParser, CellResolution defaultValue) throws SubtitleDecoderException, NumberFormatException {
        String attributeValue = xmlParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return defaultValue;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return defaultValue;
        }
        try {
            int i = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int i2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (i == 0 || i2 == 0) {
                throw new SubtitleDecoderException("Invalid cell resolution " + i + " " + i2);
            }
            return new CellResolution(i, i2);
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return defaultValue;
        }
    }

    private TtsExtent parseTtsExtent(XmlPullParser xmlParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring non-pixel tts extent: " + attributeValue);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed tts extent: " + attributeValue);
            return null;
        }
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlParser, Map<String, TtmlStyle> globalStyles, CellResolution cellResolution, TtsExtent ttsExtent, Map<String, TtmlRegion> globalRegions, Map<String, String> imageMap) throws XmlPullParserException, IOException, NumberFormatException {
        do {
            xmlParser.next();
            if (XmlPullParserUtil.isStartTag(xmlParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlParser, "style");
                TtmlStyle styleAttributes = parseStyleAttributes(xmlParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        styleAttributes.chain(globalStyles.get(str));
                    }
                }
                String id = styleAttributes.getId();
                if (id != null) {
                    globalStyles.put(id, styleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlParser, "region")) {
                TtmlRegion regionAttributes = parseRegionAttributes(xmlParser, cellResolution, ttsExtent);
                if (regionAttributes != null) {
                    globalRegions.put(regionAttributes.id, regionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlParser, "metadata")) {
                parseMetadata(xmlParser, imageMap);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlParser, "head"));
        return globalStyles;
    }

    private void parseMetadata(XmlPullParser xmlParser, Map<String, String> imageMap) throws XmlPullParserException, IOException {
        String attributeValue;
        do {
            xmlParser.next();
            if (XmlPullParserUtil.isStartTag(xmlParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlParser, "id")) != null) {
                imageMap.put(attributeValue, xmlParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlParser, "metadata"));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.exoplayer2.text.ttml.TtmlRegion parseRegionAttributes(org.xmlpull.v1.XmlPullParser r18, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution r19, com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseRegionAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder$CellResolution, com.google.android.exoplayer2.text.ttml.TtmlDecoder$TtsExtent):com.google.android.exoplayer2.text.ttml.TtmlRegion");
    }

    private String[] parseStyleIds(String parentStyleIds) {
        String strTrim = parentStyleIds.trim();
        return strTrim.isEmpty() ? new String[0] : Util.split(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r14, com.google.android.exoplayer2.text.ttml.TtmlStyle r15) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle):com.google.android.exoplayer2.text.ttml.TtmlStyle");
    }

    private TtmlStyle createIfNull(TtmlStyle style) {
        return style == null ? new TtmlStyle() : style;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.exoplayer2.text.ttml.TtmlNode parseNode(org.xmlpull.v1.XmlPullParser r22, com.google.android.exoplayer2.text.ttml.TtmlNode r23, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r24, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r25) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseNode(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    private static boolean isSupportedTag(String tag) {
        return tag.equals("tt") || tag.equals("head") || tag.equals("body") || tag.equals("div") || tag.equals("p") || tag.equals("span") || tag.equals("br") || tag.equals("style") || tag.equals("styling") || tag.equals("layout") || tag.equals("region") || tag.equals("metadata") || tag.equals("image") || tag.equals(RemoteMessageConst.DATA) || tag.equals("information");
    }

    private static void parseFontSize(String expression, TtmlStyle out) throws SubtitleDecoderException {
        Matcher matcher;
        String str;
        String[] strArrSplit = Util.split(expression, "\\s+");
        if (strArrSplit.length == 1) {
            matcher = FONT_SIZE.matcher(expression);
        } else if (strArrSplit.length == 2) {
            matcher = FONT_SIZE.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrSplit.length + ".");
        }
        if (matcher.matches()) {
            str = (String) Assertions.checkNotNull(matcher.group(3));
            str.hashCode();
            switch (str) {
                case "%":
                    out.setFontSizeUnit(3);
                    break;
                case "em":
                    out.setFontSizeUnit(2);
                    break;
                case "px":
                    out.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str + "'.");
            }
            out.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + expression + "'.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long parseTimeExpression(java.lang.String r13, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float effectiveFrameRate, int subFrameRate, int tickRate) {
            this.effectiveFrameRate = effectiveFrameRate;
            this.subFrameRate = subFrameRate;
            this.tickRate = tickRate;
        }
    }

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
