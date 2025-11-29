package ru.yoomoney.sdk.auth.auxToken.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "", "auxAuthorization", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auxAuthorizationInfo", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuxTokenIssueInteractor {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object auxAuthorization$default(AuxTokenIssueInteractor auxTokenIssueInteractor, String str, List list, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: auxAuthorization");
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return auxTokenIssueInteractor.auxAuthorization(str, list, str2, continuation);
        }
    }

    Object auxAuthorization(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super AuxTokenIssue.Action> continuation);

    Object auxAuthorizationInfo(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super AuxTokenIssue.Action> continuation);
}
