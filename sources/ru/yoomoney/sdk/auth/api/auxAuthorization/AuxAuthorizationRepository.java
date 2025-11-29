package ru.yoomoney.sdk.auth.api.auxAuthorization;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "", "auxAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "auxAuthorization-BWLJW6A", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auxAuthorizationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "auxAuthorizationInfo-BWLJW6A", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuxAuthorizationRepository {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* renamed from: auxAuthorization-BWLJW6A$default, reason: not valid java name */
        public static /* synthetic */ Object m3243auxAuthorizationBWLJW6A$default(AuxAuthorizationRepository auxAuthorizationRepository, String str, List list, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: auxAuthorization-BWLJW6A");
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return auxAuthorizationRepository.mo3241auxAuthorizationBWLJW6A(str, list, str2, continuation);
        }
    }

    /* renamed from: auxAuthorization-BWLJW6A, reason: not valid java name */
    Object mo3241auxAuthorizationBWLJW6A(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super Result<AuxToken>> continuation);

    /* renamed from: auxAuthorizationInfo-BWLJW6A, reason: not valid java name */
    Object mo3242auxAuthorizationInfoBWLJW6A(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super Result<ApplicationInfo>> continuation);
}
