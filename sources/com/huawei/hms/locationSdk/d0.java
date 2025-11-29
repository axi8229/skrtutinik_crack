package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import java.util.Objects;

/* loaded from: classes3.dex */
public class d0 extends h0 {
    private PendingIntent b;

    public void a(PendingIntent pendingIntent) {
        this.b = pendingIntent;
    }

    @Override // com.huawei.hms.locationSdk.h0
    public boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (this == obj) {
            return true;
        }
        if (obj == null || d0.class != obj.getClass() || (pendingIntent = this.b) == null) {
            return false;
        }
        return pendingIntent.equals(((d0) obj).b);
    }

    public int hashCode() {
        return Objects.hash(this.b);
    }
}
