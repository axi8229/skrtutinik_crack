package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.mappers.surveys.DomainSurveyToSurveyMapper;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.survey.DomainSurvey;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import com.sputnik.domain.usecases.survey.GetSurveyUseCase;
import com.sputnik.domain.usecases.survey.GetSurveysUseCase;
import com.sputnik.domain.usecases.survey.SendResultUseCase;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: SurveysViewModel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BE\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJE\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u000b\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b'\u0010(J9\u0010)\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010&J\u000f\u0010,\u001a\u00020$H\u0016¢\u0006\u0004\b,\u0010&J\r\u0010-\u001a\u00020$¢\u0006\u0004\b-\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00100R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00101R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00102R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00103¨\u00064"}, d2 = {"Lcom/sputnik/common/viewmodels/SurveysViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/SurveysState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/domain/usecases/survey/GetSurveysUseCase;", "getSurveysUseCase", "Lcom/sputnik/domain/usecases/survey/GetSurveyUseCase;", "getSurveyUseCase", "Lcom/sputnik/domain/usecases/survey/SendResultUseCase;", "sendResultUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "Lcom/sputnik/common/entities/surveys/Survey;", "domainSurveysToSurveysListMapper", "Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;", "domainSurveysToSurveysMapper", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/survey/GetSurveysUseCase;Lcom/sputnik/domain/usecases/survey/GetSurveyUseCase;Lcom/sputnik/domain/usecases/survey/SendResultUseCase;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getSurveysFromServer", "()Landroidx/lifecycle/LiveData;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "getSurveyFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "surveyId", "optionIds", "starsCount", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadSurveys", "()V", "loadSurvey", "(Ljava/lang/String;)V", "sendResult", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "lockSurveys", "clearState", "logout", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/survey/GetSurveysUseCase;", "Lcom/sputnik/domain/usecases/survey/GetSurveyUseCase;", "Lcom/sputnik/domain/usecases/survey/SendResultUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurveysViewModel extends BaseViewModel<SurveysState> {
    private final ListMapper<DomainSurvey, Survey> domainSurveysToSurveysListMapper;
    private final DomainSurveyToSurveyMapper domainSurveysToSurveysMapper;
    private final GetSurveyUseCase getSurveyUseCase;
    private final GetSurveysUseCase getSurveysUseCase;
    private final PrefManager prefManager;
    private final SendResultUseCase sendResultUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveysViewModel(PrefManager prefManager, GetSurveysUseCase getSurveysUseCase, GetSurveyUseCase getSurveyUseCase, SendResultUseCase sendResultUseCase, ListMapper<DomainSurvey, Survey> domainSurveysToSurveysListMapper, DomainSurveyToSurveyMapper domainSurveysToSurveysMapper) {
        super(new SurveysState(null, null, null, false, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(getSurveysUseCase, "getSurveysUseCase");
        Intrinsics.checkNotNullParameter(getSurveyUseCase, "getSurveyUseCase");
        Intrinsics.checkNotNullParameter(sendResultUseCase, "sendResultUseCase");
        Intrinsics.checkNotNullParameter(domainSurveysToSurveysListMapper, "domainSurveysToSurveysListMapper");
        Intrinsics.checkNotNullParameter(domainSurveysToSurveysMapper, "domainSurveysToSurveysMapper");
        this.prefManager = prefManager;
        this.getSurveysUseCase = getSurveysUseCase;
        this.getSurveyUseCase = getSurveyUseCase;
        this.sendResultUseCase = sendResultUseCase;
        this.domainSurveysToSurveysListMapper = domainSurveysToSurveysListMapper;
        this.domainSurveysToSurveysMapper = domainSurveysToSurveysMapper;
        loadSurveys();
    }

    private final LiveData<Resource<List<DomainSurvey>>> getSurveysFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getSurveysUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainSurvey>> getSurveyFromServer(String name) {
        return FlowLiveDataConversions.asLiveData$default(this.getSurveyUseCase.invoke(name), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainSurveyResult>> sendResultUseCase(int surveyId, List<Integer> optionIds, Integer starsCount, String comment) {
        return FlowLiveDataConversions.asLiveData$default(this.sendResultUseCase.invoke(surveyId, optionIds, starsCount, comment), null, 0L, 3, null);
    }

    public void clearState() {
        SurveysState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : status, (166 & 2) != 0 ? currentState.uploadResultState : status, (166 & 4) != 0 ? currentState.surveys : null, (166 & 8) != 0 ? currentState.surveysDismissed : false, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : null, (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
    }

    public void loadSurvey(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        SurveysState currentState = getCurrentState();
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : null, (166 & 2) != 0 ? currentState.uploadResultState : null, (166 & 4) != 0 ? currentState.surveys : null, (166 & 8) != 0 ? currentState.surveysDismissed : false, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : null, (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
        subscribeOnDataSource(getSurveyFromServer(name), new Function2<Resource<? extends DomainSurvey>, SurveysState, SurveysState>() { // from class: com.sputnik.common.viewmodels.SurveysViewModel.loadSurvey.2

            /* compiled from: SurveysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.SurveysViewModel$loadSurvey$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ SurveysState invoke(Resource<? extends DomainSurvey> resource, SurveysState surveysState) {
                return invoke2((Resource<DomainSurvey>) resource, surveysState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SurveysState invoke2(Resource<DomainSurvey> serverData, SurveysState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : name, (166 & 128) != 0 ? state.uploadResultData : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainSurvey data = serverData.getData();
                    if (data != null) {
                        return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : data.getName() != null ? new Event(this.domainSurveysToSurveysMapper.map(data)) : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : name, (166 & 128) != 0 ? state.uploadResultData : null);
                    }
                    return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null) {
                    this.notifyErrorMessage(errorMsg.getError());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    SurveysViewModel surveysViewModel = this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    surveysViewModel.notifySimpleError(error);
                }
                return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : name, (166 & 128) != 0 ? state.uploadResultData : null);
            }
        });
    }

    public void loadSurveys() {
        SurveysState currentState = getCurrentState();
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : null, (166 & 2) != 0 ? currentState.uploadResultState : null, (166 & 4) != 0 ? currentState.surveys : null, (166 & 8) != 0 ? currentState.surveysDismissed : false, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : null, (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
        subscribeOnDataSource(getSurveysFromServer(), new Function2<Resource<? extends List<? extends DomainSurvey>>, SurveysState, SurveysState>() { // from class: com.sputnik.common.viewmodels.SurveysViewModel.loadSurveys.2

            /* compiled from: SurveysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.SurveysViewModel$loadSurveys$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ SurveysState invoke(Resource<? extends List<? extends DomainSurvey>> resource, SurveysState surveysState) {
                return invoke2((Resource<? extends List<DomainSurvey>>) resource, surveysState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SurveysState invoke2(Resource<? extends List<DomainSurvey>> serverData, SurveysState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    List<DomainSurvey> data = serverData.getData();
                    return state.copy((166 & 1) != 0 ? state.serverState : status, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : data != null ? SurveysViewModel.this.domainSurveysToSurveysListMapper.map(data) : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null) {
                    SurveysViewModel.this.notifyErrorMessage(errorMsg.getError());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    SurveysViewModel surveysViewModel = SurveysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    surveysViewModel.notifySimpleError(error);
                }
                return state.copy((166 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (166 & 2) != 0 ? state.uploadResultState : null, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
            }
        });
    }

    public void lockSurveys() {
        SurveysState currentState = getCurrentState();
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : null, (166 & 2) != 0 ? currentState.uploadResultState : null, (166 & 4) != 0 ? currentState.surveys : null, (166 & 8) != 0 ? currentState.surveysDismissed : true, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : null, (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
    }

    public final void logout() {
        SurveysState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : status, (166 & 2) != 0 ? currentState.uploadResultState : status, (166 & 4) != 0 ? currentState.surveys : CollectionsKt.emptyList(), (166 & 8) != 0 ? currentState.surveysDismissed : false, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : new Event(Boolean.TRUE), (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
    }

    public void sendResult(int surveyId, List<Integer> optionIds, Integer starsCount, String comment) {
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        SurveysState currentState = getCurrentState();
        SurveysState surveysStateCopy = currentState.copy((166 & 1) != 0 ? currentState.serverState : null, (166 & 2) != 0 ? currentState.uploadResultState : Resource.Status.LOADING, (166 & 4) != 0 ? currentState.surveys : null, (166 & 8) != 0 ? currentState.surveysDismissed : false, (166 & 16) != 0 ? currentState.requestedSurvey : null, (166 & 32) != 0 ? currentState.needToReload : null, (166 & 64) != 0 ? currentState.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy, this, null), 3, null);
        getState().setValue(surveysStateCopy);
        subscribeOnDataSource(sendResultUseCase(surveyId, optionIds, starsCount, comment), new Function2<Resource<? extends DomainSurveyResult>, SurveysState, SurveysState>() { // from class: com.sputnik.common.viewmodels.SurveysViewModel.sendResult.2

            /* compiled from: SurveysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.SurveysViewModel$sendResult$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ SurveysState invoke(Resource<? extends DomainSurveyResult> resource, SurveysState surveysState) {
                return invoke2((Resource<DomainSurveyResult>) resource, surveysState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final SurveysState invoke2(Resource<DomainSurveyResult> serverData, SurveysState state) {
                Unit unit;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((166 & 1) != 0 ? state.serverState : null, (166 & 2) != 0 ? state.uploadResultState : Resource.Status.LOADING, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
                }
                if (i != 3) {
                    if (i == 4) {
                        return state.copy((166 & 1) != 0 ? state.serverState : null, (166 & 2) != 0 ? state.uploadResultState : Resource.Status.SUCCESS, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : serverData.getData());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null) {
                    SurveysViewModel.this.notifyErrorMessage(errorMsg.getError());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    SurveysViewModel surveysViewModel = SurveysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    surveysViewModel.notifySimpleError(error);
                }
                return state.copy((166 & 1) != 0 ? state.serverState : null, (166 & 2) != 0 ? state.uploadResultState : Resource.Status.ERROR, (166 & 4) != 0 ? state.surveys : null, (166 & 8) != 0 ? state.surveysDismissed : false, (166 & 16) != 0 ? state.requestedSurvey : null, (166 & 32) != 0 ? state.needToReload : null, (166 & 64) != 0 ? state.lastRequestedSurveyName : null, (166 & 128) != 0 ? state.uploadResultData : null);
            }
        });
        clearState();
        SurveysState currentState2 = getCurrentState();
        SurveysState surveysStateCopy2 = currentState2.copy((166 & 1) != 0 ? currentState2.serverState : null, (166 & 2) != 0 ? currentState2.uploadResultState : Resource.Status.NONE, (166 & 4) != 0 ? currentState2.surveys : null, (166 & 8) != 0 ? currentState2.surveysDismissed : false, (166 & 16) != 0 ? currentState2.requestedSurvey : null, (166 & 32) != 0 ? currentState2.needToReload : null, (166 & 64) != 0 ? currentState2.lastRequestedSurveyName : null, (166 & 128) != 0 ? currentState2.uploadResultData : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(surveysStateCopy2, this, null), 3, null);
        getState().setValue(surveysStateCopy2);
    }
}
