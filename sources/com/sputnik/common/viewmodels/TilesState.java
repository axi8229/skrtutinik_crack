package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.tiles.Tile;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TilesViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/sputnik/common/viewmodels/TilesState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/tiles/Tile;", "tiles", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;)Lcom/sputnik/common/viewmodels/TilesState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getTiles", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TilesState implements VMState {
    private final Resource.Status serverState;
    private final List<Tile> tiles;

    public TilesState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TilesState copy$default(TilesState tilesState, Resource.Status status, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            status = tilesState.serverState;
        }
        if ((i & 2) != 0) {
            list = tilesState.tiles;
        }
        return tilesState.copy(status, list);
    }

    public final TilesState copy(Resource.Status serverState, List<Tile> tiles) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        return new TilesState(serverState, tiles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TilesState)) {
            return false;
        }
        TilesState tilesState = (TilesState) other;
        return this.serverState == tilesState.serverState && Intrinsics.areEqual(this.tiles, tilesState.tiles);
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        List<Tile> list = this.tiles;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "TilesState(serverState=" + this.serverState + ", tiles=" + this.tiles + ")";
    }

    public TilesState(Resource.Status serverState, List<Tile> list) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        this.serverState = serverState;
        this.tiles = list;
    }

    public /* synthetic */ TilesState(Resource.Status status, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? null : list);
    }

    public final List<Tile> getTiles() {
        return this.tiles;
    }
}
