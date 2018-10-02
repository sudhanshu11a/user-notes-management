/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration for documentation, visualize and interact with the
 * API’s resources without having any of the implementation logic in place. It’s
 * automatically generated from your OpenAPI (formerly known as Swagger)
 * Specification, with the visual documentation making it easy for back end
 * implementation and client side consumption.
 * 
 * @author sudhanshusharma
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors
						.basePackage("org.gotprint.assignment.usernotesmanagement.rest.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Sudhanshu Sharma", "", "sudhanshu11a@gmail.com");
		return new ApiInfoBuilder().title("User Notes Mangement Application")
				.description("This is a assignment application for the GotPoint").version("v1").contact(contact)
				.build();
	}
}
