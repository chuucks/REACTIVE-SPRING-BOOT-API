package com.codesolt.springbootreactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codesolt.springbootreactive.controller.BitMxHandler;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
	
	@Bean
	public BitMxHandler getBitMxHandler() {
		return new BitMxHandler();
	}
	
    @Bean
    public RouterFunction<ServerResponse> routeCoinsRequests(BitMxHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/bitmx/handler/coins"), handler::getCoins)
        		.andRoute(RequestPredicates.GET("/bitmx/handler/tickers"), handler::getTickers);
    }
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }	
}
