package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.content.CacheResponse;
import coil.content.CacheStrategy;
import coil.content.Utils;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.request.Options;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* compiled from: HttpUriFetcher.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0016H\u0002J\f\u0010-\u001a\u00020.*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "response", "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpUriFetcher implements Fetcher {
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {224}, m = "executeNetworkRequest")
    /* renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {77, 106}, m = "fetch")
    /* renamed from: coil.fetch.HttpUriFetcher$fetch$1, reason: invalid class name and case insensitive filesystem */
    static final class C05741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C05741(Continuation<? super C05741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x012c A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:72:0x0188, B:54:0x011e, B:56:0x012c, B:58:0x013a, B:61:0x0143, B:63:0x014d, B:65:0x0155, B:67:0x016d), top: B:81:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:72:0x0188, B:54:0x011e, B:56:0x012c, B:58:0x013a, B:61:0x0143, B:63:0x014d, B:65:0x0155, B:67:0x016d), top: B:81:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetch(kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.fetch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2 A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010c A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final coil.disk.DiskCache.Snapshot writeToDiskCache(coil.disk.DiskCache.Snapshot r6, okhttp3.Request r7, okhttp3.Response r8, coil.content.CacheResponse r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.writeToDiskCache(coil.disk.DiskCache$Snapshot, okhttp3.Request, okhttp3.Response, coil.network.CacheResponse):coil.disk.DiskCache$Snapshot");
    }

    private final Request newRequest() {
        Request.Builder builderHeaders = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                builderHeaders.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return builderHeaders.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeNetworkRequest(okhttp3.Request r5, kotlin.coroutines.Continuation<? super okhttp3.Response> r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil.fetch.HttpUriFetcher.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = (coil.fetch.HttpUriFetcher.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = new coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L72
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = coil.content.Utils.isMainThread()
            if (r6 == 0) goto L5d
            coil.request.Options r6 = r4.options
            coil.request.CachePolicy r6 = r6.getNetworkCachePolicy()
            boolean r6 = r6.getReadEnabled()
            if (r6 != 0) goto L57
            kotlin.Lazy<okhttp3.Call$Factory> r6 = r4.callFactory
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.newCall(r5)
            okhttp3.Response r5 = r5.execute()
            goto L75
        L57:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L5d:
            kotlin.Lazy<okhttp3.Call$Factory> r6 = r4.callFactory
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.newCall(r5)
            r0.label = r3
            java.lang.Object r6 = coil.content.Calls.await(r5, r0)
            if (r6 != r1) goto L72
            return r1
        L72:
            r5 = r6
            okhttp3.Response r5 = (okhttp3.Response) r5
        L75:
            boolean r6 = r5.isSuccessful()
            if (r6 != 0) goto L92
            int r6 = r5.code()
            r0 = 304(0x130, float:4.26E-43)
            if (r6 == r0) goto L92
            okhttp3.ResponseBody r6 = r5.body()
            if (r6 == 0) goto L8c
            coil.content.Utils.closeQuietly(r6)
        L8c:
            coil.network.HttpException r6 = new coil.network.HttpException
            r6.<init>(r5)
            throw r6
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.executeNetworkRequest(okhttp3.Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || StringsKt.startsWith$default(mediaType, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    private final boolean isCacheable(Request request, Response response) {
        return this.options.getDiskCachePolicy().getWriteEnabled() && (!this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response));
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                cacheResponse = null;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException unused) {
            return null;
        }
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getBodySource(), this.options.getContext());
    }

    private final DataSource toDataSource(Response response) {
        return response.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    /* compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", RemoteMessageConst.DATA, "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z;
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), "https");
        }
    }
}
