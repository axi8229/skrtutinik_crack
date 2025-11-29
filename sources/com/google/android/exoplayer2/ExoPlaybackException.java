package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ExoPlaybackException extends Exception {
    private final Throwable cause;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    public static ExoPlaybackException createForSource(IOException cause) {
        return new ExoPlaybackException(0, cause);
    }

    public static ExoPlaybackException createForRenderer(Exception cause, String rendererName, int rendererIndex, Format rendererFormat, int rendererFormatSupport) {
        if (rendererFormat == null) {
            rendererFormatSupport = 4;
        }
        return new ExoPlaybackException(1, cause, null, rendererName, rendererIndex, rendererFormat, rendererFormatSupport);
    }

    public static boolean isEmptyManifest(ExoPlaybackException exception) {
        return (exception.getCause() instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exception.getCause()).responseCode == 410;
    }

    public static boolean isPositionOutOfRange(ExoPlaybackException exoPlaybackException) {
        for (ExoPlaybackException cause = exoPlaybackException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 0) {
                return true;
            }
        }
        return false;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException cause) {
        return new ExoPlaybackException(2, cause);
    }

    public static ExoPlaybackException createForOutOfMemoryError(OutOfMemoryError cause) {
        return new ExoPlaybackException(4, cause);
    }

    private ExoPlaybackException(int type, Throwable cause) {
        this(type, cause, null, null, -1, null, 4);
    }

    private ExoPlaybackException(int type, Throwable cause, String customMessage, String rendererName, int rendererIndex, Format rendererFormat, int rendererFormatSupport) {
        super(deriveMessage(type, customMessage, rendererName, rendererIndex, rendererFormat, rendererFormatSupport), cause);
        this.type = type;
        this.cause = cause;
        this.rendererName = rendererName;
        this.rendererIndex = rendererIndex;
        this.rendererFormat = rendererFormat;
        this.rendererFormatSupport = rendererFormatSupport;
        this.timestampMs = SystemClock.elapsedRealtime();
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.cause);
    }

    private static String deriveMessage(int type, String customMessage, String rendererName, int rendererIndex, Format rendererFormat, int rendererFormatSupport) {
        String str;
        if (type == 0) {
            str = "Source error";
        } else if (type == 1) {
            str = rendererName + " error, index=" + rendererIndex + ", format=" + rendererFormat + ", format_supported=" + RendererCapabilities.getFormatSupportString(rendererFormatSupport);
        } else if (type == 3) {
            str = "Remote error";
        } else if (type == 4) {
            str = "Out of memory error";
        } else {
            str = "Unexpected runtime error";
        }
        if (TextUtils.isEmpty(customMessage)) {
            return str;
        }
        return str + ": " + customMessage;
    }
}
