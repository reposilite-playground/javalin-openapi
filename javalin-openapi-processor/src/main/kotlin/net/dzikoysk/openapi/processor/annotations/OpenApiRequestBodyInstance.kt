package net.dzikoysk.openapi.processor.annotations

import io.javalin.plugin.openapi.annotations.OpenApiRequestBody
import net.dzikoysk.openapi.processor.processing.AnnotationMirrorMapper
import javax.lang.model.element.AnnotationMirror

class OpenApiRequestBodyInstance(mirror: AnnotationMirror) : AnnotationMirrorMapper(mirror) {

    fun content(): List<OpenApiContentInstance> =
        getArray("content", AnnotationMirror::class.java) { OpenApiContentInstance(it) }

    fun description(): String =
        getString("description")

    fun required(): Boolean =
        getBoolean("required")

    fun annotationType(): Class<out Annotation> =
        OpenApiRequestBody::class.java

}