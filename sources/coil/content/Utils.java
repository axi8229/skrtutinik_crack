package coil.content;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.EventListener;
import coil.base.R$id;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.request.Parameters;
import coil.request.Tags;
import coil.request.ViewTargetRequestManager;
import coil.size.Dimension;
import coil.size.Scale;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\n\u001a\u00020\f*\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\n\u0010\r\u001a\u0015\u0010\n\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\n\u0010\u000f\u001a\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0015\u001a\u00020\u0013*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\u0010*\u00020\u0013H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001f\u001a\u00020\u0013*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010'\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0000¢\u0006\u0004\b'\u0010(\u001a\u0013\u0010+\u001a\u00020**\u00020)H\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00103\u001a\u00020\u00132\u0006\u0010.\u001a\u00020-2\u0006\u00102\u001a\u00020/H\u0000¢\u0006\u0004\b3\u00104\" \u00107\u001a\b\u0012\u0004\u0012\u000206058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u001a\u0010;\u001a\u0002068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u001a\u0010?\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0018\u0010G\u001a\u00020D*\u00020C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\"\u0018\u0010K\u001a\u00020\u0013*\u00020H8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J\"\u0018\u0010M\u001a\u00020\u0013*\u00020H8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010J\"\u0018\u0010N\u001a\u00020\u0010*\u00020H8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O\"\u0018\u0010\u001e\u001a\u00020\u001d*\u00020P8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R\"\u001a\u0010U\u001a\u0004\u0018\u00010\u0005*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0018\u0010Y\u001a\u00020\u0013*\u00020V8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010X\"\u0018\u0010]\u001a\u00020Z*\u00020-8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\\"\u0018\u0010_\u001a\u00020\u0010*\u00020^8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`\"\u0018\u0010d\u001a\u00020a*\u00020^8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006e"}, d2 = {"Ljava/io/Closeable;", "", "closeQuietly", "(Ljava/io/Closeable;)V", "Landroid/webkit/MimeTypeMap;", "", "url", "getMimeTypeFromUrl", "(Landroid/webkit/MimeTypeMap;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "orEmpty", "(Lokhttp3/Headers;)Lokhttp3/Headers;", "Lcoil/request/Tags;", "(Lcoil/request/Tags;)Lcoil/request/Tags;", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Lcoil/request/Parameters;", "", "isMainThread", "()Z", "", "defaultValue", "toNonNegativeInt", "(Ljava/lang/String;I)I", "Lcoil/disk/DiskCache$Editor;", "abortQuietly", "(Lcoil/disk/DiskCache$Editor;)V", "isMinOrMax", "(I)Z", "Lcoil/size/Dimension;", "Lcoil/size/Scale;", "scale", "toPx", "(Lcoil/size/Dimension;Lcoil/size/Scale;)I", "Landroid/net/Uri;", "uri", "isAssetUri", "(Landroid/net/Uri;)Z", "Lokhttp3/Headers$Builder;", "line", "addUnsafeNonAscii", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "Lokhttp3/Response;", "Lokhttp3/ResponseBody;", "requireBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "Landroid/content/Context;", "context", "", "defaultMemoryCacheSizePercent", "(Landroid/content/Context;)D", "percent", "calculateMemoryCacheSize", "(Landroid/content/Context;D)I", "", "Landroid/graphics/Bitmap$Config;", "VALID_TRANSFORMATION_CONFIGS", "[Landroid/graphics/Bitmap$Config;", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "Landroid/view/View;", "Lcoil/request/ViewTargetRequestManager;", "getRequestManager", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "requestManager", "Landroid/graphics/drawable/Drawable;", "getWidth", "(Landroid/graphics/drawable/Drawable;)I", "width", "getHeight", "height", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "firstPathSegment", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "nightMode", "Ljava/io/File;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "safeCacheDir", "Lcoil/intercept/Interceptor$Chain;", "isPlaceholderCached", "(Lcoil/intercept/Interceptor$Chain;)Z", "Lcoil/EventListener;", "getEventListener", "(Lcoil/intercept/Interceptor$Chain;)Lcoil/EventListener;", "eventListener", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Utils, reason: invalid class name */
/* loaded from: classes.dex */
public final class Utils {
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG;
    private static final Headers EMPTY_HEADERS;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS;

    /* compiled from: Utils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: coil.util.-Utils$WhenMappings */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            try {
                iArr3[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    public static final int calculateMemoryCacheSize(Context context, double d) {
        int largeMemoryClass;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        double d2 = 1024;
        return (int) (d * largeMemoryClass * d2 * d2);
    }

    public static final double defaultMemoryCacheSizePercent(Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final ViewTargetRequestManager getRequestManager(View view) {
        int i = R$id.coil_request_manager;
        Object tag = view.getTag(i);
        ViewTargetRequestManager viewTargetRequestManager = tag instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag : null;
        if (viewTargetRequestManager == null) {
            synchronized (view) {
                try {
                    Object tag2 = view.getTag(i);
                    ViewTargetRequestManager viewTargetRequestManager2 = tag2 instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag2 : null;
                    if (viewTargetRequestManager2 != null) {
                        viewTargetRequestManager = viewTargetRequestManager2;
                    } else {
                        viewTargetRequestManager = new ViewTargetRequestManager(view);
                        view.addOnAttachStateChangeListener(viewTargetRequestManager);
                        view.setTag(i, viewTargetRequestManager);
                    }
                } finally {
                }
            }
        }
        return viewTargetRequestManager;
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$2[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final boolean isVector(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final void closeQuietly(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Scale getScale(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', null, 2, null), '?', null, 2, null), JsonPointer.SEPARATOR, (String) null, 2, (Object) null), '.', ""));
    }

    public static final String getFirstPathSegment(Uri uri) {
        return (String) CollectionsKt.firstOrNull((List) uri.getPathSegments());
    }

    public static final int getNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    static {
        Bitmap.Config[] configArr;
        Bitmap.Config config;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};
        } else {
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        }
        VALID_TRANSFORMATION_CONFIGS = configArr;
        if (i >= 26) {
            config = Bitmap.Config.HARDWARE;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        DEFAULT_BITMAP_CONFIG = config;
        EMPTY_HEADERS = new Headers.Builder().build();
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final Headers orEmpty(Headers headers) {
        return headers == null ? EMPTY_HEADERS : headers;
    }

    public static final Tags orEmpty(Tags tags) {
        return tags == null ? Tags.EMPTY : tags;
    }

    public static final Parameters orEmpty(Parameters parameters) {
        return parameters == null ? Parameters.EMPTY : parameters;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final File getSafeCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null");
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final int toNonNegativeInt(String str, int i) {
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull == null) {
            return i;
        }
        long jLongValue = longOrNull.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).getIsPlaceholderCached();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual(getFirstPathSegment(uri), "android_asset");
    }

    public static final Headers.Builder addUnsafeNonAscii(Headers.Builder builder, String str) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String string = StringsKt.trim(strSubstring).toString();
        String strSubstring2 = str.substring(iIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        builder.addUnsafeNonAscii(string, strSubstring2);
        return builder;
    }

    public static final ResponseBody requireBody(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody;
        }
        throw new IllegalStateException("response body == null");
    }
}
