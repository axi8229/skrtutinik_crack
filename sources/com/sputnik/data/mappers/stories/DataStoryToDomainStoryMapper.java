package com.sputnik.data.mappers.stories;

import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import com.sputnik.domain.entities.stories.DomainStory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataStoryToDomainStoryMapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/data/mappers/stories/DataStoryToDomainStoryMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/stories/DataStory;", "Lcom/sputnik/domain/entities/stories/DomainStory;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/stories/DataStoriesButton;", "Lcom/sputnik/domain/entities/stories/DomainStoriesButton;", "(Lcom/sputnik/domain/common/NullableInputListMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataStoryToDomainStoryMapper implements Mapper<DataStory, DomainStory> {
    private final NullableInputListMapper<DataStoriesButton, DomainStoriesButton> mapper;

    public DataStoryToDomainStoryMapper(NullableInputListMapper<DataStoriesButton, DomainStoriesButton> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainStory map(DataStory input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new DomainStory(input.getId(), input.getVersion(), input.getSet(), input.getOrder(), input.getDuration(), input.getBackground(), input.getScreenshot(), input.getTitle(), input.getDescription(), (List) this.mapper.map(input.getButtons()));
    }
}
