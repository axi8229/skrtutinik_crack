package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil.content.C0578Contexts;
import coil.content.Requests;
import coil.content.Utils;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import coil.size.ViewSizeResolver;
import coil.size.ViewSizeResolvers;
import coil.target.ImageViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import coil.transition.Transition;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004\u008c\u0001\u008d\u0001Bõ\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\b\u00108\u001a\u0004\u0018\u00010\n\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\u0010=\u001a\u0004\u0018\u00010:\u0012\b\u0010>\u001a\u0004\u0018\u00010<\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\b\u0010@\u001a\u0004\u0018\u00010<\u0012\u0006\u0010A\u001a\u00020B\u0012\u0006\u0010C\u001a\u00020D¢\u0006\u0002\u0010EJ\u0015\u0010\u0087\u0001\u001a\u00020#2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0089\u0001\u001a\u00020:H\u0016J\u0014\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010$\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010GR\u0011\u0010%\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bI\u0010GR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010.\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010C\u001a\u00020D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010)\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0010\u0010>\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bc\u0010`R\u0010\u0010@\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010-\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bd\u0010SR'\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bi\u0010SR\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bp\u0010]R\u0011\u0010*\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bq\u0010]R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010t\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bu\u0010`R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u00108\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bv\u0010oR\u0012\u00109\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u0010&\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\by\u0010GR\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010/\u001a\u00020,¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010SR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0013\u0010\u001c\u001a\u00020\u001d¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", RemoteMessageConst.DATA, "target", "Lcoil/target/Target;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "diskCacheKey", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "precision", "Lcoil/size/Precision;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "transformations", "", "Lcoil/transform/Transformation;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "headers", "Lokhttp3/Headers;", "tags", "Lcoil/request/Tags;", "allowConversionToBitmap", "", "allowHardware", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "parameters", "Lcoil/request/Parameters;", "placeholderMemoryCacheKey", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/Decoder$Factory;Ljava/util/List;Lcoil/transition/Transition$Factory;Lokhttp3/Headers;Lcoil/request/Tags;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lcoil/request/Parameters;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDecoderFactory", "()Lcoil/decode/Decoder$Factory;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCacheKey", "()Ljava/lang/String;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcherDispatcher", "getFetcherFactory", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getInterceptorDispatcher", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTags", "()Lcoil/request/Tags;", "getTarget", "()Lcoil/target/Target;", "getTransformationDispatcher", "getTransformations", "()Ljava/util/List;", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "equals", "other", "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "Builder", "Listener", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final CoroutineDispatcher decoderDispatcher;
    private final Decoder.Factory decoderFactory;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Drawable errorDrawable;
    private final Integer errorResId;
    private final Drawable fallbackDrawable;
    private final Integer fallbackResId;
    private final CoroutineDispatcher fetcherDispatcher;
    private final Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory;
    private final Headers headers;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Tags tags;
    private final Target target;
    private final CoroutineDispatcher transformationDispatcher;
    private final List<Transformation> transformations;
    private final Transition.Factory transitionFactory;

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        default void onCancel(ImageRequest request) {
        }

        default void onError(ImageRequest request, ErrorResult result) {
        }

        default void onStart(ImageRequest request) {
        }

        default void onSuccess(ImageRequest request, SuccessResult result) {
        }
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, key, str, config, colorSpace, precision, pair, factory, list, factory2, headers, tags, z, z2, z3, z4, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, parameters, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair, Decoder.Factory factory, List<? extends Transformation> list, Transition.Factory factory2, Headers headers, Tags tags, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.bitmapConfig = config;
        this.colorSpace = colorSpace;
        this.precision = precision;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.transformations = list;
        this.transitionFactory = factory2;
        this.headers = headers;
        this.tags = tags;
        this.allowConversionToBitmap = z;
        this.allowHardware = z2;
        this.allowRgb565 = z3;
        this.premultipliedAlpha = z4;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.lifecycle = lifecycle;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.parameters = parameters;
        this.placeholderMemoryCacheKey = key2;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Pair<Fetcher.Factory<?>, Class<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final List<Transformation> getTransformations() {
        return this.transformations;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    public final Builder newBuilder(Context context) {
        return new Builder(this, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) other;
            if (Intrinsics.areEqual(this.context, imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && Intrinsics.areEqual(this.listener, imageRequest.listener) && Intrinsics.areEqual(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && this.bitmapConfig == imageRequest.bitmapConfig && ((Build.VERSION.SDK_INT < 26 || Intrinsics.areEqual(this.colorSpace, imageRequest.colorSpace)) && this.precision == imageRequest.precision && Intrinsics.areEqual(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.areEqual(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.areEqual(this.transformations, imageRequest.transformations) && Intrinsics.areEqual(this.transitionFactory, imageRequest.transitionFactory) && Intrinsics.areEqual(this.headers, imageRequest.headers) && Intrinsics.areEqual(this.tags, imageRequest.tags) && this.allowConversionToBitmap == imageRequest.allowConversionToBitmap && this.allowHardware == imageRequest.allowHardware && this.allowRgb565 == imageRequest.allowRgb565 && this.premultipliedAlpha == imageRequest.premultipliedAlpha && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.interceptorDispatcher, imageRequest.interceptorDispatcher) && Intrinsics.areEqual(this.fetcherDispatcher, imageRequest.fetcherDispatcher) && Intrinsics.areEqual(this.decoderDispatcher, imageRequest.decoderDispatcher) && Intrinsics.areEqual(this.transformationDispatcher, imageRequest.transformationDispatcher) && Intrinsics.areEqual(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual(this.placeholderResId, imageRequest.placeholderResId) && Intrinsics.areEqual(this.placeholderDrawable, imageRequest.placeholderDrawable) && Intrinsics.areEqual(this.errorResId, imageRequest.errorResId) && Intrinsics.areEqual(this.errorDrawable, imageRequest.errorDrawable) && Intrinsics.areEqual(this.fallbackResId, imageRequest.fallbackResId) && Intrinsics.areEqual(this.fallbackDrawable, imageRequest.fallbackDrawable) && Intrinsics.areEqual(this.lifecycle, imageRequest.lifecycle) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && Intrinsics.areEqual(this.parameters, imageRequest.parameters) && Intrinsics.areEqual(this.defined, imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target = this.target;
        int iHashCode2 = (iHashCode + (target != null ? target.hashCode() : 0)) * 31;
        Listener listener = this.listener;
        int iHashCode3 = (iHashCode2 + (listener != null ? listener.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode4 = (iHashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.precision.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, Class<?>> pair = this.fetcherFactory;
        int iHashCode7 = (iHashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (factory != null ? factory.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int iHashCode9 = (iHashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.placeholderResId;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R,\u0010=\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030;\u0012\b\u0012\u0006\u0012\u0002\b\u00030<\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR(\u0010M\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030<\u0012\u0004\u0012\u00020\u0001\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010SR\u0016\u0010U\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010QR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010-R\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bk\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010gR\u0018\u0010n\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010q\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010pR\u0018\u0010v\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010t¨\u0006x"}, d2 = {"Lcoil/request/ImageRequest$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcoil/request/ImageRequest;", "request", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "", "resetResolvedValues", "()V", "resetResolvedScale", "Landroidx/lifecycle/Lifecycle;", "resolveLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcoil/size/SizeResolver;", "resolveSizeResolver", "()Lcoil/size/SizeResolver;", "Lcoil/size/Scale;", "resolveScale", "()Lcoil/size/Scale;", RemoteMessageConst.DATA, "(Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "Lcoil/request/ImageRequest$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcoil/request/ImageRequest$Listener;)Lcoil/request/ImageRequest$Builder;", "Landroid/widget/ImageView;", "imageView", "target", "(Landroid/widget/ImageView;)Lcoil/request/ImageRequest$Builder;", "Lcoil/target/Target;", "(Lcoil/target/Target;)Lcoil/request/ImageRequest$Builder;", "Lcoil/request/DefaultRequestOptions;", "defaults", "(Lcoil/request/DefaultRequestOptions;)Lcoil/request/ImageRequest$Builder;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcoil/request/ImageRequest;", "Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "Ljava/lang/Object;", "Lcoil/target/Target;", "Lcoil/request/ImageRequest$Listener;", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "", "diskCacheKey", "Ljava/lang/String;", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "Landroid/graphics/ColorSpace;", "colorSpace", "Landroid/graphics/ColorSpace;", "Lcoil/size/Precision;", "precision", "Lcoil/size/Precision;", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/decode/Decoder$Factory;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "", "Lcoil/transform/Transformation;", "transformations", "Ljava/util/List;", "Lcoil/transition/Transition$Factory;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "Lokhttp3/Headers$Builder;", "headers", "Lokhttp3/Headers$Builder;", "", "tags", "Ljava/util/Map;", "", "allowConversionToBitmap", "Z", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "Lcoil/request/Parameters$Builder;", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderMemoryCacheKey", "", "placeholderResId", "Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "resolvedLifecycle", "resolvedSizeResolver", "resolvedScale", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private boolean allowConversionToBitmap;
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private CoroutineDispatcher decoderDispatcher;
        private Decoder.Factory decoderFactory;
        private DefaultRequestOptions defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private CoroutineDispatcher fetcherDispatcher;
        private Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> fetcherFactory;
        private Headers.Builder headers;
        private CoroutineDispatcher interceptorDispatcher;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Map<Class<?>, Object> tags;
        private Target target;
        private CoroutineDispatcher transformationDispatcher;
        private List<? extends Transformation> transformations;
        private Transition.Factory transitionFactory;

        public Builder(Context context) {
            this.context = context;
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = null;
            }
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = CollectionsKt.emptyList();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = imageRequest.getColorSpace();
            }
            this.precision = imageRequest.getDefined().getPrecision();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.transformations = imageRequest.getTransformations();
            this.transitionFactory = imageRequest.getDefined().getTransitionFactory();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.tags = MapsKt.toMutableMap(imageRequest.getTags().asMap());
            this.allowConversionToBitmap = imageRequest.getAllowConversionToBitmap();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = imageRequest.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = imageRequest.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = imageRequest.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = imageRequest.getDefined().getTransformationDispatcher();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            if (imageRequest.getContext() == context) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
            } else {
                this.resolvedLifecycle = null;
                this.resolvedSizeResolver = null;
                this.resolvedScale = null;
            }
        }

        public final Builder data(Object data) {
            this.data = data;
            return this;
        }

        public final Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder target(ImageView imageView) {
            return target(new ImageViewTarget(imageView));
        }

        public final Builder target(Target target) {
            this.target = target;
            resetResolvedValues();
            return this;
        }

        public final Builder defaults(DefaultRequestOptions defaults) {
            this.defaults = defaults;
            resetResolvedScale();
            return this;
        }

        public final ImageRequest build() {
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            String str = this.diskCacheKey;
            Bitmap.Config bitmapConfig = this.bitmapConfig;
            if (bitmapConfig == null) {
                bitmapConfig = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config = bitmapConfig;
            ColorSpace colorSpace = this.colorSpace;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            List<? extends Transformation> list = this.transformations;
            Transition.Factory transitionFactory = this.transitionFactory;
            if (transitionFactory == null) {
                transitionFactory = this.defaults.getTransitionFactory();
            }
            Transition.Factory factory2 = transitionFactory;
            Headers.Builder builder = this.headers;
            Headers headersOrEmpty = Utils.orEmpty(builder != null ? builder.build() : null);
            Map<Class<?>, ? extends Object> map = this.tags;
            Tags tagsOrEmpty = Utils.orEmpty(map != null ? Tags.INSTANCE.from(map) : null);
            boolean z = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z2 = this.premultipliedAlpha;
            CachePolicy memoryCachePolicy = this.memoryCachePolicy;
            if (memoryCachePolicy == null) {
                memoryCachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy = memoryCachePolicy;
            CachePolicy diskCachePolicy = this.diskCachePolicy;
            if (diskCachePolicy == null) {
                diskCachePolicy = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy2 = diskCachePolicy;
            CachePolicy networkCachePolicy = this.networkCachePolicy;
            if (networkCachePolicy == null) {
                networkCachePolicy = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy3 = networkCachePolicy;
            CoroutineDispatcher interceptorDispatcher = this.interceptorDispatcher;
            if (interceptorDispatcher == null) {
                interceptorDispatcher = this.defaults.getInterceptorDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher = interceptorDispatcher;
            CoroutineDispatcher fetcherDispatcher = this.fetcherDispatcher;
            if (fetcherDispatcher == null) {
                fetcherDispatcher = this.defaults.getFetcherDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = fetcherDispatcher;
            CoroutineDispatcher decoderDispatcher = this.decoderDispatcher;
            if (decoderDispatcher == null) {
                decoderDispatcher = this.defaults.getDecoderDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher3 = decoderDispatcher;
            CoroutineDispatcher transformationDispatcher = this.transformationDispatcher;
            if (transformationDispatcher == null) {
                transformationDispatcher = this.defaults.getTransformationDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher4 = transformationDispatcher;
            Lifecycle lifecycleResolveLifecycle = this.lifecycle;
            if (lifecycleResolveLifecycle == null && (lifecycleResolveLifecycle = this.resolvedLifecycle) == null) {
                lifecycleResolveLifecycle = resolveLifecycle();
            }
            Lifecycle lifecycle = lifecycleResolveLifecycle;
            SizeResolver sizeResolverResolveSizeResolver = this.sizeResolver;
            if (sizeResolverResolveSizeResolver == null && (sizeResolverResolveSizeResolver = this.resolvedSizeResolver) == null) {
                sizeResolverResolveSizeResolver = resolveSizeResolver();
            }
            SizeResolver sizeResolver = sizeResolverResolveSizeResolver;
            Scale scaleResolveScale = this.scale;
            if (scaleResolveScale == null && (scaleResolveScale = this.resolvedScale) == null) {
                scaleResolveScale = resolveScale();
            }
            Scale scale = scaleResolveScale;
            Parameters.Builder builder2 = this.parameters;
            return new ImageRequest(context, obj2, target, listener, key, str, config, colorSpace, precision2, pair, factory, list, factory2, headersOrEmpty, tagsOrEmpty, z, zBooleanValue, zBooleanValue2, z2, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, Utils.orEmpty(builder2 != null ? builder2.build() : null), this.placeholderMemoryCacheKey, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy), this.defaults, null);
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Target target = this.target;
            Lifecycle lifecycle = C0578Contexts.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : this.context);
            return lifecycle == null ? GlobalLifecycle.INSTANCE : lifecycle;
        }

        private final SizeResolver resolveSizeResolver() {
            ImageView.ScaleType scaleType;
            Target target = this.target;
            if (target instanceof ViewTarget) {
                View view = ((ViewTarget) target).getView();
                if ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                    return SizeResolvers.create(Size.ORIGINAL);
                }
                return ViewSizeResolvers.create$default(view, false, 2, null);
            }
            return new DisplaySizeResolver(this.context);
        }

        private final Scale resolveScale() {
            View view;
            SizeResolver sizeResolver = this.sizeResolver;
            View view2 = null;
            ViewSizeResolver viewSizeResolver = sizeResolver instanceof ViewSizeResolver ? (ViewSizeResolver) sizeResolver : null;
            if (viewSizeResolver == null || (view = viewSizeResolver.getView()) == null) {
                Target target = this.target;
                ViewTarget viewTarget = target instanceof ViewTarget ? (ViewTarget) target : null;
                if (viewTarget != null) {
                    view2 = viewTarget.getView();
                }
            } else {
                view2 = view;
            }
            if (view2 instanceof ImageView) {
                return Utils.getScale((ImageView) view2);
            }
            return Scale.FIT;
        }
    }
}
