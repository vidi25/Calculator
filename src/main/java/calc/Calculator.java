package calc;


import java.sql.*;
import java.util.Scanner;

import static java.lang.Math.*;
import static sun.util.calendar.CalendarUtils.mod;


public class Calculator {

    Double num1,num2;
    Double res;
    String opr;
    public void input()
    {
        System.out.println("Enter two numbers:");
        Scanner in =new Scanner(System.in);
        num1=in.nextDouble();
        num2=in.nextDouble();
    }
    public double add()
    {
        opr="add";
        res=num1+num2;
        return res;
    }

    public double sub()
    {
        opr="subtract";
        res= num1-num2;
        return res;
    }

    public double mul()
    {
        opr="multiply";
        res=num1*num2;
        return res;
    }

    public double div()
    {
        opr="division";
        res=num1/num2;
        return res;
    }

    public double power()
    {
        opr="power";
        res=pow(num1,num2);
        return res;
    }

    public double absolute(double num1)
    {
        opr="absolute";
        res=abs(num1);
        return res;
    }

    public int modulus()
    {
        opr="modulus";
        int res=mod(num1.intValue(),num2.intValue());
        return res;
    }

    public double findmax()
    {
        opr="maximum";
        res=max(num1,num2);
        return res;
    }

    public double findmin()
    {
        opr="minimum";
        res=min(num1,num2);
        return res;
    }

    public Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asgnmnt","root","root");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }

    public void write() throws SQLException {
        Connection con=getConnection();
        java.util.Date date=new java.util.Date();
        java.sql.Timestamp creation_time =new java.sql.Timestamp(date.getTime());
        PreparedStatement ps=con.prepareStatement("Insert into calculator(id,timestamp,left_operand,right_operand,operator,result) values(null,?,?,?,?,?)");
        ps.setTimestamp(1,creation_time);
        ps.setDouble(2,num1);
        ps.setDouble(3,num2);
        ps.setString(4,opr);
        ps.setDouble(5,res);
        ps.executeUpdate();
        con.close();
    }

    public void read() throws SQLException{
        Connection con=getConnection();
        Statement stmnt=con.createStatement();
        ResultSet rs=stmnt.executeQuery("select * from calculator");
        while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getDouble(4)+" "+rs.getString(5)+" "+rs.getDouble(6));
        con.close();
    }

    public void readAll(String oper) throws SQLException
    {
        Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("Select * from calculator where operator=?");
        ps.setString(1,oper);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getDouble(4)+" "+rs.getString(5)+" "+rs.getDouble(6));
        con.close();
    }


}
