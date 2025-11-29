package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.impl.ob.Jf;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.fa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC0921fa<T> {

    /* renamed from: com.yandex.metrica.impl.ob.fa$b */
    public static class b {
        private final HashMap<Class<?>, InterfaceC0921fa<?>> a;
        private final InterfaceC0921fa<C1202qi> b;
        private final InterfaceC0921fa<Jf.e> c;
        private final InterfaceC0921fa<List<Bd>> d;
        private final InterfaceC0921fa<C1268td> e;
        private final InterfaceC0921fa<C0903eh> f;

        @Deprecated
        private final InterfaceC0921fa<C0900ee> g;

        @Deprecated
        private final InterfaceC0921fa<Z1> h;
        private final InterfaceC0921fa<Ud> i;
        private final InterfaceC0921fa<X2> j;
        private final InterfaceC0921fa<C1306v3> k;

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$a */
        class a extends AbstractC0946ga<C1306v3> {
            a(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("clids_info", r7, new C0896ea(new C1325vm(context)).c(), new C1360x9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$b, reason: collision with other inner class name */
        class C0289b extends AbstractC0946ga<C1202qi> {
            C0289b(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("startup_state", r7, new C0896ea(new C1325vm(context)).i(), new X9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$c */
        class c extends AbstractC0946ga<Jf.e> {
            c(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("provided_request_state", r7, new C0896ea(new C1325vm(context)).g(), new R9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$d */
        class d extends AbstractC0946ga<List<Bd>> {
            d(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("permission_list", r7, new C0896ea(new C1325vm(context)).d(), new P9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$e */
        class e extends AbstractC0946ga<C1268td> {
            e(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("app_permissions_state", r7, new C0896ea(new C1325vm(context)).a(), new C1216r9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$f */
        class f extends AbstractC0946ga<C0903eh> {
            f(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("sdk_fingerprinting", r7, new C0896ea(new C1325vm(context)).h(), new V9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$g */
        class g extends AbstractC0946ga<C0900ee> {
            g(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("preload_info", r7, new C0896ea(new C1325vm(context)).f(), new C0925fe());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$h */
        class h extends AbstractC0946ga<Z1> {
            h(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("satellite_clids_info", r7, new C1119n9(), new T9());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$i */
        class i extends AbstractC0946ga<Ud> {
            i(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("preload_info_data", r7, new C0896ea(new C1325vm(context)).e(), new Wd());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).n();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).o();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$j */
        class j extends AbstractC0946ga<X2> {
            j(b bVar) {
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected ProtobufStateStorage a(Context context, R7 r7) {
                return new C1069l9("auto_inapp_collecting_info_data", r7, new C0896ea(new C1325vm(context)).b(), new Y2());
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 c(Context context) {
                return C1020ja.a(context).a();
            }

            @Override // com.yandex.metrica.impl.ob.AbstractC0946ga
            protected R7 d(Context context) {
                return C1020ja.a(context).b();
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.fa$b$k */
        private static final class k {
            static final b a = new b();
        }

        public static <T> InterfaceC0921fa<T> a(Class<T> cls) {
            return (InterfaceC0921fa) k.a.a.get(cls);
        }

        public static <T> InterfaceC0921fa<Collection<T>> b(Class<T> cls) {
            return (InterfaceC0921fa) k.a.a.get(cls);
        }

        private b() {
            HashMap<Class<?>, InterfaceC0921fa<?>> map = new HashMap<>();
            this.a = map;
            C0289b c0289b = new C0289b(this);
            this.b = c0289b;
            c cVar = new c(this);
            this.c = cVar;
            d dVar = new d(this);
            this.d = dVar;
            e eVar = new e(this);
            this.e = eVar;
            f fVar = new f(this);
            this.f = fVar;
            g gVar = new g(this);
            this.g = gVar;
            h hVar = new h(this);
            this.h = hVar;
            i iVar = new i(this);
            this.i = iVar;
            j jVar = new j(this);
            this.j = jVar;
            a aVar = new a(this);
            this.k = aVar;
            map.put(C1202qi.class, c0289b);
            map.put(Jf.e.class, cVar);
            map.put(Bd.class, dVar);
            map.put(C1268td.class, eVar);
            map.put(C0903eh.class, fVar);
            map.put(C0900ee.class, gVar);
            map.put(Z1.class, hVar);
            map.put(Ud.class, iVar);
            map.put(X2.class, jVar);
            map.put(C1306v3.class, aVar);
        }
    }

    ProtobufStateStorage a(Context context);

    ProtobufStateStorage b(Context context);
}
