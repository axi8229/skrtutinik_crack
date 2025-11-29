package ru.yoomoney.sdk.auth.qrAuth.di;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\u001c\u0010\b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/di/QrAuthModule;", "", "<init>", "()V", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Landroidx/fragment/app/Fragment;", "fragments", "Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "providesQrAuthActivityFragmentFactory", "(Ljava/util/Map;)Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Landroid/content/Context;", "context", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "provideFailureMapper", "(Landroid/content/Context;)Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthModule {

    public static final class a extends Lambda implements Function3<String, String, Throwable, Unit> {
        public static final a a = new a();

        public a() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(String str, String str2, Throwable th) {
            String tag = str;
            String message = str2;
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Log.w(tag, message, th);
            return Unit.INSTANCE;
        }
    }

    public final ResourceMapper provideFailureMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ResourceMapper(context);
    }

    public final ActivityFragmentFactory providesQrAuthActivityFragmentFactory(Map<Class<?>, Provider<Fragment>> fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        return new ActivityFragmentFactory(fragments, SetsKt.setOf(NavHostFragment.class), a.a);
    }
}
