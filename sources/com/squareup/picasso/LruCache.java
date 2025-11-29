package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public final class LruCache implements Cache {
    final android.util.LruCache<String, BitmapAndSize> cache;

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public LruCache(int i) {
        this.cache = new android.util.LruCache<String, BitmapAndSize>(i) { // from class: com.squareup.picasso.LruCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.byteCount;
            }
        };
    }

    @Override // com.squareup.picasso.Cache
    public Bitmap get(String str) {
        BitmapAndSize bitmapAndSize = this.cache.get(str);
        if (bitmapAndSize != null) {
            return bitmapAndSize.bitmap;
        }
        return null;
    }

    @Override // com.squareup.picasso.Cache
    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        if (bitmapBytes > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, new BitmapAndSize(bitmap, bitmapBytes));
        }
    }

    @Override // com.squareup.picasso.Cache
    public int size() {
        return this.cache.size();
    }

    @Override // com.squareup.picasso.Cache
    public int maxSize() {
        return this.cache.maxSize();
    }

    static final class BitmapAndSize {
        final Bitmap bitmap;
        final int byteCount;

        BitmapAndSize(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.byteCount = i;
        }
    }
}
