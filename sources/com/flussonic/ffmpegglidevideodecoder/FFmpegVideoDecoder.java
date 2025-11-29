package com.flussonic.ffmpegglidevideodecoder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Arrays;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FFmpegVideoDecoder.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J:\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J:\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0003*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\f\u0010\u001c\u001a\u00020\u0013*\u00020\u0011H\u0002J\f\u0010\u001d\u001a\u00020\u000b*\u00020\u0011H\u0002J\f\u0010\u001e\u001a\u00020\u000b*\u00020\u0011H\u0002J\f\u0010\u001f\u001a\u00020\u000b*\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u0013*\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/flussonic/ffmpegglidevideodecoder/FFmpegVideoDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V", "decode", "Lcom/bumptech/glide/load/engine/Resource;", "source", "outWidth", "", "outHeight", "options", "Lcom/bumptech/glide/load/Options;", "decodeFrame", "retriever", "Lflussonic/media/FFmpegMediaMetadataRetriever;", "timeUs", "", "frameOption", "strategy", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "decodeScaledFrame", "handles", "", "decodeOriginalFrame", "frameTimeMicros", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "orientation", "originalHeight", "originalWidth", "percentagePosition", "", "Companion", "ffmpegglidevideodecoder_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class FFmpegVideoDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Option<Long> FRAME_AT_TIME;
    private static final Option<Float> PERCENTAGE_DURATION;
    public static final String Tag = "FFmpegVideoDecoder";
    private final BitmapPool bitmapPool;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Uri source, Options options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return true;
    }

    public FFmpegVideoDecoder(BitmapPool bitmapPool) {
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        this.bitmapPool = bitmapPool;
    }

    /* compiled from: FFmpegVideoDecoder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/flussonic/ffmpegglidevideodecoder/FFmpegVideoDecoder$Companion;", "", "<init>", "()V", "Lcom/bumptech/glide/load/Option;", "", "FRAME_AT_TIME", "Lcom/bumptech/glide/load/Option;", "getFRAME_AT_TIME", "()Lcom/bumptech/glide/load/Option;", "", "Tag", "Ljava/lang/String;", "ffmpegglidevideodecoder_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Option<Long> getFRAME_AT_TIME() {
            return FFmpegVideoDecoder.FRAME_AT_TIME;
        }
    }

    static {
        Option<Float> optionMemory = Option.memory("com.flussonic.ffmpegglidevideodecoder.PercentageDuration", Float.valueOf(0.03f));
        Intrinsics.checkNotNullExpressionValue(optionMemory, "memory(\n                \"com.flussonic.ffmpegglidevideodecoder.PercentageDuration\"\n                , 0.03F\n        )");
        PERCENTAGE_DURATION = optionMemory;
        Option<Long> optionMemory2 = Option.memory("com.flussonic.ffmpegglidevideodecoder.FrameAtTime", -10L);
        Intrinsics.checkNotNullExpressionValue(optionMemory2, "memory(\n                \"com.flussonic.ffmpegglidevideodecoder.FrameAtTime\"\n                , -10\n        )");
        FRAME_AT_TIME = optionMemory2;
    }

    private final Bitmap decodeOriginalFrame(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever, long j, int i) {
        return fFmpegMediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private final long duration(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever) {
        String strExtractMetadata = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION);
        Intrinsics.checkNotNullExpressionValue(strExtractMetadata, "extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)");
        return Long.parseLong(strExtractMetadata);
    }

    private final int originalWidth(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever) {
        String strExtractMetadata = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
        Intrinsics.checkNotNullExpressionValue(strExtractMetadata, "extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)");
        return Integer.parseInt(strExtractMetadata);
    }

    private final int originalHeight(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever) {
        String strExtractMetadata = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
        Intrinsics.checkNotNullExpressionValue(strExtractMetadata, "extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)");
        return Integer.parseInt(strExtractMetadata);
    }

    private final int orientation(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever) {
        String strExtractMetadata = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
        Intrinsics.checkNotNullExpressionValue(strExtractMetadata, "extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)");
        return Integer.parseInt(strExtractMetadata);
    }

    private final long percentagePosition(FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever, float f) {
        return (long) (duration(fFmpegMediaMetadataRetriever) * 1000 * f);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(Uri source, int outWidth, int outHeight, Options options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever = new FFmpegMediaMetadataRetriever();
        Object obj = options.get(PERCENTAGE_DURATION);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "options.get(PERCENTAGE_DURATION)!!");
        float fFloatValue = ((Number) obj).floatValue();
        Object obj2 = options.get(FRAME_AT_TIME);
        Intrinsics.checkNotNull(obj2);
        Intrinsics.checkNotNullExpressionValue(obj2, "options.get(FRAME_AT_TIME)!!");
        long jLongValue = ((Number) obj2).longValue();
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.NONE;
        }
        DownsampleStrategy downSampleStrategy = downsampleStrategy;
        try {
            String string = source.toString();
            Intrinsics.checkNotNullExpressionValue(string, "source.toString()");
            fFmpegMediaMetadataRetriever.setDataSource(string, Collections.emptyMap());
            long jPercentagePosition = jLongValue > -10 ? jLongValue : percentagePosition(fFmpegMediaMetadataRetriever, fFloatValue);
            Intrinsics.checkNotNullExpressionValue(downSampleStrategy, "downSampleStrategy");
            Bitmap bitmapDecodeFrame = decodeFrame(fFmpegMediaMetadataRetriever, jPercentagePosition, 2, outWidth, outHeight, downSampleStrategy);
            fFmpegMediaMetadataRetriever.release();
            return BitmapResource.obtain(bitmapDecodeFrame, this.bitmapPool);
        } catch (Throwable th) {
            fFmpegMediaMetadataRetriever.release();
            throw th;
        }
    }

    private final Bitmap decodeFrame(FFmpegMediaMetadataRetriever retriever, long timeUs, int frameOption, int outWidth, int outHeight, DownsampleStrategy strategy) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(">>> decodeFrame called with timeUs %d, outWidth %d, outHeight %d, strategy %s", Arrays.copyOf(new Object[]{Long.valueOf(timeUs), Integer.valueOf(outWidth), Integer.valueOf(outHeight), strategy.toString()}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        Log.d(Tag, str);
        Bitmap bitmapDecodeScaledFrame = (outWidth == Integer.MIN_VALUE || outHeight == Integer.MIN_VALUE || Intrinsics.areEqual(strategy, DownsampleStrategy.NONE)) ? null : decodeScaledFrame(retriever, timeUs, frameOption, outWidth, outHeight, strategy);
        return bitmapDecodeScaledFrame == null ? decodeOriginalFrame(retriever, timeUs, frameOption) : bitmapDecodeScaledFrame;
    }

    private final Bitmap decodeScaledFrame(FFmpegMediaMetadataRetriever retriever, long timeUs, int frameOption, int outWidth, int outHeight, DownsampleStrategy strategy) {
        int i;
        DownsampleStrategy downsampleStrategy;
        try {
            int iOriginalWidth = originalWidth(retriever);
            int iOriginalHeight = originalHeight(retriever);
            int iOrientation = orientation(retriever);
            if (iOrientation == 90 || iOrientation == 270) {
                i = outHeight;
                downsampleStrategy = strategy;
                iOriginalHeight = iOriginalWidth;
                iOriginalWidth = iOriginalHeight;
            } else {
                i = outHeight;
                downsampleStrategy = strategy;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(iOriginalWidth, iOriginalHeight, outWidth, i);
            return retriever.getScaledFrameAtTime(timeUs, frameOption, Math.round(iOriginalWidth * scaleFactor), Math.round(scaleFactor * iOriginalHeight));
        } catch (Exception e) {
            if (!Log.isLoggable(Tag, 3)) {
                return null;
            }
            Log.d(Tag, "Exception trying to decode frame on oreo+", e);
            return null;
        }
    }
}
