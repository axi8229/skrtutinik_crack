package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
final class DefaultEbmlReader implements EbmlReader {
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private EbmlProcessor processor;
    private final byte[] scratch = new byte[8];
    private final ArrayDeque<MasterElement> masterElementsStack = new ArrayDeque<>();
    private final VarintReader varintReader = new VarintReader();

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void init(EbmlProcessor processor) {
        this.processor = processor;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(ExtractorInput input) throws IOException {
        Assertions.checkStateNotNull(this.processor);
        while (true) {
            MasterElement masterElementPeek = this.masterElementsStack.peek();
            if (masterElementPeek == null || input.getPosition() < masterElementPeek.elementEndPosition) {
                if (this.elementState == 0) {
                    long unsignedVarint = this.varintReader.readUnsignedVarint(input, true, false, 4);
                    if (unsignedVarint == -2) {
                        unsignedVarint = maybeResyncToNextLevel1Element(input);
                    }
                    if (unsignedVarint == -1) {
                        return false;
                    }
                    this.elementId = (int) unsignedVarint;
                    this.elementState = 1;
                }
                if (this.elementState == 1) {
                    this.elementContentSize = this.varintReader.readUnsignedVarint(input, false, true, 8);
                    this.elementState = 2;
                }
                int elementType = this.processor.getElementType(this.elementId);
                if (elementType != 0) {
                    if (elementType == 1) {
                        long position = input.getPosition();
                        this.masterElementsStack.push(new MasterElement(this.elementId, this.elementContentSize + position));
                        this.processor.startMasterElement(this.elementId, position, this.elementContentSize);
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 2) {
                        long j = this.elementContentSize;
                        if (j > 8) {
                            throw new ParserException("Invalid integer size: " + this.elementContentSize);
                        }
                        this.processor.integerElement(this.elementId, readInteger(input, (int) j));
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 3) {
                        long j2 = this.elementContentSize;
                        if (j2 > 2147483647L) {
                            throw new ParserException("String element size: " + this.elementContentSize);
                        }
                        this.processor.stringElement(this.elementId, readString(input, (int) j2));
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 4) {
                        this.processor.binaryElement(this.elementId, (int) this.elementContentSize, input);
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 5) {
                        long j3 = this.elementContentSize;
                        if (j3 != 4 && j3 != 8) {
                            throw new ParserException("Invalid float size: " + this.elementContentSize);
                        }
                        this.processor.floatElement(this.elementId, readFloat(input, (int) j3));
                        this.elementState = 0;
                        return true;
                    }
                    throw new ParserException("Invalid element type " + elementType);
                }
                input.skipFully((int) this.elementContentSize);
                this.elementState = 0;
            } else {
                this.processor.endMasterElement(this.masterElementsStack.pop().elementId);
                return true;
            }
        }
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput input) throws IOException {
        input.resetPeekPosition();
        while (true) {
            input.peekFully(this.scratch, 0, 4);
            int unsignedVarintLength = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if (unsignedVarintLength != -1 && unsignedVarintLength <= 4) {
                int iAssembleVarint = (int) VarintReader.assembleVarint(this.scratch, unsignedVarintLength, false);
                if (this.processor.isLevel1Element(iAssembleVarint)) {
                    input.skipFully(unsignedVarintLength);
                    return iAssembleVarint;
                }
            }
            input.skipFully(1);
        }
    }

    private long readInteger(ExtractorInput input, int byteLength) throws IOException {
        input.readFully(this.scratch, 0, byteLength);
        long j = 0;
        for (int i = 0; i < byteLength; i++) {
            j = (j << 8) | (this.scratch[i] & 255);
        }
        return j;
    }

    private double readFloat(ExtractorInput input, int byteLength) throws IOException {
        long integer = readInteger(input, byteLength);
        if (byteLength == 4) {
            return Float.intBitsToFloat((int) integer);
        }
        return Double.longBitsToDouble(integer);
    }

    private static String readString(ExtractorInput input, int byteLength) throws IOException {
        if (byteLength == 0) {
            return "";
        }
        byte[] bArr = new byte[byteLength];
        input.readFully(bArr, 0, byteLength);
        while (byteLength > 0 && bArr[byteLength - 1] == 0) {
            byteLength--;
        }
        return new String(bArr, 0, byteLength);
    }

    private static final class MasterElement {
        private final long elementEndPosition;
        private final int elementId;

        private MasterElement(int elementId, long elementEndPosition) {
            this.elementId = elementId;
            this.elementEndPosition = elementEndPosition;
        }
    }
}
