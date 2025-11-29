package com.sputnik.common.mappers.localization;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.R$drawable;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.localization.DomainLocalization;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainLocalizationToLocalizationMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/localization/DomainLocalizationToLocalizationMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/localization/DomainLocalization;", "Lcom/sputnik/common/entities/localization/Localization;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainLocalizationToLocalizationMapper implements Mapper<DomainLocalization, Localization> {
    @Override // com.sputnik.domain.common.Mapper
    public Localization map(DomainLocalization input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String id = input.getId();
        String tag = input.getTag();
        Long createdAt = input.getCreatedAt();
        String name = input.getName();
        String platform = input.getPlatform();
        String file = input.getFile();
        boolean current = input.getCurrent();
        Integer num = AndroidConstants.INSTANCE.getLanguageFlags().get(input.getTag());
        return new Localization(id, tag, createdAt, name, platform, file, current, num != null ? num.intValue() : R$drawable.ic_russia);
    }
}
