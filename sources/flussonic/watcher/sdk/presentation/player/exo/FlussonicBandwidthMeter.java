package flussonic.watcher.sdk.presentation.player.exo;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FlussonicBandwidthMeter extends DefaultBandwidthMeter {
    private FlussonicPlaybackStatsListener playbackStatsListener;

    public void setFlussonicPlaybackStatsListener(FlussonicPlaybackStatsListener playbackStatsListener) {
        if (this.playbackStatsListener != playbackStatsListener) {
            this.playbackStatsListener = playbackStatsListener;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DefaultBandwidthMeter, com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource source, DataSpec dataSpec, boolean isNetwork) {
        super.onTransferInitializing(source, dataSpec, isNetwork);
    }

    @Override // com.google.android.exoplayer2.upstream.DefaultBandwidthMeter, com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource source, DataSpec dataSpec, boolean isNetwork) {
        super.onTransferStart(source, dataSpec, isNetwork);
        Map<String, List<String>> responseHeaders = source.getResponseHeaders();
        if (this.playbackStatsListener != null && !responseHeaders.isEmpty()) {
            this.playbackStatsListener.handleResponseHeaders(responseHeaders);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DefaultBandwidthMeter, com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource source, DataSpec dataSpec, boolean isNetwork) {
        super.onTransferEnd(source, dataSpec, isNetwork);
    }
}
