package sputnik.axmor.com.sputnik.viewmodels;

import kotlin.Metadata;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* compiled from: ISubscriptionViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/viewmodels/ISubscriptionViewModel;", "", "", "id", "plan", "paymentToken", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "paymentMethod", "", "subscribe", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ISubscriptionViewModel {
    void subscribe(String id, String plan, String paymentToken, PaymentMethodType paymentMethod);

    /* compiled from: ISubscriptionViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void subscribe$default(ISubscriptionViewModel iSubscriptionViewModel, String str, String str2, String str3, PaymentMethodType paymentMethodType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                paymentMethodType = null;
            }
            iSubscriptionViewModel.subscribe(str, str2, str3, paymentMethodType);
        }
    }
}
