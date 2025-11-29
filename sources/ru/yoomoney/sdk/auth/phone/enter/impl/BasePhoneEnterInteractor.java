package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPreloadData", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registrationConfirmPhone", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhonePasswordRecovery", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BasePhoneEnterInteractor {
    Object checkExpiration(PhoneEnter.Action.CheckExpiration checkExpiration, Continuation<? super PhoneEnter.Action> continuation);

    Object checkPreloadData(PhoneEnter.Action.LoadData loadData, Continuation<? super PhoneEnter.Action> continuation);

    Object registrationConfirmPhone(String str, Continuation<? super PhoneEnter.Action> continuation);

    Object setPhone(PhoneEnter.Action.SetPhone setPhone, CountryCallingCode countryCallingCode, Continuation<? super PhoneEnter.Action> continuation);

    Object setPhonePasswordRecovery(String str, String str2, Continuation<? super PhoneEnter.Action> continuation);
}
