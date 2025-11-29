package sputnik.axmor.com.sputnik.core.push;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PushTokenManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/PushTokenManager;", "", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushTokenManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PushTokenManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ?\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u001a\b\u0002\u0010\f\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/PushTokenManager$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "", "", "complete", "requestToken", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onError", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @SuppressLint({"CheckResult"})
        public final void requestToken(Function1<? super String, Unit> complete) {
            Intrinsics.checkNotNullParameter(complete, "complete");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PushTokenManager$Companion$requestToken$1(complete, null), 3, null);
        }

        @SuppressLint({"CheckResult"})
        public final void requestToken(Function1<? super String, Unit> complete, Function1<? super Exception, Unit> onError) {
            Intrinsics.checkNotNullParameter(complete, "complete");
            try {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PushTokenManager$Companion$requestToken$2(complete, null), 3, null);
            } catch (Exception e) {
                if (onError != null) {
                    onError.invoke(e);
                }
            }
        }
    }
}
