package com.sputnik.domain.entities.prefs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingSettings.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001:\u00019Bo\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010Jx\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b4\u0010#\"\u0004\b5\u00106R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b7\u0010#\"\u0004\b8\u00106¨\u0006:"}, d2 = {"Lcom/sputnik/domain/entities/prefs/OnboardingSettings;", "", "", "lastShowingAboutOurAppDialogTimestamp", "lastShowingAboutOurUpdatedAppDialogTimestamp", "lastShowingNoBlePermissionsBottomSheetTimestamp", "", "needToShowMoveHistory1", "needToShowMoveHistory2", "needToShowNotificationsSection", "Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "gorservOnboardingSettings", "showBleFeedbackAt", "needToShowGalleryOnboarding", "needToShowArchiveInDevelopmentPopup", "<init>", "(JJJZZLjava/lang/Boolean;Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;Ljava/lang/Long;ZZ)V", "copy", "(JJJZZLjava/lang/Boolean;Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;Ljava/lang/Long;ZZ)Lcom/sputnik/domain/entities/prefs/OnboardingSettings;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getLastShowingAboutOurAppDialogTimestamp", "()J", "getLastShowingAboutOurUpdatedAppDialogTimestamp", "getLastShowingNoBlePermissionsBottomSheetTimestamp", "Z", "getNeedToShowMoveHistory1", "()Z", "getNeedToShowMoveHistory2", "Ljava/lang/Boolean;", "getNeedToShowNotificationsSection", "()Ljava/lang/Boolean;", "setNeedToShowNotificationsSection", "(Ljava/lang/Boolean;)V", "Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "getGorservOnboardingSettings", "()Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "setGorservOnboardingSettings", "(Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;)V", "Ljava/lang/Long;", "getShowBleFeedbackAt", "()Ljava/lang/Long;", "setShowBleFeedbackAt", "(Ljava/lang/Long;)V", "getNeedToShowGalleryOnboarding", "setNeedToShowGalleryOnboarding", "(Z)V", "getNeedToShowArchiveInDevelopmentPopup", "setNeedToShowArchiveInDevelopmentPopup", "GorservOnboardingSettings", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnboardingSettings {
    private GorservOnboardingSettings gorservOnboardingSettings;
    private final long lastShowingAboutOurAppDialogTimestamp;
    private final long lastShowingAboutOurUpdatedAppDialogTimestamp;
    private final long lastShowingNoBlePermissionsBottomSheetTimestamp;
    private boolean needToShowArchiveInDevelopmentPopup;
    private boolean needToShowGalleryOnboarding;
    private final boolean needToShowMoveHistory1;
    private final boolean needToShowMoveHistory2;
    private Boolean needToShowNotificationsSection;
    private Long showBleFeedbackAt;

    public OnboardingSettings() {
        this(0L, 0L, 0L, false, false, null, null, null, false, false, 1023, null);
    }

    public final OnboardingSettings copy(long lastShowingAboutOurAppDialogTimestamp, long lastShowingAboutOurUpdatedAppDialogTimestamp, long lastShowingNoBlePermissionsBottomSheetTimestamp, boolean needToShowMoveHistory1, boolean needToShowMoveHistory2, Boolean needToShowNotificationsSection, GorservOnboardingSettings gorservOnboardingSettings, Long showBleFeedbackAt, boolean needToShowGalleryOnboarding, boolean needToShowArchiveInDevelopmentPopup) {
        Intrinsics.checkNotNullParameter(gorservOnboardingSettings, "gorservOnboardingSettings");
        return new OnboardingSettings(lastShowingAboutOurAppDialogTimestamp, lastShowingAboutOurUpdatedAppDialogTimestamp, lastShowingNoBlePermissionsBottomSheetTimestamp, needToShowMoveHistory1, needToShowMoveHistory2, needToShowNotificationsSection, gorservOnboardingSettings, showBleFeedbackAt, needToShowGalleryOnboarding, needToShowArchiveInDevelopmentPopup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingSettings)) {
            return false;
        }
        OnboardingSettings onboardingSettings = (OnboardingSettings) other;
        return this.lastShowingAboutOurAppDialogTimestamp == onboardingSettings.lastShowingAboutOurAppDialogTimestamp && this.lastShowingAboutOurUpdatedAppDialogTimestamp == onboardingSettings.lastShowingAboutOurUpdatedAppDialogTimestamp && this.lastShowingNoBlePermissionsBottomSheetTimestamp == onboardingSettings.lastShowingNoBlePermissionsBottomSheetTimestamp && this.needToShowMoveHistory1 == onboardingSettings.needToShowMoveHistory1 && this.needToShowMoveHistory2 == onboardingSettings.needToShowMoveHistory2 && Intrinsics.areEqual(this.needToShowNotificationsSection, onboardingSettings.needToShowNotificationsSection) && Intrinsics.areEqual(this.gorservOnboardingSettings, onboardingSettings.gorservOnboardingSettings) && Intrinsics.areEqual(this.showBleFeedbackAt, onboardingSettings.showBleFeedbackAt) && this.needToShowGalleryOnboarding == onboardingSettings.needToShowGalleryOnboarding && this.needToShowArchiveInDevelopmentPopup == onboardingSettings.needToShowArchiveInDevelopmentPopup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.lastShowingAboutOurAppDialogTimestamp) * 31) + Long.hashCode(this.lastShowingAboutOurUpdatedAppDialogTimestamp)) * 31) + Long.hashCode(this.lastShowingNoBlePermissionsBottomSheetTimestamp)) * 31;
        boolean z = this.needToShowMoveHistory1;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z2 = this.needToShowMoveHistory2;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        Boolean bool = this.needToShowNotificationsSection;
        int iHashCode2 = (((i4 + (bool == null ? 0 : bool.hashCode())) * 31) + this.gorservOnboardingSettings.hashCode()) * 31;
        Long l = this.showBleFeedbackAt;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z3 = this.needToShowGalleryOnboarding;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (iHashCode3 + i5) * 31;
        boolean z4 = this.needToShowArchiveInDevelopmentPopup;
        return i6 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        return "OnboardingSettings(lastShowingAboutOurAppDialogTimestamp=" + this.lastShowingAboutOurAppDialogTimestamp + ", lastShowingAboutOurUpdatedAppDialogTimestamp=" + this.lastShowingAboutOurUpdatedAppDialogTimestamp + ", lastShowingNoBlePermissionsBottomSheetTimestamp=" + this.lastShowingNoBlePermissionsBottomSheetTimestamp + ", needToShowMoveHistory1=" + this.needToShowMoveHistory1 + ", needToShowMoveHistory2=" + this.needToShowMoveHistory2 + ", needToShowNotificationsSection=" + this.needToShowNotificationsSection + ", gorservOnboardingSettings=" + this.gorservOnboardingSettings + ", showBleFeedbackAt=" + this.showBleFeedbackAt + ", needToShowGalleryOnboarding=" + this.needToShowGalleryOnboarding + ", needToShowArchiveInDevelopmentPopup=" + this.needToShowArchiveInDevelopmentPopup + ")";
    }

    public OnboardingSettings(long j, long j2, long j3, boolean z, boolean z2, Boolean bool, GorservOnboardingSettings gorservOnboardingSettings, Long l, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(gorservOnboardingSettings, "gorservOnboardingSettings");
        this.lastShowingAboutOurAppDialogTimestamp = j;
        this.lastShowingAboutOurUpdatedAppDialogTimestamp = j2;
        this.lastShowingNoBlePermissionsBottomSheetTimestamp = j3;
        this.needToShowMoveHistory1 = z;
        this.needToShowMoveHistory2 = z2;
        this.needToShowNotificationsSection = bool;
        this.gorservOnboardingSettings = gorservOnboardingSettings;
        this.showBleFeedbackAt = l;
        this.needToShowGalleryOnboarding = z3;
        this.needToShowArchiveInDevelopmentPopup = z4;
    }

    public final long getLastShowingAboutOurUpdatedAppDialogTimestamp() {
        return this.lastShowingAboutOurUpdatedAppDialogTimestamp;
    }

    public final long getLastShowingNoBlePermissionsBottomSheetTimestamp() {
        return this.lastShowingNoBlePermissionsBottomSheetTimestamp;
    }

    public final boolean getNeedToShowMoveHistory1() {
        return this.needToShowMoveHistory1;
    }

    public /* synthetic */ OnboardingSettings(long j, long j2, long j3, boolean z, boolean z2, Boolean bool, GorservOnboardingSettings gorservOnboardingSettings, Long l, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        GorservOnboardingSettings gorservOnboardingSettings2;
        long j4 = (i & 1) != 0 ? 0L : j;
        long j5 = (i & 2) != 0 ? 0L : j2;
        long j6 = (i & 4) != 0 ? 0L : j3;
        boolean z5 = (i & 8) != 0 ? true : z;
        boolean z6 = false;
        boolean z7 = (i & 16) != 0 ? false : z2;
        Boolean bool2 = (i & 32) != 0 ? Boolean.TRUE : bool;
        if ((i & 64) != 0) {
            gorservOnboardingSettings2 = new GorservOnboardingSettings(z6, true ? 1 : 0, null);
        } else {
            gorservOnboardingSettings2 = gorservOnboardingSettings;
        }
        this(j4, j5, j6, z5, z7, bool2, gorservOnboardingSettings2, (i & 128) != 0 ? 0L : l, (i & 256) != 0 ? true : z3, (i & 512) == 0 ? z4 : true);
    }

    public final Boolean getNeedToShowNotificationsSection() {
        return this.needToShowNotificationsSection;
    }

    public final GorservOnboardingSettings getGorservOnboardingSettings() {
        return this.gorservOnboardingSettings;
    }

    public final void setGorservOnboardingSettings(GorservOnboardingSettings gorservOnboardingSettings) {
        Intrinsics.checkNotNullParameter(gorservOnboardingSettings, "<set-?>");
        this.gorservOnboardingSettings = gorservOnboardingSettings;
    }

    public final Long getShowBleFeedbackAt() {
        return this.showBleFeedbackAt;
    }

    public final void setShowBleFeedbackAt(Long l) {
        this.showBleFeedbackAt = l;
    }

    public final boolean getNeedToShowGalleryOnboarding() {
        return this.needToShowGalleryOnboarding;
    }

    public final boolean getNeedToShowArchiveInDevelopmentPopup() {
        return this.needToShowArchiveInDevelopmentPopup;
    }

    public final void setNeedToShowArchiveInDevelopmentPopup(boolean z) {
        this.needToShowArchiveInDevelopmentPopup = z;
    }

    /* compiled from: OnboardingSettings.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "", "", "needToShowInstruction", "<init>", "(Z)V", "copy", "(Z)Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getNeedToShowInstruction", "()Z", "setNeedToShowInstruction", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GorservOnboardingSettings {
        private boolean needToShowInstruction;

        public GorservOnboardingSettings() {
            this(false, 1, null);
        }

        public final GorservOnboardingSettings copy(boolean needToShowInstruction) {
            return new GorservOnboardingSettings(needToShowInstruction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GorservOnboardingSettings) && this.needToShowInstruction == ((GorservOnboardingSettings) other).needToShowInstruction;
        }

        public int hashCode() {
            boolean z = this.needToShowInstruction;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "GorservOnboardingSettings(needToShowInstruction=" + this.needToShowInstruction + ")";
        }

        public GorservOnboardingSettings(boolean z) {
            this.needToShowInstruction = z;
        }

        public /* synthetic */ GorservOnboardingSettings(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getNeedToShowInstruction() {
            return this.needToShowInstruction;
        }
    }
}
