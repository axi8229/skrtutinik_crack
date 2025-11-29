package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21 {
    private HashMap<MediaControllerCompat$Callback, ExtraCallback> mCallbackMap;
    final Object mLock;
    private final List<MediaControllerCompat$Callback> mPendingCallbacks;
    final MediaSessionCompat.Token mSessionToken;

    void processPendingCallbacksLocked() {
        if (this.mSessionToken.getExtraBinder() == null) {
            return;
        }
        for (MediaControllerCompat$Callback mediaControllerCompat$Callback : this.mPendingCallbacks) {
            ExtraCallback extraCallback = new ExtraCallback(mediaControllerCompat$Callback);
            this.mCallbackMap.put(mediaControllerCompat$Callback, extraCallback);
            mediaControllerCompat$Callback.mIControllerCallback = extraCallback;
            try {
                this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                mediaControllerCompat$Callback.postToHandler(13, null, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.mPendingCallbacks.clear();
    }

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> mMediaControllerImpl;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.mMediaControllerImpl.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || resultData == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.mLock) {
                mediaControllerCompat$MediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(resultData, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(resultData, "android.support.v4.media.session.SESSION_TOKEN2"));
                mediaControllerCompat$MediaControllerImplApi21.processPendingCallbacksLocked();
            }
        }
    }

    private static class ExtraCallback extends MediaControllerCompat$Callback.StubCompat {
        ExtraCallback(MediaControllerCompat$Callback callback) {
            super(callback);
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionDestroyed() throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueTitleChanged(CharSequence title) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onExtrasChanged(Bundle extras) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
            throw new AssertionError();
        }
    }
}
