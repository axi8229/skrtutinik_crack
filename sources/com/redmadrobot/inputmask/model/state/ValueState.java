package com.redmadrobot.inputmask.model.state;

import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ValueState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState;", "Lcom/redmadrobot/inputmask/model/State;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "inheritedType", "<init>", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "child", "type", "(Lcom/redmadrobot/inputmask/model/State;Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "", "character", "", "accepts", "(C)Z", "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "nextState", "()Lcom/redmadrobot/inputmask/model/State;", "", "toString", "()Ljava/lang/String;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "getType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "isElliptical", "()Z", "StateType", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ValueState extends State {
    private final StateType type;

    /* compiled from: ValueState.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "", "()V", "AlphaNumeric", "Custom", "Ellipsis", "Literal", "Numeric", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class StateType {
        public /* synthetic */ StateType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: ValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Numeric extends StateType {
            public Numeric() {
                super(null);
            }
        }

        private StateType() {
        }

        /* compiled from: ValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Literal extends StateType {
            public Literal() {
                super(null);
            }
        }

        /* compiled from: ValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class AlphaNumeric extends StateType {
            public AlphaNumeric() {
                super(null);
            }
        }

        /* compiled from: ValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "inheritedType", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "getInheritedType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Ellipsis extends StateType {
            private final StateType inheritedType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Ellipsis(StateType inheritedType) {
                super(null);
                Intrinsics.checkNotNullParameter(inheritedType, "inheritedType");
                this.inheritedType = inheritedType;
            }

            public final StateType getInheritedType() {
                return this.inheritedType;
            }
        }

        /* compiled from: ValueState.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "character", "", "characterSet", "", "(CLjava/lang/String;)V", "getCharacter", "()C", "getCharacterSet", "()Ljava/lang/String;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Custom extends StateType {
            private final char character;
            private final String characterSet;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(char c, String characterSet) {
                super(null);
                Intrinsics.checkNotNullParameter(characterSet, "characterSet");
                this.character = c;
                this.characterSet = characterSet;
            }

            public final char getCharacter() {
                return this.character;
            }

            public final String getCharacterSet() {
                return this.characterSet;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueState(StateType inheritedType) {
        super(null);
        Intrinsics.checkNotNullParameter(inheritedType, "inheritedType");
        this.type = new StateType.Ellipsis(inheritedType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueState(State state, StateType type) {
        super(state);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    private final boolean accepts(char character) {
        StateType stateType = this.type;
        if (stateType instanceof StateType.Numeric) {
            return Character.isDigit(character);
        }
        if (stateType instanceof StateType.Literal) {
            return Character.isLetter(character);
        }
        if (stateType instanceof StateType.AlphaNumeric) {
            return Character.isLetterOrDigit(character);
        }
        if (stateType instanceof StateType.Ellipsis) {
            StateType inheritedType = ((StateType.Ellipsis) stateType).getInheritedType();
            if (inheritedType instanceof StateType.Numeric) {
                return Character.isDigit(character);
            }
            if (inheritedType instanceof StateType.Literal) {
                return Character.isLetter(character);
            }
            if (inheritedType instanceof StateType.AlphaNumeric) {
                return Character.isLetterOrDigit(character);
            }
            if (inheritedType instanceof StateType.Custom) {
                return StringsKt.contains$default((CharSequence) ((StateType.Custom) ((StateType.Ellipsis) this.type).getInheritedType()).getCharacterSet(), character, false, 2, (Object) null);
            }
            return false;
        }
        if (stateType instanceof StateType.Custom) {
            return StringsKt.contains$default((CharSequence) ((StateType.Custom) stateType).getCharacterSet(), character, false, 2, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.redmadrobot.inputmask.model.State
    public Next accept(char character) {
        if (accepts(character)) {
            return new Next(nextState(), Character.valueOf(character), true, Character.valueOf(character));
        }
        return null;
    }

    public final boolean isElliptical() {
        return this.type instanceof StateType.Ellipsis;
    }

    @Override // com.redmadrobot.inputmask.model.State
    public State nextState() {
        return this.type instanceof StateType.Ellipsis ? this : super.nextState();
    }

    @Override // com.redmadrobot.inputmask.model.State
    public String toString() {
        StateType stateType = this.type;
        if (stateType instanceof StateType.Literal) {
            return Intrinsics.stringPlus("[A] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (stateType instanceof StateType.Numeric) {
            return Intrinsics.stringPlus("[0] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (stateType instanceof StateType.AlphaNumeric) {
            return Intrinsics.stringPlus("[_] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (stateType instanceof StateType.Ellipsis) {
            return Intrinsics.stringPlus("[…] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (!(stateType instanceof StateType.Custom)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(((StateType.Custom) this.type).getCharacter());
        sb.append("] -> ");
        sb.append(getChild() != null ? getChild().toString() : "null");
        return sb.toString();
    }
}
