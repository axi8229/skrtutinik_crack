package sputnik.axmor.com.sputnik.services.call_service;

import com.sputnik.domain.usecases.call.GetCallUseCase;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CheckCallStateService_MembersInjector implements MembersInjector<CheckCallStateService> {
    public static void injectGetCallUseCase(CheckCallStateService checkCallStateService, GetCallUseCase getCallUseCase) {
        checkCallStateService.getCallUseCase = getCallUseCase;
    }
}
