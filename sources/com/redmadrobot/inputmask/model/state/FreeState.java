package com.redmadrobot.inputmask.model.state;

import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FreeState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/FreeState;", "Lcom/redmadrobot/inputmask/model/State;", "child", "", "ownCharacter", "<init>", "(Lcom/redmadrobot/inputmask/model/State;C)V", "character", "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "autocomplete", "()Lcom/redmadrobot/inputmask/model/Next;", "", "toString", "()Ljava/lang/String;", "C", "getOwnCharacter", "()C", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FreeState extends State {
    private final char ownCharacter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreeState(State child, char c) {
        super(child);
        Intrinsics.checkNotNullParameter(child, "child");
        this.ownCharacter = c;
    }

    @Override // com.redmadrobot.inputmask.model.State
    public Next accept(char character) {
        if (this.ownCharacter == character) {
            return new Next(nextState(), Character.valueOf(character), true, null);
        }
        return new Next(nextState(), Character.valueOf(this.ownCharacter), false, null);
    }

    @Override // com.redmadrobot.inputmask.model.State
    public Next autocomplete() {
        return new Next(nextState(), Character.valueOf(this.ownCharacter), false, null);
    }

    @Override // com.redmadrobot.inputmask.model.State
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.ownCharacter);
        sb.append(" -> ");
        sb.append(getChild() == null ? "null" : getChild().toString());
        return sb.toString();
    }
}
