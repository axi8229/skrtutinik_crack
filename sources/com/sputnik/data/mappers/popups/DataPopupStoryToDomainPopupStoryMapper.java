package com.sputnik.data.mappers.popups;

import com.sputnik.data.entities.popups.DataButton;
import com.sputnik.data.entities.popups.DataPopupStory;
import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.entities.popups.DataSubtitle;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.popups.DomainAppearance;
import com.sputnik.domain.entities.popups.DomainBackground;
import com.sputnik.domain.entities.popups.DomainBar;
import com.sputnik.domain.entities.popups.DomainButton;
import com.sputnik.domain.entities.popups.DomainImage;
import com.sputnik.domain.entities.popups.DomainPopupStory;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.entities.popups.DomainSubtitle;
import com.sputnik.domain.entities.popups.DomainTitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPopupStoryToDomainPopupStoryMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/popups/DataPopupStoryToDomainPopupStoryMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataPopupStoryToDomainPopupStoryMapper implements Mapper<DataPopupStoryStructure, DomainPopupStoryStructure> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainPopupStoryStructure map(DataPopupStoryStructure input) {
        String text;
        Intrinsics.checkNotNullParameter(input, "input");
        long id = input.getId();
        long version = input.getVersion();
        long priority = input.getPriority();
        String trigger = input.getTrigger();
        List<DataPopupStory> popupStories = input.getPopupStories();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(popupStories, 10));
        Iterator it = popupStories.iterator();
        while (it.hasNext()) {
            DataPopupStory dataPopupStory = (DataPopupStory) it.next();
            long id2 = dataPopupStory.getId();
            long order = dataPopupStory.getOrder();
            Iterator it2 = it;
            DomainBar domainBar = new DomainBar(dataPopupStory.getAppearance().getBar().getTrackColor(), dataPopupStory.getAppearance().getBar().getProgressColor());
            DomainImage domainImage = new DomainImage(dataPopupStory.getAppearance().getImage().getUrl());
            String str = trigger;
            long j = priority;
            long j2 = version;
            DomainTitle domainTitle = new DomainTitle(dataPopupStory.getAppearance().getTitle().getText(), dataPopupStory.getAppearance().getTitle().getTextColor(), dataPopupStory.getAppearance().getTitle().getParam(), dataPopupStory.getAppearance().getTitle().getParamColor());
            List<DataButton> buttons = dataPopupStory.getAppearance().getButtons();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
            for (DataButton dataButton : buttons) {
                arrayList2.add(new DomainButton(dataButton.getText(), dataButton.getDeeplink(), dataButton.getTextColor(), dataButton.getBackgroundColor(), dataButton.getAction()));
            }
            DataSubtitle subtitle = dataPopupStory.getAppearance().getSubtitle();
            if (subtitle == null || (text = subtitle.getText()) == null) {
                text = "";
            }
            DataSubtitle subtitle2 = dataPopupStory.getAppearance().getSubtitle();
            arrayList.add(new DomainPopupStory(id2, order, new DomainAppearance(domainBar, domainImage, domainTitle, arrayList2, new DomainSubtitle(text, subtitle2 != null ? subtitle2.getTextColor() : null), new DomainBackground(dataPopupStory.getAppearance().getBackground().getUrl(), dataPopupStory.getAppearance().getBackground().getColor()))));
            it = it2;
            trigger = str;
            priority = j;
            version = j2;
        }
        return new DomainPopupStoryStructure(id, version, priority, trigger, arrayList);
    }
}
