package sputnik.axmor.com.sputnik.core.push;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.entities.notifications.PushMessage;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;

/* compiled from: PushManagerImpl.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/PushManagerImpl;", "Lsputnik/axmor/com/sputnik/core/push/IPushManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notificationsManager", "Lsputnik/axmor/com/sputnik/core/notifications/INotificationsManager;", "handleMessage", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "body", RemoteMessageConst.DATA, "", "parseDeeplink", "Lsputnik/axmor/com/sputnik/core/push/PushManagerImpl$Deeplink;", "deeplink", "Deeplink", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushManagerImpl implements IPushManager {
    private final Context context;
    private final INotificationsManager notificationsManager;

    public PushManagerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.notificationsManager = INotificationsManager.INSTANCE.getInstance(context);
    }

    @Override // sputnik.axmor.com.sputnik.core.push.IPushManager
    public void handleMessage(String title, String body, Map<String, String> data) {
        Object obj;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(data, "data");
        String str = "\ntitle: " + title + "\nbody: " + body + "\n";
        for (String str2 : data.keySet()) {
            str = ((Object) str) + str2 + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) data.get(str2)) + "\n";
        }
        String str3 = data.get(PushMessage.Arguments.deeplink.toString());
        if (str3 == null) {
            str3 = "";
        }
        Deeplink deeplink = parseDeeplink(str3);
        INotificationsManager iNotificationsManager = this.notificationsManager;
        String raw = deeplink.getRaw();
        String strValueOf = String.valueOf(data.get(PushMessage.Arguments.body.toString()));
        Object[] enumConstants = PushMessage.Types.class.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "getEnumConstants(...)");
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                obj = null;
                break;
            }
            obj = enumConstants[i];
            if (Intrinsics.areEqual(((Enum) obj).name(), strValueOf)) {
                break;
            } else {
                i++;
            }
        }
        PushMessage.Types types = (PushMessage.Types) ((Enum) obj);
        if (types == null) {
            types = PushMessage.Types.unknown;
        }
        String id = deeplink.getId();
        iNotificationsManager.notifyPush(new PushMessage(0, title, body, types, raw, (id == null || (intOrNull = StringsKt.toIntOrNull(id)) == null) ? null : intOrNull.toString(), 1, null));
    }

    private final Deeplink parseDeeplink(String deeplink) {
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(deeplink, "sputnik://", "", false, 4, (Object) null), new String[]{"/"}, false, 0, 6, (Object) null);
        String str = (String) CollectionsKt.getOrNull(listSplit$default, 0);
        if (str == null) {
            str = "";
        }
        String str2 = null;
        if (!StringsKt.contains$default((CharSequence) deeplink, (CharSequence) "faq", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) deeplink, (CharSequence) "notifications", false, 2, (Object) null)) {
            str2 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
        }
        return new Deeplink(str, str2, deeplink);
    }

    /* compiled from: PushManagerImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/PushManagerImpl$Deeplink;", "", "", "uri", "id", "raw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUri", "getId", "getRaw", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Deeplink {
        private final String id;
        private final String raw;
        private final String uri;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Deeplink)) {
                return false;
            }
            Deeplink deeplink = (Deeplink) other;
            return Intrinsics.areEqual(this.uri, deeplink.uri) && Intrinsics.areEqual(this.id, deeplink.id) && Intrinsics.areEqual(this.raw, deeplink.raw);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.id;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.raw;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Deeplink(uri=" + this.uri + ", id=" + this.id + ", raw=" + this.raw + ")";
        }

        public Deeplink(String uri, String str, String str2) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.id = str;
            this.raw = str2;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getId() {
            return this.id;
        }

        public final String getRaw() {
            return this.raw;
        }
    }
}
