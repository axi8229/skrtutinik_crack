package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a*\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000e\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0014\u0010\u0013\u001a)\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\r*\u00020\f2\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001b\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\t2\u0006\u0010\u0002\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001c\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001d\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001f\u0010\u0013\u001a'\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b \u0010\u001a\u001a\u0019\u0010 \u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b \u0010\u001d\u001a\u001f\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b!\u0010\u0013\u001a\u0011\u0010!\u001a\u00020#*\u00020\"¢\u0006\u0004\b!\u0010$\u001a!\u0010%\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b%\u0010\u0013\u001a-\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\b(\u0010)\u001a+\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\b\b\u0000\u0010\u0000*\u00020**\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b+\u0010,\u001a?\u00100\u001a\u00028\u0000\"\u0010\b\u0000\u0010.*\n\u0012\u0006\b\u0000\u0012\u00028\u00010-\"\b\b\u0001\u0010\u0000*\u00020**\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u0010/\u001a\u00028\u0000¢\u0006\u0004\b0\u00101\u001a-\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\b2\u0010)\u001a\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020#0'*\u00020\"¢\u0006\u0004\b3\u00104\u001aC\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00107\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`6¢\u0006\u0004\b8\u00109\u001aA\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00107\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`6¢\u0006\u0004\b:\u0010;\u001a9\u0010<\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010.*\n\u0012\u0006\b\u0000\u0012\u00028\u00000-*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010/\u001a\u00028\u0001¢\u0006\u0004\b<\u00101\u001a+\u0010<\u001a\u00028\u0000\"\u0010\b\u0000\u0010.*\n\u0012\u0006\b\u0000\u0012\u00020\r0-*\u00020\f2\u0006\u0010/\u001a\u00028\u0000¢\u0006\u0004\b<\u0010=\u001a%\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b>\u0010,\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070'*\u00020\u0006¢\u0006\u0004\b>\u0010?\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0'*\u00020\t¢\u0006\u0004\b>\u0010@\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0'*\u00020\f¢\u0006\u0004\b>\u0010A\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100'*\u00020\u000f¢\u0006\u0004\b>\u0010B\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020D0'*\u00020C¢\u0006\u0004\b>\u0010E\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020G0'*\u00020F¢\u0006\u0004\b>\u0010H\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030'*\u00020I¢\u0006\u0004\b>\u0010J\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020#0'*\u00020\"¢\u0006\u0004\b>\u00104\u001a%\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000K\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bL\u0010,\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070K*\u00020\u0006¢\u0006\u0004\bL\u0010?\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0K*\u00020\t¢\u0006\u0004\bL\u0010@\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0K*\u00020\f¢\u0006\u0004\bL\u0010A\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00100K*\u00020\u000f¢\u0006\u0004\bL\u0010B\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020D0K*\u00020C¢\u0006\u0004\bL\u0010E\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020G0K*\u00020F¢\u0006\u0004\bL\u0010H\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030K*\u00020I¢\u0006\u0004\bL\u0010J\u001a\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020#0K*\u00020\"¢\u0006\u0004\bL\u00104\u001a%\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bN\u0010O\u001aE\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010'\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010P*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0086\bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a+\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000V0U\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bW\u0010X\u001a\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\r0'*\u00020\f¢\u0006\u0004\bY\u0010A\u001a\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0Z*\u00020\f¢\u0006\u0004\b[\u0010\\\u001a\u0015\u0010]\u001a\u0004\u0018\u00010\r*\u00020\fH\u0007¢\u0006\u0004\b]\u0010^\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\r*\u00020\fH\u0007¢\u0006\u0004\b_\u0010^\u001aJ\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010a0'\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010P*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\bb\u0010c\u001a<\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000a0'\"\u0004\b\u0000\u0010P*\u00020\f2\u000e\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bb\u0010d\u001aH\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010a0'\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010P*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00010UH\u0086\u0004¢\u0006\u0004\bb\u0010e\u001a\u007f\u0010p\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010h*\u00060fj\u0002`g*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010i\u001a\u00028\u00012\b\b\u0002\u0010k\u001a\u00020j2\b\b\u0002\u0010l\u001a\u00020j2\b\b\u0002\u0010m\u001a\u00020j2\b\b\u0002\u0010n\u001a\u00020\r2\b\b\u0002\u0010o\u001a\u00020j2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020j\u0018\u00010Q¢\u0006\u0004\bp\u0010q\u001aq\u0010p\u001a\u00028\u0000\"\f\b\u0000\u0010h*\u00060fj\u0002`g*\u00020\u00062\u0006\u0010i\u001a\u00028\u00002\b\b\u0002\u0010k\u001a\u00020j2\b\b\u0002\u0010l\u001a\u00020j2\b\b\u0002\u0010m\u001a\u00020j2\b\b\u0002\u0010n\u001a\u00020\r2\b\b\u0002\u0010o\u001a\u00020j2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020j\u0018\u00010Q¢\u0006\u0004\bp\u0010r\u001ai\u0010t\u001a\u00020s\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010k\u001a\u00020j2\b\b\u0002\u0010l\u001a\u00020j2\b\b\u0002\u0010m\u001a\u00020j2\b\b\u0002\u0010n\u001a\u00020\r2\b\b\u0002\u0010o\u001a\u00020j2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020j\u0018\u00010Q¢\u0006\u0004\bt\u0010u\u001a[\u0010t\u001a\u00020s*\u00020\u00062\b\b\u0002\u0010k\u001a\u00020j2\b\b\u0002\u0010l\u001a\u00020j2\b\b\u0002\u0010m\u001a\u00020j2\b\b\u0002\u0010n\u001a\u00020\r2\b\b\u0002\u0010o\u001a\u00020j2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020j\u0018\u00010Q¢\u0006\u0004\bt\u0010v\u001a%\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000U\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bw\u0010X\u001a%\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000x\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\by\u0010z\"#\u0010~\u001a\u00020{\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\u0006\u001a\u0004\b|\u0010}\"\u0015\u0010~\u001a\u00020{*\u00020\f8F¢\u0006\u0006\u001a\u0004\b|\u0010\u007f\"&\u0010\u0082\u0001\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0018\u0010\u0082\u0001\u001a\u00020\r*\u00020\f8F¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0083\u0001\"\u0018\u0010\u0082\u0001\u001a\u00020\r*\u00020\u000f8F¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0084\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0085\u0001"}, d2 = {"T", "", "element", "", "contains", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "", "", "([BB)Z", "", "", "([SS)Z", "", "", "([II)Z", "", "", "([JJ)Z", "first", "([Ljava/lang/Object;)Ljava/lang/Object;", "firstOrNull", "index", "getOrNull", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([II)Ljava/lang/Integer;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "([BB)I", "([SS)I", "([II)I", "([JJ)I", "last", "lastIndexOf", "single", "", "", "([C)C", "singleOrNull", "n", "", "drop", "([Ljava/lang/Object;I)Ljava/util/List;", "", "filterNotNull", "([Ljava/lang/Object;)Ljava/util/List;", "", "C", "destination", "filterNotNullTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "takeLast", "sorted", "([C)Ljava/util/List;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "toCollection", "([ILjava/util/Collection;)Ljava/util/Collection;", "toList", "([B)Ljava/util/List;", "([S)Ljava/util/List;", "([I)Ljava/util/List;", "([J)Ljava/util/List;", "", "", "([F)Ljava/util/List;", "", "", "([D)Ljava/util/List;", "", "([Z)Ljava/util/List;", "", "toMutableList", "", "toSet", "([Ljava/lang/Object;)Ljava/util/Set;", "R", "Lkotlin/Function1;", "transform", "map", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "Lkotlin/collections/IndexedValue;", "withIndex", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "distinct", "", "toMutableSet", "([I)Ljava/util/Set;", "maxOrNull", "([I)Ljava/lang/Integer;", "minOrNull", "other", "Lkotlin/Pair;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "([I[Ljava/lang/Object;)Ljava/util/List;", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "joinTo", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "", "joinToString", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "([BLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "asIterable", "Lkotlin/sequences/Sequence;", "asSequence", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "getIndices", "([Ljava/lang/Object;)Lkotlin/ranges/IntRange;", "indices", "([I)Lkotlin/ranges/IntRange;", "getLastIndex", "([Ljava/lang/Object;)I", "lastIndex", "([I)I", "([J)I", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes3.dex */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static <T> boolean contains(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt.indexOf(tArr, t) >= 0;
    }

    public static boolean contains(byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return indexOf(bArr, b) >= 0;
    }

    public static boolean contains(short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return indexOf(sArr, s) >= 0;
    }

    public static boolean contains(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return indexOf(iArr, i) >= 0;
    }

    public static boolean contains(long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return indexOf(jArr, j) >= 0;
    }

    public static <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static <T> T getOrNull(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0 || i > ArraysKt.getLastIndex(tArr)) {
            return null;
        }
        return tArr[i];
    }

    public static Integer getOrNull(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i < 0 || i > ArraysKt.getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static <T> int indexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (Intrinsics.areEqual(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int indexOf(byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOf(long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[ArraysKt.getLastIndex(tArr)];
    }

    public static <T> int lastIndexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (t == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (Intrinsics.areEqual(t, tArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    public static final int lastIndexOf(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static <T> T single(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T singleOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> drop(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return takeLast(tArr, RangesKt.coerceAtLeast(tArr.length - i, 0));
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int length = tArr.length;
        if (i >= length) {
            return ArraysKt.toList(tArr);
        }
        if (i == 1) {
            return CollectionsKt.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(tArr[i2]);
        }
        return arrayList;
    }

    public static List<Character> sorted(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt.sort(typedArray);
        return ArraysKt.asList(typedArray);
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static <T> IntRange getIndices(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, ArraysKt.getLastIndex(tArr));
    }

    public static IntRange getIndices(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntRange(0, ArraysKt.getLastIndex(iArr));
    }

    public static <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    public static int getLastIndex(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int getLastIndex(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            destination.add(t);
        }
        return destination;
    }

    public static final <C extends Collection<? super Integer>> C toCollection(int[] iArr, C destination) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (int i : iArr) {
            destination.add(Integer.valueOf(i));
        }
        return destination;
    }

    public static <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(tArr[0]);
        }
        return ArraysKt.toMutableList(tArr);
    }

    public static List<Byte> toList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Byte.valueOf(bArr[0]));
        }
        return toMutableList(bArr);
    }

    public static List<Short> toList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Short.valueOf(sArr[0]));
        }
        return toMutableList(sArr);
    }

    public static List<Integer> toList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Integer.valueOf(iArr[0]));
        }
        return ArraysKt.toMutableList(iArr);
    }

    public static List<Long> toList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Long.valueOf(jArr[0]));
        }
        return toMutableList(jArr);
    }

    public static List<Float> toList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Float.valueOf(fArr[0]));
        }
        return toMutableList(fArr);
    }

    public static List<Double> toList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Double.valueOf(dArr[0]));
        }
        return toMutableList(dArr);
    }

    public static List<Boolean> toList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Boolean.valueOf(zArr[0]));
        }
        return toMutableList(zArr);
    }

    public static List<Character> toList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt.listOf(Character.valueOf(cArr[0]));
        }
        return toMutableList(cArr);
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static final List<Short> toMutableList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    public static List<Integer> toMutableList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static final List<Long> toMutableList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static final List<Float> toMutableList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static <T> Set<T> toSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return SetsKt.emptySet();
        }
        if (length == 1) {
            return SetsKt.setOf(tArr[0]);
        }
        return (Set) toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    public static <T, R> List<R> map(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(transform.invoke(t));
        }
        return arrayList;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IndexingIterable(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.ArraysKt___ArraysKt.withIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<T> invoke() {
                return ArrayIteratorKt.iterator(tArr);
            }
        });
    }

    public static List<Integer> distinct(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return CollectionsKt.toList(toMutableSet(iArr));
    }

    public static final Set<Integer> toMutableSet(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (Set) toCollection(iArr, new LinkedHashSet(MapsKt.mapCapacity(iArr.length)));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static Integer maxOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i < i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static Integer minOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i > i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, R[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(tArr[i], other[i]));
        }
        return arrayList;
    }

    public static <R> List<Pair<Integer, R>> zip(int[] iArr, R[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            int i2 = iArr[i];
            arrayList.add(TuplesKt.to(Integer.valueOf(i2), other[i]));
        }
        return arrayList;
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(tArr[i], r));
            i++;
        }
        return arrayList;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : tArr) {
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

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b)));
            } else {
                buffer.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String string = ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String string = ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> asSequence(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? SequencesKt.emptySequence() : new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }
}
