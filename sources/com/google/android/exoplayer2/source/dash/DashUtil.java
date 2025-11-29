package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSpec;

/* loaded from: classes2.dex */
public final class DashUtil {
    public static DataSpec buildDataSpec(Representation representation, RangedUri requestUri) {
        return new DataSpec.Builder().setUri(requestUri.resolveUri(representation.baseUrl)).setPosition(requestUri.start).setLength(requestUri.length).setKey(representation.getCacheKey()).build();
    }
}
