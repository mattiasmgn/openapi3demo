package se.demoserver;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClassA.class, name = "ClassA"),
        @JsonSubTypes.Type(value = ClassB.class, name = "ClassB")
})
public interface InterfaceC {
    public String getCurrentTime();
    public String getType();
}
