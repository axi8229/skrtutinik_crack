package flussonic.watcher.sdk.presentation.watcher;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class FlussonicFragment extends Fragment {
    private FlussonicPlaybackStateImpl playbackState = new FlussonicPlaybackStateImpl();

    FlussonicPlaybackStateImpl getPlaybackState() {
        return this.playbackState;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Timber.d("onAttach %s", this.playbackState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (savedInstanceState != null) {
            this.playbackState = (FlussonicPlaybackStateImpl) savedInstanceState.getParcelable("KEY_PLAYBACK_STATE");
        }
        Timber.d("onCreate %s", this.playbackState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("KEY_PLAYBACK_STATE", this.playbackState);
        Timber.d("onSaveInstanceState %s", this.playbackState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy %s", this.playbackState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Timber.d("onDetach %s", this.playbackState);
    }
}
