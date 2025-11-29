package com.sputnik.domain.entities.stories;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainStory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b&\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b'\u0010\u0014R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b(\u0010\u0014R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/sputnik/domain/entities/stories/DomainStory;", "", "", "id", "version", "Lcom/sputnik/domain/entities/stories/StoriesSet;", "set", "order", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "background", "screenshot", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "desc", "", "Lcom/sputnik/domain/entities/stories/DomainStoriesButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/sputnik/domain/entities/stories/StoriesSet;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "getVersion", "Lcom/sputnik/domain/entities/stories/StoriesSet;", "getSet", "()Lcom/sputnik/domain/entities/stories/StoriesSet;", "getOrder", "getDuration", "Ljava/lang/String;", "getBackground", "getScreenshot", "getTitle", "getDesc", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainStory {
    private final String background;
    private final List<DomainStoriesButton> buttons;
    private final String desc;
    private final Integer duration;
    private final Integer id;
    private final Integer order;
    private final String screenshot;
    private final StoriesSet set;
    private final String title;
    private final Integer version;

    public DomainStory() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainStory)) {
            return false;
        }
        DomainStory domainStory = (DomainStory) other;
        return Intrinsics.areEqual(this.id, domainStory.id) && Intrinsics.areEqual(this.version, domainStory.version) && this.set == domainStory.set && Intrinsics.areEqual(this.order, domainStory.order) && Intrinsics.areEqual(this.duration, domainStory.duration) && Intrinsics.areEqual(this.background, domainStory.background) && Intrinsics.areEqual(this.screenshot, domainStory.screenshot) && Intrinsics.areEqual(this.title, domainStory.title) && Intrinsics.areEqual(this.desc, domainStory.desc) && Intrinsics.areEqual(this.buttons, domainStory.buttons);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.version;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        StoriesSet storiesSet = this.set;
        int iHashCode3 = (iHashCode2 + (storiesSet == null ? 0 : storiesSet.hashCode())) * 31;
        Integer num3 = this.order;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.duration;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.background;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.screenshot;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<DomainStoriesButton> list = this.buttons;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DomainStory(id=" + this.id + ", version=" + this.version + ", set=" + this.set + ", order=" + this.order + ", duration=" + this.duration + ", background=" + this.background + ", screenshot=" + this.screenshot + ", title=" + this.title + ", desc=" + this.desc + ", buttons=" + this.buttons + ")";
    }

    public DomainStory(Integer num, Integer num2, StoriesSet storiesSet, Integer num3, Integer num4, String str, String str2, String str3, String str4, List<DomainStoriesButton> list) {
        this.id = num;
        this.version = num2;
        this.set = storiesSet;
        this.order = num3;
        this.duration = num4;
        this.background = str;
        this.screenshot = str2;
        this.title = str3;
        this.desc = str4;
        this.buttons = list;
    }

    public /* synthetic */ DomainStory(Integer num, Integer num2, StoriesSet storiesSet, Integer num3, Integer num4, String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : storiesSet, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) == 0 ? list : null);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final StoriesSet getSet() {
        return this.set;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getScreenshot() {
        return this.screenshot;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<DomainStoriesButton> getButtons() {
        return this.buttons;
    }
}
