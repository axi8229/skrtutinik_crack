package com.sputnik.common.viewmodels;

import com.sputnik.common.localization.ILocalizationStorage;
import com.sputnik.common.localization.LocalizationStorage;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* compiled from: LocalizationViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.viewmodels.LocalizationViewModel$tryLoad$1$2$res$1", f = "LocalizationViewModel.kt", l = {158}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class LocalizationViewModel$tryLoad$1$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Long>>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ File $localizationFile;
    int label;
    final /* synthetic */ LocalizationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalizationViewModel$tryLoad$1$2$res$1(LocalizationViewModel localizationViewModel, String str, File file, Continuation<? super LocalizationViewModel$tryLoad$1$2$res$1> continuation) {
        super(2, continuation);
        this.this$0 = localizationViewModel;
        this.$filePath = str;
        this.$localizationFile = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalizationViewModel$tryLoad$1$2$res$1(this.this$0, this.$filePath, this.$localizationFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Deferred<Long>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Long>> continuation) {
        return ((LocalizationViewModel$tryLoad$1$2$res$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocalizationStorage localizationStorage = this.this$0.localizationStorage;
            String str = this.$filePath;
            File file = this.$localizationFile;
            this.label = 1;
            obj = ILocalizationStorage.DefaultImpls.downloadAsync$default(localizationStorage, str, file, null, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
