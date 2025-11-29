package com.google.android.exoplayer2;

import android.annotation.SuppressLint;

/* loaded from: classes2.dex */
public interface RendererCapabilities {
    @SuppressLint({"WrongConstant"})
    static int create(int formatSupport, int adaptiveSupport, int tunnelingSupport) {
        return formatSupport | adaptiveSupport | tunnelingSupport;
    }

    @SuppressLint({"WrongConstant"})
    static int getAdaptiveSupport(int supportFlags) {
        return supportFlags & 24;
    }

    @SuppressLint({"WrongConstant"})
    static int getFormatSupport(int supportFlags) {
        return supportFlags & 7;
    }

    @SuppressLint({"WrongConstant"})
    static int getTunnelingSupport(int supportFlags) {
        return supportFlags & 32;
    }

    String getName();

    int getTrackType();

    int supportsFormat(Format format) throws ExoPlaybackException;

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;

    static int create(int formatSupport) {
        return create(formatSupport, 0, 0);
    }

    static String getFormatSupportString(int formatSupport) {
        if (formatSupport == 0) {
            return "NO";
        }
        if (formatSupport == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (formatSupport == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (formatSupport == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (formatSupport == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }
}
