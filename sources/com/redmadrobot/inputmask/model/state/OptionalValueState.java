package com.redmadrobot.inputmask.model.state;

import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OptionalValueState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState;", "Lcom/redmadrobot/inputmask/model/State;", "child", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "type", "<init>", "(Lcom/redmadrobot/inputmask/model/State;Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;)V", "", "character", "", "accepts", "(C)Z", "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "", "toString", "()Ljava/lang/String;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "getType", "()Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "StateType", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class OptionalValueState extends State {
    private final StateType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionalValueState(State child, StateType type) {
        super(child);
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    /* compiled from: OptionalValueState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "", "()V", "AlphaNumeric", "Custom", "Literal", "Numeric", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Custom;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class StateType {
        public /* synthetic */ StateType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: OptionalValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Numeric extends StateType {
            public Numeric() {
                super(null);
            }
        }

        private StateType() {
        }

        /* compiled from: OptionalValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Literal extends StateType {
            public Literal() {
                super(null);
            }
        }

        /* compiled from: OptionalValueState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class AlphaNumeric extends StateType {
            public AlphaNumeric() {
                super(null);
            }
        }

        /* compiled from: OptionalValueState.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Custom;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "character", "", "characterSet", "", "(CLjava/lang/String;)V", "getCharacter", "()C", "getCharacterSet", "()Ljava/lang/String;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        return new Next(nextState(), null, false, null);
    }

    @Override // com.redmadrobot.inputmask.model.State
    public String toString() {
        StateType stateType = this.type;
        if (stateType instanceof StateType.Literal) {
            return Intrinsics.stringPlus("[a] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (stateType instanceof StateType.Numeric) {
            return Intrinsics.stringPlus("[9] -> ", getChild() != null ? getChild().toString() : "null");
        }
        if (stateType instanceof StateType.AlphaNumeric) {
            return Intrinsics.stringPlus("[-] -> ", getChild() != null ? getChild().toString() : "null");
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
