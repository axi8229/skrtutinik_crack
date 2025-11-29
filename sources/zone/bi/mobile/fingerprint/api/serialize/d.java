package zone.bi.mobile.fingerprint.api.serialize;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes5.dex */
public abstract class d extends a {
    public static zone.bi.mobile.fingerprint.api.serialize.model.c a(zone.bi.mobile.fingerprint.api.serialize.model.a aVar) throws JSONException, b {
        Serializable string;
        try {
            zone.bi.mobile.fingerprint.api.serialize.model.c cVar = new zone.bi.mobile.fingerprint.api.serialize.model.c();
            for (Map.Entry entry : aVar.entrySet()) {
                String str = (String) entry.getKey();
                Serializable serializable = (Serializable) entry.getValue();
                if (serializable instanceof String) {
                    String str2 = (String) serializable;
                    if (str2.length() == 0) {
                        string = str2;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < str2.length(); i++) {
                            char cCharAt = str2.charAt(i);
                            if (cCharAt != '\'' && cCharAt != '\"' && cCharAt != '>' && cCharAt != '&' && cCharAt != '<') {
                                sb.append(cCharAt);
                            }
                        }
                        string = sb.toString();
                    }
                } else {
                    if (!str.equals("HoursSinceInstall") && !str.equals("GoogleServicesParameters")) {
                        if (serializable instanceof zone.bi.mobile.fingerprint.api.serialize.model.a) {
                            string = a((zone.bi.mobile.fingerprint.api.serialize.model.a) serializable);
                        } else {
                            boolean z = serializable instanceof zone.bi.mobile.fingerprint.api.serialize.model.d;
                            string = serializable;
                            if (z) {
                                zone.bi.mobile.fingerprint.api.serialize.model.b bVar = new zone.bi.mobile.fingerprint.api.serialize.model.b();
                                Iterator it = ((zone.bi.mobile.fingerprint.api.serialize.model.d) serializable).iterator();
                                while (it.hasNext()) {
                                    bVar.put(a((zone.bi.mobile.fingerprint.api.serialize.model.a) it.next()));
                                }
                                string = bVar;
                            }
                        }
                    }
                    for (Map.Entry entry2 : ((zone.bi.mobile.fingerprint.api.serialize.model.a) serializable).entrySet()) {
                        cVar.put((String) entry2.getKey(), entry2.getValue());
                    }
                }
                cVar.put(str, string);
            }
            return cVar;
        } catch (JSONException e) {
            throw new b(e);
        }
    }
}
