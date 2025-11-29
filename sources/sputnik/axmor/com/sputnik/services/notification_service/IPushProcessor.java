package sputnik.axmor.com.sputnik.services.notification_service;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPushProcessor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor;", "", "", "", "map", "", "process", "(Ljava/util/Map;)V", "cancel", "()V", "cancelNotification", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IPushProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void cancel();

    void cancelNotification();

    void process(Map<String, String> map);

    /* compiled from: IPushProcessor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor;", "getInstance", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor;", "instance", "Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static IPushProcessor instance;

        private Companion() {
        }

        public static /* synthetic */ IPushProcessor getInstance$default(Companion companion, Context context, Lifecycle lifecycle, int i, Object obj) {
            if ((i & 2) != 0) {
                lifecycle = null;
            }
            return companion.getInstance(context, lifecycle);
        }

        public final IPushProcessor getInstance(Context context, Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (instance == null) {
                instance = new PushProcessorImpl(context, lifecycle);
            }
            IPushProcessor iPushProcessor = instance;
            Intrinsics.checkNotNull(iPushProcessor);
            return iPushProcessor;
        }
    }
}
