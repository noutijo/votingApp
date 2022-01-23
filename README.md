# votingApp
`votingApp` is a desktop application for automatic, real-time management.

# configuration & database
The project needs to be connected to a database to work, so we used MYSQL.
You must first import the `.sql` file in the `/bd` folder into your database server.



```java
public class GetConnection {

    public static Connection getConnnection() throws SQLException, ClassNotFoundException {

        Connection myConne = null;
        Class.forName("com.mysql.jdbc.Driver");
        myConne = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ens", "root", "");
        System.out.println("Connecté !");
  
        return myConne;
    }
}
 ```

# libs

# login

![](/imgs/login.png)

# administrator

# elector


