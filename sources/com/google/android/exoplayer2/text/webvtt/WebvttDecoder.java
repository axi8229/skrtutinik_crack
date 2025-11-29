package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private final CssParser cssParser;
    private final ParsableByteArray parsableWebvttData;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.parsableWebvttData = new ParsableByteArray();
        this.cssParser = new CssParser();
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bytes, int length, boolean reset) throws SubtitleDecoderException {
        WebvttCueInfo cue;
        this.parsableWebvttData.reset(bytes, length);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
            while (!TextUtils.isEmpty(this.parsableWebvttData.readLine())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int nextEvent = getNextEvent(this.parsableWebvttData);
                if (nextEvent == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (nextEvent == 1) {
                    skipComment(this.parsableWebvttData);
                } else if (nextEvent == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.parsableWebvttData.readLine();
                    arrayList.addAll(this.cssParser.parseBlock(this.parsableWebvttData));
                } else if (nextEvent == 3 && (cue = WebvttCueParser.parseCue(this.parsableWebvttData, arrayList)) != null) {
                    arrayList2.add(cue);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }

    private static int getNextEvent(ParsableByteArray parsableWebvttData) {
        int i = -1;
        int position = 0;
        while (i == -1) {
            position = parsableWebvttData.getPosition();
            String line = parsableWebvttData.readLine();
            if (line == null) {
                i = 0;
            } else if ("STYLE".equals(line)) {
                i = 2;
            } else {
                i = line.startsWith("NOTE") ? 1 : 3;
            }
        }
        parsableWebvttData.setPosition(position);
        return i;
    }

    private static void skipComment(ParsableByteArray parsableWebvttData) {
        while (!TextUtils.isEmpty(parsableWebvttData.readLine())) {
        }
    }
}
