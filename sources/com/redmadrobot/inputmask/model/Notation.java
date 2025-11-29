package com.redmadrobot.inputmask.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Notation.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/redmadrobot/inputmask/model/Notation;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "character", "C", "getCharacter", "()C", "characterSet", "Ljava/lang/String;", "getCharacterSet", "isOptional", "Z", "()Z", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Notation {
    private final char character;
    private final String characterSet;
    private final boolean isOptional;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Notation)) {
            return false;
        }
        Notation notation = (Notation) other;
        return this.character == notation.character && Intrinsics.areEqual(this.characterSet, notation.characterSet) && this.isOptional == notation.isOptional;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((Character.hashCode(this.character) * 31) + this.characterSet.hashCode()) * 31;
        boolean z = this.isOptional;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "Notation(character=" + this.character + ", characterSet=" + this.characterSet + ", isOptional=" + this.isOptional + ')';
    }

    public final char getCharacter() {
        return this.character;
    }

    public final String getCharacterSet() {
        return this.characterSet;
    }

    /* renamed from: isOptional, reason: from getter */
    public final boolean getIsOptional() {
        return this.isOptional;
    }
}
