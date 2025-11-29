package com.yandex.metrica.coreutils.services;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UtilityServiceConfiguration.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/yandex/metrica/coreutils/services/UtilityServiceConfiguration;", "", "", "initialConfigTime", "lastUpdateConfigTime", "<init>", "(JJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getInitialConfigTime", "()J", "getLastUpdateConfigTime", "core-utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class UtilityServiceConfiguration {
    private final long initialConfigTime;
    private final long lastUpdateConfigTime;

    public UtilityServiceConfiguration() {
        this(0L, 0L, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UtilityServiceConfiguration)) {
            return false;
        }
        UtilityServiceConfiguration utilityServiceConfiguration = (UtilityServiceConfiguration) other;
        return this.initialConfigTime == utilityServiceConfiguration.initialConfigTime && this.lastUpdateConfigTime == utilityServiceConfiguration.lastUpdateConfigTime;
    }

    public int hashCode() {
        long j = this.initialConfigTime;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.lastUpdateConfigTime;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        return "UtilityServiceConfiguration(initialConfigTime=" + this.initialConfigTime + ", lastUpdateConfigTime=" + this.lastUpdateConfigTime + ")";
    }

    public UtilityServiceConfiguration(long j, long j2) {
        this.initialConfigTime = j;
        this.lastUpdateConfigTime = j2;
    }

    public final long getInitialConfigTime() {
        return this.initialConfigTime;
    }

    public /* synthetic */ UtilityServiceConfiguration(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getLastUpdateConfigTime() {
        return this.lastUpdateConfigTime;
    }
}
