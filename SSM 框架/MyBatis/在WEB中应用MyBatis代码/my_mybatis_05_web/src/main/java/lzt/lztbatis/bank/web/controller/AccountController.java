package lzt.lztbatis.bank.web.controller;

import lzt.lztbatis.bank.exception.AppException;
import lzt.lztbatis.bank.exception.MoneyNotEnoughException;
import lzt.lztbatis.bank.service.AccountService;
import lzt.lztbatis.bank.service.impl.AccountServiceImpl;

// 注意：Tomcat 11 环境下，必须使用 jakarta 命名空间
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 账户控制器
 */
@WebServlet("/transfer")
public class AccountController extends HttpServlet {

    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 设置响应流的内容类型和编码，防止页面输出中文乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 2. 获取前端提交的账户信息
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");

        // 修正：将 Integer.parseInt 改为 Double.parseDouble，以支持转账金额包含小数
        double money = Double.parseDouble(request.getParameter("money"));

        // 3. 调用业务方法完成转账
        try {
            accountService.transfer(fromActno, toActno, money);
            out.print("<h1>转账成功！！！</h1>");
        } catch (MoneyNotEnoughException e) {
            out.print("<h1>转账失败：" + e.getMessage() + "</h1>");
        } catch (AppException e) {
            out.print("<h1>转账失败：" + e.getMessage() + "</h1>");
        } catch (Exception e) {
            // 兜底异常捕获：如果发生其他未知异常（如数据库连接失败、空指针等），方便页面报错排查
            out.print("<h1>系统繁忙，转账失败：发生未知错误。</h1>");
            e.printStackTrace();
        }
    }
}