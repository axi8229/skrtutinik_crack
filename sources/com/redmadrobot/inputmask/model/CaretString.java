package com.redmadrobot.inputmask.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CaretString.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString;", "", "", "string", "", "caretPosition", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "caretGravity", "<init>", "(Ljava/lang/String;ILcom/redmadrobot/inputmask/model/CaretString$CaretGravity;)V", "reversed", "()Lcom/redmadrobot/inputmask/model/CaretString;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getString", "I", "getCaretPosition", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "getCaretGravity", "()Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "CaretGravity", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CaretString {
    private final CaretGravity caretGravity;
    private final int caretPosition;
    private final String string;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaretString)) {
            return false;
        }
        CaretString caretString = (CaretString) other;
        return Intrinsics.areEqual(this.string, caretString.string) && this.caretPosition == caretString.caretPosition && Intrinsics.areEqual(this.caretGravity, caretString.caretGravity);
    }

    public int hashCode() {
        return (((this.string.hashCode() * 31) + Integer.hashCode(this.caretPosition)) * 31) + this.caretGravity.hashCode();
    }

    public String toString() {
        return "CaretString(string=" + this.string + ", caretPosition=" + this.caretPosition + ", caretGravity=" + this.caretGravity + ')';
    }

    public CaretString(String string, int i, CaretGravity caretGravity) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(caretGravity, "caretGravity");
        this.string = string;
        this.caretPosition = i;
        this.caretGravity = caretGravity;
    }

    public final String getString() {
        return this.string;
    }

    public final int getCaretPosition() {
        return this.caretPosition;
    }

    public final CaretGravity getCaretGravity() {
        return this.caretGravity;
    }

    public final CaretString reversed() {
        String str = this.string;
        if (str != null) {
            return new CaretString(StringsKt.reversed(str).toString(), this.string.length() - this.caretPosition, this.caretGravity);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* compiled from: CaretString.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "", "()V", "autocomplete", "", "getAutocomplete", "()Z", "autoskip", "getAutoskip", "BACKWARD", "FORWARD", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$FORWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$BACKWARD;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class CaretGravity {
        public /* synthetic */ CaretGravity(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: CaretString.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$FORWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "autocompleteValue", "", "(Z)V", "getAutocompleteValue", "()Z", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class FORWARD extends CaretGravity {
            private final boolean autocompleteValue;

            public FORWARD(boolean z) {
                super(null);
                this.autocompleteValue = z;
            }

            public final boolean getAutocompleteValue() {
                return this.autocompleteValue;
            }
        }

        private CaretGravity() {
        }

        /* compiled from: CaretString.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$BACKWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "autoskipValue", "", "(Z)V", "getAutoskipValue", "()Z", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class BACKWARD extends CaretGravity {
            private final boolean autoskipValue;

            public BACKWARD(boolean z) {
                super(null);
                this.autoskipValue = z;
            }

            public final boolean getAutoskipValue() {
                return this.autoskipValue;
            }
        }

        public final boolean getAutocomplete() {
            if (this instanceof FORWARD) {
                return ((FORWARD) this).getAutocompleteValue();
            }
            return false;
        }

        public final boolean getAutoskip() {
            if (this instanceof BACKWARD) {
                return ((BACKWARD) this).getAutoskipValue();
            }
            return false;
        }
    }
}
