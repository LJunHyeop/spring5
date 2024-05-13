package com.green.feedextra.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "그린그램",
                description = "Greengram with React ",
                version = "v0.0.1"

        )
)

public class SwaggerConfiguration {
}
