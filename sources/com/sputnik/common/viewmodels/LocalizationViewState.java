package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u0006\u0010\u001eR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0015R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0013¨\u0006&"}, d2 = {"Lcom/sputnik/common/viewmodels/LocalizationViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "state", "Lcom/sputnik/domain/common/Event;", "", "isLoaded", "", "Lcom/sputnik/common/entities/localization/Localization;", "localizationList", "", "curLoaderIndex", "", "currentTag", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Ljava/util/List;ILjava/lang/String;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Ljava/util/List;ILjava/lang/String;)Lcom/sputnik/common/viewmodels/LocalizationViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "Ljava/util/List;", "getLocalizationList", "()Ljava/util/List;", "I", "getCurLoaderIndex", "Ljava/lang/String;", "getCurrentTag", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LocalizationViewState implements VMState {
    private final int curLoaderIndex;
    private final String currentTag;
    private final Event<Boolean> isLoaded;
    private final List<Localization> localizationList;
    private final Resource.Status state;

    public static /* synthetic */ LocalizationViewState copy$default(LocalizationViewState localizationViewState, Resource.Status status, Event event, List list, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            status = localizationViewState.state;
        }
        if ((i2 & 2) != 0) {
            event = localizationViewState.isLoaded;
        }
        Event event2 = event;
        if ((i2 & 4) != 0) {
            list = localizationViewState.localizationList;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            i = localizationViewState.curLoaderIndex;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str = localizationViewState.currentTag;
        }
        return localizationViewState.copy(status, event2, list2, i3, str);
    }

    public final LocalizationViewState copy(Resource.Status state, Event<Boolean> isLoaded, List<Localization> localizationList, int curLoaderIndex, String currentTag) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(localizationList, "localizationList");
        Intrinsics.checkNotNullParameter(currentTag, "currentTag");
        return new LocalizationViewState(state, isLoaded, localizationList, curLoaderIndex, currentTag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizationViewState)) {
            return false;
        }
        LocalizationViewState localizationViewState = (LocalizationViewState) other;
        return this.state == localizationViewState.state && Intrinsics.areEqual(this.isLoaded, localizationViewState.isLoaded) && Intrinsics.areEqual(this.localizationList, localizationViewState.localizationList) && this.curLoaderIndex == localizationViewState.curLoaderIndex && Intrinsics.areEqual(this.currentTag, localizationViewState.currentTag);
    }

    public int hashCode() {
        return (((((((this.state.hashCode() * 31) + this.isLoaded.hashCode()) * 31) + this.localizationList.hashCode()) * 31) + Integer.hashCode(this.curLoaderIndex)) * 31) + this.currentTag.hashCode();
    }

    public String toString() {
        return "LocalizationViewState(state=" + this.state + ", isLoaded=" + this.isLoaded + ", localizationList=" + this.localizationList + ", curLoaderIndex=" + this.curLoaderIndex + ", currentTag=" + this.currentTag + ")";
    }

    public LocalizationViewState(Resource.Status state, Event<Boolean> isLoaded, List<Localization> localizationList, int i, String currentTag) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(isLoaded, "isLoaded");
        Intrinsics.checkNotNullParameter(localizationList, "localizationList");
        Intrinsics.checkNotNullParameter(currentTag, "currentTag");
        this.state = state;
        this.isLoaded = isLoaded;
        this.localizationList = localizationList;
        this.curLoaderIndex = i;
        this.currentTag = currentTag;
    }

    public /* synthetic */ LocalizationViewState(Resource.Status status, Event event, List list, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Resource.Status.NONE : status, (i2 & 2) != 0 ? new Event(Boolean.FALSE) : event, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? 0 : i, str);
    }

    public final Resource.Status getState() {
        return this.state;
    }

    public final Event<Boolean> isLoaded() {
        return this.isLoaded;
    }

    public final List<Localization> getLocalizationList() {
        return this.localizationList;
    }

    public final int getCurLoaderIndex() {
        return this.curLoaderIndex;
    }

    public final String getCurrentTag() {
        return this.currentTag;
    }
}
