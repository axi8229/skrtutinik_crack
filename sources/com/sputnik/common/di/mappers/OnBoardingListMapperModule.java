package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.mappers.stories.DomainStoryButtonToStoryButtonMapper;
import com.sputnik.common.mappers.stories.DomainStoryToStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.NullableInputListMapperImpl;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import com.sputnik.domain.entities.stories.DomainStory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingListMapperModule.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/sputnik/common/di/mappers/OnBoardingListMapperModule;", "", "()V", "provideDomainStoryButtonToStoryButton", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/stories/DomainStoriesButton;", "Lcom/sputnik/common/entities/stories/StoryButton;", "mapper", "Lcom/sputnik/common/mappers/stories/DomainStoryButtonToStoryButtonMapper;", "provideDomainStoryToStory", "Lcom/sputnik/domain/entities/stories/DomainStory;", "Lcom/sputnik/common/entities/stories/Story;", "Lcom/sputnik/common/mappers/stories/DomainStoryToStoryMapper;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBoardingListMapperModule {
    public final NullableInputListMapper<DomainStory, Story> provideDomainStoryToStory(DomainStoryToStoryMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DomainStoriesButton, StoryButton> provideDomainStoryButtonToStoryButton(DomainStoryButtonToStoryButtonMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }
}
