package com.cw.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈小哥cw
 * @date 2021/1/15 13:49
 *
 * 自定义拦截器需要实现HandleInterceptor接口
 *
 * 1.当拦截器中出现对原始处理器的拦截，后面的拦截器均中止运行
 * 2.当拦截器运行中断，仅运行配置在前面的拦截器的afterCompletion操作
 *
 * 责任链模式
 *  责任链模式是一种行为模式
 *  特征：
 * 沿着一条预先设定的任务链顺序执行，每个节点具有独立的工作任务
 *  优势：
 * 独立性：只关注当前节点的任务，对其他任务直接放行到下一节点
 * 隔离性：具备链式传递特征，无需知晓整体链路结构，只需等待请求到达后进行处理即可
 * 灵活性：可以任意修改链路结构动态新增或删减整体链路责任
 * 解耦：将动态任务与原始任务解耦
 *  弊端：
 * 链路过长时，处理效率低下
 * 可能存在节点上的循环引用现象，造成死循环，导致系统崩溃
 */
public class MyInterceptor implements HandlerInterceptor {

    //三个方法的运行顺序为    preHandle -> postHandle -> afterCompletion
    //如果preHandle返回值为false，三个方法仅运行preHandle

    //处理器运行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("前置运行----a1");
        //返回值为false将拦截原始处理器的运行
        //如果配置多拦截器，返回值为false将终止当前拦截器后面配置的拦截器的运行
        return true;
    }

    //处理器运行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后置运行----b1");
    }

    //所有拦截器的后置执行全部结束后，执行该操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("完成运行----c1");
    }
}
