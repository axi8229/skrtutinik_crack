package com.sputnik.data.api;

import com.sputnik.data.entities.payments.DataPaymentReceipt;
import com.sputnik.data.entities.service_payments.DataIntercomPayRequest;
import com.sputnik.data.entities.service_payments.DataIntercomPaymentInfo;
import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.entities.service_payments.DataPaymentItem;
import com.sputnik.data.entities.service_payments.DataPromisePayment;
import com.sputnik.data.entities.service_payments.DataServiceAccountInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: ServicePaymentsApi.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0006J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\b\b\u0001\u0010\r\u001a\u00020\u00072\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/sputnik/data/api/ServicePaymentsApi;", "", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "getPayments", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "accrualUuid", "state", "Lcom/sputnik/data/entities/payments/DataPaymentReceipt;", "getLastPaymentOfAccrual", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uuid", "Lcom/sputnik/data/entities/service_payments/DataPaymentItem;", "getPayment", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/data/entities/service_payments/DataPromisePayment;", "promisePayment", "Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;", "getAccountInfo", "Lcom/sputnik/data/entities/service_payments/DataIntercomPayRequest;", "body", "Lcom/sputnik/data/entities/service_payments/DataIntercomPaymentInfo;", "payIntercom", "(Ljava/lang/String;Lcom/sputnik/data/entities/service_payments/DataIntercomPayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServicePaymentsApi {
    @GET("ledger/accrual_account")
    Object getAccountInfo(Continuation<? super Response<DataServiceAccountInfo>> continuation);

    @GET("ledger/accruals/{uuid}/payments/last")
    Object getLastPaymentOfAccrual(@Path("uuid") String str, @Query("state") String str2, Continuation<? super Response<DataPaymentReceipt>> continuation);

    @GET("ledger/payments/{uuid}")
    Object getPayment(@Path("uuid") String str, Continuation<? super Response<DataPaymentItem>> continuation);

    @GET("ledger/accruals")
    Object getPayments(Continuation<? super Response<List<DataPaymentHistory>>> continuation);

    @POST("ledger/accruals/{uuid}/payments/yookassa")
    Object payIntercom(@Path("uuid") String str, @Body DataIntercomPayRequest dataIntercomPayRequest, Continuation<? super Response<DataIntercomPaymentInfo>> continuation);

    @POST("ledger/accruals/{uuid}/promised_payments")
    Object promisePayment(@Path("uuid") String str, Continuation<? super Response<DataPromisePayment>> continuation);

    /* compiled from: ServicePaymentsApi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getLastPaymentOfAccrual$default(ServicePaymentsApi servicePaymentsApi, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLastPaymentOfAccrual");
            }
            if ((i & 2) != 0) {
                str2 = "succeeded";
            }
            return servicePaymentsApi.getLastPaymentOfAccrual(str, str2, continuation);
        }
    }
}
