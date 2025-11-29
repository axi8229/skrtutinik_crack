package com.sputnik.domain.usecases.survey;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.repositories.survey.ISurveyRepository;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SendFeedbackUseCase.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sputnik/domain/usecases/survey/SendFeedbackUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/survey/ISurveyRepository;", "(Lcom/sputnik/domain/repositories/survey/ISurveyRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "like", "", "issues", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendFeedbackUseCase {
    private final ISurveyRepository repository;

    public SendFeedbackUseCase(ISurveyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<Unit>> invoke(boolean like, List<Integer> issues, String comment) {
        Intrinsics.checkNotNullParameter(issues, "issues");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.repository.sendFeedback(like, issues, comment);
    }
}
