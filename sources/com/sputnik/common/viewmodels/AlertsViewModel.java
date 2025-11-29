package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.entities.alerts.Alert;
import com.sputnik.common.mappers.alerts.DomainAlertToAlertMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlertsViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/viewmodels/AlertsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/AlertsViewState;", "", "Lcom/sputnik/domain/usecases/alerts/GetAlertsUseCase;", "getAlertsUseCase", "Lcom/sputnik/common/mappers/alerts/DomainAlertToAlertMapper;", "domainAlertToAlertMapper", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/alerts/GetAlertsUseCase;Lcom/sputnik/common/mappers/alerts/DomainAlertToAlertMapper;Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;)V", "", "platform", "app", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "getAlertsFromServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "getAlerts", "()V", "Lcom/sputnik/domain/usecases/alerts/GetAlertsUseCase;", "Lcom/sputnik/common/mappers/alerts/DomainAlertToAlertMapper;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlertsViewModel extends BaseViewModel<AlertsViewState> {
    private final IConfig config;
    private final DomainAlertToAlertMapper domainAlertToAlertMapper;
    private final GetAlertsUseCase getAlertsUseCase;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertsViewModel(GetAlertsUseCase getAlertsUseCase, DomainAlertToAlertMapper domainAlertToAlertMapper, IConfig config, PrefManager prefManager) {
        super(new AlertsViewState(null, null, 3, null), "javaClass");
        Intrinsics.checkNotNullParameter(getAlertsUseCase, "getAlertsUseCase");
        Intrinsics.checkNotNullParameter(domainAlertToAlertMapper, "domainAlertToAlertMapper");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.getAlertsUseCase = getAlertsUseCase;
        this.domainAlertToAlertMapper = domainAlertToAlertMapper;
        this.config = config;
        this.prefManager = prefManager;
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            getAlerts();
        }
    }

    static /* synthetic */ LiveData getAlertsFromServer$default(AlertsViewModel alertsViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alertsViewModel.config.getPlatformKeyName();
        }
        if ((i & 2) != 0) {
            str2 = "default";
        }
        if ((i & 4) != 0) {
            str3 = alertsViewModel.prefManager.getCurLocale();
        }
        return alertsViewModel.getAlertsFromServer(str, str2, str3);
    }

    private final LiveData<Resource<List<DomainAlert>>> getAlertsFromServer(String platform, String app, String locale) {
        return FlowLiveDataConversions.asLiveData$default(GetAlertsUseCase.invoke$default(this.getAlertsUseCase, platform, app, locale, 0, 8, null), null, 0L, 3, null);
    }

    public void getAlerts() {
        subscribeOnDataSource(getAlertsFromServer$default(this, null, null, null, 7, null), new Function2<Resource<? extends List<? extends DomainAlert>>, AlertsViewState, AlertsViewState>() { // from class: com.sputnik.common.viewmodels.AlertsViewModel.getAlerts.1

            /* compiled from: AlertsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.AlertsViewModel$getAlerts$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AlertsViewState invoke(Resource<? extends List<? extends DomainAlert>> resource, AlertsViewState alertsViewState) {
                return invoke2((Resource<? extends List<DomainAlert>>) resource, alertsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AlertsViewState invoke2(Resource<? extends List<DomainAlert>> data, AlertsViewState state) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                AlertsViewModel alertsViewModel = AlertsViewModel.this;
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                List<Alert> listEmptyList = null;
                if (i == 1) {
                    return AlertsViewState.copy$default(state, data.getStatus(), null, 2, null);
                }
                if (i != 2) {
                    if (i == 3) {
                        return AlertsViewState.copy$default(state, data.getStatus(), null, 2, null);
                    }
                    return AlertsViewState.copy$default(state, Resource.Status.NONE, null, 2, null);
                }
                Resource.Status status = data.getStatus();
                List<DomainAlert> data2 = data.getData();
                if (data2 != null) {
                    List<DomainAlert> list = data2;
                    listEmptyList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        listEmptyList.add(alertsViewModel.domainAlertToAlertMapper.map((DomainAlert) it.next()));
                    }
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return state.copy(status, listEmptyList);
            }
        });
    }
}
