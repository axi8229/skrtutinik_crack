package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class SimpleExoPlayer extends BasePlayer implements Player, Player.AudioComponent, Player.VideoComponent, Player.TextComponent {
    private final AnalyticsCollector analyticsCollector;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    private final CopyOnWriteArraySet<AudioRendererEventListener> audioDebugListeners;
    private DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    private Format audioFormat;
    private final CopyOnWriteArraySet<AudioListener> audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private final BandwidthMeter bandwidthMeter;
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    private List<Cue> currentCues;
    private DeviceInfo deviceInfo;
    private final CopyOnWriteArraySet<DeviceListener> deviceListeners;
    private final Handler eventHandler;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isPriorityTaskManagerRegistered;
    private final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayerImpl player;
    private boolean playerReleased;
    private PriorityTaskManager priorityTaskManager;
    protected final Renderer[] renderers;
    private boolean skipSilenceEnabled;
    private final StreamVolumeManager streamVolumeManager;
    private Surface surface;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    private final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    private final CopyOnWriteArraySet<VideoRendererEventListener> videoDebugListeners;
    private DecoderCounters videoDecoderCounters;
    private VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;
    private Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final CopyOnWriteArraySet<VideoListener> videoListeners;
    private int videoScalingMode;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean playWhenReady, int playerCommand) {
        return (!playWhenReady || playerCommand == 1) ? 1 : 2;
    }

    public Player.AudioComponent getAudioComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.VideoComponent getVideoComponent() {
        return this;
    }

    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private final Context context;
        private LoadControl loadControl;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private final RenderersFactory renderersFactory;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;

        public Builder(Context context) {
            this(context, new DefaultRenderersFactory(context));
        }

        public Builder(Context context, RenderersFactory renderersFactory) {
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
            DefaultMediaSourceFactory defaultMediaSourceFactoryNewInstance = DefaultMediaSourceFactory.newInstance(context);
            DefaultLoadControl defaultLoadControl = new DefaultLoadControl();
            DefaultBandwidthMeter singletonInstance = DefaultBandwidthMeter.getSingletonInstance(context);
            Looper looper = Util.getLooper();
            Clock clock = Clock.DEFAULT;
            this(context, renderersFactory, defaultTrackSelector, defaultMediaSourceFactoryNewInstance, defaultLoadControl, singletonInstance, looper, new AnalyticsCollector(clock), true, clock);
        }

        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, Looper looper, AnalyticsCollector analyticsCollector, boolean useLazyPreparation, Clock clock) {
            this.context = context;
            this.renderersFactory = renderersFactory;
            this.trackSelector = trackSelector;
            this.mediaSourceFactory = mediaSourceFactory;
            this.loadControl = loadControl;
            this.bandwidthMeter = bandwidthMeter;
            this.looper = looper;
            this.analyticsCollector = analyticsCollector;
            this.useLazyPreparation = useLazyPreparation;
            this.clock = clock;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter;
            return this;
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }
    }

    protected SimpleExoPlayer(Builder builder) {
        this(builder.context, builder.renderersFactory, builder.trackSelector, builder.mediaSourceFactory, builder.loadControl, builder.bandwidthMeter, builder.analyticsCollector, builder.useLazyPreparation, builder.clock, builder.looper);
    }

    protected SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean useLazyPreparation, Clock clock, Looper looper) {
        this.bandwidthMeter = bandwidthMeter;
        this.analyticsCollector = analyticsCollector;
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        CopyOnWriteArraySet<VideoListener> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        this.videoListeners = copyOnWriteArraySet;
        CopyOnWriteArraySet<AudioListener> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        this.audioListeners = copyOnWriteArraySet2;
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        this.deviceListeners = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<VideoRendererEventListener> copyOnWriteArraySet3 = new CopyOnWriteArraySet<>();
        this.videoDebugListeners = copyOnWriteArraySet3;
        CopyOnWriteArraySet<AudioRendererEventListener> copyOnWriteArraySet4 = new CopyOnWriteArraySet<>();
        this.audioDebugListeners = copyOnWriteArraySet4;
        Handler handler = new Handler(looper);
        this.eventHandler = handler;
        Renderer[] rendererArrCreateRenderers = renderersFactory.createRenderers(handler, componentListener, componentListener, componentListener, componentListener);
        this.renderers = rendererArrCreateRenderers;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.currentCues = Collections.emptyList();
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(rendererArrCreateRenderers, trackSelector, mediaSourceFactory, loadControl, bandwidthMeter, analyticsCollector, useLazyPreparation, clock, looper);
        this.player = exoPlayerImpl;
        analyticsCollector.setPlayer(exoPlayerImpl);
        exoPlayerImpl.addListener(analyticsCollector);
        exoPlayerImpl.addListener(componentListener);
        copyOnWriteArraySet3.add(analyticsCollector);
        copyOnWriteArraySet.add(analyticsCollector);
        copyOnWriteArraySet4.add(analyticsCollector);
        copyOnWriteArraySet2.add(analyticsCollector);
        addMetadataOutput(analyticsCollector);
        bandwidthMeter.addEventListener(handler, analyticsCollector);
        this.audioBecomingNoisyManager = new AudioBecomingNoisyManager(context, handler, componentListener);
        this.audioFocusManager = new AudioFocusManager(context, handler, componentListener);
        StreamVolumeManager streamVolumeManager = new StreamVolumeManager(context, handler, componentListener);
        this.streamVolumeManager = streamVolumeManager;
        this.wakeLockManager = new WakeLockManager(context);
        this.wifiLockManager = new WifiLockManager(context);
        this.deviceInfo = createDeviceInfo(streamVolumeManager);
    }

    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(null, false);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(Surface surface) {
        verifyApplicationThread();
        if (surface == null || surface != this.surface) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurface(Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surface != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        setVideoSurfaceInternal(surface, false);
        int i = surface != null ? -1 : 0;
        maybeNotifySurfaceSizeChanged(i, i);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surfaceHolder != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.componentListener);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            setVideoSurfaceInternal(surface, false);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        } else {
            setVideoSurfaceInternal(null, false);
            maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null || surfaceHolder != this.surfaceHolder) {
            return;
        }
        setVideoSurfaceHolder(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (textureView != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.textureView = textureView;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            setVideoSurfaceInternal(new Surface(surfaceTexture), true);
            maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        if (textureView == null || textureView != this.textureView) {
            return;
        }
        setVideoTextureView(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        verifyApplicationThread();
        if (videoDecoderOutputBufferRenderer != null) {
            clearVideoSurface();
        }
        setVideoDecoderOutputBufferRendererInternal(videoDecoderOutputBufferRenderer);
    }

    public void clearVideoDecoderOutputBufferRenderer() {
        verifyApplicationThread();
        setVideoDecoderOutputBufferRendererInternal(null);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setVolume(float audioVolume) {
        verifyApplicationThread();
        float fConstrainValue = Util.constrainValue(audioVolume, 0.0f, 1.0f);
        if (this.audioVolume == fConstrainValue) {
            return;
        }
        this.audioVolume = fConstrainValue;
        sendVolumeToRenderers();
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(fConstrainValue);
        }
    }

    public void addAnalyticsListener(AnalyticsListener listener) {
        verifyApplicationThread();
        this.analyticsCollector.addListener(listener);
    }

    public void removeAnalyticsListener(AnalyticsListener listener) {
        verifyApplicationThread();
        this.analyticsCollector.removeListener(listener);
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void addVideoListener(VideoListener listener) {
        this.videoListeners.add(listener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void removeVideoListener(VideoListener listener) {
        this.videoListeners.remove(listener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener listener) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = listener;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(6).setPayload(listener).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener listener) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener != listener) {
            return;
        }
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(6).setPayload(null).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setCameraMotionListener(CameraMotionListener listener) {
        verifyApplicationThread();
        this.cameraMotionListener = listener;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 5) {
                this.player.createMessage(renderer).setType(7).setPayload(listener).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearCameraMotionListener(CameraMotionListener listener) {
        verifyApplicationThread();
        if (this.cameraMotionListener != listener) {
            return;
        }
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 5) {
                this.player.createMessage(renderer).setType(7).setPayload(null).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void addTextOutput(TextOutput listener) {
        if (!this.currentCues.isEmpty()) {
            listener.onCues(this.currentCues);
        }
        this.textOutputs.add(listener);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void removeTextOutput(TextOutput listener) {
        this.textOutputs.remove(listener);
    }

    public void addMetadataOutput(MetadataOutput listener) {
        this.metadataOutputs.add(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener listener) {
        verifyApplicationThread();
        this.player.addListener(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener listener) {
        verifyApplicationThread();
        this.player.removeListener(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    @Deprecated
    public ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    @Override // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.player.getPlayerError();
    }

    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int iUpdateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, iUpdateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, iUpdateAudioFocus));
        this.player.prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean resetPosition, boolean resetState) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), resetPosition ? 0 : -1, -9223372036854775807L);
        prepare();
    }

    @Override // com.google.android.exoplayer2.BasePlayer
    public void setMediaItems(List<MediaItem> mediaItems) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(mediaItems);
    }

    @Override // com.google.android.exoplayer2.BasePlayer
    public void setMediaItems(List<MediaItem> mediaItems, boolean resetPosition) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(mediaItems, resetPosition);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> mediaItems, int startWindowIndex, long startPositionMs) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(mediaItems, startWindowIndex, startPositionMs);
    }

    @Override // com.google.android.exoplayer2.BasePlayer
    public void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaSources(List<MediaSource> mediaSources, int startWindowIndex, long startPositionMs) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(mediaSources, startWindowIndex, startPositionMs);
    }

    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean playWhenReady) {
        verifyApplicationThread();
        int iUpdateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
        updatePlayWhenReady(playWhenReady, iUpdateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, iUpdateAudioFocus));
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int repeatMode) {
        verifyApplicationThread();
        this.player.setRepeatMode(repeatMode);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean shuffleModeEnabled) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(shuffleModeEnabled);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int windowIndex, long positionMs) {
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(windowIndex, positionMs);
    }

    public void setPlaybackSpeed(float playbackSpeed) {
        verifyApplicationThread();
        this.player.setPlaybackSpeed(playbackSpeed);
    }

    @Override // com.google.android.exoplayer2.Player
    public float getPlaybackSpeed() {
        verifyApplicationThread();
        return this.player.getPlaybackSpeed();
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean reset) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        this.player.stop(reset);
        this.currentCues = Collections.emptyList();
    }

    public void release() {
        verifyApplicationThread();
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        removeSurfaceCallbacks();
        Surface surface = this.surface;
        if (surface != null) {
            if (this.ownsSurface) {
                surface.release();
            }
            this.surface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        this.currentCues = Collections.emptyList();
        this.playerReleased = true;
    }

    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int index) {
        verifyApplicationThread();
        return this.player.getRendererType(index);
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    public long getPlaybackTimeUtc() {
        return this.player.getPlaybackTimeUtc();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface, boolean ownsSurface) {
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        Surface surface2 = this.surface;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface;
        this.ownsSurface = ownsSurface;
    }

    private void setVideoDecoderOutputBufferRendererInternal(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(8).setPayload(videoDecoderOutputBufferRenderer).send();
            }
        }
        this.videoDecoderOutputBufferRenderer = videoDecoderOutputBufferRenderer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int width, int height) {
        if (width == this.surfaceWidth && height == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        Iterator<VideoListener> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(width, height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        float volumeMultiplier = this.audioVolume * this.audioFocusManager.getVolumeMultiplier();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(2).setPayload(Float.valueOf(volumeMultiplier)).send();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioSessionIdSet() {
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.audioDebugListeners.contains(next)) {
                next.onAudioSessionId(this.audioSessionId);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.audioDebugListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onAudioSessionId(this.audioSessionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySkipSilenceEnabledChanged() {
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.audioDebugListeners.contains(next)) {
                next.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.audioDebugListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayWhenReady(boolean playWhenReady, int playerCommand, int playWhenReadyChangeReason) {
        int i = 0;
        boolean z = playWhenReady && playerCommand != -1;
        if (z && playerCommand != 1) {
            i = 1;
        }
        this.player.setPlayWhenReady(z, i, playWhenReadyChangeReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.wakeLockManager.setStayAwake(getPlayWhenReady());
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != getApplicationLooper()) {
            Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
            this.hasNotifiedFullWrongThreadWarning = true;
        }
    }

    private static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo(0, streamVolumeManager.getMinVolume(), streamVolumeManager.getMaxVolume());
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, Player.EventListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters counters) {
            SimpleExoPlayer.this.videoDecoderCounters = counters;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoEnabled(counters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDecoderInitialized(decoderName, initializedTimestampMs, initializationDurationMs);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer.this.videoFormat = format;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int count, long elapsed) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onDroppedFrames(count, elapsed);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                VideoListener videoListener = (VideoListener) it.next();
                if (!SimpleExoPlayer.this.videoDebugListeners.contains(videoListener)) {
                    videoListener.onVideoSizeChanged(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
                }
            }
            Iterator it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((VideoRendererEventListener) it2.next()).onVideoSizeChanged(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            Iterator it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((VideoRendererEventListener) it2.next()).onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters counters) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDisabled(counters);
            }
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long totalProcessingOffsetUs, int frameCount, Format format) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoFrameProcessingOffset(totalProcessingOffsetUs, frameCount, format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters counters) {
            SimpleExoPlayer.this.audioDecoderCounters = counters;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioEnabled(counters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int sessionId) {
            if (SimpleExoPlayer.this.audioSessionId == sessionId) {
                return;
            }
            SimpleExoPlayer.this.audioSessionId = sessionId;
            SimpleExoPlayer.this.notifyAudioSessionIdSet();
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDecoderInitialized(decoderName, initializedTimestampMs, initializationDurationMs);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer.this.audioFormat = format;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioSinkUnderrun(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters counters) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDisabled(counters);
            }
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
            SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
            if (SimpleExoPlayer.this.skipSilenceEnabled == skipSilenceEnabled) {
                return;
            }
            SimpleExoPlayer.this.skipSilenceEnabled = skipSilenceEnabled;
            SimpleExoPlayer.this.notifySkipSilenceEnabledChanged();
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> cues) {
            SimpleExoPlayer.this.currentCues = cues;
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextOutput) it.next()).onCues(cues);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder holder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(holder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(width, height);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder holder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(width, height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(width, height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float volumeMultiplier) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int playerCommand) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(playWhenReady, playerCommand, SimpleExoPlayer.getPlayWhenReadyChangeReason(playWhenReady, playerCommand));
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.updatePlayWhenReady(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(int streamVolume, boolean streamMuted) {
            Iterator it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                ((DeviceListener) it.next()).onDeviceVolumeChanged(streamVolume, streamMuted);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsLoadingChanged(boolean isLoading) {
            if (SimpleExoPlayer.this.priorityTaskManager != null) {
                if (!isLoading || SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                    if (isLoading || !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                        return;
                    }
                    SimpleExoPlayer.this.priorityTaskManager.remove(0);
                    SimpleExoPlayer.this.isPriorityTaskManagerRegistered = false;
                    return;
                }
                SimpleExoPlayer.this.priorityTaskManager.add(0);
                SimpleExoPlayer.this.isPriorityTaskManagerRegistered = true;
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int playbackState) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }
    }
}
