package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.di.use_cases.invites.AcceptInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeclineInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeleteFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.GetFamilyInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.GetInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.ResendFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.SendFamilyInviteUseCase;
import com.sputnik.common.entities.invites.FamilyInvites;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.invites.InviteStatus;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.invites.DomainFamilyInvitesToFamilyInvitesMapper;
import com.sputnik.common.mappers.invites.DomainInviteToInviteMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
import com.sputnik.domain.entities.invites.DomainFamilyInvites;
import com.sputnik.domain.entities.invites.DomainInvite;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: InvitesViewModel.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bq\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJI\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'0&2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b*\u0010+J\u001b\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0'0&H\u0002¢\u0006\u0004\b-\u0010.J#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000'0&2\u0006\u0010/\u001a\u00020\"H\u0002¢\u0006\u0004\b1\u00102J#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000'0&2\u0006\u00103\u001a\u00020\"H\u0002¢\u0006\u0004\b4\u00102J#\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000'0&2\u0006\u00103\u001a\u00020\"H\u0002¢\u0006\u0004\b5\u00102J+\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0'0&2\u0006\u00103\u001a\u00020\"2\u0006\u00106\u001a\u00020\"H\u0002¢\u0006\u0004\b7\u00108J+\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0'0&2\u0006\u00103\u001a\u00020\"2\u0006\u00106\u001a\u00020\"H\u0002¢\u0006\u0004\b9\u00108J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020:2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020:2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bA\u0010@J\r\u0010B\u001a\u00020:¢\u0006\u0004\bB\u0010<J\u000f\u0010C\u001a\u00020:H\u0016¢\u0006\u0004\bC\u0010<J\u0017\u0010D\u001a\u00020:2\u0006\u0010/\u001a\u00020\"H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020:2\u0006\u00103\u001a\u00020\"H\u0016¢\u0006\u0004\bF\u0010EJ\u0017\u0010G\u001a\u00020:2\u0006\u00103\u001a\u00020\"H\u0016¢\u0006\u0004\bG\u0010EJ\r\u0010H\u001a\u00020:¢\u0006\u0004\bH\u0010<J\r\u0010I\u001a\u00020:¢\u0006\u0004\bI\u0010<J\r\u0010J\u001a\u00020:¢\u0006\u0004\bJ\u0010<J\r\u0010K\u001a\u00020:¢\u0006\u0004\bK\u0010<J\u0013\u0010M\u001a\b\u0012\u0004\u0012\u00020L0(¢\u0006\u0004\bM\u0010NR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010OR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010PR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010QR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010RR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010SR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010TR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010UR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010VR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010WR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010XR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010YR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010ZR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010[¨\u0006\\"}, d2 = {"Lcom/sputnik/common/viewmodels/InvitesViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/InvitesViewState;", "", "Lcom/sputnik/common/di/use_cases/invites/GetInvitesUseCase;", "getInvitesUseCase", "Lcom/sputnik/common/di/use_cases/invites/GetFamilyInvitesUseCase;", "getFamilyInvitesUseCase", "Lcom/sputnik/common/di/use_cases/invites/SendFamilyInviteUseCase;", "sendFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/ResendFamilyInviteUseCase;", "resendFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/DeleteFamilyInviteUseCase;", "deleteFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/AcceptInviteUseCase;", "acceptInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/DeclineInviteUseCase;", "declineInviteUseCase", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/common/mappers/invites/DomainInviteToInviteMapper;", "domainInviteToInviteMapper", "Lcom/sputnik/common/mappers/invites/DomainFamilyInvitesToFamilyInvitesMapper;", "domainFamilyInvitesToFamilyInvitesMapper", "Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;", "getCountryCodeUseCase", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "<init>", "(Lcom/sputnik/common/di/use_cases/invites/GetInvitesUseCase;Lcom/sputnik/common/di/use_cases/invites/GetFamilyInvitesUseCase;Lcom/sputnik/common/di/use_cases/invites/SendFamilyInviteUseCase;Lcom/sputnik/common/di/use_cases/invites/ResendFamilyInviteUseCase;Lcom/sputnik/common/di/use_cases/invites/DeleteFamilyInviteUseCase;Lcom/sputnik/common/di/use_cases/invites/AcceptInviteUseCase;Lcom/sputnik/common/di/use_cases/invites/DeclineInviteUseCase;Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/common/mappers/invites/DomainInviteToInviteMapper;Lcom/sputnik/common/mappers/invites/DomainFamilyInvitesToFamilyInvitesMapper;Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "version", "", "platform", "app", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/invites/DomainInvite;", "getInvitesFromServer", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "getFamilyInvitesFromServer", "()Landroidx/lifecycle/LiveData;", "phone", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvite;", "sendFamilyInviteToServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "id", "resendFamilyInviteToServer", "deleteFamilyInviteToServer", "source", "acceptInviteOnServer", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "declineInviteOnServer", "", "loadInvites", "()V", "Lcom/sputnik/common/entities/invites/Invite;", "invite", "acceptInvite", "(Lcom/sputnik/common/entities/invites/Invite;)V", "declineInvite", "loadFamilyInvitesIfNeeded", "loadFamilyInvites", "sendFamilyInvite", "(Ljava/lang/String;)V", "resendFamilyInvite", "deleteFamilyInvite", "logout", "clearState", "clearOperationalState", "clearInvites", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "getCountryCodes", "()Ljava/util/List;", "Lcom/sputnik/common/di/use_cases/invites/GetInvitesUseCase;", "Lcom/sputnik/common/di/use_cases/invites/GetFamilyInvitesUseCase;", "Lcom/sputnik/common/di/use_cases/invites/SendFamilyInviteUseCase;", "Lcom/sputnik/common/di/use_cases/invites/ResendFamilyInviteUseCase;", "Lcom/sputnik/common/di/use_cases/invites/DeleteFamilyInviteUseCase;", "Lcom/sputnik/common/di/use_cases/invites/AcceptInviteUseCase;", "Lcom/sputnik/common/di/use_cases/invites/DeclineInviteUseCase;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/common/mappers/invites/DomainInviteToInviteMapper;", "Lcom/sputnik/common/mappers/invites/DomainFamilyInvitesToFamilyInvitesMapper;", "Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;", "Lcom/sputnik/common/localization/LocalizationStorage;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvitesViewModel extends BaseViewModel<InvitesViewState> {
    private final AcceptInviteUseCase acceptInviteUseCase;
    private final IConfig config;
    private final DeclineInviteUseCase declineInviteUseCase;
    private final DeleteFamilyInviteUseCase deleteFamilyInviteUseCase;
    private final DomainFamilyInvitesToFamilyInvitesMapper domainFamilyInvitesToFamilyInvitesMapper;
    private final DomainInviteToInviteMapper domainInviteToInviteMapper;
    private final GetCountryCodeUseCase getCountryCodeUseCase;
    private final GetFamilyInvitesUseCase getFamilyInvitesUseCase;
    private final GetInvitesUseCase getInvitesUseCase;
    private final LocalizationStorage localizationStorage;
    private final PrefManager prefManager;
    private final ResendFamilyInviteUseCase resendFamilyInviteUseCase;
    private final SendFamilyInviteUseCase sendFamilyInviteUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvitesViewModel(GetInvitesUseCase getInvitesUseCase, GetFamilyInvitesUseCase getFamilyInvitesUseCase, SendFamilyInviteUseCase sendFamilyInviteUseCase, ResendFamilyInviteUseCase resendFamilyInviteUseCase, DeleteFamilyInviteUseCase deleteFamilyInviteUseCase, AcceptInviteUseCase acceptInviteUseCase, DeclineInviteUseCase declineInviteUseCase, IConfig config, PrefManager prefManager, DomainInviteToInviteMapper domainInviteToInviteMapper, DomainFamilyInvitesToFamilyInvitesMapper domainFamilyInvitesToFamilyInvitesMapper, GetCountryCodeUseCase getCountryCodeUseCase, LocalizationStorage localizationStorage) {
        super(new InvitesViewState(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null), "javaClass");
        Intrinsics.checkNotNullParameter(getInvitesUseCase, "getInvitesUseCase");
        Intrinsics.checkNotNullParameter(getFamilyInvitesUseCase, "getFamilyInvitesUseCase");
        Intrinsics.checkNotNullParameter(sendFamilyInviteUseCase, "sendFamilyInviteUseCase");
        Intrinsics.checkNotNullParameter(resendFamilyInviteUseCase, "resendFamilyInviteUseCase");
        Intrinsics.checkNotNullParameter(deleteFamilyInviteUseCase, "deleteFamilyInviteUseCase");
        Intrinsics.checkNotNullParameter(acceptInviteUseCase, "acceptInviteUseCase");
        Intrinsics.checkNotNullParameter(declineInviteUseCase, "declineInviteUseCase");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(domainInviteToInviteMapper, "domainInviteToInviteMapper");
        Intrinsics.checkNotNullParameter(domainFamilyInvitesToFamilyInvitesMapper, "domainFamilyInvitesToFamilyInvitesMapper");
        Intrinsics.checkNotNullParameter(getCountryCodeUseCase, "getCountryCodeUseCase");
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        this.getInvitesUseCase = getInvitesUseCase;
        this.getFamilyInvitesUseCase = getFamilyInvitesUseCase;
        this.sendFamilyInviteUseCase = sendFamilyInviteUseCase;
        this.resendFamilyInviteUseCase = resendFamilyInviteUseCase;
        this.deleteFamilyInviteUseCase = deleteFamilyInviteUseCase;
        this.acceptInviteUseCase = acceptInviteUseCase;
        this.declineInviteUseCase = declineInviteUseCase;
        this.config = config;
        this.prefManager = prefManager;
        this.domainInviteToInviteMapper = domainInviteToInviteMapper;
        this.domainFamilyInvitesToFamilyInvitesMapper = domainFamilyInvitesToFamilyInvitesMapper;
        this.getCountryCodeUseCase = getCountryCodeUseCase;
        this.localizationStorage = localizationStorage;
    }

    static /* synthetic */ LiveData getInvitesFromServer$default(InvitesViewModel invitesViewModel, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            str = invitesViewModel.config.getPlatformKeyName();
        }
        if ((i2 & 4) != 0) {
            str2 = "default";
        }
        if ((i2 & 8) != 0) {
            str3 = invitesViewModel.prefManager.getCurLocale();
        }
        return invitesViewModel.getInvitesFromServer(i, str, str2, str3);
    }

    private final LiveData<Resource<List<DomainInvite>>> getInvitesFromServer(int version, String platform, String app, String locale) {
        return FlowLiveDataConversions.asLiveData$default(this.getInvitesUseCase.invoke(version, platform, app, locale), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainFamilyInvites>> getFamilyInvitesFromServer() {
        Integer id;
        GetFamilyInvitesUseCase getFamilyInvitesUseCase = this.getFamilyInvitesUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getFamilyInvitesUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainFamilyInvite>> sendFamilyInviteToServer(String phone) {
        Integer id;
        SendFamilyInviteUseCase sendFamilyInviteUseCase = this.sendFamilyInviteUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(sendFamilyInviteUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), phone), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainFamilyInvite>> resendFamilyInviteToServer(String id) {
        Integer id2;
        ResendFamilyInviteUseCase resendFamilyInviteUseCase = this.resendFamilyInviteUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(resendFamilyInviteUseCase.invoke((currentAddress == null || (id2 = currentAddress.getId()) == null) ? -1 : id2.intValue(), id), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainFamilyInvite>> deleteFamilyInviteToServer(String id) {
        Integer id2;
        DeleteFamilyInviteUseCase deleteFamilyInviteUseCase = this.deleteFamilyInviteUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(deleteFamilyInviteUseCase.invoke((currentAddress == null || (id2 = currentAddress.getId()) == null) ? -1 : id2.intValue(), id), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainInvite>> acceptInviteOnServer(String id, String source) {
        return FlowLiveDataConversions.asLiveData$default(this.acceptInviteUseCase.invoke(id, source), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainInvite>> declineInviteOnServer(String id, String source) {
        return FlowLiveDataConversions.asLiveData$default(this.declineInviteUseCase.invoke(id, source), null, 0L, 3, null);
    }

    public void acceptInvite(Invite invite) {
        Intrinsics.checkNotNullParameter(invite, "invite");
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : Resource.Status.LOADING, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(acceptInviteOnServer(String.valueOf(invite.getId()), String.valueOf(invite.getSource())), new Function2<Resource<? extends DomainInvite>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.acceptInvite.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$acceptInvite$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainInvite> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainInvite>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainInvite> data, InvitesViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : state.getServerState(), (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    DomainInvite data2 = data.getData();
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : status, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : InviteStatus.valueOf(String.valueOf(data2 != null ? data2.getState() : null)), (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    InvitesViewModel.this.notifyErrorMessage(message.toString());
                    obj = Unit.INSTANCE;
                }
                if (obj == null) {
                    InvitesViewModel invitesViewModel = InvitesViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    invitesViewModel.notifySimpleError(error);
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : Resource.Status.ERROR, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public final void clearInvites() {
        InvitesViewState currentState = getCurrentState();
        Event event = new Event(CollectionsKt.emptyList());
        Resource.Status status = Resource.Status.NONE;
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : status, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : status, (7871 & 128) != 0 ? currentState.declineInviteServerState : status, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : event, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
    }

    public final void clearOperationalState() {
        InvitesViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : status, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : status, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : status, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
    }

    public final void clearState() {
        InvitesViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : status, (7871 & 2) != 0 ? currentState.familyInvitesServerState : status, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : status, (7871 & 64) != 0 ? currentState.acceptInviteServerState : status, (7871 & 128) != 0 ? currentState.declineInviteServerState : status, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
    }

    public void declineInvite(Invite invite) {
        Intrinsics.checkNotNullParameter(invite, "invite");
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : Resource.Status.LOADING, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(declineInviteOnServer(String.valueOf(invite.getId()), String.valueOf(invite.getSource())), new Function2<Resource<? extends DomainInvite>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.declineInvite.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$declineInvite$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainInvite> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainInvite>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainInvite> data, InvitesViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : state.getServerState(), (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    DomainInvite data2 = data.getData();
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : status, (7871 & 256) != 0 ? state.manageInviteStatus : InviteStatus.valueOf(String.valueOf(data2 != null ? data2.getState() : null)), (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    InvitesViewModel.this.notifyErrorMessage(message.toString());
                    obj = Unit.INSTANCE;
                }
                if (obj == null) {
                    InvitesViewModel invitesViewModel = InvitesViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    invitesViewModel.notifySimpleError(error);
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : Resource.Status.ERROR, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public void deleteFamilyInvite(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : Resource.Status.LOADING, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(deleteFamilyInviteToServer(id), new Function2<Resource<? extends DomainFamilyInvite>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.deleteFamilyInvite.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$deleteFamilyInvite$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainFamilyInvite> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainFamilyInvite>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainFamilyInvite> data, InvitesViewState state) {
                Unit unit;
                String message;
                Integer httpErrorCode;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : state.getServerState(), (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i != 3) {
                    if (i == 4) {
                        return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : Resource.Status.SUCCESS, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg == null || (httpErrorCode = errorMsg.getHttpErrorCode()) == null || httpErrorCode.intValue() != 404) {
                    DomainEmpty errorMsg2 = data.getErrorMsg();
                    if (errorMsg2 == null || (message = errorMsg2.getMessage()) == null) {
                        unit = null;
                    } else {
                        InvitesViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        InvitesViewModel invitesViewModel = InvitesViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        invitesViewModel.notifySimpleError(error);
                    }
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : Resource.Status.ERROR, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public void loadFamilyInvites() {
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : Resource.Status.LOADING, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(getFamilyInvitesFromServer(), new Function2<Resource<? extends DomainFamilyInvites>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.loadFamilyInvites.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$loadFamilyInvites$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainFamilyInvites> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainFamilyInvites>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainFamilyInvites> data, InvitesViewState state) {
                DomainEmpty errorMsg;
                String message;
                Integer code;
                Integer httpErrorCode;
                FamilyInvites map;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : state.getServerState(), (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    if (data.getData() != null) {
                        DomainFamilyInvitesToFamilyInvitesMapper domainFamilyInvitesToFamilyInvitesMapper = InvitesViewModel.this.domainFamilyInvitesToFamilyInvitesMapper;
                        DomainFamilyInvites data2 = data.getData();
                        Intrinsics.checkNotNull(data2);
                        map = domainFamilyInvitesToFamilyInvitesMapper.map(data2, InvitesViewModel.this.localizationStorage);
                    } else {
                        map = null;
                    }
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : status, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : map, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : true);
                }
                DomainEmpty errorMsg2 = data.getErrorMsg();
                if ((errorMsg2 == null || (httpErrorCode = errorMsg2.getHttpErrorCode()) == null || httpErrorCode.intValue() != 404) && ((errorMsg = data.getErrorMsg()) == null || (code = errorMsg.getCode()) == null || code.intValue() != 17004)) {
                    DomainEmpty errorMsg3 = data.getErrorMsg();
                    if (errorMsg3 != null && (message = errorMsg3.getMessage()) != null) {
                        InvitesViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        InvitesViewModel invitesViewModel = InvitesViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        invitesViewModel.notifySimpleError(error);
                    }
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : Resource.Status.ERROR, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public final void logout() {
        getCurrentState();
        InvitesViewState invitesViewState = new InvitesViewState(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewState, this, null), 3, null);
        getState().setValue(invitesViewState);
    }

    public void resendFamilyInvite(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : Resource.Status.LOADING, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(resendFamilyInviteToServer(id), new Function2<Resource<? extends DomainFamilyInvite>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.resendFamilyInvite.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$resendFamilyInvite$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainFamilyInvite> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainFamilyInvite>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainFamilyInvite> data, InvitesViewState state) {
                Unit unit;
                String message;
                Integer httpErrorCode;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : state.getServerState(), (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i != 3) {
                    if (i == 4) {
                        return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : Resource.Status.SUCCESS, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg == null || (httpErrorCode = errorMsg.getHttpErrorCode()) == null || httpErrorCode.intValue() != 404) {
                    DomainEmpty errorMsg2 = data.getErrorMsg();
                    if (errorMsg2 == null || (message = errorMsg2.getMessage()) == null) {
                        unit = null;
                    } else {
                        InvitesViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        InvitesViewModel invitesViewModel = InvitesViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        invitesViewModel.notifySimpleError(error);
                    }
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : Resource.Status.ERROR, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public void sendFamilyInvite(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        InvitesViewState currentState = getCurrentState();
        InvitesViewState invitesViewStateCopy = currentState.copy((7871 & 1) != 0 ? currentState.serverState : null, (7871 & 2) != 0 ? currentState.familyInvitesServerState : null, (7871 & 4) != 0 ? currentState.sendFamilyInviteServerState : Resource.Status.LOADING, (7871 & 8) != 0 ? currentState.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? currentState.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? currentState.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? currentState.acceptInviteServerState : null, (7871 & 128) != 0 ? currentState.declineInviteServerState : null, (7871 & 256) != 0 ? currentState.manageInviteStatus : null, (7871 & 512) != 0 ? currentState.invites : null, (7871 & 1024) != 0 ? currentState.familyInvites : null, (7871 & 2048) != 0 ? currentState.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? currentState.manageInvitesAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(invitesViewStateCopy, this, null), 3, null);
        getState().setValue(invitesViewStateCopy);
        subscribeOnDataSource(sendFamilyInviteToServer(phone), new Function2<Resource<? extends DomainFamilyInvite>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.sendFamilyInvite.2

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$sendFamilyInvite$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends DomainFamilyInvite> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<DomainFamilyInvite>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<DomainFamilyInvite> data, InvitesViewState state) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : data.getStatus(), (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : Resource.Status.ERROR, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : errorMsg != null ? errorMsg.getMessage() : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i == 4) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : null, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : Resource.Status.SUCCESS, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    public void loadInvites() {
        subscribeOnDataSource(getInvitesFromServer$default(this, 0, null, null, null, 15, null), new Function2<Resource<? extends List<? extends DomainInvite>>, InvitesViewState, InvitesViewState>() { // from class: com.sputnik.common.viewmodels.InvitesViewModel.loadInvites.1

            /* compiled from: InvitesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$loadInvites$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ InvitesViewState invoke(Resource<? extends List<? extends DomainInvite>> resource, InvitesViewState invitesViewState) {
                return invoke2((Resource<? extends List<DomainInvite>>) resource, invitesViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final InvitesViewState invoke2(Resource<? extends List<DomainInvite>> data, InvitesViewState state) {
                Unit unit;
                String message;
                Integer httpErrorCode;
                Collection collectionEmptyList;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((7871 & 1) != 0 ? state.serverState : state.getServerState(), (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    List<DomainInvite> data2 = data.getData();
                    if (data2 != null) {
                        List<DomainInvite> list = data2;
                        DomainInviteToInviteMapper domainInviteToInviteMapper = InvitesViewModel.this.domainInviteToInviteMapper;
                        collectionEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            collectionEmptyList.add(domainInviteToInviteMapper.map((DomainInvite) it.next()));
                        }
                    } else {
                        collectionEmptyList = CollectionsKt.emptyList();
                    }
                    return state.copy((7871 & 1) != 0 ? state.serverState : status, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : new Event(collectionEmptyList), (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg == null || (httpErrorCode = errorMsg.getHttpErrorCode()) == null || httpErrorCode.intValue() != 404) {
                    DomainEmpty errorMsg2 = data.getErrorMsg();
                    if (errorMsg2 == null || (message = errorMsg2.getMessage()) == null) {
                        unit = null;
                    } else {
                        InvitesViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        InvitesViewModel invitesViewModel = InvitesViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        invitesViewModel.notifySimpleError(error);
                    }
                }
                return state.copy((7871 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (7871 & 2) != 0 ? state.familyInvitesServerState : null, (7871 & 4) != 0 ? state.sendFamilyInviteServerState : null, (7871 & 8) != 0 ? state.resendFamilyInviteServerState : null, (7871 & 16) != 0 ? state.deleteFamilyInviteServerState : null, (7871 & 32) != 0 ? state.familyInvitesOperationServerState : null, (7871 & 64) != 0 ? state.acceptInviteServerState : null, (7871 & 128) != 0 ? state.declineInviteServerState : null, (7871 & 256) != 0 ? state.manageInviteStatus : null, (7871 & 512) != 0 ? state.invites : null, (7871 & 1024) != 0 ? state.familyInvites : null, (7871 & 2048) != 0 ? state.sendFamilyInviteErrorMessage : null, (7871 & 4096) != 0 ? state.manageInvitesAvailable : false);
            }
        });
    }

    public final void loadFamilyInvitesIfNeeded() {
        if (getCurrentState().getFamilyInvitesServerState() == Resource.Status.NONE) {
            loadFamilyInvites();
        }
    }

    /* compiled from: InvitesViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.InvitesViewModel$getCountryCodes$1", f = "InvitesViewModel.kt", l = {pjsip_status_code.PJSIP_SC_PROVIDE_REFERRER_HEADER}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.InvitesViewModel$getCountryCodes$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DomainCountryCode>>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InvitesViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends DomainCountryCode>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<DomainCountryCode>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<DomainCountryCode>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<DomainCountryCode>> flowInvoke = InvitesViewModel.this.getCountryCodeUseCase.invoke();
                if (flowInvoke != null) {
                    this.label = 1;
                    obj = FlowKt.first(flowInvoke, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return CollectionsKt.emptyList();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) obj;
            if (list != null) {
                return list;
            }
            return CollectionsKt.emptyList();
        }
    }

    public final List<DomainCountryCode> getCountryCodes() {
        return (List) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }
}
