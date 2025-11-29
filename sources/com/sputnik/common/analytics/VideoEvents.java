package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoEvents.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sputnik/common/analytics/VideoEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "CameraNoSupport264", "PhoneNoSupport264", "Lcom/sputnik/common/analytics/VideoEvents$CameraNoSupport264;", "Lcom/sputnik/common/analytics/VideoEvents$PhoneNoSupport264;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class VideoEvents extends AnalyticsTracker.Event {
    public /* synthetic */ VideoEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ VideoEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: VideoEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/VideoEvents$CameraNoSupport264;", "Lcom/sputnik/common/analytics/VideoEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CameraNoSupport264 extends VideoEvents {
        public CameraNoSupport264() {
            super("cameraNoSupport264", null, 2, 0 == true ? 1 : 0);
        }
    }

    private VideoEvents(String str, String str2) {
        super("Video", str, str2);
    }

    /* compiled from: VideoEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/VideoEvents$PhoneNoSupport264;", "Lcom/sputnik/common/analytics/VideoEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PhoneNoSupport264 extends VideoEvents {
        public PhoneNoSupport264() {
            super("phoneNoSupport264", null, 2, 0 == true ? 1 : 0);
        }
    }
}
