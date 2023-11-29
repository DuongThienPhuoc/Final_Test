package com.example.jweb_final_test.controller;

import com.example.jweb_final_test.dao.AccountDAO;
import com.example.jweb_final_test.dao.AccountDAOImpl;
import com.example.jweb_final_test.entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = {"/"})
public class LoginController extends HttpServlet {
    AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        if (accountDAO.login(userName, password)) {
            Account account = accountDAO.getAccount(userName);
            List<Account> accountList = accountDAO.getAccountToTransfer(userName);
            String username = account.getAccount();
            Long balance = account.getBalance();
            req.setAttribute("accountList",accountList);
            req.setAttribute("username", username);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher("banking/banking.jsp").forward(req, resp);
        } else {
            String error = "Wrong username or password";
            req.setAttribute("err", error);
            req.getRequestDispatcher("login/login.jsp").forward(req, resp);
        }
    }
}
