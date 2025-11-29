package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcelable;
import java.util.List;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public abstract class T implements Parcelable {
    public static final int $stable = 0;

    public T() {
    }

    public /* synthetic */ T(int i) {
        this();
    }

    public abstract Amount getCharge();

    public abstract List getConfirmationTypes();

    public abstract A getFee();

    public abstract String getIcon();

    public abstract int getId();

    public abstract boolean getSavePaymentInstrument();

    public abstract boolean getSavePaymentMethodAllowed();

    public abstract String getTitle();
}
