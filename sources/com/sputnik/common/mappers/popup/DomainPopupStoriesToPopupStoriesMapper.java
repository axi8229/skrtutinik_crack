package com.sputnik.common.mappers.popup;

import com.sputnik.common.entities.popup.Appearance;
import com.sputnik.common.entities.popup.Background;
import com.sputnik.common.entities.popup.Bar;
import com.sputnik.common.entities.popup.Button;
import com.sputnik.common.entities.popup.Image;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.popup.Subtitle;
import com.sputnik.common.entities.popup.Title;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.popups.DomainButton;
import com.sputnik.domain.entities.popups.DomainPopupStory;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.entities.popups.DomainSubtitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStoriesToPopupStoriesMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/popup/DomainPopupStoriesToPopupStoriesMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "Lcom/sputnik/common/entities/popup/PopupStoryStructure;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainPopupStoriesToPopupStoriesMapper implements Mapper<DomainPopupStoryStructure, PopupStoryStructure> {
    @Override // com.sputnik.domain.common.Mapper
    public PopupStoryStructure map(DomainPopupStoryStructure input) {
        String text;
        Intrinsics.checkNotNullParameter(input, "input");
        long id = input.getId();
        long version = input.getVersion();
        long priority = input.getPriority();
        String trigger = input.getTrigger();
        List<DomainPopupStory> popupStories = input.getPopupStories();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(popupStories, 10));
        Iterator it = popupStories.iterator();
        while (it.hasNext()) {
            DomainPopupStory domainPopupStory = (DomainPopupStory) it.next();
            long id2 = domainPopupStory.getId();
            long order = domainPopupStory.getOrder();
            Iterator it2 = it;
            Bar bar = new Bar(domainPopupStory.getAppearance().getBar().getTrackColor(), domainPopupStory.getAppearance().getBar().getProgressColor());
            Image image = new Image(domainPopupStory.getAppearance().getImage().getUrl());
            String str = trigger;
            long j = priority;
            long j2 = version;
            Title title = new Title(domainPopupStory.getAppearance().getTitle().getText(), domainPopupStory.getAppearance().getTitle().getTextColor(), domainPopupStory.getAppearance().getTitle().getParam(), domainPopupStory.getAppearance().getTitle().getParamColor());
            List<DomainButton> buttons = domainPopupStory.getAppearance().getButtons();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
            for (DomainButton domainButton : buttons) {
                arrayList2.add(new Button(domainButton.getText(), domainButton.getDeeplink(), domainButton.getTextColor(), domainButton.getBackgroundColor(), domainButton.getAction()));
            }
            DomainSubtitle subtitle = domainPopupStory.getAppearance().getSubtitle();
            if (subtitle == null || (text = subtitle.getText()) == null) {
                text = "";
            }
            DomainSubtitle subtitle2 = domainPopupStory.getAppearance().getSubtitle();
            arrayList.add(new PopupStory(id2, order, new Appearance(bar, image, title, arrayList2, new Subtitle(text, subtitle2 != null ? subtitle2.getTextColor() : null), new Background(domainPopupStory.getAppearance().getBackground().getUrl(), domainPopupStory.getAppearance().getBackground().getColor())), false, 8, null));
            it = it2;
            trigger = str;
            priority = j;
            version = j2;
        }
        return new PopupStoryStructure(id, version, priority, trigger, arrayList);
    }
}
