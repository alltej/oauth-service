package com.alltej.oauthservice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AccountTest {
    @Test public void create_account() {
        List<Account> accountList = new ArrayList<>();
        Stream.of( "john,welcome", "pete,welcome", "rafa,welcome" ).map( tpl -> tpl.split( "," ) )
                .forEach( tpl -> accountList.add(new Account( tpl[0], tpl[1], true )   ));
        assertEquals( 3, accountList.size() );
        assertEquals( "john", accountList.get( 0 ).getUsername() );
    }

}
