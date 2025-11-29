package com.yandex.metrica.identifiers.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e {
    private final d a;
    private final Function1 b;
    private final String c;
    private final w d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Intent intent, Function1 converter, String serviceShortTag) {
        this(new d(intent, serviceShortTag), converter, "[AdInServiceConnectionController-" + serviceShortTag + ']', serviceShortTag, new w());
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(serviceShortTag, "serviceShortTag");
    }

    public e(d connection, Function1 converter, String tag, String serviceShortTag, w safePackageManager) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(serviceShortTag, "serviceShortTag");
        Intrinsics.checkNotNullParameter(safePackageManager, "safePackageManager");
        this.a = connection;
        this.b = converter;
        this.c = serviceShortTag;
        this.d = safePackageManager;
    }

    public final Object a(Context context) throws j {
        ResolveInfo resolveInfoResolveService;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = this.a.a();
        Intrinsics.checkNotNullExpressionValue(intentA, "connection.intent");
        this.d.getClass();
        IBinder iBinderA = null;
        try {
            resolveInfoResolveService = context.getPackageManager().resolveService(intentA, 0);
        } catch (Throwable unused) {
            resolveInfoResolveService = null;
        }
        if (resolveInfoResolveService == null) {
            throw new m("could not resolve " + this.c + " services");
        }
        try {
            if (this.a.a(context)) {
                iBinderA = this.a.a(3000L);
            }
        } catch (Throwable unused2) {
        }
        if (iBinderA != null) {
            return this.b.invoke(iBinderA);
        }
        throw new j("could not bind to " + this.c + " services");
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            this.a.b(context);
        } catch (Throwable unused) {
        }
    }
}
