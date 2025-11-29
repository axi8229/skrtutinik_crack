package com.sputnik.common.mappers.profile;

import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SettingsAddress;
import com.sputnik.common.entities.localization.SettingsBody;
import com.sputnik.common.entities.localization.SettingsLocale;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.profile.DomainProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainProfileToProfileMapper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/mappers/profile/DomainProfileToProfileMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "Lcom/sputnik/common/entities/profile/Profile;", "mapper", "Lcom/sputnik/common/mappers/profile/DomainProfileCardInfoToProfileCardInfoMapper;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Lcom/sputnik/common/mappers/profile/DomainProfileCardInfoToProfileCardInfoMapper;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/data/local/PrefManager;)V", "getAddress", "", "input", "map", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainProfileToProfileMapper implements Mapper<DomainProfile, Profile> {
    private final LocalizationStorage localizationStorage;
    private final DomainProfileCardInfoToProfileCardInfoMapper mapper;
    private final PrefManager prefManager;

    public DomainProfileToProfileMapper(DomainProfileCardInfoToProfileCardInfoMapper mapper, LocalizationStorage localizationStorage, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.mapper = mapper;
        this.localizationStorage = localizationStorage;
        this.prefManager = prefManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // com.sputnik.domain.common.Mapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sputnik.common.entities.profile.Profile map(com.sputnik.domain.entities.profile.DomainProfile r39) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.mappers.profile.DomainProfileToProfileMapper.map(com.sputnik.domain.entities.profile.DomainProfile):com.sputnik.common.entities.profile.Profile");
    }

    private final String getAddress(DomainProfile input) {
        SettingsLocale settings;
        SettingsBody body;
        SettingsLocale settings2;
        SettingsBody body2;
        SettingsAddress address;
        String fullAddress;
        SettingsLocale settings3;
        SettingsBody body3;
        SettingsAddress address2;
        String fullAddress2;
        if (input.getApartment() != null) {
            if (input.getAddress() != null) {
                LocalizationLocalModel data = this.localizationStorage.getData();
                if (data == null || (settings3 = data.getSettings()) == null || (body3 = settings3.getBody()) == null || (address2 = body3.getAddress()) == null || (fullAddress2 = address2.getFullAddress()) == null) {
                    return null;
                }
                return StringUtilsKt.formatSafe(fullAddress2, String.valueOf(input.getAddress()), String.valueOf(input.getApartment()));
            }
            LocalizationLocalModel data2 = this.localizationStorage.getData();
            if (data2 == null || (settings2 = data2.getSettings()) == null || (body2 = settings2.getBody()) == null || (address = body2.getAddress()) == null || (fullAddress = address.getFullAddress()) == null) {
                return null;
            }
            return StringUtilsKt.formatSafe(fullAddress, String.valueOf(input.getApartment()), "");
        }
        String address3 = input.getAddress();
        if (address3 != null) {
            return address3;
        }
        LocalizationLocalModel data3 = this.localizationStorage.getData();
        if (data3 == null || (settings = data3.getSettings()) == null || (body = settings.getBody()) == null) {
            return null;
        }
        return body.getNoAddressTitle();
    }
}
