package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Compiler.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0017\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler;", "", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "(Ljava/util/List;)V", "compile", "Lcom/redmadrobot/inputmask/model/State;", "formatString", "", "valuable", "", "fixed", "lastCharacter", "", "(Ljava/lang/String;ZZLjava/lang/Character;)Lcom/redmadrobot/inputmask/model/State;", "compileWithCustomNotations", "char", "string", "determineInheritedType", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "(Ljava/lang/Character;)Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "determineTypeWithCustomNotations", "FormatError", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Compiler {
    private final List<Notation> customNotations;

    /* compiled from: Compiler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler$FormatError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FormatError extends Exception {
    }

    public Compiler(List<Notation> customNotations) {
        Intrinsics.checkNotNullParameter(customNotations, "customNotations");
        this.customNotations = customNotations;
    }

    public final State compile(String formatString) throws FormatError {
        Intrinsics.checkNotNullParameter(formatString, "formatString");
        return compile(new FormatSanitizer().sanitize(formatString), false, false, null);
    }

    private final State compile(String formatString, boolean valuable, boolean fixed, Character lastCharacter) {
        if (formatString.length() == 0) {
            return new EOLState();
        }
        char cFirst = StringsKt.first(formatString);
        if (cFirst == '[') {
            if (lastCharacter == null || '\\' != lastCharacter.charValue()) {
                return compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst));
            }
        } else if (cFirst == '{') {
            if (lastCharacter == null || '\\' != lastCharacter.charValue()) {
                return compile(StringsKt.drop(formatString, 1), false, true, Character.valueOf(cFirst));
            }
        } else if (cFirst == ']') {
            if (lastCharacter == null || '\\' != lastCharacter.charValue()) {
                return compile(StringsKt.drop(formatString, 1), false, false, Character.valueOf(cFirst));
            }
        } else if (cFirst == '}') {
            if (lastCharacter == null || '\\' != lastCharacter.charValue()) {
                return compile(StringsKt.drop(formatString, 1), false, false, Character.valueOf(cFirst));
            }
        } else if (cFirst == '\\' && (lastCharacter == null || '\\' != lastCharacter.charValue())) {
            return compile(StringsKt.drop(formatString, 1), valuable, fixed, Character.valueOf(cFirst));
        }
        if (!valuable) {
            if (fixed) {
                return new FixedState(compile(StringsKt.drop(formatString, 1), false, true, Character.valueOf(cFirst)), cFirst);
            }
            return new FreeState(compile(StringsKt.drop(formatString, 1), false, false, Character.valueOf(cFirst)), cFirst);
        }
        if (cFirst == '0') {
            return new ValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new ValueState.StateType.Numeric());
        }
        if (cFirst == 'A') {
            return new ValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new ValueState.StateType.Literal());
        }
        if (cFirst == '_') {
            return new ValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new ValueState.StateType.AlphaNumeric());
        }
        if (cFirst == 8230) {
            return new ValueState(determineInheritedType(lastCharacter));
        }
        if (cFirst == '9') {
            return new OptionalValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new OptionalValueState.StateType.Numeric());
        }
        if (cFirst == 'a') {
            return new OptionalValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new OptionalValueState.StateType.Literal());
        }
        if (cFirst == '-') {
            return new OptionalValueState(compile(StringsKt.drop(formatString, 1), true, false, Character.valueOf(cFirst)), new OptionalValueState.StateType.AlphaNumeric());
        }
        return compileWithCustomNotations(cFirst, formatString);
    }

    private final ValueState.StateType determineInheritedType(Character lastCharacter) {
        return ((lastCharacter != null && lastCharacter.charValue() == '0') || (lastCharacter != null && lastCharacter.charValue() == '9')) ? new ValueState.StateType.Numeric() : ((lastCharacter != null && lastCharacter.charValue() == 'A') || (lastCharacter != null && lastCharacter.charValue() == 'a')) ? new ValueState.StateType.Literal() : ((lastCharacter != null && lastCharacter.charValue() == '_') || (lastCharacter != null && lastCharacter.charValue() == '-')) ? new ValueState.StateType.AlphaNumeric() : (lastCharacter != null && lastCharacter.charValue() == 8230) ? new ValueState.StateType.AlphaNumeric() : (lastCharacter != null && lastCharacter.charValue() == '[') ? new ValueState.StateType.AlphaNumeric() : determineTypeWithCustomNotations(lastCharacter);
    }

    private final State compileWithCustomNotations(char c, String string) throws FormatError {
        for (Notation notation : this.customNotations) {
            if (notation.getCharacter() == c) {
                if (notation.getIsOptional()) {
                    return new OptionalValueState(compile(StringsKt.drop(string, 1), true, false, Character.valueOf(c)), new OptionalValueState.StateType.Custom(c, notation.getCharacterSet()));
                }
                return new ValueState(compile(StringsKt.drop(string, 1), true, false, Character.valueOf(c)), new ValueState.StateType.Custom(c, notation.getCharacterSet()));
            }
        }
        throw new FormatError();
    }

    private final ValueState.StateType determineTypeWithCustomNotations(Character lastCharacter) throws FormatError {
        for (Notation notation : this.customNotations) {
            char character = notation.getCharacter();
            if (lastCharacter != null && character == lastCharacter.charValue()) {
                return new ValueState.StateType.Custom(lastCharacter.charValue(), notation.getCharacterSet());
            }
        }
        throw new FormatError();
    }
}
