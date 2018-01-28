package com.alltej.oauthservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServiceConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    public AuthServiceConfiguration( AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    @Override public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
        //provide implementation of ClientDetailsService
//        clients.withClientDetails( new ClientDetailsService() {
//            @Override public ClientDetails loadClientByClientId( String s ) throws ClientRegistrationException {
//                return null;
//            }
//        } );
        //or use inMemory(for demo)
        clients.inMemory().withClient( "html5client" ).secret( "client.pswd" ).authorizedGrantTypes( "password" )
                .scopes( "openId" );
    }

    @Override public void configure( AuthorizationServerEndpointsConfigurer endpoints ) throws Exception {
        endpoints.authenticationManager( this.authenticationManager );
    }
}
