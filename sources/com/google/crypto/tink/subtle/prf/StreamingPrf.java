package com.google.crypto.tink.subtle.prf;

import java.io.InputStream;

/* loaded from: classes2.dex */
public interface StreamingPrf {
    InputStream computePrf(final byte[] input);
}
