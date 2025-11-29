package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ABExperimentsEvents.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/sputnik/common/analytics/ABExperimentsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ShowDetFastLoadingAcceleratingIcon", "ShowDetFastLoadingCloseIcon", "ShowDetFastLoadingText", "Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingAcceleratingIcon;", "Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingCloseIcon;", "Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingText;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ABExperimentsEvents extends AnalyticsTracker.Event {
    public /* synthetic */ ABExperimentsEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ ABExperimentsEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private ABExperimentsEvents(String str, String str2) {
        super("AB", str, str2);
    }

    /* compiled from: ABExperimentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingText;", "Lcom/sputnik/common/analytics/ABExperimentsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetFastLoadingText extends ABExperimentsEvents {
        public ShowDetFastLoadingText() {
            super("showDetFastLoadingText", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ABExperimentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingCloseIcon;", "Lcom/sputnik/common/analytics/ABExperimentsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetFastLoadingCloseIcon extends ABExperimentsEvents {
        public ShowDetFastLoadingCloseIcon() {
            super("showDetFastLoadingCloseIcon", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ABExperimentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/ABExperimentsEvents$ShowDetFastLoadingAcceleratingIcon;", "Lcom/sputnik/common/analytics/ABExperimentsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetFastLoadingAcceleratingIcon extends ABExperimentsEvents {
        public ShowDetFastLoadingAcceleratingIcon() {
            super("showDetFastLoadingAcceleratingIcon", null, 2, 0 == true ? 1 : 0);
        }
    }
}
