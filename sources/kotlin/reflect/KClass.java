package kotlin.reflect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: KClass.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR$\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00108&X¦\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00108&X¦\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013R$\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00108&X¦\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\f\u0012\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR(\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0015\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0015\u001a\u0004\b*\u0010(¨\u0006,"}, d2 = {"Lkotlin/reflect/KClass;", "", "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "isInstance", "(Ljava/lang/Object;)Z", "", "getSimpleName", "()Ljava/lang/String;", "simpleName", "getQualifiedName", "qualifiedName", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "getMembers$annotations", "()V", "members", "Lkotlin/reflect/KFunction;", "getConstructors", "getConstructors$annotations", "constructors", "getNestedClasses", "getNestedClasses$annotations", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "", "getSealedSubclasses", "()Ljava/util/List;", "getSealedSubclasses$annotations", "sealedSubclasses", "isCompanion", "()Z", "isCompanion$annotations", "isValue", "isValue$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    Collection<KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    Collection<KCallable<?>> getMembers();

    Collection<KClass<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();

    boolean isCompanion();

    boolean isInstance(Object value);

    boolean isValue();
}
