package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

@Deprecated
/* loaded from: classes.dex */
public final class BundleCompat {
    public static IBinder getBinder(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }
}
