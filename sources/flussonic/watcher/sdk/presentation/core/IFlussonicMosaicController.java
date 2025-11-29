package flussonic.watcher.sdk.presentation.core;

import flussonic.watcher.sdk.domain.pojo.Quality;

/* loaded from: classes3.dex */
public interface IFlussonicMosaicController extends FlussonicController {
    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    void disableAudio(boolean audioDisabled);

    Quality getQuality();

    int setMaxFrameRate(int maxFps);

    void setQuality(Quality quality);

    void setResizeMode(int resizeMode);
}
