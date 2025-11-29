package com.sputnik.common.viewmodels.interfaces;

import android.content.Context;
import android.content.Intent;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IPaymentsViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JU\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/sputnik/common/viewmodels/interfaces/IPaymentsViewModel;", "", "", "amount", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "callback", "currencyString", "", "formColor", "handlePayment", "(DLjava/lang/String;Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Ljava/lang/String;I)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IPaymentsViewModel {
    void handlePayment(double amount, String title, String subtitle, Context context, Function1<? super Intent, Unit> callback, String currencyString, int formColor);

    /* compiled from: IPaymentsViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void handlePayment$default(IPaymentsViewModel iPaymentsViewModel, double d, String str, String str2, Context context, Function1 function1, String str3, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePayment");
            }
            iPaymentsViewModel.handlePayment(d, str, str2, context, function1, (i2 & 32) != 0 ? "RUB" : str3, i);
        }
    }
}
