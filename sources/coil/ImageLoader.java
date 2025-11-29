package coil;

import android.content.Context;
import coil.EventListener;
import coil.content.ImageLoaderOptions;
import coil.content.Requests;
import coil.content.SingletonDiskCache;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* compiled from: ImageLoader.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcoil/ImageLoader;", "", "Lcoil/request/ImageRequest;", "request", "Lcoil/request/Disposable;", "enqueue", "(Lcoil/request/ImageRequest;)Lcoil/request/Disposable;", "Lcoil/ComponentRegistry;", "getComponents", "()Lcoil/ComponentRegistry;", "components", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "memoryCache", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ImageLoader {
    Disposable enqueue(ImageRequest request);

    ComponentRegistry getComponents();

    MemoryCache getMemoryCache();

    /* compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcoil/ImageLoader$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "Lokhttp3/OkHttpClient;", "initializer", "okHttpClient", "(Lkotlin/jvm/functions/Function0;)Lcoil/ImageLoader$Builder;", "Lokhttp3/Call$Factory;", "callFactory", "Lcoil/ComponentRegistry;", "components", "(Lcoil/ComponentRegistry;)Lcoil/ImageLoader$Builder;", "Lcoil/ImageLoader;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcoil/ImageLoader;", "applicationContext", "Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "memoryCache", "Lkotlin/Lazy;", "Lcoil/disk/DiskCache;", "diskCache", "Lcoil/EventListener$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "Lcoil/util/ImageLoaderOptions;", "options", "Lcoil/util/ImageLoaderOptions;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final Context applicationContext;
        private DefaultRequestOptions defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
        private Lazy<? extends MemoryCache> memoryCache = null;
        private Lazy<? extends DiskCache> diskCache = null;
        private Lazy<? extends Call.Factory> callFactory = null;
        private EventListener.Factory eventListenerFactory = null;
        private ComponentRegistry componentRegistry = null;
        private ImageLoaderOptions options = new ImageLoaderOptions(false, false, false, 0, null, 31, null);

        public Builder(Context context) {
            this.applicationContext = context.getApplicationContext();
        }

        public final Builder okHttpClient(Function0<? extends OkHttpClient> initializer) {
            return callFactory(initializer);
        }

        public final Builder callFactory(Function0<? extends Call.Factory> initializer) {
            this.callFactory = LazyKt.lazy(initializer);
            return this;
        }

        public final Builder components(ComponentRegistry components) {
            this.componentRegistry = components;
            return this;
        }

        public final ImageLoader build() {
            Context context = this.applicationContext;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Lazy<? extends MemoryCache> lazy = this.memoryCache;
            if (lazy == null) {
                lazy = LazyKt.lazy(new Function0<MemoryCache>() { // from class: coil.ImageLoader$Builder$build$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MemoryCache invoke() {
                        return new MemoryCache.Builder(this.this$0.applicationContext).build();
                    }
                });
            }
            Lazy<? extends MemoryCache> lazy2 = lazy;
            Lazy<? extends DiskCache> lazy3 = this.diskCache;
            if (lazy3 == null) {
                lazy3 = LazyKt.lazy(new Function0<DiskCache>() { // from class: coil.ImageLoader$Builder$build$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiskCache invoke() {
                        return SingletonDiskCache.INSTANCE.get(this.this$0.applicationContext);
                    }
                });
            }
            Lazy<? extends DiskCache> lazy4 = lazy3;
            Lazy<? extends Call.Factory> lazy5 = this.callFactory;
            if (lazy5 == null) {
                lazy5 = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: coil.ImageLoader$Builder$build$3
                    @Override // kotlin.jvm.functions.Function0
                    public final OkHttpClient invoke() {
                        return new OkHttpClient();
                    }
                });
            }
            Lazy<? extends Call.Factory> lazy6 = lazy5;
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            EventListener.Factory factory2 = factory;
            ComponentRegistry componentRegistry = this.componentRegistry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, lazy2, lazy4, lazy6, factory2, componentRegistry, this.options, null);
        }
    }
}
