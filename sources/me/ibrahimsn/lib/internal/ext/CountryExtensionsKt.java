package me.ibrahimsn.lib.internal.ext;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ibrahimsn.lib.api.Country;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CountryExtensions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"toCountryList", "", "Lme/ibrahimsn/lib/api/Country;", "", "lib_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CountryExtensionsKt {
    public static final List<Country> toCountryList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("iso2");
                    Intrinsics.checkNotNullExpressionValue(string, "country.getString(\"iso2\")");
                    String string2 = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                    Intrinsics.checkNotNullExpressionValue(string2, "country.getString(\"name\")");
                    arrayList.add(new Country(string, string2, jSONObject.getInt("code")));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
