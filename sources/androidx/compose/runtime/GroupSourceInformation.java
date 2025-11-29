package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0014J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR6\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroidx/compose/runtime/GroupSourceInformation;", "", "openInformation", "()Landroidx/compose/runtime/GroupSourceInformation;", "group", "", "add", "(Ljava/lang/Object;)V", "Landroidx/compose/runtime/Anchor;", "anchor", "", "hasAnchor", "(Landroidx/compose/runtime/Anchor;)Z", "Landroidx/compose/runtime/SlotWriter;", "writer", "", "reportGroup", "(Landroidx/compose/runtime/SlotWriter;I)V", "Landroidx/compose/runtime/SlotTable;", "table", "(Landroidx/compose/runtime/SlotTable;I)V", "predecessor", "addGroupAfter", "(Landroidx/compose/runtime/SlotWriter;II)V", "removeAnchor", "key", "I", "getKey", "()I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groups", "Ljava/util/ArrayList;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GroupSourceInformation {
    private boolean closed;
    private ArrayList<Object> groups;
    private final int key;

    public final int getKey() {
        return this.key;
    }

    public final ArrayList<Object> getGroups() {
        return this.groups;
    }

    public final void reportGroup(SlotWriter writer, int group) {
        openInformation().add(writer.anchor(group));
    }

    public final void reportGroup(SlotTable table, int group) {
        openInformation().add(table.anchor(group));
    }

    public final void addGroupAfter(SlotWriter writer, int predecessor, int group) {
        Anchor anchorTryAnchor$runtime_release;
        ArrayList<Object> arrayList = this.groups;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.groups = arrayList;
        }
        int i = 0;
        if (predecessor >= 0 && (anchorTryAnchor$runtime_release = writer.tryAnchor$runtime_release(predecessor)) != null) {
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                Object obj = arrayList.get(i);
                if (Intrinsics.areEqual(obj, anchorTryAnchor$runtime_release) || ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).hasAnchor(anchorTryAnchor$runtime_release))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        arrayList.add(i, writer.anchor(group));
    }

    private final GroupSourceInformation openInformation() {
        Object obj;
        GroupSourceInformation groupSourceInformationOpenInformation;
        ArrayList<Object> arrayList = this.groups;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                obj = arrayList.get(size);
                if ((obj instanceof GroupSourceInformation) && !((GroupSourceInformation) obj).closed) {
                    break;
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        GroupSourceInformation groupSourceInformation = obj instanceof GroupSourceInformation ? (GroupSourceInformation) obj : null;
        return (groupSourceInformation == null || (groupSourceInformationOpenInformation = groupSourceInformation.openInformation()) == null) ? this : groupSourceInformationOpenInformation;
    }

    private final void add(Object group) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.groups = arrayList;
        arrayList.add(group);
    }

    private final boolean hasAnchor(Anchor anchor) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (Intrinsics.areEqual(obj, anchor) || ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).hasAnchor(anchor))) {
                return true;
            }
        }
        return false;
    }

    public final boolean removeAnchor(Anchor anchor) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Object obj = arrayList.get(size);
                if (obj instanceof Anchor) {
                    if (Intrinsics.areEqual(obj, anchor)) {
                        arrayList.remove(size);
                    }
                } else if ((obj instanceof GroupSourceInformation) && !((GroupSourceInformation) obj).removeAnchor(anchor)) {
                    arrayList.remove(size);
                }
            }
            if (arrayList.isEmpty()) {
                this.groups = null;
                return false;
            }
        }
        return true;
    }
}
