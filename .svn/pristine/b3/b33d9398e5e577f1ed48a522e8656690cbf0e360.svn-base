package top.rzclk.modules.sys.oauth2;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token (表单拦截器)
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017-08-08 18:09:27
 *
 */
public class OAuth2Token implements AuthenticationToken {
	private static final long serialVersionUID = -5946219696893253560L;
	
	private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
