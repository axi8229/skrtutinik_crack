package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes3.dex */
public final class Q7 implements InterfaceC0919f8 {
    private final Context a;
    private final String b;
    private final B0 c;

    public Q7(Context context, String str, B0 b0) {
        this.a = context;
        this.b = str;
        this.c = b0;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public void a(String str) {
        try {
            File fileA = this.c.a(this.a, this.b);
            if (fileA != null) {
                FilesKt.writeText$default(fileA, str, null, 2, null);
            }
        } catch (FileNotFoundException unused) {
            ((C1127nh) C1152oh.a()).reportEvent("vital_data_provider_write_file_not_found", MapsKt.mapOf(TuplesKt.to("fileName", this.b)));
        } catch (Throwable th) {
            ((C1127nh) C1152oh.a()).reportEvent("vital_data_provider_write_exception", MapsKt.mapOf(TuplesKt.to("fileName", this.b), TuplesKt.to("exception", Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName())));
            ((C1127nh) C1152oh.a()).reportError("Error during writing file with name " + this.b, th);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public String c() {
        try {
            File fileA = this.c.a(this.a, this.b);
            if (fileA != null) {
                return FilesKt.readText$default(fileA, null, 1, null);
            }
            return null;
        } catch (FileNotFoundException unused) {
            ((C1127nh) C1152oh.a()).reportEvent("vital_data_provider_read_file_not_found", MapsKt.mapOf(TuplesKt.to("fileName", this.b)));
            return null;
        } catch (Throwable th) {
            ((C1127nh) C1152oh.a()).reportEvent("vital_data_provider_read_exception", MapsKt.mapOf(TuplesKt.to("fileName", this.b), TuplesKt.to("exception", Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName())));
            ((C1127nh) C1152oh.a()).reportError("Error during reading file with name " + this.b, th);
            return null;
        }
    }
}
