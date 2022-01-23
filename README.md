# votingApp
`votingApp` is a desktop application for automatic, real-time management.

# libs

For the functioning of the application, it requires that some libraries are integrated in the project. So, you have to integrate the libraries that are in the `/libs` folder in your project.
Note that this project is designed with `JDK 1.8`.

# configuration & database
The project needs to be connected to a database to work, so we used MYSQL.
You must first import the `.sql` file in the `/bd` folder into your database server.

Then you will modify `YOUR PASSWORD` in the file `GetConnection.java` at the root `src/cm/ens/bd`.

```java
public class GetConnection {

    public static Connection getConnnection() throws SQLException, ClassNotFoundException {

        Connection myConne = null;
        Class.forName("com.mysql.jdbc.Driver");
        myConne = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ens", "root", "YOUR PASSORD");
        System.out.println("Connecté !");
  
        return myConne;
    }
}
 ```

# login

![](/imgs/login.png)

# administrator

# elector


