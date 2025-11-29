package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.data.repository.MediaInfoRepository;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.pojo.MediaInfo;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public class MediaInfoInteractor {
    private final MediaInfoRepository mediaInfoRepository;

    public MediaInfoInteractor(MediaInfoRepository mediaInfoRepository) {
        this.mediaInfoRepository = mediaInfoRepository;
    }

    public Single<MediaInfo> mediaInfo() {
        return this.mediaInfoRepository.mediaInfo(RetryFunction.LINEAR_DELAY_LIMITED).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
