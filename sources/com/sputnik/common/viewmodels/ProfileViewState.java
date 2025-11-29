package com.sputnik.common.viewmodels;

import com.google.android.gms.common.Scopes;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\u0004\b'\u0010(Jè\u0002\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020\u00102\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b2\u00103R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00104\u001a\u0004\b7\u00106R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b8\u00106R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\b9\u00106R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b=\u0010<R\u001f\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010:\u001a\u0004\bD\u0010<R\u0017\u0010\u0012\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\b\u0012\u0010FR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010:\u001a\u0004\bG\u0010<R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\b\u0015\u0010<R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010:\u001a\u0004\bH\u0010<R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010I\u001a\u0004\bJ\u0010,R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010:\u001a\u0004\bK\u0010<R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\b\u0019\u0010<R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010:\u001a\u0004\b\u001a\u0010<R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010E\u001a\u0004\bQ\u0010F\"\u0004\bR\u0010SR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010:\u001a\u0004\bT\u0010<\"\u0004\bU\u0010VR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010:\u001a\u0004\b\u001f\u0010<\"\u0004\bW\u0010VR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010E\u001a\u0004\b\"\u0010F\"\u0004\b]\u0010SR(\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010:\u001a\u0004\bc\u0010<\"\u0004\bd\u0010V¨\u0006e"}, d2 = {"Lcom/sputnik/common/viewmodels/ProfileViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "addressServerState", "flatServerState", "profileServerState", "Lcom/sputnik/domain/common/Event;", "", "pushTokenServerState", "timezoneServerState", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lcom/sputnik/common/entities/profile/Profile;", Scopes.PROFILE, "", "needUpdate", "isShowLoader", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "profileState", "isDeactivated", "flatError", "userLocale", "localizationNeedUpdate", "isImageUpdated", "isRateLike", "Lcom/sputnik/common/BlockingLevel;", "blockLevel", "needToShowBlockedDialog", "needToClearNavigationState", "isAccountDeleted", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "localProfile", "isAppLoaded", "", "Lcom/sputnik/common/entities/addresses/UserAddress;", "currentAddresses", "needReloadForNewAddress", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/Exception;Lcom/sputnik/common/entities/profile/Profile;Lcom/sputnik/domain/common/Event;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/BlockingLevel;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/prefs/LoginState$Session;ZLjava/util/List;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/Exception;Lcom/sputnik/common/entities/profile/Profile;Lcom/sputnik/domain/common/Event;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/BlockingLevel;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/entities/prefs/LoginState$Session;ZLjava/util/List;Lcom/sputnik/domain/common/Event;)Lcom/sputnik/common/viewmodels/ProfileViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getAddressServerState", "getFlatServerState", "getProfileServerState", "Lcom/sputnik/domain/common/Event;", "getPushTokenServerState", "()Lcom/sputnik/domain/common/Event;", "getTimezoneServerState", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Lcom/sputnik/common/entities/profile/Profile;", "getProfile", "()Lcom/sputnik/common/entities/profile/Profile;", "getNeedUpdate", "Z", "()Z", "getProfileState", "getFlatError", "Ljava/lang/String;", "getUserLocale", "getLocalizationNeedUpdate", "Lcom/sputnik/common/BlockingLevel;", "getBlockLevel", "()Lcom/sputnik/common/BlockingLevel;", "setBlockLevel", "(Lcom/sputnik/common/BlockingLevel;)V", "getNeedToShowBlockedDialog", "setNeedToShowBlockedDialog", "(Z)V", "getNeedToClearNavigationState", "setNeedToClearNavigationState", "(Lcom/sputnik/domain/common/Event;)V", "setAccountDeleted", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "getLocalProfile", "()Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "setLocalProfile", "(Lcom/sputnik/domain/entities/prefs/LoginState$Session;)V", "setAppLoaded", "Ljava/util/List;", "getCurrentAddresses", "()Ljava/util/List;", "setCurrentAddresses", "(Ljava/util/List;)V", "getNeedReloadForNewAddress", "setNeedReloadForNewAddress", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProfileViewState implements VMState {
    private final Resource.Status addressServerState;
    private BlockingLevel blockLevel;
    private List<UserAddress> currentAddresses;
    private final Exception exception;
    private final Event<Boolean> flatError;
    private final Resource.Status flatServerState;
    private Event<Boolean> isAccountDeleted;
    private boolean isAppLoaded;
    private final Event<Boolean> isDeactivated;
    private final Event<Boolean> isImageUpdated;
    private final Event<Boolean> isRateLike;
    private final boolean isShowLoader;
    private LoginState.Session localProfile;
    private final Event<Boolean> localizationNeedUpdate;
    private Event<Boolean> needReloadForNewAddress;
    private Event<Boolean> needToClearNavigationState;
    private boolean needToShowBlockedDialog;
    private final Event<Boolean> needUpdate;
    private final Profile profile;
    private final Resource.Status profileServerState;
    private final Event<ProfileNavigationState> profileState;
    private final Event<String> pushTokenServerState;
    private final Resource.Status serverState;
    private final Event<String> timezoneServerState;
    private final String userLocale;

    public ProfileViewState() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, 33554431, null);
    }

    public final ProfileViewState copy(Resource.Status serverState, Resource.Status addressServerState, Resource.Status flatServerState, Resource.Status profileServerState, Event<String> pushTokenServerState, Event<String> timezoneServerState, Exception exception, Profile profile, Event<Boolean> needUpdate, boolean isShowLoader, Event<? extends ProfileNavigationState> profileState, Event<Boolean> isDeactivated, Event<Boolean> flatError, String userLocale, Event<Boolean> localizationNeedUpdate, Event<Boolean> isImageUpdated, Event<Boolean> isRateLike, BlockingLevel blockLevel, boolean needToShowBlockedDialog, Event<Boolean> needToClearNavigationState, Event<Boolean> isAccountDeleted, LoginState.Session localProfile, boolean isAppLoaded, List<UserAddress> currentAddresses, Event<Boolean> needReloadForNewAddress) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(addressServerState, "addressServerState");
        Intrinsics.checkNotNullParameter(flatServerState, "flatServerState");
        Intrinsics.checkNotNullParameter(profileServerState, "profileServerState");
        Intrinsics.checkNotNullParameter(pushTokenServerState, "pushTokenServerState");
        Intrinsics.checkNotNullParameter(timezoneServerState, "timezoneServerState");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        Intrinsics.checkNotNullParameter(isDeactivated, "isDeactivated");
        Intrinsics.checkNotNullParameter(flatError, "flatError");
        Intrinsics.checkNotNullParameter(localizationNeedUpdate, "localizationNeedUpdate");
        Intrinsics.checkNotNullParameter(isImageUpdated, "isImageUpdated");
        Intrinsics.checkNotNullParameter(isRateLike, "isRateLike");
        Intrinsics.checkNotNullParameter(needToClearNavigationState, "needToClearNavigationState");
        Intrinsics.checkNotNullParameter(isAccountDeleted, "isAccountDeleted");
        Intrinsics.checkNotNullParameter(currentAddresses, "currentAddresses");
        Intrinsics.checkNotNullParameter(needReloadForNewAddress, "needReloadForNewAddress");
        return new ProfileViewState(serverState, addressServerState, flatServerState, profileServerState, pushTokenServerState, timezoneServerState, exception, profile, needUpdate, isShowLoader, profileState, isDeactivated, flatError, userLocale, localizationNeedUpdate, isImageUpdated, isRateLike, blockLevel, needToShowBlockedDialog, needToClearNavigationState, isAccountDeleted, localProfile, isAppLoaded, currentAddresses, needReloadForNewAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileViewState)) {
            return false;
        }
        ProfileViewState profileViewState = (ProfileViewState) other;
        return this.serverState == profileViewState.serverState && this.addressServerState == profileViewState.addressServerState && this.flatServerState == profileViewState.flatServerState && this.profileServerState == profileViewState.profileServerState && Intrinsics.areEqual(this.pushTokenServerState, profileViewState.pushTokenServerState) && Intrinsics.areEqual(this.timezoneServerState, profileViewState.timezoneServerState) && Intrinsics.areEqual(this.exception, profileViewState.exception) && Intrinsics.areEqual(this.profile, profileViewState.profile) && Intrinsics.areEqual(this.needUpdate, profileViewState.needUpdate) && this.isShowLoader == profileViewState.isShowLoader && Intrinsics.areEqual(this.profileState, profileViewState.profileState) && Intrinsics.areEqual(this.isDeactivated, profileViewState.isDeactivated) && Intrinsics.areEqual(this.flatError, profileViewState.flatError) && Intrinsics.areEqual(this.userLocale, profileViewState.userLocale) && Intrinsics.areEqual(this.localizationNeedUpdate, profileViewState.localizationNeedUpdate) && Intrinsics.areEqual(this.isImageUpdated, profileViewState.isImageUpdated) && Intrinsics.areEqual(this.isRateLike, profileViewState.isRateLike) && this.blockLevel == profileViewState.blockLevel && this.needToShowBlockedDialog == profileViewState.needToShowBlockedDialog && Intrinsics.areEqual(this.needToClearNavigationState, profileViewState.needToClearNavigationState) && Intrinsics.areEqual(this.isAccountDeleted, profileViewState.isAccountDeleted) && Intrinsics.areEqual(this.localProfile, profileViewState.localProfile) && this.isAppLoaded == profileViewState.isAppLoaded && Intrinsics.areEqual(this.currentAddresses, profileViewState.currentAddresses) && Intrinsics.areEqual(this.needReloadForNewAddress, profileViewState.needReloadForNewAddress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((((((this.serverState.hashCode() * 31) + this.addressServerState.hashCode()) * 31) + this.flatServerState.hashCode()) * 31) + this.profileServerState.hashCode()) * 31) + this.pushTokenServerState.hashCode()) * 31) + this.timezoneServerState.hashCode()) * 31;
        Exception exc = this.exception;
        int iHashCode2 = (iHashCode + (exc == null ? 0 : exc.hashCode())) * 31;
        Profile profile = this.profile;
        int iHashCode3 = (((iHashCode2 + (profile == null ? 0 : profile.hashCode())) * 31) + this.needUpdate.hashCode()) * 31;
        boolean z = this.isShowLoader;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iHashCode4 = (((((((iHashCode3 + i) * 31) + this.profileState.hashCode()) * 31) + this.isDeactivated.hashCode()) * 31) + this.flatError.hashCode()) * 31;
        String str = this.userLocale;
        int iHashCode5 = (((((((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + this.localizationNeedUpdate.hashCode()) * 31) + this.isImageUpdated.hashCode()) * 31) + this.isRateLike.hashCode()) * 31;
        BlockingLevel blockingLevel = this.blockLevel;
        int iHashCode6 = (iHashCode5 + (blockingLevel == null ? 0 : blockingLevel.hashCode())) * 31;
        boolean z2 = this.needToShowBlockedDialog;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int iHashCode7 = (((((iHashCode6 + i2) * 31) + this.needToClearNavigationState.hashCode()) * 31) + this.isAccountDeleted.hashCode()) * 31;
        LoginState.Session session = this.localProfile;
        int iHashCode8 = (iHashCode7 + (session != null ? session.hashCode() : 0)) * 31;
        boolean z3 = this.isAppLoaded;
        return ((((iHashCode8 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.currentAddresses.hashCode()) * 31) + this.needReloadForNewAddress.hashCode();
    }

    public String toString() {
        return "ProfileViewState(serverState=" + this.serverState + ", addressServerState=" + this.addressServerState + ", flatServerState=" + this.flatServerState + ", profileServerState=" + this.profileServerState + ", pushTokenServerState=" + this.pushTokenServerState + ", timezoneServerState=" + this.timezoneServerState + ", exception=" + this.exception + ", profile=" + this.profile + ", needUpdate=" + this.needUpdate + ", isShowLoader=" + this.isShowLoader + ", profileState=" + this.profileState + ", isDeactivated=" + this.isDeactivated + ", flatError=" + this.flatError + ", userLocale=" + this.userLocale + ", localizationNeedUpdate=" + this.localizationNeedUpdate + ", isImageUpdated=" + this.isImageUpdated + ", isRateLike=" + this.isRateLike + ", blockLevel=" + this.blockLevel + ", needToShowBlockedDialog=" + this.needToShowBlockedDialog + ", needToClearNavigationState=" + this.needToClearNavigationState + ", isAccountDeleted=" + this.isAccountDeleted + ", localProfile=" + this.localProfile + ", isAppLoaded=" + this.isAppLoaded + ", currentAddresses=" + this.currentAddresses + ", needReloadForNewAddress=" + this.needReloadForNewAddress + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileViewState(Resource.Status serverState, Resource.Status addressServerState, Resource.Status flatServerState, Resource.Status profileServerState, Event<String> pushTokenServerState, Event<String> timezoneServerState, Exception exc, Profile profile, Event<Boolean> needUpdate, boolean z, Event<? extends ProfileNavigationState> profileState, Event<Boolean> isDeactivated, Event<Boolean> flatError, String str, Event<Boolean> localizationNeedUpdate, Event<Boolean> isImageUpdated, Event<Boolean> isRateLike, BlockingLevel blockingLevel, boolean z2, Event<Boolean> needToClearNavigationState, Event<Boolean> isAccountDeleted, LoginState.Session session, boolean z3, List<UserAddress> currentAddresses, Event<Boolean> needReloadForNewAddress) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(addressServerState, "addressServerState");
        Intrinsics.checkNotNullParameter(flatServerState, "flatServerState");
        Intrinsics.checkNotNullParameter(profileServerState, "profileServerState");
        Intrinsics.checkNotNullParameter(pushTokenServerState, "pushTokenServerState");
        Intrinsics.checkNotNullParameter(timezoneServerState, "timezoneServerState");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        Intrinsics.checkNotNullParameter(isDeactivated, "isDeactivated");
        Intrinsics.checkNotNullParameter(flatError, "flatError");
        Intrinsics.checkNotNullParameter(localizationNeedUpdate, "localizationNeedUpdate");
        Intrinsics.checkNotNullParameter(isImageUpdated, "isImageUpdated");
        Intrinsics.checkNotNullParameter(isRateLike, "isRateLike");
        Intrinsics.checkNotNullParameter(needToClearNavigationState, "needToClearNavigationState");
        Intrinsics.checkNotNullParameter(isAccountDeleted, "isAccountDeleted");
        Intrinsics.checkNotNullParameter(currentAddresses, "currentAddresses");
        Intrinsics.checkNotNullParameter(needReloadForNewAddress, "needReloadForNewAddress");
        this.serverState = serverState;
        this.addressServerState = addressServerState;
        this.flatServerState = flatServerState;
        this.profileServerState = profileServerState;
        this.pushTokenServerState = pushTokenServerState;
        this.timezoneServerState = timezoneServerState;
        this.exception = exc;
        this.profile = profile;
        this.needUpdate = needUpdate;
        this.isShowLoader = z;
        this.profileState = profileState;
        this.isDeactivated = isDeactivated;
        this.flatError = flatError;
        this.userLocale = str;
        this.localizationNeedUpdate = localizationNeedUpdate;
        this.isImageUpdated = isImageUpdated;
        this.isRateLike = isRateLike;
        this.blockLevel = blockingLevel;
        this.needToShowBlockedDialog = z2;
        this.needToClearNavigationState = needToClearNavigationState;
        this.isAccountDeleted = isAccountDeleted;
        this.localProfile = session;
        this.isAppLoaded = z3;
        this.currentAddresses = currentAddresses;
        this.needReloadForNewAddress = needReloadForNewAddress;
    }

    public /* synthetic */ ProfileViewState(Resource.Status status, Resource.Status status2, Resource.Status status3, Resource.Status status4, Event event, Event event2, Exception exc, Profile profile, Event event3, boolean z, Event event4, Event event5, Event event6, String str, Event event7, Event event8, Event event9, BlockingLevel blockingLevel, boolean z2, Event event10, Event event11, LoginState.Session session, boolean z3, List list, Event event12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        Event event13;
        Event event14;
        Event event15;
        Event event16;
        Event event17;
        BlockingLevel blockingLevel2;
        Event event18;
        Event event19;
        Event event20;
        Event event21;
        LoginState.Session session2;
        Event event22;
        Resource.Status status5 = (i & 1) != 0 ? Resource.Status.NONE : status;
        Resource.Status status6 = (i & 2) != 0 ? Resource.Status.NONE : status2;
        Resource.Status status7 = (i & 4) != 0 ? Resource.Status.NONE : status3;
        Resource.Status status8 = (i & 8) != 0 ? Resource.Status.NONE : status4;
        Event event23 = (i & 16) != 0 ? new Event("") : event;
        Event event24 = (i & 32) != 0 ? new Event("") : event2;
        Exception exc2 = (i & 64) != 0 ? null : exc;
        Profile profile2 = (i & 128) != 0 ? null : profile;
        Event event25 = (i & 256) != 0 ? new Event(Boolean.TRUE) : event3;
        boolean z4 = (i & 512) != 0 ? false : z;
        Event event26 = (i & 1024) != 0 ? new Event(new ProfileNavigationState.Default()) : event4;
        Event event27 = (i & 2048) != 0 ? new Event(Boolean.FALSE) : event5;
        Event event28 = (i & 4096) != 0 ? new Event(Boolean.FALSE) : event6;
        String str3 = (i & 8192) != 0 ? null : str;
        if ((i & 16384) != 0) {
            str2 = str3;
            event13 = new Event(Boolean.FALSE);
        } else {
            str2 = str3;
            event13 = event7;
        }
        if ((32768 & i) != 0) {
            event14 = event13;
            event15 = new Event(Boolean.FALSE);
        } else {
            event14 = event13;
            event15 = event8;
        }
        if ((65536 & i) != 0) {
            event16 = event15;
            event17 = new Event(Boolean.FALSE);
        } else {
            event16 = event15;
            event17 = event9;
        }
        BlockingLevel blockingLevel3 = (131072 & i) != 0 ? null : blockingLevel;
        boolean z5 = (i & 262144) != 0 ? false : z2;
        if ((i & 524288) != 0) {
            blockingLevel2 = blockingLevel3;
            event18 = event17;
            event19 = new Event(Boolean.FALSE);
        } else {
            blockingLevel2 = blockingLevel3;
            event18 = event17;
            event19 = event10;
        }
        if ((1048576 & i) != 0) {
            event20 = event19;
            event21 = new Event(Boolean.FALSE);
        } else {
            event20 = event19;
            event21 = event11;
        }
        LoginState.Session session3 = (2097152 & i) != 0 ? null : session;
        boolean z6 = (i & 4194304) != 0 ? false : z3;
        List arrayList = (i & 8388608) != 0 ? new ArrayList() : list;
        if ((i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            session2 = session3;
            event22 = new Event(Boolean.FALSE);
        } else {
            session2 = session3;
            event22 = event12;
        }
        this(status5, status6, status7, status8, event23, event24, exc2, profile2, event25, z4, event26, event27, event28, str2, event14, event16, event18, blockingLevel2, z5, event20, event21, session2, z6, arrayList, event22);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getAddressServerState() {
        return this.addressServerState;
    }

    public final Resource.Status getFlatServerState() {
        return this.flatServerState;
    }

    public final Resource.Status getProfileServerState() {
        return this.profileServerState;
    }

    public final Event<String> getPushTokenServerState() {
        return this.pushTokenServerState;
    }

    public final Event<String> getTimezoneServerState() {
        return this.timezoneServerState;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final Profile getProfile() {
        return this.profile;
    }

    public final Event<Boolean> getNeedUpdate() {
        return this.needUpdate;
    }

    /* renamed from: isShowLoader, reason: from getter */
    public final boolean getIsShowLoader() {
        return this.isShowLoader;
    }

    public final Event<ProfileNavigationState> getProfileState() {
        return this.profileState;
    }

    public final Event<Boolean> isDeactivated() {
        return this.isDeactivated;
    }

    public final Event<Boolean> getFlatError() {
        return this.flatError;
    }

    public final String getUserLocale() {
        return this.userLocale;
    }

    public final Event<Boolean> getLocalizationNeedUpdate() {
        return this.localizationNeedUpdate;
    }

    public final Event<Boolean> isImageUpdated() {
        return this.isImageUpdated;
    }

    public final Event<Boolean> isRateLike() {
        return this.isRateLike;
    }

    public final BlockingLevel getBlockLevel() {
        return this.blockLevel;
    }

    public final Event<Boolean> getNeedToClearNavigationState() {
        return this.needToClearNavigationState;
    }

    public final Event<Boolean> isAccountDeleted() {
        return this.isAccountDeleted;
    }

    /* renamed from: isAppLoaded, reason: from getter */
    public final boolean getIsAppLoaded() {
        return this.isAppLoaded;
    }

    public final List<UserAddress> getCurrentAddresses() {
        return this.currentAddresses;
    }

    public final Event<Boolean> getNeedReloadForNewAddress() {
        return this.needReloadForNewAddress;
    }
}
