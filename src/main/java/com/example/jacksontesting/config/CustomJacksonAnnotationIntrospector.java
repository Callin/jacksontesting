package com.example.jacksontesting.config;

import com.example.jacksontesting.annotation.JsonPropertyEs;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.lang.annotation.Annotation;

public class CustomJacksonAnnotationIntrospector extends JacksonAnnotationIntrospector {

    @SuppressWarnings("unchecked")
    private final static Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_SER = (Class<? extends Annotation>[])
            new Class<?>[]{
                    JsonSerialize.class,
                    JsonView.class,
                    JsonFormat.class,
                    JsonTypeInfo.class,
                    JsonRawValue.class,
                    JsonUnwrapped.class,
                    JsonBackReference.class,
                    JsonManagedReference.class
            };

    @SuppressWarnings("unchecked")
    private final static Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_DESER = (Class<? extends Annotation>[])
            new Class<?>[]{
                    JsonDeserialize.class,
                    JsonView.class,
                    JsonFormat.class,
                    JsonTypeInfo.class,
                    JsonUnwrapped.class,
                    JsonBackReference.class,
                    JsonManagedReference.class,
                    JsonMerge.class // since 2.9
            };

    @Override
    public PropertyName findNameForDeserialization(Annotated a) {

        JsonPropertyEs pannEs = _findAnnotation(a, JsonPropertyEs.class);
        if (pannEs != null) {
            return PropertyName.construct(pannEs.value());
        }

        // @JsonSetter has precedence over @JsonProperty, being more specific
        // @JsonDeserialize implies that there is a property, but no name
        JsonSetter js = _findAnnotation(a, JsonSetter.class);
        if (js != null) {
            return PropertyName.construct(js.value());
        }
        JsonProperty pann = _findAnnotation(a, JsonProperty.class);
        if (pann != null) {
            return PropertyName.construct(pann.value());
        }
        if (_hasOneOf(a, ANNOTATIONS_TO_INFER_DESER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    @Override
    public PropertyName findNameForSerialization(Annotated a) {
        JsonPropertyEs pannEs = _findAnnotation(a, JsonPropertyEs.class);
        if (pannEs != null) {
            return PropertyName.construct(pannEs.value());
        }

        JsonGetter jg = _findAnnotation(a, JsonGetter.class);
        if (jg != null) {
            return PropertyName.construct(jg.value());
        }
        JsonProperty pann = _findAnnotation(a, JsonProperty.class);
        if (pann != null) {
            return PropertyName.construct(pann.value());
        }
        if (_hasOneOf(a, ANNOTATIONS_TO_INFER_SER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

}
