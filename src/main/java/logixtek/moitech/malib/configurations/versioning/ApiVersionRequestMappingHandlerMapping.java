package logixtek.moitech.malib.configurations.versioning;

import jakarta.validation.constraints.NotNull;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestMappingInfo getMappingForMethod(@NotNull Method method, @NotNull Class<?> handlerType) {

        RequestMappingInfo mappingInfo = this.createRequestMappingInfo(method);

        if (mappingInfo == null) return null;

        RequestMappingInfo typeInfo = this.createRequestMappingInfo(handlerType);
        if (typeInfo != null) {
            mappingInfo = typeInfo.combine(mappingInfo);
        }

        String[] paths = this.getPaths(method, handlerType);
        if (paths != null) {
            mappingInfo = RequestMappingInfo.paths(paths).options(super.getBuilderConfiguration()).build().combine(mappingInfo);
        }

        return mappingInfo;
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {

        RequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(element, RequestMapping.class);

        return requestMapping != null
               ? createRequestMappingInfo(requestMapping, null)
               : null;
    }

    private String[] getPaths(@NotNull Method method, @NotNull Class<?> handlerType) {

        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);

        if (apiVersion == null) {

            apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);

            if (apiVersion == null) {
                // Handle here if versioning is required
                return null;
            }
        }

        int len = apiVersion.value().length;
        if (len == 0) {
            throw new IllegalArgumentException(String.format("List versions must not be empty. At %s, %s", method, handlerType));
        }

        String[] paths = new String[len];

        int index = 0;
        for (int version : apiVersion.value()) {
            if (version < 0) {
                throw new IllegalArgumentException(String.format("Invalid number of version. At %s, %s", method, handlerType));
            }

            paths[index++] = "v" + version;
        }

        return paths;
    }
}