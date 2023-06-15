//package com.minsunill.closedvotingsite.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFilter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.annotation.Resource;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Resource
//    private AuthenticationEntryPointImpl unauthorizedHandler;
//
//    @Resource
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Resource
//    private AuthenticationProviderImpl authenticationProvider;
//
//    @Bean
//    public AuthenticationFilter authenticationFilter() {
//        return new AuthenticationFilter();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider)
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(
//                "/v2/api-docs",
//                "/configuration/ui",
//                "/swagger-resources/**",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                "/",
//                "/csrf",
//                "/error"
//        );
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().disable()      // rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
//                .cors().and().csrf().disable()      // rest api이므로 csrf 보안이 필요없으므로 disable처리.
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()       // jwt token으로 인증할것이므로 세션필요없으므로 생성안함.
//                .authorizeRequests()
//                .antMatchers("/auth/signIn", "/auth/signUp", "/analysis/getBioAge", "/analysis/getBioageGraphDatas").permitAll()
//                .antMatchers("/test/**").permitAll()
//                .antMatchers("/panorama/**").permitAll()
//                .antMatchers("/commonCode/role/menu").permitAll()
//                .anyRequest().authenticated().and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//}
