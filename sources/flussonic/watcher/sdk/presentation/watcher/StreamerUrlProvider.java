package flussonic.watcher.sdk.presentation.watcher;

import android.text.TextUtils;
import flussonic.watcher.sdk.domain.pojo.Track;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class StreamerUrlProvider {
    private static final ThreadLocal<SimpleDateFormat> PREVIEW_FORMATTER = new ThreadLocal<SimpleDateFormat>() { // from class: flussonic.watcher.sdk.presentation.watcher.StreamerUrlProvider.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private final StreamerConnectionParameters connectionParameters;
    private Track track;

    public StreamerUrlProvider(StreamerConnectionParameters connectionParameters) {
        this.connectionParameters = connectionParameters;
    }

    public String getBaseUrl() {
        return String.format(Locale.US, "%s://%s:%d/", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()));
    }

    public String getPlayerUrl(long from) {
        if (from == 0) {
            Track track = this.track;
            if (track != null && !TextUtils.isEmpty(track.getTrackNumber())) {
                return String.format(Locale.US, "%s://%s:%d/%s/video%s.ts?token=%s", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()), this.connectionParameters.stream(), this.track.getTrackNumber(), this.connectionParameters.token());
            }
            return String.format(Locale.US, "%s://%s:%d/%s/mpegts?token=%s", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()), this.connectionParameters.stream(), this.connectionParameters.token());
        }
        return String.format(Locale.US, "%s://%s:%d/%s/archive-%d-%d.mpd?dynamic=false&token=%s", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()), this.connectionParameters.stream(), Long.valueOf(from), 3600L, this.connectionParameters.token());
    }

    public String getPreviewMp4Url(Date date) {
        return String.format(Locale.US, "%s://%s:%d/%s/%s-preview.mp4?token=%s", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()), this.connectionParameters.stream(), PREVIEW_FORMATTER.get().format(date), this.connectionParameters.token());
    }

    public String getPreviewMp4Url() {
        return String.format(Locale.US, "%s://%s:%d/%s/preview.mp4?token=%s", this.connectionParameters.useHttps() ? "https" : "http", this.connectionParameters.server(), Integer.valueOf(this.connectionParameters.useHttps() ? this.connectionParameters.httpsPort() : this.connectionParameters.httpPort()), this.connectionParameters.stream(), this.connectionParameters.token());
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
