package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;

/* loaded from: classes.dex */
public final class ImageWriterCompat {
    public static ImageWriter newInstance(Surface surface, int i) {
        return ImageWriterCompatApi23Impl.newInstance(surface, i);
    }

    public static Image dequeueInputImage(ImageWriter imageWriter) {
        return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
    }

    public static void queueInputImage(ImageWriter imageWriter, Image image) {
        ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
    }

    public static void close(ImageWriter imageWriter) {
        ImageWriterCompatApi23Impl.close(imageWriter);
    }
}
