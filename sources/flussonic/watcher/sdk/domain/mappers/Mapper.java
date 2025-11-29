package flussonic.watcher.sdk.domain.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public interface Mapper<FromObject, ToObject> {
    ToObject create(FromObject fromObject);

    default ToObject map(FromObject fromObject) {
        if (fromObject == null) {
            return null;
        }
        return create(fromObject);
    }

    default List<ToObject> map(List<FromObject> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FromObject> it = list.iterator();
        while (it.hasNext()) {
            ToObject map = map((Mapper<FromObject, ToObject>) it.next());
            if (map != null) {
                arrayList.add(map);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
