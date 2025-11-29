package bz;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class B {
    public final HashMap a;
    public N b;

    public B(Map map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Base feature holders should be provided!");
        }
        this.a = new HashMap(map);
    }

    public final Object a(Class cls) {
        if (this.b != null) {
            throw new IllegalStateException("Concurrent feature requests not supported!\nMaybe You used 'getFeature' from DI code - if so replace it with 'getDependency' \nDetails: \n\n\trequestedFeature = " + cls.getName() + "\n\tcurrentThread = " + Thread.currentThread().getName() + "\n\tcurrentBuildFeatureContext = " + this.b);
        }
        this.b = new N(cls, Thread.currentThread().getName(), new Throwable());
        L1 l1 = (L1) this.a.get(cls);
        if (l1 != null) {
            Object objA = l1.a();
            this.b = null;
            return objA;
        }
        throw new IllegalStateException("Failed to get feature with key = " + cls);
    }
}
