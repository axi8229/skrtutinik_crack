package ru.yoomoney.sdk.auth.location.di;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.location.GoogleLocationService;
import ru.yoomoney.sdk.auth.location.HuaweiLocationService;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u0000 \n2\u00020\u0001:\u0002\t\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/location/di/LocationComponent;", "", "inject", "", "service", "Lru/yoomoney/sdk/auth/location/GoogleLocationService;", "Lru/yoomoney/sdk/auth/location/HuaweiLocationService;", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "Builder", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LocationComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/location/di/LocationComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/auth/location/di/LocationComponent;", "context", "Landroid/content/Context;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        LocationComponent build();

        Builder context(Context context);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/location/di/LocationComponent$Companion;", "", "()V", "locationComponent", "Lru/yoomoney/sdk/auth/location/di/LocationComponent;", "initAndGet", "context", "Landroid/content/Context;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static volatile LocationComponent locationComponent;

        private Companion() {
        }

        public final LocationComponent initAndGet(Context context) {
            LocationComponent locationComponentBuild;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (LocationComponent.class) {
                locationComponentBuild = locationComponent;
                if (locationComponentBuild == null) {
                    locationComponentBuild = DaggerLocationComponent.builder().context(context).build();
                    locationComponent = locationComponentBuild;
                }
            }
            return locationComponentBuild;
        }
    }

    void inject(GoogleLocationService service);

    void inject(HuaweiLocationService service);

    LocationHeaderManager locationHeaderManager();
}
