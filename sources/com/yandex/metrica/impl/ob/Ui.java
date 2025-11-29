package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Sh;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ui {
    private C1348wl A;
    private C0982hl B;
    private C0982hl C;
    private C0982hl D;
    private C0985i E;
    private boolean F;
    private C1297ui G;
    private Ph H;
    private C1217ra I;
    private List<String> J;
    private Oh K;
    private C1327w0 L;
    private Uh M;
    private C1249si N;
    private Map<String, Object> O;
    private a a;
    private List<String> c;
    private List<String> e;
    private List<String> g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private List<C1147oc> o;
    private Long p;
    private List<C0829bi> q;
    private String r;
    private List<String> s;
    private List<String> t;
    private Map<String, List<String>> u;
    private C1273ti v;
    private C0854ci w;
    private RetryPolicyConfig x;
    private Zh z;
    private Sh b = new Sh.a().a();
    private String d = "";
    private String f = "";
    private C0879di m = null;
    private C0804ai n = null;
    private List<Bd> y = new ArrayList();

    public enum a {
        BAD,
        OK
    }

    public a A() {
        return this.a;
    }

    public RetryPolicyConfig B() {
        return this.x;
    }

    public C0854ci C() {
        return this.w;
    }

    public String D() {
        return this.h;
    }

    public C0879di E() {
        return this.m;
    }

    public C1249si F() {
        return this.N;
    }

    public List<String> G() {
        return this.c;
    }

    public C1273ti H() {
        return this.v;
    }

    public C1297ui I() {
        return this.G;
    }

    public C0982hl J() {
        return this.D;
    }

    public C0982hl K() {
        return this.B;
    }

    public C1348wl L() {
        return this.A;
    }

    public C0982hl M() {
        return this.C;
    }

    public Long N() {
        return this.p;
    }

    public boolean O() {
        return this.F;
    }

    void a(Sh sh) {
        this.b = sh;
    }

    void b(String str) {
        this.r = str;
    }

    void c(List<String> list) {
        this.g = list;
    }

    public String d() {
        return this.i;
    }

    public Sh e() {
        return this.b;
    }

    void f(String str) {
        this.d = str;
    }

    void g(String str) {
        this.f = str;
    }

    void h(List<String> list) {
        this.c = list;
    }

    public String i() {
        return this.j;
    }

    public List<String> j() {
        return this.s;
    }

    public C1217ra k() {
        return this.I;
    }

    public C1327w0 l() {
        return this.L;
    }

    public Uh m() {
        return this.M;
    }

    public String n() {
        return this.l;
    }

    public String o() {
        return this.d;
    }

    public Zh p() {
        return this.z;
    }

    public List<C1147oc> q() {
        return this.o;
    }

    public List<String> r() {
        return this.g;
    }

    public List<String> s() {
        return this.J;
    }

    public List<String> t() {
        return this.t;
    }

    public Map<String, Object> u() {
        return this.O;
    }

    public List<Bd> v() {
        return this.y;
    }

    public C0804ai w() {
        return this.n;
    }

    public String x() {
        return this.f;
    }

    public List<String> y() {
        return this.e;
    }

    public List<C0829bi> z() {
        return this.q;
    }

    void a(String str, boolean z) {
        this.y.add(new Bd(str, z));
    }

    void b(List<C1147oc> list) {
        this.o = list;
    }

    void c(String str) {
        this.k = str;
    }

    void d(String str) {
        this.j = str;
    }

    void e(String str) {
        this.l = str;
    }

    void f(List<String> list) {
        this.e = list;
    }

    void g(List<C0829bi> list) {
        this.q = list;
    }

    void h(String str) {
        this.h = str;
    }

    void a(String str) {
        this.i = str;
    }

    public void b(C0982hl c0982hl) {
        this.B = c0982hl;
    }

    public void c(C0982hl c0982hl) {
        this.C = c0982hl;
    }

    public void d(List<String> list) {
        this.J = list;
    }

    void e(List<String> list) {
        this.t = list;
    }

    public String f() {
        return this.r;
    }

    public Map<String, List<String>> g() {
        return this.u;
    }

    public String h() {
        return this.k;
    }

    void a(a aVar) {
        this.a = aVar;
    }

    public C0985i b() {
        return this.E;
    }

    public Ph c() {
        return this.H;
    }

    void a(C0879di c0879di) {
        this.m = c0879di;
    }

    public void b(Map<String, Object> map) {
        this.O = map;
    }

    void a(C0804ai c0804ai) {
        this.n = c0804ai;
    }

    void a(Long l) {
        this.p = l;
    }

    void a(List<String> list) {
        this.s = list;
    }

    void a(Map<String, List<String>> map) {
        this.u = map;
    }

    void a(C1273ti c1273ti) {
        this.v = c1273ti;
    }

    void a(C0854ci c0854ci) {
        this.w = c0854ci;
    }

    void a(Zh zh) {
        this.z = zh;
    }

    void a(RetryPolicyConfig retryPolicyConfig) {
        this.x = retryPolicyConfig;
    }

    public void a(C1348wl c1348wl) {
        this.A = c1348wl;
    }

    public void a(C0982hl c0982hl) {
        this.D = c0982hl;
    }

    public void a(C0985i c0985i) {
        this.E = c0985i;
    }

    public void a(boolean z) {
        this.F = z;
    }

    public void a(C1297ui c1297ui) {
        this.G = c1297ui;
    }

    public void a(Ph ph) {
        this.H = ph;
    }

    public void a(C1217ra c1217ra) {
        this.I = c1217ra;
    }

    public Oh a() {
        return this.K;
    }

    public void a(Oh oh) {
        this.K = oh;
    }

    public void a(C1327w0 c1327w0) {
        this.L = c1327w0;
    }

    public void a(Uh uh) {
        this.M = uh;
    }

    public void a(C1249si c1249si) {
        this.N = c1249si;
    }
}
