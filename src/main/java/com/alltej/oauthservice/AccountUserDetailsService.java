package com.alltej.oauthservice;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountUserDetailsService implements UserDetailsService{

    private final AccountRepository accountRepository;

    public AccountUserDetailsService( AccountRepository accountRepository ) {
        this.accountRepository = accountRepository;
    }

    @Override public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername( username );
        return byUsername
                .map( account -> new User( account.getUsername(),
                        account.getPassword(), account.getActive(), account.getActive(), account.getActive(), account.getActive(),
                        AuthorityUtils.createAuthorityList( "ROLE_ADMIN", "ROLE_USER" ) ) )
                .orElseThrow( () -> new UsernameNotFoundException( "couldn't find the username " + username ) )
                ;
    }
}
