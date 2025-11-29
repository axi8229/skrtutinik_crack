package org.jose4j.json.internal.json_simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;

/* loaded from: classes4.dex */
public class JSONParser {
    private LinkedList handlerStatusStack;
    private Yylex lexer = new Yylex(null);
    private Yytoken token = null;
    private int status = 0;

    private int peekStatus(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        return ((Integer) linkedList.getFirst()).intValue();
    }

    public void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    public void reset(Reader reader) {
        this.lexer.yyreset(reader);
        reset();
    }

    public int getPosition() {
        return this.lexer.getPosition();
    }

    public Object parse(String str, ContainerFactory containerFactory) throws ParseException {
        try {
            return parse(new StringReader(str), containerFactory);
        } catch (IOException e) {
            throw new ParseException(-1, 2, e);
        }
    }

    public Object parse(Reader reader, ContainerFactory containerFactory) throws ParseException, NumberFormatException, IOException {
        reset(reader);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            nextToken();
            int i = this.status;
            if (i == -1) {
                throw new ParseException(getPosition(), 1, this.token);
            }
            if (i == 0) {
                int i2 = this.token.type;
                if (i2 == 0) {
                    this.status = 1;
                    linkedList.addFirst(new Integer(1));
                    linkedList2.addFirst(this.token.value);
                } else if (i2 == 1) {
                    this.status = 2;
                    linkedList.addFirst(new Integer(2));
                    linkedList2.addFirst(createObjectContainer(containerFactory));
                } else if (i2 == 3) {
                    this.status = 3;
                    linkedList.addFirst(new Integer(3));
                    linkedList2.addFirst(createArrayContainer(containerFactory));
                } else {
                    this.status = -1;
                }
            } else {
                if (i == 1) {
                    if (this.token.type == -1) {
                        return linkedList2.removeFirst();
                    }
                    throw new ParseException(getPosition(), 1, this.token);
                }
                if (i == 2) {
                    Yytoken yytoken = this.token;
                    int i3 = yytoken.type;
                    if (i3 == 0) {
                        Object obj = yytoken.value;
                        if (obj instanceof String) {
                            linkedList2.addFirst((String) obj);
                            this.status = 4;
                            linkedList.addFirst(new Integer(4));
                        } else {
                            this.status = -1;
                        }
                    } else if (i3 != 2) {
                        if (i3 != 5) {
                            this.status = -1;
                        }
                    } else if (linkedList2.size() > 1) {
                        linkedList.removeFirst();
                        linkedList2.removeFirst();
                        this.status = peekStatus(linkedList);
                    } else {
                        this.status = 1;
                    }
                } else if (i == 3) {
                    int i4 = this.token.type;
                    if (i4 == 0) {
                        ((List) linkedList2.getFirst()).add(this.token.value);
                    } else if (i4 == 1) {
                        List list = (List) linkedList2.getFirst();
                        Map mapCreateObjectContainer = createObjectContainer(containerFactory);
                        list.add(mapCreateObjectContainer);
                        this.status = 2;
                        linkedList.addFirst(new Integer(2));
                        linkedList2.addFirst(mapCreateObjectContainer);
                    } else if (i4 == 3) {
                        List list2 = (List) linkedList2.getFirst();
                        List listCreateArrayContainer = createArrayContainer(containerFactory);
                        list2.add(listCreateArrayContainer);
                        this.status = 3;
                        linkedList.addFirst(new Integer(3));
                        linkedList2.addFirst(listCreateArrayContainer);
                    } else if (i4 != 4) {
                        if (i4 != 5) {
                            this.status = -1;
                        }
                    } else if (linkedList2.size() > 1) {
                        linkedList.removeFirst();
                        linkedList2.removeFirst();
                        this.status = peekStatus(linkedList);
                    } else {
                        this.status = 1;
                    }
                } else if (i == 4) {
                    int i5 = this.token.type;
                    if (i5 == 0) {
                        linkedList.removeFirst();
                        ((Map) linkedList2.getFirst()).put((String) linkedList2.removeFirst(), this.token.value);
                        this.status = peekStatus(linkedList);
                    } else if (i5 == 1) {
                        linkedList.removeFirst();
                        String str = (String) linkedList2.removeFirst();
                        Map map = (Map) linkedList2.getFirst();
                        Map mapCreateObjectContainer2 = createObjectContainer(containerFactory);
                        map.put(str, mapCreateObjectContainer2);
                        this.status = 2;
                        linkedList.addFirst(new Integer(2));
                        linkedList2.addFirst(mapCreateObjectContainer2);
                    } else if (i5 == 3) {
                        linkedList.removeFirst();
                        String str2 = (String) linkedList2.removeFirst();
                        Map map2 = (Map) linkedList2.getFirst();
                        List listCreateArrayContainer2 = createArrayContainer(containerFactory);
                        map2.put(str2, listCreateArrayContainer2);
                        this.status = 3;
                        linkedList.addFirst(new Integer(3));
                        linkedList2.addFirst(listCreateArrayContainer2);
                    } else if (i5 != 6) {
                        this.status = -1;
                    }
                }
            }
            if (this.status == -1) {
                throw new ParseException(getPosition(), 1, this.token);
            }
        } while (this.token.type != -1);
        throw new ParseException(getPosition(), 1, this.token);
    }

    private void nextToken() throws ParseException, NumberFormatException, IOException {
        Yytoken yytokenYylex = this.lexer.yylex();
        this.token = yytokenYylex;
        if (yytokenYylex == null) {
            this.token = new Yytoken(-1, null);
        }
    }

    private Map createObjectContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONObject();
        }
        Map mapCreateObjectContainer = containerFactory.createObjectContainer();
        return mapCreateObjectContainer == null ? new JSONObject() : mapCreateObjectContainer;
    }

    private List createArrayContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONArray();
        }
        List listCreatArrayContainer = containerFactory.creatArrayContainer();
        return listCreatArrayContainer == null ? new JSONArray() : listCreatArrayContainer;
    }
}
