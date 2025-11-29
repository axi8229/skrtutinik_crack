package ru.yoomoney.sdk.guiCompose.views.form;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConfirmCodeInputView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.guiCompose.views.form.ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1", f = "ConfirmCodeInputView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1(boolean z, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, Continuation<? super ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1(this.$enabled, this.$focusRequester, this.$keyboardController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConfirmCodeInputViewKt$ConfirmCodeInputView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$enabled) {
            this.$focusRequester.requestFocus();
        } else {
            SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
        }
        return Unit.INSTANCE;
    }
}
