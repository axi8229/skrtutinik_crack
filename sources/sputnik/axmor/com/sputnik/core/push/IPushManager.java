package sputnik.axmor.com.sputnik.core.push;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPushManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/IPushManager;", "", "handleMessage", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "body", RemoteMessageConst.DATA, "", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IPushManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void handleMessage(String title, String body, Map<String, String> data);

    /* compiled from: IPushManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/IPushManager$Companion;", "", "()V", "instance", "Lsputnik/axmor/com/sputnik/core/push/IPushManager;", "clearInstance", "", "getInstance", "context", "Landroid/content/Context;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static IPushManager instance;

        private Companion() {
        }

        public final IPushManager getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (instance == null) {
                instance = new PushManagerImpl(context);
            }
            IPushManager iPushManager = instance;
            Intrinsics.checkNotNull(iPushManager);
            return iPushManager;
        }

        public final void clearInstance() {
            instance = null;
        }
    }
}
