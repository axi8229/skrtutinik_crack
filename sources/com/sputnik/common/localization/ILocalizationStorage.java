package com.sputnik.common.localization;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;

/* compiled from: ILocalizationStorage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JG\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/sputnik/common/localization/ILocalizationStorage;", "", "", "link", "Ljava/io/File;", "file", "Lkotlin/Function2;", "", "", "progress", "Lkotlinx/coroutines/Deferred;", "downloadAsync", "(Ljava/lang/String;Ljava/io/File;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ILocalizationStorage {
    Object downloadAsync(String str, File file, Function2<? super Long, ? super Long, Unit> function2, Continuation<? super Deferred<Long>> continuation);

    /* compiled from: ILocalizationStorage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object downloadAsync$default(ILocalizationStorage iLocalizationStorage, String str, File file, Function2 function2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadAsync");
            }
            if ((i & 4) != 0) {
                function2 = null;
            }
            return iLocalizationStorage.downloadAsync(str, file, function2, continuation);
        }
    }
}
