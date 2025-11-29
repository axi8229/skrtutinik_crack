package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public interface AudioListener {
    default void onAudioSessionId(int audioSessionId) {
    }

    default void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
    }

    default void onVolumeChanged(float volume) {
    }
}
