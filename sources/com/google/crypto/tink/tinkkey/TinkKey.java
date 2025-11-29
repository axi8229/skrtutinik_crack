package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyTemplate;

@Deprecated
/* loaded from: classes2.dex */
public interface TinkKey {
    KeyTemplate getKeyTemplate();

    boolean hasSecret();
}
