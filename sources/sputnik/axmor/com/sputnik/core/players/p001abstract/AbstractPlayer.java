package sputnik.axmor.com.sputnik.core.players.p001abstract;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback;

/* compiled from: AbstractPlayer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/abstract/AbstractPlayer;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "applicationContext", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "playerCallback", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;)V", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "Landroidx/lifecycle/Lifecycle;", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "getPlayerCallback", "()Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractPlayer implements DefaultLifecycleObserver {
    private final Context applicationContext;
    private final Lifecycle lifecycle;
    private final PlayerCallback playerCallback;

    public AbstractPlayer(Context applicationContext, Lifecycle lifecycle, PlayerCallback playerCallback) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(playerCallback, "playerCallback");
        this.applicationContext = applicationContext;
        this.lifecycle = lifecycle;
        this.playerCallback = playerCallback;
        lifecycle.addObserver(this);
    }
}
