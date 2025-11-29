package com.sputnik.domain.repositories.auth;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainApplyRegistration;
import com.sputnik.domain.entities.auth.DomainConfirmResponse;
import com.sputnik.domain.entities.auth.DomainRequestInfo;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IAuthRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJM\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b0\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/sputnik/domain/repositories/auth/IAuthRepository;", "", "", "phone", "smsCode", "app", "platform", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainApplyRegistration;", "apply", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "requestId", "authCode", "Lcom/sputnik/domain/entities/auth/DomainConfirmResponse;", "confirm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", "getRequest", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAuthRepository {
    Flow<Resource<DomainApplyRegistration>> apply(String phone, String smsCode, String app, String platform);

    Flow<Resource<DomainConfirmResponse>> confirm(String requestId, String authCode, String platform, String app, String phone);

    Flow<Resource<DomainRequestInfo>> getRequest(String requestId, String phone);
}
