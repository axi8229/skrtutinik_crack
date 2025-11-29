package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0006\b\u0000\u0010\u0012\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086\b¢\u0006\u0004\b\u0018\u0010\u001f\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020 H\u0086\b¢\u0006\u0004\b\u0018\u0010!\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0086\b¢\u0006\u0004\b\u0018\u0010$\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020%H\u0086\b¢\u0006\u0004\b\u0018\u0010&\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020'H\u0086\b¢\u0006\u0004\b\u0018\u0010(\u001a$\u0010\u0018\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020)H\u0086\b¢\u0006\u0004\b\u0018\u0010*\u001a$\u0010-\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0086\b¢\u0006\u0004\b-\u0010.\u001a$\u00101\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u00100\u001a\u00020/H\u0086\b¢\u0006\u0004\b1\u00102\u001a$\u00104\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u0002032\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b4\u00105\u001a*\u00107\u001a\b\u0012\u0004\u0012\u00028\u000006\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u0002032\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b7\u00108\u001a&\u0010-\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u0002032\u0006\u0010,\u001a\u00020+H\u0086\b¢\u0006\u0004\b-\u00109\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020;H\u0086\u0002¢\u0006\u0004\b=\u0010>\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020?H\u0086\u0002¢\u0006\u0004\b=\u0010@\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020AH\u0086\u0002¢\u0006\u0004\b=\u0010B\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020CH\u0086\u0002¢\u0006\u0004\b=\u0010D\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020EH\u0086\u0002¢\u0006\u0004\b=\u0010F\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020GH\u0086\u0002¢\u0006\u0004\b=\u0010H\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020IH\u0086\u0002¢\u0006\u0004\b=\u0010J\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020KH\u0086\u0002¢\u0006\u0004\b=\u0010L\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020\"H\u0086\u0002¢\u0006\u0004\b=\u0010M\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020)H\u0086\u0002¢\u0006\u0004\b=\u0010N\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020OH\u0086\u0002¢\u0006\u0004\b=\u0010P\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020:2\u0006\u0010Q\u001a\u00020:H\u0086\u0002¢\u0006\u0004\b=\u0010R\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020;H\u0086\u0002¢\u0006\u0004\bS\u0010>\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020?H\u0086\u0002¢\u0006\u0004\bS\u0010@\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020AH\u0086\u0002¢\u0006\u0004\bS\u0010B\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020CH\u0086\u0002¢\u0006\u0004\bS\u0010D\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020EH\u0086\u0002¢\u0006\u0004\bS\u0010F\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020GH\u0086\u0002¢\u0006\u0004\bS\u0010H\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020IH\u0086\u0002¢\u0006\u0004\bS\u0010J\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020KH\u0086\u0002¢\u0006\u0004\bS\u0010L\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020\"H\u0086\u0002¢\u0006\u0004\bS\u0010M\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020)H\u0086\u0002¢\u0006\u0004\bS\u0010N\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010<\u001a\u00020OH\u0086\u0002¢\u0006\u0004\bS\u0010P\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020:2\u0006\u0010Q\u001a\u00020:H\u0086\u0002¢\u0006\u0004\bS\u0010R\u001a\u001c\u0010U\u001a\u00020\u0002*\u00020:2\u0006\u0010T\u001a\u00020AH\u0086\u0002¢\u0006\u0004\bU\u0010B\u001a\u001c\u0010V\u001a\u00020\u0002*\u00020:2\u0006\u0010T\u001a\u00020AH\u0086\u0002¢\u0006\u0004\bV\u0010B\u001a\u001c\u0010U\u001a\u00020\u0002*\u00020W2\u0006\u0010X\u001a\u00020\"H\u0086\u0002¢\u0006\u0004\bU\u0010Y\u001a\"\u0010U\u001a\u00020\u0002*\u00020W2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\"0ZH\u0086\u0002¢\u0006\u0004\bU\u0010\\\u001a\u001c\u0010V\u001a\u00020\u0002*\u00020W2\u0006\u0010X\u001a\u00020\"H\u0086\u0002¢\u0006\u0004\bV\u0010Y\u001a\"\u0010V\u001a\u00020\u0002*\u00020W2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\"0ZH\u0086\u0002¢\u0006\u0004\bV\u0010\\\u001a\u001c\u0010]\u001a\u00020;*\u00020O2\u0006\u0010X\u001a\u00020\"H\u0086\u0002¢\u0006\u0004\b]\u0010^\u001a\u001c\u0010]\u001a\u00020;*\u00020O2\u0006\u0010T\u001a\u00020AH\u0086\u0002¢\u0006\u0004\b]\u0010_\u001a-\u0010d\u001a\n c*\u0004\u0018\u00010`0`*\u00020`2\b\u0010a\u001a\u0004\u0018\u00010/2\u0006\u0010b\u001a\u00020\"H\u0000¢\u0006\u0004\bd\u0010e\u001a-\u0010d\u001a\n c*\u0004\u0018\u00010`0`*\u00020`2\b\u0010a\u001a\u0004\u0018\u00010/2\u0006\u0010T\u001a\u00020AH\u0000¢\u0006\u0004\bd\u0010f\u001a<\u0010l\u001a\u00020g\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020/*\u00020g2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000h2\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000jH\u0086\b¢\u0006\u0004\bl\u0010m\u001a<\u0010p\u001a\u00020g\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020/*\u00020g2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000h2\f\u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0086\b¢\u0006\u0004\bp\u0010q\u001a\u0013\u0010s\u001a\u00020r*\u00020AH\u0000¢\u0006\u0004\bs\u0010t\u001a\u0017\u0010v\u001a\u00020;*\u0006\u0012\u0002\b\u00030uH\u0000¢\u0006\u0004\bv\u0010w¨\u0006x"}, d2 = {"Lkotlin/Function1;", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "", "initializer", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "kotlinModule", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "jsonMapper", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/databind/json/JsonMapper;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "jacksonObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "jacksonMapperBuilder", "()Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;", "registerKotlinModule", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)Lcom/fasterxml/jackson/databind/ObjectMapper;", "T", "Lcom/fasterxml/jackson/core/type/TypeReference;", "jacksonTypeRef", "()Lcom/fasterxml/jackson/core/type/TypeReference;", "Lcom/fasterxml/jackson/core/JsonParser;", "jp", "readValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/MappingIterator;", "readValues", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/databind/MappingIterator;", "Ljava/io/File;", "src", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/File;)Ljava/lang/Object;", "Ljava/net/URL;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/net/URL;)Ljava/lang/Object;", "", "content", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/String;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/Reader;)Ljava/lang/Object;", "Ljava/io/InputStream;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/InputStream;)Ljava/lang/Object;", "", "(Lcom/fasterxml/jackson/databind/ObjectMapper;[B)Ljava/lang/Object;", "Lcom/fasterxml/jackson/core/TreeNode;", "n", "treeToValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "", RemoteMessageConst.FROM, "convertValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/ObjectReader;", "readValueTyped", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "", "readValuesTyped", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/Iterator;", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/node/ArrayNode;", "", "element", "plus", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Z)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;S)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;I)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;J)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;F)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;D)V", "Ljava/math/BigDecimal;", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/math/BigDecimal;)V", "Ljava/math/BigInteger;", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/math/BigInteger;)V", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/lang/String;)V", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;[B)V", "Lcom/fasterxml/jackson/databind/JsonNode;", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Lcom/fasterxml/jackson/databind/JsonNode;)V", "elements", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Lcom/fasterxml/jackson/databind/node/ArrayNode;)V", "plusAssign", "index", "minus", "minusAssign", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "field", "(Lcom/fasterxml/jackson/databind/node/ObjectNode;Ljava/lang/String;)V", "", "fields", "(Lcom/fasterxml/jackson/databind/node/ObjectNode;Ljava/util/Collection;)V", "contains", "(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Z", "(Lcom/fasterxml/jackson/databind/JsonNode;I)Z", "Lcom/fasterxml/jackson/databind/JsonMappingException;", "refFrom", "refFieldName", "kotlin.jvm.PlatformType", "wrapWithPath", "(Lcom/fasterxml/jackson/databind/JsonMappingException;Ljava/lang/Object;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;", "(Lcom/fasterxml/jackson/databind/JsonMappingException;Ljava/lang/Object;I)Lcom/fasterxml/jackson/databind/JsonMappingException;", "Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lkotlin/reflect/KClass;", "kClass", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "serializer", "addSerializer", "(Lcom/fasterxml/jackson/databind/module/SimpleModule;Lkotlin/reflect/KClass;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "deserializer", "addDeserializer", "(Lcom/fasterxml/jackson/databind/module/SimpleModule;Lkotlin/reflect/KClass;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Ljava/util/BitSet;", "toBitSet", "(I)Ljava/util/BitSet;", "Ljava/lang/Class;", "isUnboxableValueClass", "(Ljava/lang/Class;)Z", "jackson-module-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ExtensionsKt {
    public static /* synthetic */ KotlinModule kotlinModule$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<KotlinModule.Builder, Unit>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt.kotlinModule.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KotlinModule.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KotlinModule.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        return kotlinModule(function1);
    }

    public static final KotlinModule kotlinModule(Function1<? super KotlinModule.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        KotlinModule.Builder builder = new KotlinModule.Builder();
        initializer.invoke(builder);
        return builder.build();
    }

    public static /* synthetic */ JsonMapper jsonMapper$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<JsonMapper.Builder, Unit>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt.jsonMapper.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonMapper.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonMapper.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        return jsonMapper(function1);
    }

    public static final JsonMapper jsonMapper(Function1<? super JsonMapper.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        JsonMapper.Builder builder = JsonMapper.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        initializer.invoke(builder);
        JsonMapper jsonMapperBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapperBuild, "builder.build()");
        return jsonMapperBuild;
    }

    public static final ObjectMapper jacksonObjectMapper() {
        return jsonMapper(new Function1<JsonMapper.Builder, Unit>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt.jacksonObjectMapper.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonMapper.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonMapper.Builder jsonMapper) {
                Intrinsics.checkNotNullParameter(jsonMapper, "$this$jsonMapper");
                jsonMapper.addModule(ExtensionsKt.kotlinModule$default(null, 1, null));
            }
        });
    }

    public static final JsonMapper.Builder jacksonMapperBuilder() {
        JsonMapper.Builder builderAddModule = JsonMapper.builder().addModule(kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(builderAddModule, "builder().addModule(kotlinModule())");
        return builderAddModule;
    }

    public static final ObjectMapper registerKotlinModule(ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        ObjectMapper objectMapperRegisterModule = objectMapper.registerModule(kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(objectMapperRegisterModule, "this.registerModule(kotlinModule())");
        return objectMapperRegisterModule;
    }

    public static final /* synthetic */ <T> T convertValue(ObjectMapper objectMapper, Object from) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.needClassReification();
        return (T) objectMapper.convertValue(from, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$convertValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> TypeReference<T> jacksonTypeRef() {
        Intrinsics.needClassReification();
        return new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt.jacksonTypeRef.1
        };
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, JsonParser jp) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(jp, "jp");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(jp, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, File src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$2
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, InputStream src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$6
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, Reader src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$5
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, String content) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(content, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$4
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, URL src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$3
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, byte[] src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$7
        });
    }

    public static final /* synthetic */ <T> T readValueTyped(ObjectReader objectReader, JsonParser jp) {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(jp, "jp");
        Intrinsics.needClassReification();
        return (T) objectReader.readValue(jp, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValueTyped$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> MappingIterator<T> readValues(ObjectMapper objectMapper, JsonParser jp) throws IOException {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(jp, "jp");
        Intrinsics.needClassReification();
        MappingIterator<T> values = objectMapper.readValues(jp, (TypeReference) new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValues$$inlined$jacksonTypeRef$1
        });
        Intrinsics.checkNotNullExpressionValue(values, "readValues(jp, jacksonTypeRef<T>())");
        return values;
    }

    public static final /* synthetic */ <T> Iterator<T> readValuesTyped(ObjectReader objectReader, JsonParser jp) throws IOException {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(jp, "jp");
        Intrinsics.needClassReification();
        Iterator<T> values = objectReader.readValues(jp, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValuesTyped$$inlined$jacksonTypeRef$1
        });
        Intrinsics.checkNotNullExpressionValue(values, "readValues(jp, jacksonTypeRef<T>())");
        return values;
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectMapper objectMapper, TreeNode n) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(n, "n");
        JsonParser jsonParserTreeAsTokens = objectMapper.treeAsTokens(n);
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(jsonParserTreeAsTokens, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$treeToValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectReader objectReader, TreeNode n) {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(n, "n");
        JsonParser jsonParserTreeAsTokens = objectReader.treeAsTokens(n);
        Intrinsics.needClassReification();
        return (T) objectReader.readValue(jsonParserTreeAsTokens, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$treeToValue$$inlined$jacksonTypeRef$2
        });
    }

    public static final void plus(ArrayNode arrayNode, boolean z) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(z);
    }

    public static final void plus(ArrayNode arrayNode, short s) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(s);
    }

    public static final void plus(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(i);
    }

    public static final void plus(ArrayNode arrayNode, long j) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(j);
    }

    public static final void plus(ArrayNode arrayNode, float f) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(f);
    }

    public static final void plus(ArrayNode arrayNode, double d) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(d);
    }

    public static final void plus(ArrayNode arrayNode, BigDecimal element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, BigInteger element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, String element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, byte[] element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, JsonNode element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, ArrayNode elements) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Unit unit = Unit.INSTANCE;
        arrayNode.addAll(elements);
    }

    public static final void plusAssign(ArrayNode arrayNode, boolean z) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(z);
    }

    public static final void plusAssign(ArrayNode arrayNode, short s) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(s);
    }

    public static final void plusAssign(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(i);
    }

    public static final void plusAssign(ArrayNode arrayNode, long j) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(j);
    }

    public static final void plusAssign(ArrayNode arrayNode, float f) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(f);
    }

    public static final void plusAssign(ArrayNode arrayNode, double d) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(d);
    }

    public static final void plusAssign(ArrayNode arrayNode, BigDecimal element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, BigInteger element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, String element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, byte[] element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, JsonNode element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, ArrayNode elements) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Unit unit = Unit.INSTANCE;
        arrayNode.addAll(elements);
    }

    public static final void minus(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.remove(i);
    }

    public static final void minusAssign(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.remove(i);
    }

    public static final void minus(ObjectNode objectNode, String field) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(field);
    }

    public static final void minus(ObjectNode objectNode, Collection<String> fields) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(fields);
    }

    public static final void minusAssign(ObjectNode objectNode, String field) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(field);
    }

    public static final void minusAssign(ObjectNode objectNode, Collection<String> fields) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(fields);
    }

    public static final boolean contains(JsonNode jsonNode, String field) {
        Intrinsics.checkNotNullParameter(jsonNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        return jsonNode.has(field);
    }

    public static final boolean contains(JsonNode jsonNode, int i) {
        Intrinsics.checkNotNullParameter(jsonNode, "<this>");
        return jsonNode.has(i);
    }

    public static final JsonMappingException wrapWithPath(JsonMappingException jsonMappingException, Object obj, String refFieldName) {
        Intrinsics.checkNotNullParameter(jsonMappingException, "<this>");
        Intrinsics.checkNotNullParameter(refFieldName, "refFieldName");
        return JsonMappingException.wrapWithPath(jsonMappingException, obj, refFieldName);
    }

    public static final JsonMappingException wrapWithPath(JsonMappingException jsonMappingException, Object obj, int i) {
        Intrinsics.checkNotNullParameter(jsonMappingException, "<this>");
        return JsonMappingException.wrapWithPath(jsonMappingException, obj, i);
    }

    public static final /* synthetic */ <T> SimpleModule addSerializer(SimpleModule simpleModule, KClass<T> kClass, JsonSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(simpleModule, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        simpleModule.addSerializer(JvmClassMappingKt.getJavaClass(kClass), serializer);
        simpleModule.addSerializer(JvmClassMappingKt.getJavaObjectType(kClass), serializer);
        return simpleModule;
    }

    public static final /* synthetic */ <T> SimpleModule addDeserializer(SimpleModule simpleModule, KClass<T> kClass, JsonDeserializer<T> deserializer) {
        Intrinsics.checkNotNullParameter(simpleModule, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        simpleModule.addDeserializer(JvmClassMappingKt.getJavaClass(kClass), deserializer);
        simpleModule.addDeserializer(JvmClassMappingKt.getJavaObjectType(kClass), deserializer);
        return simpleModule;
    }

    public static final BitSet toBitSet(int i) {
        BitSet bitSet = new BitSet(32);
        int i2 = 0;
        while (i != 0) {
            if (i % 2 != 0) {
                bitSet.set(i2);
            }
            i2++;
            i >>= 1;
        }
        return bitSet;
    }

    public static final boolean isUnboxableValueClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Annotation[] annotations = cls.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        for (Annotation annotation : annotations) {
            if (annotation instanceof JvmInline) {
                return KotlinModuleKt.isKotlinClass(cls);
            }
        }
        return false;
    }
}
