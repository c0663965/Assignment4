/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package servlet;

import model.Account;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */

/* Written by Kihoon, Lee (c0663965) */

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    
    private Account myAccount = new Account(1000);
   
    @Override
    protected void doPost(HttpServletRequest req ,HttpServletResponse res)
    { 
        String withdraw=req.getParameter("withdraw");
        String deposit=req.getParameter("deposit");
        String close=req.getParameter("close");

        if(withdraw!=null)
            myAccount.withdraw(Double.parseDouble(withdraw));

        if(deposit!=null)
            myAccount.deposit(Double.parseDouble(deposit));

        if(close!=null && Boolean.parseBoolean(req.getParameter("close")))
            myAccount.closeAccount();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        res.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate");
        res.setHeader("Pragma","no-cache");
        res.setDateHeader("Expires",0);
        
        try (PrintWriter out = res.getWriter()) 
        {
            out.println(myAccount.getBalance());
            out.close();

        } catch (IOException ex) {
            System.err.println("Something Went Wrong: " + ex.getMessage());
        }
    }
}