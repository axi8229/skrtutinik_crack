package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class MediaMetadata {
    public final String title;

    public static final class Builder {
        private String title;

        public MediaMetadata build() {
            return new MediaMetadata(this.title);
        }
    }

    private MediaMetadata(String title) {
        this.title = title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        return Util.areEqual(this.title, ((MediaMetadata) obj).title);
    }

    public int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
