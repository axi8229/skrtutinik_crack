package flussonic.watcher.sdk.domain.pojo;

import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import flussonic.watcher.sdk.domain.pojo.C$AutoValue_Track;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class Track implements Parcelable {

    public static abstract class Builder {
        public abstract Track build();

        public abstract Builder setBitrate(int bitrate);

        public abstract Builder setCodec(String codec);

        public abstract Builder setContent(String content);

        public abstract Builder setHeight(int height);

        public abstract Builder setLevel(String level);

        public abstract Builder setPixelHeight(int pixelHeight);

        public abstract Builder setPixelWidth(int pixelWidth);

        public abstract Builder setProfile(String profile);

        public abstract Builder setSarHeight(int sarHeight);

        public abstract Builder setSarWidth(int sarWidth);

        public abstract Builder setSize(String size);

        public abstract Builder setTrackId(String trackId);

        public abstract Builder setWidth(int width);
    }

    public abstract int bitrate();

    public abstract String codec();

    public abstract String content();

    public abstract int height();

    public abstract String level();

    public abstract int pixelHeight();

    public abstract int pixelWidth();

    public abstract String profile();

    public abstract int sarHeight();

    public abstract int sarWidth();

    public abstract String size();

    public abstract String trackId();

    public abstract int width();

    public static List<Track> createFromFormat(List<Format> formats) {
        ArrayList arrayList = new ArrayList();
        Iterator<Format> it = formats.iterator();
        while (it.hasNext()) {
            arrayList.add(createFromFormat(it.next()));
        }
        return arrayList;
    }

    public static Track createFromFormat(Format format) {
        if (format == null) {
            return null;
        }
        return builder().setLevel("").setProfile(NonNullUtils.stringValue(format.sampleMimeType)).setBitrate(format.bitrate).setContent("").setCodec(NonNullUtils.stringValue(format.codecs)).setSize(String.format(Locale.US, "%dx%d", Integer.valueOf(format.width), Integer.valueOf(format.height))).setTrackId(NonNullUtils.stringValue(format.id)).setSarHeight(0).setWidth(format.width).setPixelHeight(0).setSarWidth(0).setPixelWidth(0).setHeight(format.height).build();
    }

    public static Builder builder() {
        return new C$AutoValue_Track.Builder();
    }

    public String getTrackNumber() {
        String strStringValue = NonNullUtils.stringValue(trackId());
        return strStringValue.length() < 1 ? "" : strStringValue.substring(1);
    }

    public boolean isVideoTrack() {
        return trackId().contains("v");
    }
}
