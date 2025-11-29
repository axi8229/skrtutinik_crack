package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MediaControllerCompat$Callback implements IBinder.DeathRecipient {
    final MediaController.Callback mCallbackFwk = new MediaControllerCallbackApi21(this);
    IMediaControllerCallback mIControllerCallback;

    public void onAudioInfoChanged(MediaControllerCompat$PlaybackInfo info) {
    }

    public void onExtrasChanged(Bundle extras) {
    }

    public void onMetadataChanged(MediaMetadataCompat metadata) {
    }

    public void onPlaybackStateChanged(PlaybackStateCompat state) {
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) {
    }

    public void onQueueTitleChanged(CharSequence title) {
    }

    public void onSessionDestroyed() {
    }

    public void onSessionEvent(String event, Bundle extras) {
    }

    void postToHandler(int what, Object obj, Bundle data) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        postToHandler(8, null, null);
    }

    private static class MediaControllerCallbackApi21 extends MediaController.Callback {
        private final WeakReference<MediaControllerCompat$Callback> mCallback;

        MediaControllerCallbackApi21(MediaControllerCompat$Callback callback) {
            this.mCallback = new WeakReference<>(callback);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onSessionDestroyed();
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String event, Bundle extras) {
            MediaSessionCompat.ensureClassLoader(extras);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onSessionEvent(event, extras);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState stateObj) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback == null || mediaControllerCompat$Callback.mIControllerCallback != null) {
                return;
            }
            mediaControllerCompat$Callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(stateObj));
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata metadataObj) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(metadataObj));
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> queue) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(queue));
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence title) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onQueueTitleChanged(title);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle extras) {
            MediaSessionCompat.ensureClassLoader(extras);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onExtrasChanged(extras);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.support.v4.media.session.MediaControllerCompat$PlaybackInfo] */
        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo info) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != 0) {
                final int playbackType = info.getPlaybackType();
                final AudioAttributesCompat audioAttributesCompatWrap = AudioAttributesCompat.wrap(info.getAudioAttributes());
                final int volumeControl = info.getVolumeControl();
                final int maxVolume = info.getMaxVolume();
                final int currentVolume = info.getCurrentVolume();
                mediaControllerCompat$Callback.onAudioInfoChanged(new Object(playbackType, audioAttributesCompatWrap, volumeControl, maxVolume, currentVolume) { // from class: android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
                    private final AudioAttributesCompat mAudioAttrsCompat;
                    private final int mCurrentVolume;
                    private final int mMaxVolume;
                    private final int mPlaybackType;
                    private final int mVolumeControl;

                    {
                        this.mPlaybackType = playbackType;
                        this.mAudioAttrsCompat = audioAttributesCompatWrap;
                        this.mVolumeControl = volumeControl;
                        this.mMaxVolume = maxVolume;
                        this.mCurrentVolume = currentVolume;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class StubCompat extends IMediaControllerCallback.Stub {
        private final WeakReference<MediaControllerCompat$Callback> mCallback;

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChangedRemoved(boolean enabled) throws RemoteException {
        }

        StubCompat(MediaControllerCompat$Callback callback) {
            this.mCallback = new WeakReference<>(callback);
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onEvent(String event, Bundle extras) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(1, event, extras);
            }
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(2, state, null);
            }
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onCaptioningEnabledChanged(boolean enabled) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(11, Boolean.valueOf(enabled), null);
            }
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onRepeatModeChanged(int repeatMode) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(9, Integer.valueOf(repeatMode), null);
            }
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChanged(int shuffleMode) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(12, Integer.valueOf(shuffleMode), null);
            }
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionReady() throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.postToHandler(13, null, null);
            }
        }
    }
}
