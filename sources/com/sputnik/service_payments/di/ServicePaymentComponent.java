package com.sputnik.service_payments.di;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sputnik.service_payments.ui.BottomSheetAboutCompany;
import com.sputnik.service_payments.ui.BottomSheetPaymentInfo;
import com.sputnik.service_payments.ui.BottomSheetPaymentStop;
import com.sputnik.service_payments.ui.DetailsPaymentFragment;
import com.sputnik.service_payments.ui.SuccessPaymentFragment;
import com.sputnik.service_payments.ui.blocking.BlockingDialog;
import com.sputnik.service_payments.ui.blocking.BlockingPaymentFragment;
import com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment;
import com.sputnik.service_payments.ui.blocking.BottomSheetArgueDebt;
import com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment;
import com.sputnik.service_payments.ui.blocking.DialogSuccessPromise;
import com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment;
import kotlin.Metadata;

/* compiled from: ServicePaymentComponent.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/sputnik/service_payments/di/ServicePaymentComponent;", "", "inject", "", "bottomSheet", "Lcom/sputnik/service_payments/ui/BottomSheetAboutCompany;", "Lcom/sputnik/service_payments/ui/BottomSheetPaymentInfo;", "Lcom/sputnik/service_payments/ui/BottomSheetPaymentStop;", "fragment", "Lcom/sputnik/service_payments/ui/DetailsPaymentFragment;", "Lcom/sputnik/service_payments/ui/SuccessPaymentFragment;", "Lcom/sputnik/service_payments/ui/blocking/BlockingDialog;", "Lcom/sputnik/service_payments/ui/blocking/BlockingPaymentFragment;", "Lcom/sputnik/service_payments/ui/blocking/BlockingPromiseBlockFragment;", "Lcom/sputnik/service_payments/ui/blocking/BottomSheetArgueDebt;", "Lcom/sputnik/service_payments/ui/blocking/BottomSheetPromisePayment;", "dialog", "Lcom/sputnik/service_payments/ui/blocking/DialogSuccessPromise;", "Lcom/sputnik/service_payments/ui/payment_info_list/IntercomPaymentFragment;", "Builder", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServicePaymentComponent {

    /* compiled from: ServicePaymentComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/sputnik/service_payments/di/ServicePaymentComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/sputnik/service_payments/di/ServicePaymentComponent;", "deps", "servicePaymentDeps", "Lcom/sputnik/service_payments/di/ServicePaymentDeps;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        ServicePaymentComponent build();

        Builder deps(ServicePaymentDeps servicePaymentDeps);
    }

    void inject(BottomSheetAboutCompany bottomSheet);

    void inject(BottomSheetPaymentInfo bottomSheet);

    void inject(BottomSheetPaymentStop bottomSheet);

    void inject(DetailsPaymentFragment fragment);

    void inject(SuccessPaymentFragment fragment);

    void inject(BlockingDialog fragment);

    void inject(BlockingPaymentFragment fragment);

    void inject(BlockingPromiseBlockFragment fragment);

    void inject(BottomSheetArgueDebt bottomSheet);

    void inject(BottomSheetPromisePayment bottomSheet);

    void inject(DialogSuccessPromise dialog);

    void inject(IntercomPaymentFragment fragment);
}
