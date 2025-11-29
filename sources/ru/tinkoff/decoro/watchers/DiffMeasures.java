package ru.tinkoff.decoro.watchers;

import java.util.Locale;

/* loaded from: classes4.dex */
class DiffMeasures {
    private int cursorPosition;
    private int diffInsertLength;
    private int diffRemoveLength;
    private int diffStartPosition;
    private int diffType;
    private boolean trimmingSequence;

    public void calculateBeforeTextChanged(int i, int i2, int i3) {
        int i4;
        this.diffStartPosition = i;
        boolean z = false;
        this.diffRemoveLength = 0;
        this.diffType = 0;
        this.diffInsertLength = 0;
        this.cursorPosition = -1;
        if (i3 > 0) {
            this.diffType = 1;
            this.diffInsertLength = i3;
        }
        if (i2 > 0) {
            this.diffType |= 2;
            this.diffRemoveLength = i2;
        }
        int i5 = this.diffInsertLength;
        if (i5 > 0 && (i4 = this.diffRemoveLength) > 0 && i5 < i4) {
            z = true;
        }
        this.trimmingSequence = z;
    }

    public void recalculateOnModifyingWord(int i) {
        this.diffRemoveLength -= this.diffInsertLength;
        this.diffStartPosition += i;
        this.diffType &= -2;
    }

    public boolean isInsertingChars() {
        return (this.diffType & 1) == 1;
    }

    public boolean isRemovingChars() {
        return (this.diffType & 2) == 2;
    }

    public int getInsertEndPosition() {
        return this.diffStartPosition + this.diffInsertLength;
    }

    public int getRemoveEndPosition() {
        return (this.diffStartPosition + this.diffRemoveLength) - 1;
    }

    public void setCursorPosition(int i) {
        this.cursorPosition = i;
    }

    public int getStartPosition() {
        return this.diffStartPosition;
    }

    public int getRemoveLength() {
        return this.diffRemoveLength;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public boolean isTrimmingSequence() {
        return this.trimmingSequence;
    }

    public String toString() {
        String str;
        int i = this.diffType;
        if ((i & 3) == 3) {
            str = "both";
        } else if ((i & 1) == 1) {
            str = "insert";
        } else if ((i & 2) == 2) {
            str = "remove";
        } else {
            str = i == 0 ? "none" : null;
        }
        if (str == null) {
            throw new IllegalStateException("unknown behaviour for diffType " + this.diffType);
        }
        return String.format(Locale.getDefault(), "[ DiffMeasures type=%s, diffStartPosition=%d, diffInsertLength=%d, diffRemoveLength=%d, cursor: %d ]", str, Integer.valueOf(this.diffStartPosition), Integer.valueOf(this.diffInsertLength), Integer.valueOf(this.diffRemoveLength), Integer.valueOf(this.cursorPosition));
    }
}
