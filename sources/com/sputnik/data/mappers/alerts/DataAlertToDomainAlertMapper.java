package com.sputnik.data.mappers.alerts;

import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.data.entities.alerts.DataButton;
import com.sputnik.data.entities.common.TextWith1Param;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.entities.alers.DomainAlertAppearance;
import com.sputnik.domain.entities.alers.DomainButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataAlertToDomainAlertMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/alerts/DataAlertToDomainAlertMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/alerts/DataAlert;", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataAlertToDomainAlertMapper implements Mapper<DataAlert, DomainAlert> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainAlert map(DataAlert input) {
        TextWith1Param body;
        TextWith1Param body2;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer version = input.getVersion();
        Boolean required = input.getRequired();
        DataAlert.DataAlertAppearance appearance = input.getAppearance();
        String text = (appearance == null || (body2 = appearance.getBody()) == null) ? null : body2.getText();
        DataAlert.DataAlertAppearance appearance2 = input.getAppearance();
        com.sputnik.domain.entities.alers.TextWith1Param textWith1Param = new com.sputnik.domain.entities.alers.TextWith1Param(text, (appearance2 == null || (body = appearance2.getBody()) == null) ? null : body.getParam1());
        DataAlert.DataAlertAppearance appearance3 = input.getAppearance();
        DomainAlertAppearance domainAlertAppearance = new DomainAlertAppearance(textWith1Param, appearance3 != null ? appearance3.getTitle() : null);
        List<DataButton> buttons = input.getButtons();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
        for (DataButton dataButton : buttons) {
            arrayList.add(new DomainButton(dataButton.getType(), dataButton.getTitle(), dataButton.getDeeplink(), null, 8, null));
        }
        return new DomainAlert(version, required, domainAlertAppearance, arrayList);
    }
}
