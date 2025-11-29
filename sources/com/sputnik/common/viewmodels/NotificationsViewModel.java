package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.common.mappers.notifications.DomainNotificationToNotificationMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.notifications.DomainNotification;
import com.sputnik.domain.usecases.notifications.GetNotificationUseCase;
import com.sputnik.domain.usecases.notifications.GetNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.GetUnviewedNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.UpdateNotificationUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: NotificationsViewModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00110\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010&¨\u0006'"}, d2 = {"Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/NotificationsViewState;", "", "Lcom/sputnik/domain/usecases/notifications/GetNotificationsUseCase;", "getNotificationsUseCase", "Lcom/sputnik/domain/usecases/notifications/GetUnviewedNotificationsUseCase;", "getUnviewedNotificationsUseCase", "Lcom/sputnik/domain/usecases/notifications/GetNotificationUseCase;", "getNotificationUseCase", "Lcom/sputnik/domain/usecases/notifications/UpdateNotificationUseCase;", "updateNotificationUseCase", "Lcom/sputnik/common/mappers/notifications/DomainNotificationToNotificationMapper;", "domainNotificationToNotificationMapper", "<init>", "(Lcom/sputnik/domain/usecases/notifications/GetNotificationsUseCase;Lcom/sputnik/domain/usecases/notifications/GetUnviewedNotificationsUseCase;Lcom/sputnik/domain/usecases/notifications/GetNotificationUseCase;Lcom/sputnik/domain/usecases/notifications/UpdateNotificationUseCase;Lcom/sputnik/common/mappers/notifications/DomainNotificationToNotificationMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "getNotificationsFromServer", "()Landroidx/lifecycle/LiveData;", "getUnviewedNotificationsFromServer", "Lcom/sputnik/common/entities/notifications/Notification;", RemoteMessageConst.NOTIFICATION, "updateNotificationOnServer", "(Lcom/sputnik/common/entities/notifications/Notification;)Landroidx/lifecycle/LiveData;", "", "loadUnviewedNotifications", "()V", "loadNotifications", "readNotification", "(Lcom/sputnik/common/entities/notifications/Notification;)V", "logout", "Lcom/sputnik/domain/usecases/notifications/GetNotificationsUseCase;", "Lcom/sputnik/domain/usecases/notifications/GetUnviewedNotificationsUseCase;", "Lcom/sputnik/domain/usecases/notifications/GetNotificationUseCase;", "Lcom/sputnik/domain/usecases/notifications/UpdateNotificationUseCase;", "Lcom/sputnik/common/mappers/notifications/DomainNotificationToNotificationMapper;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationsViewModel extends BaseViewModel<NotificationsViewState> {
    private final DomainNotificationToNotificationMapper domainNotificationToNotificationMapper;
    private final GetNotificationUseCase getNotificationUseCase;
    private final GetNotificationsUseCase getNotificationsUseCase;
    private final GetUnviewedNotificationsUseCase getUnviewedNotificationsUseCase;
    private final UpdateNotificationUseCase updateNotificationUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsViewModel(GetNotificationsUseCase getNotificationsUseCase, GetUnviewedNotificationsUseCase getUnviewedNotificationsUseCase, GetNotificationUseCase getNotificationUseCase, UpdateNotificationUseCase updateNotificationUseCase, DomainNotificationToNotificationMapper domainNotificationToNotificationMapper) {
        super(new NotificationsViewState(null, null, false, 7, null), "javaClass");
        Intrinsics.checkNotNullParameter(getNotificationsUseCase, "getNotificationsUseCase");
        Intrinsics.checkNotNullParameter(getUnviewedNotificationsUseCase, "getUnviewedNotificationsUseCase");
        Intrinsics.checkNotNullParameter(getNotificationUseCase, "getNotificationUseCase");
        Intrinsics.checkNotNullParameter(updateNotificationUseCase, "updateNotificationUseCase");
        Intrinsics.checkNotNullParameter(domainNotificationToNotificationMapper, "domainNotificationToNotificationMapper");
        this.getNotificationsUseCase = getNotificationsUseCase;
        this.getUnviewedNotificationsUseCase = getUnviewedNotificationsUseCase;
        this.getNotificationUseCase = getNotificationUseCase;
        this.updateNotificationUseCase = updateNotificationUseCase;
        this.domainNotificationToNotificationMapper = domainNotificationToNotificationMapper;
        loadUnviewedNotifications();
    }

    private final LiveData<Resource<List<DomainNotification>>> getNotificationsFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getNotificationsUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<List<DomainNotification>>> getUnviewedNotificationsFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getUnviewedNotificationsUseCase.invoke(), null, 0L, 3, null);
    }

    public void loadUnviewedNotifications() {
        subscribeOnDataSource(getUnviewedNotificationsFromServer(), new Function2<Resource<? extends List<? extends DomainNotification>>, NotificationsViewState, NotificationsViewState>() { // from class: com.sputnik.common.viewmodels.NotificationsViewModel.loadUnviewedNotifications.1

            /* compiled from: NotificationsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.NotificationsViewModel$loadUnviewedNotifications$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ NotificationsViewState invoke(Resource<? extends List<? extends DomainNotification>> resource, NotificationsViewState notificationsViewState) {
                return invoke2((Resource<? extends List<DomainNotification>>) resource, notificationsViewState);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.sputnik.common.viewmodels.NotificationsViewState invoke2(com.sputnik.domain.common.Resource<? extends java.util.List<com.sputnik.domain.entities.notifications.DomainNotification>> r9, com.sputnik.common.viewmodels.NotificationsViewState r10) {
                /*
                    r8 = this;
                    java.lang.String r0 = "data"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r0 = "state"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    com.sputnik.domain.common.Resource$Status r0 = r9.getStatus()
                    int[] r1 = com.sputnik.common.viewmodels.NotificationsViewModel.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L7d
                    r2 = 2
                    if (r0 == r2) goto L7d
                    r2 = 3
                    if (r0 == r2) goto L6f
                    r2 = 4
                    if (r0 != r2) goto L69
                    com.sputnik.domain.common.Resource$Status r0 = r10.getServerState()
                    java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
                    java.lang.Object r9 = r9.getData()
                    java.util.List r9 = (java.util.List) r9
                    r3 = 0
                    if (r9 == 0) goto L63
                    java.lang.Iterable r9 = (java.lang.Iterable) r9
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r9 = r9.iterator()
                L3e:
                    boolean r5 = r9.hasNext()
                    if (r5 == 0) goto L5b
                    java.lang.Object r5 = r9.next()
                    r6 = r5
                    com.sputnik.domain.entities.notifications.DomainNotification r6 = (com.sputnik.domain.entities.notifications.DomainNotification) r6
                    java.lang.Boolean r6 = r6.getViewed()
                    java.lang.Boolean r7 = java.lang.Boolean.FALSE
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
                    if (r6 == 0) goto L3e
                    r4.add(r5)
                    goto L3e
                L5b:
                    boolean r9 = r4.isEmpty()
                    r9 = r9 ^ r1
                    if (r9 != r1) goto L63
                    goto L64
                L63:
                    r1 = r3
                L64:
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = r10.copy(r0, r2, r1)
                    return r9
                L69:
                    kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                    r9.<init>()
                    throw r9
                L6f:
                    com.sputnik.domain.common.Resource$Status r1 = r10.getServerState()
                    r4 = 6
                    r5 = 0
                    r2 = 0
                    r3 = 0
                    r0 = r10
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = com.sputnik.common.viewmodels.NotificationsViewState.copy$default(r0, r1, r2, r3, r4, r5)
                    return r9
                L7d:
                    com.sputnik.domain.common.Resource$Status r1 = r10.getServerState()
                    r4 = 6
                    r5 = 0
                    r2 = 0
                    r3 = 0
                    r0 = r10
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = com.sputnik.common.viewmodels.NotificationsViewState.copy$default(r0, r1, r2, r3, r4, r5)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.NotificationsViewModel.AnonymousClass1.invoke2(com.sputnik.domain.common.Resource, com.sputnik.common.viewmodels.NotificationsViewState):com.sputnik.common.viewmodels.NotificationsViewState");
            }
        });
    }

    private final LiveData<Resource<DomainNotification>> updateNotificationOnServer(Notification notification) {
        return FlowLiveDataConversions.asLiveData$default(this.updateNotificationUseCase.invoke(new DomainNotification(notification != null ? notification.getId() : null, notification != null ? notification.getIdentifier() : null, notification != null ? notification.getIdentifierHuman() : null, notification != null ? notification.getTitle() : null, notification != null ? notification.getDeeplink() : null, notification != null ? notification.getMessage() : null, notification != null ? notification.getViewed() : null, notification != null ? notification.getCreatedAt() : null, null)), null, 0L, 3, null);
    }

    public void loadNotifications() {
        NotificationsViewState notificationsViewStateCopy$default = NotificationsViewState.copy$default(getCurrentState(), Resource.Status.LOADING, CollectionsKt.emptyList(), false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(notificationsViewStateCopy$default, this, null), 3, null);
        getState().setValue(notificationsViewStateCopy$default);
        subscribeOnDataSource(getNotificationsFromServer(), new Function2<Resource<? extends List<? extends DomainNotification>>, NotificationsViewState, NotificationsViewState>() { // from class: com.sputnik.common.viewmodels.NotificationsViewModel.loadNotifications.2

            /* compiled from: NotificationsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.NotificationsViewModel$loadNotifications$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ NotificationsViewState invoke(Resource<? extends List<? extends DomainNotification>> resource, NotificationsViewState notificationsViewState) {
                return invoke2((Resource<? extends List<DomainNotification>>) resource, notificationsViewState);
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.sputnik.common.viewmodels.NotificationsViewState invoke2(com.sputnik.domain.common.Resource<? extends java.util.List<com.sputnik.domain.entities.notifications.DomainNotification>> r9, com.sputnik.common.viewmodels.NotificationsViewState r10) {
                /*
                    r8 = this;
                    java.lang.String r0 = "data"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r0 = "state"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    com.sputnik.domain.common.Resource$Status r0 = r9.getStatus()
                    int[] r1 = com.sputnik.common.viewmodels.NotificationsViewModel.AnonymousClass2.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto Ld3
                    r2 = 2
                    if (r0 == r2) goto Ld3
                    r2 = 3
                    if (r0 == r2) goto La0
                    r2 = 4
                    if (r0 != r2) goto L9a
                    com.sputnik.domain.common.Resource$Status r0 = com.sputnik.domain.common.Resource.Status.SUCCESS
                    java.lang.Object r2 = r9.getData()
                    java.util.List r2 = (java.util.List) r2
                    if (r2 == 0) goto L57
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    com.sputnik.common.viewmodels.NotificationsViewModel r3 = com.sputnik.common.viewmodels.NotificationsViewModel.this
                    com.sputnik.common.mappers.notifications.DomainNotificationToNotificationMapper r3 = com.sputnik.common.viewmodels.NotificationsViewModel.access$getDomainNotificationToNotificationMapper$p(r3)
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r5 = 10
                    int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
                    r4.<init>(r5)
                    java.util.Iterator r2 = r2.iterator()
                L43:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L5b
                    java.lang.Object r5 = r2.next()
                    com.sputnik.domain.entities.notifications.DomainNotification r5 = (com.sputnik.domain.entities.notifications.DomainNotification) r5
                    com.sputnik.common.entities.notifications.Notification r5 = r3.map(r5)
                    r4.add(r5)
                    goto L43
                L57:
                    java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
                L5b:
                    java.lang.Object r9 = r9.getData()
                    java.util.List r9 = (java.util.List) r9
                    r2 = 0
                    if (r9 == 0) goto L94
                    java.lang.Iterable r9 = (java.lang.Iterable) r9
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>()
                    java.util.Iterator r9 = r9.iterator()
                L6f:
                    boolean r5 = r9.hasNext()
                    if (r5 == 0) goto L8c
                    java.lang.Object r5 = r9.next()
                    r6 = r5
                    com.sputnik.domain.entities.notifications.DomainNotification r6 = (com.sputnik.domain.entities.notifications.DomainNotification) r6
                    java.lang.Boolean r6 = r6.getViewed()
                    java.lang.Boolean r7 = java.lang.Boolean.FALSE
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
                    if (r6 == 0) goto L6f
                    r3.add(r5)
                    goto L6f
                L8c:
                    boolean r9 = r3.isEmpty()
                    r9 = r9 ^ r1
                    if (r9 != r1) goto L94
                    goto L95
                L94:
                    r1 = r2
                L95:
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = r10.copy(r0, r4, r1)
                    return r9
                L9a:
                    kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                    r9.<init>()
                    throw r9
                La0:
                    com.sputnik.domain.entities.empty.DomainEmpty r0 = r9.getErrorMsg()
                    if (r0 == 0) goto Lb8
                    java.lang.String r0 = r0.getMessage()
                    if (r0 == 0) goto Lb8
                    com.sputnik.common.viewmodels.NotificationsViewModel r1 = com.sputnik.common.viewmodels.NotificationsViewModel.this
                    java.lang.String r0 = r0.toString()
                    r1.notifyErrorMessage(r0)
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    goto Lb9
                Lb8:
                    r0 = 0
                Lb9:
                    if (r0 != 0) goto Lc7
                    com.sputnik.common.viewmodels.NotificationsViewModel r0 = com.sputnik.common.viewmodels.NotificationsViewModel.this
                    java.lang.Exception r9 = r9.getError()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                    r0.notifySimpleError(r9)
                Lc7:
                    com.sputnik.domain.common.Resource$Status r2 = com.sputnik.domain.common.Resource.Status.ERROR
                    r5 = 6
                    r6 = 0
                    r3 = 0
                    r4 = 0
                    r1 = r10
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = com.sputnik.common.viewmodels.NotificationsViewState.copy$default(r1, r2, r3, r4, r5, r6)
                    return r9
                Ld3:
                    com.sputnik.domain.common.Resource$Status r1 = r10.getServerState()
                    r4 = 6
                    r5 = 0
                    r2 = 0
                    r3 = 0
                    r0 = r10
                    com.sputnik.common.viewmodels.NotificationsViewState r9 = com.sputnik.common.viewmodels.NotificationsViewState.copy$default(r0, r1, r2, r3, r4, r5)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.NotificationsViewModel.AnonymousClass2.invoke2(com.sputnik.domain.common.Resource, com.sputnik.common.viewmodels.NotificationsViewState):com.sputnik.common.viewmodels.NotificationsViewState");
            }
        });
    }

    public final void logout() {
        NotificationsViewState notificationsViewStateCopy$default = NotificationsViewState.copy$default(getCurrentState(), Resource.Status.NONE, CollectionsKt.emptyList(), false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(notificationsViewStateCopy$default, this, null), 3, null);
        getState().setValue(notificationsViewStateCopy$default);
    }

    public void readNotification(final Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        subscribeOnDataSource(updateNotificationOnServer(notification.copy((447 & 1) != 0 ? notification.id : null, (447 & 2) != 0 ? notification.identifier : null, (447 & 4) != 0 ? notification.identifierHuman : null, (447 & 8) != 0 ? notification.title : null, (447 & 16) != 0 ? notification.deeplink : null, (447 & 32) != 0 ? notification.message : null, (447 & 64) != 0 ? notification.viewed : Boolean.TRUE, (447 & 128) != 0 ? notification.createdAt : null, (447 & 256) != 0 ? notification.buttons : null)), new Function2<Resource<? extends DomainNotification>, NotificationsViewState, NotificationsViewState>() { // from class: com.sputnik.common.viewmodels.NotificationsViewModel.readNotification.1

            /* compiled from: NotificationsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.NotificationsViewModel$readNotification$1$WhenMappings */
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ NotificationsViewState invoke(Resource<? extends DomainNotification> resource, NotificationsViewState notificationsViewState) {
                return invoke2((Resource<DomainNotification>) resource, notificationsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final NotificationsViewState invoke2(Resource<DomainNotification> data, NotificationsViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<Notification> notifications = state.getNotifications();
                    notifications.get(notifications.indexOf(notification)).setViewed(Boolean.TRUE);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : notifications) {
                        if (Intrinsics.areEqual(((Notification) obj).getViewed(), Boolean.FALSE)) {
                            arrayList.add(obj);
                        }
                    }
                    return NotificationsViewState.copy$default(state, null, notifications, arrayList.isEmpty() ^ true, 1, null);
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    NotificationsViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    NotificationsViewModel notificationsViewModel = NotificationsViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    notificationsViewModel.notifySimpleError(error);
                }
                List<Notification> notifications2 = state.getNotifications();
                notifications2.get(notifications2.indexOf(notification)).setViewed(Boolean.TRUE);
                return NotificationsViewState.copy$default(state, null, notifications2, false, 5, null);
            }
        });
    }
}
