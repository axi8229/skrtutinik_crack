package com.squareup.picasso;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface Cache {
    Bitmap get(String str);

    int maxSize();

    void set(String str, Bitmap bitmap);

    int size();
}
