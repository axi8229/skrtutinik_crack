package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: GlobalCameraFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1", f = "GlobalCameraFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayersCallback.Players $player;
    final /* synthetic */ PlayerStates $state;
    int label;
    final /* synthetic */ GlobalCameraFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1(GlobalCameraFragment globalCameraFragment, PlayersCallback.Players players, PlayerStates playerStates, Continuation<? super GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = globalCameraFragment;
        this.$player = players;
        this.$state = playerStates;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1(this.this$0, this.$player, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalCameraFragment$playersCallback$1$onStateChanged$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZoomLayout zoomLayout = this.this$0.getBinding().layoutZoom2;
            if (zoomLayout != null) {
                PlayersCallback.Players players = this.$player;
                ViewBindingUtilsKt.visibilityBasedOn(zoomLayout, Boxing.boxBoolean(players == PlayersCallback.Players.EXO || players == PlayersCallback.Players.VLC));
            }
            ZoomLayout zoomLayout2 = this.this$0.getBinding().layoutZoom;
            if (zoomLayout2 != null) {
                ViewBindingUtilsKt.visibilityBasedOn(zoomLayout2, Boxing.boxBoolean(this.$player == PlayersCallback.Players.WEBRTC));
            }
            if (this.$state == PlayerStates.ERROR) {
                this.this$0.showErrorLoadCamera();
                this.this$0.reloadStreamWithDelay();
                this.this$0.getCameraViewModel().setCurrentCameraLiveState(false);
            }
            if (this.$state == PlayerStates.LOADED) {
                this.this$0.getCameraViewModel().setCurrentCameraLiveState(true);
                LinearLayout videoLoader = this.this$0.getBinding().videoLoader;
                Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
                ViewKt.gone(videoLoader);
                LinearLayout previewError = this.this$0.getBinding().previewError;
                Intrinsics.checkNotNullExpressionValue(previewError, "previewError");
                ViewKt.gone(previewError);
                HorizontalScrollView hsPreview = this.this$0.getBinding().hsPreview;
                Intrinsics.checkNotNullExpressionValue(hsPreview, "hsPreview");
                ViewKt.gone(hsPreview);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
