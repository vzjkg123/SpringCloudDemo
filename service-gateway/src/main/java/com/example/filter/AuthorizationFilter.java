package com.example.filter;


import com.example.common.constans.SecureConsts;
import com.example.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import property.JwtProperties;
import property.SecureProperties;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;


@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorizationFilter implements GlobalFilter, Ordered {
    private final SecureProperties secureProperties;
    private final JwtProperties jwtProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (!SecureConsts.SECURE_JWT.equals(secureProperties.getType()) || path.contains("/service/user/login")) {
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst("token");
        if (StringUtils.isBlank(token)) {
            log.error("Authentic failed");
            throw new RuntimeException("Illegal request");
        }

        Claims claims = JwtUtils.decodeToken(jwtProperties.getSecretKey(), token);
        if (Objects.isNull(claims)) {
            log.error("Authentic failed");
            throw new RuntimeException("Illegal request");
        }

        HashMap<String, String> header = new HashMap<>();
        header.put("id", claims.get("id", String.class));


        return this.chainFilterAndSetHeaders(chain, exchange, header);
    }

    private Mono<Void> chainFilterAndSetHeaders(GatewayFilterChain chain,
                                                ServerWebExchange exchange,
                                                Map<String, String> headerMap) {
        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpHeader.set(entry.getKey(), entry.getValue());
            }
        };
        ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders).build();
        exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
