package com.sputnik.common.mappers.surveys;

import com.sputnik.common.entities.alerts.Button;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.entities.surveys.SurveyOption;
import com.sputnik.common.entities.surveys.SurveySelection;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.alers.DomainButton;
import com.sputnik.domain.entities.survey.DomainSurvey;
import com.sputnik.domain.entities.survey.DomainSurveyOption;
import com.sputnik.domain.entities.survey.DomainSurveySelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainSurveyToSurveyMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "Lcom/sputnik/common/entities/surveys/Survey;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainSurveyToSurveyMapper implements Mapper<DomainSurvey, Survey> {
    @Override // com.sputnik.domain.common.Mapper
    public Survey map(DomainSurvey input) {
        List listEmptyList;
        DomainSurvey.DomainRichBody.DomainNotice notice;
        DomainSurvey.DomainRichBody.DomainNotice notice2;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer id = input.getId();
        String name = input.getName();
        Boolean multipass = input.getMultipass();
        Boolean enabled = input.getEnabled();
        String title = input.getTitle();
        String body = input.getBody();
        Boolean stars = input.getStars();
        Boolean timed = input.getTimed();
        Boolean multioption = input.getMultioption();
        String startDate = input.getStartDate();
        String endDate = input.getEndDate();
        List<DomainSurveyOption> options = input.getOptions();
        if (options != null) {
            List<DomainSurveyOption> list = options;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                DomainSurveyOption domainSurveyOption = (DomainSurveyOption) it.next();
                arrayList.add(new SurveyOption(domainSurveyOption.getId(), domainSurveyOption.getBody()));
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        DomainSurveySelection selection = input.getSelection();
        SurveySelection surveySelection = new SurveySelection(selection != null ? selection.getId() : null, selection != null ? selection.getDescription() : null, selection != null ? selection.getLocalityUuids() : null, selection != null ? selection.getSubscribed() : null, selection != null ? selection.getUnsubscribed() : null);
        String starsTitle = input.getStarsTitle();
        List<DomainButton> buttons = input.getButtons();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
        Iterator it2 = buttons.iterator();
        while (it2.hasNext()) {
            DomainButton domainButton = (DomainButton) it2.next();
            arrayList2.add(new Button(domainButton.getType(), domainButton.getTitle(), domainButton.getDeeplink(), Button.Styles.valueOf(String.valueOf(domainButton.getStyle()))));
            it2 = it2;
            surveySelection = surveySelection;
            listEmptyList = listEmptyList;
            endDate = endDate;
        }
        String str = endDate;
        List list2 = listEmptyList;
        SurveySelection surveySelection2 = surveySelection;
        DomainSurvey.DomainRichBody richBody = input.getRichBody();
        String body2 = (richBody == null || (notice2 = richBody.getNotice()) == null) ? null : notice2.getBody();
        DomainSurvey.DomainRichBody richBody2 = input.getRichBody();
        return new Survey(id, name, multipass, enabled, title, body, stars, timed, multioption, startDate, str, list2, surveySelection2, starsTitle, arrayList2, new Survey.RichBody(new Survey.RichBody.Notice(body2, (richBody2 == null || (notice = richBody2.getNotice()) == null) ? null : notice.getParam())));
    }
}
