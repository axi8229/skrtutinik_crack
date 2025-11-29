package androidx.camera.core;

import android.util.Size;
import android.view.Surface;
import androidx.core.util.Consumer;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface SurfaceOutput extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    default int getFormat() {
        return 34;
    }

    Size getSize();

    Surface getSurface(Executor executor, Consumer<Event> consumer);

    void updateTransformMatrix(float[] fArr, float[] fArr2);

    public static abstract class Event {
        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();

        Event() {
        }

        public static Event of(int i, SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i, surfaceOutput);
        }
    }
}
