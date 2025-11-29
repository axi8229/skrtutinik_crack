package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class MediaStoreUtil {
    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains(MediaStreamTrack.VIDEO_TRACK_KIND);
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }
}
