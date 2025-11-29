package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Mask.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u0000  2\u00020\u0001:\u0003! \"B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask;", "", "", "format", "", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;)V", "Lcom/redmadrobot/inputmask/model/State;", "state", "", "noMandatoryCharactersLeftAfterState", "(Lcom/redmadrobot/inputmask/model/State;)Z", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "apply", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "makeIterator", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", "totalTextLength", "()I", "totalValueLength", "Ljava/util/List;", "getCustomNotations", "()Ljava/util/List;", "initialState", "Lcom/redmadrobot/inputmask/model/State;", "Factory", "AutocompletionStack", "Result", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class Mask {

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Mask> cache = new HashMap();
    private final List<Notation> customNotations;
    private final State initialState;

    public Mask(String format, List<Notation> customNotations) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(customNotations, "customNotations");
        this.customNotations = customNotations;
        this.initialState = new Compiler(customNotations).compile(format);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mask(String format) {
        this(format, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(format, "format");
    }

    /* compiled from: Mask.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Result;", "", "Lcom/redmadrobot/inputmask/model/CaretString;", "formattedText", "", "extractedValue", "", "affinity", "", "complete", "<init>", "(Lcom/redmadrobot/inputmask/model/CaretString;Ljava/lang/String;IZ)V", "reversed", "()Lcom/redmadrobot/inputmask/helper/Mask$Result;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/redmadrobot/inputmask/model/CaretString;", "getFormattedText", "()Lcom/redmadrobot/inputmask/model/CaretString;", "Ljava/lang/String;", "getExtractedValue", "I", "getAffinity", "Z", "getComplete", "()Z", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Result {
        private final int affinity;
        private final boolean complete;
        private final String extractedValue;
        private final CaretString formattedText;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.formattedText, result.formattedText) && Intrinsics.areEqual(this.extractedValue, result.extractedValue) && this.affinity == result.affinity && this.complete == result.complete;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = ((((this.formattedText.hashCode() * 31) + this.extractedValue.hashCode()) * 31) + Integer.hashCode(this.affinity)) * 31;
            boolean z = this.complete;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            return "Result(formattedText=" + this.formattedText + ", extractedValue=" + this.extractedValue + ", affinity=" + this.affinity + ", complete=" + this.complete + ')';
        }

        public Result(CaretString formattedText, String extractedValue, int i, boolean z) {
            Intrinsics.checkNotNullParameter(formattedText, "formattedText");
            Intrinsics.checkNotNullParameter(extractedValue, "extractedValue");
            this.formattedText = formattedText;
            this.extractedValue = extractedValue;
            this.affinity = i;
            this.complete = z;
        }

        public final CaretString getFormattedText() {
            return this.formattedText;
        }

        public final String getExtractedValue() {
            return this.extractedValue;
        }

        public final int getAffinity() {
            return this.affinity;
        }

        public final boolean getComplete() {
            return this.complete;
        }

        public final Result reversed() {
            CaretString caretStringReversed = this.formattedText.reversed();
            String str = this.extractedValue;
            if (str != null) {
                return new Result(caretStringReversed, StringsKt.reversed(str).toString(), this.affinity, this.complete);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    /* compiled from: Mask.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Factory;", "", "<init>", "()V", "", "format", "", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "Lcom/redmadrobot/inputmask/helper/Mask;", "getOrCreate", "(Ljava/lang/String;Ljava/util/List;)Lcom/redmadrobot/inputmask/helper/Mask;", "", "cache", "Ljava/util/Map;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.redmadrobot.inputmask.helper.Mask$Factory, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Mask getOrCreate(String format, List<Notation> customNotations) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(customNotations, "customNotations");
            Mask mask = (Mask) Mask.cache.get(format);
            if (mask != null) {
                return mask;
            }
            Mask mask2 = new Mask(format, customNotations);
            Mask.cache.put(format, mask2);
            return mask2;
        }
    }

    public Result apply(CaretString text) {
        Next nextAutocomplete;
        Intrinsics.checkNotNullParameter(text, "text");
        CaretStringIterator caretStringIteratorMakeIterator = makeIterator(text);
        int caretPosition = text.getCaretPosition();
        State state = this.initialState;
        AutocompletionStack autocompletionStack = new AutocompletionStack();
        boolean zInsertionAffectsCaret = caretStringIteratorMakeIterator.insertionAffectsCaret();
        boolean zDeletionAffectsCaret = caretStringIteratorMakeIterator.deletionAffectsCaret();
        Character next = caretStringIteratorMakeIterator.next();
        int i = 0;
        String strDropLast = "";
        String strDropLast2 = strDropLast;
        while (next != null) {
            Next nextAccept = state.accept(next.charValue());
            if (nextAccept != null) {
                if (zDeletionAffectsCaret) {
                    autocompletionStack.push(state.autocomplete());
                }
                state = nextAccept.getState();
                Object insert = nextAccept.getInsert();
                if (insert == null) {
                    insert = "";
                }
                strDropLast = Intrinsics.stringPlus(strDropLast, insert);
                Object value = nextAccept.getValue();
                if (value == null) {
                    value = "";
                }
                strDropLast2 = Intrinsics.stringPlus(strDropLast2, value);
                if (nextAccept.getPass()) {
                    zInsertionAffectsCaret = caretStringIteratorMakeIterator.insertionAffectsCaret();
                    zDeletionAffectsCaret = caretStringIteratorMakeIterator.deletionAffectsCaret();
                    next = caretStringIteratorMakeIterator.next();
                    i++;
                } else if (zInsertionAffectsCaret && nextAccept.getInsert() != null) {
                    caretPosition++;
                }
            } else {
                if (zDeletionAffectsCaret) {
                    caretPosition--;
                }
                zInsertionAffectsCaret = caretStringIteratorMakeIterator.insertionAffectsCaret();
                zDeletionAffectsCaret = caretStringIteratorMakeIterator.deletionAffectsCaret();
                next = caretStringIteratorMakeIterator.next();
            }
            i--;
        }
        while (text.getCaretGravity().getAutocomplete() && zInsertionAffectsCaret && (nextAutocomplete = state.autocomplete()) != null) {
            state = nextAutocomplete.getState();
            Object insert2 = nextAutocomplete.getInsert();
            if (insert2 == null) {
                insert2 = "";
            }
            strDropLast = Intrinsics.stringPlus(strDropLast, insert2);
            Object value2 = nextAutocomplete.getValue();
            if (value2 == null) {
                value2 = "";
            }
            strDropLast2 = Intrinsics.stringPlus(strDropLast2, value2);
            if (nextAutocomplete.getInsert() != null) {
                caretPosition++;
            }
        }
        while (text.getCaretGravity().getAutoskip() && !autocompletionStack.empty()) {
            Next nextPop = autocompletionStack.pop();
            Intrinsics.checkNotNullExpressionValue(nextPop, "autocompletionStack.pop()");
            Next next2 = nextPop;
            if (strDropLast.length() == caretPosition) {
                if (next2.getInsert() != null) {
                    Character insert3 = next2.getInsert();
                    char cLast = StringsKt.last(strDropLast);
                    if (insert3 != null && insert3.charValue() == cLast) {
                        caretPosition--;
                        strDropLast = StringsKt.dropLast(strDropLast, 1);
                    }
                }
                if (next2.getValue() != null) {
                    Character value3 = next2.getValue();
                    char cLast2 = StringsKt.last(strDropLast2);
                    if (value3 != null && value3.charValue() == cLast2) {
                        strDropLast2 = StringsKt.dropLast(strDropLast2, 1);
                    }
                }
            } else if (next2.getInsert() != null) {
                caretPosition--;
            }
        }
        return new Result(new CaretString(strDropLast, caretPosition, text.getCaretGravity()), strDropLast2, i, noMandatoryCharactersLeftAfterState(state));
    }

    public CaretStringIterator makeIterator(CaretString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new CaretStringIterator(text, 0, 2, null);
    }

    public final int totalTextLength() {
        int i = 0;
        for (State child = this.initialState; child != null && !(child instanceof EOLState); child = child.getChild()) {
            if ((child instanceof FixedState) || (child instanceof FreeState) || (child instanceof ValueState) || (child instanceof OptionalValueState)) {
                i++;
            }
        }
        return i;
    }

    public final int totalValueLength() {
        int i = 0;
        for (State child = this.initialState; child != null && !(child instanceof EOLState); child = child.getChild()) {
            if ((child instanceof FixedState) || (child instanceof ValueState) || (child instanceof OptionalValueState)) {
                i++;
            }
        }
        return i;
    }

    private final boolean noMandatoryCharactersLeftAfterState(State state) {
        if (state instanceof EOLState) {
            return true;
        }
        if (state instanceof ValueState) {
            return ((ValueState) state).isElliptical();
        }
        if (state instanceof FixedState) {
            return false;
        }
        return noMandatoryCharactersLeftAfterState(state.nextState());
    }

    /* compiled from: Mask.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$AutocompletionStack;", "Ljava/util/Stack;", "Lcom/redmadrobot/inputmask/model/Next;", "()V", "push", "item", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class AutocompletionStack extends Stack<Next> {
        public /* bridge */ boolean contains(Next next) {
            return super.contains((Object) next);
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof Next) {
                return contains((Next) obj);
            }
            return false;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(Next next) {
            return super.indexOf((Object) next);
        }

        @Override // java.util.Vector, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof Next) {
                return indexOf((Next) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Next next) {
            return super.lastIndexOf((Object) next);
        }

        @Override // java.util.Vector, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof Next) {
                return lastIndexOf((Next) obj);
            }
            return -1;
        }

        public /* bridge */ boolean remove(Next next) {
            return super.remove((Object) next);
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof Next) {
                return remove((Next) obj);
            }
            return false;
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Stack
        public Next push(Next item) {
            if (item != null) {
                return (Next) super.push((AutocompletionStack) item);
            }
            removeAllElements();
            return null;
        }
    }
}
