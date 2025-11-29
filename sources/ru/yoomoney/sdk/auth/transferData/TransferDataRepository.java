package ru.yoomoney.sdk.auth.transferData;

import kotlin.Metadata;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/transferData/TransferDataRepository;", "", "getData", "Lkotlin/Result;", "", YooMoneyAuth.KEY_CRYPTOGRAM, "getData-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "prepareData", "json", "prepareData-IoAF18A", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface TransferDataRepository {
    /* renamed from: getData-IoAF18A, reason: not valid java name */
    Object mo3348getDataIoAF18A(String cryptogram);

    /* renamed from: prepareData-IoAF18A, reason: not valid java name */
    Object mo3349prepareDataIoAF18A(String json);
}
