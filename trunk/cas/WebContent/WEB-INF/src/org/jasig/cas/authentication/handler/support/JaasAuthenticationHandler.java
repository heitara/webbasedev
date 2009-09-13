/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */
package org.jasig.cas.authentication.handler.support;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.inspektr.common.ioc.annotation.NotNull;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.util.Assert;

/**
 * JAAS Authentication Handler for CAAS. This is a simple bridge from CAS'
 * authentication to JAAS.
 * <p>
 * Using the JAAS Authentication Handler requires you to configure the
 * appropriate JAAS modules. You can specify the location of a jass.conf file
 * using the VM parameter
 * -Djava.security.auth.login.config=$PATH_TO_JAAS_CONF/jaas.conf.
 * <p>
 * This example jaas.conf would try Kerberos based authentication, then try LDAP
 * authentication CAS { com.sun.security.auth.module.Krb5LoginModule sufficient
 * client=TRUE debug=FALSE useTicketCache=FALSE;
 * edu.uconn.netid.jaas.LDAPLoginModule sufficient<br />
 * java.naming.provider.url="ldap://ldapserver.my.edu:389/dc=my,dc=edu"<br />
 * java.naming.security.principal="uid=jaasauth,dc=my,dc=edu"<br />
 * java.naming.security.credentials="password" Attribute="uid" startTLS="true"; };<br />
 * 
 * @author <a href="mailto:dotmatt@uconn.edu">Matthew J. Smith</a>
 * @version $Revision: 43670 $ $Date: 2008-05-08 13:56:48 -0400 (Thu, 08 May 2008) $
 * @since 3.0.5
 * @see javax.security.auth.callback.CallbackHandler
 * @see javax.security.auth.callback.PasswordCallback
 * @see javax.security.auth.callback.NameCallback
 */
public class JaasAuthenticationHandler extends
    AbstractUsernamePasswordAuthenticationHandler {

    /** If no realm is specified, we default to CAS. */
    private static final String DEFAULT_REALM = "CAS";

    /** The realm that contains the login module information. */
    @NotNull
    private String realm = DEFAULT_REALM;
    
    public JaasAuthenticationHandler() {
        Assert
        .notNull(
            Configuration.getConfiguration(),
            "Static Configuration cannot be null. Did you remember to specify \"java.security.auth.login.config\"?");
    }

    protected final boolean authenticateUsernamePasswordInternal(
        final UsernamePasswordCredentials credentials)
        throws AuthenticationException {

        try {
            if (log.isDebugEnabled()) {
                log.debug("Attempting authentication for: "
                    + credentials.getUsername());
            }
            final LoginContext lc = new LoginContext(this.realm,
                new UsernamePasswordCallbackHandler(credentials.getUsername(),
                    credentials.getPassword()));

            lc.login();
            lc.logout();
        } catch (final LoginException fle) {
            if (log.isDebugEnabled()) {
                log.debug("Authentication failed for: "
                    + credentials.getUsername());
            }
            return false;
        }

        if (log.isDebugEnabled()) {
            log.debug("Authentication succeeded for: "
                + credentials.getUsername());
        }
        return true;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    /**
     * A simple JAAS CallbackHandler which accepts a Name String and Password
     * String in the constructor. Only NameCallbacks and PasswordCallbacks are
     * accepted in the callback array. This code based loosely on example given
     * in Sun's javadoc for CallbackHandler interface.
     */
    protected static final class UsernamePasswordCallbackHandler implements CallbackHandler {

        /** The username of the principal we are trying to authenticate. */
        private final String userName;

        /** The password of the principal we are trying to authenticate. */
        private final String password;

        /**
         * Constuctor accepts name and password to be used for authentication.
         * 
         * @param userName name to be used for authentication
         * @param password Password to be used for authentication
         */
        protected UsernamePasswordCallbackHandler(final String userName,
            final String password) {
            this.userName = userName;
            this.password = password;

        }

        public void handle(final Callback[] callbacks)
            throws UnsupportedCallbackException {
            for (int i = 0; i < callbacks.length; i++) {
                final Callback callback = callbacks[i];

                if (callback.getClass().equals(NameCallback.class)) {
                    ((NameCallback) callback).setName(this.userName);
                } else if (callback.getClass().equals(PasswordCallback.class)) {
                    ((PasswordCallback) callback).setPassword(this.password
                        .toCharArray());
                } else {
                    throw new UnsupportedCallbackException(callback,
                        "Unrecognized Callback");
                }
            }
        }
    }
}
