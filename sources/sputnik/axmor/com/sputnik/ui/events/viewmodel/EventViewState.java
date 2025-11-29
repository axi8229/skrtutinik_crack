package sputnik.axmor.com.sputnik.ui.events.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.prefs.EventsSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJL\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0004\u0010\u0018R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0005\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0006\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Event;", "", "isNoCameraReported", "isFlatInsurance", "isCustomizationProductReported", "Lcom/sputnik/domain/entities/prefs/EventsSettings;", "eventsSettings", "<init>", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/prefs/EventsSettings;)V", "copy", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/prefs/EventsSettings;)Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/domain/entities/prefs/EventsSettings;", "getEventsSettings", "()Lcom/sputnik/domain/entities/prefs/EventsSettings;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EventViewState implements VMState {
    private final EventsSettings eventsSettings;
    private final Event<Boolean> isCustomizationProductReported;
    private final Event<Boolean> isFlatInsurance;
    private final Event<Boolean> isNoCameraReported;

    public EventViewState() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventViewState copy$default(EventViewState eventViewState, Event event, Event event2, Event event3, EventsSettings eventsSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            event = eventViewState.isNoCameraReported;
        }
        if ((i & 2) != 0) {
            event2 = eventViewState.isFlatInsurance;
        }
        if ((i & 4) != 0) {
            event3 = eventViewState.isCustomizationProductReported;
        }
        if ((i & 8) != 0) {
            eventsSettings = eventViewState.eventsSettings;
        }
        return eventViewState.copy(event, event2, event3, eventsSettings);
    }

    public final EventViewState copy(Event<Boolean> isNoCameraReported, Event<Boolean> isFlatInsurance, Event<Boolean> isCustomizationProductReported, EventsSettings eventsSettings) {
        Intrinsics.checkNotNullParameter(isNoCameraReported, "isNoCameraReported");
        Intrinsics.checkNotNullParameter(isFlatInsurance, "isFlatInsurance");
        Intrinsics.checkNotNullParameter(isCustomizationProductReported, "isCustomizationProductReported");
        return new EventViewState(isNoCameraReported, isFlatInsurance, isCustomizationProductReported, eventsSettings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventViewState)) {
            return false;
        }
        EventViewState eventViewState = (EventViewState) other;
        return Intrinsics.areEqual(this.isNoCameraReported, eventViewState.isNoCameraReported) && Intrinsics.areEqual(this.isFlatInsurance, eventViewState.isFlatInsurance) && Intrinsics.areEqual(this.isCustomizationProductReported, eventViewState.isCustomizationProductReported) && Intrinsics.areEqual(this.eventsSettings, eventViewState.eventsSettings);
    }

    public int hashCode() {
        int iHashCode = ((((this.isNoCameraReported.hashCode() * 31) + this.isFlatInsurance.hashCode()) * 31) + this.isCustomizationProductReported.hashCode()) * 31;
        EventsSettings eventsSettings = this.eventsSettings;
        return iHashCode + (eventsSettings == null ? 0 : eventsSettings.hashCode());
    }

    public String toString() {
        return "EventViewState(isNoCameraReported=" + this.isNoCameraReported + ", isFlatInsurance=" + this.isFlatInsurance + ", isCustomizationProductReported=" + this.isCustomizationProductReported + ", eventsSettings=" + this.eventsSettings + ")";
    }

    public EventViewState(Event<Boolean> isNoCameraReported, Event<Boolean> isFlatInsurance, Event<Boolean> isCustomizationProductReported, EventsSettings eventsSettings) {
        Intrinsics.checkNotNullParameter(isNoCameraReported, "isNoCameraReported");
        Intrinsics.checkNotNullParameter(isFlatInsurance, "isFlatInsurance");
        Intrinsics.checkNotNullParameter(isCustomizationProductReported, "isCustomizationProductReported");
        this.isNoCameraReported = isNoCameraReported;
        this.isFlatInsurance = isFlatInsurance;
        this.isCustomizationProductReported = isCustomizationProductReported;
        this.eventsSettings = eventsSettings;
    }

    public /* synthetic */ EventViewState(Event event, Event event2, Event event3, EventsSettings eventsSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Event(Boolean.FALSE) : event, (i & 2) != 0 ? new Event(Boolean.FALSE) : event2, (i & 4) != 0 ? new Event(Boolean.FALSE) : event3, (i & 8) != 0 ? null : eventsSettings);
    }

    public final EventsSettings getEventsSettings() {
        return this.eventsSettings;
    }
}
