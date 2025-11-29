package com.yandex.metrica.coreutils.services;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UtilityServiceLocator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yandex/metrica/coreutils/services/UtilityServiceLocator;", "", "()V", "activationBarrier", "Lcom/yandex/metrica/coreutils/services/ActivationBarrier;", "getActivationBarrier", "()Lcom/yandex/metrica/coreutils/services/ActivationBarrier;", "firstExecutionService", "Lcom/yandex/metrica/coreutils/services/FirstExecutionConditionService;", "getFirstExecutionService", "()Lcom/yandex/metrica/coreutils/services/FirstExecutionConditionService;", "firstExecutionService$delegate", "Lkotlin/Lazy;", "initAsync", "", "updateConfiguration", "configuration", "Lcom/yandex/metrica/coreutils/services/UtilityServiceConfiguration;", "Companion", "core-utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class UtilityServiceLocator {
    private static volatile UtilityServiceLocator instance = new UtilityServiceLocator();

    /* renamed from: firstExecutionService$delegate, reason: from kotlin metadata */
    private final Lazy firstExecutionService = LazyKt.lazy(new Function0<FirstExecutionConditionService>() { // from class: com.yandex.metrica.coreutils.services.UtilityServiceLocator$firstExecutionService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FirstExecutionConditionService invoke() {
            return new FirstExecutionConditionService();
        }
    });
    private final ActivationBarrier activationBarrier = new ActivationBarrier();

    @JvmStatic
    public static final UtilityServiceLocator getInstance() {
        return instance;
    }

    public final FirstExecutionConditionService getFirstExecutionService() {
        return (FirstExecutionConditionService) this.firstExecutionService.getValue();
    }

    public final ActivationBarrier getActivationBarrier() {
        return this.activationBarrier;
    }

    public final void initAsync() {
        this.activationBarrier.activate();
    }

    public final void updateConfiguration(UtilityServiceConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        getFirstExecutionService().updateConfig(configuration);
    }
}
