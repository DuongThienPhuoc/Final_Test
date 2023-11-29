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

@WebServlet(name = "transfer", urlPatterns = {"/transfer"})
public class TransferController extends HttpServlet {
    private final AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String amount = req.getParameter("amount");
        Long amountL = Long.parseLong(amount);
        String account = req.getParameter("account");
        String note = req.getParameter("note");
        String username = req.getParameter("username");
        Account daoAccount = accountDAO.getAccount(username);
        Long balace = daoAccount.getBalance();
        if (amountL > balace) {
            String err = "*Amount must be less than balane";
            List<Account> accountList = accountDAO.getAccountToTransfer(username);
            String usernames = daoAccount.getAccount();
            Long balance = daoAccount.getBalance();
            req.setAttribute("err", err);
            req.setAttribute("accountList", accountList);
            req.setAttribute("username", usernames);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher("banking/banking.jsp").forward(req, resp);
        }else {

        }
    }
}
