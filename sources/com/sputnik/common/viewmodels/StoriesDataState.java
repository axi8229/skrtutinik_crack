package com.sputnik.common.viewmodels;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0082\u0001\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u0004\u0010 R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b!\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b\r\u0010+R%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b/\u0010\u001a¨\u00060"}, d2 = {"Lcom/sputnik/common/viewmodels/StoriesDataState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Event;", "", "isLoaded", "onBoardingIsLoaded", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/stories/Story;", "stories", "", "currentStory", "isPaused", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "memoryCache", "cacheSize", "<init>", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;IZLandroid/util/LruCache;I)V", "copy", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;IZLandroid/util/LruCache;I)Lcom/sputnik/common/viewmodels/StoriesDataState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "getOnBoardingIsLoaded", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getStories", "()Ljava/util/List;", "I", "getCurrentStory", "Z", "()Z", "Landroid/util/LruCache;", "getMemoryCache", "()Landroid/util/LruCache;", "getCacheSize", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StoriesDataState implements VMState {
    private final int cacheSize;
    private final int currentStory;
    private final Event<Boolean> isLoaded;
    private final boolean isPaused;
    private final LruCache<String, Bitmap> memoryCache;
    private final Event<Boolean> onBoardingIsLoaded;
    private final Resource.Status serverState;
    private final List<Story> stories;

    public StoriesDataState() {
        this(null, null, null, null, 0, false, null, 0, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public final StoriesDataState copy(Event<Boolean> isLoaded, Event<Boolean> onBoardingIsLoaded, Resource.Status serverState, List<Story> stories, int currentStory, boolean isPaused, LruCache<String, Bitmap> memoryCache, int cacheSize) {
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(onBoardingIsLoaded, "onBoardingIsLoaded");
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        return new StoriesDataState(isLoaded, onBoardingIsLoaded, serverState, stories, currentStory, isPaused, memoryCache, cacheSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoriesDataState)) {
            return false;
        }
        StoriesDataState storiesDataState = (StoriesDataState) other;
        return Intrinsics.areEqual(this.isLoaded, storiesDataState.isLoaded) && Intrinsics.areEqual(this.onBoardingIsLoaded, storiesDataState.onBoardingIsLoaded) && this.serverState == storiesDataState.serverState && Intrinsics.areEqual(this.stories, storiesDataState.stories) && this.currentStory == storiesDataState.currentStory && this.isPaused == storiesDataState.isPaused && Intrinsics.areEqual(this.memoryCache, storiesDataState.memoryCache) && this.cacheSize == storiesDataState.cacheSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((this.isLoaded.hashCode() * 31) + this.onBoardingIsLoaded.hashCode()) * 31) + this.serverState.hashCode()) * 31;
        List<Story> list = this.stories;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.currentStory)) * 31;
        boolean z = this.isPaused;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        LruCache<String, Bitmap> lruCache = this.memoryCache;
        return ((i2 + (lruCache != null ? lruCache.hashCode() : 0)) * 31) + Integer.hashCode(this.cacheSize);
    }

    public String toString() {
        return "StoriesDataState(isLoaded=" + this.isLoaded + ", onBoardingIsLoaded=" + this.onBoardingIsLoaded + ", serverState=" + this.serverState + ", stories=" + this.stories + ", currentStory=" + this.currentStory + ", isPaused=" + this.isPaused + ", memoryCache=" + this.memoryCache + ", cacheSize=" + this.cacheSize + ")";
    }

    public StoriesDataState(Event<Boolean> isLoaded, Event<Boolean> onBoardingIsLoaded, Resource.Status serverState, List<Story> list, int i, boolean z, LruCache<String, Bitmap> lruCache, int i2) {
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(onBoardingIsLoaded, "onBoardingIsLoaded");
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        this.isLoaded = isLoaded;
        this.onBoardingIsLoaded = onBoardingIsLoaded;
        this.serverState = serverState;
        this.stories = list;
        this.currentStory = i;
        this.isPaused = z;
        this.memoryCache = lruCache;
        this.cacheSize = i2;
    }

    public /* synthetic */ StoriesDataState(Event event, Event event2, Resource.Status status, List list, int i, boolean z, LruCache lruCache, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Event(Boolean.FALSE) : event, (i3 & 2) != 0 ? new Event(Boolean.FALSE) : event2, (i3 & 4) != 0 ? Resource.Status.NONE : status, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? false : z, (i3 & 64) == 0 ? lruCache : null, (i3 & 128) == 0 ? i2 : 0);
    }

    public final Event<Boolean> isLoaded() {
        return this.isLoaded;
    }

    public final Event<Boolean> getOnBoardingIsLoaded() {
        return this.onBoardingIsLoaded;
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final List<Story> getStories() {
        return this.stories;
    }

    public final int getCurrentStory() {
        return this.currentStory;
    }

    public final LruCache<String, Bitmap> getMemoryCache() {
        return this.memoryCache;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }
}
