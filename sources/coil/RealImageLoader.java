package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.EventListener;
import coil.content.ImageLoaderOptions;
import coil.content.Logger;
import coil.content.SystemCallbacks;
import coil.content.Utils;
import coil.decode.BitmapFactoryDecoder;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.OneShotDisposable;
import coil.request.RequestService;
import coil.target.ViewTarget;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 b2\u00020\u0001:\u0001bBg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0083@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J)\u0010(\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020'2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020\u0017H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020$2\u0006\u00100\u001a\u00020\u0019H\u0000¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00107\u001a\u0004\b8\u00109R\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010:\u001a\u0004\b;\u0010<R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b=\u0010<R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\b>\u0010<R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u0010B\u001a\u0004\bR\u0010DR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010Z\u001a\u0004\b[\u0010\\R\u001d\u0010a\u001a\u0004\u0018\u00010\u00078VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b]\u0010^*\u0004\b_\u0010`\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "Landroid/content/Context;", "context", "Lcoil/request/DefaultRequestOptions;", "defaults", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "memoryCacheLazy", "Lcoil/disk/DiskCache;", "diskCacheLazy", "Lokhttp3/Call$Factory;", "callFactoryLazy", "Lcoil/EventListener$Factory;", "eventListenerFactory", "Lcoil/ComponentRegistry;", "componentRegistry", "Lcoil/util/ImageLoaderOptions;", "options", "Lcoil/util/Logger;", "logger", "<init>", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "Lcoil/request/ImageRequest;", "initialRequest", "", "type", "Lcoil/request/ImageResult;", "executeMain", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/request/SuccessResult;", "result", "Lcoil/target/Target;", "target", "Lcoil/EventListener;", "eventListener", "", "onSuccess", "(Lcoil/request/SuccessResult;Lcoil/target/Target;Lcoil/EventListener;)V", "Lcoil/request/ErrorResult;", "onError", "(Lcoil/request/ErrorResult;Lcoil/target/Target;Lcoil/EventListener;)V", "request", "onCancel", "(Lcoil/request/ImageRequest;Lcoil/EventListener;)V", "Lcoil/request/Disposable;", "enqueue", "(Lcoil/request/ImageRequest;)Lcoil/request/Disposable;", "level", "onTrimMemory$coil_base_release", "(I)V", "onTrimMemory", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "Lkotlin/Lazy;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getCallFactoryLazy", "Lcoil/EventListener$Factory;", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "Lcoil/ComponentRegistry;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "Lcoil/util/ImageLoaderOptions;", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lcoil/util/SystemCallbacks;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "Lcoil/request/RequestService;", "requestService", "Lcoil/request/RequestService;", "components", "getComponents", "", "Lcoil/intercept/Interceptor;", "interceptors", "Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcoil/util/Logger;", "getLogger", "()Lcoil/util/Logger;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "memoryCache", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealImageLoader implements ImageLoader {
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* compiled from: RealImageLoader.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.RealImageLoader", f = "RealImageLoader.kt", l = {166, 178, pjsip_status_code.PJSIP_SC_QUEUED}, m = "executeMain")
    /* renamed from: coil.RealImageLoader$executeMain$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.executeMain(null, 0, this);
        }
    }

    public final Logger getLogger() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry;
        this.options = imageLoaderOptions;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this, context, imageLoaderOptions.getNetworkObserverEnabled());
        this.systemCallbacks = systemCallbacks;
        RequestService requestService = new RequestService(this, systemCallbacks, null);
        this.requestService = requestService;
        this.components = componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(imageLoaderOptions.getBitmapFactoryMaxParallelism(), imageLoaderOptions.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().getInterceptors(), new EngineInterceptor(this, requestService, null));
        this.shutdown = new AtomicBoolean(false);
        systemCallbacks.register();
    }

    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        Deferred<? extends ImageResult> deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        if (request.getTarget() instanceof ViewTarget) {
            return Utils.getRequestManager(((ViewTarget) request.getTarget()).getView()).getDisposable(deferredAsync$default);
        }
        return new OneShotDisposable(deferredAsync$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0137 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190 A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:72:0x018a, B:74:0x0190, B:75:0x019b, B:77:0x019f), top: B:101:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019b A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:72:0x018a, B:74:0x0190, B:75:0x019b, B:77:0x019f), top: B:101:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b7 A[Catch: all -> 0x01c8, TRY_LEAVE, TryCatch #3 {all -> 0x01c8, blocks: (B:82:0x01b3, B:84:0x01b7, B:89:0x01ca, B:90:0x01cd), top: B:99:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ca A[Catch: all -> 0x01c8, TRY_ENTER, TryCatch #3 {all -> 0x01c8, blocks: (B:82:0x01b3, B:84:0x01b7, B:89:0x01ca, B:90:0x01cd), top: B:99:0x01b3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeMain(coil.request.ImageRequest r21, int r22, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r23) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.executeMain(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onTrimMemory$coil_base_release(int level) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void onSuccess(coil.request.SuccessResult r4, coil.target.Target r5, coil.EventListener r6) {
        /*
            r3 = this;
            coil.request.ImageRequest r0 = r4.getRequest()
            r4.getDataSource()
            boolean r1 = r5 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto Le
            if (r5 == 0) goto L3a
            goto L21
        Le:
            coil.request.ImageRequest r1 = r4.getRequest()
            coil.transition.Transition$Factory r1 = r1.getTransitionFactory()
            r2 = r5
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.create(r2, r4)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L29
        L21:
            android.graphics.drawable.Drawable r1 = r4.getDrawable()
            r5.onSuccess(r1)
            goto L3a
        L29:
            coil.request.ImageRequest r5 = r4.getRequest()
            r6.transitionStart(r5, r1)
            r1.transition()
            coil.request.ImageRequest r5 = r4.getRequest()
            r6.transitionEnd(r5, r1)
        L3a:
            r6.onSuccess(r0, r4)
            coil.request.ImageRequest$Listener r5 = r0.getListener()
            if (r5 == 0) goto L46
            r5.onSuccess(r0, r4)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onSuccess(coil.request.SuccessResult, coil.target.Target, coil.EventListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void onError(coil.request.ErrorResult r4, coil.target.Target r5, coil.EventListener r6) {
        /*
            r3 = this;
            coil.request.ImageRequest r0 = r4.getRequest()
            boolean r1 = r5 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto Lb
            if (r5 == 0) goto L37
            goto L1e
        Lb:
            coil.request.ImageRequest r1 = r4.getRequest()
            coil.transition.Transition$Factory r1 = r1.getTransitionFactory()
            r2 = r5
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.create(r2, r4)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L26
        L1e:
            android.graphics.drawable.Drawable r1 = r4.getDrawable()
            r5.onError(r1)
            goto L37
        L26:
            coil.request.ImageRequest r5 = r4.getRequest()
            r6.transitionStart(r5, r1)
            r1.transition()
            coil.request.ImageRequest r5 = r4.getRequest()
            r6.transitionEnd(r5, r1)
        L37:
            r6.onError(r0, r4)
            coil.request.ImageRequest$Listener r5 = r0.getListener()
            if (r5 == 0) goto L43
            r5.onError(r0, r4)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onError(coil.request.ErrorResult, coil.target.Target, coil.EventListener):void");
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }
}
