package flussonic.watcher.sdk.domain.pojo;

/* loaded from: classes3.dex */
public enum PlaybackSpeed {
    HALF(0.5f),
    NORMAL(1.0f),
    DOUBLE(2.0f),
    QUADRUPLE(4.0f),
    OCTUPLE(8.0f),
    SEXDECUPLE(16.0f);

    public final float speed;

    PlaybackSpeed(float speed) {
        this.speed = speed;
    }

    public String toStringPretty() {
        float f = this.speed;
        if (f == ((int) f)) {
            return String.valueOf((int) f);
        }
        return String.valueOf(f);
    }
}
