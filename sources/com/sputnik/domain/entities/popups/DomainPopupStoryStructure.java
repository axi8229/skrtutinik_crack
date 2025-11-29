package com.sputnik.domain.entities.popups;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStoryStructure.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "", "", "id", "version", RemoteMessageConst.Notification.PRIORITY, "", "trigger", "", "Lcom/sputnik/domain/entities/popups/DomainPopupStory;", "popupStories", "<init>", "(JJJLjava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "()J", "getVersion", "getPriority", "Ljava/lang/String;", "getTrigger", "Ljava/util/List;", "getPopupStories", "()Ljava/util/List;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPopupStoryStructure {
    private final long id;
    private final List<DomainPopupStory> popupStories;
    private final long priority;
    private final String trigger;
    private final long version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPopupStoryStructure)) {
            return false;
        }
        DomainPopupStoryStructure domainPopupStoryStructure = (DomainPopupStoryStructure) other;
        return this.id == domainPopupStoryStructure.id && this.version == domainPopupStoryStructure.version && this.priority == domainPopupStoryStructure.priority && Intrinsics.areEqual(this.trigger, domainPopupStoryStructure.trigger) && Intrinsics.areEqual(this.popupStories, domainPopupStoryStructure.popupStories);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.version)) * 31) + Long.hashCode(this.priority)) * 31) + this.trigger.hashCode()) * 31) + this.popupStories.hashCode();
    }

    public String toString() {
        return "DomainPopupStoryStructure(id=" + this.id + ", version=" + this.version + ", priority=" + this.priority + ", trigger=" + this.trigger + ", popupStories=" + this.popupStories + ")";
    }

    public DomainPopupStoryStructure(long j, long j2, long j3, String trigger, List<DomainPopupStory> popupStories) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(popupStories, "popupStories");
        this.id = j;
        this.version = j2;
        this.priority = j3;
        this.trigger = trigger;
        this.popupStories = popupStories;
    }

    public final long getId() {
        return this.id;
    }

    public final long getVersion() {
        return this.version;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final String getTrigger() {
        return this.trigger;
    }

    public final List<DomainPopupStory> getPopupStories() {
        return this.popupStories;
    }
}
