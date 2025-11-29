package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.mappers.country_code.DomainCountryCodeToCountryCodeMapper;
import com.sputnik.common.mappers.localization.DomainLocalizationToLocalizationMapper;
import com.sputnik.common.mappers.popup.DomainPopupStoriesToPopupStoriesMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.ListMapperImpl;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.NullableInputListMapperImpl;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.entities.localization.DomainLocalization;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCommonListMapperModule.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0007\u001a\u00020\u0010H\u0007J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0007\u001a\u00020\u0015H\u0007¨\u0006\u0016"}, d2 = {"Lcom/sputnik/common/di/mappers/DomainCommonListMapperModule;", "", "()V", "provideDomainCameraToCamera", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "Lcom/sputnik/common/entities/camera/Camera;", "mapper", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "provideDomainCountryCodeToCountryCode", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "Lcom/sputnik/common/entities/country_code/CountryCode;", "Lcom/sputnik/common/mappers/country_code/DomainCountryCodeToCountryCodeMapper;", "provideDomainLocalizationToLocalization", "Lcom/sputnik/domain/entities/localization/DomainLocalization;", "Lcom/sputnik/common/entities/localization/Localization;", "Lcom/sputnik/common/mappers/localization/DomainLocalizationToLocalizationMapper;", "provideDomainPopupStoriesToPopupStories", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "Lcom/sputnik/common/entities/popup/PopupStoryStructure;", "Lcom/sputnik/common/mappers/popup/DomainPopupStoriesToPopupStoriesMapper;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainCommonListMapperModule {
    public final ListMapper<DomainLocalization, Localization> provideDomainLocalizationToLocalization(DomainLocalizationToLocalizationMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainCountryCode, CountryCode> provideDomainCountryCodeToCountryCode(DomainCountryCodeToCountryCodeMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainCamera, Camera> provideDomainCameraToCamera(DomainCameraToCameraMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> provideDomainPopupStoriesToPopupStories(DomainPopupStoriesToPopupStoriesMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }
}
