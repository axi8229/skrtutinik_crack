package com.sputnik.service_payments.viewmodel.interfaces;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;

/* compiled from: IServicePaymentsViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/service_payments/viewmodel/interfaces/IServicePaymentsViewModel;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "", "updateLastShowingDebtDate", "(Ljava/lang/String;)V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IServicePaymentsViewModel {
    void updateLastShowingDebtDate(String date);

    /* compiled from: IServicePaymentsViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void updateLastShowingDebtDate$default(IServicePaymentsViewModel iServicePaymentsViewModel, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLastShowingDebtDate");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            iServicePaymentsViewModel.updateLastShowingDebtDate(str);
        }
    }
}
