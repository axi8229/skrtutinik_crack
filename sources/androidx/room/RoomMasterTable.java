package androidx.room;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomMasterTable.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/RoomMasterTable;", "", "<init>", "()V", "", "hash", "createInsertQuery", "(Ljava/lang/String;)Ljava/lang/String;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RoomMasterTable {
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();

    private RoomMasterTable() {
    }

    @JvmStatic
    public static final String createInsertQuery(String hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
