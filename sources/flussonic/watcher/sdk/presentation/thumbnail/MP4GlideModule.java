package flussonic.watcher.sdk.presentation.thumbnail;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.module.LibraryGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.flussonic.ffmpegglidevideodecoder.FFmpegVideoDecoder;
import java.util.Map;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class MP4GlideModule extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Timber.d("MP4GlideModule >>> registerComponents called %s", FFmpegVideoDecoder.class.getName());
        glide.getRegistry().append("Bitmap", Uri.class, Bitmap.class, new FFmpegVideoDecoder(glide.getBitmapPool()));
        super.registerComponents(context, glide, registry);
    }

    static RequestOptions requestOptions(String cacheKey, String url) {
        return requestOptions(cacheKey, url, true);
    }

    static RequestOptions requestOptions(String cacheKey, String url, boolean cacheEnabled) {
        if (cacheKey == null) {
            cacheKey = String.valueOf(System.currentTimeMillis() / 3600000);
        }
        return new RequestOptions().set(FFmpegVideoDecoder.INSTANCE.getFRAME_AT_TIME(), -1L).dontAnimate().format(DecodeFormat.PREFER_RGB_565).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).timeout(15000).signature(new ObjectKey(cacheKey)).fitCenter().skipMemoryCache(!cacheEnabled);
    }

    public static Headers mapToHeaders(Map<String, ? super String> headersMap) {
        if (headersMap == null || headersMap.isEmpty()) {
            return null;
        }
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (String str : headersMap.keySet()) {
            String str2 = headersMap.get(str);
            if (str2 instanceof String) {
                builder.addHeader(str, str2);
            }
        }
        return builder.build();
    }
}
