package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface EbmlProcessor {
    void binaryElement(int id, int contentsSize, ExtractorInput input) throws IOException;

    void endMasterElement(int id) throws ParserException;

    void floatElement(int id, double value) throws ParserException;

    int getElementType(int id);

    void integerElement(int id, long value) throws ParserException;

    boolean isLevel1Element(int id);

    void startMasterElement(int id, long contentPosition, long contentSize) throws ParserException;

    void stringElement(int id, String value) throws ParserException;
}
