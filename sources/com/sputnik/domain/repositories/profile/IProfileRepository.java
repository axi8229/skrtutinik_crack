package com.sputnik.domain.repositories.profile;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.DomainProfile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IProfileRepository.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u0003H&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u000bH&J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u000bH&J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u000bH&J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u001f\u001a\u00020\u000bH&J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&¨\u0006!"}, d2 = {"Lcom/sputnik/domain/repositories/profile/IProfileRepository;", "", "bindToFlat", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "number", "", "addressId", "changeAvatar", "image", "", "deactivateAccount", "deactivateAddress", "id", "deleteAccount", "deleteFr", "getProfile", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "logout", "resetAddress", "sendCallEnabled", "isEnabled", "", "sendPushToken", "token", "sendTimezone", "setLocalization", "localization", "unlinkAddress", "updateUserName", AppMeasurementSdk.ConditionalUserProperty.NAME, "verifyAddress", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IProfileRepository {
    Flow<Resource<Unit>> bindToFlat(int number, int addressId);

    Flow<Resource<Unit>> changeAvatar(String image);

    Flow<Resource<Unit>> deactivateAccount();

    Flow<Resource<Unit>> deactivateAddress(String id);

    Flow<Resource<Unit>> deleteAccount();

    Flow<Resource<Unit>> deleteFr();

    Flow<Resource<DomainProfile>> getProfile();

    Flow<Resource<Unit>> logout();

    Flow<Resource<Unit>> resetAddress();

    Flow<Resource<Unit>> sendCallEnabled(boolean isEnabled);

    Flow<Resource<Unit>> sendPushToken(String token);

    Flow<Resource<Unit>> sendTimezone(String token);

    Flow<Resource<Unit>> setLocalization(String localization);

    Flow<Resource<Unit>> unlinkAddress(String id);

    Flow<Resource<Unit>> updateUserName(String name);

    Flow<Resource<Unit>> verifyAddress(String id);
}
