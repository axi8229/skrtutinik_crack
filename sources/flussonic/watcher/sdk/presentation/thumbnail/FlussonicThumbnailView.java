package flussonic.watcher.sdk.presentation.thumbnail;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.data.network.services.SdkNetworkProvider;
import flussonic.watcher.sdk.data.repository.WatcherRepository;
import flussonic.watcher.sdk.domain.exceptions.InvalidUrlException;
import flussonic.watcher.sdk.domain.interactors.WatcherInteractor;
import flussonic.watcher.sdk.domain.pojo.Camera;
import flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError;
import flussonic.watcher.sdk.domain.utils.RxUtils;
import flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters;
import flussonic.watcher.sdk.presentation.watcher.StreamerUrlProvider;
import flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters;
import flussonic.watcher.sdk.presentation.watcher.WatcherUrlProvider;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import retrofit2.HttpException;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class FlussonicThumbnailView extends FrameLayout implements RequestListener<Drawable> {
    private String cacheKey;
    private Disposable cameraDisposable;
    private Headers headers;
    private ImageView imageView;
    private int previewHeight;
    private int previewWidth;
    private RequestManager requestManager;
    private StatusListener statusListener;
    private TextView textView;
    private String url;

    @Keep
    public enum Status {
        LOADING,
        LOADED,
        ERROR
    }

    public interface StatusListener {
        void onStatus(Status status, FlussonicThumbnailError error);
    }

    public FlussonicThumbnailView(Context context) {
        this(context, null);
    }

    public FlussonicThumbnailView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlussonicThumbnailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.previewWidth = 640;
        this.previewHeight = 360;
        this.cacheKey = null;
        init(context);
    }

    @TargetApi(21)
    public FlussonicThumbnailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.previewWidth = 640;
        this.previewHeight = 360;
        this.cacheKey = null;
        init(context);
    }

    private static void checkUrlNonEmpty(String url) {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("Specify url");
        }
    }

    private static boolean isSslError(Throwable throwable) {
        return (throwable instanceof SSLException) || throwable.toString().contains("SSL");
    }

    private void init(Context context) {
        if (isValidContextForGlide(context)) {
            this.requestManager = Glide.with(context);
            mayBeClearMemoryCache(context);
        }
        View viewInflate = View.inflate(getContext(), R$layout.fs_view_flussonic_thumbnail, this);
        this.imageView = (ImageView) viewInflate.findViewById(R$id.fs_thumbnail_image_view);
        this.textView = (TextView) viewInflate.findViewById(R$id.fs_thumbnail_text_view);
    }

    private void mayBeClearMemoryCache(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                Glide glide = Glide.get(context);
                glide.clearMemory();
                glide.setMemoryCategory(MemoryCategory.LOW);
                return;
            }
            Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL);
        }
    }

    public static void trimMemory(Context context, int level) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        int iMax = Math.max(15, level);
        Glide glide = Glide.get(context);
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                glide.setMemoryCategory(MemoryCategory.LOW);
                iMax = 60;
            }
        }
        glide.trimMemory(iMax);
        Timber.d("Trimmed memory with lvl %d", Integer.valueOf(iMax));
    }

    public static void trimMemory(Context context) {
        trimMemory(context, 0);
    }

    public void setUrl(String url) {
        setUrl(url, null);
    }

    public void setUrl(String url, Headers headers) {
        checkUrlNonEmpty(url);
        this.headers = headers;
        if (url.contains("@")) {
            loadTraditionalUrl(url);
        } else {
            loadModernUrl(url);
        }
    }

    public void setSize(final int previewWidth, final int previewHeight) {
        if (previewHeight <= 0 || previewWidth <= 0) {
            return;
        }
        if (this.previewHeight == previewHeight && this.previewWidth == previewWidth) {
            return;
        }
        this.previewHeight = previewHeight;
        this.previewWidth = previewWidth;
        show();
    }

    public void setCacheKey(String cacheKey) {
        String str = this.cacheKey;
        if (str != null && !str.equals(cacheKey)) {
            show(false);
        }
        this.cacheKey = cacheKey;
    }

    private void loadTraditionalUrl(String url) {
        try {
            final WatcherConnectionParameters watcherConnectionParametersCreate = WatcherConnectionParameters.create(url);
            WatcherInteractor watcherInteractor = new WatcherInteractor(new WatcherRepository(watcherConnectionParametersCreate, new SdkNetworkProvider().provideWatcherNetworkService(new WatcherUrlProvider(watcherConnectionParametersCreate).getBaseUrl())));
            cancelRequest();
            RxUtils.dispose(this.cameraDisposable);
            notifyListener(Status.LOADING, null);
            this.cameraDisposable = watcherInteractor.initStreamer().subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.thumbnail.FlussonicThumbnailView$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$loadTraditionalUrl$0(watcherConnectionParametersCreate, (StreamerConnectionParameters) obj);
                }
            }, new Consumer() { // from class: flussonic.watcher.sdk.presentation.thumbnail.FlussonicThumbnailView$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.onError((Throwable) obj);
                }
            });
        } catch (InvalidUrlException e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadTraditionalUrl$0(final WatcherConnectionParameters connectionParameters, StreamerConnectionParameters parameters) throws Exception {
        StreamerUrlProvider streamerUrlProvider = new StreamerUrlProvider(parameters);
        if (connectionParameters.from() == 0) {
            this.url = streamerUrlProvider.getPreviewMp4Url();
        } else {
            this.url = streamerUrlProvider.getPreviewMp4Url(new Date(TimeUnit.SECONDS.toMillis(connectionParameters.from())));
        }
        show();
    }

    private void loadModernUrl(String url) {
        if (url.equals(this.url)) {
            return;
        }
        cancelRequest();
        RxUtils.dispose(this.cameraDisposable);
        notifyListener(Status.LOADING, null);
        this.url = url;
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[PHI: r4
  0x003a: PHI (r4v2 flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError) = 
  (r4v1 flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError)
  (r4v5 flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError)
 binds: [B:8:0x0038, B:5:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            timber.log.Timber.e(r4)
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError$Builder r0 = flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError.builder()
            java.lang.String r1 = ""
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError$Builder r0 = r0.setCode(r1)
            java.lang.String r1 = r4.toString()
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError$Builder r0 = r0.setMessage(r1)
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError$Builder r0 = r0.setCause(r4)
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError r0 = r0.build()
            boolean r1 = r4 instanceof com.bumptech.glide.load.engine.GlideException
            java.lang.String r2 = "unknown_error"
            if (r1 == 0) goto L30
            com.bumptech.glide.load.engine.GlideException r4 = (com.bumptech.glide.load.engine.GlideException) r4
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError r4 = getGlideRootCause(r4)
            java.lang.String r1 = r4.code()
            if (r1 == r2) goto L3b
            goto L3a
        L30:
            flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError r4 = getRootCause(r4)
            java.lang.String r1 = r4.code()
            if (r1 == r2) goto L3b
        L3a:
            r0 = r4
        L3b:
            flussonic.watcher.sdk.presentation.thumbnail.FlussonicThumbnailView$Status r4 = flussonic.watcher.sdk.presentation.thumbnail.FlussonicThumbnailView.Status.ERROR
            r3.notifyListener(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.presentation.thumbnail.FlussonicThumbnailView.onError(java.lang.Throwable):void");
    }

    public void show(Camera camera, Date date) {
        cancelRequest();
        RxUtils.dispose(this.cameraDisposable);
        notifyListener(Status.LOADING, null);
        StreamerUrlProvider streamerUrlProvider = new StreamerUrlProvider(camera.getConnectionParameters());
        if (date == null) {
            this.url = streamerUrlProvider.getPreviewMp4Url();
        } else {
            this.url = streamerUrlProvider.getPreviewMp4Url(date);
        }
        show();
    }

    public void cancelRequest() {
        this.textView.setVisibility(8);
        try {
            RequestManager requestManager = this.requestManager;
            if (requestManager != null) {
                requestManager.clear(this.imageView);
            }
        } catch (Exception e) {
            Timber.e(e, ">>> FlussonicThumbnailView.cancelRequest error", new Object[0]);
        }
    }

    private void show() {
        show(true);
    }

    private void show(boolean cacheEnabled) {
        RequestManager requestManager;
        String str = this.url;
        if (str == null || (requestManager = this.requestManager) == null) {
            return;
        }
        if (this.headers == null) {
            requestManager.applyDefaultRequestOptions(MP4GlideModule.requestOptions(this.cacheKey, str, cacheEnabled).override(this.previewWidth, this.previewHeight)).load(Uri.parse(this.url)).listener(this).into(this.imageView);
        } else {
            requestManager.applyDefaultRequestOptions(MP4GlideModule.requestOptions(this.cacheKey, str, cacheEnabled).override(this.previewWidth, this.previewHeight)).load(new GlideUrl(this.url, this.headers)).listener(this).into(this.imageView);
        }
    }

    private static FlussonicThumbnailError getGlideRootCause(GlideException ex) {
        Iterator<Throwable> it = ex.getRootCauses().iterator();
        while (it.hasNext()) {
            FlussonicThumbnailError rootCause = getRootCause(it.next());
            if (rootCause.code() != "unknown_error") {
                return rootCause;
            }
        }
        return getErrorCause(ex);
    }

    private static FlussonicThumbnailError getRootCause(Throwable throwable) {
        for (Throwable cause = throwable; cause != null; cause = cause.getCause()) {
            FlussonicThumbnailError errorCause = getErrorCause(cause);
            if (!errorCause.code().equals("unknown_error")) {
                return errorCause;
            }
        }
        return getErrorCause(throwable);
    }

    private static FlussonicThumbnailError getErrorCause(Throwable throwable) {
        FlussonicThumbnailError.Builder builder = FlussonicThumbnailError.builder();
        if (isSslError(throwable)) {
            builder.setCode("495");
            builder.setMessage("Certificate error");
            builder.setCause(throwable);
        } else if (throwable instanceof HttpException) {
            builder.setCode(String.valueOf(((HttpException) throwable).code()));
            builder.setMessage(throwable.toString());
            builder.setCause(throwable);
        } else if (throwable instanceof FileNotFoundException) {
            builder.setCode("file_not_found");
            builder.setMessage(throwable.toString());
            builder.setCause(throwable);
        } else {
            builder.setCode("unknown_error");
            builder.setMessage(throwable.toString());
            builder.setCause(throwable);
        }
        return builder.build();
    }

    private static boolean isValidContextForGlide(final Context context) {
        if (getActivityFromContext(context) == null) {
            return false;
        }
        return !isActivityDestroyed(r0);
    }

    private static Activity getActivityFromContext(final Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        if (!(baseContext instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext2 = ((ContextWrapper) baseContext).getBaseContext();
        if (baseContext2 instanceof Activity) {
            return (Activity) baseContext2;
        }
        return null;
    }

    private static boolean isActivityDestroyed(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        Timber.d("load failed isFirstResource: %b url: %s ", Boolean.valueOf(isFirstResource), this.url);
        this.textView.setVisibility(0);
        onError(e);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        notifyListener(Status.LOADED, null);
        this.textView.setVisibility(8);
        return false;
    }

    private void notifyListener(Status status, FlussonicThumbnailError error) {
        StatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            statusListener.onStatus(status, error);
        }
    }

    public void setStatusListener(StatusListener statusListener) {
        this.statusListener = statusListener;
    }
}
