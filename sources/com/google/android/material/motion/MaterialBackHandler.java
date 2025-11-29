package com.google.android.material.motion;

import androidx.view.BackEventCompat;

/* loaded from: classes2.dex */
public interface MaterialBackHandler {
    void cancelBackProgress();

    void handleBackInvoked();

    void startBackProgress(BackEventCompat backEventCompat);

    void updateBackProgress(BackEventCompat backEventCompat);
}
