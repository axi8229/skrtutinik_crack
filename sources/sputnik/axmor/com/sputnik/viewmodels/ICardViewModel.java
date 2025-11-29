package sputnik.axmor.com.sputnik.viewmodels;

import kotlin.Metadata;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* compiled from: ICardViewModel.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/viewmodels/ICardViewModel;", "", "", "paymentToken", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "paymentMethodType", "", "addCard", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ICardViewModel {
    void addCard(String paymentToken, PaymentMethodType paymentMethodType);

    /* compiled from: ICardViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void addCard$default(ICardViewModel iCardViewModel, String str, PaymentMethodType paymentMethodType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCard");
            }
            if ((i & 2) != 0) {
                paymentMethodType = null;
            }
            iCardViewModel.addCard(str, paymentMethodType);
        }
    }
}
