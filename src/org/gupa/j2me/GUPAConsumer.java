package org.gupa.j2me;

import java.io.IOException;
import java.util.Hashtable;
import net.oauth.j2me.BadTokenStateException;
import net.oauth.j2me.Consumer;
import net.oauth.j2me.OAuthServiceProviderException;
import net.oauth.j2me.token.AccessToken;
import net.oauth.j2me.token.RequestToken;
/**
 *
 * @author Mete Ercan Pakdil
 * @version 1.0
 * http://www.mtrcn.com
 *
 */
public class GUPAConsumer {
    public static final String BASE_DOMAIN="http://www.geomatikygulamalar.com/v2";
    public static final String API_DOMAIN="http://gupa.geomatikuygulamalar.com/v1";

    
    private Consumer oauthConsumer;
    private RequestToken requestToken;
    private AccessToken accessToken;
    
    /** Creates a new instance of GUPA */
    public GUPAConsumer(String key, String secret) {
        oauthConsumer = new Consumer(key, secret);
        oauthConsumer.setSignatureMethod("HMAC-SHA1");
    }

    public String buildAuthorizeURL(String requestToken){
        return API_DOMAIN+"/oauth/authorize?oauth_token="+requestToken;
    }
    
    public RequestToken getNewRequestToken() throws OAuthServiceProviderException {
        requestToken = oauthConsumer.getRequestToken(API_DOMAIN + "/oauth/request_token",null);
        return requestToken;
    }
    
    public AccessToken getNewAccessToken() throws OAuthServiceProviderException, BadTokenStateException {
        if (requestToken==null) {
            throw new BadTokenStateException("No request token set");
        }
        accessToken = oauthConsumer.getAccessToken(API_DOMAIN + "/oauth/access_token",requestToken,null);
        requestToken = null;
        return accessToken;
    }
    
    public String api(String method, Hashtable params, AccessToken accessToken) throws OAuthServiceProviderException, BadTokenStateException, IOException {
        return oauthConsumer.accessProtectedResource(API_DOMAIN+method, accessToken, params, "POST");
    }

    // accessors and stuff
    public RequestToken getRequestToken() {
        return requestToken;
    }
    
    public void setAccessToken(AccessToken accessToken) {
        this.accessToken=accessToken;
    }

    public void setRequestToken(RequestToken requestToken){
        this.requestToken = requestToken;
    }
    
    
}
