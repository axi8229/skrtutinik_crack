package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.MediaStreamTrack;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes2.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() != 2 || !"MPD".equals(xmlPullParserNewPullParser.getName())) {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            return parseMediaPresentationDescription(xmlPullParserNewPullParser, uri.toString());
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    protected DashManifest parseMediaPresentationDescription(XmlPullParser xpp, String baseUrl) throws XmlPullParserException, IOException, NumberFormatException {
        long j;
        long j2;
        DashManifestParser dashManifestParser = this;
        long dateTime = parseDateTime(xpp, "availabilityStartTime", -9223372036854775807L);
        long duration = parseDuration(xpp, "mediaPresentationDuration", -9223372036854775807L);
        long duration2 = parseDuration(xpp, "minBufferTime", -9223372036854775807L);
        boolean zEquals = "dynamic".equals(xpp.getAttributeValue(null, "type"));
        long duration3 = zEquals ? parseDuration(xpp, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long duration4 = zEquals ? parseDuration(xpp, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long duration5 = zEquals ? parseDuration(xpp, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long dateTime2 = parseDateTime(xpp, "publishTime", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        long j3 = zEquals ? -9223372036854775807L : 0L;
        boolean z = false;
        boolean z2 = false;
        ProgramInformation programInformation = null;
        UtcTimingElement utcTiming = null;
        Uri uri = null;
        String baseUrl2 = baseUrl;
        while (true) {
            xpp.next();
            long j4 = duration4;
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    j = j3;
                    j2 = duration3;
                    j3 = j;
                } else {
                    baseUrl2 = dashManifestParser.parseBaseUrl(xpp, baseUrl2);
                    j2 = duration3;
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "ProgramInformation")) {
                j2 = duration3;
                programInformation = parseProgramInformation(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "UTCTiming")) {
                j2 = duration3;
                utcTiming = parseUtcTiming(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "Location")) {
                j2 = duration3;
                uri = Uri.parse(xpp.nextText());
            } else {
                if (XmlPullParserUtil.isStartTag(xpp, "Period") && !z2) {
                    Pair<Period, Long> period = dashManifestParser.parsePeriod(xpp, baseUrl2, j3);
                    j = j3;
                    Period period2 = (Period) period.first;
                    j2 = duration3;
                    if (period2.startMs != -9223372036854775807L) {
                        long jLongValue = ((Long) period.second).longValue();
                        long j5 = jLongValue == -9223372036854775807L ? -9223372036854775807L : period2.startMs + jLongValue;
                        arrayList.add(period2);
                        j3 = j5;
                    } else {
                        if (!zEquals) {
                            throw new ParserException("Unable to determine start of period " + arrayList.size());
                        }
                        z2 = true;
                    }
                } else {
                    j = j3;
                    j2 = duration3;
                    maybeSkipTag(xpp);
                }
                j3 = j;
            }
            if (XmlPullParserUtil.isEndTag(xpp, "MPD")) {
                if (duration == -9223372036854775807L) {
                    if (j3 != -9223372036854775807L) {
                        duration = j3;
                    } else if (!zEquals) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new ParserException("No periods found.");
                }
                return buildMediaPresentationDescription(dateTime, duration, duration2, zEquals, j2, j4, duration5, dateTime2, programInformation, utcTiming, uri, arrayList);
            }
            dashManifestParser = this;
            duration4 = j4;
            duration3 = j2;
        }
    }

    protected DashManifest buildMediaPresentationDescription(long availabilityStartTime, long durationMs, long minBufferTimeMs, boolean dynamic, long minUpdateTimeMs, long timeShiftBufferDepthMs, long suggestedPresentationDelayMs, long publishTimeMs, ProgramInformation programInformation, UtcTimingElement utcTiming, Uri location, List<Period> periods) {
        return new DashManifest(availabilityStartTime, durationMs, minBufferTimeMs, dynamic, minUpdateTimeMs, timeShiftBufferDepthMs, suggestedPresentationDelayMs, publishTimeMs, programInformation, utcTiming, location, periods);
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xpp) {
        return buildUtcTimingElement(xpp.getAttributeValue(null, "schemeIdUri"), xpp.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    protected UtcTimingElement buildUtcTimingElement(String schemeIdUri, String value) {
        return new UtcTimingElement(schemeIdUri, value);
    }

    protected Pair<Period, Long> parsePeriod(XmlPullParser xpp, String baseUrl, long defaultStartMs) throws XmlPullParserException, IOException, NumberFormatException {
        String str;
        String attributeValue = xpp.getAttributeValue(null, "id");
        long duration = parseDuration(xpp, "start", defaultStartMs);
        long duration2 = parseDuration(xpp, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String baseUrl2 = baseUrl;
        boolean z = false;
        SegmentBase segmentTemplate = null;
        Descriptor descriptor = null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    str = baseUrl2;
                } else {
                    baseUrl2 = parseBaseUrl(xpp, baseUrl2);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "AdaptationSet")) {
                str = baseUrl2;
                arrayList.add(parseAdaptationSet(xpp, baseUrl2, segmentTemplate, duration2));
            } else {
                str = baseUrl2;
                if (XmlPullParserUtil.isStartTag(xpp, "EventStream")) {
                    arrayList2.add(parseEventStream(xpp));
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentBase")) {
                    segmentTemplate = parseSegmentBase(xpp, null);
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentList")) {
                    segmentTemplate = parseSegmentList(xpp, null, duration2);
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTemplate")) {
                    segmentTemplate = parseSegmentTemplate(xpp, null, Collections.emptyList(), duration2);
                } else if (XmlPullParserUtil.isStartTag(xpp, "AssetIdentifier")) {
                    descriptor = parseDescriptor(xpp, "AssetIdentifier");
                } else {
                    maybeSkipTag(xpp);
                }
            }
            baseUrl2 = str;
        } while (!XmlPullParserUtil.isEndTag(xpp, "Period"));
        return Pair.create(buildPeriod(attributeValue, duration, arrayList, arrayList2, descriptor), Long.valueOf(duration2));
    }

    protected Period buildPeriod(String id, long startMs, List<AdaptationSet> adaptationSets, List<EventStream> eventStreams, Descriptor assetIdentifier) {
        return new Period(id, startMs, adaptationSets, eventStreams, assetIdentifier);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    protected AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase, long j) throws XmlPullParserException, NumberFormatException, IOException {
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList<Descriptor> arrayList5;
        ArrayList<DrmInitData.SchemeData> arrayList6;
        String str4;
        String str5;
        int iCheckContentTypeConsistency;
        ArrayList arrayList7;
        XmlPullParser xmlPullParser2;
        DashManifestParser dashManifestParser;
        ArrayList<Descriptor> arrayList8;
        SegmentBase segmentTemplate;
        DashManifestParser dashManifestParser2 = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        int i = parseInt(xmlPullParser3, "id", -1);
        int contentType = parseContentType(xmlPullParser);
        String str6 = null;
        String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int i2 = parseInt(xmlPullParser3, "width", -1);
        int i3 = parseInt(xmlPullParser3, "height", -1);
        float frameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int i4 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        String str7 = "lang";
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser3.getAttributeValue(null, "label");
        ArrayList arrayList9 = new ArrayList();
        ArrayList<Descriptor> arrayList10 = new ArrayList<>();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        String baseUrl = str;
        SegmentBase segmentBase2 = segmentBase;
        int audioChannelConfiguration = -1;
        String label = attributeValue4;
        String str8 = null;
        boolean z = false;
        int i5 = contentType;
        ?? r11 = arrayList9;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z) {
                    z = true;
                    baseUrl = dashManifestParser2.parseBaseUrl(xmlPullParser3, baseUrl);
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = r11;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = i5;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                }
                str2 = attributeValue3;
                str3 = baseUrl;
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = r11;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                dashManifestParser = dashManifestParser2;
                iCheckContentTypeConsistency = i5;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
                attributeValue3 = str2;
                baseUrl = str3;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                    Object obj = contentProtection.first;
                    if (obj != null) {
                        str8 = (String) obj;
                    }
                    Object obj2 = contentProtection.second;
                    if (obj2 != null) {
                        r11.add(obj2);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                    attributeValue3 = checkLanguageConsistency(attributeValue3, xmlPullParser3.getAttributeValue(str6, str7));
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = r11;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = checkContentTypeConsistency(i5, parseContentType(xmlPullParser));
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                        arrayList12.add(parseDescriptor(xmlPullParser3, "Role"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                        audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                        arrayList11.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "EssentialProperty")) {
                        arrayList13.add(parseDescriptor(xmlPullParser3, "EssentialProperty"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                        arrayList14.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                    } else {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                            str2 = attributeValue3;
                            str3 = baseUrl;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = r11;
                            str4 = str7;
                            str5 = str6;
                            RepresentationInfo representation = parseRepresentation(xmlPullParser, baseUrl, attributeValue, attributeValue2, i2, i3, frameRate, audioChannelConfiguration, i4, str2, arrayList3, arrayList4, arrayList2, arrayList, segmentBase2, j);
                            int iCheckContentTypeConsistency2 = checkContentTypeConsistency(i5, MimeTypes.getTrackType(representation.format.sampleMimeType));
                            arrayList7 = arrayList15;
                            arrayList7.add(representation);
                            dashManifestParser = this;
                            xmlPullParser2 = xmlPullParser;
                            iCheckContentTypeConsistency = iCheckContentTypeConsistency2;
                        } else {
                            str2 = attributeValue3;
                            str3 = baseUrl;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = r11;
                            str4 = str7;
                            str5 = str6;
                            iCheckContentTypeConsistency = i5;
                            arrayList7 = arrayList15;
                            xmlPullParser2 = xmlPullParser;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                                dashManifestParser = this;
                                segmentTemplate = dashManifestParser.parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) segmentBase2);
                            } else {
                                dashManifestParser = this;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                                    segmentTemplate = dashManifestParser.parseSegmentList(xmlPullParser2, (SegmentBase.SegmentList) segmentBase2, j);
                                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                    segmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase2, arrayList, j);
                                } else {
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                        arrayList8 = arrayList5;
                                        arrayList8.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                                    } else {
                                        arrayList8 = arrayList5;
                                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Label")) {
                                            label = parseLabel(xmlPullParser);
                                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                            parseAdaptationSetChild(xmlPullParser);
                                        }
                                    }
                                    attributeValue3 = str2;
                                    baseUrl = str3;
                                }
                            }
                            segmentBase2 = segmentTemplate;
                        }
                        attributeValue3 = str2;
                        baseUrl = str3;
                        arrayList8 = arrayList5;
                    }
                    str2 = attributeValue3;
                    str3 = baseUrl;
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = r11;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = i5;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                    attributeValue3 = str2;
                    baseUrl = str3;
                }
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = r11;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                dashManifestParser = dashManifestParser2;
                iCheckContentTypeConsistency = i5;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            i5 = iCheckContentTypeConsistency;
            arrayList15 = arrayList7;
            xmlPullParser3 = xmlPullParser2;
            dashManifestParser2 = dashManifestParser;
            arrayList10 = arrayList8;
            arrayList14 = arrayList;
            arrayList13 = arrayList2;
            arrayList12 = arrayList3;
            arrayList11 = arrayList4;
            r11 = arrayList6;
            str7 = str4;
            str6 = str5;
        }
        ArrayList arrayList16 = new ArrayList(arrayList7.size());
        for (int i6 = 0; i6 < arrayList7.size(); i6++) {
            arrayList16.add(buildRepresentation((RepresentationInfo) arrayList7.get(i6), label, str8, arrayList6, arrayList8));
        }
        return buildAdaptationSet(i, iCheckContentTypeConsistency, arrayList16, arrayList4, arrayList2, arrayList);
    }

    protected AdaptationSet buildAdaptationSet(int id, int contentType, List<Representation> representations, List<Descriptor> accessibilityDescriptors, List<Descriptor> essentialProperties, List<Descriptor> supplementalProperties) {
        return new AdaptationSet(id, contentType, representations, accessibilityDescriptors, essentialProperties, supplementalProperties);
    }

    protected int parseContentType(XmlPullParser xpp) {
        String attributeValue = xpp.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(attributeValue)) {
            return 1;
        }
        if (MediaStreamTrack.VIDEO_TRACK_KIND.equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected void parseAdaptationSetChild(XmlPullParser xpp) throws XmlPullParserException, IOException {
        maybeSkipTag(xpp);
    }

    protected RepresentationInfo parseRepresentation(XmlPullParser xpp, String baseUrl, String adaptationSetMimeType, String adaptationSetCodecs, int adaptationSetWidth, int adaptationSetHeight, float adaptationSetFrameRate, int adaptationSetAudioChannels, int adaptationSetAudioSamplingRate, String adaptationSetLanguage, List<Descriptor> adaptationSetRoleDescriptors, List<Descriptor> adaptationSetAccessibilityDescriptors, List<Descriptor> adaptationSetEssentialProperties, List<Descriptor> adaptationSetSupplementalProperties, SegmentBase segmentBase, long periodDurationMs) throws XmlPullParserException, NumberFormatException, IOException {
        int i;
        int i2;
        String str;
        SegmentBase segmentTemplate;
        int audioChannelConfiguration;
        String str2;
        String attributeValue = xpp.getAttributeValue(null, "id");
        int i3 = parseInt(xpp, "bandwidth", -1);
        String string = parseString(xpp, "mimeType", adaptationSetMimeType);
        String string2 = parseString(xpp, "codecs", adaptationSetCodecs);
        int i4 = parseInt(xpp, "width", adaptationSetWidth);
        int i5 = parseInt(xpp, "height", adaptationSetHeight);
        float frameRate = parseFrameRate(xpp, adaptationSetFrameRate);
        int i6 = parseInt(xpp, "audioSamplingRate", adaptationSetAudioSamplingRate);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(adaptationSetEssentialProperties);
        ArrayList arrayList4 = new ArrayList(adaptationSetSupplementalProperties);
        SegmentBase segmentBase2 = segmentBase;
        String str3 = null;
        boolean z = false;
        String baseUrl2 = baseUrl;
        int i7 = adaptationSetAudioChannels;
        while (true) {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    str = baseUrl2;
                    i = i6;
                    i2 = i3;
                    audioChannelConfiguration = i7;
                    str2 = str;
                } else {
                    baseUrl2 = parseBaseUrl(xpp, baseUrl2);
                    i = i6;
                    i2 = i3;
                    z = true;
                    audioChannelConfiguration = i7;
                    str2 = baseUrl2;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "AudioChannelConfiguration")) {
                audioChannelConfiguration = parseAudioChannelConfiguration(xpp);
                str2 = baseUrl2;
                i = i6;
                i2 = i3;
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentBase")) {
                i = i6;
                i2 = i3;
                segmentBase2 = parseSegmentBase(xpp, (SegmentBase.SingleSegmentBase) segmentBase2);
                audioChannelConfiguration = i7;
                str2 = baseUrl2;
            } else {
                if (XmlPullParserUtil.isStartTag(xpp, "SegmentList")) {
                    i = i6;
                    i2 = i3;
                    segmentTemplate = parseSegmentList(xpp, (SegmentBase.SegmentList) segmentBase2, periodDurationMs);
                } else {
                    i = i6;
                    i2 = i3;
                    if (XmlPullParserUtil.isStartTag(xpp, "SegmentTemplate")) {
                        segmentTemplate = parseSegmentTemplate(xpp, (SegmentBase.SegmentTemplate) segmentBase2, adaptationSetSupplementalProperties, periodDurationMs);
                    } else {
                        if (XmlPullParserUtil.isStartTag(xpp, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xpp);
                            str = baseUrl2;
                            Object obj = contentProtection.first;
                            if (obj != null) {
                                str3 = (String) obj;
                            }
                            Object obj2 = contentProtection.second;
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                        } else {
                            str = baseUrl2;
                            if (XmlPullParserUtil.isStartTag(xpp, "InbandEventStream")) {
                                arrayList2.add(parseDescriptor(xpp, "InbandEventStream"));
                            } else if (XmlPullParserUtil.isStartTag(xpp, "EssentialProperty")) {
                                arrayList3.add(parseDescriptor(xpp, "EssentialProperty"));
                            } else if (XmlPullParserUtil.isStartTag(xpp, "SupplementalProperty")) {
                                arrayList4.add(parseDescriptor(xpp, "SupplementalProperty"));
                            } else {
                                maybeSkipTag(xpp);
                            }
                        }
                        audioChannelConfiguration = i7;
                        str2 = str;
                    }
                }
                segmentBase2 = segmentTemplate;
                audioChannelConfiguration = i7;
                str2 = baseUrl2;
            }
            if (XmlPullParserUtil.isEndTag(xpp, "Representation")) {
                break;
            }
            i6 = i;
            baseUrl2 = str2;
            i3 = i2;
            i7 = audioChannelConfiguration;
        }
        Format formatBuildFormat = buildFormat(attributeValue, string, i4, i5, frameRate, audioChannelConfiguration, i, i2, adaptationSetLanguage, adaptationSetRoleDescriptors, adaptationSetAccessibilityDescriptors, string2, arrayList3, arrayList4);
        if (segmentBase2 == null) {
            segmentBase2 = new SegmentBase.SingleSegmentBase();
        }
        return new RepresentationInfo(formatBuildFormat, str2, segmentBase2, str3, arrayList, arrayList2, -1L);
    }

    protected Format buildFormat(String id, String containerMimeType, int width, int height, float frameRate, int audioChannels, int audioSamplingRate, int bitrate, String language, List<Descriptor> roleDescriptors, List<Descriptor> accessibilityDescriptors, String codecs, List<Descriptor> essentialProperties, List<Descriptor> supplementalProperties) {
        int cea708AccessibilityChannel;
        String sampleMimeType = getSampleMimeType(containerMimeType, codecs);
        if ("audio/eac3".equals(sampleMimeType)) {
            sampleMimeType = parseEac3SupplementalProperties(supplementalProperties);
        }
        Format.Builder language2 = new Format.Builder().setId(id).setContainerMimeType(containerMimeType).setSampleMimeType(sampleMimeType).setCodecs(codecs).setPeakBitrate(bitrate).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors(roleDescriptors)).setRoleFlags(parseRoleFlagsFromRoleDescriptors(roleDescriptors) | parseRoleFlagsFromAccessibilityDescriptors(accessibilityDescriptors) | parseRoleFlagsFromProperties(essentialProperties) | parseRoleFlagsFromProperties(supplementalProperties)).setLanguage(language);
        if (MimeTypes.isVideo(sampleMimeType)) {
            language2.setWidth(width).setHeight(height).setFrameRate(frameRate);
        } else if (MimeTypes.isAudio(sampleMimeType)) {
            language2.setChannelCount(audioChannels).setSampleRate(audioSamplingRate);
        } else if (MimeTypes.isText(sampleMimeType)) {
            if ("application/cea-608".equals(sampleMimeType)) {
                cea708AccessibilityChannel = parseCea608AccessibilityChannel(accessibilityDescriptors);
            } else {
                cea708AccessibilityChannel = "application/cea-708".equals(sampleMimeType) ? parseCea708AccessibilityChannel(accessibilityDescriptors) : -1;
            }
            language2.setAccessibilityChannel(cea708AccessibilityChannel);
        }
        return language2.build();
    }

    protected Representation buildRepresentation(RepresentationInfo representationInfo, String label, String extraDrmSchemeType, ArrayList<DrmInitData.SchemeData> extraDrmSchemeDatas, ArrayList<Descriptor> extraInbandEventStreams) {
        Format.Builder builderBuildUpon = representationInfo.format.buildUpon();
        if (label != null) {
            builderBuildUpon.setLabel(label);
        }
        String str = representationInfo.drmSchemeType;
        if (str != null) {
            extraDrmSchemeType = str;
        }
        ArrayList<DrmInitData.SchemeData> arrayList = representationInfo.drmSchemeDatas;
        arrayList.addAll(extraDrmSchemeDatas);
        if (!arrayList.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList);
            builderBuildUpon.setDrmInitData(new DrmInitData(extraDrmSchemeType, arrayList));
        }
        ArrayList<Descriptor> arrayList2 = representationInfo.inbandEventStreams;
        arrayList2.addAll(extraInbandEventStreams);
        return Representation.newInstance(representationInfo.revisionId, builderBuildUpon.build(), representationInfo.baseUrl, representationInfo.segmentBase, arrayList2);
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xpp, SegmentBase.SingleSegmentBase parent) throws XmlPullParserException, NumberFormatException, IOException {
        long j;
        long j2;
        long j3 = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j4 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j5 = parent != null ? parent.indexStart : 0L;
        long j6 = parent != null ? parent.indexLength : 0L;
        String attributeValue = xpp.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j2 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j2) + 1;
        } else {
            j = j6;
            j2 = j5;
        }
        RangedUri initialization = parent != null ? parent.initialization : null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j3, j4, j2, j);
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri initialization, long timescale, long presentationTimeOffset, long indexStart, long indexLength) {
        return new SegmentBase.SingleSegmentBase(initialization, timescale, presentationTimeOffset, indexStart, indexLength);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xpp, SegmentBase.SegmentList parent, long periodDurationMs) throws XmlPullParserException, IOException {
        long j = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j2 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j3 = parseLong(xpp, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, parent != null ? parent.duration : -9223372036854775807L);
        long j4 = parseLong(xpp, "startNumber", parent != null ? parent.startNumber : 1L);
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        List<RangedUri> arrayList = null;
        RangedUri initialization = null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xpp, j, periodDurationMs);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xpp));
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentList"));
        if (parent != null) {
            if (initialization == null) {
                initialization = parent.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = parent.segmentTimeline;
            }
            if (arrayList == null) {
                arrayList = parent.mediaSegments;
            }
        }
        return buildSegmentList(initialization, j, j2, j4, j3, segmentTimeline, arrayList);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long duration, List<SegmentBase.SegmentTimelineElement> timeline, List<RangedUri> segments) {
        return new SegmentBase.SegmentList(initialization, timescale, presentationTimeOffset, startNumber, duration, timeline, segments);
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xpp, SegmentBase.SegmentTemplate parent, List<Descriptor> adaptationSetSupplementalProperties, long periodDurationMs) throws XmlPullParserException, IOException {
        long j = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j2 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j3 = parseLong(xpp, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, parent != null ? parent.duration : -9223372036854775807L);
        long j4 = parseLong(xpp, "startNumber", parent != null ? parent.startNumber : 1L);
        long lastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(adaptationSetSupplementalProperties);
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        UrlTemplate urlTemplate = parseUrlTemplate(xpp, "media", parent != null ? parent.mediaTemplate : null);
        UrlTemplate urlTemplate2 = parseUrlTemplate(xpp, "initialization", parent != null ? parent.initializationTemplate : null);
        RangedUri initialization = null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xpp, j, periodDurationMs);
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentTemplate"));
        if (parent != null) {
            if (initialization == null) {
                initialization = parent.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = parent.segmentTimeline;
            }
        }
        return buildSegmentTemplate(initialization, j, j2, j4, lastSegmentNumberSupplementalProperty, j3, segmentTimeline, urlTemplate2, urlTemplate);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long endNumber, long duration, List<SegmentBase.SegmentTimelineElement> timeline, UrlTemplate initializationTemplate, UrlTemplate mediaTemplate) {
        return new SegmentBase.SegmentTemplate(initialization, timescale, presentationTimeOffset, startNumber, endNumber, duration, timeline, initializationTemplate, mediaTemplate);
    }

    protected EventStream parseEventStream(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", "");
        String string2 = parseString(xpp, AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        long j = parseLong(xpp, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Event")) {
                arrayList.add(parseEvent(xpp, string, string2, j, byteArrayOutputStream));
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(string, string2, j, jArr, eventMessageArr);
    }

    protected EventStream buildEventStream(String schemeIdUri, String value, long timescale, long[] presentationTimesUs, EventMessage[] events) {
        return new EventStream(schemeIdUri, value, timescale, presentationTimesUs, events);
    }

    protected Pair<Long, EventMessage> parseEvent(XmlPullParser xpp, String schemeIdUri, String value, long timescale, ByteArrayOutputStream scratchOutputStream) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException {
        long j = parseLong(xpp, "id", 0L);
        long j2 = parseLong(xpp, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, -9223372036854775807L);
        long j3 = parseLong(xpp, "presentationTime", 0L);
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000L, timescale);
        long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j3, 1000000L, timescale);
        String string = parseString(xpp, "messageData", null);
        byte[] eventObject = parseEventObject(xpp, scratchOutputStream);
        Long lValueOf = Long.valueOf(jScaleLargeTimestamp2);
        if (string != null) {
            eventObject = Util.getUtf8Bytes(string);
        }
        return Pair.create(lValueOf, buildEvent(schemeIdUri, value, j, jScaleLargeTimestamp, eventObject));
    }

    protected byte[] parseEventObject(XmlPullParser xpp, ByteArrayOutputStream scratchOutputStream) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException {
        scratchOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(scratchOutputStream, "UTF-8");
        xpp.nextToken();
        while (!XmlPullParserUtil.isEndTag(xpp, "Event")) {
            switch (xpp.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xpp.getNamespace(), xpp.getName());
                    for (int i = 0; i < xpp.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xpp.getAttributeNamespace(i), xpp.getAttributeName(i), xpp.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xpp.getNamespace(), xpp.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xpp.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xpp.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xpp.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xpp.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xpp.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xpp.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xpp.getText());
                    break;
            }
            xpp.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return scratchOutputStream.toByteArray();
    }

    protected EventMessage buildEvent(String schemeIdUri, String value, long id, long durationMs, byte[] messageData) {
        return new EventMessage(schemeIdUri, value, durationMs, id, messageData);
    }

    protected List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xpp, long timescale, long periodDurationMs) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jAddSegmentTimelineElementsToList = 0;
        long j = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "S")) {
                long j2 = parseLong(xpp, "t", -9223372036854775807L);
                if (z) {
                    jAddSegmentTimelineElementsToList = addSegmentTimelineElementsToList(arrayList, jAddSegmentTimelineElementsToList, j, i, j2);
                }
                if (j2 == -9223372036854775807L) {
                    j2 = jAddSegmentTimelineElementsToList;
                }
                j = parseLong(xpp, "d", -9223372036854775807L);
                i = parseInt(xpp, "r", 0);
                z = true;
                jAddSegmentTimelineElementsToList = j2;
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentTimeline"));
        if (z) {
            addSegmentTimelineElementsToList(arrayList, jAddSegmentTimelineElementsToList, j, i, Util.scaleLargeTimestamp(periodDurationMs, timescale, 1000L));
        }
        return arrayList;
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> segmentTimeline, long startTime, long elementDuration, int elementRepeatCount, long endTime) {
        int iCeilDivide = elementRepeatCount >= 0 ? elementRepeatCount + 1 : (int) Util.ceilDivide(endTime - startTime, elementDuration);
        for (int i = 0; i < iCeilDivide; i++) {
            segmentTimeline.add(buildSegmentTimelineElement(startTime, elementDuration));
            startTime += elementDuration;
        }
        return startTime;
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long startTime, long duration) {
        return new SegmentBase.SegmentTimelineElement(startTime, duration);
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xpp, String name, UrlTemplate defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : defaultValue;
    }

    protected RangedUri parseInitialization(XmlPullParser xpp) {
        return parseRangedUrl(xpp, "sourceURL", "range");
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xpp) {
        return parseRangedUrl(xpp, "media", "mediaRange");
    }

    protected RangedUri parseRangedUrl(XmlPullParser xpp, String urlAttribute, String rangeAttribute) throws NumberFormatException {
        long j;
        long j2;
        String attributeValue = xpp.getAttributeValue(null, urlAttribute);
        String attributeValue2 = xpp.getAttributeValue(null, rangeAttribute);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return buildRangedUri(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    protected RangedUri buildRangedUri(String urlText, long rangeStart, long rangeLength) {
        return new RangedUri(urlText, rangeStart, rangeLength);
    }

    protected ProgramInformation parseProgramInformation(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String strNextText = null;
        String string = parseString(xpp, "moreInformationURL", null);
        String string2 = parseString(xpp, "lang", null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Title")) {
                strNextText = xpp.nextText();
            } else if (XmlPullParserUtil.isStartTag(xpp, "Source")) {
                strNextText2 = xpp.nextText();
            } else if (XmlPullParserUtil.isStartTag(xpp, "Copyright")) {
                strNextText3 = xpp.nextText();
            } else {
                maybeSkipTag(xpp);
            }
            String str = strNextText3;
            if (XmlPullParserUtil.isEndTag(xpp, "ProgramInformation")) {
                return new ProgramInformation(strNextText, strNextText2, str, string, string2);
            }
            strNextText3 = str;
        }
    }

    protected String parseLabel(XmlPullParser xpp) throws XmlPullParserException, IOException {
        return parseText(xpp, "Label");
    }

    protected String parseBaseUrl(XmlPullParser xpp, String parentBaseUrl) throws XmlPullParserException, IOException {
        return UriUtil.resolve(parentBaseUrl, parseText(xpp, "BaseURL"));
    }

    protected int parseAudioChannelConfiguration(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", null);
        int dolbyChannelConfiguration = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseInt(xpp, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(string) || "urn:dolby:dash:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseDolbyChannelConfiguration(xpp);
        }
        do {
            xpp.next();
        } while (!XmlPullParserUtil.isEndTag(xpp, "AudioChannelConfiguration"));
        return dolbyChannelConfiguration;
    }

    protected int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> roleDescriptors) {
        for (int i = 0; i < roleDescriptors.size(); i++) {
            Descriptor descriptor = roleDescriptors.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri) && "main".equals(descriptor.value)) {
                return 1;
            }
        }
        return 0;
    }

    protected int parseRoleFlagsFromRoleDescriptors(List<Descriptor> roleDescriptors) {
        int dashRoleSchemeValue = 0;
        for (int i = 0; i < roleDescriptors.size(); i++) {
            Descriptor descriptor = roleDescriptors.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                dashRoleSchemeValue |= parseDashRoleSchemeValue(descriptor.value);
            }
        }
        return dashRoleSchemeValue;
    }

    protected int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> accessibilityDescriptors) {
        int tvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < accessibilityDescriptors.size(); i2++) {
            Descriptor descriptor = accessibilityDescriptors.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                tvaAudioPurposeCsValue = parseDashRoleSchemeValue(descriptor.value);
            } else if ("urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(descriptor.schemeIdUri)) {
                tvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= tvaAudioPurposeCsValue;
        }
        return i;
    }

    protected int parseRoleFlagsFromProperties(List<Descriptor> accessibilityDescriptors) {
        int i = 0;
        for (int i2 = 0; i2 < accessibilityDescriptors.size(); i2++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(accessibilityDescriptors.get(i2).schemeIdUri)) {
                i = 16384;
            }
        }
        return i;
    }

    protected int parseDashRoleSchemeValue(String value) {
        if (value == null) {
            return 0;
        }
        switch (value) {
        }
        return 0;
    }

    protected int parseTvaAudioPurposeCsValue(String value) {
        if (value == null) {
            return 0;
        }
        switch (value) {
        }
        return 0;
    }

    public static void maybeSkipTag(XmlPullParser xpp) throws XmlPullParserException, IOException {
        if (XmlPullParserUtil.isStartTag(xpp)) {
            int i = 1;
            while (i != 0) {
                xpp.next();
                if (XmlPullParserUtil.isStartTag(xpp)) {
                    i++;
                } else if (XmlPullParserUtil.isEndTag(xpp)) {
                    i--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> schemeDatas) {
        for (int size = schemeDatas.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = schemeDatas.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= schemeDatas.size()) {
                        break;
                    }
                    if (schemeDatas.get(i).canReplace(schemeData)) {
                        schemeDatas.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    private static String getSampleMimeType(String containerMimeType, String codecs) {
        if (MimeTypes.isAudio(containerMimeType)) {
            return MimeTypes.getAudioMediaMimeType(codecs);
        }
        if (MimeTypes.isVideo(containerMimeType)) {
            return MimeTypes.getVideoMediaMimeType(codecs);
        }
        if (MimeTypes.isText(containerMimeType)) {
            return "application/x-rawcc".equals(containerMimeType) ? MimeTypes.getTextMediaMimeType(codecs) : containerMimeType;
        }
        if ("application/mp4".equals(containerMimeType)) {
            return MimeTypes.getMediaMimeType(codecs);
        }
        return null;
    }

    private static String checkLanguageConsistency(String firstLanguage, String secondLanguage) {
        if (firstLanguage == null) {
            return secondLanguage;
        }
        if (secondLanguage == null) {
            return firstLanguage;
        }
        Assertions.checkState(firstLanguage.equals(secondLanguage));
        return firstLanguage;
    }

    private static int checkContentTypeConsistency(int firstType, int secondType) {
        if (firstType == -1) {
            return secondType;
        }
        if (secondType == -1) {
            return firstType;
        }
        Assertions.checkState(firstType == secondType);
        return firstType;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xpp, String tag) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", "");
        String string2 = parseString(xpp, AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
        String string3 = parseString(xpp, "id", null);
        do {
            xpp.next();
        } while (!XmlPullParserUtil.isEndTag(xpp, tag));
        return new Descriptor(string, string2, string3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> accessibilityDescriptors) {
        String str;
        for (int i = 0; i < accessibilityDescriptors.size(); i++) {
            Descriptor descriptor = accessibilityDescriptors.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> accessibilityDescriptors) {
        String str;
        for (int i = 0; i < accessibilityDescriptors.size(); i++) {
            Descriptor descriptor = accessibilityDescriptors.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> supplementalProperties) {
        for (int i = 0; i < supplementalProperties.size(); i++) {
            Descriptor descriptor = supplementalProperties.get(i);
            String str = descriptor.schemeIdUri;
            if (!"tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) || !"JOC".equals(descriptor.value)) {
                if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                    return "audio/eac3-joc";
                }
            } else {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float parseFrameRate(XmlPullParser xpp, float defaultValue) throws NumberFormatException {
        String attributeValue = xpp.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return defaultValue;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return defaultValue;
        }
        int i = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
    }

    protected static long parseDuration(XmlPullParser xpp, String name, long defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xpp, String name, long defaultValue) throws ParserException {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Util.parseXsDateTime(attributeValue);
    }

    protected static String parseText(XmlPullParser xpp, String label) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xpp.next();
            if (xpp.getEventType() == 4) {
                text = xpp.getText();
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, label));
        return text;
    }

    protected static int parseInt(XmlPullParser xpp, String name, int defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xpp, String name, long defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xpp, String name, String defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : attributeValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = "value"
            java.lang.String r4 = r4.getAttributeValue(r2, r3)
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r4)
            r2 = -1
            if (r4 != 0) goto L11
            return r2
        L11:
            int r3 = r4.hashCode()
            switch(r3) {
                case 1596796: goto L3b;
                case 2937391: goto L30;
                case 3094035: goto L25;
                case 3133436: goto L1a;
                default: goto L18;
            }
        L18:
            r4 = r2
            goto L45
        L1a:
            java.lang.String r3 = "fa01"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L23
            goto L18
        L23:
            r4 = 3
            goto L45
        L25:
            java.lang.String r3 = "f801"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L2e
            goto L18
        L2e:
            r4 = r0
            goto L45
        L30:
            java.lang.String r3 = "a000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L39
            goto L18
        L39:
            r4 = r1
            goto L45
        L3b:
            java.lang.String r3 = "4000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L44
            goto L18
        L44:
            r4 = 0
        L45:
            switch(r4) {
                case 0: goto L4f;
                case 1: goto L4e;
                case 2: goto L4c;
                case 3: goto L49;
                default: goto L48;
            }
        L48:
            return r2
        L49:
            r4 = 8
            return r4
        L4c:
            r4 = 6
            return r4
        L4e:
            return r0
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> supplementalProperties) {
        for (int i = 0; i < supplementalProperties.size(); i++) {
            Descriptor descriptor = supplementalProperties.get(i);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1L;
    }

    protected static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, String baseUrl, SegmentBase segmentBase, String drmSchemeType, ArrayList<DrmInitData.SchemeData> drmSchemeDatas, ArrayList<Descriptor> inbandEventStreams, long revisionId) {
            this.format = format;
            this.baseUrl = baseUrl;
            this.segmentBase = segmentBase;
            this.drmSchemeType = drmSchemeType;
            this.drmSchemeDatas = drmSchemeDatas;
            this.inbandEventStreams = inbandEventStreams;
            this.revisionId = revisionId;
        }
    }
}
