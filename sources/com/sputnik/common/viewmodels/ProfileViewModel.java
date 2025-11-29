package com.sputnik.common.viewmodels;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.common.Scopes;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.GlobalVariablesKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.profile.DomainProfileToProfileMapper;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.entities.profile.DomainProfile;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.domain.usecases.profile.BindToFlatUseCase;
import com.sputnik.domain.usecases.profile.ChangeAvatarUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAccountUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAddressUseCase;
import com.sputnik.domain.usecases.profile.DeleteAccountUseCase;
import com.sputnik.domain.usecases.profile.DeleteFrUseCase;
import com.sputnik.domain.usecases.profile.GetProfileUseCase;
import com.sputnik.domain.usecases.profile.LogoutUseCase;
import com.sputnik.domain.usecases.profile.SendCallEnabledUseCase;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import com.sputnik.domain.usecases.profile.SendTimezoneUseCase;
import com.sputnik.domain.usecases.profile.SetLocalizationUseCase;
import com.sputnik.domain.usecases.profile.UnlinkAddressUseCase;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import java.util.ArrayList;
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
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import okhttp3.internal.http2.Http2Connection;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B©\u0001\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u001b\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.H\u0002¢\u0006\u0004\b1\u00102J#\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J#\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u00107\u001a\u000203H\u0002¢\u0006\u0004\b8\u00106J\u001b\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090/0.H\u0002¢\u0006\u0004\b:\u00102J\u001b\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.H\u0002¢\u0006\u0004\b;\u00102J\u001b\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.H\u0002¢\u0006\u0004\b<\u00102J#\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010=\u001a\u000203H\u0002¢\u0006\u0004\b>\u00106J#\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010=\u001a\u000203H\u0002¢\u0006\u0004\b?\u00106J#\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010=\u001a\u000203H\u0002¢\u0006\u0004\b@\u00106J\u001b\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.H\u0002¢\u0006\u0004\bA\u00102J#\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010B\u001a\u000203H\u0002¢\u0006\u0004\bC\u00106J#\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010D\u001a\u000203H\u0002¢\u0006\u0004\bE\u00106J#\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ+\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020JH\u0002¢\u0006\u0004\bM\u0010NJ\u0019\u0010Q\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bS\u0010RJ\u000f\u0010U\u001a\u00020TH\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u000200H\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u000200H\u0016¢\u0006\u0004\bY\u0010XJ\u0017\u0010[\u001a\u0002002\u0006\u0010Z\u001a\u000203H\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u0002002\u0006\u00107\u001a\u000203H\u0016¢\u0006\u0004\b]\u0010\\J\u000f\u0010^\u001a\u000200H\u0016¢\u0006\u0004\b^\u0010XJ\r\u0010_\u001a\u000200¢\u0006\u0004\b_\u0010XJ\u0017\u0010a\u001a\u0002002\u0006\u0010`\u001a\u00020FH\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u000200H\u0016¢\u0006\u0004\bc\u0010XJ\u000f\u0010d\u001a\u000200H\u0016¢\u0006\u0004\bd\u0010XJ\u000f\u0010e\u001a\u000200H\u0016¢\u0006\u0004\be\u0010XJ\u000f\u0010f\u001a\u000200H\u0016¢\u0006\u0004\bf\u0010XJ\r\u0010g\u001a\u000200¢\u0006\u0004\bg\u0010XJ\r\u0010h\u001a\u000200¢\u0006\u0004\bh\u0010XJ\u000f\u0010i\u001a\u000200H\u0016¢\u0006\u0004\bi\u0010XJ\u000f\u0010j\u001a\u000200H\u0016¢\u0006\u0004\bj\u0010XJ\u0017\u0010l\u001a\u0002002\u0006\u0010k\u001a\u00020FH\u0016¢\u0006\u0004\bl\u0010bJ\u0017\u0010m\u001a\u0002002\u0006\u0010=\u001a\u000203H\u0016¢\u0006\u0004\bm\u0010\\J\u0017\u0010n\u001a\u0002002\u0006\u0010=\u001a\u000203H\u0016¢\u0006\u0004\bn\u0010\\J\u0017\u0010o\u001a\u0002002\u0006\u0010=\u001a\u000203H\u0016¢\u0006\u0004\bo\u0010\\J\u000f\u0010p\u001a\u000200H\u0016¢\u0006\u0004\bp\u0010XJ\u0017\u0010q\u001a\u0002002\u0006\u0010B\u001a\u000203H\u0016¢\u0006\u0004\bq\u0010\\J\u0017\u0010r\u001a\u0002002\u0006\u0010D\u001a\u000203H\u0016¢\u0006\u0004\br\u0010\\J\u0017\u0010s\u001a\u0002002\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bs\u0010bJ!\u0010u\u001a\u0002002\b\u0010t\u001a\u0004\u0018\u0001032\u0006\u0010L\u001a\u00020JH\u0016¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u000200H\u0016¢\u0006\u0004\bw\u0010XJ\u0011\u0010y\u001a\u0004\u0018\u00010xH\u0016¢\u0006\u0004\by\u0010zJ\r\u0010{\u001a\u000200¢\u0006\u0004\b{\u0010XJ\u0011\u0010}\u001a\u0004\u0018\u00010|H\u0016¢\u0006\u0004\b}\u0010~J\u000f\u0010\u007f\u001a\u000200H\u0016¢\u0006\u0004\b\u007f\u0010XJ\u000f\u0010\u0080\u0001\u001a\u000200¢\u0006\u0005\b\u0080\u0001\u0010XJ\u0010\u0010\u0081\u0001\u001a\u00020F¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0010\u0010\u0083\u0001\u001a\u00020F¢\u0006\u0006\b\u0083\u0001\u0010\u0082\u0001J\u0010\u0010\u0084\u0001\u001a\u00020F¢\u0006\u0006\b\u0084\u0001\u0010\u0082\u0001J\u0010\u0010\u0085\u0001\u001a\u000203¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0010\u0010\u0087\u0001\u001a\u000203¢\u0006\u0006\b\u0087\u0001\u0010\u0086\u0001J\u000f\u0010\u0088\u0001\u001a\u000200¢\u0006\u0005\b\u0088\u0001\u0010XJ\u0013\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0013\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008b\u0001J%\u0010\u008f\u0001\u001a\u0002002\b\u0010\u008d\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008e\u0001\u001a\u00020F¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010\u0091\u0001R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0092\u0001R\u0015\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010\u0093\u0001R\u0015\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0094\u0001R\u0015\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\r\u0010\u0095\u0001R\u0015\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0096\u0001R\u0015\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0097\u0001R\u0015\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u0098\u0001R\u0015\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0015\u0010\u0099\u0001R\u0015\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0017\u0010\u009a\u0001R\u0015\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010\u009b\u0001R\u0015\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u009c\u0001R\u0015\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001d\u0010\u009d\u0001R\u0015\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001f\u0010\u009e\u0001R\u0015\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010\u009f\u0001R\u001a\u0010#\u001a\u00020\"8\u0006¢\u0006\u000f\n\u0005\b#\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0015\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b%\u0010£\u0001R\u0015\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b'\u0010¤\u0001R\u0015\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b)\u0010¥\u0001R\u0015\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b+\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001¨\u0006«\u0001"}, d2 = {"Lcom/sputnik/common/viewmodels/ProfileViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/ProfileViewState;", "Lcom/sputnik/common/viewmodels/interfaces/IProfileViewModel;", "Landroid/app/Application;", "application", "Lcom/sputnik/domain/usecases/profile/DeleteFrUseCase;", "deleteFrUseCase", "Lcom/sputnik/domain/usecases/profile/SetLocalizationUseCase;", "setLocalizationUseCase", "Lcom/sputnik/domain/usecases/profile/ChangeAvatarUseCase;", "changeAvatarUseCase", "Lcom/sputnik/domain/usecases/profile/GetProfileUseCase;", "getProfileUseCase", "Lcom/sputnik/domain/usecases/profile/LogoutUseCase;", "logoutUseCase", "Lcom/sputnik/domain/usecases/profile/DeleteAccountUseCase;", "deleteAccountUseCase", "Lcom/sputnik/domain/usecases/profile/VerifyAddressUseCase;", "verifyAddressUseCase", "Lcom/sputnik/domain/usecases/profile/DeactivateAddressUseCase;", "deactivateAddressUseCase", "Lcom/sputnik/domain/usecases/profile/UnlinkAddressUseCase;", "unlinkAddressUseCase", "Lcom/sputnik/domain/usecases/profile/DeactivateAccountUseCase;", "deactivateAccountUseCase", "Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "sendPushTokenUseCase", "Lcom/sputnik/domain/usecases/profile/SendTimezoneUseCase;", "sendTimezoneUseCase", "Lcom/sputnik/domain/usecases/profile/SendCallEnabledUseCase;", "sendCallEnabledUseCase", "Lcom/sputnik/domain/usecases/profile/BindToFlatUseCase;", "bindToFlatUseCase", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/common/mappers/profile/DomainProfileToProfileMapper;", "domainProfileToProfileMapper", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "<init>", "(Landroid/app/Application;Lcom/sputnik/domain/usecases/profile/DeleteFrUseCase;Lcom/sputnik/domain/usecases/profile/SetLocalizationUseCase;Lcom/sputnik/domain/usecases/profile/ChangeAvatarUseCase;Lcom/sputnik/domain/usecases/profile/GetProfileUseCase;Lcom/sputnik/domain/usecases/profile/LogoutUseCase;Lcom/sputnik/domain/usecases/profile/DeleteAccountUseCase;Lcom/sputnik/domain/usecases/profile/VerifyAddressUseCase;Lcom/sputnik/domain/usecases/profile/DeactivateAddressUseCase;Lcom/sputnik/domain/usecases/profile/UnlinkAddressUseCase;Lcom/sputnik/domain/usecases/profile/DeactivateAccountUseCase;Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;Lcom/sputnik/domain/usecases/profile/SendTimezoneUseCase;Lcom/sputnik/domain/usecases/profile/SendCallEnabledUseCase;Lcom/sputnik/domain/usecases/profile/BindToFlatUseCase;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/common/mappers/profile/DomainProfileToProfileMapper;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/data/IConfig;Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "deleteFrFromServer", "()Landroidx/lifecycle/LiveData;", "", "locale", "setLocalizationToServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "avatar", "changeAvatarToServer", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "getProfileFromServer", "logoutFromServer", "deleteAccountFromServer", "id", "verifyAddressToServer", "deactivateAddressOnServer", "unlinkAddressOnServer", "deactivateAccountFromServer", "token", "sendPushTokenToServer", "timezone", "sendTimezoneToServer", "", "isEnabled", "sendCallEnabledToServer", "(Z)Landroidx/lifecycle/LiveData;", "", "flat", "addressId", "bindToFlatToServer", "(II)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/common/entities/profile/Profile;", Scopes.PROFILE, "handleProfileSessions", "(Lcom/sputnik/common/entities/profile/Profile;)V", "handleProfileSettings", "Lkotlinx/coroutines/Job;", "startActivateProfileJob", "()Lkotlinx/coroutines/Job;", "clearAddressState", "()V", "deleteFr", "localization", "setLocalization", "(Ljava/lang/String;)V", "changeAvatar", "loadLocalization", "loadProfileIfNeeded", "withCheckup", "loadProfile", "(Z)V", "startProfileJob", "stopProfileJob", "waitActivatedProfile", "cleanState", "cleanNavigationState", "cleanEvents", "logout", "deleteAccount", "needUpdate", "handleNeedUpdate", "verifyAddress", "deactivateAddress", "unlinkAddress", "declineBindToFlat", "sendPushToken", "sendTimezone", "setCallsEnabled", "number", "saveFlatNumber", "(Ljava/lang/String;I)V", "handleLike", "Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "getLocalProfileSettings", "()Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "postClearingSupportChat", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "getCurrentSession", "()Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "clearLocalizationLoad", "clearAfterAccountCheck", "haveSubscription", "()Z", "getIsLoggedIn", "getIsInDemoMode", "getAppVersion", "()Ljava/lang/String;", "getStore", "setIsAppLoaded", "Lcom/sputnik/common/entities/addresses/UserAddress;", "getFirstInactivatedAddress", "()Lcom/sputnik/common/entities/addresses/UserAddress;", "getCurrentAddress", "address", "needDelay", "selectCurrentAddress", "(Lcom/sputnik/common/entities/addresses/UserAddress;Z)V", "Landroid/app/Application;", "Lcom/sputnik/domain/usecases/profile/DeleteFrUseCase;", "Lcom/sputnik/domain/usecases/profile/SetLocalizationUseCase;", "Lcom/sputnik/domain/usecases/profile/ChangeAvatarUseCase;", "Lcom/sputnik/domain/usecases/profile/GetProfileUseCase;", "Lcom/sputnik/domain/usecases/profile/LogoutUseCase;", "Lcom/sputnik/domain/usecases/profile/DeleteAccountUseCase;", "Lcom/sputnik/domain/usecases/profile/VerifyAddressUseCase;", "Lcom/sputnik/domain/usecases/profile/DeactivateAddressUseCase;", "Lcom/sputnik/domain/usecases/profile/UnlinkAddressUseCase;", "Lcom/sputnik/domain/usecases/profile/DeactivateAccountUseCase;", "Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "Lcom/sputnik/domain/usecases/profile/SendTimezoneUseCase;", "Lcom/sputnik/domain/usecases/profile/SendCallEnabledUseCase;", "Lcom/sputnik/domain/usecases/profile/BindToFlatUseCase;", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/common/mappers/profile/DomainProfileToProfileMapper;", "Lcom/sputnik/common/localization/LocalizationStorage;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/common/analytics/Analytics;", "isProfileOnStartLoadedOrLoading", "Z", "profileRepeatJob", "Lkotlinx/coroutines/Job;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProfileViewModel extends BaseViewModel<ProfileViewState> implements IProfileViewModel {
    private final Analytics analytics;
    private final Application application;
    private final BindToFlatUseCase bindToFlatUseCase;
    private final ChangeAvatarUseCase changeAvatarUseCase;
    private final IConfig config;
    private final DeactivateAccountUseCase deactivateAccountUseCase;
    private final DeactivateAddressUseCase deactivateAddressUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final DeleteFrUseCase deleteFrUseCase;
    private final DomainProfileToProfileMapper domainProfileToProfileMapper;
    private final GetProfileUseCase getProfileUseCase;
    private boolean isProfileOnStartLoadedOrLoading;
    private final LocalizationStorage localizationStorage;
    private final LogoutUseCase logoutUseCase;
    private final PrefManager prefManager;
    private Job profileRepeatJob;
    private final SendCallEnabledUseCase sendCallEnabledUseCase;
    private final SendPushTokenUseCase sendPushTokenUseCase;
    private final SendTimezoneUseCase sendTimezoneUseCase;
    private final SetLocalizationUseCase setLocalizationUseCase;
    private final UnlinkAddressUseCase unlinkAddressUseCase;
    private final VerifyAddressUseCase verifyAddressUseCase;

    public final PrefManager getPrefManager() {
        return this.prefManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel(Application application, DeleteFrUseCase deleteFrUseCase, SetLocalizationUseCase setLocalizationUseCase, ChangeAvatarUseCase changeAvatarUseCase, GetProfileUseCase getProfileUseCase, LogoutUseCase logoutUseCase, DeleteAccountUseCase deleteAccountUseCase, VerifyAddressUseCase verifyAddressUseCase, DeactivateAddressUseCase deactivateAddressUseCase, UnlinkAddressUseCase unlinkAddressUseCase, DeactivateAccountUseCase deactivateAccountUseCase, SendPushTokenUseCase sendPushTokenUseCase, SendTimezoneUseCase sendTimezoneUseCase, SendCallEnabledUseCase sendCallEnabledUseCase, BindToFlatUseCase bindToFlatUseCase, PrefManager prefManager, DomainProfileToProfileMapper domainProfileToProfileMapper, LocalizationStorage localizationStorage, IConfig config, Analytics analytics) {
        LoginState.Session session;
        Object next;
        super(new ProfileViewState(null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, 33554431, null), "javaClass");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(deleteFrUseCase, "deleteFrUseCase");
        Intrinsics.checkNotNullParameter(setLocalizationUseCase, "setLocalizationUseCase");
        Intrinsics.checkNotNullParameter(changeAvatarUseCase, "changeAvatarUseCase");
        Intrinsics.checkNotNullParameter(getProfileUseCase, "getProfileUseCase");
        Intrinsics.checkNotNullParameter(logoutUseCase, "logoutUseCase");
        Intrinsics.checkNotNullParameter(deleteAccountUseCase, "deleteAccountUseCase");
        Intrinsics.checkNotNullParameter(verifyAddressUseCase, "verifyAddressUseCase");
        Intrinsics.checkNotNullParameter(deactivateAddressUseCase, "deactivateAddressUseCase");
        Intrinsics.checkNotNullParameter(unlinkAddressUseCase, "unlinkAddressUseCase");
        Intrinsics.checkNotNullParameter(deactivateAccountUseCase, "deactivateAccountUseCase");
        Intrinsics.checkNotNullParameter(sendPushTokenUseCase, "sendPushTokenUseCase");
        Intrinsics.checkNotNullParameter(sendTimezoneUseCase, "sendTimezoneUseCase");
        Intrinsics.checkNotNullParameter(sendCallEnabledUseCase, "sendCallEnabledUseCase");
        Intrinsics.checkNotNullParameter(bindToFlatUseCase, "bindToFlatUseCase");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(domainProfileToProfileMapper, "domainProfileToProfileMapper");
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.application = application;
        this.deleteFrUseCase = deleteFrUseCase;
        this.setLocalizationUseCase = setLocalizationUseCase;
        this.changeAvatarUseCase = changeAvatarUseCase;
        this.getProfileUseCase = getProfileUseCase;
        this.logoutUseCase = logoutUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.verifyAddressUseCase = verifyAddressUseCase;
        this.deactivateAddressUseCase = deactivateAddressUseCase;
        this.unlinkAddressUseCase = unlinkAddressUseCase;
        this.deactivateAccountUseCase = deactivateAccountUseCase;
        this.sendPushTokenUseCase = sendPushTokenUseCase;
        this.sendTimezoneUseCase = sendTimezoneUseCase;
        this.sendCallEnabledUseCase = sendCallEnabledUseCase;
        this.bindToFlatUseCase = bindToFlatUseCase;
        this.prefManager = prefManager;
        this.domainProfileToProfileMapper = domainProfileToProfileMapper;
        this.localizationStorage = localizationStorage;
        this.config = config;
        this.analytics = analytics;
        Log.e("DAGGER", "ProfileViewModel");
        List<LoginState.Session> sessions = prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), this.prefManager.getPhone())) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        if (session != null) {
            ProfileViewState currentState = getCurrentState();
            ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : session, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
            getState().setValue(profileViewStateCopy);
        }
    }

    private final LiveData<Resource<Unit>> deleteFrFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.deleteFrUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> setLocalizationToServer(String locale) {
        return FlowLiveDataConversions.asLiveData$default(this.setLocalizationUseCase.invoke(locale), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> changeAvatarToServer(String avatar) {
        return FlowLiveDataConversions.asLiveData$default(this.changeAvatarUseCase.invoke(avatar), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainProfile>> getProfileFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getProfileUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> logoutFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.logoutUseCase.invoke(), null, 0L, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearAddressState() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : Resource.Status.NONE, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    private final LiveData<Resource<Unit>> deleteAccountFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.deleteAccountUseCase.invoke(), null, 0L, 3, null);
    }

    public final void cleanEvents() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : new Event(getCurrentState().getProfileState().peekContent()), (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public final void cleanNavigationState() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : new Event(Boolean.TRUE), (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public void cleanState() {
        ProfileViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : status, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : status, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : new Event(Boolean.TRUE), (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public final void clearAfterAccountCheck() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : new Event(Boolean.FALSE), (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public void clearLocalizationLoad() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : new Event(Boolean.FALSE), (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public void handleLike() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : new Event(Boolean.TRUE), (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public void handleNeedUpdate(boolean needUpdate) {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : new Event(Boolean.valueOf(needUpdate)), (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    public void logout() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : Resource.Status.LOADING, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
        this.prefManager.updateIsLoggedIn(false);
        subscribeOnDataSource(logoutFromServer(), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.logout.2

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$logout$2$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> data, ProfileViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : true, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        ProfileViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ProfileViewModel profileViewModel = ProfileViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        profileViewModel.notifySimpleError(error);
                    }
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                ProfileViewModel.this.getPrefManager().updateJwtToken("");
                PrefManager prefManager = ProfileViewModel.this.getPrefManager();
                ProfileSettings profileSettings = ProfileViewModel.this.getPrefManager().getProfileSettings();
                profileSettings.setNeedToClearSupportScreen(Boolean.TRUE);
                prefManager.setProfileSettings(profileSettings);
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : new Event(new ProfileNavigationState.ToLoginState()), (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void setCallsEnabled(boolean isEnabled) {
        ProfileViewState currentState = getCurrentState();
        Profile profile = currentState.getProfile();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : profile != null ? profile.copy((8388606 & 1) != 0 ? profile.callIsEnabled : null, (8388606 & 2) != 0 ? profile.firstName : null, (8388606 & 4) != 0 ? profile.avatar : null, (8388606 & 8) != 0 ? profile.isNeedFeedback : null, (8388606 & 16) != 0 ? profile.cardInfo : null, (8388606 & 32) != 0 ? profile.faceRecognitionDataUploaded : null, (8388606 & 64) != 0 ? profile.servicesPaidByPartner : null, (8388606 & 128) != 0 ? profile.blocked : null, (8388606 & 256) != 0 ? profile.blockingReason : null, (8388606 & 512) != 0 ? profile.localization : null, (8388606 & 1024) != 0 ? profile.address : null, (8388606 & 2048) != 0 ? profile.addressWithApartment : null, (8388606 & 4096) != 0 ? profile.blockLevel : null, (8388606 & 8192) != 0 ? profile.apartment : null, (8388606 & 16384) != 0 ? profile.historyAvailable : null, (8388606 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? profile.pushToken : null, (8388606 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? profile.timezone : null, (8388606 & 131072) != 0 ? profile.splashScreen : null, (8388606 & 262144) != 0 ? profile.rawAddress : null, (8388606 & 524288) != 0 ? profile.loadingVideo : null, (8388606 & 1048576) != 0 ? profile.richFunctionalityAvailable : null, (8388606 & 2097152) != 0 ? profile.paymentMethod : null, (8388606 & 4194304) != 0 ? profile.addresses : null) : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
        subscribeOnDataSource(sendCallEnabledToServer(isEnabled), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.setCallsEnabled.2

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$setCallsEnabled$2$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        ProfileViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ProfileViewModel profileViewModel = ProfileViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        profileViewModel.notifySimpleError(error);
                    }
                    return null;
                }
                IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public final void setIsAppLoaded() {
        ProfileViewState currentState = getCurrentState();
        ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : true, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
        getState().setValue(profileViewStateCopy);
    }

    private final LiveData<Resource<Unit>> verifyAddressToServer(String id) {
        return FlowLiveDataConversions.asLiveData$default(this.verifyAddressUseCase.invoke(id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> deactivateAddressOnServer(String id) {
        return FlowLiveDataConversions.asLiveData$default(this.deactivateAddressUseCase.invoke(id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> unlinkAddressOnServer(String id) {
        return FlowLiveDataConversions.asLiveData$default(this.unlinkAddressUseCase.invoke(id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> deactivateAccountFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.deactivateAccountUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> sendPushTokenToServer(String token) {
        return FlowLiveDataConversions.asLiveData$default(this.sendPushTokenUseCase.invoke(token), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> sendTimezoneToServer(String timezone) {
        return FlowLiveDataConversions.asLiveData$default(this.sendTimezoneUseCase.invoke(timezone), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> sendCallEnabledToServer(boolean isEnabled) {
        return FlowLiveDataConversions.asLiveData$default(this.sendCallEnabledUseCase.invoke(isEnabled), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> bindToFlatToServer(int flat, int addressId) {
        return FlowLiveDataConversions.asLiveData$default(this.bindToFlatUseCase.invoke(flat, addressId), null, 0L, 3, null);
    }

    public void deleteFr() {
        subscribeOnDataSource(deleteFrFromServer(), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.deleteFr.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$deleteFr$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> data, ProfileViewState state) {
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
                    IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    ProfileViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    ProfileViewModel profileViewModel = ProfileViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    profileViewModel.notifySimpleError(error);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : data.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void setLocalization(String localization) {
        Intrinsics.checkNotNullParameter(localization, "localization");
        subscribeOnDataSource(setLocalizationToServer(localization), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.setLocalization.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$setLocalization$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> profileData, ProfileViewState state) {
                Intrinsics.checkNotNullParameter(profileData, "profileData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[profileData.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 3) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : profileData.getStatus(), (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : profileData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : new Event(Boolean.TRUE), (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void changeAvatar(String avatar) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        subscribeOnDataSource(changeAvatarToServer(avatar), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.changeAvatar.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$changeAvatar$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> profileData, ProfileViewState state) {
                String message;
                ProfileSettingsLocale profileSettings;
                List<String> messages;
                Intrinsics.checkNotNullParameter(profileData, "profileData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[profileData.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ProfileViewModel profileViewModel = ProfileViewModel.this;
                    LocalizationLocalModel data = profileViewModel.localizationStorage.getData();
                    profileViewModel.notifySuccessMessage(String.valueOf((data == null || (profileSettings = data.getProfileSettings()) == null || (messages = profileSettings.getMessages()) == null) ? null : (String) CollectionsKt.firstOrNull((List) messages)));
                    IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg = profileData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    ProfileViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    ProfileViewModel profileViewModel2 = ProfileViewModel.this;
                    Exception error = profileData.getError();
                    Intrinsics.checkNotNull(error);
                    profileViewModel2.notifySimpleError(error);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : profileData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void loadLocalization() {
        subscribeOnDataSource(getProfileFromServer(), new Function2<Resource<? extends DomainProfile>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.loadLocalization.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$loadLocalization$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[BlockingLevel.values().length];
                    try {
                        iArr[BlockingLevel.FULL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BlockingLevel.PARTIAL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[Resource.Status.values().length];
                    try {
                        iArr2[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr2[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends DomainProfile> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<DomainProfile>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<DomainProfile> profileData, ProfileViewState state) {
                Integer blockLevel;
                Intrinsics.checkNotNullParameter(profileData, "profileData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$1[profileData.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 3) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : profileData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : new Event(Boolean.TRUE), (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                GlobalVariables globalVariables = GlobalVariables.INSTANCE;
                DomainProfile data = profileData.getData();
                globalVariables.setBlockLevel((data == null || (blockLevel = data.getBlockLevel()) == null) ? 0 : blockLevel.intValue());
                Resource.Status status = Resource.Status.SUCCESS;
                DomainProfile data2 = profileData.getData();
                String localization = data2 != null ? data2.getLocalization() : null;
                Event event = new Event(Boolean.TRUE);
                DomainProfile data3 = profileData.getData();
                BlockingLevel blockingLevel = GlobalVariablesKt.parseBlockingLevel(data3 != null ? data3.getBlockLevel() : null);
                DomainProfile data4 = profileData.getData();
                int i2 = WhenMappings.$EnumSwitchMapping$0[GlobalVariablesKt.parseBlockingLevel(data4 != null ? data4.getBlockLevel() : null).ordinal()];
                return state.copy((33554431 & 1) != 0 ? state.serverState : status, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : localization, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : event, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : blockingLevel, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : i2 == 1 || i2 == 2, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public final void loadProfileIfNeeded() {
        if (getCurrentState().getProfileServerState() != Resource.Status.SUCCESS) {
            IProfileViewModel.DefaultImpls.loadProfile$default(this, false, 1, null);
        }
    }

    @Override // com.sputnik.common.viewmodels.interfaces.IProfileViewModel
    public void loadProfile(boolean withCheckup) {
        if (this.isProfileOnStartLoadedOrLoading && withCheckup) {
            return;
        }
        try {
            subscribeOnDataSource(getProfileFromServer(), new Function2<Resource<? extends DomainProfile>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.loadProfile.1

                /* compiled from: ProfileViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$loadProfile$1$WhenMappings */
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
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends DomainProfile> resource, ProfileViewState profileViewState) {
                    return invoke2((Resource<DomainProfile>) resource, profileViewState);
                }

                /* JADX WARN: Removed duplicated region for block: B:145:0x034c  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.sputnik.common.viewmodels.ProfileViewState invoke2(com.sputnik.domain.common.Resource<com.sputnik.domain.entities.profile.DomainProfile> r32, com.sputnik.common.viewmodels.ProfileViewState r33) {
                    /*
                        Method dump skipped, instructions count: 1038
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel.C06651.invoke2(com.sputnik.domain.common.Resource, com.sputnik.common.viewmodels.ProfileViewState):com.sputnik.common.viewmodels.ProfileViewState");
                }
            });
            ProfileViewState currentState = getCurrentState();
            ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : new Event(Boolean.FALSE), (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
            getState().setValue(profileViewStateCopy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleProfileSessions(com.sputnik.common.entities.profile.Profile r31) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel.handleProfileSessions(com.sputnik.common.entities.profile.Profile):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleProfileSettings(com.sputnik.common.entities.profile.Profile r32) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel.handleProfileSettings(com.sputnik.common.entities.profile.Profile):void");
    }

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$startActivateProfileJob$1", f = "ProfileViewModel.kt", l = {669}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$startActivateProfileJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C06711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06711(Continuation<? super C06711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProfileViewModel.this.new C06711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005e -> B:18:0x0061). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r6)
                goto L61
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
            L1a:
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                com.sputnik.common.base.VMState r6 = r6.getCurrentState()
                com.sputnik.common.viewmodels.ProfileViewState r6 = (com.sputnik.common.viewmodels.ProfileViewState) r6
                com.sputnik.domain.common.Event r6 = r6.getProfileState()
                java.lang.Object r6 = r6.peekContent()
                boolean r6 = r6 instanceof com.sputnik.domain.entities.profile.ProfileNavigationState.ToVerifyAddressState
                if (r6 != 0) goto L67
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                com.sputnik.common.base.VMState r6 = r6.getCurrentState()
                com.sputnik.common.viewmodels.ProfileViewState r6 = (com.sputnik.common.viewmodels.ProfileViewState) r6
                com.sputnik.domain.common.Event r6 = r6.getProfileState()
                java.lang.Object r6 = r6.peekContent()
                boolean r6 = r6 instanceof com.sputnik.domain.entities.profile.ProfileNavigationState.ToEnterFlatNumberState
                if (r6 != 0) goto L67
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                com.sputnik.common.base.VMState r6 = r6.getCurrentState()
                com.sputnik.common.viewmodels.ProfileViewState r6 = (com.sputnik.common.viewmodels.ProfileViewState) r6
                com.sputnik.domain.common.Event r6 = r6.getProfileState()
                java.lang.Object r6 = r6.peekContent()
                boolean r6 = r6 instanceof com.sputnik.domain.entities.profile.ProfileNavigationState.ToActivatedState
                if (r6 != 0) goto L67
                r5.label = r2
                r3 = 4000(0xfa0, double:1.9763E-320)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
                if (r6 != r0) goto L61
                return r0
            L61:
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                r6.waitActivatedProfile()
                goto L1a
            L67:
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                r0 = 0
                r1 = 0
                com.sputnik.common.viewmodels.interfaces.IProfileViewModel.DefaultImpls.loadProfile$default(r6, r0, r2, r1)
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                kotlinx.coroutines.Job r6 = com.sputnik.common.viewmodels.ProfileViewModel.access$getProfileRepeatJob$p(r6)
                if (r6 == 0) goto L79
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(r6, r1, r2, r1)
            L79:
                com.sputnik.common.viewmodels.ProfileViewModel r6 = com.sputnik.common.viewmodels.ProfileViewModel.this
                com.sputnik.common.viewmodels.ProfileViewModel.access$setProfileRepeatJob$p(r6, r1)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel.C06711.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job startActivateProfileJob() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06711(null), 3, null);
    }

    public void startProfileJob() {
        if (this.profileRepeatJob == null) {
            this.profileRepeatJob = startActivateProfileJob();
        }
    }

    public void stopProfileJob() {
        Job job = this.profileRepeatJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.profileRepeatJob = null;
    }

    public void waitActivatedProfile() {
        subscribeOnDataSource(getProfileFromServer(), new Function2<Resource<? extends DomainProfile>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.waitActivatedProfile.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$waitActivatedProfile$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends DomainProfile> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<DomainProfile>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<DomainProfile> profileData, ProfileViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(profileData, "profileData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[profileData.getStatus().ordinal()];
                if (i == 1) {
                    Resource.Status status = Resource.Status.NONE;
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : status, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    Resource.Status status2 = Resource.Status.LOADING;
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status2, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : status2, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainProfile data = profileData.getData();
                    Profile profileMap2 = data != null ? ProfileViewModel.this.domainProfileToProfileMapper.map(data) : null;
                    Resource.Status status3 = Resource.Status.SUCCESS;
                    Intrinsics.checkNotNull(profileMap2);
                    DomainProfile data2 = profileData.getData();
                    Intrinsics.checkNotNull(data2);
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status3, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : status3, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : profileMap2, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : new Event(profileMap2.getNavigationState(data2)), (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg = profileData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    ProfileViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    ProfileViewModel profileViewModel = ProfileViewModel.this;
                    Exception error = profileData.getError();
                    Intrinsics.checkNotNull(error);
                    profileViewModel.notifySimpleError(error);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : profileData.getStatus(), (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : profileData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void deleteAccount() {
        subscribeOnDataSource(deleteAccountFromServer(), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.deleteAccount.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$deleteAccount$1$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : true, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                Object obj = null;
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        ProfileViewModel.this.notifyErrorMessage(message.toString());
                        obj = Unit.INSTANCE;
                    }
                    if (obj == null) {
                        ProfileViewModel profileViewModel = ProfileViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        profileViewModel.notifySimpleError(error);
                    }
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                LoginState loginState = ProfileViewModel.this.getPrefManager().getLoginState();
                String jwtToken = ProfileViewModel.this.getPrefManager().getJwtToken();
                List<LoginState.Session> sessions = loginState.getSessions();
                if (sessions != null) {
                    Iterator<T> it = sessions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((LoginState.Session) next).getJwt(), jwtToken)) {
                            obj = next;
                            break;
                        }
                    }
                    obj = (LoginState.Session) obj;
                }
                if (obj != null) {
                    sessions.remove(obj);
                    PrefManager prefManager = ProfileViewModel.this.getPrefManager();
                    loginState.setSessions(sessions);
                    prefManager.setLoginState(loginState);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.NONE, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : new Event(new ProfileNavigationState.ToLoginState()), (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void verifyAddress(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        subscribeOnDataSource(verifyAddressToServer(id), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.verifyAddress.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$verifyAddress$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ProfileViewModel.this.analytics.trackLogEvent(new MultiAddressEvents.StateAddressAdded(ProfileViewModel.this.getPrefManager().getCurrentAddresses().isEmpty()));
                    ProfileViewModel.this.analytics.trackLogEvent(new AnalyticsTracker.Event("domofonConnection", "registration_success", null, 4, null));
                    IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.SUCCESS, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    ProfileViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    ProfileViewModel profileViewModel = ProfileViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    profileViewModel.notifySimpleError(error);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.ERROR, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void deactivateAddress(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        subscribeOnDataSource(deactivateAddressOnServer(id), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.deactivateAddress.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$deactivateAddress$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                String message;
                Object next;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        ProfileViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ProfileViewModel profileViewModel = ProfileViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        profileViewModel.notifySimpleError(error);
                    }
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.ERROR, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                ProfileViewModel.this.analytics.trackLogEvent(new MultiAddressEvents.StateAddressUnlinked(ProfileViewModel.this.getPrefManager().getCurrentAddresses().isEmpty()));
                ProfileViewModel profileViewModel2 = ProfileViewModel.this;
                String str = id;
                ProfileViewState currentState = profileViewModel2.getCurrentState();
                List<UserAddress> currentAddresses = profileViewModel2.getCurrentState().getCurrentAddresses();
                List<UserAddress> list = currentAddresses;
                Iterator<T> it = profileViewModel2.getCurrentState().getCurrentAddresses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(String.valueOf(((UserAddress) next).getId()), str)) {
                        break;
                    }
                }
                TypeIntrinsics.asMutableCollection(list).remove(next);
                Unit unit2 = Unit.INSTANCE;
                ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : currentAddresses, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(profileViewModel2), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, profileViewModel2, null), 3, null);
                profileViewModel2.getState().setValue(profileViewStateCopy);
                IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(ProfileViewModel.this), null, null, new AnonymousClass3(ProfileViewModel.this, null), 3, null);
                return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.SUCCESS, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }

            /* compiled from: ProfileViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$deactivateAddress$1$3", f = "ProfileViewModel.kt", l = {925}, m = "invokeSuspend")
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$deactivateAddress$1$3, reason: invalid class name */
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ProfileViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(ProfileViewModel profileViewModel, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = profileViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (DelayKt.delay(YooProfilerImpl.TIMER_LIMIT, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.clearAddressState();
                    return Unit.INSTANCE;
                }
            }
        });
    }

    public void unlinkAddress(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        subscribeOnDataSource(unlinkAddressOnServer(id), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.unlinkAddress.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$unlinkAddress$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                String message;
                Object next;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        ProfileViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ProfileViewModel profileViewModel = ProfileViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        profileViewModel.notifySimpleError(error);
                    }
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.ERROR, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                ProfileViewModel profileViewModel2 = ProfileViewModel.this;
                String str = id;
                ProfileViewState currentState = profileViewModel2.getCurrentState();
                List<UserAddress> currentAddresses = profileViewModel2.getCurrentState().getCurrentAddresses();
                List<UserAddress> list = currentAddresses;
                Iterator<T> it = profileViewModel2.getCurrentState().getCurrentAddresses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(String.valueOf(((UserAddress) next).getId()), str)) {
                        break;
                    }
                }
                TypeIntrinsics.asMutableCollection(list).remove(next);
                Unit unit2 = Unit.INSTANCE;
                ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : null, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : currentAddresses, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(profileViewModel2), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, profileViewModel2, null), 3, null);
                profileViewModel2.getState().setValue(profileViewStateCopy);
                IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(ProfileViewModel.this), null, null, new AnonymousClass3(ProfileViewModel.this, null), 3, null);
                return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : Resource.Status.SUCCESS, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }

            /* compiled from: ProfileViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$unlinkAddress$1$3", f = "ProfileViewModel.kt", l = {958}, m = "invokeSuspend")
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$unlinkAddress$1$3, reason: invalid class name */
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ProfileViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(ProfileViewModel profileViewModel, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = profileViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (DelayKt.delay(YooProfilerImpl.TIMER_LIMIT, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.clearAddressState();
                    return Unit.INSTANCE;
                }
            }
        });
    }

    public void declineBindToFlat() {
        subscribeOnDataSource(deactivateAccountFromServer(), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.declineBindToFlat.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$declineBindToFlat$1$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        DomainEmpty errorMsg = serverData.getErrorMsg();
                        if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                            unit = null;
                        } else {
                            ProfileViewModel.this.notifyErrorMessage(message.toString());
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            ProfileViewModel profileViewModel = ProfileViewModel.this;
                            Exception error = serverData.getError();
                            Intrinsics.checkNotNull(error);
                            profileViewModel.notifySimpleError(error);
                        }
                    } else {
                        return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : new Event(new ProfileNavigationState.ToIntercomState()), (33554431 & 2048) != 0 ? state.isDeactivated : new Event(Boolean.TRUE), (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                    }
                }
                return null;
            }
        });
    }

    public void sendPushToken(final String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        subscribeOnDataSource(sendPushTokenToServer(token), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.sendPushToken.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$sendPushToken$1$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : serverData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                ProfileViewModel.this.getPrefManager().updatePushToken(token);
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void sendTimezone(String timezone) {
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        subscribeOnDataSource(sendTimezoneToServer(timezone), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.sendTimezone.1

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$sendTimezone$1$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i != 3) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : null, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : serverData.getError(), (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public void saveFlatNumber(String number, int addressId) {
        if (number == null || number.length() == 0 || StringsKt.toIntOrNull(number) == null) {
            ProfileViewState currentState = getCurrentState();
            ProfileViewState profileViewStateCopy = currentState.copy((33554431 & 1) != 0 ? currentState.serverState : Resource.Status.ERROR, (33554431 & 2) != 0 ? currentState.addressServerState : null, (33554431 & 4) != 0 ? currentState.flatServerState : null, (33554431 & 8) != 0 ? currentState.profileServerState : null, (33554431 & 16) != 0 ? currentState.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState.timezoneServerState : null, (33554431 & 64) != 0 ? currentState.exception : null, (33554431 & 128) != 0 ? currentState.profile : null, (33554431 & 256) != 0 ? currentState.needUpdate : null, (33554431 & 512) != 0 ? currentState.isShowLoader : false, (33554431 & 1024) != 0 ? currentState.profileState : null, (33554431 & 2048) != 0 ? currentState.isDeactivated : null, (33554431 & 4096) != 0 ? currentState.flatError : null, (33554431 & 8192) != 0 ? currentState.userLocale : null, (33554431 & 16384) != 0 ? currentState.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.isRateLike : null, (33554431 & 131072) != 0 ? currentState.blockLevel : null, (33554431 & 262144) != 0 ? currentState.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState.localProfile : null, (33554431 & 4194304) != 0 ? currentState.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState.needReloadForNewAddress : null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy, this, null), 3, null);
            getState().setValue(profileViewStateCopy);
            return;
        }
        ProfileViewState currentState2 = getCurrentState();
        Resource.Status status = Resource.Status.LOADING;
        ProfileViewState profileViewStateCopy2 = currentState2.copy((33554431 & 1) != 0 ? currentState2.serverState : status, (33554431 & 2) != 0 ? currentState2.addressServerState : null, (33554431 & 4) != 0 ? currentState2.flatServerState : status, (33554431 & 8) != 0 ? currentState2.profileServerState : null, (33554431 & 16) != 0 ? currentState2.pushTokenServerState : null, (33554431 & 32) != 0 ? currentState2.timezoneServerState : null, (33554431 & 64) != 0 ? currentState2.exception : null, (33554431 & 128) != 0 ? currentState2.profile : null, (33554431 & 256) != 0 ? currentState2.needUpdate : null, (33554431 & 512) != 0 ? currentState2.isShowLoader : false, (33554431 & 1024) != 0 ? currentState2.profileState : null, (33554431 & 2048) != 0 ? currentState2.isDeactivated : null, (33554431 & 4096) != 0 ? currentState2.flatError : null, (33554431 & 8192) != 0 ? currentState2.userLocale : null, (33554431 & 16384) != 0 ? currentState2.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState2.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState2.isRateLike : null, (33554431 & 131072) != 0 ? currentState2.blockLevel : null, (33554431 & 262144) != 0 ? currentState2.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? currentState2.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? currentState2.isAccountDeleted : null, (33554431 & 2097152) != 0 ? currentState2.localProfile : null, (33554431 & 4194304) != 0 ? currentState2.isAppLoaded : false, (33554431 & 8388608) != 0 ? currentState2.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? currentState2.needReloadForNewAddress : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(profileViewStateCopy2, this, null), 3, null);
        getState().setValue(profileViewStateCopy2);
        subscribeOnDataSource(bindToFlatToServer(Integer.parseInt(number), addressId), new Function2<Resource<? extends Unit>, ProfileViewState, ProfileViewState>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.saveFlatNumber.2

            /* compiled from: ProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$saveFlatNumber$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ ProfileViewState invoke(Resource<? extends Unit> resource, ProfileViewState profileViewState) {
                return invoke2((Resource<Unit>) resource, profileViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ProfileViewState invoke2(Resource<Unit> serverData, ProfileViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1) {
                    Resource.Status status2 = Resource.Status.NONE;
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status2, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : status2, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                if (i == 2) {
                    Resource.Status status3 = Resource.Status.LOADING;
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status3, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : status3, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    IProfileViewModel.DefaultImpls.loadProfile$default(ProfileViewModel.this, false, 1, null);
                    Resource.Status status4 = Resource.Status.SUCCESS;
                    return state.copy((33554431 & 1) != 0 ? state.serverState : status4, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : status4, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : null, (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                Integer code = errorMsg != null ? errorMsg.getCode() : null;
                if (code != null && code.intValue() == 11100) {
                    return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : Resource.Status.ERROR, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : new Event(Boolean.TRUE), (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
                }
                DomainEmpty errorMsg2 = serverData.getErrorMsg();
                if (errorMsg2 != null && (message = errorMsg2.getMessage()) != null) {
                    ProfileViewModel.this.notifyErrorMessage(message);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    ProfileViewModel profileViewModel = ProfileViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    profileViewModel.notifySimpleError(error);
                }
                return state.copy((33554431 & 1) != 0 ? state.serverState : null, (33554431 & 2) != 0 ? state.addressServerState : null, (33554431 & 4) != 0 ? state.flatServerState : Resource.Status.ERROR, (33554431 & 8) != 0 ? state.profileServerState : null, (33554431 & 16) != 0 ? state.pushTokenServerState : null, (33554431 & 32) != 0 ? state.timezoneServerState : null, (33554431 & 64) != 0 ? state.exception : null, (33554431 & 128) != 0 ? state.profile : null, (33554431 & 256) != 0 ? state.needUpdate : null, (33554431 & 512) != 0 ? state.isShowLoader : false, (33554431 & 1024) != 0 ? state.profileState : null, (33554431 & 2048) != 0 ? state.isDeactivated : null, (33554431 & 4096) != 0 ? state.flatError : new Event(Boolean.FALSE), (33554431 & 8192) != 0 ? state.userLocale : null, (33554431 & 16384) != 0 ? state.localizationNeedUpdate : null, (33554431 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isImageUpdated : null, (33554431 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.isRateLike : null, (33554431 & 131072) != 0 ? state.blockLevel : null, (33554431 & 262144) != 0 ? state.needToShowBlockedDialog : false, (33554431 & 524288) != 0 ? state.needToClearNavigationState : null, (33554431 & 1048576) != 0 ? state.isAccountDeleted : null, (33554431 & 2097152) != 0 ? state.localProfile : null, (33554431 & 4194304) != 0 ? state.isAppLoaded : false, (33554431 & 8388608) != 0 ? state.currentAddresses : null, (33554431 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? state.needReloadForNewAddress : null);
            }
        });
    }

    public ProfileSettings getLocalProfileSettings() {
        LoginState.Session session;
        Object next;
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((LoginState.Session) next).getJwt(), this.prefManager.getJwtToken())) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        if (session != null) {
            return session.getProfileSettings();
        }
        return null;
    }

    public final void postClearingSupportChat() {
        PrefManager prefManager = this.prefManager;
        ProfileSettings profileSettings = prefManager.getProfileSettings();
        profileSettings.setNeedToClearSupportScreen(Boolean.TRUE);
        prefManager.setProfileSettings(profileSettings);
    }

    public LoginState.Session getCurrentSession() {
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        Object obj = null;
        if (sessions == null) {
            return null;
        }
        Iterator<T> it = sessions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((LoginState.Session) next).getJwt(), this.prefManager.getJwtToken())) {
                obj = next;
                break;
            }
        }
        return (LoginState.Session) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean haveSubscription() {
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        LoginState.Session session = null;
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), StringUtilsKt.toPhoneHash(this.prefManager.getPhone()))) {
                    session = next;
                    break;
                }
            }
            session = session;
        }
        if (!(session != null ? Intrinsics.areEqual(session.getHaveSubscription(), Boolean.TRUE) : false) && getIsLoggedIn() && !this.prefManager.getIsNoDomofon()) {
            if (!(session != null ? Intrinsics.areEqual(session.getHaveLoadingVideo(), Boolean.FALSE) : false)) {
                return false;
            }
        }
        return true;
    }

    public final boolean getIsLoggedIn() {
        return this.prefManager.getIsLoggedIn() || !StringsKt.isBlank(this.prefManager.getJwtToken());
    }

    public final boolean getIsInDemoMode() {
        return this.prefManager.getIsNoDomofon();
    }

    public final String getAppVersion() {
        return this.config.getVersionName() + "(" + this.config.getVersionCode() + ")";
    }

    public final String getStore() {
        String platformKeyName = this.config.getPlatformKeyName();
        return Intrinsics.areEqual(platformKeyName, "android") ? "Google Play" : Intrinsics.areEqual(platformKeyName, "huawei") ? "App Gallery" : "-";
    }

    public final UserAddress getFirstInactivatedAddress() {
        Object next;
        Iterator<T> it = getCurrentState().getCurrentAddresses().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!Intrinsics.areEqual(((UserAddress) next).getNavigationStateForAddress(), new ProfileNavigationState.ToActivatedState())) {
                break;
            }
        }
        return (UserAddress) next;
    }

    public final UserAddress getCurrentAddress() {
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        if (currentAddress != null) {
            return new UserAddress(currentAddress.getId(), currentAddress.getFullAddress(), currentAddress.getFullAddressWithApartment(), currentAddress.getAddressVerificationRequired(), currentAddress.getApartment(), currentAddress.getIsSelected(), currentAddress.getFlatUUID(), currentAddress.getEntryUUID(), currentAddress.getStatus());
        }
        return null;
    }

    public static /* synthetic */ void selectCurrentAddress$default(ProfileViewModel profileViewModel, UserAddress userAddress, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        profileViewModel.selectCurrentAddress(userAddress, z);
    }

    public final void selectCurrentAddress(UserAddress address, boolean needDelay) {
        LoginState.Session session;
        List<LoginState.Session.Address> listEmptyList;
        Object next;
        LoginState.Session session2;
        LoginState.Session session3;
        Object next2;
        Object next3;
        Object next4;
        Intrinsics.checkNotNullParameter(address, "address");
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (it.hasNext()) {
                    next4 = it.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next4).getJwt(), this.prefManager.getJwtToken())) {
                        break;
                    }
                } else {
                    next4 = null;
                    break;
                }
            }
            session = (LoginState.Session) next4;
        } else {
            session = null;
        }
        if (session == null || (listEmptyList = session.getAddresses()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<LoginState.Session.Address> list = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (LoginState.Session.Address address2 : list) {
            address2.setSelected(false);
            arrayList.add(address2);
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                next = it2.next();
                if (Intrinsics.areEqual(((LoginState.Session.Address) next).getId(), address.getId())) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        LoginState.Session.Address address3 = (LoginState.Session.Address) next;
        if (address3 != null) {
            address3.setSelected(true);
        }
        List<LoginState.Session> sessions2 = this.prefManager.getLoginState().getSessions();
        if (sessions2 != null) {
            Iterator<T> it3 = sessions2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    next3 = it3.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next3).getJwt(), session != null ? session.getJwt() : null)) {
                        break;
                    }
                } else {
                    next3 = null;
                    break;
                }
            }
            session2 = (LoginState.Session) next3;
        } else {
            session2 = null;
        }
        if (session2 != null) {
            session2.setAddresses(arrayList);
        }
        PrefManager prefManager = this.prefManager;
        LoginState loginState = prefManager.getLoginState();
        List<LoginState.Session> sessions3 = loginState.getSessions();
        if (sessions3 != null) {
            Iterator<T> it4 = sessions3.iterator();
            while (true) {
                if (it4.hasNext()) {
                    next2 = it4.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next2).getJwt(), session != null ? session.getJwt() : null)) {
                        break;
                    }
                } else {
                    next2 = null;
                    break;
                }
            }
            session3 = (LoginState.Session) next2;
        } else {
            session3 = null;
        }
        if (session3 != null) {
            session3.setAddresses(arrayList);
        }
        prefManager.setLoginState(loginState);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(needDelay, this, address, null), 3, null);
    }

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$selectCurrentAddress$3", f = "ProfileViewModel.kt", l = {1271}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$selectCurrentAddress$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAddress $address;
        final /* synthetic */ boolean $needDelay;
        int label;
        final /* synthetic */ ProfileViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(boolean z, ProfileViewModel profileViewModel, UserAddress userAddress, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$needDelay = z;
            this.this$0 = profileViewModel;
            this.$address = userAddress;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$needDelay, this.this$0, this.$address, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                r33 = this;
                r0 = r33
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L19
                if (r2 != r3) goto L11
                kotlin.ResultKt.throwOnFailure(r34)
                goto L2b
            L11:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L19:
                kotlin.ResultKt.throwOnFailure(r34)
                boolean r2 = r0.$needDelay
                if (r2 == 0) goto L2b
                r0.label = r3
                r4 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r4, r0)
                if (r2 != r1) goto L2b
                return r1
            L2b:
                com.sputnik.common.viewmodels.ProfileViewModel r1 = r0.this$0
                com.sputnik.common.entities.addresses.UserAddress r2 = r0.$address
                com.sputnik.common.base.VMState r4 = r1.getCurrentState()
                r5 = r4
                com.sputnik.common.viewmodels.ProfileViewState r5 = (com.sputnik.common.viewmodels.ProfileViewState) r5
                java.util.List r4 = r5.getCurrentAddresses()
                if (r4 == 0) goto L7d
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.ArrayList r6 = new java.util.ArrayList
                r7 = 10
                int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
                r6.<init>(r7)
                java.util.Iterator r4 = r4.iterator()
            L4d:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L73
                java.lang.Object r7 = r4.next()
                com.sputnik.common.entities.addresses.UserAddress r7 = (com.sputnik.common.entities.addresses.UserAddress) r7
                java.lang.Integer r8 = r7.getId()
                java.lang.Integer r9 = r2.getId()
                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
                if (r8 == 0) goto L6b
                r7.setSelected(r3)
                goto L6f
            L6b:
                r8 = 0
                r7.setSelected(r8)
            L6f:
                r6.add(r7)
                goto L4d
            L73:
                java.util.List r2 = kotlin.collections.CollectionsKt.toMutableList(r6)
                if (r2 != 0) goto L7a
                goto L7d
            L7a:
                r29 = r2
                goto L83
            L7d:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                goto L7a
            L83:
                com.sputnik.domain.common.Event r2 = new com.sputnik.domain.common.Event
                r30 = r2
                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                r2.<init>(r3)
                r31 = 8388607(0x7fffff, float:1.1754942E-38)
                r32 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                com.sputnik.common.viewmodels.ProfileViewState r2 = com.sputnik.common.viewmodels.ProfileViewState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
                kotlinx.coroutines.CoroutineScope r3 = androidx.lifecycle.ViewModelKt.getViewModelScope(r1)
                com.sputnik.common.base.BaseViewModel$updateState$1 r6 = new com.sputnik.common.base.BaseViewModel$updateState$1
                r4 = 0
                r6.<init>(r2, r1, r4)
                r7 = 3
                r5 = 0
                kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                androidx.lifecycle.MediatorLiveData r1 = r1.getState()
                r1.setValue(r2)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
