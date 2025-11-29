package com.sputnik.domain.usecases.alerts;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.repositories.alerts.IAlertsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetAlertsUseCase.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J=\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sputnik/domain/usecases/alerts/GetAlertsUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/alerts/IAlertsRepository;", "(Lcom/sputnik/domain/repositories/alerts/IAlertsRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "platform", "", "app", "locale", "version", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetAlertsUseCase {
    private final IAlertsRepository repository;

    public GetAlertsUseCase(IAlertsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public static /* synthetic */ Flow invoke$default(GetAlertsUseCase getAlertsUseCase, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1;
        }
        return getAlertsUseCase.invoke(str, str2, str3, i);
    }

    public final Flow<Resource<List<DomainAlert>>> invoke(String platform, String app, String locale, int version) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return this.repository.getAlerts(version, platform, app, locale);
    }
}
