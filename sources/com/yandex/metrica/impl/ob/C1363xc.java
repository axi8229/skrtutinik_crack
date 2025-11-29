package com.yandex.metrica.impl.ob;

import android.location.Location;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.xc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1363xc extends AbstractC1305v2<Location> {
    public static final long d = TimeUnit.MINUTES.toMillis(2);
    public static final List<String> e = Arrays.asList("gps", "network");
    private a c;

    /* renamed from: com.yandex.metrica.impl.ob.xc$a */
    public static class a {
        public final long a;

        public a(long j, long j2, long j3) {
            this.a = j;
        }
    }

    public C1363xc(Ph ph) {
        this(new a(d, 200L, 50L), ph != null ? ph.c : G.e.c, (ph != null ? ph.c : G.e.c) * 2);
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected boolean a(Object obj) {
        Location location = (Location) obj;
        return e.contains(location.getProvider()) && (this.a.b() || this.a.d() || a(location, (Location) this.a.a()));
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected long b(Ph ph) {
        return ph.c;
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected long a(Ph ph) {
        return ph.c * 2;
    }

    private boolean a(Location location, Location location2) {
        boolean zEquals;
        long j = this.c.a;
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > j;
        boolean z2 = time < (-j);
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (!z2) {
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            boolean z4 = accuracy > 0;
            boolean z5 = accuracy < 0;
            boolean z6 = ((long) accuracy) > 200;
            String provider = location.getProvider();
            String provider2 = location2.getProvider();
            if (provider == null) {
                zEquals = provider2 == null;
            } else {
                zEquals = provider.equals(provider2);
            }
            if (z5) {
                return true;
            }
            if (z3 && !z4) {
                return true;
            }
            if (z3 && !z6 && zEquals) {
                return true;
            }
        }
        return false;
    }

    C1363xc(a aVar, long j, long j2) {
        super(j, j2);
        this.c = aVar;
    }
}
