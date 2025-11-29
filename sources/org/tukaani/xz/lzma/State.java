package org.tukaani.xz.lzma;

/* loaded from: classes4.dex */
final class State {
    private int state;

    State() {
    }

    int get() {
        return this.state;
    }

    boolean isLiteral() {
        return this.state < 7;
    }

    void reset() {
        this.state = 0;
    }

    void updateLiteral() {
        int i = this.state;
        this.state = i <= 3 ? 0 : i <= 9 ? i - 3 : i - 6;
    }

    void updateLongRep() {
        this.state = this.state < 7 ? 8 : 11;
    }

    void updateMatch() {
        this.state = this.state >= 7 ? 10 : 7;
    }

    void updateShortRep() {
        this.state = this.state < 7 ? 9 : 11;
    }
}
