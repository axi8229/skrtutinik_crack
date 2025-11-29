package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Tl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Si {
    void a(Ui ui, Tl.a aVar) {
        JSONObject jSONObjectOptJSONObject;
        if (!ui.O() || (jSONObjectOptJSONObject = aVar.optJSONObject("socket")) == null) {
            return;
        }
        If.q qVar = new If.q();
        long jOptLong = jSONObjectOptJSONObject.optLong("seconds_to_live");
        long jOptLong2 = jSONObjectOptJSONObject.optLong("first_delay_seconds", qVar.e);
        int iOptInt = jSONObjectOptJSONObject.optInt("launch_delay_seconds", qVar.f);
        long jOptLong3 = jSONObjectOptJSONObject.optLong("open_event_interval_seconds", qVar.g);
        long jOptLong4 = jSONObjectOptJSONObject.optLong("min_failed_request_interval_seconds", qVar.h);
        long jOptLong5 = jSONObjectOptJSONObject.optLong("min_successful_request_interval_seconds", qVar.i);
        long jOptLong6 = jSONObjectOptJSONObject.optLong("open_retry_interval_seconds", qVar.j);
        String strOptString = jSONObjectOptJSONObject.optString("token");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ports_https");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = jSONArray;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("ports_http");
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = jSONArray2;
        }
        boolean z = jSONArrayOptJSONArray.length() > 0 || jSONArrayOptJSONArray2.length() > 0;
        if (jOptLong <= 0 || TextUtils.isEmpty(strOptString) || !z) {
            return;
        }
        List<Integer> listA = a(jSONArrayOptJSONArray);
        List<Integer> listA2 = a(jSONArrayOptJSONArray2);
        if (((ArrayList) listA).isEmpty() && ((ArrayList) listA2).isEmpty()) {
            return;
        }
        ui.a(new C0879di(jOptLong, strOptString, listA, listA2, jOptLong2, iOptInt, jOptLong3, jOptLong4, jOptLong5, jOptLong6));
    }

    private List<Integer> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            int iOptInt = jSONArray.optInt(i);
            if (iOptInt != 0) {
                arrayList.add(Integer.valueOf(iOptInt));
            }
        }
        return arrayList;
    }
}
