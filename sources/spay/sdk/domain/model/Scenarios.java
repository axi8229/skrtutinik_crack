package spay.sdk.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lspay/sdk/domain/model/Scenarios;", "", "()V", "OrderIdScenario", "PurchaseScenario", "Lspay/sdk/domain/model/Scenarios$OrderIdScenario;", "Lspay/sdk/domain/model/Scenarios$PurchaseScenario;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Scenarios {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lspay/sdk/domain/model/Scenarios$OrderIdScenario;", "Lspay/sdk/domain/model/Scenarios;", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OrderIdScenario extends Scenarios {
        public static final OrderIdScenario INSTANCE = new OrderIdScenario();

        private OrderIdScenario() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lspay/sdk/domain/model/Scenarios$PurchaseScenario;", "Lspay/sdk/domain/model/Scenarios;", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PurchaseScenario extends Scenarios {
        public static final PurchaseScenario INSTANCE = new PurchaseScenario();

        private PurchaseScenario() {
            super(null);
        }
    }

    private Scenarios() {
    }

    public /* synthetic */ Scenarios(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
