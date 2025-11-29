package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CaretStringIterator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", "Lcom/redmadrobot/inputmask/model/CaretString;", "caretString", "", "currentIndex", "<init>", "(Lcom/redmadrobot/inputmask/model/CaretString;I)V", "", "insertionAffectsCaret", "()Z", "deletionAffectsCaret", "", "next", "()Ljava/lang/Character;", "Lcom/redmadrobot/inputmask/model/CaretString;", "getCaretString", "()Lcom/redmadrobot/inputmask/model/CaretString;", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class CaretStringIterator {
    private final CaretString caretString;
    private int currentIndex;

    public CaretStringIterator(CaretString caretString, int i) {
        Intrinsics.checkNotNullParameter(caretString, "caretString");
        this.caretString = caretString;
        this.currentIndex = i;
    }

    public /* synthetic */ CaretStringIterator(CaretString caretString, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(caretString, (i2 & 2) != 0 ? 0 : i);
    }

    protected final CaretString getCaretString() {
        return this.caretString;
    }

    protected final int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean insertionAffectsCaret() {
        CaretString.CaretGravity caretGravity = this.caretString.getCaretGravity();
        if (caretGravity instanceof CaretString.CaretGravity.BACKWARD) {
            if (this.currentIndex >= this.caretString.getCaretPosition()) {
                return false;
            }
        } else {
            if (!(caretGravity instanceof CaretString.CaretGravity.FORWARD)) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.currentIndex > this.caretString.getCaretPosition() && (this.currentIndex != 0 || this.caretString.getCaretPosition() != 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean deletionAffectsCaret() {
        return this.currentIndex < this.caretString.getCaretPosition();
    }

    public Character next() {
        if (this.currentIndex >= this.caretString.getString().length()) {
            return null;
        }
        String string = this.caretString.getString();
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = string.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        int i = this.currentIndex;
        char c = charArray[i];
        this.currentIndex = i + 1;
        return Character.valueOf(c);
    }
}
