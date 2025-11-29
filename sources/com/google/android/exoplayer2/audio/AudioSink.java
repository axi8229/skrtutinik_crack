package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface AudioSink {

    public interface Listener {
        void onAudioSessionId(int audioSessionId);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled);

        void onUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs);
    }

    void configure(int inputEncoding, int inputChannelCount, int inputSampleRate, int specifiedBufferSize, int[] outputChannels, int trimStartFrames, int trimEndFrames) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int tunnelingAudioSessionId);

    void flush();

    long getCurrentPositionUs(boolean sourceEnded);

    float getPlaybackSpeed();

    boolean handleBuffer(ByteBuffer buffer, long presentationTimeUs, int encodedAccessUnitCount) throws WriteException, InitializationException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int audioSessionId);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setListener(Listener listener);

    void setPlaybackSpeed(float playbackSpeed);

    void setSkipSilenceEnabled(boolean skipSilenceEnabled);

    void setVolume(float volume);

    boolean supportsOutput(int channelCount, int encoding);

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable cause) {
            super(cause);
        }

        public ConfigurationException(String message) {
            super(message);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int audioTrackState, int sampleRate, int channelConfig, int bufferSize) {
            super("AudioTrack init failed: " + audioTrackState + ", Config(" + sampleRate + ", " + channelConfig + ", " + bufferSize + ")");
            this.audioTrackState = audioTrackState;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int errorCode) {
            super("AudioTrack write failed: " + errorCode);
            this.errorCode = errorCode;
        }
    }
}
