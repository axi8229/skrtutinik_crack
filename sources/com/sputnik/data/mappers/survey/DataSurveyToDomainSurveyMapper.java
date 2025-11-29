package com.sputnik.data.mappers.survey;

import com.sputnik.data.entities.alerts.DataButton;
import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.entities.survey.DataSurveyOption;
import com.sputnik.data.entities.survey.DataSurveySelection;
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

/* compiled from: DataSurveyToDomainSurveyMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/survey/DataSurveyToDomainSurveyMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/survey/DataSurvey;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataSurveyToDomainSurveyMapper implements Mapper<DataSurvey, DomainSurvey> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainSurvey map(DataSurvey input) {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        DomainSurveySelection domainSurveySelection;
        String str2;
        List listEmptyList;
        DataSurvey.DataRichBody.DataNotice notice;
        DataSurvey.DataRichBody.DataNotice notice2;
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
        List<DataSurveyOption> options = input.getOptions();
        if (options != null) {
            List<DataSurveyOption> list = options;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                DataSurveyOption dataSurveyOption = (DataSurveyOption) it.next();
                arrayList3.add(new DomainSurveyOption(dataSurveyOption.getId(), dataSurveyOption.getBody()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        DataSurveySelection selection = input.getSelection();
        DomainSurveySelection domainSurveySelection2 = new DomainSurveySelection(selection != null ? selection.getId() : null, selection != null ? selection.getDescription() : null, selection != null ? selection.getLocalityUuids() : null, selection != null ? selection.getSubscribed() : null, selection != null ? selection.getUnsubscribed() : null);
        String starsTitle = input.getStarsTitle();
        List<DataButton> buttons = input.getButtons();
        if (buttons != null) {
            List<DataButton> list2 = buttons;
            str2 = starsTitle;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                DataButton dataButton = (DataButton) it2.next();
                arrayList4.add(new DomainButton(dataButton.getType(), dataButton.getTitle(), dataButton.getDeeplink(), dataButton.getStyle()));
                it2 = it2;
                domainSurveySelection2 = domainSurveySelection2;
                arrayList = arrayList;
                endDate = endDate;
            }
            str = endDate;
            arrayList2 = arrayList;
            domainSurveySelection = domainSurveySelection2;
            listEmptyList = arrayList4;
        } else {
            str = endDate;
            arrayList2 = arrayList;
            domainSurveySelection = domainSurveySelection2;
            str2 = starsTitle;
            listEmptyList = CollectionsKt.emptyList();
        }
        DataSurvey.DataRichBody richBody = input.getRichBody();
        String body2 = (richBody == null || (notice2 = richBody.getNotice()) == null) ? null : notice2.getBody();
        DataSurvey.DataRichBody richBody2 = input.getRichBody();
        return new DomainSurvey(id, name, multipass, enabled, title, body, stars, timed, multioption, startDate, str, arrayList2, domainSurveySelection, str2, listEmptyList, new DomainSurvey.DomainRichBody(new DomainSurvey.DomainRichBody.DomainNotice(body2, (richBody2 == null || (notice = richBody2.getNotice()) == null) ? null : notice.getParam())));
    }
}
