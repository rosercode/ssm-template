package cool.wangshuo.st.component.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import cool.wangshuo.st.annotation.NeedLogin;
import cool.wangshuo.st.model.response.GlobalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 自定义的拦截器： <br
 */

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {


    public AuthInterceptor() {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 拦截后端接口
        if (handler instanceof HandlerMethod) {
            // 获取注解，用于判断注解是否存在
            NeedLogin auth = ((HandlerMethod) handler).getMethod().getAnnotation(NeedLogin.class);
            if (auth != null) {
                HttpSession session = request.getSession(true);
                if (session.getAttribute("isLogin") == null || !(boolean) session.getAttribute("isLogin")) {
                    authFailOutput(response, "登录信息不存在，请重新登录");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    /**
     * json输出
     *
     * @param response
     * @throws IOException
     */
    private void authFailOutput(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(GlobalResult.error(500, msg)));
        out.flush();
    }
}


