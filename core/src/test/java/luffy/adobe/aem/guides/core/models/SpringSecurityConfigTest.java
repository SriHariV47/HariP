package luffy.adobe.aem.guides.core.models;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;

@ExtendWith(MockitoExtension.class)
public class SpringSecurityConfigTest {

    @Mock
    private AuthenticationEntryPoint authEntryPoint;

    @Mock
    private AuthenticationManagerBuilder auth;

    @InjectMocks
    private SpringSecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
        securityConfig = new SpringSecurityConfig();
        // Use reflection to set the private field authEntryPoint
        try {
            java.lang.reflect.Field field = SpringSecurityConfig.class.getDeclaredField("authEntryPoint");
            field.setAccessible(true);
            field.set(securityConfig, authEntryPoint);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFilterChain() throws Exception {
        HttpSecurity httpSecurity = MockMvcBuilders.standaloneSetup(new Object()).apply((MockMvcConfigurer) new SpringSecurityConfig()).build().getDispatcherServlet().getWebApplicationContext().getBean(HttpSecurity.class);

        securityConfig.filterChain(httpSecurity);

        verify(httpSecurity).cors();
        verify(httpSecurity).csrf().disable();
        verify(httpSecurity).exceptionHandling().authenticationEntryPoint(authEntryPoint);
        verify(httpSecurity).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        verify(httpSecurity).authorizeRequests().anyRequest().authenticated();
        verify(httpSecurity).httpBasic();
    }

    @Test
    void testConfigureGlobal() throws Exception {
        securityConfig.configureGlobal(auth);
        verify(auth).inMemoryAuthentication().withUser("dell-coveo").password("$2a$10$MBH8srBnCyWevltRDl06/eAMyV2JunWJvEeD9XidC5jyjkRYBiejq").roles("USER");
    }

    @Test
    void testEncoder() {
        BCryptPasswordEncoder encoder = securityConfig.encoder();
        assert(encoder != null);
    }
}
