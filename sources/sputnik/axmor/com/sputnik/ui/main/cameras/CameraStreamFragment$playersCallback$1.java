package sputnik.axmor.com.sputnik.ui.main.cameras;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: CameraStreamFragment.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"sputnik/axmor/com/sputnik/ui/main/cameras/CameraStreamFragment$playersCallback$1", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "onStateChanged", "", "state", "Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "player", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback$Players;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraStreamFragment$playersCallback$1 implements PlayersCallback {
    final /* synthetic */ CameraStreamFragment this$0;

    CameraStreamFragment$playersCallback$1(CameraStreamFragment cameraStreamFragment) {
        this.this$0 = cameraStreamFragment;
    }

    @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback
    public void onStateChanged(final PlayerStates state, final PlayersCallback.Players player) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.this$0.getView() != null) {
            final CameraStreamFragment cameraStreamFragment = this.this$0;
            try {
                FragmentActivity activity = cameraStreamFragment.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$playersCallback$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraStreamFragment$playersCallback$1.onStateChanged$lambda$2$lambda$1$lambda$0(cameraStreamFragment, player, state);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStateChanged$lambda$2$lambda$1$lambda$0(CameraStreamFragment this$0, PlayersCallback.Players player, PlayerStates state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(player, "$player");
        Intrinsics.checkNotNullParameter(state, "$state");
        BuildersKt__Builders_commonKt.launch$default(this$0.getMainCoroutineScope(), null, null, new CameraStreamFragment$playersCallback$1$onStateChanged$1$1$1$1(this$0, player, state, null), 3, null);
    }
}
