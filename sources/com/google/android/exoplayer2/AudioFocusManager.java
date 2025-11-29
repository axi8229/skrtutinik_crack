package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes2.dex */
final class AudioFocusManager {
    private AudioAttributes audioAttributes;
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private int focusGain;
    private final AudioFocusListener focusListener;
    private PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier = 1.0f;
    private int audioFocusState = 0;

    public interface PlayerControl {
        void executePlayerCommand(int playerCommand);

        void setVolumeMultiplier(float volumeMultiplier);
    }

    public AudioFocusManager(Context context, Handler eventHandler, PlayerControl playerControl) {
        this.audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.playerControl = playerControl;
        this.focusListener = new AudioFocusListener(eventHandler);
    }

    public float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    public int updateAudioFocus(boolean playWhenReady, int playbackState) {
        if (shouldAbandonAudioFocus(playbackState)) {
            abandonAudioFocus();
            return playWhenReady ? 1 : -1;
        }
        if (playWhenReady) {
            return requestAudioFocus();
        }
        return -1;
    }

    public void release() {
        this.playerControl = null;
        abandonAudioFocus();
    }

    private boolean shouldAbandonAudioFocus(int playbackState) {
        return playbackState == 1 || this.focusGain != 1;
    }

    private int requestAudioFocus() {
        if (this.audioFocusState == 1) {
            return 1;
        }
        if ((Util.SDK_INT >= 26 ? requestAudioFocusV26() : requestAudioFocusDefault()) == 1) {
            setAudioFocusState(1);
            return 1;
        }
        setAudioFocusState(0);
        return -1;
    }

    private void abandonAudioFocus() {
        if (this.audioFocusState == 0) {
            return;
        }
        if (Util.SDK_INT >= 26) {
            abandonAudioFocusV26();
        } else {
            abandonAudioFocusDefault();
        }
        setAudioFocusState(0);
    }

    private int requestAudioFocusDefault() {
        return this.audioManager.requestAudioFocus(this.focusListener, Util.getStreamTypeForAudioUsage(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).usage), this.focusGain);
    }

    private int requestAudioFocusV26() {
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest == null || this.rebuildAudioFocusRequest) {
            AudioFocusManager$$ExternalSyntheticApiModelOutline8.m();
            this.audioFocusRequest = (audioFocusRequest == null ? AudioFocusManager$$ExternalSyntheticApiModelOutline6.m(this.focusGain) : AudioFocusManager$$ExternalSyntheticApiModelOutline7.m(this.audioFocusRequest)).setAudioAttributes(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(willPauseWhenDucked()).setOnAudioFocusChangeListener(this.focusListener).build();
            this.rebuildAudioFocusRequest = false;
        }
        return this.audioManager.requestAudioFocus(this.audioFocusRequest);
    }

    private void abandonAudioFocusDefault() {
        this.audioManager.abandonAudioFocus(this.focusListener);
    }

    private void abandonAudioFocusV26() {
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private boolean willPauseWhenDucked() {
        AudioAttributes audioAttributes = this.audioAttributes;
        return audioAttributes != null && audioAttributes.contentType == 1;
    }

    private void setAudioFocusState(int audioFocusState) {
        if (this.audioFocusState == audioFocusState) {
            return;
        }
        this.audioFocusState = audioFocusState;
        float f = audioFocusState == 3 ? 0.2f : 1.0f;
        if (this.volumeMultiplier == f) {
            return;
        }
        this.volumeMultiplier = f;
        PlayerControl playerControl = this.playerControl;
        if (playerControl != null) {
            playerControl.setVolumeMultiplier(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlatformAudioFocusChange(int focusChange) {
        if (focusChange == -3 || focusChange == -2) {
            if (focusChange == -2 || willPauseWhenDucked()) {
                executePlayerCommand(0);
                setAudioFocusState(2);
                return;
            } else {
                setAudioFocusState(3);
                return;
            }
        }
        if (focusChange == -1) {
            executePlayerCommand(-1);
            abandonAudioFocus();
        } else if (focusChange == 1) {
            setAudioFocusState(1);
            executePlayerCommand(1);
        } else {
            Log.w("AudioFocusManager", "Unknown focus change type: " + focusChange);
        }
    }

    private void executePlayerCommand(int playerCommand) {
        PlayerControl playerControl = this.playerControl;
        if (playerControl != null) {
            playerControl.executePlayerCommand(playerCommand);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private final Handler eventHandler;

        public AudioFocusListener(Handler eventHandler) {
            this.eventHandler = eventHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAudioFocusChange$0(final int focusChange) {
            AudioFocusManager.this.handlePlatformAudioFocusChange(focusChange);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int focusChange) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.AudioFocusManager$AudioFocusListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioFocusChange$0(focusChange);
                }
            });
        }
    }
}
