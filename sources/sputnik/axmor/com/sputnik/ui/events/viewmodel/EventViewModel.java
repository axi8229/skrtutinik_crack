package sputnik.axmor.com.sputnik.ui.events.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.EventsSettings;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.event.ReportCustomUseCase;
import com.sputnik.domain.usecases.event.ReportFlatInsuranceUseCase;
import com.sputnik.domain.usecases.event.ReportNoCameraUseCase;
import com.sputnik.domain.usecases.issues.IssueTypes;
import com.sputnik.domain.usecases.issues.ReportIssueUseCase;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: EventViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b!\u0010\u001eJ\u0019\u0010\"\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010 J\r\u0010$\u001a\u00020\u0014¢\u0006\u0004\b$\u0010 J\u0017\u0010%\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b%\u0010\u001eJ\u0017\u0010&\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b&\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010*R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010+¨\u0006,"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewState;", "", "Lcom/sputnik/domain/usecases/event/ReportCustomUseCase;", "reportCustomUseCase", "Lcom/sputnik/domain/usecases/event/ReportFlatInsuranceUseCase;", "reportFlatInsuranceUseCase", "Lcom/sputnik/domain/usecases/event/ReportNoCameraUseCase;", "reportNoCameraUseCase", "Lcom/sputnik/domain/usecases/issues/ReportIssueUseCase;", "reportIssueUseCase", "Lcom/sputnik/data/local/PrefManager;", "preferences", "<init>", "(Lcom/sputnik/domain/usecases/event/ReportCustomUseCase;Lcom/sputnik/domain/usecases/event/ReportFlatInsuranceUseCase;Lcom/sputnik/domain/usecases/event/ReportNoCameraUseCase;Lcom/sputnik/domain/usecases/issues/ReportIssueUseCase;Lcom/sputnik/data/local/PrefManager;)V", "", "identifier", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "reportNoCameraToServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/usecases/issues/IssueTypes;", "errorCode", "cameraUUID", "intercomUUID", "reportIssueOnServer", "(Lcom/sputnik/domain/usecases/issues/IssueTypes;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "reportNoCamera", "(Ljava/lang/String;)V", "loadEventsSettings", "()V", "updateIntercomOfflineTimestamp", "updateVideoErrorTimestamp", "updateIntercomNotFoundTimestamp", "reportIntercomNotFoundIssue", "reportNoVideoIssue", "reportIntercomOfflineIssue", "Lcom/sputnik/domain/usecases/event/ReportCustomUseCase;", "Lcom/sputnik/domain/usecases/event/ReportFlatInsuranceUseCase;", "Lcom/sputnik/domain/usecases/event/ReportNoCameraUseCase;", "Lcom/sputnik/domain/usecases/issues/ReportIssueUseCase;", "Lcom/sputnik/data/local/PrefManager;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventViewModel extends BaseViewModel<EventViewState> {
    private final PrefManager preferences;
    private final ReportCustomUseCase reportCustomUseCase;
    private final ReportFlatInsuranceUseCase reportFlatInsuranceUseCase;
    private final ReportIssueUseCase reportIssueUseCase;
    private final ReportNoCameraUseCase reportNoCameraUseCase;

    public EventViewModel(ReportCustomUseCase reportCustomUseCase, ReportFlatInsuranceUseCase reportFlatInsuranceUseCase, ReportNoCameraUseCase reportNoCameraUseCase, ReportIssueUseCase reportIssueUseCase, PrefManager preferences) {
        Intrinsics.checkNotNullParameter(reportCustomUseCase, "reportCustomUseCase");
        Intrinsics.checkNotNullParameter(reportFlatInsuranceUseCase, "reportFlatInsuranceUseCase");
        Intrinsics.checkNotNullParameter(reportNoCameraUseCase, "reportNoCameraUseCase");
        Intrinsics.checkNotNullParameter(reportIssueUseCase, "reportIssueUseCase");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        EventViewState eventViewState = new EventViewState(null, null, null, null, 15, null);
        String name = EventViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(eventViewState, name);
        this.reportCustomUseCase = reportCustomUseCase;
        this.reportFlatInsuranceUseCase = reportFlatInsuranceUseCase;
        this.reportNoCameraUseCase = reportNoCameraUseCase;
        this.reportIssueUseCase = reportIssueUseCase;
        this.preferences = preferences;
        loadEventsSettings();
    }

    private final LiveData<Resource<Unit>> reportNoCameraToServer(String identifier) {
        return FlowLiveDataConversions.asLiveData$default(this.reportNoCameraUseCase.invoke(identifier), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> reportIssueOnServer(IssueTypes errorCode, String cameraUUID, String intercomUUID) {
        Integer id;
        ReportIssueUseCase reportIssueUseCase = this.reportIssueUseCase;
        LoginState.Session.Address currentAddress = this.preferences.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(reportIssueUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), errorCode, cameraUUID, intercomUUID), null, 0L, 3, null);
    }

    public void reportNoCamera(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        subscribeOnDataSource(reportNoCameraToServer(identifier), new Function2<Resource<? extends Unit>, EventViewState, EventViewState>() { // from class: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel.reportNoCamera.1

            /* compiled from: EventViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel$reportNoCamera$1$WhenMappings */
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ EventViewState invoke(Resource<? extends Unit> resource, EventViewState eventViewState) {
                return invoke2((Resource<Unit>) resource, eventViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final EventViewState invoke2(Resource<Unit> serverData, EventViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                Exception error = serverData.getError();
                LogUtilsKt.writeLog("GGGG: EVENT=" + (error != null ? ExceptionsKt.stackTraceToString(error) : null));
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return null;
                }
                if (i == 4) {
                    return EventViewState.copy$default(state, new Event(Boolean.TRUE), null, null, null, 14, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public void updateIntercomOfflineTimestamp(String intercomUUID) {
        PrefManager prefManager = this.preferences;
        EventsSettings eventsSettings = prefManager.getEventsSettings();
        String phone = this.preferences.getPhone();
        String string = IssueTypes.intercom_offline.toString();
        if (intercomUUID == null) {
            intercomUUID = "";
        }
        prefManager.setEventsSettings(EventsSettings.setLastClick$default(eventsSettings, phone, intercomUUID, string, 0L, 8, null));
        loadEventsSettings();
    }

    public void updateVideoErrorTimestamp(String cameraUUID) {
        PrefManager prefManager = this.preferences;
        EventsSettings eventsSettings = prefManager.getEventsSettings();
        String phone = this.preferences.getPhone();
        String string = IssueTypes.video.toString();
        if (cameraUUID == null) {
            cameraUUID = "";
        }
        prefManager.setEventsSettings(EventsSettings.setLastClick$default(eventsSettings, phone, cameraUUID, string, 0L, 8, null));
        loadEventsSettings();
    }

    public void loadEventsSettings() {
        EventViewState eventViewStateCopy$default = EventViewState.copy$default(getCurrentState(), null, null, null, this.preferences.getEventsSettings(), 7, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EventViewModel$loadEventsSettings$$inlined$updateState$1(eventViewStateCopy$default, this, null), 3, null);
        getState().setValue(eventViewStateCopy$default);
    }

    public void updateIntercomNotFoundTimestamp() {
        PrefManager prefManager = this.preferences;
        prefManager.setEventsSettings(EventsSettings.setLastClick$default(prefManager.getEventsSettings(), this.preferences.getPhone(), "", IssueTypes.no_intercom.toString(), 0L, 8, null));
        loadEventsSettings();
    }

    public final void reportIntercomNotFoundIssue() {
        updateIntercomNotFoundTimestamp();
        subscribeOnDataSource(reportIssueOnServer(IssueTypes.no_intercom, null, null), new Function2<Resource<? extends Unit>, EventViewState, EventViewState>() { // from class: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel.reportIntercomNotFoundIssue.1

            /* compiled from: EventViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel$reportIntercomNotFoundIssue$1$WhenMappings */
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ EventViewState invoke(Resource<? extends Unit> resource, EventViewState eventViewState) {
                return invoke2((Resource<Unit>) resource, eventViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final EventViewState invoke2(Resource<Unit> serverData, EventViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return null;
                }
                if (i == 4) {
                    return EventViewState.copy$default(state, new Event(Boolean.TRUE), null, null, null, 14, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public final void reportNoVideoIssue(String cameraUUID) {
        updateVideoErrorTimestamp(cameraUUID);
        subscribeOnDataSource(reportIssueOnServer(IssueTypes.video, cameraUUID, null), new Function2<Resource<? extends Unit>, EventViewState, EventViewState>() { // from class: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel.reportNoVideoIssue.1

            /* compiled from: EventViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel$reportNoVideoIssue$1$WhenMappings */
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ EventViewState invoke(Resource<? extends Unit> resource, EventViewState eventViewState) {
                return invoke2((Resource<Unit>) resource, eventViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final EventViewState invoke2(Resource<Unit> serverData, EventViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return null;
                }
                if (i == 4) {
                    return EventViewState.copy$default(state, new Event(Boolean.TRUE), null, null, null, 14, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public final void reportIntercomOfflineIssue(String intercomUUID) {
        updateIntercomOfflineTimestamp(intercomUUID);
        subscribeOnDataSource(reportIssueOnServer(IssueTypes.intercom_offline, null, intercomUUID), new Function2<Resource<? extends Unit>, EventViewState, EventViewState>() { // from class: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel.reportIntercomOfflineIssue.1

            /* compiled from: EventViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel$reportIntercomOfflineIssue$1$WhenMappings */
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ EventViewState invoke(Resource<? extends Unit> resource, EventViewState eventViewState) {
                return invoke2((Resource<Unit>) resource, eventViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final EventViewState invoke2(Resource<Unit> serverData, EventViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return null;
                }
                if (i == 4) {
                    return EventViewState.copy$default(state, new Event(Boolean.TRUE), null, null, null, 14, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
