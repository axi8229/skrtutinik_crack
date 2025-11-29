package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;

@Alpha
/* loaded from: classes2.dex */
public abstract class Key {
    public abstract boolean equalsKey(Key other);

    public abstract Integer getIdRequirementOrNull();

    public abstract Parameters getParameters();
}
