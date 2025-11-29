package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0006\u0010\t\u001a\u001f\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\t\u001a'\u0010\r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0012\u0010\u0007\u001a\u001d\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0012\u0010\t\u001a\u001f\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u001f\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0013\u0010\t\u001a\u001d\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0014\u0010\u0007\u001a\u001d\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0014\u0010\t\u001a\u001f\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u001f\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0015\u0010\t\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018\u001a+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001a\u001a=\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a)\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001f*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b \u0010!\u001a=\u0010%\u001a\u00028\u0000\"\u0010\b\u0000\u0010#*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\"\"\b\b\u0001\u0010\u0000*\u00020\u001f*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&\u001a+\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*\u001a+\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u0018\u001a+\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u001a\u001a#\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b-\u0010!\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000.*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b/\u0010!\u001a?\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000000j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`1¢\u0006\u0004\b3\u00104\u001a\u0017\u00107\u001a\u000206*\b\u0012\u0004\u0012\u00020\u000305¢\u0006\u0004\b7\u00108\u001a\u0017\u0010;\u001a\u00020:*\b\u0012\u0004\u0012\u00020905¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010>\u001a\u00020=*\b\u0012\u0004\u0012\u00020\u000b05¢\u0006\u0004\b>\u0010?\u001a\u0017\u0010B\u001a\u00020A*\b\u0012\u0004\u0012\u00020@05¢\u0006\u0004\bB\u0010C\u001a7\u0010D\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010#*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\"*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0004\bD\u0010&\u001a-\u0010G\u001a\u0012\u0012\u0004\u0012\u00028\u00000Ej\b\u0012\u0004\u0012\u00028\u0000`F\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bG\u0010H\u001a#\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bI\u0010!\u001a#\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000J\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bK\u0010!\u001a#\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000J\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000005¢\u0006\u0004\bK\u0010L\u001a#\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bN\u0010O\u001aC\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010P*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\bR\u0010\u001e\u001a)\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bT\u0010U\u001a#\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bV\u0010!\u001a4\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bX\u0010Y\u001a#\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000Z\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b[\u0010O\u001a4\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\b\\\u0010Y\u001a7\u0010]\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a\u001b\u0010_\u001a\u0004\u0018\u000109*\b\u0012\u0004\u0012\u0002090\u0001H\u0007¢\u0006\u0004\b_\u0010`\u001a+\u0010_\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000.*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b_\u0010a\u001a\u001b\u0010b\u001a\u0004\u0018\u000109*\b\u0012\u0004\u0012\u0002090\u0001H\u0007¢\u0006\u0004\bb\u0010`\u001a+\u0010b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000.*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bb\u0010a\u001a.\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bc\u0010d\u001a4\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bc\u0010f\u001a.\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bg\u0010d\u001a.\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000052\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bg\u0010h\u001a4\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bg\u0010f\u001a4\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000052\f\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bg\u0010i\u001aF\u0010k\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010j0\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010P*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\bk\u0010f\u001a}\u0010v\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010n*\u00060lj\u0002`m*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010o\u001a\u00028\u00012\b\b\u0002\u0010q\u001a\u00020p2\b\b\u0002\u0010r\u001a\u00020p2\b\b\u0002\u0010s\u001a\u00020p2\b\b\u0002\u0010t\u001a\u00020\u000b2\b\b\u0002\u0010u\u001a\u00020p2\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020p\u0018\u00010\u001b¢\u0006\u0004\bv\u0010w\u001ag\u0010y\u001a\u00020x\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010q\u001a\u00020p2\b\b\u0002\u0010r\u001a\u00020p2\b\b\u0002\u0010s\u001a\u00020p2\b\b\u0002\u0010t\u001a\u00020\u000b2\b\b\u0002\u0010u\u001a\u00020p2\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020p\u0018\u00010\u001b¢\u0006\u0004\by\u0010z\u001a#\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00000{\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b|\u0010}\u001a\u001a\u0010\u0080\u0001\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0007¢\u0006\u0004\b~\u0010\u007f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0081\u0001"}, d2 = {"T", "", "element", "", "contains", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "", "(Ljava/util/List;)Ljava/lang/Object;", "firstOrNull", "", "index", "getOrNull", "(Ljava/util/List;I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "(Ljava/util/List;Ljava/lang/Object;)I", "last", "lastOrNull", "single", "singleOrNull", "n", "drop", "(Ljava/lang/Iterable;I)Ljava/util/List;", "dropLast", "(Ljava/util/List;I)Ljava/util/List;", "Lkotlin/Function1;", "predicate", "filter", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "filterNotNull", "(Ljava/lang/Iterable;)Ljava/util/List;", "", "C", "destination", "filterNotNullTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "Lkotlin/ranges/IntRange;", "indices", "slice", "(Ljava/util/List;Lkotlin/ranges/IntRange;)Ljava/util/List;", "take", "takeLast", "reversed", "", "sorted", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;", "", "", "toBooleanArray", "(Ljava/util/Collection;)[Z", "", "", "toFloatArray", "(Ljava/util/Collection;)[F", "", "toIntArray", "(Ljava/util/Collection;)[I", "", "", "toLongArray", "(Ljava/util/Collection;)[J", "toCollection", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "(Ljava/lang/Iterable;)Ljava/util/HashSet;", "toList", "", "toMutableList", "(Ljava/util/Collection;)Ljava/util/List;", "", "toSet", "(Ljava/lang/Iterable;)Ljava/util/Set;", "R", "transform", "map", "Lkotlin/collections/IndexedValue;", "withIndex", "(Ljava/lang/Iterable;)Ljava/lang/Iterable;", "distinct", "other", "intersect", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;", "", "toMutableSet", "union", "all", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Z", "maxOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "minOrNull", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/List;", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;Ljava/lang/Iterable;)Ljava/util/List;", "Lkotlin/Pair;", "zip", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "joinTo", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "", "joinToString", "(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;", "sumOfInt", "(Ljava/lang/Iterable;)I", "sum", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> boolean contains(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return CollectionsKt.indexOf(iterable, t) >= 0;
    }

    public static <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return it.next();
    }

    public static <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T getOrNull(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i < 0 || i > CollectionsKt.getLastIndex(list)) {
            return null;
        }
        return list.get(i);
    }

    public static <T> int indexOf(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> int indexOf(List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.indexOf(t);
    }

    public static <T> T last(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(CollectionsKt.getLastIndex(list));
    }

    public static <T> T lastOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> T single(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> T single(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> T singleOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> T singleOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> List<T> drop(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.toList(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i;
            if (size <= 0) {
                return CollectionsKt.emptyList();
            }
            if (size == 1) {
                return CollectionsKt.listOf(CollectionsKt.last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i < size2) {
                        arrayList.add(((List) iterable).get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (T t : iterable) {
            if (i2 >= i) {
                arrayList.add(t);
            } else {
                i2++;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> dropLast(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return CollectionsKt.take(list, RangesKt.coerceAtLeast(list.size() - i, 0));
    }

    public static <T> List<T> filter(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : iterable) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static <T> List<T> slice(List<? extends T> list, IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : CollectionsKt.toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static <T> List<T> take(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return CollectionsKt.toList(iterable);
            }
            if (i == 1) {
                return CollectionsKt.listOf(CollectionsKt.first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<? extends T> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> takeLast(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int size = list.size();
        if (i >= size) {
            return CollectionsKt.toList(list);
        }
        if (i == 1) {
            return CollectionsKt.listOf(CollectionsKt.last((List) list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    public static <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return CollectionsKt.toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            ArraysKt.sort((Comparable[]) array);
            return ArraysKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.sort(mutableList);
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return CollectionsKt.toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.sortWith(array, comparator);
            return ArraysKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.sortWith(mutableList, comparator);
        return mutableList;
    }

    public static boolean[] toBooleanArray(Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = it.next().booleanValue();
            i++;
        }
        return zArr;
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = it.next().floatValue();
            i++;
        }
        return fArr;
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public static long[] toLongArray(Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 12))));
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return CollectionsKt.emptyList();
            }
            if (size != 1) {
                return CollectionsKt.toMutableList(collection);
            }
            return CollectionsKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    public static <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return SetsKt.emptySet();
            }
            if (size != 1) {
                return (Set) toCollection(iterable, new LinkedHashSet(MapsKt.mapCapacity(collection.size())));
            }
            return SetsKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
    }

    public static <T, R> List<R> map(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt.withIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static <T> List<T> distinct(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.toList(CollectionsKt.toMutableSet(iterable));
    }

    public static <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> boolean all(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: maxOrNull, reason: collision with other method in class */
    public static Float m2726maxOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* renamed from: minOrNull, reason: collision with other method in class */
    public static Float m2727minOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean z = false;
        for (T t2 : iterable) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collectionConvertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(elements);
        if (!collectionConvertToListIfNotCollection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (T t : iterable) {
                if (!collectionConvertToListIfNotCollection.contains(t)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return CollectionsKt.toList(iterable);
    }

    public static <T> List<T> plus(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Object) t);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Iterable) elements);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, iterable);
        CollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt.addAll(arrayList2, elements);
        return arrayList2;
    }

    public static <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), CollectionsKt.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.appendElement(buffer, t, function1);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String string = ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static <T> Sequence<T> asSequence(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }
}
