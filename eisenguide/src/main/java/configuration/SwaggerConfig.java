package configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
		
		@Bean
		OpenAPI springEisenguideOpenAPI() {
			return new OpenAPI()
					.info(new Info()
							.title("Eisenguide")
							.description("Projeto Eisenguide - Fatec")
							.version("v3.0.1")
							.license(new License()
									.name("Fatec Carapicuiba")
									.url("https://www.fateccarapicuiba.edu.br/"))
							.contact(new Contact()
									.name("Yngrid Padilha")
									.url("https://github.com/yngridp")
									.email("yngrid_padilha@hotmail.com")))
					.externalDocs(new ExternalDocumentation()
							.description("Github")
							.url("https://github.com/yngridp"));
		}							
								
			@Bean
			OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
				
				return openApi -> {
					openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
						
						ApiResponses apiResponses = operation.getResponses();
						
						apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
						apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
						apiResponses.addApiResponse("204", createApiResponse("Objeto Exclu�do!"));
						apiResponses.addApiResponse("400", createApiResponse("Erro na Requisi��o!"));
						apiResponses.addApiResponse("401", createApiResponse("Acesso N�o Autorizado!"));
						apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
						apiResponses.addApiResponse("404", createApiResponse("Objeto N�o Encontrado!"));
						apiResponses.addApiResponse("500", createApiResponse("Erro na Aplica��o!"));
						
					}));
				};
	}

			private ApiResponse createApiResponse(String message) {
				
				return new ApiResponse().description(message);
			}
		}

