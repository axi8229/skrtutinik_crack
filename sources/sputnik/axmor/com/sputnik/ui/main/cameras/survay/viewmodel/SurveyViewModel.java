package sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.mocklets.pluto.PlutoLog;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.survey.SendFeedbackUseCase;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: SurveyViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001f¨\u0006 "}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;", "", "Lcom/sputnik/domain/usecases/survey/SendFeedbackUseCase;", "sendFeedbackUseCase", "<init>", "(Lcom/sputnik/domain/usecases/survey/SendFeedbackUseCase;)V", "", "like", "", "", "issues", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "sendFeedbackToServer", "(ZLjava/util/List;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "isChecked", "mark", "updateMark", "(ZI)V", "isLike", "sendSurvey", "(Z)V", "sendPositiveSurvey", "()V", "handleComment", "(Ljava/lang/String;)V", "Lcom/sputnik/domain/usecases/survey/SendFeedbackUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyViewModel extends BaseViewModel<SurveyViewState> {
    private final SendFeedbackUseCase sendFeedbackUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyViewModel(SendFeedbackUseCase sendFeedbackUseCase) {
        super(new SurveyViewState(null, null, null, null, 15, null), "javaClass");
        Intrinsics.checkNotNullParameter(sendFeedbackUseCase, "sendFeedbackUseCase");
        this.sendFeedbackUseCase = sendFeedbackUseCase;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ LiveData sendFeedbackToServer$default(SurveyViewModel surveyViewModel, boolean z, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            str = "";
        }
        return surveyViewModel.sendFeedbackToServer(z, list, str);
    }

    private final LiveData<Resource<Unit>> sendFeedbackToServer(boolean like, List<Integer> issues, String comment) {
        return FlowLiveDataConversions.asLiveData$default(this.sendFeedbackUseCase.invoke(like, issues, comment), null, 0L, 3, null);
    }

    public void sendSurvey(boolean isLike) {
        subscribeOnDataSource(sendFeedbackToServer(isLike, getCurrentState().getMarks(), getCurrentState().getCommentText()), new Function2<Resource<? extends Unit>, SurveyViewState, SurveyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel.sendSurvey.1

            /* compiled from: SurveyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel$sendSurvey$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ SurveyViewState invoke(Resource<? extends Unit> resource, SurveyViewState surveyViewState) {
                return invoke2((Resource<Unit>) resource, surveyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SurveyViewState invoke2(Resource<Unit> serverData, SurveyViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return SurveyViewState.copy$default(state, new ArrayList(), "", new Event(Boolean.TRUE), null, 8, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        SurveyViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        SurveyViewModel surveyViewModel = SurveyViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        surveyViewModel.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void sendPositiveSurvey() {
        subscribeOnDataSource(sendFeedbackToServer$default(this, true, null, null, 6, null), new Function2<Resource<? extends Unit>, SurveyViewState, SurveyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel.sendPositiveSurvey.1

            /* compiled from: SurveyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel$sendPositiveSurvey$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ SurveyViewState invoke(Resource<? extends Unit> resource, SurveyViewState surveyViewState) {
                return invoke2((Resource<Unit>) resource, surveyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SurveyViewState invoke2(Resource<Unit> serverData, SurveyViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                PlutoLog.e$default(PlutoLog.INSTANCE, "feedback", serverData.toString(), null, 4, null);
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return SurveyViewState.copy$default(state, new ArrayList(), "", null, new Event(Boolean.TRUE), 4, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        SurveyViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        SurveyViewModel surveyViewModel = SurveyViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        surveyViewModel.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void handleComment(String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        SurveyViewState surveyViewStateCopy$default = SurveyViewState.copy$default(getCurrentState(), null, comment, null, null, 13, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SurveyViewModel$handleComment$$inlined$updateState$1(surveyViewStateCopy$default, this, null), 3, null);
        getState().setValue(surveyViewStateCopy$default);
    }

    public void updateMark(boolean isChecked, int mark) {
        if (isChecked) {
            SurveyViewState currentState = getCurrentState();
            ArrayList<Integer> marks = getCurrentState().getMarks();
            marks.add(Integer.valueOf(mark));
            SurveyViewState surveyViewStateCopy$default = SurveyViewState.copy$default(currentState, marks, null, null, null, 14, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SurveyViewModel$updateMark$$inlined$updateState$1(surveyViewStateCopy$default, this, null), 3, null);
            getState().setValue(surveyViewStateCopy$default);
            return;
        }
        SurveyViewState currentState2 = getCurrentState();
        ArrayList<Integer> marks2 = getCurrentState().getMarks();
        marks2.remove(Integer.valueOf(mark));
        SurveyViewState surveyViewStateCopy$default2 = SurveyViewState.copy$default(currentState2, marks2, null, null, null, 14, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SurveyViewModel$updateMark$$inlined$updateState$2(surveyViewStateCopy$default2, this, null), 3, null);
        getState().setValue(surveyViewStateCopy$default2);
    }
}
