package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes2.dex */
final class zzly extends zzlv {
    zzly() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzd() {
        if (!zze()) {
            for (int i = 0; i < zza(); i++) {
                Map.Entry entryZza = zza(i);
                if (((zzjo) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry entry : zzb()) {
                if (((zzjo) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzd();
    }
}
