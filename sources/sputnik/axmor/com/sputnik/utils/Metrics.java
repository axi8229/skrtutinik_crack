package sputnik.axmor.com.sputnik.utils;

import com.sputnik.common.AndroidConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Metrics.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\f\n\u000b\f\r\t\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\t\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics;", "", "", "parentScreen", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getParentScreen", "()Ljava/lang/String;", "Companion", "Archive3EventName", "Archive5EventName", "Archive7EventName", "ArchiveMetrics", "FaceRecognizerErrorEventName", "FaceRecognizerMainEventName", "FaceRecognizerSettingsEventName", "FaceRecognizerUploadEventName", "ServiceMetrics", "SubscriptionsDoneEventName", "VisitsEventName", "Lsputnik/axmor/com/sputnik/utils/Metrics$Archive3EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$Archive5EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$Archive7EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerErrorEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerMainEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerSettingsEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerUploadEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$SubscriptionsDoneEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$VisitsEventName;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Metrics {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String parentScreen;

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$ArchiveMetrics;", "Lsputnik/axmor/com/sputnik/utils/Metrics$ServiceMetrics;", "getAccess", "", "getGetAccess", "()Ljava/lang/String;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ArchiveMetrics extends ServiceMetrics {
        String getGetAccess();
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$ServiceMetrics;", "", "", "getUnsubscribe", "()Ljava/lang/String;", "unsubscribe", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ServiceMetrics {
        String getUnsubscribe();
    }

    public /* synthetic */ Metrics(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private Metrics(String str) {
        this.parentScreen = str;
    }

    public final String getParentScreen() {
        return this.parentScreen;
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$Companion;", "", "()V", "getServiceMetrics", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "id", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Metrics getServiceMetrics(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
            return Intrinsics.areEqual(id, servicesNames.getVIDEO_ARCHIVE_3d_IDENTIFIER()) ? Archive3EventName.INSTANCE : Intrinsics.areEqual(id, servicesNames.getVIDEO_ARCHIVE_5d_IDENTIFIER()) ? Archive5EventName.INSTANCE : Intrinsics.areEqual(id, servicesNames.getVIDEO_ARCHIVE_7d_IDENTIFIER()) ? Archive7EventName.INSTANCE : FaceRecognizerMainEventName.INSTANCE;
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerSettingsEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FaceRecognizerSettingsEventName extends Metrics {
        public static final FaceRecognizerSettingsEventName INSTANCE = new FaceRecognizerSettingsEventName();

        private FaceRecognizerSettingsEventName() {
            super("faceRecognizerSettings", null);
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerUploadEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FaceRecognizerUploadEventName extends Metrics {
        public static final FaceRecognizerUploadEventName INSTANCE = new FaceRecognizerUploadEventName();

        private FaceRecognizerUploadEventName() {
            super("faceRecognizerUpload", null);
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerErrorEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FaceRecognizerErrorEventName extends Metrics {
        public static final FaceRecognizerErrorEventName INSTANCE = new FaceRecognizerErrorEventName();

        private FaceRecognizerErrorEventName() {
            super("faceRecognizerError", null);
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$FaceRecognizerMainEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$ServiceMetrics;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "", "subscribe", "Ljava/lang/String;", "getSubscribe", "()Ljava/lang/String;", "unsubscribe", "getUnsubscribe", "popupOk", "getPopupOk", "popupUnsubscribeOk", "getPopupUnsubscribeOk", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FaceRecognizerMainEventName extends Metrics implements ServiceMetrics {
        public static final FaceRecognizerMainEventName INSTANCE = new FaceRecognizerMainEventName();
        private static final String subscribe = "subscribe";
        private static final String unsubscribe = "unsubscribe";
        private static final String popupOk = "popup_ok";
        private static final String popupUnsubscribeOk = "popup_unsubscribe_ok_fr";

        private FaceRecognizerMainEventName() {
            super("faceRecognizerMain", null);
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ServiceMetrics
        public String getUnsubscribe() {
            return unsubscribe;
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$Archive3EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$ArchiveMetrics;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "", "getAccess", "Ljava/lang/String;", "getGetAccess", "()Ljava/lang/String;", "subscribe", "getSubscribe", "unsubscribe", "getUnsubscribe", "popupOk", "getPopupOk", "popupUnsubscribeOk", "getPopupUnsubscribeOk", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Archive3EventName extends Metrics implements ArchiveMetrics {
        public static final Archive3EventName INSTANCE = new Archive3EventName();
        private static final String getAccess = "get_access_3";
        private static final String subscribe = "subscribe_3";
        private static final String unsubscribe = "unsubscribe_3";
        private static final String popupOk = "popup_ok_3";
        private static final String popupUnsubscribeOk = "popup_unsubscribe_ok_3";

        private Archive3EventName() {
            super("archive3Main", null);
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ArchiveMetrics
        public String getGetAccess() {
            return getAccess;
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ServiceMetrics
        public String getUnsubscribe() {
            return unsubscribe;
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$Archive5EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$ArchiveMetrics;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "", "getAccess", "Ljava/lang/String;", "getGetAccess", "()Ljava/lang/String;", "subscribe", "getSubscribe", "unsubscribe", "getUnsubscribe", "popupOk", "getPopupOk", "popupUnsubscribeOk", "getPopupUnsubscribeOk", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Archive5EventName extends Metrics implements ArchiveMetrics {
        public static final Archive5EventName INSTANCE = new Archive5EventName();
        private static final String getAccess = "get_access_5";
        private static final String subscribe = "subscribe_5";
        private static final String unsubscribe = "unsubscribe_5";
        private static final String popupOk = "popup_ok_5";
        private static final String popupUnsubscribeOk = "popup_unsubscribe_ok_5";

        private Archive5EventName() {
            super("archive5Main", null);
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ArchiveMetrics
        public String getGetAccess() {
            return getAccess;
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ServiceMetrics
        public String getUnsubscribe() {
            return unsubscribe;
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$Archive7EventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics$ArchiveMetrics;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "", "getAccess", "Ljava/lang/String;", "getGetAccess", "()Ljava/lang/String;", "subscribe", "getSubscribe", "unsubscribe", "getUnsubscribe", "popupOk", "getPopupOk", "popupUnsubscribeOk", "getPopupUnsubscribeOk", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Archive7EventName extends Metrics implements ArchiveMetrics {
        public static final Archive7EventName INSTANCE = new Archive7EventName();
        private static final String getAccess = "get_access_7";
        private static final String subscribe = "subscribe_7";
        private static final String unsubscribe = "unsubscribe_7";
        private static final String popupOk = "popup_ok_7";
        private static final String popupUnsubscribeOk = "popup_unsubscribe_ok_7";

        private Archive7EventName() {
            super("archive7Main", null);
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ArchiveMetrics
        public String getGetAccess() {
            return getAccess;
        }

        @Override // sputnik.axmor.com.sputnik.utils.Metrics.ServiceMetrics
        public String getUnsubscribe() {
            return unsubscribe;
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$VisitsEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VisitsEventName extends Metrics {
        public static final VisitsEventName INSTANCE = new VisitsEventName();

        private VisitsEventName() {
            super("visits", null);
        }
    }

    /* compiled from: Metrics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/Metrics$SubscriptionsDoneEventName;", "Lsputnik/axmor/com/sputnik/utils/Metrics;", "<init>", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SubscriptionsDoneEventName extends Metrics {
        public static final SubscriptionsDoneEventName INSTANCE = new SubscriptionsDoneEventName();

        private SubscriptionsDoneEventName() {
            super("subscriptionsDone", null);
        }
    }
}
