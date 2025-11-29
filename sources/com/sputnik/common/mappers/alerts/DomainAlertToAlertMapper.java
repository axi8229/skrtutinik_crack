package com.sputnik.common.mappers.alerts;

import com.sputnik.common.entities.alerts.Alert;
import com.sputnik.common.entities.alerts.AlertAppearance;
import com.sputnik.common.entities.alerts.Button;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.entities.alers.DomainAlertAppearance;
import com.sputnik.domain.entities.alers.DomainButton;
import com.sputnik.domain.entities.alers.TextWith1Param;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainAlertToAlertMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/alerts/DomainAlertToAlertMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "Lcom/sputnik/common/entities/alerts/Alert;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainAlertToAlertMapper implements Mapper<DomainAlert, Alert> {
    @Override // com.sputnik.domain.common.Mapper
    public Alert map(DomainAlert input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Integer version = input.getVersion();
        Boolean required = input.getRequired();
        DomainAlertAppearance appearance = input.getAppearance();
        TextWith1Param body = appearance != null ? appearance.getBody() : null;
        DomainAlertAppearance appearance2 = input.getAppearance();
        AlertAppearance alertAppearance = new AlertAppearance(body, appearance2 != null ? appearance2.getTitle() : null);
        List<DomainButton> buttons = input.getButtons();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
        for (DomainButton domainButton : buttons) {
            arrayList.add(new Button(domainButton.getType(), domainButton.getTitle(), domainButton.getDeeplink(), null, 8, null));
        }
        return new Alert(version, required, alertAppearance, arrayList);
    }
}
