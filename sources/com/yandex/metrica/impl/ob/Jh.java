package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.FirstExecutionConditionService;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.UtilityServiceLocator;
import com.yandex.metrica.impl.ob.Fh;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Jh implements Runnable, Gh {
    private final ServiceConnection a;
    private final Handler b;
    private final Runnable c;
    private final HashMap<String, Bh> d;
    private final Context e;
    private volatile boolean f;
    private ServerSocket g;
    private C0879di h;
    private Lm i;
    private final M0 j;
    private final FirstExecutionConditionService.FirstExecutionHandler k;
    private final C1416zh l;
    private final C1416zh m;
    private final Fh n;
    private final Pm o;
    private final InterfaceC1132nm<C0879di, List<Integer>> p;
    private final C1392yh q;
    private final Ih r;
    private final String s;

    class a implements ServiceConnection {
        a(Jh jh) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            Jh.this.c();
            try {
                Jh.this.e.unbindService(Jh.this.a);
            } catch (Throwable unused) {
                Jh.this.j.reportEvent("socket_unbind_has_thrown_exception");
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Jh jh = Jh.this;
            Jh.a(jh, jh.h);
        }
    }

    class d extends HashMap<String, Bh> {

        class a implements Bh {
            a() {
            }

            @Override // com.yandex.metrica.impl.ob.Bh
            public Ah a(Socket socket, Uri uri, Hh hh) {
                Jh jh = Jh.this;
                return new C1201qh(socket, uri, jh, jh.h, Jh.this.q.a(), hh);
            }
        }

        class b implements Bh {
            b() {
            }

            @Override // com.yandex.metrica.impl.ob.Bh
            public Ah a(Socket socket, Uri uri, Hh hh) {
                Jh jh = Jh.this;
                return new Dh(socket, uri, jh, jh.h, hh);
            }
        }

        d() {
            put("p", new a());
            put("i", new b());
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Jh.f(Jh.this);
        }
    }

    private enum f {
        OK,
        SHOULD_RETRY,
        ORDINARY_FAIL
    }

    Jh(Context context, C1178pi c1178pi, Fh fh, InterfaceC1132nm<C0879di, List<Integer>> interfaceC1132nm, C1344wh c1344wh, C1344wh c1344wh2, String str) {
        this(context, c1178pi, UtilityServiceLocator.getInstance().getFirstExecutionService(), F0.g().q(), C1152oh.a(), new C1416zh("open", c1344wh), new C1416zh("port_already_in_use", c1344wh2), new C1392yh(context, c1178pi), new Ih(), fh, interfaceC1132nm, str);
    }

    static void f(Jh jh) {
        jh.getClass();
        Intent intent = new Intent(jh.e, (Class<?>) MetricaService.class);
        intent.setAction("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER");
        try {
            if (!jh.e.bindService(intent, jh.a, 1)) {
                jh.j.reportEvent("socket_bind_has_failed");
            }
        } catch (Throwable unused) {
            jh.j.reportEvent("socket_bind_has_thrown_exception");
        }
        Lm lmB = jh.o.b(jh);
        jh.i = lmB;
        lmB.start();
        jh.r.d();
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        Socket socketAccept;
        ServerSocket serverSocket;
        synchronized (this) {
            try {
                C0879di c0879di = this.h;
                if (c0879di != null && a(c0879di) == f.SHOULD_RETRY) {
                    this.f = false;
                    long j = this.h.j;
                    ICommonExecutor iCommonExecutorA = this.o.a();
                    iCommonExecutorA.remove(this.c);
                    iCommonExecutorA.executeDelayed(this.c, j, TimeUnit.SECONDS);
                    return;
                }
                if (A2.a(26)) {
                    TrafficStats.setThreadStatsTag(40230);
                }
                if (this.g != null) {
                    while (this.f) {
                        synchronized (this) {
                            try {
                                socketAccept = null;
                                serverSocket = this.f ? this.g : null;
                            } finally {
                            }
                        }
                        if (serverSocket != null) {
                            try {
                                socketAccept = serverSocket.accept();
                                Hh hh = new Hh(new SystemTimeProvider(), new C0958gm());
                                if (A2.a(26)) {
                                    TrafficStats.tagSocket(socketAccept);
                                }
                                new Ch(socketAccept, this, this.d, hh).a();
                            } catch (Throwable unused) {
                                if (socketAccept != null) {
                                }
                            }
                            if (socketAccept != null) {
                                try {
                                    socketAccept.close();
                                } catch (IOException unused2) {
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    private synchronized void c(C0879di c0879di) {
        if (!this.f && this.k.tryExecute(c0879di.f)) {
            this.f = true;
        }
    }

    public void a() {
        this.b.removeMessages(100);
        this.r.e();
    }

    public synchronized void b() {
        if (this.f) {
            a();
            Handler handler = this.b;
            handler.sendMessageDelayed(handler.obtainMessage(100), TimeUnit.SECONDS.toMillis(this.h.a));
            this.r.c();
        }
    }

    public synchronized void a(C1178pi c1178pi) {
        try {
            C0879di c0879diM = c1178pi.M();
            synchronized (this) {
                if (c0879diM != null) {
                    c(c0879diM);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    Jh(Context context, C1178pi c1178pi, FirstExecutionConditionService firstExecutionConditionService, Pm pm, M0 m0, C1416zh c1416zh, C1416zh c1416zh2, C1392yh c1392yh, Ih ih, Fh fh, InterfaceC1132nm<C0879di, List<Integer>> interfaceC1132nm, String str) {
        this.a = new a(this);
        this.b = new b(Looper.getMainLooper());
        this.c = new c();
        this.d = new d();
        this.e = context;
        this.j = m0;
        this.l = c1416zh;
        this.m = c1416zh2;
        this.n = fh;
        this.p = interfaceC1132nm;
        this.o = pm;
        this.q = c1392yh;
        this.r = ih;
        String str2 = String.format("[YandexUID%sServer]", str);
        this.s = str2;
        this.k = firstExecutionConditionService.createFirstExecutionHandler(new e(), pm.a(), str2);
        b(c1178pi.M());
        C0879di c0879di = this.h;
        if (c0879di != null) {
            c(c0879di);
        }
    }

    static void a(Jh jh, C0879di c0879di) {
        synchronized (jh) {
            if (c0879di != null) {
                jh.c(c0879di);
            }
        }
    }

    synchronized void c() {
        try {
            this.f = false;
            Lm lm = this.i;
            if (lm != null) {
                lm.stopRunning();
                this.i = null;
            }
            ServerSocket serverSocket = this.g;
            if (serverSocket != null) {
                serverSocket.close();
                this.g = null;
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized f a(C0879di c0879di) {
        f fVar;
        Integer next;
        Throwable th;
        Fh.a e2;
        try {
            Iterator<Integer> it = this.p.a(c0879di).iterator();
            fVar = f.ORDINARY_FAIL;
            Integer num = null;
            while (this.g == null && it.hasNext()) {
                try {
                    next = it.next();
                    if (next != null) {
                        try {
                            this.g = this.n.a(next.intValue());
                            fVar = f.OK;
                            this.l.a(this, next.intValue(), c0879di);
                        } catch (Fh.a e3) {
                            e2 = e3;
                            String message = e2.getMessage();
                            Throwable cause = e2.getCause();
                            if (cause != null && message != null) {
                                Map<String, Object> mapA = a(next);
                                ((HashMap) mapA).put("exception", Log.getStackTraceString(cause));
                                this.j.reportEvent(b(message), mapA);
                            }
                            num = next;
                        } catch (BindException unused) {
                            num = next;
                            fVar = f.SHOULD_RETRY;
                            this.m.a(this, num.intValue(), c0879di);
                        } catch (Throwable th2) {
                            th = th2;
                            Map<String, Object> mapA2 = a(next);
                            ((HashMap) mapA2).put("exception", Log.getStackTraceString(th));
                            this.j.reportEvent(b("open_error"), mapA2);
                            num = next;
                        }
                    }
                } catch (Fh.a e4) {
                    next = num;
                    e2 = e4;
                } catch (BindException unused2) {
                } catch (Throwable th3) {
                    next = num;
                    th = th3;
                }
                num = next;
            }
        } catch (Throwable th4) {
            throw th4;
        }
        return fVar;
    }

    private void b(C0879di c0879di) {
        this.h = c0879di;
        if (c0879di != null) {
            this.k.setDelaySeconds(c0879di.e);
        }
    }

    public void b(int i, Hh hh) {
        this.j.reportEvent(b("sync_succeed"), a(i, hh));
    }

    public synchronized void b(C1178pi c1178pi) {
        try {
            this.q.a(c1178pi);
            C0879di c0879diM = c1178pi.M();
            if (c0879diM != null) {
                this.h = c0879diM;
                this.k.setDelaySeconds(c0879diM.e);
                c(c0879diM);
            } else {
                c();
                b((C0879di) null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private String b(String str) {
        return "socket_" + str;
    }

    private Map<String, Object> a(Integer num) {
        HashMap map = new HashMap();
        map.put("port", num == null ? "" : String.valueOf(num));
        return map;
    }

    private Map<String, Object> a(int i, Hh hh) {
        Map<String, Object> mapA = a(Integer.valueOf(i));
        HashMap map = (HashMap) mapA;
        map.put("idle_interval", Double.valueOf(this.r.b()));
        map.put("background_interval", Double.valueOf(this.r.a()));
        map.put("request_read_time", Long.valueOf(hh.d()));
        map.put("response_form_time", Long.valueOf(hh.e()));
        map.put("response_send_time", Long.valueOf(hh.f()));
        return mapA;
    }

    public void a(String str, String str2) {
        HashMap map = new HashMap();
        map.put("uri", str2);
        this.j.reportEvent("socket_" + str, map);
    }

    public void a(String str) {
        this.j.reportEvent(b(str));
    }

    public void a(String str, Throwable th) {
        this.j.reportError(b(str), th);
    }

    public void a(String str, Integer num) {
        this.j.reportEvent(b(str), a(num));
    }

    public void a(Map<String, Object> map, int i, Hh hh) {
        Map<String, Object> mapA = a(i, hh);
        ((HashMap) mapA).put("params", map);
        this.j.reportEvent(b("reversed_sync_succeed"), mapA);
    }
}
