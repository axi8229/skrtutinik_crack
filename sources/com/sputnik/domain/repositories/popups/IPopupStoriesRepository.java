package com.sputnik.domain.repositories.popups;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IPopupStoriesRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&J,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;", "", "loadPopupStories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "version", "", "sendAction", "popupId", "", "popupStoryId", "action", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IPopupStoriesRepository {
    Flow<Resource<List<DomainPopupStoryStructure>>> loadPopupStories(int version);

    Flow<Resource<Object>> sendAction(String popupId, String popupStoryId, String action);
}
