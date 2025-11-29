package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJz\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b \u0010\u001bR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/sputnik/common/viewmodels/OnboardingViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Event;", "", "needToShowAboutOurHomeDialog", "needToShowMoveHistory1", "needToShowMoveHistory2", "needToShowNotificationsSection", "needToShowBleFeedback", "needToShowGalleryOnboarding", "dontShowGalleryOnboarding", "<init>", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Z)V", "copy", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Z)Lcom/sputnik/common/viewmodels/OnboardingViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Event;", "getNeedToShowAboutOurHomeDialog", "()Lcom/sputnik/domain/common/Event;", "getNeedToShowMoveHistory1", "getNeedToShowMoveHistory2", "getNeedToShowNotificationsSection", "getNeedToShowBleFeedback", "getNeedToShowGalleryOnboarding", "Z", "getDontShowGalleryOnboarding", "()Z", "setDontShowGalleryOnboarding", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnboardingViewState implements VMState {
    private boolean dontShowGalleryOnboarding;
    private final Event<Boolean> needToShowAboutOurHomeDialog;
    private final Event<Boolean> needToShowBleFeedback;
    private final Event<Boolean> needToShowGalleryOnboarding;
    private final Event<Boolean> needToShowMoveHistory1;
    private final Event<Boolean> needToShowMoveHistory2;
    private final Event<Boolean> needToShowNotificationsSection;

    public OnboardingViewState() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public static /* synthetic */ OnboardingViewState copy$default(OnboardingViewState onboardingViewState, Event event, Event event2, Event event3, Event event4, Event event5, Event event6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            event = onboardingViewState.needToShowAboutOurHomeDialog;
        }
        if ((i & 2) != 0) {
            event2 = onboardingViewState.needToShowMoveHistory1;
        }
        Event event7 = event2;
        if ((i & 4) != 0) {
            event3 = onboardingViewState.needToShowMoveHistory2;
        }
        Event event8 = event3;
        if ((i & 8) != 0) {
            event4 = onboardingViewState.needToShowNotificationsSection;
        }
        Event event9 = event4;
        if ((i & 16) != 0) {
            event5 = onboardingViewState.needToShowBleFeedback;
        }
        Event event10 = event5;
        if ((i & 32) != 0) {
            event6 = onboardingViewState.needToShowGalleryOnboarding;
        }
        Event event11 = event6;
        if ((i & 64) != 0) {
            z = onboardingViewState.dontShowGalleryOnboarding;
        }
        return onboardingViewState.copy(event, event7, event8, event9, event10, event11, z);
    }

    public final OnboardingViewState copy(Event<Boolean> needToShowAboutOurHomeDialog, Event<Boolean> needToShowMoveHistory1, Event<Boolean> needToShowMoveHistory2, Event<Boolean> needToShowNotificationsSection, Event<Boolean> needToShowBleFeedback, Event<Boolean> needToShowGalleryOnboarding, boolean dontShowGalleryOnboarding) {
        Intrinsics.checkNotNullParameter(needToShowAboutOurHomeDialog, "needToShowAboutOurHomeDialog");
        Intrinsics.checkNotNullParameter(needToShowMoveHistory1, "needToShowMoveHistory1");
        Intrinsics.checkNotNullParameter(needToShowMoveHistory2, "needToShowMoveHistory2");
        Intrinsics.checkNotNullParameter(needToShowNotificationsSection, "needToShowNotificationsSection");
        Intrinsics.checkNotNullParameter(needToShowBleFeedback, "needToShowBleFeedback");
        Intrinsics.checkNotNullParameter(needToShowGalleryOnboarding, "needToShowGalleryOnboarding");
        return new OnboardingViewState(needToShowAboutOurHomeDialog, needToShowMoveHistory1, needToShowMoveHistory2, needToShowNotificationsSection, needToShowBleFeedback, needToShowGalleryOnboarding, dontShowGalleryOnboarding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingViewState)) {
            return false;
        }
        OnboardingViewState onboardingViewState = (OnboardingViewState) other;
        return Intrinsics.areEqual(this.needToShowAboutOurHomeDialog, onboardingViewState.needToShowAboutOurHomeDialog) && Intrinsics.areEqual(this.needToShowMoveHistory1, onboardingViewState.needToShowMoveHistory1) && Intrinsics.areEqual(this.needToShowMoveHistory2, onboardingViewState.needToShowMoveHistory2) && Intrinsics.areEqual(this.needToShowNotificationsSection, onboardingViewState.needToShowNotificationsSection) && Intrinsics.areEqual(this.needToShowBleFeedback, onboardingViewState.needToShowBleFeedback) && Intrinsics.areEqual(this.needToShowGalleryOnboarding, onboardingViewState.needToShowGalleryOnboarding) && this.dontShowGalleryOnboarding == onboardingViewState.dontShowGalleryOnboarding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((((((this.needToShowAboutOurHomeDialog.hashCode() * 31) + this.needToShowMoveHistory1.hashCode()) * 31) + this.needToShowMoveHistory2.hashCode()) * 31) + this.needToShowNotificationsSection.hashCode()) * 31) + this.needToShowBleFeedback.hashCode()) * 31) + this.needToShowGalleryOnboarding.hashCode()) * 31;
        boolean z = this.dontShowGalleryOnboarding;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "OnboardingViewState(needToShowAboutOurHomeDialog=" + this.needToShowAboutOurHomeDialog + ", needToShowMoveHistory1=" + this.needToShowMoveHistory1 + ", needToShowMoveHistory2=" + this.needToShowMoveHistory2 + ", needToShowNotificationsSection=" + this.needToShowNotificationsSection + ", needToShowBleFeedback=" + this.needToShowBleFeedback + ", needToShowGalleryOnboarding=" + this.needToShowGalleryOnboarding + ", dontShowGalleryOnboarding=" + this.dontShowGalleryOnboarding + ")";
    }

    public OnboardingViewState(Event<Boolean> needToShowAboutOurHomeDialog, Event<Boolean> needToShowMoveHistory1, Event<Boolean> needToShowMoveHistory2, Event<Boolean> needToShowNotificationsSection, Event<Boolean> needToShowBleFeedback, Event<Boolean> needToShowGalleryOnboarding, boolean z) {
        Intrinsics.checkNotNullParameter(needToShowAboutOurHomeDialog, "needToShowAboutOurHomeDialog");
        Intrinsics.checkNotNullParameter(needToShowMoveHistory1, "needToShowMoveHistory1");
        Intrinsics.checkNotNullParameter(needToShowMoveHistory2, "needToShowMoveHistory2");
        Intrinsics.checkNotNullParameter(needToShowNotificationsSection, "needToShowNotificationsSection");
        Intrinsics.checkNotNullParameter(needToShowBleFeedback, "needToShowBleFeedback");
        Intrinsics.checkNotNullParameter(needToShowGalleryOnboarding, "needToShowGalleryOnboarding");
        this.needToShowAboutOurHomeDialog = needToShowAboutOurHomeDialog;
        this.needToShowMoveHistory1 = needToShowMoveHistory1;
        this.needToShowMoveHistory2 = needToShowMoveHistory2;
        this.needToShowNotificationsSection = needToShowNotificationsSection;
        this.needToShowBleFeedback = needToShowBleFeedback;
        this.needToShowGalleryOnboarding = needToShowGalleryOnboarding;
        this.dontShowGalleryOnboarding = z;
    }

    public /* synthetic */ OnboardingViewState(Event event, Event event2, Event event3, Event event4, Event event5, Event event6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Event(Boolean.FALSE) : event, (i & 2) != 0 ? new Event(Boolean.FALSE) : event2, (i & 4) != 0 ? new Event(Boolean.FALSE) : event3, (i & 8) != 0 ? new Event(Boolean.FALSE) : event4, (i & 16) != 0 ? new Event(Boolean.FALSE) : event5, (i & 32) != 0 ? new Event(Boolean.FALSE) : event6, (i & 64) != 0 ? false : z);
    }

    public final Event<Boolean> getNeedToShowMoveHistory2() {
        return this.needToShowMoveHistory2;
    }

    public final Event<Boolean> getNeedToShowBleFeedback() {
        return this.needToShowBleFeedback;
    }

    public final Event<Boolean> getNeedToShowGalleryOnboarding() {
        return this.needToShowGalleryOnboarding;
    }

    public final boolean getDontShowGalleryOnboarding() {
        return this.dontShowGalleryOnboarding;
    }
}
