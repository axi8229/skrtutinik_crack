package sputnik.axmor.com.sputnik.ui.settings;

import com.sputnik.activationautomation.data.files.ILogger;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.scancameraidentifiers.data.files.FileManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SettingsActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$initViews$1$19$1", f = "SettingsActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class SettingsActivity$initViews$1$19$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ILogger $file;
    final /* synthetic */ Ref$ObjectRef<String> $s;
    int label;
    final /* synthetic */ SettingsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsActivity$initViews$1$19$1(ILogger iLogger, Ref$ObjectRef<String> ref$ObjectRef, SettingsActivity settingsActivity, Continuation<? super SettingsActivity$initViews$1$19$1> continuation) {
        super(2, continuation);
        this.$file = iLogger;
        this.$s = ref$ObjectRef;
        this.this$0 = settingsActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsActivity$initViews$1$19$1(this.$file, this.$s, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsActivity$initViews$1$19$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$file.write(this.$s.element);
        String absolutePath = FileManager.INSTANCE.getFile(this.this$0, "prefs.txt").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        IntentUtilsKt.sendFile(absolutePath, this.this$0);
        return Unit.INSTANCE;
    }
}
