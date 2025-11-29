package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.Logger;
import coil.content.Requests;
import coil.content.Utils;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MemoryCacheService.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010!\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b \u0010\u0016J'\u0010$\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J-\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0018\u0010-\u001a\u00020\u0014*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u00102\u001a\u0004\u0018\u00010/*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcoil/memory/MemoryCacheService;", "", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/request/RequestService;", "requestService", "Lcoil/util/Logger;", "logger", "<init>", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "Lcoil/request/ImageRequest;", "request", "Lcoil/memory/MemoryCache$Key;", "cacheKey", "Lcoil/memory/MemoryCache$Value;", "cacheValue", "Lcoil/size/Size;", "size", "Lcoil/size/Scale;", "scale", "", "isSizeValid", "(Lcoil/request/ImageRequest;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Value;Lcoil/size/Size;Lcoil/size/Scale;)Z", "mappedData", "Lcoil/request/Options;", "options", "Lcoil/EventListener;", "eventListener", "newCacheKey", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;)Lcoil/memory/MemoryCache$Key;", "getCacheValue", "(Lcoil/request/ImageRequest;Lcoil/memory/MemoryCache$Key;Lcoil/size/Size;Lcoil/size/Scale;)Lcoil/memory/MemoryCache$Value;", "isCacheValueValid$coil_base_release", "isCacheValueValid", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "result", "setCacheValue", "(Lcoil/memory/MemoryCache$Key;Lcoil/request/ImageRequest;Lcoil/intercept/EngineInterceptor$ExecuteResult;)Z", "Lcoil/intercept/Interceptor$Chain;", "chain", "Lcoil/request/SuccessResult;", "newResult", "(Lcoil/intercept/Interceptor$Chain;Lcoil/request/ImageRequest;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Value;)Lcoil/request/SuccessResult;", "Lcoil/ImageLoader;", "Lcoil/request/RequestService;", "isSampled", "(Lcoil/memory/MemoryCache$Value;)Z", "", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "diskCacheKey", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryCacheService {
    private final ImageLoader imageLoader;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest request, Object mappedData, Options options, EventListener eventListener) {
        MemoryCache.Key memoryCacheKey = request.getMemoryCacheKey();
        if (memoryCacheKey != null) {
            return memoryCacheKey;
        }
        eventListener.keyStart(request, mappedData);
        String strKey = this.imageLoader.getComponents().key(mappedData, options);
        eventListener.keyEnd(request, strKey);
        if (strKey == null) {
            return null;
        }
        List<Transformation> transformations = request.getTransformations();
        Map<String, String> mapMemoryCacheKeys = request.getParameters().memoryCacheKeys();
        if (transformations.isEmpty() && mapMemoryCacheKeys.isEmpty()) {
            return new MemoryCache.Key(strKey, null, 2, null);
        }
        Map mutableMap = MapsKt.toMutableMap(mapMemoryCacheKeys);
        if (!transformations.isEmpty()) {
            List<Transformation> transformations2 = request.getTransformations();
            int size = transformations2.size();
            for (int i = 0; i < size; i++) {
                mutableMap.put("coil#transformation_" + i, transformations2.get(i).getCacheKey());
            }
            mutableMap.put("coil#transformation_size", options.getSize().toString());
        }
        return new MemoryCache.Key(strKey, mutableMap);
    }

    public final MemoryCache.Value getCacheValue(ImageRequest request, MemoryCache.Key cacheKey, Size size, Scale scale) {
        if (!request.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(cacheKey) : null;
        if (value == null || !isCacheValueValid$coil_base_release(request, cacheKey, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        if (this.requestService.isConfigValidForHardware(request, Bitmaps.getSafeConfig(cacheValue.getBitmap()))) {
            return isSizeValid(request, cacheKey, cacheValue, size, scale);
        }
        return false;
    }

    private final boolean isSizeValid(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        boolean zIsSampled = isSampled(cacheValue);
        if (Sizes.isOriginal(size)) {
            return !zIsSampled;
        }
        String str = cacheKey.getExtras().get("coil#transformation_size");
        if (str != null) {
            return Intrinsics.areEqual(str, size.toString());
        }
        int width = cacheValue.getBitmap().getWidth();
        int height = cacheValue.getBitmap().getHeight();
        Dimension width2 = size.getWidth();
        int i = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : Integer.MAX_VALUE;
        Dimension height2 = size.getHeight();
        int i2 = height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).px : Integer.MAX_VALUE;
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i, i2, scale);
        boolean allowInexactSize = Requests.getAllowInexactSize(request);
        if (allowInexactSize) {
            double dCoerceAtMost = RangesKt.coerceAtMost(dComputeSizeMultiplier, 1.0d);
            if (Math.abs(i - (width * dCoerceAtMost)) <= 1.0d || Math.abs(i2 - (dCoerceAtMost * height)) <= 1.0d) {
                return true;
            }
        } else if ((Utils.isMinOrMax(i) || Math.abs(i - width) <= 1) && (Utils.isMinOrMax(i2) || Math.abs(i2 - height) <= 1)) {
            return true;
        }
        if (dComputeSizeMultiplier == 1.0d || allowInexactSize) {
            return dComputeSizeMultiplier <= 1.0d || !zIsSampled;
        }
        return false;
    }

    public final boolean setCacheValue(MemoryCache.Key cacheKey, ImageRequest request, EngineInterceptor.ExecuteResult result) {
        MemoryCache memoryCache;
        Bitmap bitmap;
        if (request.getMemoryCachePolicy().getWriteEnabled() && (memoryCache = this.imageLoader.getMemoryCache()) != null && cacheKey != null) {
            Drawable drawable = result.getDrawable();
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(result.getIsSampled()));
                String diskCacheKey = result.getDiskCacheKey();
                if (diskCacheKey != null) {
                    linkedHashMap.put("coil#disk_cache_key", diskCacheKey);
                }
                memoryCache.set(cacheKey, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue) {
        return new SuccessResult(new BitmapDrawable(request.getContext().getResources(), cacheValue.getBitmap()), request, DataSource.MEMORY_CACHE, cacheKey, getDiskCacheKey(cacheValue), isSampled(cacheValue), Utils.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
