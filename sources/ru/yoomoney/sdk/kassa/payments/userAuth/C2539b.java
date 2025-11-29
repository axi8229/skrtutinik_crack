package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.transferData.TransferDataRepository;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2539b implements InterfaceC2538a {
    public final TransferDataRepository a;

    public C2539b(TransferDataRepository transferDataRepository) {
        Intrinsics.checkNotNullParameter(transferDataRepository, "transferDataRepository");
        this.a = transferDataRepository;
    }
}
