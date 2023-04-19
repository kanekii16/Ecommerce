package com.example.e_commerce;

import java.sql.ResultSet;

public class login {


    public customer customerLogin(String username,String password){


        String login_query = "SELECT * FROM customer WHERE email ='"+username+"' AND password = '"+password+"'";

        databaseConnection conn = new databaseConnection();

        ResultSet rs = conn.getQueryTable(login_query);

        try {
            if(rs.next()){
                return new customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("mobile"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        login login = new login();
        customer customer = login.customerLogin("Sai@gmail.com","abc");
        System.out.println("Welcome : "+customer.getName());


    }
}
