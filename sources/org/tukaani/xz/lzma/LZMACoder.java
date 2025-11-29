package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import org.tukaani.xz.rangecoder.RangeCoder;

/* loaded from: classes4.dex */
abstract class LZMACoder {
    final short[] distAlign;
    final short[][] distSlots;
    final short[][] distSpecial;
    final short[][] isMatch;
    final short[] isRep;
    final short[] isRep0;
    final short[][] isRep0Long;
    final short[] isRep1;
    final short[] isRep2;
    final int posMask;
    final int[] reps = new int[4];
    final State state = new State();

    abstract class LengthCoder {
        final short[] choice = new short[2];
        final short[] high;
        final short[][] low;
        final short[][] mid;

        LengthCoder() {
            Class cls = Short.TYPE;
            this.low = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.mid = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.high = new short[256];
        }

        void reset() {
            RangeCoder.initProbs(this.choice);
            int i = 0;
            while (true) {
                short[][] sArr = this.low;
                if (i >= sArr.length) {
                    break;
                }
                RangeCoder.initProbs(sArr[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.low.length; i2++) {
                RangeCoder.initProbs(this.mid[i2]);
            }
            RangeCoder.initProbs(this.high);
        }
    }

    abstract class LiteralCoder {
        private final int lc;
        private final int literalPosMask;

        abstract class LiteralSubcoder {
            final short[] probs = new short[768];

            LiteralSubcoder() {
            }

            void reset() {
                RangeCoder.initProbs(this.probs);
            }
        }

        LiteralCoder(int i, int i2) {
            this.lc = i;
            this.literalPosMask = (1 << i2) - 1;
        }

        final int getSubcoderIndex(int i, int i2) {
            int i3 = this.lc;
            return (i >> (8 - i3)) + ((i2 & this.literalPosMask) << i3);
        }
    }

    LZMACoder(int i) {
        Class cls = Short.TYPE;
        this.isMatch = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.isRep = new short[12];
        this.isRep0 = new short[12];
        this.isRep1 = new short[12];
        this.isRep2 = new short[12];
        this.isRep0Long = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.distSlots = (short[][]) Array.newInstance((Class<?>) cls, 4, 64);
        this.distSpecial = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.distAlign = new short[16];
        this.posMask = (1 << i) - 1;
    }

    static final int getDistState(int i) {
        if (i < 6) {
            return i - 2;
        }
        return 3;
    }

    void reset() {
        int[] iArr = this.reps;
        int i = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.state.reset();
        int i2 = 0;
        while (true) {
            short[][] sArr = this.isMatch;
            if (i2 >= sArr.length) {
                break;
            }
            RangeCoder.initProbs(sArr[i2]);
            i2++;
        }
        RangeCoder.initProbs(this.isRep);
        RangeCoder.initProbs(this.isRep0);
        RangeCoder.initProbs(this.isRep1);
        RangeCoder.initProbs(this.isRep2);
        int i3 = 0;
        while (true) {
            short[][] sArr2 = this.isRep0Long;
            if (i3 >= sArr2.length) {
                break;
            }
            RangeCoder.initProbs(sArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[][] sArr3 = this.distSlots;
            if (i4 >= sArr3.length) {
                break;
            }
            RangeCoder.initProbs(sArr3[i4]);
            i4++;
        }
        while (true) {
            short[][] sArr4 = this.distSpecial;
            if (i >= sArr4.length) {
                RangeCoder.initProbs(this.distAlign);
                return;
            } else {
                RangeCoder.initProbs(sArr4[i]);
                i++;
            }
        }
    }
}
