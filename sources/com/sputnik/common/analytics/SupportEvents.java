package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SupportEvents.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0006\u0007\b\t\n\u000b\f\rB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAdditionalContact", "ClickApplicationQuestions", "ClickHardwareQuestions", "ClickOpenSupport", "ClickPhoneNumber", "ClickReadyAnswers", "ClickViewСontacts", "ClickWriteSupport", "Lcom/sputnik/common/analytics/SupportEvents$ClickAdditionalContact;", "Lcom/sputnik/common/analytics/SupportEvents$ClickApplicationQuestions;", "Lcom/sputnik/common/analytics/SupportEvents$ClickHardwareQuestions;", "Lcom/sputnik/common/analytics/SupportEvents$ClickOpenSupport;", "Lcom/sputnik/common/analytics/SupportEvents$ClickPhoneNumber;", "Lcom/sputnik/common/analytics/SupportEvents$ClickReadyAnswers;", "Lcom/sputnik/common/analytics/SupportEvents$ClickViewСontacts;", "Lcom/sputnik/common/analytics/SupportEvents$ClickWriteSupport;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SupportEvents extends AnalyticsTracker.Event {
    public /* synthetic */ SupportEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ SupportEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickReadyAnswers;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickReadyAnswers extends SupportEvents {
        public ClickReadyAnswers() {
            super("clickReadyAnswers", null, 2, 0 == true ? 1 : 0);
        }
    }

    private SupportEvents(String str, String str2) {
        super("Support", str, str2);
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickApplicationQuestions;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickApplicationQuestions extends SupportEvents {
        public ClickApplicationQuestions() {
            super("clickApplicationQuestions", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickHardwareQuestions;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickHardwareQuestions extends SupportEvents {
        public ClickHardwareQuestions() {
            super("clickHardwareQuestions", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickPhoneNumber;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPhoneNumber extends SupportEvents {
        public ClickPhoneNumber() {
            super("clickPhoneNumber", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickAdditionalContact;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAdditionalContact extends SupportEvents {
        public ClickAdditionalContact() {
            super("clickAdditionalPhoneNumber", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickWriteSupport;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickWriteSupport extends SupportEvents {
        public ClickWriteSupport() {
            super("clickWriteSupport", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickViewСontacts;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.common.analytics.SupportEvents$ClickViewСontacts, reason: invalid class name */
    public static final class ClickViewontacts extends SupportEvents {
        public ClickViewontacts() {
            super("clickViewСontacts", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SupportEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/SupportEvents$ClickOpenSupport;", "Lcom/sputnik/common/analytics/SupportEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickOpenSupport extends SupportEvents {
        public ClickOpenSupport() {
            super("clickOpenSupport", null, 2, 0 == true ? 1 : 0);
        }
    }
}
